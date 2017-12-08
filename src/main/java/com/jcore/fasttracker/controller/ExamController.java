package com.jcore.fasttracker.controller;

import java.io.IOException;
import java.util.List;

import com.jcore.fasttracker.dao.ExamDao;
import com.jcore.fasttracker.model.Exam;
import com.jcore.fasttracker.model.User;
import com.jcore.fasttracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ExamController extends BaseController {

	private static final String NOTFOUND = "Could not find exam with UUID ";

	@Autowired
	private UserService userService;

	@Autowired
	private ExamDao examDao;

	/**
	 * Display the fasttracks page
	 *
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/exams", method = RequestMethod.GET)
	public String getExams(Model model) throws IOException {

		// Get the uploads of the user
		List<Exam> exams = examDao.findByUserId(1); // FIXME: Logged in userId
		model.addAttribute("exams", exams);

		return "/exams";
	}

	/**
	 * Display a single fasttrack
	 *
	 * @param trackUuid
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/exams/{examUuid}", method = RequestMethod.GET)
	public String getExam(@PathVariable String examUuid, Model model, RedirectAttributes redirectAttributes) {

		Exam exam = examDao.findByUuid(examUuid);
		if (exam == null) {
			redirectAttributes.addFlashAttribute("errors", new String[]{NOTFOUND + examUuid});
			return "/exams";
		}

		model.addAttribute("exam", exam);
		return "/exam";
	}

	/**
	 * Complete an exam and add it to the user's list of completed exams
	 * 
	 * @param examUuid
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/exams/{examUuid}/complete", method = RequestMethod.POST)
	public String completeExam(@PathVariable String examUuid, @RequestParam("score") int score, 
			Model model, RedirectAttributes redirectAttributes) {

		Exam exam = examDao.findByUuid(examUuid);
		if (exam == null) {
			redirectAttributes.addFlashAttribute("errors", new String[]{NOTFOUND + examUuid});
			return "/exams";
		}

		// Check if the score is higher than the required minimum
		if (exam.isRequiredPercentage(score)) {
			redirectAttributes.addFlashAttribute("errors", new String[]{"You didn't have the required score. " 
					+ "You had " + score + "% where " + exam.getRequiredPercentage() + "% is required to pass."});
			return "/exams";
		}

		// TODO: Use the logged in user
		User user = userService.findByUuid("SomeUuid");
		user.addExam(exam);
		userService.save(user);
		
		return "/exams";
	}

}
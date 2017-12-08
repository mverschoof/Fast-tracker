package com.jcore.fasttracker.controller;

import java.io.IOException;
import java.util.List;

import com.jcore.fasttracker.dao.ExerciseDao;
import com.jcore.fasttracker.model.Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ExerciseController extends BaseController {

	private static final String NOTFOUND = "Could not find exercise with UUID ";

	@Autowired
	private ExerciseDao exerciseDao;

	/**
	 * Display the fasttracks page
	 *
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value ="/exercises", method = RequestMethod.GET)
	public String getExams(Model model) throws IOException {

		// Get the uploads of the user
		List<Exercise> exercises = exerciseDao.findByUserId(1); // FIXME: Logged in userId
		model.addAttribute("exercise", exercises);

		return "/exercises";
	}

	/**
	 * Display a single fasttrack
	 *
	 * @param trackUuid
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/exercises/{exerciseUuid}", method = RequestMethod.GET)
	public String getExam(@PathVariable String exerciseUuid, Model model, RedirectAttributes redirectAttributes) {

		Exercise exercise = exerciseDao.findByUuid(exerciseUuid);
		if (exercise == null) {
			redirectAttributes.addFlashAttribute("errors", new String[]{NOTFOUND + exerciseUuid});
			return "/exercises";
		}

		model.addAttribute("exercise", exercise);
		return "/exercise";
	}

}
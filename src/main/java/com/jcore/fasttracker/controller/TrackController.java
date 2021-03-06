package com.jcore.fasttracker.controller;

import java.io.IOException;
import java.util.List;
import com.jcore.fasttracker.model.Track;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TrackController extends BaseController {

    /**
     * Get the index page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
    	// TODO: Get logged in user, select the corresponding track and display it like getTrack()
    	
        return "/index";
    }

    /**
     * Display the fast-tracks page
     *
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value ="/tracks", method = RequestMethod.GET)
    public String getTracks(Model model) throws IOException {

        // Get the uploads of the user
        List<Track> tracks = trackDao.findAll();
        model.addAttribute("tracks", tracks);

        return "/tracks";
    }

    /**
     * Display a single fast-track
     *
     * @param trackUuid
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/tracks/{trackUuid}", method = RequestMethod.GET)
    public String getTrack(@PathVariable String trackUuid, Model model, RedirectAttributes redirectAttributes) {

        Track track = findFasttrack(trackUuid);
        if (track == null) {
            redirectAttributes.addFlashAttribute("errors", new String[]{""});
            return "/tracks";
        }

        model.addAttribute("track", track);
        return "/track";
    }

}
package com.jcore.fasttracker.controller;

import com.jcore.fasttracker.dao.TrackDao;
import com.jcore.fasttracker.model.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected TrackDao trackDao;

    /**
     * Get a specific fasttrack by its uuid
     *
     * @param uuid
     * @return
     */
    protected Track findFasttrack(String uuid) {
        if (!validateUuid(uuid)) {
            return null;
        }

        Track track = this.findFasttrackByUuid(uuid);
        if (track == null) {
            log.error("The track (" + uuid + ") could not be found");
        }

        return track;
    }

    /**
     * Get a specific upload, if the user is allowed to view it
     *
     * @param uuid
     * @return
     */
    private Track findFasttrackByUuid(String uuid) {
        return trackDao.findByUuid(uuid);
    }

    /**
     * Validate the UUID
     *
     * @param uuid
     * @return <code>true</code> if it's a valid UUID, <code>false</code> otherwise
     */
    protected boolean validateUuid(String uuid) {
        if (uuid == null || uuid.trim().isEmpty()) {
            log.error("The given UUID is either null or empty");
            return false;
        }
        if (uuid.length() != 36) {
            log.error("The given UUID (" + uuid + ") is not 36 characters long");
            return false;
        }
        return true;
    }

}
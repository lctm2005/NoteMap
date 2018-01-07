package com.licong.notemap.web.controller;

import com.licong.notemap.service.EvernoteSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by lctm2005 on 2017/4/18.
 */
@RestController
public class EvernoteWebhookController {

    private static final String NOTEBOOK_CREATE = "notebook_create";
    private static final String NOTEBOOK_UPDATE = "notebook_update";
    private static final String NOTE_CREATE = "create";
    private static final String NOTE_UPDATE = "update";

    @Autowired
    private EvernoteSyncService evernoteSyncService;

    @RequestMapping(value = "/notify", method = RequestMethod.GET)
    public void notify(@RequestParam Long userId, @RequestParam UUID notebookGuid, @RequestParam String reason) {
        System.out.println(userId);
        System.out.println(notebookGuid);
        System.out.println(reason);
    }

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    public void sync() {
        evernoteSyncService.syncNoteBook(0L, UUID.fromString("dea6691f-cd37-40f9-abbd-b3785da21636"));
    }
}
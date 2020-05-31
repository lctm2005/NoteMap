package com.licong.notemap.web.controller;

import com.evernote.edam.type.Note;
import com.licong.notemap.repository.evernote.EvernoteRepository;
import com.licong.notemap.util.JsonUtils;
import com.licong.notemap.web.vo.note.NoteResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSOutput;

import java.util.UUID;

@Slf4j
@Controller
public class PageController {

    @Autowired
    private EvernoteRepository evernoteRepository;

    @RequestMapping("/")
    public ModelAndView graph() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("graph");
        return modelAndView;
    }


    @RequestMapping("/note/{note_id}")
    public ModelAndView edit(@PathVariable(value = "note_id") UUID noteId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("note");
        modelAndView.addObject("note_id", noteId);
        return modelAndView;
    }

    @RequestMapping("/note")
    public ModelAndView newNote() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("note");
        modelAndView.addObject("note", JsonUtils.toJson(new NoteResource()));
        return modelAndView;
    }

    @RequestMapping("/financial")
    public ModelAndView financial() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("financial");
        return modelAndView;
    }

}

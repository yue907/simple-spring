package com.test.entity;

import com.guge.spring.beans.annotation.Component;
import com.guge.spring.beans.annotation.Prop;


/**
 * Created by google on 17/4/16.
 */
@Component(value="note")
public class Note {
    @Prop(value = "2018")
    private int noteId;
    @Prop(value = "测试帖")
    private String title;
    @Prop(ref = "noteUser")
    private User user;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

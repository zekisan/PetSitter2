package com.zekisanmobile.petsitter2.api.body;

public class ReplyRateBody {

    private String app_id;

    private String sitter_comment;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getSitter_comment() {
        return sitter_comment;
    }

    public void setSitter_comment(String sitter_comment) {
        this.sitter_comment = sitter_comment;
    }
}

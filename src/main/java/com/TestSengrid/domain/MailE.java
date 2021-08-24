package com.TestSengrid.domain;

public class MailE {
    private String fromEmail;
    private String subject;
    private String content;
    private String emailTo;

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    @Override
    public String toString() {
        return "MailE{" +
                "fromEmail='" + fromEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", emailTo='" + emailTo + '\'' +
                '}';
    }
}

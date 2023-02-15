package by.it_academy.jd2.MJD29522.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "app.email")
public class EmailEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column(name = "message")
    private String message;
    @Column(name = "validateemail")
    private boolean validateEmail;
    @Column(name = "sendmessage")
    private boolean sendMessage;
    @Column(name = "lastsendtime")
    private long lastSendTime;
    @Column(name = "email")
    private String email;

    public EmailEntity() {
    }

    public EmailEntity(long id, String message, boolean validateEmail,
                       boolean sendMessage, long lastSendTime, String email) {
        this.id = id;
        this.message = message;
        this.validateEmail = validateEmail;
        this.sendMessage = sendMessage;
        this.lastSendTime = lastSendTime;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isValidateEmail() {
        return validateEmail;
    }

    public void setValidateEmail(boolean validateEmail) {
        this.validateEmail = validateEmail;
    }

    public boolean isSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(boolean sendMessage) {
        this.sendMessage = sendMessage;
    }

    public long getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(long lastSendTime) {
        this.lastSendTime = lastSendTime;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", validateEmail=" + validateEmail +
                ", sendMessage=" + sendMessage +
                ", lastSendTime=" + lastSendTime +
                ", email='" + email + '\'' +
                '}';
    }
}

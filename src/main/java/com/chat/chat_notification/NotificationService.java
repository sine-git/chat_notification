package com.chat.chat_notification;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.checkerframework.checker.units.qual.Acceleration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private  FirebaseMessaging firebaseMessaging;

  /*  @Autowired
    public  NotificationService(FirebaseMessaging firebaseMessaging){
        this.firebaseMessaging = firebaseMessaging;
    }*/

    public String sendNotification(String token, String title, String body) {
        Notification notification = Notification.builder().setTitle("Notification").setBody("Votre message").build();
        Message message =  Message.builder().setNotification(notification).setToken(token).build();
        try{
            return firebaseMessaging.send(message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  "Erreur lors de l'envoi";
        }
    }

}

package com.chat.chat_notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/sendNotification")
    String sednNotification(){
        return notificationService.sendNotification("c_Q8nAw9SS6HyXZy5hyo0l:APA91bFtOG_K9Tk9Ir4vp_9TLcBczIWTkLJ2ajmrELlY51B4inqpoN5p6eyqhKy_XQfP5jUdG-iWOP9Btz9y_HxY20B6U8timmW838QYaYPkxColSyQjdwdB6j5q9IfPysKn2-awZY2i","Notification", "Hello you have notification bor");
    }

}

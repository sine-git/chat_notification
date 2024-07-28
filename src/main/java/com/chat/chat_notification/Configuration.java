package com.chat.chat_notification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@org.springframework.context.annotation.Configuration
public class Configuration {


    /*
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
       // FileInputStream serviceAccount =
              //  new FileInputStream("chattingapp.json");

      *//*  FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://console.firebase.google.com/project/chattingapp-eabb5")
                .build();
       *//*
        try{
            Resource resource = new ClassPathResource("chattingapp.json");
            FileInputStream serviceAccount = new FileInputStream(resource.getFile());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
              return FirebaseApp.initializeApp(options);
            }
        }
        catch (Exception e){
            System.out.println("Exception while creating firebaseApp");
            throw e;
        }
        return  null;
    }*/
   /* @Bean
    public FirebaseMessaging firebaseMessaging() {
        return FirebaseMessaging.getInstance(FirebaseApp.getInstance());
    }*/
}

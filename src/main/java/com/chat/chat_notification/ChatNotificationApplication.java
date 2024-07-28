package com.chat.chat_notification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ChatNotificationApplication {

    public static void main(String[] args) {

        SpringApplication.run(ChatNotificationApplication.class, args);
    }

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        Resource resource = new ClassPathResource("chattingappiirre.json");

        // Utiliser InputStream pour une meilleure portabilité

        String firebaseConfig = System.getenv("FIREBASE_CONFIG");

     /*   if (firebaseConfig != null){
            ByteArrayInputStream serviceAccountEnv = new ByteArrayInputStream(firebaseConfig.getBytes());

            if (serviceAccountEnv == null) {
                throw new IllegalArgumentException("Service account file not found");
            }
            System.out.println("serviceAccount info is " + readInputStream(serviceAccountEnv));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.
                                    fromStream(serviceAccountEnv))
                    .build();

            return FirebaseApp.initializeApp(options,"Chatting App");
        }
*/
      //  else  {
            ClassPathResource serviceAccount =
                    new ClassPathResource("chattingapp.json");
            if (serviceAccount == null) {
                throw new IllegalArgumentException("Service account file not found");
            }
            System.out.println("serviceAccount info is " + readInputStream(serviceAccount.getInputStream()));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.
                                    fromStream(serviceAccount.getInputStream()))
                    .build();

            return FirebaseApp.initializeApp(options,"Chatting App");
    //    }


        }

    public String readInputStream(InputStream inputStream) throws IOException {
        // Utiliser BufferedReader pour lire le contenu ligne par ligne

             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));

    }

   @Bean
    public FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        try{
            System.out.println("Firabase app name is "+ firebaseApp.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return FirebaseMessaging.getInstance(firebaseApp);
    }
}

package com.quote.QuoteGenerator.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> payload) {
        String idTokenString = payload.get("credential");

        GoogleIdToken idToken = verifyToken(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload googlePayload = idToken.getPayload();

            String email = googlePayload.getEmail();
            String name = (String) googlePayload.get("name");
            String pictureUrl = (String) googlePayload.get("picture");

            User user = userRepository.findByEmail(email).orElseGet(() -> userRepository.save(new User() ))

            return ResponseEntity.ok(Map.of(
                    "email", email,
                    "name", name,
                    "picture", pictureUrl));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid ID token.");
        }

    }

    @SuppressWarnings("deprecation")
    private GoogleIdToken verifyToken(String idTokenString) { // token verification with Google’s servers
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(),
                    new JacksonFactory())
                    .setAudience(Collections
                            .singletonList("268854021462-45hsdqqb47302gc2gju9ife2gkvviche.apps.googleusercontent.com")) // from
                                                                                                                        // frontend
                    .build();

            return verifier.verify(idTokenString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

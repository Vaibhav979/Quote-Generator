package com.quote.QuoteGenerator.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/google")
    public ResponseEntity<?> googelLogin(@RequestBody Map<String, String> payload) {
        String idTokenString = payload.get("credential");

        GoogleIdToken idToken = verifyToken(idTokenString);

        return entity;
    }

    private GoogleIdToken verifyToken(String idTokenString) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
                    new JsonFactory())
                    .setAudience(Collections.singletonList("YOUR_GOOGLE_CLIENT_ID")) // from frontend
                    .build();

            return verifier.verify(idTokenString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

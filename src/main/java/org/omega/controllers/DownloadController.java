package org.omega.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.omega.util.Method;
import org.omega.validation.UrlValidator;

import static org.omega.service.DownloadService.downloadSingle;

public class DownloadController {
    public static void downloadHead(String body){
        JsonObject json;
        Gson gson = new Gson();
        json = gson.fromJson(body, JsonObject.class);

        String method = json.get("method").getAsString(); //video or audio
        String scope = json.get("scope").getAsString(); //single multiple audio
        String url = json.get("url").getAsString();

        url = UrlValidator.fixUrl(url);

        try {
            UrlValidator.validate(url);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        switch (method) {
            case "audio" -> downloadSingle(url, Method.AUDIO);
            case "video" -> downloadSingle(url, Method.VIDEO);
        }
    }
}

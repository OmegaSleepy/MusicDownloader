package org.omega.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.omega.validation.UrlValidator;

import java.util.List;

public class DownloadService {

    public static final String DOWNLOAD_FOLDER = "/home/martin/Music/downloaded";

    public static void downloadHead(String body){
        JsonObject json;
        Gson gson = new Gson();
        json = gson.fromJson(body, JsonObject.class);

        String method = json.get("method").getAsString();
        String url = json.get("url").getAsString();

        switch (method) {
            case "single-audio" -> download(url);
        }

    }


    public static void download(String url) {

        try {
            UrlValidator.validate(url);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        download(url, new String[]{});

    }

    private static void download(String url, String[] params) {

        var command = new Command(
                List.of(
                "yt-dlp",
                "-x",
                "--audio-format", "mp3",
                "--audio-quality", "0",
                url),
                DOWNLOAD_FOLDER
        );

        try {
            command.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}

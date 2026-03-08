package org.omega.service;

import org.omega.validation.UrlValidator;

import java.util.List;

public class DownloadService {

    public static final String DOWNLOAD_FOLDER = "/home/martin/Music/downloaded";

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

package org.omega.service;

import org.omega.util.Command;
import org.omega.util.Method;

import java.util.List;

public class DownloadService {

    public static final String DOWNLOAD_FOLDER = "/home/martin/Music/downloaded";


    public static void downloadMultiple (String url, Method method){
        switch (method) {
            case AUDIO -> download(url, List.of(
                    "--yes-playlist",
                    "-f", "bestaudio",
                    "--extract-audio",
                    "--audio-format", "mp3",
                    "--audio-quality","0",
                    "--embed-metadata",
                    "--embed-thumbnail",
                    "--convert-thumbnails", "jpg",
                    "--parse-metadata", "playlist_index:%(track_number)s",
                    "--output", "%(album,playlist_title)s/%(track_number,playlist_index)02d - %(title)s"
            ));
        }
    }

    public static void downloadSingle (String url, Method method) {
            
        switch (method) {
            case AUDIO -> download(url, List.of(
                    "-x",
                    "--audio-format", "mp3",
                    "--audio-quality", "0",
                    "-o", "%(title)s",
                    "--embed-metadata", "--embed-thumbnail"
            ));

            case VIDEO -> download(url, List.of(
                    "-t", "mp4",
                    "-o", "\"%(title)s.%(ext)s\"",
                    "--embed-metadata", "--embed-thumbnail"
            ));
        }

    }

    private static void download(String url, List<String> params) {

        var command = new Command(
                Command.construct(params, url),
                DOWNLOAD_FOLDER
        );

        try {
            command.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

package org.example;

import io.javalin.Javalin;
import org.example.service.DownloadService;

public class Main {
    public static void main (String[] args) {

        var app = Javalin.create(config -> {
            config.routes
                    .get("/", ctx -> {})
                    .post("/download", ctx -> {
                        String url = ctx.pathParam("url");
                        DownloadService.download(url);
                    })
                    ;
        }).start(8080);

    }
}
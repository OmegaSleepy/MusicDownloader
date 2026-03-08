package org.omega;

import io.javalin.Javalin;
import org.omega.service.DownloadService;

public class Main {
    public static void main (String[] args) {

        var app = Javalin.create(config -> {
            config.concurrency.useVirtualThreads = true;
            config.staticFiles.add("/public");

            config.routes
                    .post("/download", ctx -> {
                        System.out.println(ctx.path());
                        String url = ctx.formParam("url");
                        DownloadService.download(url);
                    })
                    ;
        }).start(8080);

    }
}
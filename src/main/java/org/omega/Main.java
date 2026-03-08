package org.omega;

import io.javalin.Javalin;
import org.omega.controllers.DownloadController;
import org.omega.service.DownloadService;

public class Main {
    public static void main (String[] args) {

        var app = Javalin.create(config -> {
            config.concurrency.useVirtualThreads = true;
            config.staticFiles.add("/public");

            config.routes
                    .post("/download", ctx -> DownloadController.downloadHead(ctx.body()))



                    ;
        }).start(8080);

    }
}
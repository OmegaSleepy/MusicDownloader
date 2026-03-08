package org.omega.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    List<String> args;

    String execDir;

    public Command (List<String> args) {
        new Command(args, "");
    }

    public Command (List<String> args, String execDir) {
        this.args = args;
        this.execDir = execDir;
    }

    public int run() throws Exception {
        return run(args);
    }

    public static List<String> construct(List<String> args, String url) {
        ArrayList<String> result = new ArrayList<>();
        result.add("yt-dlp");
        result.add("--js-runtimes");
        result.add("node:/usr/bin/node");
        result.addAll(args);
        result.add(url);
        return result;
    }

    public int run(List<String> command) throws Exception {

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        if (execDir != null) {
            pb.directory(new File(execDir));
        }

        Process process = pb.start();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        return process.waitFor();
    }
}

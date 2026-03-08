package org.omega.validation;

public class UrlValidator {

    public static void validate(String url) {
        if (url == null) {
            throw new NullPointerException("url is null");
        }

        if (url.startsWith("http://")) {
            throw new IllegalArgumentException(url + " is not a valid URL");
        }

        if (!url.startsWith("https://youtube.com")) {
            throw new IllegalArgumentException(url + " is not from youtube.com");
        }
    }

    public static String fixUrl(String url) {
        if (url == null) throw new NullPointerException("url is null");
        if (url.startsWith("http://")) {
            url = url.replaceFirst("http://", "https://");
        }

        if (url.contains("music.youtube.com")) {
            url = url.replaceFirst("music.youtube.com", "youtube.com");
        }

        if (url.startsWith("https://www.")) {
            url = url.replaceFirst("https://www.", "https://");
        }

        return url;

    }

}

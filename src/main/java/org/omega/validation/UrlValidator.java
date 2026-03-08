package org.omega.validation;

public class UrlValidator {

    public static void validate(String url) {
        if (url == null) {
            throw new NullPointerException("url is null");
        }

        if (url.startsWith("http://")) {
            throw new IllegalArgumentException(url + " is not a valid URL");
        }

        if (!url.startsWith("https://www.youtube.com")) {
            throw new IllegalArgumentException(url + " is not from youtube.com");
        }
    }

}

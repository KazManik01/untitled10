package org.example;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.*;
import org.apache.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://kinescope.io/06fc1552-6651-43ef-a5c3-97f33f9dd657/master.mpd").get();
        ArrayList<String> links = new ArrayList<>(10);
        int i = 1;
        int schet = 0;
        System.out.println("720p - 0, 1080p - 1,360p - 2,480p - 3,");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        String jj = "";
        while (links.size() + 1 > schet) {
            String link = "AdaptationSet:eq(0) > Representation:eq(" + choose + ") > SegmentList > SegmentURL:eq(" + i + ")";
            jj = ((doc.select(link).attr("media")));
            links.add(jj);
            i++;
            schet++;

            if (jj.isEmpty()) {
                System.out.println("String is empty");
                break;
            }
        }
        Set<String> linkSet = new HashSet<>(links);
        links.clear();
        links.addAll(linkSet);
        System.out.println(links);
        download(links);


    }

    public static void download(ArrayList<String> links) throws IOException {
        for (int i = 0; i < links.size(); i++) {
            FileUtils.copyURLToFile(new URL(links.get(i)), new File("C:/Users/Rybin/Videos"));


        }
    }

}

package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://kinescope.io/06fc1552-6651-43ef-a5c3-97f33f9dd657/master.mpd").get();
        doc.select("SegmentList:eq(0) > SegmentURL:eq(2)").forEach(System.out::println);
    }
}
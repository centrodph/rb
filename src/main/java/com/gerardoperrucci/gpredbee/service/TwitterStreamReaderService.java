package com.gerardoperrucci.gpredbee.service;


//import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
//import org.springframework.boot.context.event.ApplicationReadyEvent;

import twitter4j.*;

@Service
public class TwitterStreamReaderService {

    //Listener for startup
    //@EventListener(ApplicationReadyEvent.class)
    public void readTwitterFeed() {

        System.out.println("STARTT");

        StatusListener listener = new StatusListener() {

            @Override
            public void onException(Exception e) {
                System.out.println("Exception occured:" + e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onTrackLimitationNotice(int n) {
                System.out.println("Track limitation notice for " + n);
            }

            @Override
            public void onStatus(Status status) {
                System.out.println(status.getUser().getName() + " : " + status.getText()+ "  Tweeted AT: " + status.getCreatedAt());
            }

            @Override
            public void onStallWarning(StallWarning arg0) {
                System.out.println("Stall warning");
            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                System.out.println("Scrub geo with:" + arg0 + ":" + arg1);
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                System.out.println("Status deletion notice");
            }
        };

        TwitterStream stream = new TwitterStreamFactory().getInstance();
        FilterQuery qry = new FilterQuery();
        String[] keywords = { "Sochi","Ukraine","Whatsapp" };

        qry.track(keywords);

        stream.addListener(listener);
        stream.filter(qry);
    }
}

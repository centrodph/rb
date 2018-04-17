package com.gerardoperrucci.gpredbee.controller;

import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerardoperrucci.gpredbee.dto.SearchDTO;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    private Twitter twitter;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public TwitterController() {
        twitter = TwitterFactory.getSingleton();
    }

    public List<Status> query(String query) throws TwitterException {
        QueryResult search = twitter.search(new Query(query));
        List<Status> tweets = search.getTweets();
        return tweets;
    }

    public void printStatus(Status status) {
        System.out.println("----------------------------------------------------------");
        System.out.println(String.format("User [%s]", status.getUser().getScreenName()));
        System.out.println(status.getText());
        System.out.println(sdf.format(status.getCreatedAt()));
        System.out.println(String.format("RT[%d] FAV[%d]", status.getRetweetCount(), status.getFavoriteCount()));
        System.out.println("----------------------------------------------------------");
    }

    public void printStatus(List<Status> status) {
        for (Status tweet : status) {
            printStatus(tweet);
        }
    }

    @PostMapping("/search")
    public List<?> searchTweets(@RequestBody SearchDTO searchDTO) {
            List<Status> result;
			try {
				result = this.query(searchDTO.getSearch());
				this.printStatus(result);
                return result;
			} catch (TwitterException e) {
				e.printStackTrace();
			}
        return  new ArrayList<>();
    }

}

package com.gerardoperrucci.gpredbee.controller;
// Java
import java.util.ArrayList;
import java.util.List;
// Spring
import com.gerardoperrucci.gpredbee.service.TwitterStreamReaderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Twiiter4j
import twitter4j.*;
// Custom
import com.gerardoperrucci.gpredbee.dto.SearchDTO;
import com.gerardoperrucci.gpredbee.dto.TopicDTO;
import com.gerardoperrucci.gpredbee.model.Topic;
import com.gerardoperrucci.gpredbee.repository.TopicRepository;
import com.gerardoperrucci.gpredbee.service.TwitterStreamReaderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/twitter")
public class TwitterController {


    @Autowired
    private TwitterStreamReaderService twitterStreamReaderService;

    private Twitter twitter;

    public TwitterController() {
        twitter = TwitterFactory.getSingleton();
    }

    public List<Status> query(String query) throws TwitterException {
        QueryResult search = twitter.search(new Query(query));
        List<Status> tweets = search.getTweets();
        return tweets;
    }
    public ResponseList<User> queryUser(String query) throws TwitterException {
        int page = 1;
        ResponseList<User> search = twitter.searchUsers(query, page);
        return search;
    }

    @PostMapping("/searchByUser")
    public List<?> searchByUserTweets(@RequestBody SearchDTO searchDTO) {
        ResponseList<User> result;
        try {
            result = this.queryUser(searchDTO.getSearch());
            return result;
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return  new ArrayList<>();
    }

    @PostMapping("/search")
    public List<?> searchTweets(@RequestBody SearchDTO searchDTO) {
            List<Status> result;
			try {
				result = this.query(searchDTO.getSearch());
                return result;
			} catch (TwitterException e) {
				e.printStackTrace();
			}
        return  new ArrayList<>();
    }



    @PostMapping("suscribe")
    public void interestTopic(@RequestBody TopicDTO req) {
        twitterStreamReaderService.readTwitterTopic(req);
    }

    //EJEMPLO
    @GetMapping("suscribe")
    public void suscribeTopic() {
        twitterStreamReaderService.readTwitterFeed();
    }


}

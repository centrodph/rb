package com.gerardoperrucci.gpredbee.controller;
// Java
import java.util.ArrayList;
import java.util.List;
// Spring
import com.gerardoperrucci.gpredbee.service.TwitterStreamReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Twiiter4j
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
// Custom
import com.gerardoperrucci.gpredbee.dto.SearchDTO;
import com.gerardoperrucci.gpredbee.dto.TopicDTO;
import com.gerardoperrucci.gpredbee.model.Topic;
import com.gerardoperrucci.gpredbee.repository.TopicRepository;
import com.gerardoperrucci.gpredbee.service.TwitterStreamReaderService;


@RestController
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    private TopicRepository topicRepository;

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


    @PostMapping("topic")
    public Topic createTopic(@RequestBody TopicDTO req) {

        Topic topic = new Topic();
        topic.setInterest(req.getInterest());
        topic.setType(req.getType());
        Topic saved = topicRepository.save(topic);
        return saved;
    }

    @GetMapping("topic")
    public List<Topic> createTopic() {
        return topicRepository.findAll();
    }


    @GetMapping("suscribe")
    public void suscribeTopic() {
        twitterStreamReaderService.readTwitterFeed();
    }


}

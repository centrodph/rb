Base url:

https://gp-rb.herokuapp.com/


## PostMan

https://www.getpostman.com/collections/376ddb0a589f696bc2f4



## Libraries

http://twitter4j.org/en/configuration.html

oauth.consumerSecret=yourConsumerSecret

oauth.consumerKey=yourConsumerKey

oauth.accessToken=yourAccessToken

oauth.accessTokenSecret=yourAccessTokenSecret



## R&D Links

#### Example twitter4j integration:

https://geeks-mexico.com/2016/09/21/crea-un-buscador-en-twitter-con-java-utilizando-twitter4j/


#### Spring boot folders:

https://stackoverflow.com/a/39017839/6620340


#### CrudRepository

https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/


#### Websocket:

http://twitter4j.org/javadoc/twitter4j/TwitterStream.html

https://spring.io/guides/gs/messaging-stomp-websocket/

https://medium.com/oril/spring-boot-websockets-angular-5-f2f4b1c14cee

Dynamic mapping and sendTo

https://stackoverflow.com/questions/27047310/path-variables-in-spring-websockets-sendto-mapping


Connect service or Controller with socket endpoint


https://stackoverflow.com/questions/42207513/sending-message-to-client-periodically-via-spring-web-socket/42208928


Non-blocking

https://spring.io/guides/gs/async-method/




## Twitter4j

Status status
       status.getUser().getScreenName()
       status.getText()
       status.getCreatedAt()
       status.getRetweetCount()
       status.getFavoriteCount()



## TODO:

-  Crear topic, identificando si es interés o un usuario. Intereses => “#”, Usuarios => “@”

-  Anaizar el como manejar el "board".

-  Analizar como determinar nuevos mensajes.

-  Buscar nuevos mensajes de esa suscripción. La búsqueda del proceso se ejecuta a intervalos regulares.

-  Metodo para suscribirse a topicos.

-  Exponer actualizaciones.
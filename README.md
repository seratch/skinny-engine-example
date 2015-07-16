### Simple Skinny Engine Exmaple

Skinny Framework 2 will have its own engine. This example app shows a simple usage of it.

https://github.com/skinny-framework/skinny-framework/tree/master/engine

### Simple App

#### Run the app

```
$ cd engine-app
$ sbt

> ~container:restart
2015-07-14 15:23:59.389:INFO:oejs.ServerConnector:pool-7-thread-4: Started ServerConnector@3be28a91{HTTP/1.1}{0.0.0.0:8080}
2015-07-14 15:23:59.390:INFO:oejs.Server:pool-7-thread-4: Started @18480ms
[success] Total time: 1 s, completed Jul 14, 2015 3:23:59 PM
1. Waiting for source changes... (press enter to interrupt)
```

Access the app from your browser:

- http://localhost:8080/
- http://localhost:8080/?name=Martin
- http://localhost:8080/async?name=Martin
- http://localhost:8080/json?name=Martin
- http://localhost:8080/json/async?name=Martin

#### Run Tests

```
sbt test
```

### Standalone App

#### Run the app

```
$ cd standalone-app
$ ./scalas app.scala
```

Access the app from your browser:

- http://localhost:8081/
- http://localhost:8081/?name=Martin


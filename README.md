# Netflix Reviews

Netflix Reviews is a software that is a network of loosely coupled web services. The different services communicate over REST Apis.

![Service Architecture](/architecture.jpg?raw=true "Service Architecture")

Netflix Reviews uses Eureka Server for service discovery, Zuul for API Gateway.

Video service:

- stores Video entities in its own database (H2)
- able to retrieve all videos (without recommendations)
- able to retrieve videos and recommendations by a video id
- able to update a video and it's recommendations
- generates some video entities at startup time

Video recommendation service:

- stores Recommendations in its own database (H2)
- able to retrieve all recommendations for a videoId
- able to save a new recommendation for a videoId

## Usage

Clone the repository:

```
git clone git@github.com:noemiGyorgy/microservices-netflix.git
```

Import Maven dependencies.

Run microservices one-by-one. Please wait for finishing the initialization of each services, then start the next one.

The order of the servises is very important, please run them in this order:

1. ServiceregistryApplication
2. ApiGatewayApplication
3. RecommendationApplication
4. VideoApplication

After these steps please follow the steps of the [frontend application](https://github.com/noemiGyorgy/microservice-netflix-frontend)

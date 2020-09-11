package com.codecool.recommendation;

import com.codecool.recommendation.entity.Review;
import com.codecool.recommendation.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class RecommendationApplication {

	@Autowired
	private ReviewRepository reviewRepository;

	public static void main(String[] args) {
		SpringApplication.run(RecommendationApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/review/**"))
				.build();
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Review strangerThings = Review.builder()
					.rating(5)
					.comment("Stranger Things is nothing if not a surprising, sometimes scary, moving and successful homage to the era of Spielberg's 'ET' and the 1980s themselves. To conclude, Stranger Things is a blast, thanks to its strong storytelling and high production values.")
					.videoId(1)
					.build();
			reviewRepository.save(strangerThings);

			Review blackMirror = Review.builder()
					.rating(4)
					.comment("The 23 episodes provide us glimpses of the different outcomes as humans interact with advanced technology. The overarching theme for me is that technology has both beneficial and inimical effects on human behaviour.")
					.videoId(2)
					.build();
			reviewRepository.save(blackMirror);
		};

	}

}

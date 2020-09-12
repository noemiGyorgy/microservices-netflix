package com.codecool.video;

import com.codecool.video.entity.Video;
import com.codecool.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoApplication {

	@Autowired
	private VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/video/**"))
				.build();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Video strangerThings = Video.builder()
					.name("Stranger Things")
					.url("https://www.youtube.com/watch?v=b9EkMc79ZSU")
					.build();
			videoRepository.save(strangerThings);

			Video blackMirror = Video.builder()
					.name("Black Mirror")
					.url("https://www.youtube.com/watch?v=jDiYGjp5iFg")
					.build();
			videoRepository.save(blackMirror);

			Video umbrellaAcademy = Video.builder()
					.name("The Umbrella Academy")
					.url("https://www.youtube.com/watch?v=0DAmWHxeoKw")
					.build();
			videoRepository.save(umbrellaAcademy);
		};

	}
}

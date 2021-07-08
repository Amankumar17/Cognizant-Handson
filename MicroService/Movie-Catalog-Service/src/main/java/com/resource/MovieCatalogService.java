package com.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.CatalogItem;
import com.model.Movie;
import com.model.Rating;
import com.model.UserRating;
import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {

	@Autowired
	private DiscoveryClient discoveryClient; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
//		List<ServiceInstance> instances = discoveryClient.("MOVIE-INFO-SERVICE");
		
		UserRating ratings =  restTemplate.getForObject("http://ratings-info-service/ratingsdata/users/"+userId, UserRating.class);
		
//		List<Rating> ratings = Arrays.asList(
//				new Rating("12345",4),
//				new Rating("67890",5)
//				);
		
		return ratings.getUserRating().stream().map(rating->{
			
			Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(),Movie.class);
			
			return new CatalogItem(movie.getName(),"Desc",rating.getRating());
			}
		).collect(Collectors.toList());
//		
//		return Collections.singletonList(
//				new CatalogItem("Transformers","Desc",3)
//				);
	}
}

package boot.data.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	
	
	  @Value("${cloud.aws.credentials.accesskey}")
	  private String accesskey;
	  @Value("${cloud.aws.credentials.secretkey}")
	  private String secretkey;
	  @Value("${cloud.aws.region.static}")
	  private String region;
	  
	  @Bean
	  public AmazonS3Client amazonS3Client(){

	        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accesskey, secretkey);

	        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
	                .withRegion(region)
	                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
	                .build();
	    }
	  
	 
}
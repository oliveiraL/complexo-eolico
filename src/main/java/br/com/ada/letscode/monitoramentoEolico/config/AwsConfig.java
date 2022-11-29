package br.com.ada.letscode.monitoramentoEolico.config;


import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsConfig {


    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync(){
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("AKIAXGPIJ4Q4ETCZASRB",
                        "U+Mxs2ZqFO5qYX29BZ6sthCPDix0B0q2qycDws6A")
        );
        return AmazonSQSAsyncClientBuilder.standard().withCredentials(awsCredentialsProvider)
                .withRegion("us-east-1").build();
    }
}

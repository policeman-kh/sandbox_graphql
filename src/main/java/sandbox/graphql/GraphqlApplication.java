package sandbox.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sandbox.graphql.data.ConstantDataProvider;
import sandbox.graphql.data.DataProvider;
import sandbox.graphql.processor.BookInMemoryProcessor;
import sandbox.graphql.processor.IBookProcessor;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public DataProvider dataProvider(){
		return new ConstantDataProvider();
	}

	@Bean
	public IBookProcessor bookProcessor(){
		return new BookInMemoryProcessor();
	}
}

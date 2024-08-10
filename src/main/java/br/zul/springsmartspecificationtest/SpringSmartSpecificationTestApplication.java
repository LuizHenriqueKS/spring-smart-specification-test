package br.zul.springsmartspecificationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.zul.springsmartspecificationtest.domain.Example;
import br.zul.springsmartspecificationtest.repository.ExampleRepository;
import br.zul.springsmartspecificationtest.specification.ExampleSpecification;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class SpringSmartSpecificationTestApplication implements CommandLineRunner {

	@Autowired
	private ExampleRepository exampleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSmartSpecificationTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		exampleRepository.save(new Example().value("0"));

		log.info("==================");
		Example expected = new Example().value("abc");
		exampleRepository.save(expected);

		exampleRepository.save(new Example().value("1"));

		Example value = exampleRepository.findById(expected.id()).orElse(null);
		log.info("Value: {}", value);

		ExampleSpecification spec = new ExampleSpecification().value(expected.value());

		value = exampleRepository.findOne(spec).orElse(null);
		log.info("Value2: {}", value);
		log.info("==================");

	}

}

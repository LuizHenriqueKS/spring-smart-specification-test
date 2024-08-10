package br.zul.springsmartspecificationtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.zul.springsmartspecificationtest.domain.Example;
import io.github.zul.springsmartspecification.repository.JpaSmartSpecificationRepository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long>, JpaSpecificationExecutor<Example>,
        JpaSmartSpecificationRepository<Example> {

}

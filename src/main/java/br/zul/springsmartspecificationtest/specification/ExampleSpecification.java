package br.zul.springsmartspecificationtest.specification;

import br.zul.springsmartspecificationtest.domain.Example;
import io.github.zul.springsmartspecification.specification.SmartSpecification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class ExampleSpecification implements SmartSpecification<Example> {

    String value;

    @Override
    public Class<Example> getDomainClass() {
        return Example.class;
    }

}

package br.com.ferracini.argumentsexamples;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.time.LocalDate;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>25/04/2020</pre>
 */
public class PersonAggregator implements ArgumentsAggregator {
    @Override
    public Person aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        System.out.println(context.getParameter().getType());
        return new Person(accessor.getString(0),
                accessor.getString(1),
                accessor.get(2, Gender.class),
                accessor.get(3, LocalDate.class));
    }
}

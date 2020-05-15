package br.com.ferracini.mastering;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>15/05/2020</pre>
 */
public class RepetitionTestInfo {

    @RepeatedTest(2)
    void test(RepetitionInfo repetitionInfo) {
        System.out.println("** Test " + repetitionInfo.getCurrentRepetition()
                + '/' + repetitionInfo.getTotalRepetitions());
    }

}

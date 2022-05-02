package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.tachogaph.TachographModule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TachographTests {

        @Test
        public void TestDataAddition(){
            TachographModule tc = new TachographModule();

            tc.recordData(new Date(0), 10, 10);

            var a = tc.getData(new Date(0));

            Assertions.assertTrue(a.containsKey(10));

        }
}

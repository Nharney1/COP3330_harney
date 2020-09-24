import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BodyMassIndexTest {

        private BodyMassIndex bmiTester;

        @BeforeEach
        public void init(){
              bmiTester = new BodyMassIndex(1000,1000);
        }

        @Test
        public void testBmiCalculatorNormalNumbers1(){
                double output = bmiTester.bmiCalculator(50,50);
                assertEquals(14.06, output);
        }

        @Test
        public void testBmiCalculatorNormalNumbers2(){
                double output = bmiTester.bmiCalculator(50,100);
                assertEquals(28.12, output);
        }

        @Test
        public void testBmiCalculatorExtremeCase1(){
                double output = bmiTester.bmiCalculator(10,100);
                assertEquals(703, output);
        }

        @Test
        public void testBmiCalculatorExtremeCase2(){
                double output = bmiTester.bmiCalculator(100,10);
                assertEquals(.703, output);
        }

        @Test
        public void testBmiGetter(){
                double output = bmiTester.getBmi();
                assertEquals(.703, output);
        }

        @Test
        public void testCategoryGetter() {
                String output = bmiTester.getCategory();
                assertEquals("Underweight",output );
        }

        @Test
        public void testCategoryObese(){
               String output = bmiTester.category(50);
                assertEquals("Obesity", output);
        }

        @Test
        public void testCategoryObeseBoundary(){
                String output = bmiTester.category(29.9);
                assertEquals("Overweight", output);
        }

        @Test
        public void testCategoryOverweight(){
                String output = bmiTester.category(27.5);
                assertEquals("Overweight", output);
        }

        @Test
        public void testCategoryOverweightBoundary(){
                String output = bmiTester.category(24.9);
                assertEquals("Normal weight", output);
        }

        @Test
        public void testCategoryNormalWeight(){
                String output = bmiTester.category(20);
                assertEquals("Normal weight", output);
        }

        @Test
        public void testCategoryNormalWeightBoundary(){
                String output = bmiTester.category(18.51);
                assertEquals("Normal weight", output);
        }

        @Test
        public void testCategoryNormalWeightBoundary2(){
                String output = bmiTester.category(18.5);
                assertEquals("Underweight", output);
        }

        @Test
        public void testCategoryUnderweight(){
                String output = bmiTester.category(5);
                assertEquals("Underweight", output);
        }

}
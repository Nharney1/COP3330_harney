import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BodyMassIndexTest {

        @Test
        public void testBmiCalculatorNormalNumbers1(){
                BodyMassIndex bmiTester = new BodyMassIndex(50,50);
                double output = bmiTester.bmiCalculator(50,50);
                assertEquals(14.06, output);
        }

        @Test
        public void testBmiCalculatorNormalNumbers2(){
                BodyMassIndex bmiTester = new BodyMassIndex(50,100);
                double output = bmiTester.bmiCalculator(50,100);
                assertEquals(28.12, output);
        }

        @Test
        public void testBmiCalculatorExtremeCase1(){
                BodyMassIndex bmiTester = new BodyMassIndex(10,100);
                double output = bmiTester.bmiCalculator(10,100);
                assertEquals(703, output);
        }

        @Test
        public void testBmiCalculatorExtremeCase2(){
                BodyMassIndex bmiTester = new BodyMassIndex(100000,100000);
                double output = bmiTester.bmiCalculator(100,10);
                assertEquals(.703, output);
        }

        @Test
        public void testBmiGetter(){
                BodyMassIndex bmiTester = new BodyMassIndex(100,100);
                double output = bmiTester.getBmi();
                assertEquals(7.03, output);
        }

        @Test
        public void testCategorySetter() {
                BodyMassIndex bmiTester = new BodyMassIndex(100,100);
                String output = bmiTester.getCategory();
                assertEquals("Underweight",output );
        }

        @Test
            public void testCategoryObese(){
                BodyMassIndex tester = new BodyMassIndex(10,1000);
                assertEquals("Obesity", tester.getCategory());
          }

        @Test
        public void testCategoryOverweight(){
                BodyMassIndex tester = new BodyMassIndex(70,180);
                assertEquals("Overweight", tester.getCategory());
        }

        @Test
        public void testCategoryNormalWeight(){
                BodyMassIndex tester = new BodyMassIndex(70,170);
                assertEquals("Normal Weight", tester.getCategory());
        }
        @Test
        public void testCategoryUnderweight(){
                BodyMassIndex tester = new BodyMassIndex(70,120);
                assertEquals("Underweight", tester.getCategory());
        }

  /*      @Test
        public void testCategoryMethodNOTWORKING(){
                String output =
                assertEquals("Underweight", output);
        }
*/

}
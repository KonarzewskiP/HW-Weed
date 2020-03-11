package bigDecimal;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalPlayground {
    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal num = new BigDecimal("356");
        BigDecimal three = new BigDecimal("3");


        System.out.println(num.divide(three, RoundingMode.DOWN));
    }
}

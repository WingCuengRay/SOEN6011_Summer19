package tangentfunction;

/**
 * F2_tan(x).
 * 
 * @author Qing Li SID:40082701
 */
public class TangentFunction {

  /**
   * Constructor.
   */
  public TangentFunction() {}

  /**
   * Power function.
   * 
   * @param x is the number of base
   * @param n is the number of power
   * @return the result represented in double
   */
  public static double pwr(double x, int n) {
    int i = 0;
    double powers = 1;
    if (n == 0) {
      return 1;
    }
    for (i = 1; i <= n; i++) {
      powers = powers * x;
    }
    return powers;
  }

  /**
   * Factorial function.
   * 
   * @param n is an integer number
   * @return the result represented in double
   */
  public static double fac(int n) {
    int i = 0;
    double pdt = 1;
    if (n == 0 || n == 1) {
      return 1;
    }
    for (i = 2; i <= n; i++) {
      pdt = pdt * i;
    }
    return pdt;
  }

  /**
   * Tangent function.
   * 
   * @param line is the input stream
   * @return the result represented in String
   */
  public String tangent(String line) {
    int i = 0;
    int j = 0;
    int cons = 1;
    double s = 0;
    double c = 0;
    double sin = 0;
    double cos = 0;
    double y = 0;
    final double pi = 3.1415926;
    String msg;

    // error handling: to detect the empty input
    if (line.isEmpty()) {
      msg = "Error: Empty input!";
      return msg;
    }

    // error handling: to detect non real number input
    for (int n = 0; n < line.length(); n++) {
      if (line.charAt(n) < 48 || line.charAt(n) > 57) {
        if (line.charAt(n) != 45 && line.charAt(n) != 46) {
          msg = "Error: This is not a real number!";
          return msg;
        }
      }
    }

    y = Double.valueOf(line);

    // error handling: to detect non exist value
    if (y % 90 == 0) {
      msg = "Error: The value is not existing!";
      return msg;
    }

    double x = y * pi / 180;

    for (int k = 1; k <= 24; k++) {
      i = 2 * k - 1;
      j = 2 * k - 2;
      s = cons * pwr(x, i) / fac(i); // calculate sin based on Taylor series
      c = cons * pwr(x, j) / fac(j); // calculate cos based on Taylor series
      cons = -1 * cons;
      sin = sin + s;
      cos = cos + c;
    }

    double tan = sin / cos; // tangent function based tan=sin/cos
    msg = "tan(" + (float) y + ")= " + String.format("%.6f", tan);
    return msg;
  }
}

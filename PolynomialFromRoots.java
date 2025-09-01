import java.math.BigInteger;
import java.util.*;

public class PolynomialFromRoots {

    public static void main(String[] args) {
        // ---------- Test Case 1 ----------
        Map<String, Map<String, String>> testCase1 = new LinkedHashMap<>();
        testCase1.put("keys", Map.of("n", "4", "k", "3"));
        testCase1.put("1", Map.of("base", "10", "value", "4"));
        testCase1.put("2", Map.of("base", "2", "value", "111"));
        testCase1.put("3", Map.of("base", "10", "value", "12"));
        testCase1.put("6", Map.of("base", "4", "value", "213"));

        System.out.println("---- Test Case 1 ----");
        solvePolynomial(testCase1);

        // ---------- Test Case 2 ----------
        Map<String, Map<String, String>> testCase2 = new LinkedHashMap<>();
        testCase2.put("keys", Map.of("n", "10", "k", "7"));
        testCase2.put("1", Map.of("base", "6", "value", "13444211440455345511"));
        testCase2.put("2", Map.of("base", "15", "value", "aed7015a346d635"));
        testCase2.put("3", Map.of("base", "15", "value", "6aeeb69631c227c"));
        testCase2.put("4", Map.of("base", "16", "value", "e1b5e05623d881f"));
        testCase2.put("5", Map.of("base", "8", "value", "316034514573652620673"));
        testCase2.put("6", Map.of("base", "3", "value", "2122212201122002221120200210011020220200"));
        testCase2.put("7", Map.of("base", "3", "value", "20120221122211000100210021102001201112121"));
        testCase2.put("8", Map.of("base", "6", "value", "20220554335330240002224253"));
        testCase2.put("9", Map.of("base", "12", "value", "45153788322a1255483"));
        testCase2.put("10", Map.of("base", "7", "value", "1101613130313526312514143"));

        System.out.println("\n---- Test Case 2 ----");
        solvePolynomial(testCase2);
    }

    private static void solvePolynomial(Map<String, Map<String, String>> input) {
        int n = Integer.parseInt(input.get("keys").get("n"));
        int k = Integer.parseInt(input.get("keys").get("k"));

        List<BigInteger> decimalRoots = new ArrayList<>();

        
        for (int i = 1; i <= n; i++) {
            Map<String, String> root = input.get(String.valueOf(i));
            if (root != null) {
                int base = Integer.parseInt(root.get("base"));
                String value = root.get("value");
                decimalRoots.add(new BigInteger(value, base));
            }
        }

        
        List<BigInteger> chosenRoots = decimalRoots.subList(0, k - 1);

        
        List<BigInteger> coefficients = getPolynomialCoefficients(chosenRoots);

        
        for (int i = 0; i < coefficients.size(); i++) {
            System.out.println("x^" + (coefficients.size() - 1 - i) + " : " + coefficients.get(i));
        }
    }

    // Polynomial expansion from roots
    private static List<BigInteger> getPolynomialCoefficients(List<BigInteger> roots) {
        List<BigInteger> coeffs = new ArrayList<>();
        coeffs.add(BigInteger.ONE);

        for (BigInteger r : roots) {
            List<BigInteger> newCoeffs = new ArrayList<>();
            newCoeffs.add(coeffs.get(0)); // highest degree stays

            for (int i = 1; i < coeffs.size(); i++) {
                newCoeffs.add(coeffs.get(i).subtract(r.multiply(coeffs.get(i - 1))));
            }

            newCoeffs.add(coeffs.get(coeffs.size() - 1).negate().multiply(r));
            coeffs = newCoeffs;
        }
        return coeffs;
    }
}

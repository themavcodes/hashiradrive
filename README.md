# Polynomial From Roots

This Java program reconstructs a polynomial from given roots.  
Each root is provided in a specific **base**, and the program converts them into decimal before forming the polynomial.  
It then prints out the polynomial coefficients using Vieta’s formula and polynomial expansion.

---

## Features
- Handles roots in **different number bases** (binary, octal, decimal, hexadecimal, etc.).
- Supports **arbitrarily large numbers** using `BigInteger`.
- Works with **multiple test cases**.
- Prints polynomial coefficients in standard form.

---

## Example

### Input (Test Case 1 in code):
```json
{
  "keys": { "n": "4", "k": "3" },
  "1": { "base": "10", "value": "4" },
  "2": { "base": "2", "value": "111" },
  "3": { "base": "10", "value": "12" },
  "6": { "base": "4", "value": "213" }
}

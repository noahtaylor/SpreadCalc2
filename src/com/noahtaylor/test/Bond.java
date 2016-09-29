package com.noahtaylor.test;

import java.math.BigDecimal;

public class Bond {

  public enum BondType {
    CORP("corporate"), GOV("government");
    private final String value;

    BondType(String value) {
      this.value = value;
    }

    public static BondType from(String name) {
      for (BondType b : BondType.values()) {
        if (b.value.equals(name))
          return b;
      }
      return null;
    }
  }

  private final String bond;
  private final BondType type;
  private final BigDecimal term;
  private final BigDecimal yield;

  /**
   * Constructor
   * 
   * @param csvString format of a bond e.g. "C1,corporate,10.3 years,5.30%"
   */
  public Bond(String csvString) {
    String[] s = csvString.split(",");
    if (s.length != 4)
      throw new IllegalArgumentException("Invalid number of values in csv.  Expected 4 but was: " + s.length + " in " + s);
    this.bond = s[0].trim();
    this.type = BondType.from(s[1].trim());
    if (type == null)
      throw new IllegalArgumentException("Invalid bond type: " + s[1]);
    term = new BigDecimal(s[2].replace("years", "").trim());
    yield = new BigDecimal(s[3].replace("%", "").trim());
  }

  public String getBond() {
    return bond;
  }

  public BondType getType() {
    return type;
  }

  public BigDecimal getTerm() {
    return term;
  }

  public BigDecimal getYield() {
    return yield;
  }

  public boolean isGovt() {
    return getType() == BondType.GOV;
  }
}

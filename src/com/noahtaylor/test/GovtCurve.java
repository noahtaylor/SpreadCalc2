package com.noahtaylor.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class GovtCurve {

  TreeSet<Bond> govtBonds = new TreeSet<Bond>(new Comparator<Bond>() {

    @Override
    public int compare(Bond o1, Bond o2) {
      return o1.getTerm().compareTo(o2.getTerm());
    }

  });

  /**
   * Add a govt bond to the curve
   * 
   * @param govt
   */
  public void addBond(Bond govt) {
    if (!govt.isGovt())
      throw new IllegalArgumentException("Bond is not a goverment bond!");
    govtBonds.add(govt);
  }

  public BigDecimal calculateSpreadToBenchmark(Bond corp) {
    if (govtBonds.isEmpty())
      throw new IllegalStateException("No benchmark bonds to calculate spread.");
    Bond l = govtBonds.lower(corp);
    Bond h = govtBonds.higher(corp);

    Bond bm = null;
    // if lower is less than or equal then use lower otherwise use higher
    if (l == null || (h != null && corp.getTerm().subtract(l.getTerm()).compareTo(h.getTerm().subtract(corp.getTerm())) > 0)) {
      bm = h;
    } else {
      bm = l;
    }
    BigDecimal sp = corp.getYield().subtract(bm.getYield());
    System.out.println(corp.getBond() + "," + bm.getBond() + "," + sp + "%");
    return sp;
  }

  public void calculateSpreadToBenchmark(List<Bond> corps) {
    System.out.println("bond,benchmark,spread_to_benchmark");
    for (Bond b : corps)
      calculateSpreadToBenchmark(b);
  }

  public BigDecimal calculateSpreadToCurve(Bond corp, int decimalPlaces) {
    if (govtBonds.isEmpty())
      throw new IllegalStateException("No benchmark bonds to calculate spread.");
    Bond l = govtBonds.lower(corp);
    Bond h = govtBonds.higher(corp);
    if (l == null || h == null)
      throw new IllegalStateException("Corporate bond term out of bounds.");
    // compute linear interpolation
    BigDecimal r = corp.getTerm().subtract(l.getTerm()).divide(h.getTerm().subtract(l.getTerm()), 10, RoundingMode.HALF_EVEN);
    BigDecimal yl = l.getYield().multiply(BigDecimal.ONE.subtract(r));
    BigDecimal yh = h.getYield().multiply(r);
    BigDecimal sp = corp.getYield().subtract(yh.add(yl)).setScale(decimalPlaces, RoundingMode.HALF_EVEN);
    System.out.println(corp.getBond() + "," + sp + "%");
    return sp;
  }

  public void calculateSpreadToCurve(List<Bond> corps, int decimalPlaces) {
    System.out.println("bond,spread_to_curve");
    for (Bond b : corps)
      calculateSpreadToCurve(b, decimalPlaces);
  }

}

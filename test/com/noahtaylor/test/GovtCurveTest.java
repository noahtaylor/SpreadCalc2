package com.noahtaylor.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import com.noahtaylor.test.BondReader.CurveAndCorps;

public class GovtCurveTest {

  @Test
  public void testGovtCurveSpreadToBenchMark() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c1test1.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToBenchmark(bonds.getCorps().get(0));
    assertTrue(sp.compareTo(new BigDecimal("1.6")) == 0);
  }

  @Test
  public void testGovtCurveSpreadToBenchMarkHigher() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c1test2.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToBenchmark(bonds.getCorps().get(0));
    assertTrue(sp.compareTo(new BigDecimal("0.5")) == 0);
  }

  @Test
  public void testGovtCurveSpreadToBenchMarkLower() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c1test3.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToBenchmark(bonds.getCorps().get(0));
    assertTrue(sp.compareTo(new BigDecimal("1.6")) == 0);
  }

  @Test
  public void testGovtCurveSpreadToBenchMarkTie() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c1test4.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToBenchmark(bonds.getCorps().get(0));
    assertTrue(sp.compareTo(new BigDecimal("1.6")) == 0);
  }

  @Test
  public void testGovtCurveSpreadToBenchMarkBelow() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c1test5.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToBenchmark(bonds.getCorps().get(0));
    assertTrue(sp.compareTo(new BigDecimal("1.6")) == 0);
  }

  @Test
  public void testGovtCurveSpreadToBenchMarkAbove() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c1test6.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToBenchmark(bonds.getCorps().get(0));
    assertTrue(sp.compareTo(new BigDecimal("0.5")) == 0);
  }

  @Test
  public void testGovtCurveSpreadToCurve() {
    BondReader br = new BondReader();
    CurveAndCorps bonds = null;
    try {
      bonds = br.readCurveAndCorpsFromCsv("csv/test/c2test1.csv");
    } catch (IOException e) {
      assertTrue(false);
    }

    assertNotNull(bonds.getCurve());
    assertNotNull(bonds.getClass());
    BigDecimal sp = bonds.getCurve().calculateSpreadToCurve(bonds.getCorps().get(0), 2);
    assertTrue(sp.compareTo(new BigDecimal("1.22")) == 0);
    sp = bonds.getCurve().calculateSpreadToCurve(bonds.getCorps().get(1), 2);
    assertTrue(sp.compareTo(new BigDecimal("2.98")) == 0);
  }


}

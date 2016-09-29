package com.noahtaylor.test;

import java.io.IOException;

import com.noahtaylor.test.BondReader.CurveAndCorps;

public class Main {
  public static void main(String[] args) {
    try {
      BondReader br = new BondReader();
      // calculate spread to benchmark
      CurveAndCorps c = null;
      try {
        c = br.readCurveAndCorpsFromCsv("csv/c1.csv");
      } catch (IOException e) {
        System.out.println("ERROR: Unable to read file csv/c1.csv");
        return;
      }
      c.getCurve().calculateSpreadToBenchmark(c.getCorps());

      // calculate spread to curve
      try {
        c = br.readCurveAndCorpsFromCsv("csv/c2.csv");
      } catch (IOException e) {
        System.out.println("ERROR: Unable to read file csv/c2.csv");
        return;
      }
      c.getCurve().calculateSpreadToCurve(c.getCorps(), 2);
    } catch (Throwable t) {
      System.out.println("ERROR: " + t.getMessage());
    }
  }
}

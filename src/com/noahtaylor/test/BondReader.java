package com.noahtaylor.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads csv files and converts them to list of bonds.
 * 
 * @author taylon6
 *
 */
public class BondReader {
  /**
   * Get a list of bonds from a csv file
   * 
   * @param fileName - based on the base project path
   * @return
   * @throws IOException
   */
  public List<Bond> readBondsFromCsv(String fileName) throws IOException {
    List<Bond> bonds = new ArrayList<>();
    try (BufferedReader CSVFile = new BufferedReader(new FileReader(fileName))) {
      // first header line is discarded
      String data = CSVFile.readLine();
      data = CSVFile.readLine();
      while (data != null) {
        bonds.add(new Bond(data));
        data = CSVFile.readLine();
      }
    }
    return bonds;
  }

  /**
   * Reads a csv file into a list govt curve and corporates list
   * 
   * @param fileName
   * @return
   * @throws IOException
   */
  public CurveAndCorps readCurveAndCorpsFromCsv(String fileName) throws IOException {
    BondReader br = new BondReader();
    List<Bond> bonds = null;
    bonds = br.readBondsFromCsv(fileName);

    GovtCurve curve = new GovtCurve();
    List<Bond> corps = new ArrayList<>();
    for (Bond b : bonds) {
      if (b.isGovt()) {
        curve.addBond(b);
      } else {
        corps.add(b);
      }
    }
    return new CurveAndCorps(curve, corps);

  }

  /**
   * Convenience class for returning a separate curve and corps list
   * 
   * @author taylon6
   *
   */
  public static class CurveAndCorps {
    private final List<Bond> corps;
    private final GovtCurve curve;

    public CurveAndCorps(GovtCurve curve, List<Bond> corps) {
      this.corps = corps;
      this.curve = curve;
    }

    public List<Bond> getCorps() {
      return corps;
    }

    public GovtCurve getCurve() {
      return curve;
    }

  }

}

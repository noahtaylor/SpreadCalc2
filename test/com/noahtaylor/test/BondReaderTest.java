package com.noahtaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class BondReaderTest {

  @Test
  public void testBondReader() {
    BondReader br = new BondReader();
    List<Bond> bonds = null;
    try {
      bonds = br.readBondsFromCsv("csv/test/c1test1.csv");
    } catch (IOException e) {
      assertTrue(false);
    }
    assertEquals(bonds.size(), 3);
  }

}

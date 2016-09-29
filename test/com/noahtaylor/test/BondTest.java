package com.noahtaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.noahtaylor.test.Bond.BondType;

/**
 * Test class for bond
 * 
 * @author taylon6
 *
 */
public class BondTest {
  @Test
  public void testBond() {
    Bond b = new Bond("C1,corporate,10.3 years,5.30%");
    assertEquals(b.getBond(), "C1");
    assertEquals(b.getType(), BondType.CORP);
    assertEquals(b.getTerm(), new BigDecimal("10.3"));
    assertTrue(b.getYield().compareTo(new BigDecimal("5.3")) == 0);
  }
}

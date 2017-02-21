package lice.compiler.parse

import lice.compiler.util.println
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by ice1000 on 2017/2/20.
 *
 * @author ice1000
 */
class NumberKtTest {
	@Test(timeout = 1000)
	fun safeLower() {
		assertEquals('a', 'A'.safeLower())
		assertEquals('a', 'a'.safeLower())
		assertEquals('b', 'B'.safeLower())
		assertEquals('c', 'C'.safeLower())
		assertEquals('d', 'D'.safeLower())
		assertEquals('d', 'd'.safeLower())
	}

	@Test(timeout = 1000)
	fun isHexInt() {
		assertTrue("0x2333".isHexInt())
		assertTrue("0xA1D2".isHexInt())
		assertTrue("0x0000".isHexInt())
		assertTrue("0x9999".isHexInt())
		assertTrue("-0x9999".isHexInt())
		assertTrue("0xFFFF".isHexInt())
		assertTrue("0xABCD".isHexInt())
		assertTrue("0xffff".isHexInt())
		assertTrue("0XFFFF".isHexInt())
		assertFalse("0aFFFF".isHexInt())
		assertFalse("FFFF".isHexInt())
		assertFalse("0xABCR".isHexInt())
		assertFalse("-0xABCX".isHexInt())
	}

	@Test(timeout = 1000)
	fun toHexInt() {
//		0x1.println()
//		Integer.toHexString("0x1".toHexInt()).println()
		assertEquals(0x2333, "0x2333".toHexInt())
		assertEquals(0xABCD, "0xABCD".toHexInt())
		assertEquals(-0x2333, "-0x2333".toHexInt())
	}

}
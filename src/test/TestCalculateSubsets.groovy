package test;

import static org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

import src.CalculateSubsets

class TestCalculateSubsets {
	CalculateSubsets testCalcSub
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMaskGetsSomePermutations() {
		testCalcSub = new CalculateSubsets(4,2)
		
		List expectedFirstIteration = [0,0,0,1]
		List expectedSecondIteration = [0,0,1,0]
		List expectedThirdIteration = [0,0,1,1]
		List expectedFourthIteration = [0,1,0,0]
		
		assertEquals(expectedFirstIteration,testCalcSub.next())
		assertEquals(expectedSecondIteration,testCalcSub.next())
		assertEquals(expectedThirdIteration,testCalcSub.next())
		assertEquals(expectedFourthIteration,testCalcSub.next())
	}
	
	@Test
	public void testMaskGetSingleValuePermutations() {
		testCalcSub = new CalculateSubsets(5, 1)
		
		List expectedFirstIteration = [0,0,0,0,1]
		List expectedSecondIteration = [0,0,0,1,0]
		List expectedThirdIteration = [0,0,1,0,0]
		List expectedFourthIteration = [0,1,0,0,0]
		List expectedFifthIteration = [1,0,0,0,0]

		assertEquals(expectedFirstIteration,testCalcSub.next())
		assertEquals(expectedSecondIteration,testCalcSub.next())
		assertEquals(expectedThirdIteration,testCalcSub.next())
		assertEquals(expectedFourthIteration,testCalcSub.next())
		assertEquals(expectedFifthIteration,testCalcSub.next())
	}
	
	@Test
	public void testIfNextKnowsWhenToStop(){
		int setSize = 5
		int maxSubsetSize = 1
		testCalcSub = new CalculateSubsets(setSize, maxSubsetSize)
		
		//Call next for setSize times
		for(int i=0;i<2.power(setSize);i++){
			testCalcSub.next()
		}
		//The next call to next should return a null, yo
		assertEquals(null,testCalcSub.next())
	}
	
	@Test
	public void testWhenTheNumbersAreTooDamnHigh(){
		testCalcSub = new CalculateSubsets(100000000,5)
		while (testCalcSub.next() != null){
			//Do nothing
			//This seems kinda dumb, but whatever
		}
	}
	
	@Test
	public void testIfBigIntegerIsReallyThatBig() {
		BigInteger thisIsLarge = 2.power(70)
		assertEquals(2.power(70),thisIsLarge)
	}

}

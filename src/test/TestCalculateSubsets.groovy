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
		
		while(testCalcSub.hasNext() == true){
			testCalcSub.next()
		}
		
		//Call next for setSize times
		for(int i=0;i<setSize;i++){
			testCalcSub.next()
		}
		//The next call to hasNext should return a null, yo
		assertEquals(false,testCalcSub.hasNext())
	}
	
	@Test
	public void testWhenTheNumbersAreTooDamnHigh(){
		testCalcSub = new CalculateSubsets(30,5)
		while (testCalcSub.hasNext()){
			testCalcSub.next()
		}
	}
	
	@Test
	public void testIfBigIntegerIsReallyThatBig() {
		BigInteger thisIsLarge = 2.power(70)
		assertEquals(2.power(70),thisIsLarge)
		//Haha, this is a silly test...
	}

}

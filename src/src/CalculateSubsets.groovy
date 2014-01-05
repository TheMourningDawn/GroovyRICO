package src

class CalculateSubsets {
	int maxSubsetSize
	BigInteger setSize
	BigInteger iteration
	
	String format

	public CalculateSubsets(int mySetSize, int maxSubset) {
		maxSubsetSize = maxSubset
		setSize = mySetSize
		iteration = 0
		format = "%" + setSize + "s"
	}
	
	boolean hasNext(){
		int nextIteration = iteration + 1
		if(nextIteration > 2.power(setSize))
			return false
		return true
	}
	
	List next(){
		List mask = new ArrayList()
		iteration++
		String maskAsString = ""
		while((maskAsString = Integer.toBinaryString(iteration)).count("1") > maxSubsetSize){
			iteration++
			println iteration
		}
		if(this.hasNext()){
			maskAsString = String.format(format, Integer.toBinaryString(iteration)).replace(' ','0')
			for(int i=0;i<maskAsString.size();i++){
				mask.add(maskAsString.substring(i,i+1).toInteger())
			}
//			println mask
		}
		return mask
	}

	static main(args) {
//		def mask = new ArrayList()
//		
//		int boobs = 23
//		String whatWhat = String.format("%8s",Integer.toBinaryString(boobs)).replace(' ','0')
//		for(int i=0;i<whatWhat.length();i++){
//			mask.add(whatWhat.substring(i,i+1).toInteger())
//		}
//		
//		println mask
		
//		def mask = new ArrayList()
//		mask.push(true)
//		mask.push(true)
//		for(int i=0;i<6;i++){
//			mask.push(false)
//		}
//		
//		PermutationGenerator coolness = new PermutationGenerator(mask)
//		println coolness.getTotal()
//		while(coolness.hasNext()){
//			println coolness.next()
//		}
		
//		CalculateSubsets greatShit = new CalculateSubsets(5)
//		mask.each { x -> println x }
//		greatShit.next(mask,2)
//		println "NextThingy"
//		mask.each { x -> println x }
//		while (greatShit.next(mask, 2)) {
//			println "stop"
//			mask.each { x -> println x }
//		}
		
//		def somethingElse = mask.subsequences().each { x -> println x } 
//		mask.subsequences().findAll{ it.size() <= 4 }.each{ x-> println x }
//		def somethingElse = mask.permutations { it.collect { x -> x+2 } }
//		mask.eachPermutation { x -> println x }
//		CalculateSubsets greatShit = new CalculateSubsets(5)
//		greatShit.nextMask(mask, 0)
//		println "${somethingElse}"
//		println "${wootness}"
	}

}

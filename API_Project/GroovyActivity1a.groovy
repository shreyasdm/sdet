package activity

class GroovyActivity1a {
	static void main(def args) {
		def inputList = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		def intList = inputList.minus(["Mango", "Apple", "Watermelon"])
		
		
		println intList.sort()
		def strList=inputList.minus(intList)
		println strList.sort()
	}
}

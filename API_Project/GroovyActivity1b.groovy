package activity

class GroovyActivity1b {
	static void main(def args) {
		File file = new File("src/activity/input.txt");
		file.createNewFile();
		file.write("quick brown Fox jumped over the lazy Cow\n") 
		file.append("John Jimbo jingeled happily ever after\n") 
		file.append("Th1\$ 1\$ v3ry c0nfus1ng\n") 
		
		file.eachLine { 
			if(it =~/Cow$/) {
				println it
			}
			if(it =~/^J/) {
				println it
			}
			if(it =~/\d{2}/) {
				println it
			}
		}
		
		def match1 = file.text =~ /\S+er/
		println match1.findAll()
		
		def match2 = file.text =~ /\S*d\W/
		println match2.findAll()
	}
}

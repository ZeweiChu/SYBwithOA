form Box1HouseOwning {
	valueResidue: "Value residue:" integer
	value4: "value4" integer (valueResidue+1)
	value5: "value5" integer (value4+1)

	if(value5 > 100 && true){
		value6: "hello" integer
	}
}
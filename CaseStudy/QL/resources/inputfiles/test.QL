form HouseOwning {
  soldHouse: "Did you sell a house?" boolean
  boughtHouse: "Did you buy a house?" boolean
  if (soldHouse) {
    sellingPrice: "Selling price:" integer
    privateDebt: "Private debts:" integer
    valueResidue: "Value residue:" integer 
       = (sellingPrice - privateDebt)
  }
}

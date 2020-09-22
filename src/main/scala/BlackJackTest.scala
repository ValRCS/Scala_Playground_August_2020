import BlackJack.{getRandomDeck, getScore}

object BlackJackTest extends App {
  println("Testing BlackJack!")
//  assert(2+2 == 5) // will throw an error
  val fakeDeck = Seq(Card("10","clubs", 10), Card("A","clubs", 1))
//  val fakeDeck2 = Seq((("6","clubs"),6), (("A","clubs"),1), (("4","clubs"),4))
//  val fakeDeck3 = Seq((("6","clubs"),6), (("A","clubs"),1), (("4","clubs"),4), (("A","diamonds"),1))
  // you would need to add a few more tests to cover all basis when testing
  assert(getScore(fakeDeck) == 21)
//  assert(getScore(fakeDeck2) == 21)
//  assert(getScore(fakeDeck3) == 12)
  getRandomDeck()
}

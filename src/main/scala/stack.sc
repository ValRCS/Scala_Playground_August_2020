// A stack is a last-in, first-out (LIFO) data structure
// https://alvinalexander.com/scala/how-to-use-stack-class-immutable-push-pop-in-scala/
import scala.collection.mutable.Stack
val myStack = Stack("cookie","milk","angry dog")
myStack
val current = myStack.pop()
val numbers = Stack(0)
(9 to 0 by -1).foreach(numbers.push(_))
val stackRange = Stack.range(0,9) // more Stack like :) but no step
stackRange
numbers
numbers.pop()
numbers.pop()
numbers.pop()

numbers.size
numbers.slice(0,6)

//you could just use List structure for this as well, which is supposed to be a bit faster


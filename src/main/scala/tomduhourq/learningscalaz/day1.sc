import scalaz._
import Scalaz._

// Triple equals does not let you compare different types.
1 === 1

// Inequality
1.some =/= 2.some

// This one led to a RuntimeException
//1 assert_=== 2

1 =/= 2 && false

// Returns the Ordering with the result.
val ord = 1.0 ?|? 2.0
ord.toInt

1.0 max 41.0
1 lt 2

"asdgqlaghqoñihgpñqje".shows

// Enum
'a' to 'e'
'a' |-> 'e'

(3 |=> 5).dropWhile(5>).toList

'H'.succ



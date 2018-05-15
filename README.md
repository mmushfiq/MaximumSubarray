# MaximumSubarray
Maximum subarray problem. Brute Force, Divide and Conquer, Kadane's Algorithm

More info: [https://www.mycertnotes.com/az/maximum-subarray-problemi-kadane-alqoritmi/](https://www.mycertnotes.com/az/maximum-subarray-problemi-kadane-alqoritmi/)

***
The following stock problem is given in [Introduction to Algorithms](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844) book (on page 68), you can solve it using "Maximum-subarray":

![maximum-subarray-practical-example](http://www.mycertnotes.com/wp-content/uploads/2017/07/maximum-subarray-practical-example.jpg)

***


It is shown three solution for maximum-subarray problem in this project:

N | Algorithm | Time complexity
----|----|----
1 | Brute-force | O(n^2)
2 | Divide and Conquer | O(nlogn)
3 | Kadane's Algorithm | O(n)

<br>
I compared these three solutions in my local machine and result was (duration is given with milliseconds):
<br><br>

Array length | Brute-force| Divide and Conquer | Kadane's Algorithm
----|----|----|----
1000 | 13 ms | 2 ms | 1 ms
1_000_000 | 646535 ms | 115 ms | 9 ms

***

### Time complexity:
![time-complexity](http://www.mycertnotes.com/wp-content/uploads/2017/07/rate-of-growth.jpg)



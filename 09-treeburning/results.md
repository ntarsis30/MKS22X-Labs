1. Why did you choose the board size for your finalized table?

   I wanted to have a large board to remove the possibility of receiving insufficient data from smaller boards. 
   Originally I had a 1000 by 1000 board, but that was too slow to run 100 times for 31 densities.
2. Why did you choose the number of repetitions size for your finalized table?

   My goal was to test very thoroughly, so I wanted to have a high number of tests for each density.
   At the same time, I wanted to also be able to test a large board, so I went with a more moderate number of tests.
3. What did your testing show about changing the board size?

   When I changed the board size, the number of ticks needed for sufficiently large densities, above 40%, began to increase more significantly
4. Knowing that there were differences based on boardsize, what was the relationship between the board size and the maximum burn time? How did you test this?

   I noticed that the ratio between the board size and the maximumm burn time seemed to approach the value of e. 
   To test this I just tested some large values for the board size such as 100, 500, 1000.
5. What density of trees yields the maximum burn time?
   
   The maximum burn time seems to come when the density lies between 60% and 61%.

    ## 500x500 100 times
    | Density        | Tick Count           |
    | -------------  |:-------------:|
    | 5%             | 1.87          |
    | 10%            | 3.0           |
    | 15%            | 4.35          |
    | 20%            | 5.58          |
    | 25%            | 7.66          |
    | 30%            | 10.25         |
    | 35%            | 13.63         |
    | 40%            | 18.69         |
    | 45%            | 28.69         |
    | 50%            | 50.14         |
    | 55%            | 129.86        |
    | 60%            | 1271.34       |
    | 65%            | 766.91        |
    | 70%            | 669.71        |
    | 75%            | 619.7         |
    | 80%            | 584.73        |
    | 85%            | 558.57        |
    | 90%            | 538.0         |
    | 95%            | 528.0         |

    ## 500x500 100 times on optimal range
    | Density        | Tick Count           |
    | -------------  |:-------------:|
    | 55%            | 132.11        |
    | 56%            | 144.1         |
    | 57%            | 217.66        |
    | 58%            | 462.13        |
    | 59%            | 911.34        |
    | 60%            | 1257.86       |
    | 61%            | 1071.62       |
    | 62%            | 928.31        |
    | 63%            | 863.49        |
    | 64%            | 802.36        |
    | 65%            | 768.45        |





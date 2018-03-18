# Sorting tree 
> Algorithm for constructing a decision tree for sorting fixed-sized sets

## How to use

Clone the repo. Compile and run `Main` class.

## What it does

This algorithm constructs a binary tree that represents all ways to sort a set of elements. 
Every inner node of the tree holds a pair of indexes of elements to be compared. To sort a set, one 
should start in the root of the tree and traverse to the leaves choosing children based on result of
comparisons. Every leaf of the tree holds a permutation which can be used on the set to be 
converted into ordered sequence. 

Example: `n = 3`
```
if 0 < 1:
  if 1 < 2:
    (0, 1, 2)
  else:
    if 0 < 2:
      (0, 2, 1)
    else:
      (2, 0, 1)
else:
  if 0 < 2:
    if 1 < 0:
      (1, 0, 2)
    else:
      (0, 1, 2)
  else:
    if 1 < 2:
      (1, 2, 0)
    else:
      (2, 1, 0)
```
In this representation of the tree every if statement represents an inner node with two children.
Lines of form  (a, b, c) represent final permutations. 

> It is obvious that such tree is equivalent to a sorting algorithm.

This algorithm is based on bubble sort algorithm, which has worst-case scenario time complexity of 
![O(n^2)](https://latex.codecogs.com/gif.latex?O(n^2)). Equivalently the sorting decision tree has 
maximum height of ![n^2](https://latex.codecogs.com/gif.latex?n^2) and time complexity of 
sorting with such tree is ![O(n^2)](https://latex.codecogs.com/gif.latex?O(n^2)). 
Number of nodes in such tree is 
![\theta(2^{n^2})](https://latex.codecogs.com/gif.latex?\theta(2^{n^2}))

If a better base sorting algorithm would be used, space complexity could be reduced to 
![\theta(2^{n\cdot log n})](https://latex.codecogs.com/gif.latex?\theta(2^{n\cdot&space;log&space;n})) 
and time complexity of sorting to 
![\theta(n\cdot log n)](https://latex.codecogs.com/gif.latex?\theta(n\cdot&space;log&space;n)). 

Another downside is the fact that a single tree is constructed for sorting only a sets with n 
elements. To sort sets of size different than n, new tree should be constructed.

## Conclusion

There is no practical upsides to using such sorting trees for actual sorting instead of 
traditional sorting algorithms. 

They are only meant to visualise complexity of sorting problems.

## Example

`n = 5`
```
Constructing decision tree with height 10.
Construction complete. Nodes: 1501
Sorted test set: [4, 31, 67, 636, 821]

Tree representation:
if 0 < 1:
  if 1 < 2:
    if 2 < 3:
      if 3 < 4:
        (0, 1, 2, 3, 4)
      else:
        if 0 < 1:
          if 1 < 2:
            if 2 < 4:
              (0, 1, 2, 4, 3)
            else:
              if 0 < 1:
                if 1 < 4:
                  (0, 1, 4, 2, 3)
                else:
                  if 0 < 4:
                    (0, 4, 1, 2, 3)
                  else:
                    (4, 0, 1, 2, 3)
              else:
                if 0 < 4:
                  if 1 < 0:
                    (1, 0, 4, 2, 3)
                  else:
                    (0, 1, 4, 2, 3)
                else:
                  if 1 < 4:
                    (1, 4, 0, 2, 3)
                  else:
                    (4, 1, 0, 2, 3)
          else:
            if 1 < 4:
              if 0 < 2:
                if 2 < 1:
                  (0, 2, 1, 4, 3)
                else:
                  if 0 < 1:
                    (0, 1, 2, 4, 3)
                  else:
                    (1, 0, 2, 4, 3)
              else:
                if 0 < 1:
                  if 2 < 0:
                    (2, 0, 1, 4, 3)
                  else:
                    (0, 2, 1, 4, 3)
                else:
                  if 2 < 1:
                    (2, 1, 0, 4, 3)
                  else:
                    (1, 2, 0, 4, 3)
            else:
              if 0 < 2:
                if 2 < 4:
                  (0, 2, 4, 1, 3)
                else:
                  if 0 < 4:
                    (0, 4, 2, 1, 3)
                  else:
                    (4, 0, 2, 1, 3)
              else:
                if 0 < 4:
                  if 2 < 0:
                    (2, 0, 4, 1, 3)
                  else:
                    (0, 2, 4, 1, 3)
                else:
                  if 2 < 4:
                    (2, 4, 0, 1, 3)
                  else:
                    (4, 2, 0, 1, 3)
        else:
          if 0 < 2:
            if 2 < 4:
              if 1 < 0:
                if 0 < 2:
                  (1, 0, 2, 4, 3)
                else:
                  if 1 < 2:
                    (1, 2, 0, 4, 3)
                  else:
                    (2, 1, 0, 4, 3)
              else:
                if 1 < 2:
                  if 0 < 1:
                    (0, 1, 2, 4, 3)
                  else:
                    (1, 0, 2, 4, 3)
                else:
                  if 0 < 2:
                    (0, 2, 1, 4, 3)
                  else:
                    (2, 0, 1, 4, 3)
            else:
              if 1 < 0:
                if 0 < 4:
                  (1, 0, 4, 2, 3)
                else:
                  if 1 < 4:
                    (1, 4, 0, 2, 3)
                  else:
                    (4, 1, 0, 2, 3)
              else:
                if 1 < 4:
                  if 0 < 1:
                    (0, 1, 4, 2, 3)
                  else:
                    (1, 0, 4, 2, 3)
                else:
                  if 0 < 4:
                    (0, 4, 1, 2, 3)
                  else:
                    (4, 0, 1, 2, 3)
          else:
            if 0 < 4:
              if 1 < 2:
                if 2 < 0:
                  (1, 2, 0, 4, 3)
                else:
                  if 1 < 0:
                    (1, 0, 2, 4, 3)
                  else:
                    (0, 1, 2, 4, 3)
              else:
                if 1 < 0:
                  if 2 < 1:
                    (2, 1, 0, 4, 3)
                  else:
                    (1, 2, 0, 4, 3)
                else:
                  if 2 < 0:
                    (2, 0, 1, 4, 3)
                  else:
                    (0, 2, 1, 4, 3)
            else:
              if 1 < 2:
                if 2 < 4:
                  (1, 2, 4, 0, 3)
                else:
                  if 1 < 4:
                    (1, 4, 2, 0, 3)
                  else:
                    (4, 1, 2, 0, 3)
              else:
                if 1 < 4:
                  if 2 < 1:
                    (2, 1, 4, 0, 3)
                  else:
                    (1, 2, 4, 0, 3)
                else:
                  if 2 < 4:
                    (2, 4, 1, 0, 3)
                  else:
                    (4, 2, 1, 0, 3)
    else:
      if 2 < 4:
        if 0 < 1:
          if 1 < 3:
            if 3 < 2:
              (0, 1, 3, 2, 4)
            else:
              if 0 < 1:
                if 1 < 2:
                  (0, 1, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
              else:
                if 0 < 2:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
          else:
            if 1 < 2:
              if 0 < 3:
                if 3 < 1:
                  (0, 3, 1, 2, 4)
                else:
                  if 0 < 1:
                    (0, 1, 3, 2, 4)
                  else:
                    (1, 0, 3, 2, 4)
              else:
                if 0 < 1:
                  if 3 < 0:
                    (3, 0, 1, 2, 4)
                  else:
                    (0, 3, 1, 2, 4)
                else:
                  if 3 < 1:
                    (3, 1, 0, 2, 4)
                  else:
                    (1, 3, 0, 2, 4)
            else:
              if 0 < 3:
                if 3 < 2:
                  (0, 3, 2, 1, 4)
                else:
                  if 0 < 2:
                    (0, 2, 3, 1, 4)
                  else:
                    (2, 0, 3, 1, 4)
              else:
                if 0 < 2:
                  if 3 < 0:
                    (3, 0, 2, 1, 4)
                  else:
                    (0, 3, 2, 1, 4)
                else:
                  if 3 < 2:
                    (3, 2, 0, 1, 4)
                  else:
                    (2, 3, 0, 1, 4)
        else:
          if 0 < 3:
            if 3 < 2:
              if 1 < 0:
                if 0 < 3:
                  (1, 0, 3, 2, 4)
                else:
                  if 1 < 3:
                    (1, 3, 0, 2, 4)
                  else:
                    (3, 1, 0, 2, 4)
              else:
                if 1 < 3:
                  if 0 < 1:
                    (0, 1, 3, 2, 4)
                  else:
                    (1, 0, 3, 2, 4)
                else:
                  if 0 < 3:
                    (0, 3, 1, 2, 4)
                  else:
                    (3, 0, 1, 2, 4)
            else:
              if 1 < 0:
                if 0 < 2:
                  (1, 0, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
              else:
                if 1 < 2:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
          else:
            if 0 < 2:
              if 1 < 3:
                if 3 < 0:
                  (1, 3, 0, 2, 4)
                else:
                  if 1 < 0:
                    (1, 0, 3, 2, 4)
                  else:
                    (0, 1, 3, 2, 4)
              else:
                if 1 < 0:
                  if 3 < 1:
                    (3, 1, 0, 2, 4)
                  else:
                    (1, 3, 0, 2, 4)
                else:
                  if 3 < 0:
                    (3, 0, 1, 2, 4)
                  else:
                    (0, 3, 1, 2, 4)
            else:
              if 1 < 3:
                if 3 < 2:
                  (1, 3, 2, 0, 4)
                else:
                  if 1 < 2:
                    (1, 2, 3, 0, 4)
                  else:
                    (2, 1, 3, 0, 4)
              else:
                if 1 < 2:
                  if 3 < 1:
                    (3, 1, 2, 0, 4)
                  else:
                    (1, 3, 2, 0, 4)
                else:
                  if 3 < 2:
                    (3, 2, 1, 0, 4)
                  else:
                    (2, 3, 1, 0, 4)
      else:
        if 0 < 1:
          if 1 < 3:
            if 3 < 4:
              (0, 1, 3, 4, 2)
            else:
              if 0 < 1:
                if 1 < 4:
                  (0, 1, 4, 3, 2)
                else:
                  if 0 < 4:
                    (0, 4, 1, 3, 2)
                  else:
                    (4, 0, 1, 3, 2)
              else:
                if 0 < 4:
                  if 1 < 0:
                    (1, 0, 4, 3, 2)
                  else:
                    (0, 1, 4, 3, 2)
                else:
                  if 1 < 4:
                    (1, 4, 0, 3, 2)
                  else:
                    (4, 1, 0, 3, 2)
          else:
            if 1 < 4:
              if 0 < 3:
                if 3 < 1:
                  (0, 3, 1, 4, 2)
                else:
                  if 0 < 1:
                    (0, 1, 3, 4, 2)
                  else:
                    (1, 0, 3, 4, 2)
              else:
                if 0 < 1:
                  if 3 < 0:
                    (3, 0, 1, 4, 2)
                  else:
                    (0, 3, 1, 4, 2)
                else:
                  if 3 < 1:
                    (3, 1, 0, 4, 2)
                  else:
                    (1, 3, 0, 4, 2)
            else:
              if 0 < 3:
                if 3 < 4:
                  (0, 3, 4, 1, 2)
                else:
                  if 0 < 4:
                    (0, 4, 3, 1, 2)
                  else:
                    (4, 0, 3, 1, 2)
              else:
                if 0 < 4:
                  if 3 < 0:
                    (3, 0, 4, 1, 2)
                  else:
                    (0, 3, 4, 1, 2)
                else:
                  if 3 < 4:
                    (3, 4, 0, 1, 2)
                  else:
                    (4, 3, 0, 1, 2)
        else:
          if 0 < 3:
            if 3 < 4:
              if 1 < 0:
                if 0 < 3:
                  (1, 0, 3, 4, 2)
                else:
                  if 1 < 3:
                    (1, 3, 0, 4, 2)
                  else:
                    (3, 1, 0, 4, 2)
              else:
                if 1 < 3:
                  if 0 < 1:
                    (0, 1, 3, 4, 2)
                  else:
                    (1, 0, 3, 4, 2)
                else:
                  if 0 < 3:
                    (0, 3, 1, 4, 2)
                  else:
                    (3, 0, 1, 4, 2)
            else:
              if 1 < 0:
                if 0 < 4:
                  (1, 0, 4, 3, 2)
                else:
                  if 1 < 4:
                    (1, 4, 0, 3, 2)
                  else:
                    (4, 1, 0, 3, 2)
              else:
                if 1 < 4:
                  if 0 < 1:
                    (0, 1, 4, 3, 2)
                  else:
                    (1, 0, 4, 3, 2)
                else:
                  if 0 < 4:
                    (0, 4, 1, 3, 2)
                  else:
                    (4, 0, 1, 3, 2)
          else:
            if 0 < 4:
              if 1 < 3:
                if 3 < 0:
                  (1, 3, 0, 4, 2)
                else:
                  if 1 < 0:
                    (1, 0, 3, 4, 2)
                  else:
                    (0, 1, 3, 4, 2)
              else:
                if 1 < 0:
                  if 3 < 1:
                    (3, 1, 0, 4, 2)
                  else:
                    (1, 3, 0, 4, 2)
                else:
                  if 3 < 0:
                    (3, 0, 1, 4, 2)
                  else:
                    (0, 3, 1, 4, 2)
            else:
              if 1 < 3:
                if 3 < 4:
                  (1, 3, 4, 0, 2)
                else:
                  if 1 < 4:
                    (1, 4, 3, 0, 2)
                  else:
                    (4, 1, 3, 0, 2)
              else:
                if 1 < 4:
                  if 3 < 1:
                    (3, 1, 4, 0, 2)
                  else:
                    (1, 3, 4, 0, 2)
                else:
                  if 3 < 4:
                    (3, 4, 1, 0, 2)
                  else:
                    (4, 3, 1, 0, 2)
  else:
    if 1 < 3:
      if 3 < 4:
        if 0 < 2:
          if 2 < 1:
            if 1 < 3:
              (0, 2, 1, 3, 4)
            else:
              if 0 < 2:
                if 2 < 3:
                  (0, 2, 3, 1, 4)
                else:
                  if 0 < 3:
                    (0, 3, 2, 1, 4)
                  else:
                    (3, 0, 2, 1, 4)
              else:
                if 0 < 3:
                  if 2 < 0:
                    (2, 0, 3, 1, 4)
                  else:
                    (0, 2, 3, 1, 4)
                else:
                  if 2 < 3:
                    (2, 3, 0, 1, 4)
                  else:
                    (3, 2, 0, 1, 4)
          else:
            if 2 < 3:
              if 0 < 1:
                if 1 < 2:
                  (0, 1, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
              else:
                if 0 < 2:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
            else:
              if 0 < 1:
                if 1 < 3:
                  (0, 1, 3, 2, 4)
                else:
                  if 0 < 3:
                    (0, 3, 1, 2, 4)
                  else:
                    (3, 0, 1, 2, 4)
              else:
                if 0 < 3:
                  if 1 < 0:
                    (1, 0, 3, 2, 4)
                  else:
                    (0, 1, 3, 2, 4)
                else:
                  if 1 < 3:
                    (1, 3, 0, 2, 4)
                  else:
                    (3, 1, 0, 2, 4)
        else:
          if 0 < 1:
            if 1 < 3:
              if 2 < 0:
                if 0 < 1:
                  (2, 0, 1, 3, 4)
                else:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
              else:
                if 2 < 1:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
                else:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
            else:
              if 2 < 0:
                if 0 < 3:
                  (2, 0, 3, 1, 4)
                else:
                  if 2 < 3:
                    (2, 3, 0, 1, 4)
                  else:
                    (3, 2, 0, 1, 4)
              else:
                if 2 < 3:
                  if 0 < 2:
                    (0, 2, 3, 1, 4)
                  else:
                    (2, 0, 3, 1, 4)
                else:
                  if 0 < 3:
                    (0, 3, 2, 1, 4)
                  else:
                    (3, 0, 2, 1, 4)
          else:
            if 0 < 3:
              if 2 < 1:
                if 1 < 0:
                  (2, 1, 0, 3, 4)
                else:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
              else:
                if 2 < 0:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
                else:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
            else:
              if 2 < 1:
                if 1 < 3:
                  (2, 1, 3, 0, 4)
                else:
                  if 2 < 3:
                    (2, 3, 1, 0, 4)
                  else:
                    (3, 2, 1, 0, 4)
              else:
                if 2 < 3:
                  if 1 < 2:
                    (1, 2, 3, 0, 4)
                  else:
                    (2, 1, 3, 0, 4)
                else:
                  if 1 < 3:
                    (1, 3, 2, 0, 4)
                  else:
                    (3, 1, 2, 0, 4)
      else:
        if 0 < 2:
          if 2 < 1:
            if 1 < 4:
              (0, 2, 1, 4, 3)
            else:
              if 0 < 2:
                if 2 < 4:
                  (0, 2, 4, 1, 3)
                else:
                  if 0 < 4:
                    (0, 4, 2, 1, 3)
                  else:
                    (4, 0, 2, 1, 3)
              else:
                if 0 < 4:
                  if 2 < 0:
                    (2, 0, 4, 1, 3)
                  else:
                    (0, 2, 4, 1, 3)
                else:
                  if 2 < 4:
                    (2, 4, 0, 1, 3)
                  else:
                    (4, 2, 0, 1, 3)
          else:
            if 2 < 4:
              if 0 < 1:
                if 1 < 2:
                  (0, 1, 2, 4, 3)
                else:
                  if 0 < 2:
                    (0, 2, 1, 4, 3)
                  else:
                    (2, 0, 1, 4, 3)
              else:
                if 0 < 2:
                  if 1 < 0:
                    (1, 0, 2, 4, 3)
                  else:
                    (0, 1, 2, 4, 3)
                else:
                  if 1 < 2:
                    (1, 2, 0, 4, 3)
                  else:
                    (2, 1, 0, 4, 3)
            else:
              if 0 < 1:
                if 1 < 4:
                  (0, 1, 4, 2, 3)
                else:
                  if 0 < 4:
                    (0, 4, 1, 2, 3)
                  else:
                    (4, 0, 1, 2, 3)
              else:
                if 0 < 4:
                  if 1 < 0:
                    (1, 0, 4, 2, 3)
                  else:
                    (0, 1, 4, 2, 3)
                else:
                  if 1 < 4:
                    (1, 4, 0, 2, 3)
                  else:
                    (4, 1, 0, 2, 3)
        else:
          if 0 < 1:
            if 1 < 4:
              if 2 < 0:
                if 0 < 1:
                  (2, 0, 1, 4, 3)
                else:
                  if 2 < 1:
                    (2, 1, 0, 4, 3)
                  else:
                    (1, 2, 0, 4, 3)
              else:
                if 2 < 1:
                  if 0 < 2:
                    (0, 2, 1, 4, 3)
                  else:
                    (2, 0, 1, 4, 3)
                else:
                  if 0 < 1:
                    (0, 1, 2, 4, 3)
                  else:
                    (1, 0, 2, 4, 3)
            else:
              if 2 < 0:
                if 0 < 4:
                  (2, 0, 4, 1, 3)
                else:
                  if 2 < 4:
                    (2, 4, 0, 1, 3)
                  else:
                    (4, 2, 0, 1, 3)
              else:
                if 2 < 4:
                  if 0 < 2:
                    (0, 2, 4, 1, 3)
                  else:
                    (2, 0, 4, 1, 3)
                else:
                  if 0 < 4:
                    (0, 4, 2, 1, 3)
                  else:
                    (4, 0, 2, 1, 3)
          else:
            if 0 < 4:
              if 2 < 1:
                if 1 < 0:
                  (2, 1, 0, 4, 3)
                else:
                  if 2 < 0:
                    (2, 0, 1, 4, 3)
                  else:
                    (0, 2, 1, 4, 3)
              else:
                if 2 < 0:
                  if 1 < 2:
                    (1, 2, 0, 4, 3)
                  else:
                    (2, 1, 0, 4, 3)
                else:
                  if 1 < 0:
                    (1, 0, 2, 4, 3)
                  else:
                    (0, 1, 2, 4, 3)
            else:
              if 2 < 1:
                if 1 < 4:
                  (2, 1, 4, 0, 3)
                else:
                  if 2 < 4:
                    (2, 4, 1, 0, 3)
                  else:
                    (4, 2, 1, 0, 3)
              else:
                if 2 < 4:
                  if 1 < 2:
                    (1, 2, 4, 0, 3)
                  else:
                    (2, 1, 4, 0, 3)
                else:
                  if 1 < 4:
                    (1, 4, 2, 0, 3)
                  else:
                    (4, 1, 2, 0, 3)
    else:
      if 1 < 4:
        if 0 < 2:
          if 2 < 3:
            if 3 < 1:
              (0, 2, 3, 1, 4)
            else:
              if 0 < 2:
                if 2 < 1:
                  (0, 2, 1, 3, 4)
                else:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
              else:
                if 0 < 1:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
                else:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
          else:
            if 2 < 1:
              if 0 < 3:
                if 3 < 2:
                  (0, 3, 2, 1, 4)
                else:
                  if 0 < 2:
                    (0, 2, 3, 1, 4)
                  else:
                    (2, 0, 3, 1, 4)
              else:
                if 0 < 2:
                  if 3 < 0:
                    (3, 0, 2, 1, 4)
                  else:
                    (0, 3, 2, 1, 4)
                else:
                  if 3 < 2:
                    (3, 2, 0, 1, 4)
                  else:
                    (2, 3, 0, 1, 4)
            else:
              if 0 < 3:
                if 3 < 1:
                  (0, 3, 1, 2, 4)
                else:
                  if 0 < 1:
                    (0, 1, 3, 2, 4)
                  else:
                    (1, 0, 3, 2, 4)
              else:
                if 0 < 1:
                  if 3 < 0:
                    (3, 0, 1, 2, 4)
                  else:
                    (0, 3, 1, 2, 4)
                else:
                  if 3 < 1:
                    (3, 1, 0, 2, 4)
                  else:
                    (1, 3, 0, 2, 4)
        else:
          if 0 < 3:
            if 3 < 1:
              if 2 < 0:
                if 0 < 3:
                  (2, 0, 3, 1, 4)
                else:
                  if 2 < 3:
                    (2, 3, 0, 1, 4)
                  else:
                    (3, 2, 0, 1, 4)
              else:
                if 2 < 3:
                  if 0 < 2:
                    (0, 2, 3, 1, 4)
                  else:
                    (2, 0, 3, 1, 4)
                else:
                  if 0 < 3:
                    (0, 3, 2, 1, 4)
                  else:
                    (3, 0, 2, 1, 4)
            else:
              if 2 < 0:
                if 0 < 1:
                  (2, 0, 1, 3, 4)
                else:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
              else:
                if 2 < 1:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
                else:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
          else:
            if 0 < 1:
              if 2 < 3:
                if 3 < 0:
                  (2, 3, 0, 1, 4)
                else:
                  if 2 < 0:
                    (2, 0, 3, 1, 4)
                  else:
                    (0, 2, 3, 1, 4)
              else:
                if 2 < 0:
                  if 3 < 2:
                    (3, 2, 0, 1, 4)
                  else:
                    (2, 3, 0, 1, 4)
                else:
                  if 3 < 0:
                    (3, 0, 2, 1, 4)
                  else:
                    (0, 3, 2, 1, 4)
            else:
              if 2 < 3:
                if 3 < 1:
                  (2, 3, 1, 0, 4)
                else:
                  if 2 < 1:
                    (2, 1, 3, 0, 4)
                  else:
                    (1, 2, 3, 0, 4)
              else:
                if 2 < 1:
                  if 3 < 2:
                    (3, 2, 1, 0, 4)
                  else:
                    (2, 3, 1, 0, 4)
                else:
                  if 3 < 1:
                    (3, 1, 2, 0, 4)
                  else:
                    (1, 3, 2, 0, 4)
      else:
        if 0 < 2:
          if 2 < 3:
            if 3 < 4:
              (0, 2, 3, 4, 1)
            else:
              if 0 < 2:
                if 2 < 4:
                  (0, 2, 4, 3, 1)
                else:
                  if 0 < 4:
                    (0, 4, 2, 3, 1)
                  else:
                    (4, 0, 2, 3, 1)
              else:
                if 0 < 4:
                  if 2 < 0:
                    (2, 0, 4, 3, 1)
                  else:
                    (0, 2, 4, 3, 1)
                else:
                  if 2 < 4:
                    (2, 4, 0, 3, 1)
                  else:
                    (4, 2, 0, 3, 1)
          else:
            if 2 < 4:
              if 0 < 3:
                if 3 < 2:
                  (0, 3, 2, 4, 1)
                else:
                  if 0 < 2:
                    (0, 2, 3, 4, 1)
                  else:
                    (2, 0, 3, 4, 1)
              else:
                if 0 < 2:
                  if 3 < 0:
                    (3, 0, 2, 4, 1)
                  else:
                    (0, 3, 2, 4, 1)
                else:
                  if 3 < 2:
                    (3, 2, 0, 4, 1)
                  else:
                    (2, 3, 0, 4, 1)
            else:
              if 0 < 3:
                if 3 < 4:
                  (0, 3, 4, 2, 1)
                else:
                  if 0 < 4:
                    (0, 4, 3, 2, 1)
                  else:
                    (4, 0, 3, 2, 1)
              else:
                if 0 < 4:
                  if 3 < 0:
                    (3, 0, 4, 2, 1)
                  else:
                    (0, 3, 4, 2, 1)
                else:
                  if 3 < 4:
                    (3, 4, 0, 2, 1)
                  else:
                    (4, 3, 0, 2, 1)
        else:
          if 0 < 3:
            if 3 < 4:
              if 2 < 0:
                if 0 < 3:
                  (2, 0, 3, 4, 1)
                else:
                  if 2 < 3:
                    (2, 3, 0, 4, 1)
                  else:
                    (3, 2, 0, 4, 1)
              else:
                if 2 < 3:
                  if 0 < 2:
                    (0, 2, 3, 4, 1)
                  else:
                    (2, 0, 3, 4, 1)
                else:
                  if 0 < 3:
                    (0, 3, 2, 4, 1)
                  else:
                    (3, 0, 2, 4, 1)
            else:
              if 2 < 0:
                if 0 < 4:
                  (2, 0, 4, 3, 1)
                else:
                  if 2 < 4:
                    (2, 4, 0, 3, 1)
                  else:
                    (4, 2, 0, 3, 1)
              else:
                if 2 < 4:
                  if 0 < 2:
                    (0, 2, 4, 3, 1)
                  else:
                    (2, 0, 4, 3, 1)
                else:
                  if 0 < 4:
                    (0, 4, 2, 3, 1)
                  else:
                    (4, 0, 2, 3, 1)
          else:
            if 0 < 4:
              if 2 < 3:
                if 3 < 0:
                  (2, 3, 0, 4, 1)
                else:
                  if 2 < 0:
                    (2, 0, 3, 4, 1)
                  else:
                    (0, 2, 3, 4, 1)
              else:
                if 2 < 0:
                  if 3 < 2:
                    (3, 2, 0, 4, 1)
                  else:
                    (2, 3, 0, 4, 1)
                else:
                  if 3 < 0:
                    (3, 0, 2, 4, 1)
                  else:
                    (0, 3, 2, 4, 1)
            else:
              if 2 < 3:
                if 3 < 4:
                  (2, 3, 4, 0, 1)
                else:
                  if 2 < 4:
                    (2, 4, 3, 0, 1)
                  else:
                    (4, 2, 3, 0, 1)
              else:
                if 2 < 4:
                  if 3 < 2:
                    (3, 2, 4, 0, 1)
                  else:
                    (2, 3, 4, 0, 1)
                else:
                  if 3 < 4:
                    (3, 4, 2, 0, 1)
                  else:
                    (4, 3, 2, 0, 1)
else:
  if 0 < 2:
    if 2 < 3:
      if 3 < 4:
        if 1 < 0:
          if 0 < 2:
            if 2 < 3:
              (1, 0, 2, 3, 4)
            else:
              if 1 < 0:
                if 0 < 3:
                  (1, 0, 3, 2, 4)
                else:
                  if 1 < 3:
                    (1, 3, 0, 2, 4)
                  else:
                    (3, 1, 0, 2, 4)
              else:
                if 1 < 3:
                  if 0 < 1:
                    (0, 1, 3, 2, 4)
                  else:
                    (1, 0, 3, 2, 4)
                else:
                  if 0 < 3:
                    (0, 3, 1, 2, 4)
                  else:
                    (3, 0, 1, 2, 4)
          else:
            if 0 < 3:
              if 1 < 2:
                if 2 < 0:
                  (1, 2, 0, 3, 4)
                else:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
              else:
                if 1 < 0:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
                else:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
            else:
              if 1 < 2:
                if 2 < 3:
                  (1, 2, 3, 0, 4)
                else:
                  if 1 < 3:
                    (1, 3, 2, 0, 4)
                  else:
                    (3, 1, 2, 0, 4)
              else:
                if 1 < 3:
                  if 2 < 1:
                    (2, 1, 3, 0, 4)
                  else:
                    (1, 2, 3, 0, 4)
                else:
                  if 2 < 3:
                    (2, 3, 1, 0, 4)
                  else:
                    (3, 2, 1, 0, 4)
        else:
          if 1 < 2:
            if 2 < 3:
              if 0 < 1:
                if 1 < 2:
                  (0, 1, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
              else:
                if 0 < 2:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
            else:
              if 0 < 1:
                if 1 < 3:
                  (0, 1, 3, 2, 4)
                else:
                  if 0 < 3:
                    (0, 3, 1, 2, 4)
                  else:
                    (3, 0, 1, 2, 4)
              else:
                if 0 < 3:
                  if 1 < 0:
                    (1, 0, 3, 2, 4)
                  else:
                    (0, 1, 3, 2, 4)
                else:
                  if 1 < 3:
                    (1, 3, 0, 2, 4)
                  else:
                    (3, 1, 0, 2, 4)
          else:
            if 1 < 3:
              if 0 < 2:
                if 2 < 1:
                  (0, 2, 1, 3, 4)
                else:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
              else:
                if 0 < 1:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
                else:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
            else:
              if 0 < 2:
                if 2 < 3:
                  (0, 2, 3, 1, 4)
                else:
                  if 0 < 3:
                    (0, 3, 2, 1, 4)
                  else:
                    (3, 0, 2, 1, 4)
              else:
                if 0 < 3:
                  if 2 < 0:
                    (2, 0, 3, 1, 4)
                  else:
                    (0, 2, 3, 1, 4)
                else:
                  if 2 < 3:
                    (2, 3, 0, 1, 4)
                  else:
                    (3, 2, 0, 1, 4)
      else:
        if 1 < 0:
          if 0 < 2:
            if 2 < 4:
              (1, 0, 2, 4, 3)
            else:
              if 1 < 0:
                if 0 < 4:
                  (1, 0, 4, 2, 3)
                else:
                  if 1 < 4:
                    (1, 4, 0, 2, 3)
                  else:
                    (4, 1, 0, 2, 3)
              else:
                if 1 < 4:
                  if 0 < 1:
                    (0, 1, 4, 2, 3)
                  else:
                    (1, 0, 4, 2, 3)
                else:
                  if 0 < 4:
                    (0, 4, 1, 2, 3)
                  else:
                    (4, 0, 1, 2, 3)
          else:
            if 0 < 4:
              if 1 < 2:
                if 2 < 0:
                  (1, 2, 0, 4, 3)
                else:
                  if 1 < 0:
                    (1, 0, 2, 4, 3)
                  else:
                    (0, 1, 2, 4, 3)
              else:
                if 1 < 0:
                  if 2 < 1:
                    (2, 1, 0, 4, 3)
                  else:
                    (1, 2, 0, 4, 3)
                else:
                  if 2 < 0:
                    (2, 0, 1, 4, 3)
                  else:
                    (0, 2, 1, 4, 3)
            else:
              if 1 < 2:
                if 2 < 4:
                  (1, 2, 4, 0, 3)
                else:
                  if 1 < 4:
                    (1, 4, 2, 0, 3)
                  else:
                    (4, 1, 2, 0, 3)
              else:
                if 1 < 4:
                  if 2 < 1:
                    (2, 1, 4, 0, 3)
                  else:
                    (1, 2, 4, 0, 3)
                else:
                  if 2 < 4:
                    (2, 4, 1, 0, 3)
                  else:
                    (4, 2, 1, 0, 3)
        else:
          if 1 < 2:
            if 2 < 4:
              if 0 < 1:
                if 1 < 2:
                  (0, 1, 2, 4, 3)
                else:
                  if 0 < 2:
                    (0, 2, 1, 4, 3)
                  else:
                    (2, 0, 1, 4, 3)
              else:
                if 0 < 2:
                  if 1 < 0:
                    (1, 0, 2, 4, 3)
                  else:
                    (0, 1, 2, 4, 3)
                else:
                  if 1 < 2:
                    (1, 2, 0, 4, 3)
                  else:
                    (2, 1, 0, 4, 3)
            else:
              if 0 < 1:
                if 1 < 4:
                  (0, 1, 4, 2, 3)
                else:
                  if 0 < 4:
                    (0, 4, 1, 2, 3)
                  else:
                    (4, 0, 1, 2, 3)
              else:
                if 0 < 4:
                  if 1 < 0:
                    (1, 0, 4, 2, 3)
                  else:
                    (0, 1, 4, 2, 3)
                else:
                  if 1 < 4:
                    (1, 4, 0, 2, 3)
                  else:
                    (4, 1, 0, 2, 3)
          else:
            if 1 < 4:
              if 0 < 2:
                if 2 < 1:
                  (0, 2, 1, 4, 3)
                else:
                  if 0 < 1:
                    (0, 1, 2, 4, 3)
                  else:
                    (1, 0, 2, 4, 3)
              else:
                if 0 < 1:
                  if 2 < 0:
                    (2, 0, 1, 4, 3)
                  else:
                    (0, 2, 1, 4, 3)
                else:
                  if 2 < 1:
                    (2, 1, 0, 4, 3)
                  else:
                    (1, 2, 0, 4, 3)
            else:
              if 0 < 2:
                if 2 < 4:
                  (0, 2, 4, 1, 3)
                else:
                  if 0 < 4:
                    (0, 4, 2, 1, 3)
                  else:
                    (4, 0, 2, 1, 3)
              else:
                if 0 < 4:
                  if 2 < 0:
                    (2, 0, 4, 1, 3)
                  else:
                    (0, 2, 4, 1, 3)
                else:
                  if 2 < 4:
                    (2, 4, 0, 1, 3)
                  else:
                    (4, 2, 0, 1, 3)
    else:
      if 2 < 4:
        if 1 < 0:
          if 0 < 3:
            if 3 < 2:
              (1, 0, 3, 2, 4)
            else:
              if 1 < 0:
                if 0 < 2:
                  (1, 0, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
              else:
                if 1 < 2:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
          else:
            if 0 < 2:
              if 1 < 3:
                if 3 < 0:
                  (1, 3, 0, 2, 4)
                else:
                  if 1 < 0:
                    (1, 0, 3, 2, 4)
                  else:
                    (0, 1, 3, 2, 4)
              else:
                if 1 < 0:
                  if 3 < 1:
                    (3, 1, 0, 2, 4)
                  else:
                    (1, 3, 0, 2, 4)
                else:
                  if 3 < 0:
                    (3, 0, 1, 2, 4)
                  else:
                    (0, 3, 1, 2, 4)
            else:
              if 1 < 3:
                if 3 < 2:
                  (1, 3, 2, 0, 4)
                else:
                  if 1 < 2:
                    (1, 2, 3, 0, 4)
                  else:
                    (2, 1, 3, 0, 4)
              else:
                if 1 < 2:
                  if 3 < 1:
                    (3, 1, 2, 0, 4)
                  else:
                    (1, 3, 2, 0, 4)
                else:
                  if 3 < 2:
                    (3, 2, 1, 0, 4)
                  else:
                    (2, 3, 1, 0, 4)
        else:
          if 1 < 3:
            if 3 < 2:
              if 0 < 1:
                if 1 < 3:
                  (0, 1, 3, 2, 4)
                else:
                  if 0 < 3:
                    (0, 3, 1, 2, 4)
                  else:
                    (3, 0, 1, 2, 4)
              else:
                if 0 < 3:
                  if 1 < 0:
                    (1, 0, 3, 2, 4)
                  else:
                    (0, 1, 3, 2, 4)
                else:
                  if 1 < 3:
                    (1, 3, 0, 2, 4)
                  else:
                    (3, 1, 0, 2, 4)
            else:
              if 0 < 1:
                if 1 < 2:
                  (0, 1, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
              else:
                if 0 < 2:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
          else:
            if 1 < 2:
              if 0 < 3:
                if 3 < 1:
                  (0, 3, 1, 2, 4)
                else:
                  if 0 < 1:
                    (0, 1, 3, 2, 4)
                  else:
                    (1, 0, 3, 2, 4)
              else:
                if 0 < 1:
                  if 3 < 0:
                    (3, 0, 1, 2, 4)
                  else:
                    (0, 3, 1, 2, 4)
                else:
                  if 3 < 1:
                    (3, 1, 0, 2, 4)
                  else:
                    (1, 3, 0, 2, 4)
            else:
              if 0 < 3:
                if 3 < 2:
                  (0, 3, 2, 1, 4)
                else:
                  if 0 < 2:
                    (0, 2, 3, 1, 4)
                  else:
                    (2, 0, 3, 1, 4)
              else:
                if 0 < 2:
                  if 3 < 0:
                    (3, 0, 2, 1, 4)
                  else:
                    (0, 3, 2, 1, 4)
                else:
                  if 3 < 2:
                    (3, 2, 0, 1, 4)
                  else:
                    (2, 3, 0, 1, 4)
      else:
        if 1 < 0:
          if 0 < 3:
            if 3 < 4:
              (1, 0, 3, 4, 2)
            else:
              if 1 < 0:
                if 0 < 4:
                  (1, 0, 4, 3, 2)
                else:
                  if 1 < 4:
                    (1, 4, 0, 3, 2)
                  else:
                    (4, 1, 0, 3, 2)
              else:
                if 1 < 4:
                  if 0 < 1:
                    (0, 1, 4, 3, 2)
                  else:
                    (1, 0, 4, 3, 2)
                else:
                  if 0 < 4:
                    (0, 4, 1, 3, 2)
                  else:
                    (4, 0, 1, 3, 2)
          else:
            if 0 < 4:
              if 1 < 3:
                if 3 < 0:
                  (1, 3, 0, 4, 2)
                else:
                  if 1 < 0:
                    (1, 0, 3, 4, 2)
                  else:
                    (0, 1, 3, 4, 2)
              else:
                if 1 < 0:
                  if 3 < 1:
                    (3, 1, 0, 4, 2)
                  else:
                    (1, 3, 0, 4, 2)
                else:
                  if 3 < 0:
                    (3, 0, 1, 4, 2)
                  else:
                    (0, 3, 1, 4, 2)
            else:
              if 1 < 3:
                if 3 < 4:
                  (1, 3, 4, 0, 2)
                else:
                  if 1 < 4:
                    (1, 4, 3, 0, 2)
                  else:
                    (4, 1, 3, 0, 2)
              else:
                if 1 < 4:
                  if 3 < 1:
                    (3, 1, 4, 0, 2)
                  else:
                    (1, 3, 4, 0, 2)
                else:
                  if 3 < 4:
                    (3, 4, 1, 0, 2)
                  else:
                    (4, 3, 1, 0, 2)
        else:
          if 1 < 3:
            if 3 < 4:
              if 0 < 1:
                if 1 < 3:
                  (0, 1, 3, 4, 2)
                else:
                  if 0 < 3:
                    (0, 3, 1, 4, 2)
                  else:
                    (3, 0, 1, 4, 2)
              else:
                if 0 < 3:
                  if 1 < 0:
                    (1, 0, 3, 4, 2)
                  else:
                    (0, 1, 3, 4, 2)
                else:
                  if 1 < 3:
                    (1, 3, 0, 4, 2)
                  else:
                    (3, 1, 0, 4, 2)
            else:
              if 0 < 1:
                if 1 < 4:
                  (0, 1, 4, 3, 2)
                else:
                  if 0 < 4:
                    (0, 4, 1, 3, 2)
                  else:
                    (4, 0, 1, 3, 2)
              else:
                if 0 < 4:
                  if 1 < 0:
                    (1, 0, 4, 3, 2)
                  else:
                    (0, 1, 4, 3, 2)
                else:
                  if 1 < 4:
                    (1, 4, 0, 3, 2)
                  else:
                    (4, 1, 0, 3, 2)
          else:
            if 1 < 4:
              if 0 < 3:
                if 3 < 1:
                  (0, 3, 1, 4, 2)
                else:
                  if 0 < 1:
                    (0, 1, 3, 4, 2)
                  else:
                    (1, 0, 3, 4, 2)
              else:
                if 0 < 1:
                  if 3 < 0:
                    (3, 0, 1, 4, 2)
                  else:
                    (0, 3, 1, 4, 2)
                else:
                  if 3 < 1:
                    (3, 1, 0, 4, 2)
                  else:
                    (1, 3, 0, 4, 2)
            else:
              if 0 < 3:
                if 3 < 4:
                  (0, 3, 4, 1, 2)
                else:
                  if 0 < 4:
                    (0, 4, 3, 1, 2)
                  else:
                    (4, 0, 3, 1, 2)
              else:
                if 0 < 4:
                  if 3 < 0:
                    (3, 0, 4, 1, 2)
                  else:
                    (0, 3, 4, 1, 2)
                else:
                  if 3 < 4:
                    (3, 4, 0, 1, 2)
                  else:
                    (4, 3, 0, 1, 2)
  else:
    if 0 < 3:
      if 3 < 4:
        if 1 < 2:
          if 2 < 0:
            if 0 < 3:
              (1, 2, 0, 3, 4)
            else:
              if 1 < 2:
                if 2 < 3:
                  (1, 2, 3, 0, 4)
                else:
                  if 1 < 3:
                    (1, 3, 2, 0, 4)
                  else:
                    (3, 1, 2, 0, 4)
              else:
                if 1 < 3:
                  if 2 < 1:
                    (2, 1, 3, 0, 4)
                  else:
                    (1, 2, 3, 0, 4)
                else:
                  if 2 < 3:
                    (2, 3, 1, 0, 4)
                  else:
                    (3, 2, 1, 0, 4)
          else:
            if 2 < 3:
              if 1 < 0:
                if 0 < 2:
                  (1, 0, 2, 3, 4)
                else:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
              else:
                if 1 < 2:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
                else:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
            else:
              if 1 < 0:
                if 0 < 3:
                  (1, 0, 3, 2, 4)
                else:
                  if 1 < 3:
                    (1, 3, 0, 2, 4)
                  else:
                    (3, 1, 0, 2, 4)
              else:
                if 1 < 3:
                  if 0 < 1:
                    (0, 1, 3, 2, 4)
                  else:
                    (1, 0, 3, 2, 4)
                else:
                  if 0 < 3:
                    (0, 3, 1, 2, 4)
                  else:
                    (3, 0, 1, 2, 4)
        else:
          if 1 < 0:
            if 0 < 3:
              if 2 < 1:
                if 1 < 0:
                  (2, 1, 0, 3, 4)
                else:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
              else:
                if 2 < 0:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
                else:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
            else:
              if 2 < 1:
                if 1 < 3:
                  (2, 1, 3, 0, 4)
                else:
                  if 2 < 3:
                    (2, 3, 1, 0, 4)
                  else:
                    (3, 2, 1, 0, 4)
              else:
                if 2 < 3:
                  if 1 < 2:
                    (1, 2, 3, 0, 4)
                  else:
                    (2, 1, 3, 0, 4)
                else:
                  if 1 < 3:
                    (1, 3, 2, 0, 4)
                  else:
                    (3, 1, 2, 0, 4)
          else:
            if 1 < 3:
              if 2 < 0:
                if 0 < 1:
                  (2, 0, 1, 3, 4)
                else:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
              else:
                if 2 < 1:
                  if 0 < 2:
                    (0, 2, 1, 3, 4)
                  else:
                    (2, 0, 1, 3, 4)
                else:
                  if 0 < 1:
                    (0, 1, 2, 3, 4)
                  else:
                    (1, 0, 2, 3, 4)
            else:
              if 2 < 0:
                if 0 < 3:
                  (2, 0, 3, 1, 4)
                else:
                  if 2 < 3:
                    (2, 3, 0, 1, 4)
                  else:
                    (3, 2, 0, 1, 4)
              else:
                if 2 < 3:
                  if 0 < 2:
                    (0, 2, 3, 1, 4)
                  else:
                    (2, 0, 3, 1, 4)
                else:
                  if 0 < 3:
                    (0, 3, 2, 1, 4)
                  else:
                    (3, 0, 2, 1, 4)
      else:
        if 1 < 2:
          if 2 < 0:
            if 0 < 4:
              (1, 2, 0, 4, 3)
            else:
              if 1 < 2:
                if 2 < 4:
                  (1, 2, 4, 0, 3)
                else:
                  if 1 < 4:
                    (1, 4, 2, 0, 3)
                  else:
                    (4, 1, 2, 0, 3)
              else:
                if 1 < 4:
                  if 2 < 1:
                    (2, 1, 4, 0, 3)
                  else:
                    (1, 2, 4, 0, 3)
                else:
                  if 2 < 4:
                    (2, 4, 1, 0, 3)
                  else:
                    (4, 2, 1, 0, 3)
          else:
            if 2 < 4:
              if 1 < 0:
                if 0 < 2:
                  (1, 0, 2, 4, 3)
                else:
                  if 1 < 2:
                    (1, 2, 0, 4, 3)
                  else:
                    (2, 1, 0, 4, 3)
              else:
                if 1 < 2:
                  if 0 < 1:
                    (0, 1, 2, 4, 3)
                  else:
                    (1, 0, 2, 4, 3)
                else:
                  if 0 < 2:
                    (0, 2, 1, 4, 3)
                  else:
                    (2, 0, 1, 4, 3)
            else:
              if 1 < 0:
                if 0 < 4:
                  (1, 0, 4, 2, 3)
                else:
                  if 1 < 4:
                    (1, 4, 0, 2, 3)
                  else:
                    (4, 1, 0, 2, 3)
              else:
                if 1 < 4:
                  if 0 < 1:
                    (0, 1, 4, 2, 3)
                  else:
                    (1, 0, 4, 2, 3)
                else:
                  if 0 < 4:
                    (0, 4, 1, 2, 3)
                  else:
                    (4, 0, 1, 2, 3)
        else:
          if 1 < 0:
            if 0 < 4:
              if 2 < 1:
                if 1 < 0:
                  (2, 1, 0, 4, 3)
                else:
                  if 2 < 0:
                    (2, 0, 1, 4, 3)
                  else:
                    (0, 2, 1, 4, 3)
              else:
                if 2 < 0:
                  if 1 < 2:
                    (1, 2, 0, 4, 3)
                  else:
                    (2, 1, 0, 4, 3)
                else:
                  if 1 < 0:
                    (1, 0, 2, 4, 3)
                  else:
                    (0, 1, 2, 4, 3)
            else:
              if 2 < 1:
                if 1 < 4:
                  (2, 1, 4, 0, 3)
                else:
                  if 2 < 4:
                    (2, 4, 1, 0, 3)
                  else:
                    (4, 2, 1, 0, 3)
              else:
                if 2 < 4:
                  if 1 < 2:
                    (1, 2, 4, 0, 3)
                  else:
                    (2, 1, 4, 0, 3)
                else:
                  if 1 < 4:
                    (1, 4, 2, 0, 3)
                  else:
                    (4, 1, 2, 0, 3)
          else:
            if 1 < 4:
              if 2 < 0:
                if 0 < 1:
                  (2, 0, 1, 4, 3)
                else:
                  if 2 < 1:
                    (2, 1, 0, 4, 3)
                  else:
                    (1, 2, 0, 4, 3)
              else:
                if 2 < 1:
                  if 0 < 2:
                    (0, 2, 1, 4, 3)
                  else:
                    (2, 0, 1, 4, 3)
                else:
                  if 0 < 1:
                    (0, 1, 2, 4, 3)
                  else:
                    (1, 0, 2, 4, 3)
            else:
              if 2 < 0:
                if 0 < 4:
                  (2, 0, 4, 1, 3)
                else:
                  if 2 < 4:
                    (2, 4, 0, 1, 3)
                  else:
                    (4, 2, 0, 1, 3)
              else:
                if 2 < 4:
                  if 0 < 2:
                    (0, 2, 4, 1, 3)
                  else:
                    (2, 0, 4, 1, 3)
                else:
                  if 0 < 4:
                    (0, 4, 2, 1, 3)
                  else:
                    (4, 0, 2, 1, 3)
    else:
      if 0 < 4:
        if 1 < 2:
          if 2 < 3:
            if 3 < 0:
              (1, 2, 3, 0, 4)
            else:
              if 1 < 2:
                if 2 < 0:
                  (1, 2, 0, 3, 4)
                else:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
              else:
                if 1 < 0:
                  if 2 < 1:
                    (2, 1, 0, 3, 4)
                  else:
                    (1, 2, 0, 3, 4)
                else:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
          else:
            if 2 < 0:
              if 1 < 3:
                if 3 < 2:
                  (1, 3, 2, 0, 4)
                else:
                  if 1 < 2:
                    (1, 2, 3, 0, 4)
                  else:
                    (2, 1, 3, 0, 4)
              else:
                if 1 < 2:
                  if 3 < 1:
                    (3, 1, 2, 0, 4)
                  else:
                    (1, 3, 2, 0, 4)
                else:
                  if 3 < 2:
                    (3, 2, 1, 0, 4)
                  else:
                    (2, 3, 1, 0, 4)
            else:
              if 1 < 3:
                if 3 < 0:
                  (1, 3, 0, 2, 4)
                else:
                  if 1 < 0:
                    (1, 0, 3, 2, 4)
                  else:
                    (0, 1, 3, 2, 4)
              else:
                if 1 < 0:
                  if 3 < 1:
                    (3, 1, 0, 2, 4)
                  else:
                    (1, 3, 0, 2, 4)
                else:
                  if 3 < 0:
                    (3, 0, 1, 2, 4)
                  else:
                    (0, 3, 1, 2, 4)
        else:
          if 1 < 3:
            if 3 < 0:
              if 2 < 1:
                if 1 < 3:
                  (2, 1, 3, 0, 4)
                else:
                  if 2 < 3:
                    (2, 3, 1, 0, 4)
                  else:
                    (3, 2, 1, 0, 4)
              else:
                if 2 < 3:
                  if 1 < 2:
                    (1, 2, 3, 0, 4)
                  else:
                    (2, 1, 3, 0, 4)
                else:
                  if 1 < 3:
                    (1, 3, 2, 0, 4)
                  else:
                    (3, 1, 2, 0, 4)
            else:
              if 2 < 1:
                if 1 < 0:
                  (2, 1, 0, 3, 4)
                else:
                  if 2 < 0:
                    (2, 0, 1, 3, 4)
                  else:
                    (0, 2, 1, 3, 4)
              else:
                if 2 < 0:
                  if 1 < 2:
                    (1, 2, 0, 3, 4)
                  else:
                    (2, 1, 0, 3, 4)
                else:
                  if 1 < 0:
                    (1, 0, 2, 3, 4)
                  else:
                    (0, 1, 2, 3, 4)
          else:
            if 1 < 0:
              if 2 < 3:
                if 3 < 1:
                  (2, 3, 1, 0, 4)
                else:
                  if 2 < 1:
                    (2, 1, 3, 0, 4)
                  else:
                    (1, 2, 3, 0, 4)
              else:
                if 2 < 1:
                  if 3 < 2:
                    (3, 2, 1, 0, 4)
                  else:
                    (2, 3, 1, 0, 4)
                else:
                  if 3 < 1:
                    (3, 1, 2, 0, 4)
                  else:
                    (1, 3, 2, 0, 4)
            else:
              if 2 < 3:
                if 3 < 0:
                  (2, 3, 0, 1, 4)
                else:
                  if 2 < 0:
                    (2, 0, 3, 1, 4)
                  else:
                    (0, 2, 3, 1, 4)
              else:
                if 2 < 0:
                  if 3 < 2:
                    (3, 2, 0, 1, 4)
                  else:
                    (2, 3, 0, 1, 4)
                else:
                  if 3 < 0:
                    (3, 0, 2, 1, 4)
                  else:
                    (0, 3, 2, 1, 4)
      else:
        if 1 < 2:
          if 2 < 3:
            if 3 < 4:
              (1, 2, 3, 4, 0)
            else:
              if 1 < 2:
                if 2 < 4:
                  (1, 2, 4, 3, 0)
                else:
                  if 1 < 4:
                    (1, 4, 2, 3, 0)
                  else:
                    (4, 1, 2, 3, 0)
              else:
                if 1 < 4:
                  if 2 < 1:
                    (2, 1, 4, 3, 0)
                  else:
                    (1, 2, 4, 3, 0)
                else:
                  if 2 < 4:
                    (2, 4, 1, 3, 0)
                  else:
                    (4, 2, 1, 3, 0)
          else:
            if 2 < 4:
              if 1 < 3:
                if 3 < 2:
                  (1, 3, 2, 4, 0)
                else:
                  if 1 < 2:
                    (1, 2, 3, 4, 0)
                  else:
                    (2, 1, 3, 4, 0)
              else:
                if 1 < 2:
                  if 3 < 1:
                    (3, 1, 2, 4, 0)
                  else:
                    (1, 3, 2, 4, 0)
                else:
                  if 3 < 2:
                    (3, 2, 1, 4, 0)
                  else:
                    (2, 3, 1, 4, 0)
            else:
              if 1 < 3:
                if 3 < 4:
                  (1, 3, 4, 2, 0)
                else:
                  if 1 < 4:
                    (1, 4, 3, 2, 0)
                  else:
                    (4, 1, 3, 2, 0)
              else:
                if 1 < 4:
                  if 3 < 1:
                    (3, 1, 4, 2, 0)
                  else:
                    (1, 3, 4, 2, 0)
                else:
                  if 3 < 4:
                    (3, 4, 1, 2, 0)
                  else:
                    (4, 3, 1, 2, 0)
        else:
          if 1 < 3:
            if 3 < 4:
              if 2 < 1:
                if 1 < 3:
                  (2, 1, 3, 4, 0)
                else:
                  if 2 < 3:
                    (2, 3, 1, 4, 0)
                  else:
                    (3, 2, 1, 4, 0)
              else:
                if 2 < 3:
                  if 1 < 2:
                    (1, 2, 3, 4, 0)
                  else:
                    (2, 1, 3, 4, 0)
                else:
                  if 1 < 3:
                    (1, 3, 2, 4, 0)
                  else:
                    (3, 1, 2, 4, 0)
            else:
              if 2 < 1:
                if 1 < 4:
                  (2, 1, 4, 3, 0)
                else:
                  if 2 < 4:
                    (2, 4, 1, 3, 0)
                  else:
                    (4, 2, 1, 3, 0)
              else:
                if 2 < 4:
                  if 1 < 2:
                    (1, 2, 4, 3, 0)
                  else:
                    (2, 1, 4, 3, 0)
                else:
                  if 1 < 4:
                    (1, 4, 2, 3, 0)
                  else:
                    (4, 1, 2, 3, 0)
          else:
            if 1 < 4:
              if 2 < 3:
                if 3 < 1:
                  (2, 3, 1, 4, 0)
                else:
                  if 2 < 1:
                    (2, 1, 3, 4, 0)
                  else:
                    (1, 2, 3, 4, 0)
              else:
                if 2 < 1:
                  if 3 < 2:
                    (3, 2, 1, 4, 0)
                  else:
                    (2, 3, 1, 4, 0)
                else:
                  if 3 < 1:
                    (3, 1, 2, 4, 0)
                  else:
                    (1, 3, 2, 4, 0)
            else:
              if 2 < 3:
                if 3 < 4:
                  (2, 3, 4, 1, 0)
                else:
                  if 2 < 4:
                    (2, 4, 3, 1, 0)
                  else:
                    (4, 2, 3, 1, 0)
              else:
                if 2 < 4:
                  if 3 < 2:
                    (3, 2, 4, 1, 0)
                  else:
                    (2, 3, 4, 1, 0)
                else:
                  if 3 < 4:
                    (3, 4, 2, 1, 0)
                  else:
                    (4, 3, 2, 1, 0)
```
# Pandas
`import pandas as pd`

## 1. Creating, Reading, and Writing

### Creating

#### DataFrame

`pd.DataFrame({'Yes':[50,21], 'No':[131,2]})`
就是创造了个这个玩意儿⤵️
|     | Yes | No  |
| --- | --- | --- |
| 0   | 50  | 131 |
| 1   | 21  | 2   |

`pd.DataFrame({'Yes':[50,21], 'No':[131,2]},index=['Mary','Tom'])` 注意大括号的位置！
给每一行取名⤵️
|      | Yes | No  |
| ---- | --- | --- |
| Mary | 50  | 131 |
| Tom  | 21  | 2   |

#### Series
If a DataFrame is a table, a Series is a list. 反正把series看做只有一列的data frame就好了
`pd.Series([100, 92, 83, 74], index=['A','B','C','D'],name='Grading Guideline')`
列出来就是⤵️
```
A   100
B   92
C   83
D   74
Name: Grading Guideline, dtype: int64
```

### Reading data files
现在用的最多的是CSV file，即Comma-Separated Values，它里头就是个大大大大table

#### Read File & Save File
`wine_reviews = pd.read_csv("../input/wine-reviews/winemag-data-130k-v2.csv")`
这个`pd.read_csv`有30多个parameter，自己体会去吧

`wine_reviews.to_csv("winemag-data-130k-v2.csv")`这样就把`wine_reviews`贮存到`winemag-data-130k-v2.csv`了

#### How Large?
`wine_reviews.shape`
这个是output：
```
(129971, 14)
```
指的是一共 129971 行， 14 列

#### Display CSV
`wine_reviews.head()`
然后整个table的前5行就哗啦啦地出来了

## 2. Indexing, Selecting & Assigning

### Native accessors
就是一些Python自带的，你已经用烂了的方法，这里简单归纳一下
- object property `book.title`
- dictionary `grades['math grade']` or `grades['math grade'][0]` (好处在于可以handle空格)

### Indexing in pandas

Both `loc` and `iloc` are row-first, column-second. This is the opposite of what we do in native Python, which is column-first, row-second.

#### `iloc[]` index-based selection

- `iloc[0]`提取第一排
- `iloc[:, 0]`提取第一列
- `iloc[:3, 0]`提取第一列前三项(index 0~2)
- `iloc[1:3, 0]`提取第一列第二和第三项(index 1~2)
- `iloc[[1,2,3], 0]`提取第一列第二三四项(index 1,2,3)
- `iloc[-5:]`提取倒数后5项

#### `loc[]` label-based selection

- `reviews.loc[0, 'country']`第一行，country列
- `reviews.loc[:, ['taster_name', 'taster_twitter_handle', 'points']]`所有行，这些列

#### `iloc[]` VS `loc[]`
`iloc[:100]`指的是`0, ... , 99`
`loc [:100]`指的是`0, ... , 100`

### Manipulating the index

#### `set_index()`
`myDataFrame.set_index('new_index')`怎么看好像是在`myDataFrame`里头新添加一行，这一行没有内容，但是这一行的index是`new_index`？？？不太懂，之后搞懂

### Conditional selection 按条件搜索

#### `==`

`reviews.country == 'Italy'`---会给出一长列，在原本`country`的一列里面布满了`True`和`False`，来表示是否`== 'Italy'`

`reviews.loc[(reviews.country == 'Italy') & (reviews.points >= 90)]`---一目了然，无需多言（`&`是and `|`是or

#### `isin`
`reviews.loc[reviews.country.isin(['Italy', 'France'])]`这样成功筛选出只包含Italy和France的行

#### `notnull()`
`reviews.loc[reviews.price.notnull()]`这样就把price不是`NaN`的挑出来了

### Assigning data
`reviews['critic'] = 'everyone'`---critic这一列就全都是everyone了

`reviews['index_backwards'] = range(len(reviews), 0, -1)`---index_backwards这一列就是倒着的数字了，比如`9,8,7,6,5,4,3,2,1`

## 3. Summary Functions and Maps

### Summary Functions

#### `describe()`

##### `reviews.points.describe()`
它能根据你的data type给出不同的description，比如numerical data会给出mean, count, max, 75%等，如果是string就会给出count, unique, top, freq等

那么举一反三就有很多操作了
- `reviews.points.mean()`直接输出mean
- `reviews.taster_name.unique()`给出一个array，包含 a list of unique values，也就是给你个list，它包含了（你选中的这一列中一共有哪几种不同的value）
- `reviews.taster_name.value_counts()`即告诉你每个taster_name出现多少次 (感觉很像是sql里面的 '''SELECT taster_name, COUNT(1) AS freq FROM... GROUP BY taster_name''')

### Maps
就是把data从这里原封不动地搬运到另一个地方，主要作用是创建一个副本，或者改变data file的格式

###### `map(fun, iter)`
先来回忆一下python build-in map()
```
# Python program to demonstrate working 
# of map. 
  
# Return double of n 
def addition(n): 
    return n + n 
  
# We double all numbers using map() 
numbers = (1, 2, 3, 4) 
result = map(addition, numbers) 
print(list(result)) 
```
output:
```
[2, 4, 6, 8]
```

还可以更简洁，用lambda
```
# Double all numbers using map and lambda 

numbers = (1, 2, 3, 4) 
result = map(lambda x: x + x, numbers) 
print(list(result)) 
```
output:
```
[2, 4, 6, 8]
```

或者多几个variable也完全不是问题：

```
# Add two lists using map and lambda 

numbers1 = [1, 2, 3] 
numbers2 = [4, 5, 6] 

result = map(lambda x, y: x + y, numbers1, numbers2) 
print(list(result)) 
```
output:
```
[5, 7, 9]
```

#### `map(lambda x: )`
和lambda版的map很像，不过是把iter放到map前面去.它了
``` 
review_points_mean = reviews.points.mean()
reviews.points.map(lambda p: p - review_points_mean)

reviews.description.map(lambda desc: "tropical" in desc)
```

#### `apply(fun, iter)`
和function版的map其实是一个道理，不过是把iter放到map前面去.它了，比如说
```
def remean_points(row):
    row.points = row.points - review_points_mean
    return row

reviews.apply(remean_points, axis='columns')
```



## 4. Grouping and Sorting

### 



## 5. Data Types and Missing Values

## 6. Renaming and Combining


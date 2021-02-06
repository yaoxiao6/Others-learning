def collatz_function(a):
    if(a % 2 == 0):
        return a/2
    else:
        return 3*a+1


def collatz_sequence(a):
    c = collatz_function(a)
    b = [a, c]
    while(c != 1):
        c = collatz_function(c)
        b = b+[c]
    return b


def smallest_int_with_collatz_length(n):
    i = 1
    while(True):
        # print(i)
        if(len(collatz_sequence(i)) > n):
            return i
        i += 1

#counterexample = [the length of Collatz sequence 626331 is 501, which is greater than 500]

if __name__ == "__main__":
    print(len(collatz_sequence(9375608542097553)))

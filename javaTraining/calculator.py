import math


def c(n, r):
    return math.factorial(n) / (math.factorial(r) * math.factorial(n-r))


def p(n, r):
    return math.factorial(n) / math.factorial(n-r)


def polynomial_expansion(elements, power):
    result = 0
    for i in range(1, elements+1):
        result += p(elements, i)
    return result


def two_three_tree(n):
    sum = 0
    for i in range(n+1):
        print("========================="+str(i))
        sum += math.pow(3, i)*2
    return sum


def complete_tree(n):
    sum = 0
    for i in range(n+1):
        print("========================="+str(i))
        sum += math.pow(2, i)
    return sum


def cao_ni_ma(iniPosition, length):
    this_position = iniPosition
    i = 0
    while(this_position > 2):
        print("this position = "+str(this_position)+"i = "+str(i))
        this_position = (iniPosition+pow(i, 2)) % length
        i += 1


if __name__ == "__main__":
    print("Bro's P(A) = " + str(13.0*48/c(52, 5)))
    print("Bro's P(B) = " + str(4.0*c(51, 4)/c(52, 5)))

    print("Yao's P(A) = "+str(52.0 * 3/51 * 2/50 * 1/49))
    print("Yao's P(B) = "+str(4/52.0))


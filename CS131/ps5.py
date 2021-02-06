def is_symmetric(A, R):
    for x in A:
        for y in A:
            if R(x, y) and not R(y, x):
                return False 
    return True

def is_reflexive(A, R):
    for x in A:
        for y in A:
            if not R(x, x):
                return False 
    return True

def is_injective(domain, f):
    arr=[]
    counter=0
    for i in domain:
        arr+=[f(i)]
    # print(arr)
    for i in arr:
        counter=0
        for j in arr:
            if(i==j):
                counter+=1
        if(counter >1):
            return False
    return True

def is_transitive(A, R):
    for i in A:
        for j in A:
            for k in A:
                if R(i,j) and R(j,k) and not R(i,k):
                    return False
    return True
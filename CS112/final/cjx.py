def compute(d, c):
    counter = 0
    for key in d:
        if key[0] == c:
            counter += len(d[key])
    return counter


if __name__ == "__main__":
    a = {'hello': ['1', '2', '3'], 'are': ['1'], 'how': ['1']}
    print(compute(a, 'h'))

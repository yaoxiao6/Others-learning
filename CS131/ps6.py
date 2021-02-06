def are_parts_nonoverlapping(p):
    all = p[0]
    q = p[1:]
    for i in q:
        if(len(all & i) > 0):
            return False
        all = all | i
    return True


def do_parts_contain_element(x, p):
    all = p[0]
    for i in p:
        all = all | i
    return x in all


def do_parts_cover_set(s, p):
    for j in s:
        if(not do_parts_contain_element(j, p)):
            return False
    return True


def do_parts_have_nothing_extra(s, p):
    for i in p:
        if(not i.issubset(s)):
            return False
    return True

def is_partition(s,p):
    return are_parts_nonoverlapping(p) and do_parts_cover_set(s, p) and do_parts_have_nothing_extra(s, p)


if __name__ == "__main__":
    print(do_parts_cover_set([{2, 4, 5}, {1, 2, 3}], [{1, 3, 4}, {4, 2, 5}]))

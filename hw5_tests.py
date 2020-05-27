import time
import traceback
import hw5_316499359 as hw


def checker_equals(func, expected):
    return func == expected


def test_case(args, expected_result, func, max_time=None, checker_func=checker_equals):
    func_pretty_name = f"{func.__name__}({', '.join(repr(i) for i in args)})"

    start = time.perf_counter()
    try:
        result = func(*args)
    except Exception:
        print(f"{func_pretty_name}: an error has occured during function\n", traceback.format_exc())
        return

    end = time.perf_counter()
    if not checker_func(result, expected_result):
        print(f"{func_pretty_name}: expected {expected_result}, got {result}")

    if max_time is not None:
        elapsed_time = end - start
        if elapsed_time > max_time:
            print(f"{func_pretty_name}: took {elapsed_time} seconds")


def test_cases(cases, func, max_time=None, checker_func=checker_equals):
    for args, expected_result in cases:
        test_case(args, expected_result, func, max_time, checker_func)


def test_perm():
    # __init__
    cases = [
        (([1, 2, 3],), None),
        (([5, 2],), None),
        (([1, 0, 0],), None),
        (([0, 1, 2],), [0, 1, 2]),
        (([3, 0, 1, 2],), [3, 0, 1, 2]),

    ]

    def test_perm_validation(perm):
        perm_obj = hw.Permutation(perm)
        return perm_obj.perm

    test_cases(cases, test_perm_validation)

    # __getitem__
    cases = [
        (([2, 3, 1, 0], 0), 2),
        (([2, 3, 1, 0], 3), 0),

    ]

    def test_perm_getitem(perm, i):
        perm_obj = hw.Permutation(perm)
        return perm_obj[i]

    test_cases(cases, test_perm_getitem)

    # compose
    cases = [
        (([1, 0, 2], [0, 2, 1]), [1, 2, 0]),
    ]

    def test_perm_compose(p1, p2):
        perm_obj1 = hw.Permutation(p1)
        perm_obj2 = hw.Permutation(p2)
        return perm_obj1.compose(perm_obj2).perm

    test_cases(cases, test_perm_compose)

    # inv
    cases = [
        (([1, 2, 0],), [2, 0, 1]),
    ]

    def test_perm_inv(perm):
        perm_obj = hw.Permutation(perm)
        return perm_obj.inv().perm

    test_cases(cases, test_perm_inv)

    # compose_list
    cases = [
        (([1, 0, 2, 3], [2, 3, 1, 0], [3, 2, 1, 0]), [1, 0, 3, 2]),
    ]

    def test_perm_compose(*perms):
        lst = [hw.Permutation(perm) for perm in perms]
        return hw.compose_list(lst).perm

    test_cases(cases, test_perm_compose)

    # order
    cases = [
        (([0, 1, 2, 3],), 1),
        (([1, 0, 2, 3],), 2),
        (([2, 3, 1, 0],), 4)
    ]

    def test_perm_order(perm):
        return hw.Permutation(perm).order()

    test_cases(cases, test_perm_order)


def test_binary_tree():#
    def build_tree(tree_items):
        tree_obj = hw.Binary_search_tree()
        for key, val in tree_items:
            assert type(key) is str
            assert type(val) in (float, int)
            tree_obj.insert(key, val)
        return tree_obj

    # max_sum
    cases = [
        (([],), 0),
        (([('e', 1), ('b', 2)],), 3),
        (([('e', 1), ('b', 2), ('a', 8), ('d', 4), ('c', 10), ('i', 3), ('g', 5)
              , ('f', 7), ('h', 9), ('j', 6), ('k', 5)],), 18),
    ]

    def test_max_sum(tree_items):
        return build_tree(tree_items).max_sum()
    test_cases(cases, test_max_sum)

    # is_balanced
    cases = [
        (([],), True),
        (([("b", 10), ("d", 10), ("a", 10), ("c", 10)],), True),
        (([("b", 10), ("d", 10), ("a", 10), ("c", 10), ("e", 10), ("f", 10)],), False),
    ]

    def test_is_balanced(tree_items):
        return build_tree(tree_items).is_balanced()
    test_cases(cases, test_is_balanced)

    # diam
    cases = [
        (([],), 0),
        (([('c', 10), ('a', 10), ('b', 10), ('g', 10), ('e', 10), ('d', 10), ('f', 10), ('h', 10)],), 6),
        (([('c', 1), ('g', 3), ('e', 5), ('d', 7), ('f', 8), ('h', 6), ('z', 6)],), 5),
    ]

    def test_diam(tree_items):
        return build_tree(tree_items).diam()
    test_cases(cases, test_diam)


def run_all_tests():
    all_tests = [
        test_perm,
        test_binary_tree
    ]

    for test_func in all_tests:
        print(f"Running {test_func.__name__}...")
        test_func()

    # print("Running lecturers tests...")
    # try:
    #     hw.test()
    # except Exception:
    #     print(f"An error has occured during lecturer tests:\n", traceback.format_exc())


if __name__ == "__main__":
    run_all_tests()

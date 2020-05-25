import time
import traceback
import hw5_316499359 as hw


def checker_equals(func, expected):
    return func == expected


def test(cases, func, max_time=None, checker_func=checker_equals):
    for args, expected_result in cases:
        func_pretty_name = f"{func.__name__}({', '.join(repr(i) for i in args)})"

        start = time.perf_counter()
        try:
            result = func(*args)
        except Exception:
            print(f"{func_pretty_name}: an error has occured during function\n", traceback.format_exc())
            continue

        end = time.perf_counter()
        if not checker_func(result, expected_result):
            print(f"{func_pretty_name}: expected {expected_result}, got {result}")

        if max_time is not None:
            elapsed_time = end - start
            if elapsed_time > max_time:
                print(f"{func_pretty_name}: took {elapsed_time} seconds")


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

    test(cases, test_perm_validation)

    # __getitem__
    cases = [
        (([2, 3, 1, 0], 0), 2),
        (([2, 3, 1, 0], 3), 0),

    ]

    def test_perm_getitem(perm, i):
        perm_obj = hw.Permutation(perm)
        return perm_obj[i]

    test(cases, test_perm_getitem)

    # compose
    cases = [
        (([1, 0, 2], [0, 2, 1]), [1, 2, 0]),
    ]

    def test_perm_compose(p1, p2):
        perm_obj1 = hw.Permutation(p1)
        perm_obj2 = hw.Permutation(p2)
        return perm_obj1.compose(perm_obj2).perm

    test(cases, test_perm_compose)

    # inv
    cases = [
        (([1, 2, 0],), [2, 0, 1]),
    ]

    def test_perm_inv(perm):
        perm_obj = hw.Permutation(perm)
        return perm_obj.inv().perm

    test(cases, test_perm_inv)

    # compose_list
    cases = [
        (([1, 0, 2, 3], [2, 3, 1, 0], [3, 2, 1, 0]), [1, 0, 3, 2]),
    ]

    def test_perm_compose(*perms):
        lst = [hw.Permutation(perm) for perm in perms]
        return hw.compose_list(lst).perm

    test(cases, test_perm_compose)

    # order
    cases = [
        (([0, 1, 2, 3],), 1),
        (([1, 0, 2, 3],), 2),
        (([2, 3, 1, 0],), 3)
    ]

    def test_perm_order(perm):
        return hw.Permutation(perm).order()

    test(cases, test_perm_order)


def run_all_tests():
    all_tests = [
        test_perm
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

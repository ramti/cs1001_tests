import time
import random
import traceback
import hw4_316499359 as hw


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


def test_had_complete():
    tests = [
        ((0,), [[0]]),
        ((1,), [[0, 0], [0, 1]]),
        ((2,), [[0, 0, 0, 0], [0, 1, 0, 1], [0, 0, 1, 1], [0, 1, 1, 0]]),
        ((3,), [[0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 0, 1, 0, 1, 0, 1], [0, 0, 1, 1, 0, 0, 1, 1], [0, 1, 1, 0, 0, 1, 1, 0],
                [0, 0, 0, 0, 1, 1, 1, 1], [0, 1, 0, 1, 1, 0, 1, 0], [0, 0, 1, 1, 1, 1, 0, 0], [0, 1, 1, 0, 1, 0, 0, 1]])

    ]

    test(tests, hw.had_complete)


def test_subset_sum():
    tests = [
        (([1, 3, 8], 11), 1),
        (([], 0), 1),
        (([1, 2], 0), 1),
        (([1, 3, 8, 6, 5], 11), 2),
        (([1, 3, 8, 11], 11), 2),
    ]

    test(tests, hw.subset_sum_count)

    tests = [
        (([1, 3, 8], 11), [[3, 8]]),
        (([], 0), [[]]),
        (([1, 2], 0), [[]]),
        (([1, 2], 6), []),
        (([1, 3, 8, 6, 5], 11), [[3, 8], [6, 5]]),
        (([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], 10),
         [[4, 3, 2, 1], [7, 2, 1], [6, 3, 1], [5, 4, 1], [9, 1], [5, 3, 2], [8, 2], [7, 3], [6, 4], [10]])
    ]

    def checker_internal_list_no_order(func, expected):
        if len(func) != len(expected):
            return False

        func_sorted = [sorted(lst) for lst in func]
        expected_sorted = [sorted(lst) for lst in expected]

        for lst in func_sorted:
            if lst not in expected_sorted:
                return False
        return True

    test(tests, hw.subset_sum_search_all, checker_func=checker_internal_list_no_order)


def test_distance():
    tests = [
        (("computer", "computer"), 0),
        (("", ""), 0),
        (("computer", "commuter"), 1),
        (("sport", "sort"), 1),
        (("", "ab"), 2),
        (("kitten", "sitting"), 3),
    ]

    for test_args, expected in tests[:]:
        reversed_args = (test_args[1], test_args[0])
        tests.append((reversed_args, expected))

    test(tests, hw.distance)
    #test(tests, hw.distance_fast)


def run_all_tests():
    all_tests = [
        test_had_complete,
        test_subset_sum,
        test_distance
    ]

    for test_func in all_tests:
        print(f"Running {test_func.__name__}...")
        test_func()

    print("Running lecturers tests...")
    try:
        hw.test()
    except Exception:
        print(f"An error has occured during lecturer tests:\n", traceback.format_exc())


if __name__ == "__main__":
    run_all_tests()

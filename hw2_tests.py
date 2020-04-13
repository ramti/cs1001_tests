import time
import random
import traceback
import hw2_12345678 as hw


def test(cases, func, max_time=None):
    for args, expected_result in cases:
        func_pretty_name = f"{func.__name__}({', '.join(str(i) for i in args)})"

        start = time.perf_counter()
        try:
            result = func(*args)
        except Exception:
            print(f"{func_pretty_name}: an error has occured during function\n", traceback.format_exc())
            continue

        end = time.perf_counter()
        if result != expected_result:
            print(f"{func_pretty_name}: expected {expected_result}, got {result}")

        if max_time is not None:
            elapsed_time = end - start
            if elapsed_time > max_time:
                print(f"{func_pretty_name}: took {elapsed_time} seconds")


def test_sum_divisors():
    TESTS = [
        ((1, ), 0),
        ((4, ), 3),
        ((220, ), 284),
        ((64, ), 63),
        ((60, ), 108)
    ]

    test(TESTS, hw.sum_divisors)


def test_legal_par():
    TESTS = [
        (("[[{}<>[]]]", ), True),
        (("{}{}", ), True),
        (("[()][<>][[()]]", ), True),
        (("[(])", ), False),
        (("](())", ), False),
        (("<<<{>>}>", ), False)
    ]

    test(TESTS, hw.legal_par)


def test_spiral_num():
    TESTS = [
        ((1, ), 1),
        ((3, ), 25),
        ((100001, ), 666691667100001)
    ]

    test(TESTS, hw.spiral_sum, max_time=1)


def int2bin(num):
    return bin(num)[2:]


def test_binary():
    TESTS_SUB = [
        (("0", "0"), "0"), (("1", "0"), "1"), (("10", "1"), "1"), (("11", "10"), "1"), (("1" + "0" * 19, "1" * 19), "1")
    ]
    TESTS_INC = [(("0",), "1")]
    TESTS_DEC = [(("1",), "0")]
    TESTS_LEQ = [(("1", "0"), False), (("1", "1"), True)]
    TESTS_DIV = [(("10101", "11"), "111"), (("0", "11"), "0")]

    TESTS = [(TESTS_INC, hw.inc), (TESTS_DEC, hw.dec), (TESTS_SUB, hw.sub),
             (TESTS_LEQ, hw.leq), (TESTS_DIV, hw.div)]

    for i in range(1000):
        # bin1 >= bin2
        bin1 = random.randint(0, 100000)
        bin2 = random.randint(0, bin1)
        bin1_str = int2bin(bin1)
        bin2_str = int2bin(bin2)
        TESTS_SUB.append((
            (bin1_str, bin2_str), int2bin(bin1 - bin2)
        ))

        TESTS_INC.append(((bin2_str,), int2bin(bin2 + 1)))

        if bin1 != 0:
            TESTS_DEC.append(((bin1_str,), int2bin(bin1 - 1)))

        if bin1 == bin2:
            TESTS_LEQ.append(((bin1_str, bin2_str), True))
        else:
            TESTS_LEQ.append(((bin1_str, bin2_str), False))
            TESTS_LEQ.append(((bin2_str, bin1_str), True))

        if bin2 != 0:
            TESTS_DIV.append(((bin1_str, bin2_str), int2bin(bin1 // bin2)))

    for cases, func in TESTS:
        test(cases, func, max_time=5)


def test_has_repeat():
    TESTS = [
        (("a", 1), False),
        (("ababa", 3), True),
        (("abab", 3), False),
        (("abab", 2), True),
        (("abcdeabcde", 5), True),
        (("abcdeabcde", 4), True),
        (("abcdeabcde", 6), False),
        (("abcdeabcde", 1), True),
        (("bcece", 2), True),
    ]

    test(TESTS, hw.has_repeat1)
    test(TESTS, hw.has_repeat2)


def test_reading():
    TESTS = [
        ((1, ), "1"),
        ((2, ), "11"),
        ((3, ), "21"),
        ((4, ), "1211"),
        ((5, ), "111221"),
        ((6, ), "312211"),
        ((7, ), "13112221"),
        ((8, ), "1113213211"),
        ((9, ), "31131211131221"),
    ]

    test(TESTS, hw.reading)


def test_max_div_seq():
    TESTS = [
        ((23300247524689, 2), 4),
        ((1357, 2), 0),
        ((1630860, 3), 3),
        ((1630860, 8), 2),
    ]

    test(TESTS, hw.max_div_seq)


def run_all_tests():
    print("Running lecturers tests...")
    try:
        hw.test()
    except Exception:
        print(f"An error has occured during lecturer tests:\n", traceback.format_exc())

    ALL_TESTS = [
        test_sum_divisors,
        test_legal_par,
        test_spiral_num,
        test_has_repeat,
        test_reading,
        test_max_div_seq,
        test_binary
    ]

    for test_func in ALL_TESTS:
        print(f"Running {test_func.__name__}...")
        test_func()


if __name__ == "__main__":
    run_all_tests()

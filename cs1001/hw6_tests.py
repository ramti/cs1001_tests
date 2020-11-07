import pytest
import time
import traceback
import hw6_316499359 as hw


def checker_equals(func, expected):
    return func == expected


def run_single_case(args, expected_result, func, max_time=None, checker_func=checker_equals):
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


def run_all_cases(cases, func, max_time=None, checker_func=checker_equals):
    for args, expected_result in cases:
        run_single_case(args, expected_result, func, max_time, checker_func)


def test_generator():
    # a + b
    g = (i for i in range(5))
    g2 = hw.ImprovedGenerator(g)
    for i in range(5):
        assert i == next(g2)
    with pytest.raises(StopIteration):
        next(g2)

    # c
    g = (i for i in range(5))
    g2 = hw.ImprovedGenerator(g)
    assert g2.has_next() is True
    for i in range(4):
        assert i == next(g2)

    assert g2.has_next() is True
    assert g2.has_next() is True
    assert g2.has_next() is True
    assert next(g2) == 4

    assert g2.has_next() is False
    assert g2.has_next() is False
    assert g2.has_next() is False
    with pytest.raises(StopIteration):
        next(g2)

    assert g2.has_next() is False

    # d
    g = (i for i in range(5))
    g2 = hw.ImprovedGenerator(g)
    assert next(g2) == 0
    assert g2.peek() == 1
    assert g2.peek() == 1
    assert g2.peek() == 1
    assert next(g2) == 1
    assert next(g2) == 2
    assert g2.peek() == 3
    assert g2.peek() == 3
    assert g2.has_next() is True
    assert g2.has_next() is True
    assert g2.peek() == 3
    assert next(g2) == 3
    assert next(g2) == 4
    assert g2.has_next() is False
    with pytest.raises(StopIteration):
        next(g2)

    # e
    g = (i for i in range(10))
    g2 = (i for i in range(10, 20))
    X = hw.ImprovedGenerator(g)
    Y = hw.ImprovedGenerator(g2)
    Z = X.product(Y)
    for i in range(10):
        assert Z.has_next() is True
        assert next(Z) == (i, 10 + i)
    assert Z.has_next() is False
    with pytest.raises(StopIteration):
        next(Z)


def test_lzw_compress():
    cases = [
        (('abc' * 20,), ['a', 'b', 'c', [3, 31], [3, 26]]),
        (('how much wood would the wood chuck chuck if\nthe wood chuck would chuck wood should could hood',),
         ['h', 'o', 'w', ' ', 'm', 'u', 'c', 'h', ' ', 'w', 'o', 'o', 'd', [5, 3], 'u', 'l', 'd', ' ', 't', 'h', 'e',
          [15, 6], 'c', 'h', 'u', 'c', 'k', [6, 7], 'i', 'f', '\n', [24, 15], [45, 6], [12, 8], [23, 3], 's', 'h',
          [18, 6], [6, 5], 'h', [18, 3]]
         ),
    ]

    run_all_cases(cases, hw.LZW_compress)


def test_fingerprint():
    cases = [
        (('amirrub', 'rubamira'), False),
        (('amirrub', ''), False),
        (('', 'amirrub'), False),
        (('', ''), True),
        (('amirrub', 'amirrub'), True),
        (('amirrub', 'rubamir'), True),
        (('amirrub', 'ubamirr'), True),
        (('amirrub', 'rabamir'), False),
        (('abbbbba', 'bbaabbb'), True)
    ]

    run_all_cases(cases, hw.is_rotated_1)
    run_all_cases(cases, hw.is_rotated_2)


def test_lecturer():
    hw.test()


if __name__ == "__main__":
    import sys

    args = list(sys.argv)
    args.append("-s")
    pytest.main(args)

import pytest
import time
import traceback
import hw5_316499359 as hw


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

    run_all_cases(cases, test_perm_validation)

    # __getitem__
    cases = [
        (([2, 3, 1, 0], 0), 2),
        (([2, 3, 1, 0], 3), 0),

    ]

    def test_perm_getitem(perm, i):
        perm_obj = hw.Permutation(perm)
        return perm_obj[i]

    run_all_cases(cases, test_perm_getitem)

    # compose
    cases = [
        (([1, 0, 2], [0, 2, 1]), [1, 2, 0]),
    ]

    def test_perm_compose(p1, p2):
        perm_obj1 = hw.Permutation(p1)
        perm_obj2 = hw.Permutation(p2)
        return perm_obj1.compose(perm_obj2).perm

    run_all_cases(cases, test_perm_compose)

    # inv
    cases = [
        (([1, 2, 0],), [2, 0, 1]),
    ]

    def test_perm_inv(perm):
        perm_obj = hw.Permutation(perm)
        return perm_obj.inv().perm

    run_all_cases(cases, test_perm_inv)

    # compose_list
    cases = [
        (([1, 0, 2, 3], [2, 3, 1, 0], [3, 2, 1, 0]), [1, 0, 3, 2]),
    ]

    def test_perm_compose(*perms):
        lst = [hw.Permutation(perm) for perm in perms]
        return hw.compose_list(lst).perm

    run_all_cases(cases, test_perm_compose)

    # order
    cases = [
        (([0, 1, 2, 3],), 1),
        (([1, 0, 2, 3],), 2),
        (([2, 3, 1, 0],), 4)
    ]

    def test_perm_order(perm):
        return hw.Permutation(perm).order()

    run_all_cases(cases, test_perm_order)


def test_binary_tree():
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

    run_all_cases(cases, test_max_sum)

    # is_balanced
    cases = [
        (([],), True),
        (([("b", 10), ("d", 10), ("a", 10), ("c", 10)],), True),
        (([("b", 10), ("d", 10), ("a", 10), ("c", 10), ("e", 10), ("f", 10)],), False),
    ]

    def test_is_balanced(tree_items):
        return build_tree(tree_items).is_balanced()

    run_all_cases(cases, test_is_balanced)

    # diam
    cases = [
        (([],), 0),
        (([('c', 10), ('a', 10), ('b', 10), ('g', 10), ('e', 10), ('d', 10), ('f', 10), ('h', 10)],), 6),
        (([('c', 1), ('g', 3), ('e', 5), ('d', 7), ('f', 8), ('h', 6), ('z', 6)],), 5),
    ]

    def test_diam(tree_items):
        return build_tree(tree_items).diam()

    run_all_cases(cases, test_diam)

    # same_tree
    cases = [
        (([], []), True),
        (([3, 2, 1, 4, 5, 6], [3, 4, 5, 6, 2, 1]), True),
        (([3, 2, 1, 4, 5, 6], [3, 4, 2, 5, 6, 1]), True),
        (([1, 2, 3, 4, 5, 6], [2, 1, 3, 4, 5, 6]), False),
    ]

    run_all_cases(cases, hw.same_tree)


def test_dllist():
    # insert
    dllist = hw.DLList()
    dllist.insert(5)
    assert dllist.len == 1
    assert dllist.head is dllist.tail
    assert dllist.head.value == 5
    assert dllist.head.next is dllist.head.prev is None

    dllist.insert(7)
    assert dllist.len == 2
    assert dllist.head is dllist.tail.prev
    assert dllist.head.value == 5
    assert dllist.tail.value == 7
    assert dllist.head.prev is dllist.tail.next is None

    # reverse
    dllist.insert(9)
    dllist.insert(1)
    dllist.insert(6)
    dllist.reverse()
    assert dllist.len == 5
    assert dllist.head.value == 6
    assert dllist.head.next.value == 1
    assert dllist.head.prev is None
    assert dllist.tail.value == 5
    assert dllist.tail.prev.value == 7
    assert dllist.tail.next is None

    dllist = hw.DLList()
    dllist.reverse()
    assert dllist.head is dllist.tail is None

    dllist.insert(1)
    dllist.reverse()
    assert dllist.head is dllist.tail

    # remove
    dllist = hw.DLList()
    dllist.insert(1)
    dllist.insert(2)
    dllist.insert(3)

    dllist.delete_node(dllist.head.next)  # delete 2
    assert dllist.len == 2
    assert dllist.head.value == 1
    assert dllist.tail.value == 3
    assert dllist.head.next is dllist.tail
    assert dllist.tail.prev is dllist.head

    dllist.delete_node(dllist.head)  # delete 1
    assert dllist.len == 1
    assert dllist.head is dllist.tail
    assert dllist.head.next is dllist.head.prev is None

    dllist.delete_node(dllist.head)  # delete 3
    assert dllist.len == 0
    assert dllist.head is dllist.tail is None

    dllist = hw.DLList()
    dllist.insert(1)
    dllist.insert(2)
    dllist.insert(3)
    dllist.insert(4)

    dllist.delete_node(dllist.head)  # delete head
    assert dllist.len == 3
    assert dllist.head.value == 2
    assert dllist.head.prev is None
    assert dllist.head.next.prev is dllist.head

    dllist.delete_node(dllist.tail)  # delete tail
    assert dllist.len == 2
    assert dllist.tail.value == 3
    assert dllist.tail.next is None
    assert dllist.tail.prev.next is dllist.tail

    # rotate
    dllist = hw.DLList()
    dllist.insert(1)
    dllist.rotate(0)
    assert dllist.head is dllist.tail
    assert dllist.head.next is dllist.head.prev is None

    dllist.insert(2)
    dllist.rotate(1)
    assert dllist.head.value == 2
    assert dllist.tail.value == 1
    assert dllist.head.prev is dllist.tail.next is None
    assert dllist.head.next is dllist.tail
    assert dllist.tail.prev is dllist.head

    dllist.rotate(1)
    dllist.insert(3)
    dllist.insert(4)
    dllist.rotate(2)
    assert dllist.head.value == 3
    assert dllist.tail.value == 2
    assert dllist.head.prev is dllist.tail.next is None
    assert dllist.tail.prev.next is dllist.tail
    assert dllist.head.next.prev is dllist.head


def test_prefix_suffix_overlap():
    def checker_unordered_list(func, expected):
        return sorted(func) == sorted(expected)

    # prefix_suffix_overlap
    cases = [
        ((["a" * 10, "b" * 4 + "a" * 6, "c" * 5 + "b" * 4 + "a"], 5), [(0, 1), (1, 2)]),
        ((["aaa", "aaa"], 3), [(0, 1), (1, 0)]),
        ((["aba", "cab"], 1), []),
    ]

    run_all_cases(cases, hw.prefix_suffix_overlap, checker_func=checker_unordered_list)
    run_all_cases(cases, hw.prefix_suffix_overlap_hash1, checker_func=checker_unordered_list)
    run_all_cases(cases, hw.prefix_suffix_overlap_hash2, checker_func=checker_unordered_list)

    # find
    dict_obj = hw.Dict(3)
    assert dict_obj.find(56) == []

    dict_obj.insert(3, "a")
    dict_obj.insert(56, "a")
    dict_obj.insert(56, "b")
    dict_obj.insert(57, "c")
    assert dict_obj.find(56) == ["a", "b"]
    assert dict_obj.find(57) == ["c"]


def test_lecturer():
    hw.test()


if __name__ == "__main__":
    import sys

    args = list(sys.argv)
    args.append("-s")
    pytest.main(args)

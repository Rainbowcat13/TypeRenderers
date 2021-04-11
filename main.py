import sys
import pandas


class MyClass:
    pass


def print_vars():
    variables = sys._getframe(1).f_locals  # depth 1 to go to caller context
    for var in variables.items():
        print(f"{var[0]}: {var[1].__class__.__module__ == 'builtins'}")


def foo():
    a = 1
    b = MyClass()
    c = [1, 2, 3]
    d = pandas.read_csv('my_file.csv')
    print_vars()


if __name__ == '__main__':
    foo()

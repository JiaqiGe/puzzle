import sys

def reverse(a):
    if a == -sys.maxint-1:
        raise Exception("cannot reverse "+str(a))

    if a < 0:
        return - _reverse(-a)
    else:
        return _reverse(a)

def _reverse(a):
    r = 0
    while a > 0:
        digit = a % 10
        a = a / 10

        if sys.maxint / 10 >= r and sys.maxint - digit >= r*10:
            r = r * 10 + digit
        else:
            raise Exception('overflow!')

    return r


if __name__ == '__main__:
    print reverse(123)

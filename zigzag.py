def zigzag(text, nRows):
    unit_length = nRows * 2 - 2
    r = []
    for row in range(nRows):
        i = row
        while i < len(text):
            r.extend(text[i])
            tmp1 = unit_length - i % unit_length

            if tmp1 < unit_length:
                tmp2 = (i / unit_length)*unit_length + unit_length - i % unit_length
                if tmp2 != i and tmp2 < len(text):
                    r.extend(text[tmp2])

            i = i + unit_length

    return r

if __name__ == '__main__':
    print ''.join(zigzag('PAYPALISHIRING',3))

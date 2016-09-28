

def isMatch(a, p):
    rows = len(a) + 1
    columns = len(p) + 1
    matrix = [[False for x in range(columns)] for y in range(rows)]

    # initialization
    for i in range(0,rows):
        matrix[i][columns-1] = False

    matrix[rows -1][columns-1] = True
    for j in range(0,columns-1):
        matrix[rows-1][j] = matrix[rows-1][j+1] and p[j] == '*'

    #dp
    for i in range(rows-2,-1,-1):
        for j in range(columns-2, -1, -1):
            if p[j] == '.':
                matrix[i][j] = matrix[i+1][j+1]
            elif p[j] == '*':
                for k in range(i+1,rows):
                    if matrix[k][j+1]:
                        matrix[i][j] = True
                        break
            else:
                matrix[i][j] = matrix[i+1][j+1] and a[i] == p[j]

    result = False
    for j in range(0,columns):
        result = result or matrix[0][j]
    return result


if __name__ == '__main__':
    print isMatch('aab','*a*b')

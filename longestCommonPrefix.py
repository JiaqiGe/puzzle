import sys

def longestCommonPrefix(strs):
       min_str = ''
       length = sys.maxint
       for str in strs:
           if len(str) < length:
               length = len(str)
               min_str = str

       p = []
       for i in range(len(min_str)):
           for str in strs:
               if str[i] != min_str[i]:
                   return ''.join(p)
           p.append(min_str[i])

       return ''.join(p)

if __name__ == '__main__':
    print longestCommonPrefix(['abc','ab','ac'])

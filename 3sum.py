
def threesum(nums):
    nums.sort()
    start = 0
    end = len(nums) - 1

    s = set()

    for i in range(len(nums)):
        a1 = nums[i]
        start = i + 1
        end = len(nums) - 1
        res = _2sum(nums,start, end, -nums[i])

        for (a2,a3) in res:
            s.add((a1,a2,a3))
    return s

def _2sum(nums, start, end, k):
    r = set()
    while start < end:
        s = nums[start] + nums[end]

        if s > k:
            end -= 1
        elif s < k:
            start += 1
        else:
            r.add((nums[start], nums[end]))
            start += 1
            end -= 1
    return r

if __name__ == '__main__':
    S = [-1, 0, 1, 2, -1, -4]
    print threesum(S)


def closest3sum(nums, k):
    return _closest3sum(sorted(nums), 0, k)


def _closest3sum(nums, start, k):
    if len(nums) - start  < 3:
        return None

    if len(nums) - start == 3:
        return nums

    preclosest = _closest3sum(nums, start + 1, k)

    pre2sum = _closest2sum(nums, start+1,k-nums[start])

    closest = 0

    if sum(pre2sum) + nums[start] < sum(preclosest):
        closest = sum(pre2sum) + nums[start]
    else:
        closest = preclosest

    return closest

def _closest2sum(nums,lo, k)
    start = lo
    end = len(nums) - 1

    while start < end :
        if


if __name__ == '__main__':
    nums = [2,3,4,5,6]
    closest3sum(nums,16)

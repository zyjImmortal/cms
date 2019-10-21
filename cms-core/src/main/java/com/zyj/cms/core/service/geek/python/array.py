class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        
        def helper(i, tmp):
            res.append(tmp)
            for j in range(i, n):
                helper(j + 1,tmp + [nums[j]] )
        helper(0, [])
        return res 
    
    def addDigits(self, num: int) -> int:
        '''
        给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数
        '''
        pre = num // 10
        if pre == 0:
            return num;
        mod = num % 10
        return self.addDigits(pre + mod)

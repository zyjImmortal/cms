class Solution:

    def isPalindrome(self, s: str)->bool:
        '''
        判断是否是回文字符串
        '''
        filter_str = filter(str.isalnum, s)
        new_str = ''.join(filter_str)
        reverse_string = new_str.lower()[::-1]
        if s == reverse_string:
            return True
        else:
            return False
    
    def mostCommonWord(self, paragraph: str, banned) -> str:
        import re
        record = {}
        strs = re.split('\W',paragraph)
        for key in strs:
            if key in record and key not in banned:
                record[key] = record[key] + 1
        max_key,max_value = None,0
        for key, value in record.items():
            if value > max_value:
                max_key,max_value = key,value
        return max_key

if __name__ == "__main__":
    soluton = Solution()
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    print(soluton.mostCommonWord(paragraph,banned))


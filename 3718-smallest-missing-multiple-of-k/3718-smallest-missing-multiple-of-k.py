class Solution:
    def missingMultiple(self, a: List[int], k: int) -> int:
        return min({*range(k,max(a)+k+1,k)}-{*a})
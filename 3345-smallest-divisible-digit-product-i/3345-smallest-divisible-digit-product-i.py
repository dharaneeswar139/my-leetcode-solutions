class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        def dipd(n):
            p=1
            while n:
                p*=n%10
                n//=10
            return p
        while True:
            if dipd(n)%t==0:
                return n
            n+=1


        
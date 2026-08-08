class Solution:
    def validSequence(self, word1: str, word2: str) -> List[int]:
        n, m = len(word1), len(word2)

        # PHASE 1 -> the right to left suffix array (for teh guaranteed supply)
        # suffix_match[i] will store exactly how many characters of word2's suffix can be perfectly matched in word1 starting from index [i...end]
        suffix_match = [0] * (n + 1)
        j = m - 1

        for i in range(n - 1, -1, -1):
            if j >= 0 and word1[i] == word2[j]:
                suffix_match[i] = suffix_match[i + 1] + 1
                j -= 1
            else:
                suffix_match[i] = suffix_match[i + 1]
        

        # PHASE 2 -> informed greedy
        res = []
        j = 0
        changed = False

        for i in range(n):

            # we have successfully formed all of word2, we can stop searching.
            if j == m:
                break
            
            # option 1 -> match, so we directly take the index.
            if word1[i] == word2[j]:
                res.append(i)
                j += 1


            # option 2 -> mismatch, we need to deicde now whether to change or skip this index.        
            elif not changed:

                # how many more characters of word2 do we still need? if we have to force the current char to change?
                remaining_needed = m - j - 1

                # now look at the suffx array ahead of the current index(= i + 1), can it alone supply the rest of the upcoming demand we are gonna have if we changin the current index...
                if remaining_needed <= suffix_match[i + 1]:
                    res.append(i)
                    j += 1
                    changed = True
        
        if len(res) == m:
            return res
        return []
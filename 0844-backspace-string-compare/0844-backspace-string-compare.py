class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        def build(stri):
            st=[]
            for ch in stri:
                if ch=='#':
                    if st:
                        st.pop()
                else:
                    st.append(ch)
            return st
        return build(s)==build(t)


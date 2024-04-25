d = 256  # Number of characters in the input alphabet
q = 101  # A prime number for hashing

def rabin_karp(text, pattern):
    text_len = len(text)
    pattern_len = len(pattern)
    h = pow(d, pattern_len - 1, q)  # Calculate h: d^(m-1) % q
    pattern_hash = sum(ord(pattern[i]) * pow(d, pattern_len - i - 1, q) % q for i in range(pattern_len)) % q
    text_hash = sum(ord(text[i]) * pow(d, pattern_len - i - 1, q) % q for i in range(pattern_len)) % q

    for i in range(text_len - pattern_len + 1):
        if pattern_hash == text_hash:
            if text[i:i + pattern_len] == pattern:
                print("Pattern found at index", i)

        if i < text_len - pattern_len:
            text_hash = (d * (text_hash - ord(text[i]) * h) + ord(text[i + pattern_len])) % q
            if text_hash < 0:
                text_hash += q

# Example usage:
text = "AABAACAADAABAABA"
pattern = "AABA"
print("Text:", text)
print("Pattern:", pattern)
rabin_karp(text, pattern)

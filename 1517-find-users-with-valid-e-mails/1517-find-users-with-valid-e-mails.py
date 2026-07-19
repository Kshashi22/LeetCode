import pandas as pd

def valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    # Strict regex matching exactly what LeetCode demands
    pattern = r'^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\.com$'
    
    # Filter the rows while cleanly ignoring any null fields
    return users[users['mail'].str.match(pattern, na=False)]
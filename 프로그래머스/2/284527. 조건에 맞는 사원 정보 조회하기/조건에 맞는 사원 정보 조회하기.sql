-- 코드를 작성해주세요
WITH SUM_SCORE AS (
    SELECT SUM(SCORE) AS SCORE, EMP_NO
    FROM HR_GRADE
    GROUP BY EMP_NO
)

# SELECT MAX(S.SCORE) AS SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL -- 실패
SELECT S.SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM HR_EMPLOYEES AS E
INNER JOIN SUM_SCORE AS S
ON E.EMP_NO = S.EMP_NO
# WHERE S.SCORE = MAX(S.SCORE)
WHERE S.SCORE = (SELECT MAX(SCORE) 
                FROM SUM_SCORE)
# GROUP BY EMP_NO


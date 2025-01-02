-- 코드를 작성해주세요
WITH DIFF AS (
    SELECT max(SIZE_OF_COLONY) AS MAX_SIZE, YEAR(DIFFERENTIATION_DATE) AS YEAR
    FROM ECOLI_DATA
    GROUP BY YEAR)
    
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, 
(D.MAX_SIZE - E.SIZE_OF_COLONY) AS YEAR_DEV, 
E.ID
FROM ECOLI_DATA AS E
INNER JOIN DIFF AS D
ON YEAR(DIFFERENTIATION_DATE) = D.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC

# SELECT
#     YEAR(A.DIFFERENTIATION_DATE) AS YEAR,
#     B.YEAR_MAX - A.SIZE_OF_COLONY AS YEAR_DEV,
#     ID
# FROM ECOLI_DATA A
# INNER JOIN (
#     SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS YEAR_MAX
#     FROM ECOLI_DATA
#     GROUP BY YEAR
# ) B
# ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
# ORDER BY YEAR, YEAR_DEV;


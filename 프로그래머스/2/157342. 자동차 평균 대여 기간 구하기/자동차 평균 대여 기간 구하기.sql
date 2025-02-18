# -- 코드를 입력하세요
# WITH DURATION AS (
#     SELECT DATEDIFF(END_DATE, START_DATE)+1 AS DATEDIFF
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     GROUP BY CAR_ID
# )
# SELECT C.CAR_ID, AVG(D.DATEDIFF) AS AVERAGE_DURATION
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
# INNER JOIN DURATION AS D
# ON C.CAR_ID = D.CAR_ID
# WHERE

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

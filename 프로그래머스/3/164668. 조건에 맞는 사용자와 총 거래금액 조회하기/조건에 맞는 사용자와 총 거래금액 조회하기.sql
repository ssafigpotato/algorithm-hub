-- 코드를 입력하세요
SELECT U.USER_ID, U.NICKNAME, SUM(B.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER AS U
INNER JOIN USED_GOODS_BOARD AS B
ON U.USER_ID = B.WRITER_ID
WHERE STATUS = 'DONE'
GROUP BY U.USER_ID
HAVING SUM(B.PRICE) >= 700000
ORDER BY SUM(B.PRICE) ASC
-- 코드를 작성해주세요
SELECT count(*) AS FISH_COUNT, MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH -- as로 설정한 이름으로 그룹바이 가능하구나! as를 months라고 하고 이것도 months라고 했더니 됐음 
ORDER BY MONTH ASC
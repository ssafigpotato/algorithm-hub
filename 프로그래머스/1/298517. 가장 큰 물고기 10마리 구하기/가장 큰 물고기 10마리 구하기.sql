-- 코드를 작성해주세요
SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH IS NOT NULL AND LENGTH > 10
ORDER BY LENGTH DESC, ID ASC
LIMIT 10

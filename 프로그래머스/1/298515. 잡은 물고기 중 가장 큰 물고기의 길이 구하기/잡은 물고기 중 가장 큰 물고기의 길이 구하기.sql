-- 코드를 작성해주세요
# SELECT CONCAT(max(LENGTH), 'cm') AS MAX_LENGTH
# FROM FISH_INFO
SELECT CONCAT(FORMAT(max(LENGTH),2), 'cm') AS MAX_LENGTH
FROM FISH_INFO
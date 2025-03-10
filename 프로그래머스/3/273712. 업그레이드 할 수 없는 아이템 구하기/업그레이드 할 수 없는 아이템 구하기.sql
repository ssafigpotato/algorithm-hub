-- 코드를 작성해주세요
# WITH I AS (
#     SELECT ITEM_ID, PARENT_ITEM_ID
#     FROM ITEM_TREE
#     )

SELECT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO AS I
# INNER JOIN ITEM_TREE AS T
# ON I.ITEM_ID <> T.PARENT_ITEM_ID
WHERE I.ITEM_ID NOT IN (
    SELECT T.PARENT_ITEM_ID
    FROM ITEM_TREE AS T
    WHERE T.PARENT_ITEM_ID IS NOT NULL
)
ORDER BY I.ITEM_ID DESC
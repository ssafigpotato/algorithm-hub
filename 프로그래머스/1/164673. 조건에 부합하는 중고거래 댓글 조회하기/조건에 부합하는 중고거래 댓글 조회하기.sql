-- 코드를 입력하세요
-- R의 created-date는 댓글 작성일, B의 created-date는 게시글 작성일
SELECT B.TITLE, R.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_REPLY AS R
INNER JOIN USED_GOODS_BOARD AS B
ON R.BOARD_ID = B.BOARD_ID
WHERE substr(B.CREATED_DATE,1,7) = '2022-10'
ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;
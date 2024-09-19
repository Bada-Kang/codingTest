-- 온라인 상품 판매 정보
-- 동일한 회원이 재구매한 데이터를 구하여
-- 재구매한 회원 ID와 재구매한 상품 ID를 출력
-- 정렬: 회원 ID, 상품 ID DESC
SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID HAVING COUNT(*) > 1
ORDER BY 1, 2 DESC;
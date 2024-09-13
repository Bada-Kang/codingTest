-- 코드를 입력하세요
SELECT * FROM FOOD_PRODUCT where price = (SELECT max(price) FROM FOOD_PRODUCT);
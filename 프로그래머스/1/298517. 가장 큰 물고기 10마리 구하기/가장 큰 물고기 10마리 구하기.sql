-- 가장 큰 물고기 10마리의 ID와 길이를 출력
-- 10cm 초과
-- 정렬: 길이 내림차순, ID 오름차순

SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH > 10
ORDER BY 2 DESC, 1
LIMIT 10;


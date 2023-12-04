-- 입약을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회
-- "INS에는 있으나 OUTS에는 없을 수 있음"
-- 레프트 아우터 조인 -> 없는 애들은 null로 채워짐
-- outs의 DateTime이 null인 애들 -> 입양 못 감
-- Ins 오름차순으로 정렬후 3개의 데이터 추출 Limit 3 -> 가장 오래 동물 3마리
SELECT i.NAME, i.DATETIME
FROM ANIMAL_INS i
LEFT JOIN ANIMAL_OUTS o
ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE o.DATETIME IS NULL 
ORDER BY i.DATETIME
LIMIT 3;

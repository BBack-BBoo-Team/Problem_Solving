SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';

-- ROUND : 반올림
-- ROUND(v, p) : 반올림 자릿수 설정. p가 자릿수
-- CEIL : 올림
-- FLOOR : 소수 모두 버림
-- TRUNCATE(v,p) : 버림 자릿수 설정. p가 자릿수

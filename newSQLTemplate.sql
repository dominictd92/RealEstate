SELECT DISTINCT s.s_name FROM S s
WHERE s.s_num IN (SELECT s_num FROM SPJ WHERE j_num = 'j2')
create or replace
PROCEDURE CT_CUSTOMER IS 
v_tabcnt NUMBER;
BEGIN
SELECT count(*) INTO v_tabcnt
FROM ALL_TABLES
WHERE TABLE_NAME = 'CUSTOMER'AND OWNER = USER;

if v_tabcnt = 0 then
EXECUTE IMMEDIATE 'CREATE TABLE CUSTOMER
                  (
                     CUSTOMER_ID INTEGER PRIMARY KEY,
                     FIRST_NAME VARCHAR(20),
                     CREDIT DECIMAL(10,2)
                  )';
                  COMMIT;
  
end if;

SELECT count(*) into v_tabcnt
from all_sequences
where sequence_name = 'CUSTOMERS_SEQ' and sequence_owner = USER;

if v_tabcnt = 0 then
EXECUTE IMMEDIATE 'CREATE SEQUENCE customers_seq
                   START WITH     100000
                   INCREMENT BY   2
                   CACHE 20';
                   COMMIT;
                   end if;

END CT_CUSTOMER;









  
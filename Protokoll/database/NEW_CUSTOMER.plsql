create or replace
PROCEDURE 
PROC_NEW_CUSTOMER ( CUSTOMER_ID out NUMBER,
                    FIRST_NAME in VARCHAR,
                    CREDIT in out NUMBER) IS
                    
                    
BEGIN

SELECT CUSTOMERS_SEQ.nextval into CUSTOMER_ID
from Dual;


IF(CREDIT IS NULL) THEN
SELECT -100 INTO CREDIT
FROM DUAL;

END IF;

INSERT INTO CUSTOMER VALUES(CUSTOMER_ID,FIRST_NAME,CREDIT);

END PROC_NEW_CUSTOMER;
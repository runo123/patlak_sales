create or replace
TRIGGER TRG_CREDIT
BEFORE INSERT OR UPDATE
ON CUSTOMER
REFERENCING OLD AS OLDROW NEW as NEWROW
FOR EACH ROW
DECLARE
BEGIN
  
      IF(:NEWROW.CREDIT < 0) THEN
      RAISE_APPLICATION_ERROR(-20500, 'The Credit can not be under zero, current Credit'
      || :NEWROW.CREDIT || '!!!');
      
      END IF;


END TRG_CREDIT;
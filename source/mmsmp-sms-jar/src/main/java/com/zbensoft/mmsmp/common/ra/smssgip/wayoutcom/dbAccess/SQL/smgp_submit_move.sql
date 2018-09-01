CREATE PROCEDURE `smgp_submit_move`()
    NOT DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT ''
begin DECLARE nowtime datetime DEFAULT now(); declare inst int default 0; declare updt int default 0; declare Smove int default 1; declare tries int default 1; START TRANSACTION; select value into Smove from smgp_parameter where name = 'submitLocal_bak'; select value into tries from smgp_parameter where name = 'submitLocal_retries'; insert into smgp_submitok select seq from smgp_submittimeout where (TIMESTAMPDIFF(minute,convertTime, nowtime)>=Smove and resp = 'Y'); set @inst = ROW_COUNT(); delete from smgp_submittimeout where (TIMESTAMPDIFF(minute,convertTime, nowtime)>=Smove and resp = 'Y'); set @updt = ROW_COUNT(); IF updt!=inst THEN rollback; ELSE COMMIT; END IF; insert into smgp_submitnok select seq from smgp_submittimeout where (retries >= tries and resp = 'N'); set @inst = ROW_COUNT(); delete from smgp_submittimeout where (retries >= tries and resp = 'N'); set @updt = ROW_COUNT(); IF updt!=inst THEN rollback; ELSE COMMIT; END IF; end;

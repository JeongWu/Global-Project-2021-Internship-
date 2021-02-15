INSERT INTO company (ID, NAME) VALUES (1, 'EXIMBAY');



INSERT INTO division (DIVISION_SEQ,  NAME) VALUES (1, 'D1');

INSERT INTO division (DIVISION_SEQ,  NAME) VALUES (2, 'D2');
INSERT INTO division (DIVISION_SEQ,  NAME) VALUES (3, 'D3');


INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG,IMAGE,INTRODUCTION) VALUES (1, 1, 'TEAM 1','1T' ,'TFT','Y','assets/media/users/100_2.jpg','team 1 introduction');

INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG,IMAGE) VALUES (2, 2, 'TEAM 2','2T', 'SQUAD','N','assets/media/users/100_2.jpg');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG,IMAGE) VALUES (3, 3, 'TEAM 3','3T', 'TEAM','Y','assets/media/users/100_2.jpg');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (4, 1, 'TEAM 4','4T', 'TEAM','Y');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (5, 2, 'TEAM 5','5T', 'TFT','N');

INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (6, 1, 'TEAM 6','6T' ,'TFT','Y');

INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (7, 2, 'TEAM 7','7T', 'SQUAD','N');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (8, 3, 'TEAM 8','8T', 'TEAM','Y');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (9, 1, 'TEAM 9','9T', 'TEAM','Y');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (10, 2, 'TEAM 10','10T', 'TFT','N');

INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (11, 1, 'TEAM 11','11T' ,'TFT','Y');

INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (12, 2, 'TEAM 12','12T', 'SQUAD','N');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (13, 3, 'TEAM 13','13T', 'TEAM','Y');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (14, 1, 'TEAM 14','14T', 'TEAM','Y');
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (15, 2, 'TEAM 15','15T', 'TFT','N');

INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(1111,'Jane','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(2222,'Bob','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(3333,'Chris','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(4444,'Tom','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(5555,'Amy','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(6666,'member1','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(7777,'member2','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(8888,'member3','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(9999,'member4','assets/media/users/100_2.jpg');
INSERT INTO member2 (MEMBER_SEQ, NAME,IMAGE) VALUES(10000,'member5','assets/media/users/100_2.jpg');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(1111,'Jane');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(2222,'Bob');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(3333,'Chris');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(4444,'Tom');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(5555,'Amy');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(6666,'member1');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(7777,'member2');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(8888,'member3');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(9999,'member4');
-- INSERT INTO member2 (MEMBER_SEQ, NAME) VALUES(10000,'member5);



INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(1,'Y', 1,1111);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE, TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(2, 'N',1,2222);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE, TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(3, 'N',1,3333);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE, TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(4, 'N',1,4444);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(5, 'N',1,5555);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(6, 'N',2,6666);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(7, 'Y',2,7777);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(8, 'N',2,8888);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(9, 'Y',3,9999);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(9, 'Y',4,2222);
INSERT INTO TEAM_MEMBER (APPLY_BEGIN_DATE,TEAM_MANAGER_FLAG,TEAM_SEQ,MEMBER_SEQ) VALUES(9, 'N',5,10000);

-- INSERT INTO TEAM_MEMBER (TEAM_SEQ,MEMBER_SEQ) VALUES(1,1111);
-- INSERT INTO TEAM_MEMBER (TEAM_SEQ,MEMBER_SEQ) VALUES(2,2222);
-- INSERT INTO TEAM_MEMBER (TEAM_SEQ,MEMBER_SEQ) VALUES(1,3333);


/*
INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (1, 1, 'TEAM 1','1T' ,'TFT','Y');

INSERT INTO team2 (TEAM_SEQ,DIVISION_SEQ,  NAME, LOCAL_NAME,TEAM_TYPE, USE_FLAG) VALUES (2, 2, 'TEAM 2','2T', 'SQUAD','N');

INSERT INTO member2 (MEMBER_SEQ, TEAM_SEQ, NAME) VALUES(1111,1,'Jane');
INSERT INTO member2 (MEMBER_SEQ, TEAM_SEQ, NAME) VALUES(2222,2,'Bob');
INSERT INTO member2 (MEMBER_SEQ, TEAM_SEQ, NAME) VALUES(3333,1,'Chris');


*/

/* INSERT INTO team (ID, NAME, REG_USER_ID, REG_DT) VALUES (1, 'TEAM 1', 'bayar', now());

INSERT INTO member (ID, TEAM_ID, LEVEL, USER_ID, PASSWORD, NAME, EMAIL, REG_USER_ID, REG_DT)VALUES(1, 1, 'C', 'admin', '123456', 'Admin', 'admin@eximbay.com', 'bayar', now());
INSERT INTO member (ID, TEAM_ID, LEVEL, USER_ID, PASSWORD, NAME, EMAIL, REG_USER_ID, REG_DT)VALUES(2, 1, 'T', 'bayar', '123456', 'Bayar', 'bayar@eximbay.com', 'bayar', now());
INSERT INTO member (ID, TEAM_ID, LEVEL, USER_ID, PASSWORD, NAME, EMAIL, REG_USER_ID, REG_DT)VALUES(3, 1, 'M', 'tester', '123456', 'Tester', 'test@eximbay.com', 'bayar', now());
INSERT INTO member (ID, TEAM_ID, LEVEL, USER_ID, PASSWORD, NAME, EMAIL, REG_USER_ID, REG_DT)VALUES(4, 1, 'M', 'tester2', '123456', 'Tester2', 'test2@eximbay.com', 'bayar', now());
INSERT INTO member (ID, TEAM_ID, LEVEL, USER_ID, PASSWORD, NAME, EMAIL, REG_USER_ID, REG_DT)VALUES(5, 1, 'M', 'tester3', '123456', 'Tester3', 'test3@eximbay.com', 'bayar', now());
  */
/*INSERT INTO objective (ID, M_ID, OBJ_NO, OBJ_NAME, LEVEL, REG_USER_ID, REG_DT)VALUES(1, 1, '1', 'Test Obj 1', 'M', 'bayar', now());
INSERT INTO objective (ID, M_ID, OBJ_NO, OBJ_NAME, LEVEL, REG_USER_ID, REG_DT)VALUES(2, 1, '2', 'Test Obj 2', 'M', 'bayar', now());
INSERT INTO objective (ID, M_ID, OBJ_NO, OBJ_NAME, LEVEL, REG_USER_ID, REG_DT)VALUES(3, 1, '3', 'Test Obj 3', 'M', 'bayar', now());

INSERT INTO key_result (ID, KR_NO, KR_NAME, PCT_OF_KR_COMPLETE, REG_USER_ID, REG_DT)VALUES(1, '1', 'Test KR 1', 80, 'bayar', now());
INSERT INTO key_result (ID, KR_NO, KR_NAME, PCT_OF_KR_COMPLETE, REG_USER_ID, REG_DT)VALUES(2, '2', 'Test KR 2', 76, 'bayar', now());
INSERT INTO key_result (ID, KR_NO, KR_NAME, PCT_OF_KR_COMPLETE, REG_USER_ID, REG_DT)VALUES(3, '3', 'Test KR 3', 78, 'bayar', now());
*/
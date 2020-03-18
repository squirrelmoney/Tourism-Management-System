����������PK���������ƣ�
Ա����(Ա����PK,����,�ֻ���,ְ��)
�û���½�����ֻ���PK�����룬Ȩ�ޣ�
    Ȩ��1-���� 2-������ 3-���� 4-�û�
���ʱ���Ա����,��������,����һ��,��ɣ�
��Ŀ��(��Ŀ��PK����Ŀ����Ŀ�ĵأ����γ���ʱ�䣬����ʱ�䣬��ֹʱ�䣬��ϸ��Ϣ�����������������������������״̬��������ID(FK)������ID(FK),��Ŀ���fk))
    ״̬1-������  2-����ʱ�����  3-����
���������Ŀ��PK,���˳ɱ���ס�����ã������ѣ�����
�û���Ϣ�����ֻ���PK����Ŀ��pk,����������֤���룬��������״̬��
    ״̬1-δ���ڣ����н���֮ǰ�� 2-�ѹ��ڣ����ν���֮��
ԤԼ�����ֻ���PK����Ŀ��pk,����������֤���룬��������״̬��//��ʱ��
    ״̬1-ԤԼ��  2-ԤԼ�ɹ�  3-ԤԼʧ��
��ʷ��¼������Ŀ��PK��������
�ȴ���������Ŀ�ĵأ�������



drop database if exists travelAgency;

create database travelAgency;

use travelAgency;

create table category
(
cId char(10) primary key,
cName varchar(20)
);

create table  employee
(
eId char(10) primary key,
eName char(20),
eTel char(11),
eTitle char(10)
);

create table user
(
uTel char(11) primary key,
uPassWord char(20),
uSuper int
);

create table salary(
seId char(10) primary key,
baseSalary double,
insurance double,
reward double,
foreign key(seId) references employee(eId) 
);

create table project
(
pId char(10) primary key,
pName varchar(50),
destination char(20),
last int,
beginning date,
ending date,
describing varchar(50),
min int,
max int,
pflag int,
chargeId char(10),
leadId char(10),
pcId char(10),
foreign key(pcId) references category(cId) ,
foreign key(chargeId)  references employee(eId),
foreign key(leadId)  references employee(eId) 
);

create table financing(
fpId char(10) primary key,
basepay double,
roompay double,
poundage double,
profit double,
foreign key(fpId)  references project(pId) 
);

create table information
(
iTel char(11) ,
ipId char(10),
iName varchar(20),
iNum char(20),
iroom int,
itimes int,
iflag int,
primary key(iTel,ipId),
foreign key(ipId) references project(pId) 
);

create table book
(
bTel char(11) ,
bpId char(10),
bName varchar(20),
bNum char(20),
broom int,
primary key(bTel,bpId),
bflag int,
foreign key(bpId) references project(pId) 
);

create table projectHistory
(
hpId char(10) primary key,
phNumber int,
foreign key(hpId) references project(pId)
);

create table word
(
wpName char(20) primary key,
wNumber int
);


insert into category values('c001','������');
insert into category values('c002','������');


insert into employee values('j001','����','13000000001','����');
insert into employee values('f001','����','13000000002','������');
insert into employee values('f002','������','13000000003','������');
insert into employee values('f003','����','13000000004','������');
insert into employee values('f004','����','1111','������');
insert into employee values('f005','��һ','2222','������');
insert into employee values('f006','�ƶ�','3333','������');
insert into employee values('d001','����','13000000005','����');
insert into employee values('d002','����','13000000006','����');
insert into employee values('d003','������','13000000007','����');
insert into employee values('d004','����','13000000008','����');
insert into employee values('d005','����','4444','����');
insert into employee values('d006','����','5555','����');
insert into employee values('d007','����','6666','����');




insert into user values('13000000001','admin','1');
insert into user values('13000000002','123456','2');
insert into user values('13000000003','123456','2');
insert into user values('13000000004','123456','2');
insert into user values('13000000005','123456','3');
insert into user values('13000000006','123456','3');
insert into user values('13000000007','123456','3');
insert into user values('13000000008','123456','3');                                                                       
insert into user values('12345678900','123456','4'); 
insert into user values('12345678910','123456','4');
insert into user values('12345678902','123456','4');
insert into user values('12345678901','123456','4');
insert into user values('12345678903','123456','4');
insert into user values('12345678904','123456','4');
insert into user values('12345678805','123456','4');
insert into user values('12345678906','123456','4');
insert into user values('13000000100','123456','1');
insert into user values('13000000110','123456','2');
insert into user values('13000000111','123456','2');
insert into user values('13000000200','123456','2');
insert into user values('13000000211','123456','3');
insert into user values('13000000220','123456','3');
insert into user values('13000000222','123456','3');
insert into user values('13000000333','123456','3');                                                                       
insert into user values('12345678033','123456','4'); 
insert into user values('12345678923','123456','4');
insert into user values('99999','123456','4');
insert into user values('88888','123456','4');
insert into user values('77777','123456','4');
insert into user values('66666','123456','4');
insert into user values('55555','123456','4');
insert into user values('12345','123456','4');


insert into salary values('j001',20000,1200,0);
insert into salary values('f001',6000,1200,0);
insert into salary values('f002',6000,1200,0);
insert into salary values('f003',6000,1200,0);
insert into salary values('f004',6000,1200,0);
insert into salary values('f005',6000,1200,0);
insert into salary values('f006',6000,1200,0);
insert into salary values('d001',5000,1200,0);
insert into salary values('d002',5000,1200,0);
insert into salary values('d003',5000,1200,0);
insert into salary values('d004',5000,1200,0);
insert into salary values('d005',5000,1200,0);
insert into salary values('d006',5000,1200,0);
insert into salary values('d007',5000,1200,0);


insert into project values
('p001','����3����','����',3,'2019-07-23','2019-08-03','8��10������7:00տ�������ǻ�,8��13����7:00���ǻ����ǻ��س�',1,3,1,'f001','d005','c001');
insert into project values
('p002','����2����','����',2,'2019-07-24','2019-08-15','8��20������7:30�������ſڴ�ͷ���,8��22����3:30����ͷ���',5,15,1,'f002',null,'c002');
insert into project values
('p003','�Ϻ���ʿ��','�Ϻ�',2,'2019-07-23','2019-08-13','8��20������21:00տ�������ǻ�,8��22������7:00�Ϻ����Ż����ǻ��س�',7,15,1,'f001','d001','c001');
insert into project values
('p004','','�¹�+����+��ʿ+�����13����',13,'2019-07-03','2019-08-03','8��10������7:00տ�������ǻ�,8��23����7:00����������ǻ��س�',8,15,1,'f003','d003','c001');
insert into project values
('p005','��˹�ٰµ·�8��9����','����',9,'2019-07-23','2019-08-03','8��10������7:00տ�������ǻ�,8��19����7:00���������ǻ��س�',8,15,1,'f002','d004','c001');
insert into project values
('p006','Խ��ѿׯ5����','����',3,'2019-07-23','2019-08-03','8��10������7:00տ�������ǻ�,8��13����7:00Խ��ѿׯ�����ǻ��س�',10,15,1,'f001','d001','c001');


insert into financing values('p001',2000,1000,2000,0);
insert into financing values('p002',1800,500,2000,0);
insert into financing values('p003',2900,1000,3000,0);
insert into financing values('p004',8000,5000,6000,0);
insert into financing values('p005',8500,5550,5000,0);
insert into financing values('p006',7000,3000,3000,0);


insert into information values('12345678900','p001','��Զ','440751727158355712',0,1,2);
insert into information values('12345678910','p001','��÷','438273823748373311',1,1,2);
insert into information values('12345678902','p001','������','414632843984783747',1,1,2);
insert into information values('12345678901','p001','����','445755172715835577',2,2,2);
insert into information values('12345678906','p001','����','445755172715835577',0,2,2);
insert into information values('12345678903','p001','л��','445754942710025314',1,2,2);
insert into information values('12345678904','p001','�','414334948326435899',1,1,2);
insert into information values('12345678905','p001','�ƺ�','414632843984783747',1,1,2);



insert into book values('12345678903','p002','л��','445754942710025314',1,1);
insert into book values('12345678904','p002','�','414334948326435899',1,1);
insert into book values('12345678905','p002','�ƺ�','414632843984783747',1,1);
insert into book values('13000000100','p003','��һ','440751727158355712',2,1);
insert into book values('13000000110','p003','���','438273823748373311',1,1);
insert into book values('13000000111','p003','����','440751727158355712',0,1);
insert into book values('13000000200','p003','����','438273823748373311',1,1);
insert into book values('13000000211','p003','����','414632843984783747',1,1);
insert into book values('13000000220','p003','����','445755172715835577',2,1);
insert into book values('13000000222','p003','��˵','445755172715835577',0,1);
insert into book values('13000000333','p003','л˵˵','445754942710025314',1,1);
insert into book values('12345678033','p002','����','414334948326435899',1,1);
insert into book values('12345678923','p002','�ư���','414632843984783747',1,1);
insert into book values('99999','p002','����','438273823748373311',1,1);
insert into book values('88888','p004','����','414632843984783747',1,1);
insert into book values('77777','p003','����','445755172715835577',2,1);
insert into book values('66666','p003','��˵','445755172715835577',0,1);
insert into book values('55555','p003','л˵˵','445754942710025314',1,1);
insert into book values('12345','p004','����','414334948326435899',1,1);


insert into projectHistory values('p006',1);


insert into word values('�Ϻ�',1);


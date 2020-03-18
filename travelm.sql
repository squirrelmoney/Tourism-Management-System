类别表（类别号PK，类型名称）
员工表(员工号PK,姓名,手机号,职称)
用户登陆表（手机号PK，密码，权限）
    权限1-经理 2-负责人 3-导游 4-用户
工资表（员工号,基本工资,五险一金,提成）
项目表(项目号PK，项目名，目的地，旅游持续时间，报名时间，截止时间，详细信息，报团最少人数，报团最多人数，状态，负责人ID(FK)，导游ID(FK),项目类别（fk))
    状态1-报名中  2-报名时间结束  3-搁置
财务表（项目号PK,个人成本，住房费用，手续费，利润）
用户信息表（手机号PK，项目号pk,姓名，身份证号码，房间数，状态）
    状态1-未过期（旅行结束之前） 2-已过期（旅游结束之后）
预约表（手机号PK，项目号pk,姓名，身份证号码，房间数，状态）//临时表
    状态1-预约中  2-预约成功  3-预约失败
历史记录表（项目号PK，次数）
热词搜索表（目的地，次数）



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


insert into category values('c001','跟团游');
insert into category values('c002','自由行');


insert into employee values('j001','黄文','13000000001','经理');
insert into employee values('f001','傅娟','13000000002','负责人');
insert into employee values('f002','林晓琳','13000000003','负责人');
insert into employee values('f003','黄曦','13000000004','负责人');
insert into employee values('f004','零零','1111','负责人');
insert into employee values('f005','林一','2222','负责人');
insert into employee values('f006','黄二','3333','负责人');
insert into employee values('d001','李六','13000000005','导游');
insert into employee values('d002','蒋区','13000000006','导游');
insert into employee values('d003','江天乐','13000000007','导游');
insert into employee values('d004','张天','13000000008','导游');
insert into employee values('d005','李三','4444','导游');
insert into employee values('d006','蒋四','5555','导游');
insert into employee values('d007','江五','6666','导游');




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
('p001','三亚3日游','三亚',3,'2019-07-23','2019-08-03','8月10日早上7:00湛江机场登机,8月13早上7:00三亚机场登机回程',1,3,1,'f001','d005','c001');
insert into project values
('p002','阳江2日游','阳江',2,'2019-07-24','2019-08-15','8月20日早上7:30旅行社门口大巴发车,8月22下午3:30坐大巴返程',5,15,1,'f002',null,'c002');
insert into project values
('p003','上海迪士尼','上海',2,'2019-07-23','2019-08-13','8月20日晚上21:00湛江机场登机,8月22日早上7:00上海虹桥机场登机回程',7,15,1,'f001','d001','c001');
insert into project values
('p004','','德国+法国+瑞士+意大利13日游',13,'2019-07-03','2019-08-03','8月10日早上7:00湛江机场登机,8月23早上7:00意大利机场登机回程',8,15,1,'f003','d003','c001');
insert into project values
('p005','捷斯匈奥德法8晚9日游','三亚',9,'2019-07-23','2019-08-03','8月10日早上7:00湛江机场登机,8月19早上7:00法国机场登机回程',8,15,1,'f002','d004','c001');
insert into project values
('p006','越南芽庄5日游','三亚',3,'2019-07-23','2019-08-03','8月10日早上7:00湛江机场登机,8月13早上7:00越南芽庄机场登机回程',10,15,1,'f001','d001','c001');


insert into financing values('p001',2000,1000,2000,0);
insert into financing values('p002',1800,500,2000,0);
insert into financing values('p003',2900,1000,3000,0);
insert into financing values('p004',8000,5000,6000,0);
insert into financing values('p005',8500,5550,5000,0);
insert into financing values('p006',7000,3000,3000,0);


insert into information values('12345678900','p001','张远','440751727158355712',0,1,2);
insert into information values('12345678910','p001','吴梅','438273823748373311',1,1,2);
insert into information values('12345678902','p001','胡妮妮','414632843984783747',1,1,2);
insert into information values('12345678901','p001','李明','445755172715835577',2,2,2);
insert into information values('12345678906','p001','李明','445755172715835577',0,2,2);
insert into information values('12345678903','p001','谢丽','445754942710025314',1,2,2);
insert into information values('12345678904','p001','李凯','414334948326435899',1,1,2);
insert into information values('12345678905','p001','黄鹤','414632843984783747',1,1,2);



insert into book values('12345678903','p002','谢丽','445754942710025314',1,1);
insert into book values('12345678904','p002','李凯','414334948326435899',1,1);
insert into book values('12345678905','p002','黄鹤','414632843984783747',1,1);
insert into book values('13000000100','p003','张一','440751727158355712',2,1);
insert into book values('13000000110','p003','吴二','438273823748373311',1,1);
insert into book values('13000000111','p003','张三','440751727158355712',0,1);
insert into book values('13000000200','p003','吴四','438273823748373311',1,1);
insert into book values('13000000211','p003','胡六','414632843984783747',1,1);
insert into book values('13000000220','p003','李起','445755172715835577',2,1);
insert into book values('13000000222','p003','李说','445755172715835577',0,1);
insert into book values('13000000333','p003','谢说说','445754942710025314',1,1);
insert into book values('12345678033','p002','李腌','414334948326435899',1,1);
insert into book values('12345678923','p002','黄安安','414632843984783747',1,1);
insert into book values('99999','p002','吴四','438273823748373311',1,1);
insert into book values('88888','p004','胡六','414632843984783747',1,1);
insert into book values('77777','p003','李起','445755172715835577',2,1);
insert into book values('66666','p003','李说','445755172715835577',0,1);
insert into book values('55555','p003','谢说说','445754942710025314',1,1);
insert into book values('12345','p004','李腌','414334948326435899',1,1);


insert into projectHistory values('p006',1);


insert into word values('上海',1);



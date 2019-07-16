-- 用户表创建
create table user_data
(
  id            int auto_increment
    primary key,
  name          varchar(20) not null,
  password      varchar(20) not null,
  register_date date        not null,
  type          varchar(20) not null
);
-- 添加第一个超级用户
insert into user_data (name, password, register_date, type)
values (`sumover`, `2323180`, current_date, `teacher`);

-- 问题表创建
create table questions
(
  id           int auto_increment
    primary key,
  score        int         not null,
  type         varchar(20) not null,
  id_in_others int         not null
);

-- 选择题表创建
create table multiple_choice_questions
(
  id         int auto_increment
    primary key,
  `describe` text not null comment '描述',
  options    text not null comment '选项, 用json表示'
)
  comment '选择题的一个题库';

-- 试卷表的创建
create table examination_paper
(
  id            int auto_increment
    primary key,
  name          varchar(100) not null,
  create_date   date         not null,
  note          text         null,
  question_list text         not null comment '题目id表,字符串类型,两个id之间用空格分开'
)
  comment '试卷';
--
create table examination
(
  id                   int auto_increment
    primary key,
  examination_paper_id int         not null comment '考试用到的试卷的id',
  create_teacher_id    int         not null comment '创建该场考试的老师的id',
  create_time          datetime    not null comment '创建考试的时间',
  begin_time           datetime    not null comment '考试开始时间',
  end_time             datetime    not null comment '考试结束时间',
  status               varchar(20) not null comment '考试状态 public或private'
)
  comment '考试信息';

-- 答案表创建
create table answer
(
  id          int auto_increment comment 'id...这个...'
    primary key,
  ans         varchar(20) not null comment '答案, 为了保证扩展性, 我们用varchar保存, 到时候解析就是了',
  question_id int         not null comment '答案对应题目库的id'
)
  comment '答案表';



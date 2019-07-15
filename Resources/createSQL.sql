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


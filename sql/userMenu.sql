-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信用户', '3', '1', '/module/user', 'C', '0', 'module:user:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '微信用户菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信用户查询', @parentId, '1',  '#',  'F', '0', 'module:user:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信用户新增', @parentId, '2',  '#',  'F', '0', 'module:user:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信用户修改', @parentId, '3',  '#',  'F', '0', 'module:user:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('微信用户删除', @parentId, '4',  '#',  'F', '0', 'module:user:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

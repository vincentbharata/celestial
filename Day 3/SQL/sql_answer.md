select * from employees
select * from departments
select * from projects
select * from employee_projects

-- 1
with total_salary as (
  select department_id, sum(salary) as total
  from employees
  group by department_id
)
select d.name, t.total
from total_salary t
join departments d on t.department_id = d.id;

--2
with no_project as (
  select e.id, e.name
  from employees e
  left join employee_projects p on e.id = p.employee_id
  where p.employee_id is null
)
select name from no_project;

--3
with sort_salary as (
  select 
    name, 
    department_id, 
    salary,
    row_number() over (partition by department_id order by salary desc) as sort
  from employees
)
select name, department_id, salary
from sort_salary
where sort <4;

--4
with average_kerja as (
  select
    name,
    (current_date - hire_date) as masa_kerja
  from employees
), 
average_project as (
  select 
    id, 
    name,
    (end_date - start_date) as masa_project
  from projects
)
select * from average_project;









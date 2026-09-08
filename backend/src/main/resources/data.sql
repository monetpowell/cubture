DELETE FROM income;
DELETE FROM expense;
DELETE FROM childcare;
DELETE FROM savings;



-- =========================================
-- INCOME
-- Tanya & Chris Household
-- =========================================

INSERT INTO income (id, source, amount, date_received, frequency) VALUES
(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-01-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-01-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-01-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-02-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-02-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-02-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-03-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-03-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-03-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-04-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-04-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-04-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-05-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-05-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-05-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-06-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-06-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-06-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-07-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-07-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-07-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-08-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-08-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-08-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-09-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-09-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-09-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-10-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-10-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-10-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-11-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-11-28', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-11-28', 'MONTHLY'),

(UUID_TO_BIN(UUID()), 'Salary - Tanya', 1850.00, '2026-12-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Salary - Chris', 2250.00, '2026-12-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Child Benefit', 110.40, '2026-12-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Christmas Bonus - Chris', 500.00, '2026-12-20', 'ONE_OFF');

-- =========================================
-- EXPENSES
-- Tanya & Chris Household
-- =========================================

INSERT INTO expense (id, name, amount, date_paid, frequency) VALUES

-- JANUARY
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-01-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-01-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 145.00, '2026-01-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-01-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-01-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-01-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 485.00, '2026-01-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 165.00, '2026-01-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-01-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-01-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-01-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-01-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-01-25', 'MONTHLY'),

-- FEBRUARY
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-02-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-02-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 138.00, '2026-02-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-02-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-02-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-02-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 470.00, '2026-02-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 160.00, '2026-02-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-02-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-02-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-02-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-02-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-02-25', 'MONTHLY'),

-- MARCH
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-03-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-03-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 128.00, '2026-03-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-03-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-03-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-03-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 480.00, '2026-03-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 165.00, '2026-03-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-03-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-03-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-03-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-03-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-03-25', 'MONTHLY'),

-- APRIL
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-04-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-04-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 110.00, '2026-04-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-04-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-04-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-04-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 475.00, '2026-04-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 170.00, '2026-04-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-04-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-04-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-04-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-04-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 60.00, '2026-04-25', 'MONTHLY'),
-- MAY
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-05-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-05-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 92.00, '2026-05-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-05-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-05-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-05-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 490.00, '2026-05-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 175.00, '2026-05-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-05-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-05-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-05-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-05-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-05-25', 'MONTHLY'),

-- JUNE
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-06-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-06-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 78.00, '2026-06-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-06-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-06-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-06-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 475.00, '2026-06-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 185.00, '2026-06-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-06-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-06-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-06-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-06-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-06-25', 'MONTHLY'),

-- JULY
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-07-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-07-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 72.00, '2026-07-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-07-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-07-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-07-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 520.00, '2026-07-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 210.00, '2026-07-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-07-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-07-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-07-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-07-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Uniform', 180.00, '2026-07-28', 'ONE_OFF'),

-- AUGUST
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-08-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-08-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 70.00, '2026-08-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-08-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-08-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-08-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 540.00, '2026-08-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 240.00, '2026-08-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-08-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-08-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-08-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-08-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Uniform', 95.00, '2026-08-26', 'ONE_OFF'),
-- SEPTEMBER
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-09-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-09-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 82.00, '2026-09-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-09-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-09-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-09-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 485.00, '2026-09-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 175.00, '2026-09-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-09-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-09-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-09-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-09-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-09-25', 'MONTHLY'),

-- OCTOBER
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-10-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-10-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 105.00, '2026-10-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-10-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-10-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-10-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 500.00, '2026-10-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 165.00, '2026-10-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-10-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-10-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-10-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-10-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-10-25', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Halloween Costumes', 45.00, '2026-10-29', 'ONE_OFF'),

-- NOVEMBER
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-11-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-11-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 128.00, '2026-11-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-11-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-11-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-11-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 490.00, '2026-11-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 170.00, '2026-11-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-11-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-11-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-11-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-11-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 72.00, '2026-11-25', 'MONTHLY'),

-- DECEMBER
(UUID_TO_BIN(UUID()), 'Mortgage', 950.00, '2026-12-01', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Council Tax', 165.00, '2026-12-03', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Gas & Electricity', 155.00, '2026-12-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Water', 38.00, '2026-12-05', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Broadband', 34.99, '2026-12-06', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Mobile Phones', 62.00, '2026-12-07', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Food Shopping', 650.00, '2026-12-10', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Fuel', 190.00, '2026-12-15', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Car Insurance', 58.00, '2026-12-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Home Insurance', 22.00, '2026-12-20', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Netflix', 12.99, '2026-12-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Disney+', 10.99, '2026-12-22', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'School Meals', 40.00, '2026-12-18', 'MONTHLY'),
(UUID_TO_BIN(UUID()), 'Christmas Presents', 650.00, '2026-12-18', 'ONE_OFF');

-- =========================================
-- CHILDCARE
-- Tanya & Chris Household
-- =========================================

INSERT INTO childcare (id, name, amount, date_paid, frequency) VALUES

-- JANUARY
(UUID_TO_BIN(UUID()), 'After School Club', 640.00, '2026-01-31', 'MONTHLY'),

-- FEBRUARY
(UUID_TO_BIN(UUID()), 'After School Club + Half Term Holiday Club', 760.00, '2026-02-28', 'MONTHLY'),

-- MARCH
(UUID_TO_BIN(UUID()), 'After School Club', 640.00, '2026-03-31', 'MONTHLY'),

-- APRIL
(UUID_TO_BIN(UUID()), 'After School Club + Easter Holiday Club', 900.00, '2026-04-30', 'MONTHLY'),

-- MAY
(UUID_TO_BIN(UUID()), 'After School Club + Half Term Holiday Club', 760.00, '2026-05-31', 'MONTHLY'),

-- JUNE
(UUID_TO_BIN(UUID()), 'After School Club', 640.00, '2026-06-30', 'MONTHLY'),

-- JULY
(UUID_TO_BIN(UUID()), 'After School Club + Summer Holiday Club', 950.00, '2026-07-31', 'MONTHLY'),

-- AUGUST
(UUID_TO_BIN(UUID()), 'Summer Holiday Club', 1350.00, '2026-08-31', 'MONTHLY'),

-- SEPTEMBER
(UUID_TO_BIN(UUID()), 'After School Club', 640.00, '2026-09-30', 'MONTHLY'),

-- OCTOBER
(UUID_TO_BIN(UUID()), 'After School Club + Half Term Holiday Club', 760.00, '2026-10-31', 'MONTHLY'),

-- NOVEMBER
(UUID_TO_BIN(UUID()), 'After School Club', 640.00, '2026-11-30', 'MONTHLY'),

-- DECEMBER
(UUID_TO_BIN(UUID()), 'After School Club + Christmas Holiday Club', 980.00, '2026-12-31', 'MONTHLY');


-- =========================================
-- SAVINGS GOALS
-- =========================================

INSERT INTO savings (id, goal_name, target_amount, saved_amount, target_date) VALUES

(UUID_TO_BIN(UUID()), 'Family Holiday', 3000.00, 1650.00, '2027-07-01'),
(UUID_TO_BIN(UUID()), 'Emergency Fund', 5000.00, 2800.00, '2027-12-31'),
(UUID_TO_BIN(UUID()), 'New Family Car', 12000.00, 4200.00, '2028-06-30');
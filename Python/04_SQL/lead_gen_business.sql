-- 1
-- SELECT SUM(amount) as march_2012_revenue FROM billing
-- WHERE charged_datetime >= "2012-03-00"
-- AND charged_datetime <= "2012-03-31"
-- GROUP BY amount;

-- 2
-- SELECT SUM(billing.amount) FROM clients
-- JOIN billing ON clients.id=billing.clients_id
-- WHERE clients.id = 2;

-- 3
-- SELECT * FROM clients
-- JOIN sites ON clients.id=sites.clients_id
-- WHERE clients.id = 10;

-- 4 NOT FINISHED
-- SELECT clients.first_name,clients.last_name,sites.domain_name FROM clients
-- JOIN sites ON clients.id=sites.clients_id
-- WHERE clients.id = 1

-- 5
-- SELECT COUNT(sites.id) FROM sites
-- JOIN leads ON sites.id=leads.sites_id
-- WHERE registered_datetime > "2011-01-01"
-- AND registered_datetime < "2011-02-15";

-- 6
-- SELECT clients.first_name,count(leads.id) AS total_leads FROM clients
-- JOIN sites ON clients.id=sites.clients_id
-- JOIN leads ON sites.id=leads.sites_id
-- WHERE registered_datetime > "2011-01-01"
-- AND registered_datetime < "2011-12-31"
-- GROUP BY clients.first_name;

-- 7
-- SELECT clients.first_name,count(leads.id) AS total_leads FROM clients
-- JOIN sites ON clients.id=sites.clients_id
-- JOIN leads ON sites.id=leads.sites_id
-- WHERE registered_datetime > "2011-01-00"
-- AND registered_datetime < "2011-06-30"
-- GROUP BY clients.id ORDER BY total_leads ASC;

-- 8
-- Just the 1st query.
-- SELECT clients.first_name,SUM(leads.id) total_leads FROM clients
-- JOIN sites ON clients.id=sites.clients_id
-- JOIN leads ON sites.id=leads.sites_id
-- WHERE leads.registered_datetime >= '2011-01-01'
-- AND leads.registered_datetime <= '2011-12-31'
-- GROUP BY clients.id
-- ORDER BY clients.id;

-- 9
-- SELECT clients.first_name,month(billing.charged_datetime),SUM(amount) AS revenue FROM clients
-- JOIN billing ON clients.id=billing.clients_id
-- GROUP BY month(billing.charged_datetime),clients.id
-- ORDER BY clients.id;

-- 10
-- Group Concat is amazing
-- SELECT clients.first_name,GROUP_CONCAT(sites.domain_name) AS sites FROM clients
-- JOIN sites ON clients.id=sites.clients_id
-- GROUP BY clients.id;

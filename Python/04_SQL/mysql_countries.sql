-- 1
-- SELECT name,language,percentage FROM countries
-- JOIN languages ON countries.id = languages.country_id
-- WHERE language = "Slovene" ORDER BY percentage DESC;



-- 2
-- SELECT countries.name,count(countries.id) AS number_of_cities FROM countries
-- JOIN cities on countries.id=cities.country_id
-- GROUP BY countries.name ORDER BY number_of_cities DESC;
 


-- 3
-- SELECT countries.name AS country_name,cities.name AS city_name,cities.population AS population FROM countries
-- JOIN cities ON countries.id=cities.country_id
-- WHERE countries.name = "Mexico" 
-- OR cities.country_code = "MEX"
-- AND cities.population > 500000;



-- 4
-- SELECT languages.language,languages.percentage AS percentage FROM countries
-- JOIN languages ON countries.id=languages.country_id
-- WHERE percentage > 89
-- ORDER BY percentage DESC;



-- 5
-- SELECT countries.name FROM countries
-- WHERE countries.surface_area < 501
-- AND countries.population > 100000;



-- 6
-- SELECT countries.name FROM countries
-- WHERE government_form = "Constitutional Monarchy"
-- AND capital > 200
-- AND life_expectancy > 75;



-- 7
-- SELECT countries.name,cities.name,cities.district,cities.population FROM countries
-- JOIN cities ON countries.id=cities.country_id
-- WHERE countries.name = "Argentina"
-- AND cities.district = "Buenos Aires"
-- AND cities.population > 500000;



-- 8
# Yea, this one took a while.
-- SELECT region,count(name) AS countries_in_region FROM countries
-- GROUP BY region ORDER BY countries_in_region DESC;
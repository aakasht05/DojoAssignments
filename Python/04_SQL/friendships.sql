SELECT CONCAT(u1.first_name,' ',u1.last_name) AS friend_1,CONCAT(u2.first_name,' ',u2.last_name) friend_2
FROM users u1,users u2,friendships f
WHERE u1.id = f.user_id
AND f.friend_id = u2.id
ORDER BY u2.last_name DESC;
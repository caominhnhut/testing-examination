SELECT place
FROM (
    SELECT place,
           SUM(CASE WHEN opinion = 'recommended' THEN 1 ELSE 0 END) as recommended_count,
           SUM(CASE WHEN opinion = 'not recommended' THEN 1 ELSE 0 END) as not_recommended_count
    FROM opinions
    GROUP BY place
) AS counts
WHERE recommended_count > not_recommended_count
ORDER BY place
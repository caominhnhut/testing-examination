SELECT
  C1.country,
  COALESCE(SUM(T1.value), 0) AS export,
  COALESCE(SUM(T2.value), 0) AS import
FROM
  companies C1
LEFT JOIN
  trades T1 ON C1.name = T1.seller
LEFT JOIN
  trades T2 ON C1.name = T2.buyer
GROUP BY
  C1.country
ORDER BY
  C1.country;
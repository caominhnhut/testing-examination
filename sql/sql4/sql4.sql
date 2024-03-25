SELECT 
    Name AS Name,
    Description AS Description,
    CASE 
        WHEN IsEnabled = 0 THEN 'DISABLED'
        ELSE 'ENABLED' 
    END AS Status
FROM 
    UserRole
WHERE 
    Description IS NOT NULL
    AND TRIM(LOWER(CreatedBy)) LIKE 'John Smith%'
    AND Created > '2020-01-03'
    AND Created < '2020-01-07'
    AND Updated IS NULL
ORDER BY 
    Name DESC;
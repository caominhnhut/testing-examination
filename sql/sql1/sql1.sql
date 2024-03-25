SELECT entry_date, entry_time, value
FROM measurements
WHERE value >= (
    SELECT AVG(value) 
    FROM measurements AS m2 
    WHERE m2.entry_date = measurements.entry_date
);
# Write your MySQL query statement below
SELECT
    ROUND(
        AVG(
            CASE
                WHEN order_date = customer_pref_delivery_date THEN 100
                ELSE 0
            END
        ),
        2
    ) AS immediate_percentage
FROM (
    SELECT
        customer_id,
        order_date,
        customer_pref_delivery_date,
        ROW_NUMBER() OVER (
            PARTITION BY customer_id
            ORDER BY order_date
        ) AS rn
    FROM Delivery
) d
WHERE rn = 1;
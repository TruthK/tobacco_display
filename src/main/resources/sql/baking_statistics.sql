TRUNCATE TABLE baking_figures;
INSERT INTO baking_figures (
    SELECT round(sum(baking_weight_before), 2) AS baking_before,
           round(sum(baking_weight_after), 2)  AS baking_after,
           end_time,
           location,
           parent_location,
           avg(score)                          AS score,
           bi.station_id,
           avg(loss_rate)                      AS loss_rate,
           avg(cyanosis_rate)                  AS cyanosis_rate,
           avg(noise_rate)                     AS noise_rate,
           avg(yellow_rate)                    AS yellow_rate,
           avg(single_leaf_before)             AS single_leaf_before,
           avg(single_leaf_after)              AS single_leaf_after,
           avg(water_rate)                     AS water_rate,
           curve_kind,
           avg(curve_contrast)                 AS curve_contrast,
           tobacco_info
    FROM (
             SELECT baking_weight_before,
                    baking_weight_after,
                    device_id,
                    DATE_FORMAT(end_time, '%Y-%m-%d') AS end_time,
                    score,
                    loss_rate,
                    cyanosis_rate,
                    noise_rate,
                    yellow_rate,
                    single_leaf_before,
                    single_leaf_after,
                    water_rate,
                    curve_contrast,
                    curve_kind,
                    tobacco_info
             FROM baking_records
         ) br
             LEFT JOIN (
        SELECT bi.device_id,
               bi.address,
               s.parent_location,
               s.location,
               bi.head,
               bi.head_phone,
               bi.kind,
               bi.create_time,
               bi.device_name,
               s.station_id,
               s.station_name
        FROM bakehouse_info bi
                 LEFT JOIN stations s ON bi.station_id = s.station_id
    ) bi ON br.device_id = bi.device_id
    GROUP BY end_time,
             bi.station_id,
             curve_kind,
             tobacco_info
)
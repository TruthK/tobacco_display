TRUNCATE TABLE baking_statistics;
INSERT into backing_statistics (
    SELECT round(sum(baking_weight_before), 2) as baking_before,
           round(sum(baking_weight_after), 2)  as baking_after,
           end_time,
           location,
           parent_location,
           tobacco_info,
           avg(score) as score
    from (SELECT baking_weight_before,
                 baking_weight_after,
                 tobacco_info,
                 device_id,
                 DATE_FORMAT(end_time, '%Y-%m-%d') as end_time,
                 score
          from baking_records) br
             left JOIN bakehouse_info bi on br.device_id = bi.device_id
    GROUP BY end_time, location, tobacco_info, parent_location)
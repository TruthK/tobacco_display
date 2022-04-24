TRUNCATE TABLE baking_figures;
INSERT into baking_figures (
    SELECT round(sum(baking_weight_before), 2) as baking_before,
           round(sum(baking_weight_after), 2)  as baking_after,
           end_time,
           location,
           parent_location,
           tobacco_info,
           avg(score)   as score,
           bi.station_id
    from (SELECT baking_weight_before,
                 baking_weight_after,
                 tobacco_info,
                 device_id,
                 DATE_FORMAT(end_time, '%Y-%m-%d') as end_time,
                 score
          from baking_records) br
             left JOIN (select bi.device_id,
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
                        from bakehouse_info bi
                                 left join stations s
                                           on bi.station_id = s.station_id) bi on br.device_id = bi.device_id
    GROUP BY end_time, tobacco_info, bi.station_id)
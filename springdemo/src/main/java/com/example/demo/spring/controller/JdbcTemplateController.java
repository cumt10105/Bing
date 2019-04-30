package com.example.demo.spring.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbcTemplate")
public class JdbcTemplateController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbUser(){
        String sql = "select * from tuser";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/user/{name}")
    public Map<String,Object> getUser(@PathVariable String name){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbUser();

        for (Map<String, Object> dbmap : list) {

            Set<String> set = dbmap.keySet();

            for (String key : set) {
                if(key.equals("name")){
                    if(dbmap.get(key).equals(name)){
                        map = dbmap;
                    }
                }
            }
        }

        if(map==null)
            map = list.get(0);
        return map;
    }
}

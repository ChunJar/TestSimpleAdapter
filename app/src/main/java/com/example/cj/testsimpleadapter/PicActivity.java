package com.example.cj.testsimpleadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PicActivity extends Activity {
    private ListView lv;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list;
    private Map<String, Object> map;
    private int[] images = {R.drawable.back, R.drawable.doge};
    private String[] names = {"背景图", "狗"};
    private String[] descs = {"花", "柴犬"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < images.length; i++) {
            map = new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("name", names[i]);
            map.put("desc", descs[i]);
            list.add(map);
        }
        String[] from = {"image", "name", "desc"};
        int[] to = {R.id.pic_img, R.id.pic_name, R.id.pic_desc};
        adapter = new SimpleAdapter(this, list, R.layout.pic_adapter_item, from, to);
        lv.setAdapter(adapter);
    }
}

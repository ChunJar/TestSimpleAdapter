package com.example.cj.testsimpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * SimpleAdapter:可以使用s在多控件进行适配的效果中
 */
public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list;
    private Map<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<Map<String, Object>>();
        for (int i = 1; i < 101; i++) {
            map = new HashMap<String, Object>();
            map.put("data", "数据" + i);
            map.put("intro", "介绍 " + i);
            list.add(map);
        }
        String[] from = {"data", "intro"};
        int[] to = {R.id.data, R.id.intro};
        // 参数一：上下文对象
        // 参数二：数据源
        // 参数三：item对应的布局文件
        // 参数四：map中的key组成的数组
        // 参数五：控件id组成的数组
        //参数四和参数五一定要一一对应
        adapter = new SimpleAdapter(this, list, R.layout.simple_adapter_item, from, to);
        lv.setAdapter(adapter);
    }
}

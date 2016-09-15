package com.example.myapplication;

import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private AutoCompleteTextView acTextView;
    private String[] res={"beijing","beijing2","shanghai1"};
    private MultiAutoCompleteTextView macTextView;
    //private ArrayAdapter<String> adapter;

    private Button ToggleBtn;
    private Button bt1;
    private Button bt2;
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * AutoCompleteTextView
         * 第一步：初始化控件
         * 第二步：添加适配器
         * 第三步：初始化数据源--这数据源去匹配文本框输入的内容
         * 第四步：将adapter与当前AutoCompleteTextView绑定
         */
        acTextView= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,res);
        acTextView.setAdapter(adapter);

        /**
         * MultiAutoCompleteTextView
         * 第一步：初始化控件
         * 第二步：添加适配器
         * 第三步：初始化数据源--这数据源去匹配文本框输入的内容
         * 第四步：将adapter与当前AutoCompleteTextView绑定
         * 第五步：设置分隔符
         */
        macTextView= (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        macTextView.setAdapter(adapter);
        //设置以逗号分隔符为结束的符号,Tokenizer:分词器；Comma：逗号
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        /**
         * 匿名内部类监听
         * 1.初始化当前所需要的控件
         * findViewById---返回View对象
         *
         * 2.设置Button的监听器，通过监听器
         *
         */
        ToggleBtn= (Button) findViewById(R.id.toggleButton);
        /**
         * 1.监听事件方法一、（匿名内部类监听）
         */
        ToggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在当前onClick方法中监听点击Button的动作

                System.out.println("我的 Button被点击了");

            }
        });
        bt1=(Button) findViewById(R.id.button1);
        bt2= (Button) findViewById(R.id.button2);
        /**
         * 2.监听事件方法二、外部类
         *      使用较少
         *      1.事件监听器通常属于特定的GUI界面（UI界面:User Interface,用户界面），定义成外部类
         * 不利于提高程序的内聚性
         *      2.外部类的形式的事件监听器不能自由访问创建GUI界面的类中的组件，编程不够简洁
         *
         */
        bt1.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View v) {
               //调用父类的onClick
                super.onClick(v);
                Toast.makeText(MainActivity.this," bt1要执行的逻辑", 1).show();
                //MainActivity.this--匿名内部类访问不到外部类的this，所以类名.this调用
            }
        });
        bt2.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View v) {
                //调用父类的onClick
                super.onClick(v);
                Toast.makeText(MainActivity.this," bt2要执行的逻辑", 1).show();
                //MainActivity.this--匿名内部类访问不到外部类的this，所以类名.this调用
            }
        });
        bt3= (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View v) {
                //调用父类的onClick
                super.onClick(v);
                Toast.makeText(MainActivity.this," bt2要执行的逻辑", 1).show();
                //MainActivity.this--匿名内部类访问不到外部类的this，所以类名.this调用
            }
        });

    }
}

/**
 * OnClickListener是接口
 */
class  MyOnClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        System.out.println("父类的onClick事件");
        //改变button的透明度
        v.setAlpha(0.5f);
    }

}

class  MyOnClickListener1 implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        System.out.println("父类的onClick事件");
        //改变button的透明度
        v.setAlpha(0.5f);
    }
}
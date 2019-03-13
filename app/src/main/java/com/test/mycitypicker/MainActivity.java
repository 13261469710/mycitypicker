package com.test.mycitypicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;

/**
 * 城市选择器应用
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView cityTextView;
    CityPickerView mPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityTextView = findViewById(R.id.activity_main_city_picker);
        cityTextView.setOnClickListener(this);
        initCityPicker();
    }

    /**
     * 初始化城市选择
     */
    private void initCityPicker(){

        //初始化地区pop
        mPicker=new CityPickerView();
        mPicker.init(this);
                CityConfig cityConfig = new CityConfig.Builder().title("选择城市")
                .titleTextSize(18)//标题文字大小
                .titleBackgroundColor("#E9E9E9")
                .titleTextColor("#585858")
                .confirTextColor("#585858")//确认按钮文字颜色
                .confirmText("确定")//确认按钮文字
                .confirmTextSize(16)//确认按钮文字大小
                .cancelTextColor("#585858")//取消按钮文字颜色
                .cancelText("取消")//取消按钮文字
                .cancelTextSize(16)//取消按钮文字大小
                .setCityWheelType(CityConfig.WheelType.PRO_CITY_DIS)//显示类，只显示省份一级，显示省市两级还是显示省市区三级
                .showBackground(true)//是否显示半透明背景
                .visibleItemsCount(7)//显示item的数量
                .province("河北省")//默认显示的省份
                .city("唐山市")//默认显示省份下面的城市
                .district("路北区")//默认显示省市下面的区县数据
                .provinceCyclic(true)//省份滚轮是否可以循环滚动
                .cityCyclic(true)//城市滚轮是否可以循环滚动
                .districtCyclic(true)//区县滚轮是否循环滚动
                .build();
        mPicker.setConfig(cityConfig);

//监听选择点击事件及返回结果
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, com.lljjcoder.bean.CityBean city, DistrictBean district) {
                super.onSelected(province, city, district);

                //省份
                if (province != null) {

                }

                //城市
                if (city != null) {

                }

                //地区
                if (district != null) {

                }
                cityTextView.setText(province.getName()+city.getName()+district.getName());//将结果显示在界面
            }

            @Override
            public void onCancel() {
                super.onCancel();
                //取消
            }
        });


    }

    /**
     * 单击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.activity_main_city_picker){
            mPicker.showCityPicker( );//显示城市选择

        }
    }
}

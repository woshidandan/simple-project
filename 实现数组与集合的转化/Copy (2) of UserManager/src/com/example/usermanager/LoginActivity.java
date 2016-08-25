package com.example.usermanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	public  static boolean is_debug=true;
	String username;
	String password;
	EditText  name;
	EditText  pwd;
	private ImageView iv_left;
	private ImageView iv_right;
	private TextView tv_title;
	
	//主要控制我们手机屏幕的显示
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载对应布局
		setContentView(R.layout.activity_main);
		initView();
		iv_left.setVisibility(View.INVISIBLE);
		iv_right.setVisibility(View.INVISIBLE); 
		if(is_debug=false){
			name.setText("");
			pwd.setText("");
		}
		//tv_title.setText("UserManager");
	}
	private void initView() {
		name=(EditText)findViewById(R.id.editText1);
		pwd=(EditText) findViewById(R.id.editText2);
		iv_left=(ImageView) findViewById(R.id.imageView1);
		iv_right=(ImageView) findViewById(R.id.imageView2);
		tv_title=(TextView) findViewById(R.id.title);
	}
	//ctrl+shift+o
	public void doClick(View view){
		username=name.getText().toString();
		password=pwd.getText().toString();
		if(username.equals("admin")&&password.equals("123456")){
			Intent intent=new Intent(
					LoginActivity.this,
					WelcomeActivity.class);
			intent.putExtra("name", username); //key和value的值
			//启动意图
			startActivity(intent);
		}else{
			Toast.makeText(
					getApplicationContext(),
					"用户名或者密码输入错误", 1).show();	
		}
	}
	//创建菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

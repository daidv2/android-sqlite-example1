package net.xuanthulab.sqlitetutorial.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import net.xuanthulab.sqlitetutorial.R;

public class ActionBar extends AppCompatActivity implements FirstFragment.OnFirstFragmentListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        drawerLayout = findViewById(R.id.activity_main_drawer);
        // làm nhiệm vụ điều khiển việc đóng mở DrawerLayout
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        // set icon hamburger xuất hiện trên ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FirstFragment firstFragment = new FirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.firstFrame, firstFragment);
        fragmentTransaction.commit();
    }

    // onSaveInstanceState: lưu lại state trước khi hủy activity
    // onRestoreInstanceState: Mỗi khi OnCreate khởi chạy, nếu có trạng thái được lưu lại
    // thì sau khi gọi onCreate Activity sẽ tự động gọi phương thức onRestoreInstanceState
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    // Một số cấu hình của thiết bị có thể thay đổi khi ứng dụng đang chạy (ví dụ: hướng màn hình).
    // Khi có sự thay đổi này, Android sẽ khởi động lại Activity (onDestroy() sẽ được gọi,
    // sau đó là onCreate()) để điều chỉnh phù hợp với cấu hình mới.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    // nạp main_actions vào ActionBar của Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // bắt event khi bấm vào các menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        Bundle bundle = new Bundle();
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Intent intent = new Intent(this, ContactActivity.class);
                bundle.putString(ContactActivity.KEY_SHOW_WHAT, ContactActivity.VALUE_SHOW_ABOUT);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            case R.id.help:
                intent = new Intent(this, ContactActivity.class);
                bundle.putString(ContactActivity.KEY_SHOW_WHAT, ContactActivity.VALUE_SHOW_HELP);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemPressed(String content) {
        SecondFragment secondFragment = SecondFragment.newInstance(content);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.secondFrame, secondFragment);
        fragmentTransaction.commit();
    }
}

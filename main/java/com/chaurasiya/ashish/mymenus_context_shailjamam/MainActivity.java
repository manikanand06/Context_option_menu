package com.chaurasiya.ashish.mymenus_context_shailjamam;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1;
    MenuItem mi;
    ActionMode am;
    ActionMode.Callback amc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.t1);
        b1=(Button)findViewById(R.id.b1);
        registerForContextMenu(t1);
        amc=new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.my_menu,menu);
                mode.setTitle("Contextual : ");
                mode.setSubtitle("Subtitle");
                return true;
            }
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return true;
            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(MainActivity.this,""+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        };
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                am=startActionMode(amc);
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        menu.add(0,1,5,"About us");
        SubMenu ab=menu.addSubMenu("Sub menu");
        ab.add(0,2,0,"Sub menu 1");
        ab.add(0,3,0,"Sub menu 1");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int k=item.getItemId();
        switch(k)
        {
            case R.id.i1:
                Toast.makeText(this,""+item.getItemId(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"Save as");
        menu.add(0,1,0,"Download");
        menu.add(0,1,0,"open in new tab");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int a=item.getItemId();
        switch (a)
        {
            case 1:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

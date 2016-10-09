package qianfeng.a7_2snackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        snackbar = Snackbar.make(view, "Hello", Snackbar.LENGTH_INDEFINITE); // 显示无限长的时间

        View snackbarView = snackbar.getView();

        snackbarView.setBackgroundColor(Color.BLUE);

        // 找到snackbar中的textView，是系统写好的
        TextView snackbarText = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);

        snackbarText.setTextColor(Color.BLACK);


        snackbar // 这个view类似于popupWindow一样，是依附于这个token来生成的自身的。就是要依附哪个控件生成自身,显示在哪个Activity上
                .setAction("弹出Toast", new View.OnClickListener() { //设置交互文本及点击行为
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(Color.RED)
                .show();
    }


    public void close(View view) {
        snackbar.dismiss(); // 关闭snackbar，如果你在其他地方点击，snackbar是不会消失的！
    }
}

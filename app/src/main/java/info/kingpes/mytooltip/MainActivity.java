package info.kingpes.mytooltip;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt = findViewById(R.id.tv);
        final TextView txt1 = findViewById(R.id.tv1);
        final TextView txt2 = findViewById(R.id.tv2);
        final TextView txt3 = findViewById(R.id.tv3);
        final TextView txt4 = findViewById(R.id.tv4);
        final TextView txt5 = findViewById(R.id.tv5);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTooltip
                        .on(v)
                        .autoHide(true, 1000)
                        .position(MyTooltip.Position.RIGHT)
                        .text("Hello Kingpes")
                        .show();
            }
        });


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTooltip
                        .on(v)
                        .position(MyTooltip.Position.TOP)
                        .text("hello")
                        .show();
            }
        });


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTooltip
                        .on(v)
                        .color(Color.BLACK)
                        .distanceWithView(0)
                        .arrowHeight(0)
                        .arrowWidth(0)
                        .padding(20, 20, 20, 20)
                        .position(MyTooltip.Position.BOTTOM)
                        .align(MyTooltip.ALIGN.START)
                        .text("Hello")
                        .show();
            }
        });


        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTooltip
                        .on(v)
                        .color(Color.BLACK)
                        .position(MyTooltip.Position.TOP)
                        .text("bottomRight bottomRight bottomRight")
                        .show();
            }
        });


        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTooltip
                        .on(v)
                        .color(Color.BLACK)
                        .position(MyTooltip.Position.TOP)
                        .text("bottomLeft bottomLeft bottomLeft")
                        .show();
            }
        });


        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTooltip
                        .on(v)
                        // .customView(customView)
                        .position(MyTooltip.Position.LEFT)
                        .arrowSourceMargin(0)
                        .arrowTargetMargin(0)
                        .text("Hellooooo")
                        .clickToHide(true)
                        .autoHide(false, 0)
                        .color(createPaint())
                        .animation(new MyTooltip.FadeTooltipAnimation(500))
                        .onDisplay(new MyTooltip.ListenerDisplay() {
                            @Override
                            public void onDisplay(View view) {
                                Log.d("ViewTooltip", "onDisplay");
                            }
                        })
                        .onHide(new MyTooltip.ListenerHide() {
                            @Override
                            public void onHide(View view) {
                                Log.d("ViewTooltip", "onHide");
                            }
                        })
                        .show();
            }
        });
    }

    private Paint createPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(new LinearGradient(0, 0, 0, 600, BLUE, GREEN, Shader.TileMode.CLAMP));
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }
}

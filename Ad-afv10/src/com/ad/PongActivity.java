package com.ad;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;

public class PongActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Pong(this));
	}

	public class Pong extends View {
		float x = 50, y = 50;
		String action = "action";
		Path path = new Path();		
		public Pong(Context context) {
			super(context);
		}
		
		public boolean onTouchEvent(MotionEvent event) {
			Log.i("log", "onTouch");
			x= event.getX();
			y= event.getY();
			if(event.getAction()==MotionEvent.ACTION_DOWN){
				action="down";
			}
			if(event.getAction()==MotionEvent.ACTION_MOVE){
				action="move";
			}
			Log.i("log", "x:" + event.getX() + " y:" + event.getY());
			invalidate();
			return true;
		}

		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			Paint paint = new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(6);;
			paint.setColor(Color.RED);
			if(action == "down"){
				path.moveTo(x,y);
			}if(action == "move"){
				path.lineTo(x, y);
			}
			canvas.drawPath(path, paint);
		}
	}
}
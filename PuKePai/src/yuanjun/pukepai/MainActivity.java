package yuanjun.pukepai;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	TextView tv1, tv2;
	Button button;
	MediaPlayer mediaPlayer;
	ImageButton imageButton;
	boolean flag = false;
    
	String[] PuKePai = new String[] { "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "J", "Q", "K", "A" };
	int[] LiShuDu = new int[] { 0, 8, 16, 24, 32, 41, 49, 58, 66, 75, 84, 91,
			100 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initSounds();
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		button = (Button) findViewById(R.id.button1);
		imageButton = (ImageButton) findViewById(R.id.imageButton1);
		
		OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (flag) {
					imageButton.setImageDrawable(getResources().getDrawable(
							R.drawable.state1));
					initSounds();
					mediaPlayer.setLooping(true);
					mediaPlayer.start();
					flag = false;

				} else {
					imageButton.setImageDrawable(getResources().getDrawable(
							R.drawable.state2));
					mediaPlayer.stop();
					mediaPlayer.setLooping(false);
					flag = true;
				}
			}
		};
		imageButton.setOnClickListener(listener);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (v == button) {
					int temp = (int) (Math.random() * PuKePai.length);
					tv1.setText("您的牌为：" + PuKePai[temp]);
					tv2.setText("赢的概率为：" + LiShuDu[temp] + "%");
				}
			}
		});

	}

	private void initSounds() {
		// TODO Auto-generated method stub
		
		mediaPlayer = MediaPlayer.create(this, R.raw.background);
		
	}
	
	public void onClick(View v) {

	}
}

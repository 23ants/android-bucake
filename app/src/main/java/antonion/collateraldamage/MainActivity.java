package antonion.collateraldamage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAdView();
        initGifView();
    }

    private void initAdView() {
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void initGifView() {
        GifImageButton gib = findViewById(R.id.imageView);
        final MediaController mc = new MediaController(this);
        mc.setMediaPlayer((GifDrawable) gib.getDrawable());
        mc.setAnchorView(gib);
        gib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc.show();
            }
        });
    }
}

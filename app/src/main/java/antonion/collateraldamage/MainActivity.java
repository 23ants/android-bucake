package antonion.collateraldamage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                shareAction();
                break;
            default:
                break;
        }

        return true;
    }

    private void shareAction() {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Bucake");
            String sAux = "https://play.google.com/store/apps/details?id=twentythree.ants.bucake";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "Compartir en"));
        } catch(Exception e) {
            //e.toString();
        }
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

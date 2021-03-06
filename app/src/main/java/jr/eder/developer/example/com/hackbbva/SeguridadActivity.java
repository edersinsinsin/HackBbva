package jr.eder.developer.example.com.hackbbva;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import devlight.io.library.ArcProgressStackView;
import jr.eder.developer.example.com.hackbbva.ui.ChooseActionActivity;
import jr.eder.developer.example.com.hackbbva.ui.PotentialRobersActivity;

public class SeguridadActivity extends AppCompatActivity {
    @BindView(R.id.apsv_presentation)
    ArcProgressStackView arcProgressStackView;
    public final static int MODEL_COUNT = 4;
    private int[]
            mStartColors = new int[MODEL_COUNT];
    private int[] mEndColors = new int[MODEL_COUNT];
    private Bundle bundle;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        id=bundle.getString("Algo");
    }
    public void setArcProgressStackViewValues(){

        // Get colors
        final String[] startColors = getResources().getStringArray(R.array.devlight);
        final String[] endColors = getResources().getStringArray(R.array.default_preview);
        final String[] bgColors = getResources().getStringArray(R.array.medical_express);
        for (int i = 0; i < MODEL_COUNT; i++) {
            mStartColors[i] = Color.parseColor(startColors[i]);
            mEndColors[i] = Color.parseColor(endColors[i]);
        }
        List<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("Molestia", 70, Color.parseColor(bgColors[0]), mStartColors[3]));
        models.add(new ArcProgressStackView.Model("Desprecio", 23, Color.parseColor(bgColors[1]), mStartColors[2]));
        models.add(new ArcProgressStackView.Model("Disgusto", 34, Color.parseColor(bgColors[2]), mStartColors[1]));
        models.add(new ArcProgressStackView.Model("Neutral", 23, Color.parseColor(bgColors[3]), mStartColors[0]));
        arcProgressStackView.setModels(models);
        for (ArcProgressStackView.Model model : arcProgressStackView.getModels());
        arcProgressStackView.animateProgress();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,
                PotentialRobersActivity.class);
        startActivity(intent);
        finish();
    }
}
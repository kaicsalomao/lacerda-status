package com.lacerdagroup.status.ui.onboarding;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroCustomLayoutFragment;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.lacerdagroup.status.R;

public class OnboardingActivity extends AppIntro {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTransformer(AppIntroPageTransformerType.Fade.INSTANCE);
    
    addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.fragment_onboarding_01));
    addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.fragment_onboarding_02));
    addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.fragment_onboarding_03));

    setImmersiveMode();
    setButtonsEnabled(true);
    setWizardMode(true);
  }

  @Override
  protected void onSkipPressed(Fragment arg0) {
    super.onSkipPressed(arg0);
    finish();
    // TODO: Implement this method
  }

  @Override
  protected void onDonePressed(Fragment arg0) {
    super.onDonePressed(arg0);
    finish();
    // TODO: Implement this method
  }
}

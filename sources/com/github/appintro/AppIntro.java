package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.github.appintro.internal.TypefaceContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class AppIntro extends AppIntroBase {
    private final int layoutId = R.layout.appintro_intro_layout;

    @Override // com.github.appintro.AppIntroBase
    protected int getLayoutId() {
        return this.layoutId;
    }

    public final void setBackArrowColor(int i3) {
        ((ImageButton) findViewById(R.id.back)).setColorFilter(i3);
    }

    public final void setBarColor(int i3) {
        findViewById(R.id.bottom).setBackgroundColor(i3);
    }

    public final void setColorDoneText(int i3) {
        ((TextView) findViewById(R.id.done)).setTextColor(i3);
    }

    public final void setColorSkipButton(int i3) {
        ((TextView) findViewById(R.id.skip)).setTextColor(i3);
    }

    public final void setDoneText(CharSequence charSequence) {
        TextView doneText = (TextView) findViewById(R.id.done);
        Intrinsics.checkNotNullExpressionValue(doneText, "doneText");
        doneText.setText(charSequence);
    }

    public final void setDoneTextAppearance(int i3) {
        TextViewCompat.o((TextView) findViewById(R.id.done), i3);
    }

    public final void setDoneTextTypeface(String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setImageNextButton(Drawable imageNextButton) {
        Intrinsics.checkNotNullParameter(imageNextButton, "imageNextButton");
        ((ImageView) findViewById(R.id.next)).setImageDrawable(imageNextButton);
    }

    public final void setNextArrowColor(int i3) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i3);
    }

    public final void setSeparatorColor(int i3) {
        findViewById(R.id.bottom_separator).setBackgroundColor(i3);
    }

    public final void setSkipText(CharSequence charSequence) {
        TextView skipText = (TextView) findViewById(R.id.skip);
        Intrinsics.checkNotNullExpressionValue(skipText, "skipText");
        skipText.setText(charSequence);
    }

    public final void setSkipTextAppearance(int i3) {
        TextViewCompat.o((TextView) findViewById(R.id.skip), i3);
    }

    public final void setSkipTextTypeface(int i3) {
        new TypefaceContainer(null, i3).applyTo((TextView) findViewById(R.id.skip));
    }

    public final void showSeparator(boolean z2) {
        View bottomSeparator = findViewById(R.id.bottom_separator);
        if (z2) {
            Intrinsics.checkNotNullExpressionValue(bottomSeparator, "bottomSeparator");
            bottomSeparator.setVisibility(0);
        } else {
            Intrinsics.checkNotNullExpressionValue(bottomSeparator, "bottomSeparator");
            bottomSeparator.setVisibility(4);
        }
    }

    public final void setDoneText(int i3) {
        ((TextView) findViewById(R.id.done)).setText(i3);
    }

    public final void setDoneTextTypeface(int i3) {
        new TypefaceContainer(null, i3).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setSkipText(int i3) {
        ((TextView) findViewById(R.id.skip)).setText(i3);
    }

    public final void setSkipTextTypeface(String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.skip));
    }
}

package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
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
public abstract class AppIntro2 extends AppIntroBase {
    private Drawable backgroundDrawable;
    private ConstraintLayout backgroundFrame;
    private Integer backgroundResource;
    private View bottomBar;
    private final int layoutId = R.layout.appintro_intro_layout2;
    private ImageButton skipImageButton;

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final Integer getBackgroundResource() {
        return this.backgroundResource;
    }

    @Override // com.github.appintro.AppIntroBase
    protected int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewFindViewById = findViewById(R.id.background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.background)");
        this.backgroundFrame = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.bottom);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.bottom)");
        this.bottomBar = viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.skip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.skip)");
        this.skipImageButton = (ImageButton) viewFindViewById3;
        if (isRtl$appintro_release()) {
            ImageButton imageButton = this.skipImageButton;
            if (imageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipImageButton");
            }
            imageButton.setScaleX(-1.0f);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.backgroundDrawable = drawable;
        if (drawable != null) {
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundFrame");
            }
            constraintLayout.setBackground(this.backgroundDrawable);
        }
    }

    public final void setBackgroundResource(Integer num) {
        this.backgroundResource = num;
        if (num == null || num == null) {
            return;
        }
        int iIntValue = num.intValue();
        ConstraintLayout constraintLayout = this.backgroundFrame;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundFrame");
        }
        constraintLayout.setBackgroundResource(iIntValue);
    }

    public final void setBarColor(int i3) {
        View view = this.bottomBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
        }
        view.setBackgroundColor(i3);
    }

    public final void setImageSkipButton(Drawable imageSkipButton) {
        Intrinsics.checkNotNullParameter(imageSkipButton, "imageSkipButton");
        ImageButton imageButton = this.skipImageButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipImageButton");
        }
        imageButton.setImageDrawable(imageSkipButton);
    }

    public final void setNextArrowColor(int i3) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i3);
    }

    public final void setSkipArrowColor(int i3) {
        ((ImageButton) findViewById(R.id.skip)).setColorFilter(i3);
    }
}

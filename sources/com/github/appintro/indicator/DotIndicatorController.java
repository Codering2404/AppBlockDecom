package com.github.appintro.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.github.appintro.R;
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
public final class DotIndicatorController extends LinearLayout implements IndicatorController {
    private int currentPosition;
    private int selectedIndicatorColor;
    private int slideCount;
    private int unselectedIndicatorColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotIndicatorController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedIndicatorColor = ContextCompat.getColor(context, R.color.appintro_default_selected_color);
        this.unselectedIndicatorColor = ContextCompat.getColor(context, R.color.appintro_default_unselected_color);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void initialize(int i3) {
        this.slideCount = i3;
        for (int i4 = 0; i4 < i3; i4++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_appintro_indicator));
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i3 == 1) {
                imageView.setVisibility(4);
            }
            addView(imageView, layoutParams);
        }
        selectPosition(0);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public View newInstance(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        setOrientation(0);
        setGravity(17);
        return this;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void selectPosition(int i3) {
        this.currentPosition = i3;
        int i4 = this.slideCount;
        int i5 = 0;
        while (i5 < i4) {
            int selectedIndicatorColor = i5 == i3 ? getSelectedIndicatorColor() : getUnselectedIndicatorColor();
            View childAt = getChildAt(i5);
            if (childAt == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            DrawableCompat.n(((ImageView) childAt).getDrawable(), selectedIndicatorColor);
            i5++;
        }
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setSelectedIndicatorColor(int i3) {
        this.selectedIndicatorColor = i3;
        selectPosition(this.currentPosition);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setUnselectedIndicatorColor(int i3) {
        this.unselectedIndicatorColor = i3;
        selectPosition(this.currentPosition);
    }
}

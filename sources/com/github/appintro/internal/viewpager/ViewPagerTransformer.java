package com.github.appintro.internal.viewpager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.AppIntroPageTransformerType;
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
public final class ViewPagerTransformer implements ViewPager.PageTransformer {
    private double descriptionPF;
    private double imagePF;
    private double titlePF;
    private final AppIntroPageTransformerType transformType;

    public ViewPagerTransformer(AppIntroPageTransformerType transformType) {
        Intrinsics.checkNotNullParameter(transformType, "transformType");
        this.transformType = transformType;
    }

    private final void applyParallax(View view, float f3) {
        View viewFindViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "page.findViewById<TextView>(R.id.title)");
        ((TextView) viewFindViewById).setTranslationX(computeParallax(view, f3, this.titlePF));
        View viewFindViewById2 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "page.findViewById<ImageView>(R.id.image)");
        ((ImageView) viewFindViewById2).setTranslationX(computeParallax(view, f3, this.imagePF));
        View viewFindViewById3 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "page.findViewById<TextView>(R.id.description)");
        ((TextView) viewFindViewById3).setTranslationX(computeParallax(view, f3, this.descriptionPF));
    }

    private final float computeParallax(View view, float f3, double d3) {
        return (float) (((double) (-f3)) * (((double) view.getWidth()) / d3));
    }

    private final void transformDepth(float f3, View view) {
        if (f3 > 0) {
            float f4 = 1;
            if (f3 < f4) {
                view.setAlpha(f4 - f3);
                ViewPagerTransformerKt.setScaleXY(view, ((f4 - Math.abs(f3)) * 0.25f) + 0.75f);
                view.setTranslationX(view.getWidth() * (-f3));
                return;
            }
        }
        ViewPagerTransformerKt.transformDefaults(view);
    }

    private final void transformFade(float f3, View view) {
        if (f3 <= -1.0f || f3 >= 1.0f) {
            view.setTranslationX(view.getWidth());
            view.setAlpha(0.0f);
            view.setClickable(false);
        } else if (f3 != 0.0f) {
            view.setTranslationX(view.getWidth() * (-f3));
            view.setAlpha(1.0f - Math.abs(f3));
        } else {
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
            view.setClickable(true);
        }
    }

    private final void transformParallax(float f3, View view) {
        if (f3 <= -1 || f3 >= 1) {
            return;
        }
        try {
            applyParallax(view, f3);
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        }
    }

    private final void transformSlideOver(float f3, View view) {
        if (f3 >= 0 || f3 <= -1) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f4 = 1;
        ViewPagerTransformerKt.setScaleXY(view, (Math.abs(Math.abs(f3) - f4) * 0.14999998f) + 0.85f);
        view.setAlpha(Math.max(0.35f, f4 - Math.abs(f3)));
        float f5 = -view.getWidth();
        float f6 = f3 * f5;
        if (f6 > f5) {
            view.setTranslationX(f6);
        } else {
            view.setTranslationX(0.0f);
        }
    }

    private final void transformZoom(float f3, View view) {
        if (f3 >= -1) {
            float f4 = 1;
            if (f3 <= f4) {
                ViewPagerTransformerKt.setScaleXY(view, Math.max(0.85f, f4 - Math.abs(f3)));
                view.setAlpha((((ViewPagerTransformerKt.getScaleXY(view) - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
                float f5 = 2;
                float height = (view.getHeight() * (f4 - ViewPagerTransformerKt.getScaleXY(view))) / f5;
                float width = (view.getWidth() * (f4 - ViewPagerTransformerKt.getScaleXY(view))) / f5;
                if (f3 < 0) {
                    view.setTranslationX(width - (height / f5));
                    return;
                } else {
                    view.setTranslationX((-width) + (height / f5));
                    return;
                }
            }
        }
        ViewPagerTransformerKt.transformDefaults(view);
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View page, float f3) {
        Intrinsics.checkNotNullParameter(page, "page");
        AppIntroPageTransformerType appIntroPageTransformerType = this.transformType;
        if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Flow.INSTANCE)) {
            page.setRotationY(f3 * (-30.0f));
            return;
        }
        if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.SlideOver.INSTANCE)) {
            transformSlideOver(f3, page);
            return;
        }
        if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Depth.INSTANCE)) {
            transformDepth(f3, page);
            return;
        }
        if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Zoom.INSTANCE)) {
            transformZoom(f3, page);
            return;
        }
        if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Fade.INSTANCE)) {
            transformFade(f3, page);
        } else if (appIntroPageTransformerType instanceof AppIntroPageTransformerType.Parallax) {
            this.titlePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getTitleParallaxFactor();
            this.imagePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getImageParallaxFactor();
            this.descriptionPF = ((AppIntroPageTransformerType.Parallax) this.transformType).getDescriptionParallaxFactor();
            transformParallax(f3, page);
        }
    }
}

package cz.mobilesoft.coreblock.util.view;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f3) {
        Intrinsics.checkNotNullParameter(view, "view");
        int width = view.getWidth();
        int height = view.getHeight();
        if (f3 < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f3 > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float f4 = 1;
        float fMax = Math.max(0.85f, f4 - Math.abs(f3));
        float f5 = f4 - fMax;
        float f6 = 2;
        float f7 = (height * f5) / f6;
        float f8 = (width * f5) / f6;
        view.setTranslationX(f3 < 0.0f ? f8 - (f7 / f6) : f8 + (f7 / f6));
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.setAlpha((((fMax - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
    }
}

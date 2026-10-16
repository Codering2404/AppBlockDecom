package com.github.appintro.internal.viewpager;

import android.view.View;
import kotlin.Metadata;

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
public final class ViewPagerTransformerKt {
    private static final float FLOW_ROTATION_ANGLE = -30.0f;
    private static final float MIN_ALPHA_SLIDE = 0.35f;
    private static final float MIN_ALPHA_ZOOM = 0.5f;
    private static final float MIN_SCALE_DEPTH = 0.75f;
    private static final float MIN_SCALE_ZOOM = 0.85f;
    private static final float SCALE_FACTOR_SLIDE = 0.85f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getScaleXY(View view) {
        return view.getScaleX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScaleXY(View view, float f3) {
        view.setScaleX(f3);
        view.setScaleY(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transformDefaults(View view) {
        view.setAlpha(1.0f);
        setScaleXY(view, 1.0f);
        view.setTranslationX(0.0f);
    }
}

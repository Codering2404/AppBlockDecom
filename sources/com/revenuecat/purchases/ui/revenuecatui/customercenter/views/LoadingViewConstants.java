package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class LoadingViewConstants {
    public static final float PLACEHOLDER_ALPHA = 0.15f;
    public static final LoadingViewConstants INSTANCE = new LoadingViewConstants();
    private static final RoundedCornerShape PLACEHOLDER_SHAPE = RoundedCornerShapeKt.d(Dp.g(4));
    private static final float TITLE_WIDTH = Dp.g(SensibleDefaults.X_OFFSET);
    private static final float TITLE_HEIGHT = Dp.g(20);
    private static final float SUBTITLE_WIDTH = Dp.g(220);
    private static final float BODY_HEIGHT = Dp.g(16);
    private static final float STORE_WIDTH = Dp.g(100);
    private static final float BUTTON_HEIGHT = Dp.g(48);
    private static final RoundedCornerShape BUTTON_SHAPE = RoundedCornerShapeKt.d(Dp.g(24));
    private static final float BADGE_WIDTH = Dp.g(60);
    private static final float BADGE_HEIGHT = Dp.g(22);
    private static final RoundedCornerShape BADGE_SHAPE = RoundedCornerShapeKt.d(CustomerCenterConstants.Card.INSTANCE.m952getBADGE_CORNER_SIZED9Ej5fM());

    private LoadingViewConstants() {
    }

    /* JADX INFO: renamed from: getBADGE_HEIGHT-D9Ej5fM, reason: not valid java name */
    public final float m1040getBADGE_HEIGHTD9Ej5fM() {
        return BADGE_HEIGHT;
    }

    public final RoundedCornerShape getBADGE_SHAPE() {
        return BADGE_SHAPE;
    }

    /* JADX INFO: renamed from: getBADGE_WIDTH-D9Ej5fM, reason: not valid java name */
    public final float m1041getBADGE_WIDTHD9Ej5fM() {
        return BADGE_WIDTH;
    }

    /* JADX INFO: renamed from: getBODY_HEIGHT-D9Ej5fM, reason: not valid java name */
    public final float m1042getBODY_HEIGHTD9Ej5fM() {
        return BODY_HEIGHT;
    }

    /* JADX INFO: renamed from: getBUTTON_HEIGHT-D9Ej5fM, reason: not valid java name */
    public final float m1043getBUTTON_HEIGHTD9Ej5fM() {
        return BUTTON_HEIGHT;
    }

    public final RoundedCornerShape getBUTTON_SHAPE() {
        return BUTTON_SHAPE;
    }

    public final RoundedCornerShape getPLACEHOLDER_SHAPE() {
        return PLACEHOLDER_SHAPE;
    }

    /* JADX INFO: renamed from: getSTORE_WIDTH-D9Ej5fM, reason: not valid java name */
    public final float m1044getSTORE_WIDTHD9Ej5fM() {
        return STORE_WIDTH;
    }

    /* JADX INFO: renamed from: getSUBTITLE_WIDTH-D9Ej5fM, reason: not valid java name */
    public final float m1045getSUBTITLE_WIDTHD9Ej5fM() {
        return SUBTITLE_WIDTH;
    }

    /* JADX INFO: renamed from: getTITLE_HEIGHT-D9Ej5fM, reason: not valid java name */
    public final float m1046getTITLE_HEIGHTD9Ej5fM() {
        return TITLE_HEIGHT;
    }

    /* JADX INFO: renamed from: getTITLE_WIDTH-D9Ej5fM, reason: not valid java name */
    public final float m1047getTITLE_WIDTHD9Ej5fM() {
        return TITLE_WIDTH;
    }
}

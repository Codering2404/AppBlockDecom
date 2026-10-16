package com.revenuecat.purchases.ui.revenuecatui.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ArrowBackKt {
    private static ImageVector _arrowBack;

    public static final ImageVector getArrowBack() {
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.ArrowBack", Dp.g(24.0f), Dp.g(24.0f), 24.0f, 24.0f, 0L, 0, true, 96, null);
        int iB = VectorKt.b();
        SolidColor solidColor = new SolidColor(Color.f25715b.a(), null);
        int iA = StrokeCap.f25935b.a();
        int iA2 = StrokeJoin.f25940b.a();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(20.0f, 11.0f);
        pathBuilder.f(7.83f);
        pathBuilder.i(5.59f, -5.59f);
        pathBuilder.h(12.0f, 4.0f);
        pathBuilder.i(-8.0f, 8.0f);
        pathBuilder.i(8.0f, 8.0f);
        pathBuilder.i(1.41f, -1.41f);
        pathBuilder.h(7.83f, 13.0f);
        pathBuilder.f(20.0f);
        pathBuilder.r(-2.0f);
        pathBuilder.b();
        ImageVector imageVectorF = builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iA2, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f).f();
        _arrowBack = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

package com.revenuecat.purchases.ui.revenuecatui.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
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
public final class CalendarMonthKt {
    private static ImageVector _Calendar_month;

    public static final ImageVector getCalendarMonth() {
        ImageVector imageVector = _Calendar_month;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        float f3 = 24;
        ImageVector.Builder builder = new ImageVector.Builder("CalendarMonth", Dp.g(f3), Dp.g(f3), 960.0f, 960.0f, 0L, 0, false, 224, null);
        SolidColor solidColor = new SolidColor(Color.f25715b.a(), null);
        int iA = StrokeCap.f25935b.a();
        int iB = StrokeJoin.f25940b.b();
        int iB2 = PathFillType.f25834b.b();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(200.0f, 880.0f);
        pathBuilder.l(-33.0f, 0.0f, -56.5f, -23.5f);
        pathBuilder.o(120.0f, 800.0f);
        pathBuilder.r(-560.0f);
        pathBuilder.l(0.0f, -33.0f, 23.5f, -56.5f);
        pathBuilder.o(200.0f, 160.0f);
        pathBuilder.g(40.0f);
        pathBuilder.r(-80.0f);
        pathBuilder.g(80.0f);
        pathBuilder.r(80.0f);
        pathBuilder.g(320.0f);
        pathBuilder.r(-80.0f);
        pathBuilder.g(80.0f);
        pathBuilder.r(80.0f);
        pathBuilder.g(40.0f);
        pathBuilder.l(33.0f, 0.0f, 56.5f, 23.5f);
        pathBuilder.o(840.0f, 240.0f);
        pathBuilder.r(560.0f);
        pathBuilder.l(0.0f, 33.0f, -23.5f, 56.5f);
        pathBuilder.o(760.0f, 880.0f);
        pathBuilder.b();
        pathBuilder.k(0.0f, -80.0f);
        pathBuilder.g(560.0f);
        pathBuilder.r(-400.0f);
        pathBuilder.f(200.0f);
        pathBuilder.b();
        pathBuilder.k(0.0f, -480.0f);
        pathBuilder.g(560.0f);
        pathBuilder.r(-80.0f);
        pathBuilder.f(200.0f);
        pathBuilder.b();
        pathBuilder.k(0.0f, 0.0f);
        pathBuilder.r(-80.0f);
        pathBuilder.b();
        pathBuilder.k(280.0f, 240.0f);
        pathBuilder.l(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.o(440.0f, 520.0f);
        pathBuilder.p(11.5f, -28.5f);
        pathBuilder.o(480.0f, 480.0f);
        pathBuilder.p(28.5f, 11.5f);
        pathBuilder.o(520.0f, 520.0f);
        pathBuilder.p(-11.5f, 28.5f);
        pathBuilder.o(480.0f, 560.0f);
        pathBuilder.k(-160.0f, 0.0f);
        pathBuilder.l(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.o(280.0f, 520.0f);
        pathBuilder.p(11.5f, -28.5f);
        pathBuilder.o(320.0f, 480.0f);
        pathBuilder.p(28.5f, 11.5f);
        pathBuilder.o(360.0f, 520.0f);
        pathBuilder.p(-11.5f, 28.5f);
        pathBuilder.o(320.0f, 560.0f);
        pathBuilder.k(320.0f, 0.0f);
        pathBuilder.l(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.o(600.0f, 520.0f);
        pathBuilder.p(11.5f, -28.5f);
        pathBuilder.o(640.0f, 480.0f);
        pathBuilder.p(28.5f, 11.5f);
        pathBuilder.o(680.0f, 520.0f);
        pathBuilder.p(-11.5f, 28.5f);
        pathBuilder.o(640.0f, 560.0f);
        pathBuilder.j(480.0f, 720.0f);
        pathBuilder.l(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.o(440.0f, 680.0f);
        pathBuilder.p(11.5f, -28.5f);
        pathBuilder.o(480.0f, 640.0f);
        pathBuilder.p(28.5f, 11.5f);
        pathBuilder.o(520.0f, 680.0f);
        pathBuilder.p(-11.5f, 28.5f);
        pathBuilder.o(480.0f, 720.0f);
        pathBuilder.k(-160.0f, 0.0f);
        pathBuilder.l(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.o(280.0f, 680.0f);
        pathBuilder.p(11.5f, -28.5f);
        pathBuilder.o(320.0f, 640.0f);
        pathBuilder.p(28.5f, 11.5f);
        pathBuilder.o(360.0f, 680.0f);
        pathBuilder.p(-11.5f, 28.5f);
        pathBuilder.o(320.0f, 720.0f);
        pathBuilder.k(320.0f, 0.0f);
        pathBuilder.l(-17.0f, 0.0f, -28.5f, -11.5f);
        pathBuilder.o(600.0f, 680.0f);
        pathBuilder.p(11.5f, -28.5f);
        pathBuilder.o(640.0f, 640.0f);
        pathBuilder.p(28.5f, 11.5f);
        pathBuilder.o(680.0f, 680.0f);
        pathBuilder.p(-11.5f, 28.5f);
        pathBuilder.o(640.0f, 720.0f);
        builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB2, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iB, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f);
        ImageVector imageVectorF = builder.f();
        _Calendar_month = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

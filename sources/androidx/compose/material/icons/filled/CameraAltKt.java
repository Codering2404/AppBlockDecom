package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CameraAltKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ImageVector f15163a;

    public static final ImageVector a(Icons.Filled filled) {
        ImageVector imageVector = f15163a;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.CameraAlt", Dp.g(24.0f), Dp.g(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int iB = VectorKt.b();
        Color.Companion companion = Color.f25715b;
        SolidColor solidColor = new SolidColor(companion.a(), null);
        StrokeCap.Companion companion2 = StrokeCap.f25935b;
        int iA = companion2.a();
        StrokeJoin.Companion companion3 = StrokeJoin.f25940b;
        int iA2 = companion3.a();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(12.0f, 12.0f);
        pathBuilder.k(-3.2f, 0.0f);
        pathBuilder.a(3.2f, 3.2f, 0.0f, true, true, 6.4f, 0.0f);
        pathBuilder.a(3.2f, 3.2f, 0.0f, true, true, -6.4f, 0.0f);
        builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iA2, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f);
        int iB2 = VectorKt.b();
        SolidColor solidColor2 = new SolidColor(companion.a(), null);
        int iA3 = companion2.a();
        int iA4 = companion3.a();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.j(9.0f, 2.0f);
        pathBuilder2.h(7.17f, 4.0f);
        pathBuilder2.h(4.0f, 4.0f);
        pathBuilder2.d(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder2.r(12.0f);
        pathBuilder2.d(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder2.g(16.0f);
        pathBuilder2.d(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.h(22.0f, 6.0f);
        pathBuilder2.d(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder2.g(-3.17f);
        pathBuilder2.h(15.0f, 2.0f);
        pathBuilder2.h(9.0f, 2.0f);
        pathBuilder2.b();
        pathBuilder2.j(12.0f, 17.0f);
        pathBuilder2.d(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        pathBuilder2.n(2.24f, -5.0f, 5.0f, -5.0f);
        pathBuilder2.n(5.0f, 2.24f, 5.0f, 5.0f);
        pathBuilder2.n(-2.24f, 5.0f, -5.0f, 5.0f);
        pathBuilder2.b();
        ImageVector imageVectorF = builder.c(pathBuilder2.e(), (14336 & 2) != 0 ? VectorKt.b() : iB2, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor2, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA3, (14336 & 512) != 0 ? VectorKt.d() : iA4, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f).f();
        f15163a = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

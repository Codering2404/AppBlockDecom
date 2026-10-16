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
public final class SignalWifiOffKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ImageVector f15179a;

    public static final ImageVector a(Icons.Filled filled) {
        ImageVector imageVector = f15179a;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.SignalWifiOff", Dp.g(24.0f), Dp.g(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int iB = VectorKt.b();
        SolidColor solidColor = new SolidColor(Color.f25715b.a(), null);
        int iA = StrokeCap.f25935b.a();
        int iA2 = StrokeJoin.f25940b.a();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(23.64f, 7.0f);
        pathBuilder.d(-0.45f, -0.34f, -4.93f, -4.0f, -11.64f, -4.0f);
        pathBuilder.d(-1.5f, 0.0f, -2.89f, 0.19f, -4.15f, 0.48f);
        pathBuilder.h(18.18f, 13.8f);
        pathBuilder.h(23.64f, 7.0f);
        pathBuilder.b();
        pathBuilder.j(17.04f, 15.22f);
        pathBuilder.h(3.27f, 1.44f);
        pathBuilder.h(2.0f, 2.72f);
        pathBuilder.i(2.05f, 2.06f);
        pathBuilder.c(1.91f, 5.76f, 0.59f, 6.82f, 0.36f, 7.0f);
        pathBuilder.i(11.63f, 14.49f);
        pathBuilder.i(0.01f, 0.01f);
        pathBuilder.i(0.01f, -0.01f);
        pathBuilder.i(3.9f, -4.86f);
        pathBuilder.i(3.32f, 3.32f);
        pathBuilder.i(1.27f, -1.27f);
        pathBuilder.i(-3.46f, -3.46f);
        pathBuilder.b();
        ImageVector imageVectorF = builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iA2, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f).f();
        f15179a = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

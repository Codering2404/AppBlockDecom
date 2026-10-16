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
public final class ShareKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ImageVector f15178a;

    public static final ImageVector a(Icons.Filled filled) {
        ImageVector imageVector = f15178a;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Share", Dp.g(24.0f), Dp.g(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int iB = VectorKt.b();
        SolidColor solidColor = new SolidColor(Color.f25715b.a(), null);
        int iA = StrokeCap.f25935b.a();
        int iA2 = StrokeJoin.f25940b.a();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(18.0f, 16.08f);
        pathBuilder.d(-0.76f, 0.0f, -1.44f, 0.3f, -1.96f, 0.77f);
        pathBuilder.h(8.91f, 12.7f);
        pathBuilder.d(0.05f, -0.23f, 0.09f, -0.46f, 0.09f, -0.7f);
        pathBuilder.n(-0.04f, -0.47f, -0.09f, -0.7f);
        pathBuilder.i(7.05f, -4.11f);
        pathBuilder.d(0.54f, 0.5f, 1.25f, 0.81f, 2.04f, 0.81f);
        pathBuilder.d(1.66f, 0.0f, 3.0f, -1.34f, 3.0f, -3.0f);
        pathBuilder.n(-1.34f, -3.0f, -3.0f, -3.0f);
        pathBuilder.n(-3.0f, 1.34f, -3.0f, 3.0f);
        pathBuilder.d(0.0f, 0.24f, 0.04f, 0.47f, 0.09f, 0.7f);
        pathBuilder.h(8.04f, 9.81f);
        pathBuilder.c(7.5f, 9.31f, 6.79f, 9.0f, 6.0f, 9.0f);
        pathBuilder.d(-1.66f, 0.0f, -3.0f, 1.34f, -3.0f, 3.0f);
        pathBuilder.n(1.34f, 3.0f, 3.0f, 3.0f);
        pathBuilder.d(0.79f, 0.0f, 1.5f, -0.31f, 2.04f, -0.81f);
        pathBuilder.i(7.12f, 4.16f);
        pathBuilder.d(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f);
        pathBuilder.d(0.0f, 1.61f, 1.31f, 2.92f, 2.92f, 2.92f);
        pathBuilder.d(1.61f, 0.0f, 2.92f, -1.31f, 2.92f, -2.92f);
        pathBuilder.n(-1.31f, -2.92f, -2.92f, -2.92f);
        pathBuilder.b();
        ImageVector imageVectorF = builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iA2, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f).f();
        f15178a = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

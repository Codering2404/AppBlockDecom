package androidx.compose.material.icons.outlined;

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
public final class VisibilityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ImageVector f15181a;

    public static final ImageVector a(Icons.Outlined outlined) {
        ImageVector imageVector = f15181a;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Visibility", Dp.g(24.0f), Dp.g(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int iB = VectorKt.b();
        SolidColor solidColor = new SolidColor(Color.f25715b.a(), null);
        int iA = StrokeCap.f25935b.a();
        int iA2 = StrokeJoin.f25940b.a();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(12.0f, 6.0f);
        pathBuilder.d(3.79f, 0.0f, 7.17f, 2.13f, 8.82f, 5.5f);
        pathBuilder.c(19.17f, 14.87f, 15.79f, 17.0f, 12.0f, 17.0f);
        pathBuilder.n(-7.17f, -2.13f, -8.82f, -5.5f);
        pathBuilder.c(4.83f, 8.13f, 8.21f, 6.0f, 12.0f, 6.0f);
        pathBuilder.k(0.0f, -2.0f);
        pathBuilder.c(7.0f, 4.0f, 2.73f, 7.11f, 1.0f, 11.5f);
        pathBuilder.c(2.73f, 15.89f, 7.0f, 19.0f, 12.0f, 19.0f);
        pathBuilder.n(9.27f, -3.11f, 11.0f, -7.5f);
        pathBuilder.c(21.27f, 7.11f, 17.0f, 4.0f, 12.0f, 4.0f);
        pathBuilder.b();
        pathBuilder.j(12.0f, 9.0f);
        pathBuilder.d(1.38f, 0.0f, 2.5f, 1.12f, 2.5f, 2.5f);
        pathBuilder.m(13.38f, 14.0f, 12.0f, 14.0f);
        pathBuilder.n(-2.5f, -1.12f, -2.5f, -2.5f);
        pathBuilder.m(10.62f, 9.0f, 12.0f, 9.0f);
        pathBuilder.k(0.0f, -2.0f);
        pathBuilder.d(-2.48f, 0.0f, -4.5f, 2.02f, -4.5f, 4.5f);
        pathBuilder.m(9.52f, 16.0f, 12.0f, 16.0f);
        pathBuilder.n(4.5f, -2.02f, 4.5f, -4.5f);
        pathBuilder.m(14.48f, 7.0f, 12.0f, 7.0f);
        pathBuilder.b();
        ImageVector imageVectorF = builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iA2, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f).f();
        f15181a = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

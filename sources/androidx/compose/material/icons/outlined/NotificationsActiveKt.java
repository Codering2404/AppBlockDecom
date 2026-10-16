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
public final class NotificationsActiveKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ImageVector f15180a;

    public static final ImageVector a(Icons.Outlined outlined) {
        ImageVector imageVector = f15180a;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.NotificationsActive", Dp.g(24.0f), Dp.g(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int iB = VectorKt.b();
        SolidColor solidColor = new SolidColor(Color.f25715b.a(), null);
        int iA = StrokeCap.f25935b.a();
        int iA2 = StrokeJoin.f25940b.a();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.j(12.0f, 22.0f);
        pathBuilder.d(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.g(-4.0f);
        pathBuilder.d(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.b();
        pathBuilder.j(18.0f, 16.0f);
        pathBuilder.r(-5.0f);
        pathBuilder.d(0.0f, -3.07f, -1.63f, -5.64f, -4.5f, -6.32f);
        pathBuilder.h(13.5f, 4.0f);
        pathBuilder.d(0.0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        pathBuilder.n(-1.5f, 0.67f, -1.5f, 1.5f);
        pathBuilder.r(0.68f);
        pathBuilder.c(7.64f, 5.36f, 6.0f, 7.92f, 6.0f, 11.0f);
        pathBuilder.r(5.0f);
        pathBuilder.i(-2.0f, 2.0f);
        pathBuilder.r(1.0f);
        pathBuilder.g(16.0f);
        pathBuilder.r(-1.0f);
        pathBuilder.i(-2.0f, -2.0f);
        pathBuilder.b();
        pathBuilder.j(16.0f, 17.0f);
        pathBuilder.h(8.0f, 17.0f);
        pathBuilder.r(-6.0f);
        pathBuilder.d(0.0f, -2.48f, 1.51f, -4.5f, 4.0f, -4.5f);
        pathBuilder.n(4.0f, 2.02f, 4.0f, 4.5f);
        pathBuilder.r(6.0f);
        pathBuilder.b();
        pathBuilder.j(7.58f, 4.08f);
        pathBuilder.h(6.15f, 2.65f);
        pathBuilder.c(3.75f, 4.48f, 2.17f, 7.3f, 2.03f, 10.5f);
        pathBuilder.g(2.0f);
        pathBuilder.d(0.15f, -2.65f, 1.51f, -4.97f, 3.55f, -6.42f);
        pathBuilder.b();
        pathBuilder.j(19.97f, 10.5f);
        pathBuilder.g(2.0f);
        pathBuilder.d(-0.15f, -3.2f, -1.73f, -6.02f, -4.12f, -7.85f);
        pathBuilder.i(-1.42f, 1.43f);
        pathBuilder.d(2.02f, 1.45f, 3.39f, 3.77f, 3.54f, 6.42f);
        pathBuilder.b();
        ImageVector imageVectorF = builder.c(pathBuilder.e(), (14336 & 2) != 0 ? VectorKt.b() : iB, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : 1.0f, (14336 & Function.MAX_NARGS) != 0 ? VectorKt.c() : iA, (14336 & 512) != 0 ? VectorKt.d() : iA2, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0f : 0.0f).f();
        f15180a = imageVectorF;
        Intrinsics.checkNotNull(imageVectorF);
        return imageVectorF;
    }
}

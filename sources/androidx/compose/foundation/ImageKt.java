package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ImageKt {
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.graphics.painter.Painter r20, final java.lang.String r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.Alignment r23, androidx.compose.ui.layout.ContentScale r24, float r25, androidx.compose.ui.graphics.ColorFilter r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ImageKt.a(androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void b(ImageVector imageVector, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, Composer composer, int i3, int i4) {
        if ((i4 & 4) != 0) {
            modifier = Modifier.b8;
        }
        Modifier modifier2 = modifier;
        if ((i4 & 8) != 0) {
            alignment = Alignment.f25072a.e();
        }
        Alignment alignment2 = alignment;
        ContentScale contentScaleE = (i4 & 16) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i4 & 32) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i4 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.M()) {
            ComposerKt.U(1595907091, i3, -1, "androidx.compose.foundation.Image (Image.kt:202)");
        }
        a(VectorPainterKt.h(imageVector, composer, i3 & 14), str, modifier2, alignment2, contentScaleE, f4, colorFilter2, composer, VectorPainter.f26531p | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void c(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, int i4, int i5) {
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.b8 : modifier;
        Alignment alignmentE = (i5 & 8) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i5 & 16) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i5 & 32) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i5 & 64) != 0 ? null : colorFilter;
        int iB = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? DrawScope.e8.b() : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(-1396260732, i4, -1, "androidx.compose.foundation.Image (Image.kt:156)");
        }
        boolean Z = composer.Z(imageBitmap);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = BitmapPainterKt.b(imageBitmap, 0L, 0L, iB, 6, null);
            composer.w(objG);
        }
        a((BitmapPainter) objG, str, modifier2, alignmentE, contentScaleE, f4, colorFilter2, composer, i4 & 4194288, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}

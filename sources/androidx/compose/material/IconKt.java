package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.unit.Dp;
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
public final class IconKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Modifier f13018a = SizeKt.v(Modifier.b8, Dp.g(24));

    /* JADX WARN: Removed duplicated region for block: B:102:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.graphics.painter.Painter r20, final java.lang.String r21, androidx.compose.ui.Modifier r22, long r23, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconKt.a(androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void b(ImageVector imageVector, String str, Modifier modifier, long j3, Composer composer, int i3, int i4) {
        Modifier modifier2 = (i4 & 4) != 0 ? Modifier.b8 : modifier;
        long jR = (i4 & 8) != 0 ? Color.r(((Color) composer.q(ContentColorKt.a())).B(), ((Number) composer.q(ContentAlphaKt.a())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.M()) {
            ComposerKt.U(-800853103, i3, -1, "androidx.compose.material.Icon (Icon.kt:66)");
        }
        a(VectorPainterKt.h(imageVector, composer, i3 & 14), str, modifier2, jR, composer, VectorPainter.f26531p | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    private static final Modifier c(Modifier modifier, Painter painter) {
        return modifier.then((Size.f(painter.l(), Size.f25617b.a()) || d(painter.l())) ? f13018a : Modifier.b8);
    }

    private static final boolean d(long j3) {
        return Float.isInfinite(Size.i(j3)) && Float.isInfinite(Size.g(j3));
    }
}

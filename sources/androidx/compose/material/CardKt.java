package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public final class CardKt {
    public static final void a(Modifier modifier, Shape shape, long j3, long j4, BorderStroke borderStroke, float f3, Function2 function2, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            modifier = Modifier.b8;
        }
        if ((i4 & 2) != 0) {
            shape = MaterialTheme.f13091a.b(composer, 6).d();
        }
        Shape shape2 = shape;
        long jN = (i4 & 4) != 0 ? MaterialTheme.f13091a.a(composer, 6).n() : j3;
        long jB = (i4 & 8) != 0 ? ColorsKt.b(jN, composer, (i3 >> 6) & 14) : j4;
        BorderStroke borderStroke2 = (i4 & 16) != 0 ? null : borderStroke;
        float fG = (i4 & 32) != 0 ? Dp.g(1) : f3;
        if (ComposerKt.M()) {
            ComposerKt.U(1956755640, i3, -1, "androidx.compose.material.Card (Card.kt:62)");
        }
        SurfaceKt.a(modifier, shape2, jN, jB, borderStroke2, fG, function2, composer, i3 & 4194302, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void b(Function0 function0, Modifier modifier, boolean z2, Shape shape, long j3, long j4, BorderStroke borderStroke, float f3, MutableInteractionSource mutableInteractionSource, Function2 function2, Composer composer, int i3, int i4) {
        Modifier modifier2 = (i4 & 2) != 0 ? Modifier.b8 : modifier;
        boolean z3 = (i4 & 4) != 0 ? true : z2;
        Shape shapeD = (i4 & 8) != 0 ? MaterialTheme.f13091a.b(composer, 6).d() : shape;
        long jN = (i4 & 16) != 0 ? MaterialTheme.f13091a.a(composer, 6).n() : j3;
        long jB = (i4 & 32) != 0 ? ColorsKt.b(jN, composer, (i3 >> 12) & 14) : j4;
        BorderStroke borderStroke2 = (i4 & 64) != 0 ? null : borderStroke;
        float fG = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Dp.g(1) : f3;
        MutableInteractionSource mutableInteractionSource2 = (i4 & Function.MAX_NARGS) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.M()) {
            ComposerKt.U(778538979, i3, -1, "androidx.compose.material.Card (Card.kt:114)");
        }
        float f4 = fG;
        SurfaceKt.b(function0, modifier2, z3, shapeD, jN, jB, borderStroke2, f4, mutableInteractionSource2, function2, composer, i3 & 2147483646, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}

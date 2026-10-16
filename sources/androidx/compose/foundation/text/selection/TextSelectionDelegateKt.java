package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class TextSelectionDelegateKt {
    public static final float a(TextLayoutResult textLayoutResult, int i3, boolean z2, boolean z3) {
        return textLayoutResult.j(i3, textLayoutResult.c(((!z2 || z3) && (z2 || !z3)) ? Math.max(i3 + (-1), 0) : i3) == textLayoutResult.y(i3));
    }

    public static final long b(TextLayoutResult textLayoutResult, int i3, boolean z2, boolean z3) {
        int iQ = textLayoutResult.q(i3);
        if (iQ >= textLayoutResult.n()) {
            return Offset.f25596b.b();
        }
        return Offset.e((((long) Float.floatToRawIntBits(RangesKt.o(a(textLayoutResult, i3, z2, z3), 0.0f, (int) (textLayoutResult.B() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(RangesKt.o(textLayoutResult.m(iQ), 0.0f, (int) (textLayoutResult.B() & 4294967295L)))) & 4294967295L));
    }
}

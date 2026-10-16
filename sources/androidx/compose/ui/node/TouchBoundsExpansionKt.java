package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
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
public final class TouchBoundsExpansionKt {
    public static final DpTouchBoundsExpansion a(float f3, float f4, float f5, float f6) {
        return new DpTouchBoundsExpansion(f3, f4, f5, f6, true, null);
    }

    public static final long b(int i3, int i4, int i5, int i6) {
        if (!(i3 >= 0 && i3 < 32768)) {
            InlineClassHelperKt.a("Start must be in the range of 0 .. 32767");
        }
        if (!(i4 >= 0 && i4 < 32768)) {
            InlineClassHelperKt.a("Top must be in the range of 0 .. 32767");
        }
        if (!(i5 >= 0 && i5 < 32768)) {
            InlineClassHelperKt.a("End must be in the range of 0 .. 32767");
        }
        if (!(i6 >= 0 && i6 < 32768)) {
            InlineClassHelperKt.a("Bottom must be in the range of 0 .. 32767");
        }
        return TouchBoundsExpansion.d(TouchBoundsExpansion.f27637b.c(i3, i4, i5, i6, true));
    }

    public static /* synthetic */ long c(int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = 0;
        }
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return b(i3, i4, i5, i6);
    }
}

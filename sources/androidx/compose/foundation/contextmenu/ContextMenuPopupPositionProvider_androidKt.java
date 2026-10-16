package androidx.compose.foundation.contextmenu;

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
public final class ContextMenuPopupPositionProvider_androidKt {
    private static final int a(int i3, int i4, boolean z2) {
        return f(i3, i4, !z2);
    }

    public static final int b(int i3, int i4, int i5, boolean z2) {
        return i4 >= i5 ? f(i4, i5, z2) : g(i3, i4, i5, z2) ? e(i3, i4, z2) : h(i3, i4, i5, z2) ? d(i3, i4, z2) : a(i4, i5, z2);
    }

    public static /* synthetic */ int c(int i3, int i4, int i5, boolean z2, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z2 = true;
        }
        return b(i3, i4, i5, z2);
    }

    private static final int d(int i3, int i4, boolean z2) {
        return e(i3, i4, !z2);
    }

    private static final int e(int i3, int i4, boolean z2) {
        return z2 ? i3 : i3 - i4;
    }

    private static final int f(int i3, int i4, boolean z2) {
        if (z2) {
            return 0;
        }
        return i4 - i3;
    }

    private static final boolean g(int i3, int i4, int i5, boolean z2) {
        return h(i3, i4, i5, !z2);
    }

    private static final boolean h(int i3, int i4, int i5, boolean z2) {
        return z2 ? i4 <= i3 : i5 - i4 > i3;
    }
}

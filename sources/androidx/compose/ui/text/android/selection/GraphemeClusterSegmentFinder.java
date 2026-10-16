package androidx.compose.ui.text.android.selection;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class GraphemeClusterSegmentFinder implements SegmentFinder {
    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int a(int i3) {
        int iE = e(i3);
        if (iE == -1 || e(iE) == -1) {
            return -1;
        }
        return iE;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int b(int i3) {
        return f(i3);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int c(int i3) {
        return e(i3);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int d(int i3) {
        int iF = f(i3);
        if (iF == -1 || f(iF) == -1) {
            return -1;
        }
        return iF;
    }

    public abstract int e(int i3);

    public abstract int f(int i3);
}

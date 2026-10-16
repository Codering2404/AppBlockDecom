package androidx.compose.runtime.collection;

import java.util.List;
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
public final class MutableVectorKt {
    public static final void a(List list, int i3) {
        int size = list.size();
        if (i3 < 0 || i3 >= size) {
            c(i3, size);
        }
    }

    public static final void b(List list, int i3, int i4) {
        if (i3 > i4) {
            f(i3, i4);
        }
        if (i3 < 0) {
            d(i3);
        }
        if (i4 > list.size()) {
            e(i4, list.size());
        }
    }

    private static final void c(int i3, int i4) {
        throw new IndexOutOfBoundsException("Index " + i3 + " is out of bounds. The list has " + i4 + " elements.");
    }

    private static final void d(int i3) {
        throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than 0.");
    }

    private static final void e(int i3, int i4) {
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is more than than the list size (" + i4 + ')');
    }

    private static final void f(int i3, int i4) {
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
    }
}

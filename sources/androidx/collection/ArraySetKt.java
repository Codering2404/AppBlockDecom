package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.ConcurrentModificationException;
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
public final class ArraySetKt {
    public static final void a(ArraySet arraySet, int i3) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        arraySet.l(new int[i3]);
        arraySet.h(new Object[i3]);
    }

    public static final int b(ArraySet arraySet, int i3) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        try {
            return ContainerHelpersKt.a(arraySet.d(), arraySet.f(), i3);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(ArraySet arraySet, Object obj, int i3) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int iF = arraySet.f();
        if (iF == 0) {
            return -1;
        }
        int iB = b(arraySet, i3);
        if (iB < 0 || Intrinsics.areEqual(obj, arraySet.b()[iB])) {
            return iB;
        }
        int i4 = iB + 1;
        while (i4 < iF && arraySet.d()[i4] == i3) {
            if (Intrinsics.areEqual(obj, arraySet.b()[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iB - 1; i5 >= 0 && arraySet.d()[i5] == i3; i5--) {
            if (Intrinsics.areEqual(obj, arraySet.b()[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    public static final int d(ArraySet arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return c(arraySet, null, 0);
    }
}

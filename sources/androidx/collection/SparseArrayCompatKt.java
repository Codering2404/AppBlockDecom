package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
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
public final class SparseArrayCompatKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f3158a = new Object();

    public static final Object c(SparseArrayCompat sparseArrayCompat, int i3) {
        Object obj;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int iA = ContainerHelpersKt.a(sparseArrayCompat.f3155b, sparseArrayCompat.f3157d, i3);
        if (iA < 0 || (obj = sparseArrayCompat.f3156c[iA]) == f3158a) {
            return null;
        }
        return obj;
    }

    public static final Object d(SparseArrayCompat sparseArrayCompat, int i3, Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int iA = ContainerHelpersKt.a(sparseArrayCompat.f3155b, sparseArrayCompat.f3157d, i3);
        return (iA < 0 || (obj2 = sparseArrayCompat.f3156c[iA]) == f3158a) ? obj : obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SparseArrayCompat sparseArrayCompat) {
        int i3 = sparseArrayCompat.f3157d;
        int[] iArr = sparseArrayCompat.f3155b;
        Object[] objArr = sparseArrayCompat.f3156c;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f3158a) {
                if (i5 != i4) {
                    iArr[i4] = iArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        sparseArrayCompat.f3154a = false;
        sparseArrayCompat.f3157d = i4;
    }
}

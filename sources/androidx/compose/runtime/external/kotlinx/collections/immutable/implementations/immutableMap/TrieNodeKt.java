package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class TrieNodeKt {
    public static final int f(int i3, int i4) {
        return (i3 >> i4) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] g(Object[] objArr, int i3, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i3 + 2, i3, objArr.length);
        objArr2[i3] = obj;
        objArr2[i3 + 1] = obj2;
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] h(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i3, i3 + 2, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] i(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i3, i3 + 1, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] j(Object[] objArr, int i3, int i4, TrieNode trieNode) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i3, i3 + 2, i4);
        objArr2[i4 - 2] = trieNode;
        ArraysKt.copyInto(objArr, objArr2, i4 - 1, i4, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] k(Object[] objArr, int i3, int i4, Object obj, Object obj2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        ArraysKt.copyInto(objArrCopyOf, objArrCopyOf, i3 + 2, i3 + 1, objArr.length);
        ArraysKt.copyInto(objArrCopyOf, objArrCopyOf, i4 + 2, i4, i3);
        objArrCopyOf[i4] = obj;
        objArrCopyOf[i4 + 1] = obj2;
        return objArrCopyOf;
    }
}

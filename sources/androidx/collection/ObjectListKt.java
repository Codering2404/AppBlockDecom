package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.List;
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
public final class ObjectListKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f3084a = new Object[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ObjectList f3085b = new MutableObjectList(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(List list, int i3) {
        int size = list.size();
        if (i3 < 0 || i3 >= size) {
            RuntimeHelpersKt.c("Index " + i3 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(List list, int i3, int i4) {
        int size = list.size();
        if (i3 > i4) {
            RuntimeHelpersKt.a("Indices are out of order. fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        }
        if (i3 < 0) {
            RuntimeHelpersKt.c("fromIndex (" + i3 + ") is less than 0.");
        }
        if (i4 > size) {
            RuntimeHelpersKt.c("toIndex (" + i4 + ") is more than than the list size (" + size + ')');
        }
    }

    public static final ObjectList f() {
        ObjectList objectList = f3085b;
        Intrinsics.checkNotNull(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return objectList;
    }

    public static final MutableObjectList g(Object obj) {
        MutableObjectList mutableObjectList = new MutableObjectList(1);
        mutableObjectList.n(obj);
        return mutableObjectList;
    }

    public static final MutableObjectList h(Object obj, Object obj2) {
        MutableObjectList mutableObjectList = new MutableObjectList(2);
        mutableObjectList.n(obj);
        mutableObjectList.n(obj2);
        return mutableObjectList;
    }

    public static final ObjectList i(Object obj) {
        return g(obj);
    }
}

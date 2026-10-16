package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;

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
public final class ExtensionsKt {
    public static final boolean a(ObjectList objectList, Function1 function1) {
        if (objectList.e() <= 1) {
            return true;
        }
        Comparable comparable = (Comparable) function1.invoke(objectList.d(0));
        if (comparable == null) {
            return false;
        }
        int iE = objectList.e();
        int i3 = 1;
        while (i3 < iE) {
            Comparable comparable2 = (Comparable) function1.invoke(objectList.d(i3));
            if (comparable2 == null || comparable.compareTo(comparable2) > 0) {
                return false;
            }
            i3++;
            comparable = comparable2;
        }
        return true;
    }

    public static final Object b(MutableObjectList mutableObjectList) {
        if (mutableObjectList.g()) {
            throw new NoSuchElementException("List is empty.");
        }
        int iE = mutableObjectList.e() - 1;
        Object objD = mutableObjectList.d(iE);
        mutableObjectList.A(iE);
        return objD;
    }

    public static final void c(MutableObjectList mutableObjectList, final Function1 function1) {
        List listS = mutableObjectList.s();
        if (listS.size() > 1) {
            CollectionsKt.sortWith(listS, new Comparator() { // from class: androidx.compose.runtime.collection.ExtensionsKt$sortBy$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Function1 function12 = function1;
                    return ComparisonsKt.d((Comparable) function12.invoke(obj), (Comparable) function12.invoke(obj2));
                }
            });
        }
    }

    public static final ObjectList d(ObjectList objectList, Function1 function1) {
        if (a(objectList, function1)) {
            return objectList;
        }
        MutableObjectList mutableObjectListE = e(objectList);
        c(mutableObjectListE, function1);
        return mutableObjectListE;
    }

    public static final MutableObjectList e(ObjectList objectList) {
        MutableObjectList mutableObjectList = new MutableObjectList(objectList.e());
        Object[] objArr = objectList.f3081a;
        int i3 = objectList.f3082b;
        for (int i4 = 0; i4 < i3; i4++) {
            mutableObjectList.n(objArr[i4]);
        }
        return mutableObjectList;
    }
}

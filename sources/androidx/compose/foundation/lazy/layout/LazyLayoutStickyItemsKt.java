package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class LazyLayoutStickyItemsKt {
    public static final List b(StickyItemsPlacement stickyItemsPlacement, List list, IntList intList, int i3, int i4, int i5, int i6, Function1 function1) {
        StickyItemsPlacement stickyItemsPlacement2 = stickyItemsPlacement;
        if (stickyItemsPlacement2 == null || list.isEmpty() || intList.f2877b == 0) {
            return CollectionsKt.emptyList();
        }
        IntList intListB = stickyItemsPlacement2.b(((LazyLayoutMeasuredItem) CollectionsKt.first(list)).getIndex(), ((LazyLayoutMeasuredItem) CollectionsKt.last(list)).getIndex(), intList);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list.size());
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            Object obj = list.get(i7);
            if (intList.c(((LazyLayoutMeasuredItem) obj).getIndex())) {
                arrayList2.add(obj);
            }
        }
        int[] iArr = intListB.f2876a;
        int i8 = intListB.f2877b;
        int i9 = 0;
        while (i9 < i8) {
            int i10 = iArr[i9];
            Iterator it = list.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                if (((LazyLayoutMeasuredItem) it.next()).getIndex() == i10) {
                    break;
                }
                i11++;
            }
            LazyLayoutMeasuredItem lazyLayoutMeasuredItem = i11 == -1 ? (LazyLayoutMeasuredItem) function1.invoke(Integer.valueOf(i10)) : (LazyLayoutMeasuredItem) list.remove(i11);
            ArrayList arrayList3 = arrayList2;
            LazyLayoutMeasuredItem lazyLayoutMeasuredItem2 = lazyLayoutMeasuredItem;
            int iA = stickyItemsPlacement2.a(arrayList3, i10, lazyLayoutMeasuredItem.m(), i11 == -1 ? Integer.MIN_VALUE : c(lazyLayoutMeasuredItem), i3, i4, i5, i6);
            lazyLayoutMeasuredItem2.g(true);
            lazyLayoutMeasuredItem2.l(iA, 0, i5, i6);
            arrayList.add(lazyLayoutMeasuredItem2);
            i9++;
            stickyItemsPlacement2 = stickyItemsPlacement;
            arrayList2 = arrayList3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long jO = lazyLayoutMeasuredItem.o(0);
        return lazyLayoutMeasuredItem.k() ? IntOffset.l(jO) : IntOffset.k(jO);
    }
}

package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class PlaceholderPaddedListDiffHelperKt {
    public static final PlaceholderPaddedDiffResult a(final PlaceholderPaddedList placeholderPaddedList, final PlaceholderPaddedList newList, final DiffUtil.ItemCallback diffCallback) {
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        final int iA = placeholderPaddedList.a();
        final int iA2 = newList.a();
        DiffUtil.Callback callback = new DiffUtil.Callback() { // from class: androidx.paging.PlaceholderPaddedListDiffHelperKt$computeDiff$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean a(int i3, int i4) {
                Object item = placeholderPaddedList.getItem(i3);
                Object item2 = newList.getItem(i4);
                if (item == item2) {
                    return true;
                }
                return diffCallback.a(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean b(int i3, int i4) {
                Object item = placeholderPaddedList.getItem(i3);
                Object item2 = newList.getItem(i4);
                if (item == item2) {
                    return true;
                }
                return diffCallback.b(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object c(int i3, int i4) {
                Object item = placeholderPaddedList.getItem(i3);
                Object item2 = newList.getItem(i4);
                return item == item2 ? Boolean.TRUE : diffCallback.c(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int d() {
                return iA2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int e() {
                return iA;
            }
        };
        boolean z2 = true;
        DiffUtil.DiffResult diffResultC = DiffUtil.c(callback, true);
        Intrinsics.checkNotNullExpressionValue(diffResultC, "PlaceholderPaddedList<T>…    },\n        true\n    )");
        Iterable iterableB = RangesKt.B(0, placeholderPaddedList.a());
        if ((iterableB instanceof Collection) && ((Collection) iterableB).isEmpty()) {
            z2 = false;
        } else {
            Iterator it = iterableB.iterator();
            while (it.hasNext()) {
                if (diffResultC.b(((IntIterator) it).nextInt()) != -1) {
                    break;
                }
            }
            z2 = false;
        }
        return new PlaceholderPaddedDiffResult(diffResultC, z2);
    }

    public static final void b(PlaceholderPaddedList placeholderPaddedList, ListUpdateCallback callback, PlaceholderPaddedList newList, PlaceholderPaddedDiffResult diffResult) {
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        if (diffResult.b()) {
            OverlappingListsDiffDispatcher.f49932a.a(placeholderPaddedList, newList, callback, diffResult);
        } else {
            DistinctListsDiffDispatcher.f49717a.b(callback, placeholderPaddedList, newList);
        }
    }

    public static final int c(PlaceholderPaddedList placeholderPaddedList, PlaceholderPaddedDiffResult diffResult, PlaceholderPaddedList newList, int i3) {
        int iB;
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        Intrinsics.checkNotNullParameter(newList, "newList");
        if (!diffResult.b()) {
            return RangesKt.q(i3, RangesKt.B(0, newList.getSize()));
        }
        int iD = i3 - placeholderPaddedList.d();
        int iA = placeholderPaddedList.a();
        if (iD >= 0 && iD < iA) {
            for (int i4 = 0; i4 < 30; i4++) {
                int i5 = ((i4 / 2) * (i4 % 2 == 1 ? -1 : 1)) + iD;
                if (i5 >= 0 && i5 < placeholderPaddedList.a() && (iB = diffResult.a().b(i5)) != -1) {
                    return iB + newList.d();
                }
            }
        }
        return RangesKt.q(i3, RangesKt.B(0, newList.getSize()));
    }
}

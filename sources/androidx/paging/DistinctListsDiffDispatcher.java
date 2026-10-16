package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
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
public final class DistinctListsDiffDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DistinctListsDiffDispatcher f49717a = new DistinctListsDiffDispatcher();

    private DistinctListsDiffDispatcher() {
    }

    private final void a(ListUpdateCallback listUpdateCallback, int i3, int i4, int i5, int i6, Object obj) {
        int i7 = i3 - i5;
        if (i7 > 0) {
            listUpdateCallback.c(i5, i7, obj);
        }
        int i8 = i6 - i4;
        if (i8 > 0) {
            listUpdateCallback.c(i4, i8, obj);
        }
    }

    public final void b(ListUpdateCallback callback, PlaceholderPaddedList oldList, PlaceholderPaddedList newList) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        int iMax = Math.max(oldList.d(), newList.d());
        int iMin = Math.min(oldList.d() + oldList.a(), newList.d() + newList.a());
        int i3 = iMin - iMax;
        if (i3 > 0) {
            callback.b(iMax, i3);
            callback.a(iMax, i3);
        }
        int iMin2 = Math.min(iMax, iMin);
        int iMax2 = Math.max(iMax, iMin);
        a(callback, iMin2, iMax2, RangesKt.k(oldList.d(), newList.getSize()), RangesKt.k(oldList.d() + oldList.a(), newList.getSize()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        a(callback, iMin2, iMax2, RangesKt.k(newList.d(), oldList.getSize()), RangesKt.k(newList.d() + newList.a(), oldList.getSize()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int size = newList.getSize() - oldList.getSize();
        if (size > 0) {
            callback.a(oldList.getSize(), size);
        } else if (size < 0) {
            callback.b(oldList.getSize() + size, -size);
        }
    }
}

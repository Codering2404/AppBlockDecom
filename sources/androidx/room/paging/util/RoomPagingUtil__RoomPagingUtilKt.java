package androidx.room.paging.util;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

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
final /* synthetic */ class RoomPagingUtil__RoomPagingUtilKt {
    public static final Integer a(PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "<this>");
        Integer numD = pagingState.d();
        if (numD != null) {
            return Integer.valueOf(Math.max(0, numD.intValue() - (pagingState.e().f50309d / 2)));
        }
        return null;
    }

    public static final int b(PagingSource.LoadParams params, int i3) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(params instanceof PagingSource.LoadParams.Prepend)) {
            return params.b();
        }
        PagingSource.LoadParams.Prepend prepend = (PagingSource.LoadParams.Prepend) params;
        return i3 < prepend.b() ? i3 : prepend.b();
    }

    public static final int c(PagingSource.LoadParams params, int i3, int i4) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params instanceof PagingSource.LoadParams.Prepend) {
            PagingSource.LoadParams.Prepend prepend = (PagingSource.LoadParams.Prepend) params;
            if (i3 < prepend.b()) {
                return 0;
            }
            return i3 - prepend.b();
        }
        if (params instanceof PagingSource.LoadParams.Append) {
            return i3;
        }
        if (!(params instanceof PagingSource.LoadParams.Refresh)) {
            throw new NoWhenBranchMatchedException();
        }
        PagingSource.LoadParams.Refresh refresh = (PagingSource.LoadParams.Refresh) params;
        return i3 >= i4 - refresh.b() ? Math.max(0, i4 - refresh.b()) : i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(androidx.paging.PagingSource.LoadParams r10, androidx.room.RoomRawQuery r11, int r12, kotlin.jvm.functions.Function3 r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.util.RoomPagingUtil__RoomPagingUtilKt.d(androidx.paging.PagingSource$LoadParams, androidx.room.RoomRawQuery, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object e(RoomRawQuery roomRawQuery, RoomDatabase roomDatabase, Continuation continuation) {
        return BuildersKt.g(roomDatabase.getCoroutineScope().getCoroutineContext(), new RoomPagingUtil__RoomPagingUtilKt$queryItemCount$2(roomDatabase, "SELECT COUNT(*) FROM ( " + roomRawQuery.f() + " )", roomRawQuery, null), continuation);
    }
}

package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
final class FlattenedPageController<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlattenedPageEventStorage f49718a = new FlattenedPageEventStorage();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mutex f49719b = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f49720c = -1;

    public final PageEvent.Insert a() {
        PageEvent pageEvent = (PageEvent) CollectionsKt.firstOrNull(this.f49718a.b());
        if (pageEvent != null && (pageEvent instanceof PageEvent.Insert)) {
            PageEvent.Insert insert = (PageEvent.Insert) pageEvent;
            if (insert.j() == LoadType.REFRESH) {
                return insert;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.paging.FlattenedPageController$getStateAsEvents$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.paging.FlattenedPageController$getStateAsEvents$1 r0 = (androidx.paging.FlattenedPageController$getStateAsEvents$1) r0
            int r1 = r0.f49725f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49725f = r1
            goto L18
        L13:
            androidx.paging.FlattenedPageController$getStateAsEvents$1 r0 = new androidx.paging.FlattenedPageController$getStateAsEvents$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f49723c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f49725f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.f49722b
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.f49721a
            androidx.paging.FlattenedPageController r0 = (androidx.paging.FlattenedPageController) r0
            kotlin.ResultKt.b(r9)
            goto L4e
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.Mutex r9 = r8.f49719b
            r0.f49721a = r8
            r0.f49722b = r9
            r0.f49725f = r3
            java.lang.Object r0 = r9.f(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r8
            r1 = r9
        L4e:
            androidx.paging.FlattenedPageEventStorage r9 = r0.f49718a     // Catch: java.lang.Throwable -> L80
            java.util.List r9 = r9.b()     // Catch: java.lang.Throwable -> L80
            int r0 = r0.f49720c     // Catch: java.lang.Throwable -> L80
            int r2 = r9.size()     // Catch: java.lang.Throwable -> L80
            int r0 = r0 - r2
            int r0 = r0 + r3
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch: java.lang.Throwable -> L80
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L80
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r3)     // Catch: java.lang.Throwable -> L80
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L80
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> L80
            r3 = 0
        L6e:
            boolean r5 = r9.hasNext()     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L8f
            java.lang.Object r5 = r9.next()     // Catch: java.lang.Throwable -> L80
            int r6 = r3 + 1
            if (r3 >= 0) goto L82
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch: java.lang.Throwable -> L80
            goto L82
        L80:
            r9 = move-exception
            goto L93
        L82:
            androidx.paging.PageEvent r5 = (androidx.paging.PageEvent) r5     // Catch: java.lang.Throwable -> L80
            kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue     // Catch: java.lang.Throwable -> L80
            int r3 = r3 + r0
            r7.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            r2.add(r7)     // Catch: java.lang.Throwable -> L80
            r3 = r6
            goto L6e
        L8f:
            r1.i(r4)
            return r2
        L93:
            r1.i(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.collections.IndexedValue r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.FlattenedPageController$record$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.paging.FlattenedPageController$record$1 r0 = (androidx.paging.FlattenedPageController$record$1) r0
            int r1 = r0.f49731g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49731g = r1
            goto L18
        L13:
            androidx.paging.FlattenedPageController$record$1 r0 = new androidx.paging.FlattenedPageController$record$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f49729d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f49731g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f49728c
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f49727b
            kotlin.collections.IndexedValue r1 = (kotlin.collections.IndexedValue) r1
            java.lang.Object r0 = r0.f49726a
            androidx.paging.FlattenedPageController r0 = (androidx.paging.FlattenedPageController) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.f49719b
            r0.f49726a = r5
            r0.f49727b = r6
            r0.f49728c = r7
            r0.f49731g = r3
            java.lang.Object r0 = r7.f(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            int r1 = r6.getIndex()     // Catch: java.lang.Throwable -> L6e
            r0.f49720c = r1     // Catch: java.lang.Throwable -> L6e
            androidx.paging.FlattenedPageEventStorage r0 = r0.f49718a     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r6 = r6.getValue()     // Catch: java.lang.Throwable -> L6e
            androidx.paging.PageEvent r6 = (androidx.paging.PageEvent) r6     // Catch: java.lang.Throwable -> L6e
            r0.a(r6)     // Catch: java.lang.Throwable -> L6e
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L6e
            r7.i(r4)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L6e:
            r6 = move-exception
            r7.i(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.c(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

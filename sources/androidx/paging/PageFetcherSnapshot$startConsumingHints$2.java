package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$2", f = "PageFetcherSnapshot.kt", l = {646, 233}, m = "invokeSuspend")
final class PageFetcherSnapshot$startConsumingHints$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f50209d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PageFetcherSnapshot f50210f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$startConsumingHints$2(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f50210f = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PageFetcherSnapshot$startConsumingHints$2(this.f50210f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        if (r1.q(r7, r3, r6) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f50209d
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r7)
            goto L64
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            java.lang.Object r1 = r6.f50208c
            androidx.paging.PageFetcherSnapshot r1 = (androidx.paging.PageFetcherSnapshot) r1
            java.lang.Object r3 = r6.f50207b
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r5 = r6.f50206a
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            kotlin.ResultKt.b(r7)
            goto L48
        L2b:
            kotlin.ResultKt.b(r7)
            androidx.paging.PageFetcherSnapshot r1 = r6.f50210f
            androidx.paging.PageFetcherSnapshotState$Holder r5 = androidx.paging.PageFetcherSnapshot.k(r1)
            kotlinx.coroutines.sync.Mutex r7 = androidx.paging.PageFetcherSnapshotState.Holder.a(r5)
            r6.f50206a = r5
            r6.f50207b = r7
            r6.f50208c = r1
            r6.f50209d = r3
            java.lang.Object r3 = r7.f(r4, r6)
            if (r3 != r0) goto L47
            goto L63
        L47:
            r3 = r7
        L48:
            androidx.paging.PageFetcherSnapshotState r7 = androidx.paging.PageFetcherSnapshotState.Holder.b(r5)     // Catch: java.lang.Throwable -> L67
            kotlinx.coroutines.flow.Flow r7 = r7.f()     // Catch: java.lang.Throwable -> L67
            r3.i(r4)
            androidx.paging.LoadType r3 = androidx.paging.LoadType.PREPEND
            r6.f50206a = r4
            r6.f50207b = r4
            r6.f50208c = r4
            r6.f50209d = r2
            java.lang.Object r7 = androidx.paging.PageFetcherSnapshot.a(r1, r7, r3, r6)
            if (r7 != r0) goto L64
        L63:
            return r0
        L64:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L67:
            r7 = move-exception
            r3.i(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$startConsumingHints$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PageFetcherSnapshot$startConsumingHints$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}

package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [Value] */
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
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$2", f = "PageFetcherSnapshot.kt", l = {646, 179}, m = "invokeSuspend")
final class PageFetcherSnapshot$pageEventFlow$2<Value> extends SuspendLambda implements Function2<FlowCollector<? super PageEvent<Value>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f50198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f50199d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PageFetcherSnapshot f50200f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$pageEventFlow$2(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f50200f = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PageFetcherSnapshot$pageEventFlow$2 pageFetcherSnapshot$pageEventFlow$2 = new PageFetcherSnapshot$pageEventFlow$2(this.f50200f, continuation);
        pageFetcherSnapshot$pageEventFlow$2.f50199d = obj;
        return pageFetcherSnapshot$pageEventFlow$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
    
        if (r1.emit(r2, r6) == r0) goto L17;
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
            int r1 = r6.f50198c
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L2b
            if (r1 == r2) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.b(r7)
            goto L70
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            java.lang.Object r1 = r6.f50197b
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r2 = r6.f50196a
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r6.f50199d
            androidx.paging.PageFetcherSnapshotState$Holder r5 = (androidx.paging.PageFetcherSnapshotState.Holder) r5
            kotlin.ResultKt.b(r7)
            goto L4d
        L2b:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f50199d
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            androidx.paging.PageFetcherSnapshot r7 = r6.f50200f
            androidx.paging.PageFetcherSnapshotState$Holder r5 = androidx.paging.PageFetcherSnapshot.k(r7)
            kotlinx.coroutines.sync.Mutex r7 = androidx.paging.PageFetcherSnapshotState.Holder.a(r5)
            r6.f50199d = r5
            r6.f50196a = r7
            r6.f50197b = r1
            r6.f50198c = r2
            java.lang.Object r2 = r7.f(r4, r6)
            if (r2 != r0) goto L4c
            goto L6f
        L4c:
            r2 = r7
        L4d:
            androidx.paging.PageFetcherSnapshotState r7 = androidx.paging.PageFetcherSnapshotState.Holder.b(r5)     // Catch: java.lang.Throwable -> L73
            androidx.paging.MutableLoadStateCollection r7 = r7.p()     // Catch: java.lang.Throwable -> L73
            androidx.paging.LoadStates r7 = r7.d()     // Catch: java.lang.Throwable -> L73
            r2.i(r4)
            androidx.paging.PageEvent$LoadStateUpdate r2 = new androidx.paging.PageEvent$LoadStateUpdate
            r2.<init>(r7, r4, r3, r4)
            r6.f50199d = r4
            r6.f50196a = r4
            r6.f50197b = r4
            r6.f50198c = r3
            java.lang.Object r7 = r1.emit(r2, r6)
            if (r7 != r0) goto L70
        L6f:
            return r0
        L70:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L73:
            r7 = move-exception
            r2.i(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((PageFetcherSnapshot$pageEventFlow$2) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}

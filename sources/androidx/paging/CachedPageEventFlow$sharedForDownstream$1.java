package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$sharedForDownstream$1", f = "CachedPageEventFlow.kt", l = {62, 67}, m = "invokeSuspend")
final class CachedPageEventFlow$sharedForDownstream$1<T> extends SuspendLambda implements Function2<FlowCollector<? super IndexedValue<? extends PageEvent<T>>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f49614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f49615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f49616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CachedPageEventFlow f49617d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$sharedForDownstream$1(CachedPageEventFlow cachedPageEventFlow, Continuation continuation) {
        super(2, continuation);
        this.f49617d = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CachedPageEventFlow$sharedForDownstream$1 cachedPageEventFlow$sharedForDownstream$1 = new CachedPageEventFlow$sharedForDownstream$1(this.f49617d, continuation);
        cachedPageEventFlow$sharedForDownstream$1.f49616c = obj;
        return cachedPageEventFlow$sharedForDownstream$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r5 == r0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f49615b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r4.f49614a
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r4.f49616c
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.ResultKt.b(r5)
            goto L56
        L1a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L22:
            java.lang.Object r1 = r4.f49616c
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.b(r5)
            goto L43
        L2a:
            kotlin.ResultKt.b(r5)
            java.lang.Object r5 = r4.f49616c
            r1 = r5
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            androidx.paging.CachedPageEventFlow r5 = r4.f49617d
            androidx.paging.FlattenedPageController r5 = androidx.paging.CachedPageEventFlow.c(r5)
            r4.f49616c = r1
            r4.f49615b = r3
            java.lang.Object r5 = r5.b(r4)
            if (r5 != r0) goto L43
            goto L6e
        L43:
            java.util.List r5 = (java.util.List) r5
            androidx.paging.CachedPageEventFlow r3 = r4.f49617d
            kotlinx.coroutines.Job r3 = androidx.paging.CachedPageEventFlow.a(r3)
            r3.start()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r3 = r1
            r1 = r5
        L56:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L6f
            java.lang.Object r5 = r1.next()
            kotlin.collections.IndexedValue r5 = (kotlin.collections.IndexedValue) r5
            r4.f49616c = r3
            r4.f49614a = r1
            r4.f49615b = r2
            java.lang.Object r5 = r3.emit(r5, r4)
            if (r5 != r0) goto L56
        L6e:
            return r0
        L6f:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPageEventFlow$sharedForDownstream$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((CachedPageEventFlow$sharedForDownstream$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}

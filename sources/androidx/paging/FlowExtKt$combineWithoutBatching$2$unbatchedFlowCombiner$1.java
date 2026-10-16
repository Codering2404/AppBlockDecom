package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1", f = "FlowExt.kt", l = {141, 141}, m = "invokeSuspend")
public final class FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 extends SuspendLambda implements Function4<Object, Object, CombineSource, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f49758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f49759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f49760d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SimpleProducerScope f49761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function4 f49762g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(SimpleProducerScope simpleProducerScope, Function4 function4, Continuation continuation) {
        super(4, continuation);
        this.f49761f = simpleProducerScope;
        this.f49762g = function4;
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Object obj, Object obj2, CombineSource combineSource, Continuation continuation) {
        FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 = new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(this.f49761f, this.f49762g, continuation);
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.f49758b = obj;
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.f49759c = obj2;
        flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.f49760d = combineSource;
        return flowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r1.y(r9, r8) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f49757a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.b(r9)
            goto L4b
        L13:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1b:
            java.lang.Object r1 = r8.f49758b
            androidx.paging.SimpleProducerScope r1 = (androidx.paging.SimpleProducerScope) r1
            kotlin.ResultKt.b(r9)
            goto L40
        L23:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f49758b
            java.lang.Object r1 = r8.f49759c
            java.lang.Object r5 = r8.f49760d
            androidx.paging.CombineSource r5 = (androidx.paging.CombineSource) r5
            androidx.paging.SimpleProducerScope r6 = r8.f49761f
            kotlin.jvm.functions.Function4 r7 = r8.f49762g
            r8.f49758b = r6
            r8.f49759c = r2
            r8.f49757a = r4
            java.lang.Object r9 = r7.invoke(r9, r1, r5, r8)
            if (r9 != r0) goto L3f
            goto L4a
        L3f:
            r1 = r6
        L40:
            r8.f49758b = r2
            r8.f49757a = r3
            java.lang.Object r9 = r1.y(r9, r8)
            if (r9 != r0) goto L4b
        L4a:
            return r0
        L4b:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

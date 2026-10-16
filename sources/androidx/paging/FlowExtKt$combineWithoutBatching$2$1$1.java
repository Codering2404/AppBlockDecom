package androidx.paging;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", l = {147}, m = "invokeSuspend")
public final class FlowExtKt$combineWithoutBatching$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Flow f49746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AtomicInteger f49747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SimpleProducerScope f49748d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ UnbatchedFlowCombiner f49749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f49750g;

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UnbatchedFlowCombiner f49751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f49752b;

        public AnonymousClass1(UnbatchedFlowCombiner unbatchedFlowCombiner, int i3) {
            this.f49751a = unbatchedFlowCombiner;
            this.f49752b = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        
            if (kotlinx.coroutines.YieldKt.a(r0) == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1 r0 = (androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1) r0
                int r1 = r0.f49755c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49755c = r1
                goto L18
            L13:
                androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1 r0 = new androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f49753a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f49755c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L38
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r7)
                goto L51
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                kotlin.ResultKt.b(r7)
                goto L48
            L38:
                kotlin.ResultKt.b(r7)
                androidx.paging.UnbatchedFlowCombiner r7 = r5.f49751a
                int r2 = r5.f49752b
                r0.f49755c = r4
                java.lang.Object r6 = r7.a(r2, r6, r0)
                if (r6 != r1) goto L48
                goto L50
            L48:
                r0.f49755c = r3
                java.lang.Object r6 = kotlinx.coroutines.YieldKt.a(r0)
                if (r6 != r1) goto L51
            L50:
                return r1
            L51:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2$1$1(Flow flow, AtomicInteger atomicInteger, SimpleProducerScope simpleProducerScope, UnbatchedFlowCombiner unbatchedFlowCombiner, int i3, Continuation continuation) {
        super(2, continuation);
        this.f49746b = flow;
        this.f49747c = atomicInteger;
        this.f49748d = simpleProducerScope;
        this.f49749f = unbatchedFlowCombiner;
        this.f49750g = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowExtKt$combineWithoutBatching$2$1$1(this.f49746b, this.f49747c, this.f49748d, this.f49749f, this.f49750g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AtomicInteger atomicInteger;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49745a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flow = this.f49746b;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f49749f, this.f49750g);
                this.f49745a = 1;
                if (flow.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                SendChannel.DefaultImpls.a(this.f49748d, null, 1, null);
            }
            return Unit.f139807a;
        } finally {
            if (this.f49747c.decrementAndGet() == 0) {
                SendChannel.DefaultImpls.a(this.f49748d, null, 1, null);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlowExtKt$combineWithoutBatching$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}

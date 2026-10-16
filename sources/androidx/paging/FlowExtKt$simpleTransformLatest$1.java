package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1", f = "FlowExt.kt", l = {88}, m = "invokeSuspend")
final class FlowExtKt$simpleTransformLatest$1 extends SuspendLambda implements Function2<SimpleProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f49799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f49800d;

    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1$1", f = "FlowExt.kt", l = {89}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f49801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function3 f49803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChannelFlowCollector f49804d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function3 function3, ChannelFlowCollector channelFlowCollector, Continuation continuation) {
            super(2, continuation);
            this.f49803c = function3;
            this.f49804d = channelFlowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f49803c, this.f49804d, continuation);
            anonymousClass1.f49802b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f49801a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Object obj2 = this.f49802b;
                Function3 function3 = this.f49803c;
                ChannelFlowCollector channelFlowCollector = this.f49804d;
                this.f49801a = 1;
                if (function3.invoke(channelFlowCollector, obj2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$simpleTransformLatest$1(Flow flow, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f49799c = flow;
        this.f49800d = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$simpleTransformLatest$1 flowExtKt$simpleTransformLatest$1 = new FlowExtKt$simpleTransformLatest$1(this.f49799c, this.f49800d, continuation);
        flowExtKt$simpleTransformLatest$1.f49798b = obj;
        return flowExtKt$simpleTransformLatest$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SimpleProducerScope simpleProducerScope, Continuation continuation) {
        return ((FlowExtKt$simpleTransformLatest$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49797a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.f49798b;
            Flow flow = this.f49799c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f49800d, new ChannelFlowCollector(simpleProducerScope), null);
            this.f49797a = 1;
            if (FlowKt.l(flow, anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}

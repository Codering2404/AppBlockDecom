package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Flow f142287d;

    public ChannelFlowOperator(Flow flow, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        super(coroutineContext, i3, bufferOverflow);
        this.f142287d = flow;
    }

    static /* synthetic */ Object n(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        if (channelFlowOperator.f142263b == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext coroutineContextJ = CoroutineContextKt.j(context, channelFlowOperator.f142262a);
            if (Intrinsics.areEqual(coroutineContextJ, context)) {
                Object objQ = channelFlowOperator.q(flowCollector, continuation);
                return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.t8;
            if (Intrinsics.areEqual(coroutineContextJ.get(key), context.get(key))) {
                Object objP = channelFlowOperator.p(flowCollector, coroutineContextJ, continuation);
                return objP == IntrinsicsKt.f() ? objP : Unit.f139807a;
            }
        }
        Object objCollect = super.collect(flowCollector, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    static /* synthetic */ Object o(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object objQ = channelFlowOperator.q(new SendingCollector(producerScope), continuation);
        return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
    }

    private final Object p(FlowCollector flowCollector, CoroutineContext coroutineContext, Continuation continuation) {
        return ChannelFlowKt.d(coroutineContext, ChannelFlowKt.e(flowCollector, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return n(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope producerScope, Continuation continuation) {
        return o(this, producerScope, continuation);
    }

    protected abstract Object q(FlowCollector flowCollector, Continuation continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f142287d + " -> " + super.toString();
    }
}

package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class FlowKt {
    public static final Object A(FlowCollector flowCollector, Flow flow, Continuation continuation) {
        return FlowKt__CollectKt.c(flowCollector, flow, continuation);
    }

    public static final void B(FlowCollector flowCollector) {
        FlowKt__EmittersKt.b(flowCollector);
    }

    public static final Flow C(Flow flow) {
        return FlowKt__TransformKt.a(flow);
    }

    public static final Object D(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.a(flow, continuation);
    }

    public static final Object E(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    public static final Object F(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.c(flow, continuation);
    }

    public static final Object G(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__ReduceKt.d(flow, function2, continuation);
    }

    public static final ReceiveChannel H(CoroutineScope coroutineScope, long j3) {
        return FlowKt__DelayKt.a(coroutineScope, j3);
    }

    public static final Flow I(Function2 function2) {
        return FlowKt__BuildersKt.d(function2);
    }

    public static final Flow J(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt__ZipKt.f(flow, flow2, function3);
    }

    public static final Flow K(Object obj) {
        return FlowKt__BuildersKt.e(obj);
    }

    public static final Flow L(Object... objArr) {
        return FlowKt__BuildersKt.f(objArr);
    }

    public static final Flow M(Flow flow, CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.f(flow, coroutineContext);
    }

    public static final int N() {
        return FlowKt__MergeKt.a();
    }

    public static final Object O(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.f(flow, continuation);
    }

    public static final Object P(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.g(flow, continuation);
    }

    public static final Job Q(Flow flow, CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.d(flow, coroutineScope);
    }

    public static final Flow R(Flow flow, Function2 function2) {
        return FlowKt__MergeKt.b(flow, function2);
    }

    public static final Flow S(Iterable iterable) {
        return FlowKt__MergeKt.c(iterable);
    }

    public static final Flow T(Flow... flowArr) {
        return FlowKt__MergeKt.d(flowArr);
    }

    public static final Flow U(Flow flow, Function3 function3) {
        return FlowKt__EmittersKt.d(flow, function3);
    }

    public static final Flow V(Flow flow, Function2 function2) {
        return FlowKt__TransformKt.b(flow, function2);
    }

    public static final Flow W(Flow flow, Function2 function2) {
        return FlowKt__EmittersKt.e(flow, function2);
    }

    public static final SharedFlow X(SharedFlow sharedFlow, Function2 function2) {
        return FlowKt__ShareKt.f(sharedFlow, function2);
    }

    public static final ReceiveChannel Y(Flow flow, CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.e(flow, coroutineScope);
    }

    public static final Object Z(Flow flow, Function3 function3, Continuation continuation) {
        return FlowKt__ReduceKt.h(flow, function3, continuation);
    }

    public static final Flow a(Iterable iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    public static final Flow a0(Flow flow, Function4 function4) {
        return FlowKt__ErrorsKt.e(flow, function4);
    }

    public static final SharedFlow b(MutableSharedFlow mutableSharedFlow) {
        return FlowKt__ShareKt.a(mutableSharedFlow);
    }

    public static final Flow b0(Flow flow, Object obj, Function3 function3) {
        return FlowKt__TransformKt.c(flow, obj, function3);
    }

    public static final StateFlow c(MutableStateFlow mutableStateFlow) {
        return FlowKt__ShareKt.b(mutableStateFlow);
    }

    public static final Flow c0(Flow flow, Object obj, Function3 function3) {
        return FlowKt__TransformKt.d(flow, obj, function3);
    }

    public static final Flow d(Flow flow, int i3, BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.a(flow, i3, bufferOverflow);
    }

    public static final SharedFlow d0(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i3) {
        return FlowKt__ShareKt.g(flow, coroutineScope, sharingStarted, i3);
    }

    public static final Object e0(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.i(flow, continuation);
    }

    public static final Flow f(Function2 function2) {
        return FlowKt__BuildersKt.b(function2);
    }

    public static final Object f0(Flow flow, Continuation continuation) {
        return FlowKt__ReduceKt.j(flow, continuation);
    }

    public static final Flow g(Flow flow) {
        return FlowKt__ContextKt.c(flow);
    }

    public static final Object g0(Flow flow, CoroutineScope coroutineScope, Continuation continuation) {
        return FlowKt__ShareKt.h(flow, coroutineScope, continuation);
    }

    public static final Flow h(Flow flow, Function3 function3) {
        return FlowKt__ErrorsKt.a(flow, function3);
    }

    public static final StateFlow h0(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, Object obj) {
        return FlowKt__ShareKt.i(flow, coroutineScope, sharingStarted, obj);
    }

    public static final Object i(Flow flow, FlowCollector flowCollector, Continuation continuation) {
        return FlowKt__ErrorsKt.b(flow, flowCollector, continuation);
    }

    public static final Flow i0(Flow flow, int i3) {
        return FlowKt__LimitKt.f(flow, i3);
    }

    public static final Flow j(Function2 function2) {
        return FlowKt__BuildersKt.c(function2);
    }

    public static final Flow j0(Flow flow, Function2 function2) {
        return FlowKt__LimitKt.g(flow, function2);
    }

    public static final Object k(Flow flow, Continuation continuation) {
        return FlowKt__CollectKt.a(flow, continuation);
    }

    public static final Flow k0(Flow flow, long j3) {
        return FlowKt__DelayKt.b(flow, j3);
    }

    public static final Object l(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CollectKt.b(flow, function2, continuation);
    }

    public static final Object l0(Flow flow, Collection collection, Continuation continuation) {
        return FlowKt__CollectionKt.a(flow, collection, continuation);
    }

    public static final Flow m(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt__ZipKt.b(flow, flow2, function3);
    }

    public static final Flow m0(Flow flow, Function3 function3) {
        return FlowKt__MergeKt.e(flow, function3);
    }

    public static final Flow n(Flow flow, Flow flow2, Flow flow3, Function4 function4) {
        return FlowKt__ZipKt.c(flow, flow2, flow3, function4);
    }

    public static final Flow n0(Flow flow) {
        return FlowKt__TransformKt.e(flow);
    }

    public static final Flow o(Flow flow, Flow flow2, Flow flow3, Flow flow4, Function5 function5) {
        return FlowKt__ZipKt.d(flow, flow2, flow3, flow4, function5);
    }

    public static final Flow p(Flow flow, Flow flow2, Flow flow3, Flow flow4, Flow flow5, Function6 function6) {
        return FlowKt__ZipKt.e(flow, flow2, flow3, flow4, flow5, function6);
    }

    public static final Flow q(Flow flow) {
        return FlowKt__ContextKt.e(flow);
    }

    public static final Flow r(ReceiveChannel receiveChannel) {
        return FlowKt__ChannelsKt.b(receiveChannel);
    }

    public static final Object s(Flow flow, Continuation continuation) {
        return FlowKt__CountKt.a(flow, continuation);
    }

    public static final Object t(Flow flow, Function2 function2, Continuation continuation) {
        return FlowKt__CountKt.b(flow, function2, continuation);
    }

    public static final Flow u(Flow flow) {
        return FlowKt__DistinctKt.e(flow);
    }

    public static final Flow v(Flow flow, Function2 function2) {
        return FlowKt__DistinctKt.f(flow, function2);
    }

    public static final Flow w(Flow flow, Function1 function1) {
        return FlowKt__DistinctKt.g(flow, function1);
    }

    public static final Flow x(Flow flow, int i3) {
        return FlowKt__LimitKt.c(flow, i3);
    }

    public static final Flow y(Flow flow, Function2 function2) {
        return FlowKt__LimitKt.d(flow, function2);
    }

    public static final Object z(FlowCollector flowCollector, ReceiveChannel receiveChannel, Continuation continuation) {
        return FlowKt__ChannelsKt.c(flowCollector, receiveChannel, continuation);
    }
}

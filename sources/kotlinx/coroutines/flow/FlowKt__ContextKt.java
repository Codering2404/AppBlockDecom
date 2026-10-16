package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

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
final /* synthetic */ class FlowKt__ContextKt {
    public static final Flow a(Flow flow, int i3, BufferOverflow bufferOverflow) {
        if (i3 < 0 && i3 != -2 && i3 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i3).toString());
        }
        if (i3 == -1 && bufferOverflow != BufferOverflow.f141062a) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i3 == -1) {
            bufferOverflow = BufferOverflow.f141063b;
            i3 = 0;
        }
        int i4 = i3;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if (flow instanceof FusibleFlow) {
            return FusibleFlow.DefaultImpls.a((FusibleFlow) flow, null, i4, bufferOverflow2, 1, null);
        }
        return new ChannelFlowOperatorImpl(flow, null, i4, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ Flow b(Flow flow, int i3, BufferOverflow bufferOverflow, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = -2;
        }
        if ((i4 & 2) != 0) {
            bufferOverflow = BufferOverflow.f141062a;
        }
        return FlowKt.d(flow, i3, bufferOverflow);
    }

    public static final Flow c(Flow flow) {
        return flow instanceof CancellableFlow ? flow : new CancellableFlowImpl(flow);
    }

    private static final void d(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.v8) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    public static final Flow e(Flow flow) {
        return b(flow, -1, null, 2, null);
    }

    public static final Flow f(Flow flow, CoroutineContext coroutineContext) {
        d(coroutineContext);
        if (Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.f139889a)) {
            return flow;
        }
        if (flow instanceof FusibleFlow) {
            return FusibleFlow.DefaultImpls.a((FusibleFlow) flow, coroutineContext, 0, null, 6, null);
        }
        return new ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12, null);
    }
}

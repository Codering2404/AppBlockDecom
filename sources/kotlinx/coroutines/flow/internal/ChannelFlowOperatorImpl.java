package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
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
public final class ChannelFlowOperatorImpl<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ ChannelFlowOperatorImpl(Flow flow, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow, (i4 & 2) != 0 ? EmptyCoroutineContext.f139889a : coroutineContext, (i4 & 4) != 0 ? -3 : i3, (i4 & 8) != 0 ? BufferOverflow.f141062a : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow i(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return new ChannelFlowOperatorImpl(this.f142287d, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Flow j() {
        return this.f142287d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    protected Object q(FlowCollector flowCollector, Continuation continuation) {
        Object objCollect = this.f142287d.collect(flowCollector, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public ChannelFlowOperatorImpl(Flow flow, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i3, bufferOverflow);
    }
}

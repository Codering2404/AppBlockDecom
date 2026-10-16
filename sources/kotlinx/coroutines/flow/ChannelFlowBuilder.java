package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

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
class ChannelFlowBuilder<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f141478d;

    public /* synthetic */ ChannelFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i4 & 2) != 0 ? EmptyCoroutineContext.f139889a : coroutineContext, (i4 & 4) != 0 ? -2 : i3, (i4 & 8) != 0 ? BufferOverflow.f141062a : bufferOverflow);
    }

    static /* synthetic */ Object n(ChannelFlowBuilder channelFlowBuilder, ProducerScope producerScope, Continuation continuation) {
        Object objInvoke = channelFlowBuilder.f141478d.invoke(producerScope, continuation);
        return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope producerScope, Continuation continuation) {
        return n(this, producerScope, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow i(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return new ChannelFlowBuilder(this.f141478d, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f141478d + "] -> " + super.toString();
    }

    public ChannelFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        super(coroutineContext, i3, bufferOverflow);
        this.f141478d = function2;
    }
}

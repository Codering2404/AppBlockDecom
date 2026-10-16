package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;

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
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Flow f142272d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f142273f;

    public ChannelFlowMerge(Flow flow, int i3, CoroutineContext coroutineContext, int i4, BufferOverflow bufferOverflow) {
        super(coroutineContext, i4, bufferOverflow);
        this.f142272d = flow;
        this.f142273f = i3;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String f() {
        return "concurrency=" + this.f142273f;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope producerScope, Continuation continuation) {
        Object objCollect = this.f142272d.collect(new ChannelFlowMerge$collectTo$2((Job) continuation.getContext().get(Job.v8), SemaphoreKt.b(this.f142273f, 0, 2, null), producerScope, new SendingCollector(producerScope)), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow i(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.f142272d, this.f142273f, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel m(CoroutineScope coroutineScope) {
        return ProduceKt.b(coroutineScope, this.f142262a, this.f142263b, k());
    }
}

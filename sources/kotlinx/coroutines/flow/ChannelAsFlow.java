package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

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
final class ChannelAsFlow<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f141475g = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReceiveChannel f141476d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f141477f;

    public /* synthetic */ ChannelAsFlow(ReceiveChannel receiveChannel, boolean z2, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(receiveChannel, z2, (i4 & 4) != 0 ? EmptyCoroutineContext.f139889a : coroutineContext, (i4 & 8) != 0 ? -3 : i3, (i4 & 16) != 0 ? BufferOverflow.f141062a : bufferOverflow);
    }

    private final void o() {
        if (this.f141477f && f141475g.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        if (this.f142263b != -3) {
            Object objCollect = super.collect(flowCollector, continuation);
            return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
        }
        o();
        Object objD = FlowKt__ChannelsKt.d(flowCollector, this.f141476d, this.f141477f, continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String f() {
        return "channel=" + this.f141476d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope producerScope, Continuation continuation) throws Throwable {
        Object objD = FlowKt__ChannelsKt.d(new SendingCollector(producerScope), this.f141476d, this.f141477f, continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow i(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return new ChannelAsFlow(this.f141476d, this.f141477f, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Flow j() {
        return new ChannelAsFlow(this.f141476d, this.f141477f, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel m(CoroutineScope coroutineScope) {
        o();
        return this.f142263b == -3 ? this.f141476d : super.m(coroutineScope);
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel, boolean z2, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        super(coroutineContext, i3, bufferOverflow);
        this.f141476d = receiveChannel;
        this.f141477f = z2;
        this.consumed$volatile = 0;
    }
}

package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;

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
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Iterable f142310d;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i4 & 2) != 0 ? EmptyCoroutineContext.f139889a : coroutineContext, (i4 & 4) != 0 ? -2 : i3, (i4 & 8) != 0 ? BufferOverflow.f141062a : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(ProducerScope producerScope, Continuation continuation) {
        SendingCollector sendingCollector = new SendingCollector(producerScope);
        Iterator<T> it = this.f142310d.iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.d(producerScope, null, null, new ChannelLimitedFlowMerge$collectTo$2$1((Flow) it.next(), sendingCollector, null), 3, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow i(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f142310d, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel m(CoroutineScope coroutineScope) {
        return ProduceKt.b(coroutineScope, this.f142262a, this.f142263b, k());
    }

    public ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        super(coroutineContext, i3, bufferOverflow);
        this.f142310d = iterable;
    }
}

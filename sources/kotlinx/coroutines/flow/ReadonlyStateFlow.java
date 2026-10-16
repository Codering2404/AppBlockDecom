package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
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
final class ReadonlyStateFlow<T> implements StateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ StateFlow f142175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Job f142176b;

    public ReadonlyStateFlow(StateFlow stateFlow, Job job) {
        this.f142175a = stateFlow;
        this.f142176b = job;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow a(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return StateFlowKt.d(this, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List b() {
        return this.f142175a.b();
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return this.f142175a.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public Object getValue() {
        return this.f142175a.getValue();
    }
}

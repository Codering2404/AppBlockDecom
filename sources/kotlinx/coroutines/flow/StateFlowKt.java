package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

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
public final class StateFlowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Symbol f142240a = new Symbol("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Symbol f142241b = new Symbol("PENDING");

    public static final MutableStateFlow a(Object obj) {
        if (obj == null) {
            obj = NullSurrogateKt.f142386a;
        }
        return new StateFlowImpl(obj);
    }

    public static final Flow d(StateFlow stateFlow, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return (((i3 < 0 || i3 >= 2) && i3 != -2) || bufferOverflow != BufferOverflow.f141063b) ? SharedFlowKt.e(stateFlow, coroutineContext, i3, bufferOverflow) : stateFlow;
    }
}

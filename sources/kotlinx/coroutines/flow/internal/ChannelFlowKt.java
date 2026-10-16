package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

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
public final class ChannelFlowKt {
    public static final ChannelFlow b(Flow flow) {
        ChannelFlow channelFlow = flow instanceof ChannelFlow ? (ChannelFlow) flow : null;
        if (channelFlow == null) {
            return new ChannelFlowOperatorImpl(flow, null, 0, null, 14, null);
        }
        return channelFlow;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation) {
        Object objI = ThreadContextKt.i(coroutineContext, obj2);
        try {
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(continuation, coroutineContext);
            Object objD = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.d(function2, obj, stackFrameContinuation) : ((Function2) TypeIntrinsics.f(function2, 2)).invoke(obj, stackFrameContinuation);
            ThreadContextKt.f(coroutineContext, objI);
            if (objD == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objD;
        } catch (Throwable th) {
            ThreadContextKt.f(coroutineContext, objI);
            throw th;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i3, Object obj3) {
        if ((i3 & 4) != 0) {
            obj2 = ThreadContextKt.g(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FlowCollector e(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        return ((flowCollector instanceof SendingCollector) || (flowCollector instanceof NopCollector)) ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }
}

package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
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
public final class SharedFlowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f142198a = new Symbol("NO_VALUE");

    public static final MutableSharedFlow a(int i3, int i4, BufferOverflow bufferOverflow) {
        if (i3 < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i3).toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i4).toString());
        }
        if (i3 > 0 || i4 > 0 || bufferOverflow == BufferOverflow.f141062a) {
            int i5 = i4 + i3;
            if (i5 < 0) {
                i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return new SharedFlowImpl(i3, i5, bufferOverflow);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
    }

    public static /* synthetic */ MutableSharedFlow b(int i3, int i4, BufferOverflow bufferOverflow, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            bufferOverflow = BufferOverflow.f141062a;
        }
        return a(i3, i4, bufferOverflow);
    }

    public static final Flow e(SharedFlow sharedFlow, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return ((i3 == 0 || i3 == -3) && bufferOverflow == BufferOverflow.f141062a) ? sharedFlow : new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i3, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j3) {
        return objArr[((int) j3) & (objArr.length - 1)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Object[] objArr, long j3, Object obj) {
        objArr[((int) j3) & (objArr.length - 1)] = obj;
    }
}

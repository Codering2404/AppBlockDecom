package kotlinx.coroutines.channels;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class ChannelKt {
    public static final Channel a(int i3, BufferOverflow bufferOverflow, Function1 function1) {
        if (i3 == -2) {
            return bufferOverflow == BufferOverflow.f141062a ? new BufferedChannel(Channel.w8.a(), function1) : new ConflatedBufferedChannel(1, bufferOverflow, function1);
        }
        if (i3 != -1) {
            return i3 != 0 ? i3 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.f141062a ? new BufferedChannel(i3, function1) : new ConflatedBufferedChannel(i3, bufferOverflow, function1) : new BufferedChannel(Api.BaseClientBuilder.API_PRIORITY_OTHER, function1) : bufferOverflow == BufferOverflow.f141062a ? new BufferedChannel(0, function1) : new ConflatedBufferedChannel(1, bufferOverflow, function1);
        }
        if (bufferOverflow == BufferOverflow.f141062a) {
            return new ConflatedBufferedChannel(1, BufferOverflow.f141063b, function1);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ Channel b(int i3, BufferOverflow bufferOverflow, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        if ((i4 & 2) != 0) {
            bufferOverflow = BufferOverflow.f141062a;
        }
        if ((i4 & 4) != 0) {
            function1 = null;
        }
        return a(i3, bufferOverflow, function1);
    }
}

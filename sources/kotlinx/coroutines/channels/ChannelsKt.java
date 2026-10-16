package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ChannelsKt {
    public static final void b(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    public static final Object s(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, sendChannel, continuation);
    }

    public static final Object t(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, collection, continuation);
    }

    public static final Object u(ReceiveChannel receiveChannel, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.c(receiveChannel, continuation);
    }

    public static final Object v(ReceiveChannel receiveChannel, Map map, Continuation continuation) {
        return ChannelsKt__DeprecatedKt.u(receiveChannel, map, continuation);
    }

    public static final Object w(SendChannel sendChannel, Object obj) {
        return ChannelsKt__ChannelsKt.a(sendChannel, obj);
    }
}

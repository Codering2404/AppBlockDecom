package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
@Deprecated
@Metadata
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BroadcastChannelImpl f141347a;

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean A() {
        return this.f141347a.A();
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException) {
        this.f141347a.cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel e() {
        return this.f141347a.e();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void g(Function1 function1) {
        this.f141347a.g(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        return this.f141347a.h(obj);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean w(Throwable th) {
        return this.f141347a.w(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object y(Object obj, Continuation continuation) {
        return this.f141347a.y(obj, continuation);
    }
}

package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

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
public final class NamedDispatcher extends CoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Delay f142474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f142475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f142476d;

    /* JADX WARN: Multi-variable type inference failed */
    public NamedDispatcher(CoroutineDispatcher coroutineDispatcher, String str) {
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.f142474b = delay == null ? DefaultExecutorKt.a() : delay;
        this.f142475c = coroutineDispatcher;
        this.f142476d = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void M(CoroutineContext coroutineContext, Runnable runnable) {
        this.f142475c.M(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void O(CoroutineContext coroutineContext, Runnable runnable) {
        this.f142475c.O(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean e0(CoroutineContext coroutineContext) {
        return this.f142475c.e0(coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public void i(long j3, CancellableContinuation cancellableContinuation) {
        this.f142474b.i(j3, cancellableContinuation);
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle m(long j3, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f142474b.m(j3, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return this.f142476d;
    }
}

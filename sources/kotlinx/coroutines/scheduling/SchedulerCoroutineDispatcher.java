package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

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
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f142544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f142545d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f142546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f142547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CoroutineScheduler f142548h = z0();

    public SchedulerCoroutineDispatcher(int i3, int i4, long j3, String str) {
        this.f142544c = i3;
        this.f142545d = i4;
        this.f142546f = j3;
        this.f142547g = str;
    }

    private final CoroutineScheduler z0() {
        return new CoroutineScheduler(this.f142544c, this.f142545d, this.f142546f, this.f142547g);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void M(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.k(this.f142548h, runnable, false, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void O(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.k(this.f142548h, runnable, false, true, 2, null);
    }

    public final void O0(Runnable runnable, boolean z2, boolean z3) {
        this.f142548h.j(runnable, z2, z3);
    }

    public void close() throws InterruptedException {
        this.f142548h.close();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor w0() {
        return this.f142548h;
    }
}

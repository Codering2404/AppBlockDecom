package okio;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class Pipe$source$1 implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timeout f145093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Pipe f145094b;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ReentrantLock reentrantLockE = this.f145094b.e();
        Pipe pipe = this.f145094b;
        reentrantLockE.lock();
        try {
            pipe.j(true);
            pipe.c().signalAll();
            Unit unit = Unit.f139807a;
        } finally {
            reentrantLockE.unlock();
        }
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        ReentrantLock reentrantLockE = this.f145094b.e();
        Pipe pipe = this.f145094b;
        reentrantLockE.lock();
        try {
            if (pipe.h()) {
                throw new IllegalStateException("closed");
            }
            if (pipe.b()) {
                throw new IOException("canceled");
            }
            while (pipe.a().size() == 0) {
                if (pipe.g()) {
                    reentrantLockE.unlock();
                    return -1L;
                }
                this.f145093a.a(pipe.c());
                if (pipe.b()) {
                    throw new IOException("canceled");
                }
            }
            long jT2 = pipe.a().t2(sink, j3);
            pipe.c().signalAll();
            reentrantLockE.unlock();
            return jT2;
        } catch (Throwable th) {
            reentrantLockE.unlock();
            throw th;
        }
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145093a;
    }
}

package okio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

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
public final class Throttler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f145119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f145120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f145121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f145122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantLock f145123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Condition f145124f;

    private final long b(long j3) {
        return (j3 * 1000000000) / this.f145120b;
    }

    private final long c(long j3) {
        return (j3 * this.f145120b) / 1000000000;
    }

    public final long a(long j3, long j4) {
        if (this.f145120b == 0) {
            return j4;
        }
        long jMax = Math.max(this.f145119a - j3, 0L);
        long jC = this.f145122d - c(jMax);
        if (jC >= j4) {
            this.f145119a = j3 + jMax + b(j4);
            return j4;
        }
        long j5 = this.f145121c;
        if (jC >= j5) {
            this.f145119a = j3 + b(this.f145122d);
            return jC;
        }
        long jMin = Math.min(j5, j4);
        long jB = jMax + b(jMin - this.f145122d);
        if (jB != 0) {
            return -jB;
        }
        this.f145119a = j3 + b(this.f145122d);
        return jMin;
    }

    public final long d(long j3) {
        if (j3 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        ReentrantLock reentrantLock = this.f145123e;
        reentrantLock.lock();
        while (true) {
            try {
                long jA = a(System.nanoTime(), j3);
                if (jA >= 0) {
                    return jA;
                }
                this.f145124f.awaitNanos(-jA);
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}

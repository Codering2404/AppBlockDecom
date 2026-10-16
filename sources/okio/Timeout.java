package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class Timeout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f145127d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Timeout f145128e = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        public Timeout h(long j3, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this;
        }

        @Override // okio.Timeout
        public void g() {
        }

        @Override // okio.Timeout
        public Timeout e(long j3) {
            return this;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f145129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f145130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f145131c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(long j3, long j4) {
            return (j3 != 0 && (j4 == 0 || j3 < j4)) ? j3 : j4;
        }

        private Companion() {
        }
    }

    public final void a(Condition condition) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(condition, "condition");
        try {
            boolean zF = f();
            long jI = i();
            long jNanoTime = 0;
            if (!zF && jI == 0) {
                condition.await();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF && jI != 0) {
                jI = Math.min(jI, d() - jNanoTime2);
            } else if (zF) {
                jI = d() - jNanoTime2;
            }
            if (jI > 0) {
                condition.await(jI, TimeUnit.NANOSECONDS);
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jI) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout b() {
        this.f145129a = false;
        return this;
    }

    public Timeout c() {
        this.f145131c = 0L;
        return this;
    }

    public long d() {
        if (this.f145129a) {
            return this.f145130b;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout e(long j3) {
        this.f145129a = true;
        this.f145130b = j3;
        return this;
    }

    public boolean f() {
        return this.f145129a;
    }

    public void g() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f145129a && this.f145130b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout h(long j3, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j3 >= 0) {
            this.f145131c = unit.toNanos(j3);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j3).toString());
    }

    public long i() {
        return this.f145131c;
    }

    public final void j(Object monitor) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        try {
            boolean zF = f();
            long jI = i();
            long jNanoTime = 0;
            if (!zF && jI == 0) {
                monitor.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF && jI != 0) {
                jI = Math.min(jI, d() - jNanoTime2);
            } else if (zF) {
                jI = d() - jNanoTime2;
            }
            if (jI > 0) {
                long j3 = jI / 1000000;
                monitor.wait(j3, (int) (jI - (1000000 * j3)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jI) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}

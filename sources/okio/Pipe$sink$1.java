package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class Pipe$sink$1 implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timeout f145091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Pipe f145092b;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        r1 = kotlin.Unit.f139807a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
    
        r0.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        if (r2 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        r0 = r12.f145092b;
        r1 = r2.v();
        r0 = r0.k().v();
        r3 = r1.i();
        r5 = okio.Timeout.f145127d.a(r0.i(), r1.i());
        r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r1.h(r5, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
    
        if (r1.f() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        r5 = r1.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        if (r0.f() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        r1.e(java.lang.Math.min(r1.d(), r0.d()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        r2.H0(r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c6, code lost:
    
        r1.h(r3, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
    
        if (r0.f() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        r1.e(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d3, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d4, code lost:
    
        r1.h(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00dd, code lost:
    
        if (r0.f() != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        r1.e(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
    
        throw r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e7, code lost:
    
        if (r0.f() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e9, code lost:
    
        r1.e(r0.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f0, code lost:
    
        r2.H0(r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f3, code lost:
    
        r1.h(r3, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fa, code lost:
    
        if (r0.f() == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fc, code lost:
    
        r1.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ff, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0100, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0101, code lost:
    
        r1.h(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010a, code lost:
    
        if (r0.f() != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
    
        r1.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010f, code lost:
    
        throw r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    @Override // okio.Sink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void H0(okio.Buffer r13, long r14) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.H0(okio.Buffer, long):void");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ReentrantLock reentrantLockE = this.f145092b.e();
        Pipe pipe = this.f145092b;
        reentrantLockE.lock();
        try {
            if (pipe.g()) {
                reentrantLockE.unlock();
                return;
            }
            Sink sinkD = pipe.d();
            if (sinkD == null) {
                if (pipe.h() && pipe.a().size() > 0) {
                    throw new IOException("source is closed");
                }
                pipe.i(true);
                pipe.c().signalAll();
                sinkD = null;
            }
            Unit unit = Unit.f139807a;
            reentrantLockE.unlock();
            if (sinkD != null) {
                Pipe pipe2 = this.f145092b;
                Timeout timeoutV = sinkD.v();
                Timeout timeoutV2 = pipe2.k().v();
                long jI = timeoutV.i();
                long jA = Timeout.f145127d.a(timeoutV2.i(), timeoutV.i());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeoutV.h(jA, timeUnit);
                if (!timeoutV.f()) {
                    if (timeoutV2.f()) {
                        timeoutV.e(timeoutV2.d());
                    }
                    try {
                        sinkD.close();
                        timeoutV.h(jI, timeUnit);
                        if (timeoutV2.f()) {
                            timeoutV.b();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        timeoutV.h(jI, TimeUnit.NANOSECONDS);
                        if (timeoutV2.f()) {
                            timeoutV.b();
                        }
                        throw th;
                    }
                }
                long jD = timeoutV.d();
                if (timeoutV2.f()) {
                    timeoutV.e(Math.min(timeoutV.d(), timeoutV2.d()));
                }
                try {
                    sinkD.close();
                    timeoutV.h(jI, timeUnit);
                    if (timeoutV2.f()) {
                        timeoutV.e(jD);
                    }
                } catch (Throwable th2) {
                    timeoutV.h(jI, TimeUnit.NANOSECONDS);
                    if (timeoutV2.f()) {
                        timeoutV.e(jD);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            reentrantLockE.unlock();
            throw th3;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        ReentrantLock reentrantLockE = this.f145092b.e();
        Pipe pipe = this.f145092b;
        reentrantLockE.lock();
        try {
            if (pipe.g()) {
                throw new IllegalStateException("closed");
            }
            if (pipe.b()) {
                throw new IOException("canceled");
            }
            Sink sinkD = pipe.d();
            if (sinkD == null) {
                if (pipe.h() && pipe.a().size() > 0) {
                    throw new IOException("source is closed");
                }
                sinkD = null;
            }
            Unit unit = Unit.f139807a;
            reentrantLockE.unlock();
            if (sinkD != null) {
                Pipe pipe2 = this.f145092b;
                Timeout timeoutV = sinkD.v();
                Timeout timeoutV2 = pipe2.k().v();
                long jI = timeoutV.i();
                long jA = Timeout.f145127d.a(timeoutV2.i(), timeoutV.i());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeoutV.h(jA, timeUnit);
                if (!timeoutV.f()) {
                    if (timeoutV2.f()) {
                        timeoutV.e(timeoutV2.d());
                    }
                    try {
                        sinkD.flush();
                        timeoutV.h(jI, timeUnit);
                        if (timeoutV2.f()) {
                            timeoutV.b();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        timeoutV.h(jI, TimeUnit.NANOSECONDS);
                        if (timeoutV2.f()) {
                            timeoutV.b();
                        }
                        throw th;
                    }
                }
                long jD = timeoutV.d();
                if (timeoutV2.f()) {
                    timeoutV.e(Math.min(timeoutV.d(), timeoutV2.d()));
                }
                try {
                    sinkD.flush();
                    timeoutV.h(jI, timeUnit);
                    if (timeoutV2.f()) {
                        timeoutV.e(jD);
                    }
                } catch (Throwable th2) {
                    timeoutV.h(jI, TimeUnit.NANOSECONDS);
                    if (timeoutV2.f()) {
                        timeoutV.e(jD);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            reentrantLockE.unlock();
            throw th3;
        }
    }

    @Override // okio.Sink
    public Timeout v() {
        return this.f145091a;
    }
}

package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.EventLoopImplBase;

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
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DefaultExecutor f140926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f140927j;

    static {
        Long l3;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        f140926i = defaultExecutor;
        EventLoop.h1(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f140927j = timeUnit.toNanos(l3.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized Thread C2() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(f140926i.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean J2() {
        return debugStatus == 4;
    }

    private final boolean K2() {
        int i3 = debugStatus;
        return i3 == 2 || i3 == 3;
    }

    private final synchronized boolean L2() {
        if (K2()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void M2() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    private final synchronized void z2() {
        if (K2()) {
            debugStatus = 3;
            h2();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread A1() {
        Thread thread = _thread;
        return thread == null ? C2() : thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected void B1(long j3, EventLoopImplBase.DelayedTask delayedTask) {
        M2();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void R1(Runnable runnable) {
        if (J2()) {
            M2();
        }
        super.R1(runnable);
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public DisposableHandle m(long j3, Runnable runnable, CoroutineContext coroutineContext) {
        return n2(j3, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadLocalEventLoop.f141011a.d(this);
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        if (abstractTimeSource != null) {
            abstractTimeSource.c();
        }
        try {
            if (!L2()) {
                _thread = null;
                z2();
                AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.f140870a;
                if (abstractTimeSource2 != null) {
                    abstractTimeSource2.g();
                }
                if (c2()) {
                    return;
                }
                A1();
                return;
            }
            long j3 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jT1 = t1();
                if (jT1 == Long.MAX_VALUE) {
                    AbstractTimeSource abstractTimeSource3 = AbstractTimeSourceKt.f140870a;
                    long jA = abstractTimeSource3 != null ? abstractTimeSource3.a() : System.nanoTime();
                    if (j3 == Long.MAX_VALUE) {
                        j3 = f140927j + jA;
                    }
                    long j4 = j3 - jA;
                    if (j4 <= 0) {
                        _thread = null;
                        z2();
                        AbstractTimeSource abstractTimeSource4 = AbstractTimeSourceKt.f140870a;
                        if (abstractTimeSource4 != null) {
                            abstractTimeSource4.g();
                        }
                        if (c2()) {
                            return;
                        }
                        A1();
                        return;
                    }
                    jT1 = RangesKt.l(jT1, j4);
                } else {
                    j3 = Long.MAX_VALUE;
                }
                if (jT1 > 0) {
                    if (K2()) {
                        _thread = null;
                        z2();
                        AbstractTimeSource abstractTimeSource5 = AbstractTimeSourceKt.f140870a;
                        if (abstractTimeSource5 != null) {
                            abstractTimeSource5.g();
                        }
                        if (c2()) {
                            return;
                        }
                        A1();
                        return;
                    }
                    AbstractTimeSource abstractTimeSource6 = AbstractTimeSourceKt.f140870a;
                    if (abstractTimeSource6 != null) {
                        abstractTimeSource6.b(this, jT1);
                    } else {
                        LockSupport.parkNanos(this, jT1);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            z2();
            AbstractTimeSource abstractTimeSource7 = AbstractTimeSourceKt.f140870a;
            if (abstractTimeSource7 != null) {
                abstractTimeSource7.g();
            }
            if (!c2()) {
                A1();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "DefaultExecutor";
    }
}

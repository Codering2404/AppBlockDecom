package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
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
public class AsyncTimeout extends Timeout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f144973i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ReentrantLock f144974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Condition f144975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f144976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f144977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static AsyncTimeout f144978n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f144979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AsyncTimeout f144980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f144981h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(AsyncTimeout asyncTimeout) {
            ReentrantLock reentrantLockF = AsyncTimeout.f144973i.f();
            reentrantLockF.lock();
            try {
                if (!asyncTimeout.f144979f) {
                    return false;
                }
                asyncTimeout.f144979f = false;
                for (AsyncTimeout asyncTimeout2 = AsyncTimeout.f144978n; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.f144980g) {
                    if (asyncTimeout2.f144980g == asyncTimeout) {
                        asyncTimeout2.f144980g = asyncTimeout.f144980g;
                        asyncTimeout.f144980g = null;
                        return false;
                    }
                }
                reentrantLockF.unlock();
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(AsyncTimeout asyncTimeout, long j3, boolean z2) {
            ReentrantLock reentrantLockF = AsyncTimeout.f144973i.f();
            reentrantLockF.lock();
            try {
                if (asyncTimeout.f144979f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                asyncTimeout.f144979f = true;
                if (AsyncTimeout.f144978n == null) {
                    AsyncTimeout.f144978n = new AsyncTimeout();
                    new Watchdog().start();
                }
                long jNanoTime = System.nanoTime();
                if (j3 != 0 && z2) {
                    asyncTimeout.f144981h = Math.min(j3, asyncTimeout.d() - jNanoTime) + jNanoTime;
                } else if (j3 != 0) {
                    asyncTimeout.f144981h = j3 + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    asyncTimeout.f144981h = asyncTimeout.d();
                }
                long jA = asyncTimeout.A(jNanoTime);
                AsyncTimeout asyncTimeout2 = AsyncTimeout.f144978n;
                Intrinsics.checkNotNull(asyncTimeout2);
                while (asyncTimeout2.f144980g != null) {
                    AsyncTimeout asyncTimeout3 = asyncTimeout2.f144980g;
                    Intrinsics.checkNotNull(asyncTimeout3);
                    if (jA < asyncTimeout3.A(jNanoTime)) {
                        break;
                    }
                    asyncTimeout2 = asyncTimeout2.f144980g;
                    Intrinsics.checkNotNull(asyncTimeout2);
                }
                asyncTimeout.f144980g = asyncTimeout2.f144980g;
                asyncTimeout2.f144980g = asyncTimeout;
                if (asyncTimeout2 == AsyncTimeout.f144978n) {
                    AsyncTimeout.f144973i.e().signal();
                }
                Unit unit = Unit.f139807a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public final AsyncTimeout c() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.f144978n;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.f144980g;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                e().await(AsyncTimeout.f144976l, TimeUnit.MILLISECONDS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.f144978n;
                Intrinsics.checkNotNull(asyncTimeout3);
                if (asyncTimeout3.f144980g != null || System.nanoTime() - jNanoTime < AsyncTimeout.f144977m) {
                    return null;
                }
                return AsyncTimeout.f144978n;
            }
            long jA = asyncTimeout2.A(System.nanoTime());
            if (jA > 0) {
                e().await(jA, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.f144978n;
            Intrinsics.checkNotNull(asyncTimeout4);
            asyncTimeout4.f144980g = asyncTimeout2.f144980g;
            asyncTimeout2.f144980g = null;
            return asyncTimeout2;
        }

        public final Condition e() {
            return AsyncTimeout.f144975k;
        }

        public final ReentrantLock f() {
            return AsyncTimeout.f144974j;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockF;
            AsyncTimeout asyncTimeoutC;
            while (true) {
                try {
                    Companion companion = AsyncTimeout.f144973i;
                    reentrantLockF = companion.f();
                    reentrantLockF.lock();
                    try {
                        asyncTimeoutC = companion.c();
                    } finally {
                        reentrantLockF.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (asyncTimeoutC == AsyncTimeout.f144978n) {
                    AsyncTimeout.f144978n = null;
                    return;
                }
                Unit unit = Unit.f139807a;
                reentrantLockF.unlock();
                if (asyncTimeoutC != null) {
                    asyncTimeoutC.D();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f144974j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "lock.newCondition()");
        f144975k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f144976l = millis;
        f144977m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A(long j3) {
        return this.f144981h - j3;
    }

    public final Sink B(final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink
            public void H0(Buffer source, long j3) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                SegmentedByteString.b(source.size(), 0L, j3);
                while (true) {
                    long j4 = 0;
                    if (j3 <= 0) {
                        return;
                    }
                    Segment segment = source.f144986a;
                    Intrinsics.checkNotNull(segment);
                    while (true) {
                        if (j4 >= 65536) {
                            break;
                        }
                        j4 += (long) (segment.f145106c - segment.f145105b);
                        if (j4 >= j3) {
                            j4 = j3;
                            break;
                        } else {
                            segment = segment.f145109f;
                            Intrinsics.checkNotNull(segment);
                        }
                    }
                    AsyncTimeout asyncTimeout = this.f144982a;
                    Sink sink2 = sink;
                    asyncTimeout.x();
                    try {
                        try {
                            sink2.H0(source, j4);
                            Unit unit = Unit.f139807a;
                            if (asyncTimeout.y()) {
                                throw asyncTimeout.r(null);
                            }
                            j3 -= j4;
                        } catch (IOException e3) {
                            if (!asyncTimeout.y()) {
                                throw e3;
                            }
                            throw asyncTimeout.r(e3);
                        }
                    } catch (Throwable th) {
                        asyncTimeout.y();
                        throw th;
                    }
                }
            }

            @Override // okio.Sink
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AsyncTimeout v() {
                return this.f144982a;
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = this.f144982a;
                Sink sink2 = sink;
                asyncTimeout.x();
                try {
                    sink2.close();
                    Unit unit = Unit.f139807a;
                    if (asyncTimeout.y()) {
                        throw asyncTimeout.r(null);
                    }
                } catch (IOException e3) {
                    if (!asyncTimeout.y()) {
                        throw e3;
                    }
                    throw asyncTimeout.r(e3);
                } finally {
                    asyncTimeout.y();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout asyncTimeout = this.f144982a;
                Sink sink2 = sink;
                asyncTimeout.x();
                try {
                    sink2.flush();
                    Unit unit = Unit.f139807a;
                    if (asyncTimeout.y()) {
                        throw asyncTimeout.r(null);
                    }
                } catch (IOException e3) {
                    if (!asyncTimeout.y()) {
                        throw e3;
                    }
                    throw asyncTimeout.r(e3);
                } finally {
                    asyncTimeout.y();
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }
        };
    }

    public final Source C(final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AsyncTimeout v() {
                return this.f144984a;
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = this.f144984a;
                Source source2 = source;
                asyncTimeout.x();
                try {
                    source2.close();
                    Unit unit = Unit.f139807a;
                    if (asyncTimeout.y()) {
                        throw asyncTimeout.r(null);
                    }
                } catch (IOException e3) {
                    if (!asyncTimeout.y()) {
                        throw e3;
                    }
                    throw asyncTimeout.r(e3);
                } finally {
                    asyncTimeout.y();
                }
            }

            @Override // okio.Source
            public long t2(Buffer sink, long j3) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                AsyncTimeout asyncTimeout = this.f144984a;
                Source source2 = source;
                asyncTimeout.x();
                try {
                    long jT2 = source2.t2(sink, j3);
                    if (asyncTimeout.y()) {
                        throw asyncTimeout.r(null);
                    }
                    return jT2;
                } catch (IOException e3) {
                    if (asyncTimeout.y()) {
                        throw asyncTimeout.r(e3);
                    }
                    throw e3;
                } finally {
                    asyncTimeout.y();
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    public final IOException r(IOException iOException) {
        return z(iOException);
    }

    public final void x() {
        long jI = i();
        boolean zF = f();
        if (jI != 0 || zF) {
            f144973i.g(this, jI, zF);
        }
    }

    public final boolean y() {
        return f144973i.d(this);
    }

    protected IOException z(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    protected void D() {
    }
}

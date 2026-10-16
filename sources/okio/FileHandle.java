package okio;

import java.io.Closeable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class FileHandle implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f145015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f145016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f145017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReentrantLock f145018d = _JvmPlatformKt.b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class FileHandleSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileHandle f145019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f145020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f145021c;

        public FileHandleSink(FileHandle fileHandle, long j3) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.f145019a = fileHandle;
            this.f145020b = j3;
        }

        @Override // okio.Sink
        public void H0(Buffer source, long j3) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f145021c) {
                throw new IllegalStateException("closed");
            }
            this.f145019a.K(this.f145020b, source, j3);
            this.f145020b += j3;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f145021c) {
                return;
            }
            this.f145021c = true;
            ReentrantLock reentrantLockJ = this.f145019a.j();
            reentrantLockJ.lock();
            try {
                FileHandle fileHandle = this.f145019a;
                fileHandle.f145017c--;
                if (this.f145019a.f145017c == 0 && this.f145019a.f145016b) {
                    Unit unit = Unit.f139807a;
                    reentrantLockJ.unlock();
                    this.f145019a.k();
                }
            } finally {
                reentrantLockJ.unlock();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.f145021c) {
                throw new IllegalStateException("closed");
            }
            this.f145019a.l();
        }

        @Override // okio.Sink
        public Timeout v() {
            return Timeout.f145128e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class FileHandleSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileHandle f145022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f145023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f145024c;

        public FileHandleSource(FileHandle fileHandle, long j3) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.f145022a = fileHandle;
            this.f145023b = j3;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f145024c) {
                return;
            }
            this.f145024c = true;
            ReentrantLock reentrantLockJ = this.f145022a.j();
            reentrantLockJ.lock();
            try {
                FileHandle fileHandle = this.f145022a;
                fileHandle.f145017c--;
                if (this.f145022a.f145017c == 0 && this.f145022a.f145016b) {
                    Unit unit = Unit.f139807a;
                    reentrantLockJ.unlock();
                    this.f145022a.k();
                }
            } finally {
                reentrantLockJ.unlock();
            }
        }

        @Override // okio.Source
        public long t2(Buffer sink, long j3) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.f145024c) {
                throw new IllegalStateException("closed");
            }
            long jZ = this.f145022a.z(this.f145023b, sink, j3);
            if (jZ != -1) {
                this.f145023b += jZ;
            }
            return jZ;
        }

        @Override // okio.Source
        public Timeout v() {
            return Timeout.f145128e;
        }
    }

    public FileHandle(boolean z2) {
        this.f145015a = z2;
    }

    public static /* synthetic */ Sink F(FileHandle fileHandle, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        return fileHandle.C(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(long j3, Buffer buffer, long j4) {
        SegmentedByteString.b(buffer.size(), 0L, j4);
        long j5 = j3 + j4;
        long j6 = j3;
        while (j6 < j5) {
            Segment segment = buffer.f144986a;
            Intrinsics.checkNotNull(segment);
            int iMin = (int) Math.min(j5 - j6, segment.f145106c - segment.f145105b);
            r(j6, segment.f145104a, segment.f145105b, iMin);
            segment.f145105b += iMin;
            long j7 = iMin;
            j6 += j7;
            buffer.j0(buffer.size() - j7);
            if (segment.f145105b == segment.f145106c) {
                buffer.f144986a = segment.b();
                SegmentPool.b(segment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long z(long j3, Buffer buffer, long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        long j5 = j4 + j3;
        long j6 = j3;
        while (true) {
            if (j6 >= j5) {
                break;
            }
            Segment segmentZ0 = buffer.z0(1);
            int iM = m(j6, segmentZ0.f145104a, segmentZ0.f145106c, (int) Math.min(j5 - j6, 8192 - r7));
            if (iM == -1) {
                if (segmentZ0.f145105b == segmentZ0.f145106c) {
                    buffer.f144986a = segmentZ0.b();
                    SegmentPool.b(segmentZ0);
                }
                if (j3 == j6) {
                    return -1L;
                }
            } else {
                segmentZ0.f145106c += iM;
                long j7 = iM;
                j6 += j7;
                buffer.j0(buffer.size() + j7);
            }
        }
        return j6 - j3;
    }

    public final Sink C(long j3) {
        if (!this.f145015a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f145018d;
        reentrantLock.lock();
        try {
            if (this.f145016b) {
                throw new IllegalStateException("closed");
            }
            this.f145017c++;
            reentrantLock.unlock();
            return new FileHandleSink(this, j3);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final Source J(long j3) {
        ReentrantLock reentrantLock = this.f145018d;
        reentrantLock.lock();
        try {
            if (this.f145016b) {
                throw new IllegalStateException("closed");
            }
            this.f145017c++;
            reentrantLock.unlock();
            return new FileHandleSource(this, j3);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f145018d;
        reentrantLock.lock();
        try {
            if (this.f145016b) {
                return;
            }
            this.f145016b = true;
            if (this.f145017c != 0) {
                return;
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            k();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f145015a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f145018d;
        reentrantLock.lock();
        try {
            if (this.f145016b) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            l();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ReentrantLock j() {
        return this.f145018d;
    }

    protected abstract void k();

    protected abstract void l();

    protected abstract int m(long j3, byte[] bArr, int i3, int i4);

    protected abstract long n();

    protected abstract void r(long j3, byte[] bArr, int i3, int i4);

    public final long size() {
        ReentrantLock reentrantLock = this.f145018d;
        reentrantLock.lock();
        try {
            if (this.f145016b) {
                throw new IllegalStateException("closed");
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            return n();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}

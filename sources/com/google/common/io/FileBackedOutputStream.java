package com.google.common.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class FileBackedOutputStream extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f85259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f85260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OutputStream f85261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MemoryOutput f85262d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f85263f;

    /* JADX INFO: renamed from: com.google.common.io.FileBackedOutputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileBackedOutputStream f85264a;

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return this.f85264a.b();
        }

        protected void finalize() {
            try {
                this.f85264a.reset();
            } catch (Throwable th) {
                th.printStackTrace(System.err);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.common.io.FileBackedOutputStream$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileBackedOutputStream f85265a;

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return this.f85265a.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }

        /* synthetic */ MemoryOutput(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized InputStream b() {
        if (this.f85263f != null) {
            return new FileInputStream(this.f85263f);
        }
        Objects.requireNonNull(this.f85262d);
        return new ByteArrayInputStream(this.f85262d.a(), 0, this.f85262d.getCount());
    }

    private void c(int i3) throws IOException {
        MemoryOutput memoryOutput = this.f85262d;
        if (memoryOutput == null || memoryOutput.getCount() + i3 <= this.f85259a) {
            return;
        }
        File fileA = TempFileCreator.f85290a.a("FileBackedOutputStream");
        if (this.f85260b) {
            fileA.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileA);
            fileOutputStream.write(this.f85262d.a(), 0, this.f85262d.getCount());
            fileOutputStream.flush();
            this.f85261c = fileOutputStream;
            this.f85263f = fileA;
            this.f85262d = null;
        } catch (IOException e3) {
            fileA.delete();
            throw e3;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f85261c.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        this.f85261c.flush();
    }

    public synchronized void reset() {
        AnonymousClass1 anonymousClass1 = null;
        try {
            close();
            MemoryOutput memoryOutput = this.f85262d;
            if (memoryOutput == null) {
                this.f85262d = new MemoryOutput(anonymousClass1);
            } else {
                memoryOutput.reset();
            }
            this.f85261c = this.f85262d;
            File file = this.f85263f;
            if (file != null) {
                this.f85263f = null;
                if (!file.delete()) {
                    throw new IOException("Could not delete: " + file);
                }
            }
        } catch (Throwable th) {
            if (this.f85262d == null) {
                this.f85262d = new MemoryOutput(anonymousClass1);
            } else {
                this.f85262d.reset();
            }
            this.f85261c = this.f85262d;
            File file2 = this.f85263f;
            if (file2 != null) {
                this.f85263f = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
            throw th;
        } finally {
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i3) {
        c(1);
        this.f85261c.write(i3);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i4) {
        c(i4);
        this.f85261c.write(bArr, i3, i4);
    }
}

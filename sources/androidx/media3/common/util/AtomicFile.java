package androidx.media3.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AtomicFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f41474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f41475b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AtomicFileOutputStream extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileOutputStream f41476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f41477b = false;

        public AtomicFileOutputStream(File file) {
            this.f41476a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f41477b) {
                return;
            }
            this.f41477b = true;
            flush();
            try {
                this.f41476a.getFD().sync();
            } catch (IOException e3) {
                Log.j("AtomicFile", "Failed to sync file descriptor:", e3);
            }
            this.f41476a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f41476a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i3) throws IOException {
            this.f41476a.write(i3);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f41476a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            this.f41476a.write(bArr, i3, i4);
        }
    }

    private void e() {
        if (this.f41475b.exists()) {
            this.f41474a.delete();
            this.f41475b.renameTo(this.f41474a);
        }
    }

    public void a() {
        this.f41474a.delete();
        this.f41475b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f41475b.delete();
    }

    public boolean c() {
        return this.f41474a.exists() || this.f41475b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.f41474a);
    }

    public OutputStream f() throws IOException {
        if (this.f41474a.exists()) {
            if (this.f41475b.exists()) {
                this.f41474a.delete();
            } else if (!this.f41474a.renameTo(this.f41475b)) {
                Log.i("AtomicFile", "Couldn't rename file " + this.f41474a + " to backup file " + this.f41475b);
            }
        }
        try {
            return new AtomicFileOutputStream(this.f41474a);
        } catch (FileNotFoundException e3) {
            File parentFile = this.f41474a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f41474a, e3);
            }
            try {
                return new AtomicFileOutputStream(this.f41474a);
            } catch (FileNotFoundException e4) {
                throw new IOException("Couldn't create " + this.f41474a, e4);
            }
        }
    }
}

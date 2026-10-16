package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ReusableBufferedOutputStream extends BufferedOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f42103a;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        Assertions.g(this.f42103a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f42103a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f42103a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            Util.f1(th);
        }
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i3) {
        super(outputStream, i3);
    }
}

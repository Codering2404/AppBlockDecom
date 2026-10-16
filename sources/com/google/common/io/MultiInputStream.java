package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class MultiInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator f85276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f85277b;

    public MultiInputStream(Iterator it) {
        this.f85276a = (Iterator) Preconditions.t(it);
        a();
    }

    private void a() {
        close();
        if (this.f85276a.hasNext()) {
            this.f85277b = ((ByteSource) this.f85276a.next()).a();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream inputStream = this.f85277b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.f85277b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f85277b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f85277b;
            if (inputStream == null) {
                return -1;
            }
            int i3 = inputStream.read();
            if (i3 != -1) {
                return i3;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        InputStream inputStream = this.f85277b;
        if (inputStream == null || j3 <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j3);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f85277b.skip(j3 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        Preconditions.t(bArr);
        while (true) {
            InputStream inputStream = this.f85277b;
            if (inputStream == null) {
                return -1;
            }
            int i5 = inputStream.read(bArr, i3, i4);
            if (i5 != -1) {
                return i5;
            }
            a();
        }
    }
}

package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CompositeInputStream extends InputStream {
    private int mCurrentIndex;
    private final InputStream[] mStreams;

    public CompositeInputStream(InputStream[] inputStreamArr) {
        if (inputStreamArr == null || inputStreamArr.length < 2) {
            throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
        }
        this.mStreams = inputStreamArr;
        this.mCurrentIndex = 0;
    }

    private void closeAll(int i3) throws IOException {
        IOException iOException = null;
        int i4 = 0;
        while (true) {
            InputStream[] inputStreamArr = this.mStreams;
            if (i4 >= inputStreamArr.length) {
                return;
            }
            try {
                inputStreamArr[i4].close();
            } catch (IOException e3) {
                e = e3;
                if (i4 != i3 && iOException != null) {
                    e = iOException;
                }
                if (iOException != null && iOException != e) {
                    LogUtil.w(iOException, "Suppressing exception");
                }
                iOException = e;
            }
            i4++;
        }
    }

    private boolean tryMoveToNextStream() {
        int i3 = this.mCurrentIndex;
        if (i3 + 1 >= this.mStreams.length) {
            return false;
        }
        this.mCurrentIndex = i3 + 1;
        return true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mStreams[this.mCurrentIndex].available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        closeAll(this.mCurrentIndex);
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        int i3 = read(new byte[(int) j3]);
        if (i3 >= 0) {
            return i3;
        }
        return -1L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        do {
            i5 = this.mStreams[this.mCurrentIndex].read(bArr, i3, i4);
            if (i5 != -1) {
                break;
            }
        } while (tryMoveToNextStream());
        return i5;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i3;
        do {
            i3 = this.mStreams[this.mCurrentIndex].read();
            if (i3 != -1) {
                break;
            }
        } while (tryMoveToNextStream());
        return i3;
    }
}

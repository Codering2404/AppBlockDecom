package com.google.crypto.tink.streamingaead;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class InputStreamDecrypter extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f87303a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    InputStream f87304b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    InputStream f87305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PrimitiveSet f87306d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    byte[] f87307f;

    public InputStreamDecrypter(PrimitiveSet primitiveSet, InputStream inputStream, byte[] bArr) {
        this.f87306d = primitiveSet;
        if (inputStream.markSupported()) {
            this.f87305c = inputStream;
        } else {
            this.f87305c = new BufferedInputStream(inputStream);
        }
        this.f87305c.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f87307f = (byte[]) bArr.clone();
    }

    private void a() {
        this.f87305c.mark(0);
    }

    private void b() throws IOException {
        this.f87305c.reset();
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        InputStream inputStream = this.f87304b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f87305c.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) != 1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        InputStream inputStream = this.f87304b;
        if (inputStream != null) {
            return inputStream.read(bArr, i3, i4);
        }
        if (!this.f87303a) {
            this.f87303a = true;
            Iterator it = this.f87306d.b().iterator();
            while (it.hasNext()) {
                try {
                    try {
                        InputStream inputStreamC = ((StreamingAead) ((PrimitiveSet.Entry) it.next()).a()).c(this.f87305c, this.f87307f);
                        int i5 = inputStreamC.read(bArr, i3, i4);
                        if (i5 != 0) {
                            this.f87304b = inputStreamC;
                            a();
                            return i5;
                        }
                        throw new IOException("Could not read bytes from the ciphertext stream");
                    } catch (GeneralSecurityException unused) {
                        b();
                    }
                } catch (IOException unused2) {
                    b();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
    }
}

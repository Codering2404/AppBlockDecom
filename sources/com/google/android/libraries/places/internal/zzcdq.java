package com.google.android.libraries.places.internal;

import com.facebook.internal.Utility;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdq extends InputStream implements zzbjz, zzbla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbex f77684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbff f77685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteArrayInputStream f77686c;

    zzcdq(zzbex zzbexVar, zzbff zzbffVar) {
        this.f77684a = zzbexVar;
        this.f77685b = zzbffVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbjz
    public final int a(OutputStream outputStream) throws IOException {
        zzbex zzbexVar = this.f77684a;
        if (zzbexVar != null) {
            int iJ = zzbexVar.j();
            this.f77684a.i(outputStream);
            this.f77684a = null;
            return iJ;
        }
        ByteArrayInputStream byteArrayInputStream = this.f77686c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        zzbdb zzbdbVar = zzcds.f77690a;
        Preconditions.u(byteArrayInputStream, "inputStream cannot be null!");
        Preconditions.u(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        long j3 = 0;
        while (true) {
            int i3 = byteArrayInputStream.read(bArr);
            if (i3 == -1) {
                int i4 = (int) j3;
                this.f77686c = null;
                return i4;
            }
            outputStream.write(bArr, 0, i3);
            j3 += (long) i3;
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        zzbex zzbexVar = this.f77684a;
        if (zzbexVar != null) {
            return zzbexVar.j();
        }
        ByteArrayInputStream byteArrayInputStream = this.f77686c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    final zzbex b() {
        zzbex zzbexVar = this.f77684a;
        if (zzbexVar != null) {
            return zzbexVar;
        }
        throw new IllegalStateException("message not available");
    }

    final zzbff c() {
        return this.f77685b;
    }

    @Override // java.io.InputStream
    public final int read() {
        zzbex zzbexVar = this.f77684a;
        if (zzbexVar != null) {
            this.f77686c = new ByteArrayInputStream(zzbexVar.b());
            this.f77684a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f77686c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) {
        zzbex zzbexVar = this.f77684a;
        if (zzbexVar != null) {
            int iJ = zzbexVar.j();
            if (iJ == 0) {
                this.f77684a = null;
                this.f77686c = null;
                return -1;
            }
            if (i4 >= iJ) {
                zzbcu zzbcuVarA = zzbcu.A(bArr, i3, iJ);
                this.f77684a.k(zzbcuVarA);
                zzbcuVarA.e();
                this.f77684a = null;
                this.f77686c = null;
                return iJ;
            }
            this.f77686c = new ByteArrayInputStream(this.f77684a.b());
            this.f77684a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f77686c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i3, i4);
        }
        return -1;
    }
}

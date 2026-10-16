package com.google.android.gms.internal.ads;

import com.sun.jna.Function;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaug extends ByteArrayOutputStream {
    private final zzatv zza;

    public zzaug(zzatv zzatvVar, int i3) {
        this.zza = zzatvVar;
        ((ByteArrayOutputStream) this).buf = zzatvVar.zza(Math.max(i3, Function.MAX_NARGS));
    }

    private final void zza(int i3) {
        int i4 = ((ByteArrayOutputStream) this).count;
        if (i4 + i3 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        zzatv zzatvVar = this.zza;
        int i5 = i4 + i3;
        byte[] bArrZza = zzatvVar.zza(i5 + i5);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrZza, 0, ((ByteArrayOutputStream) this).count);
        zzatvVar.zzb(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrZza;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.zzb(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zzb(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i3) {
        zza(1);
        super.write(i3);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i3, int i4) {
        zza(i4);
        super.write(bArr, i3, i4);
    }
}

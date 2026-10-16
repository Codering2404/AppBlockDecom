package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzieu extends InputStream {
    private Iterator zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    zzieu(Iterable iterable) {
        this.zza = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzc++;
        }
        this.zzd = -1;
        if (zza()) {
            return;
        }
        this.zzb = zzier.zzb;
        this.zze = 0;
        this.zzi = 0L;
    }

    private final boolean zza() {
        ByteBuffer byteBuffer;
        do {
            this.zzd++;
            if (!this.zza.hasNext()) {
                return false;
            }
            byteBuffer = (ByteBuffer) this.zza.next();
            this.zzb = byteBuffer;
        } while (!byteBuffer.hasRemaining());
        this.zze = this.zzb.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zziha.zzq(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    private final void zzb(int i3) {
        int i4 = this.zze + i3;
        this.zze = i4;
        if (i4 == this.zzb.limit()) {
            zza();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            int i3 = this.zzg[this.zze + this.zzh] & 255;
            zzb(1);
            return i3;
        }
        int iZzp = zziha.zzp(((long) this.zze) + this.zzi) & 255;
        zzb(1);
        return iZzp;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int iLimit = this.zzb.limit();
        int i5 = this.zze;
        int i6 = iLimit - i5;
        if (i4 > i6) {
            i4 = i6;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i5 + this.zzh, bArr, i3, i4);
            zzb(i4);
            return i4;
        }
        int iPosition = this.zzb.position();
        this.zzb.position(this.zze);
        this.zzb.get(bArr, i3, i4);
        this.zzb.position(iPosition);
        zzb(i4);
        return i4;
    }
}

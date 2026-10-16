package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzva extends zziv {
    private long zzg;
    private int zzh;
    private int zzi;

    public zzva() {
        super(2, 0);
        this.zzi = 32;
    }

    @Override // com.google.android.gms.internal.ads.zziv, com.google.android.gms.internal.ads.zziq
    public final void zza() {
        super.zza();
        this.zzh = 0;
    }

    public final void zzm(int i3) {
        this.zzi = i3;
    }

    public final long zzn() {
        return this.zzg;
    }

    public final int zzo() {
        return this.zzh;
    }

    public final boolean zzp() {
        return this.zzh > 0;
    }

    public final boolean zzq(zziv zzivVar) {
        ByteBuffer byteBuffer;
        zzgtj.zza(!zzivVar.zzi(1073741824));
        zzgtj.zza(!zzivVar.zzi(268435456));
        zzgtj.zza(!zzivVar.zzi(4));
        if (zzp()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzivVar.zzc;
            if (byteBuffer2 != null && (byteBuffer = this.zzc) != null && byteBuffer.position() + byteBuffer2.remaining() > 3072000) {
                return false;
            }
        }
        int i3 = this.zzh;
        this.zzh = i3 + 1;
        if (i3 == 0) {
            this.zze = zzivVar.zze;
            if (zzivVar.zzi(1)) {
                zzg(1);
            }
        }
        ByteBuffer byteBuffer3 = zzivVar.zzc;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzivVar.zze;
        return true;
    }
}

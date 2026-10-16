package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaus extends zzimd {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzimn zzm;
    private long zzn;

    public zzaus() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzimn.zzj;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzimb
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzimi.zza(zzauo.zzd(byteBuffer));
            this.zzh = zzimi.zza(zzauo.zzd(byteBuffer));
            this.zzi = zzauo.zza(byteBuffer);
            this.zzj = zzauo.zzd(byteBuffer);
        } else {
            this.zzg = zzimi.zza(zzauo.zza(byteBuffer));
            this.zzh = zzimi.zza(zzauo.zza(byteBuffer));
            this.zzi = zzauo.zza(byteBuffer);
            this.zzj = zzauo.zza(byteBuffer);
        }
        this.zzk = zzauo.zze(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzl = ((short) ((r1[1] & 255) | ((short) (65280 & (r1[0] << 8))))) / 256.0f;
        zzauo.zzb(byteBuffer);
        zzauo.zza(byteBuffer);
        zzauo.zza(byteBuffer);
        this.zzm = new zzimn(zzauo.zze(byteBuffer), zzauo.zze(byteBuffer), zzauo.zze(byteBuffer), zzauo.zze(byteBuffer), zzauo.zzf(byteBuffer), zzauo.zzf(byteBuffer), zzauo.zzf(byteBuffer), zzauo.zze(byteBuffer), zzauo.zze(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzauo.zza(byteBuffer);
    }
}

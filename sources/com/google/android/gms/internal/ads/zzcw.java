package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcw {
    private CharSequence zza;
    private Bitmap zzb;
    private Layout.Alignment zzc;
    private Layout.Alignment zzd;
    private float zze;
    private int zzf;
    private int zzg;
    private float zzh;
    private int zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private int zzn;
    private float zzo;
    private int zzp;

    public zzcw() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = -3.4028235E38f;
        this.zzf = Integer.MIN_VALUE;
        this.zzg = Integer.MIN_VALUE;
        this.zzh = -3.4028235E38f;
        this.zzi = Integer.MIN_VALUE;
        this.zzj = Integer.MIN_VALUE;
        this.zzk = -3.4028235E38f;
        this.zzl = -3.4028235E38f;
        this.zzm = -3.4028235E38f;
        this.zzn = Integer.MIN_VALUE;
    }

    public final zzcw zza(CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = null;
        return this;
    }

    @Pure
    public final CharSequence zzb() {
        return this.zza;
    }

    public final zzcw zzc(Bitmap bitmap) {
        this.zzb = bitmap;
        this.zza = null;
        return this;
    }

    public final zzcw zzd(Layout.Alignment alignment) {
        this.zzc = alignment;
        return this;
    }

    public final zzcw zze(Layout.Alignment alignment) {
        this.zzd = alignment;
        return this;
    }

    public final zzcw zzf(float f3, int i3) {
        this.zze = f3;
        this.zzf = i3;
        return this;
    }

    public final zzcw zzg(int i3) {
        this.zzg = i3;
        return this;
    }

    @Pure
    public final int zzh() {
        return this.zzg;
    }

    public final zzcw zzi(float f3) {
        this.zzh = f3;
        return this;
    }

    public final zzcw zzj(int i3) {
        this.zzi = i3;
        return this;
    }

    @Pure
    public final int zzk() {
        return this.zzi;
    }

    public final zzcw zzl(float f3, int i3) {
        this.zzk = f3;
        this.zzj = i3;
        return this;
    }

    public final zzcw zzm(float f3) {
        this.zzl = f3;
        return this;
    }

    public final zzcw zzn(float f3) {
        this.zzm = f3;
        return this;
    }

    public final zzcw zzo(int i3) {
        this.zzn = i3;
        return this;
    }

    public final zzcw zzp(float f3) {
        this.zzo = f3;
        return this;
    }

    public final zzcw zzq(int i3) {
        this.zzp = i3;
        return this;
    }

    public final zzcx zzr() {
        return new zzcx(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, false, -16777216, this.zzn, this.zzo, this.zzp, null);
    }

    /* synthetic */ zzcw(zzcx zzcxVar, byte[] bArr) {
        this.zza = zzcxVar.zza;
        this.zzb = zzcxVar.zzd;
        this.zzc = zzcxVar.zzb;
        this.zzd = zzcxVar.zzc;
        this.zze = zzcxVar.zze;
        this.zzf = zzcxVar.zzf;
        this.zzg = zzcxVar.zzg;
        this.zzh = zzcxVar.zzh;
        this.zzi = zzcxVar.zzi;
        this.zzj = zzcxVar.zzl;
        this.zzk = zzcxVar.zzm;
        this.zzl = zzcxVar.zzj;
        this.zzm = zzcxVar.zzk;
        this.zzn = zzcxVar.zzn;
        this.zzo = zzcxVar.zzo;
        this.zzp = zzcxVar.zzp;
    }
}

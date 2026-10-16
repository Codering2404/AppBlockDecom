package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcp implements zzco {
    protected zzcl zzb;
    protected zzcl zzc;
    private zzcl zzd;
    private zzcl zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzcp() {
        ByteBuffer byteBuffer = zzco.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzcl zzclVar = zzcl.zza;
        this.zzd = zzclVar;
        this.zze = zzclVar;
        this.zzb = zzclVar;
        this.zzc = zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzb(zzcl zzclVar) throws zzcn {
        this.zzd = zzclVar;
        this.zze = zzm(zzclVar);
        return zzc() ? this.zze : zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public boolean zzc() {
        return this.zze != zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zze() {
        this.zzh = true;
        zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public ByteBuffer zzf() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzco.zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public boolean zzg() {
        return this.zzh && this.zzg == zzco.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    @Deprecated
    public final void zzh() {
        zzcm zzcmVar = zzcm.zza;
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzi(zzcm zzcmVar) {
        this.zzg = zzco.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzo(zzcmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzj() {
        ByteBuffer byteBuffer = zzco.zza;
        this.zzg = byteBuffer;
        this.zzh = false;
        this.zzf = byteBuffer;
        zzcl zzclVar = zzcl.zza;
        this.zzd = zzclVar;
        this.zze = zzclVar;
        this.zzb = zzclVar;
        this.zzc = zzclVar;
        zzp();
    }

    protected final ByteBuffer zzk(int i3) {
        if (this.zzf.capacity() < i3) {
            this.zzf = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    protected final boolean zzl() {
        return this.zzg.hasRemaining();
    }

    protected zzcl zzm(zzcl zzclVar) throws zzcn {
        throw null;
    }

    protected void zzn() {
    }

    protected void zzp() {
    }

    protected void zzo(zzcm zzcmVar) {
    }
}

package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhz extends zzmb implements zznn {
    private zzhz() {
        throw null;
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzib) this.zza).zza());
    }

    public final int zzb() {
        return ((zzib) this.zza).zzb();
    }

    public final zzid zzc(int i3) {
        return ((zzib) this.zza).zzc(i3);
    }

    public final zzhz zzd(int i3, zzic zzicVar) {
        zzaX();
        ((zzib) this.zza).zzj(i3, (zzid) zzicVar.zzbc());
        return this;
    }

    public final zzhz zze(zzic zzicVar) {
        zzaX();
        ((zzib) this.zza).zzk((zzid) zzicVar.zzbc());
        return this;
    }

    public final zzhz zzf(Iterable iterable) {
        zzaX();
        ((zzib) this.zza).zzm(iterable);
        return this;
    }

    public final zzhz zzg() {
        zzaX();
        ((zzib) this.zza).zzn();
        return this;
    }

    public final String zzh() {
        return ((zzib) this.zza).zze();
    }

    public final zzhz zzi(String str) {
        zzaX();
        ((zzib) this.zza).zzo(str);
        return this;
    }

    public final zzhz zzj(String str) {
        zzaX();
        ((zzib) this.zza).zzp(str);
        return this;
    }

    /* synthetic */ zzhz(byte[] bArr) {
        super(zzib.zzh);
    }
}

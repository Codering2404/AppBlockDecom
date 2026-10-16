package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhr extends zzmb implements zznn {
    private zzhr() {
        throw null;
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzhs) this.zza).zza());
    }

    public final int zzb() {
        return ((zzhs) this.zza).zzb();
    }

    public final zzhw zzc(int i3) {
        return ((zzhs) this.zza).zzc(i3);
    }

    public final zzhr zzd(int i3, zzhw zzhwVar) {
        zzaX();
        ((zzhs) this.zza).zzm(i3, zzhwVar);
        return this;
    }

    public final zzhr zze(int i3, zzhv zzhvVar) {
        zzaX();
        ((zzhs) this.zza).zzm(i3, (zzhw) zzhvVar.zzbc());
        return this;
    }

    public final zzhr zzf(zzhw zzhwVar) {
        zzaX();
        ((zzhs) this.zza).zzn(zzhwVar);
        return this;
    }

    public final zzhr zzg(zzhv zzhvVar) {
        zzaX();
        ((zzhs) this.zza).zzn((zzhw) zzhvVar.zzbc());
        return this;
    }

    public final zzhr zzh(Iterable iterable) {
        zzaX();
        ((zzhs) this.zza).zzo(iterable);
        return this;
    }

    public final zzhr zzi() {
        zzaX();
        ((zzhs) this.zza).zzp();
        return this;
    }

    public final zzhr zzj(int i3) {
        zzaX();
        ((zzhs) this.zza).zzq(i3);
        return this;
    }

    public final String zzk() {
        return ((zzhs) this.zza).zzd();
    }

    public final zzhr zzl(String str) {
        zzaX();
        ((zzhs) this.zza).zzr(str);
        return this;
    }

    public final boolean zzm() {
        return ((zzhs) this.zza).zze();
    }

    public final long zzn() {
        return ((zzhs) this.zza).zzf();
    }

    public final zzhr zzo(long j3) {
        zzaX();
        ((zzhs) this.zza).zzs(j3);
        return this;
    }

    public final long zzp() {
        return ((zzhs) this.zza).zzh();
    }

    public final zzhr zzq(long j3) {
        zzaX();
        ((zzhs) this.zza).zzt(j3);
        return this;
    }

    public final zzhr zzr(long j3) {
        zzaX();
        ((zzhs) this.zza).zzu(j3);
        return this;
    }

    /* synthetic */ zzhr(byte[] bArr) {
        super(zzhs.zzj);
    }
}

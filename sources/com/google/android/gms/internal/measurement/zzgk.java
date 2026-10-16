package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgk extends zzmb implements zznn {
    private zzgk() {
        throw null;
    }

    public final int zza() {
        return ((zzgl) this.zza).zzf();
    }

    public final zzgj zzb(int i3) {
        return ((zzgl) this.zza).zzg(i3);
    }

    public final zzgk zzc(int i3, zzgi zzgiVar) {
        zzaX();
        ((zzgl) this.zza).zzt(i3, (zzgj) zzgiVar.zzbc());
        return this;
    }

    public final List zzd() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzh());
    }

    public final zzgk zze() {
        zzaX();
        ((zzgl) this.zza).zzu();
        return this;
    }

    public final zzgk zzf() {
        zzaX();
        ((zzgl) this.zza).zzv();
        return this;
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzgl) this.zza).zzk());
    }

    public final String zzh() {
        return ((zzgl) this.zza).zzm();
    }

    /* synthetic */ zzgk(byte[] bArr) {
        super(zzgl.zzu);
    }
}

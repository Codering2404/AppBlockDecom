package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.HashSet;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzbk {
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzgwm zzi;
    private zzgwm zzj;
    private zzgwm zzk;
    private zzgwm zzl;
    private zzgwm zzm;
    private int zzn;
    private int zzo;
    private zzgwm zzp;
    private zzbj zzq;
    private zzgwm zzr;
    private boolean zzs;
    private zzgwm zzt;
    private HashMap zzu;
    private HashSet zzv;

    public zzbk() {
        this.zza = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzb = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzc = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzd = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zze = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzf = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzg = true;
        this.zzh = true;
        this.zzi = zzgwm.zzi();
        this.zzj = zzgwm.zzi();
        this.zzk = zzgwm.zzi();
        this.zzl = zzgwm.zzi();
        this.zzm = zzgwm.zzi();
        this.zzn = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzo = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzp = zzgwm.zzi();
        this.zzq = zzbj.zza;
        this.zzr = zzgwm.zzi();
        this.zzs = true;
        this.zzt = zzgwm.zzi();
        this.zzu = new HashMap();
        this.zzv = new HashSet();
    }

    @EnsuresNonNull
    private final void zzx(zzbl zzblVar) {
        this.zza = zzblVar.zza;
        this.zzb = zzblVar.zzb;
        this.zzc = zzblVar.zzc;
        this.zzd = zzblVar.zzd;
        this.zze = zzblVar.zzi;
        this.zzf = zzblVar.zzj;
        this.zzg = zzblVar.zzk;
        this.zzh = zzblVar.zzl;
        this.zzj = zzblVar.zzn;
        this.zzi = zzblVar.zzm;
        this.zzk = zzblVar.zzo;
        this.zzl = zzblVar.zzq;
        this.zzm = zzblVar.zzr;
        this.zzn = zzblVar.zzt;
        this.zzo = zzblVar.zzu;
        this.zzp = zzblVar.zzv;
        this.zzq = zzblVar.zzw;
        this.zzr = zzblVar.zzy;
        this.zzs = zzblVar.zzB;
        this.zzt = zzblVar.zzz;
        this.zzv = new HashSet(zzblVar.zzI);
        this.zzu = new HashMap(zzblVar.zzH);
    }

    protected final zzbk zza(zzbl zzblVar) {
        zzx(zzblVar);
        return this;
    }

    final /* synthetic */ int zzb() {
        return this.zza;
    }

    final /* synthetic */ int zzc() {
        return this.zzb;
    }

    final /* synthetic */ int zzd() {
        return this.zzc;
    }

    final /* synthetic */ int zze() {
        return this.zzd;
    }

    final /* synthetic */ int zzf() {
        return this.zze;
    }

    final /* synthetic */ int zzg() {
        return this.zzf;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzg;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzh;
    }

    final /* synthetic */ zzgwm zzj() {
        return this.zzi;
    }

    final /* synthetic */ zzgwm zzk() {
        return this.zzj;
    }

    final /* synthetic */ zzgwm zzl() {
        return this.zzk;
    }

    final /* synthetic */ zzgwm zzm() {
        return this.zzl;
    }

    final /* synthetic */ zzgwm zzn() {
        return this.zzm;
    }

    final /* synthetic */ int zzo() {
        return this.zzn;
    }

    final /* synthetic */ int zzp() {
        return this.zzo;
    }

    final /* synthetic */ zzgwm zzq() {
        return this.zzp;
    }

    final /* synthetic */ zzbj zzr() {
        return this.zzq;
    }

    final /* synthetic */ zzgwm zzs() {
        return this.zzr;
    }

    final /* synthetic */ boolean zzt() {
        return this.zzs;
    }

    final /* synthetic */ zzgwm zzu() {
        return this.zzt;
    }

    final /* synthetic */ HashMap zzv() {
        return this.zzu;
    }

    final /* synthetic */ HashSet zzw() {
        return this.zzv;
    }

    protected zzbk(zzbl zzblVar) {
        zzx(zzblVar);
    }
}

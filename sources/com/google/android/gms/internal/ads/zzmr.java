package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmr {
    private final zzqf zza;
    private final zzmq zze;
    private final zznm zzh;
    private final zzdz zzi;
    private boolean zzj;
    private zzin zzk;
    private zzzf zzl = new zzzf(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzmr(zzmq zzmqVar, zznm zznmVar, zzdz zzdzVar, zzqf zzqfVar) {
        this.zza = zzqfVar;
        this.zze = zzmqVar;
        this.zzh = zznmVar;
        this.zzi = zzdzVar;
    }

    private final void zzr() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzmo zzmoVar = (zzmo) it.next();
            if (zzmoVar.zzc.isEmpty()) {
                zzs(zzmoVar);
                it.remove();
            }
        }
    }

    private final void zzs(zzmo zzmoVar) {
        zzmn zzmnVar = (zzmn) this.zzf.get(zzmoVar);
        if (zzmnVar != null) {
            zzmnVar.zza.zzr(zzmnVar.zzb);
        }
    }

    private final void zzt(int i3, int i4) {
        while (true) {
            i4--;
            if (i4 < i3) {
                return;
            }
            zzmo zzmoVar = (zzmo) this.zzb.remove(i4);
            this.zzd.remove(zzmoVar.zzb);
            zzu(i4, -zzmoVar.zza.zzz().zza());
            zzmoVar.zze = true;
            if (this.zzj) {
                zzw(zzmoVar);
            }
        }
    }

    private final void zzu(int i3, int i4) {
        while (true) {
            List list = this.zzb;
            if (i3 >= list.size()) {
                return;
            }
            ((zzmo) list.get(i3)).zzd += i4;
            i3++;
        }
    }

    private final void zzv(zzmo zzmoVar) {
        zzxf zzxfVar = zzmoVar.zza;
        zzxl zzxlVar = new zzxl() { // from class: com.google.android.gms.internal.ads.zzmp
            @Override // com.google.android.gms.internal.ads.zzxl
            public final /* synthetic */ void zza(zzxm zzxmVar, zzbf zzbfVar) {
                this.zza.zzi(zzxmVar, zzbfVar);
            }
        };
        zzmm zzmmVar = new zzmm(this, zzmoVar);
        this.zzf.put(zzmoVar, new zzmn(zzxfVar, zzxlVar, zzmmVar));
        zzxfVar.zzl(new Handler(zzfl.zzf(), null), zzmmVar);
        zzxfVar.zzn(new Handler(zzfl.zzf(), null), zzmmVar);
        zzxfVar.zzp(zzxlVar, this.zzk, this.zza);
    }

    private final void zzw(zzmo zzmoVar) {
        if (zzmoVar.zze && zzmoVar.zzc.isEmpty()) {
            zzmn zzmnVar = (zzmn) this.zzf.remove(zzmoVar);
            zzmnVar.getClass();
            zzxm zzxmVar = zzmnVar.zza;
            zzxmVar.zzs(zzmnVar.zzb);
            zzmm zzmmVar = zzmnVar.zzc;
            zzxmVar.zzm(zzmmVar);
            zzxmVar.zzo(zzmmVar);
            this.zzg.remove(zzmoVar);
        }
    }

    public final zzbf zza(int i3, int i4, List list) {
        zzgtj.zza(i3 >= 0 && i3 <= i4 && i4 <= zzc());
        zzgtj.zza(list.size() == i4 - i3);
        for (int i5 = i3; i5 < i4; i5++) {
            ((zzmo) this.zzb.get(i5)).zza.zzA((zzak) list.get(i5 - i3));
        }
        return zzh();
    }

    public final boolean zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final void zzd(zzin zzinVar) {
        zzgtj.zzi(!this.zzj);
        this.zzk = zzinVar;
        int i3 = 0;
        while (true) {
            List list = this.zzb;
            if (i3 >= list.size()) {
                this.zzj = true;
                return;
            }
            zzmo zzmoVar = (zzmo) list.get(i3);
            zzv(zzmoVar);
            this.zzg.add(zzmoVar);
            i3++;
        }
    }

    public final zzxi zze(zzxk zzxkVar, zzabl zzablVar, long j3) {
        int i3 = zzmy.zzb;
        Pair pair = (Pair) zzxkVar.zza;
        Object obj = pair.first;
        zzxk zzxkVarZza = zzxkVar.zza(pair.second);
        zzmo zzmoVar = (zzmo) this.zzd.get(obj);
        zzmoVar.getClass();
        this.zzg.add(zzmoVar);
        zzmn zzmnVar = (zzmn) this.zzf.get(zzmoVar);
        if (zzmnVar != null) {
            zzmnVar.zza.zzq(zzmnVar.zzb);
        }
        zzmoVar.zzc.add(zzxkVarZza);
        zzxc zzxcVarZzC = zzmoVar.zza.zzG(zzxkVarZza, zzablVar, j3);
        this.zzc.put(zzxcVarZzC, zzmoVar);
        zzr();
        return zzxcVarZzC;
    }

    public final void zzf(zzxi zzxiVar) {
        IdentityHashMap identityHashMap = this.zzc;
        zzmo zzmoVar = (zzmo) identityHashMap.remove(zzxiVar);
        zzmoVar.getClass();
        zzmoVar.zza.zzD(zzxiVar);
        zzmoVar.zzc.remove(((zzxc) zzxiVar).zza);
        if (!identityHashMap.isEmpty()) {
            zzr();
        }
        zzw(zzmoVar);
    }

    public final void zzg() {
        for (zzmn zzmnVar : this.zzf.values()) {
            try {
                zzmnVar.zza.zzs(zzmnVar.zzb);
            } catch (RuntimeException e3) {
                zzeg.zzf("MediaSourceList", "Failed to release child source.", e3);
            }
            zzxm zzxmVar = zzmnVar.zza;
            zzmm zzmmVar = zzmnVar.zzc;
            zzxmVar.zzm(zzmmVar);
            zzxmVar.zzo(zzmmVar);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final zzbf zzh() {
        List list = this.zzb;
        if (list.isEmpty()) {
            return zzbf.zza;
        }
        int iZza = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzmo zzmoVar = (zzmo) list.get(i3);
            zzmoVar.zzd = iZza;
            iZza += zzmoVar.zza.zzz().zza();
        }
        return new zzmy(list, this.zzl);
    }

    final /* synthetic */ void zzi(zzxm zzxmVar, zzbf zzbfVar) {
        this.zze.zzo();
    }

    final /* synthetic */ zznm zzj() {
        return this.zzh;
    }

    final /* synthetic */ zzdz zzk() {
        return this.zzi;
    }

    public final zzbf zzl(List list, zzzf zzzfVar) {
        List list2 = this.zzb;
        zzt(0, list2.size());
        return zzm(list2.size(), list, zzzfVar);
    }

    public final zzbf zzm(int i3, List list, zzzf zzzfVar) {
        if (!list.isEmpty()) {
            this.zzl = zzzfVar;
            for (int i4 = i3; i4 < list.size() + i3; i4++) {
                zzmo zzmoVar = (zzmo) list.get(i4 - i3);
                if (i4 > 0) {
                    zzmo zzmoVar2 = (zzmo) this.zzb.get(i4 - 1);
                    zzmoVar.zzc(zzmoVar2.zzd + zzmoVar2.zza.zzz().zza());
                } else {
                    zzmoVar.zzc(0);
                }
                zzu(i4, zzmoVar.zza.zzz().zza());
                this.zzb.add(i4, zzmoVar);
                this.zzd.put(zzmoVar.zzb, zzmoVar);
                if (this.zzj) {
                    zzv(zzmoVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzmoVar);
                    } else {
                        zzs(zzmoVar);
                    }
                }
            }
        }
        return zzh();
    }

    public final zzbf zzn(int i3, int i4, zzzf zzzfVar) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= i4 && i4 <= zzc()) {
            z2 = true;
        }
        zzgtj.zza(z2);
        this.zzl = zzzfVar;
        zzt(i3, i4);
        return zzh();
    }

    public final zzbf zzo(int i3, int i4, int i5, zzzf zzzfVar) {
        zzgtj.zza(zzc() >= 0);
        this.zzl = null;
        return zzh();
    }

    public final zzbf zzp(zzzf zzzfVar) {
        int iZzc = zzc();
        if (zzzfVar.zza() != iZzc) {
            zzzfVar = zzzfVar.zzg().zzf(0, iZzc);
        }
        this.zzl = zzzfVar;
        return zzh();
    }

    public final zzzf zzq() {
        return this.zzl;
    }
}

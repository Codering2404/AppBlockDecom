package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzan extends zzai implements zzak {
    protected final List zza;
    protected final List zzb;
    protected zzg zzc;

    private zzan(zzan zzanVar) {
        super(zzanVar.zzd);
        ArrayList arrayList = new ArrayList(zzanVar.zza.size());
        this.zza = arrayList;
        arrayList.addAll(zzanVar.zza);
        ArrayList arrayList2 = new ArrayList(zzanVar.zzb.size());
        this.zzb = arrayList2;
        arrayList2.addAll(zzanVar.zzb);
        this.zzc = zzanVar.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        zzg zzgVarZzc = this.zzc.zzc();
        int i3 = 0;
        while (true) {
            List list2 = this.zza;
            if (i3 >= list2.size()) {
                break;
            }
            if (i3 < list.size()) {
                zzgVarZzc.zzf((String) list2.get(i3), zzgVar.zza((zzao) list.get(i3)));
            } else {
                zzgVarZzc.zzf((String) list2.get(i3), zzao.zzf);
            }
            i3++;
        }
        for (zzao zzaoVar : this.zzb) {
            zzao zzaoVarZza = zzgVarZzc.zza(zzaoVar);
            if (zzaoVarZza instanceof zzap) {
                zzaoVarZza = zzgVarZzc.zza(zzaoVar);
            }
            if (zzaoVarZza instanceof zzag) {
                return ((zzag) zzaoVarZza).zzb();
            }
        }
        return zzao.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzai, com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzan(this);
    }

    public zzan(String str, List list, List list2, zzg zzgVar) {
        super(str);
        this.zza = new ArrayList();
        this.zzc = zzgVar;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zza.add(((zzao) it.next()).zzc());
            }
        }
        this.zzb = new ArrayList(list2);
    }
}

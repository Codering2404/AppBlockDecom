package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecm {
    private final zzebw zza;
    private final zzdwz zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    zzecm(zzebw zzebwVar, zzdwz zzdwzVar) {
        this.zza = zzebwVar;
        this.zzb = zzdwzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final void zzc(List list) {
        zzdwy zzdwyVarZzc;
        zzdwy zzdwyVarZzc2;
        zzbxq zzbxqVar;
        synchronized (this.zzc) {
            try {
                if (this.zze) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbrp zzbrpVar = (zzbrp) it.next();
                    String string = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkK)).booleanValue() || (zzdwyVarZzc2 = this.zzb.zzc(zzbrpVar.zza)) == null || (zzbxqVar = zzdwyVarZzc2.zzc) == null) ? "" : zzbxqVar.toString();
                    String str = string;
                    boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkL)).booleanValue() && (zzdwyVarZzc = this.zzb.zzc(zzbrpVar.zza)) != null && zzdwyVarZzc.zzd;
                    List list2 = this.zzd;
                    String str2 = zzbrpVar.zza;
                    list2.add(new zzecl(str2, str, this.zzb.zzd(str2), zzbrpVar.zzb ? 1 : 0, zzbrpVar.zzd, zzbrpVar.zzc, z2));
                }
                this.zze = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza() {
        this.zza.zzb(new zzeck(this));
    }

    public final JSONArray zzb() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            try {
                if (!this.zze) {
                    zzebw zzebwVar = this.zza;
                    if (!zzebwVar.zze()) {
                        zza();
                        return jSONArray;
                    }
                    zzc(zzebwVar.zzd());
                }
                Iterator it = this.zzd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((zzecl) it.next()).zza());
                }
                return jSONArray;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

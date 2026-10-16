package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbn {
    private final List<zzbq> zza = new ArrayList();
    private zzok zzb = zzok.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb() {
        Iterator<zzbq> it = this.zza.iterator();
        while (it.hasNext()) {
            it.next().zza = false;
        }
    }

    public final zzbn zza(zzbq zzbqVar) {
        if (zzbqVar.zze != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzbqVar.zza) {
            zzb();
        }
        zzbqVar.zze = this;
        this.zza.add(zzbqVar);
        return this;
    }

    public final zzbm zza() throws GeneralSecurityException {
        int iZza;
        if (!this.zzc) {
            this.zzc = true;
            zzxh.zza zzaVarZzc = zzxh.zzc();
            ArrayList arrayList = new ArrayList(this.zza.size());
            List<zzbq> list = this.zza;
            for (int i3 = 0; i3 < list.size() - 1; i3++) {
                if (list.get(i3).zzd == zzbp.zza && list.get(i3 + 1).zzd != zzbp.zza) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer numValueOf = null;
            for (zzbq zzbqVar : this.zza) {
                if (zzbqVar.zzb != null) {
                    if (zzbqVar.zzd != null) {
                        if (zzbqVar.zzd == zzbp.zza) {
                            iZza = 0;
                            while (true) {
                                if (iZza != 0 && !hashSet.contains(Integer.valueOf(iZza))) {
                                    break;
                                }
                                iZza = zzqn.zza();
                            }
                        } else {
                            iZza = zzbp.zza(zzbqVar.zzd);
                        }
                        int i4 = iZza;
                        if (!hashSet.contains(Integer.valueOf(i4))) {
                            hashSet.add(Integer.valueOf(i4));
                            zzbi zzbiVarZza = zzop.zza().zza(zzbqVar.zzc, zzbqVar.zzc.zza() ? Integer.valueOf(i4) : null);
                            zzbs zzbsVar = new zzbs(zzbiVarZza, zzbm.zza(zzbqVar.zzb), i4, zzbqVar.zza, false, zzbs.zza);
                            zzaVarZzc.zza(zzbm.zzb(zzbiVarZza, zzbm.zza(zzbqVar.zzb), i4));
                            if (zzbqVar.zza) {
                                if (numValueOf == null) {
                                    numValueOf = Integer.valueOf(i4);
                                    if (zzbqVar.zzb != zzbk.zza) {
                                        throw new GeneralSecurityException("Primary key is not enabled");
                                    }
                                } else {
                                    throw new GeneralSecurityException("Two primaries were set");
                                }
                            }
                            arrayList.add(zzbsVar);
                        } else {
                            throw new GeneralSecurityException("Id " + i4 + " is used twice in the keyset");
                        }
                    } else {
                        throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                    }
                } else {
                    throw new GeneralSecurityException("Key Status not set.");
                }
            }
            if (numValueOf != null) {
                zzaVarZzc.zza(numValueOf.intValue());
                zzxh zzxhVar = (zzxh) ((zzalf) zzaVarZzc.zze());
                zzbm.zzd(zzxhVar);
                return zzbm.zzb(new zzbm(zzxhVar, arrayList, this.zzb));
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}

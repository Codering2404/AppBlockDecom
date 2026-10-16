package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdw {
    private final List zza = new ArrayList();
    private final Map zzb = new HashMap();
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final void zzc() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzhdu) it.next()).zzd(false);
        }
    }

    public final zzhdw zza(zzhdu zzhduVar) {
        if (zzhduVar.zzh() != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzhduVar.zzc()) {
            zzc();
        }
        zzhduVar.zzi(this);
        this.zza.add(zzhduVar);
        return this;
    }

    public final zzheb zzb() throws GeneralSecurityException {
        int i3;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        List<zzhdu> list = this.zza;
        ArrayList arrayList = new ArrayList(list.size());
        int i4 = 0;
        while (i4 < list.size() - 1) {
            int i5 = i4 + 1;
            if (((zzhdu) list.get(i4)).zzg() == zzhdv.zza && ((zzhdu) list.get(i5)).zzg() != zzhdv.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i4 = i5;
        }
        HashSet hashSet = new HashSet();
        byte[] bArr = null;
        Integer num = null;
        for (zzhdu zzhduVar : list) {
            zzhduVar.zze();
            if (zzhduVar.zzg() == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            int i6 = 3;
            if (zzhduVar.zzg() == zzhdv.zza) {
                int i7 = 0;
                while (true) {
                    if (i7 != 0 && !hashSet.contains(Integer.valueOf(i7))) {
                        break;
                    }
                    int i8 = zzhnz.zza;
                    i7 = 0;
                    while (i7 == 0) {
                        byte[] bArrZza = zzhnp.zza(4);
                        i7 = (bArrZza[3] & 255) | ((bArrZza[0] & 255) << 24) | ((bArrZza[1] & 255) << 16) | ((bArrZza[2] & 255) << 8);
                    }
                }
                i3 = i7;
            } else {
                zzhduVar.zzg();
                i3 = 0;
            }
            Integer numValueOf = Integer.valueOf(i3);
            if (hashSet.contains(numValueOf)) {
                int i9 = i3;
                StringBuilder sb = new StringBuilder(String.valueOf(i9).length() + 31);
                sb.append("Id ");
                sb.append(i9);
                sb.append(" is used twice in the keyset");
                throw new GeneralSecurityException(sb.toString());
            }
            hashSet.add(numValueOf);
            zzhdq zzhdqVarZzc = zzhmi.zza().zzc(zzhduVar.zzf(), true != zzhduVar.zzf().zza() ? null : numValueOf);
            zzhds zzhdsVarZze = zzhduVar.zze();
            zzhds zzhdsVar = zzhds.zza;
            if (!zzhdsVar.equals(zzhdsVarZze)) {
                if (zzhds.zzb.equals(zzhdsVarZze)) {
                    i6 = 4;
                } else {
                    if (!zzhds.zzc.equals(zzhdsVarZze)) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    i6 = 5;
                }
            }
            zzhdz zzhdzVar = new zzhdz(zzhdqVarZzc, i6, i3, zzhduVar.zzc(), false, zzhdz.zza, null);
            if (zzhduVar.zzc()) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzhduVar.zze() != zzhdsVar) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzhdzVar);
        }
        if (num != null) {
            return zzheb.zzi(new zzheb(arrayList, this.zzb, bArr));
        }
        throw new GeneralSecurityException("No primary was set");
    }
}

package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsd {
    public static zzam zza(zzam zzamVar) {
        zzan zzanVarZzg = zzam.zzg();
        zzanVarZzg.zzt(zzat.STRING);
        zzanVarZzg.zzt(zzamVar.zzh());
        zzanVarZzg.zzi();
        zzanVarZzg.zza(zzamVar.zzr());
        zzanVarZzg.zzo(zzamVar.zzP());
        return (zzam) zzanVarZzg.zzD();
    }

    public static zzrv zzb(zzac zzacVar) throws zzsc {
        zzam[] zzamVarArr = new zzam[zzacVar.zzf()];
        for (int i3 = 0; i3 < zzacVar.zzf(); i3++) {
            zze(i3, zzacVar, zzamVarArr, new HashSet(0));
        }
        zzrx zzrxVar = new zzrx(null);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < zzacVar.zze(); i4++) {
            arrayList.add(zzf(zzacVar.zzi(i4), zzacVar, zzamVarArr));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < zzacVar.zzc(); i5++) {
            arrayList2.add(zzf(zzacVar.zzh(i5), zzacVar, zzamVarArr));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < zzacVar.zza(); i6++) {
            zzrr zzrrVarZzf = zzf(zzacVar.zzg(i6), zzacVar, zzamVarArr);
            zzrxVar.zzb(zzrrVarZzf);
            arrayList3.add(zzrrVarZzf);
        }
        for (zzae zzaeVar : zzacVar.zzq()) {
            zzsb zzsbVar = new zzsb(null);
            Iterator it = zzaeVar.zzh().iterator();
            while (it.hasNext()) {
                zzsbVar.zzg((zzrr) arrayList2.get(((Integer) it.next()).intValue()));
            }
            Iterator it2 = zzaeVar.zzg().iterator();
            while (it2.hasNext()) {
                zzsbVar.zzf((zzrr) arrayList2.get(((Integer) it2.next()).intValue()));
            }
            Iterator it3 = zzaeVar.zze().iterator();
            while (it3.hasNext()) {
                zzsbVar.zzd((zzrr) arrayList.get(((Integer) it3.next()).intValue()));
            }
            Iterator it4 = zzaeVar.zzf().iterator();
            while (it4.hasNext()) {
                zzsbVar.zze(zzacVar.zzm(((Integer) it4.next()).intValue()).zzq());
            }
            Iterator it5 = zzaeVar.zzk().iterator();
            while (it5.hasNext()) {
                zzsbVar.zzj((zzrr) arrayList.get(((Integer) it5.next()).intValue()));
            }
            Iterator it6 = zzaeVar.zzl().iterator();
            while (it6.hasNext()) {
                zzsbVar.zzk(zzacVar.zzm(((Integer) it6.next()).intValue()).zzq());
            }
            Iterator it7 = zzaeVar.zzc().iterator();
            while (it7.hasNext()) {
                zzsbVar.zzb((zzrr) arrayList3.get(((Integer) it7.next()).intValue()));
            }
            Iterator it8 = zzaeVar.zzd().iterator();
            while (it8.hasNext()) {
                zzsbVar.zzc(zzacVar.zzm(((Integer) it8.next()).intValue()).zzq());
            }
            Iterator it9 = zzaeVar.zzi().iterator();
            while (it9.hasNext()) {
                zzsbVar.zzh((zzrr) arrayList3.get(((Integer) it9.next()).intValue()));
            }
            Iterator it10 = zzaeVar.zzj().iterator();
            while (it10.hasNext()) {
                zzsbVar.zzi(zzacVar.zzm(((Integer) it10.next()).intValue()).zzq());
            }
            zzrxVar.zzc(zzsbVar.zza());
        }
        zzrxVar.zze(zzacVar.zzn());
        zzrxVar.zzd(zzacVar.zzd());
        return zzrxVar.zza();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i3);
            }
        }
    }

    private static zzag zzd(zzam zzamVar) throws zzsc {
        zzxt zzxtVar = zzag.zza;
        if (!zzamVar.zzV(zzxtVar)) {
            zzh("Expected a ServingValue and didn't get one. Value is: ".concat(String.valueOf(zzamVar)));
        }
        return (zzag) zzamVar.zzU(zzxtVar);
    }

    private static zzam zze(int i3, zzac zzacVar, zzam[] zzamVarArr, Set set) throws zzsc {
        zzan zzanVar;
        zzan zzanVar2;
        Integer numValueOf = Integer.valueOf(i3);
        if (set.contains(numValueOf)) {
            zzh("Value cycle detected.  Current value reference: " + i3 + ".  Previous value references: " + set.toString() + ".");
        }
        zzan zzanVar3 = (zzan) ((zzam) zzg(zzacVar.zzr(), i3, "values")).zzZ();
        zzam zzamVar = zzamVarArr[i3];
        if (zzamVar != null) {
            return zzamVar;
        }
        set.add(numValueOf);
        zzat zzatVar = zzat.STRING;
        switch (zzanVar3.zzu()) {
            case STRING:
            case FUNCTION_ID:
            case INTEGER:
            case BOOLEAN:
                zzanVar = zzanVar3;
                break;
            case LIST:
                zzag zzagVarZzd = zzd((zzam) zzanVar3.zzD());
                zzan zzanVar4 = (zzan) zza((zzam) zzanVar3.zzD()).zzZ();
                zzanVar4.zzj();
                Iterator it = zzagVarZzd.zzf().iterator();
                while (it.hasNext()) {
                    zzanVar4.zze(zze(((Integer) it.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                zzanVar = zzanVar4;
                break;
            case MAP:
                zzanVar2 = (zzan) zza((zzam) zzanVar3.zzD()).zzZ();
                zzag zzagVarZzd2 = zzd((zzam) zzanVar3.zzD());
                if (zzagVarZzd2.zzc() != zzagVarZzd2.zzd()) {
                    zzh("Uneven map keys (" + zzagVarZzd2.zzc() + ") and map values (" + zzagVarZzd2.zzd() + ")");
                }
                zzanVar2.zzk();
                zzanVar2.zzl();
                Iterator it2 = zzagVarZzd2.zzg().iterator();
                while (it2.hasNext()) {
                    zzanVar2.zzf(zze(((Integer) it2.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                Iterator it3 = zzagVarZzd2.zzh().iterator();
                while (it3.hasNext()) {
                    zzanVar2.zzg(zze(((Integer) it3.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                zzanVar = zzanVar2;
                break;
            case MACRO_REFERENCE:
                zzanVar2 = (zzan) zza((zzam) zzanVar3.zzD()).zzZ();
                zzanVar2.zzr(com.google.android.gms.tagmanager.zzfu.zzm(com.google.android.gms.tagmanager.zzfu.zzk(zze(zzd((zzam) zzanVar3.zzD()).zza(), zzacVar, zzamVarArr, set))));
                zzanVar = zzanVar2;
                break;
            case TEMPLATE:
                zzanVar2 = (zzan) zza((zzam) zzanVar3.zzD()).zzZ();
                zzag zzagVarZzd3 = zzd((zzam) zzanVar3.zzD());
                zzanVar2.zzm();
                Iterator it4 = zzagVarZzd3.zzi().iterator();
                while (it4.hasNext()) {
                    zzanVar2.zzh(zze(((Integer) it4.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                zzanVar = zzanVar2;
                break;
            default:
                zzanVar = null;
                break;
        }
        if (zzanVar == null) {
            zzh("Invalid value: ".concat(zzanVar3.toString()));
        }
        zzamVarArr[i3] = (zzam) zzanVar.zzD();
        set.remove(Integer.valueOf(i3));
        return (zzam) zzanVar.zzD();
    }

    private static zzrr zzf(zzu zzuVar, zzac zzacVar, zzam[] zzamVarArr) throws zzsc {
        zzrt zzrtVar = new zzrt(null);
        Iterator it = zzuVar.zzc().iterator();
        while (it.hasNext()) {
            zzaa zzaaVar = (zzaa) zzg(zzacVar.zzp(), ((Integer) it.next()).intValue(), DiagnosticsEntry.PROPERTIES_KEY);
            String str = (String) zzg(zzacVar.zzo(), zzaaVar.zza(), "keys");
            int iZzc = zzaaVar.zzc();
            if (iZzc < 0 || iZzc >= zzamVarArr.length) {
                zzh("Index out of bounds detected: " + iZzc + " in values");
            }
            zzam zzamVar = zzamVarArr[iZzc];
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzrtVar.zzc(zzamVar);
            } else {
                zzrtVar.zzb(str, zzamVar);
            }
        }
        return zzrtVar.zza();
    }

    private static Object zzg(List list, int i3, String str) throws zzsc {
        if (i3 < 0 || i3 >= list.size()) {
            zzh("Index out of bounds detected: " + i3 + " in " + str);
        }
        return list.get(i3);
    }

    private static void zzh(String str) throws zzsc {
        Log.e("GoogleTagManager", str);
        throw new zzsc(str);
    }
}

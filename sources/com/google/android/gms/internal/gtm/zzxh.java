package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxh extends zzxg {
    zzxh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final int zza(Map.Entry entry) {
        return ((zzxs) entry.getKey()).zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final zzxk zzb(Object obj) {
        return ((zzxr) obj).zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final zzxk zzc(Object obj) {
        return ((zzxr) obj).zzT();
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final Object zzd(zzxf zzxfVar, zzzg zzzgVar, int i3) {
        return zzxfVar.zzb(zzzgVar, i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final Object zze(Object obj, zzzs zzzsVar, Object obj2, zzxf zzxfVar, zzxk zzxkVar, Object obj3, zzaak zzaakVar) throws IOException {
        Object objValueOf;
        Object objZzf;
        zzxt zzxtVar = (zzxt) obj2;
        zzaba zzabaVar = zzxtVar.zzd.zzc;
        if (zzabaVar != zzaba.zzn) {
            switch (zzabaVar.ordinal()) {
                case 0:
                    objValueOf = Double.valueOf(zzzsVar.zza());
                    break;
                case 1:
                    objValueOf = Float.valueOf(zzzsVar.zzb());
                    break;
                case 2:
                    objValueOf = Long.valueOf(zzzsVar.zzl());
                    break;
                case 3:
                    objValueOf = Long.valueOf(zzzsVar.zzo());
                    break;
                case 4:
                    objValueOf = Integer.valueOf(zzzsVar.zzg());
                    break;
                case 5:
                    objValueOf = Long.valueOf(zzzsVar.zzk());
                    break;
                case 6:
                    objValueOf = Integer.valueOf(zzzsVar.zzf());
                    break;
                case 7:
                    objValueOf = Boolean.valueOf(zzzsVar.zzP());
                    break;
                case 8:
                    objValueOf = zzzsVar.zzt();
                    break;
                case 9:
                    zzxs zzxsVar = zzxtVar.zzd;
                    if (!zzxsVar.zzd) {
                        Object objZzf2 = zzxkVar.zzf(zzxsVar);
                        if (objZzf2 instanceof zzxv) {
                            zzzt zzztVarZzb = zzzp.zza().zzb(objZzf2.getClass());
                            if (!((zzxv) objZzf2).zzaq()) {
                                Object objZze = zzztVarZzb.zze();
                                zzztVarZzb.zzg(objZze, objZzf2);
                                zzxkVar.zzk(zzxtVar.zzd, objZze);
                                objZzf2 = objZze;
                            }
                            zzzsVar.zzv(objZzf2, zzztVarZzb, zzxfVar);
                            return obj3;
                        }
                    }
                    objValueOf = zzzsVar.zzr(zzxtVar.zzc.getClass(), zzxfVar);
                    break;
                case 10:
                    zzxs zzxsVar2 = zzxtVar.zzd;
                    if (!zzxsVar2.zzd) {
                        Object objZzf3 = zzxkVar.zzf(zzxsVar2);
                        if (objZzf3 instanceof zzxv) {
                            zzzt zzztVarZzb2 = zzzp.zza().zzb(objZzf3.getClass());
                            if (!((zzxv) objZzf3).zzaq()) {
                                Object objZze2 = zzztVarZzb2.zze();
                                zzztVarZzb2.zzg(objZze2, objZzf3);
                                zzxkVar.zzk(zzxtVar.zzd, objZze2);
                                objZzf3 = objZze2;
                            }
                            zzzsVar.zzw(objZzf3, zzztVarZzb2, zzxfVar);
                            return obj3;
                        }
                    }
                    objValueOf = zzzsVar.zzs(zzxtVar.zzc.getClass(), zzxfVar);
                    break;
                case 11:
                    objValueOf = zzzsVar.zzp();
                    break;
                case 12:
                    objValueOf = Integer.valueOf(zzzsVar.zzj());
                    break;
                case 13:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 14:
                    objValueOf = Integer.valueOf(zzzsVar.zzh());
                    break;
                case 15:
                    objValueOf = Long.valueOf(zzzsVar.zzm());
                    break;
                case 16:
                    objValueOf = Integer.valueOf(zzzsVar.zzi());
                    break;
                case 17:
                    objValueOf = Long.valueOf(zzzsVar.zzn());
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        } else {
            int iZzg = zzzsVar.zzg();
            if (zzxtVar.zzd.zza.zza(iZzg) == null) {
                return zzzv.zzp(obj, zzxtVar.zzd.zzb, iZzg, obj3, zzaakVar);
            }
            objValueOf = Integer.valueOf(iZzg);
        }
        zzxs zzxsVar3 = zzxtVar.zzd;
        if (zzxsVar3.zzd) {
            zzxkVar.zzh(zzxsVar3, objValueOf);
            return obj3;
        }
        int iOrdinal = zzxsVar3.zzc.ordinal();
        if ((iOrdinal == 9 || iOrdinal == 10) && (objZzf = zzxkVar.zzf(zzxtVar.zzd)) != null) {
            byte[] bArr = zzye.zzd;
            objValueOf = ((zzzg) objZzf).zzav().zzx((zzzg) objValueOf).zzE();
        }
        zzxkVar.zzk(zzxtVar.zzd, objValueOf);
        return obj3;
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final void zzf(Object obj) {
        ((zzxr) obj).zza.zzi();
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final void zzg(zzzs zzzsVar, Object obj, zzxf zzxfVar, zzxk zzxkVar) throws IOException {
        zzxt zzxtVar = (zzxt) obj;
        zzxkVar.zzk(zzxtVar.zzd, zzzsVar.zzs(zzxtVar.zzc.getClass(), zzxfVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final void zzh(zzud zzudVar, Object obj, zzxf zzxfVar, zzxk zzxkVar) throws IOException {
        zzua zzuaVar = (zzua) zzudVar;
        byte[] bArr = zzuaVar.zza;
        zzxt zzxtVar = (zzxt) obj;
        zzzf zzzfVarZzau = zzxtVar.zzc.zzau();
        zzuj zzujVarZzH = zzuj.zzH(bArr, 0, zzuaVar.zzd(), true);
        zzzfVarZzau.zzy(zzujVarZzH, zzxfVar);
        zzxkVar.zzk(zzxtVar.zzd, zzzfVarZzau.zzE());
        zzujVarZzH.zzz(0);
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final boolean zzi(zzzg zzzgVar) {
        return zzzgVar instanceof zzxr;
    }

    @Override // com.google.android.gms.internal.gtm.zzxg
    final void zzj(zzur zzurVar, Map.Entry entry) throws IOException {
        zzxs zzxsVar = (zzxs) entry.getKey();
        if (!zzxsVar.zzd) {
            zzaba zzabaVar = zzaba.zza;
            switch (zzxsVar.zzc.ordinal()) {
                case 0:
                    zzurVar.zzf(zzxsVar.zzb, ((Double) entry.getValue()).doubleValue());
                    break;
                case 1:
                    zzurVar.zzo(zzxsVar.zzb, ((Float) entry.getValue()).floatValue());
                    break;
                case 2:
                    zzurVar.zzt(zzxsVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 3:
                    zzurVar.zzK(zzxsVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    zzurVar.zzr(zzxsVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 5:
                    zzurVar.zzm(zzxsVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 6:
                    zzurVar.zzk(zzxsVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 7:
                    zzurVar.zzb(zzxsVar.zzb, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 8:
                    zzurVar.zzG(zzxsVar.zzb, (String) entry.getValue());
                    break;
                case 9:
                    zzurVar.zzq(zzxsVar.zzb, entry.getValue(), zzzp.zza().zzb(entry.getValue().getClass()));
                    break;
                case 10:
                    zzurVar.zzv(zzxsVar.zzb, entry.getValue(), zzzp.zza().zzb(entry.getValue().getClass()));
                    break;
                case 11:
                    zzurVar.zzd(zzxsVar.zzb, (zzud) entry.getValue());
                    break;
                case 12:
                    zzurVar.zzI(zzxsVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    zzurVar.zzr(zzxsVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 14:
                    zzurVar.zzx(zzxsVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    zzurVar.zzz(zzxsVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case 16:
                    zzurVar.zzB(zzxsVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case 17:
                    zzurVar.zzD(zzxsVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzaba zzabaVar2 = zzaba.zza;
        switch (zzxsVar.zzc.ordinal()) {
            case 0:
                zzzv.zzw(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 1:
                zzzv.zzA(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 2:
                zzzv.zzD(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 3:
                zzzv.zzL(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 4:
                zzzv.zzC(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 5:
                zzzv.zzz(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 6:
                zzzv.zzy(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 7:
                zzzv.zzu(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 8:
                zzzv.zzJ(zzxsVar.zzb, (List) entry.getValue(), zzurVar);
                break;
            case 9:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzzv.zzB(zzxsVar.zzb, (List) entry.getValue(), zzurVar, zzzp.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case 10:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzzv.zzE(zzxsVar.zzb, (List) entry.getValue(), zzurVar, zzzp.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case 11:
                zzzv.zzv(zzxsVar.zzb, (List) entry.getValue(), zzurVar);
                break;
            case 12:
                zzzv.zzK(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 13:
                zzzv.zzC(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 14:
                zzzv.zzF(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 15:
                zzzv.zzG(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 16:
                zzzv.zzH(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
            case 17:
                zzzv.zzI(zzxsVar.zzb, (List) entry.getValue(), zzurVar, false);
                break;
        }
    }
}

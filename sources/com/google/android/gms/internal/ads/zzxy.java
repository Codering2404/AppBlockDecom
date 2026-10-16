package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxy implements zzxi, zzxh {
    private final zzxi[] zza;
    private final boolean[] zzb;
    private zzxh zzf;
    private zzzn zzg;
    private final ArrayList zzd = new ArrayList();
    private final HashMap zze = new HashMap();
    private zzze zzi = new zzwu(zzgwm.zzi(), zzgwm.zzi());
    private final IdentityHashMap zzc = new IdentityHashMap();
    private zzxi[] zzh = new zzxi[0];

    public zzxy(zzwv zzwvVar, long[] jArr, zzxi... zzxiVarArr) {
        this.zza = zzxiVarArr;
        this.zzb = new boolean[zzxiVarArr.length];
        for (int i3 = 0; i3 < zzxiVarArr.length; i3++) {
            long j3 = jArr[i3];
            if (j3 != 0) {
                this.zzb[i3] = true;
                this.zza[i3] = new zzzk(zzxiVarArr[i3], j3);
            }
        }
    }

    public final zzxi zza(int i3) {
        return this.zzb[i3] ? ((zzzk) this.zza[i3]).zza() : this.zza[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzxh zzxhVar, long j3) {
        this.zzf = zzxhVar;
        ArrayList arrayList = this.zzd;
        zzxi[] zzxiVarArr = this.zza;
        Collections.addAll(arrayList, zzxiVarArr);
        for (zzxi zzxiVar : zzxiVarArr) {
            zzxiVar.zzb(this, j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzc() throws IOException {
        int i3 = 0;
        while (true) {
            zzxi[] zzxiVarArr = this.zza;
            if (i3 >= zzxiVarArr.length) {
                return;
            }
            zzxiVarArr[i3].zzc();
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final zzzn zzd() {
        zzzn zzznVar = this.zzg;
        zzznVar.getClass();
        return zzznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zze(zzaba[] zzabaVarArr, boolean[] zArr, zzzc[] zzzcVarArr, boolean[] zArr2, long j3) {
        int length;
        int[] iArr;
        int length2 = zzabaVarArr.length;
        int[] iArr2 = new int[length2];
        int[] iArr3 = new int[length2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            length = zzabaVarArr.length;
            if (i4 >= length) {
                break;
            }
            zzzc zzzcVar = zzzcVarArr[i4];
            Integer num = zzzcVar == null ? null : (Integer) this.zzc.get(zzzcVar);
            iArr2[i4] = num == null ? -1 : num.intValue();
            zzaba zzabaVar = zzabaVarArr[i4];
            if (zzabaVar != null) {
                String str = zzabaVar.zza().zzb;
                iArr3[i4] = Integer.parseInt(str.substring(0, str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)));
            } else {
                iArr3[i4] = -1;
            }
            i4++;
        }
        IdentityHashMap identityHashMap = this.zzc;
        identityHashMap.clear();
        zzxi[] zzxiVarArr = this.zza;
        zzzc[] zzzcVarArr2 = new zzzc[length];
        zzzc[] zzzcVarArr3 = new zzzc[length];
        zzaba[] zzabaVarArr2 = new zzaba[length];
        ArrayList arrayList = new ArrayList(zzxiVarArr.length);
        long j4 = j3;
        int i5 = 0;
        while (i5 < zzxiVarArr.length) {
            int i6 = i3;
            while (i6 < zzabaVarArr.length) {
                zzzcVarArr3[i6] = iArr2[i6] == i5 ? zzzcVarArr[i6] : null;
                if (iArr3[i6] == i5) {
                    zzaba zzabaVar2 = zzabaVarArr[i6];
                    zzabaVar2.getClass();
                    iArr = iArr3;
                    zzbg zzbgVar = (zzbg) this.zze.get(zzabaVar2.zza());
                    zzbgVar.getClass();
                    zzabaVarArr2[i6] = new zzxx(zzabaVar2, zzbgVar);
                } else {
                    iArr = iArr3;
                    zzabaVarArr2[i6] = null;
                }
                i6++;
                iArr3 = iArr;
            }
            int[] iArr4 = iArr3;
            ArrayList arrayList2 = arrayList;
            int i7 = i5;
            long jZze = zzxiVarArr[i5].zze(zzabaVarArr2, zArr, zzzcVarArr3, zArr2, j4);
            if (i7 == 0) {
                j4 = jZze;
            } else if (jZze != j4) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i8 = 0; i8 < zzabaVarArr.length; i8++) {
                if (iArr4[i8] == i7) {
                    zzzc zzzcVar2 = zzzcVarArr3[i8];
                    zzzcVar2.getClass();
                    zzzcVarArr2[i8] = zzzcVar2;
                    identityHashMap.put(zzzcVar2, Integer.valueOf(i7));
                    z2 = true;
                } else if (iArr2[i8] == i7) {
                    zzgtj.zzi(zzzcVarArr3[i8] == null);
                }
            }
            if (z2) {
                arrayList2.add(zzxiVarArr[i7]);
            }
            i5 = i7 + 1;
            arrayList = arrayList2;
            iArr3 = iArr4;
            i3 = 0;
        }
        int i9 = i3;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzzcVarArr2, i9, zzzcVarArr, i9, length);
        this.zzh = (zzxi[]) arrayList3.toArray(new zzxi[i9]);
        this.zzi = new zzwu(arrayList3, zzgxm.zzc(arrayList3, zzxw.zza));
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzf(long j3, boolean z2) {
        for (zzxi zzxiVar : this.zzh) {
            zzxiVar.zzf(j3, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final void zzg(long j3) {
        this.zzi.zzg(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzh() {
        long j3 = -9223372036854775807L;
        for (zzxi zzxiVar : this.zzh) {
            long jZzh = zzxiVar.zzh();
            if (jZzh == -9223372036854775807L) {
                if (j3 != -9223372036854775807L && zzxiVar.zzj(j3) != j3) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j3 == -9223372036854775807L) {
                for (zzxi zzxiVar2 : this.zzh) {
                    if (zzxiVar2 == zzxiVar) {
                        break;
                    }
                    if (zzxiVar2.zzj(jZzh) != jZzh) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j3 = jZzh;
            } else if (jZzh != j3) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzi() {
        return this.zzi.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzj(long j3) {
        long jZzj = this.zzh[0].zzj(j3);
        int i3 = 1;
        while (true) {
            zzxi[] zzxiVarArr = this.zzh;
            if (i3 >= zzxiVarArr.length) {
                return jZzj;
            }
            if (zzxiVarArr[i3].zzj(jZzj) != jZzj) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final long zzk(long j3, zzni zzniVar) {
        zzxi[] zzxiVarArr = this.zzh;
        return (zzxiVarArr.length > 0 ? zzxiVarArr[0] : this.zza[0]).zzk(j3, zzniVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final long zzl() {
        return this.zzi.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzm(zzma zzmaVar) {
        ArrayList arrayList = this.zzd;
        if (arrayList.isEmpty()) {
            return this.zzi.zzm(zzmaVar);
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zzxi) arrayList.get(i3)).zzm(zzmaVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxi, com.google.android.gms.internal.ads.zzze
    public final boolean zzn() {
        return this.zzi.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        ArrayList arrayList = this.zzd;
        arrayList.remove(zzxiVar);
        if (arrayList.isEmpty()) {
            zzxi[] zzxiVarArr = this.zza;
            int i3 = 0;
            for (zzxi zzxiVar2 : zzxiVarArr) {
                i3 += zzxiVar2.zzd().zzb;
            }
            zzbg[] zzbgVarArr = new zzbg[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < zzxiVarArr.length; i5++) {
                zzzn zzznVarZzd = zzxiVarArr[i5].zzd();
                int i6 = zzznVarZzd.zzb;
                int i7 = 0;
                while (i7 < i6) {
                    zzbg zzbgVarZza = zzznVarZzd.zza(i7);
                    int i8 = zzbgVarZza.zza;
                    zzv[] zzvVarArr = new zzv[i8];
                    int i9 = 0;
                    while (i9 < i8) {
                        zzv zzvVarZza = zzbgVarZza.zza(i9);
                        zzt zztVarZza = zzvVarZza.zza();
                        String str = zzvVarZza.zza;
                        if (str == null) {
                            str = "";
                        }
                        zzxi[] zzxiVarArr2 = zzxiVarArr;
                        int i10 = i4;
                        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 1 + str.length());
                        sb.append(i5);
                        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                        sb.append(str);
                        zztVarZza.zza(sb.toString());
                        String str2 = zzvVarZza.zzn;
                        if (str2 != null) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(i5).length() + 1 + str2.length());
                            sb2.append(i5);
                            sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                            sb2.append(str2);
                            zztVarZza.zzm(sb2.toString());
                        }
                        zzvVarArr[i9] = zztVarZza.zzO();
                        i9++;
                        zzxiVarArr = zzxiVarArr2;
                        i4 = i10;
                    }
                    zzxi[] zzxiVarArr3 = zzxiVarArr;
                    int i11 = i4;
                    String str3 = zzbgVarZza.zzb;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(i5).length() + 1 + String.valueOf(str3).length());
                    sb3.append(i5);
                    sb3.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                    sb3.append(str3);
                    zzbg zzbgVar = new zzbg(sb3.toString(), zzvVarArr);
                    this.zze.put(zzbgVar, zzbgVarZza);
                    i4 = i11 + 1;
                    zzbgVarArr[i11] = zzbgVar;
                    i7++;
                    zzxiVarArr = zzxiVarArr3;
                }
            }
            this.zzg = new zzzn(zzbgVarArr);
            zzxh zzxhVar = this.zzf;
            zzxhVar.getClass();
            zzxhVar.zzp(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        zzxh zzxhVar = this.zzf;
        zzxhVar.getClass();
        zzxhVar.zzs(this);
    }
}

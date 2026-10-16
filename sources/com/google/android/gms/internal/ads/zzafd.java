package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafd {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final float zzk;
    public final String zzl;

    private zzafd(List list, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f3, String str) {
        this.zza = list;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = i10;
        this.zzj = i11;
        this.zzk = f3;
        this.zzl = str;
    }

    public static zzafd zza(zzet zzetVar) throws zzat {
        String strZzb;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f3;
        int i9;
        int i10;
        try {
            zzetVar.zzk(4);
            int iZzs = (zzetVar.zzs() & 3) + 1;
            if (iZzs == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzs2 = zzetVar.zzs() & 31;
            for (int i11 = 0; i11 < iZzs2; i11++) {
                arrayList.add(zzb(zzetVar));
            }
            int iZzs3 = zzetVar.zzs();
            for (int i12 = 0; i12 < iZzs3; i12++) {
                arrayList.add(zzb(zzetVar));
            }
            if (iZzs2 > 0) {
                byte[] bArr = (byte[]) arrayList.get(0);
                byte[] bArr2 = (byte[]) arrayList.get(0);
                byte[] bArr3 = zzgp.zza;
                zzgo zzgoVarZze = zzgp.zze(bArr2, 5, bArr.length);
                int i13 = zzgoVarZze.zze;
                int i14 = zzgoVarZze.zzf;
                int i15 = zzgoVarZze.zzh + 8;
                int i16 = zzgoVarZze.zzi + 8;
                int i17 = zzgoVarZze.zzj;
                int i18 = zzgoVarZze.zzk;
                int i19 = zzgoVarZze.zzl;
                int i20 = zzgoVarZze.zzm;
                float f4 = zzgoVarZze.zzg;
                strZzb = zzdq.zzb(zzgoVarZze.zza, zzgoVarZze.zzb, zzgoVarZze.zzc);
                i7 = i19;
                i8 = i20;
                f3 = f4;
                i6 = i16;
                i9 = i17;
                i10 = i18;
                i3 = i13;
                i4 = i14;
                i5 = i15;
            } else {
                strZzb = null;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = -1;
                i8 = 16;
                f3 = 1.0f;
                i9 = -1;
                i10 = -1;
            }
            return new zzafd(arrayList, iZzs, i3, i4, i5, i6, i9, i10, i7, i8, f3, strZzb);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw zzat.zzb("Error parsing AVC config", e3);
        }
    }

    private static byte[] zzb(zzet zzetVar) {
        int iZzt = zzetVar.zzt();
        int iZzg = zzetVar.zzg();
        zzetVar.zzk(iZzt);
        return zzdq.zzh(zzetVar.zzi(), iZzg, iZzt);
    }
}

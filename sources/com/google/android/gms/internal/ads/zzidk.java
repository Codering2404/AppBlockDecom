package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidk implements zzihi {
    private final zzidj zza;

    private zzidk(zzidj zzidjVar) {
        zzidjVar.getClass();
        this.zza = zzidjVar;
        zzidjVar.zza = this;
    }

    public static zzidk zza(zzidj zzidjVar) {
        Object obj = zzidjVar.zza;
        return obj != null ? (zzidk) obj : new zzidk(zzidjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzA(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzifd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzu(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z2) {
            while (i4 < zzifdVar.size()) {
                this.zza.zzg(i3, zzifdVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzifdVar.size(); i8++) {
            zzifdVar.zzc(i8);
            i7 += 8;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zzifdVar.size()) {
            zzidjVar2.zzu(zzifdVar.zzc(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzB(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzidv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zze(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzs(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        zzidv zzidvVar = (zzidv) list;
        if (!z2) {
            while (i4 < zzidvVar.size()) {
                this.zza.zze(i3, Float.floatToRawIntBits(zzidvVar.zzf(i4)));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzidvVar.size(); i8++) {
            zzidvVar.zzf(i8);
            i7 += 4;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zzidvVar.size()) {
            zzidjVar2.zzs(Float.floatToRawIntBits(zzidvVar.zzf(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzC(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzidl)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        zzidl zzidlVar = (zzidl) list;
        if (!z2) {
            while (i4 < zzidlVar.size()) {
                this.zza.zzg(i3, Double.doubleToRawLongBits(zzidlVar.zzf(i4)));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzidlVar.size(); i8++) {
            zzidlVar.zzf(i8);
            i7 += 8;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zzidlVar.size()) {
            zzidjVar2.zzu(Double.doubleToRawLongBits(zzidlVar.zzf(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzD(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzief)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzc(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int iZzG = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzG += zzidj.zzG(((Integer) list.get(i5)).intValue());
            }
            zzidjVar.zzr(iZzG);
            while (i4 < list.size()) {
                zzidjVar.zzq(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z2) {
            while (i4 < zziefVar.size()) {
                this.zza.zzc(i3, zziefVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int iZzG2 = 0;
        for (int i6 = 0; i6 < zziefVar.size(); i6++) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i6));
        }
        zzidjVar2.zzr(iZzG2);
        while (i4 < zziefVar.size()) {
            zzidjVar2.zzq(zziefVar.zzf(i4));
            i4++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzE(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzicq)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, ((Boolean) list.get(i4)).booleanValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzp(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
                i4++;
            }
            return;
        }
        zzicq zzicqVar = (zzicq) list;
        if (!z2) {
            while (i4 < zzicqVar.size()) {
                this.zza.zzh(i3, zzicqVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzicqVar.size(); i8++) {
            zzicqVar.zzf(i8);
            i7++;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zzicqVar.size()) {
            zzidjVar2.zzp(zzicqVar.zzf(i4) ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzF(int i3, List list) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzifa)) {
            while (i4 < list.size()) {
                this.zza.zzi(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzifa zzifaVar = (zzifa) list;
        while (i4 < list.size()) {
            Object objZzc = zzifaVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzi(i3, (String) objZzc);
            } else {
                this.zza.zzj(i3, (zzida) objZzc);
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzG(int i3, List list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zzj(i3, (zzida) list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzH(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzief)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzd(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int iZzF = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzF += zzidj.zzF(((Integer) list.get(i5)).intValue());
            }
            zzidjVar.zzr(iZzF);
            while (i4 < list.size()) {
                zzidjVar.zzr(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z2) {
            while (i4 < zziefVar.size()) {
                this.zza.zzd(i3, zziefVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int iZzF2 = 0;
        for (int i6 = 0; i6 < zziefVar.size(); i6++) {
            iZzF2 += zzidj.zzF(zziefVar.zzf(i6));
        }
        zzidjVar2.zzr(iZzF2);
        while (i4 < zziefVar.size()) {
            zzidjVar2.zzr(zziefVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzI(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzief)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zze(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzs(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z2) {
            while (i4 < zziefVar.size()) {
                this.zza.zze(i3, zziefVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zziefVar.size(); i8++) {
            zziefVar.zzf(i8);
            i7 += 4;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zziefVar.size()) {
            zzidjVar2.zzs(zziefVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzJ(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzifd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzu(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z2) {
            while (i4 < zzifdVar.size()) {
                this.zza.zzg(i3, zzifdVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzifdVar.size(); i8++) {
            zzifdVar.zzc(i8);
            i7 += 8;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zzifdVar.size()) {
            zzidjVar2.zzu(zzifdVar.zzc(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzK(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzief)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzidj zzidjVar = this.zza;
                    int iIntValue = ((Integer) list.get(i4)).intValue();
                    zzidjVar.zzd(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i4++;
                }
                return;
            }
            zzidj zzidjVar2 = this.zza;
            zzidjVar2.zzb(i3, 2);
            int iZzF = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int iIntValue2 = ((Integer) list.get(i5)).intValue();
                iZzF += zzidj.zzF((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzidjVar2.zzr(iZzF);
            while (i4 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i4)).intValue();
                zzidjVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i4++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z2) {
            while (i4 < zziefVar.size()) {
                zzidj zzidjVar3 = this.zza;
                int iZzf = zziefVar.zzf(i4);
                zzidjVar3.zzd(i3, (iZzf >> 31) ^ (iZzf + iZzf));
                i4++;
            }
            return;
        }
        zzidj zzidjVar4 = this.zza;
        zzidjVar4.zzb(i3, 2);
        int iZzF2 = 0;
        for (int i6 = 0; i6 < zziefVar.size(); i6++) {
            int iZzf2 = zziefVar.zzf(i6);
            iZzF2 += zzidj.zzF((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzidjVar4.zzr(iZzF2);
        while (i4 < zziefVar.size()) {
            int iZzf3 = zziefVar.zzf(i4);
            zzidjVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzL(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzifd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzidj zzidjVar = this.zza;
                    long jLongValue = ((Long) list.get(i4)).longValue();
                    zzidjVar.zzf(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i4++;
                }
                return;
            }
            zzidj zzidjVar2 = this.zza;
            zzidjVar2.zzb(i3, 2);
            int iZzG = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long jLongValue2 = ((Long) list.get(i5)).longValue();
                iZzG += zzidj.zzG((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzidjVar2.zzr(iZzG);
            while (i4 < list.size()) {
                long jLongValue3 = ((Long) list.get(i4)).longValue();
                zzidjVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i4++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z2) {
            while (i4 < zzifdVar.size()) {
                zzidj zzidjVar3 = this.zza;
                long jZzc = zzifdVar.zzc(i4);
                zzidjVar3.zzf(i3, (jZzc >> 63) ^ (jZzc + jZzc));
                i4++;
            }
            return;
        }
        zzidj zzidjVar4 = this.zza;
        zzidjVar4.zzb(i3, 2);
        int iZzG2 = 0;
        for (int i6 = 0; i6 < zzifdVar.size(); i6++) {
            long jZzc2 = zzifdVar.zzc(i6);
            iZzG2 += zzidj.zzG((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzidjVar4.zzr(iZzG2);
        while (i4 < zzifdVar.size()) {
            long jZzc3 = zzifdVar.zzc(i4);
            zzidjVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzM(int i3, zzifh zzifhVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            zzidjVar.zzr(zzifi.zzc(zzifhVar, entry.getKey(), entry.getValue()));
            zzifi.zzb(zzidjVar, zzifhVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzb(int i3, int i4) throws IOException {
        this.zza.zze(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzc(int i3, long j3) throws IOException {
        this.zza.zzf(i3, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzd(int i3, long j3) throws IOException {
        this.zza.zzg(i3, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zze(int i3, float f3) throws IOException {
        this.zza.zze(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzf(int i3, double d3) throws IOException {
        this.zza.zzg(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzg(int i3, int i4) throws IOException {
        this.zza.zzc(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzh(int i3, long j3) throws IOException {
        this.zza.zzf(i3, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzi(int i3, int i4) throws IOException {
        this.zza.zzc(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzj(int i3, long j3) throws IOException {
        this.zza.zzg(i3, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzk(int i3, int i4) throws IOException {
        this.zza.zze(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzl(int i3, boolean z2) throws IOException {
        this.zza.zzh(i3, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzm(int i3, String str) throws IOException {
        this.zza.zzi(i3, str);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzn(int i3, zzida zzidaVar) throws IOException {
        this.zza.zzj(i3, zzidaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzo(int i3, int i4) throws IOException {
        this.zza.zzd(i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzp(int i3, int i4) throws IOException {
        this.zza.zzd(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzq(int i3, long j3) throws IOException {
        this.zza.zzf(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzr(int i3, Object obj, zzigh zzighVar) throws IOException {
        zzidj zzidjVar = this.zza;
        zzicj zzicjVar = (zzicj) obj;
        zzidjVar.zzb(i3, 2);
        zzidjVar.zzr(zzicjVar.zzaT(zzighVar));
        zzighVar.zzf(zzicjVar, this);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzs(int i3, Object obj, zzigh zzighVar) throws IOException {
        zzidj zzidjVar = this.zza;
        zzidjVar.zzb(i3, 3);
        zzighVar.zzf((zzicj) obj, this);
        zzidjVar.zzb(i3, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    @Deprecated
    public final void zzt(int i3) throws IOException {
        this.zza.zzb(i3, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    @Deprecated
    public final void zzu(int i3) throws IOException {
        this.zza.zzb(i3, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzv(int i3, Object obj) throws IOException {
        if (obj instanceof zzida) {
            this.zza.zzn(i3, (zzida) obj);
        } else {
            this.zza.zzm(i3, (zzifp) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzw(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzief)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzc(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int iZzG = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzG += zzidj.zzG(((Integer) list.get(i5)).intValue());
            }
            zzidjVar.zzr(iZzG);
            while (i4 < list.size()) {
                zzidjVar.zzq(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z2) {
            while (i4 < zziefVar.size()) {
                this.zza.zzc(i3, zziefVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int iZzG2 = 0;
        for (int i6 = 0; i6 < zziefVar.size(); i6++) {
            iZzG2 += zzidj.zzG(zziefVar.zzf(i6));
        }
        zzidjVar2.zzr(iZzG2);
        while (i4 < zziefVar.size()) {
            zzidjVar2.zzq(zziefVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzx(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzief)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zze(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzidjVar.zzr(i5);
            while (i4 < list.size()) {
                zzidjVar.zzs(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzief zziefVar = (zzief) list;
        if (!z2) {
            while (i4 < zziefVar.size()) {
                this.zza.zze(i3, zziefVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zziefVar.size(); i8++) {
            zziefVar.zzf(i8);
            i7 += 4;
        }
        zzidjVar2.zzr(i7);
        while (i4 < zziefVar.size()) {
            zzidjVar2.zzs(zziefVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzy(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzifd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int iZzG = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzG += zzidj.zzG(((Long) list.get(i5)).longValue());
            }
            zzidjVar.zzr(iZzG);
            while (i4 < list.size()) {
                zzidjVar.zzt(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z2) {
            while (i4 < zzifdVar.size()) {
                this.zza.zzf(i3, zzifdVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int iZzG2 = 0;
        for (int i6 = 0; i6 < zzifdVar.size(); i6++) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i6));
        }
        zzidjVar2.zzr(iZzG2);
        while (i4 < zzifdVar.size()) {
            zzidjVar2.zzt(zzifdVar.zzc(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzihi
    public final void zzz(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzifd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzidj zzidjVar = this.zza;
            zzidjVar.zzb(i3, 2);
            int iZzG = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzG += zzidj.zzG(((Long) list.get(i5)).longValue());
            }
            zzidjVar.zzr(iZzG);
            while (i4 < list.size()) {
                zzidjVar.zzt(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzifd zzifdVar = (zzifd) list;
        if (!z2) {
            while (i4 < zzifdVar.size()) {
                this.zza.zzf(i3, zzifdVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzidj zzidjVar2 = this.zza;
        zzidjVar2.zzb(i3, 2);
        int iZzG2 = 0;
        for (int i6 = 0; i6 < zzifdVar.size(); i6++) {
            iZzG2 += zzidj.zzG(zzifdVar.zzc(i6));
        }
        zzidjVar2.zzr(iZzG2);
        while (i4 < zzifdVar.size()) {
            zzidjVar2.zzt(zzifdVar.zzc(i4));
            i4++;
        }
    }
}

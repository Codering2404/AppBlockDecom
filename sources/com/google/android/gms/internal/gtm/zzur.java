package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzur {
    private final zzuq zza;

    private zzur(zzuq zzuqVar) {
        byte[] bArr = zzye.zzd;
        this.zza = zzuqVar;
        zzuqVar.zze = this;
    }

    public static zzur zza(zzuq zzuqVar) {
        zzur zzurVar = zzuqVar.zze;
        return zzurVar != null ? zzurVar : new zzur(zzuqVar);
    }

    public final void zzA(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzj(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Long) list.get(i6)).getClass();
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzk(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    public final void zzB(int i3, int i4) throws IOException {
        this.zza.zzt(i3, (i4 >> 31) ^ (i4 + i4));
    }

    public final void zzC(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                zzuq zzuqVar = this.zza;
                int iIntValue = ((Integer) list.get(i4)).intValue();
                zzuqVar.zzt(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzD = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            int iIntValue2 = ((Integer) list.get(i5)).intValue();
            iZzD += zzuq.zzD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzu(iZzD);
        while (i4 < list.size()) {
            zzuq zzuqVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i4)).intValue();
            zzuqVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i4++;
        }
    }

    public final void zzD(int i3, long j3) throws IOException {
        this.zza.zzv(i3, (j3 >> 63) ^ (j3 + j3));
    }

    public final void zzE(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                zzuq zzuqVar = this.zza;
                long jLongValue = ((Long) list.get(i4)).longValue();
                zzuqVar.zzv(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzE = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            long jLongValue2 = ((Long) list.get(i5)).longValue();
            iZzE += zzuq.zzE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzu(iZzE);
        while (i4 < list.size()) {
            zzuq zzuqVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i4)).longValue();
            zzuqVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i4++;
        }
    }

    @Deprecated
    public final void zzF(int i3) throws IOException {
        this.zza.zzs(i3, 3);
    }

    public final void zzG(int i3, String str) throws IOException {
        this.zza.zzq(i3, str);
    }

    public final void zzH(int i3, List list) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzyo)) {
            while (i4 < list.size()) {
                this.zza.zzq(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzyo zzyoVar = (zzyo) list;
        while (i4 < list.size()) {
            Object objZzf = zzyoVar.zzf(i4);
            if (objZzf instanceof String) {
                this.zza.zzq(i3, (String) objZzf);
            } else {
                this.zza.zzM(i3, (zzud) objZzf);
            }
            i4++;
        }
    }

    public final void zzI(int i3, int i4) throws IOException {
        this.zza.zzt(i3, i4);
    }

    public final void zzJ(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzt(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzD = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iZzD += zzuq.zzD(((Integer) list.get(i5)).intValue());
        }
        this.zza.zzu(iZzD);
        while (i4 < list.size()) {
            this.zza.zzu(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    public final void zzK(int i3, long j3) throws IOException {
        this.zza.zzv(i3, j3);
    }

    public final void zzL(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzv(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzE = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iZzE += zzuq.zzE(((Long) list.get(i5)).longValue());
        }
        this.zza.zzu(iZzE);
        while (i4 < list.size()) {
            this.zza.zzw(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    public final void zzb(int i3, boolean z2) throws IOException {
        this.zza.zzL(i3, z2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzc(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzL(i3, ((Boolean) list.get(i4)).booleanValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Boolean) list.get(i6)).getClass();
            i5++;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzK(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    public final void zzd(int i3, zzud zzudVar) throws IOException {
        this.zza.zzM(i3, zzudVar);
    }

    public final void zze(int i3, List list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zzM(i3, (zzud) list.get(i4));
        }
    }

    public final void zzf(int i3, double d3) throws IOException {
        this.zza.zzj(i3, Double.doubleToRawLongBits(d3));
    }

    public final void zzg(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzj(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Double) list.get(i6)).getClass();
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
            i4++;
        }
    }

    @Deprecated
    public final void zzh(int i3) throws IOException {
        this.zza.zzs(i3, 4);
    }

    public final void zzi(int i3, int i4) throws IOException {
        this.zza.zzl(i3, i4);
    }

    public final void zzj(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzl(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzz = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iZzz += zzuq.zzz(((Integer) list.get(i5)).intValue());
        }
        this.zza.zzu(iZzz);
        while (i4 < list.size()) {
            this.zza.zzm(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    public final void zzk(int i3, int i4) throws IOException {
        this.zza.zzh(i3, i4);
    }

    public final void zzl(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Integer) list.get(i6)).getClass();
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzi(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    public final void zzm(int i3, long j3) throws IOException {
        this.zza.zzj(i3, j3);
    }

    public final void zzn(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzj(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Long) list.get(i6)).getClass();
            i5 += 8;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzk(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    public final void zzo(int i3, float f3) throws IOException {
        this.zza.zzh(i3, Float.floatToRawIntBits(f3));
    }

    public final void zzp(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Float) list.get(i6)).getClass();
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
            i4++;
        }
    }

    public final void zzq(int i3, Object obj, zzzt zzztVar) throws IOException {
        zzuq zzuqVar = this.zza;
        zzuqVar.zzs(i3, 3);
        zzztVar.zzm((zzzg) obj, zzuqVar.zze);
        zzuqVar.zzs(i3, 4);
    }

    public final void zzr(int i3, int i4) throws IOException {
        this.zza.zzl(i3, i4);
    }

    public final void zzs(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzl(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzz = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iZzz += zzuq.zzz(((Integer) list.get(i5)).intValue());
        }
        this.zza.zzu(iZzz);
        while (i4 < list.size()) {
            this.zza.zzm(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    public final void zzt(int i3, long j3) throws IOException {
        this.zza.zzv(i3, j3);
    }

    public final void zzu(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzv(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int iZzE = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iZzE += zzuq.zzE(((Long) list.get(i5)).longValue());
        }
        this.zza.zzu(iZzE);
        while (i4 < list.size()) {
            this.zza.zzw(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    public final void zzv(int i3, Object obj, zzzt zzztVar) throws IOException {
        this.zza.zzn(i3, (zzzg) obj, zzztVar);
    }

    public final void zzw(int i3, Object obj) throws IOException {
        if (obj instanceof zzud) {
            this.zza.zzp(i3, (zzud) obj);
        } else {
            this.zza.zzo(i3, (zzzg) obj);
        }
    }

    public final void zzx(int i3, int i4) throws IOException {
        this.zza.zzh(i3, i4);
    }

    public final void zzy(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzs(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Integer) list.get(i6)).getClass();
            i5 += 4;
        }
        this.zza.zzu(i5);
        while (i4 < list.size()) {
            this.zza.zzi(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    public final void zzz(int i3, long j3) throws IOException {
        this.zza.zzj(i3, j3);
    }
}

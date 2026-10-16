package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzln implements zzov {
    private final zzlm zza;

    private zzln(zzlm zzlmVar) {
        byte[] bArr = zzmp.zzb;
        this.zza = zzlmVar;
        zzlmVar.zza = this;
    }

    public static zzln zza(zzlm zzlmVar) {
        zzln zzlnVar = zzlmVar.zza;
        return zzlnVar != null ? zzlnVar : new zzln(zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzA(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i4 < zznaVar.size()) {
                this.zza.zzf(i3, zznaVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zznaVar.size(); i8++) {
            zznaVar.zzc(i8);
            i7 += 8;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzB(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzly)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzd(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzs(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        zzly zzlyVar = (zzly) list;
        if (!z2) {
            while (i4 < zzlyVar.size()) {
                this.zza.zzd(i3, Float.floatToRawIntBits(zzlyVar.zze(i4)));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzlyVar.size(); i8++) {
            zzlyVar.zze(i8);
            i7 += 4;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zzlyVar.size()) {
            zzlmVar2.zzs(Float.floatToRawIntBits(zzlyVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzC(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzlo)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        zzlo zzloVar = (zzlo) list;
        if (!z2) {
            while (i4 < zzloVar.size()) {
                this.zza.zzf(i3, Double.doubleToRawLongBits(zzloVar.zze(i4)));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzloVar.size(); i8++) {
            zzloVar.zze(i8);
            i7 += 8;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zzloVar.size()) {
            zzlmVar2.zzu(Double.doubleToRawLongBits(zzloVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzD(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzb(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzA += zzlm.zzA(((Integer) list.get(i5)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i4 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i4 < zzmgVar.size()) {
                this.zza.zzb(i3, zzmgVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zzmgVar.size(); i6++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i6));
        }
        zzlmVar2.zzr(iZzA2);
        while (i4 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i4));
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
    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzE(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzky)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, ((Boolean) list.get(i4)).booleanValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzp(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
                i4++;
            }
            return;
        }
        zzky zzkyVar = (zzky) list;
        if (!z2) {
            while (i4 < zzkyVar.size()) {
                this.zza.zzg(i3, zzkyVar.zze(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzkyVar.size(); i8++) {
            zzkyVar.zze(i8);
            i7++;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zzkyVar.size()) {
            zzlmVar2.zzp(zzkyVar.zze(i4) ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzF(int i3, List list) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmx)) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzmx zzmxVar = (zzmx) list;
        while (i4 < list.size()) {
            Object objZzc = zzmxVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzh(i3, (String) objZzc);
            } else {
                this.zza.zzi(i3, (zzlh) objZzc);
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzG(int i3, List list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zzi(i3, (zzlh) list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzH(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzc(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzz += zzlm.zzz(((Integer) list.get(i5)).intValue());
            }
            zzlmVar.zzr(iZzz);
            while (i4 < list.size()) {
                zzlmVar.zzr(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i4 < zzmgVar.size()) {
                this.zza.zzc(i3, zzmgVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzmgVar.size(); i6++) {
            iZzz2 += zzlm.zzz(zzmgVar.zzf(i6));
        }
        zzlmVar2.zzr(iZzz2);
        while (i4 < zzmgVar.size()) {
            zzlmVar2.zzr(zzmgVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzI(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzd(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i4 < zzmgVar.size()) {
                this.zza.zzd(i3, zzmgVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzmgVar.size(); i8++) {
            zzmgVar.zzf(i8);
            i7 += 4;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzJ(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i4 < zznaVar.size()) {
                this.zza.zzf(i3, zznaVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zznaVar.size(); i8++) {
            zznaVar.zzc(i8);
            i7 += 8;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzK(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    int iIntValue = ((Integer) list.get(i4)).intValue();
                    zzlmVar.zzc(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i4++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int iIntValue2 = ((Integer) list.get(i5)).intValue();
                iZzz += zzlm.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzlmVar2.zzr(iZzz);
            while (i4 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i4)).intValue();
                zzlmVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i4++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i4 < zzmgVar.size()) {
                zzlm zzlmVar3 = this.zza;
                int iZzf = zzmgVar.zzf(i4);
                zzlmVar3.zzc(i3, (iZzf >> 31) ^ (iZzf + iZzf));
                i4++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzmgVar.size(); i6++) {
            int iZzf2 = zzmgVar.zzf(i6);
            iZzz2 += zzlm.zzz((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzlmVar4.zzr(iZzz2);
        while (i4 < zzmgVar.size()) {
            int iZzf3 = zzmgVar.zzf(i4);
            zzlmVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzL(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    long jLongValue = ((Long) list.get(i4)).longValue();
                    zzlmVar.zze(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i4++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long jLongValue2 = ((Long) list.get(i5)).longValue();
                iZzA += zzlm.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzlmVar2.zzr(iZzA);
            while (i4 < list.size()) {
                long jLongValue3 = ((Long) list.get(i4)).longValue();
                zzlmVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i4++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i4 < zznaVar.size()) {
                zzlm zzlmVar3 = this.zza;
                long jZzc = zznaVar.zzc(i4);
                zzlmVar3.zze(i3, (jZzc >> 63) ^ (jZzc + jZzc));
                i4++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zznaVar.size(); i6++) {
            long jZzc2 = zznaVar.zzc(i6);
            iZzA2 += zzlm.zzA((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzlmVar4.zzr(iZzA2);
        while (i4 < zznaVar.size()) {
            long jZzc3 = zznaVar.zzc(i4);
            zzlmVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzM(int i3, zzne zzneVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            zzlmVar.zzr(zznf.zzc(zzneVar, entry.getKey(), entry.getValue()));
            zznf.zzb(zzlmVar, zzneVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzb(int i3, int i4) throws IOException {
        this.zza.zzd(i3, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzc(int i3, long j3) throws IOException {
        this.zza.zze(i3, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzd(int i3, long j3) throws IOException {
        this.zza.zzf(i3, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zze(int i3, float f3) throws IOException {
        this.zza.zzd(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzf(int i3, double d3) throws IOException {
        this.zza.zzf(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzg(int i3, int i4) throws IOException {
        this.zza.zzb(i3, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzh(int i3, long j3) throws IOException {
        this.zza.zze(i3, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzi(int i3, int i4) throws IOException {
        this.zza.zzb(i3, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzj(int i3, long j3) throws IOException {
        this.zza.zzf(i3, j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzk(int i3, int i4) throws IOException {
        this.zza.zzd(i3, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzl(int i3, boolean z2) throws IOException {
        this.zza.zzg(i3, z2);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzm(int i3, String str) throws IOException {
        this.zza.zzh(i3, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzn(int i3, zzlh zzlhVar) throws IOException {
        this.zza.zzi(i3, zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzo(int i3, int i4) throws IOException {
        this.zza.zzc(i3, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzp(int i3, int i4) throws IOException {
        this.zza.zzc(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzq(int i3, long j3) throws IOException {
        this.zza.zze(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzr(int i3, Object obj, zznx zznxVar) throws IOException {
        this.zza.zzl(i3, (zznm) obj, zznxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzs(int i3, Object obj, zznx zznxVar) throws IOException {
        zzlm zzlmVar = this.zza;
        zzlmVar.zza(i3, 3);
        zznxVar.zzf((zznm) obj, zzlmVar.zza);
        zzlmVar.zza(i3, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzt(int i3) throws IOException {
        this.zza.zza(i3, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzu(int i3) throws IOException {
        this.zza.zza(i3, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzv(int i3, Object obj) throws IOException {
        if (obj instanceof zzlh) {
            this.zza.zzn(i3, (zzlh) obj);
        } else {
            this.zza.zzm(i3, (zznm) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzw(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzb(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzA += zzlm.zzA(((Integer) list.get(i5)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i4 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i4 < zzmgVar.size()) {
                this.zza.zzb(i3, zzmgVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zzmgVar.size(); i6++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i6));
        }
        zzlmVar2.zzr(iZzA2);
        while (i4 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzx(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzd(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzlmVar.zzr(i5);
            while (i4 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i4 < zzmgVar.size()) {
                this.zza.zzd(i3, zzmgVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzmgVar.size(); i8++) {
            zzmgVar.zzf(i8);
            i7 += 4;
        }
        zzlmVar2.zzr(i7);
        while (i4 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzy(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zze(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzA += zzlm.zzA(((Long) list.get(i5)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i4 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i4 < zznaVar.size()) {
                this.zza.zze(i3, zznaVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zznaVar.size(); i6++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i6));
        }
        zzlmVar2.zzr(iZzA2);
        while (i4 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzz(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zze(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzA += zzlm.zzA(((Long) list.get(i5)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i4 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i4 < zznaVar.size()) {
                this.zza.zze(i3, zznaVar.zzc(i4));
                i4++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zznaVar.size(); i6++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i6));
        }
        zzlmVar2.zzr(iZzA2);
        while (i4 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i4));
            i4++;
        }
    }
}

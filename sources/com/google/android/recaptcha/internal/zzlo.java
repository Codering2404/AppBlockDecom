package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzlo implements zzpy {
    private final zzln zza;

    private zzlo(zzln zzlnVar) {
        byte[] bArr = zznl.zzb;
        this.zza = zzlnVar;
        zzlnVar.zza = this;
    }

    public static zzlo zza(zzln zzlnVar) {
        zzlo zzloVar = zzlnVar.zza;
        return zzloVar != null ? zzloVar : new zzlo(zzlnVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzA(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zznx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzi(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z2) {
            while (i4 < zznxVar.size()) {
                this.zza.zzh(i3, zznxVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zznxVar.size(); i8++) {
            zznxVar.zze(i8);
            i7 += 8;
        }
        this.zza.zzt(i7);
        while (i4 < zznxVar.size()) {
            this.zza.zzi(zznxVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzB(int i3, int i4) throws IOException {
        this.zza.zzs(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzC(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzne)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzln zzlnVar = this.zza;
                    int iIntValue = ((Integer) list.get(i4)).intValue();
                    zzlnVar.zzs(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int iIntValue2 = ((Integer) list.get(i5)).intValue();
                iZzA += zzln.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzA);
            while (i4 < list.size()) {
                zzln zzlnVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i4)).intValue();
                zzlnVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i4++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z2) {
            while (i4 < zzneVar.size()) {
                zzln zzlnVar3 = this.zza;
                int iZze = zzneVar.zze(i4);
                zzlnVar3.zzs(i3, (iZze >> 31) ^ (iZze + iZze));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zzneVar.size(); i6++) {
            int iZze2 = zzneVar.zze(i6);
            iZzA2 += zzln.zzA((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzA2);
        while (i4 < zzneVar.size()) {
            zzln zzlnVar4 = this.zza;
            int iZze3 = zzneVar.zze(i4);
            zzlnVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzD(int i3, long j3) throws IOException {
        this.zza.zzu(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzE(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zznx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzln zzlnVar = this.zza;
                    long jLongValue = ((Long) list.get(i4)).longValue();
                    zzlnVar.zzu(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long jLongValue2 = ((Long) list.get(i5)).longValue();
                iZzB += zzln.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzB);
            while (i4 < list.size()) {
                zzln zzlnVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i4)).longValue();
                zzlnVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i4++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z2) {
            while (i4 < zznxVar.size()) {
                zzln zzlnVar3 = this.zza;
                long jZze = zznxVar.zze(i4);
                zzlnVar3.zzu(i3, (jZze >> 63) ^ (jZze + jZze));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzB2 = 0;
        for (int i6 = 0; i6 < zznxVar.size(); i6++) {
            long jZze2 = zznxVar.zze(i6);
            iZzB2 += zzln.zzB((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzB2);
        while (i4 < zznxVar.size()) {
            zzln zzlnVar4 = this.zza;
            long jZze3 = zznxVar.zze(i4);
            zzlnVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    @Deprecated
    public final void zzF(int i3) throws IOException {
        this.zza.zzr(i3, 3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzG(int i3, String str) throws IOException {
        this.zza.zzp(i3, str);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzH(int i3, List list) throws IOException {
        int i4 = 0;
        if (!(list instanceof zznu)) {
            while (i4 < list.size()) {
                this.zza.zzp(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zznu zznuVar = (zznu) list;
        while (i4 < list.size()) {
            Object objZzc = zznuVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzp(i3, (String) objZzc);
            } else {
                this.zza.zze(i3, (zzle) objZzc);
            }
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzI(int i3, int i4) throws IOException {
        this.zza.zzs(i3, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzJ(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzne)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzs(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzA = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzA += zzln.zzA(((Integer) list.get(i5)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i4 < list.size()) {
                this.zza.zzt(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z2) {
            while (i4 < zzneVar.size()) {
                this.zza.zzs(i3, zzneVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzA2 = 0;
        for (int i6 = 0; i6 < zzneVar.size(); i6++) {
            iZzA2 += zzln.zzA(zzneVar.zze(i6));
        }
        this.zza.zzt(iZzA2);
        while (i4 < zzneVar.size()) {
            this.zza.zzt(zzneVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzK(int i3, long j3) throws IOException {
        this.zza.zzu(i3, j3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzL(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zznx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzu(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzB += zzln.zzB(((Long) list.get(i5)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i4 < list.size()) {
                this.zza.zzv(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z2) {
            while (i4 < zznxVar.size()) {
                this.zza.zzu(i3, zznxVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzB2 = 0;
        for (int i6 = 0; i6 < zznxVar.size(); i6++) {
            iZzB2 += zzln.zzB(zznxVar.zze(i6));
        }
        this.zza.zzt(iZzB2);
        while (i4 < zznxVar.size()) {
            this.zza.zzv(zznxVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzb(int i3, boolean z2) throws IOException {
        this.zza.zzd(i3, z2);
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
    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzc(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzkv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzd(i3, ((Boolean) list.get(i4)).booleanValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
                i4++;
            }
            return;
        }
        zzkv zzkvVar = (zzkv) list;
        if (!z2) {
            while (i4 < zzkvVar.size()) {
                this.zza.zzd(i3, zzkvVar.zzf(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzkvVar.size(); i8++) {
            zzkvVar.zzf(i8);
            i7++;
        }
        this.zza.zzt(i7);
        while (i4 < zzkvVar.size()) {
            this.zza.zzb(zzkvVar.zzf(i4) ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzd(int i3, zzle zzleVar) throws IOException {
        this.zza.zze(i3, zzleVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zze(int i3, List list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zze(i3, (zzle) list.get(i4));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzf(int i3, double d3) throws IOException {
        this.zza.zzh(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzg(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmi)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        zzmi zzmiVar = (zzmi) list;
        if (!z2) {
            while (i4 < zzmiVar.size()) {
                this.zza.zzh(i3, Double.doubleToRawLongBits(zzmiVar.zze(i4)));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzmiVar.size(); i8++) {
            zzmiVar.zze(i8);
            i7 += 8;
        }
        this.zza.zzt(i7);
        while (i4 < zzmiVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzmiVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    @Deprecated
    public final void zzh(int i3) throws IOException {
        this.zza.zzr(i3, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzi(int i3, int i4) throws IOException {
        this.zza.zzj(i3, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzj(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzne)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzB += zzln.zzB(((Integer) list.get(i5)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i4 < list.size()) {
                this.zza.zzk(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z2) {
            while (i4 < zzneVar.size()) {
                this.zza.zzj(i3, zzneVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzB2 = 0;
        for (int i6 = 0; i6 < zzneVar.size(); i6++) {
            iZzB2 += zzln.zzB(zzneVar.zze(i6));
        }
        this.zza.zzt(iZzB2);
        while (i4 < zzneVar.size()) {
            this.zza.zzk(zzneVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzk(int i3, int i4) throws IOException {
        this.zza.zzf(i3, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzl(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzne)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzg(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z2) {
            while (i4 < zzneVar.size()) {
                this.zza.zzf(i3, zzneVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzneVar.size(); i8++) {
            zzneVar.zze(i8);
            i7 += 4;
        }
        this.zza.zzt(i7);
        while (i4 < zzneVar.size()) {
            this.zza.zzg(zzneVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzm(int i3, long j3) throws IOException {
        this.zza.zzh(i3, j3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzn(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zznx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzi(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z2) {
            while (i4 < zznxVar.size()) {
                this.zza.zzh(i3, zznxVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zznxVar.size(); i8++) {
            zznxVar.zze(i8);
            i7 += 8;
        }
        this.zza.zzt(i7);
        while (i4 < zznxVar.size()) {
            this.zza.zzi(zznxVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzo(int i3, float f3) throws IOException {
        this.zza.zzf(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzp(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzmv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        zzmv zzmvVar = (zzmv) list;
        if (!z2) {
            while (i4 < zzmvVar.size()) {
                this.zza.zzf(i3, Float.floatToRawIntBits(zzmvVar.zze(i4)));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzmvVar.size(); i8++) {
            zzmvVar.zze(i8);
            i7 += 4;
        }
        this.zza.zzt(i7);
        while (i4 < zzmvVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzmvVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzq(int i3, Object obj, zzow zzowVar) throws IOException {
        zzln zzlnVar = this.zza;
        zzlnVar.zzr(i3, 3);
        zzowVar.zzj((zzoi) obj, zzlnVar.zza);
        zzlnVar.zzr(i3, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzr(int i3, int i4) throws IOException {
        this.zza.zzj(i3, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzs(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzne)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzB += zzln.zzB(((Integer) list.get(i5)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i4 < list.size()) {
                this.zza.zzk(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z2) {
            while (i4 < zzneVar.size()) {
                this.zza.zzj(i3, zzneVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzB2 = 0;
        for (int i6 = 0; i6 < zzneVar.size(); i6++) {
            iZzB2 += zzln.zzB(zzneVar.zze(i6));
        }
        this.zza.zzt(iZzB2);
        while (i4 < zzneVar.size()) {
            this.zza.zzk(zzneVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzt(int i3, long j3) throws IOException {
        this.zza.zzu(i3, j3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzu(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zznx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzu(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int iZzB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzB += zzln.zzB(((Long) list.get(i5)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i4 < list.size()) {
                this.zza.zzv(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z2) {
            while (i4 < zznxVar.size()) {
                this.zza.zzu(i3, zznxVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int iZzB2 = 0;
        for (int i6 = 0; i6 < zznxVar.size(); i6++) {
            iZzB2 += zzln.zzB(zznxVar.zze(i6));
        }
        this.zza.zzt(iZzB2);
        while (i4 < zznxVar.size()) {
            this.zza.zzv(zznxVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzv(int i3, Object obj, zzow zzowVar) throws IOException {
        this.zza.zzm(i3, (zzoi) obj, zzowVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzw(int i3, Object obj) throws IOException {
        if (obj instanceof zzle) {
            this.zza.zzo(i3, (zzle) obj);
        } else {
            this.zza.zzn(i3, (zzoi) obj);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzx(int i3, int i4) throws IOException {
        this.zza.zzf(i3, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzy(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzne)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzr(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i4 < list.size()) {
                this.zza.zzg(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z2) {
            while (i4 < zzneVar.size()) {
                this.zza.zzf(i3, zzneVar.zze(i4));
                i4++;
            }
            return;
        }
        this.zza.zzr(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzneVar.size(); i8++) {
            zzneVar.zze(i8);
            i7 += 4;
        }
        this.zza.zzt(i7);
        while (i4 < zzneVar.size()) {
            this.zza.zzg(zzneVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzz(int i3, long j3) throws IOException {
        this.zza.zzh(i3, j3);
    }
}

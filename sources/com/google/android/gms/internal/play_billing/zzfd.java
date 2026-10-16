package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfd implements zzit {
    private final zzfc zza;

    private zzfd(zzfc zzfcVar) {
        byte[] bArr = zzga.zzb;
        this.zza = zzfcVar;
        zzfcVar.zza = this;
    }

    public static zzfd zza(zzfc zzfcVar) {
        Object obj = zzfcVar.zza;
        return obj != null ? (zzfd) obj : new zzfd(zzfcVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzA(int i3, long j3) throws IOException {
        this.zza.zzj(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzB(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzgp)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzk(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        if (!z2) {
            while (i4 < zzgpVar.size()) {
                this.zza.zzj(i3, zzgpVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzgpVar.size(); i8++) {
            zzgpVar.zze(i8);
            i7 += 8;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzgpVar.size()) {
            zzfcVar2.zzk(zzgpVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzC(int i3, int i4) throws IOException {
        this.zza.zzt(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzD(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzfc zzfcVar = this.zza;
                    int iIntValue = ((Integer) list.get(i4)).intValue();
                    zzfcVar.zzt(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i4++;
                }
                return;
            }
            zzfc zzfcVar2 = this.zza;
            zzfcVar2.zzs(i3, 2);
            int iZzy = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int iIntValue2 = ((Integer) list.get(i5)).intValue();
                iZzy += zzfc.zzy((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzfcVar2.zzu(iZzy);
            while (i4 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i4)).intValue();
                zzfcVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i4++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z2) {
            while (i4 < zzfvVar.size()) {
                zzfc zzfcVar3 = this.zza;
                int iZze = zzfvVar.zze(i4);
                zzfcVar3.zzt(i3, (iZze >> 31) ^ (iZze + iZze));
                i4++;
            }
            return;
        }
        zzfc zzfcVar4 = this.zza;
        zzfcVar4.zzs(i3, 2);
        int iZzy2 = 0;
        for (int i6 = 0; i6 < zzfvVar.size(); i6++) {
            int iZze2 = zzfvVar.zze(i6);
            iZzy2 += zzfc.zzy((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzfcVar4.zzu(iZzy2);
        while (i4 < zzfvVar.size()) {
            int iZze3 = zzfvVar.zze(i4);
            zzfcVar4.zzu((iZze3 >> 31) ^ (iZze3 + iZze3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzE(int i3, long j3) throws IOException {
        this.zza.zzv(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzF(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzgp)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzfc zzfcVar = this.zza;
                    long jLongValue = ((Long) list.get(i4)).longValue();
                    zzfcVar.zzv(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i4++;
                }
                return;
            }
            zzfc zzfcVar2 = this.zza;
            zzfcVar2.zzs(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long jLongValue2 = ((Long) list.get(i5)).longValue();
                iZzz += zzfc.zzz((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzfcVar2.zzu(iZzz);
            while (i4 < list.size()) {
                long jLongValue3 = ((Long) list.get(i4)).longValue();
                zzfcVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i4++;
            }
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        if (!z2) {
            while (i4 < zzgpVar.size()) {
                zzfc zzfcVar3 = this.zza;
                long jZze = zzgpVar.zze(i4);
                zzfcVar3.zzv(i3, (jZze >> 63) ^ (jZze + jZze));
                i4++;
            }
            return;
        }
        zzfc zzfcVar4 = this.zza;
        zzfcVar4.zzs(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzgpVar.size(); i6++) {
            long jZze2 = zzgpVar.zze(i6);
            iZzz2 += zzfc.zzz((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzfcVar4.zzu(iZzz2);
        while (i4 < zzgpVar.size()) {
            long jZze3 = zzgpVar.zze(i4);
            zzfcVar4.zzw((jZze3 >> 63) ^ (jZze3 + jZze3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    @Deprecated
    public final void zzG(int i3) throws IOException {
        this.zza.zzs(i3, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzH(int i3, String str) throws IOException {
        this.zza.zzq(i3, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzI(int i3, List list) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzgj)) {
            while (i4 < list.size()) {
                this.zza.zzq(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzgj zzgjVar = (zzgj) list;
        while (i4 < list.size()) {
            Object objZza = zzgjVar.zza();
            if (objZza instanceof String) {
                this.zza.zzq(i3, (String) objZza);
            } else {
                this.zza.zzf(i3, (zzev) objZza);
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzJ(int i3, int i4) throws IOException {
        this.zza.zzt(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzK(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzt(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int iZzy = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzy += zzfc.zzy(((Integer) list.get(i5)).intValue());
            }
            zzfcVar.zzu(iZzy);
            while (i4 < list.size()) {
                zzfcVar.zzu(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z2) {
            while (i4 < zzfvVar.size()) {
                this.zza.zzt(i3, zzfvVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int iZzy2 = 0;
        for (int i6 = 0; i6 < zzfvVar.size(); i6++) {
            iZzy2 += zzfc.zzy(zzfvVar.zze(i6));
        }
        zzfcVar2.zzu(iZzy2);
        while (i4 < zzfvVar.size()) {
            zzfcVar2.zzu(zzfvVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzL(int i3, long j3) throws IOException {
        this.zza.zzv(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzM(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzgp)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzv(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzz += zzfc.zzz(((Long) list.get(i5)).longValue());
            }
            zzfcVar.zzu(iZzz);
            while (i4 < list.size()) {
                zzfcVar.zzw(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        if (!z2) {
            while (i4 < zzgpVar.size()) {
                this.zza.zzv(i3, zzgpVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzgpVar.size(); i6++) {
            iZzz2 += zzfc.zzz(zzgpVar.zze(i6));
        }
        zzfcVar2.zzu(iZzz2);
        while (i4 < zzgpVar.size()) {
            zzfcVar2.zzw(zzgpVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzb(int i3, boolean z2) throws IOException {
        this.zza.zzd(i3, z2);
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
    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzc(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzel)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzd(i3, ((Boolean) list.get(i4)).booleanValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzb(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
                i4++;
            }
            return;
        }
        zzel zzelVar = (zzel) list;
        if (!z2) {
            while (i4 < zzelVar.size()) {
                this.zza.zzd(i3, zzelVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzelVar.size(); i8++) {
            zzelVar.zzf(i8);
            i7++;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzelVar.size()) {
            zzfcVar2.zzb(zzelVar.zzf(i4) ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzd(int i3, zzev zzevVar) throws IOException {
        this.zza.zzf(i3, zzevVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zze(int i3, List list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zzf(i3, (zzev) list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzf(int i3, double d3) throws IOException {
        this.zza.zzj(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzg(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfe)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        zzfe zzfeVar = (zzfe) list;
        if (!z2) {
            while (i4 < zzfeVar.size()) {
                this.zza.zzj(i3, Double.doubleToRawLongBits(zzfeVar.zze(i4)));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzfeVar.size(); i8++) {
            zzfeVar.zze(i8);
            i7 += 8;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzfeVar.size()) {
            zzfcVar2.zzk(Double.doubleToRawLongBits(zzfeVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    @Deprecated
    public final void zzh(int i3) throws IOException {
        this.zza.zzs(i3, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzi(int i3, int i4) throws IOException {
        this.zza.zzl(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzj(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzl(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzz += zzfc.zzz(((Integer) list.get(i5)).intValue());
            }
            zzfcVar.zzu(iZzz);
            while (i4 < list.size()) {
                zzfcVar.zzm(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z2) {
            while (i4 < zzfvVar.size()) {
                this.zza.zzl(i3, zzfvVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzfvVar.size(); i6++) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i6));
        }
        zzfcVar2.zzu(iZzz2);
        while (i4 < zzfvVar.size()) {
            zzfcVar2.zzm(zzfvVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzk(int i3, int i4) throws IOException {
        this.zza.zzh(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzl(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzi(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z2) {
            while (i4 < zzfvVar.size()) {
                this.zza.zzh(i3, zzfvVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzfvVar.size(); i8++) {
            zzfvVar.zze(i8);
            i7 += 4;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzfvVar.size()) {
            zzfcVar2.zzi(zzfvVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzm(int i3, long j3) throws IOException {
        this.zza.zzj(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzn(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzgp)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzk(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        if (!z2) {
            while (i4 < zzgpVar.size()) {
                this.zza.zzj(i3, zzgpVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzgpVar.size(); i8++) {
            zzgpVar.zze(i8);
            i7 += 8;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzgpVar.size()) {
            zzfcVar2.zzk(zzgpVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzo(int i3, float f3) throws IOException {
        this.zza.zzh(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzp(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfo)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzi(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        zzfo zzfoVar = (zzfo) list;
        if (!z2) {
            while (i4 < zzfoVar.size()) {
                this.zza.zzh(i3, Float.floatToRawIntBits(zzfoVar.zze(i4)));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzfoVar.size(); i8++) {
            zzfoVar.zze(i8);
            i7 += 4;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzfoVar.size()) {
            zzfcVar2.zzi(Float.floatToRawIntBits(zzfoVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzq(int i3, Object obj, zzhl zzhlVar) throws IOException {
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i3, 3);
        zzhlVar.zzi((zzeg) obj, this);
        zzfcVar.zzs(i3, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzr(int i3, int i4) throws IOException {
        this.zza.zzl(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzs(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzl(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzz += zzfc.zzz(((Integer) list.get(i5)).intValue());
            }
            zzfcVar.zzu(iZzz);
            while (i4 < list.size()) {
                zzfcVar.zzm(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z2) {
            while (i4 < zzfvVar.size()) {
                this.zza.zzl(i3, zzfvVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzfvVar.size(); i6++) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i6));
        }
        zzfcVar2.zzu(iZzz2);
        while (i4 < zzfvVar.size()) {
            zzfcVar2.zzm(zzfvVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzt(int i3, long j3) throws IOException {
        this.zza.zzv(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzu(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzgp)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzv(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int iZzz = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzz += zzfc.zzz(((Long) list.get(i5)).longValue());
            }
            zzfcVar.zzu(iZzz);
            while (i4 < list.size()) {
                zzfcVar.zzw(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzgp zzgpVar = (zzgp) list;
        if (!z2) {
            while (i4 < zzgpVar.size()) {
                this.zza.zzv(i3, zzgpVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int iZzz2 = 0;
        for (int i6 = 0; i6 < zzgpVar.size(); i6++) {
            iZzz2 += zzfc.zzz(zzgpVar.zze(i6));
        }
        zzfcVar2.zzu(iZzz2);
        while (i4 < zzgpVar.size()) {
            zzfcVar2.zzw(zzgpVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzv(int i3, zzgt zzgtVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            zzfcVar.zzu(zzgu.zzb(zzgtVar, entry.getKey(), entry.getValue()));
            zzgu.zze(zzfcVar, zzgtVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzw(int i3, Object obj, zzhl zzhlVar) throws IOException {
        zzfc zzfcVar = this.zza;
        zzeg zzegVar = (zzeg) obj;
        zzfcVar.zzs(i3, 2);
        zzfcVar.zzu(zzegVar.zzi(zzhlVar));
        zzhlVar.zzi(zzegVar, this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzx(int i3, Object obj) throws IOException {
        if (obj instanceof zzev) {
            this.zza.zzp(i3, (zzev) obj);
        } else {
            this.zza.zzo(i3, (zzhb) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzy(int i3, int i4) throws IOException {
        this.zza.zzh(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzz(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzfv)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzfcVar.zzu(i5);
            while (i4 < list.size()) {
                zzfcVar.zzi(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z2) {
            while (i4 < zzfvVar.size()) {
                this.zza.zzh(i3, zzfvVar.zze(i4));
                i4++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzfvVar.size(); i8++) {
            zzfvVar.zze(i8);
            i7 += 4;
        }
        zzfcVar2.zzu(i7);
        while (i4 < zzfvVar.size()) {
            zzfcVar2.zzi(zzfvVar.zze(i4));
            i4++;
        }
    }
}

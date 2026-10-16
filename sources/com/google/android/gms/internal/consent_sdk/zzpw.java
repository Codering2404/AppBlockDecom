package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpw implements zztb {
    private final zzpv zza;

    private zzpw(zzpv zzpvVar) {
        byte[] bArr = zzqs.zzb;
        this.zza = zzpvVar;
        zzpvVar.zze = this;
    }

    public static zzpw zza(zzpv zzpvVar) {
        Object obj = zzpvVar.zze;
        return obj != null ? (zzpw) obj : new zzpw(zzpvVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzA(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzre)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzl(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzm(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzre zzreVar = (zzre) list;
        if (!z2) {
            while (i4 < zzreVar.size()) {
                this.zza.zzl(i3, zzreVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzreVar.size(); i8++) {
            zzreVar.zze(i8);
            i7 += 8;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzreVar.size()) {
            zzpvVar2.zzm(zzreVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzB(int i3, int i4) throws IOException {
        this.zza.zzv(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzC(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqn)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzpv zzpvVar = this.zza;
                    int iIntValue = ((Integer) list.get(i4)).intValue();
                    zzpvVar.zzv(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i4++;
                }
                return;
            }
            zzpv zzpvVar2 = this.zza;
            zzpvVar2.zzu(i3, 2);
            int iZzC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int iIntValue2 = ((Integer) list.get(i5)).intValue();
                iZzC += zzpv.zzC((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzpvVar2.zzw(iZzC);
            while (i4 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i4)).intValue();
                zzpvVar2.zzw((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i4++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z2) {
            while (i4 < zzqnVar.size()) {
                zzpv zzpvVar3 = this.zza;
                int iZze = zzqnVar.zze(i4);
                zzpvVar3.zzv(i3, (iZze >> 31) ^ (iZze + iZze));
                i4++;
            }
            return;
        }
        zzpv zzpvVar4 = this.zza;
        zzpvVar4.zzu(i3, 2);
        int iZzC2 = 0;
        for (int i6 = 0; i6 < zzqnVar.size(); i6++) {
            int iZze2 = zzqnVar.zze(i6);
            iZzC2 += zzpv.zzC((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzpvVar4.zzw(iZzC2);
        while (i4 < zzqnVar.size()) {
            int iZze3 = zzqnVar.zze(i4);
            zzpvVar4.zzw((iZze3 >> 31) ^ (iZze3 + iZze3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzD(int i3, long j3) throws IOException {
        this.zza.zzx(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzE(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzre)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzpv zzpvVar = this.zza;
                    long jLongValue = ((Long) list.get(i4)).longValue();
                    zzpvVar.zzx(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i4++;
                }
                return;
            }
            zzpv zzpvVar2 = this.zza;
            zzpvVar2.zzu(i3, 2);
            int iZzD = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long jLongValue2 = ((Long) list.get(i5)).longValue();
                iZzD += zzpv.zzD((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzpvVar2.zzw(iZzD);
            while (i4 < list.size()) {
                long jLongValue3 = ((Long) list.get(i4)).longValue();
                zzpvVar2.zzy((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i4++;
            }
            return;
        }
        zzre zzreVar = (zzre) list;
        if (!z2) {
            while (i4 < zzreVar.size()) {
                zzpv zzpvVar3 = this.zza;
                long jZze = zzreVar.zze(i4);
                zzpvVar3.zzx(i3, (jZze >> 63) ^ (jZze + jZze));
                i4++;
            }
            return;
        }
        zzpv zzpvVar4 = this.zza;
        zzpvVar4.zzu(i3, 2);
        int iZzD2 = 0;
        for (int i6 = 0; i6 < zzreVar.size(); i6++) {
            long jZze2 = zzreVar.zze(i6);
            iZzD2 += zzpv.zzD((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzpvVar4.zzw(iZzD2);
        while (i4 < zzreVar.size()) {
            long jZze3 = zzreVar.zze(i4);
            zzpvVar4.zzy((jZze3 >> 63) ^ (jZze3 + jZze3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzF(int i3, String str) throws IOException {
        this.zza.zzs(i3, str);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzG(int i3, List list) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzrb)) {
            while (i4 < list.size()) {
                this.zza.zzs(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzrb zzrbVar = (zzrb) list;
        while (i4 < list.size()) {
            Object objZza = zzrbVar.zza();
            if (objZza instanceof String) {
                this.zza.zzs(i3, (String) objZza);
            } else {
                this.zza.zzh(i3, (zzpm) objZza);
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzH(int i3, int i4) throws IOException {
        this.zza.zzv(i3, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzI(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqn)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzv(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int iZzC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzC += zzpv.zzC(((Integer) list.get(i5)).intValue());
            }
            zzpvVar.zzw(iZzC);
            while (i4 < list.size()) {
                zzpvVar.zzw(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z2) {
            while (i4 < zzqnVar.size()) {
                this.zza.zzv(i3, zzqnVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int iZzC2 = 0;
        for (int i6 = 0; i6 < zzqnVar.size(); i6++) {
            iZzC2 += zzpv.zzC(zzqnVar.zze(i6));
        }
        zzpvVar2.zzw(iZzC2);
        while (i4 < zzqnVar.size()) {
            zzpvVar2.zzw(zzqnVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzJ(int i3, long j3) throws IOException {
        this.zza.zzx(i3, j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzK(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzre)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzx(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int iZzD = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzD += zzpv.zzD(((Long) list.get(i5)).longValue());
            }
            zzpvVar.zzw(iZzD);
            while (i4 < list.size()) {
                zzpvVar.zzy(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzre zzreVar = (zzre) list;
        if (!z2) {
            while (i4 < zzreVar.size()) {
                this.zza.zzx(i3, zzreVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int iZzD2 = 0;
        for (int i6 = 0; i6 < zzreVar.size(); i6++) {
            iZzD2 += zzpv.zzD(zzreVar.zze(i6));
        }
        zzpvVar2.zzw(iZzD2);
        while (i4 < zzreVar.size()) {
            zzpvVar2.zzy(zzreVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzb(int i3, boolean z2) throws IOException {
        this.zza.zzK(i3, z2);
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
    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzc(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzpd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzK(i3, ((Boolean) list.get(i4)).booleanValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzJ(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
                i4++;
            }
            return;
        }
        zzpd zzpdVar = (zzpd) list;
        if (!z2) {
            while (i4 < zzpdVar.size()) {
                this.zza.zzK(i3, zzpdVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzpdVar.size(); i8++) {
            zzpdVar.zze(i8);
            i7++;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzpdVar.size()) {
            zzpvVar2.zzJ(zzpdVar.zze(i4) ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzd(int i3, zzpm zzpmVar) throws IOException {
        this.zza.zzh(i3, zzpmVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zze(int i3, List list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zzh(i3, (zzpm) list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzf(int i3, double d3) throws IOException {
        this.zza.zzl(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzg(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzpx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzl(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzm(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        zzpx zzpxVar = (zzpx) list;
        if (!z2) {
            while (i4 < zzpxVar.size()) {
                this.zza.zzl(i3, Double.doubleToRawLongBits(zzpxVar.zze(i4)));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzpxVar.size(); i8++) {
            zzpxVar.zze(i8);
            i7 += 8;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzpxVar.size()) {
            zzpvVar2.zzm(Double.doubleToRawLongBits(zzpxVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzh(int i3, int i4) throws IOException {
        this.zza.zzn(i3, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzi(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqn)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzn(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int iZzD = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzD += zzpv.zzD(((Integer) list.get(i5)).intValue());
            }
            zzpvVar.zzw(iZzD);
            while (i4 < list.size()) {
                zzpvVar.zzo(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z2) {
            while (i4 < zzqnVar.size()) {
                this.zza.zzn(i3, zzqnVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int iZzD2 = 0;
        for (int i6 = 0; i6 < zzqnVar.size(); i6++) {
            iZzD2 += zzpv.zzD(zzqnVar.zze(i6));
        }
        zzpvVar2.zzw(iZzD2);
        while (i4 < zzqnVar.size()) {
            zzpvVar2.zzo(zzqnVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzj(int i3, int i4) throws IOException {
        this.zza.zzj(i3, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzk(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqn)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzk(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z2) {
            while (i4 < zzqnVar.size()) {
                this.zza.zzj(i3, zzqnVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzqnVar.size(); i8++) {
            zzqnVar.zze(i8);
            i7 += 4;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzqnVar.size()) {
            zzpvVar2.zzk(zzqnVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzl(int i3, long j3) throws IOException {
        this.zza.zzl(i3, j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzm(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzre)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzl(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzm(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzre zzreVar = (zzre) list;
        if (!z2) {
            while (i4 < zzreVar.size()) {
                this.zza.zzl(i3, zzreVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzreVar.size(); i8++) {
            zzreVar.zze(i8);
            i7 += 8;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzreVar.size()) {
            zzpvVar2.zzm(zzreVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzn(int i3, float f3) throws IOException {
        this.zza.zzj(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzo(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqh)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzk(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        zzqh zzqhVar = (zzqh) list;
        if (!z2) {
            while (i4 < zzqhVar.size()) {
                this.zza.zzj(i3, Float.floatToRawIntBits(zzqhVar.zze(i4)));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzqhVar.size(); i8++) {
            zzqhVar.zze(i8);
            i7 += 4;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzqhVar.size()) {
            zzpvVar2.zzk(Float.floatToRawIntBits(zzqhVar.zze(i4)));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzp(int i3, Object obj, zzsa zzsaVar) throws IOException {
        zzpv zzpvVar = this.zza;
        zzpvVar.zzu(i3, 3);
        zzsaVar.zzf((zzpa) obj, this);
        zzpvVar.zzu(i3, 4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzq(int i3, int i4) throws IOException {
        this.zza.zzn(i3, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzr(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqn)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzn(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int iZzD = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzD += zzpv.zzD(((Integer) list.get(i5)).intValue());
            }
            zzpvVar.zzw(iZzD);
            while (i4 < list.size()) {
                zzpvVar.zzo(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z2) {
            while (i4 < zzqnVar.size()) {
                this.zza.zzn(i3, zzqnVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int iZzD2 = 0;
        for (int i6 = 0; i6 < zzqnVar.size(); i6++) {
            iZzD2 += zzpv.zzD(zzqnVar.zze(i6));
        }
        zzpvVar2.zzw(iZzD2);
        while (i4 < zzqnVar.size()) {
            zzpvVar2.zzo(zzqnVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzs(int i3, long j3) throws IOException {
        this.zza.zzx(i3, j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzt(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzre)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzx(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int iZzD = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzD += zzpv.zzD(((Long) list.get(i5)).longValue());
            }
            zzpvVar.zzw(iZzD);
            while (i4 < list.size()) {
                zzpvVar.zzy(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzre zzreVar = (zzre) list;
        if (!z2) {
            while (i4 < zzreVar.size()) {
                this.zza.zzx(i3, zzreVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int iZzD2 = 0;
        for (int i6 = 0; i6 < zzreVar.size(); i6++) {
            iZzD2 += zzpv.zzD(zzreVar.zze(i6));
        }
        zzpvVar2.zzw(iZzD2);
        while (i4 < zzreVar.size()) {
            zzpvVar2.zzy(zzreVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzu(int i3, zzri zzriVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            zzpvVar.zzw(zzrj.zzb(zzriVar, entry.getKey(), entry.getValue()));
            Object key = entry.getKey();
            Object value = entry.getValue();
            zzqf.zzi(zzpvVar, zzriVar.zza, 1, key);
            zzqf.zzi(zzpvVar, zzriVar.zzb, 2, value);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzv(int i3, Object obj, zzsa zzsaVar) throws IOException {
        zzpv zzpvVar = this.zza;
        zzpa zzpaVar = (zzpa) obj;
        zzpvVar.zzu(i3, 2);
        zzpvVar.zzw(zzpaVar.zzj(zzsaVar));
        zzsaVar.zzf(zzpaVar, this);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzw(int i3, Object obj) throws IOException {
        if (obj instanceof zzpm) {
            this.zza.zzr(i3, (zzpm) obj);
        } else {
            this.zza.zzq(i3, (zzrq) obj);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzx(int i3, int i4) throws IOException {
        this.zza.zzj(i3, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzy(int i3, List list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzqn)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzj(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzpv zzpvVar = this.zza;
            zzpvVar.zzu(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzpvVar.zzw(i5);
            while (i4 < list.size()) {
                zzpvVar.zzk(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzqn zzqnVar = (zzqn) list;
        if (!z2) {
            while (i4 < zzqnVar.size()) {
                this.zza.zzj(i3, zzqnVar.zze(i4));
                i4++;
            }
            return;
        }
        zzpv zzpvVar2 = this.zza;
        zzpvVar2.zzu(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzqnVar.size(); i8++) {
            zzqnVar.zze(i8);
            i7 += 4;
        }
        zzpvVar2.zzw(i7);
        while (i4 < zzqnVar.size()) {
            zzpvVar2.zzk(zzqnVar.zze(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztb
    public final void zzz(int i3, long j3) throws IOException {
        this.zza.zzl(i3, j3);
    }
}

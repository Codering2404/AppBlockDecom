package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcv implements zzbgl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbcu f76035a;

    private zzbcv(zzbcu zzbcuVar) {
        byte[] bArr = zzbeb.f76092b;
        this.f76035a = zzbcuVar;
        zzbcuVar.f76034a = this;
    }

    public static zzbcv d(zzbcu zzbcuVar) {
        Object obj = zzbcuVar.f76034a;
        return obj != null ? (zzbcv) obj : new zzbcv(zzbcuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void a(int i3, zzbcl zzbclVar) {
        this.f76035a.q(i3, zzbclVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void b(int i3, Object obj, zzbfl zzbflVar) {
        zzbcu zzbcuVar = this.f76035a;
        zzbby zzbbyVar = (zzbby) obj;
        zzbcuVar.h(i3, 2);
        zzbcuVar.v(zzbbyVar.d(zzbflVar));
        zzbflVar.a(zzbbyVar, this);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void c(int i3, Object obj, zzbfl zzbflVar) {
        zzbcu zzbcuVar = this.f76035a;
        zzbcuVar.h(i3, 3);
        zzbflVar.a((zzbby) obj, this);
        zzbcuVar.h(i3, 4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzA(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbem)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.n(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.y(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z2) {
            while (i4 < zzbemVar.size()) {
                this.f76035a.n(i3, zzbemVar.d(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbemVar.size(); i8++) {
            zzbemVar.d(i8);
            i7 += 8;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbemVar.size()) {
            zzbcuVar2.y(zzbemVar.d(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzB(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdi)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.k(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).getClass();
                i5 += 4;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.w(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        zzbdi zzbdiVar = (zzbdi) list;
        if (!z2) {
            while (i4 < zzbdiVar.size()) {
                this.f76035a.k(i3, Float.floatToRawIntBits(zzbdiVar.b(i4)));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbdiVar.size(); i8++) {
            zzbdiVar.b(i8);
            i7 += 4;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbdiVar.size()) {
            zzbcuVar2.w(Float.floatToRawIntBits(zzbdiVar.b(i4)));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzC(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbcw)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.n(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).getClass();
                i5 += 8;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.y(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        zzbcw zzbcwVar = (zzbcw) list;
        if (!z2) {
            while (i4 < zzbcwVar.size()) {
                this.f76035a.n(i3, Double.doubleToRawLongBits(zzbcwVar.b(i4)));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbcwVar.size(); i8++) {
            zzbcwVar.b(i8);
            i7 += 8;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbcwVar.size()) {
            zzbcuVar2.y(Double.doubleToRawLongBits(zzbcwVar.b(i4)));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzD(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdr)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.i(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int iC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iC += zzbcu.C(((Integer) list.get(i5)).intValue());
            }
            zzbcuVar.v(iC);
            while (i4 < list.size()) {
                zzbcuVar.u(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        if (!z2) {
            while (i4 < zzbdrVar.size()) {
                this.f76035a.i(i3, zzbdrVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int iC2 = 0;
        for (int i6 = 0; i6 < zzbdrVar.size(); i6++) {
            iC2 += zzbcu.C(zzbdrVar.zzf(i6));
        }
        zzbcuVar2.v(iC2);
        while (i4 < zzbdrVar.size()) {
            zzbcuVar2.u(zzbdrVar.zzf(i4));
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
    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzE(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbcd)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.o(i3, ((Boolean) list.get(i4)).booleanValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).getClass();
                i5++;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.t(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
                i4++;
            }
            return;
        }
        zzbcd zzbcdVar = (zzbcd) list;
        if (!z2) {
            while (i4 < zzbcdVar.size()) {
                this.f76035a.o(i3, zzbcdVar.b(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbcdVar.size(); i8++) {
            zzbcdVar.b(i8);
            i7++;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbcdVar.size()) {
            zzbcuVar2.t(zzbcdVar.b(i4) ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzF(int i3, List list) {
        int i4 = 0;
        if (!(list instanceof zzbej)) {
            while (i4 < list.size()) {
                this.f76035a.p(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzbej zzbejVar = (zzbej) list;
        while (i4 < list.size()) {
            Object objZzc = zzbejVar.zzc();
            if (objZzc instanceof String) {
                this.f76035a.p(i3, (String) objZzc);
            } else {
                this.f76035a.q(i3, (zzbcl) objZzc);
            }
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzG(int i3, List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f76035a.q(i3, (zzbcl) list.get(i4));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzH(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdr)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.j(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int iB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iB += zzbcu.B(((Integer) list.get(i5)).intValue());
            }
            zzbcuVar.v(iB);
            while (i4 < list.size()) {
                zzbcuVar.v(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        if (!z2) {
            while (i4 < zzbdrVar.size()) {
                this.f76035a.j(i3, zzbdrVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int iB2 = 0;
        for (int i6 = 0; i6 < zzbdrVar.size(); i6++) {
            iB2 += zzbcu.B(zzbdrVar.zzf(i6));
        }
        zzbcuVar2.v(iB2);
        while (i4 < zzbdrVar.size()) {
            zzbcuVar2.v(zzbdrVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzI(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdr)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.k(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.w(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        if (!z2) {
            while (i4 < zzbdrVar.size()) {
                this.f76035a.k(i3, zzbdrVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbdrVar.size(); i8++) {
            zzbdrVar.zzf(i8);
            i7 += 4;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbdrVar.size()) {
            zzbcuVar2.w(zzbdrVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzJ(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbem)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.n(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).getClass();
                i5 += 8;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.y(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z2) {
            while (i4 < zzbemVar.size()) {
                this.f76035a.n(i3, zzbemVar.d(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbemVar.size(); i8++) {
            zzbemVar.d(i8);
            i7 += 8;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbemVar.size()) {
            zzbcuVar2.y(zzbemVar.d(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzK(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdr)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzbcu zzbcuVar = this.f76035a;
                    int iIntValue = ((Integer) list.get(i4)).intValue();
                    zzbcuVar.j(i3, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar2 = this.f76035a;
            zzbcuVar2.h(i3, 2);
            int iB = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                int iIntValue2 = ((Integer) list.get(i5)).intValue();
                iB += zzbcu.B((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzbcuVar2.v(iB);
            while (i4 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i4)).intValue();
                zzbcuVar2.v((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i4++;
            }
            return;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        if (!z2) {
            while (i4 < zzbdrVar.size()) {
                zzbcu zzbcuVar3 = this.f76035a;
                int iZzf = zzbdrVar.zzf(i4);
                zzbcuVar3.j(i3, (iZzf >> 31) ^ (iZzf + iZzf));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar4 = this.f76035a;
        zzbcuVar4.h(i3, 2);
        int iB2 = 0;
        for (int i6 = 0; i6 < zzbdrVar.size(); i6++) {
            int iZzf2 = zzbdrVar.zzf(i6);
            iB2 += zzbcu.B((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzbcuVar4.v(iB2);
        while (i4 < zzbdrVar.size()) {
            int iZzf3 = zzbdrVar.zzf(i4);
            zzbcuVar4.v((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzL(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbem)) {
            if (!z2) {
                while (i4 < list.size()) {
                    zzbcu zzbcuVar = this.f76035a;
                    long jLongValue = ((Long) list.get(i4)).longValue();
                    zzbcuVar.l(i3, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar2 = this.f76035a;
            zzbcuVar2.h(i3, 2);
            int iC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                long jLongValue2 = ((Long) list.get(i5)).longValue();
                iC += zzbcu.C((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzbcuVar2.v(iC);
            while (i4 < list.size()) {
                long jLongValue3 = ((Long) list.get(i4)).longValue();
                zzbcuVar2.x((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i4++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z2) {
            while (i4 < zzbemVar.size()) {
                zzbcu zzbcuVar3 = this.f76035a;
                long jD = zzbemVar.d(i4);
                zzbcuVar3.l(i3, (jD >> 63) ^ (jD + jD));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar4 = this.f76035a;
        zzbcuVar4.h(i3, 2);
        int iC2 = 0;
        for (int i6 = 0; i6 < zzbemVar.size(); i6++) {
            long jD2 = zzbemVar.d(i6);
            iC2 += zzbcu.C((jD2 >> 63) ^ (jD2 + jD2));
        }
        zzbcuVar4.v(iC2);
        while (i4 < zzbemVar.size()) {
            long jD3 = zzbemVar.d(i4);
            zzbcuVar4.x((jD3 >> 63) ^ (jD3 + jD3));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzb(int i3, int i4) {
        this.f76035a.k(i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzc(int i3, long j3) {
        this.f76035a.l(i3, j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzd(int i3, long j3) {
        this.f76035a.n(i3, j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zze(int i3, float f3) {
        this.f76035a.k(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzf(int i3, double d3) {
        this.f76035a.n(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzg(int i3, int i4) {
        this.f76035a.i(i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzh(int i3, long j3) {
        this.f76035a.l(i3, j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzi(int i3, int i4) {
        this.f76035a.i(i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzj(int i3, long j3) {
        this.f76035a.n(i3, j3);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzk(int i3, int i4) {
        this.f76035a.k(i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzl(int i3, boolean z2) {
        this.f76035a.o(i3, z2);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzm(int i3, String str) {
        this.f76035a.p(i3, str);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzo(int i3, int i4) {
        this.f76035a.j(i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzp(int i3, int i4) {
        this.f76035a.j(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzq(int i3, long j3) {
        this.f76035a.l(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzt(int i3) {
        this.f76035a.h(i3, 3);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzu(int i3) {
        this.f76035a.h(i3, 4);
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzv(int i3, Object obj) {
        if (obj instanceof zzbcl) {
            this.f76035a.s(i3, (zzbcl) obj);
        } else {
            this.f76035a.r(i3, (zzbex) obj);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzw(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdr)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.i(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int iC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iC += zzbcu.C(((Integer) list.get(i5)).intValue());
            }
            zzbcuVar.v(iC);
            while (i4 < list.size()) {
                zzbcuVar.u(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        if (!z2) {
            while (i4 < zzbdrVar.size()) {
                this.f76035a.i(i3, zzbdrVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int iC2 = 0;
        for (int i6 = 0; i6 < zzbdrVar.size(); i6++) {
            iC2 += zzbcu.C(zzbdrVar.zzf(i6));
        }
        zzbcuVar2.v(iC2);
        while (i4 < zzbdrVar.size()) {
            zzbcuVar2.u(zzbdrVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzx(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbdr)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.k(i3, ((Integer) list.get(i4)).intValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).getClass();
                i5 += 4;
            }
            zzbcuVar.v(i5);
            while (i4 < list.size()) {
                zzbcuVar.w(((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        zzbdr zzbdrVar = (zzbdr) list;
        if (!z2) {
            while (i4 < zzbdrVar.size()) {
                this.f76035a.k(i3, zzbdrVar.zzf(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < zzbdrVar.size(); i8++) {
            zzbdrVar.zzf(i8);
            i7 += 4;
        }
        zzbcuVar2.v(i7);
        while (i4 < zzbdrVar.size()) {
            zzbcuVar2.w(zzbdrVar.zzf(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzy(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbem)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.l(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int iC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iC += zzbcu.C(((Long) list.get(i5)).longValue());
            }
            zzbcuVar.v(iC);
            while (i4 < list.size()) {
                zzbcuVar.x(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z2) {
            while (i4 < zzbemVar.size()) {
                this.f76035a.l(i3, zzbemVar.d(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int iC2 = 0;
        for (int i6 = 0; i6 < zzbemVar.size(); i6++) {
            iC2 += zzbcu.C(zzbemVar.d(i6));
        }
        zzbcuVar2.v(iC2);
        while (i4 < zzbemVar.size()) {
            zzbcuVar2.x(zzbemVar.d(i4));
            i4++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgl
    public final void zzz(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!(list instanceof zzbem)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.f76035a.l(i3, ((Long) list.get(i4)).longValue());
                    i4++;
                }
                return;
            }
            zzbcu zzbcuVar = this.f76035a;
            zzbcuVar.h(i3, 2);
            int iC = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iC += zzbcu.C(((Long) list.get(i5)).longValue());
            }
            zzbcuVar.v(iC);
            while (i4 < list.size()) {
                zzbcuVar.x(((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z2) {
            while (i4 < zzbemVar.size()) {
                this.f76035a.l(i3, zzbemVar.d(i4));
                i4++;
            }
            return;
        }
        zzbcu zzbcuVar2 = this.f76035a;
        zzbcuVar2.h(i3, 2);
        int iC2 = 0;
        for (int i6 = 0; i6 < zzbemVar.size(); i6++) {
            iC2 += zzbcu.C(zzbemVar.d(i6));
        }
        zzbcuVar2.v(iC2);
        while (i4 < zzbemVar.size()) {
            zzbcuVar2.x(zzbemVar.d(i4));
            i4++;
        }
    }
}

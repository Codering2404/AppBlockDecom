package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzrb;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzit implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbg f73958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzjd f73960c;

    zzit(zzjd zzjdVar, zzbg zzbgVar, String str) {
        this.f73958a = zzbgVar;
        this.f73959b = str;
        Objects.requireNonNull(zzjdVar);
        this.f73960c = zzjdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Throwable {
        zzlp zzlpVar;
        zzh zzhVarJ0;
        byte[] bArr;
        zzpg zzpgVar;
        zzpn zzpnVar;
        zzpg zzpgVar2;
        zzh zzhVar;
        zzic zzicVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        Bundle bundle;
        String str;
        boolean z2;
        Object obj;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzbc zzbcVarA;
        long j3;
        byte[] bArr2;
        zzjd zzjdVar = this.f73960c;
        zzjdVar.n5().E();
        zzlp zzlpVarJ0 = zzjdVar.n5().J0();
        zzlpVarJ0.h();
        zzic zzicVar3 = zzlpVarJ0.f73997a;
        zzic.q();
        zzbg zzbgVar = this.f73958a;
        Preconditions.m(zzbgVar);
        String str2 = this.f73959b;
        Preconditions.g(str2);
        String str3 = zzbgVar.f73484a;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzlpVarJ0.f73997a.a().v().c("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar3 = zzlpVarJ0.f74388b;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzh = com.google.android.gms.internal.measurement.zzib.zzh();
        zzpgVar3.F0().r0();
        try {
            zzhVarJ0 = zzpgVar3.F0().J0(str2);
        } catch (Throwable th) {
            th = th;
            zzlpVar = zzlpVarJ0;
        }
        if (zzhVarJ0 != null) {
            if (zzhVarJ0.d()) {
                com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                zzicVarZzaE.zza(1);
                zzicVarZzaE.zzC("android");
                if (!TextUtils.isEmpty(zzhVarJ0.o0())) {
                    zzicVarZzaE.zzL(zzhVarJ0.o0());
                }
                if (!TextUtils.isEmpty(zzhVarJ0.H0())) {
                    zzicVarZzaE.zzJ((String) Preconditions.m(zzhVarJ0.H0()));
                }
                if (!TextUtils.isEmpty(zzhVarJ0.D0())) {
                    zzicVarZzaE.zzM((String) Preconditions.m(zzhVarJ0.D0()));
                }
                if (zzhVarJ0.F0() != -2147483648L) {
                    zzicVarZzaE.zzaj((int) zzhVarJ0.F0());
                }
                zzicVarZzaE.zzN(zzhVarJ0.J0());
                zzicVarZzaE.zzar(zzhVarJ0.b());
                String strR0 = zzhVarJ0.r0();
                if (!TextUtils.isEmpty(strR0)) {
                    zzicVarZzaE.zzad(strR0);
                }
                zzicVarZzaE.zzay(zzhVarJ0.X());
                zzjl zzjlVarG = zzlpVarJ0.f74388b.g(str2);
                zzicVarZzaE.zzY(zzhVarJ0.L0());
                if (zzicVar3.g() && zzlpVarJ0.f73997a.w().k(zzicVarZzaE.zzK()) && zzjlVarG.o(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzicVarZzaE.zzam(null);
                }
                zzicVarZzaE.zzat(zzjlVarG.k());
                if (zzjlVarG.o(zzjk.AD_STORAGE) && zzhVarJ0.P()) {
                    Pair pairM = zzpgVar3.L0().m(zzhVarJ0.o0(), zzjlVarG);
                    if (zzhVarJ0.P() && !TextUtils.isEmpty((CharSequence) pairM.first)) {
                        try {
                            zzicVarZzaE.zzQ(zzlp.m((String) pairM.first, Long.toString(zzbgVar.f73487d)));
                            Object obj2 = pairM.second;
                            if (obj2 != null) {
                                zzicVarZzaE.zzT(((Boolean) obj2).booleanValue());
                            }
                        } catch (SecurityException e3) {
                            zzlpVarJ0.f73997a.a().v().b("Resettable device id encryption failed", e3.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarJ0.f74388b;
                            zzpgVar.F0().t0();
                            return bArr;
                        }
                    }
                }
                zzic zzicVar4 = zzlpVarJ0.f73997a;
                zzicVar4.K().l();
                zzicVarZzaE.zzF(Build.MODEL);
                zzicVar4.K().l();
                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                zzicVarZzaE.zzI((int) zzicVar4.K().o());
                zzicVarZzaE.zzH(zzicVar4.K().p());
                try {
                    if (zzjlVarG.o(zzjk.ANALYTICS_STORAGE) && zzhVarJ0.p0() != null) {
                        zzicVarZzaE.zzW(zzlp.m((String) Preconditions.m(zzhVarJ0.p0()), Long.toString(zzbgVar.f73487d)));
                    }
                    if (!TextUtils.isEmpty(zzhVarJ0.x0())) {
                        zzicVarZzaE.zzah((String) Preconditions.m(zzhVarJ0.x0()));
                    }
                    String strO0 = zzhVarJ0.o0();
                    zzpg zzpgVar4 = zzlpVarJ0.f74388b;
                    List listC0 = zzpgVar4.F0().C0(strO0);
                    Iterator it = listC0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzpnVar = null;
                            break;
                        }
                        zzpnVar = (zzpn) it.next();
                        if ("_lte".equals(zzpnVar.f74486c)) {
                            break;
                        }
                    }
                    if (zzpnVar == null || zzpnVar.f74488e == null) {
                        zzpn zzpnVar2 = new zzpn(strO0, "auto", "_lte", zzlpVarJ0.f73997a.e().currentTimeMillis(), 0L);
                        listC0.add(zzpnVar2);
                        zzpgVar4.F0().A0(zzpnVar2);
                    }
                    com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listC0.size()];
                    for (int i3 = 0; i3 < listC0.size(); i3++) {
                        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                        zzitVarZzm.zzb(((zzpn) listC0.get(i3)).f74486c);
                        zzitVarZzm.zza(((zzpn) listC0.get(i3)).f74487d);
                        zzpgVar4.K0().G(zzitVarZzm, ((zzpn) listC0.get(i3)).f74488e);
                        zziuVarArr[i3] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbc();
                    }
                    zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                    zzpg zzpgVar5 = zzlpVarJ0.f74388b;
                    zzpgVar5.n(zzhVarJ0, zzicVarZzaE);
                    zzpgVar5.o(zzhVarJ0, zzicVarZzaE);
                    zzgv zzgvVarA = zzgv.a(zzbgVar);
                    zzic zzicVar5 = zzlpVarJ0.f73997a;
                    zzpp zzppVarC = zzicVar5.C();
                    Bundle bundle2 = zzgvVarA.f73742d;
                    zzppVarC.w(bundle2, zzpgVar4.F0().G(str2));
                    zzicVar5.C().u(zzgvVarA, zzicVar5.w().w(str2));
                    bundle2.putLong("_c", 1L);
                    zzicVar5.a().v().a("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    String str4 = zzbgVar.f73486c;
                    bundle2.putString("_o", str4);
                    if (zzicVar5.C().P(zzicVarZzaE.zzK(), zzhVarJ0.l0())) {
                        zzicVar5.C().A(bundle2, "_dbg", 1L);
                        zzicVar5.C().A(bundle2, "_r", 1L);
                    }
                    zzav zzavVarF0 = zzpgVar4.F0();
                    String str5 = zzbgVar.f73484a;
                    zzbc zzbcVarV0 = zzavVarF0.v0(str2, str5);
                    if (zzbcVarV0 == null) {
                        zzhVar = zzhVarJ0;
                        zzicVar = zzicVar5;
                        zzicVar2 = zzicVarZzaE;
                        zzpgVar2 = zzpgVar5;
                        obj = null;
                        bundle = bundle2;
                        str = str4;
                        zzbcVarA = new zzbc(str2, str5, 0L, 0L, 0L, zzbgVar.f73487d, 0L, null, null, null, null);
                        z2 = true;
                        j3 = 0;
                        zzhzVar = zzhzVarZzh;
                    } else {
                        zzpgVar2 = zzpgVar5;
                        zzhVar = zzhVarJ0;
                        zzicVar = zzicVar5;
                        zzicVar2 = zzicVarZzaE;
                        bundle = bundle2;
                        str = str4;
                        z2 = true;
                        obj = null;
                        zzhzVar = zzhzVarZzh;
                        long j4 = zzbcVarV0.f73475f;
                        zzbcVarA = zzbcVarV0.a(zzbgVar.f73487d);
                        j3 = j4;
                    }
                    zzbc zzbcVar = zzbcVarA;
                    zzpgVar4.F0().w0(zzbcVar);
                    zzic zzicVar6 = zzlpVarJ0.f73997a;
                    long j5 = zzbgVar.f73487d;
                    boolean z3 = z2;
                    zzh zzhVar2 = zzhVar;
                    com.google.android.gms.internal.measurement.zzic zzicVar7 = zzicVar2;
                    zzpg zzpgVar6 = zzpgVar2;
                    try {
                        zzbb zzbbVar = new zzbb(zzicVar6, str, str2, str5, j5, j3, bundle);
                        com.google.android.gms.internal.measurement.zzhr zzhrVarZzk = com.google.android.gms.internal.measurement.zzhs.zzk();
                        zzhrVarZzk.zzo(zzbbVar.f73467d);
                        zzhrVarZzk.zzl(zzbbVar.f73465b);
                        zzhrVarZzk.zzq(zzbbVar.f73468e);
                        zzbe zzbeVar = zzbbVar.f73469f;
                        zzbd zzbdVar = new zzbd(zzbeVar);
                        while (zzbdVar.hasNext()) {
                            String next = zzbdVar.next();
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn.zzb(next);
                            Object objM = zzbeVar.M(next);
                            if (objM != null) {
                                zzpgVar4.K0().H(zzhvVarZzn, objM);
                                zzhrVarZzk.zzg(zzhvVarZzn);
                            }
                        }
                        zzicVar7.zzg(zzhrVarZzk);
                        com.google.android.gms.internal.measurement.zzie zzieVarZza = com.google.android.gms.internal.measurement.zzig.zza();
                        com.google.android.gms.internal.measurement.zzht zzhtVarZza = com.google.android.gms.internal.measurement.zzhu.zza();
                        zzhtVarZza.zzb(zzbcVar.f73472c);
                        zzhtVarZza.zza(str5);
                        zzieVarZza.zza(zzhtVarZza);
                        zzicVar7.zzap(zzieVarZza);
                        zzicVar7.zzaf(zzpgVar4.I0().m(zzhVar2.o0(), Collections.EMPTY_LIST, zzicVar7.zzk(), Long.valueOf(zzhrVarZzk.zzn()), Long.valueOf(zzhrVarZzk.zzn()), false));
                        if (zzhrVarZzk.zzm()) {
                            zzicVar7.zzv(zzhrVarZzk.zzn());
                            zzicVar7.zzx(zzhrVarZzk.zzn());
                        }
                        long jB0 = zzhVar2.B0();
                        if (jB0 != 0) {
                            zzicVar7.zzA(jB0);
                        }
                        long jZ0 = zzhVar2.z0();
                        if (jZ0 != 0) {
                            zzicVar7.zzy(jZ0);
                        } else if (jB0 != 0) {
                            zzicVar7.zzy(jB0);
                        }
                        String strT0 = zzhVar2.t0();
                        zzrb.zza();
                        if (zzicVar.w().H(str2, zzfy.N0) && strT0 != null) {
                            zzicVar7.zzau(strT0);
                        }
                        zzhVar2.l();
                        zzicVar7.zzZ((int) zzhVar2.g());
                        zzicVar.w().A();
                        zzicVar7.zzO(133005L);
                        zzicVar7.zzs(zzicVar.e().currentTimeMillis());
                        zzicVar7.zzae(z3);
                        zzpgVar6.x(zzicVar7.zzK(), zzicVar7);
                        zzhzVar.zze(zzicVar7);
                        zzhVar2.A0(zzicVar7.zzu());
                        zzhVar2.C0(zzicVar7.zzw());
                        zzpgVar4.F0().K0(zzhVar2, false, false);
                        zzpgVar4.F0().s0();
                        zzpgVar4.F0().t0();
                        try {
                            return zzpgVar4.K0().V(((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc()).zzcc());
                        } catch (IOException e4) {
                            zzlpVarJ0.f73997a.a().o().c("Data loss. Failed to bundle and serialize. appId", zzgu.x(str2), e4);
                            return obj;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zzlpVar = zzlpVarJ0;
                    }
                } catch (SecurityException e5) {
                    zzlpVar = zzlpVarJ0;
                    try {
                        zzlpVar.f73997a.a().v().b("app instance id encryption failed", e5.getMessage());
                        bArr = new byte[0];
                        zzpgVar = zzlpVar.f74388b;
                        zzpgVar.F0().t0();
                        return bArr;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } else {
                zzlpVarJ0.f73997a.a().v().b("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzlpVar.f74388b.F0().t0();
            throw th;
        }
        zzlpVarJ0.f73997a.a().v().b("Log and bundle not available. package_name", str2);
        bArr2 = new byte[0];
        zzpgVar3.F0().t0();
        return bArr2;
    }
}

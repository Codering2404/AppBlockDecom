package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjd extends zzga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzpg f73994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f73995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f73996c;

    public zzjd(zzpg zzpgVar, String str) {
        Preconditions.m(zzpgVar);
        this.f73994a = zzpgVar;
        this.f73996c = null;
    }

    private final void o5(zzbg zzbgVar, zzr zzrVar) {
        zzpg zzpgVar = this.f73994a;
        zzpgVar.E();
        zzpgVar.k(zzbgVar, zzrVar);
    }

    private final void p5(zzr zzrVar, boolean z2) {
        Preconditions.m(zzrVar);
        String str = zzrVar.f74500a;
        Preconditions.g(str);
        q5(str, false);
        this.f73994a.N0().o(zzrVar.f74501b);
    }

    private final void q5(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.f73994a.a().o().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z2) {
            try {
                if (this.f73995b == null) {
                    boolean z3 = true;
                    if (!"com.google.android.gms".equals(this.f73996c)) {
                        zzpg zzpgVar = this.f73994a;
                        if (!UidVerifier.a(zzpgVar.d(), Binder.getCallingUid()) && !GoogleSignatureVerifier.a(zzpgVar.d()).c(Binder.getCallingUid())) {
                            z3 = false;
                        }
                    }
                    this.f73995b = Boolean.valueOf(z3);
                }
                if (this.f73995b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e3) {
                this.f73994a.a().o().b("Measurement Service called with invalid calling package. appId", zzgu.x(str));
                throw e3;
            }
        }
        if (this.f73996c == null && GooglePlayServicesUtilLight.l(this.f73994a.d(), Binder.getCallingUid(), str)) {
            this.f73996c = str;
        }
        if (str.equals(this.f73996c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void B2(zzbg zzbgVar, String str, String str2) {
        Preconditions.m(zzbgVar);
        Preconditions.g(str);
        q5(str, true);
        t5(new zzis(this, zzbgVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void E4(zzr zzrVar) {
        p5(zzrVar, false);
        t5(new zzif(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void F(zzr zzrVar, final zzoo zzooVar, final zzgh zzghVar) {
        p5(zzrVar, false);
        final String str = (String) Preconditions.m(zzrVar.f74500a);
        this.f73994a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f73977a.k5(str, zzooVar, zzghVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void F0(final zzr zzrVar) {
        Preconditions.g(zzrVar.f74500a);
        Preconditions.m(zzrVar.f74518t);
        x3(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f73992a.h5(zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List I(String str, String str2, String str3, boolean z2) {
        q5(str, true);
        try {
            List<zzpn> list = (List) this.f73994a.b().r(new zzik(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpn zzpnVar : list) {
                if (z2 || !zzpp.N(zzpnVar.f74486c)) {
                    arrayList.add(new zzpl(zzpnVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e3) {
            e = e3;
            this.f73994a.a().o().c("Failed to get user properties as. appId", zzgu.x(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e4) {
            e = e4;
            this.f73994a.a().o().c("Failed to get user properties as. appId", zzgu.x(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void K(zzah zzahVar, zzr zzrVar) {
        Preconditions.m(zzahVar);
        Preconditions.m(zzahVar.f73388c);
        p5(zzrVar, false);
        zzah zzahVar2 = new zzah(zzahVar);
        zzahVar2.f73386a = zzrVar.f74500a;
        t5(new zzih(this, zzahVar2, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List K4(String str, String str2, boolean z2, zzr zzrVar) {
        p5(zzrVar, false);
        String str3 = zzrVar.f74500a;
        Preconditions.m(str3);
        try {
            List<zzpn> list = (List) this.f73994a.b().r(new zzij(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpn zzpnVar : list) {
                if (z2 || !zzpp.N(zzpnVar.f74486c)) {
                    arrayList.add(new zzpl(zzpnVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e3) {
            e = e3;
            this.f73994a.a().o().c("Failed to query user properties. appId", zzgu.x(zzrVar.f74500a), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e4) {
            e = e4;
            this.f73994a.a().o().c("Failed to query user properties. appId", zzgu.x(zzrVar.f74500a), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void L3(final zzr zzrVar, final zzaf zzafVar) {
        p5(zzrVar, false);
        t5(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzja
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f73985a.l5(zzrVar, zzafVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void M2(long j3, String str, String str2, String str3) {
        t5(new zzig(this, str2, str3, str, j3));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void O2(zzr zzrVar) {
        String str = zzrVar.f74500a;
        Preconditions.g(str);
        q5(str, false);
        t5(new zzio(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List S0(zzr zzrVar, Bundle bundle) {
        p5(zzrVar, false);
        Preconditions.m(zzrVar.f74500a);
        zzpg zzpgVar = this.f73994a;
        if (!zzpgVar.B0().H(null, zzfy.Z0)) {
            try {
                return (List) this.f73994a.b().r(new zziw(this, zzrVar, bundle)).get();
            } catch (InterruptedException | ExecutionException e3) {
                this.f73994a.a().o().c("Failed to get trigger URIs. appId", zzgu.x(zzrVar.f74500a), e3);
                return Collections.EMPTY_LIST;
            }
        }
        try {
            return (List) zzpgVar.b().s(new zziv(this, zzrVar, bundle)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e4) {
            this.f73994a.a().o().c("Failed to get trigger URIs. appId", zzgu.x(zzrVar.f74500a), e4);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List S4(String str, String str2, zzr zzrVar) {
        p5(zzrVar, false);
        String str3 = zzrVar.f74500a;
        Preconditions.m(str3);
        try {
            return (List) this.f73994a.b().r(new zzil(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e3) {
            this.f73994a.a().o().b("Failed to get conditional user properties", e3);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void W0(zzbg zzbgVar, zzr zzrVar) {
        Preconditions.m(zzbgVar);
        p5(zzrVar, false);
        t5(new zzir(this, zzbgVar, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final String W1(zzr zzrVar) {
        p5(zzrVar, false);
        return this.f73994a.p0(zzrVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void X0(zzr zzrVar) {
        p5(zzrVar, false);
        t5(new zzin(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void Z0(final zzr zzrVar) {
        Preconditions.g(zzrVar.f74500a);
        Preconditions.m(zzrVar.f74518t);
        x3(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzix
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f73970a.i5(zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final zzao b4(zzr zzrVar) {
        p5(zzrVar, false);
        Preconditions.g(zzrVar.f74500a);
        try {
            return (zzao) this.f73994a.b().s(new zziq(this, zzrVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e3) {
            this.f73994a.a().o().c("Failed to get consent. appId", zzgu.x(zzrVar.f74500a), e3);
            return new zzao(null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final byte[] d1(zzbg zzbgVar, String str) {
        Preconditions.g(str);
        Preconditions.m(zzbgVar);
        q5(str, true);
        zzpg zzpgVar = this.f73994a;
        zzgs zzgsVarV = zzpgVar.a().v();
        zzgn zzgnVarM0 = zzpgVar.M0();
        String str2 = zzbgVar.f73484a;
        zzgsVarV.b("Log and bundle. event", zzgnVarM0.a(str2));
        long jB = zzpgVar.e().b() / 1000000;
        try {
            byte[] bArr = (byte[]) zzpgVar.b().s(new zzit(this, zzbgVar, str)).get();
            if (bArr == null) {
                zzpgVar.a().o().b("Log and bundle returned null. appId", zzgu.x(str));
                bArr = new byte[0];
            }
            zzpgVar.a().v().d("Log and bundle processed. event, size, time_ms", zzpgVar.M0().a(str2), Integer.valueOf(bArr.length), Long.valueOf((zzpgVar.e().b() / 1000000) - jB));
            return bArr;
        } catch (InterruptedException e3) {
            e = e3;
            zzpg zzpgVar2 = this.f73994a;
            zzpgVar2.a().o().d("Failed to log and bundle. appId, event, error", zzgu.x(str), zzpgVar2.M0().a(zzbgVar.f73484a), e);
            return null;
        } catch (ExecutionException e4) {
            e = e4;
            zzpg zzpgVar22 = this.f73994a;
            zzpgVar22.a().o().d("Failed to log and bundle. appId, event, error", zzgu.x(str), zzpgVar22.M0().a(zzbgVar.f73484a), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void e1(zzah zzahVar) {
        Preconditions.m(zzahVar);
        Preconditions.m(zzahVar.f73388c);
        Preconditions.g(zzahVar.f73386a);
        q5(zzahVar.f73386a, true);
        t5(new zzii(this, new zzah(zzahVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void e4(final Bundle bundle, final zzr zzrVar) {
        p5(zzrVar, false);
        final String str = zzrVar.f74500a;
        Preconditions.m(str);
        t5(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f73988a.m5(bundle, str, zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void e5(zzr zzrVar) {
        Preconditions.g(zzrVar.f74500a);
        Preconditions.m(zzrVar.f74518t);
        x3(new zzip(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List h2(zzr zzrVar, boolean z2) {
        p5(zzrVar, false);
        String str = zzrVar.f74500a;
        Preconditions.m(str);
        try {
            List<zzpn> list = (List) this.f73994a.b().r(new zzid(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpn zzpnVar : list) {
                if (z2 || !zzpp.N(zzpnVar.f74486c)) {
                    arrayList.add(new zzpl(zzpnVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e3) {
            e = e3;
            this.f73994a.a().o().c("Failed to get user properties. appId", zzgu.x(zzrVar.f74500a), e);
            return null;
        } catch (ExecutionException e4) {
            e = e4;
            this.f73994a.a().o().c("Failed to get user properties. appId", zzgu.x(zzrVar.f74500a), e);
            return null;
        }
    }

    final /* synthetic */ void h5(zzr zzrVar) {
        zzpg zzpgVar = this.f73994a;
        zzpgVar.E();
        zzpgVar.P0(zzrVar);
    }

    final /* synthetic */ void i5(zzr zzrVar) {
        zzpg zzpgVar = this.f73994a;
        zzpgVar.E();
        zzpgVar.Q0(zzrVar);
    }

    final /* synthetic */ void j5(zzr zzrVar, Bundle bundle, zzge zzgeVar, String str) {
        zzpg zzpgVar = this.f73994a;
        zzpgVar.E();
        try {
            zzgeVar.zze(zzpgVar.q0(zzrVar, bundle));
        } catch (RemoteException e3) {
            this.f73994a.a().o().c("Failed to return trigger URIs for app", str, e3);
        }
    }

    final /* synthetic */ void k5(String str, zzoo zzooVar, zzgh zzghVar) {
        zzpg zzpgVar = this.f73994a;
        zzpgVar.E();
        zzpgVar.b().h();
        zzpgVar.O0();
        List<zzpj> listO = zzpgVar.F0().o(str, zzooVar, ((Integer) zzfy.B.b(null)).intValue());
        ArrayList arrayList = new ArrayList();
        for (zzpj zzpjVar : listO) {
            if (zzpgVar.t(str, zzpjVar.e())) {
                int i3 = zzpjVar.i();
                if (i3 > 0) {
                    if (i3 <= ((Integer) zzfy.f73681z.b(null)).intValue()) {
                        if (zzpgVar.e().currentTimeMillis() >= zzpjVar.h() + Math.min(((Long) zzfy.f73677x.b(null)).longValue() * (1 << (i3 - 1)), ((Long) zzfy.f73679y.b(null)).longValue())) {
                        }
                    }
                    zzpgVar.a().w().d("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", str, Long.valueOf(zzpjVar.c()), Long.valueOf(zzpjVar.h()));
                }
                zzom zzomVarB = zzpjVar.b();
                try {
                    com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpk.W(com.google.android.gms.internal.measurement.zzib.zzh(), zzomVarB.f74390b);
                    for (int i4 = 0; i4 < zzhzVar.zzb(); i4++) {
                        com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzhzVar.zzc(i4).zzcl();
                        zzicVar.zzs(zzpgVar.e().currentTimeMillis());
                        zzhzVar.zzd(i4, zzicVar);
                    }
                    zzomVarB.f74390b = ((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc()).zzcc();
                    if (Log.isLoggable(zzpgVar.a().z(), 2)) {
                        zzomVarB.f74395h = zzpgVar.K0().K((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc());
                    }
                    arrayList.add(zzomVarB);
                } catch (com.google.android.gms.internal.measurement.zzmr unused) {
                    zzpgVar.a().r().b("Failed to parse queued batch. appId", str);
                }
            } else {
                zzpgVar.a().w().d("[sgtm] batch skipped due to destination in backoff. appId, rowId, url", str, Long.valueOf(zzpjVar.c()), zzpjVar.e());
            }
        }
        zzoq zzoqVar = new zzoq(arrayList);
        try {
            zzghVar.v4(zzoqVar);
            this.f73994a.a().w().c("[sgtm] Sending queued upload batches to client. appId, count", str, Integer.valueOf(zzoqVar.f74397a.size()));
        } catch (RemoteException e3) {
            this.f73994a.a().o().c("[sgtm] Failed to return upload batches for app", str, e3);
        }
    }

    final /* synthetic */ void l5(zzr zzrVar, zzaf zzafVar) {
        zzpg zzpgVar = this.f73994a;
        zzpgVar.E();
        zzpgVar.r0((String) Preconditions.m(zzrVar.f74500a), zzafVar);
    }

    final /* synthetic */ void m5(Bundle bundle, String str, zzr zzrVar) {
        zzpg zzpgVar = this.f73994a;
        boolean zH = zzpgVar.B0().H(null, zzfy.W0);
        if (bundle.isEmpty() && zH) {
            zzav zzavVarF0 = this.f73994a.F0();
            zzavVarF0.h();
            zzavVarF0.j();
            try {
                zzavVarF0.u0().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e3) {
                zzavVarF0.f73997a.a().o().b("Error clearing default event params", e3);
                return;
            }
        }
        zzav zzavVarF02 = zzpgVar.F0();
        zzavVarF02.h();
        zzavVarF02.j();
        byte[] bArrZzcc = zzavVarF02.f74388b.K0().J(new zzbb(zzavVarF02.f73997a, "", str, "dep", 0L, 0L, bundle)).zzcc();
        zzic zzicVar = zzavVarF02.f73997a;
        zzicVar.a().w().c("Saving default event parameters, appId, data size", str, Integer.valueOf(bArrZzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzcc);
        try {
            if (zzavVarF02.u0().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzicVar.a().o().b("Failed to insert default event parameters (got -1). appId", zzgu.x(str));
            }
        } catch (SQLiteException e4) {
            zzavVarF02.f73997a.a().o().c("Error storing default event parameters. appId", zzgu.x(str), e4);
        }
        zzpg zzpgVar2 = this.f73994a;
        zzav zzavVarF03 = zzpgVar2.F0();
        long j3 = zzrVar.E;
        if (zzavVarF03.H(str, j3)) {
            zzpgVar2.F0().I(str, Long.valueOf(j3), null, bundle);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void n1(zzpl zzplVar, zzr zzrVar) {
        Preconditions.m(zzplVar);
        p5(zzrVar, false);
        t5(new zziu(this, zzplVar, zzrVar));
    }

    final /* synthetic */ zzpg n5() {
        return this.f73994a;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void q4(zzr zzrVar) {
        p5(zzrVar, false);
        t5(new zzie(this, zzrVar));
    }

    final void r5(zzbg zzbgVar, zzr zzrVar) {
        zzpg zzpgVar = this.f73994a;
        zzht zzhtVarD0 = zzpgVar.D0();
        String str = zzrVar.f74500a;
        com.google.android.gms.internal.measurement.zzc zzcVar = TextUtils.isEmpty(str) ? null : (com.google.android.gms.internal.measurement.zzc) zzhtVarD0.f73857j.get(str);
        if (zzcVar == null) {
            this.f73994a.a().w().b("EES not loaded for", zzrVar.f74500a);
            o5(zzbgVar, zzrVar);
            return;
        }
        try {
            Map mapZ = zzpgVar.K0().Z(zzbgVar.f73485b.w0(), true);
            String str2 = zzbgVar.f73484a;
            String strA = zzjm.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            if (zzcVar.zzb(new com.google.android.gms.internal.measurement.zzaa(str2, zzbgVar.f73487d, mapZ))) {
                if (zzcVar.zzc()) {
                    zzpg zzpgVar2 = this.f73994a;
                    zzpgVar2.a().w().b("EES edited event", zzbgVar.f73484a);
                    o5(zzpgVar2.K0().m(zzcVar.zze().zzc()), zzrVar);
                } else {
                    o5(zzbgVar, zzrVar);
                }
                if (zzcVar.zzd()) {
                    for (com.google.android.gms.internal.measurement.zzaa zzaaVar : zzcVar.zze().zzf()) {
                        zzpg zzpgVar3 = this.f73994a;
                        zzpgVar3.a().w().b("EES logging created event", zzaaVar.zzb());
                        o5(zzpgVar3.K0().m(zzaaVar), zzrVar);
                    }
                    return;
                }
                return;
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            this.f73994a.a().o().c("EES error. appId, eventName", zzrVar.f74501b, zzbgVar.f73484a);
        }
        this.f73994a.a().w().b("EES was not applied to event", zzbgVar.f73484a);
        o5(zzbgVar, zzrVar);
    }

    final zzbg s5(zzbg zzbgVar, zzr zzrVar) {
        zzbe zzbeVar;
        if ("_cmp".equals(zzbgVar.f73484a) && (zzbeVar = zzbgVar.f73485b) != null && zzbeVar.j0() != 0) {
            String strG0 = zzbeVar.g0("_cis");
            if ("referrer broadcast".equals(strG0) || "referrer API".equals(strG0)) {
                this.f73994a.a().u().b("Event has been filtered ", zzbgVar.toString());
                return new zzbg("_cmpx", zzbeVar, zzbgVar.f73486c, zzbgVar.f73487d);
            }
        }
        return zzbgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final List t0(String str, String str2, String str3) {
        q5(str, true);
        try {
            return (List) this.f73994a.b().r(new zzim(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e3) {
            this.f73994a.a().o().b("Failed to get conditional user properties as", e3);
            return Collections.EMPTY_LIST;
        }
    }

    final void t5(Runnable runnable) {
        Preconditions.m(runnable);
        zzpg zzpgVar = this.f73994a;
        if (zzpgVar.b().p()) {
            runnable.run();
        } else {
            zzpgVar.b().t(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgb
    public final void w3(final zzr zzrVar, final Bundle bundle, final zzge zzgeVar) {
        p5(zzrVar, false);
        final String str = (String) Preconditions.m(zzrVar.f74500a);
        this.f73994a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f73972a.j5(zzrVar, bundle, zzgeVar, str);
            }
        });
    }

    final void x3(Runnable runnable) {
        Preconditions.m(runnable);
        zzpg zzpgVar = this.f73994a;
        if (zzpgVar.b().p()) {
            runnable.run();
        } else {
            zzpgVar.b().v(runnable);
        }
    }
}

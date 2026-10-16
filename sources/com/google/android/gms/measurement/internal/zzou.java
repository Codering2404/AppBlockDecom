package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzou extends zzol {
    zzou(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final String k(String str) {
        String strX = this.f74388b.D0().x(str);
        if (TextUtils.isEmpty(strX)) {
            return (String) zzfy.f73665r.b(null);
        }
        Uri uri = Uri.parse((String) zzfy.f73665r.b(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String authority = uri.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(strX).length() + 1 + String.valueOf(authority).length());
        sb.append(strX);
        sb.append(".");
        sb.append(authority);
        builderBuildUpon.authority(sb.toString());
        return builderBuildUpon.build().toString();
    }

    private static final boolean l(String str) {
        String str2 = (String) zzfy.f73669t.b(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    public final zzot i(String str) {
        zzh zzhVarJ0;
        zzpg zzpgVar = this.f74388b;
        zzh zzhVarJ02 = zzpgVar.F0().J0(str);
        zzot zzotVar = null;
        if (zzhVarJ02 == null || !zzhVarJ02.V()) {
            return new zzot(k(str), Collections.EMPTY_MAP, zzls.GOOGLE_ANALYTICS, null);
        }
        com.google.android.gms.internal.measurement.zzil zzilVarZzb = com.google.android.gms.internal.measurement.zzis.zzb();
        zzilVarZzb.zzb(2);
        zzilVarZzb.zza((com.google.android.gms.internal.measurement.zzin) Preconditions.m(com.google.android.gms.internal.measurement.zzin.zzb(zzhVarJ02.M())));
        String strP0 = zzhVarJ02.p0();
        com.google.android.gms.internal.measurement.zzgl zzglVarW = zzpgVar.D0().w(str);
        if (zzglVarW == null || (zzhVarJ0 = zzpgVar.F0().J0(str)) == null || ((!zzglVarW.zzp() || zzglVarW.zzq().zzc() != 100) && !this.f73997a.C().P(str, zzhVarJ0.l0()) && (TextUtils.isEmpty(strP0) || Math.abs(strP0.hashCode() % 100) >= zzglVarW.zzq().zzc()))) {
            zzilVarZzb.zzc(3);
            return new zzot(k(str), Collections.EMPTY_MAP, zzls.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzis) zzilVarZzb.zzbc());
        }
        String strO0 = zzhVarJ02.o0();
        zzilVarZzb.zzb(2);
        com.google.android.gms.internal.measurement.zzgl zzglVarW2 = zzpgVar.D0().w(zzhVarJ02.o0());
        if (zzglVarW2 == null || !zzglVarW2.zzp()) {
            this.f73997a.a().w().b("[sgtm] Missing sgtm_setting in remote config. appId", strO0);
            zzilVarZzb.zzc(4);
        } else {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(zzhVarJ02.l0())) {
                map.put("x-gtm-server-preview", zzhVarJ02.l0());
            }
            String strZzd = zzglVarW2.zzq().zzd();
            com.google.android.gms.internal.measurement.zzin zzinVarZzb = com.google.android.gms.internal.measurement.zzin.zzb(zzhVarJ02.M());
            if (zzinVarZzb != null && zzinVarZzb != com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE) {
                zzilVarZzb.zza(zzinVarZzb);
            } else if (l(zzhVarJ02.o0())) {
                zzilVarZzb.zza(com.google.android.gms.internal.measurement.zzin.PINNED_TO_SERVICE_UPLOAD);
            } else if (TextUtils.isEmpty(strZzd)) {
                zzilVarZzb.zza(com.google.android.gms.internal.measurement.zzin.MISSING_SGTM_SERVER_URL);
            } else {
                this.f73997a.a().w().b("[sgtm] Eligible for client side upload. appId", strO0);
                zzilVarZzb.zzb(3);
                zzilVarZzb.zza(com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE);
                zzotVar = new zzot(strZzd, map, zzls.SGTM_CLIENT, (com.google.android.gms.internal.measurement.zzis) zzilVarZzb.zzbc());
            }
            zzglVarW2.zzq().zza();
            zzglVarW2.zzq().zzb();
            zzic zzicVar = this.f73997a;
            zzicVar.c();
            if (TextUtils.isEmpty(strZzd)) {
                zzilVarZzb.zzc(6);
                zzicVar.a().w().b("[sgtm] Local service, missing sgtm_server_url", zzhVarJ02.o0());
            } else {
                zzicVar.a().w().b("[sgtm] Eligible for local service direct upload. appId", strO0);
                zzilVarZzb.zzb(5);
                zzilVarZzb.zzc(2);
                zzotVar = new zzot(strZzd, map, zzls.SGTM, (com.google.android.gms.internal.measurement.zzis) zzilVarZzb.zzbc());
            }
        }
        return zzotVar != null ? zzotVar : new zzot(k(str), Collections.EMPTY_MAP, zzls.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzis) zzilVarZzb.zzbc());
    }

    final boolean j(String str, com.google.android.gms.internal.measurement.zzin zzinVar) {
        com.google.android.gms.internal.measurement.zzgl zzglVarW;
        h();
        return (zzinVar != com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE || l(str) || (zzglVarW = this.f74388b.D0().w(str)) == null || !zzglVarW.zzp() || zzglVarW.zzq().zzd().isEmpty()) ? false : true;
    }
}

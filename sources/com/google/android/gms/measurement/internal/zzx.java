package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzic f74529a;

    public zzx(zzic zzicVar) {
        this.f74529a = zzicVar;
    }

    final void a() {
        zzic zzicVar = this.f74529a;
        zzicVar.b().h();
        if (e()) {
            if (d()) {
                zzicVar.x().f73830x.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", SDKConstants.PARAM_INTENT);
                bundle.putLong("_cc", 1L);
                zzicVar.B().t("auto", "_cmpx", bundle);
            } else {
                String strA = zzicVar.x().f73830x.a();
                if (TextUtils.isEmpty(strA)) {
                    zzicVar.a().p().a("Cache still valid but referrer not found");
                } else {
                    long jA = zzicVar.x().f73831y.a() / 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", (jA - 1) * 3600000);
                    Object obj = pair.first;
                    zzicVar.B().t(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                zzicVar.x().f73830x.b(null);
            }
            zzicVar.x().f73831y.b(0L);
        }
    }

    final void b(String str, Bundle bundle) {
        String string;
        zzic zzicVar = this.f74529a;
        zzicVar.b().h();
        if (zzicVar.g()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        zzicVar.x().f73830x.b(string);
        zzicVar.x().f73831y.b(zzicVar.e().currentTimeMillis());
    }

    final void c() {
        if (e() && d()) {
            this.f74529a.x().f73830x.b(null);
        }
    }

    final boolean d() {
        if (!e()) {
            return false;
        }
        zzic zzicVar = this.f74529a;
        return zzicVar.e().currentTimeMillis() - zzicVar.x().f73831y.a() > zzicVar.w().D(null, zzfy.f73650k0);
    }

    final boolean e() {
        return this.f74529a.x().f73831y.a() > 0;
    }
}

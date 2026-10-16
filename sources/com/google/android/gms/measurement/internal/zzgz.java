package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgz extends zzos {
    public zzgz(zzpg zzpgVar) {
        super(zzpgVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        return false;
    }

    public final boolean m() {
        j();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f73997a.d().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void n(String str, zzot zzotVar, com.google.android.gms.internal.measurement.zzib zzibVar, zzgw zzgwVar) {
        zzgz zzgzVar;
        String str2;
        URL url;
        byte[] bArrZzcc;
        h();
        j();
        try {
            url = new URI(zzotVar.a()).toURL();
            this.f74388b.K0();
            bArrZzcc = zzibVar.zzcc();
            zzgzVar = this;
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgzVar = this;
            str2 = str;
        }
        try {
            this.f73997a.b().w(new zzgy(zzgzVar, str2, url, bArrZzcc, zzotVar.b(), zzgwVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgzVar.f73997a.a().o().c("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgu.x(str2), zzotVar.a());
        }
    }

    public final void o(zzh zzhVar, Map map, zzgw zzgwVar) {
        zzgz zzgzVar;
        URL url;
        h();
        j();
        Preconditions.m(zzhVar);
        Preconditions.m(zzgwVar);
        zzou zzouVarC0 = this.f74388b.C0();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) zzfy.f73634f.b(null)).encodedAuthority((String) zzfy.f73637g.b(null)).path("config/app/".concat(String.valueOf(zzhVar.r0()))).appendQueryParameter("platform", "android");
        zzouVarC0.f73997a.w().A();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(133005L)).appendQueryParameter("runtime_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String string = builder.build().toString();
        try {
            url = new URI(string).toURL();
            zzgzVar = this;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgzVar = this;
        }
        try {
            this.f73997a.b().w(new zzgy(zzgzVar, zzhVar.o0(), url, null, map, zzgwVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgzVar.f73997a.a().o().c("Failed to parse config URL. Not fetching. appId", zzgu.x(zzhVar.o0()), string);
        }
    }
}

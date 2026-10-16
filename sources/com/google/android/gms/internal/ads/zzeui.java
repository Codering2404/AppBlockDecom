package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.LegacyTokenHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeui implements zzfci {
    final zzfky zza;
    private final long zzb;
    private final long zzc;

    public zzeui(zzfky zzfkyVar, long j3, long j4) {
        this.zza = zzfkyVar;
        this.zzb = j3;
        this.zzc = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfky zzfkyVar = this.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfkyVar.zzd;
        bundle.putInt("http_timeout_millis", zzmVar.f69986x);
        bundle.putString("slotname", zzfkyVar.zzg);
        int i3 = zzfkyVar.zzp.zza;
        if (i3 == 0) {
            throw null;
        }
        int i4 = i3 - 1;
        if (i4 == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i4 == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        long j3 = this.zzb;
        bundle.putLong("start_signals_timestamp", j3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoX)).booleanValue()) {
            bundle.putLong("tsi", j3 - this.zzc);
        }
        zzfln.zzd(bundle, "is_sdk_preload", true, zzmVar.zzc());
        zzfln.zzb(bundle, "prefetch_type", "zenith_v2", zzmVar.zzd());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        long j4 = zzmVar.f69965b;
        zzfln.zzb(bundle, "cust_age", simpleDateFormat.format(new Date(j4)), j4 != -1);
        zzfln.zzf(bundle, "extras", zzmVar.f69966c);
        int i5 = zzmVar.f69967d;
        zzfln.zzc(bundle, "cust_gender", i5, i5 != -1);
        zzfln.zzg(bundle, "kw", zzmVar.f69968f);
        int i6 = zzmVar.f69970h;
        zzfln.zzc(bundle, "tag_for_child_directed_treatment", i6, i6 != -1);
        if (zzmVar.f69969g) {
            bundle.putBoolean("test_request", true);
        }
        bundle.putInt("ppt_p13n", zzmVar.f69988z);
        int i7 = zzmVar.f69964a;
        zzfln.zzc(bundle, "d_imp_hdr", 1, i7 >= 2 && zzmVar.f69971i);
        String str = zzmVar.f69972j;
        zzfln.zzb(bundle, "ppid", str, i7 >= 2 && !TextUtils.isEmpty(str));
        Location location = zzmVar.f69974l;
        if (location != null) {
            float accuracy = location.getAccuracy() * 1000.0f;
            long time = location.getTime() * 1000;
            double latitude = location.getLatitude() * 1.0E7d;
            double longitude = 1.0E7d * location.getLongitude();
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", accuracy);
            bundle2.putLong("lat", (long) latitude);
            bundle2.putLong(LegacyTokenHelper.TYPE_LONG, (long) longitude);
            bundle2.putLong("time", time);
            bundle.putBundle("uule", bundle2);
        }
        zzfln.zze(bundle, "url", zzmVar.f69975m);
        zzfln.zzg(bundle, "neighboring_content_urls", zzmVar.f69985w);
        zzfln.zzf(bundle, "custom_targeting", zzmVar.f69977o);
        zzfln.zzg(bundle, "category_exclusions", zzmVar.f69978p);
        zzfln.zze(bundle, "request_agent", zzmVar.f69979q);
        zzfln.zze(bundle, "request_pkg", zzmVar.f69980r);
        zzfln.zzd(bundle, "is_designed_for_families", zzmVar.f69981s, i7 >= 7);
        if (i7 >= 8) {
            int i8 = zzmVar.f69983u;
            zzfln.zzc(bundle, "tag_for_under_age_of_consent", i8, i8 != -1);
            zzfln.zze(bundle, "max_ad_content_rating", zzmVar.f69984v);
        }
        Bundle bundle3 = zzfkyVar.zze;
        zzfln.zzh(bundle, "plcs", Integer.valueOf(bundle3.getInt("plcs")));
        zzfln.zzh(bundle, "plbs", Integer.valueOf(bundle3.getInt("plbs")));
        zzfln.zze(bundle, "plid", bundle3.getString("plid"));
        zzfln.zzc(bundle, "s2s_rr", 1, zzfkyVar.zzv && !(zzmVar.f69982t == null && zzmVar.f69987y == null));
    }
}

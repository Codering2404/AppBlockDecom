package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.client.zzex;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbzs;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class QueryInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzex f70823a;

    public QueryInfo(zzex zzexVar) {
        this.f70823a = zzexVar;
    }

    public static void a(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        c(context, adFormat, adRequest, null, queryInfoGenerationCallback);
    }

    private static void c(final Context context, final AdFormat adFormat, final AdRequest adRequest, final String str, final QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzj.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.query.zza
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AdRequest adRequest2 = adRequest;
                        zzeh zzehVarA = adRequest2 == null ? null : adRequest2.a();
                        new zzbzs(context, adFormat, zzehVarA, str).zzb(queryInfoGenerationCallback);
                    }
                });
                return;
            }
        }
        new zzbzs(context, adFormat, adRequest == null ? null : adRequest.a(), str).zzb(queryInfoGenerationCallback);
    }

    public String b() {
        return this.f70823a.a();
    }
}

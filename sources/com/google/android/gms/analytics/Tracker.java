package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzbu;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzfb;
import com.google.android.gms.internal.gtm.zzft;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Tracker extends zzbu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f70878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f70879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f70880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzfb f70881d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzv f70882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzft f70883g;

    Tracker(zzbx zzbxVar, String str, zzfb zzfbVar) {
        super(zzbxVar);
        HashMap map = new HashMap();
        this.f70879b = map;
        this.f70880c = new HashMap();
        if (str != null) {
            map.put("&tid", str);
        }
        map.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        map.put("&a", Integer.toString(new Random().nextInt(Api.BaseClientBuilder.API_PRIORITY_OTHER) + 1));
        this.f70881d = new zzfb(60, 2000L, "tracking", zzC());
        this.f70882f = new zzv(this, zzbxVar);
    }

    private static String M(Map.Entry entry) {
        String str = (String) entry.getKey();
        if (!str.startsWith("&") || str.length() < 2) {
            return null;
        }
        return ((String) entry.getKey()).substring(1);
    }

    private static void j(Map map, Map map2) {
        Preconditions.m(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String strM = M(entry);
            if (strM != null) {
                map2.put(strM, (String) entry.getValue());
            }
        }
    }

    public void b(boolean z2) {
        this.f70878a = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0 A[Catch: all -> 0x0123, TRY_ENTER, TryCatch #0 {all -> 0x0123, blocks: (B:38:0x00cd, B:54:0x0114, B:49:0x00f0, B:53:0x0109), top: B:66:0x00cd }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:62:0x0128
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(java.util.Map r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.c(java.util.Map):void");
    }

    public void f(String str, String str2) {
        Preconditions.n(str, "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f70879b.put(str, str2);
    }

    public void i(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter("referrer");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        Uri uri2 = Uri.parse("http://hostname/?".concat(String.valueOf(queryParameter)));
        String queryParameter2 = uri2.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.f70880c.put("&ci", queryParameter2);
        }
        String queryParameter3 = uri2.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.f70880c.put("&anid", queryParameter3);
        }
        String queryParameter4 = uri2.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.f70880c.put("&cn", queryParameter4);
        }
        String queryParameter5 = uri2.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.f70880c.put("&cc", queryParameter5);
        }
        String queryParameter6 = uri2.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.f70880c.put("&cm", queryParameter6);
        }
        String queryParameter7 = uri2.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.f70880c.put("&cs", queryParameter7);
        }
        String queryParameter8 = uri2.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.f70880c.put("&ck", queryParameter8);
        }
        String queryParameter9 = uri2.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.f70880c.put("&dclid", queryParameter9);
        }
        String queryParameter10 = uri2.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.f70880c.put("&gclid", queryParameter10);
        }
        String queryParameter11 = uri2.getQueryParameter("aclid");
        if (queryParameter11 != null) {
            this.f70880c.put("&aclid", queryParameter11);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.f70882f.zzW();
        String strZza = zzB().zza();
        if (strZza != null) {
            f("&an", strZza);
        }
        String strZzb = zzB().zzb();
        if (strZzb != null) {
            f("&av", strZzb);
        }
    }
}

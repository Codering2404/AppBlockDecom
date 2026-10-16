package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzecr;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f70254a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f70255b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f70256c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f70257d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f70258e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f70259f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzecr f70260g;

    /* JADX WARN: Multi-variable type inference failed */
    protected static final String o(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put(GraphRequest.USER_AGENT_HEADER, com.google.android.gms.ads.internal.zzt.g().P(context, str2));
        ListenableFuture listenableFutureB = new zzbl(context).b(0, str, map, null);
        try {
            return (String) listenableFutureB.get(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfW)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            String strValueOf = String.valueOf(str);
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Interrupted while retrieving a response from: ".concat(strValueOf), e3);
            listenableFutureB.cancel(true);
            return null;
        } catch (TimeoutException e4) {
            String strValueOf2 = String.valueOf(str);
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Timeout while retrieving a response from: ".concat(strValueOf2), e4);
            listenableFutureB.cancel(true);
            return null;
        } catch (Exception e5) {
            String strValueOf3 = String.valueOf(str);
            int i5 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error retrieving a response from: ".concat(strValueOf3), e5);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[Catch: all -> 0x0029, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0013, B:7:0x0018, B:12:0x0034, B:14:0x003c, B:16:0x0051, B:19:0x0063, B:11:0x002b, B:20:0x006a, B:21:0x006c), top: B:26:0x000b, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.net.Uri p(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            android.net.Uri r6 = android.net.Uri.parse(r6)
            android.net.Uri$Builder r6 = r6.buildUpon()
            java.lang.Object r0 = r4.f70254a
            monitor-enter(r0)
            java.lang.String r1 = r4.f70255b     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L6a
            com.google.android.gms.ads.internal.zzt.g()     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = "debug_signals_id.txt"
            java.io.FileInputStream r1 = r5.openFileInput(r1)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r3 = 1
            byte[] r1 = com.google.android.gms.common.util.IOUtils.e(r1, r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            goto L34
        L29:
            r5 = move-exception
            goto L81
        L2b:
            java.lang.String r1 = "Error reading from internal storage."
            int r2 = com.google.android.gms.ads.internal.util.zze.f70328b     // Catch: java.lang.Throwable -> L29
            com.google.android.gms.ads.internal.util.client.zzo.a(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = ""
        L34:
            r4.f70255b = r2     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L6a
            com.google.android.gms.ads.internal.zzt.g()     // Catch: java.lang.Throwable -> L29
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L29
            r4.f70255b = r1     // Catch: java.lang.Throwable -> L29
            com.google.android.gms.ads.internal.zzt.g()     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r4.f70255b     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = "debug_signals_id.txt"
            r3 = 0
            java.io.FileOutputStream r5 = r5.openFileOutput(r2, r3)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L62
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L62
            byte[] r1 = r1.getBytes(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L62
            r5.write(r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L62
            r5.close()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L62
            goto L6a
        L62:
            r5 = move-exception
            java.lang.String r1 = "Error writing to file in internal storage."
            int r2 = com.google.android.gms.ads.internal.util.zze.f70328b     // Catch: java.lang.Throwable -> L29
            com.google.android.gms.ads.internal.util.client.zzo.d(r1, r5)     // Catch: java.lang.Throwable -> L29
        L6a:
            java.lang.String r5 = r4.f70255b     // Catch: java.lang.Throwable -> L29
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = "linkedDeviceId"
            r6.appendQueryParameter(r0, r5)
            java.lang.String r5 = "adSlotPath"
            r6.appendQueryParameter(r5, r7)
            java.lang.String r5 = "afmaVersion"
            r6.appendQueryParameter(r5, r8)
            android.net.Uri r5 = r6.build()
            return r5
        L81:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzax.p(android.content.Context, java.lang.String, java.lang.String, java.lang.String):android.net.Uri");
    }

    public final void a(zzecr zzecrVar) {
        this.f70260g = zzecrVar;
    }

    public final zzecr b() {
        return this.f70260g;
    }

    public final void c(Context context) {
        zzecr zzecrVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue() || (zzecrVar = this.f70260g) == null) {
            return;
        }
        zzecrVar.zzo(new zzau(this, context), zzecq.DEBUG_MENU);
    }

    final boolean d(Context context, String str, String str2) {
        String strO = o(context, p(context, (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfT), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strO)) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strO.trim());
            String strOptString = jSONObject.optString("gct");
            this.f70259f = jSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
                String str3 = this.f70259f;
                boolean z2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3) || "2".equals(str3);
                j(z2);
                zzg zzgVarZzo = com.google.android.gms.ads.internal.zzt.l().zzo();
                if (!z2) {
                    str = "";
                }
                zzgVarZzo.g(str);
            }
            synchronized (this.f70254a) {
                this.f70256c = strOptString;
            }
            return true;
        } catch (JSONException e3) {
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to get in app preview response json.", e3);
            return false;
        }
    }

    public final boolean e(Context context, String str, String str2) {
        String strO = o(context, p(context, (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfU), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strO)) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(new JSONObject(strO.trim()).optString("debug_mode"));
            j(zEquals);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
                zzg zzgVarZzo = com.google.android.gms.ads.internal.zzt.l().zzo();
                if (true != zEquals) {
                    str = "";
                }
                zzgVarZzo.g(str);
            }
            return zEquals;
        } catch (JSONException e3) {
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to get debug mode response json.", e3);
            return false;
        }
    }

    public final void f(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzt.g();
        zzs.z(context, p(context, (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfS), str, str2));
    }

    public final boolean g(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !m()) {
            return false;
        }
        int i3 = zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Sending troubleshooting signals to the server.");
        h(context, str, str2, str3);
        return true;
    }

    public final void h(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = p(context, (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfV), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzt.g();
        zzs.o(context, str, builderBuildUpon.build().toString());
    }

    public final String i() {
        String str;
        synchronized (this.f70254a) {
            str = this.f70256c;
        }
        return str;
    }

    public final void j(boolean z2) {
        synchronized (this.f70254a) {
            try {
                this.f70258e = z2;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.l().zzo().zzK(z2);
                    zzecr zzecrVar = this.f70260g;
                    if (zzecrVar != null) {
                        zzecrVar.zzb(z2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k() {
        boolean z2;
        synchronized (this.f70254a) {
            z2 = this.f70258e;
        }
        return z2;
    }

    public final void l(boolean z2) {
        synchronized (this.f70254a) {
            this.f70257d = z2;
        }
    }

    public final boolean m() {
        boolean z2;
        synchronized (this.f70254a) {
            z2 = this.f70257d;
        }
        return z2;
    }

    protected final void n(Context context, String str, boolean z2, boolean z3) {
        if (context instanceof Activity) {
            zzs.f70374l.post(new zzaw(this, context, str, z2, z3));
        } else {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Can not create dialog without Activity Context");
        }
    }
}

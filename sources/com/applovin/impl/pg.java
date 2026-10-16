package com.applovin.impl;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class pg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f62435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f62436b = com.applovin.impl.sdk.j.m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f62437c;

    public pg(com.applovin.impl.sdk.j jVar) {
        this.f62435a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.f62437c != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f62436b.getResources().openRawResource(R.raw.omsdk_v1_4_12)));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            this.f62437c = sb.toString();
                            bufferedReader.close();
                            return;
                        }
                        sb.append(line);
                    }
                } catch (IOException e3) {
                    Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e3);
                }
            } catch (Throwable th) {
                try {
                    Log.e("OpenMeasurementService", "Failed to load JavaScript Open Measurement SDK", th);
                    bufferedReader.close();
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e4);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.f62435a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62435a.I().a("OpenMeasurementService", "Failed to retrieve resource omsdk_v1_4_12.js", th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.f62436b);
        this.f62435a.I();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVarI = this.f62435a.I();
            StringBuilder sb = new StringBuilder();
            sb.append("Init ");
            sb.append(d() ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
            sb.append(" and took ");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb.append("ms");
            nVarI.a("OpenMeasurementService", sb.toString());
        }
        h();
    }

    private void h() {
        this.f62435a.i0().a((yl) new jn(this.f62435a, "OpenMeasurementService", new Runnable() { // from class: com.applovin.impl.p00
            @Override // java.lang.Runnable
            public final void run() {
                this.f62399a.f();
            }
        }), tm.b.OTHER);
    }

    public String c() {
        return Omid.getVersion();
    }

    public boolean d() {
        return Omid.isActive();
    }

    public boolean e() {
        String str = this.f62435a.f0().getExtraParameters().get("enable_omsdk_testing");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    public void i() {
        if (((Boolean) this.f62435a.a(sj.f63738f0)).booleanValue()) {
            this.f62435a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62435a.I().a("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.q00
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62548a.g();
                }
            });
        }
    }

    public String a() {
        return this.f62437c;
    }

    public Partner b() {
        return Partner.createPartner((String) this.f62435a.a(sj.f63742g0), AppLovinSdk.VERSION);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.e()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L19
            com.applovin.impl.sdk.j r0 = r4.f62435a     // Catch: java.lang.Throwable -> L17
            java.lang.String r0 = com.applovin.impl.qg.a(r0)     // Catch: java.lang.Throwable -> L17
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L19
            java.lang.String r0 = com.iab.omid.library.applovin.ScriptInjector.injectScriptContentIntoHtml(r0, r5)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r0 = move-exception
            goto L21
        L19:
            r0 = r5
        L1a:
            java.lang.String r1 = r4.f62437c     // Catch: java.lang.Throwable -> L17
            java.lang.String r5 = com.iab.omid.library.applovin.ScriptInjector.injectScriptContentIntoHtml(r1, r0)     // Catch: java.lang.Throwable -> L17
            return r5
        L21:
            com.applovin.impl.sdk.j r1 = r4.f62435a
            r1.I()
            boolean r1 = com.applovin.impl.sdk.n.a()
            if (r1 == 0) goto L39
            com.applovin.impl.sdk.j r1 = r4.f62435a
            com.applovin.impl.sdk.n r1 = r1.I()
            java.lang.String r2 = "OpenMeasurementService"
            java.lang.String r3 = "Failed to inject JavaScript SDK into HTML"
            r1.a(r2, r3, r0)
        L39:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.pg.a(java.lang.String):java.lang.String");
    }
}

package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CustomTabsClient f58822b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends CustomTabsServiceConnection {
        a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            c5.this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                c5.this.f58821a.I().a("CustomTabsManager", "Connection successful: " + componentName);
            }
            c5.this.f58822b = customTabsClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c5.this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                c5.this.f58821a.I().a("CustomTabsManager", "Service disconnected: " + componentName);
            }
            c5.this.f58822b = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b extends CustomTabsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f58824a;

        public b(com.applovin.impl.adview.a aVar) {
            this.f58824a = new WeakReference(aVar);
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i3, Bundle bundle) {
            com.applovin.impl.adview.a aVar = (com.applovin.impl.adview.a) this.f58824a.get();
            if (aVar == null) {
                c5.this.f58821a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    c5.this.f58821a.I().b("CustomTabsManager", "Unable to track navigation event (" + i3 + "). Controller is null.");
                }
                return;
            }
            com.applovin.impl.sdk.ad.b bVarI = aVar.i();
            if (bVarI == null) {
                c5.this.f58821a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    c5.this.f58821a.I().b("CustomTabsManager", "Unable to track navigation event (" + i3 + "). No ad specified.");
                    return;
                }
                return;
            }
            switch (i3) {
                case 1:
                    if (bVarI.T0()) {
                        c5.this.f58821a.j().trackCustomTabsNavigationStarted(bVarI);
                    }
                    break;
                case 2:
                    if (bVarI.T0()) {
                        c5.this.f58821a.j().trackCustomTabsNavigationFinished(bVarI);
                    }
                    break;
                case 3:
                    if (bVarI.T0()) {
                        c5.this.f58821a.j().trackCustomTabsNavigationFailed(bVarI);
                    }
                    break;
                case 4:
                    if (bVarI.T0()) {
                        c5.this.f58821a.j().trackCustomTabsNavigationAborted(bVarI);
                    }
                    break;
                case 5:
                    if (bVarI.T0()) {
                        c5.this.f58821a.j().trackCustomTabsTabShown(bVarI);
                    }
                    fc.c(aVar.e(), bVarI, aVar.k());
                    break;
                case 6:
                    if (bVarI.T0()) {
                        c5.this.f58821a.j().trackCustomTabsTabHidden(bVarI);
                    }
                    fc.a(aVar.e(), bVarI, aVar.k());
                    break;
                default:
                    c5.this.f58821a.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        c5.this.f58821a.I().a("CustomTabsManager", "Unknown navigation event: " + i3);
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i3, Uri uri, boolean z2, Bundle bundle) {
            c5.this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVarI = c5.this.f58821a.I();
                StringBuilder sb = new StringBuilder();
                sb.append("Validation ");
                sb.append(z2 ? rnFwbPAQmQTnL.HqzwsnXd : "failed");
                sb.append(" for session-URL relation(");
                sb.append(i3);
                sb.append("), requestedOrigin(");
                sb.append(uri);
                sb.append(")");
                nVarI.a("CustomTabsManager", sb.toString());
            }
        }
    }

    public c5(com.applovin.impl.sdk.j jVar) {
        this.f58821a = jVar;
    }

    public void b(final List list, final CustomTabsSession customTabsSession) {
        if (list.isEmpty()) {
            return;
        }
        if (customTabsSession != null) {
            a("warmup urls", new Runnable() { // from class: com.applovin.impl.hu
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60257a.a(list, customTabsSession);
                }
            });
            return;
        }
        this.f58821a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f58821a.I().a("CustomTabsManager", "Custom Tabs session is null, cannot warmup urls");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.LinkedList r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Retrying with next package name..."
            java.lang.String r1 = "CustomTabsManager"
            r2 = 0
            android.content.Context r3 = com.applovin.impl.sdk.j.m()     // Catch: java.lang.Throwable -> L31
            java.lang.Object r4 = r7.poll()     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L31
            com.applovin.impl.c5$a r5 = new com.applovin.impl.c5$a     // Catch: java.lang.Throwable -> L31
            r5.<init>()     // Catch: java.lang.Throwable -> L31
            boolean r2 = androidx.browser.customtabs.CustomTabsClient.a(r3, r4, r5)     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L33
            com.applovin.impl.sdk.j r3 = r6.f58821a     // Catch: java.lang.Throwable -> L31
            r3.I()     // Catch: java.lang.Throwable -> L31
            boolean r3 = com.applovin.impl.sdk.n.a()     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L33
            com.applovin.impl.sdk.j r3 = r6.f58821a     // Catch: java.lang.Throwable -> L31
            com.applovin.impl.sdk.n r3 = r3.I()     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = "Custom Tabs service not available"
            r3.b(r1, r4)     // Catch: java.lang.Throwable -> L31
            goto L33
        L31:
            r3 = move-exception
            goto L47
        L33:
            if (r2 != 0) goto L7f
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L7f
            com.applovin.impl.sdk.j r2 = r6.f58821a
            r2.I()
            boolean r2 = com.applovin.impl.sdk.n.a()
            if (r2 == 0) goto L7c
            goto L73
        L47:
            com.applovin.impl.sdk.j r4 = r6.f58821a     // Catch: java.lang.Throwable -> L5e
            r4.I()     // Catch: java.lang.Throwable -> L5e
            boolean r4 = com.applovin.impl.sdk.n.a()     // Catch: java.lang.Throwable -> L5e
            if (r4 == 0) goto L60
            com.applovin.impl.sdk.j r4 = r6.f58821a     // Catch: java.lang.Throwable -> L5e
            com.applovin.impl.sdk.n r4 = r4.I()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r5 = "Failed to bind to service"
            r4.a(r1, r5, r3)     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r3 = move-exception
            goto L80
        L60:
            if (r2 != 0) goto L7f
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L7f
            com.applovin.impl.sdk.j r2 = r6.f58821a
            r2.I()
            boolean r2 = com.applovin.impl.sdk.n.a()
            if (r2 == 0) goto L7c
        L73:
            com.applovin.impl.sdk.j r2 = r6.f58821a
            com.applovin.impl.sdk.n r2 = r2.I()
            r2.a(r1, r0)
        L7c:
            r6.a(r7)
        L7f:
            return
        L80:
            if (r2 != 0) goto L9f
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L9f
            com.applovin.impl.sdk.j r2 = r6.f58821a
            r2.I()
            boolean r2 = com.applovin.impl.sdk.n.a()
            if (r2 == 0) goto L9c
            com.applovin.impl.sdk.j r2 = r6.f58821a
            com.applovin.impl.sdk.n r2 = r2.I()
            r2.a(r1, r0)
        L9c:
            r6.a(r7)
        L9f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.c5.a(java.util.LinkedList):void");
    }

    public void a() {
        if (((Boolean) this.f58821a.a(sj.r6)).booleanValue() && this.f58822b == null) {
            String strE = CustomTabsClient.e(com.applovin.impl.sdk.j.m(), this.f58821a.c(sj.s6), true);
            String strD = CustomTabsClient.d(com.applovin.impl.sdk.j.m(), null);
            LinkedList linkedList = new LinkedList();
            if (((Boolean) this.f58821a.a(sj.t6)).booleanValue()) {
                CollectionUtils.addUniqueObjectIfExists(strD, linkedList);
                CollectionUtils.addUniqueObjectIfExists(strE, linkedList);
            } else {
                CollectionUtils.addUniqueObjectIfExists(strE, linkedList);
                CollectionUtils.addUniqueObjectIfExists(strD, linkedList);
            }
            if (linkedList.isEmpty()) {
                this.f58821a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58821a.I().b("CustomTabsManager", "Unable to find a supported Custom Tabs package name");
                    return;
                }
                return;
            }
            a(linkedList);
        }
    }

    private CustomTabsIntent a(com.applovin.impl.adview.a aVar, Activity activity) {
        this.f58821a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f58821a.I().a("CustomTabsManager", "Creating Custom Tabs intent");
        }
        com.applovin.impl.sdk.ad.b bVarI = aVar.i();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(aVar.j());
        d5 d5VarX = bVarI != null ? bVarI.x() : null;
        if (((Boolean) this.f58821a.a(sj.u6)).booleanValue()) {
            int i3 = R.anim.applovin_slide_up_animation;
            int i4 = R.anim.applovin_slide_down_animation;
            builder.t(activity, i3, i4);
            builder.j(activity, i3, i4);
        }
        if (d5VarX != null) {
            Integer numH = d5VarX.h();
            if (numH != null) {
                builder.h(new CustomTabColorSchemeParams.Builder().b(numH.intValue()).a());
            }
            Integer numA = d5VarX.a();
            if (numA != null) {
                builder.f(2, new CustomTabColorSchemeParams.Builder().b(numA.intValue()).a());
            }
            Boolean boolI = d5VarX.i();
            if (boolI != null) {
                builder.v(boolI.booleanValue());
            }
            Boolean boolG = d5VarX.g();
            if (boolG != null) {
                builder.s(boolG.booleanValue());
            }
            Boolean boolC = d5VarX.c();
            if (boolC != null) {
                builder.m(boolC.booleanValue());
            }
            Integer numF = d5VarX.f();
            if (numF != null) {
                builder.r(numF.intValue());
            }
        }
        CustomTabsIntent customTabsIntentA = builder.a();
        if (d5VarX != null) {
            String strD = d5VarX.d();
            if (strD != null) {
                customTabsIntentA.f2637a.putExtra("android.intent.extra.REFERRER", Uri.parse(strD));
            }
            Bundle bundleS = bVarI.s();
            if (!bundleS.isEmpty()) {
                customTabsIntentA.f2637a.putExtra("com.android.browser.headers", bundleS);
            }
        }
        return customTabsIntentA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.adview.a aVar, Activity activity, String str) {
        a(aVar, activity).a(activity, Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, CustomTabsSession customTabsSession) {
        this.f58822b.h(0L);
        d5 d5VarX = bVar.x();
        if (d5VarX == null) {
            return;
        }
        Integer numE = d5VarX.e();
        String strB = d5VarX.b();
        if (numE == null || TextUtils.isEmpty(strB)) {
            return;
        }
        if (customTabsSession == null) {
            this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58821a.I().b("CustomTabsManager", "Cannot validate session-URL relation because the session is null");
                return;
            }
            return;
        }
        this.f58821a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f58821a.I().a("CustomTabsManager", "Validating session-URL relation: " + numE + " with digital asset link: " + strB);
        }
        customTabsSession.k(numE.intValue(), Uri.parse(strB), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, CustomTabsSession customTabsSession) {
        this.f58821a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f58821a.I().a("CustomTabsManager", "Warming up URLs: " + list);
        }
        String str = (String) list.remove(0);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.customtabs.otherurls.URL", Uri.parse(str2));
            arrayList.add(bundle);
        }
        boolean zG = customTabsSession.g(Uri.parse(str), null, arrayList);
        this.f58821a.I();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVarI = this.f58821a.I();
            StringBuilder sb = new StringBuilder();
            sb.append("Warmup for URLs ");
            sb.append(zG ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
            nVarI.a("CustomTabsManager", sb.toString());
        }
    }

    public void a(final String str, final com.applovin.impl.adview.a aVar, final Activity activity) {
        a("launch url", new Runnable() { // from class: com.applovin.impl.gu
            @Override // java.lang.Runnable
            public final void run() {
                this.f60053a.a(aVar, activity, str);
            }
        });
    }

    private void a(String str, Runnable runnable) {
        try {
            this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58821a.I().a("CustomTabsManager", "Running operation: " + str);
            }
            runnable.run();
            this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58821a.I().a("CustomTabsManager", "Finished operation: " + str);
            }
        } catch (Throwable th) {
            this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58821a.I().a("CustomTabsManager", "Failed to run operation: " + str, th);
            }
            this.f58821a.D().a("CustomTabsManager", str, th);
        }
    }

    public CustomTabsSession a(com.applovin.impl.adview.a aVar) {
        if (this.f58822b == null) {
            this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58821a.I().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f58821a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f58821a.I().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            CustomTabsSession customTabsSessionF = this.f58822b.f(new b(aVar));
            a(customTabsSessionF, aVar.i());
            return customTabsSessionF;
        } catch (Exception e3) {
            this.f58821a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58821a.I().a("CustomTabsManager", "Failed to create Custom Tabs session", e3);
            }
            return null;
        }
    }

    private void a(final CustomTabsSession customTabsSession, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null || !bVar.B0()) {
            return;
        }
        a("client warmup", new Runnable() { // from class: com.applovin.impl.iu
            @Override // java.lang.Runnable
            public final void run() {
                this.f60533a.a(bVar, customTabsSession);
            }
        });
    }
}

package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.m3;
import com.applovin.impl.privacy.cmp.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinCmpService;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CmpServiceImpl implements AppLovinCmpService, a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f62484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m3 f62485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.applovin.impl.privacy.cmp.a f62486c = b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f62487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f62488e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppLovinCmpService.OnCompletedListener f62489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f62490b;

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.CmpServiceImpl$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0116a implements e {
            C0116a() {
            }

            @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
            public void a(AppLovinCmpError appLovinCmpError) {
                a.this.f62489a.onCompleted(appLovinCmpError);
            }
        }

        a(AppLovinCmpService.OnCompletedListener onCompletedListener, Activity activity) {
            this.f62489a = onCompletedListener;
            this.f62490b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.d
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError != null) {
                this.f62489a.onCompleted(appLovinCmpError);
            } else {
                CmpServiceImpl.this.showCmp(this.f62490b, new C0116a());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f62493a;

        b(Activity activity) {
            this.f62493a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            CmpServiceImpl.this.f62486c.a(this.f62493a, CmpServiceImpl.this.f62485b, CmpServiceImpl.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f62495a;

        c(Activity activity) {
            this.f62495a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            CmpServiceImpl.this.f62486c.b(this.f62495a, CmpServiceImpl.this.f62485b, CmpServiceImpl.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface d {
        void a(AppLovinCmpError appLovinCmpError);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface e {
        void a(AppLovinCmpError appLovinCmpError);
    }

    public CmpServiceImpl(j jVar) {
        this.f62484a = jVar;
        this.f62485b = new m3(jVar.u().e());
    }

    private void c() {
        if (hasSupportedCmp()) {
            this.f62486c.c();
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public boolean hasSupportedCmp() {
        return this.f62486c != null;
    }

    public void loadCmp(Activity activity, d dVar) {
        if (!hasSupportedCmp()) {
            dVar.a(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
            return;
        }
        this.f62487d = dVar;
        b bVar = new b(activity);
        if (this.f62486c.d()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            bVar.run();
        }
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowHidden(Bundle bundle) {
        b((AppLovinCmpError) null);
        a();
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl) {
        a(cmpErrorImpl);
        a();
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowLoaded(Bundle bundle) {
        a((AppLovinCmpError) null);
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowShowFailed(CmpErrorImpl cmpErrorImpl) {
        b(cmpErrorImpl);
        a();
    }

    public void showCmp(Activity activity, e eVar) {
        c cVar = new c(activity);
        this.f62488e = eVar;
        if (this.f62486c.e()) {
            AppLovinSdkUtils.runOnUiThread(cVar);
        } else {
            cVar.run();
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public void showCmpForExistingUser(Activity activity, AppLovinCmpService.OnCompletedListener onCompletedListener) {
        this.f62484a.I();
        if (n.a()) {
            this.f62484a.I().a("AppLovinCmpService", "showCmpForExistingUser(activity=" + activity + ", completedListener=" + onCompletedListener + ")");
        }
        if (!hasSupportedCmp()) {
            onCompletedListener.onCompleted(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
        } else {
            c();
            loadCmp(activity, new a(onCompletedListener, activity));
        }
    }

    public String toString() {
        return "[CmpService]";
    }

    private void a(AppLovinCmpError appLovinCmpError) {
        d dVar = this.f62487d;
        if (dVar == null) {
            return;
        }
        dVar.a(appLovinCmpError);
        this.f62487d = null;
    }

    private void b(AppLovinCmpError appLovinCmpError) {
        e eVar = this.f62488e;
        if (eVar == null) {
            return;
        }
        eVar.a(appLovinCmpError);
        this.f62488e = null;
    }

    private void a() {
        com.applovin.impl.privacy.cmp.a aVar = this.f62486c;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    private com.applovin.impl.privacy.cmp.a b() {
        if (yp.a("com.google.android.ump.ConsentForm")) {
            return new com.applovin.impl.privacy.cmp.a(this.f62484a);
        }
        if (!this.f62484a.u().j()) {
            return null;
        }
        n.h("AppLovinSdk", "Could not load Google UMP. Please add the Google User Messaging Platform SDK into your application. Instructions can be found here: https://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow#enabling-google-ump");
        return null;
    }
}

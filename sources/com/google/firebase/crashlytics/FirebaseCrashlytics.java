package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.BuildIdInfo;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import d.qFm.sECyKyO;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseCrashlytics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CrashlyticsCore f88266a;

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.f88266a = crashlyticsCore;
    }

    public static FirebaseCrashlytics c() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.m().j(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    public boolean b() {
        return this.f88266a.j();
    }

    public void e(String str) {
        this.f88266a.q(str);
    }

    public void f(Throwable th) {
        if (th == null) {
            Logger.f().k("A null value was passed to recordException. Ignoring.");
        } else {
            this.f88266a.r(th, Collections.EMPTY_MAP);
        }
    }

    public void g(boolean z2) {
        this.f88266a.v(Boolean.valueOf(z2));
    }

    public void h(String str, int i3) {
        this.f88266a.w(str, Integer.toString(i3));
    }

    public void i(String str, String str2) {
        this.f88266a.w(str, str2);
    }

    public void j(String str) {
        this.f88266a.x(str);
    }

    static FirebaseCrashlytics d(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Deferred deferred, Deferred deferred2, Deferred deferred3, ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3) {
        Context contextL = firebaseApp.l();
        String packageName = contextL.getPackageName();
        Logger.f().g("Initializing Firebase Crashlytics " + CrashlyticsCore.o() + " for " + packageName);
        CrashlyticsWorkers crashlyticsWorkers = new CrashlyticsWorkers(executorService, executorService2);
        FileStore fileStore = new FileStore(contextL);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        IdManager idManager = new IdManager(contextL, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred2);
        CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber = new CrashlyticsAppQualitySessionsSubscriber(dataCollectionArbiter, fileStore);
        FirebaseSessionsDependencies.e(crashlyticsAppQualitySessionsSubscriber);
        CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, analyticsDeferredProxy.e(), analyticsDeferredProxy.d(), fileStore, crashlyticsAppQualitySessionsSubscriber, new RemoteConfigDeferredProxy(deferred3), crashlyticsWorkers);
        String strC = firebaseApp.p().c();
        String strM = CommonUtils.m(contextL);
        List<BuildIdInfo> listJ = CommonUtils.j(contextL);
        Logger.f().b("Mapping file ID is: " + strM);
        for (BuildIdInfo buildIdInfo : listJ) {
            Logger.f().b(String.format(sECyKyO.HEvU, buildIdInfo.c(), buildIdInfo.a(), buildIdInfo.b()));
        }
        try {
            AppData appDataA = AppData.a(contextL, idManager, strC, strM, listJ, new DevelopmentPlatformProvider(contextL));
            Logger.f().i("Installer package name is: " + appDataA.f88301d);
            SettingsController settingsControllerL = SettingsController.l(contextL, strC, idManager, new HttpRequestFactory(), appDataA.f88303f, appDataA.f88304g, fileStore, dataCollectionArbiter);
            settingsControllerL.o(crashlyticsWorkers).addOnFailureListener(executorService3, new OnFailureListener() { // from class: com.google.firebase.crashlytics.e
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Logger.f().e("Error fetching settings.", exc);
                }
            });
            if (crashlyticsCore.u(appDataA, settingsControllerL)) {
                crashlyticsCore.m(settingsControllerL);
            }
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e3) {
            Logger.f().e("Error retrieving app package info.", e3);
            return null;
        }
    }
}

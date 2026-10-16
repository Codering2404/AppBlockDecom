package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AnalyticsDeferredProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deferred f88257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile AnalyticsEventLogger f88258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile BreadcrumbSource f88259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f88260d;

    public AnalyticsDeferredProxy(Deferred deferred) {
        this(deferred, new DisabledBreadcrumbSource(), new UnavailableAnalyticsEventLogger());
    }

    public static /* synthetic */ void a(AnalyticsDeferredProxy analyticsDeferredProxy, Provider provider) {
        analyticsDeferredProxy.getClass();
        Logger.f().b("AnalyticsConnector now available.");
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) provider.get();
        CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
        CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
        if (g(analyticsConnector, crashlyticsAnalyticsListener) == null) {
            Logger.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        Logger.f().b("Registered Firebase Analytics listener.");
        BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
        BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
        synchronized (analyticsDeferredProxy) {
            try {
                Iterator it = analyticsDeferredProxy.f88260d.iterator();
                while (it.hasNext()) {
                    breadcrumbAnalyticsEventReceiver.a((BreadcrumbHandler) it.next());
                }
                crashlyticsAnalyticsListener.d(breadcrumbAnalyticsEventReceiver);
                crashlyticsAnalyticsListener.e(blockingAnalyticsEventLogger);
                analyticsDeferredProxy.f88259c = breadcrumbAnalyticsEventReceiver;
                analyticsDeferredProxy.f88258b = blockingAnalyticsEventLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void c(AnalyticsDeferredProxy analyticsDeferredProxy, BreadcrumbHandler breadcrumbHandler) {
        synchronized (analyticsDeferredProxy) {
            try {
                if (analyticsDeferredProxy.f88259c instanceof DisabledBreadcrumbSource) {
                    analyticsDeferredProxy.f88260d.add(breadcrumbHandler);
                }
                analyticsDeferredProxy.f88259c.a(breadcrumbHandler);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        this.f88257a.a(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.c
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void a(Provider provider) {
                AnalyticsDeferredProxy.a(this.f88269a, provider);
            }
        });
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle g(AnalyticsConnector analyticsConnector, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleG = analyticsConnector.g("clx", crashlyticsAnalyticsListener);
        if (analyticsConnectorHandleG != null) {
            return analyticsConnectorHandleG;
        }
        Logger.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleG2 = analyticsConnector.g("crash", crashlyticsAnalyticsListener);
        if (analyticsConnectorHandleG2 != null) {
            Logger.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return analyticsConnectorHandleG2;
    }

    public AnalyticsEventLogger d() {
        return new AnalyticsEventLogger() { // from class: com.google.firebase.crashlytics.b
            @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
            public final void a(String str, Bundle bundle) {
                this.f88268a.f88258b.a(str, bundle);
            }
        };
    }

    public BreadcrumbSource e() {
        return new BreadcrumbSource() { // from class: com.google.firebase.crashlytics.a
            @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
            public final void a(BreadcrumbHandler breadcrumbHandler) {
                AnalyticsDeferredProxy.c(this.f88267a, breadcrumbHandler);
            }
        };
    }

    public AnalyticsDeferredProxy(Deferred deferred, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger) {
        this.f88257a = deferred;
        this.f88259c = breadcrumbSource;
        this.f88260d = new ArrayList();
        this.f88258b = analyticsEventLogger;
        f();
    }
}

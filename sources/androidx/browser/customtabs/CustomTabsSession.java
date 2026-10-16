package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.support.customtabs.IEngagementSignalsCallback;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2653a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ICustomTabsService f2654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ICustomTabsCallback f2655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComponentName f2656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PendingIntent f2657e;

    /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends IEngagementSignalsCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f2658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EngagementSignalsCallback f2659b;

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void A(final int i3, final Bundle bundle) {
            Handler handler = this.f2658a;
            final EngagementSignalsCallback engagementSignalsCallback = this.f2659b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.c
                @Override // java.lang.Runnable
                public final void run() {
                    engagementSignalsCallback.A(i3, bundle);
                }
            });
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void u(final boolean z2, final Bundle bundle) {
            Handler handler = this.f2658a;
            final EngagementSignalsCallback engagementSignalsCallback = this.f2659b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.b
                @Override // java.lang.Runnable
                public final void run() {
                    engagementSignalsCallback.u(z2, bundle);
                }
            });
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void x(final boolean z2, final Bundle bundle) {
            Handler handler = this.f2658a;
            final EngagementSignalsCallback engagementSignalsCallback = this.f2659b;
            handler.post(new Runnable() { // from class: androidx.browser.customtabs.d
                @Override // java.lang.Runnable
                public final void run() {
                    engagementSignalsCallback.x(z2, bundle);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends IEngagementSignalsCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f2660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EngagementSignalsCallback f2661b;

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void A(final int i3, final Bundle bundle) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                Executor executor = this.f2660a;
                final EngagementSignalsCallback engagementSignalsCallback = this.f2661b;
                executor.execute(new Runnable() { // from class: androidx.browser.customtabs.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        engagementSignalsCallback.A(i3, bundle);
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void u(final boolean z2, final Bundle bundle) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                Executor executor = this.f2660a;
                final EngagementSignalsCallback engagementSignalsCallback = this.f2661b;
                executor.execute(new Runnable() { // from class: androidx.browser.customtabs.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        engagementSignalsCallback.u(z2, bundle);
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.customtabs.IEngagementSignalsCallback
        public void x(final boolean z2, final Bundle bundle) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                Executor executor = this.f2660a;
                final EngagementSignalsCallback engagementSignalsCallback = this.f2661b;
                executor.execute(new Runnable() { // from class: androidx.browser.customtabs.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        engagementSignalsCallback.x(z2, bundle);
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MockSession extends ICustomTabsService.Stub {
        @Override // android.support.customtabs.ICustomTabsService
        public boolean A4(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean B1(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean G1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int T3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return 0;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean U(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean c5(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean d4(ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean i0(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean n3(long j3) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean o1(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean r1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean v2(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List list) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle y0(String str, Bundle bundle) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PendingSession {
    }

    CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.f2654b = iCustomTabsService;
        this.f2655c = iCustomTabsCallback;
        this.f2656d = componentName;
        this.f2657e = pendingIntent;
    }

    private void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f2657e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    private Bundle b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    private Bundle c(Uri uri) {
        Bundle bundle = new Bundle();
        if (uri != null) {
            bundle.putParcelable("target_origin", uri);
        }
        if (this.f2657e != null) {
            a(bundle);
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    IBinder d() {
        return this.f2655c.asBinder();
    }

    ComponentName e() {
        return this.f2656d;
    }

    PendingIntent f() {
        return this.f2657e;
    }

    public boolean g(Uri uri, Bundle bundle, List list) {
        try {
            return this.f2654b.v2(this.f2655c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int h(String str, Bundle bundle) {
        int iT3;
        Bundle bundleB = b(bundle);
        synchronized (this.f2653a) {
            try {
                try {
                    iT3 = this.f2654b.T3(this.f2655c, str, bundleB);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iT3;
    }

    public boolean i(Uri uri) {
        return j(uri, null, new Bundle());
    }

    public boolean j(Uri uri, Uri uri2, Bundle bundle) {
        try {
            Bundle bundleC = c(uri2);
            if (bundleC == null) {
                return this.f2654b.A4(this.f2655c, uri);
            }
            bundle.putAll(bundleC);
            return this.f2654b.o1(this.f2655c, uri, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean k(int i3, Uri uri, Bundle bundle) {
        if (i3 >= 1 && i3 <= 2) {
            try {
                return this.f2654b.U(this.f2655c, i3, uri, b(bundle));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }
}

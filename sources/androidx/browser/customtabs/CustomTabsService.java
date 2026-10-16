package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SimpleArrayMap f2649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICustomTabsService.Stub f2650b;

    /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ICustomTabsService.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomTabsService f2651a;

        private PendingIntent i5(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        private Uri j5(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 33 ? (Uri) Api33Impl.a(bundle, "target_origin", Uri.class) : (Uri) bundle.getParcelable("target_origin");
        }

        private boolean k5(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.a
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.f2672a.f2651a.a(customTabsSessionToken);
                    }
                };
                synchronized (this.f2651a.f2649a) {
                    iCustomTabsCallback.asBinder().linkToDeath(deathRecipient, 0);
                    this.f2651a.f2649a.put(iCustomTabsCallback.asBinder(), deathRecipient);
                }
                return this.f2651a.e(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean A4(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return this.f2651a.i(new CustomTabsSessionToken(iCustomTabsCallback, null), uri, null, new Bundle());
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean B1(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle) {
            return this.f2651a.j(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), EngagementSignalsCallbackRemote.a(iBinder), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean G1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return this.f2651a.k(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int T3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return this.f2651a.f(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean U(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
            return this.f2651a.l(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), i3, uri, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean c5(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return this.f2651a.c(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean d4(ICustomTabsCallback iCustomTabsCallback) {
            return k5(iCustomTabsCallback, null);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean i0(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle) {
            return this.f2651a.g(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), uri, i3, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean n3(long j3) {
            return this.f2651a.m(j3);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean o1(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return this.f2651a.i(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), uri, j5(bundle), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean r1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return k5(iCustomTabsCallback, i5(bundle));
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean v2(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List list) {
            return this.f2651a.d(new CustomTabsSessionToken(iCustomTabsCallback, i5(bundle)), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle y0(String str, Bundle bundle) {
            return this.f2651a.b(str, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FilePurpose {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.f2649a) {
                try {
                    IBinder iBinderA = customTabsSessionToken.a();
                    if (iBinderA == null) {
                        return false;
                    }
                    iBinderA.unlinkToDeath((IBinder.DeathRecipient) this.f2649a.get(iBinderA), 0);
                    this.f2649a.remove(iBinderA);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    protected abstract Bundle b(String str, Bundle bundle);

    protected boolean c(CustomTabsSessionToken customTabsSessionToken, Bundle bundle) {
        return false;
    }

    protected abstract boolean d(CustomTabsSessionToken customTabsSessionToken, Uri uri, Bundle bundle, List list);

    protected abstract boolean e(CustomTabsSessionToken customTabsSessionToken);

    protected abstract int f(CustomTabsSessionToken customTabsSessionToken, String str, Bundle bundle);

    protected abstract boolean g(CustomTabsSessionToken customTabsSessionToken, Uri uri, int i3, Bundle bundle);

    protected abstract boolean h(CustomTabsSessionToken customTabsSessionToken, Uri uri);

    protected boolean i(CustomTabsSessionToken customTabsSessionToken, Uri uri, Uri uri2, Bundle bundle) {
        return h(customTabsSessionToken, uri);
    }

    protected boolean j(CustomTabsSessionToken customTabsSessionToken, EngagementSignalsCallback engagementSignalsCallback, Bundle bundle) {
        return false;
    }

    protected abstract boolean k(CustomTabsSessionToken customTabsSessionToken, Bundle bundle);

    protected abstract boolean l(CustomTabsSessionToken customTabsSessionToken, int i3, Uri uri, Bundle bundle);

    protected abstract boolean m(long j3);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2650b;
    }
}

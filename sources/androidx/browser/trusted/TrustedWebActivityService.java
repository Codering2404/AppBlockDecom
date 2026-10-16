package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.browser.trusted.TrustedWebActivityServiceConnection;
import androidx.core.app.NotificationManagerCompat;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TrustedWebActivityService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f2703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ITrustedWebActivityService.Stub f2705c;

    /* JADX INFO: renamed from: androidx.browser.trusted.TrustedWebActivityService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ITrustedWebActivityService.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrustedWebActivityService f2706a;

        private void h5() {
            TrustedWebActivityService trustedWebActivityService = this.f2706a;
            if (trustedWebActivityService.f2704b == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                int i3 = 0;
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token tokenA = this.f2706a.c().a();
                PackageManager packageManager = this.f2706a.getPackageManager();
                if (tokenA != null) {
                    int length = packagesForUid.length;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        if (tokenA.a(packagesForUid[i3], packageManager)) {
                            this.f2706a.f2704b = Binder.getCallingUid();
                            break;
                        }
                        i3++;
                    }
                }
            }
            if (this.f2706a.f2704b != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle D0(String str, Bundle bundle, IBinder iBinder) {
            h5();
            return this.f2706a.f(str, bundle, TrustedWebActivityCallbackRemote.a(iBinder));
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle D1(Bundle bundle) {
            h5();
            TrustedWebActivityServiceConnection.NotifyNotificationArgs notifyNotificationArgsA = TrustedWebActivityServiceConnection.NotifyNotificationArgs.a(bundle);
            return new TrustedWebActivityServiceConnection.ResultArgs(this.f2706a.j(notifyNotificationArgsA.f2714a, notifyNotificationArgsA.f2715b, notifyNotificationArgsA.f2716c, notifyNotificationArgsA.f2717d)).a();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle I2() {
            h5();
            return new TrustedWebActivityServiceConnection.ActiveNotificationsArgs(this.f2706a.g()).a();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public int Q3() {
            h5();
            return this.f2706a.i();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle S3(Bundle bundle) {
            h5();
            return new TrustedWebActivityServiceConnection.ResultArgs(this.f2706a.d(TrustedWebActivityServiceConnection.NotificationsEnabledArgs.a(bundle).f2713a)).a();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle h1() {
            h5();
            return this.f2706a.h();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public void k4(Bundle bundle) {
            h5();
            TrustedWebActivityServiceConnection.CancelNotificationArgs cancelNotificationArgsA = TrustedWebActivityServiceConnection.CancelNotificationArgs.a(bundle);
            this.f2706a.e(cancelNotificationArgsA.f2711a, cancelNotificationArgsA.f2712b);
        }
    }

    private static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    private void b() {
        if (this.f2703a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract TokenStore c();

    public boolean d(String str) {
        b();
        if (NotificationManagerCompat.d(this).a()) {
            return NotificationApiHelperForO.b(this.f2703a, a(str));
        }
        return false;
    }

    public void e(String str, int i3) {
        b();
        this.f2703a.cancel(str, i3);
    }

    public Bundle f(String str, Bundle bundle, TrustedWebActivityCallbackRemote trustedWebActivityCallbackRemote) {
        return null;
    }

    public Parcelable[] g() {
        b();
        return NotificationApiHelperForM.a(this.f2703a);
    }

    public Bundle h() {
        int i3 = i();
        Bundle bundle = new Bundle();
        if (i3 == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i3));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean j(String str, int i3, Notification notification, String str2) {
        b();
        if (!NotificationManagerCompat.d(this).a()) {
            return false;
        }
        String strA = a(str2);
        Notification notificationA = NotificationApiHelperForO.a(this, this.f2703a, notification, strA, str2);
        if (!NotificationApiHelperForO.b(this.f2703a, strA)) {
            return false;
        }
        this.f2703a.notify(str, i3, notificationA);
        return true;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2705c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f2703a = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.f2704b = -1;
        return super.onUnbind(intent);
    }
}

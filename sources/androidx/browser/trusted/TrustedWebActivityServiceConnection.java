package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import android.support.customtabs.trusted.ITrustedWebActivityService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class TrustedWebActivityServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ITrustedWebActivityService f2707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f2708b;

    /* JADX INFO: renamed from: androidx.browser.trusted.TrustedWebActivityServiceConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ITrustedWebActivityCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrustedWebActivityCallback f2709a;

        @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public void T4(String str, Bundle bundle) {
            this.f2709a.a(str, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ActiveNotificationsArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parcelable[] f2710a;

        ActiveNotificationsArgs(Parcelable[] parcelableArr) {
            this.f2710a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f2710a);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CancelNotificationArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2712b;

        CancelNotificationArgs(String str, int i3) {
            this.f2711a = str;
            this.f2712b = i3;
        }

        public static CancelNotificationArgs a(Bundle bundle) {
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new CancelNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NotificationsEnabledArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2713a;

        NotificationsEnabledArgs(String str) {
            this.f2713a = str;
        }

        public static NotificationsEnabledArgs a(Bundle bundle) {
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotificationsEnabledArgs(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NotifyNotificationArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Notification f2716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2717d;

        NotifyNotificationArgs(String str, int i3, Notification notification, String str2) {
            this.f2714a = str;
            this.f2715b = i3;
            this.f2716c = notification;
            this.f2717d = str2;
        }

        public static NotifyNotificationArgs a(Bundle bundle) {
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            TrustedWebActivityServiceConnection.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotifyNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ResultArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2718a;

        ResultArgs(boolean z2) {
            this.f2718a = z2;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f2718a);
            return bundle;
        }
    }

    TrustedWebActivityServiceConnection(ITrustedWebActivityService iTrustedWebActivityService, ComponentName componentName) {
        this.f2707a = iTrustedWebActivityService;
        this.f2708b = componentName;
    }

    static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}

package androidx.browser.customtabs;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import com.facebook.GraphRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsIntent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f2637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f2638b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivityHeightResizeBehavior {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivitySideSheetDecorationType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivitySideSheetPosition {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivitySideSheetRoundedCornersPosition {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21Impl {
        static Locale a(Intent intent) {
            String stringExtra = intent.getStringExtra("androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG");
            if (stringExtra != null) {
                return Locale.forLanguageTag(stringExtra);
            }
            return null;
        }

        static void b(Intent intent, Locale locale) {
            intent.putExtra("androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG", locale.toLanguageTag());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api23Impl {
        static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api24Impl {
        static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api34Impl {
        static void a(ActivityOptions activityOptions, boolean z2) {
            activityOptions.setShareIdentityEnabled(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseButtonPosition {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareState {
    }

    CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f2637a = intent;
        this.f2638b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f2637a.setData(uri);
        ContextCompat.startActivity(context, this.f2637a, this.f2638b);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ArrayList f2641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ActivityOptions f2642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ArrayList f2643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private SparseArray f2644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f2645g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f2648j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f2639a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CustomTabColorSchemeParams.Builder f2640b = new CustomTabColorSchemeParams.Builder();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2646h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f2647i = true;

        public Builder() {
        }

        private void g() {
            String strA = Api24Impl.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f2639a.hasExtra("com.android.browser.headers") ? this.f2639a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey(GraphRequest.ACCEPT_LANGUAGE_HEADER)) {
                return;
            }
            bundleExtra.putString(GraphRequest.ACCEPT_LANGUAGE_HEADER, strA);
            this.f2639a.putExtra("com.android.browser.headers", bundleExtra);
        }

        private void p(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f2639a.putExtras(bundle);
        }

        private void q() {
            if (this.f2642d == null) {
                this.f2642d = Api23Impl.a();
            }
            Api34Impl.a(this.f2642d, this.f2648j);
        }

        public CustomTabsIntent a() {
            if (!this.f2639a.hasExtra("android.support.customtabs.extra.SESSION")) {
                p(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f2641c;
            if (arrayList != null) {
                this.f2639a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f2643e;
            if (arrayList2 != null) {
                this.f2639a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f2639a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2647i);
            this.f2639a.putExtras(this.f2640b.a().a());
            Bundle bundle = this.f2645g;
            if (bundle != null) {
                this.f2639a.putExtras(bundle);
            }
            if (this.f2644f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f2644f);
                this.f2639a.putExtras(bundle2);
            }
            this.f2639a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f2646h);
            int i3 = Build.VERSION.SDK_INT;
            g();
            if (i3 >= 34) {
                q();
            }
            ActivityOptions activityOptions = this.f2642d;
            return new CustomTabsIntent(this.f2639a, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public Builder b(boolean z2) {
            this.f2639a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_STAR_BUTTON", !z2);
            return this;
        }

        public Builder c(Bitmap bitmap) {
            this.f2639a.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", bitmap);
            return this;
        }

        public Builder d(int i3) {
            if (i3 < 0 || i3 > 2) {
                throw new IllegalArgumentException("Invalid value for the position argument");
            }
            this.f2639a.putExtra("androidx.browser.customtabs.extra.CLOSE_BUTTON_POSITION", i3);
            return this;
        }

        public Builder e(int i3) {
            if (i3 < 0 || i3 > 2) {
                throw new IllegalArgumentException("Invalid value for the colorScheme argument");
            }
            this.f2639a.putExtra("androidx.browser.customtabs.extra.COLOR_SCHEME", i3);
            return this;
        }

        public Builder f(int i3, CustomTabColorSchemeParams customTabColorSchemeParams) {
            if (i3 < 0 || i3 > 2 || i3 == 0) {
                throw new IllegalArgumentException("Invalid colorScheme: " + i3);
            }
            if (this.f2644f == null) {
                this.f2644f = new SparseArray();
            }
            this.f2644f.put(i3, customTabColorSchemeParams.a());
            return this;
        }

        public Builder h(CustomTabColorSchemeParams customTabColorSchemeParams) {
            this.f2645g = customTabColorSchemeParams.a();
            return this;
        }

        public Builder i(boolean z2) {
            this.f2639a.putExtra("org.chromium.chrome.browser.customtabs.EXTRA_DISABLE_DOWNLOAD_BUTTON", !z2);
            return this;
        }

        public Builder j(Context context, int i3, int i4) {
            this.f2639a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", ActivityOptionsCompat.a(context, i3, i4).b());
            return this;
        }

        public Builder k(int i3) {
            return l(i3, 0);
        }

        public Builder l(int i3, int i4) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("Invalid value for the initialHeightPx argument");
            }
            if (i4 < 0 || i4 > 2) {
                throw new IllegalArgumentException("Invalid value for the activityHeightResizeBehavior argument");
            }
            this.f2639a.putExtra("androidx.browser.customtabs.extra.INITIAL_ACTIVITY_HEIGHT_PX", i3);
            this.f2639a.putExtra("androidx.browser.customtabs.extra.ACTIVITY_HEIGHT_RESIZE_BEHAVIOR", i4);
            return this;
        }

        public Builder m(boolean z2) {
            this.f2647i = z2;
            return this;
        }

        public Builder n(boolean z2) {
            this.f2639a.putExtra("android.support.customtabs.extra.SEND_TO_EXTERNAL_HANDLER", z2);
            return this;
        }

        public Builder o(CustomTabsSession customTabsSession) {
            this.f2639a.setPackage(customTabsSession.e().getPackageName());
            p(customTabsSession.d(), customTabsSession.f());
            return this;
        }

        public Builder r(int i3) {
            if (i3 < 0 || i3 > 2) {
                throw new IllegalArgumentException("Invalid value for the shareState argument");
            }
            this.f2646h = i3;
            if (i3 == 1) {
                this.f2639a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
                return this;
            }
            if (i3 == 2) {
                this.f2639a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
                return this;
            }
            this.f2639a.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
            return this;
        }

        public Builder s(boolean z2) {
            this.f2639a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z2 ? 1 : 0);
            return this;
        }

        public Builder t(Context context, int i3, int i4) {
            this.f2642d = ActivityOptions.makeCustomAnimation(context, i3, i4);
            return this;
        }

        public Builder u(int i3) {
            if (i3 < 0 || i3 > 16) {
                throw new IllegalArgumentException("Invalid value for the cornerRadiusDp argument");
            }
            this.f2639a.putExtra("androidx.browser.customtabs.extra.TOOLBAR_CORNER_RADIUS_DP", i3);
            return this;
        }

        public Builder v(boolean z2) {
            this.f2639a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", z2);
            return this;
        }

        public Builder(CustomTabsSession customTabsSession) {
            if (customTabsSession != null) {
                o(customTabsSession);
            }
        }
    }
}

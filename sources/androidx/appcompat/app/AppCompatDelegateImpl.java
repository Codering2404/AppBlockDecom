package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.internal.Utility;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.pairip.VMRunner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final SimpleArrayMap f1009k0 = new SimpleArrayMap();

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final boolean f1010l0 = false;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final int[] f1011m0 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final boolean f1012n0 = !"robolectric".equals(Build.FINGERPRINT);
    private boolean A;
    private boolean B;
    ViewGroup C;
    private TextView D;
    private View E;
    private boolean F;
    private boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    private boolean M;
    private PanelFeatureState[] N;
    private PanelFeatureState O;
    private boolean P;
    private boolean Q;
    private boolean R;
    boolean S;
    private Configuration T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private AutoNightModeManager Y;
    private AutoNightModeManager Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    boolean f1013a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    int f1014b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Runnable f1015c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f1016d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private Rect f1017e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Rect f1018f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private AppCompatViewInflater f1019g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private LayoutIncludeDetector f1020h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private OnBackInvokedDispatcher f1021i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private OnBackInvokedCallback f1022j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Object f1023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Context f1024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Window f1025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AppCompatWindowCallback f1026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final AppCompatCallback f1027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ActionBar f1028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    MenuInflater f1029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f1030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DecorContentParent f1031s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ActionMenuPresenterCallback f1032t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PanelMenuPresenterCallback f1033u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ActionMode f1034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    ActionBarContextView f1035w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    PopupWindow f1036x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Runnable f1037y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    ViewPropertyAnimatorCompat f1038z;

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f1039a;

        private boolean a(Throwable th) {
            String message;
            return (th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains(AppIntroBaseFragmentKt.ARG_DRAWABLE) || message.contains("Drawable"));
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f1039a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f1039a.uncaughtException(thread, notFoundException);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f1042a;

        @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
        public void a(Rect rect) {
            rect.top = this.f1042a.n1(null, rect);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void a(int i3) {
            ActionBar actionBarZ = AppCompatDelegateImpl.this.z();
            if (actionBarZ != null) {
                actionBarZ.w(i3);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void b(Drawable drawable, int i3) {
            ActionBar actionBarZ = AppCompatDelegateImpl.this.z();
            if (actionBarZ != null) {
                actionBarZ.y(drawable);
                actionBarZ.w(i3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ActionBarMenuCallback {
        boolean a(int i3);

        View onCreatePanelView(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(MenuBuilder menuBuilder, boolean z2) {
            AppCompatDelegateImpl.this.i0(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(MenuBuilder menuBuilder) {
            Window.Callback callbackE0 = AppCompatDelegateImpl.this.E0();
            if (callbackE0 == null) {
                return true;
            }
            callbackE0.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ActionMode.Callback f1049a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f1049a = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void a(ActionMode actionMode) {
            this.f1049a.a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f1036x != null) {
                appCompatDelegateImpl.f1025m.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f1037y);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f1035w != null) {
                appCompatDelegateImpl2.s0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f1038z = ViewCompat.e(appCompatDelegateImpl3.f1035w).b(0.0f);
                AppCompatDelegateImpl.this.f1038z.g(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void b(View view) {
                        AppCompatDelegateImpl.this.f1035w.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl4.f1036x;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl4.f1035w.getParent() instanceof View) {
                            ViewCompat.j0((View) AppCompatDelegateImpl.this.f1035w.getParent());
                        }
                        AppCompatDelegateImpl.this.f1035w.l();
                        AppCompatDelegateImpl.this.f1038z.g(null);
                        AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl5.f1038z = null;
                        ViewCompat.j0(appCompatDelegateImpl5.C);
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f1027o;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.f1034v);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f1034v = null;
            ViewCompat.j0(appCompatDelegateImpl5.C);
            AppCompatDelegateImpl.this.l1();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f1049a.b(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f1049a.c(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean d(ActionMode actionMode, Menu menu) {
            ViewCompat.j0(AppCompatDelegateImpl.this.C);
            return this.f1049a.d(actionMode, menu);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.i()));
        }

        static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.i()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i3 = configuration.colorMode & 3;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 3)) {
                configuration3.colorMode |= i4 & 3;
            }
            int i5 = configuration.colorMode & 12;
            int i6 = configuration2.colorMode;
            if (i5 != (i6 & 12)) {
                configuration3.colorMode |= i6 & 12;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.i
                public final void onBackInvoked() {
                    appCompatDelegateImpl.M0();
                }
            };
            e.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            e.a(obj).unregisterOnBackInvokedCallback(d.a(obj2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AppCompatWindowCallback extends WindowCallbackWrapper {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ActionBarMenuCallback f1052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1054d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1055f;

        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1054d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1054d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f1053c = true;
                callback.onContentChanged();
            } finally {
                this.f1053c = false;
            }
        }

        public void d(Window.Callback callback, int i3, Menu menu) {
            try {
                this.f1055f = true;
                callback.onPanelClosed(i3, menu);
            } finally {
                this.f1055f = false;
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1054d ? a().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.q0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.P0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(ActionBarMenuCallback actionBarMenuCallback) {
            this.f1052b = actionBarMenuCallback;
        }

        final android.view.ActionMode f(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.f1024l, callback);
            androidx.appcompat.view.ActionMode actionModeY = AppCompatDelegateImpl.this.Y(callbackWrapper);
            if (actionModeY != null) {
                return callbackWrapper.e(actionModeY);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1053c) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i3, Menu menu) {
            if (i3 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i3, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i3) {
            View viewOnCreatePanelView;
            ActionBarMenuCallback actionBarMenuCallback = this.f1052b;
            return (actionBarMenuCallback == null || (viewOnCreatePanelView = actionBarMenuCallback.onCreatePanelView(i3)) == null) ? super.onCreatePanelView(i3) : viewOnCreatePanelView;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i3, Menu menu) {
            super.onMenuOpened(i3, menu);
            AppCompatDelegateImpl.this.S0(i3);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i3, Menu menu) {
            if (this.f1055f) {
                a().onPanelClosed(i3, menu);
            } else {
                super.onPanelClosed(i3, menu);
                AppCompatDelegateImpl.this.T0(i3);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i3, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i3 == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.f0(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.f1052b;
            boolean zOnPreparePanel = actionBarMenuCallback != null && actionBarMenuCallback.a(i3);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i3, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.f0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i3) {
            MenuBuilder menuBuilder;
            PanelFeatureState panelFeatureStateC0 = AppCompatDelegateImpl.this.C0(0, true);
            if (panelFeatureStateC0 == null || (menuBuilder = panelFeatureStateC0.f1074j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i3);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i3);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
            return (AppCompatDelegateImpl.this.K0() && i3 == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f1057c;

        AutoBatteryNightModeManager(Context context) {
            super();
            this.f1057c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int c() {
            return Api21Impl.a(this.f1057c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void d() {
            AppCompatDelegateImpl.this.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class AutoNightModeManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f1059a;

        AutoNightModeManager() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f1059a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f1024l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1059a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f1059a == null) {
                this.f1059a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        VMRunner.invoke("dlAngW562Xry7abr", new Object[]{this, context, intent});
                    }
                };
            }
            AppCompatDelegateImpl.this.f1024l.registerReceiver(this.f1059a, intentFilterB);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AutoTimeNightModeManager extends AutoNightModeManager {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TwilightManager f1062c;

        AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.f1062c = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int c() {
            return this.f1062c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void d() {
            AppCompatDelegateImpl.this.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean b(int i3, int i4) {
            return i3 < -5 || i4 < -5 || i3 > getWidth() + 5 || i4 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.q0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.k0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i3) {
            setBackgroundDrawable(AppCompatResources.b(getContext(), i3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1069e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1070f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f1071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        View f1072h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        View f1073i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        MenuBuilder f1074j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        ListMenuPresenter f1075k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Context f1076l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f1077m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f1078n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f1079o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1080p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f1081q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f1082r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Bundle f1083s;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i3) {
                    return new SavedState[i3];
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f1084a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f1085b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Bundle f1086c;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1084a = parcel.readInt();
                boolean z2 = parcel.readInt() == 1;
                savedState.f1085b = z2;
                if (z2) {
                    savedState.f1086c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.f1084a);
                parcel.writeInt(this.f1085b ? 1 : 0);
                if (this.f1085b) {
                    parcel.writeBundle(this.f1086c);
                }
            }
        }

        PanelFeatureState(int i3) {
            this.f1065a = i3;
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.f1074j == null) {
                return null;
            }
            if (this.f1075k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f1076l, androidx.appcompat.R.layout.f770l);
                this.f1075k = listMenuPresenter;
                listMenuPresenter.d(callback);
                this.f1074j.b(this.f1075k);
            }
            return this.f1075k.l(this.f1071g);
        }

        public boolean b() {
            if (this.f1072h == null) {
                return false;
            }
            return this.f1073i != null || this.f1075k.b().getCount() > 0;
        }

        void c(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f1074j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.R(this.f1075k);
            }
            this.f1074j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.f1075k) == null) {
                return;
            }
            menuBuilder.b(listMenuPresenter);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.f631a, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            }
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.f652k0, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                themeNewTheme.applyStyle(i4, true);
            } else {
                themeNewTheme.applyStyle(androidx.appcompat.R.style.f802d, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(themeNewTheme);
            this.f1076l = contextThemeWrapper;
            TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(androidx.appcompat.R.styleable.A0);
            this.f1066b = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.D0, 0);
            this.f1070f = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.C0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(MenuBuilder menuBuilder, boolean z2) {
            MenuBuilder menuBuilderF = menuBuilder.F();
            boolean z3 = menuBuilderF != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z3) {
                menuBuilder = menuBuilderF;
            }
            PanelFeatureState panelFeatureStateV0 = appCompatDelegateImpl.v0(menuBuilder);
            if (panelFeatureStateV0 != null) {
                if (!z3) {
                    AppCompatDelegateImpl.this.l0(panelFeatureStateV0, z2);
                } else {
                    AppCompatDelegateImpl.this.h0(panelFeatureStateV0.f1065a, panelFeatureStateV0, menuBuilderF);
                    AppCompatDelegateImpl.this.l0(panelFeatureStateV0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(MenuBuilder menuBuilder) {
            Window.Callback callbackE0;
            if (menuBuilder != menuBuilder.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.H || (callbackE0 = appCompatDelegateImpl.E0()) == null || AppCompatDelegateImpl.this.S) {
                return true;
            }
            callbackE0.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    private AutoNightModeManager A0(Context context) {
        if (this.Y == null) {
            this.Y = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.Y;
    }

    private void F0() {
        t0();
        if (this.H && this.f1028p == null) {
            Object obj = this.f1023k;
            if (obj instanceof Activity) {
                this.f1028p = new WindowDecorActionBar((Activity) this.f1023k, this.I);
            } else if (obj instanceof Dialog) {
                this.f1028p = new WindowDecorActionBar((Dialog) this.f1023k);
            }
            ActionBar actionBar = this.f1028p;
            if (actionBar != null) {
                actionBar.s(this.f1016d0);
            }
        }
    }

    private boolean G0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f1073i;
        if (view != null) {
            panelFeatureState.f1072h = view;
            return true;
        }
        if (panelFeatureState.f1074j == null) {
            return false;
        }
        if (this.f1033u == null) {
            this.f1033u = new PanelMenuPresenterCallback();
        }
        View view2 = (View) panelFeatureState.a(this.f1033u);
        panelFeatureState.f1072h = view2;
        return view2 != null;
    }

    private boolean H0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(x0());
        panelFeatureState.f1071g = new ListMenuDecorView(panelFeatureState.f1076l);
        panelFeatureState.f1067c = 81;
        return true;
    }

    private boolean I0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.f1024l;
        int i3 = panelFeatureState.f1065a;
        if ((i3 == 0 || i3 == 108) && this.f1031s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(androidx.appcompat.R.attr.f641f, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.f643g, typedValue, true);
            } else {
                theme.resolveAttribute(androidx.appcompat.R.attr.f643g, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(themeNewTheme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.W(this);
        panelFeatureState.c(menuBuilder);
        return true;
    }

    private void J0(int i3) {
        this.f1014b0 = (1 << i3) | this.f1014b0;
        if (this.f1013a0) {
            return;
        }
        ViewCompat.e0(this.f1025m.getDecorView(), this.f1015c0);
        this.f1013a0 = true;
    }

    private boolean O0(int i3, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateC0 = C0(i3, true);
        if (panelFeatureStateC0.f1079o) {
            return false;
        }
        return Y0(panelFeatureStateC0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean R0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.f1034v
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.C0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.DecorContentParent r5 = r4.f1031s
            if (r5 == 0) goto L43
            boolean r5 = r5.b()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f1024l
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.DecorContentParent r5 = r4.f1031s
            boolean r5 = r5.f()
            if (r5 != 0) goto L3c
            boolean r5 = r4.S
            if (r5 != 0) goto L62
            boolean r5 = r4.Y0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.DecorContentParent r5 = r4.f1031s
            boolean r0 = r5.d()
            goto L68
        L3c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.f1031s
            boolean r0 = r5.c()
            goto L68
        L43:
            boolean r5 = r2.f1079o
            if (r5 != 0) goto L64
            boolean r3 = r2.f1078n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f1077m
            if (r5 == 0) goto L62
            boolean r5 = r2.f1082r
            if (r5 == 0) goto L5b
            r2.f1077m = r1
            boolean r5 = r4.Y0(r2, r6)
            goto L5c
        L5b:
            r5 = r0
        L5c:
            if (r5 == 0) goto L62
            r4.V0(r2, r6)
            goto L68
        L62:
            r0 = r1
            goto L68
        L64:
            r4.l0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r5 = r4.f1024l
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            return r0
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.R0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void V0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.V0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean X0(PanelFeatureState panelFeatureState, int i3, KeyEvent keyEvent, int i4) {
        MenuBuilder menuBuilder;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f1077m || Y0(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f1074j) != null) {
            zPerformShortcut = menuBuilder.performShortcut(i3, keyEvent, i4);
        }
        if (zPerformShortcut && (i4 & 1) == 0 && this.f1031s == null) {
            l0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    private boolean Y0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.S) {
            return false;
        }
        if (panelFeatureState.f1077m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.O;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            l0(panelFeatureState2, false);
        }
        Window.Callback callbackE0 = E0();
        if (callbackE0 != null) {
            panelFeatureState.f1073i = callbackE0.onCreatePanelView(panelFeatureState.f1065a);
        }
        int i3 = panelFeatureState.f1065a;
        boolean z2 = i3 == 0 || i3 == 108;
        if (z2 && (decorContentParent3 = this.f1031s) != null) {
            decorContentParent3.g();
        }
        if (panelFeatureState.f1073i == null && (!z2 || !(W0() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.f1074j;
            if (menuBuilder == null || panelFeatureState.f1082r) {
                if (menuBuilder == null && (!I0(panelFeatureState) || panelFeatureState.f1074j == null)) {
                    return false;
                }
                if (z2 && this.f1031s != null) {
                    if (this.f1032t == null) {
                        this.f1032t = new ActionMenuPresenterCallback();
                    }
                    this.f1031s.e(panelFeatureState.f1074j, this.f1032t);
                }
                panelFeatureState.f1074j.i0();
                if (!callbackE0.onCreatePanelMenu(panelFeatureState.f1065a, panelFeatureState.f1074j)) {
                    panelFeatureState.c(null);
                    if (z2 && (decorContentParent = this.f1031s) != null) {
                        decorContentParent.e(null, this.f1032t);
                    }
                    return false;
                }
                panelFeatureState.f1082r = false;
            }
            panelFeatureState.f1074j.i0();
            Bundle bundle = panelFeatureState.f1083s;
            if (bundle != null) {
                panelFeatureState.f1074j.S(bundle);
                panelFeatureState.f1083s = null;
            }
            if (!callbackE0.onPreparePanel(0, panelFeatureState.f1073i, panelFeatureState.f1074j)) {
                if (z2 && (decorContentParent2 = this.f1031s) != null) {
                    decorContentParent2.e(null, this.f1032t);
                }
                panelFeatureState.f1074j.h0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f1080p = z3;
            panelFeatureState.f1074j.setQwertyMode(z3);
            panelFeatureState.f1074j.h0();
        }
        panelFeatureState.f1077m = true;
        panelFeatureState.f1078n = false;
        this.O = panelFeatureState;
        return true;
    }

    private void Z0(boolean z2) {
        DecorContentParent decorContentParent = this.f1031s;
        if (decorContentParent == null || !decorContentParent.b() || (ViewConfiguration.get(this.f1024l).hasPermanentMenuKey() && !this.f1031s.h())) {
            PanelFeatureState panelFeatureStateC0 = C0(0, true);
            panelFeatureStateC0.f1081q = true;
            l0(panelFeatureStateC0, false);
            V0(panelFeatureStateC0, null);
            return;
        }
        Window.Callback callbackE0 = E0();
        if (this.f1031s.f() && z2) {
            this.f1031s.c();
            if (this.S) {
                return;
            }
            callbackE0.onPanelClosed(108, C0(0, true).f1074j);
            return;
        }
        if (callbackE0 == null || this.S) {
            return;
        }
        if (this.f1013a0 && (this.f1014b0 & 1) != 0) {
            this.f1025m.getDecorView().removeCallbacks(this.f1015c0);
            this.f1015c0.run();
        }
        PanelFeatureState panelFeatureStateC02 = C0(0, true);
        MenuBuilder menuBuilder = panelFeatureStateC02.f1074j;
        if (menuBuilder == null || panelFeatureStateC02.f1082r || !callbackE0.onPreparePanel(0, panelFeatureStateC02.f1073i, menuBuilder)) {
            return;
        }
        callbackE0.onMenuOpened(108, panelFeatureStateC02.f1074j);
        this.f1031s.d();
    }

    private int a1(int i3) {
        if (i3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i3 != 9) {
            return i3;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean b0(boolean z2) {
        return c0(z2, true);
    }

    private boolean c0(boolean z2, boolean z3) {
        if (this.S) {
            return false;
        }
        int iG0 = g0();
        int iL0 = L0(this.f1024l, iG0);
        LocaleListCompat localeListCompatF0 = Build.VERSION.SDK_INT < 33 ? f0(this.f1024l) : null;
        if (!z3 && localeListCompatF0 != null) {
            localeListCompatF0 = B0(this.f1024l.getResources().getConfiguration());
        }
        boolean zK1 = k1(iL0, localeListCompatF0, z2);
        if (iG0 == 0) {
            A0(this.f1024l).e();
        } else {
            AutoNightModeManager autoNightModeManager = this.Y;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (iG0 == 3) {
            z0(this.f1024l).e();
            return zK1;
        }
        AutoNightModeManager autoNightModeManager2 = this.Z;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
        return zK1;
    }

    private void d0() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.C.findViewById(R.id.content);
        View decorView = this.f1025m.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f1024l.obtainStyledAttributes(androidx.appcompat.R.styleable.A0);
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.M0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.N0, contentFrameLayout.getMinWidthMinor());
        int i3 = androidx.appcompat.R.styleable.K0;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMajor());
        }
        int i4 = androidx.appcompat.R.styleable.L0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedWidthMinor());
        }
        int i5 = androidx.appcompat.R.styleable.I0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMajor());
        }
        int i6 = androidx.appcompat.R.styleable.J0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            typedArrayObtainStyledAttributes.getValue(i6, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void e0(Window window) {
        if (this.f1025m != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.f1026n = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        TintTypedArray tintTypedArrayU = TintTypedArray.u(this.f1024l, null, f1011m0);
        Drawable drawableH = tintTypedArrayU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        tintTypedArrayU.x();
        this.f1025m = window;
        if (Build.VERSION.SDK_INT < 33 || this.f1021i0 != null) {
            return;
        }
        U(null);
    }

    private boolean e1(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1025m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int g0() {
        int i3 = this.U;
        return i3 != -100 ? i3 : AppCompatDelegate.s();
    }

    private void h1() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity i1() {
        for (Context baseContext = this.f1024l; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void j0() {
        AutoNightModeManager autoNightModeManager = this.Y;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.Z;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j1(Configuration configuration) {
        Activity activity = (Activity) this.f1023k;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().getCurrentState().b(Lifecycle.State.f39949c)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.R || this.S) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean k1(int r11, androidx.core.os.LocaleListCompat r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.k1(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    private Configuration m0(Context context, int i3, LocaleListCompat localeListCompat, Configuration configuration, boolean z2) {
        int i4 = i3 != 1 ? i3 != 2 ? z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            b1(configuration2, localeListCompat);
        }
        return configuration2;
    }

    private void m1(int i3, LocaleListCompat localeListCompat, boolean z2, Configuration configuration) {
        Resources resources = this.f1024l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i3 | (resources.getConfiguration().uiMode & (-49));
        if (localeListCompat != null) {
            b1(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, null);
        int i4 = this.V;
        if (i4 != 0) {
            this.f1024l.setTheme(i4);
            this.f1024l.getTheme().applyStyle(this.V, true);
        }
        if (z2 && (this.f1023k instanceof Activity)) {
            j1(configuration2);
        }
    }

    private ViewGroup n0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f1024l.obtainStyledAttributes(androidx.appcompat.R.styleable.A0);
        int i3 = androidx.appcompat.R.styleable.F0;
        if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.O0, false)) {
            N(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i3, false)) {
            N(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.G0, false)) {
            N(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.H0, false)) {
            N(10);
        }
        this.K = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.B0, false);
        typedArrayObtainStyledAttributes.recycle();
        u0();
        this.f1025m.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1024l);
        if (this.L) {
            viewGroup = this.J ? (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.f775q, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.f774p, (ViewGroup) null);
        } else if (this.K) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.f766h, (ViewGroup) null);
            this.I = false;
            this.H = false;
        } else if (this.H) {
            TypedValue typedValue = new TypedValue();
            this.f1024l.getTheme().resolveAttribute(androidx.appcompat.R.attr.f641f, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(this.f1024l, typedValue.resourceId) : this.f1024l).inflate(androidx.appcompat.R.layout.f776r, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(androidx.appcompat.R.id.f749q);
            this.f1031s = decorContentParent;
            decorContentParent.setWindowCallback(E0());
            if (this.I) {
                this.f1031s.i(109);
            }
            if (this.F) {
                this.f1031s.i(2);
            }
            if (this.G) {
                this.f1031s.i(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        ViewCompat.C0(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                int iM = windowInsetsCompat.m();
                int iN1 = AppCompatDelegateImpl.this.n1(windowInsetsCompat, null);
                if (iM != iN1) {
                    windowInsetsCompat = windowInsetsCompat.t(windowInsetsCompat.k(), iN1, windowInsetsCompat.l(), windowInsetsCompat.j());
                }
                return ViewCompat.Y(view, windowInsetsCompat);
            }
        });
        if (this.f1031s == null) {
            this.D = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.S);
        }
        ViewUtils.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.f734b);
        ViewGroup viewGroup2 = (ViewGroup) this.f1025m.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f1025m.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void onDetachedFromWindow() {
                AppCompatDelegateImpl.this.p0();
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void a() {
            }
        });
        return viewGroup;
    }

    private void o1(View view) {
        view.setBackgroundColor((ViewCompat.K(view) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? ContextCompat.getColor(this.f1024l, androidx.appcompat.R.color.f685b) : ContextCompat.getColor(this.f1024l, androidx.appcompat.R.color.f684a));
    }

    private void t0() {
        if (this.B) {
            return;
        }
        this.C = n0();
        CharSequence charSequenceD0 = D0();
        if (!TextUtils.isEmpty(charSequenceD0)) {
            DecorContentParent decorContentParent = this.f1031s;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(charSequenceD0);
            } else if (W0() != null) {
                W0().B(charSequenceD0);
            } else {
                TextView textView = this.D;
                if (textView != null) {
                    textView.setText(charSequenceD0);
                }
            }
        }
        d0();
        U0(this.C);
        this.B = true;
        PanelFeatureState panelFeatureStateC0 = C0(0, false);
        if (this.S) {
            return;
        }
        if (panelFeatureStateC0 == null || panelFeatureStateC0.f1074j == null) {
            J0(108);
        }
    }

    private void u0() {
        if (this.f1025m == null) {
            Object obj = this.f1023k;
            if (obj instanceof Activity) {
                e0(((Activity) obj).getWindow());
            }
        }
        if (this.f1025m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration w0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f3 = configuration.fontScale;
            float f4 = configuration2.fontScale;
            if (f3 != f4) {
                configuration3.fontScale = f4;
            }
            int i3 = configuration.mcc;
            int i4 = configuration2.mcc;
            if (i3 != i4) {
                configuration3.mcc = i4;
            }
            int i5 = configuration.mnc;
            int i6 = configuration2.mnc;
            if (i5 != i6) {
                configuration3.mnc = i6;
            }
            Api24Impl.a(configuration, configuration2, configuration3);
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            Api26Impl.a(configuration, configuration2, configuration3);
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            int i37 = configuration.densityDpi;
            int i38 = configuration2.densityDpi;
            if (i37 != i38) {
                configuration3.densityDpi = i38;
            }
        }
        return configuration3;
    }

    private int y0(Context context) {
        if (!this.X && (this.f1023k instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1023k.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : 786432);
                if (activityInfo != null) {
                    this.W = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e3);
                this.W = 0;
            }
        }
        this.X = true;
        return this.W;
    }

    private AutoNightModeManager z0(Context context) {
        if (this.Z == null) {
            this.Z = new AutoBatteryNightModeManager(context);
        }
        return this.Z;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void A() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1024l);
        if (layoutInflaterFrom.getFactory() == null) {
            LayoutInflaterCompat.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void B() {
        if (W0() == null || z().l()) {
            return;
        }
        J0(0);
    }

    LocaleListCompat B0(Configuration configuration) {
        return Api24Impl.b(configuration);
    }

    protected PanelFeatureState C0(int i3, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i3) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i3 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.N = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i3];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i3);
        panelFeatureStateArr[i3] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void D(Configuration configuration) {
        ActionBar actionBarZ;
        if (this.H && this.B && (actionBarZ = z()) != null) {
            actionBarZ.m(configuration);
        }
        AppCompatDrawableManager.b().g(this.f1024l);
        this.T = new Configuration(this.f1024l.getResources().getConfiguration());
        c0(false, false);
    }

    final CharSequence D0() {
        Object obj = this.f1023k;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f1030r;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void E(Bundle bundle) {
        String strC;
        this.Q = true;
        b0(false);
        u0();
        Object obj = this.f1023k;
        if (obj instanceof Activity) {
            try {
                strC = NavUtils.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                ActionBar actionBarW0 = W0();
                if (actionBarW0 == null) {
                    this.f1016d0 = true;
                } else {
                    actionBarW0.s(true);
                }
            }
            AppCompatDelegate.e(this);
        }
        this.T = new Configuration(this.f1024l.getResources().getConfiguration());
        this.R = true;
    }

    final Window.Callback E0() {
        return this.f1025m.getCallback();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void F() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1023k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.AppCompatDelegate.L(r3)
        L9:
            boolean r0 = r3.f1013a0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1025m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f1015c0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.S = r0
            int r0 = r3.U
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1023k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.SimpleArrayMap r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1009k0
            java.lang.Object r1 = r3.f1023k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.SimpleArrayMap r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1009k0
            java.lang.Object r1 = r3.f1023k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.f1028p
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.j0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.F():void");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void G(Bundle bundle) {
        t0();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void H() {
        ActionBar actionBarZ = z();
        if (actionBarZ != null) {
            actionBarZ.z(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void J() {
        c0(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void K() {
        ActionBar actionBarZ = z();
        if (actionBarZ != null) {
            actionBarZ.z(false);
        }
    }

    public boolean K0() {
        return this.A;
    }

    int L0(Context context, int i3) {
        if (i3 == -100) {
            return -1;
        }
        if (i3 != -1) {
            if (i3 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return A0(context).c();
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    return z0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i3;
    }

    boolean M0() {
        boolean z2 = this.P;
        this.P = false;
        PanelFeatureState panelFeatureStateC0 = C0(0, false);
        if (panelFeatureStateC0 != null && panelFeatureStateC0.f1079o) {
            if (!z2) {
                l0(panelFeatureStateC0, true);
            }
            return true;
        }
        androidx.appcompat.view.ActionMode actionMode = this.f1034v;
        if (actionMode != null) {
            actionMode.c();
            return true;
        }
        ActionBar actionBarZ = z();
        return actionBarZ != null && actionBarZ.g();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean N(int i3) {
        int iA1 = a1(i3);
        if (this.L && iA1 == 108) {
            return false;
        }
        if (this.H && iA1 == 1) {
            this.H = false;
        }
        if (iA1 == 1) {
            h1();
            this.L = true;
            return true;
        }
        if (iA1 == 2) {
            h1();
            this.F = true;
            return true;
        }
        if (iA1 == 5) {
            h1();
            this.G = true;
            return true;
        }
        if (iA1 == 10) {
            h1();
            this.J = true;
            return true;
        }
        if (iA1 == 108) {
            h1();
            this.H = true;
            return true;
        }
        if (iA1 != 109) {
            return this.f1025m.requestFeature(iA1);
        }
        h1();
        this.I = true;
        return true;
    }

    boolean N0(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.P = (keyEvent.getFlags() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
        } else if (i3 == 82) {
            O0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean P0(int i3, KeyEvent keyEvent) {
        ActionBar actionBarZ = z();
        if (actionBarZ != null && actionBarZ.o(i3, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.O;
        if (panelFeatureState != null && X0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.O;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f1078n = true;
            }
            return true;
        }
        if (this.O == null) {
            PanelFeatureState panelFeatureStateC0 = C0(0, true);
            Y0(panelFeatureStateC0, keyEvent);
            boolean zX0 = X0(panelFeatureStateC0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateC0.f1077m = false;
            if (zX0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void Q(int i3) {
        t0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1024l).inflate(i3, viewGroup);
        this.f1026n.c(this.f1025m.getCallback());
    }

    boolean Q0(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            if (i3 == 82) {
                R0(0, keyEvent);
                return true;
            }
        } else if (M0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void R(View view) {
        t0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1026n.c(this.f1025m.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void S(View view, ViewGroup.LayoutParams layoutParams) {
        t0();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1026n.c(this.f1025m.getCallback());
    }

    void S0(int i3) {
        ActionBar actionBarZ;
        if (i3 != 108 || (actionBarZ = z()) == null) {
            return;
        }
        actionBarZ.h(true);
    }

    void T0(int i3) {
        if (i3 == 108) {
            ActionBar actionBarZ = z();
            if (actionBarZ != null) {
                actionBarZ.h(false);
                return;
            }
            return;
        }
        if (i3 == 0) {
            PanelFeatureState panelFeatureStateC0 = C0(i3, true);
            if (panelFeatureStateC0.f1079o) {
                l0(panelFeatureStateC0, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void U(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.U(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f1021i0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f1022j0
            if (r1 == 0) goto L11
            androidx.appcompat.app.AppCompatDelegateImpl.Api33Impl.c(r0, r1)
            r0 = 0
            r2.f1022j0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.f1023k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.f1023k
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.AppCompatDelegateImpl.Api33Impl.a(r3)
            r2.f1021i0 = r3
            goto L2e
        L2c:
            r2.f1021i0 = r3
        L2e:
            r2.l1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.U(android.window.OnBackInvokedDispatcher):void");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void V(Toolbar toolbar) {
        if (this.f1023k instanceof Activity) {
            ActionBar actionBarZ = z();
            if (actionBarZ instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f1029q = null;
            if (actionBarZ != null) {
                actionBarZ.n();
            }
            this.f1028p = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, D0(), this.f1026n);
                this.f1028p = toolbarActionBar;
                this.f1026n.e(toolbarActionBar.f1106c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f1026n.e(null);
            }
            B();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void W(int i3) {
        this.V = i3;
    }

    final ActionBar W0() {
        return this.f1028p;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void X(CharSequence charSequence) {
        this.f1030r = charSequence;
        DecorContentParent decorContentParent = this.f1031s;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (W0() != null) {
            W0().B(charSequence);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public androidx.appcompat.view.ActionMode Y(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.ActionMode actionMode = this.f1034v;
        if (actionMode != null) {
            actionMode.c();
        }
        ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
        ActionBar actionBarZ = z();
        if (actionBarZ != null) {
            androidx.appcompat.view.ActionMode actionModeC = actionBarZ.C(actionModeCallbackWrapperV9);
            this.f1034v = actionModeC;
            if (actionModeC != null && (appCompatCallback = this.f1027o) != null) {
                appCompatCallback.onSupportActionModeStarted(actionModeC);
            }
        }
        if (this.f1034v == null) {
            this.f1034v = g1(actionModeCallbackWrapperV9);
        }
        l1();
        return this.f1034v;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateV0;
        Window.Callback callbackE0 = E0();
        if (callbackE0 == null || this.S || (panelFeatureStateV0 = v0(menuBuilder.F())) == null) {
            return false;
        }
        return callbackE0.onMenuItemSelected(panelFeatureStateV0.f1065a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void b(MenuBuilder menuBuilder) {
        Z0(true);
    }

    void b1(Configuration configuration, LocaleListCompat localeListCompat) {
        Api24Impl.d(configuration, localeListCompat);
    }

    void c1(LocaleListCompat localeListCompat) {
        Api24Impl.c(localeListCompat);
    }

    final boolean d1() {
        ViewGroup viewGroup;
        return this.B && (viewGroup = this.C) != null && viewGroup.isLaidOut();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void f(View view, ViewGroup.LayoutParams layoutParams) {
        t0();
        ((ViewGroup) this.C.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1026n.c(this.f1025m.getCallback());
    }

    LocaleListCompat f0(Context context) {
        LocaleListCompat localeListCompatX;
        if (Build.VERSION.SDK_INT >= 33 || (localeListCompatX = AppCompatDelegate.x()) == null) {
            return null;
        }
        LocaleListCompat localeListCompatB0 = B0(context.getApplicationContext().getResources().getConfiguration());
        LocaleListCompat localeListCompatB = LocaleOverlayHelper.b(localeListCompatX, localeListCompatB0);
        return localeListCompatB.g() ? localeListCompatB0 : localeListCompatB;
    }

    boolean f1() {
        if (this.f1021i0 == null) {
            return false;
        }
        PanelFeatureState panelFeatureStateC0 = C0(0, false);
        return (panelFeatureStateC0 != null && panelFeatureStateC0.f1079o) || this.f1034v != null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    boolean g() {
        if (AppCompatDelegate.C(this.f1024l) && AppCompatDelegate.x() != null && !AppCompatDelegate.x().equals(AppCompatDelegate.y())) {
            k(this.f1024l);
        }
        return b0(true);
    }

    androidx.appcompat.view.ActionMode g1(ActionMode.Callback callback) {
        androidx.appcompat.view.ActionMode actionModeOnWindowStartingSupportActionMode;
        Context contextThemeWrapper;
        AppCompatCallback appCompatCallback;
        s0();
        androidx.appcompat.view.ActionMode actionMode = this.f1034v;
        if (actionMode != null) {
            actionMode.c();
        }
        if (!(callback instanceof ActionModeCallbackWrapperV9)) {
            callback = new ActionModeCallbackWrapperV9(callback);
        }
        AppCompatCallback appCompatCallback2 = this.f1027o;
        if (appCompatCallback2 == null || this.S) {
            actionModeOnWindowStartingSupportActionMode = null;
        } else {
            try {
                actionModeOnWindowStartingSupportActionMode = appCompatCallback2.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError unused) {
                actionModeOnWindowStartingSupportActionMode = null;
            }
        }
        if (actionModeOnWindowStartingSupportActionMode != null) {
            this.f1034v = actionModeOnWindowStartingSupportActionMode;
        } else {
            if (this.f1035w == null) {
                if (this.K) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1024l.getTheme();
                    theme.resolveAttribute(androidx.appcompat.R.attr.f641f, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f1024l.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        contextThemeWrapper = new ContextThemeWrapper(this.f1024l, 0);
                        contextThemeWrapper.getTheme().setTo(themeNewTheme);
                    } else {
                        contextThemeWrapper = this.f1024l;
                    }
                    this.f1035w = new ActionBarContextView(contextThemeWrapper);
                    PopupWindow popupWindow = new PopupWindow(contextThemeWrapper, (AttributeSet) null, androidx.appcompat.R.attr.f647i);
                    this.f1036x = popupWindow;
                    PopupWindowCompat.b(popupWindow, 2);
                    this.f1036x.setContentView(this.f1035w);
                    this.f1036x.setWidth(-1);
                    contextThemeWrapper.getTheme().resolveAttribute(androidx.appcompat.R.attr.f633b, typedValue, true);
                    this.f1035w.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                    this.f1036x.setHeight(-2);
                    this.f1037y = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6
                        @Override // java.lang.Runnable
                        public void run() {
                            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                            appCompatDelegateImpl.f1036x.showAtLocation(appCompatDelegateImpl.f1035w, 55, 0, 0);
                            AppCompatDelegateImpl.this.s0();
                            if (!AppCompatDelegateImpl.this.d1()) {
                                AppCompatDelegateImpl.this.f1035w.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.f1035w.setVisibility(0);
                            } else {
                                AppCompatDelegateImpl.this.f1035w.setAlpha(0.0f);
                                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                                appCompatDelegateImpl2.f1038z = ViewCompat.e(appCompatDelegateImpl2.f1035w).b(1.0f);
                                AppCompatDelegateImpl.this.f1038z.g(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.6.1
                                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void b(View view) {
                                        AppCompatDelegateImpl.this.f1035w.setAlpha(1.0f);
                                        AppCompatDelegateImpl.this.f1038z.g(null);
                                        AppCompatDelegateImpl.this.f1038z = null;
                                    }

                                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void c(View view) {
                                        AppCompatDelegateImpl.this.f1035w.setVisibility(0);
                                    }
                                });
                            }
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.C.findViewById(androidx.appcompat.R.id.f740h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(x0()));
                        this.f1035w = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f1035w != null) {
                s0();
                this.f1035w.l();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.f1035w.getContext(), this.f1035w, callback, this.f1036x == null);
                if (callback.b(standaloneActionMode, standaloneActionMode.e())) {
                    standaloneActionMode.k();
                    this.f1035w.i(standaloneActionMode);
                    this.f1034v = standaloneActionMode;
                    if (d1()) {
                        this.f1035w.setAlpha(0.0f);
                        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatB = ViewCompat.e(this.f1035w).b(1.0f);
                        this.f1038z = viewPropertyAnimatorCompatB;
                        viewPropertyAnimatorCompatB.g(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.7
                            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                            public void b(View view) {
                                AppCompatDelegateImpl.this.f1035w.setAlpha(1.0f);
                                AppCompatDelegateImpl.this.f1038z.g(null);
                                AppCompatDelegateImpl.this.f1038z = null;
                            }

                            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                            public void c(View view) {
                                AppCompatDelegateImpl.this.f1035w.setVisibility(0);
                                if (AppCompatDelegateImpl.this.f1035w.getParent() instanceof View) {
                                    ViewCompat.j0((View) AppCompatDelegateImpl.this.f1035w.getParent());
                                }
                            }
                        });
                    } else {
                        this.f1035w.setAlpha(1.0f);
                        this.f1035w.setVisibility(0);
                        if (this.f1035w.getParent() instanceof View) {
                            ViewCompat.j0((View) this.f1035w.getParent());
                        }
                    }
                    if (this.f1036x != null) {
                        this.f1025m.getDecorView().post(this.f1037y);
                    }
                } else {
                    this.f1034v = null;
                }
            }
        }
        androidx.appcompat.view.ActionMode actionMode2 = this.f1034v;
        if (actionMode2 != null && (appCompatCallback = this.f1027o) != null) {
            appCompatCallback.onSupportActionModeStarted(actionMode2);
        }
        l1();
        return this.f1034v;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean h() {
        return b0(true);
    }

    void h0(int i3, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i3 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.N;
                if (i3 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i3];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1074j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1079o) && !this.S) {
            this.f1026n.d(this.f1025m.getCallback(), i3, menu);
        }
    }

    void i0(MenuBuilder menuBuilder) {
        if (this.M) {
            return;
        }
        this.M = true;
        this.f1031s.m();
        Window.Callback callbackE0 = E0();
        if (callbackE0 != null && !this.S) {
            callbackE0.onPanelClosed(108, menuBuilder);
        }
        this.M = false;
    }

    void k0(int i3) {
        l0(C0(i3, true), true);
    }

    void l0(PanelFeatureState panelFeatureState, boolean z2) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z2 && panelFeatureState.f1065a == 0 && (decorContentParent = this.f1031s) != null && decorContentParent.f()) {
            i0(panelFeatureState.f1074j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1024l.getSystemService("window");
        if (windowManager != null && panelFeatureState.f1079o && (viewGroup = panelFeatureState.f1071g) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                h0(panelFeatureState.f1065a, panelFeatureState, null);
            }
        }
        panelFeatureState.f1077m = false;
        panelFeatureState.f1078n = false;
        panelFeatureState.f1079o = false;
        panelFeatureState.f1072h = null;
        panelFeatureState.f1081q = true;
        if (this.O == panelFeatureState) {
            this.O = null;
        }
        if (panelFeatureState.f1065a == 0) {
            l1();
        }
    }

    void l1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zF1 = f1();
            if (zF1 && this.f1022j0 == null) {
                this.f1022j0 = Api33Impl.b(this.f1021i0, this);
            } else {
                if (zF1 || (onBackInvokedCallback = this.f1022j0) == null) {
                    return;
                }
                Api33Impl.c(this.f1021i0, onBackInvokedCallback);
                this.f1022j0 = null;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context m(Context context) {
        Context context2;
        this.Q = true;
        int iL0 = L0(context, g0());
        if (AppCompatDelegate.C(context)) {
            AppCompatDelegate.a0(context);
        }
        LocaleListCompat localeListCompatF0 = f0(context);
        if (context instanceof android.view.ContextThemeWrapper) {
            context2 = context;
            try {
                ((android.view.ContextThemeWrapper) context2).applyOverrideConfiguration(m0(context2, iL0, localeListCompatF0, null, false));
                return context2;
            } catch (IllegalStateException unused) {
            }
        } else {
            context2 = context;
        }
        if (context2 instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context2).a(m0(context2, iL0, localeListCompatF0, null, false));
                return context2;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1012n0) {
            return super.m(context2);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context2.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context2.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationM0 = m0(context2, iL0, localeListCompatF0, !configuration2.equals(configuration3) ? w0(configuration2, configuration3) : null, true);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context2, androidx.appcompat.R.style.f803e);
        contextThemeWrapper.a(configurationM0);
        try {
            if (context2.getTheme() != null) {
                ResourcesCompat.ThemeCompat.a(contextThemeWrapper.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.m(contextThemeWrapper);
    }

    final int n1(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        boolean z2;
        boolean z3;
        int iM = windowInsetsCompat != null ? windowInsetsCompat.m() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f1035w;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1035w.getLayoutParams();
            if (this.f1035w.isShown()) {
                if (this.f1017e0 == null) {
                    this.f1017e0 = new Rect();
                    this.f1018f0 = new Rect();
                }
                Rect rect2 = this.f1017e0;
                Rect rect3 = this.f1018f0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.k(), windowInsetsCompat.m(), windowInsetsCompat.l(), windowInsetsCompat.j());
                }
                ViewUtils.a(this.C, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                WindowInsetsCompat windowInsetsCompatF = ViewCompat.F(this.C);
                int iK = windowInsetsCompatF == null ? 0 : windowInsetsCompatF.k();
                int iL = windowInsetsCompatF == null ? 0 : windowInsetsCompatF.l();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z3 = true;
                }
                if (i3 <= 0 || this.E != null) {
                    View view = this.E;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != iK || marginLayoutParams2.rightMargin != iL) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = iK;
                            marginLayoutParams2.rightMargin = iL;
                            this.E.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f1024l);
                    this.E = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iK;
                    layoutParams.rightMargin = iL;
                    this.C.addView(this.E, -1, layoutParams);
                }
                View view3 = this.E;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    o1(this.E);
                }
                if (!this.J && z) {
                    iM = 0;
                }
                z2 = z;
                z = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z = false;
            }
            if (z) {
                this.f1035w.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.E;
        if (view4 != null) {
            view4.setVisibility(z2 ? 0 : 8);
        }
        return iM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View o0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        if (this.f1019g0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.f1024l.obtainStyledAttributes(androidx.appcompat.R.styleable.A0);
            String string = typedArrayObtainStyledAttributes.getString(androidx.appcompat.R.styleable.E0);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.f1019g0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f1019g0 = (AppCompatViewInflater) this.f1024l.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f1019g0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z3 = f1010l0;
        boolean zE1 = false;
        if (z3) {
            if (this.f1020h0 == null) {
                this.f1020h0 = new LayoutIncludeDetector();
            }
            if (this.f1020h0.a(attributeSet)) {
                z2 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zE1 = e1((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zE1 = true;
                }
                z2 = zE1;
            }
        } else {
            z2 = zE1;
        }
        return this.f1019g0.r(view, str, context, attributeSet, z2, z3, true, VectorEnabledTintResources.d());
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return o0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View p(int i3) {
        t0();
        return this.f1025m.findViewById(i3);
    }

    void p0() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.f1031s;
        if (decorContentParent != null) {
            decorContentParent.m();
        }
        if (this.f1036x != null) {
            this.f1025m.getDecorView().removeCallbacks(this.f1037y);
            if (this.f1036x.isShowing()) {
                try {
                    this.f1036x.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1036x = null;
        }
        s0();
        PanelFeatureState panelFeatureStateC0 = C0(0, false);
        if (panelFeatureStateC0 == null || (menuBuilder = panelFeatureStateC0.f1074j) == null) {
            return;
        }
        menuBuilder.close();
    }

    boolean q0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1023k;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f1025m.getDecorView()) != null && KeyEventDispatcher.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1026n.b(this.f1025m.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? N0(keyCode, keyEvent) : Q0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context r() {
        return this.f1024l;
    }

    void r0(int i3) {
        PanelFeatureState panelFeatureStateC0;
        PanelFeatureState panelFeatureStateC02 = C0(i3, true);
        if (panelFeatureStateC02.f1074j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateC02.f1074j.U(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateC02.f1083s = bundle;
            }
            panelFeatureStateC02.f1074j.i0();
            panelFeatureStateC02.f1074j.clear();
        }
        panelFeatureStateC02.f1082r = true;
        panelFeatureStateC02.f1081q = true;
        if ((i3 != 108 && i3 != 0) || this.f1031s == null || (panelFeatureStateC0 = C0(0, false)) == null) {
            return;
        }
        panelFeatureStateC0.f1077m = false;
        Y0(panelFeatureStateC0, null);
    }

    void s0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1038z;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate t() {
        return new ActionBarDrawableToggleImpl();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int u() {
        return this.U;
    }

    PanelFeatureState v0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.N;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i3];
            if (panelFeatureState != null && panelFeatureState.f1074j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater w() {
        if (this.f1029q == null) {
            F0();
            ActionBar actionBar = this.f1028p;
            this.f1029q = new SupportMenuInflater(actionBar != null ? actionBar.j() : this.f1024l);
        }
        return this.f1029q;
    }

    final Context x0() {
        ActionBar actionBarZ = z();
        Context contextJ = actionBarZ != null ? actionBarZ.j() : null;
        return contextJ == null ? this.f1024l : contextJ;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar z() {
        F0();
        return this.f1028p;
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivityI1;
        this.f1038z = null;
        this.A = true;
        this.U = -100;
        this.f1015c0 = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.f1014b0 & 1) != 0) {
                    appCompatDelegateImpl.r0(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.f1014b0 & 4096) != 0) {
                    appCompatDelegateImpl2.r0(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f1013a0 = false;
                appCompatDelegateImpl3.f1014b0 = 0;
            }
        };
        this.f1024l = context;
        this.f1027o = appCompatCallback;
        this.f1023k = obj;
        if (this.U == -100 && (obj instanceof Dialog) && (appCompatActivityI1 = i1()) != null) {
            this.U = appCompatActivityI1.getDelegate().u();
        }
        if (this.U == -100) {
            SimpleArrayMap simpleArrayMap = f1009k0;
            Integer num = (Integer) simpleArrayMap.get(obj.getClass().getName());
            if (num != null) {
                this.U = num.intValue();
                simpleArrayMap.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            e0(window);
        }
        AppCompatDrawableManager.h();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void I(Bundle bundle) {
    }

    void U0(ViewGroup viewGroup) {
    }
}

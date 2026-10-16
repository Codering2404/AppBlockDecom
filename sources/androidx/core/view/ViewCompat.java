package androidx.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakHashMap f34444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f34445b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f34446c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f34447d = {R.id.f33498b, R.id.f33499c, R.id.f33510n, R.id.f33521y, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F, R.id.G, R.id.f33500d, R.id.f33501e, R.id.f33502f, R.id.f33503g, R.id.f33504h, R.id.f33505i, R.id.f33506j, R.id.f33507k, R.id.f33508l, R.id.f33509m, R.id.f33511o, R.id.f33512p, R.id.f33513q, R.id.f33514r, R.id.f33515s, R.id.f33516t, R.id.f33517u, R.id.f33518v, R.id.f33519w, R.id.f33520x, R.id.f33522z, R.id.A};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final OnReceiveContentViewBehavior f34448e = new OnReceiveContentViewBehavior() { // from class: androidx.core.view.u
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public final ContentInfoCompat a(ContentInfoCompat contentInfoCompat) {
            return ViewCompat.a(contentInfoCompat);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AccessibilityPaneVisibilityManager f34449f = new AccessibilityPaneVisibilityManager();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AccessibilityViewProperty<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f34451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f34452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f34454d;

        AccessibilityViewProperty(int i3, Class cls, int i4) {
            this(i3, cls, 0, i4);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f34453c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f34451a);
            if (this.f34452b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                ViewCompat.i(view);
                view.setTag(this.f34451a, obj);
                ViewCompat.V(view, this.f34454d);
            }
        }

        boolean g(Object obj, Object obj2) {
            return !obj2.equals(obj);
        }

        AccessibilityViewProperty(int i3, Class cls, int i4, int i5) {
            this.f34451a = i3;
            this.f34452b = cls;
            this.f34454d = i4;
            this.f34453c = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api20Impl {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21Impl {
        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.Q);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsetsY = windowInsetsCompat.y();
            if (windowInsetsY != null) {
                return WindowInsetsCompat.A(view.computeSystemWindowInsets(windowInsetsY, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        static ColorStateList c(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode d(View view) {
            return view.getBackgroundTintMode();
        }

        static float e(View view) {
            return view.getElevation();
        }

        static String f(View view) {
            return view.getTransitionName();
        }

        static float g(View view) {
            return view.getTranslationZ();
        }

        static float h(View view) {
            return view.getZ();
        }

        static boolean i(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void j(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void k(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void l(View view, float f3) {
            view.setElevation(f3);
        }

        static void m(View view, boolean z2) {
            view.setNestedScrollingEnabled(z2);
        }

        static void n(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.L, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.Q));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    WindowInsetsCompat f34455a = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompatA = WindowInsetsCompat.A(windowInsets, view2);
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 < 30) {
                            Api21Impl.a(windowInsets, view);
                            if (windowInsetsCompatA.equals(this.f34455a)) {
                                return onApplyWindowInsetsListener.a(view2, windowInsetsCompatA).y();
                            }
                        }
                        this.f34455a = windowInsetsCompatA;
                        WindowInsetsCompat windowInsetsCompatA2 = onApplyWindowInsetsListener.a(view2, windowInsetsCompatA);
                        if (i3 >= 30) {
                            return windowInsetsCompatA2.y();
                        }
                        ViewCompat.j0(view2);
                        return windowInsetsCompatA2.y();
                    }
                });
            }
        }

        static void o(View view, String str) {
            view.setTransitionName(str);
        }

        static void p(View view, float f3) {
            view.setTranslationZ(f3);
        }

        static void q(View view, float f3) {
            view.setZ(f3);
        }

        static void r(View view) {
            view.stopNestedScroll();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api23Impl {
        public static WindowInsetsCompat a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompatZ = WindowInsetsCompat.z(rootWindowInsets);
            windowInsetsCompatZ.w(windowInsetsCompatZ);
            windowInsetsCompatZ.d(view.getRootView());
            return windowInsetsCompatZ;
        }

        static void b(View view, int i3, int i4) {
            view.setScrollIndicators(i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static int a(View view) {
            return view.getImportantForAutofill();
        }

        static void b(View view, int i3) {
            view.setImportantForAutofill(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        static void d(View view, boolean z2) {
            view.setAccessibilityHeading(z2);
        }

        static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void f(View view, boolean z2) {
            view.setScreenReaderFocusable(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api29Impl {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static WindowInsetsControllerCompat b(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.f(windowInsetsController);
            }
            return null;
        }

        static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31Impl {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat b(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfoF = contentInfoCompat.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? contentInfoCompat : ContentInfoCompat.g(contentInfoPerformReceiveContent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OnReceiveContentListener f34458a;

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompatG = ContentInfoCompat.g(contentInfo);
            ContentInfoCompat contentInfoCompatA = this.f34458a.a(view, contentInfoCompatG);
            if (contentInfoCompatA == null) {
                return null;
            }
            return contentInfoCompatA == contentInfoCompatG ? contentInfo : contentInfoCompatA.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnUnhandledKeyEventListenerCompat {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnhandledKeyEventManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ArrayList f34459a = new ArrayList();
    }

    public static int A(View view) {
        return view.getMinimumWidth();
    }

    public static void A0(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static String[] B(View view) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(view) : (String[]) view.getTag(R.id.N);
    }

    public static void B0(View view, boolean z2) {
        Api21Impl.m(view, z2);
    }

    public static int C(View view) {
        return view.getPaddingEnd();
    }

    public static void C0(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.n(view, onApplyWindowInsetsListener);
    }

    public static int D(View view) {
        return view.getPaddingStart();
    }

    public static void D0(View view, int i3, int i4, int i5, int i6) {
        view.setPaddingRelative(i3, i4, i5, i6);
    }

    public static ViewParent E(View view) {
        return view.getParentForAccessibility();
    }

    public static void E0(View view, PointerIconCompat pointerIconCompat) {
        Api24Impl.a(view, (PointerIcon) (pointerIconCompat != null ? pointerIconCompat.a() : null));
    }

    public static WindowInsetsCompat F(View view) {
        return Api23Impl.a(view);
    }

    public static void F0(View view, boolean z2) {
        l0().f(view, Boolean.valueOf(z2));
    }

    public static CharSequence G(View view) {
        return (CharSequence) M0().e(view);
    }

    public static void G0(View view, int i3, int i4) {
        Api23Impl.b(view, i3, i4);
    }

    public static String H(View view) {
        return Api21Impl.f(view);
    }

    public static void H0(View view, CharSequence charSequence) {
        M0().f(view, charSequence);
    }

    public static float I(View view) {
        return Api21Impl.g(view);
    }

    public static void I0(View view, String str) {
        Api21Impl.o(view, str);
    }

    public static WindowInsetsControllerCompat J(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void J0(View view, float f3) {
        Api21Impl.p(view, f3);
    }

    public static int K(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void K0(View view, WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.d(view, callback);
    }

    public static float L(View view) {
        return Api21Impl.h(view);
    }

    public static void L0(View view, float f3) {
        Api21Impl.q(view, f3);
    }

    public static boolean M(View view) {
        return l(view) != null;
    }

    private static AccessibilityViewProperty M0() {
        return new AccessibilityViewProperty<CharSequence>(R.id.P, CharSequence.class, 64, 30) { // from class: androidx.core.view.ViewCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public CharSequence c(View view) {
                return Api30Impl.a(view);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public void d(View view, CharSequence charSequence) {
                Api30Impl.c(view, charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public boolean g(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean N(View view) {
        return view.hasOnClickListeners();
    }

    public static void N0(View view) {
        Api21Impl.r(view);
    }

    public static boolean O(View view) {
        return view.hasTransientState();
    }

    public static boolean P(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean Q(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean R(View view) {
        return view.isLaidOut();
    }

    public static boolean S(View view) {
        return Api21Impl.i(view);
    }

    public static boolean T(View view) {
        return view.isPaddingRelative();
    }

    public static boolean U(View view) {
        Boolean bool = (Boolean) l0().e(view);
        return bool != null && bool.booleanValue();
    }

    static void V(View view, int i3) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = n(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i3);
                if (z2) {
                    accessibilityEventObtain.getText().add(n(view));
                    x0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i3 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i3);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(n(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i3);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e3);
                }
            }
        }
    }

    public static void W(View view, int i3) {
        view.offsetLeftAndRight(i3);
    }

    public static void X(View view, int i3) {
        view.offsetTopAndBottom(i3);
    }

    public static WindowInsetsCompat Y(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsetsY = windowInsetsCompat.y();
        if (windowInsetsY != null) {
            WindowInsets windowInsetsB = Api20Impl.b(view, windowInsetsY);
            if (!windowInsetsB.equals(windowInsetsY)) {
                return WindowInsetsCompat.A(windowInsetsB, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void Z(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.Y0());
    }

    private static AccessibilityViewProperty a0() {
        return new AccessibilityViewProperty<CharSequence>(R.id.K, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public CharSequence c(View view) {
                return Api28Impl.a(view);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public void d(View view, CharSequence charSequence) {
                Api28Impl.e(view, charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public boolean g(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    private static AccessibilityViewProperty b() {
        return new AccessibilityViewProperty<Boolean>(R.id.J, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public Boolean c(View view) {
                return Boolean.valueOf(Api28Impl.b(view));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public void d(View view, Boolean bool) {
                Api28Impl.d(view, bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public boolean g(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static boolean b0(View view, int i3, Bundle bundle) {
        return view.performAccessibilityAction(i3, bundle);
    }

    public static int c(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int iP = p(view, charSequence);
        if (iP != -1) {
            d(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iP, charSequence, accessibilityViewCommand));
        }
        return iP;
    }

    public static ContentInfoCompat c0(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.M);
        if (onReceiveContentListener == null) {
            return u(view).a(contentInfoCompat);
        }
        ContentInfoCompat contentInfoCompatA = onReceiveContentListener.a(view, contentInfoCompat);
        if (contentInfoCompatA == null) {
            return null;
        }
        return u(view).a(contentInfoCompatA);
    }

    private static void d(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        i(view);
        h0(accessibilityActionCompat.b(), view);
        o(view).add(accessibilityActionCompat);
        V(view, 0);
    }

    public static void d0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static ViewPropertyAnimatorCompat e(View view) {
        if (f34444a == null) {
            f34444a = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) f34444a.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        f34444a.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static void e0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static WindowInsetsCompat f(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Api21Impl.b(view, windowInsetsCompat, rect);
    }

    public static void f0(View view, Runnable runnable, long j3) {
        view.postOnAnimationDelayed(runnable, j3);
    }

    public static WindowInsetsCompat g(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsetsY = windowInsetsCompat.y();
        if (windowInsetsY != null) {
            WindowInsets windowInsetsA = Api20Impl.a(view, windowInsetsY);
            if (!windowInsetsA.equals(windowInsetsY)) {
                return WindowInsetsCompat.A(windowInsetsA, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void g0(View view, int i3) {
        h0(i3, view);
        V(view, 0);
    }

    static boolean h(View view, KeyEvent keyEvent) {
        return false;
    }

    private static void h0(int i3, View view) {
        List listO = o(view);
        for (int i4 = 0; i4 < listO.size(); i4++) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listO.get(i4)).b() == i3) {
                listO.remove(i4);
                return;
            }
        }
    }

    static void i(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompatK = k(view);
        if (accessibilityDelegateCompatK == null) {
            accessibilityDelegateCompatK = new AccessibilityDelegateCompat();
        }
        m0(view, accessibilityDelegateCompatK);
    }

    public static void i0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            g0(view, accessibilityActionCompat.b());
        } else {
            d(view, accessibilityActionCompat.a(charSequence, accessibilityViewCommand));
        }
    }

    public static int j() {
        return View.generateViewId();
    }

    public static void j0(View view) {
        Api20Impl.c(view);
    }

    public static AccessibilityDelegateCompat k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateL).f34379a : new AccessibilityDelegateCompat(accessibilityDelegateL);
    }

    public static void k0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(view, context, iArr, attributeSet, typedArray, i3, i4);
        }
    }

    private static View.AccessibilityDelegate l(View view) {
        return Build.VERSION.SDK_INT >= 29 ? Api29Impl.a(view) : m(view);
    }

    private static AccessibilityViewProperty l0() {
        return new AccessibilityViewProperty<Boolean>(R.id.O, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public Boolean c(View view) {
                return Boolean.valueOf(Api28Impl.c(view));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public void d(View view, Boolean bool) {
                Api28Impl.f(view, bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public boolean g(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    private static View.AccessibilityDelegate m(View view) {
        if (f34446c) {
            return null;
        }
        if (f34445b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f34445b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f34446c = true;
                return null;
            }
        }
        try {
            Object obj = f34445b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f34446c = true;
            return null;
        }
    }

    public static void m0(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (l(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        x0(view);
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.d());
    }

    public static CharSequence n(View view) {
        return (CharSequence) a0().e(view);
    }

    public static void n0(View view, boolean z2) {
        b().f(view, Boolean.valueOf(z2));
    }

    private static List o(View view) {
        int i3 = R.id.H;
        ArrayList arrayList = (ArrayList) view.getTag(i3);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i3, arrayList2);
        return arrayList2;
    }

    public static void o0(View view, int i3) {
        view.setAccessibilityLiveRegion(i3);
    }

    private static int p(View view, CharSequence charSequence) {
        List listO = o(view);
        for (int i3 = 0; i3 < listO.size(); i3++) {
            if (TextUtils.equals(charSequence, ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listO.get(i3)).c())) {
                return ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listO.get(i3)).b();
            }
        }
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int[] iArr = f34447d;
            if (i5 >= iArr.length || i4 != -1) {
                break;
            }
            int i6 = iArr[i5];
            boolean z2 = true;
            for (int i7 = 0; i7 < listO.size(); i7++) {
                z2 &= ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listO.get(i7)).b() != i6;
            }
            if (z2) {
                i4 = i6;
            }
            i5++;
        }
        return i4;
    }

    public static void p0(View view, CharSequence charSequence) {
        a0().f(view, charSequence);
        if (charSequence != null) {
            f34449f.a(view);
        } else {
            f34449f.c(view);
        }
    }

    public static ColorStateList q(View view) {
        return Api21Impl.c(view);
    }

    public static void q0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static PorterDuff.Mode r(View view) {
        return Api21Impl.d(view);
    }

    public static void r0(View view, ColorStateList colorStateList) {
        Api21Impl.j(view, colorStateList);
    }

    public static Display s(View view) {
        return view.getDisplay();
    }

    public static void s0(View view, PorterDuff.Mode mode) {
        Api21Impl.k(view, mode);
    }

    public static float t(View view) {
        return Api21Impl.e(view);
    }

    public static void t0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior u(View view) {
        return view instanceof OnReceiveContentViewBehavior ? (OnReceiveContentViewBehavior) view : f34448e;
    }

    public static void u0(View view, float f3) {
        Api21Impl.l(view, f3);
    }

    public static boolean v(View view) {
        return view.getFitsSystemWindows();
    }

    public static void v0(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    public static int w(View view) {
        return view.getImportantForAccessibility();
    }

    public static void w0(View view, int i3) {
        view.setImportantForAccessibility(i3);
    }

    public static int x(View view) {
        return Api26Impl.a(view);
    }

    private static void x0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static int y(View view) {
        return view.getLayoutDirection();
    }

    public static void y0(View view, int i3) {
        Api26Impl.b(view, i3);
    }

    public static int z(View view) {
        return view.getMinimumHeight();
    }

    public static void z0(View view, int i3) {
        view.setLabelFor(i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakHashMap f34450a = new WeakHashMap();

        AccessibilityPaneVisibilityManager() {
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void d(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.f34450a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                b(view);
            }
        }

        void c(View view) {
            this.f34450a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ ContentInfoCompat a(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }
}

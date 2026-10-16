package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WindowInsetsCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WindowInsetsCompat f34517b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Impl f34518a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21ReflectionHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f34519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f34520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f34521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f34522d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f34519a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f34520b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f34521c = declaredField3;
                declaredField3.setAccessible(true);
                f34522d = true;
            } catch (ReflectiveOperationException e3) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e3.getMessage(), e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BuilderImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowInsetsCompat f34524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Insets[] f34525b;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        protected final void a() {
            Insets[] insetsArr = this.f34525b;
            if (insetsArr != null) {
                Insets insetsF = insetsArr[Type.e(1)];
                Insets insetsF2 = this.f34525b[Type.e(2)];
                if (insetsF2 == null) {
                    insetsF2 = this.f34524a.f(2);
                }
                if (insetsF == null) {
                    insetsF = this.f34524a.f(1);
                }
                g(Insets.a(insetsF, insetsF2));
                Insets insets = this.f34525b[Type.e(16)];
                if (insets != null) {
                    f(insets);
                }
                Insets insets2 = this.f34525b[Type.e(32)];
                if (insets2 != null) {
                    d(insets2);
                }
                Insets insets3 = this.f34525b[Type.e(64)];
                if (insets3 != null) {
                    h(insets3);
                }
            }
        }

        WindowInsetsCompat b() {
            a();
            return this.f34524a;
        }

        void c(int i3, Insets insets) {
            if (this.f34525b == null) {
                this.f34525b = new Insets[9];
            }
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    this.f34525b[Type.e(i4)] = insets;
                }
            }
        }

        BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.f34524a = windowInsetsCompat;
        }

        void d(Insets insets) {
        }

        void e(Insets insets) {
        }

        void f(Insets insets) {
        }

        void g(Insets insets) {
        }

        void h(Insets insets) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void c(int i3, Insets insets) {
            this.f34532c.setInsets(TypeImpl30.a(i3), insets.e());
        }

        BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat a() {
            return WindowInsetsCompat.z(this.f34540c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            return Objects.equals(this.f34540c, impl28.f34540c) && Objects.equals(this.f34544g, impl28.f34544g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        DisplayCutoutCompat f() {
            return DisplayCutoutCompat.f(this.f34540c.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.f34540c.hashCode();
        }

        Impl28(WindowInsetsCompat windowInsetsCompat, Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl30 extends Impl29 {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final WindowInsetsCompat f34549q = WindowInsetsCompat.z(WindowInsets.CONSUMED);

        Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets g(int i3) {
            return Insets.d(this.f34540c.getInsets(TypeImpl30.a(i3)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets h(int i3) {
            return Insets.d(this.f34540c.getInsetsIgnoringVisibility(TypeImpl30.a(i3)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean q(int i3) {
            return this.f34540c.isVisible(TypeImpl30.a(i3));
        }

        Impl30(WindowInsetsCompat windowInsetsCompat, Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        final void d(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Type {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        static int a() {
            return -1;
        }

        public static int b() {
            return 4;
        }

        public static int c() {
            return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }

        public static int d() {
            return 8;
        }

        static int e(int i3) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 4) {
                return 2;
            }
            if (i3 == 8) {
                return 3;
            }
            if (i3 == 16) {
                return 4;
            }
            if (i3 == 32) {
                return 5;
            }
            if (i3 == 64) {
                return 6;
            }
            if (i3 == 128) {
                return 7;
            }
            if (i3 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i3);
        }

        public static int f() {
            return 32;
        }

        public static int g() {
            return 2;
        }

        public static int h() {
            return 1;
        }

        public static int i() {
            return 7;
        }

        public static int j() {
            return 16;
        }

        public static int k() {
            return 64;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TypeImpl30 {
        static int a(int i3) {
            int iStatusBars;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i3 & i5) != 0) {
                    if (i5 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i4 |= iStatusBars;
                }
            }
            return i4;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f34517b = Impl30.f34549q;
        } else {
            f34517b = Impl.f34533b;
        }
    }

    private WindowInsetsCompat(WindowInsets windowInsets) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f34518a = new Impl30(this, windowInsets);
        } else if (i3 >= 29) {
            this.f34518a = new Impl29(this, windowInsets);
        } else {
            this.f34518a = new Impl28(this, windowInsets);
        }
    }

    public static WindowInsetsCompat A(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.h(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.w(ViewCompat.F(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    static Insets q(Insets insets, int i3, int i4, int i5, int i6) {
        int iMax = Math.max(0, insets.f33964a - i3);
        int iMax2 = Math.max(0, insets.f33965b - i4);
        int iMax3 = Math.max(0, insets.f33966c - i5);
        int iMax4 = Math.max(0, insets.f33967d - i6);
        return (iMax == i3 && iMax2 == i4 && iMax3 == i5 && iMax4 == i6) ? insets : Insets.b(iMax, iMax2, iMax3, iMax4);
    }

    public static WindowInsetsCompat z(WindowInsets windowInsets) {
        return A(windowInsets, null);
    }

    public WindowInsetsCompat a() {
        return this.f34518a.a();
    }

    public WindowInsetsCompat b() {
        return this.f34518a.b();
    }

    public WindowInsetsCompat c() {
        return this.f34518a.c();
    }

    void d(View view) {
        this.f34518a.d(view);
    }

    public DisplayCutoutCompat e() {
        return this.f34518a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.a(this.f34518a, ((WindowInsetsCompat) obj).f34518a);
        }
        return false;
    }

    public Insets f(int i3) {
        return this.f34518a.g(i3);
    }

    public Insets g(int i3) {
        return this.f34518a.h(i3);
    }

    public Insets h() {
        return this.f34518a.j();
    }

    public int hashCode() {
        Impl impl = this.f34518a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public Insets i() {
        return this.f34518a.k();
    }

    public int j() {
        return this.f34518a.l().f33967d;
    }

    public int k() {
        return this.f34518a.l().f33964a;
    }

    public int l() {
        return this.f34518a.l().f33966c;
    }

    public int m() {
        return this.f34518a.l().f33965b;
    }

    public boolean n() {
        Insets insetsF = f(Type.a());
        Insets insets = Insets.f33963e;
        return (insetsF.equals(insets) && g(Type.a() ^ Type.d()).equals(insets) && e() == null) ? false : true;
    }

    public boolean o() {
        return !this.f34518a.l().equals(Insets.f33963e);
    }

    public WindowInsetsCompat p(int i3, int i4, int i5, int i6) {
        return this.f34518a.n(i3, i4, i5, i6);
    }

    public boolean r() {
        return this.f34518a.o();
    }

    public boolean s(int i3) {
        return this.f34518a.q(i3);
    }

    public WindowInsetsCompat t(int i3, int i4, int i5, int i6) {
        return new Builder(this).d(Insets.b(i3, i4, i5, i6)).a();
    }

    void u(Insets[] insetsArr) {
        this.f34518a.r(insetsArr);
    }

    void v(Insets insets) {
        this.f34518a.s(insets);
    }

    void w(WindowInsetsCompat windowInsetsCompat) {
        this.f34518a.t(windowInsetsCompat);
    }

    void x(Insets insets) {
        this.f34518a.u(insets);
    }

    public WindowInsets y() {
        Impl impl = this.f34518a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f34540c;
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BuilderImpl20 extends BuilderImpl {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Field f34526e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f34527f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static Constructor f34528g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f34529h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsets f34530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Insets f34531d;

        BuilderImpl20() {
            this.f34530c = i();
        }

        private static WindowInsets i() {
            if (!f34527f) {
                try {
                    f34526e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e3);
                }
                f34527f = true;
            }
            Field field = f34526e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e4);
                }
            }
            if (!f34529h) {
                try {
                    f34528g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e5);
                }
                f34529h = true;
            }
            Constructor constructor = f34528g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e6);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompatZ = WindowInsetsCompat.z(this.f34530c);
            windowInsetsCompatZ.u(this.f34525b);
            windowInsetsCompatZ.x(this.f34531d);
            return windowInsetsCompatZ;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void e(Insets insets) {
            this.f34531d = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void g(Insets insets) {
            WindowInsets windowInsets = this.f34530c;
            if (windowInsets != null) {
                this.f34530c = windowInsets.replaceSystemWindowInsets(insets.f33964a, insets.f33965b, insets.f33966c, insets.f33967d);
            }
        }

        BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f34530c = windowInsetsCompat.y();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BuilderImpl29 extends BuilderImpl {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f34532c;

        BuilderImpl29() {
            this.f34532c = r0.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompatZ = WindowInsetsCompat.z(this.f34532c.build());
            windowInsetsCompatZ.u(this.f34525b);
            return windowInsetsCompatZ;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void d(Insets insets) {
            this.f34532c.setMandatorySystemGestureInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void e(Insets insets) {
            this.f34532c.setStableInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void f(Insets insets) {
            this.f34532c.setSystemGestureInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void g(Insets insets) {
            this.f34532c.setSystemWindowInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void h(Insets insets) {
            this.f34532c.setTappableElementInsets(insets.e());
        }

        BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builderA;
            super(windowInsetsCompat);
            WindowInsets windowInsetsY = windowInsetsCompat.y();
            if (windowInsetsY != null) {
                builderA = q0.a(windowInsetsY);
            } else {
                builderA = r0.a();
            }
            this.f34532c = builderA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl21 extends Impl20 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Insets f34545m;

        Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f34545m = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat b() {
            return WindowInsetsCompat.z(this.f34540c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat c() {
            return WindowInsetsCompat.z(this.f34540c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets j() {
            if (this.f34545m == null) {
                this.f34545m = Insets.b(this.f34540c.getStableInsetLeft(), this.f34540c.getStableInsetTop(), this.f34540c.getStableInsetRight(), this.f34540c.getStableInsetBottom());
            }
            return this.f34545m;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean o() {
            return this.f34540c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void u(Insets insets) {
            this.f34545m = insets;
        }

        Impl21(WindowInsetsCompat windowInsetsCompat, Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.f34545m = null;
            this.f34545m = impl21.f34545m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl20 extends Impl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f34535h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static Method f34536i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static Class f34537j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static Field f34538k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static Field f34539l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets f34540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Insets[] f34541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Insets f34542e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WindowInsetsCompat f34543f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Insets f34544g;

        Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f34542e = null;
            this.f34540c = windowInsets;
        }

        private static void A() {
            try {
                f34536i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f34537j = cls;
                f34538k = cls.getDeclaredField("mVisibleInsets");
                f34539l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f34538k.setAccessible(true);
                f34539l.setAccessible(true);
            } catch (ReflectiveOperationException e3) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
            }
            f34535h = true;
        }

        private Insets v(int i3, boolean z2) {
            Insets insetsA = Insets.f33963e;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    insetsA = Insets.a(insetsA, w(i4, z2));
                }
            }
            return insetsA;
        }

        private Insets x() {
            WindowInsetsCompat windowInsetsCompat = this.f34543f;
            return windowInsetsCompat != null ? windowInsetsCompat.h() : Insets.f33963e;
        }

        private Insets y(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f34535h) {
                A();
            }
            Method method = f34536i;
            if (method != null && f34537j != null && f34538k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f34538k.get(f34539l.get(objInvoke));
                    if (rect != null) {
                        return Insets.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e3) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e3.getMessage(), e3);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void d(View view) {
            Insets insetsY = y(view);
            if (insetsY == null) {
                insetsY = Insets.f33963e;
            }
            s(insetsY);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void e(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.w(this.f34543f);
            windowInsetsCompat.v(this.f34544g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f34544g, ((Impl20) obj).f34544g);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets g(int i3) {
            return v(i3, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets h(int i3) {
            return v(i3, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets l() {
            if (this.f34542e == null) {
                this.f34542e = Insets.b(this.f34540c.getSystemWindowInsetLeft(), this.f34540c.getSystemWindowInsetTop(), this.f34540c.getSystemWindowInsetRight(), this.f34540c.getSystemWindowInsetBottom());
            }
            return this.f34542e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat n(int i3, int i4, int i5, int i6) {
            Builder builder = new Builder(WindowInsetsCompat.z(this.f34540c));
            builder.d(WindowInsetsCompat.q(l(), i3, i4, i5, i6));
            builder.c(WindowInsetsCompat.q(j(), i3, i4, i5, i6));
            return builder.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean p() {
            return this.f34540c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean q(int i3) {
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0 && !z(i4)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void r(Insets[] insetsArr) {
            this.f34541d = insetsArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void s(Insets insets) {
            this.f34544g = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void t(WindowInsetsCompat windowInsetsCompat) {
            this.f34543f = windowInsetsCompat;
        }

        protected Insets w(int i3, boolean z2) {
            Insets insetsH;
            int i4;
            if (i3 == 1) {
                return z2 ? Insets.b(0, Math.max(x().f33965b, l().f33965b), 0, 0) : Insets.b(0, l().f33965b, 0, 0);
            }
            if (i3 == 2) {
                if (z2) {
                    Insets insetsX = x();
                    Insets insetsJ = j();
                    return Insets.b(Math.max(insetsX.f33964a, insetsJ.f33964a), 0, Math.max(insetsX.f33966c, insetsJ.f33966c), Math.max(insetsX.f33967d, insetsJ.f33967d));
                }
                Insets insetsL = l();
                WindowInsetsCompat windowInsetsCompat = this.f34543f;
                insetsH = windowInsetsCompat != null ? windowInsetsCompat.h() : null;
                int iMin = insetsL.f33967d;
                if (insetsH != null) {
                    iMin = Math.min(iMin, insetsH.f33967d);
                }
                return Insets.b(insetsL.f33964a, 0, insetsL.f33966c, iMin);
            }
            if (i3 != 8) {
                if (i3 == 16) {
                    return k();
                }
                if (i3 == 32) {
                    return i();
                }
                if (i3 == 64) {
                    return m();
                }
                if (i3 != 128) {
                    return Insets.f33963e;
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f34543f;
                DisplayCutoutCompat displayCutoutCompatE = windowInsetsCompat2 != null ? windowInsetsCompat2.e() : f();
                return displayCutoutCompatE != null ? Insets.b(displayCutoutCompatE.b(), displayCutoutCompatE.d(), displayCutoutCompatE.c(), displayCutoutCompatE.a()) : Insets.f33963e;
            }
            Insets[] insetsArr = this.f34541d;
            insetsH = insetsArr != null ? insetsArr[Type.e(8)] : null;
            if (insetsH != null) {
                return insetsH;
            }
            Insets insetsL2 = l();
            Insets insetsX2 = x();
            int i5 = insetsL2.f33967d;
            if (i5 > insetsX2.f33967d) {
                return Insets.b(0, 0, 0, i5);
            }
            Insets insets = this.f34544g;
            return (insets == null || insets.equals(Insets.f33963e) || (i4 = this.f34544g.f33967d) <= insetsX2.f33967d) ? Insets.f33963e : Insets.b(0, 0, 0, i4);
        }

        protected boolean z(int i3) {
            if (i3 != 1 && i3 != 2) {
                if (i3 == 4) {
                    return false;
                }
                if (i3 != 8 && i3 != 128) {
                    return true;
                }
            }
            return !w(i3, false).equals(Insets.f33963e);
        }

        Impl20(WindowInsetsCompat windowInsetsCompat, Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f34540c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl29 extends Impl28 {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Insets f34546n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Insets f34547o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Insets f34548p;

        Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f34546n = null;
            this.f34547o = null;
            this.f34548p = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets i() {
            if (this.f34547o == null) {
                this.f34547o = Insets.d(this.f34540c.getMandatorySystemGestureInsets());
            }
            return this.f34547o;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets k() {
            if (this.f34546n == null) {
                this.f34546n = Insets.d(this.f34540c.getSystemGestureInsets());
            }
            return this.f34546n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets m() {
            if (this.f34548p == null) {
                this.f34548p = Insets.d(this.f34540c.getTappableElementInsets());
            }
            return this.f34548p;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat n(int i3, int i4, int i5, int i6) {
            return WindowInsetsCompat.z(this.f34540c.inset(i3, i4, i5, i6));
        }

        Impl29(WindowInsetsCompat windowInsetsCompat, Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.f34546n = null;
            this.f34547o = null;
            this.f34548p = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void u(Insets insets) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BuilderImpl f34523a;

        public Builder() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.f34523a = new BuilderImpl30();
            } else if (i3 >= 29) {
                this.f34523a = new BuilderImpl29();
            } else {
                this.f34523a = new BuilderImpl20();
            }
        }

        public WindowInsetsCompat a() {
            return this.f34523a.b();
        }

        public Builder b(int i3, Insets insets) {
            this.f34523a.c(i3, insets);
            return this;
        }

        public Builder c(Insets insets) {
            this.f34523a.e(insets);
            return this;
        }

        public Builder d(Insets insets) {
            this.f34523a.g(insets);
            return this;
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                this.f34523a = new BuilderImpl30(windowInsetsCompat);
            } else if (i3 >= 29) {
                this.f34523a = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.f34523a = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f34518a;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30 && (impl instanceof Impl30)) {
                this.f34518a = new Impl30(this, (Impl30) impl);
            } else if (i3 >= 29 && (impl instanceof Impl29)) {
                this.f34518a = new Impl29(this, (Impl29) impl);
            } else if (impl instanceof Impl28) {
                this.f34518a = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.f34518a = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.f34518a = new Impl20(this, (Impl20) impl);
            } else {
                this.f34518a = new Impl(this);
            }
            impl.e(this);
            return;
        }
        this.f34518a = new Impl(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final WindowInsetsCompat f34533b = new Builder().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WindowInsetsCompat f34534a;

        Impl(WindowInsetsCompat windowInsetsCompat) {
            this.f34534a = windowInsetsCompat;
        }

        WindowInsetsCompat a() {
            return this.f34534a;
        }

        WindowInsetsCompat b() {
            return this.f34534a;
        }

        WindowInsetsCompat c() {
            return this.f34534a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return p() == impl.p() && o() == impl.o() && ObjectsCompat.a(l(), impl.l()) && ObjectsCompat.a(j(), impl.j()) && ObjectsCompat.a(f(), impl.f());
        }

        DisplayCutoutCompat f() {
            return null;
        }

        Insets g(int i3) {
            return Insets.f33963e;
        }

        Insets h(int i3) {
            if ((i3 & 8) == 0) {
                return Insets.f33963e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return ObjectsCompat.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        Insets i() {
            return l();
        }

        Insets j() {
            return Insets.f33963e;
        }

        Insets k() {
            return l();
        }

        Insets l() {
            return Insets.f33963e;
        }

        Insets m() {
            return l();
        }

        WindowInsetsCompat n(int i3, int i4, int i5, int i6) {
            return f34533b;
        }

        boolean o() {
            return false;
        }

        boolean p() {
            return false;
        }

        boolean q(int i3) {
            return true;
        }

        void d(View view) {
        }

        void e(WindowInsetsCompat windowInsetsCompat) {
        }

        public void r(Insets[] insetsArr) {
        }

        void s(Insets insets) {
        }

        void t(WindowInsetsCompat windowInsetsCompat) {
        }

        public void u(Insets insets) {
        }
    }
}

package com.applovin.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.WindowManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f65341a = new HashMap(2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f65342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f65343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f65344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f65345d;

        /* JADX INFO: renamed from: com.applovin.impl.z3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class C0131a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f65346a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f65347b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f65348c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f65349d;

            C0131a() {
            }

            public C0131a a(int i3) {
                this.f65348c = i3;
                return this;
            }

            public C0131a b(int i3) {
                this.f65349d = i3;
                return this;
            }

            public C0131a c(int i3) {
                this.f65346a = i3;
                return this;
            }

            public C0131a d(int i3) {
                this.f65347b = i3;
                return this;
            }

            public String toString() {
                return "CompatibilityUtils.ScreenCornerRadii.ScreenCornerRadiiBuilder(topLeft=" + this.f65346a + ", topRight=" + this.f65347b + ", bottomLeft=" + this.f65348c + ", bottomRight=" + this.f65349d + ")";
            }

            public a a() {
                return new a(this.f65346a, this.f65347b, this.f65348c, this.f65349d);
            }
        }

        a(int i3, int i4, int i5, int i6) {
            this.f65342a = i3;
            this.f65343b = i4;
            this.f65344c = i5;
            this.f65345d = i6;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public int b() {
            return this.f65345d;
        }

        public int c() {
            return this.f65342a;
        }

        public int d() {
            return this.f65343b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a(this) && c() == aVar.c() && d() == aVar.d() && a() == aVar.a() && b() == aVar.b();
        }

        public int hashCode() {
            return ((((((c() + 59) * 59) + d()) * 59) + a()) * 59) + b();
        }

        public String toString() {
            return "CompatibilityUtils.ScreenCornerRadii(topLeft=" + c() + ", topRight=" + d() + ", bottomLeft=" + a() + ", bottomRight=" + b() + ")";
        }

        public int a() {
            return this.f65344c;
        }
    }

    public static Point a(Context context) {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        Point point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        StrictMode.setVmPolicy(vmPolicy);
        return point;
    }

    public static Point b(Context context) {
        int orientation = AppLovinSdkUtils.getOrientation(context);
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f63329u0;
        boolean z2 = jVar == null || ((Boolean) jVar.a(sj.l6)).booleanValue();
        if (!c(context) || z2) {
            Map map = f65341a;
            if (map.containsKey(Integer.valueOf(orientation))) {
                return (Point) map.get(Integer.valueOf(orientation));
            }
        }
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (b()) {
                Rect bounds = windowManager.getMaximumWindowMetrics().getBounds();
                point = new Point(bounds.width(), bounds.height());
            } else if (d()) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
        }
        StrictMode.setVmPolicy(vmPolicy);
        f65341a.put(Integer.valueOf(orientation), point);
        return point;
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.type.foldable") || packageManager.hasSystemFeature("android.hardware.sensor.hinge_angle");
    }

    public static boolean d() {
        return true;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return true;
    }

    public static boolean i() {
        return true;
    }

    public static boolean j() {
        return true;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    private static int a(int i3, Display display) {
        RoundedCorner roundedCorner = display.getRoundedCorner(i3);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return -1;
    }

    public static a a(Context context, com.applovin.impl.sdk.j jVar) {
        a aVarA = null;
        if (((Boolean) jVar.a(sj.X3)).booleanValue() && m()) {
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                try {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    aVarA = new a.C0131a().c(a(0, defaultDisplay)).d(a(1, defaultDisplay)).a(a(3, defaultDisplay)).b(a(2, defaultDisplay)).a();
                } catch (Throwable unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        }
        return aVarA;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static void a() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        } catch (Throwable unused) {
        }
    }
}

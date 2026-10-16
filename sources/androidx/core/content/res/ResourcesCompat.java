package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResourcesCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f33907a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f33908b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f33909c = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static Drawable a(Resources resources, int i3, Resources.Theme theme) {
            return resources.getDrawable(i3, theme);
        }

        static Drawable b(Resources resources, int i3, int i4, Resources.Theme theme) {
            return resources.getDrawableForDensity(i3, i4, theme);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static int a(Resources resources, int i3, Resources.Theme theme) {
            return resources.getColor(i3, theme);
        }

        static ColorStateList b(Resources resources, int i3, Resources.Theme theme) {
            return resources.getColorStateList(i3, theme);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static float a(Resources resources, int i3) {
            return resources.getFloat(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ColorStateListCacheEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f33910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f33911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f33912c;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f33910a = colorStateList;
            this.f33911b = configuration;
            this.f33912c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ColorStateListCacheKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Resources f33913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Resources.Theme f33914b;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.f33913a = resources;
            this.f33914b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ColorStateListCacheKey.class == obj.getClass()) {
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (this.f33913a.equals(colorStateListCacheKey.f33913a) && ObjectsCompat.a(this.f33914b, colorStateListCacheKey.f33914b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f33913a, this.f33914b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(final int i3, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f33932a.onFontRetrievalFailed(i3);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f33930a.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i3);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ThemeCompat {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api23Impl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Object f33915a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f33916b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f33917c;

            /* JADX WARN: Removed duplicated region for block: B:31:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            static void a(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f33915a
                    monitor-enter(r0)
                    boolean r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f33917c     // Catch: java.lang.Throwable -> L17
                    r2 = 0
                    if (r1 != 0) goto L23
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f33916b = r3     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    goto L21
                L17:
                    r6 = move-exception
                    goto L39
                L19:
                    r3 = move-exception
                    java.lang.String r4 = "ResourcesCompat"
                    java.lang.String r5 = "Failed to retrieve rebase() method"
                    android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L17
                L21:
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f33917c = r1     // Catch: java.lang.Throwable -> L17
                L23:
                    java.lang.reflect.Method r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f33916b     // Catch: java.lang.Throwable -> L17
                    if (r1 == 0) goto L37
                    r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L17 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d
                    goto L37
                L2b:
                    r6 = move-exception
                    goto L2e
                L2d:
                    r6 = move-exception
                L2e:
                    java.lang.String r1 = "ResourcesCompat"
                    java.lang.String r3 = "Failed to invoke rebase() method via reflection"
                    android.util.Log.i(r1, r3, r6)     // Catch: java.lang.Throwable -> L17
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f33916b = r2     // Catch: java.lang.Throwable -> L17
                L37:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    return
                L39:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.a(android.content.res.Resources$Theme):void");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Api29Impl {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.a(theme);
            } else {
                Api23Impl.a(theme);
            }
        }
    }

    private static void a(ColorStateListCacheKey colorStateListCacheKey, int i3, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f33909c) {
            try {
                WeakHashMap weakHashMap = f33908b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i3, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.f33913a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f33912c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.res.ColorStateList b(androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.f33909c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = androidx.core.content.res.ResourcesCompat.f33908b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f33911b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f33913a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f33914b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f33912c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f33912c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f33910a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.b(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return o(context, i3, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources resources, int i3, Resources.Theme theme) {
        return Api23Impl.a(resources, i3, theme);
    }

    public static ColorStateList e(Resources resources, int i3, Resources.Theme theme) {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList colorStateListB = b(colorStateListCacheKey, i3);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListM = m(resources, i3, theme);
        if (colorStateListM == null) {
            return Api23Impl.b(resources, i3, theme);
        }
        a(colorStateListCacheKey, i3, colorStateListM, theme);
        return colorStateListM;
    }

    public static Drawable f(Resources resources, int i3, Resources.Theme theme) {
        return Api21Impl.a(resources, i3, theme);
    }

    public static Drawable g(Resources resources, int i3, int i4, Resources.Theme theme) {
        return Api21Impl.b(resources, i3, i4, theme);
    }

    public static float h(Resources resources, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(resources, i3);
        }
        TypedValue typedValueL = l();
        resources.getValue(i3, typedValueL, true);
        if (typedValueL.type == 4) {
            return typedValueL.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i3) + " type #0x" + Integer.toHexString(typedValueL.type) + " is not valid");
    }

    public static Typeface i(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return o(context, i3, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface j(Context context, int i3, TypedValue typedValue, int i4, FontCallback fontCallback) {
        if (context.isRestricted()) {
            return null;
        }
        return o(context, i3, typedValue, i4, fontCallback, null, true, false);
    }

    public static void k(Context context, int i3, FontCallback fontCallback, Handler handler) {
        Preconditions.h(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            o(context, i3, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    private static TypedValue l() {
        ThreadLocal threadLocal = f33907a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList m(Resources resources, int i3, Resources.Theme theme) {
        if (n(resources, i3)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.a(resources, resources.getXml(i3), theme);
        } catch (Exception e3) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e3);
            return null;
        }
    }

    private static boolean n(Resources resources, int i3) {
        TypedValue typedValueL = l();
        resources.getValue(i3, typedValueL, true);
        int i4 = typedValueL.type;
        return i4 >= 28 && i4 <= 31;
    }

    private static Typeface o(Context context, int i3, TypedValue typedValue, int i4, FontCallback fontCallback, Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        Typeface typefaceP = p(context, resources, typedValue, i3, i4, fontCallback, handler, z2, z3);
        if (typefaceP != null || fontCallback != null || z3) {
            return typefaceP;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i3) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface p(android.content.Context r13, android.content.res.Resources r14, android.util.TypedValue r15, int r16, int r17, androidx.core.content.res.ResourcesCompat.FontCallback r18, android.os.Handler r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.p(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}

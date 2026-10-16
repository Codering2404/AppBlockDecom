package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ResourceManagerInternal f2062i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakHashMap f2064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SimpleArrayMap f2065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SparseArrayCompat f2066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHashMap f2067d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f2068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ResourceManagerHooks f2070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f2061h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ColorFilterLruCache f2063j = new ColorFilterLruCache(6);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AsldcInflateDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e3);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AvdcInflateDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e3);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i3) {
            super(i3);
        }

        private static int b(int i3, PorterDuff.Mode mode) {
            return ((i3 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter c(int i3, PorterDuff.Mode mode) {
            return get(Integer.valueOf(b(i3, mode)));
        }

        PorterDuffColorFilter d(int i3, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(b(i3, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DrawableDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    Compatibility.Api21Impl.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e3) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e3);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface InflateDelegate {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ResourceManagerHooks {
        Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i3);

        ColorStateList b(Context context, int i3);

        boolean c(Context context, int i3, Drawable drawable);

        PorterDuff.Mode d(int i3);

        boolean e(Context context, int i3, Drawable drawable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VdcInflateDelegate implements InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e3) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e3);
                return null;
            }
        }
    }

    private synchronized boolean a(Context context, long j3, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            LongSparseArray longSparseArray = (LongSparseArray) this.f2067d.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.f2067d.put(context, longSparseArray);
            }
            longSparseArray.m(j3, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(Context context, int i3, ColorStateList colorStateList) {
        if (this.f2064a == null) {
            this.f2064a = new WeakHashMap();
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.f2064a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f2064a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.a(i3, colorStateList);
    }

    private void c(Context context) {
        if (this.f2069f) {
            return;
        }
        this.f2069f = true;
        Drawable drawableI = i(context, R.drawable.f1244a);
        if (drawableI == null || !p(drawableI)) {
            this.f2069f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long d(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable e(Context context, int i3) {
        if (this.f2068e == null) {
            this.f2068e = new TypedValue();
        }
        TypedValue typedValue = this.f2068e;
        context.getResources().getValue(i3, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        ResourceManagerHooks resourceManagerHooks = this.f2070g;
        Drawable drawableA = resourceManagerHooks == null ? null : resourceManagerHooks.a(this, context, i3);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal g() {
        try {
            if (f2062i == null) {
                ResourceManagerInternal resourceManagerInternal = new ResourceManagerInternal();
                f2062i = resourceManagerInternal;
                o(resourceManagerInternal);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2062i;
    }

    private synchronized Drawable h(Context context, long j3) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f2067d.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.g(j3);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.p(j3);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter k(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterC;
        ColorFilterLruCache colorFilterLruCache = f2063j;
        porterDuffColorFilterC = colorFilterLruCache.c(i3, mode);
        if (porterDuffColorFilterC == null) {
            porterDuffColorFilterC = new PorterDuffColorFilter(i3, mode);
            colorFilterLruCache.d(i3, mode, porterDuffColorFilterC);
        }
        return porterDuffColorFilterC;
    }

    private ColorStateList m(Context context, int i3) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.f2064a;
        if (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.g(i3);
    }

    private static boolean p(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable q(Context context, int i3) {
        int next;
        SimpleArrayMap simpleArrayMap = this.f2065b;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = this.f2066c;
        if (sparseArrayCompat != null) {
            String str = (String) sparseArrayCompat.g(i3);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f2065b.get(str) == null)) {
                return null;
            }
        } else {
            this.f2066c = new SparseArrayCompat();
        }
        if (this.f2068e == null) {
            this.f2068e = new TypedValue();
        }
        TypedValue typedValue = this.f2068e;
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i3);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2066c.a(i3, name);
                InflateDelegate inflateDelegate = (InflateDelegate) this.f2065b.get(name);
                if (inflateDelegate != null) {
                    drawableH = inflateDelegate.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e3) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e3);
            }
        }
        if (drawableH == null) {
            this.f2066c.a(i3, "appcompat_skip_skip");
        }
        return drawableH;
    }

    private Drawable u(Context context, int i3, boolean z2, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i3);
        if (colorStateListL != null) {
            Drawable drawableR = DrawableCompat.r(drawable.mutate());
            DrawableCompat.o(drawableR, colorStateListL);
            PorterDuff.Mode modeN = n(i3);
            if (modeN != null) {
                DrawableCompat.p(drawableR, modeN);
            }
            return drawableR;
        }
        ResourceManagerHooks resourceManagerHooks = this.f2070g;
        if ((resourceManagerHooks == null || !resourceManagerHooks.e(context, i3, drawable)) && !w(context, i3, drawable) && z2) {
            return null;
        }
        return drawable;
    }

    static void v(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z2 = tintInfo.f2244d;
        if (z2 || tintInfo.f2243c) {
            drawable.setColorFilter(f(z2 ? tintInfo.f2241a : null, tintInfo.f2243c ? tintInfo.f2242b : f2061h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public synchronized Drawable i(Context context, int i3) {
        return j(context, i3, false);
    }

    synchronized Drawable j(Context context, int i3, boolean z2) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i3);
            if (drawableQ == null) {
                drawableQ = e(context, i3);
            }
            if (drawableQ == null) {
                drawableQ = ContextCompat.getDrawable(context, i3);
            }
            if (drawableQ != null) {
                drawableQ = u(context, i3, z2, drawableQ);
            }
            if (drawableQ != null) {
                DrawableUtils.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    synchronized ColorStateList l(Context context, int i3) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i3);
        if (colorStateListM == null) {
            ResourceManagerHooks resourceManagerHooks = this.f2070g;
            colorStateListM = resourceManagerHooks == null ? null : resourceManagerHooks.b(context, i3);
            if (colorStateListM != null) {
                b(context, i3, colorStateListM);
            }
        }
        return colorStateListM;
    }

    PorterDuff.Mode n(int i3) {
        ResourceManagerHooks resourceManagerHooks = this.f2070g;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.d(i3);
    }

    public synchronized void r(Context context) {
        LongSparseArray longSparseArray = (LongSparseArray) this.f2067d.get(context);
        if (longSparseArray != null) {
            longSparseArray.b();
        }
    }

    synchronized Drawable s(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i3) {
        try {
            Drawable drawableQ = q(context, i3);
            if (drawableQ == null) {
                drawableQ = vectorEnabledTintResources.a(i3);
            }
            if (drawableQ == null) {
                return null;
            }
            return u(context, i3, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(ResourceManagerHooks resourceManagerHooks) {
        this.f2070g = resourceManagerHooks;
    }

    boolean w(Context context, int i3, Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.f2070g;
        return resourceManagerHooks != null && resourceManagerHooks.c(context, i3, drawable);
    }

    private static void o(ResourceManagerInternal resourceManagerInternal) {
    }
}

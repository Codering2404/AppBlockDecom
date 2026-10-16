package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f2237c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList f2238d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f2239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources.Theme f2240b;

    private TintContextWrapper(Context context) {
        super(context);
        if (!VectorEnabledTintResources.d()) {
            this.f2239a = new TintResources(this, context.getResources());
            this.f2240b = null;
            return;
        }
        VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
        this.f2239a = vectorEnabledTintResources;
        Resources.Theme themeNewTheme = vectorEnabledTintResources.newTheme();
        this.f2240b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        return ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources) || !VectorEnabledTintResources.d()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f2237c) {
            try {
                ArrayList arrayList = f2238d;
                if (arrayList == null) {
                    f2238d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f2238d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f2238d.remove(size);
                        }
                    }
                    for (int size2 = f2238d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f2238d.get(size2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? (TintContextWrapper) weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                f2238d.add(new WeakReference(tintContextWrapper2));
                return tintContextWrapper2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2239a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2239a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2240b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        Resources.Theme theme = this.f2240b;
        if (theme == null) {
            super.setTheme(i3);
        } else {
            theme.applyStyle(i3, true);
        }
    }
}

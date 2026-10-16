package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Configuration f1266f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f1268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f1269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f1270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f1271e;

    public ContextThemeWrapper(Context context, int i3) {
        super(context);
        this.f1267a = i3;
    }

    private Resources b() {
        if (this.f1271e == null) {
            Configuration configuration = this.f1270d;
            if (configuration == null || e(configuration)) {
                this.f1271e = super.getResources();
            } else {
                this.f1271e = createConfigurationContext(this.f1270d).getResources();
            }
        }
        return this.f1271e;
    }

    private void d() {
        boolean z2 = this.f1268b == null;
        if (z2) {
            this.f1268b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1268b.setTo(theme);
            }
        }
        f(this.f1268b, this.f1267a, z2);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f1266f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f1266f = configuration2;
        }
        return configuration.equals(f1266f);
    }

    public void a(Configuration configuration) {
        if (this.f1271e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f1270d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f1270d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f1267a;
    }

    protected void f(Resources.Theme theme, int i3, boolean z2) {
        theme.applyStyle(i3, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1269c == null) {
            this.f1269c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1269c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1268b;
        if (theme != null) {
            return theme;
        }
        if (this.f1267a == 0) {
            this.f1267a = R.style.f804f;
        }
        d();
        return this.f1268b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        if (this.f1267a != i3) {
            this.f1267a = i3;
            d();
        }
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f1268b = theme;
    }
}

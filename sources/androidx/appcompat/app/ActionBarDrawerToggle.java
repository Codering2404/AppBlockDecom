package androidx.appcompat.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Delegate f901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawerLayout f902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DrawerArrowDrawable f903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View.OnClickListener f908h;

    /* JADX INFO: renamed from: androidx.appcompat.app.ActionBarDrawerToggle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionBarDrawerToggle f909a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBarDrawerToggle actionBarDrawerToggle = this.f909a;
            if (actionBarDrawerToggle.f905e) {
                actionBarDrawerToggle.g();
                return;
            }
            View.OnClickListener onClickListener = actionBarDrawerToggle.f908h;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Delegate {
        void a(int i3);

        void b(Drawable drawable, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DelegateProvider {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameworkActionBarDelegate implements Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f910a;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void a(int i3) {
            android.app.ActionBar actionBar = this.f910a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i3);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void b(Drawable drawable, int i3) {
            android.app.ActionBar actionBar = this.f910a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ToolbarCompatDelegate implements Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Toolbar f911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharSequence f912b;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void a(int i3) {
            if (i3 == 0) {
                this.f911a.setNavigationContentDescription(this.f912b);
            } else {
                this.f911a.setNavigationContentDescription(i3);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void b(Drawable drawable, int i3) {
            this.f911a.setNavigationIcon(drawable);
            a(i3);
        }
    }

    private void f(float f3) {
        if (f3 == 1.0f) {
            this.f903c.g(true);
        } else if (f3 == 0.0f) {
            this.f903c.g(false);
        }
        this.f903c.setProgress(f3);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void a(View view) {
        f(1.0f);
        if (this.f905e) {
            e(this.f907g);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void b(View view) {
        f(0.0f);
        if (this.f905e) {
            e(this.f906f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void d(View view, float f3) {
        if (this.f904d) {
            f(Math.min(1.0f, Math.max(0.0f, f3)));
        } else {
            f(0.0f);
        }
    }

    void e(int i3) {
        this.f901a.a(i3);
    }

    void g() {
        int iQ = this.f902b.q(8388611);
        if (this.f902b.E(8388611) && iQ != 2) {
            this.f902b.d(8388611);
        } else if (iQ != 1) {
            this.f902b.J(8388611);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void c(int i3) {
    }
}

package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f39831g = {R.attr.homeAsUpIndicator};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Activity f39832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Delegate f39833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SlideDrawable f39835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f39836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f39837f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface Delegate {
        void a(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface DelegateProvider {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SetIndicatorInfo {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f39838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f39839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f39840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f39841d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionBarDrawerToggle f39842f;

        public float a() {
            return this.f39840c;
        }

        public void b(float f3) {
            this.f39840c = f3;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            copyBounds(this.f39839b);
            canvas.save();
            boolean z2 = ViewCompat.y(this.f39842f.f39832a.getWindow().getDecorView()) == 1;
            int i3 = z2 ? -1 : 1;
            float fWidth = this.f39839b.width();
            canvas.translate((-this.f39841d) * fWidth * this.f39840c * i3, 0.0f);
            if (z2 && !this.f39838a) {
                canvas.translate(fWidth, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    private void e(int i3) {
        Delegate delegate = this.f39833b;
        if (delegate != null) {
            delegate.a(i3);
            return;
        }
        ActionBar actionBar = this.f39832a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i3);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void a(View view) {
        this.f39835d.b(1.0f);
        if (this.f39834c) {
            e(this.f39837f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void b(View view) {
        this.f39835d.b(0.0f);
        if (this.f39834c) {
            e(this.f39836e);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void d(View view, float f3) {
        float fA = this.f39835d.a();
        this.f39835d.b(f3 > 0.5f ? Math.max(fA, Math.max(0.0f, f3 - 0.5f) * 2.0f) : Math.min(fA, f3 * 2.0f));
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void c(int i3) {
    }
}

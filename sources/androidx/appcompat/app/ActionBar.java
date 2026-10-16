package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i3, long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static abstract class Tab {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract int d();

        public abstract CharSequence e();

        public abstract void f();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface TabListener {
        void a(Tab tab, FragmentTransaction fragmentTransaction);

        void b(Tab tab, FragmentTransaction fragmentTransaction);

        void c(Tab tab, FragmentTransaction fragmentTransaction);
    }

    public abstract void A(CharSequence charSequence);

    public ActionMode C(ActionMode.Callback callback) {
        return null;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract int i();

    public Context j() {
        return null;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public boolean o(int i3, KeyEvent keyEvent) {
        return false;
    }

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(Drawable drawable);

    public abstract void t(boolean z2);

    public abstract void u(boolean z2);

    public void v(float f3) {
        if (f3 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f900a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f900a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f879t);
            this.f900a = typedArrayObtainStyledAttributes.getInt(R.styleable.f882u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f900a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f900a = 0;
            this.f900a = layoutParams.f900a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f900a = 0;
        }
    }

    void n() {
    }

    public void B(CharSequence charSequence) {
    }

    public void h(boolean z2) {
    }

    public void m(Configuration configuration) {
    }

    public void s(boolean z2) {
    }

    public void w(int i3) {
    }

    public void x(int i3) {
    }

    public void y(Drawable drawable) {
    }

    public void z(boolean z2) {
    }
}

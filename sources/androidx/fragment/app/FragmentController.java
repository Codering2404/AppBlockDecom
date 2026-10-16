package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FragmentController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentHostCallback f37203a;

    private FragmentController(FragmentHostCallback fragmentHostCallback) {
        this.f37203a = fragmentHostCallback;
    }

    public static FragmentController b(FragmentHostCallback fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.i(fragmentHostCallback, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentHostCallback fragmentHostCallback = this.f37203a;
        fragmentHostCallback.f37209f.o(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void c() {
        this.f37203a.f37209f.B();
    }

    public boolean d(MenuItem menuItem) {
        return this.f37203a.f37209f.E(menuItem);
    }

    public void e() {
        this.f37203a.f37209f.F();
    }

    public void f() {
        this.f37203a.f37209f.H();
    }

    public void g() {
        this.f37203a.f37209f.Q();
    }

    public void h() {
        this.f37203a.f37209f.U();
    }

    public void i() {
        this.f37203a.f37209f.V();
    }

    public void j() {
        this.f37203a.f37209f.X();
    }

    public boolean k() {
        return this.f37203a.f37209f.e0(true);
    }

    public FragmentManager l() {
        return this.f37203a.f37209f;
    }

    public void m() {
        this.f37203a.f37209f.d1();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f37203a.f37209f.F0().onCreateView(view, str, context, attributeSet);
    }
}

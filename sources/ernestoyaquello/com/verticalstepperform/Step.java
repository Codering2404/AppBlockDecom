package ernestoyaquello.com.verticalstepperform;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Step<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f134585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f134586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f134587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f134588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f134589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f134590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f134591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f134592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f134593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VerticalStepperFormView f134594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f134595k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface InternalFormStepListener {
        void a(int i3, boolean z2);

        void b(int i3, boolean z2);

        void c(int i3, boolean z2);

        void d(int i3, boolean z2);

        void e(int i3, boolean z2);

        void f(int i3, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class IsDataValid {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f134596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f134597b;

        public IsDataValid(boolean z2) {
            this(z2, "");
        }

        public String a() {
            return this.f134597b;
        }

        public boolean b() {
            return this.f134596a;
        }

        public IsDataValid(boolean z2, String str) {
            this.f134596a = z2;
            this.f134597b = str;
        }
    }

    private void B(String str, boolean z2) {
        if (str == null) {
            str = "";
        }
        this.f134588d = str;
        v(z2);
    }

    private void D(boolean z2, String str, boolean z3) {
        this.f134589e = z2;
        B(str, z3);
        w(z3);
        if (z2) {
            r(z3);
            return;
        }
        VerticalStepperFormView verticalStepperFormView = this.f134594j;
        if (verticalStepperFormView != null) {
            verticalStepperFormView.setFormCompleted(Boolean.FALSE);
            this.f134594j.A(this.f134593i);
        }
        s(z3);
    }

    private void E(boolean z2, boolean z3) {
        this.f134590f = z2;
        x(z3);
        if (z2) {
            t(z3);
        } else {
            q(z3);
        }
    }

    private void u(boolean z2) {
        Iterator it = this.f134595k.iterator();
        while (it.hasNext()) {
            ((InternalFormStepListener) it.next()).d(f(), z2);
        }
    }

    private void v(boolean z2) {
        Iterator it = this.f134595k.iterator();
        while (it.hasNext()) {
            ((InternalFormStepListener) it.next()).b(f(), z2);
        }
    }

    private void w(boolean z2) {
        Iterator it = this.f134595k.iterator();
        while (it.hasNext()) {
            ((InternalFormStepListener) it.next()).a(f(), z2);
        }
    }

    private void x(boolean z2) {
        Iterator it = this.f134595k.iterator();
        while (it.hasNext()) {
            ((InternalFormStepListener) it.next()).f(f(), z2);
        }
    }

    private void y(boolean z2) {
        Iterator it = this.f134595k.iterator();
        while (it.hasNext()) {
            ((InternalFormStepListener) it.next()).e(f(), z2);
        }
    }

    private void z(boolean z2) {
        Iterator it = this.f134595k.iterator();
        while (it.hasNext()) {
            ((InternalFormStepListener) it.next()).c(f(), z2);
        }
    }

    void A(boolean z2) {
        if (this.f134590f) {
            return;
        }
        E(true, z2);
    }

    protected void C(String str, boolean z2) {
        if (str == null) {
            str = "";
        }
        this.f134587c = str;
        u(z2);
    }

    protected void F(String str, boolean z2) {
        if (str == null) {
            str = "";
        }
        this.f134586b = str;
        y(z2);
    }

    protected void G(String str, boolean z2) {
        if (str == null) {
            str = "";
        }
        this.f134585a = str;
        z(z2);
    }

    void a(boolean z2) {
        if (this.f134590f) {
            E(false, z2);
        }
    }

    public View b() {
        return this.f134592h;
    }

    public View c() {
        return this.f134591g;
    }

    public String d() {
        String str = this.f134588d;
        return str == null ? "" : str;
    }

    public String e() {
        String str = this.f134587c;
        return str == null ? "" : str;
    }

    public int f() {
        return this.f134593i;
    }

    public abstract Object g();

    public abstract String h();

    public String i() {
        String str = this.f134586b;
        return str == null ? "" : str;
    }

    public String j() {
        String str = this.f134585a;
        return str == null ? "" : str;
    }

    public boolean k() {
        return this.f134589e;
    }

    public boolean l() {
        return this.f134590f;
    }

    protected abstract IsDataValid m(Object obj);

    public void n(boolean z2) {
        D(true, "", z2);
    }

    public boolean o(boolean z2) {
        IsDataValid isDataValidM = m(g());
        if (isDataValidM == null) {
            isDataValidM = new IsDataValid(true);
        }
        if (this.f134589e == isDataValidM.b()) {
            B(isDataValidM.b() ? "" : isDataValidM.a(), z2);
        } else if (isDataValidM.b()) {
            n(z2);
        } else {
            p(isDataValidM.a(), z2);
        }
        return isDataValidM.b();
    }

    public void p(String str, boolean z2) {
        D(false, str, z2);
    }

    protected abstract void q(boolean z2);

    protected abstract void r(boolean z2);

    protected abstract void s(boolean z2);

    protected abstract void t(boolean z2);
}

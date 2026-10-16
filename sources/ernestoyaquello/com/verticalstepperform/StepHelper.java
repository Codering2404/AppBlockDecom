package ernestoyaquello.com.verticalstepperform;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.button.MaterialButton;
import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class StepHelper implements Step.InternalFormStepListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Step f134598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VerticalStepperFormView.FormStyle f134599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f134600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f134601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f134602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f134603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f134604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f134605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaterialButton f134606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaterialButton f134607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f134608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f134609l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f134610m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f134611n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f134612o;

    /* JADX INFO: renamed from: ernestoyaquello.com.verticalstepperform.StepHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerticalStepperFormView f134613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f134614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StepHelper f134615c;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f134615c.f134599b.f134658n || this.f134615c.f134598a.l()) {
                return;
            }
            this.f134613a.x(this.f134614b, true);
        }
    }

    /* JADX INFO: renamed from: ernestoyaquello.com.verticalstepperform.StepHelper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerticalStepperFormView f134616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f134617b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f134616a.x(this.f134617b + 1, true);
        }
    }

    /* JADX INFO: renamed from: ernestoyaquello.com.verticalstepperform.StepHelper$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerticalStepperFormView f134618a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f134618a.m();
        }
    }

    private String m() {
        String strI = (!this.f134599b.f134654j || this.f134598a.l()) ? this.f134598a.i() : this.f134598a.h();
        return strI == null ? "" : strI;
    }

    private void q() {
        this.f134604g.setVisibility(0);
        this.f134603f.setVisibility(8);
    }

    private void r() {
        this.f134604g.setVisibility(8);
        this.f134603f.setVisibility(0);
    }

    private boolean s() {
        CharSequence text = this.f134606i.getText();
        String string = text == null ? "" : text.toString();
        String strE = this.f134598a.e();
        if (strE.equals(string)) {
            return false;
        }
        this.f134606i.setText(strE);
        return true;
    }

    private boolean t() {
        CharSequence text = this.f134605h.getText();
        String string = text == null ? "" : text.toString();
        String strD = this.f134598a.d();
        if (strD.equals(string)) {
            return false;
        }
        if (strD.isEmpty()) {
            return true;
        }
        this.f134605h.setText(strD);
        return true;
    }

    private void u(boolean z2) {
        if (!this.f134598a.l() || this.f134598a.k() || this.f134598a.d().isEmpty()) {
            UIHelper.j(this.f134609l, z2);
        } else {
            UIHelper.i(this.f134609l, z2);
        }
    }

    private void v(boolean z2) {
        boolean z3 = this.f134598a.l() || this.f134598a.k();
        float f3 = z3 ? 1.0f : this.f134599b.f134659o;
        float f4 = z3 ? 1.0f : 0.0f;
        this.f134601d.setAlpha(f3);
        this.f134602e.setAlpha(f4);
        this.f134600c.setAlpha(f3);
        if (this.f134599b.f134655k) {
            Drawable drawableB = AppCompatResources.b(this.f134600c.getContext(), R.drawable.f134500a);
            drawableB.setColorFilter(new PorterDuffColorFilter(z3 ? this.f134599b.f134646b : this.f134599b.f134645a, PorterDuff.Mode.SRC_IN));
            this.f134600c.setBackground(drawableB);
        }
        if (this.f134598a.l() || !this.f134598a.k()) {
            r();
        } else {
            q();
        }
        w();
        x(z2);
        u(z2);
    }

    private boolean w() {
        CharSequence text = this.f134602e.getText();
        String string = text == null ? "" : text.toString();
        String strM = m();
        if (strM.equals(string)) {
            return false;
        }
        if (strM.isEmpty()) {
            return true;
        }
        this.f134602e.setText(strM);
        return true;
    }

    private void x(boolean z2) {
        if (m().isEmpty() || !(this.f134598a.l() || this.f134598a.k())) {
            UIHelper.j(this.f134602e, z2);
        } else {
            UIHelper.i(this.f134602e, z2);
        }
    }

    private boolean y() {
        CharSequence text = this.f134601d.getText();
        String string = text == null ? "" : text.toString();
        String strJ = this.f134598a.j();
        if (strJ.equals(string)) {
            return false;
        }
        this.f134601d.setText(strJ);
        return true;
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
    public void a(int i3, boolean z2) {
        if (this.f134598a.c() != null) {
            if (this.f134598a.k()) {
                l();
            } else {
                k();
            }
            v(z2);
        }
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
    public void b(int i3, boolean z2) {
        if (this.f134598a.c() == null || !t()) {
            return;
        }
        u(z2);
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
    public void c(int i3, boolean z2) {
        if (this.f134598a.c() != null) {
            y();
        }
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
    public void d(int i3, boolean z2) {
        if (this.f134598a.c() != null) {
            s();
        }
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
    public void e(int i3, boolean z2) {
        if (this.f134598a.c() == null || !w()) {
            return;
        }
        x(z2);
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
    public void f(int i3, boolean z2) {
        if (this.f134598a.c() != null) {
            if (!this.f134598a.l()) {
                UIHelper.j(this.f134608k, z2);
                v(z2);
                return;
            }
            UIHelper.i(this.f134608k, z2);
            if (this.f134598a.o(z2) == this.f134598a.k()) {
                v(z2);
            }
        }
    }

    void i() {
        k();
        j();
    }

    void j() {
        this.f134607j.setEnabled(false);
        this.f134607j.setAlpha(this.f134599b.f134659o);
        VerticalStepperFormView.FormStyle formStyle = this.f134599b;
        if (formStyle.f134655k) {
            MaterialButton materialButton = this.f134607j;
            int i3 = formStyle.f134645a;
            UIHelper.g(materialButton, i3, formStyle.f134652h, i3, formStyle.f134653i);
        }
    }

    void k() {
        this.f134606i.setEnabled(false);
        this.f134606i.setAlpha(this.f134599b.f134659o);
        VerticalStepperFormView.FormStyle formStyle = this.f134599b;
        if (formStyle.f134655k) {
            MaterialButton materialButton = this.f134606i;
            int i3 = formStyle.f134645a;
            UIHelper.g(materialButton, i3, formStyle.f134650f, i3, formStyle.f134651g);
        }
    }

    void l() {
        this.f134606i.setEnabled(true);
        this.f134606i.setAlpha(1.0f);
        VerticalStepperFormView.FormStyle formStyle = this.f134599b;
        if (formStyle.f134655k) {
            UIHelper.g(this.f134606i, formStyle.f134647c, formStyle.f134650f, formStyle.f134648d, formStyle.f134651g);
        }
    }

    public Step n() {
        return this.f134598a;
    }

    boolean o() {
        return this.f134598a instanceof ConfirmationStep;
    }

    void p(boolean z2) {
        if (z2) {
            this.f134601d.setTextColor(this.f134599b.f134649e);
            this.f134600c.setBackground(this.f134610m);
        } else {
            this.f134601d.setTextColor(this.f134612o);
            this.f134600c.setBackground(this.f134611n);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ConfirmationStep extends Step<Object> {
        @Override // ernestoyaquello.com.verticalstepperform.Step
        public Object g() {
            return null;
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step
        public String h() {
            return i();
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step
        protected Step.IsDataValid m(Object obj) {
            return null;
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step
        protected void q(boolean z2) {
            p("", z2);
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step
        protected void r(boolean z2) {
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step
        protected void s(boolean z2) {
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step
        protected void t(boolean z2) {
        }
    }
}

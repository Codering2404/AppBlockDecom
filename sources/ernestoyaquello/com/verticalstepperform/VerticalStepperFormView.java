package ernestoyaquello.com.verticalstepperform;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageButton;
import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class VerticalStepperFormView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    FormStyle f134625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StepperFormListener f134626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private KeyboardTogglingObserver f134627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f134628d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f134629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f134630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ScrollView f134631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ProgressBar f134632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AppCompatImageButton f134633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AppCompatImageButton f134634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f134635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f134636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f134637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f134638o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class FormStyle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f134645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f134646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f134647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f134648d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f134649e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f134650f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f134651g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f134652h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f134653i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f134654j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f134655k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f134656l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f134657m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f134658n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float f134659o;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class KeyboardTogglingObserver implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerticalStepperFormView f134660a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z2 = this.f134660a.f134637n;
            VerticalStepperFormView verticalStepperFormView = this.f134660a;
            verticalStepperFormView.f134637n = verticalStepperFormView.y();
            if (!this.f134660a.f134629f || this.f134660a.f134637n == z2) {
                return;
            }
            this.f134660a.G(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0010, B:10:0x0016, B:13:0x0028, B:14:0x003b, B:16:0x0043), top: B:21:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void B(int r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto L3b
            java.util.List r0 = r2.f134628d     // Catch: java.lang.Throwable -> L26
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L26
            if (r3 >= r0) goto L3b
            int r0 = r2.f134638o     // Catch: java.lang.Throwable -> L26
            r1 = -1
            if (r0 == r1) goto L28
            ernestoyaquello.com.verticalstepperform.VerticalStepperFormView$FormStyle r1 = r2.f134625a     // Catch: java.lang.Throwable -> L26
            boolean r1 = r1.f134656l     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L28
            java.util.List r1 = r2.f134628d     // Catch: java.lang.Throwable -> L26
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Throwable -> L26
            ernestoyaquello.com.verticalstepperform.StepHelper r0 = (ernestoyaquello.com.verticalstepperform.StepHelper) r0     // Catch: java.lang.Throwable -> L26
            ernestoyaquello.com.verticalstepperform.Step r0 = r0.n()     // Catch: java.lang.Throwable -> L26
            r0.a(r4)     // Catch: java.lang.Throwable -> L26
            goto L28
        L26:
            r3 = move-exception
            goto L49
        L28:
            java.util.List r0 = r2.f134628d     // Catch: java.lang.Throwable -> L26
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L26
            ernestoyaquello.com.verticalstepperform.StepHelper r0 = (ernestoyaquello.com.verticalstepperform.StepHelper) r0     // Catch: java.lang.Throwable -> L26
            ernestoyaquello.com.verticalstepperform.Step r0 = r0.n()     // Catch: java.lang.Throwable -> L26
            r0.A(r4)     // Catch: java.lang.Throwable -> L26
            r2.A(r3)     // Catch: java.lang.Throwable -> L26
            goto L47
        L3b:
            java.util.List r4 = r2.f134628d     // Catch: java.lang.Throwable -> L26
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L26
            if (r3 != r4) goto L47
            r3 = 0
            r2.l(r3)     // Catch: java.lang.Throwable -> L26
        L47:
            monitor-exit(r2)
            return
        L49:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L26
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ernestoyaquello.com.verticalstepperform.VerticalStepperFormView.B(int, boolean):void");
    }

    private void D() {
        this.f134633j.setOnClickListener(new View.OnClickListener() { // from class: ernestoyaquello.com.verticalstepperform.VerticalStepperFormView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerticalStepperFormView.this.w(true);
            }
        });
        this.f134634k.setOnClickListener(new View.OnClickListener() { // from class: ernestoyaquello.com.verticalstepperform.VerticalStepperFormView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerticalStepperFormView.this.v(true);
            }
        });
        i();
    }

    private void E() {
        getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f134627c);
    }

    private void F(int i3, boolean[] zArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, boolean z2) {
        if (zArr.length != this.f134628d.size()) {
            return;
        }
        for (int i4 = 0; i4 < zArr.length; i4++) {
            StepHelper stepHelper = (StepHelper) this.f134628d.get(i4);
            stepHelper.n().G(strArr[i4], false);
            stepHelper.n().F(strArr2[i4], false);
            stepHelper.n().C(strArr3[i4], false);
            if (zArr[i4]) {
                B(i4, false);
                stepHelper.n().n(false);
            } else {
                stepHelper.n().p(strArr4[i4], false);
            }
        }
        x(i3, false);
        if (z2) {
            this.f134636m = true;
            ((StepHelper) this.f134628d.get(this.f134638o)).i();
            I();
        }
        C();
    }

    private void i() {
        this.f134637n = y();
        getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this.f134627c);
    }

    private synchronized void l(boolean z2) {
        try {
            if (this.f134636m) {
                return;
            }
            String strD = "";
            List list = this.f134628d;
            StepHelper stepHelper = (StepHelper) list.get(list.size() - 1);
            Step stepN = stepHelper.n();
            boolean z3 = false;
            if (!z2 && !stepN.k() && stepHelper.o()) {
                strD = stepN.d();
                stepN.o(true);
                if (stepN.k()) {
                    z3 = true;
                }
            }
            int i3 = this.f134638o;
            if (i3 >= 0 && i3 < this.f134628d.size() && (z2 || k())) {
                this.f134636m = true;
                ((StepHelper) this.f134628d.get(i3)).i();
                I();
                StepperFormListener stepperFormListener = this.f134626b;
                if (stepperFormListener != null) {
                    if (z2) {
                        stepperFormListener.a();
                    } else {
                        stepperFormListener.b();
                    }
                }
            } else if (z3) {
                stepN.p(strD, true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void n(View view) {
        view.setAlpha(this.f134625a.f134659o);
        view.setEnabled(false);
    }

    private void q(View view) {
        view.setAlpha(1.0f);
        view.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (k()) {
            ((StepHelper) this.f134628d.get(r0.size() - 1)).l();
        } else {
            ((StepHelper) this.f134628d.get(r0.size() - 1)).k();
        }
    }

    private void setProgress(int i3) {
        if (i3 < 0 || i3 > this.f134628d.size()) {
            return;
        }
        this.f134632i.setProgress(i3);
    }

    private void u() {
        this.f134630g = (LinearLayout) findViewById(R.id.f134502b);
        this.f134631h = (ScrollView) findViewById(R.id.f134506f);
        this.f134632i = (ProgressBar) findViewById(R.id.f134505e);
        this.f134633j = (AppCompatImageButton) findViewById(R.id.f134504d);
        this.f134634k = (AppCompatImageButton) findViewById(R.id.f134503c);
        this.f134635l = findViewById(R.id.f134501a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        Rect rect = new Rect();
        this.f134630g.getWindowVisibleDisplayFrame(rect);
        int height = this.f134630g.getRootView().getHeight();
        return ((double) (height - rect.bottom)) > ((double) height) * 0.2d;
    }

    void A(int i3) {
        this.f134638o = i3;
        int i4 = 0;
        while (i4 < this.f134628d.size()) {
            StepHelper stepHelper = (StepHelper) this.f134628d.get(i4);
            stepHelper.p(i4 == this.f134638o);
            if (i4 > this.f134638o) {
                stepHelper.n().a(true);
            }
            i4++;
        }
    }

    public int C() {
        int i3 = 0;
        for (int i4 = 0; i4 < this.f134628d.size(); i4++) {
            if (((StepHelper) this.f134628d.get(i4)).n().k()) {
                i3++;
            }
        }
        setProgress(i3);
        return i3;
    }

    public synchronized void G(boolean z2) {
        H(this.f134638o, z2);
    }

    public void H(final int i3, final boolean z2) {
        if (i3 < 0 || i3 >= this.f134628d.size()) {
            return;
        }
        this.f134631h.post(new Runnable() { // from class: ernestoyaquello.com.verticalstepperform.VerticalStepperFormView.1
            @Override // java.lang.Runnable
            public void run() {
                Step stepN = ((StepHelper) VerticalStepperFormView.this.f134628d.get(i3)).n();
                View viewC = stepN.c();
                View viewB = stepN.b();
                VerticalStepperFormView.this.f134631h.getDrawingRect(new Rect());
                if (viewB == null || r2.top > viewB.getY()) {
                    if (z2) {
                        VerticalStepperFormView.this.f134631h.smoothScrollTo(0, viewC.getTop());
                    } else {
                        VerticalStepperFormView.this.f134631h.scrollTo(0, viewC.getTop());
                    }
                }
            }
        });
    }

    protected synchronized void I() {
        try {
            int i3 = this.f134638o;
            if (i3 >= 0 && i3 < this.f134628d.size()) {
                StepHelper stepHelper = (StepHelper) this.f134628d.get(i3);
                if (this.f134636m || i3 <= 0) {
                    p();
                } else {
                    t();
                }
                if (this.f134636m || i3 + 1 >= this.f134628d.size() || !(this.f134625a.f134657m || stepHelper.n().k())) {
                    o();
                } else {
                    r();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Step getOpenStep() {
        int i3 = this.f134638o;
        if (i3 >= 0 && i3 < this.f134628d.size()) {
            StepHelper stepHelper = (StepHelper) this.f134628d.get(this.f134638o);
            if (stepHelper.n().l()) {
                return stepHelper.n();
            }
        }
        return null;
    }

    public int getTotalNumberOfSteps() {
        return this.f134628d.size();
    }

    public boolean j(int i3) {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            if (!((StepHelper) this.f134628d.get(i4)).n().k()) {
                return false;
            }
        }
        return true;
    }

    public boolean k() {
        return j(this.f134628d.size());
    }

    public void m() {
        l(true);
    }

    protected void o() {
        n(this.f134634k);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        E();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        u();
        D();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            boolean z2 = bundle.getBoolean("formCompleted");
            String[] stringArray = bundle.getStringArray("errorMessages");
            String[] stringArray2 = bundle.getStringArray("buttonTexts");
            String[] stringArray3 = bundle.getStringArray("subtitles");
            String[] stringArray4 = bundle.getStringArray("titles");
            boolean[] booleanArray = bundle.getBooleanArray("completedSteps");
            int i3 = bundle.getInt("openStep");
            parcelable = bundle.getParcelable("superState");
            F(i3, booleanArray, stringArray4, stringArray3, stringArray2, stringArray, z2);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int size = this.f134628d.size();
        boolean[] zArr = new boolean[size];
        String[] strArr = new String[this.f134628d.size()];
        String[] strArr2 = new String[this.f134628d.size()];
        String[] strArr3 = new String[this.f134628d.size()];
        String[] strArr4 = new String[this.f134628d.size()];
        for (int i3 = 0; i3 < size; i3++) {
            StepHelper stepHelper = (StepHelper) this.f134628d.get(i3);
            zArr[i3] = stepHelper.n().k();
            strArr[i3] = stepHelper.n().j();
            strArr2[i3] = stepHelper.n().i();
            strArr3[i3] = stepHelper.n().e();
            if (!stepHelper.n().k()) {
                strArr4[i3] = stepHelper.n().d();
            }
        }
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("openStep", this.f134638o);
        bundle.putBooleanArray("completedSteps", zArr);
        bundle.putStringArray("titles", strArr);
        bundle.putStringArray("subtitles", strArr2);
        bundle.putStringArray("buttonTexts", strArr3);
        bundle.putStringArray("errorMessages", strArr4);
        bundle.putBoolean("formCompleted", this.f134636m);
        return bundle;
    }

    protected void p() {
        n(this.f134633j);
    }

    protected void r() {
        q(this.f134634k);
    }

    public void setFormCompleted(Boolean bool) {
        this.f134636m = bool.booleanValue();
    }

    protected void t() {
        q(this.f134633j);
    }

    public synchronized boolean v(boolean z2) {
        if (this.f134636m) {
            return false;
        }
        boolean z3 = true;
        boolean zX = true;
        while (z3) {
            zX = x(this.f134638o + 1, z2);
            z3 = z(this.f134638o) && this.f134638o + 1 < this.f134628d.size();
        }
        return zX;
    }

    public synchronized boolean w(boolean z2) {
        return x(this.f134638o - 1, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        if (r0 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean x(int r4, boolean r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f134636m     // Catch: java.lang.Throwable -> L29
            r1 = 0
            if (r0 == 0) goto L8
            monitor-exit(r3)
            return r1
        L8:
            int r0 = r3.f134638o     // Catch: java.lang.Throwable -> L29
            if (r0 == r4) goto L33
            if (r4 < 0) goto L33
            java.util.List r0 = r3.f134628d     // Catch: java.lang.Throwable -> L29
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L29
            if (r4 > r0) goto L33
            boolean r0 = r3.j(r4)     // Catch: java.lang.Throwable -> L29
            ernestoyaquello.com.verticalstepperform.VerticalStepperFormView$FormStyle r2 = r3.f134625a     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.f134657m     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L2b
            java.util.List r2 = r3.f134628d     // Catch: java.lang.Throwable -> L29
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L29
            if (r4 < r2) goto L2d
            goto L2b
        L29:
            r4 = move-exception
            goto L35
        L2b:
            if (r0 == 0) goto L33
        L2d:
            r3.B(r4, r5)     // Catch: java.lang.Throwable -> L29
            monitor-exit(r3)
            r4 = 1
            return r4
        L33:
            monitor-exit(r3)
            return r1
        L35:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L29
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ernestoyaquello.com.verticalstepperform.VerticalStepperFormView.x(int, boolean):boolean");
    }

    public boolean z(int i3) {
        if (i3 < 0 || i3 >= this.f134628d.size()) {
            return false;
        }
        return ((StepHelper) this.f134628d.get(i3)).n().k();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class FormStepListener implements Step.InternalFormStepListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerticalStepperFormView f134644a;

        @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
        public void a(int i3, boolean z2) {
            this.f134644a.I();
            this.f134644a.C();
            this.f134644a.s();
            if (this.f134644a.k()) {
                this.f134644a.f134626b.b();
            } else {
                this.f134644a.f134626b.c();
            }
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
        public void f(int i3, boolean z2) {
            this.f134644a.I();
            this.f134644a.G(z2);
            this.f134644a.s();
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
        public void b(int i3, boolean z2) {
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
        public void c(int i3, boolean z2) {
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
        public void d(int i3, boolean z2) {
        }

        @Override // ernestoyaquello.com.verticalstepperform.Step.InternalFormStepListener
        public void e(int i3, boolean z2) {
        }
    }
}

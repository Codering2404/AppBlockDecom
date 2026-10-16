package com.google.android.material.sidesheet;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.sidesheet.SheetCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f81919o = R.id.f79630f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f81920p = R.id.f79657s0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Sheet f81921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f81922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout f81923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f81924j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f81925k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f81926l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f81927m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MaterialBackOrchestrator f81928n;

    public static /* synthetic */ void j(SheetDialog sheetDialog, View view) {
        if (sheetDialog.f81925k && sheetDialog.isShowing() && sheetDialog.u()) {
            sheetDialog.cancel();
        }
    }

    private void l() {
        if (this.f81922h == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), q(), null);
            this.f81922h = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(p());
            this.f81923i = frameLayout2;
            Sheet sheetN = n(frameLayout2);
            this.f81921g = sheetN;
            k(sheetN);
            this.f81928n = new MaterialBackOrchestrator(this.f81921g, this.f81923i);
        }
    }

    private FrameLayout o() {
        if (this.f81922h == null) {
            l();
        }
        return this.f81922h;
    }

    private FrameLayout r() {
        if (this.f81923i == null) {
            l();
        }
        return this.f81923i;
    }

    private void t() {
        FrameLayout frameLayout;
        Window window = getWindow();
        if (window == null || (frameLayout = this.f81923i) == null || !(frameLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return;
        }
        window.setWindowAnimations(GravityCompat.b(((CoordinatorLayout.LayoutParams) this.f81923i.getLayoutParams()).f33465c, ViewCompat.y(this.f81923i)) == 3 ? R.style.f79728a : R.style.f79729b);
    }

    private boolean u() {
        if (!this.f81927m) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.f81926l = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f81927m = true;
        }
        return this.f81926l;
    }

    private void v() {
        MaterialBackOrchestrator materialBackOrchestrator = this.f81928n;
        if (materialBackOrchestrator == null) {
            return;
        }
        if (this.f81925k) {
            materialBackOrchestrator.c();
        } else {
            materialBackOrchestrator.f();
        }
    }

    private View w(int i3, View view, ViewGroup.LayoutParams layoutParams) {
        l();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) o().findViewById(f81919o);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayoutR = r();
        frameLayoutR.removeAllViews();
        if (layoutParams == null) {
            frameLayoutR.addView(view);
        } else {
            frameLayoutR.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f81920p).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.sidesheet.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SheetDialog.j(this.f81965a, view2);
            }
        });
        ViewCompat.m0(r(), new AccessibilityDelegateCompat() { // from class: com.google.android.material.sidesheet.SheetDialog.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                if (!SheetDialog.this.f81925k) {
                    accessibilityNodeInfoCompat.o0(false);
                } else {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.o0(true);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view2, int i4, Bundle bundle) {
                if (i4 == 1048576) {
                    SheetDialog sheetDialog = SheetDialog.this;
                    if (sheetDialog.f81925k) {
                        sheetDialog.cancel();
                        return true;
                    }
                }
                return super.j(view2, i4, bundle);
            }
        });
        return this.f81922h;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Sheet sheetM = m();
        if (!this.f81924j || sheetM.getState() == 5) {
            super.cancel();
        } else {
            sheetM.c(5);
        }
    }

    abstract void k(Sheet sheet);

    Sheet m() {
        if (this.f81921g == null) {
            l();
        }
        return this.f81921g;
    }

    abstract Sheet n(FrameLayout frameLayout);

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
        v();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator materialBackOrchestrator = this.f81928n;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.f();
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        Sheet sheet = this.f81921g;
        if (sheet == null || sheet.getState() != 5) {
            return;
        }
        this.f81921g.c(s());
    }

    abstract int p();

    abstract int q();

    abstract int s();

    @Override // android.app.Dialog
    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f81925k != z2) {
            this.f81925k = z2;
        }
        if (getWindow() != null) {
            v();
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f81925k) {
            this.f81925k = true;
        }
        this.f81926l = z2;
        this.f81927m = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(w(i3, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(w(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(w(0, view, layoutParams));
    }
}

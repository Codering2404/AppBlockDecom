package com.google.android.material.bottomsheet;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f80216n = R.style.f79750w;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AccessibilityManager f80217d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BottomSheetBehavior f80218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f80219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f80220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f80221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f80222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f80223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f80224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final BottomSheetBehavior.BottomSheetCallback f80225m;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.BottomSheetDragHandleView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BottomSheetDragHandleView f80227d;

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                this.f80227d.g();
            }
        }
    }

    private void f(String str) {
        if (this.f80217d == null) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.getText().add(str);
        this.f80217d.sendAccessibilityEvent(accessibilityEventObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        boolean z2 = false;
        if (!this.f80220h) {
            return false;
        }
        f(this.f80224l);
        if (!this.f80218f.A0() && !this.f80218f.e1()) {
            z2 = true;
        }
        int state = this.f80218f.getState();
        int i3 = 6;
        int i4 = 3;
        if (state == 4) {
            if (!z2) {
                i3 = i4;
            }
        } else if (state != 3) {
            if (!this.f80221i) {
                i4 = 4;
            }
            i3 = i4;
        } else if (!z2) {
            i3 = 4;
        }
        this.f80218f.c(i3);
        return true;
    }

    private BottomSheetBehavior h() {
        View viewI = this;
        while (true) {
            viewI = i(viewI);
            if (viewI == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = viewI.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) layoutParams).f();
                if (behaviorF instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) behaviorF;
                }
            }
        }
    }

    private static View i(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3) {
        if (i3 == 4) {
            this.f80221i = true;
        } else if (i3 == 3) {
            this.f80221i = false;
        }
        ViewCompat.i0(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34572i, this.f80221i ? this.f80222j : this.f80223k, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.a
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return this.f80232a.g();
            }
        });
    }

    private void k() {
        this.f80220h = this.f80219g && this.f80218f != null;
        ViewCompat.w0(this, this.f80218f == null ? 2 : 1);
        setClickable(this.f80220h);
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.f80218f;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.G0(this.f80225m);
            this.f80218f.L0(null);
        }
        this.f80218f = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.L0(this);
            j(this.f80218f.getState());
            this.f80218f.e0(this.f80225m);
        }
        k();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z2) {
        this.f80219g = z2;
        k();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(h());
        AccessibilityManager accessibilityManager = this.f80217d;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.f80217d.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f80217d;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.BottomSheetDragHandleView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDragHandleView f80226a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i3) {
            this.f80226a.j(i3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f3) {
        }
    }
}

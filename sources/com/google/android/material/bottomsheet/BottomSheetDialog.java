package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BottomSheetBehavior f80193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f80194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CoordinatorLayout f80195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FrameLayout f80196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f80197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f80198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f80199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f80200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private EdgeToEdgeCallback f80201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f80202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MaterialBackOrchestrator f80203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private BottomSheetBehavior.BottomSheetCallback f80204r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f80210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WindowInsetsCompat f80211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Window f80212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f80213d;

        private void a(View view) {
            if (view.getTop() < this.f80211b.m()) {
                Window window = this.f80212c;
                if (window != null) {
                    Boolean bool = this.f80210a;
                    EdgeToEdgeUtils.f(window, bool == null ? this.f80213d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f80211b.m() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.f80212c;
                if (window2 != null) {
                    EdgeToEdgeUtils.f(window2, this.f80213d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        void b(Window window) {
            if (this.f80212c == window) {
                return;
            }
            this.f80212c = window;
            if (window != null) {
                this.f80213d = WindowCompat.a(window, window.getDecorView()).b();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        void onLayout(View view) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f3) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i3) {
            a(view);
        }

        private EdgeToEdgeCallback(View view, WindowInsetsCompat windowInsetsCompat) {
            this.f80211b = windowInsetsCompat;
            MaterialShapeDrawable materialShapeDrawableV0 = BottomSheetBehavior.s0(view).v0();
            ColorStateList colorStateListX = materialShapeDrawableV0 != null ? materialShapeDrawableV0.x() : ViewCompat.q(view);
            if (colorStateListX != null) {
                this.f80210a = Boolean.valueOf(MaterialColors.i(colorStateListX.getDefaultColor()));
                return;
            }
            Integer numH = ViewUtils.h(view);
            if (numH != null) {
                this.f80210a = Boolean.valueOf(MaterialColors.i(numH.intValue()));
            } else {
                this.f80210a = null;
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
        this.f80202p = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.C}).getBoolean(0, false);
    }

    private static int f(Context context, int i3) {
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.f79484e, typedValue, true) ? typedValue.resourceId : R.style.f79739l;
    }

    private FrameLayout n() {
        if (this.f80194h == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.f79671b, null);
            this.f80194h = frameLayout;
            this.f80195i = (CoordinatorLayout) frameLayout.findViewById(R.id.f79630f);
            FrameLayout frameLayout2 = (FrameLayout) this.f80194h.findViewById(R.id.f79632g);
            this.f80196j = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorS0 = BottomSheetBehavior.s0(frameLayout2);
            this.f80193g = bottomSheetBehaviorS0;
            bottomSheetBehaviorS0.e0(this.f80204r);
            this.f80193g.R0(this.f80198l);
            this.f80203q = new MaterialBackOrchestrator(this.f80193g, this.f80196j);
        }
        return this.f80194h;
    }

    private void s() {
        MaterialBackOrchestrator materialBackOrchestrator = this.f80203q;
        if (materialBackOrchestrator == null) {
            return;
        }
        if (this.f80198l) {
            materialBackOrchestrator.c();
        } else {
            materialBackOrchestrator.f();
        }
    }

    private View t(int i3, View view, ViewGroup.LayoutParams layoutParams) {
        n();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f80194h.findViewById(R.id.f79630f);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f80202p) {
            ViewCompat.C0(this.f80196j, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.f80201o != null) {
                        BottomSheetDialog.this.f80193g.G0(BottomSheetDialog.this.f80201o);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        bottomSheetDialog.f80201o = new EdgeToEdgeCallback(bottomSheetDialog.f80196j, windowInsetsCompat);
                        BottomSheetDialog.this.f80201o.b(BottomSheetDialog.this.getWindow());
                        BottomSheetDialog.this.f80193g.e0(BottomSheetDialog.this.f80201o);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.f80196j.removeAllViews();
        if (layoutParams == null) {
            this.f80196j.addView(view);
        } else {
            this.f80196j.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.f79657s0).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f80198l && bottomSheetDialog.isShowing() && BottomSheetDialog.this.r()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.m0(this.f80196j, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                if (!BottomSheetDialog.this.f80198l) {
                    accessibilityNodeInfoCompat.o0(false);
                } else {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.o0(true);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view2, int i4, Bundle bundle) {
                if (i4 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.f80198l) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.j(view2, i4, bundle);
            }
        });
        this.f80196j.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.f80194h;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior bottomSheetBehaviorO = o();
        if (!this.f80197k || bottomSheetBehaviorO.getState() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorO.c(5);
        }
    }

    public BottomSheetBehavior o() {
        if (this.f80193g == null) {
            n();
        }
        return this.f80193g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z2 = this.f80202p && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f80194h;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z2);
            }
            CoordinatorLayout coordinatorLayout = this.f80195i;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z2);
            }
            WindowCompat.b(window, !z2);
            EdgeToEdgeCallback edgeToEdgeCallback = this.f80201o;
            if (edgeToEdgeCallback != null) {
                edgeToEdgeCallback.b(window);
            }
        }
        s();
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
        EdgeToEdgeCallback edgeToEdgeCallback = this.f80201o;
        if (edgeToEdgeCallback != null) {
            edgeToEdgeCallback.b(null);
        }
        MaterialBackOrchestrator materialBackOrchestrator = this.f80203q;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.f();
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f80193g;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.f80193g.c(4);
    }

    public boolean p() {
        return this.f80197k;
    }

    void q() {
        this.f80193g.G0(this.f80204r);
    }

    boolean r() {
        if (!this.f80200n) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.f80199m = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f80200n = true;
        }
        return this.f80199m;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f80198l != z2) {
            this.f80198l = z2;
            BottomSheetBehavior bottomSheetBehavior = this.f80193g;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.R0(z2);
            }
            if (getWindow() != null) {
                s();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f80198l) {
            this.f80198l = true;
        }
        this.f80199m = z2;
        this.f80200n = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(t(i3, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(t(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(t(0, view, layoutParams));
    }

    public BottomSheetDialog(Context context, int i3) {
        super(context, f(context, i3));
        this.f80198l = true;
        this.f80199m = true;
        this.f80204r = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i4) {
                if (i4 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f3) {
            }
        };
        i(1);
        this.f80202p = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.C}).getBoolean(0, false);
    }
}

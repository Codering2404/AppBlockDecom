package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.activity.BackEventCompat;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NavigationMenu f81439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final NavigationMenuPresenter f81440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    OnNavigationItemSelectedListener f81441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f81442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int[] f81443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MenuInflater f81444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f81445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f81446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f81447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f81448r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f81449s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f81450t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ShapeableDelegate f81451u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MaterialSideContainerBackHelper f81452v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MaterialBackOrchestrator f81453w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final DrawerLayout.DrawerListener f81454x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f81437y = {R.attr.state_checked};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f81438z = {-16842910};
    private static final int A = com.google.android.material.R.style.f79746s;

    /* JADX INFO: renamed from: com.google.android.material.navigation.NavigationView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends DrawerLayout.SimpleDrawerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationView f81455a;

        @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void a(View view) {
            NavigationView navigationView = this.f81455a;
            if (view == navigationView) {
                final MaterialBackOrchestrator materialBackOrchestrator = navigationView.f81453w;
                Objects.requireNonNull(materialBackOrchestrator);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        materialBackOrchestrator.e();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void b(View view) {
            NavigationView navigationView = this.f81455a;
            if (view == navigationView) {
                navigationView.f81453w.f();
                this.f81455a.o();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.navigation.NavigationView$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationView f81457a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = this.f81457a;
            navigationView.getLocationOnScreen(navigationView.f81443m);
            boolean z2 = true;
            boolean z3 = this.f81457a.f81443m[1] == 0;
            this.f81457a.f81440j.A(z3);
            NavigationView navigationView2 = this.f81457a;
            navigationView2.setDrawTopInsetForeground(z3 && navigationView2.n());
            this.f81457a.setDrawLeftInsetForeground(this.f81457a.f81443m[0] == 0 || this.f81457a.f81443m[0] + this.f81457a.getWidth() == 0);
            Activity activityA = ContextUtils.a(this.f81457a.getContext());
            if (activityA != null) {
                Rect rectA = WindowUtils.a(activityA);
                boolean z4 = rectA.height() - this.f81457a.getHeight() == this.f81457a.f81443m[1];
                boolean z5 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = this.f81457a;
                navigationView3.setDrawBottomInsetForeground(z4 && z5 && navigationView3.m());
                if (rectA.width() != this.f81457a.f81443m[0] && rectA.width() - this.f81457a.getWidth() != this.f81457a.f81443m[0]) {
                    z2 = false;
                }
                this.f81457a.setDrawRightInsetForeground(z2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnNavigationItemSelectedListener {
        boolean a(MenuItem menuItem);
    }

    private MenuInflater getMenuInflater() {
        if (this.f81444n == null) {
            this.f81444n = new SupportMenuInflater(getContext());
        }
        return this.f81444n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.f81449s || this.f81448r == 0) {
            return;
        }
        this.f81448r = 0;
        p(getWidth(), getHeight());
    }

    private void p(int i3, int i4) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
            if ((this.f81448r > 0 || this.f81449s) && (getBackground() instanceof MaterialShapeDrawable)) {
                boolean z2 = GravityCompat.b(((DrawerLayout.LayoutParams) getLayoutParams()).f36761a, ViewCompat.y(this)) == 3;
                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                ShapeAppearanceModel.Builder builderO = materialShapeDrawable.getShapeAppearanceModel().v().o(this.f81448r);
                if (z2) {
                    builderO.D(0.0f);
                    builderO.v(0.0f);
                } else {
                    builderO.H(0.0f);
                    builderO.z(0.0f);
                }
                ShapeAppearanceModel shapeAppearanceModelM = builderO.m();
                materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelM);
                this.f81451u.f(this, shapeAppearanceModelM);
                this.f81451u.e(this, new RectF(0.0f, 0.0f, i3, i4));
                this.f81451u.h(this, true);
            }
        }
    }

    private Pair q() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void a() {
        q();
        this.f81452v.f();
        o();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void d(BackEventCompat backEventCompat) {
        q();
        this.f81452v.j(backEventCompat);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f81451u.d(canvas, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.navigation.b
            @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
            public final void a(Canvas canvas2) {
                super/*android.view.View*/.dispatchDraw(canvas2);
            }
        });
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void e(BackEventCompat backEventCompat) {
        this.f81452v.l(backEventCompat, ((DrawerLayout.LayoutParams) q().second).f36761a);
        if (this.f81449s) {
            this.f81448r = AnimationUtils.c(0, this.f81450t, this.f81452v.a(backEventCompat.a()));
            p(getWidth(), getHeight());
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void f() {
        Pair pairQ = q();
        DrawerLayout drawerLayout = (DrawerLayout) pairQ.first;
        BackEventCompat backEventCompatC = this.f81452v.c();
        if (backEventCompatC == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.f(this);
            return;
        }
        this.f81452v.h(backEventCompatC, ((DrawerLayout.LayoutParams) pairQ.second).f36761a, DrawerLayoutUtils.b(drawerLayout, this), DrawerLayoutUtils.c(drawerLayout));
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void g(WindowInsetsCompat windowInsetsCompat) {
        this.f81440j.l(windowInsetsCompat);
    }

    MaterialSideContainerBackHelper getBackHelper() {
        return this.f81452v;
    }

    public MenuItem getCheckedItem() {
        return this.f81440j.m();
    }

    public int getDividerInsetEnd() {
        return this.f81440j.n();
    }

    public int getDividerInsetStart() {
        return this.f81440j.o();
    }

    public int getHeaderCount() {
        return this.f81440j.p();
    }

    public Drawable getItemBackground() {
        return this.f81440j.q();
    }

    public int getItemHorizontalPadding() {
        return this.f81440j.r();
    }

    public int getItemIconPadding() {
        return this.f81440j.s();
    }

    public ColorStateList getItemIconTintList() {
        return this.f81440j.v();
    }

    public int getItemMaxLines() {
        return this.f81440j.t();
    }

    public ColorStateList getItemTextColor() {
        return this.f81440j.u();
    }

    public int getItemVerticalPadding() {
        return this.f81440j.w();
    }

    public Menu getMenu() {
        return this.f81439i;
    }

    public int getSubheaderInsetEnd() {
        return this.f81440j.x();
    }

    public int getSubheaderInsetStart() {
        return this.f81440j.y();
    }

    public boolean m() {
        return this.f81447q;
    }

    public boolean n() {
        return this.f81446p;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f81453w.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.N(this.f81454x);
            drawerLayout.a(this.f81454x);
            if (drawerLayout.C(this)) {
                this.f81453w.e();
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f81445o);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).N(this.f81454x);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.f81442l), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.f81442l, 1073741824);
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        this.f81439i.T(savedState.f81458c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f81458c = bundle;
        this.f81439i.V(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        p(i3, i4);
    }

    public void setBottomInsetScrimEnabled(boolean z2) {
        this.f81447q = z2;
    }

    public void setCheckedItem(int i3) {
        MenuItem menuItemFindItem = this.f81439i.findItem(i3);
        if (menuItemFindItem != null) {
            this.f81440j.B((MenuItemImpl) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i3) {
        this.f81440j.C(i3);
    }

    public void setDividerInsetStart(int i3) {
        this.f81440j.D(i3);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        MaterialShapeUtils.d(this, f3);
    }

    public void setForceCompatClippingEnabled(boolean z2) {
        this.f81451u.g(this, z2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f81440j.E(drawable);
    }

    public void setItemBackgroundResource(int i3) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setItemHorizontalPadding(int i3) {
        this.f81440j.F(i3);
    }

    public void setItemHorizontalPaddingResource(int i3) {
        this.f81440j.F(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconPadding(int i3) {
        this.f81440j.G(i3);
    }

    public void setItemIconPaddingResource(int i3) {
        this.f81440j.G(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconSize(int i3) {
        this.f81440j.H(i3);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f81440j.I(colorStateList);
    }

    public void setItemMaxLines(int i3) {
        this.f81440j.J(i3);
    }

    public void setItemTextAppearance(int i3) {
        this.f81440j.K(i3);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        this.f81440j.L(z2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f81440j.M(colorStateList);
    }

    public void setItemVerticalPadding(int i3) {
        this.f81440j.N(i3);
    }

    public void setItemVerticalPaddingResource(int i3) {
        this.f81440j.N(getResources().getDimensionPixelSize(i3));
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f81441k = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(i3);
        NavigationMenuPresenter navigationMenuPresenter = this.f81440j;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.O(i3);
        }
    }

    public void setSubheaderInsetEnd(int i3) {
        this.f81440j.P(i3);
    }

    public void setSubheaderInsetStart(int i3) {
        this.f81440j.Q(i3);
    }

    public void setTopInsetScrimEnabled(boolean z2) {
        this.f81446p = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f81458c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f81458c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.f81458c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f81439i.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f81440j.B((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    /* JADX INFO: renamed from: com.google.android.material.navigation.NavigationView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationView f81456a;

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnNavigationItemSelectedListener onNavigationItemSelectedListener = this.f81456a.f81441k;
            return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(MenuBuilder menuBuilder) {
        }
    }
}

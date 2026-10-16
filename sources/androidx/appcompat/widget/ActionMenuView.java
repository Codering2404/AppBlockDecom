package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    private int A;
    OnMenuItemClickListener B;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MenuBuilder f1643q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f1644r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1645s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1646t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ActionMenuPresenter f1647u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MenuPresenter.Callback f1648v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    MenuBuilder.Callback f1649w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1650x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1651y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1652z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ActionMenuChildView {
        boolean a();

        boolean b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1658f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f1653a = layoutParams.f1653a;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f1653a = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.B;
            return onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.f1649w;
            if (callback != null) {
                callback.b(menuBuilder);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int L(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$LayoutParams r0 = (androidx.appcompat.widget.ActionMenuView.LayoutParams) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.f()
            if (r9 == 0) goto L28
            r9 = r2
            goto L29
        L28:
            r9 = r1
        L29:
            if (r7 <= 0) goto L4c
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4c
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L45
            int r4 = r4 + 1
        L45:
            if (r9 == 0) goto L4a
            if (r4 >= r3) goto L4a
            goto L4d
        L4a:
            r3 = r4
            goto L4d
        L4c:
            r3 = r1
        L4d:
            boolean r7 = r0.f1653a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f1656d = r1
            r0.f1654b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.L(android.view.View, int, int, int, int):int");
    }

    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v48 */
    private void M(int i3, int i4) {
        long j3;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        ?? r3;
        int i7;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.f1652z;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int iMax = 0;
        int i13 = 0;
        boolean z4 = false;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        long j4 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i16 = size2;
            if (childAt.getVisibility() == 8) {
                i7 = i12;
            } else {
                boolean z5 = childAt instanceof ActionMenuItemView;
                i14++;
                if (z5) {
                    int i17 = this.A;
                    z3 = z5;
                    r3 = 0;
                    childAt.setPadding(i17, 0, i17, 0);
                } else {
                    z3 = z5;
                    r3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1658f = r3;
                layoutParams.f1655c = r3;
                layoutParams.f1654b = r3;
                layoutParams.f1656d = r3;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = r3;
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = r3;
                layoutParams.f1657e = z3 && ((ActionMenuItemView) childAt).f();
                int iL = L(childAt, i12, layoutParams.f1653a ? 1 : i10, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                i7 = i12;
                if (layoutParams.f1656d) {
                    i15++;
                }
                if (layoutParams.f1653a) {
                    z4 = true;
                }
                i10 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j4 |= (long) (1 << i13);
                }
            }
            i13++;
            size2 = i16;
            i12 = i7;
        }
        int i18 = size2;
        int i19 = i12;
        char c3 = 2;
        boolean z6 = z4 && i14 == 2;
        boolean z7 = false;
        while (i15 > 0 && i10 > 0) {
            int i20 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long j5 = 0;
            char c4 = c3;
            int i21 = 0;
            int i22 = 0;
            j3 = 1;
            while (i22 < childCount) {
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i22).getLayoutParams();
                boolean z8 = z6;
                if (layoutParams2.f1656d) {
                    int i23 = layoutParams2.f1654b;
                    if (i23 < i20) {
                        j5 = 1 << i22;
                        i20 = i23;
                        i21 = 1;
                    } else if (i23 == i20) {
                        j5 |= 1 << i22;
                        i21++;
                    }
                }
                i22++;
                z6 = z8;
            }
            boolean z9 = z6;
            j4 |= j5;
            if (i21 > i10) {
                break;
            }
            int i24 = i20 + 1;
            int i25 = 0;
            while (i25 < childCount) {
                View childAt2 = getChildAt(i25);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                long j6 = 1 << i25;
                if ((j5 & j6) == 0) {
                    if (layoutParams3.f1654b == i24) {
                        j4 |= j6;
                    }
                    i6 = i25;
                } else {
                    if (!z9 || !layoutParams3.f1657e) {
                        i6 = i25;
                        z2 = true;
                    } else if (i10 == 1) {
                        int i26 = this.A;
                        z2 = true;
                        i6 = i25;
                        childAt2.setPadding(i26 + i19, 0, i26, 0);
                    } else {
                        i6 = i25;
                        z2 = true;
                    }
                    layoutParams3.f1654b++;
                    layoutParams3.f1658f = z2;
                    i10--;
                }
                i25 = i6 + 1;
            }
            c3 = c4;
            z6 = z9;
            z7 = true;
        }
        j3 = 1;
        boolean z10 = !z4 && i14 == 1;
        if (i10 <= 0 || j4 == 0 || (i10 >= i14 - 1 && !z10 && iMax2 <= 1)) {
            i5 = 0;
        } else {
            float fBitCount = Long.bitCount(j4);
            if (z10) {
                i5 = 0;
            } else {
                if ((j4 & j3) != 0) {
                    i5 = 0;
                    if (!((LayoutParams) getChildAt(0).getLayoutParams()).f1657e) {
                        fBitCount -= 0.5f;
                    }
                } else {
                    i5 = 0;
                }
                int i27 = childCount - 1;
                if ((j4 & ((long) (1 << i27))) != 0 && !((LayoutParams) getChildAt(i27).getLayoutParams()).f1657e) {
                    fBitCount -= 0.5f;
                }
            }
            int i28 = fBitCount > 0.0f ? (int) ((i10 * i19) / fBitCount) : i5;
            boolean z11 = z7;
            for (int i29 = i5; i29 < childCount; i29++) {
                if ((j4 & ((long) (1 << i29))) != 0) {
                    View childAt3 = getChildAt(i29);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f1655c = i28;
                        layoutParams4.f1658f = true;
                        if (i29 == 0 && !layoutParams4.f1657e) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = (-i28) / 2;
                        }
                        z11 = true;
                    } else if (layoutParams4.f1653a) {
                        layoutParams4.f1655c = i28;
                        layoutParams4.f1658f = true;
                        ((LinearLayout.LayoutParams) layoutParams4).rightMargin = (-i28) / 2;
                        z11 = true;
                    } else {
                        if (i29 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = i28 / 2;
                        }
                        if (i29 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams4).rightMargin = i28 / 2;
                        }
                    }
                }
            }
            z7 = z11;
        }
        if (z7) {
            for (int i30 = i5; i30 < childCount; i30++) {
                View childAt4 = getChildAt(i30);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1658f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f1654b * i19) + layoutParams5.f1655c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i8, mode != 1073741824 ? iMax : i18);
    }

    public void B() {
        ActionMenuPresenter actionMenuPresenter = this.f1647u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LayoutParams k() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LayoutParams l(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LayoutParams m(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
        }
        return layoutParams2;
    }

    public LayoutParams F() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f1653a = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    protected boolean G(int i3) {
        boolean zA = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            zA = ((ActionMenuChildView) childAt).a();
        }
        return (i3 <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? zA : ((ActionMenuChildView) childAt2).b() | zA;
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.f1647u;
        return actionMenuPresenter != null && actionMenuPresenter.E();
    }

    public boolean I() {
        ActionMenuPresenter actionMenuPresenter = this.f1647u;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean J() {
        ActionMenuPresenter actionMenuPresenter = this.f1647u;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    public boolean K() {
        return this.f1646t;
    }

    public MenuBuilder N() {
        return this.f1643q;
    }

    public void O(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1648v = callback;
        this.f1649w = callback2;
    }

    public boolean P() {
        ActionMenuPresenter actionMenuPresenter = this.f1647u;
        return actionMenuPresenter != null && actionMenuPresenter.N();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void a(MenuBuilder menuBuilder) {
        this.f1643q = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean b(MenuItemImpl menuItemImpl) {
        return this.f1643q.O(menuItemImpl, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1643q == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1643q = menuBuilder;
            menuBuilder.W(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1647u = actionMenuPresenter;
            actionMenuPresenter.M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1647u;
            MenuPresenter.Callback actionMenuPresenterCallback = this.f1648v;
            if (actionMenuPresenterCallback == null) {
                actionMenuPresenterCallback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.d(actionMenuPresenterCallback);
            this.f1643q.c(this.f1647u, this.f1644r);
            this.f1647u.K(this);
        }
        return this.f1643q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1647u.D();
    }

    public int getPopupTheme() {
        return this.f1645s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1647u;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h(false);
            if (this.f1647u.H()) {
                this.f1647u.E();
                this.f1647u.N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int width;
        int paddingLeft;
        if (!this.f1650x) {
            super.onLayout(z2, i3, i4, i5, i6);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i6 - i4) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i5 - i3;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zB = ViewUtils.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1653a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    G(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int iMax = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1653a) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1653a) {
                int i20 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft2 = i20 + measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i3, int i4) {
        MenuBuilder menuBuilder;
        boolean z2 = this.f1650x;
        boolean z3 = View.MeasureSpec.getMode(i3) == 1073741824;
        this.f1650x = z3;
        if (z2 != z3) {
            this.f1651y = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.f1650x && (menuBuilder = this.f1643q) != null && size != this.f1651y) {
            this.f1651y = size;
            menuBuilder.N(true);
        }
        int childCount = getChildCount();
        if (this.f1650x && childCount > 0) {
            M(i3, i4);
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i3, i4);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f1647u.J(z2);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.B = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1647u.L(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.f1646t = z2;
    }

    public void setPopupTheme(int i3) {
        if (this.f1645s != i3) {
            this.f1645s = i3;
            if (i3 == 0) {
                this.f1644r = getContext();
            } else {
                this.f1644r = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1647u = actionMenuPresenter;
        actionMenuPresenter.K(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f1652z = (int) (56.0f * f3);
        this.A = (int) (f3 * 4.0f);
        this.f1644r = context;
        this.f1645s = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(MenuBuilder menuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(MenuBuilder menuBuilder, boolean z2) {
        }
    }
}

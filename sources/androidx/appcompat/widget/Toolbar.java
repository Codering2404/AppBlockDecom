package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private ColorStateList A;
    private ColorStateList B;
    private boolean C;
    private boolean D;
    private final ArrayList E;
    private final ArrayList F;
    private final int[] G;
    final MenuHostHelper H;
    private ArrayList I;
    OnMenuItemClickListener J;
    private final ActionMenuView.OnMenuItemClickListener K;
    private ToolbarWidgetWrapper L;
    private ActionMenuPresenter M;
    private ExpandedActionViewMenuPresenter N;
    private MenuPresenter.Callback O;
    MenuBuilder.Callback P;
    private boolean Q;
    private OnBackInvokedCallback R;
    private OnBackInvokedDispatcher S;
    private boolean T;
    private final Runnable U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ActionMenuView f2249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f2250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f2251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageButton f2252d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f2253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f2254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CharSequence f2255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ImageButton f2256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    View f2257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f2258k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2259l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2260m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2261n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f2262o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2263p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2264q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2265r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f2266s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2267t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RtlSpacingHelper f2268u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2269v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f2270w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f2271x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CharSequence f2272y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CharSequence f2273z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.x
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2285e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2286f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2287g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2288h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2289i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f2290j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f2291k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f2292l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f2293m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f2294n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f2295o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f2296p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f2297q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f2298r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f2299s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f2300t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f2301u;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(Toolbar toolbar, PropertyReader propertyReader) {
            if (!this.f2281a) {
                throw c.a();
            }
            propertyReader.readObject(this.f2282b, toolbar.getCollapseContentDescription());
            propertyReader.readObject(this.f2283c, toolbar.getCollapseIcon());
            propertyReader.readInt(this.f2284d, toolbar.getContentInsetEnd());
            propertyReader.readInt(this.f2285e, toolbar.getContentInsetEndWithActions());
            propertyReader.readInt(this.f2286f, toolbar.getContentInsetLeft());
            propertyReader.readInt(this.f2287g, toolbar.getContentInsetRight());
            propertyReader.readInt(this.f2288h, toolbar.getContentInsetStart());
            propertyReader.readInt(this.f2289i, toolbar.getContentInsetStartWithNavigation());
            propertyReader.readObject(this.f2290j, toolbar.getLogo());
            propertyReader.readObject(this.f2291k, toolbar.getLogoDescription());
            propertyReader.readObject(this.f2292l, toolbar.getMenu());
            propertyReader.readObject(this.f2293m, toolbar.getNavigationContentDescription());
            propertyReader.readObject(this.f2294n, toolbar.getNavigationIcon());
            propertyReader.readResourceId(this.f2295o, toolbar.getPopupTheme());
            propertyReader.readObject(this.f2296p, toolbar.getSubtitle());
            propertyReader.readObject(this.f2297q, toolbar.getTitle());
            propertyReader.readInt(this.f2298r, toolbar.getTitleMarginBottom());
            propertyReader.readInt(this.f2299s, toolbar.getTitleMarginEnd());
            propertyReader.readInt(this.f2300t, toolbar.getTitleMarginStart());
            propertyReader.readInt(this.f2301u, toolbar.getTitleMarginTop());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f2282b = propertyMapper.mapObject("collapseContentDescription", R.attr.E);
            this.f2283c = propertyMapper.mapObject("collapseIcon", R.attr.F);
            this.f2284d = propertyMapper.mapInt("contentInsetEnd", R.attr.M);
            this.f2285e = propertyMapper.mapInt("contentInsetEndWithActions", R.attr.N);
            this.f2286f = propertyMapper.mapInt("contentInsetLeft", R.attr.O);
            this.f2287g = propertyMapper.mapInt("contentInsetRight", R.attr.P);
            this.f2288h = propertyMapper.mapInt("contentInsetStart", R.attr.Q);
            this.f2289i = propertyMapper.mapInt("contentInsetStartWithNavigation", R.attr.R);
            this.f2290j = propertyMapper.mapObject("logo", R.attr.f640e0);
            this.f2291k = propertyMapper.mapObject("logoDescription", R.attr.f642f0);
            this.f2292l = propertyMapper.mapObject("menu", R.attr.f646h0);
            this.f2293m = propertyMapper.mapObject("navigationContentDescription", R.attr.f648i0);
            this.f2294n = propertyMapper.mapObject("navigationIcon", R.attr.f650j0);
            this.f2295o = propertyMapper.mapResourceId("popupTheme", R.attr.f654l0);
            this.f2296p = propertyMapper.mapObject("subtitle", R.attr.f674v0);
            this.f2297q = propertyMapper.mapObject("title", R.attr.F0);
            this.f2298r = propertyMapper.mapInt("titleMarginBottom", R.attr.G0);
            this.f2299s = propertyMapper.mapInt("titleMarginEnd", R.attr.H0);
            this.f2300t = propertyMapper.mapInt("titleMarginStart", R.attr.I0);
            this.f2301u = propertyMapper.mapInt("titleMarginTop", R.attr.J0);
            this.f2281a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.L0);
    }

    private int C(View view, int i3, int[] iArr, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = i3 + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        int iQ = q(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int D(View view, int i3, int[] iArr, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i3 - Math.max(0, i5);
        iArr[1] = Math.max(0, -i5);
        int iQ = q(view, i4);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int E(View view, int i3, int i4, int i5, int i6, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i7) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + iMax + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i3, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.H.f(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.I = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.U);
        post(this.U);
    }

    private boolean O() {
        if (!this.Q) {
            return false;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i3) {
        boolean z2 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iB = GravityCompat.b(i3, getLayoutDirection());
        list.clear();
        if (!z2) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2302b == 0 && P(childAt) && p(layoutParams.f900a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f2302b == 0 && P(childAt2) && p(layoutParams2.f900a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParamsGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        layoutParamsGenerateDefaultLayoutParams.f2302b = 1;
        if (!z2 || this.f2257j == null) {
            addView(view, layoutParamsGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.F.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i3 = 0; i3 < menu.size(); i3++) {
            arrayList.add(menu.getItem(i3));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private void h() {
        if (this.f2268u == null) {
            this.f2268u = new RtlSpacingHelper();
        }
    }

    private void i() {
        if (this.f2253f == null) {
            this.f2253f = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f2249a.N() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f2249a.getMenu();
            if (this.N == null) {
                this.N = new ExpandedActionViewMenuPresenter();
            }
            this.f2249a.setExpandedActionViewsExclusive(true);
            menuBuilder.c(this.N, this.f2258k);
            R();
        }
    }

    private void k() {
        if (this.f2249a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f2249a = actionMenuView;
            actionMenuView.setPopupTheme(this.f2259l);
            this.f2249a.setOnMenuItemClickListener(this.K);
            this.f2249a.O(this.O, new MenuBuilder.Callback() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
                public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
                    MenuBuilder.Callback callback = Toolbar.this.P;
                    return callback != null && callback.a(menuBuilder, menuItem);
                }

                @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
                public void b(MenuBuilder menuBuilder) {
                    if (!Toolbar.this.f2249a.J()) {
                        Toolbar.this.H.i(menuBuilder);
                    }
                    MenuBuilder.Callback callback = Toolbar.this.P;
                    if (callback != null) {
                        callback.b(menuBuilder);
                    }
                }
            });
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f900a = (this.f2262o & 112) | 8388613;
            this.f2249a.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            c(this.f2249a, false);
        }
    }

    private void l() {
        if (this.f2252d == null) {
            this.f2252d = new AppCompatImageButton(getContext(), null, R.attr.K0);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f900a = (this.f2262o & 112) | 8388611;
            this.f2252d.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
        }
    }

    private int p(int i3) {
        int layoutDirection = getLayoutDirection();
        int iB = GravityCompat.b(i3, layoutDirection) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : layoutDirection == 1 ? 5 : 3;
    }

    private int q(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i3 > 0 ? (measuredHeight - i3) / 2 : 0;
        int iR = r(layoutParams.f900a);
        if (iR == 48) {
            return getPaddingTop() - i4;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i5) {
            iMax = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i6 < i7) {
                iMax = Math.max(0, iMax - (i7 - i6));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i3) {
        int i4 = i3 & 112;
        return (i4 == 16 || i4 == 48 || i4 == 80) ? i4 : this.f2271x & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List list, int[] iArr) {
        int i3 = iArr[0];
        int i4 = iArr[1];
        int size = list.size();
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            View view = (View) list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i3;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i4;
            int iMax = Math.max(0, i6);
            int iMax2 = Math.max(0, i7);
            int iMax3 = Math.max(0, -i6);
            int iMax4 = Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i4 = iMax4;
            i3 = iMax3;
        }
        return measuredWidth;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f2249a;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f2249a;
        return actionMenuView != null && actionMenuView.J();
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).f2302b != 2 && childAt != this.f2249a) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    public void J(int i3, int i4) {
        h();
        this.f2268u.g(i3, i4);
    }

    public void K(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.f2249a == null) {
            return;
        }
        k();
        MenuBuilder menuBuilderN = this.f2249a.N();
        if (menuBuilderN == menuBuilder) {
            return;
        }
        if (menuBuilderN != null) {
            menuBuilderN.R(this.M);
            menuBuilderN.R(this.N);
        }
        if (this.N == null) {
            this.N = new ExpandedActionViewMenuPresenter();
        }
        actionMenuPresenter.J(true);
        if (menuBuilder != null) {
            menuBuilder.c(actionMenuPresenter, this.f2258k);
            menuBuilder.c(this.N, this.f2258k);
        } else {
            actionMenuPresenter.k(this.f2258k, null);
            this.N.k(this.f2258k, null);
            actionMenuPresenter.h(true);
            this.N.h(true);
        }
        this.f2249a.setPopupTheme(this.f2259l);
        this.f2249a.setPresenter(actionMenuPresenter);
        this.M = actionMenuPresenter;
        R();
    }

    public void L(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.O = callback;
        this.P = callback2;
        ActionMenuView actionMenuView = this.f2249a;
        if (actionMenuView != null) {
            actionMenuView.O(callback, callback2);
        }
    }

    public void M(Context context, int i3) {
        this.f2261n = i3;
        TextView textView = this.f2251c;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public void N(Context context, int i3) {
        this.f2260m = i3;
        TextView textView = this.f2250b;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.f2249a;
        return actionMenuView != null && actionMenuView.P();
    }

    void R() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = Api33Impl.a(this);
            boolean z2 = v() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.T;
            if (z2 && this.S == null) {
                if (this.R == null) {
                    this.R = Api33Impl.b(new Runnable() { // from class: androidx.appcompat.widget.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2356a.e();
                        }
                    });
                }
                Api33Impl.c(onBackInvokedDispatcherA, this.R);
                this.S = onBackInvokedDispatcherA;
                return;
            }
            if (z2 || (onBackInvokedDispatcher = this.S) == null) {
                return;
            }
            Api33Impl.d(onBackInvokedDispatcher, this.R);
            this.S = null;
        }
    }

    void a() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView((View) this.F.get(size));
        }
        this.F.clear();
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider) {
        this.H.c(menuProvider);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2249a) != null && actionMenuView.K();
    }

    public void e() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.N;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.f2279b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f2249a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f2256i == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.K0);
            this.f2256i = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f2254g);
            this.f2256i.setContentDescription(this.f2255h);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f900a = (this.f2262o & 112) | 8388611;
            layoutParamsGenerateDefaultLayoutParams.f2302b = 2;
            this.f2256i.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.f2256i.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.e();
                }
            });
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f2256i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f2256i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.f2268u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i3 = this.f2270w;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.f2268u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.f2268u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.f2268u;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i3 = this.f2269v;
        return i3 != Integer.MIN_VALUE ? i3 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder menuBuilderN;
        ActionMenuView actionMenuView = this.f2249a;
        return (actionMenuView == null || (menuBuilderN = actionMenuView.N()) == null || !menuBuilderN.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f2270w, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2269v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f2253f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f2253f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f2249a.getMenu();
    }

    View getNavButtonView() {
        return this.f2252d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2252d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2252d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.M;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f2249a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f2258k;
    }

    public int getPopupTheme() {
        return this.f2259l;
    }

    public CharSequence getSubtitle() {
        return this.f2273z;
    }

    final TextView getSubtitleTextView() {
        return this.f2251c;
    }

    public CharSequence getTitle() {
        return this.f2272y;
    }

    public int getTitleMarginBottom() {
        return this.f2267t;
    }

    public int getTitleMarginEnd() {
        return this.f2265r;
    }

    public int getTitleMarginStart() {
        return this.f2264q;
    }

    public int getTitleMarginTop() {
        return this.f2266s;
    }

    final TextView getTitleTextView() {
        return this.f2250b;
    }

    public DecorToolbar getWrapper() {
        if (this.L == null) {
            this.L = new ToolbarWidgetWrapper(this, true);
        }
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ActionBar.LayoutParams ? new LayoutParams((ActionBar.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U);
        R();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0297 A[LOOP:0: B:104:0x0295->B:105:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b5 A[LOOP:1: B:107:0x02b3->B:108:0x02b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ec A[LOOP:2: B:116:0x02ea->B:117:0x02ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 769
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int[] iArr;
        int iMax2;
        int iCombineMeasuredStates2;
        int measuredHeight;
        int[] iArr2 = this.G;
        boolean zB = ViewUtils.b(this);
        int i5 = !zB ? 1 : 0;
        if (P(this.f2252d)) {
            F(this.f2252d, i3, 0, i4, 0, this.f2263p);
            measuredWidth = this.f2252d.getMeasuredWidth() + s(this.f2252d);
            iMax = Math.max(0, this.f2252d.getMeasuredHeight() + t(this.f2252d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2252d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (P(this.f2256i)) {
            F(this.f2256i, i3, 0, i4, 0, this.f2263p);
            measuredWidth = this.f2256i.getMeasuredWidth() + s(this.f2256i);
            iMax = Math.max(iMax, this.f2256i.getMeasuredHeight() + t(this.f2256i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2256i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr2[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (P(this.f2249a)) {
            F(this.f2249a, i3, iMax3, i4, 0, this.f2263p);
            measuredWidth2 = this.f2249a.getMeasuredWidth() + s(this.f2249a);
            iMax = Math.max(iMax, this.f2249a.getMeasuredHeight() + t(this.f2249a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2249a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr2[i5] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (P(this.f2257j)) {
            iArr = iArr2;
            iMax4 += E(this.f2257j, i3, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f2257j.getMeasuredHeight() + t(this.f2257j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2257j.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (P(this.f2253f)) {
            iMax4 += E(this.f2253f, i3, iMax4, i4, 0, iArr);
            iMax = Math.max(iMax, this.f2253f.getMeasuredHeight() + t(this.f2253f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2253f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (((LayoutParams) childAt.getLayoutParams()).f2302b == 0 && P(childAt)) {
                iMax4 += E(childAt, i3, iMax4, i4, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i7 = iMax4;
        int i8 = this.f2266s + this.f2267t;
        int i9 = this.f2264q + this.f2265r;
        if (P(this.f2250b)) {
            E(this.f2250b, i3, i7 + i9, i4, i8, iArr);
            int measuredWidth3 = this.f2250b.getMeasuredWidth() + s(this.f2250b);
            int measuredHeight2 = this.f2250b.getMeasuredHeight() + t(this.f2250b);
            iMax2 = measuredWidth3;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2250b.getMeasuredState());
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            measuredHeight = 0;
        }
        if (P(this.f2251c)) {
            iMax2 = Math.max(iMax2, E(this.f2251c, i3, i7 + i9, i4, i8 + measuredHeight, iArr));
            measuredHeight += this.f2251c.getMeasuredHeight() + t(this.f2251c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2251c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, (-16777216) & iCombineMeasuredStates2), O() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        ActionMenuView actionMenuView = this.f2249a;
        MenuBuilder menuBuilderN = actionMenuView != null ? actionMenuView.N() : null;
        int i3 = savedState.f2303c;
        if (i3 != 0 && this.N != null && menuBuilderN != null && (menuItemFindItem = menuBuilderN.findItem(i3)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f2304d) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        h();
        this.f2268u.f(i3 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.N;
        if (expandedActionViewMenuPresenter != null && (menuItemImpl = expandedActionViewMenuPresenter.f2279b) != null) {
            savedState.f2303c = menuItemImpl.getItemId();
        }
        savedState.f2304d = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider menuProvider) {
        this.H.j(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.T != z2) {
            this.T = z2;
            R();
        }
    }

    public void setCollapseContentDescription(int i3) {
        setCollapseContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setCollapseIcon(int i3) {
        setCollapseIcon(AppCompatResources.b(getContext(), i3));
    }

    public void setCollapsible(boolean z2) {
        this.Q = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f2270w) {
            this.f2270w = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i3) {
        if (i3 < 0) {
            i3 = Integer.MIN_VALUE;
        }
        if (i3 != this.f2269v) {
            this.f2269v = i3;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i3) {
        setLogo(AppCompatResources.b(getContext(), i3));
    }

    public void setLogoDescription(int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    public void setNavigationContentDescription(int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    public void setNavigationIcon(int i3) {
        setNavigationIcon(AppCompatResources.b(getContext(), i3));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f2252d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.J = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f2249a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i3) {
        if (this.f2259l != i3) {
            this.f2259l = i3;
            if (i3 == 0) {
                this.f2258k = getContext();
            } else {
                this.f2258k = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setSubtitle(int i3) {
        setSubtitle(getContext().getText(i3));
    }

    public void setSubtitleTextColor(int i3) {
        setSubtitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitle(int i3) {
        setTitle(getContext().getText(i3));
    }

    public void setTitleMarginBottom(int i3) {
        this.f2267t = i3;
        requestLayout();
    }

    public void setTitleMarginEnd(int i3) {
        this.f2265r = i3;
        requestLayout();
    }

    public void setTitleMarginStart(int i3) {
        this.f2264q = i3;
        requestLayout();
    }

    public void setTitleMarginTop(int i3) {
        this.f2266s = i3;
        requestLayout();
    }

    public void setTitleTextColor(int i3) {
        setTitleTextColor(ColorStateList.valueOf(i3));
    }

    public boolean v() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.N;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.f2279b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f2249a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i3) {
        getMenuInflater().inflate(i3, getMenu());
    }

    public void y() {
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        G();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ActionBar.LayoutParams {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2302b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2302b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f2302b = 0;
            this.f900a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f2302b = 0;
            this.f2302b = layoutParams.f2302b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2302b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2302b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2302b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2271x = 8388627;
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new int[2];
        this.H = new MenuHostHelper(new Runnable() { // from class: androidx.appcompat.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f2357a.y();
            }
        });
        this.I = new ArrayList();
        this.K = new ActionMenuView.OnMenuItemClickListener() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.H.h(menuItem)) {
                    return true;
                }
                OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.J;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.U = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.Q();
            }
        };
        Context context2 = getContext();
        int[] iArr = R.styleable.n3;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context2, attributeSet, iArr, i3, 0);
        ViewCompat.k0(this, context, iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        this.f2260m = tintTypedArrayV.n(R.styleable.P3, 0);
        this.f2261n = tintTypedArrayV.n(R.styleable.G3, 0);
        this.f2271x = tintTypedArrayV.l(R.styleable.o3, this.f2271x);
        this.f2262o = tintTypedArrayV.l(R.styleable.p3, 48);
        int iE = tintTypedArrayV.e(R.styleable.J3, 0);
        int i4 = R.styleable.O3;
        iE = tintTypedArrayV.s(i4) ? tintTypedArrayV.e(i4, iE) : iE;
        this.f2267t = iE;
        this.f2266s = iE;
        this.f2265r = iE;
        this.f2264q = iE;
        int iE2 = tintTypedArrayV.e(R.styleable.M3, -1);
        if (iE2 >= 0) {
            this.f2264q = iE2;
        }
        int iE3 = tintTypedArrayV.e(R.styleable.L3, -1);
        if (iE3 >= 0) {
            this.f2265r = iE3;
        }
        int iE4 = tintTypedArrayV.e(R.styleable.N3, -1);
        if (iE4 >= 0) {
            this.f2266s = iE4;
        }
        int iE5 = tintTypedArrayV.e(R.styleable.K3, -1);
        if (iE5 >= 0) {
            this.f2267t = iE5;
        }
        this.f2263p = tintTypedArrayV.f(R.styleable.A3, -1);
        int iE6 = tintTypedArrayV.e(R.styleable.w3, Integer.MIN_VALUE);
        int iE7 = tintTypedArrayV.e(R.styleable.s3, Integer.MIN_VALUE);
        int iF = tintTypedArrayV.f(R.styleable.u3, 0);
        int iF2 = tintTypedArrayV.f(R.styleable.v3, 0);
        h();
        this.f2268u.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f2268u.g(iE6, iE7);
        }
        this.f2269v = tintTypedArrayV.e(R.styleable.x3, Integer.MIN_VALUE);
        this.f2270w = tintTypedArrayV.e(R.styleable.t3, Integer.MIN_VALUE);
        this.f2254g = tintTypedArrayV.g(R.styleable.r3);
        this.f2255h = tintTypedArrayV.p(R.styleable.q3);
        CharSequence charSequenceP = tintTypedArrayV.p(R.styleable.I3);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = tintTypedArrayV.p(R.styleable.F3);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f2258k = getContext();
        setPopupTheme(tintTypedArrayV.n(R.styleable.E3, 0));
        Drawable drawableG = tintTypedArrayV.g(R.styleable.D3);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = tintTypedArrayV.p(R.styleable.C3);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = tintTypedArrayV.g(R.styleable.y3);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = tintTypedArrayV.p(R.styleable.z3);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i5 = R.styleable.Q3;
        if (tintTypedArrayV.s(i5)) {
            setTitleTextColor(tintTypedArrayV.c(i5));
        }
        int i6 = R.styleable.H3;
        if (tintTypedArrayV.s(i6)) {
            setSubtitleTextColor(tintTypedArrayV.c(i6));
        }
        int i7 = R.styleable.B3;
        if (tintTypedArrayV.s(i7)) {
            x(tintTypedArrayV.n(i7, 0));
        }
        tintTypedArrayV.x();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f2256i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f2256i.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f2256i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f2254g);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f2253f)) {
                c(this.f2253f, true);
            }
        } else {
            ImageView imageView = this.f2253f;
            if (imageView != null && z(imageView)) {
                removeView(this.f2253f);
                this.F.remove(this.f2253f);
            }
        }
        ImageView imageView2 = this.f2253f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f2253f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f2252d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            TooltipCompat.a(this.f2252d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f2252d)) {
                c(this.f2252d, true);
            }
        } else {
            ImageButton imageButton = this.f2252d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f2252d);
                this.F.remove(this.f2252d);
            }
        }
        ImageButton imageButton2 = this.f2252d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2251c;
            if (textView != null && z(textView)) {
                removeView(this.f2251c);
                this.F.remove(this.f2251c);
            }
        } else {
            if (this.f2251c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2251c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2251c.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f2261n;
                if (i3 != 0) {
                    this.f2251c.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f2251c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2251c)) {
                c(this.f2251c, true);
            }
        }
        TextView textView2 = this.f2251c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2273z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f2251c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2250b;
            if (textView != null && z(textView)) {
                removeView(this.f2250b);
                this.F.remove(this.f2250b);
            }
        } else {
            if (this.f2250b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2250b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2250b.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.f2260m;
                if (i3 != 0) {
                    this.f2250b.setTextAppearance(context, i3);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f2250b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2250b)) {
                c(this.f2250b, true);
            }
        }
        TextView textView2 = this.f2250b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2272y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f2250b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
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
        int f2303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2304d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2303c = parcel.readInt();
            this.f2304d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2303c);
            parcel.writeInt(this.f2304d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ExpandedActionViewMenuPresenter implements MenuPresenter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MenuBuilder f2278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        MenuItemImpl f2279b;

        ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f2256i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2256i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2256i);
            }
            Toolbar.this.f2257j = menuItemImpl.getActionView();
            this.f2279b = menuItemImpl;
            ViewParent parent2 = Toolbar.this.f2257j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2257j);
                }
                LayoutParams layoutParamsGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                layoutParamsGenerateDefaultLayoutParams.f900a = (toolbar4.f2262o & 112) | 8388611;
                layoutParamsGenerateDefaultLayoutParams.f2302b = 2;
                toolbar4.f2257j.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2257j);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            menuItemImpl.r(true);
            KeyEvent.Callback callback = Toolbar.this.f2257j;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).onActionViewExpanded();
            }
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean f(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable g() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void h(boolean z2) {
            if (this.f2279b != null) {
                MenuBuilder menuBuilder = this.f2278a;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.f2278a.getItem(i3) == this.f2279b) {
                            return;
                        }
                    }
                }
                j(this.f2278a, this.f2279b);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean i() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            KeyEvent.Callback callback = Toolbar.this.f2257j;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2257j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2256i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2257j = null;
            toolbar3.a();
            this.f2279b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.r(false);
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void k(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f2278a;
            if (menuBuilder2 != null && (menuItemImpl = this.f2279b) != null) {
                menuBuilder2.f(menuItemImpl);
            }
            this.f2278a = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void e(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void a(MenuBuilder menuBuilder, boolean z2) {
        }
    }
}

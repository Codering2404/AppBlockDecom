package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] G = {R.attr.state_checked};
    private static final int[] H = {-16842910};
    private int A;
    private ShapeAppearanceModel B;
    private boolean C;
    private ColorStateList D;
    private NavigationBarPresenter E;
    private MenuBuilder F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransitionSet f81397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.OnClickListener f81398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pools.Pool f81399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f81400d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f81401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private NavigationBarItemView[] f81402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f81403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f81404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f81405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f81406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f81407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ColorStateList f81408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f81409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f81410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f81411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f81412q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ColorStateList f81413r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f81414s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final SparseArray f81415t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f81416u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f81417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f81418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f81419x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f81420y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f81421z;

    /* JADX INFO: renamed from: com.google.android.material.navigation.NavigationBarMenuView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationBarMenuView f81422a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
            if (this.f81422a.F.P(itemData, this.f81422a.E, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    private Drawable e() {
        if (this.B == null || this.D == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.B);
        materialShapeDrawable.a0(this.D);
        return materialShapeDrawable;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.f81399c.a();
        return navigationBarItemView == null ? f(getContext()) : navigationBarItemView;
    }

    private boolean h(int i3) {
        return i3 != -1;
    }

    private void i() {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            hashSet.add(Integer.valueOf(this.F.getItem(i3).getItemId()));
        }
        for (int i4 = 0; i4 < this.f81415t.size(); i4++) {
            int iKeyAt = this.f81415t.keyAt(i4);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.f81415t.delete(iKeyAt);
            }
        }
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (h(id) && (badgeDrawable = (BadgeDrawable) this.f81415t.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void a(MenuBuilder menuBuilder) {
        this.F = menuBuilder;
    }

    public void d() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f81399c.b(navigationBarItemView);
                    navigationBarItemView.h();
                }
            }
        }
        if (this.F.size() == 0) {
            this.f81403h = 0;
            this.f81404i = 0;
            this.f81402g = null;
            return;
        }
        i();
        this.f81402g = new NavigationBarItemView[this.F.size()];
        boolean zG = g(this.f81401f, this.F.G().size());
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            this.E.b(true);
            this.F.getItem(i3).setCheckable(true);
            this.E.b(false);
            NavigationBarItemView newItem = getNewItem();
            this.f81402g[i3] = newItem;
            newItem.setIconTintList(this.f81405j);
            newItem.setIconSize(this.f81406k);
            newItem.setTextColor(this.f81408m);
            newItem.setTextAppearanceInactive(this.f81409n);
            newItem.setTextAppearanceActive(this.f81410o);
            newItem.setTextAppearanceActiveBoldEnabled(this.f81411p);
            newItem.setTextColor(this.f81407l);
            int i4 = this.f81416u;
            if (i4 != -1) {
                newItem.setItemPaddingTop(i4);
            }
            int i5 = this.f81417v;
            if (i5 != -1) {
                newItem.setItemPaddingBottom(i5);
            }
            int i6 = this.f81418w;
            if (i6 != -1) {
                newItem.setActiveIndicatorLabelPadding(i6);
            }
            newItem.setActiveIndicatorWidth(this.f81420y);
            newItem.setActiveIndicatorHeight(this.f81421z);
            newItem.setActiveIndicatorMarginHorizontal(this.A);
            newItem.setActiveIndicatorDrawable(e());
            newItem.setActiveIndicatorResizeable(this.C);
            newItem.setActiveIndicatorEnabled(this.f81419x);
            Drawable drawable = this.f81412q;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f81414s);
            }
            newItem.setItemRippleColor(this.f81413r);
            newItem.setShifting(zG);
            newItem.setLabelVisibilityMode(this.f81401f);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.F.getItem(i3);
            newItem.c(menuItemImpl, 0);
            newItem.setItemPosition(i3);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener((View.OnTouchListener) this.f81400d.get(itemId));
            newItem.setOnClickListener(this.f81398b);
            int i7 = this.f81403h;
            if (i7 != 0 && itemId == i7) {
                this.f81404i = i3;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.F.size() - 1, this.f81404i);
        this.f81404i = iMin;
        this.F.getItem(iMin).setChecked(true);
    }

    protected abstract NavigationBarItemView f(Context context);

    protected boolean g(int i3, int i4) {
        return i3 == -1 ? i4 > 3 : i3 == 0;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f81418w;
    }

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f81415t;
    }

    public ColorStateList getIconTintList() {
        return this.f81405j;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.D;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f81419x;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f81421z;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.A;
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.B;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f81420y;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f81412q : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f81414s;
    }

    public int getItemIconSize() {
        return this.f81406k;
    }

    public int getItemPaddingBottom() {
        return this.f81417v;
    }

    public int getItemPaddingTop() {
        return this.f81416u;
    }

    public ColorStateList getItemRippleColor() {
        return this.f81413r;
    }

    public int getItemTextAppearanceActive() {
        return this.f81410o;
    }

    public int getItemTextAppearanceInactive() {
        return this.f81409n;
    }

    public ColorStateList getItemTextColor() {
        return this.f81407l;
    }

    public int getLabelVisibilityMode() {
        return this.f81401f;
    }

    protected MenuBuilder getMenu() {
        return this.F;
    }

    public int getSelectedItemId() {
        return this.f81403h;
    }

    protected int getSelectedItemPosition() {
        return this.f81404i;
    }

    public int getWindowAnimations() {
        return 0;
    }

    void j(SparseArray sparseArray) {
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            int iKeyAt = sparseArray.keyAt(i3);
            if (this.f81415t.indexOfKey(iKeyAt) < 0) {
                this.f81415t.append(iKeyAt, (BadgeDrawable) sparseArray.get(iKeyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                BadgeDrawable badgeDrawable = (BadgeDrawable) this.f81415t.get(navigationBarItemView.getId());
                if (badgeDrawable != null) {
                    navigationBarItemView.setBadge(badgeDrawable);
                }
            }
        }
    }

    void k(int i3) {
        int size = this.F.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = this.F.getItem(i4);
            if (i3 == item.getItemId()) {
                this.f81403h = i3;
                this.f81404i = i4;
                item.setChecked(true);
                return;
            }
        }
    }

    public void l() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.F;
        if (menuBuilder == null || this.f81402g == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.f81402g.length) {
            d();
            return;
        }
        int i3 = this.f81403h;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = this.F.getItem(i4);
            if (item.isChecked()) {
                this.f81403h = item.getItemId();
                this.f81404i = i4;
            }
        }
        if (i3 != this.f81403h && (transitionSet = this.f81397a) != null) {
            TransitionManager.b(this, transitionSet);
        }
        boolean zG = g(this.f81401f, this.F.G().size());
        for (int i5 = 0; i5 < size; i5++) {
            this.E.b(true);
            this.f81402g[i5].setLabelVisibilityMode(this.f81401f);
            this.f81402g[i5].setShifting(zG);
            this.f81402g[i5].c((MenuItemImpl) this.F.getItem(i5), 0);
            this.E.b(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(1, this.F.G().size(), false, 1));
    }

    public void setActiveIndicatorLabelPadding(int i3) {
        this.f81418w = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i3);
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f81405j = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(e());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z2) {
        this.f81419x = z2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z2);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i3) {
        this.f81421z = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i3);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i3) {
        this.A = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i3);
            }
        }
    }

    protected void setItemActiveIndicatorResizeable(boolean z2) {
        this.C = z2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z2);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.B = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(e());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i3) {
        this.f81420y = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i3);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f81412q = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i3) {
        this.f81414s = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i3);
            }
        }
    }

    public void setItemIconSize(int i3) {
        this.f81406k = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i3);
            }
        }
    }

    public void setItemPaddingBottom(int i3) {
        this.f81417v = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i3);
            }
        }
    }

    public void setItemPaddingTop(int i3) {
        this.f81416u = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i3);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f81413r = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i3) {
        this.f81410o = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i3);
                ColorStateList colorStateList = this.f81407l;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        this.f81411p = z2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z2);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i3) {
        this.f81409n = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i3);
                ColorStateList colorStateList = this.f81407l;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f81407l = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f81402g;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i3) {
        this.f81401f = i3;
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.E = navigationBarPresenter;
    }
}

package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    private int A;
    private int B;
    int C;
    private int D;
    final View.OnClickListener E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NavigationMenuView f81215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LinearLayout f81216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MenuPresenter.Callback f81217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    MenuBuilder f81218d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f81219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    NavigationMenuAdapter f81220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    LayoutInflater f81221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f81222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    ColorStateList f81223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f81224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f81225l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ColorStateList f81226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ColorStateList f81227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable f81228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    RippleDrawable f81229p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f81230q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f81231r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f81232s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f81233t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f81234u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f81235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f81236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f81237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f81238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f81239z;

    /* JADX INFO: renamed from: com.google.android.material.internal.NavigationMenuPresenter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationMenuPresenter f81240a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z2 = true;
            this.f81240a.R(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = this.f81240a;
            boolean zP = navigationMenuPresenter.f81218d.P(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && zP) {
                this.f81240a.f81220g.s(itemData);
            } else {
                z2 = false;
            }
            this.f81240a.R(false);
            if (z2) {
                this.f81240a.h(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ArrayList f81241i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private MenuItemImpl f81242j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f81243k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ NavigationMenuPresenter f81244l;

        /* JADX INFO: Access modifiers changed from: private */
        public int h(int i3) {
            int i4 = i3;
            for (int i5 = 0; i5 < i3; i5++) {
                if (this.f81244l.f81220g.getItemViewType(i5) == 2 || this.f81244l.f81220g.getItemViewType(i5) == 3) {
                    i4--;
                }
            }
            return i4;
        }

        private void i(int i3, int i4) {
            while (i3 < i4) {
                ((NavigationMenuTextItem) this.f81241i.get(i3)).f81251b = true;
                i3++;
            }
        }

        private void p() {
            if (this.f81243k) {
                return;
            }
            boolean z2 = true;
            this.f81243k = true;
            this.f81241i.clear();
            this.f81241i.add(new NavigationMenuHeaderItem());
            int size = this.f81244l.f81218d.G().size();
            int i3 = -1;
            int i4 = 0;
            boolean z3 = false;
            int size2 = 0;
            while (i4 < size) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) this.f81244l.f81218d.G().get(i4);
                if (menuItemImpl.isChecked()) {
                    s(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.t(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.f81241i.add(new NavigationMenuSeparatorItem(this.f81244l.C, 0));
                        }
                        this.f81241i.add(new NavigationMenuTextItem(menuItemImpl));
                        int size3 = this.f81241i.size();
                        int size4 = subMenu.size();
                        int i5 = 0;
                        boolean z4 = false;
                        while (i5 < size4) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                            if (menuItemImpl2.isVisible()) {
                                if (!z4 && menuItemImpl2.getIcon() != null) {
                                    z4 = z2;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.t(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    s(menuItemImpl);
                                }
                                this.f81241i.add(new NavigationMenuTextItem(menuItemImpl2));
                            }
                            i5++;
                            z2 = true;
                        }
                        if (z4) {
                            i(size3, this.f81241i.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i3) {
                        size2 = this.f81241i.size();
                        z3 = menuItemImpl.getIcon() != null;
                        if (i4 != 0) {
                            size2++;
                            ArrayList arrayList = this.f81241i;
                            int i6 = this.f81244l.C;
                            arrayList.add(new NavigationMenuSeparatorItem(i6, i6));
                        }
                    } else if (!z3 && menuItemImpl.getIcon() != null) {
                        i(size2, this.f81241i.size());
                        z3 = true;
                    }
                    NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem.f81251b = z3;
                    this.f81241i.add(navigationMenuTextItem);
                    i3 = groupId;
                }
                i4++;
                z2 = true;
            }
            this.f81243k = false;
        }

        private void r(View view, final int i3, final boolean z2) {
            ViewCompat.m0(view, new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(NavigationMenuAdapter.this.h(i3), 1, 1, 1, z2, view2.isSelected()));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f81241i.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.f81241i.get(i3);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public Bundle j() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f81242j;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f81241i.size();
            for (int i3 = 0; i3 < size; i3++) {
                NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.f81241i.get(i3);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItemImplA = ((NavigationMenuTextItem) navigationMenuItem).a();
                    View actionView = menuItemImplA != null ? menuItemImplA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItemImplA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public MenuItemImpl k() {
            return this.f81242j;
        }

        int l() {
            int i3 = 0;
            for (int i4 = 0; i4 < this.f81244l.f81220g.getItemCount(); i4++) {
                int itemViewType = this.f81244l.f81220g.getItemViewType(i4);
                if (itemViewType == 0 || itemViewType == 1) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder viewHolder, int i3) {
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f81241i.get(i3);
                    viewHolder.itemView.setPadding(this.f81244l.f81234u, navigationMenuSeparatorItem.b(), this.f81244l.f81235v, navigationMenuSeparatorItem.a());
                    return;
                }
                TextView textView = (TextView) viewHolder.itemView;
                textView.setText(((NavigationMenuTextItem) this.f81241i.get(i3)).a().getTitle());
                TextViewCompat.o(textView, this.f81244l.f81222i);
                textView.setPadding(this.f81244l.f81236w, textView.getPaddingTop(), this.f81244l.f81237x, textView.getPaddingBottom());
                ColorStateList colorStateList = this.f81244l.f81223j;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                r(textView, i3, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
            navigationMenuItemView.setIconTintList(this.f81244l.f81227n);
            navigationMenuItemView.setTextAppearance(this.f81244l.f81224k);
            ColorStateList colorStateList2 = this.f81244l.f81226m;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = this.f81244l.f81228o;
            ViewCompat.q0(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = this.f81244l.f81229p;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f81241i.get(i3);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f81251b);
            NavigationMenuPresenter navigationMenuPresenter = this.f81244l;
            int i4 = navigationMenuPresenter.f81230q;
            int i5 = navigationMenuPresenter.f81231r;
            navigationMenuItemView.setPadding(i4, i5, i4, i5);
            navigationMenuItemView.setIconPadding(this.f81244l.f81232s);
            NavigationMenuPresenter navigationMenuPresenter2 = this.f81244l;
            if (navigationMenuPresenter2.f81238y) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.f81233t);
            }
            navigationMenuItemView.setMaxLines(this.f81244l.A);
            navigationMenuItemView.D(navigationMenuTextItem.a(), this.f81244l.f81225l);
            r(navigationMenuItemView, i3, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (i3 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = this.f81244l;
                return new NormalViewHolder(navigationMenuPresenter.f81221h, viewGroup, navigationMenuPresenter.E);
            }
            if (i3 == 1) {
                return new SubheaderViewHolder(this.f81244l.f81221h, viewGroup);
            }
            if (i3 == 2) {
                return new SeparatorViewHolder(this.f81244l.f81221h, viewGroup);
            }
            if (i3 != 3) {
                return null;
            }
            return new HeaderViewHolder(this.f81244l.f81216b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).E();
            }
        }

        public void q(Bundle bundle) {
            MenuItemImpl menuItemImplA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItemImplA2;
            int i3 = bundle.getInt("android:menu:checked", 0);
            if (i3 != 0) {
                this.f81243k = true;
                int size = this.f81241i.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.f81241i.get(i4);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (menuItemImplA2 = ((NavigationMenuTextItem) navigationMenuItem).a()) != null && menuItemImplA2.getItemId() == i3) {
                        s(menuItemImplA2);
                        break;
                    }
                    i4++;
                }
                this.f81243k = false;
                p();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f81241i.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    NavigationMenuItem navigationMenuItem2 = (NavigationMenuItem) this.f81241i.get(i5);
                    if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (menuItemImplA = ((NavigationMenuTextItem) navigationMenuItem2).a()) != null && (actionView = menuItemImplA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItemImplA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void s(MenuItemImpl menuItemImpl) {
            if (this.f81242j == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f81242j;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f81242j = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void t(boolean z2) {
            this.f81243k = z2;
        }

        public void u() {
            p();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface NavigationMenuItem {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f81248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f81249b;

        public NavigationMenuSeparatorItem(int i3, int i4) {
            this.f81248a = i3;
            this.f81249b = i4;
        }

        public int a() {
            return this.f81249b;
        }

        public int b() {
            return this.f81248a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NavigationMenuTextItem implements NavigationMenuItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItemImpl f81250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f81251b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f81250a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f81250a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ NavigationMenuPresenter f81252f;

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(this.f81252f.f81220g.l(), 1, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.f79676g, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.f79677h, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.f79678i, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private void S() {
        int i3 = (z() || !this.f81239z) ? 0 : this.B;
        NavigationMenuView navigationMenuView = this.f81215a;
        navigationMenuView.setPadding(0, i3, 0, navigationMenuView.getPaddingBottom());
    }

    private boolean z() {
        return p() > 0;
    }

    public void A(boolean z2) {
        if (this.f81239z != z2) {
            this.f81239z = z2;
            S();
        }
    }

    public void B(MenuItemImpl menuItemImpl) {
        this.f81220g.s(menuItemImpl);
    }

    public void C(int i3) {
        this.f81235v = i3;
        h(false);
    }

    public void D(int i3) {
        this.f81234u = i3;
        h(false);
    }

    public void E(Drawable drawable) {
        this.f81228o = drawable;
        h(false);
    }

    public void F(int i3) {
        this.f81230q = i3;
        h(false);
    }

    public void G(int i3) {
        this.f81232s = i3;
        h(false);
    }

    public void H(int i3) {
        if (this.f81233t != i3) {
            this.f81233t = i3;
            this.f81238y = true;
            h(false);
        }
    }

    public void I(ColorStateList colorStateList) {
        this.f81227n = colorStateList;
        h(false);
    }

    public void J(int i3) {
        this.A = i3;
        h(false);
    }

    public void K(int i3) {
        this.f81224k = i3;
        h(false);
    }

    public void L(boolean z2) {
        this.f81225l = z2;
        h(false);
    }

    public void M(ColorStateList colorStateList) {
        this.f81226m = colorStateList;
        h(false);
    }

    public void N(int i3) {
        this.f81231r = i3;
        h(false);
    }

    public void O(int i3) {
        this.D = i3;
        NavigationMenuView navigationMenuView = this.f81215a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i3);
        }
    }

    public void P(int i3) {
        this.f81237x = i3;
        h(false);
    }

    public void Q(int i3) {
        this.f81236w = i3;
        h(false);
    }

    public void R(boolean z2) {
        NavigationMenuAdapter navigationMenuAdapter = this.f81220g;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.t(z2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f81217c;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f81215a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f81220g.q(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f81216b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable g() {
        Bundle bundle = new Bundle();
        if (this.f81215a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f81215a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.f81220g;
        if (navigationMenuAdapter != null) {
            bundle.putBundle("android:menu:adapter", navigationMenuAdapter.j());
        }
        if (this.f81216b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f81216b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f81219f;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        NavigationMenuAdapter navigationMenuAdapter = this.f81220g;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.u();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void k(Context context, MenuBuilder menuBuilder) {
        this.f81221h = LayoutInflater.from(context);
        this.f81218d = menuBuilder;
        this.C = context.getResources().getDimensionPixelOffset(R.dimen.f79568h);
    }

    public void l(WindowInsetsCompat windowInsetsCompat) {
        int iM = windowInsetsCompat.m();
        if (this.B != iM) {
            this.B = iM;
            S();
        }
        NavigationMenuView navigationMenuView = this.f81215a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.j());
        ViewCompat.g(this.f81216b, windowInsetsCompat);
    }

    public MenuItemImpl m() {
        return this.f81220g.k();
    }

    public int n() {
        return this.f81235v;
    }

    public int o() {
        return this.f81234u;
    }

    public int p() {
        return this.f81216b.getChildCount();
    }

    public Drawable q() {
        return this.f81228o;
    }

    public int r() {
        return this.f81230q;
    }

    public int s() {
        return this.f81232s;
    }

    public int t() {
        return this.A;
    }

    public ColorStateList u() {
        return this.f81226m;
    }

    public ColorStateList v() {
        return this.f81227n;
    }

    public int w() {
        return this.f81231r;
    }

    public int x() {
        return this.f81237x;
    }

    public int y() {
        return this.f81236w;
    }
}

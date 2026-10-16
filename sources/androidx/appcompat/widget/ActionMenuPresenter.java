package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    ActionButtonSubmenu A;
    OpenOverflowRunnable B;
    private ActionMenuPopupCallback C;
    final PopupPresenterCallback D;
    int E;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    OverflowMenuButton f1618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f1619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1620n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1621o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1622p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1623q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1624r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1625s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1626t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1627u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1629w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1630x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final SparseBooleanArray f1631y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    OverflowPopup f1632z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.f655m);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f1618l;
                f(view2 == null ? (View) ((BaseMenuPresenter) ActionMenuPresenter.this).f1370j : view2);
            }
            j(ActionMenuPresenter.this.D);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.A = null;
            actionMenuPresenter.E = 0;
            super.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu a() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.A;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.c();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OpenOverflowRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private OverflowPopup f1635a;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f1635a = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).f1364c != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).f1364c.d();
            }
            View view = (View) ((BaseMenuPresenter) ActionMenuPresenter.this).f1370j;
            if (view != null && view.getWindowToken() != null && this.f1635a.m()) {
                ActionMenuPresenter.this.f1632z = this.f1635a;
            }
            ActionMenuPresenter.this.B = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.f653l);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public ShowableListMenu b() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.f1632z;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.c();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean c() {
                    ActionMenuPresenter.this.N();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean d() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.B != null) {
                        return false;
                    }
                    actionMenuPresenter.E();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i3, int i4, int i5, int i6) {
            boolean frame = super.setFrame(i3, i4, i5, i6);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z2) {
            super(context, menuBuilder, view, z2, R.attr.f655m);
            h(8388613);
            j(ActionMenuPresenter.this.D);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void e() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).f1364c != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).f1364c.close();
            }
            ActionMenuPresenter.this.f1632z = null;
            super.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(MenuBuilder menuBuilder, boolean z2) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.F().e(false);
            }
            MenuPresenter.Callback callbackP = ActionMenuPresenter.this.p();
            if (callbackP != null) {
                callbackP.a(menuBuilder, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(MenuBuilder menuBuilder) {
            if (menuBuilder == ((BaseMenuPresenter) ActionMenuPresenter.this).f1364c) {
                return false;
            }
            ActionMenuPresenter.this.E = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callbackP = ActionMenuPresenter.this.p();
            if (callbackP != null) {
                return callbackP.b(menuBuilder);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1642a;

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f1642a);
        }

        SavedState(Parcel parcel) {
            this.f1642a = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.f761c, R.layout.f760b);
        this.f1631y = new SparseBooleanArray();
        this.D = new PopupPresenterCallback();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1370j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        OverflowMenuButton overflowMenuButton = this.f1618l;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f1620n) {
            return this.f1619m;
        }
        return null;
    }

    public boolean E() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.B;
        if (openOverflowRunnable != null && (obj = this.f1370j) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.B = null;
            return true;
        }
        OverflowPopup overflowPopup = this.f1632z;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.b();
        return true;
    }

    public boolean F() {
        ActionButtonSubmenu actionButtonSubmenu = this.A;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.b();
        return true;
    }

    public boolean G() {
        return this.B != null || H();
    }

    public boolean H() {
        OverflowPopup overflowPopup = this.f1632z;
        return overflowPopup != null && overflowPopup.d();
    }

    public void I(Configuration configuration) {
        if (!this.f1626t) {
            this.f1625s = ActionBarPolicy.b(this.f1363b).d();
        }
        MenuBuilder menuBuilder = this.f1364c;
        if (menuBuilder != null) {
            menuBuilder.N(true);
        }
    }

    public void J(boolean z2) {
        this.f1629w = z2;
    }

    public void K(ActionMenuView actionMenuView) {
        this.f1370j = actionMenuView;
        actionMenuView.a(this.f1364c);
    }

    public void L(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f1618l;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.f1620n = true;
            this.f1619m = drawable;
        }
    }

    public void M(boolean z2) {
        this.f1621o = z2;
        this.f1622p = true;
    }

    public boolean N() {
        MenuBuilder menuBuilder;
        if (!this.f1621o || H() || (menuBuilder = this.f1364c) == null || this.f1370j == null || this.B != null || menuBuilder.B().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.f1363b, this.f1364c, this.f1618l, true));
        this.B = openOverflowRunnable;
        ((View) this.f1370j).post(openOverflowRunnable);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
        B();
        super.a(menuBuilder, z2);
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void b(boolean z2) {
        if (z2) {
            super.f(null);
            return;
        }
        MenuBuilder menuBuilder = this.f1364c;
        if (menuBuilder != null) {
            menuBuilder.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(Parcelable parcelable) {
        int i3;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i3 = ((SavedState) parcelable).f1642a) > 0 && (menuItemFindItem = this.f1364c.findItem(i3)) != null) {
            f((SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        boolean z2 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.j0() != this.f1364c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.j0();
        }
        View viewC = C(subMenuBuilder2.getItem());
        if (viewC == null) {
            return false;
        }
        this.E = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i3++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.f1363b, subMenuBuilder, viewC);
        this.A = actionButtonSubmenu;
        actionButtonSubmenu.g(z2);
        this.A.k();
        super.f(subMenuBuilder);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f1642a = this.E;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        super.h(z2);
        ((View) this.f1370j).requestLayout();
        MenuBuilder menuBuilder = this.f1364c;
        boolean z3 = false;
        if (menuBuilder != null) {
            ArrayList arrayListU = menuBuilder.u();
            int size = arrayListU.size();
            for (int i3 = 0; i3 < size; i3++) {
                ActionProvider actionProviderA = ((MenuItemImpl) arrayListU.get(i3)).a();
                if (actionProviderA != null) {
                    actionProviderA.i(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f1364c;
        ArrayList arrayListB = menuBuilder2 != null ? menuBuilder2.B() : null;
        if (this.f1621o && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z3 = !((MenuItemImpl) arrayListB.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f1618l == null) {
                this.f1618l = new OverflowMenuButton(this.f1362a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1618l.getParent();
            if (viewGroup != this.f1370j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1618l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1370j;
                actionMenuView.addView(this.f1618l, actionMenuView.F());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f1618l;
            if (overflowMenuButton != null) {
                Object parent = overflowMenuButton.getParent();
                Object obj = this.f1370j;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1618l);
                }
            }
        }
        ((ActionMenuView) this.f1370j).setOverflowReserved(this.f1621o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.MenuItemImpl] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean i() {
        ArrayList arrayListG;
        int size;
        int i3;
        int iL;
        ?? r02;
        int i4;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f1364c;
        View view = null;
        ?? r3 = 0;
        if (menuBuilder != null) {
            arrayListG = menuBuilder.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i5 = actionMenuPresenter.f1625s;
        int i6 = actionMenuPresenter.f1624r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1370j;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayListG.get(i9);
            if (menuItemImpl.o()) {
                i7++;
            } else if (menuItemImpl.n()) {
                i8++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.f1629w && menuItemImpl.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (actionMenuPresenter.f1621o && (z2 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1631y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1627u) {
            int i11 = actionMenuPresenter.f1630x;
            iL = i6 / i11;
            i3 = i11 + ((i6 % i11) / iL);
        } else {
            i3 = 0;
            iL = 0;
        }
        int i12 = 0;
        int i13 = 0;
        ?? r03 = actionMenuPresenter;
        while (i12 < size) {
            ?? r15 = (MenuItemImpl) arrayListG.get(i12);
            if (r15.o()) {
                View viewQ = r03.q(r15, view, viewGroup);
                if (r03.f1627u) {
                    iL -= ActionMenuView.L(viewQ, i3, iL, iMakeMeasureSpec, r3);
                } else {
                    viewQ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewQ.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.u(true);
                r02 = r3;
                i4 = size;
            } else if (r15.n()) {
                int groupId2 = r15.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i6 > 0 && (!r03.f1627u || iL > 0);
                boolean z5 = z4;
                i4 = size;
                if (z4) {
                    View viewQ2 = r03.q(r15, null, viewGroup);
                    if (r03.f1627u) {
                        int iL2 = ActionMenuView.L(viewQ2, i3, iL, iMakeMeasureSpec, 0);
                        iL -= iL2;
                        if (iL2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewQ2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewQ2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = z6 & (!r03.f1627u ? i6 + i13 <= 0 : i6 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        MenuItemImpl menuItemImpl2 = (MenuItemImpl) arrayListG.get(i14);
                        if (menuItemImpl2.getGroupId() == groupId2) {
                            if (menuItemImpl2.l()) {
                                i10++;
                            }
                            menuItemImpl2.u(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                r15.u(z4);
                r02 = 0;
            } else {
                r02 = r3;
                i4 = size;
                r15.u(r02);
            }
            i12++;
            r3 = r02;
            size = i4;
            view = null;
            r03 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void k(Context context, MenuBuilder menuBuilder) {
        super.k(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicyB = ActionBarPolicy.b(context);
        if (!this.f1622p) {
            this.f1621o = actionBarPolicyB.h();
        }
        if (!this.f1628v) {
            this.f1623q = actionBarPolicyB.c();
        }
        if (!this.f1626t) {
            this.f1625s = actionBarPolicyB.d();
        }
        int measuredWidth = this.f1623q;
        if (this.f1621o) {
            if (this.f1618l == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f1362a);
                this.f1618l = overflowMenuButton;
                if (this.f1620n) {
                    overflowMenuButton.setImageDrawable(this.f1619m);
                    this.f1619m = null;
                    this.f1620n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1618l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1618l.getMeasuredWidth();
        } else {
            this.f1618l = null;
        }
        this.f1624r = measuredWidth;
        this.f1630x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void m(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.c(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1370j);
        if (this.C == null) {
            this.C = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean o(ViewGroup viewGroup, int i3) {
        if (viewGroup.getChildAt(i3) == this.f1618l) {
            return false;
        }
        return super.o(viewGroup, i3);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View q(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.j()) {
            actionView = super.q(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public MenuView r(ViewGroup viewGroup) {
        MenuView menuView = this.f1370j;
        MenuView menuViewR = super.r(viewGroup);
        if (menuView != menuViewR) {
            ((ActionMenuView) menuViewR).setPresenter(this);
        }
        return menuViewR;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean t(int i3, MenuItemImpl menuItemImpl) {
        return menuItemImpl.l();
    }
}

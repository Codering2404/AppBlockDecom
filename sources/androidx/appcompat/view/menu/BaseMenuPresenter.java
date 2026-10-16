package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f1362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f1363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected MenuBuilder f1364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f1365d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected LayoutInflater f1366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MenuPresenter.Callback f1367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected MenuView f1370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1371k;

    public BaseMenuPresenter(Context context, int i3, int i4) {
        this.f1362a = context;
        this.f1365d = LayoutInflater.from(context);
        this.f1368h = i3;
        this.f1369i = i4;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f1367g;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void d(MenuPresenter.Callback callback) {
        this.f1367g = callback;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.Callback callback = this.f1367g;
        MenuBuilder menuBuilder = subMenuBuilder;
        if (callback == null) {
            return false;
        }
        if (subMenuBuilder == null) {
            menuBuilder = this.f1364c;
        }
        return callback.b(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f1371k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) this.f1370j;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.f1364c;
        int i3 = 0;
        if (menuBuilder != null) {
            menuBuilder.t();
            ArrayList arrayListG = this.f1364c.G();
            int size = arrayListG.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) arrayListG.get(i5);
                if (t(i4, menuItemImpl)) {
                    View childAt = viewGroup.getChildAt(i4);
                    MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                    View viewQ = q(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        viewQ.setPressed(false);
                        viewQ.jumpDrawablesToCurrentState();
                    }
                    if (viewQ != childAt) {
                        l(viewQ, i4);
                    }
                    i4++;
                }
            }
            i3 = i4;
        }
        while (i3 < viewGroup.getChildCount()) {
            if (!o(viewGroup, i3)) {
                i3++;
            }
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
        this.f1363b = context;
        this.f1366f = LayoutInflater.from(context);
        this.f1364c = menuBuilder;
    }

    protected void l(View view, int i3) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1370j).addView(view, i3);
    }

    public abstract void m(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public MenuView.ItemView n(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.f1365d.inflate(this.f1369i, viewGroup, false);
    }

    protected boolean o(ViewGroup viewGroup, int i3) {
        viewGroup.removeViewAt(i3);
        return true;
    }

    public MenuPresenter.Callback p() {
        return this.f1367g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View q(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemViewN = view instanceof MenuView.ItemView ? (MenuView.ItemView) view : n(viewGroup);
        m(menuItemImpl, itemViewN);
        return (View) itemViewN;
    }

    public MenuView r(ViewGroup viewGroup) {
        if (this.f1370j == null) {
            MenuView menuView = (MenuView) this.f1365d.inflate(this.f1368h, viewGroup, false);
            this.f1370j = menuView;
            menuView.a(this.f1364c);
            h(true);
        }
        return this.f1370j;
    }

    public void s(int i3) {
        this.f1371k = i3;
    }

    public boolean t(int i3, MenuItemImpl menuItemImpl) {
        return true;
    }
}

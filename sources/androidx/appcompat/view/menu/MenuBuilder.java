package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f1448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Callback f1451e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f1459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    CharSequence f1460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable f1461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f1462p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MenuItemImpl f1470x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1472z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1458l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1463q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1464r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1465s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1466t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1467u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList f1468v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList f1469w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1471y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f1452f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f1453g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1454h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f1455i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f1456j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1457k = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback {
        boolean a(MenuBuilder menuBuilder, MenuItem menuItem);

        void b(MenuBuilder menuBuilder);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ItemInvoker {
        boolean b(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f1447a = context;
        this.f1448b = context.getResources();
        g0(true);
    }

    private static int D(int i3) {
        int i4 = ((-65536) & i3) >> 16;
        if (i4 >= 0) {
            int[] iArr = A;
            if (i4 < iArr.length) {
                return (i3 & 65535) | (iArr[i4] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void Q(int i3, boolean z2) {
        if (i3 < 0 || i3 >= this.f1452f.size()) {
            return;
        }
        this.f1452f.remove(i3);
        if (z2) {
            N(true);
        }
    }

    private void b0(int i3, CharSequence charSequence, int i4, Drawable drawable, View view) {
        Resources resourcesE = E();
        if (view != null) {
            this.f1462p = view;
            this.f1460n = null;
            this.f1461o = null;
        } else {
            if (i3 > 0) {
                this.f1460n = resourcesE.getText(i3);
            } else if (charSequence != null) {
                this.f1460n = charSequence;
            }
            if (i4 > 0) {
                this.f1461o = ContextCompat.getDrawable(w(), i4);
            } else if (drawable != null) {
                this.f1461o = drawable;
            }
            this.f1462p = null;
        }
        N(false);
    }

    private MenuItemImpl g(int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        return new MenuItemImpl(this, i3, i4, i5, i6, charSequence, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f1448b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f1447a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f1447a
            boolean r3 = androidx.core.view.ViewConfigurationCompat.j(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1450d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.g0(boolean):void");
    }

    private void i(boolean z2) {
        if (this.f1469w.isEmpty()) {
            return;
        }
        i0();
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                this.f1469w.remove(weakReference);
            } else {
                menuPresenter.h(z2);
            }
        }
        h0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f1469w.isEmpty()) {
            return;
        }
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                this.f1469w.remove(weakReference);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    menuPresenter.e(parcelable);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable parcelableG;
        if (this.f1469w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                this.f1469w.remove(weakReference);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelableG = menuPresenter.g()) != null) {
                    sparseArray.put(id, parcelableG);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.f1469w.isEmpty()) {
            return false;
        }
        boolean zF = menuPresenter != null ? menuPresenter.f(subMenuBuilder) : false;
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null) {
                this.f1469w.remove(weakReference);
            } else if (!zF) {
                zF = menuPresenter2.f(subMenuBuilder);
            }
        }
        return zF;
    }

    private static int p(ArrayList arrayList, int i3) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((MenuItemImpl) arrayList.get(size)).f() <= i3) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f1462p;
    }

    public ArrayList B() {
        t();
        return this.f1456j;
    }

    boolean C() {
        return this.f1466t;
    }

    Resources E() {
        return this.f1448b;
    }

    public ArrayList G() {
        if (!this.f1454h) {
            return this.f1453g;
        }
        this.f1453g.clear();
        int size = this.f1452f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i3);
            if (menuItemImpl.isVisible()) {
                this.f1453g.add(menuItemImpl);
            }
        }
        this.f1454h = false;
        this.f1457k = true;
        return this.f1453g;
    }

    public boolean H() {
        return !this.f1463q;
    }

    public boolean I() {
        return this.f1471y;
    }

    boolean J() {
        return this.f1449c;
    }

    public boolean K() {
        return this.f1450d;
    }

    void L(MenuItemImpl menuItemImpl) {
        this.f1457k = true;
        N(true);
    }

    void M(MenuItemImpl menuItemImpl) {
        this.f1454h = true;
        N(true);
    }

    public void N(boolean z2) {
        if (this.f1463q) {
            this.f1464r = true;
            if (z2) {
                this.f1465s = true;
                return;
            }
            return;
        }
        if (z2) {
            this.f1454h = true;
            this.f1457k = true;
        }
        i(z2);
    }

    public boolean O(MenuItem menuItem, int i3) {
        return P(menuItem, null, i3);
    }

    public boolean P(MenuItem menuItem, MenuPresenter menuPresenter, int i3) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean zK = menuItemImpl.k();
        ActionProvider actionProviderA = menuItemImpl.a();
        boolean z2 = actionProviderA != null && actionProviderA.a();
        if (menuItemImpl.j()) {
            boolean zExpandActionView = menuItemImpl.expandActionView() | zK;
            if (zExpandActionView) {
                e(true);
            }
            return zExpandActionView;
        }
        if (!menuItemImpl.hasSubMenu() && !z2) {
            if ((i3 & 1) == 0) {
                e(true);
            }
            return zK;
        }
        if ((i3 & 4) == 0) {
            e(false);
        }
        if (!menuItemImpl.hasSubMenu()) {
            menuItemImpl.x(new SubMenuBuilder(w(), this, menuItemImpl));
        }
        SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
        if (z2) {
            actionProviderA.f(subMenuBuilder);
        }
        boolean zL = l(subMenuBuilder, menuPresenter) | zK;
        if (!zL) {
            e(true);
        }
        return zL;
    }

    public void R(MenuPresenter menuPresenter) {
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f1469w.remove(weakReference);
            }
        }
    }

    public void S(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).S(bundle);
            }
        }
        int i4 = bundle.getInt("android:menu:expandedactionview");
        if (i4 <= 0 || (menuItemFindItem = findItem(i4)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void T(Bundle bundle) {
        j(bundle);
    }

    public void U(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).U(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(Callback callback) {
        this.f1451e = callback;
    }

    public MenuBuilder X(int i3) {
        this.f1458l = i3;
        return this;
    }

    void Y(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1452f.size();
        i0();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i3);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m() && menuItemImpl.isCheckable()) {
                menuItemImpl.s(menuItemImpl == menuItem);
            }
        }
        h0();
    }

    protected MenuBuilder Z(int i3) {
        b0(0, null, i3, null, null);
        return this;
    }

    protected MenuItem a(int i3, int i4, int i5, CharSequence charSequence) {
        int iD = D(i5);
        MenuItemImpl menuItemImplG = g(i3, i4, i5, iD, charSequence, this.f1458l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1459m;
        if (contextMenuInfo != null) {
            menuItemImplG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f1452f;
        arrayList.add(p(arrayList, iD), menuItemImplG);
        N(true);
        return menuItemImplG;
    }

    protected MenuBuilder a0(Drawable drawable) {
        b0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        int i7;
        PackageManager packageManager = this.f1447a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i6 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i8 = 0; i8 < size; i8++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i9 < 0 ? intent : intentArr[i9]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i3, i4, i5, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(MenuPresenter menuPresenter) {
        c(menuPresenter, this.f1447a);
    }

    public void c(MenuPresenter menuPresenter, Context context) {
        this.f1469w.add(new WeakReference(menuPresenter));
        menuPresenter.k(context, this);
        this.f1457k = true;
    }

    protected MenuBuilder c0(int i3) {
        b0(i3, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.f1470x;
        if (menuItemImpl != null) {
            f(menuItemImpl);
        }
        this.f1452f.clear();
        N(true);
    }

    public void clearHeader() {
        this.f1461o = null;
        this.f1460n = null;
        this.f1462p = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        Callback callback = this.f1451e;
        if (callback != null) {
            callback.b(this);
        }
    }

    protected MenuBuilder d0(CharSequence charSequence) {
        b0(0, charSequence, 0, null, null);
        return this;
    }

    public final void e(boolean z2) {
        if (this.f1467u) {
            return;
        }
        this.f1467u = true;
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                this.f1469w.remove(weakReference);
            } else {
                menuPresenter.a(this, z2);
            }
        }
        this.f1467u = false;
    }

    protected MenuBuilder e0(View view) {
        b0(0, null, 0, null, view);
        return this;
    }

    public boolean f(MenuItemImpl menuItemImpl) {
        boolean zJ = false;
        if (!this.f1469w.isEmpty() && this.f1470x == menuItemImpl) {
            i0();
            for (WeakReference weakReference : this.f1469w) {
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter != null) {
                    zJ = menuPresenter.j(this, menuItemImpl);
                    if (zJ) {
                        break;
                    }
                } else {
                    this.f1469w.remove(weakReference);
                }
            }
            h0();
            if (zJ) {
                this.f1470x = null;
            }
        }
        return zJ;
    }

    public void f0(boolean z2) {
        this.f1472z = z2;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i4);
            if (menuItemImpl.getItemId() == i3) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (menuItemFindItem = menuItemImpl.getSubMenu().findItem(i3)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return (MenuItem) this.f1452f.get(i3);
    }

    boolean h(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.f1451e;
        return callback != null && callback.a(menuBuilder, menuItem);
    }

    public void h0() {
        this.f1463q = false;
        if (this.f1464r) {
            this.f1464r = false;
            N(this.f1465s);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1472z) {
            return true;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((MenuItemImpl) this.f1452f.get(i3)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i0() {
        if (this.f1463q) {
            return;
        }
        this.f1463q = true;
        this.f1464r = false;
        this.f1465s = false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return r(i3, keyEvent) != null;
    }

    public boolean m(MenuItemImpl menuItemImpl) {
        boolean zC = false;
        if (this.f1469w.isEmpty()) {
            return false;
        }
        i0();
        for (WeakReference weakReference : this.f1469w) {
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter != null) {
                zC = menuPresenter.c(this, menuItemImpl);
                if (zC) {
                    break;
                }
            } else {
                this.f1469w.remove(weakReference);
            }
        }
        h0();
        if (zC) {
            this.f1470x = menuItemImpl;
        }
        return zC;
    }

    public int n(int i3) {
        return o(i3, 0);
    }

    public int o(int i3, int i4) {
        int size = size();
        if (i4 < 0) {
            i4 = 0;
        }
        while (i4 < size) {
            if (((MenuItemImpl) this.f1452f.get(i4)).getGroupId() == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i4) {
        return O(findItem(i3), i4);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i4) {
        MenuItemImpl menuItemImplR = r(i3, keyEvent);
        boolean zO = menuItemImplR != null ? O(menuItemImplR, i4) : false;
        if ((i4 & 2) != 0) {
            e(true);
        }
        return zO;
    }

    public int q(int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((MenuItemImpl) this.f1452f.get(i4)).getItemId() == i3) {
                return i4;
            }
        }
        return -1;
    }

    MenuItemImpl r(int i3, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1468v;
        arrayList.clear();
        s(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (MenuItemImpl) arrayList.get(0);
        }
        boolean zJ = J();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i4);
            char alphabeticShortcut = zJ ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zJ && alphabeticShortcut == '\b' && i3 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        int iN = n(i3);
        if (iN >= 0) {
            int size = this.f1452f.size() - iN;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size || ((MenuItemImpl) this.f1452f.get(iN)).getGroupId() != i3) {
                    break;
                }
                Q(iN, false);
                i4 = i5;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        Q(q(i3), true);
    }

    void s(List list, int i3, KeyEvent keyEvent) {
        boolean zJ = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i3 == 67) {
            int size = this.f1452f.size();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i4);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).s(list, i3, keyEvent);
                }
                char alphabeticShortcut = zJ ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((modifiers & 69647) == ((zJ ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zJ && alphabeticShortcut == '\b' && i3 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z2, boolean z3) {
        int size = this.f1452f.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i4);
            if (menuItemImpl.getGroupId() == i3) {
                menuItemImpl.t(z3);
                menuItemImpl.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f1471y = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z2) {
        int size = this.f1452f.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i4);
            if (menuItemImpl.getGroupId() == i3) {
                menuItemImpl.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z2) {
        int size = this.f1452f.size();
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f1452f.get(i4);
            if (menuItemImpl.getGroupId() == i3 && menuItemImpl.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f1449c = z2;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1452f.size();
    }

    public void t() {
        ArrayList arrayListG = G();
        if (this.f1457k) {
            boolean zI = false;
            for (WeakReference weakReference : this.f1469w) {
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f1469w.remove(weakReference);
                } else {
                    zI |= menuPresenter.i();
                }
            }
            if (zI) {
                this.f1455i.clear();
                this.f1456j.clear();
                int size = arrayListG.size();
                for (int i3 = 0; i3 < size; i3++) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) arrayListG.get(i3);
                    if (menuItemImpl.l()) {
                        this.f1455i.add(menuItemImpl);
                    } else {
                        this.f1456j.add(menuItemImpl);
                    }
                }
            } else {
                this.f1455i.clear();
                this.f1456j.clear();
                this.f1456j.addAll(G());
            }
            this.f1457k = false;
        }
    }

    public ArrayList u() {
        t();
        return this.f1455i;
    }

    protected String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f1447a;
    }

    public MenuItemImpl x() {
        return this.f1470x;
    }

    public Drawable y() {
        return this.f1461o;
    }

    public CharSequence z() {
        return this.f1460n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return a(0, 0, 0, this.f1448b.getString(i3));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.f1448b.getString(i3));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, CharSequence charSequence) {
        return a(i3, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i3, i4, i5, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f1447a, this, menuItemImpl);
        menuItemImpl.x(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, int i6) {
        return a(i3, i4, i5, this.f1448b.getString(i6));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, int i6) {
        return addSubMenu(i3, i4, i5, this.f1448b.getString(i6));
    }

    public MenuBuilder F() {
        return this;
    }
}

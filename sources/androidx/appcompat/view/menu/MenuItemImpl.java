package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {
    private View A;
    private ActionProvider B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f1481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f1482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Intent f1483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char f1484h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private char f1486j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f1488l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    MenuBuilder f1490n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private SubMenuBuilder f1491o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f1492p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1493q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f1494r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f1495s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1502z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1485i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1487k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1489m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorStateList f1496t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f1497u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1498v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1499w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1500x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1501y = 16;
    private boolean D = false;

    MenuItemImpl(MenuBuilder menuBuilder, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        this.f1490n = menuBuilder;
        this.f1477a = i4;
        this.f1478b = i3;
        this.f1479c = i5;
        this.f1480d = i6;
        this.f1481e = charSequence;
        this.f1502z = i7;
    }

    private static void d(StringBuilder sb, int i3, int i4, String str) {
        if ((i3 & i4) == i4) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f1500x && (this.f1498v || this.f1499w)) {
            drawable = DrawableCompat.r(drawable).mutate();
            if (this.f1498v) {
                DrawableCompat.o(drawable, this.f1496t);
            }
            if (this.f1499w) {
                DrawableCompat.p(drawable, this.f1497u);
            }
            this.f1500x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f1490n.K() && g() != 0;
    }

    public boolean B() {
        return (this.f1502z & 4) == 4;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider a() {
        return this.B;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem b(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.B;
        if (actionProvider2 != null) {
            actionProvider2.h();
        }
        this.A = null;
        this.B = actionProvider;
        this.f1490n.N(true);
        ActionProvider actionProvider3 = this.B;
        if (actionProvider3 != null) {
            actionProvider3.j(new ActionProvider.VisibilityListener() { // from class: androidx.appcompat.view.menu.MenuItemImpl.1
                @Override // androidx.core.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean z2) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.f1490n.M(menuItemImpl);
                }
            });
        }
        return this;
    }

    public void c() {
        this.f1490n.L(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1502z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1490n.f(this);
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1490n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f1480d;
    }

    char g() {
        return this.f1490n.J() ? this.f1486j : this.f1484h;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider == null) {
            return null;
        }
        View viewD = actionProvider.d(this);
        this.A = viewD;
        return viewD;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1487k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1486j;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1494r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1478b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1488l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f1489m == 0) {
            return null;
        }
        Drawable drawableB = AppCompatResources.b(this.f1490n.w(), this.f1489m);
        this.f1489m = 0;
        this.f1488l = drawableB;
        return e(drawableB);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1496t;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1497u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1483g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1477a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1485i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1484h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1479c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1491o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1481e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1482f;
        return charSequence != null ? charSequence : this.f1481e;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1495s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f1490n.w().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1490n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.f795o));
        }
        int i3 = this.f1490n.J() ? this.f1487k : this.f1485i;
        d(sb, i3, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, resources.getString(R.string.f791k));
        d(sb, i3, 4096, resources.getString(R.string.f787g));
        d(sb, i3, 2, resources.getString(R.string.f786f));
        d(sb, i3, 1, resources.getString(R.string.f792l));
        d(sb, i3, 4, resources.getString(R.string.f794n));
        d(sb, i3, 8, resources.getString(R.string.f790j));
        if (cG == '\b') {
            sb.append(resources.getString(R.string.f788h));
        } else if (cG == '\n') {
            sb.append(resources.getString(R.string.f789i));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(R.string.f793m));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1491o != null;
    }

    CharSequence i(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1501y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1501y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1501y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.B;
        return (actionProvider == null || !actionProvider.g()) ? (this.f1501y & 8) == 0 : (this.f1501y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        ActionProvider actionProvider;
        if ((this.f1502z & 8) != 0) {
            if (this.A == null && (actionProvider = this.B) != null) {
                this.A = actionProvider.d(this);
            }
            if (this.A != null) {
                return true;
            }
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1493q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f1490n;
        if (menuBuilder.h(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.f1492p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1483g != null) {
            try {
                this.f1490n.w().startActivity(this.f1483g);
                return true;
            } catch (ActivityNotFoundException e3) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e3);
            }
        }
        ActionProvider actionProvider = this.B;
        return actionProvider != null && actionProvider.e();
    }

    public boolean l() {
        return (this.f1501y & 32) == 32;
    }

    public boolean m() {
        return (this.f1501y & 4) != 0;
    }

    public boolean n() {
        return (this.f1502z & 1) == 1;
    }

    public boolean o() {
        return (this.f1502z & 2) == 2;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int i3) {
        Context contextW = this.f1490n.w();
        setActionView(LayoutInflater.from(contextW).inflate(i3, (ViewGroup) new LinearLayout(contextW), false));
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        int i3;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i3 = this.f1477a) > 0) {
            view.setId(i3);
        }
        this.f1490n.L(this);
        return this;
    }

    public void r(boolean z2) {
        this.D = z2;
        this.f1490n.N(false);
    }

    void s(boolean z2) {
        int i3 = this.f1501y;
        int i4 = (z2 ? 2 : 0) | (i3 & (-3));
        this.f1501y = i4;
        if (i3 != i4) {
            this.f1490n.N(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        if (this.f1486j == c3) {
            return this;
        }
        this.f1486j = Character.toLowerCase(c3);
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        int i3 = this.f1501y;
        int i4 = (z2 ? 1 : 0) | (i3 & (-2));
        this.f1501y = i4;
        if (i3 != i4) {
            this.f1490n.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        if ((this.f1501y & 4) != 0) {
            this.f1490n.Y(this);
            return this;
        }
        s(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f1501y |= 16;
        } else {
            this.f1501y &= -17;
        }
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1489m = 0;
        this.f1488l = drawable;
        this.f1500x = true;
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1496t = colorStateList;
        this.f1498v = true;
        this.f1500x = true;
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1497u = mode;
        this.f1499w = true;
        this.f1500x = true;
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1483g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        if (this.f1484h == c3) {
            return this;
        }
        this.f1484h = c3;
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1493q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f1484h = c3;
        this.f1486j = Character.toLowerCase(c4);
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i3) {
        int i4 = i3 & 3;
        if (i4 != 0 && i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1502z = i3;
        this.f1490n.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1481e = charSequence;
        this.f1490n.N(false);
        SubMenuBuilder subMenuBuilder = this.f1491o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1482f = charSequence;
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        if (y(z2)) {
            this.f1490n.M(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.f1501y = (z2 ? 4 : 0) | (this.f1501y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f1481e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z2) {
        if (z2) {
            this.f1501y |= 32;
        } else {
            this.f1501y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    public void x(SubMenuBuilder subMenuBuilder) {
        this.f1491o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    boolean y(boolean z2) {
        int i3 = this.f1501y;
        int i4 = (z2 ? 0 : 8) | (i3 & (-9));
        this.f1501y = i4;
        return i3 != i4;
    }

    public boolean z() {
        return this.f1490n.C();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1494r = charSequence;
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1495s = charSequence;
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        if (this.f1486j == c3 && this.f1487k == i3) {
            return this;
        }
        this.f1486j = Character.toLowerCase(c3);
        this.f1487k = KeyEvent.normalizeMetaState(i3);
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        if (this.f1484h == c3 && this.f1485i == i3) {
            return this;
        }
        this.f1484h = c3;
        this.f1485i = KeyEvent.normalizeMetaState(i3);
        this.f1490n.N(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f1484h = c3;
        this.f1485i = KeyEvent.normalizeMetaState(i3);
        this.f1486j = Character.toLowerCase(c4);
        this.f1487k = KeyEvent.normalizeMetaState(i4);
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f1488l = null;
        this.f1489m = i3;
        this.f1500x = true;
        this.f1490n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        return setTitle(this.f1490n.w().getString(i3));
    }
}

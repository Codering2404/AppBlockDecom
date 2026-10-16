package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f1333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f1334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f1335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f1336g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private char f1338i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f1340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f1341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CharSequence f1343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f1344o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1337h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1339j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f1345p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f1346q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1347r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1348s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1349t = 16;

    public ActionMenuItem(Context context, int i3, int i4, int i5, int i6, CharSequence charSequence) {
        this.f1341l = context;
        this.f1330a = i4;
        this.f1331b = i3;
        this.f1332c = i6;
        this.f1333d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f1340k;
        if (drawable != null) {
            if (this.f1347r || this.f1348s) {
                Drawable drawableR = DrawableCompat.r(drawable);
                this.f1340k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f1340k = drawableMutate;
                if (this.f1347r) {
                    DrawableCompat.o(drawableMutate, this.f1345p);
                }
                if (this.f1348s) {
                    DrawableCompat.p(this.f1340k, this.f1346q);
                }
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider a() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem b(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1339j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1338i;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1343n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1331b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1340k;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1345p;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1346q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1335f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1330a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1337h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1336g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1332c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1333d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1334e;
        return charSequence != null ? charSequence : this.f1333d;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1344o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1349t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1349t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1349t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1349t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.f1338i = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f1349t = (z2 ? 1 : 0) | (this.f1349t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f1349t = (z2 ? 2 : 0) | (this.f1349t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f1349t = (z2 ? 16 : 0) | (this.f1349t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1340k = drawable;
        c();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1345p = colorStateList;
        this.f1347r = true;
        c();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1346q = mode;
        this.f1348s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1335f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.f1336g = c3;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1342m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f1336g = c3;
        this.f1338i = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1333d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1334e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        this.f1349t = (this.f1349t & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f1338i = Character.toLowerCase(c3);
        this.f1339j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1343n = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.f1336g = c3;
        this.f1337h = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f1333d = this.f1341l.getResources().getString(i3);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1344o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f1340k = ContextCompat.getDrawable(this.f1341l, i3);
        c();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f1336g = c3;
        this.f1337h = KeyEvent.normalizeMetaState(i3);
        this.f1338i = Character.toLowerCase(c4);
        this.f1339j = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i3) {
    }
}

package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Class[] f1285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Class[] f1286f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object[] f1287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f1288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f1289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f1290d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Class[] f1291c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f1292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f1293b;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f1292a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1293b = cls.getMethod(str, f1291c);
            } catch (Exception e3) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e3);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1293b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1293b.invoke(this.f1292a, menuItem)).booleanValue();
                }
                this.f1293b.invoke(this.f1292a, menuItem);
                return true;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MenuState {
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Menu f1294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1298e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1299f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1300g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1301h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1302i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f1303j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f1304k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CharSequence f1305l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f1306m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private char f1307n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f1308o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private char f1309p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f1310q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f1311r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f1312s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f1313t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f1314u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f1315v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f1316w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private String f1317x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f1318y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private String f1319z;

        public MenuState(Menu menu) {
            this.f1294a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f1289c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e3) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e3);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.f1312s).setVisible(this.f1313t).setEnabled(this.f1314u).setCheckable(this.f1311r >= 1).setTitleCondensed(this.f1305l).setIcon(this.f1306m);
            int i3 = this.f1315v;
            if (i3 >= 0) {
                menuItem.setShowAsAction(i3);
            }
            if (this.f1319z != null) {
                if (SupportMenuInflater.this.f1289c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.b(), this.f1319z));
            }
            if (this.f1311r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).t(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).h(true);
                }
            }
            String str = this.f1317x;
            if (str != null) {
                menuItem.setActionView((View) e(str, SupportMenuInflater.f1285e, SupportMenuInflater.this.f1287a));
                z2 = true;
            }
            int i4 = this.f1316w;
            if (i4 > 0) {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i4);
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.a(menuItem, actionProvider);
            }
            MenuItemCompat.c(menuItem, this.B);
            MenuItemCompat.g(menuItem, this.C);
            MenuItemCompat.b(menuItem, this.f1307n, this.f1308o);
            MenuItemCompat.f(menuItem, this.f1309p, this.f1310q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f1301h = true;
            i(this.f1294a.add(this.f1295b, this.f1302i, this.f1303j, this.f1304k));
        }

        public SubMenu b() {
            this.f1301h = true;
            SubMenu subMenuAddSubMenu = this.f1294a.addSubMenu(this.f1295b, this.f1302i, this.f1303j, this.f1304k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f1301h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = SupportMenuInflater.this.f1289c.obtainStyledAttributes(attributeSet, R.styleable.f896y1);
            this.f1295b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.A1, 0);
            this.f1296c = typedArrayObtainStyledAttributes.getInt(R.styleable.C1, 0);
            this.f1297d = typedArrayObtainStyledAttributes.getInt(R.styleable.D1, 0);
            this.f1298e = typedArrayObtainStyledAttributes.getInt(R.styleable.E1, 0);
            this.f1299f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.B1, true);
            this.f1300g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f899z1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            TintTypedArray tintTypedArrayU = TintTypedArray.u(SupportMenuInflater.this.f1289c, attributeSet, R.styleable.F1);
            this.f1302i = tintTypedArrayU.n(R.styleable.I1, 0);
            this.f1303j = (tintTypedArrayU.k(R.styleable.L1, this.f1296c) & (-65536)) | (tintTypedArrayU.k(R.styleable.M1, this.f1297d) & 65535);
            this.f1304k = tintTypedArrayU.p(R.styleable.N1);
            this.f1305l = tintTypedArrayU.p(R.styleable.O1);
            this.f1306m = tintTypedArrayU.n(R.styleable.G1, 0);
            this.f1307n = c(tintTypedArrayU.o(R.styleable.P1));
            this.f1308o = tintTypedArrayU.k(R.styleable.W1, 4096);
            this.f1309p = c(tintTypedArrayU.o(R.styleable.Q1));
            this.f1310q = tintTypedArrayU.k(R.styleable.f808a2, 4096);
            int i3 = R.styleable.R1;
            if (tintTypedArrayU.s(i3)) {
                this.f1311r = tintTypedArrayU.a(i3, false) ? 1 : 0;
            } else {
                this.f1311r = this.f1298e;
            }
            this.f1312s = tintTypedArrayU.a(R.styleable.J1, false);
            this.f1313t = tintTypedArrayU.a(R.styleable.K1, this.f1299f);
            this.f1314u = tintTypedArrayU.a(R.styleable.H1, this.f1300g);
            this.f1315v = tintTypedArrayU.k(R.styleable.f812b2, -1);
            this.f1319z = tintTypedArrayU.o(R.styleable.S1);
            this.f1316w = tintTypedArrayU.n(R.styleable.T1, 0);
            this.f1317x = tintTypedArrayU.o(R.styleable.V1);
            String strO = tintTypedArrayU.o(R.styleable.U1);
            this.f1318y = strO;
            boolean z2 = strO != null;
            if (z2 && this.f1316w == 0 && this.f1317x == null) {
                this.A = (ActionProvider) e(strO, SupportMenuInflater.f1286f, SupportMenuInflater.this.f1288b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = tintTypedArrayU.p(R.styleable.X1);
            this.C = tintTypedArrayU.p(R.styleable.f816c2);
            int i4 = R.styleable.Z1;
            if (tintTypedArrayU.s(i4)) {
                this.E = DrawableUtils.e(tintTypedArrayU.k(i4, -1), this.E);
            } else {
                this.E = null;
            }
            int i5 = R.styleable.Y1;
            if (tintTypedArrayU.s(i5)) {
                this.D = tintTypedArrayU.c(i5);
            } else {
                this.D = null;
            }
            tintTypedArrayU.x();
            this.f1301h = false;
        }

        public void h() {
            this.f1295b = 0;
            this.f1296c = 0;
            this.f1297d = 0;
            this.f1298e = 0;
            this.f1299f = true;
            this.f1300g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f1285e = clsArr;
        f1286f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f1289c = context;
        Object[] objArr = {context};
        this.f1287a = objArr;
        this.f1288b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        while (!z2) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        z3 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        menuState.h();
                    } else if (name2.equals("item")) {
                        if (!menuState.d()) {
                            ActionProvider actionProvider = menuState.A;
                            if (actionProvider == null || !actionProvider.a()) {
                                menuState.a();
                            } else {
                                menuState.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z2 = true;
                    }
                }
            } else if (!z3) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    menuState.f(attributeSet);
                } else if (name3.equals("item")) {
                    menuState.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, menuState.b());
                } else {
                    str = name3;
                    z3 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f1290d == null) {
            this.f1290d = a(this.f1289c);
        }
        return this.f1290d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i3, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i3, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z2 = false;
        try {
            try {
                layout = this.f1289c.getResources().getLayout(i3);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof MenuBuilder) {
                    MenuBuilder menuBuilder = (MenuBuilder) menu;
                    if (menuBuilder.H()) {
                        menuBuilder.i0();
                        z2 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z2) {
                    ((MenuBuilder) menu).h0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            } catch (XmlPullParserException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            }
        } catch (Throwable th) {
            if (z2) {
                ((MenuBuilder) menu).h0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}

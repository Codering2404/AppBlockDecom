package com.iab.omid.library.applovin.walking;

import android.view.View;
import com.iab.omid.library.applovin.internal.e;
import com.iab.omid.library.applovin.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f92207a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0171a> f92208b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f92209c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f92210d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f92211e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f92212f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f92213g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<View, Boolean> f92214h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f92215i;

    /* JADX INFO: renamed from: com.iab.omid.library.applovin.walking.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class C0171a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f92216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f92217b = new ArrayList<>();

        public C0171a(e eVar, String str) {
            this.f92216a = eVar;
            a(str);
        }

        public e a() {
            return this.f92216a;
        }

        public ArrayList<String> b() {
            return this.f92217b;
        }

        public void a(String str) {
            this.f92217b.add(str);
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f92214h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f92214h.containsKey(view)) {
            return this.f92214h.get(view);
        }
        Map<View, Boolean> map = this.f92214h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f92209c.get(str);
    }

    public C0171a c(View view) {
        C0171a c0171a = this.f92208b.get(view);
        if (c0171a != null) {
            this.f92208b.remove(view);
        }
        return c0171a;
    }

    public String d(View view) {
        if (this.f92207a.size() == 0) {
            return null;
        }
        String str = this.f92207a.get(view);
        if (str != null) {
            this.f92207a.remove(view);
        }
        return str;
    }

    public c e(View view) {
        return this.f92210d.contains(view) ? c.PARENT_VIEW : this.f92215i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public boolean f(View view) {
        if (!this.f92214h.containsKey(view)) {
            return true;
        }
        this.f92214h.put(view, Boolean.TRUE);
        return false;
    }

    private String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strA = h.a(view);
            if (strA != null) {
                return strA;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f92210d.addAll(hashSet);
        return null;
    }

    public String b(String str) {
        return this.f92213g.get(str);
    }

    public HashSet<String> c() {
        return this.f92211e;
    }

    public void d() {
        this.f92215i = true;
    }

    public void e() {
        com.iab.omid.library.applovin.internal.c cVarC = com.iab.omid.library.applovin.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.applovin.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.f92211e.add(adSessionId);
                            this.f92207a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f92212f.add(adSessionId);
                            this.f92209c.put(adSessionId, viewC);
                            this.f92213g.put(adSessionId, strA);
                        }
                    } else {
                        this.f92212f.add(adSessionId);
                        this.f92213g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void a() {
        this.f92207a.clear();
        this.f92208b.clear();
        this.f92209c.clear();
        this.f92210d.clear();
        this.f92211e.clear();
        this.f92212f.clear();
        this.f92213g.clear();
        this.f92215i = false;
    }

    public HashSet<String> b() {
        return this.f92212f;
    }

    private void a(com.iab.omid.library.applovin.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.applovin.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0171a c0171a = this.f92208b.get(view);
        if (c0171a != null) {
            c0171a.a(aVar.getAdSessionId());
        } else {
            this.f92208b.put(view, new C0171a(eVar, aVar.getAdSessionId()));
        }
    }
}

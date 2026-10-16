package com.iab.omid.library.applovin.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.applovin.processor.a;
import com.iab.omid.library.applovin.utils.f;
import com.iab.omid.library.applovin.utils.h;
import com.iab.omid.library.applovin.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TreeWalker implements a.InterfaceC0169a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f92193i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f92194j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f92195k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f92196l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f92197m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f92199b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f92205h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f92198a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f92200c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.applovin.weakreference.a> f92201d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.applovin.walking.a f92203f = new com.iab.omid.library.applovin.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.applovin.processor.b f92202e = new com.iab.omid.library.applovin.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.applovin.walking.b f92204g = new com.iab.omid.library.applovin.walking.b(new com.iab.omid.library.applovin.walking.async.c());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i3, long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i3, long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f92204g.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f92195k != null) {
                TreeWalker.f92195k.post(TreeWalker.f92196l);
                TreeWalker.f92195k.postDelayed(TreeWalker.f92197m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d() {
        a(f.b() - this.f92205h);
    }

    private void e() {
        this.f92199b = 0;
        this.f92201d.clear();
        this.f92200c = false;
        Iterator<com.iab.omid.library.applovin.adsession.a> it = com.iab.omid.library.applovin.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f92200c = true;
                break;
            }
        }
        this.f92205h = f.b();
    }

    public static TreeWalker getInstance() {
        return f92193i;
    }

    private void i() {
        if (f92195k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f92195k = handler;
            handler.post(f92196l);
            f92195k.postDelayed(f92197m, 200L);
        }
    }

    private void k() {
        Handler handler = f92195k;
        if (handler != null) {
            handler.removeCallbacks(f92197m);
            f92195k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f92198a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f92198a.add(treeWalkerTimeLogger);
    }

    void f() {
        TreeWalker treeWalker;
        this.f92203f.e();
        long jB = f.b();
        com.iab.omid.library.applovin.processor.a aVarA = this.f92202e.a();
        if (this.f92203f.b().size() > 0) {
            for (String str : this.f92203f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f92203f.a(str), jSONObjectA);
                com.iab.omid.library.applovin.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f92204g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f92203f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            treeWalker = this;
            treeWalker.a(null, aVarA, jSONObjectA2, com.iab.omid.library.applovin.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.applovin.utils.c.b(jSONObjectA2);
            treeWalker.f92204g.b(jSONObjectA2, treeWalker.f92203f.c(), jB);
            if (treeWalker.f92200c) {
                Iterator<com.iab.omid.library.applovin.adsession.a> it = com.iab.omid.library.applovin.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(treeWalker.f92201d);
                }
            }
        } else {
            treeWalker = this;
            treeWalker.f92204g.b();
        }
        treeWalker.f92203f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f92198a.clear();
        f92194j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f92198a.contains(treeWalkerTimeLogger)) {
            this.f92198a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j3) {
        if (this.f92198a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f92198a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f92199b, TimeUnit.NANOSECONDS.toMillis(j3));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f92199b, j3);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strD = this.f92203f.d(view);
        if (strD == null) {
            return false;
        }
        com.iab.omid.library.applovin.utils.c.a(jSONObject, strD);
        com.iab.omid.library.applovin.utils.c.a(jSONObject, Boolean.valueOf(this.f92203f.f(view)));
        this.f92203f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.applovin.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.applovin.walking.c cVar, boolean z2) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.applovin.walking.c.PARENT_VIEW, z2);
    }

    @Override // com.iab.omid.library.applovin.processor.a.InterfaceC0169a
    public void a(View view, com.iab.omid.library.applovin.processor.a aVar, JSONObject jSONObject, boolean z2) {
        com.iab.omid.library.applovin.walking.c cVarE;
        TreeWalker treeWalker;
        if (h.d(view) && (cVarE = this.f92203f.e(view)) != com.iab.omid.library.applovin.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.applovin.utils.c.a(jSONObject, jSONObjectA);
            if (b(view, jSONObjectA)) {
                treeWalker = this;
            } else {
                boolean z3 = z2 || a(view, jSONObjectA);
                if (this.f92200c && cVarE == com.iab.omid.library.applovin.walking.c.OBSTRUCTION_VIEW && !z3) {
                    this.f92201d.add(new com.iab.omid.library.applovin.weakreference.a(view));
                }
                treeWalker = this;
                treeWalker.a(view, aVar, jSONObjectA, cVarE, z3);
            }
            treeWalker.f92199b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.applovin.processor.a aVarB = this.f92202e.b();
        String strB = this.f92203f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.applovin.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.applovin.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.applovin.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0171a c0171aC = this.f92203f.c(view);
        if (c0171aC == null) {
            return false;
        }
        com.iab.omid.library.applovin.utils.c.a(jSONObject, c0171aC);
        return true;
    }
}

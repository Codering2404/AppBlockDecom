package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.impl.f1;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class e1 extends d1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f59316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f59317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f59318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u2 f59319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c f59320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private StringBuffer f59321k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f59322l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ExecutorService f59323m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f59324n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f59325a;

        a(String str) {
            this.f59325a = str;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                if (((Boolean) e1.this.f59052a.a(sj.V0)).booleanValue()) {
                    synchronized (e1.this.f59322l) {
                        StringUtils.replaceAll(e1.this.f59321k, this.f59325a, uri.toString());
                    }
                } else {
                    StringUtils.replaceAll(e1.this.f59321k, this.f59325a, uri.toString());
                }
                e1.this.f59317g.a(uri);
                e1.this.f59319i.d();
                return;
            }
            com.applovin.impl.sdk.n nVar = e1.this.f59054c;
            if (com.applovin.impl.sdk.n.a()) {
                e1 e1Var = e1.this;
                e1Var.f59054c.a(e1Var.f59053b, CbYNFSEGaQj.sAWhQGhtGnEWU + this.f59325a);
            }
            if (e1.this.f59320j != null) {
                e1.this.f59320j.a(e1.this.f59316f, true);
            }
            e1.this.f59319i.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f59327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f59328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f59329c;

        b(String str, String str2, String str3) {
            this.f59327a = str;
            this.f59328b = str2;
            this.f59329c = str3;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                if (((Boolean) e1.this.f59052a.a(sj.V0)).booleanValue()) {
                    synchronized (e1.this.f59322l) {
                        StringUtils.replaceAll(e1.this.f59321k, this.f59327a, uri.toString());
                    }
                } else {
                    StringUtils.replaceAll(e1.this.f59321k, this.f59327a, uri.toString());
                }
                e1.this.f59317g.a(uri);
                e1.this.f59319i.d();
                return;
            }
            if (e1.this.f59317g.X().contains(this.f59328b + this.f59329c) && e1.this.f59320j != null) {
                e1.this.f59320j.a(e1.this.f59316f, true);
            }
            e1.this.f59319i.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        void a(String str, boolean z2);
    }

    public e1(String str, com.applovin.impl.sdk.ad.b bVar, List list, u2 u2Var, ExecutorService executorService, com.applovin.impl.sdk.j jVar, c cVar) {
        super("AsyncTaskCacheHTMLResources", jVar);
        this.f59316f = str;
        this.f59317g = bVar;
        this.f59318h = list;
        this.f59319i = u2Var;
        this.f59323m = executorService;
        this.f59320j = cVar;
        this.f59321k = new StringBuffer(str);
        this.f59322l = new Object();
    }

    private void a(String str) {
        c cVar;
        if (this.f59056e.get() || (cVar = this.f59320j) == null) {
            return;
        }
        cVar.a(str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.HashSet c() {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.e1.c():java.util.HashSet");
    }

    private HashSet d() {
        HashSet hashSet = new HashSet();
        for (String str : StringUtils.getRegexMatches(StringUtils.match(this.f59316f, (String) this.f59052a.a(sj.Y4)), 1)) {
            if (this.f59056e.get()) {
                return null;
            }
            if (StringUtils.isValidString(str)) {
                hashSet.add(new f1(str, this.f59317g, Collections.EMPTY_LIST, false, this.f59319i, this.f59052a, new a(str)));
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f59054c.a(this.f59053b, "Skip caching of non-resource " + str);
            }
        }
        return hashSet;
    }

    private Collection e() {
        HashSet hashSet = new HashSet();
        for (char c3 : ((String) this.f59052a.a(sj.D0)).toCharArray()) {
            hashSet.add(Character.valueOf(c3));
        }
        hashSet.add('\"');
        return hashSet;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws InterruptedException {
        HashSet hashSetD;
        if (this.f59056e.get()) {
            return Boolean.FALSE;
        }
        if (TextUtils.isEmpty(this.f59316f)) {
            a(this.f59316f);
            return Boolean.FALSE;
        }
        if (!((Boolean) this.f59052a.a(sj.E0)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f59054c.a(this.f59053b, "Resource caching is disabled, skipping cache...");
            }
            a(this.f59316f);
            return Boolean.FALSE;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSetC = c();
        if (hashSetC != null) {
            hashSet.addAll(hashSetC);
        }
        if (((Boolean) this.f59052a.a(sj.W4)).booleanValue() && (hashSetD = d()) != null) {
            hashSet.addAll(hashSetD);
        }
        this.f59324n = new ArrayList(hashSet);
        if (this.f59056e.get()) {
            return Boolean.FALSE;
        }
        List list = this.f59324n;
        if (list == null || list.isEmpty()) {
            a(this.f59316f);
            return Boolean.FALSE;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f59054c.a(this.f59053b, "Executing " + this.f59324n.size() + " caching operations...");
        }
        this.f59323m.invokeAll(this.f59324n);
        if (((Boolean) this.f59052a.a(sj.V0)).booleanValue()) {
            synchronized (this.f59322l) {
                a(this.f59321k.toString());
            }
        } else {
            a(this.f59321k.toString());
        }
        return Boolean.TRUE;
    }
}

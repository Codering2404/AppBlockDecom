package com.applovin.impl.sdk;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.impl.fe;
import com.applovin.impl.p6;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f63285b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f63286c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f63287d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f63288e = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f63289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f63290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f63291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f63292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f63293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f63294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f63295g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f63296h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f63297i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ArrayDeque f63298j;

        private b(fe feVar, c cVar) {
            this.f63298j = new ArrayDeque();
            this.f63289a = feVar.getAdUnitId();
            this.f63290b = feVar.getFormat().getLabel();
            this.f63291c = feVar.c();
            this.f63292d = feVar.b();
            this.f63293e = feVar.z();
            this.f63294f = feVar.B();
            this.f63295g = feVar.getCreativeId();
            this.f63296h = feVar.hashCode();
            a(cVar);
        }

        public String b() {
            return this.f63292d;
        }

        public String c() {
            return this.f63291c;
        }

        public String d() {
            return this.f63293e;
        }

        public String e() {
            return this.f63294f;
        }

        public String f() {
            return this.f63295g;
        }

        public String g() {
            return this.f63290b;
        }

        public int h() {
            return this.f63296h;
        }

        public c i() {
            return (c) this.f63298j.getLast();
        }

        public String a() {
            return this.f63289a;
        }

        public String toString() {
            return "AdInfo{state='" + i() + '\'' + CbYNFSEGaQj.CTzxUNQBaG + this.f63289a + "', format='" + this.f63290b + "', adapterName='" + this.f63291c + "', adapterClass='" + this.f63292d + "', adapterVersion='" + this.f63293e + "', bCode='" + this.f63294f + "', creativeId='" + this.f63295g + "', updated=" + this.f63297i + '}';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.f63297i = System.currentTimeMillis();
            this.f63298j.add(cVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum c {
        LOAD("load"),
        SHOW("show"),
        HIDE("hide"),
        CLICK("click"),
        DESTROY("destroy"),
        SHOW_ERROR("show_error");


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Set f63305i = new HashSet(Arrays.asList(values()));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f63307a;

        c(String str) {
            this.f63307a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f63307a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface d {
        void a(b bVar);
    }

    g(j jVar) {
        this.f63284a = jVar;
        a();
    }

    public void a(fe feVar, c cVar) {
        synchronized (this.f63288e) {
            try {
                int iHashCode = feVar.hashCode();
                b bVar = (b) this.f63287d.get(Integer.valueOf(iHashCode));
                if (bVar == null) {
                    if (cVar == c.DESTROY) {
                        return;
                    }
                    bVar = new b(feVar, cVar);
                    this.f63287d.put(Integer.valueOf(iHashCode), bVar);
                } else if (bVar.i() == cVar) {
                    return;
                } else {
                    bVar.a(cVar);
                }
                if (cVar == c.DESTROY) {
                    this.f63287d.remove(Integer.valueOf(iHashCode));
                }
                a(bVar, cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        synchronized (this.f63286c) {
            try {
                for (c cVar : c.values()) {
                    this.f63285b.put(cVar, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(d dVar, Set set) {
        synchronized (this.f63286c) {
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    a((c) it.next()).add(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(d dVar) {
        synchronized (this.f63286c) {
            try {
                Iterator it = this.f63285b.keySet().iterator();
                while (it.hasNext()) {
                    a((c) it.next()).remove(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Set a(c cVar) {
        synchronized (this.f63286c) {
            try {
                Set set = (Set) this.f63285b.get(cVar);
                if (p6.a(set)) {
                    return set;
                }
                return new HashSet();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(b bVar, c cVar) {
        synchronized (this.f63286c) {
            try {
                Iterator it = a(cVar).iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

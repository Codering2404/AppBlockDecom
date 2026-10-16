package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxc extends zzblp {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Logger f77128s = Logger.getLogger(zzbxc.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f77129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzblg f77130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f77131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbwv f77132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f77133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f77134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzbnw f77135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private zzbjn f77136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private zzbjn f77137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f77138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private zzbnw f77139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f77140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private zzbsh f77141r;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    zzbxc(com.google.android.libraries.places.internal.zzblg r6) {
        /*
            r5 = this;
            r5.<init>()
            boolean r0 = e()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L17
            boolean r0 = com.google.android.libraries.places.internal.zzbxj.f77153a
            java.lang.String r0 = "GRPC_PF_USE_HAPPY_EYEBALLS"
            boolean r0 = com.google.android.libraries.places.internal.zzbsz.j(r0, r2)
            if (r0 == 0) goto L17
            r0 = r1
            goto L18
        L17:
            r0 = r2
        L18:
            r5.f77129f = r0
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r5.f77131h = r3
            com.google.android.libraries.places.internal.zzbwv r3 = new com.google.android.libraries.places.internal.zzbwv
            com.google.common.collect.ImmutableList r4 = com.google.common.collect.ImmutableList.y()
            r3.<init>(r4, r0)
            r5.f77132i = r3
            r5.f77133j = r2
            r5.f77134k = r1
            r0 = 0
            r5.f77135l = r0
            com.google.android.libraries.places.internal.zzbjn r2 = com.google.android.libraries.places.internal.zzbjn.IDLE
            r5.f77136m = r2
            r5.f77137n = r2
            r5.f77138o = r1
            r5.f77139p = r0
            boolean r0 = e()
            r5.f77140q = r0
            java.lang.String r0 = "helper"
            java.lang.Object r6 = com.google.common.base.Preconditions.u(r6, r0)
            com.google.android.libraries.places.internal.zzblg r6 = (com.google.android.libraries.places.internal.zzblg) r6
            r5.f77130g = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbxc.<init>(com.google.android.libraries.places.internal.zzblg):void");
    }

    static boolean e() {
        return zzbsz.j("GRPC_SERIALIZE_RETRIES", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean o(ImmutableList immutableList) {
        Map map = this.f77131h;
        HashSet<SocketAddress> hashSet = new HashSet(map.keySet());
        HashSet hashSet2 = new HashSet();
        int size = immutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            hashSet2.addAll(((zzbka) immutableList.get(i3)).a());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                ((zzbxb) map.remove(socketAddress)).a().b();
            }
        }
        return hashSet.isEmpty();
    }

    private final void p() {
        if (this.f77140q && this.f77139p == null) {
            if (this.f77141r == null) {
                this.f77141r = new zzbsh();
            }
            long jA = this.f77141r.a();
            zzblg zzblgVar = this.f77130g;
            this.f77139p = zzblgVar.d().c(new zzbwr(this), jA, TimeUnit.NANOSECONDS, zzblgVar.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void g(zzbxb zzbxbVar) {
        zzbjn zzbjnVarG = zzbxbVar.g();
        zzbjn zzbjnVar = zzbjn.READY;
        if (zzbjnVarG != zzbjnVar) {
            return;
        }
        if (this.f77138o || zzbxbVar.e() == zzbjnVar) {
            r(zzbjnVar, new zzblf(zzbli.a(zzbxbVar.f(), null)));
            return;
        }
        zzbjn zzbjnVarE = zzbxbVar.e();
        zzbjn zzbjnVar2 = zzbjn.TRANSIENT_FAILURE;
        if (zzbjnVarE == zzbjnVar2) {
            r(zzbjnVar2, new zzbwy(zzbli.b(zzbxbVar.h().d())));
        } else if (this.f77137n != zzbjnVar2) {
            r(zzbxbVar.e(), new zzbwy(zzbli.d()));
        }
    }

    private final void r(zzbjn zzbjnVar, zzbln zzblnVar) {
        if (zzbjnVar == this.f77137n && (zzbjnVar == zzbjn.IDLE || zzbjnVar == zzbjn.CONNECTING)) {
            return;
        }
        this.f77137n = zzbjnVar;
        this.f77130g.b(zzbjnVar, zzblnVar);
    }

    private final void s() {
        if (this.f77129f) {
            zzbnw zzbnwVar = this.f77135l;
            if (zzbnwVar == null || !zzbnwVar.b()) {
                zzblg zzblgVar = this.f77130g;
                this.f77135l = zzblgVar.d().c(new zzbws(this), 250L, TimeUnit.MILLISECONDS, zzblgVar.e());
            }
        }
    }

    private final void t() {
        zzbnw zzbnwVar = this.f77135l;
        if (zzbnwVar != null) {
            zzbnwVar.a();
            this.f77135l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.net.SocketAddress u(com.google.android.libraries.places.internal.zzblm r3) {
        /*
            com.google.android.libraries.places.internal.zzbvp r3 = (com.google.android.libraries.places.internal.zzbvp) r3
            com.google.android.libraries.places.internal.zzbvr r0 = r3.f76971j
            com.google.android.libraries.places.internal.zzbnx r0 = r0.f77001n
            r0.b()
            boolean r0 = r3.f76968g
            java.lang.String r1 = "not started"
            com.google.common.base.Preconditions.A(r0, r1)
            java.util.List r3 = r3.f76966e
            r0 = 0
            if (r3 == 0) goto L1d
            int r1 = r3.size()
            r2 = 1
            if (r1 != r2) goto L1d
            goto L1e
        L1d:
            r2 = r0
        L1e:
            java.lang.String r1 = "%s does not have exactly one group"
            com.google.common.base.Preconditions.D(r2, r1, r3)
            java.lang.Object r3 = r3.get(r0)
            com.google.android.libraries.places.internal.zzbka r3 = (com.google.android.libraries.places.internal.zzbka) r3
            java.util.List r3 = r3.a()
            java.lang.Object r3 = r3.get(r0)
            java.net.SocketAddress r3 = (java.net.SocketAddress) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbxc.u(com.google.android.libraries.places.internal.zzblm):java.net.SocketAddress");
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final zzbnp a(zzbll zzbllVar) {
        Boolean bool;
        if (this.f77136m == zzbjn.SHUTDOWN) {
            return zzbnp.f76494k.e("Already shut down");
        }
        Boolean bool2 = (Boolean) zzbllVar.d().a(zzblp.f76385e);
        this.f77138o = bool2 == null || !bool2.booleanValue();
        List<zzbka> listC = zzbllVar.c();
        if (listC.isEmpty()) {
            zzbnp zzbnpVar = zzbnp.f76496m;
            String strValueOf = String.valueOf(zzbllVar.c());
            String strValueOf2 = String.valueOf(zzbllVar.d());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 55 + strValueOf2.length());
            sb.append("NameResolver returned no usable address. addrs=");
            sb.append(strValueOf);
            sb.append(", attrs=");
            sb.append(strValueOf2);
            zzbnp zzbnpVarE = zzbnpVar.e(sb.toString());
            b(zzbnpVarE);
            return zzbnpVarE;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (((zzbka) it.next()) == null) {
                zzbnp zzbnpVar2 = zzbnp.f76496m;
                String strValueOf3 = String.valueOf(zzbllVar.c());
                String strValueOf4 = String.valueOf(zzbllVar.d());
                StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 69 + strValueOf4.length());
                sb2.append("NameResolver returned address list with null endpoint. addrs=");
                sb2.append(strValueOf3);
                sb2.append(", attrs=");
                sb2.append(strValueOf4);
                zzbnp zzbnpVarE2 = zzbnpVar2.e(sb2.toString());
                b(zzbnpVarE2);
                return zzbnpVarE2;
            }
        }
        this.f77134k = true;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (zzbka zzbkaVar : listC) {
            ArrayList arrayList2 = new ArrayList();
            for (SocketAddress socketAddress : zzbkaVar.a()) {
                if (hashSet.add(socketAddress)) {
                    arrayList2.add(socketAddress);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new zzbka(arrayList2, zzbkaVar.b()));
            }
        }
        if ((zzbllVar.e() instanceof zzbwx) && (bool = ((zzbwx) zzbllVar.e()).f77117a) != null && bool.booleanValue()) {
            Collections.shuffle(arrayList, new Random());
        }
        ImmutableList immutableListM = ImmutableList.o().k(arrayList).m();
        zzbjn zzbjnVar = this.f77136m;
        zzbjn zzbjnVar2 = zzbjn.READY;
        if (zzbjnVar == zzbjnVar2 || zzbjnVar == zzbjn.CONNECTING) {
            zzbwv zzbwvVar = this.f77132i;
            SocketAddress socketAddressD = zzbwvVar.d();
            zzbwvVar.g(immutableListM);
            if (zzbwvVar.h(socketAddressD)) {
                ((zzbxb) this.f77131h.get(socketAddressD)).a().d(zzbwvVar.f());
                o(immutableListM);
                return zzbnp.f76488e;
            }
        } else {
            this.f77132i.g(immutableListM);
        }
        if (o(immutableListM)) {
            zzbjn zzbjnVar3 = zzbjn.CONNECTING;
            this.f77136m = zzbjnVar3;
            r(zzbjnVar3, new zzbwy(zzbli.d()));
        }
        zzbjn zzbjnVar4 = this.f77136m;
        if (zzbjnVar4 == zzbjnVar2) {
            zzbjn zzbjnVar5 = zzbjn.IDLE;
            this.f77136m = zzbjnVar5;
            r(zzbjnVar5, new zzbxa(this, this));
        } else if (zzbjnVar4 == zzbjn.CONNECTING || zzbjnVar4 == zzbjn.TRANSIENT_FAILURE) {
            t();
            d();
        }
        return zzbnp.f76488e;
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void b(zzbnp zzbnpVar) {
        if (this.f77136m == zzbjn.SHUTDOWN) {
            return;
        }
        Map map = this.f77131h;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((zzbxb) it.next()).a().b();
        }
        map.clear();
        this.f77132i.g(ImmutableList.y());
        zzbjn zzbjnVar = zzbjn.TRANSIENT_FAILURE;
        this.f77136m = zzbjnVar;
        r(zzbjnVar, new zzbwy(zzbli.b(zzbnpVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void c() {
        Map map = this.f77131h;
        f77128s.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer", "shutdown", "Shutting down, currently have {} subchannels created", Integer.valueOf(map.size()));
        zzbjn zzbjnVar = zzbjn.SHUTDOWN;
        this.f77136m = zzbjnVar;
        this.f77137n = zzbjnVar;
        t();
        zzbnw zzbnwVar = this.f77139p;
        if (zzbnwVar != null) {
            zzbnwVar.a();
            this.f77139p = null;
        }
        this.f77141r = null;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((zzbxb) it.next()).a().b();
        }
        map.clear();
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void d() {
        zzbwv zzbwvVar = this.f77132i;
        if (!zzbwvVar.a() || this.f77136m == zzbjn.SHUTDOWN) {
            return;
        }
        Map map = this.f77131h;
        SocketAddress socketAddressD = zzbwvVar.d();
        zzbxb zzbxbVar = (zzbxb) map.get(socketAddressD);
        if (zzbxbVar == null) {
            zzbio zzbioVarE = zzbwvVar.e();
            zzbwt zzbwtVar = new zzbwt(this, null);
            zzblg zzblgVar = this.f77130g;
            zzblb zzblbVarD = zzbld.d();
            zzblbVarD.b(Lists.l(new zzbka(Collections.singletonList(socketAddressD), zzbioVarE)));
            zzblbVarD.a(zzblp.f76382b, zzbwtVar);
            zzblbVarD.a(zzblp.f76383c, Boolean.valueOf(this.f77140q));
            zzblm zzblmVarA = zzblgVar.a(zzblbVarD.c());
            final zzbxb zzbxbVar2 = new zzbxb(zzblmVarA, zzbjn.IDLE);
            zzbwtVar.b(zzbxbVar2);
            map.put(socketAddressD, zzbxbVar2);
            zzbio zzbioVarB = ((zzbvp) zzblmVarA).f76962a.b();
            if (this.f77138o || zzbioVarB.a(zzblp.f76384d) == null) {
                zzbxbVar2.i(zzbjo.a(zzbjn.READY));
            }
            zzblmVarA.a(new zzblo() { // from class: com.google.android.libraries.places.internal.zzbww
                @Override // com.google.android.libraries.places.internal.zzblo
                public final /* synthetic */ void a(zzbjo zzbjoVar) {
                    this.f77115a.f(zzbxbVar2, zzbjoVar);
                }
            });
            zzbxbVar = zzbxbVar2;
        }
        int iOrdinal = zzbxbVar.b().ordinal();
        if (iOrdinal == 0) {
            s();
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            zzbxbVar.f().c();
            zzbxbVar.d(zzbjn.CONNECTING);
            s();
            return;
        }
        if (!this.f77140q) {
            zzbwvVar.b();
            d();
        } else if (!zzbwvVar.a()) {
            p();
        } else {
            zzbxbVar.f().c();
            zzbxbVar.d(zzbjn.CONNECTING);
        }
    }

    final /* synthetic */ void f(zzbxb zzbxbVar, zzbjo zzbjoVar) {
        zzblm zzblmVarF = zzbxbVar.f();
        zzbjn zzbjnVarC = zzbjoVar.c();
        Map map = this.f77131h;
        if (zzbxbVar == map.get(u(zzblmVarF)) && zzbjnVarC != zzbjn.SHUTDOWN) {
            zzbjn zzbjnVar = zzbjn.IDLE;
            if (zzbjnVarC == zzbjnVar && zzbxbVar.g() == zzbjn.READY) {
                this.f77130g.c();
            }
            zzbxbVar.d(zzbjnVarC);
            zzbjn zzbjnVar2 = this.f77136m;
            zzbjn zzbjnVar3 = zzbjn.TRANSIENT_FAILURE;
            if (zzbjnVar2 == zzbjnVar3 || this.f77137n == zzbjnVar3) {
                if (zzbjnVarC == zzbjn.CONNECTING) {
                    return;
                }
                if (zzbjnVarC == zzbjnVar) {
                    d();
                    return;
                }
            }
            int iOrdinal = zzbjnVarC.ordinal();
            if (iOrdinal == 0) {
                zzbjn zzbjnVar4 = zzbjn.CONNECTING;
                this.f77136m = zzbjnVar4;
                r(zzbjnVar4, new zzbwy(zzbli.d()));
                return;
            }
            if (iOrdinal == 1) {
                zzbnw zzbnwVar = this.f77139p;
                if (zzbnwVar != null) {
                    zzbnwVar.a();
                    this.f77139p = null;
                }
                this.f77141r = null;
                t();
                for (zzbxb zzbxbVar2 : map.values()) {
                    if (!zzbxbVar2.a().equals(zzbxbVar.f())) {
                        zzbxbVar2.a().b();
                    }
                }
                map.clear();
                zzbjn zzbjnVar5 = zzbjn.READY;
                zzbxbVar.d(zzbjnVar5);
                map.put(u(zzbxbVar.f()), zzbxbVar);
                this.f77132i.h(u(zzbxbVar.f()));
                this.f77136m = zzbjnVar5;
                g(zzbxbVar);
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new IllegalArgumentException("Unsupported state:".concat(String.valueOf(zzbjnVarC)));
                }
                this.f77132i.c();
                this.f77136m = zzbjnVar;
                r(zzbjnVar, new zzbxa(this, this));
                return;
            }
            zzbwv zzbwvVar = this.f77132i;
            if (zzbwvVar.a() && map.get(zzbwvVar.d()) == zzbxbVar) {
                if (zzbwvVar.b()) {
                    t();
                    d();
                } else if (map.size() >= zzbwvVar.i()) {
                    p();
                } else {
                    zzbwvVar.c();
                    d();
                }
            }
            if (map.size() >= zzbwvVar.i()) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    if (!((zzbxb) it.next()).c()) {
                        return;
                    }
                }
                this.f77136m = zzbjnVar3;
                r(zzbjnVar3, new zzbwy(zzbli.b(zzbjoVar.d())));
                int i3 = this.f77133j + 1;
                this.f77133j = i3;
                if (i3 >= zzbwvVar.i() || this.f77134k) {
                    this.f77134k = false;
                    this.f77133j = 0;
                    this.f77130g.c();
                }
            }
        }
    }

    final /* synthetic */ zzblg i() {
        return this.f77130g;
    }

    final /* synthetic */ Map j() {
        return this.f77131h;
    }

    final /* synthetic */ zzbwv k() {
        return this.f77132i;
    }

    final /* synthetic */ void l(zzbnw zzbnwVar) {
        this.f77135l = null;
    }

    final /* synthetic */ boolean m() {
        return this.f77138o;
    }

    final /* synthetic */ void n(zzbnw zzbnwVar) {
        this.f77139p = null;
    }
}

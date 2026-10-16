package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.primitives.UnsignedInts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzceo extends zzblp {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Logger f77718k = Logger.getLogger(zzceo.class.getName());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f77719l = new Random().nextInt();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzblg f77721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f77722h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected zzbjn f77724j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f77720f = new ArrayList(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final zzblr f77723i = new zzbxj();

    protected zzceo(zzblg zzblgVar) {
        this.f77721g = (zzblg) Preconditions.u(zzblgVar, "helper");
        f77718k.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "<init>", "Created");
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final zzbnp a(zzbll zzbllVar) {
        zzbnp zzbnpVarE;
        f77718k.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "acceptResolvedAddresses", "Received resolution result: {0}", zzbllVar);
        try {
            this.f77722h = true;
            LinkedHashMap linkedHashMapD = Maps.D(zzbllVar.c().size());
            for (zzbka zzbkaVar : zzbllVar.c()) {
                zzblk zzblkVarB = zzbllVar.b();
                zzblkVarB.a(Collections.singletonList(zzbkaVar));
                zzbim zzbimVarB = zzbio.b();
                zzbimVarB.a(zzblp.f76385e, Boolean.TRUE);
                zzblkVarB.b(zzbimVarB.c());
                zzblkVarB.c(null);
                linkedHashMapD.put(new zzcen(zzbkaVar), zzblkVarB.d());
            }
            if (linkedHashMapD.isEmpty()) {
                zzbnp zzbnpVar = zzbnp.f76496m;
                String string = zzbllVar.toString();
                StringBuilder sb = new StringBuilder(string.length() + 41);
                sb.append("NameResolver returned no usable address. ");
                sb.append(string);
                zzbnpVarE = zzbnpVar.e(sb.toString());
                b(zzbnpVarE);
            } else {
                LinkedHashMap linkedHashMapD2 = Maps.D(this.f77720f.size());
                for (zzcem zzcemVar : this.f77720f) {
                    linkedHashMapD2.put(zzcemVar.c(), zzcemVar);
                }
                zzbnp zzbnpVar2 = zzbnp.f76488e;
                ArrayList arrayList = new ArrayList(linkedHashMapD.size());
                for (Map.Entry entry : linkedHashMapD.entrySet()) {
                    zzcem zzcemVarF = (zzcem) linkedHashMapD2.remove(entry.getKey());
                    if (zzcemVarF == null) {
                        zzcemVarF = f(entry.getKey());
                    }
                    arrayList.add(zzcemVarF);
                }
                int iC = arrayList.isEmpty() ? 0 : UnsignedInts.c(f77719l, arrayList.size());
                for (zzcem zzcemVar2 : Iterables.d(Iterables.s(arrayList, iC), Iterables.n(arrayList, iC))) {
                    zzbll zzbllVar2 = (zzbll) linkedHashMapD.get(zzcemVar2.c());
                    if (zzbllVar2 != null) {
                        zzbnp zzbnpVarA = zzcemVar2.g().a(zzbllVar2);
                        if (!zzbnpVarA.j()) {
                            zzbnpVar2 = zzbnpVarA;
                        }
                    }
                }
                this.f77720f = arrayList;
                e();
                Iterator it = linkedHashMapD2.values().iterator();
                while (it.hasNext()) {
                    ((zzcem) it.next()).b();
                }
                zzbnpVarE = zzbnpVar2;
            }
            this.f77722h = false;
            return zzbnpVarE;
        } catch (Throwable th) {
            this.f77722h = false;
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void b(zzbnp zzbnpVar) {
        if (this.f77724j != zzbjn.READY) {
            this.f77721g.b(zzbjn.TRANSIENT_FAILURE, new zzblf(zzbli.b(zzbnpVar)));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzblp
    public final void c() {
        f77718k.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "shutdown", "Shutdown");
        Iterator it = this.f77720f.iterator();
        while (it.hasNext()) {
            ((zzcem) it.next()).b();
        }
        this.f77720f.clear();
    }

    protected abstract void e();

    protected zzcem f(Object obj) {
        throw null;
    }

    protected final zzblg g() {
        return this.f77721g;
    }

    public final Collection h() {
        return this.f77720f;
    }

    protected final List i() {
        ArrayList arrayList = new ArrayList();
        for (zzcem zzcemVar : this.f77720f) {
            if (zzcemVar.f() == zzbjn.READY) {
                arrayList.add(zzcemVar);
            }
        }
        return arrayList;
    }

    final /* synthetic */ zzblg k() {
        return this.f77721g;
    }
}

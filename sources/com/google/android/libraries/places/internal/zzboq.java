package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzboq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblg f76562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzblp f76563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzblr f76564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbov f76565d;

    zzboq(zzbov zzbovVar, zzblg zzblgVar) {
        Objects.requireNonNull(zzbovVar);
        this.f76565d = zzbovVar;
        this.f76562a = zzblgVar;
        zzblr zzblrVarB = zzbovVar.c().b(zzbovVar.d());
        this.f76564c = zzblrVarB;
        if (zzblrVarB != null) {
            this.f76563b = zzblrVarB.a(zzblgVar);
            return;
        }
        String strD = zzbovVar.d();
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 182);
        sb.append("Could not find policy '");
        sb.append(strD);
        sb.append("'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        throw new IllegalStateException(sb.toString());
    }

    final zzbnp a(zzbll zzbllVar) {
        zzbzs zzbzsVar = (zzbzs) zzbllVar.e();
        byte[] bArr = null;
        if (zzbzsVar == null) {
            try {
                zzbov zzbovVar = this.f76565d;
                zzbzsVar = new zzbzs(zzbovVar.b(zzbovVar.d(), "using default policy"), null);
            } catch (zzbou e3) {
                this.f76562a.b(zzbjn.TRANSIENT_FAILURE, new zzbos(zzbnp.f76495l.e(e3.getMessage())));
                this.f76563b.c();
                this.f76564c = null;
                this.f76563b = new zzbot(bArr);
                return zzbnp.f76488e;
            }
        }
        if (this.f76564c == null || !zzbzsVar.f77301a.d().equals(this.f76564c.d())) {
            zzblg zzblgVar = this.f76562a;
            zzblgVar.b(zzbjn.CONNECTING, new zzbor(bArr));
            this.f76563b.c();
            zzblr zzblrVar = zzbzsVar.f77301a;
            this.f76564c = zzblrVar;
            zzblp zzblpVar = this.f76563b;
            this.f76563b = zzblrVar.a(zzblgVar);
            ((zzbuz) zzblgVar).f76934b.D().b(2, "Load balancer changed from {0} to {1}", zzblpVar.getClass().getSimpleName(), this.f76563b.getClass().getSimpleName());
        }
        Object obj = zzbzsVar.f77302b;
        if (obj != null) {
            ((zzbuz) this.f76562a).f76934b.D().b(1, "Load-balancing config: {0}", obj);
        }
        zzblp zzblpVar2 = this.f76563b;
        zzblk zzblkVarA = zzbll.a();
        zzblkVarA.a(zzbllVar.c());
        zzblkVarA.b(zzbllVar.d());
        zzblkVarA.c(obj);
        return zzblpVar2.a(zzblkVarA.d());
    }

    final void b() {
        this.f76563b.c();
        this.f76563b = null;
    }

    public final zzblp c() {
        return this.f76563b;
    }
}

package com.google.android.libraries.places.internal;

import java.util.Objects;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzcem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f77711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzblp f77712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbjn f77713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbln f77714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzceo f77715e;

    public zzcem(zzceo zzceoVar, Object obj, zzble zzbleVar) {
        Objects.requireNonNull(zzceoVar);
        this.f77715e = zzceoVar;
        this.f77714d = new zzblf(zzbli.d());
        this.f77711a = obj;
        this.f77712b = zzbleVar.a(a());
        this.f77713c = zzbjn.CONNECTING;
    }

    protected zzcel a() {
        return new zzcel(this);
    }

    protected final void b() {
        this.f77712b.c();
        this.f77713c = zzbjn.SHUTDOWN;
        zzceo.f77718k.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "shutdown", "Child balancer {0} deleted", this.f77711a);
    }

    public final Object c() {
        return this.f77711a;
    }

    public final zzblp d() {
        return this.f77712b;
    }

    public final zzbln e() {
        return this.f77714d;
    }

    public final zzbjn f() {
        return this.f77713c;
    }

    final /* synthetic */ zzblp g() {
        return this.f77712b;
    }

    final /* synthetic */ zzbjn h() {
        return this.f77713c;
    }

    final /* synthetic */ void i(zzbjn zzbjnVar) {
        this.f77713c = zzbjnVar;
    }

    final /* synthetic */ void j(zzbln zzblnVar) {
        this.f77714d = zzblnVar;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f77711a);
        String strValueOf2 = String.valueOf(this.f77713c);
        String strValueOf3 = String.valueOf(this.f77714d.getClass());
        String strValueOf4 = String.valueOf(this.f77712b);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 20 + length2 + 15 + strValueOf3.length() + 6 + strValueOf4.length());
        sb.append("Address = ");
        sb.append(strValueOf);
        sb.append(", state = ");
        sb.append(strValueOf2);
        sb.append(", picker type: ");
        sb.append(strValueOf3);
        sb.append(", lb: ");
        sb.append(strValueOf4);
        return sb.toString();
    }
}

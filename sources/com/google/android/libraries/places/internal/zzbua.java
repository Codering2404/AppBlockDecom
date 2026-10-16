package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbua implements zzbkt, zzcai {
    private final String A;
    private zzbsh B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbku f76881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f76883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbtt f76884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbpq f76885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f76886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbkn f76887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbpb f76888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbiv f76889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f76890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f76891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzbnx f76892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzbtu f76893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile List f76894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Stopwatch f76895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private zzbnw f76896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private zzbnw f76897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private zzbwd f76898r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private zzbqa f76901u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile zzbwd f76902v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private zzbnp f76904x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile zzbio f76905y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final zzcaf f76906z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Collection f76899s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final zzbte f76900t = new zzbth(this);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile zzbjo f76903w = zzbjo.a(zzbjn.IDLE);

    zzbua(zzbld zzbldVar, String str, String str2, zzbsg zzbsgVar, zzbpq zzbpqVar, ScheduledExecutorService scheduledExecutorService, Supplier supplier, zzbnx zzbnxVar, zzbtt zzbttVar, zzbkn zzbknVar, zzbpb zzbpbVar, zzbpd zzbpdVar, zzbku zzbkuVar, zzbiv zzbivVar, List list, String str3, zzbmo zzbmoVar) {
        List listA = zzbldVar.a();
        Preconditions.u(listA, "addressGroups");
        Preconditions.e(!listA.isEmpty(), "addressGroups is empty");
        r(listA, "addressGroups contains null entry");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(listA));
        this.f76894n = listUnmodifiableList;
        this.f76893m = new zzbtu(listUnmodifiableList);
        this.f76882b = str;
        this.f76883c = str2;
        this.f76885e = zzbpqVar;
        this.f76886f = scheduledExecutorService;
        this.f76895o = (Stopwatch) supplier.get();
        this.f76892l = zzbnxVar;
        this.f76884d = zzbttVar;
        this.f76887g = zzbknVar;
        this.f76888h = zzbpbVar;
        this.f76881a = (zzbku) Preconditions.u(zzbkuVar, "logId");
        this.f76889i = (zzbiv) Preconditions.u(zzbivVar, "channelLogger");
        this.f76891k = list;
        this.f76890j = ((Boolean) zzbldVar.c(zzblp.f76383c)).booleanValue();
        this.A = str3;
        this.f76906z = new zzcaf(zzbmoVar);
    }

    private final void q(zzbjo zzbjoVar) {
        this.f76892l.b();
        if (this.f76903w.c() != zzbjoVar.c()) {
            Preconditions.D(this.f76903w.c() != zzbjn.SHUTDOWN, "Cannot transition out of SHUTDOWN to %s", zzbjoVar.c());
            if (this.f76890j && zzbjoVar.c() == zzbjn.TRANSIENT_FAILURE) {
                this.f76903w = zzbjo.a(zzbjn.IDLE);
            } else {
                this.f76903w = zzbjoVar;
            }
            zzbtt zzbttVar = this.f76884d;
            Preconditions.A(true, "listener is null");
            ((zzbvn) zzbttVar).f76959a.a(zzbjoVar);
        }
    }

    private static void r(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Preconditions.u(it.next(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s(zzbnp zzbnpVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(zzbnpVar.g());
        if (zzbnpVar.h() != null) {
            sb.append("(");
            sb.append(zzbnpVar.h());
            sb.append(")");
        }
        if (zzbnpVar.i() != null) {
            sb.append("[");
            sb.append(zzbnpVar.i());
            sb.append("]");
        }
        return sb.toString();
    }

    final /* synthetic */ zzbtt A() {
        return this.f76884d;
    }

    final /* synthetic */ ScheduledExecutorService B() {
        return this.f76886f;
    }

    final /* synthetic */ zzbkn C() {
        return this.f76887g;
    }

    final /* synthetic */ zzbiv D() {
        return this.f76889i;
    }

    final /* synthetic */ List E() {
        return this.f76891k;
    }

    final /* synthetic */ zzbnx F() {
        return this.f76892l;
    }

    final /* synthetic */ zzbtu G() {
        return this.f76893m;
    }

    final /* synthetic */ void H(List list) {
        this.f76894n = list;
    }

    final /* synthetic */ void I(zzbnw zzbnwVar) {
        this.f76896p = null;
    }

    final /* synthetic */ zzbnw J() {
        return this.f76897q;
    }

    final /* synthetic */ void K(zzbnw zzbnwVar) {
        this.f76897q = zzbnwVar;
    }

    final /* synthetic */ zzbwd L() {
        return this.f76898r;
    }

    final /* synthetic */ void M(zzbwd zzbwdVar) {
        this.f76898r = zzbwdVar;
    }

    final /* synthetic */ Collection N() {
        return this.f76899s;
    }

    final /* synthetic */ zzbte O() {
        return this.f76900t;
    }

    public final void a(zzbnp zzbnpVar) {
        zzbtm zzbtmVar = new zzbtm(this, zzbnpVar);
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.a(zzbtmVar);
        zzbnxVar.zza();
    }

    final void c(zzbnp zzbnpVar) {
        a(zzbnpVar);
        zzbtp zzbtpVar = new zzbtp(this, zzbnpVar);
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.a(zzbtpVar);
        zzbnxVar.zza();
    }

    final /* synthetic */ zzbqa d() {
        return this.f76901u;
    }

    final /* synthetic */ void f(zzbqa zzbqaVar) {
        this.f76901u = null;
    }

    final /* synthetic */ zzbwd g() {
        return this.f76902v;
    }

    final /* synthetic */ void h(zzbwd zzbwdVar) {
        this.f76902v = zzbwdVar;
    }

    final /* synthetic */ zzbjo i() {
        return this.f76903w;
    }

    final /* synthetic */ zzbnp j() {
        return this.f76904x;
    }

    final /* synthetic */ void k(zzbnp zzbnpVar) {
        this.f76904x = zzbnpVar;
    }

    final /* synthetic */ void l(zzbio zzbioVar) {
        this.f76905y = zzbioVar;
    }

    final /* synthetic */ zzcaf m() {
        return this.f76906z;
    }

    final /* synthetic */ String n() {
        return this.A;
    }

    final /* synthetic */ void o(zzbsh zzbshVar) {
        this.B = null;
    }

    public final void t(List list) {
        Preconditions.u(list, "newAddressGroups");
        r(list, "newAddressGroups contains null entry");
        Preconditions.e(!list.isEmpty(), "newAddressGroups is empty");
        zzbtl zzbtlVar = new zzbtl(this, Collections.unmodifiableList(new ArrayList(list)));
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.a(zzbtlVar);
        zzbnxVar.zza();
    }

    public final String toString() {
        return MoreObjects.c(this).c("logId", this.f76881a.c()).d("addressGroups", this.f76894n).toString();
    }

    final /* synthetic */ void u() {
        zzbki zzbkiVar;
        this.f76892l.b();
        Preconditions.A(this.f76896p == null, "Should have no reconnectTask scheduled");
        zzbtu zzbtuVar = this.f76893m;
        if (zzbtuVar.b()) {
            this.f76895o.h().i();
        }
        SocketAddress socketAddressE = zzbtuVar.e();
        byte[] bArr = null;
        if (socketAddressE instanceof zzbki) {
            zzbki zzbkiVar2 = (zzbki) socketAddressE;
            zzbkiVar = zzbkiVar2;
            socketAddressE = zzbkiVar2.d();
        } else {
            zzbkiVar = null;
        }
        zzbio zzbioVarF = zzbtuVar.f();
        String str = (String) zzbioVarF.a(zzbka.f76310d);
        zzbpp zzbppVar = new zzbpp();
        if (str == null) {
            str = this.f76882b;
        }
        zzbppVar.b(str);
        zzbppVar.d(zzbioVarF);
        zzbppVar.f(this.f76883c);
        zzbppVar.h(zzbkiVar);
        zzbtz zzbtzVar = new zzbtz();
        zzbtzVar.f76880a = this.f76881a;
        zzbts zzbtsVar = new zzbts(this.f76885e.l1(socketAddressE, zzbppVar, zzbtzVar), this.f76888h, bArr);
        zzbtzVar.f76880a = zzbtsVar.zzc();
        this.f76887g.d(zzbtsVar);
        this.f76901u = zzbtsVar;
        this.f76899s.add(zzbtsVar);
        zzbtsVar.b(new zzbty(this, zzbtsVar));
        this.f76889i.b(2, "Started transport {0}", zzbtzVar.f76880a);
    }

    final /* synthetic */ void v(zzbnp zzbnpVar) {
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.b();
        q(zzbjo.b(zzbnpVar));
        if (this.f76890j) {
            return;
        }
        if (this.B == null) {
            this.B = new zzbsh();
        }
        long jA = this.B.a();
        Stopwatch stopwatch = this.f76895o;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jE = jA - stopwatch.e(timeUnit);
        this.f76889i.b(2, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", s(zzbnpVar), Long.valueOf(jE));
        Preconditions.A(this.f76896p == null, "previous reconnectTask is not done");
        this.f76896p = zzbnxVar.c(new zzbti(this), jE, timeUnit, this.f76886f);
    }

    final /* synthetic */ void w(zzbjn zzbjnVar) {
        this.f76892l.b();
        q(zzbjo.a(zzbjnVar));
    }

    final /* synthetic */ void x() {
        zzbtn zzbtnVar = new zzbtn(this);
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.a(zzbtnVar);
        zzbnxVar.zza();
    }

    final /* synthetic */ void y(zzbqa zzbqaVar, boolean z2) {
        zzbto zzbtoVar = new zzbto(this, zzbqaVar, z2);
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.a(zzbtoVar);
        zzbnxVar.zza();
    }

    final /* synthetic */ void z() {
        this.f76892l.b();
        zzbnw zzbnwVar = this.f76896p;
        if (zzbnwVar != null) {
            zzbnwVar.a();
            this.f76896p = null;
            this.B = null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcai
    public final zzbpo zza() {
        zzbwd zzbwdVar = this.f76902v;
        if (zzbwdVar != null) {
            return zzbwdVar;
        }
        zzbnx zzbnxVar = this.f76892l;
        zzbnxVar.a(new zzbtj(this));
        zzbnxVar.zza();
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzbkz
    public final zzbku zzc() {
        return this.f76881a;
    }
}

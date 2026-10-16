package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.libraries.places.api.net.PlacesClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzmd implements zzmn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzmp f78188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f78189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzmz f78190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final zzbih f78191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final zzbih f78192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzbih f78193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final zzbih f78194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final zzbih f78195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final zzbih f78196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final zzbih f78197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final zzbih f78198k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final zzbih f78199l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final zzbih f78200m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final zzbih f78201n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final zzbih f78202o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final zzbih f78203p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final zzbih f78204q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final zzbih f78205r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final zzbih f78206s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final zzbih f78207t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final zzbih f78208u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final zzbih f78209v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final zzbih f78210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final zzbih f78211x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final zzbih f78212y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final zzbih f78213z;

    zzmd(Context context, zzmp zzmpVar, zzmz zzmzVar) {
        this.f78188a = zzmpVar;
        this.f78189b = context;
        this.f78190c = zzmzVar;
        zzbie zzbieVarA = zzbif.a(context);
        this.f78191d = zzbieVarA;
        zzbih zzbihVarA = zzbid.a(zzmu.a(zzbieVarA, zzeq.a()));
        this.f78192e = zzbihVarA;
        this.f78193f = zzbil.a(zzeh.a());
        this.f78194g = zzbid.a(zzmj.f78217a);
        zzbih zzbihVarA2 = zzbid.a(zzhs.a());
        this.f78195h = zzbihVarA2;
        zzbih zzbihVarA3 = zzbid.a(zzjz.a(zzbihVarA2));
        this.f78196i = zzbihVarA3;
        this.f78197j = zzbid.a(zzkg.a(zzbihVarA2, zzbihVarA3));
        this.f78198k = zzbid.a(zzke.a(zzbihVarA2, zzbihVarA3));
        this.f78199l = zzbid.a(zzid.a());
        this.f78200m = zzbid.a(zzia.a());
        this.f78201n = zzbid.a(zzhp.a(zzbihVarA2));
        this.f78202o = zzbid.a(zzjk.a());
        this.f78203p = zzbid.a(zzkc.a());
        this.f78204q = zzbid.a(zzkj.a());
        zzms zzmsVarB = zzms.b(zzbieVarA);
        this.f78205r = zzmsVarB;
        zzbih zzbihVarA4 = zzbid.a(zzmh.f78216a);
        this.f78206s = zzbihVarA4;
        this.f78207t = zzbid.a(zzjq.a(zzmsVarB, zzbihVarA4));
        zzfg zzfgVarA = zzfg.a(zzbihVarA);
        this.f78208u = zzfgVarA;
        zzbij zzbijVarA = zzbik.a(1, 0);
        zzbijVarA.a(zzfgVarA);
        zzbik zzbikVarB = zzbijVarA.b();
        this.f78209v = zzbikVarB;
        this.f78210w = zzff.b(zzbikVarB);
        this.f78211x = zzbid.a(zzmf.f78215a);
        zzbih zzbihVar = zzme.f78214a;
        this.f78212y = zzbihVar;
        this.f78213z = zzbid.a(zzfh.a(zzbihVar));
    }

    final zzfs a() {
        return zzft.a(new zzne(zzmt.a(this.f78189b), (zzex) this.f78192e.zzb()), this.f78190c, this.f78188a);
    }

    final zzjc b() {
        return new zzjc(zzms.c(this.f78189b));
    }

    @Override // com.google.android.libraries.places.internal.zzmn
    public final PlacesClient zzc() {
        Context context = this.f78189b;
        zznh zznhVar = new zznh(context);
        zzga zzgaVarA = zzgb.a(zzml.a(zzms.c(context)), new zzlc());
        zzgg zzggVarA = zzgh.a(zzml.a(zzms.c(context)));
        zzbih zzbihVar = this.f78193f;
        zzfs zzfsVarA = a();
        zzef zzefVar = (zzef) zzbihVar.zzb();
        zzko zzkoVarA = zzkp.a();
        zzks zzksVarA = zzkt.a(zzlr.a());
        zzkw zzkwVarA = zzkx.a();
        zzla zzlaVarA = zzlb.a(zzlr.a());
        zzmp zzmpVar = this.f78188a;
        zzln zzlnVarA = zzlo.a(zzmpVar, zznhVar, zzgaVarA, zzggVarA, zzfsVarA, zzefVar, zzkoVarA, zzksVarA, zzkwVarA, zzlaVarA);
        Context contextC = zzms.c(context);
        FusedLocationProviderClient fusedLocationProviderClientA = LocationServices.a(zzms.c(context));
        zzbig.a(fusedLocationProviderClientA);
        zzfl zzflVarA = zzfm.a(contextC, fusedLocationProviderClientA, new zzmb(new zzlx()));
        zzfq zzfqVarA = zzfr.a(zzms.c(context), (zzef) zzbihVar.zzb());
        zzfs zzfsVarA2 = a();
        zzef zzefVar2 = (zzef) zzbihVar.zzb();
        zzblw zzblwVar = (zzblw) this.f78194g.zzb();
        zzfs zzfsVarA3 = a();
        zzef zzefVar3 = (zzef) zzbihVar.zzb();
        zzbih zzbihVar2 = this.f78206s;
        zzbih zzbihVar3 = this.f78207t;
        zzbih zzbihVar4 = this.f78204q;
        zzbih zzbihVar5 = this.f78203p;
        zzbih zzbihVar6 = this.f78202o;
        zzbih zzbihVar7 = this.f78201n;
        zzbih zzbihVar8 = this.f78200m;
        zzbih zzbihVar9 = this.f78199l;
        return zzhn.a(zzmpVar, zzlnVarA, zzflVarA, zzfqVarA, zzfsVarA2, zzefVar2, zzjb.a(zzmpVar, zzblwVar, zzfsVarA3, zzefVar3, this.f78197j.zzb(), this.f78198k.zzb(), zzbihVar9.zzb(), zzbihVar8.zzb(), zzbihVar7.zzb(), zzbihVar6.zzb(), zzbihVar5.zzb(), zzbihVar4.zzb(), b(), zzbihVar3.zzb(), zzjx.a(zzms.c(context), (zzblw) zzbihVar2.zzb(), zzmpVar, b(), zzbihVar3.zzb()), zzasp.a(this.f78210w), zzhx.a((zzblw) this.f78211x.zzb(), b())), new zzfe((zzblw) this.f78213z.zzb(), (zzex) this.f78192e.zzb(), zzeq.b()));
    }
}

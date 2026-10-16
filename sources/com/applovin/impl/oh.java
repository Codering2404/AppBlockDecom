package com.applovin.impl;

import com.applovin.impl.ae;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class oh {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ae.a f62299t = new ae.a(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo f62300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ae.a f62301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f62302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f62303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f62304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z7 f62305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f62306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final po f62307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wo f62308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f62309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ae.a f62310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f62311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f62312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ph f62313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f62314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f62315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f62316q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f62317r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f62318s;

    public oh(fo foVar, ae.a aVar, long j3, long j4, int i3, z7 z7Var, boolean z2, po poVar, wo woVar, List list, ae.a aVar2, boolean z3, int i4, ph phVar, long j5, long j6, long j7, boolean z4, boolean z5) {
        this.f62300a = foVar;
        this.f62301b = aVar;
        this.f62302c = j3;
        this.f62303d = j4;
        this.f62304e = i3;
        this.f62305f = z7Var;
        this.f62306g = z2;
        this.f62307h = poVar;
        this.f62308i = woVar;
        this.f62309j = list;
        this.f62310k = aVar2;
        this.f62311l = z3;
        this.f62312m = i4;
        this.f62313n = phVar;
        this.f62316q = j5;
        this.f62317r = j6;
        this.f62318s = j7;
        this.f62314o = z4;
        this.f62315p = z5;
    }

    public static oh a(wo woVar) {
        fo foVar = fo.f59732a;
        ae.a aVar = f62299t;
        return new oh(foVar, aVar, -9223372036854775807L, 0L, 1, null, false, po.f62471d, woVar, db.h(), aVar, false, 0, ph.f62438d, 0L, 0L, 0L, false, false);
    }

    public oh b(boolean z2) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, z2, this.f62315p);
    }

    public oh c(boolean z2) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, z2);
    }

    public static ae.a a() {
        return f62299t;
    }

    public oh a(ae.a aVar, long j3, long j4, long j5, long j6, po poVar, wo woVar, List list) {
        return new oh(this.f62300a, aVar, j4, j5, this.f62304e, this.f62305f, this.f62306g, poVar, woVar, list, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, j6, j3, this.f62314o, this.f62315p);
    }

    public oh a(fo foVar) {
        return new oh(foVar, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }

    public oh a(int i3) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, i3, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }

    public oh a(z7 z7Var) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, z7Var, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }

    public oh a(boolean z2) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, z2, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }

    public oh a(ae.a aVar) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, aVar, this.f62311l, this.f62312m, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }

    public oh a(boolean z2, int i3) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, z2, i3, this.f62313n, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }

    public oh a(ph phVar) {
        return new oh(this.f62300a, this.f62301b, this.f62302c, this.f62303d, this.f62304e, this.f62305f, this.f62306g, this.f62307h, this.f62308i, this.f62309j, this.f62310k, this.f62311l, this.f62312m, phVar, this.f62316q, this.f62317r, this.f62318s, this.f62314o, this.f62315p);
    }
}

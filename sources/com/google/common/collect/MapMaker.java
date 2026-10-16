package com.google.common.collect;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MapMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f84291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f84292b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f84293c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    MapMakerInternalMap.Strength f84294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    MapMakerInternalMap.Strength f84295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Equivalence f84296f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Dummy {
        VALUE
    }

    public MapMaker a(int i3) {
        int i4 = this.f84293c;
        Preconditions.B(i4 == -1, "concurrency level was already set to %s", i4);
        Preconditions.d(i3 > 0);
        this.f84293c = i3;
        return this;
    }

    int b() {
        int i3 = this.f84293c;
        if (i3 == -1) {
            return 4;
        }
        return i3;
    }

    int c() {
        int i3 = this.f84292b;
        if (i3 == -1) {
            return 16;
        }
        return i3;
    }

    Equivalence d() {
        return (Equivalence) MoreObjects.a(this.f84296f, e().b());
    }

    MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f84294d, MapMakerInternalMap.Strength.STRONG);
    }

    MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f84295e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i3) {
        int i4 = this.f84292b;
        Preconditions.B(i4 == -1, "initial capacity was already set to %s", i4);
        Preconditions.d(i3 >= 0);
        this.f84292b = i3;
        return this;
    }

    MapMaker h(Equivalence equivalence) {
        Equivalence equivalence2 = this.f84296f;
        Preconditions.D(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f84296f = (Equivalence) Preconditions.t(equivalence);
        this.f84291a = true;
        return this;
    }

    public ConcurrentMap i() {
        return !this.f84291a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.a(this);
    }

    MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f84294d;
        Preconditions.D(strength2 == null, "Key strength was already set to %s", strength2);
        this.f84294d = (MapMakerInternalMap.Strength) Preconditions.t(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f84291a = true;
        }
        return this;
    }

    MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f84295e;
        Preconditions.D(strength2 == null, "Value strength was already set to %s", strength2);
        this.f84295e = (MapMakerInternalMap.Strength) Preconditions.t(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f84291a = true;
        }
        return this;
    }

    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        MoreObjects.ToStringHelper toStringHelperC = MoreObjects.c(this);
        int i3 = this.f84292b;
        if (i3 != -1) {
            toStringHelperC.b("initialCapacity", i3);
        }
        int i4 = this.f84293c;
        if (i4 != -1) {
            toStringHelperC.b("concurrencyLevel", i4);
        }
        MapMakerInternalMap.Strength strength = this.f84294d;
        if (strength != null) {
            toStringHelperC.d("keyStrength", Ascii.e(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f84295e;
        if (strength2 != null) {
            toStringHelperC.d("valueStrength", Ascii.e(strength2.toString()));
        }
        if (this.f84296f != null) {
            toStringHelperC.k("keyEquivalence");
        }
        return toStringHelperC.toString();
    }
}

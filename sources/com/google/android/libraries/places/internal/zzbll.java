package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f76378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbio f76379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f76380c;

    /* synthetic */ zzbll(List list, zzbio zzbioVar, Object obj, byte[] bArr) {
        this.f76378a = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.u(list, "addresses")));
        this.f76379b = (zzbio) Preconditions.u(zzbioVar, "attributes");
        this.f76380c = obj;
    }

    public static zzblk a() {
        return new zzblk();
    }

    public final zzblk b() {
        zzblk zzblkVar = new zzblk();
        zzblkVar.a(this.f76378a);
        zzblkVar.b(this.f76379b);
        zzblkVar.c(this.f76380c);
        return zzblkVar;
    }

    public final List c() {
        return this.f76378a;
    }

    public final zzbio d() {
        return this.f76379b;
    }

    public final Object e() {
        return this.f76380c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbll)) {
            return false;
        }
        zzbll zzbllVar = (zzbll) obj;
        return Objects.a(this.f76378a, zzbllVar.f76378a) && Objects.a(this.f76379b, zzbllVar.f76379b) && Objects.a(this.f76380c, zzbllVar.f76380c);
    }

    public final int hashCode() {
        return Objects.b(this.f76378a, this.f76379b, this.f76380c);
    }

    public final String toString() {
        return MoreObjects.c(this).d("addresses", this.f76378a).d("attributes", this.f76379b).d("loadBalancingPolicyConfig", this.f76380c).toString();
    }
}

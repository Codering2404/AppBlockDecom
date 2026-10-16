package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbs extends RouteModifiers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f75301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f75302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f75303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f75304d;

    zzbs(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f75301a = z2;
        this.f75302b = z3;
        this.f75303c = z4;
        this.f75304d = z5;
    }

    @Override // com.google.android.libraries.places.api.model.RouteModifiers
    public final boolean c() {
        return this.f75303c;
    }

    @Override // com.google.android.libraries.places.api.model.RouteModifiers
    public final boolean d() {
        return this.f75302b;
    }

    @Override // com.google.android.libraries.places.api.model.RouteModifiers
    public final boolean e() {
        return this.f75304d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RouteModifiers) {
            RouteModifiers routeModifiers = (RouteModifiers) obj;
            if (this.f75301a == routeModifiers.f() && this.f75302b == routeModifiers.d() && this.f75303c == routeModifiers.c() && this.f75304d == routeModifiers.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.RouteModifiers
    public final boolean f() {
        return this.f75301a;
    }

    public final int hashCode() {
        int i3 = true != this.f75301a ? 1237 : 1231;
        return ((((((i3 ^ 1000003) * 1000003) ^ (true != this.f75302b ? 1237 : 1231)) * 1000003) ^ (true != this.f75303c ? 1237 : 1231)) * 1000003) ^ (true != this.f75304d ? 1237 : 1231);
    }

    public final String toString() {
        boolean z2 = this.f75301a;
        int length = String.valueOf(z2).length();
        boolean z3 = this.f75302b;
        int length2 = String.valueOf(z3).length();
        boolean z4 = this.f75303c;
        int length3 = String.valueOf(z4).length();
        boolean z5 = this.f75304d;
        StringBuilder sb = new StringBuilder(length + 44 + length2 + 15 + length3 + 16 + String.valueOf(z5).length() + 1);
        sb.append("RouteModifiers{tollAvoided=");
        sb.append(z2);
        sb.append(", highwayAvoided=");
        sb.append(z3);
        sb.append(", ferryAvoided=");
        sb.append(z4);
        sb.append(", indoorAvoided=");
        sb.append(z5);
        sb.append("}");
        return sb.toString();
    }
}

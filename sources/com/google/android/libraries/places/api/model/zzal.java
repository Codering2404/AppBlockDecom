package com.google.android.libraries.places.api.model;

import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzal extends Leg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Duration f75074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75075b;

    zzal(Duration duration, int i3) {
        if (duration == null) {
            throw new NullPointerException("Null duration");
        }
        this.f75074a = duration;
        this.f75075b = i3;
    }

    @Override // com.google.android.libraries.places.api.model.Leg
    public final int c() {
        return this.f75075b;
    }

    @Override // com.google.android.libraries.places.api.model.Leg
    public final Duration d() {
        return this.f75074a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Leg) {
            Leg leg = (Leg) obj;
            if (this.f75074a.equals(leg.d()) && this.f75075b == leg.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f75074a.hashCode() ^ 1000003) * 1000003) ^ this.f75075b;
    }

    public final String toString() {
        String string = this.f75074a.toString();
        int length = string.length();
        int i3 = this.f75075b;
        StringBuilder sb = new StringBuilder(length + 30 + String.valueOf(i3).length() + 1);
        sb.append("Leg{duration=");
        sb.append(string);
        sb.append(", distanceMeters=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}

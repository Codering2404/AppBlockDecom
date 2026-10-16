package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbb extends Period {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeOfWeek f75146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeOfWeek f75147b;

    zzbb(TimeOfWeek timeOfWeek, TimeOfWeek timeOfWeek2) {
        this.f75146a = timeOfWeek;
        this.f75147b = timeOfWeek2;
    }

    @Override // com.google.android.libraries.places.api.model.Period
    public final TimeOfWeek d() {
        return this.f75147b;
    }

    @Override // com.google.android.libraries.places.api.model.Period
    public final TimeOfWeek e() {
        return this.f75146a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            TimeOfWeek timeOfWeek = this.f75146a;
            if (timeOfWeek != null ? timeOfWeek.equals(period.e()) : period.e() == null) {
                TimeOfWeek timeOfWeek2 = this.f75147b;
                if (timeOfWeek2 != null ? timeOfWeek2.equals(period.d()) : period.d() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        TimeOfWeek timeOfWeek = this.f75146a;
        int iHashCode = timeOfWeek == null ? 0 : timeOfWeek.hashCode();
        TimeOfWeek timeOfWeek2 = this.f75147b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (timeOfWeek2 != null ? timeOfWeek2.hashCode() : 0);
    }

    public final String toString() {
        TimeOfWeek timeOfWeek = this.f75147b;
        String strValueOf = String.valueOf(this.f75146a);
        String strValueOf2 = String.valueOf(timeOfWeek);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 20 + strValueOf2.length() + 1);
        sb.append("Period{open=");
        sb.append(strValueOf);
        sb.append(", close=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}

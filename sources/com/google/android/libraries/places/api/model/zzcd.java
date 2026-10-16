package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzcd extends TimeOfWeek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDate f75331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DayOfWeek f75332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocalTime f75333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f75334d;

    zzcd(LocalDate localDate, DayOfWeek dayOfWeek, LocalTime localTime, boolean z2) {
        this.f75331a = localDate;
        if (dayOfWeek == null) {
            throw new NullPointerException("Null day");
        }
        this.f75332b = dayOfWeek;
        if (localTime == null) {
            throw new NullPointerException("Null time");
        }
        this.f75333c = localTime;
        this.f75334d = z2;
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek
    public final LocalDate c() {
        return this.f75331a;
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek
    public final DayOfWeek d() {
        return this.f75332b;
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek
    public final LocalTime e() {
        return this.f75333c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TimeOfWeek) {
            TimeOfWeek timeOfWeek = (TimeOfWeek) obj;
            LocalDate localDate = this.f75331a;
            if (localDate != null ? localDate.equals(timeOfWeek.c()) : timeOfWeek.c() == null) {
                if (this.f75332b.equals(timeOfWeek.d()) && this.f75333c.equals(timeOfWeek.e()) && this.f75334d == timeOfWeek.f()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek
    public final boolean f() {
        return this.f75334d;
    }

    public final int hashCode() {
        LocalDate localDate = this.f75331a;
        return (((((((localDate == null ? 0 : localDate.hashCode()) ^ 1000003) * 1000003) ^ this.f75332b.hashCode()) * 1000003) ^ this.f75333c.hashCode()) * 1000003) ^ (true != this.f75334d ? 1237 : 1231);
    }

    public final String toString() {
        LocalTime localTime = this.f75333c;
        DayOfWeek dayOfWeek = this.f75332b;
        String strValueOf = String.valueOf(this.f75331a);
        String string = dayOfWeek.toString();
        String string2 = localTime.toString();
        int length = strValueOf.length();
        int length2 = string.length();
        int length3 = string2.length();
        boolean z2 = this.f75334d;
        StringBuilder sb = new StringBuilder(length + 22 + length2 + 7 + length3 + 12 + String.valueOf(z2).length() + 1);
        sb.append("TimeOfWeek{date=");
        sb.append(strValueOf);
        sb.append(", day=");
        sb.append(string);
        sb.append(", time=");
        sb.append(string2);
        sb.append(", truncated=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}

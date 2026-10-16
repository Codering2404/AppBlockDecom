package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbz extends SpecialDay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDate f75317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f75318b;

    zzbz(LocalDate localDate, boolean z2) {
        if (localDate == null) {
            throw new NullPointerException("Null date");
        }
        this.f75317a = localDate;
        this.f75318b = z2;
    }

    @Override // com.google.android.libraries.places.api.model.SpecialDay
    public final LocalDate c() {
        return this.f75317a;
    }

    @Override // com.google.android.libraries.places.api.model.SpecialDay
    public final boolean d() {
        return this.f75318b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpecialDay) {
            SpecialDay specialDay = (SpecialDay) obj;
            if (this.f75317a.equals(specialDay.c()) && this.f75318b == specialDay.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f75317a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f75318b ? 1237 : 1231);
    }

    public final String toString() {
        String string = this.f75317a.toString();
        int length = string.length();
        boolean z2 = this.f75318b;
        StringBuilder sb = new StringBuilder(length + 30 + String.valueOf(z2).length() + 1);
        sb.append("SpecialDay{date=");
        sb.append(string);
        sb.append(", exceptional=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}

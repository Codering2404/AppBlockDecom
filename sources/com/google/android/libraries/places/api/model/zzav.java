package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.OpeningHours;
import java.time.Instant;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzav extends OpeningHours {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OpeningHours.HoursType f75111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f75113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f75114d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Boolean f75115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Instant f75116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Instant f75117h;

    zzav(OpeningHours.HoursType hoursType, List list, List list2, List list3, Boolean bool, Instant instant, Instant instant2) {
        this.f75111a = hoursType;
        if (list == null) {
            throw new NullPointerException("Null periods");
        }
        this.f75112b = list;
        if (list2 == null) {
            throw new NullPointerException("Null specialDays");
        }
        this.f75113c = list2;
        if (list3 == null) {
            throw new NullPointerException("Null weekdayText");
        }
        this.f75114d = list3;
        this.f75115f = bool;
        this.f75116g = instant;
        this.f75117h = instant2;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public OpeningHours.HoursType d() {
        return this.f75111a;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public List e() {
        return this.f75112b;
    }

    public final boolean equals(Object obj) {
        Boolean bool;
        Instant instant;
        Instant instant2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpeningHours) {
            OpeningHours openingHours = (OpeningHours) obj;
            OpeningHours.HoursType hoursType = this.f75111a;
            if (hoursType != null ? hoursType.equals(openingHours.d()) : openingHours.d() == null) {
                if (this.f75112b.equals(openingHours.e()) && this.f75113c.equals(openingHours.f()) && this.f75114d.equals(openingHours.g()) && ((bool = this.f75115f) != null ? bool.equals(openingHours.h()) : openingHours.h() == null) && ((instant = this.f75116g) != null ? instant.equals(openingHours.i()) : openingHours.i() == null) && ((instant2 = this.f75117h) != null ? instant2.equals(openingHours.j()) : openingHours.j() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public List f() {
        return this.f75113c;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public List g() {
        return this.f75114d;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public final Boolean h() {
        return this.f75115f;
    }

    public final int hashCode() {
        OpeningHours.HoursType hoursType = this.f75111a;
        int iHashCode = (((((((hoursType == null ? 0 : hoursType.hashCode()) ^ 1000003) * 1000003) ^ this.f75112b.hashCode()) * 1000003) ^ this.f75113c.hashCode()) * 1000003) ^ this.f75114d.hashCode();
        Boolean bool = this.f75115f;
        int iHashCode2 = ((iHashCode * 1000003) ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Instant instant = this.f75116g;
        int iHashCode3 = (iHashCode2 ^ (instant == null ? 0 : instant.hashCode())) * 1000003;
        Instant instant2 = this.f75117h;
        return iHashCode3 ^ (instant2 != null ? instant2.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public final Instant i() {
        return this.f75116g;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours
    public final Instant j() {
        return this.f75117h;
    }

    public final String toString() {
        Instant instant = this.f75117h;
        Instant instant2 = this.f75116g;
        List list = this.f75114d;
        List list2 = this.f75113c;
        List list3 = this.f75112b;
        String strValueOf = String.valueOf(this.f75111a);
        String string = list3.toString();
        String string2 = list2.toString();
        String string3 = list.toString();
        String strValueOf2 = String.valueOf(instant2);
        String strValueOf3 = String.valueOf(instant);
        int length = strValueOf.length();
        int length2 = string.length();
        int length3 = string2.length();
        int length4 = string3.length();
        Boolean bool = this.f75115f;
        int length5 = String.valueOf(bool).length();
        StringBuilder sb = new StringBuilder(length + 33 + length2 + 14 + length3 + 14 + length4 + 10 + length5 + 11 + strValueOf2.length() + 12 + strValueOf3.length() + 1);
        sb.append("OpeningHours{hoursType=");
        sb.append(strValueOf);
        sb.append(", periods=");
        sb.append(string);
        sb.append(", specialDays=");
        sb.append(string2);
        sb.append(", weekdayText=");
        sb.append(string3);
        sb.append(", openNow=");
        sb.append(bool);
        sb.append(", nextOpen=");
        sb.append(strValueOf2);
        sb.append(", nextClose=");
        sb.append(strValueOf3);
        sb.append("}");
        return sb.toString();
    }
}

package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.OpeningHours;
import java.time.Instant;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzau extends OpeningHours.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OpeningHours.HoursType f75104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f75105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f75106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f75107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f75108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Instant f75109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Instant f75110g;

    zzau() {
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder b(OpeningHours.HoursType hoursType) {
        this.f75104a = hoursType;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder c(List list) {
        if (list == null) {
            throw new NullPointerException("Null periods");
        }
        this.f75105b = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder d(List list) {
        if (list == null) {
            throw new NullPointerException("Null specialDays");
        }
        this.f75106c = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder e(List list) {
        if (list == null) {
            throw new NullPointerException("Null weekdayText");
        }
        this.f75107d = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder f(Boolean bool) {
        this.f75108e = bool;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder g(Instant instant) {
        this.f75109f = instant;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    public final OpeningHours.Builder h(Instant instant) {
        this.f75110g = instant;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.OpeningHours.Builder
    final OpeningHours i() {
        List list;
        List list2;
        List list3 = this.f75105b;
        if (list3 != null && (list = this.f75106c) != null && (list2 = this.f75107d) != null) {
            return new zzeg(this.f75104a, list3, list, list2, this.f75108e, this.f75109f, this.f75110g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75105b == null) {
            sb.append(" periods");
        }
        if (this.f75106c == null) {
            sb.append(" specialDays");
        }
        if (this.f75107d == null) {
            sb.append(" weekdayText");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}

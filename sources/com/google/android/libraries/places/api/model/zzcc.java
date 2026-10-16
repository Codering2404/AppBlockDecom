package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.TimeOfWeek;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcc extends TimeOfWeek.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocalDate f75326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DayOfWeek f75327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LocalTime f75328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f75329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f75330e;

    zzcc() {
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek.Builder
    public final TimeOfWeek a() {
        DayOfWeek dayOfWeek;
        LocalTime localTime;
        if (this.f75330e == 1 && (dayOfWeek = this.f75327b) != null && (localTime = this.f75328c) != null) {
            return new zzfq(this.f75326a, dayOfWeek, localTime, this.f75329d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75327b == null) {
            sb.append(" day");
        }
        if (this.f75328c == null) {
            sb.append(" time");
        }
        if (this.f75330e == 0) {
            sb.append(" truncated");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek.Builder
    public final TimeOfWeek.Builder b(LocalDate localDate) {
        this.f75326a = localDate;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek.Builder
    public final TimeOfWeek.Builder c(LocalTime localTime) {
        if (localTime == null) {
            throw new NullPointerException("Null time");
        }
        this.f75328c = localTime;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.TimeOfWeek.Builder
    public final TimeOfWeek.Builder d(boolean z2) {
        this.f75329d = z2;
        this.f75330e = (byte) 1;
        return this;
    }

    public final TimeOfWeek.Builder e(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) {
            throw new NullPointerException("Null day");
        }
        this.f75327b = dayOfWeek;
        return this;
    }
}

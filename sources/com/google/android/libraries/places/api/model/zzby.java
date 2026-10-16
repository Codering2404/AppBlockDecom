package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.SpecialDay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzby extends SpecialDay.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocalDate f75314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f75315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f75316c;

    zzby() {
    }

    @Override // com.google.android.libraries.places.api.model.SpecialDay.Builder
    public final SpecialDay a() {
        LocalDate localDate;
        if (this.f75316c == 1 && (localDate = this.f75314a) != null) {
            return new zzfm(localDate, this.f75315b);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75314a == null) {
            sb.append(" date");
        }
        if (this.f75316c == 0) {
            sb.append(" exceptional");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.SpecialDay.Builder
    public final SpecialDay.Builder b(boolean z2) {
        this.f75315b = z2;
        this.f75316c = (byte) 1;
        return this;
    }

    public final SpecialDay.Builder c(LocalDate localDate) {
        if (localDate == null) {
            throw new NullPointerException("Null date");
        }
        this.f75314a = localDate;
        return this;
    }
}

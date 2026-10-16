package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.Period;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzba extends Period.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TimeOfWeek f75144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TimeOfWeek f75145b;

    zzba() {
    }

    @Override // com.google.android.libraries.places.api.model.Period.Builder
    public final Period a() {
        return new zzem(this.f75144a, this.f75145b);
    }

    @Override // com.google.android.libraries.places.api.model.Period.Builder
    public final Period.Builder b(TimeOfWeek timeOfWeek) {
        this.f75145b = timeOfWeek;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Period.Builder
    public final Period.Builder c(TimeOfWeek timeOfWeek) {
        this.f75144a = timeOfWeek;
        return this;
    }
}

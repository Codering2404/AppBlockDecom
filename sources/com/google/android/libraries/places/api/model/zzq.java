package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.ConsumerAlert;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzq extends ConsumerAlert.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConsumerAlertDetails f75389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f75390c;

    zzq() {
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert.Builder
    public final ConsumerAlert a() {
        return new zzda(this.f75388a, this.f75389b, this.f75390c);
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert.Builder
    public final ConsumerAlert.Builder b(ConsumerAlertDetails consumerAlertDetails) {
        this.f75389b = consumerAlertDetails;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert.Builder
    public final ConsumerAlert.Builder c(String str) {
        this.f75390c = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert.Builder
    public final ConsumerAlert.Builder d(String str) {
        this.f75388a = str;
        return this;
    }
}

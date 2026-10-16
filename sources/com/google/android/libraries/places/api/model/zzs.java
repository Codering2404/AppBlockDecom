package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.ConsumerAlertDetails;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzs extends ConsumerAlertDetails.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f75396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f75397d;

    zzs() {
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails.Builder
    public final ConsumerAlertDetails a() {
        return new zzdc(this.f75394a, this.f75395b, this.f75396c, this.f75397d);
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails.Builder
    public final ConsumerAlertDetails.Builder b(String str) {
        this.f75396c = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails.Builder
    public final ConsumerAlertDetails.Builder c(Uri uri) {
        this.f75397d = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails.Builder
    public final ConsumerAlertDetails.Builder d(String str) {
        this.f75395b = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlertDetails.Builder
    public final ConsumerAlertDetails.Builder e(String str) {
        this.f75394a = str;
        return this;
    }
}

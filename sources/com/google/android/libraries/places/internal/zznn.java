package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznn extends zznr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f78285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImmutableList f78286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Place f78287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AutocompletePrediction f78288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AutocompleteSessionToken f78289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Status f78290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f78291g;

    zznn() {
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zznr a(String str) {
        this.f78285a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zznr b(List list) {
        this.f78286b = list == null ? null : ImmutableList.t(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zznr c(Place place) {
        this.f78287c = place;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zznr d(AutocompletePrediction autocompletePrediction) {
        this.f78288d = autocompletePrediction;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zznr e(AutocompleteSessionToken autocompleteSessionToken) {
        this.f78289e = autocompleteSessionToken;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zznr f(Status status) {
        this.f78290f = status;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zznr
    public final zzns g() {
        int i3 = this.f78291g;
        if (i3 != 0) {
            return new zzno(i3, this.f78285a, this.f78286b, this.f78287c, this.f78288d, this.f78289e, this.f78290f, null);
        }
        throw new IllegalStateException("Missing required properties: type");
    }

    public final zznr h(int i3) {
        this.f78291g = i3;
        return this;
    }
}

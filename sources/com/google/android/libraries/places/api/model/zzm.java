package com.google.android.libraries.places.api.model;

import android.os.ParcelUuid;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzm extends AutocompleteSessionToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParcelUuid f75373a;

    zzm(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            throw new NullPointerException("Null UUID");
        }
        this.f75373a = parcelUuid;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompleteSessionToken
    final ParcelUuid d() {
        return this.f75373a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompleteSessionToken) {
            return this.f75373a.equals(((AutocompleteSessionToken) obj).d());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75373a.hashCode() ^ 1000003;
    }
}

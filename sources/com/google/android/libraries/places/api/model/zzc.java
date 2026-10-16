package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.AddressComponent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzc extends AddressComponent.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f75321c;

    zzc() {
    }

    @Override // com.google.android.libraries.places.api.model.AddressComponent.Builder
    public final AddressComponent.Builder b(String str) {
        this.f75320b = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AddressComponent.Builder
    final AddressComponent.Builder c(List list) {
        if (list == null) {
            throw new NullPointerException("Null types");
        }
        this.f75321c = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AddressComponent.Builder
    final AddressComponent d() {
        List list;
        String str = this.f75319a;
        if (str != null && (list = this.f75321c) != null) {
            return new zzci(str, this.f75320b, list);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75319a == null) {
            sb.append(" name");
        }
        if (this.f75321c == null) {
            sb.append(" types");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    final AddressComponent.Builder e(String str) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f75319a = str;
        return this;
    }
}

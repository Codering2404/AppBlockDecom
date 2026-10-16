package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.SubDestination;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzca extends SubDestination.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75323b;

    zzca() {
    }

    @Override // com.google.android.libraries.places.api.model.SubDestination.Builder
    public final SubDestination a() {
        String str;
        String str2 = this.f75322a;
        if (str2 != null && (str = this.f75323b) != null) {
            return new zzfo(str2, str);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75322a == null) {
            sb.append(" id");
        }
        if (this.f75323b == null) {
            sb.append(" name");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.model.SubDestination.Builder
    public final SubDestination.Builder b(String str) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f75323b = str;
        return this;
    }

    public final SubDestination.Builder c(String str) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.f75322a = str;
        return this;
    }
}

package com.google.android.recaptcha.internal;

import com.facebook.ads.AdError;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzlq implements zznf {
    EDITION_UNKNOWN(0),
    EDITION_LEGACY(900),
    EDITION_PROTO2(998),
    EDITION_PROTO3(999),
    EDITION_2023(1000),
    EDITION_2024(AdError.NO_FILL_ERROR_CODE),
    EDITION_1_TEST_ONLY(1),
    EDITION_2_TEST_ONLY(2),
    EDITION_99997_TEST_ONLY(99997),
    EDITION_99998_TEST_ONLY(99998),
    EDITION_99999_TEST_ONLY(99999),
    EDITION_MAX(Api.BaseClientBuilder.API_PRIORITY_OTHER);

    private final int zzn;

    zzlq(int i3) {
        this.zzn = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzn);
    }

    @Override // com.google.android.recaptcha.internal.zznf
    public final int zza() {
        return this.zzn;
    }
}

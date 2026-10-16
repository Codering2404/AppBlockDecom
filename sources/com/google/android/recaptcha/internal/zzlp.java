package com.google.android.recaptcha.internal;

import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzlp implements zznh {
    static final zznh zza = new zzlp();

    private zzlp() {
    }

    @Override // com.google.android.recaptcha.internal.zznh
    public final boolean zza(int i3) {
        zzlq zzlqVar;
        zzlq zzlqVar2 = zzlq.EDITION_UNKNOWN;
        if (i3 == 0) {
            zzlqVar = zzlq.EDITION_UNKNOWN;
        } else if (i3 == 1) {
            zzlqVar = zzlq.EDITION_1_TEST_ONLY;
        } else if (i3 == 2) {
            zzlqVar = zzlq.EDITION_2_TEST_ONLY;
        } else if (i3 == 900) {
            zzlqVar = zzlq.EDITION_LEGACY;
        } else if (i3 != Integer.MAX_VALUE) {
            switch (i3) {
                case 998:
                    zzlqVar = zzlq.EDITION_PROTO2;
                    break;
                case 999:
                    zzlqVar = zzlq.EDITION_PROTO3;
                    break;
                case 1000:
                    zzlqVar = zzlq.EDITION_2023;
                    break;
                case AdError.NO_FILL_ERROR_CODE /* 1001 */:
                    zzlqVar = zzlq.EDITION_2024;
                    break;
                default:
                    switch (i3) {
                        case 99997:
                            zzlqVar = zzlq.EDITION_99997_TEST_ONLY;
                            break;
                        case 99998:
                            zzlqVar = zzlq.EDITION_99998_TEST_ONLY;
                            break;
                        case 99999:
                            zzlqVar = zzlq.EDITION_99999_TEST_ONLY;
                            break;
                        default:
                            zzlqVar = null;
                            break;
                    }
                    break;
            }
        } else {
            zzlqVar = zzlq.EDITION_MAX;
        }
        return zzlqVar != null;
    }
}

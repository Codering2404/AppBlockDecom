package com.google.android.libraries.places.internal;

import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzald implements zzbdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zzbdw f75670a = new zzald();

    private zzald() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdw
    public final boolean zza(int i3) {
        if (i3 == 0) {
            return true;
        }
        switch (i3) {
            case 1000:
            case AdError.NO_FILL_ERROR_CODE /* 1001 */:
            case 1002:
            case 1003:
                return true;
            default:
                return false;
        }
    }
}

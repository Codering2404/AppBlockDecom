package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzihu implements zziek {
    static final zziek zza = new zzihu();

    private zzihu() {
    }

    @Override // com.google.android.gms.internal.ads.zziek
    public final boolean zza(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 1999) {
            switch (i3) {
                case 1000:
                case AdError.NO_FILL_ERROR_CODE /* 1001 */:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case CloseCodes.CLOSED_ABNORMALLY /* 1006 */:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}

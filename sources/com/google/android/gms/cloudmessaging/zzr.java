package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzr extends zzs {
    zzr(int i3, int i4, Bundle bundle) {
        super(i3, i4, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new zzt(4, "Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    final boolean b() {
        return true;
    }
}

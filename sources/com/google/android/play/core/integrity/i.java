package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class i implements k {
    i() {
    }

    @Override // com.google.android.play.core.integrity.k
    public final ApiException a(Bundle bundle) {
        int i3 = bundle.getInt("error");
        if (i3 == 0) {
            return null;
        }
        return new IntegrityServiceException(i3, null);
    }
}

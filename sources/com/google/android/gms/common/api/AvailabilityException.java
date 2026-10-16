package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AvailabilityException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap f71487a;

    public AvailabilityException(ArrayMap arrayMap) {
        this.f71487a = arrayMap;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (ApiKey apiKey : this.f71487a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.m((ConnectionResult) this.f71487a.get(apiKey));
            z2 &= !connectionResult.w0();
            arrayList.add(apiKey.b() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}

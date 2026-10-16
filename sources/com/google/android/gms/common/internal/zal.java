package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseIntArray f72062a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GoogleApiAvailabilityLight f72063b;

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        Preconditions.m(googleApiAvailabilityLight);
        this.f72063b = googleApiAvailabilityLight;
    }

    public final int a(Context context, int i3) {
        return this.f72062a.get(i3, -1);
    }

    public final int b(Context context, Api.Client client) {
        Preconditions.m(context);
        Preconditions.m(client);
        int iJ = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int iA = a(context, minApkVersion);
        if (iA != -1) {
            return iA;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f72062a.size()) {
                iJ = -1;
                break;
            }
            int iKeyAt = this.f72062a.keyAt(i3);
            if (iKeyAt > minApkVersion && this.f72062a.get(iKeyAt) == 0) {
                break;
            }
            i3++;
        }
        if (iJ == -1) {
            iJ = this.f72063b.j(context, minApkVersion);
        }
        this.f72062a.put(minApkVersion, iJ);
        return iJ;
    }

    public final void c() {
        this.f72062a.clear();
    }
}

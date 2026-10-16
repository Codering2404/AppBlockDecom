package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap f71845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap f71846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource f71847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f71848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f71849e;

    public final Set a() {
        return this.f71845a.keySet();
    }

    public final void b(ApiKey apiKey, ConnectionResult connectionResult, String str) {
        this.f71845a.put(apiKey, connectionResult);
        this.f71846b.put(apiKey, str);
        this.f71848d--;
        if (!connectionResult.w0()) {
            this.f71849e = true;
        }
        if (this.f71848d == 0) {
            if (!this.f71849e) {
                this.f71847c.setResult(this.f71846b);
            } else {
                this.f71847c.setException(new AvailabilityException(this.f71845a));
            }
        }
    }
}

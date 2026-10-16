package com.android.billingclient.api;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DeveloperBillingOptionParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f57239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f57240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f57241c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
    }

    public int a() {
        return this.f57241c;
    }

    public int b() {
        return this.f57240b;
    }

    public Uri c() {
        return this.f57239a;
    }
}

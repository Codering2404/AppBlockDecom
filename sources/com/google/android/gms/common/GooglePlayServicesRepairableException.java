package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71457b;

    public GooglePlayServicesRepairableException(int i3, String str, Intent intent) {
        super(str, intent);
        this.f71457b = i3;
    }

    public int a() {
        return this.f71457b;
    }
}

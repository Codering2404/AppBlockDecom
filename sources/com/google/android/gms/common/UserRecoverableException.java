package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class UserRecoverableException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Intent f71475a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f71475a = intent;
    }
}

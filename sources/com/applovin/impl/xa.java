package com.applovin.impl;

import com.applovin.impl.af;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class xa implements af.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64884a;

    public xa(String str) {
        this.f64884a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f64884a;
    }
}

package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SubDestination implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract SubDestination a();

        public abstract Builder b(String str);
    }

    public static SubDestination d(String str, String str2) {
        zzca zzcaVar = new zzca();
        zzcaVar.c(str);
        zzcaVar.b(str2);
        return zzcaVar.a();
    }

    public abstract String c();

    public abstract String getName();
}

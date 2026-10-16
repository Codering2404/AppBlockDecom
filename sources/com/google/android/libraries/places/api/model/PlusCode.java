package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class PlusCode implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract PlusCode a();

        public abstract Builder b(String str);

        public abstract Builder c(String str);
    }

    public static Builder c() {
        return new zzbh();
    }

    public abstract String d();

    public abstract String e();
}

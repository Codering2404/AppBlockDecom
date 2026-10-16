package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Period implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract Period a();

        public abstract Builder b(TimeOfWeek timeOfWeek);

        public abstract Builder c(TimeOfWeek timeOfWeek);
    }

    public static Builder c() {
        return new zzba();
    }

    public abstract TimeOfWeek d();

    public abstract TimeOfWeek e();
}

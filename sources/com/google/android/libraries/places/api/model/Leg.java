package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Leg implements Parcelable {
    public static Leg e(Duration duration, int i3) {
        return new zzdw(duration, i3);
    }

    public abstract int c();

    public abstract Duration d();
}

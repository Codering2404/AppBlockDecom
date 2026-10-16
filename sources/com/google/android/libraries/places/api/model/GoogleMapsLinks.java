package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class GoogleMapsLinks implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract GoogleMapsLinks a();

        public abstract Builder b(Uri uri);

        public abstract Builder c(Uri uri);

        public abstract Builder d(Uri uri);

        public abstract Builder e(Uri uri);

        public abstract Builder f(Uri uri);
    }

    public static Builder c() {
        return new zzaj();
    }

    public abstract Uri d();

    public abstract Uri e();

    public abstract Uri f();

    public abstract Uri g();

    public abstract Uri h();
}

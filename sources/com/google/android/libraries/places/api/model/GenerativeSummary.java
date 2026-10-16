package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class GenerativeSummary extends zzce implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract GenerativeSummary a();

        public abstract Builder b(String str);

        public abstract Builder c(String str);

        public abstract Builder d(Uri uri);

        public abstract Builder e(String str);

        public abstract Builder f(String str);
    }

    public static Builder c() {
        return new zzah();
    }

    public abstract String d();

    public abstract String e();

    public abstract Uri f();

    public abstract String g();

    public abstract String h();
}

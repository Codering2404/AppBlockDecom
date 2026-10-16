package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NeighborhoodSummary extends zzce implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract NeighborhoodSummary a();

        public abstract Builder b(ContentBlock contentBlock);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(Uri uri);

        public abstract Builder f(ContentBlock contentBlock);
    }

    public static Builder c() {
        return new zzas();
    }

    public abstract ContentBlock d();

    public abstract String e();

    public abstract String f();

    public abstract Uri g();

    public abstract ContentBlock h();
}

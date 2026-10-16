package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class EvChargeAmenitySummary extends zzce implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract EvChargeAmenitySummary a();

        public abstract Builder b(ContentBlock contentBlock);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(Uri uri);

        public abstract Builder f(ContentBlock contentBlock);

        public abstract Builder g(ContentBlock contentBlock);
    }

    public static Builder a(ContentBlock contentBlock) {
        zzab zzabVar = new zzab();
        zzabVar.h(contentBlock);
        return zzabVar;
    }

    public abstract ContentBlock c();

    public abstract String d();

    public abstract String e();

    public abstract Uri f();

    public abstract ContentBlock g();

    public abstract ContentBlock h();

    public abstract ContentBlock i();
}

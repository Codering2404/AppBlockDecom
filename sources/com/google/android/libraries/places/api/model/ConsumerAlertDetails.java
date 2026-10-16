package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ConsumerAlertDetails implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ConsumerAlertDetails a();

        public abstract Builder b(String str);

        public abstract Builder c(Uri uri);

        public abstract Builder d(String str);

        public abstract Builder e(String str);
    }

    public static Builder c() {
        return new zzs();
    }

    public abstract String d();

    public abstract Uri e();

    public abstract String f();

    public abstract String g();
}

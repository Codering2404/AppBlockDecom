package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AuthorAttribution implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public AuthorAttribution a() {
            Preconditions.e(!d().getName().isEmpty(), "Name must not be empty.");
            return d();
        }

        public abstract Builder b(String str);

        public abstract Builder c(String str);

        abstract AuthorAttribution d();
    }

    public static Builder a(String str) {
        zzf zzfVar = new zzf();
        zzfVar.e(str);
        return zzfVar;
    }

    public abstract String c();

    public abstract String d();

    public abstract String getName();
}

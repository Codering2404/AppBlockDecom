package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class RoutingSummary implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract RoutingSummary a();

        public RoutingSummary b() {
            e(ImmutableList.t(c()));
            return a();
        }

        public abstract List c();

        public abstract Builder d(Uri uri);

        public abstract Builder e(List list);
    }

    public static Builder a(List list) {
        zzbv zzbvVar = new zzbv();
        zzbvVar.e(list);
        return zzbvVar;
    }

    public abstract Uri c();

    public abstract List d();
}

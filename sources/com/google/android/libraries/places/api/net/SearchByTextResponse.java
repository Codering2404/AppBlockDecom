package com.google.android.libraries.places.api.net;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SearchByTextResponse implements SearchResponse {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract SearchByTextResponse a();

        public SearchByTextResponse b() {
            f(ImmutableList.t(c()));
            List listD = d();
            if (listD != null) {
                g(ImmutableList.t(listD));
            }
            return a();
        }

        public abstract List c();

        public abstract List d();

        public abstract Builder e(Pagination pagination);

        public abstract Builder f(List list);

        public abstract Builder g(List list);

        public abstract Builder h(Uri uri);

        public abstract Builder i(String str);

        public abstract Builder j(int i3);
    }

    public static Builder a(List list) {
        zzu zzuVar = new zzu();
        zzuVar.f(list);
        zzuVar.j(1);
        return zzuVar;
    }

    public abstract Pagination b();

    public abstract List c();

    public abstract List d();

    public abstract Uri e();

    public abstract String f();

    public abstract int g();
}

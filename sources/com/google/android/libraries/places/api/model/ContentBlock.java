package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ContentBlock implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public ContentBlock a() {
            List listF = f();
            if (listF != null) {
                e(ImmutableList.t(listF));
            }
            List listG = g();
            if (listG != null) {
                d(ImmutableList.t(listG));
            }
            return h();
        }

        public abstract Builder b(String str);

        public abstract Builder c(String str);

        public abstract Builder d(List list);

        public abstract Builder e(List list);

        abstract List f();

        abstract List g();

        abstract ContentBlock h();
    }

    public static Builder c() {
        return new zzu();
    }

    public abstract String d();

    public abstract String e();

    public abstract List f();

    public abstract List g();
}

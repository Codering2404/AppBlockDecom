package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzxi;
import com.google.android.libraries.places.internal.zzxj;
import com.google.android.libraries.places.internal.zzxl;
import com.google.android.libraries.places.internal.zzxm;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Review implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public Review a() {
            Double dI = l().i();
            boolean z2 = false;
            if (dI.doubleValue() >= 1.0d && dI.doubleValue() <= 5.0d) {
                z2 = true;
            }
            Preconditions.m(z2, "Rating must between 1.0 and 5.0 (inclusive), but was: %s.", dI);
            return l();
        }

        public abstract Builder b(Uri uri);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(String str);

        public abstract Builder f(String str);

        public abstract Builder g(String str);

        public abstract Builder h(String str);

        public abstract Builder i(LocalDate localDate);

        abstract Builder j(AuthorAttribution authorAttribution);

        abstract Builder k(String str);

        abstract Review l();
    }

    public static Builder a(Double d3, AuthorAttribution authorAttribution) {
        String strE = Strings.e(authorAttribution.d());
        if (strE.startsWith("//")) {
            strE = "https:".concat(strE);
        }
        zzxj zzxjVar = new zzxj("a");
        int i3 = zzxm.f78835d;
        zzxjVar.a(zzxm.a(strE, zzxl.f78830b));
        zzxjVar.b(authorAttribution.getName());
        zzxi zzxiVarC = zzxjVar.c();
        zzbn zzbnVar = new zzbn();
        zzbnVar.m(d3);
        zzbnVar.j(authorAttribution);
        zzbnVar.k(zzxiVarC.a());
        return zzbnVar;
    }

    public abstract String c();

    public abstract AuthorAttribution d();

    public abstract Uri e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract Double i();

    public abstract String j();

    public abstract String k();

    public abstract String l();

    public abstract LocalDate m();
}

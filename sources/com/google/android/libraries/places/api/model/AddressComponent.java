package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AddressComponent implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public AddressComponent a() {
            AddressComponent addressComponentD = d();
            Preconditions.e(!addressComponentD.getName().isEmpty(), "Name must not be empty.");
            List listD = addressComponentD.d();
            Iterator it = listD.iterator();
            while (it.hasNext()) {
                Preconditions.e(!TextUtils.isEmpty((String) it.next()), "Types must not contain null or empty values.");
            }
            c(ImmutableList.t(listD));
            return d();
        }

        public abstract Builder b(String str);

        abstract Builder c(List list);

        abstract AddressComponent d();
    }

    public static Builder a(String str, List list) {
        zzc zzcVar = new zzc();
        zzcVar.e(str);
        zzcVar.c(list);
        return zzcVar;
    }

    public abstract String c();

    public abstract List d();

    public abstract String getName();
}

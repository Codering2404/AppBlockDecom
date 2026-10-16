package com.google.android.libraries.places.api.net;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class FindCurrentPlaceResponse {
    public static FindCurrentPlaceResponse b(List list) {
        return new zzo(ImmutableList.t(list));
    }

    public abstract List a();
}

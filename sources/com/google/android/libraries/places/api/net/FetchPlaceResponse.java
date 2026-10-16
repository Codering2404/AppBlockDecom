package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FetchPlaceResponse {
    public static FetchPlaceResponse b(Place place) {
        return new zzf(place);
    }

    public abstract Place a();
}

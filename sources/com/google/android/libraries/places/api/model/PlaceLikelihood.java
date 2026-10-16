package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.base.Preconditions;
import com.google.common.collect.Range;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class PlaceLikelihood implements Parcelable {
    public static PlaceLikelihood e(Place place, double d3) {
        Double dValueOf = Double.valueOf(0.0d);
        Double dValueOf2 = Double.valueOf(1.0d);
        Range rangeF = Range.f(dValueOf, dValueOf2);
        Double dValueOf3 = Double.valueOf(d3);
        Preconditions.p(rangeF.i(dValueOf3), "Likelihood must not be out-of-range: %s to %s, but was: %s.", dValueOf, dValueOf2, dValueOf3);
        return new zzes(place, d3);
    }

    public abstract double c();

    public abstract Place d();
}

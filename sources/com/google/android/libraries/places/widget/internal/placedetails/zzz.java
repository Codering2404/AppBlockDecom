package com.google.android.libraries.places.widget.internal.placedetails;

import com.google.android.libraries.places.api.model.FuelPrice;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzz {
    public static final boolean a(FuelPrice.FuelType fuelType) {
        Intrinsics.checkNotNullParameter(fuelType, "<this>");
        return fuelType == FuelPrice.FuelType.REGULAR_UNLEADED || fuelType == FuelPrice.FuelType.MIDGRADE || fuelType == FuelPrice.FuelType.PREMIUM || fuelType == FuelPrice.FuelType.DIESEL;
    }

    public static final boolean b(FuelPrice fuelPrice, Instant instant) {
        Intrinsics.checkNotNullParameter(fuelPrice, "<this>");
        if (instant == null) {
            return false;
        }
        Instant instantMinus = instant.minus(24L, (TemporalUnit) ChronoUnit.HOURS);
        Intrinsics.checkNotNullExpressionValue(instantMinus, "minus(...)");
        return fuelPrice.e().isBefore(instantMinus);
    }
}

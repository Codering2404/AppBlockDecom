package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.ConnectorAggregation;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzu {
    public static final String a(List list, Context context, Instant instant) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (instant == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Instant instantC = ((ConnectorAggregation) it.next()).c();
            if (instantC != null) {
                arrayList.add(instantC);
            }
        }
        Instant instant2 = (Instant) CollectionsKt.maxOrNull((Iterable) arrayList);
        if (instant2 == null) {
            return null;
        }
        Duration durationBetween = Duration.between(instant2, instant);
        Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
        if (durationBetween.toDays() > 0) {
            return context.getString(R.string.f74827b1, Long.valueOf(durationBetween.toDays()));
        }
        if (durationBetween.toHours() > 0) {
            return context.getString(R.string.f74830c1, Long.valueOf(durationBetween.toHours()));
        }
        if (durationBetween.toMinutes() > 0) {
            return context.getString(R.string.f74833d1, Long.valueOf(durationBetween.toMinutes()));
        }
        if (durationBetween.toMillis() / 1000 < 0) {
            return null;
        }
        return context.getString(R.string.f74836e1);
    }
}

package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TimeOfWeek implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract TimeOfWeek a();

        public abstract Builder b(LocalDate localDate);

        public abstract Builder c(LocalTime localTime);

        public abstract Builder d(boolean z2);
    }

    public static Builder a(DayOfWeek dayOfWeek, LocalTime localTime) {
        zzcc zzccVar = new zzcc();
        zzccVar.e(dayOfWeek);
        zzccVar.c(localTime);
        zzccVar.d(false);
        return zzccVar;
    }

    public static TimeOfWeek g(DayOfWeek dayOfWeek, LocalTime localTime) {
        return a(dayOfWeek, localTime).a();
    }

    public abstract LocalDate c();

    public abstract DayOfWeek d();

    public abstract LocalTime e();

    public abstract boolean f();
}

package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Money implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public Money a() {
            long jLongValue = c().longValue();
            Integer numB = b();
            if (jLongValue > 0) {
                Preconditions.m(numB.intValue() >= 0, "Unit is positive and nano must be positive or zero, but was: %s.", numB);
            } else if (jLongValue < 0) {
                Preconditions.m(numB.intValue() <= 0, "Unit is negative and nano must be negative or zero, but was: %s.", numB);
            }
            return f();
        }

        public abstract Integer b();

        public abstract Long c();

        public abstract Builder d(Integer num);

        public abstract Builder e(Long l3);

        abstract Money f();
    }

    public static Money f(String str, Long l3, Integer num) {
        zzaq zzaqVar = new zzaq();
        zzaqVar.g(str);
        zzaqVar.e(l3);
        zzaqVar.d(num);
        return zzaqVar.a();
    }

    public abstract String c();

    public abstract Integer d();

    public abstract Long e();
}

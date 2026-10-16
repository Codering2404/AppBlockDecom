package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class OpeningHours implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public OpeningHours a() {
            OpeningHours openingHoursI = i();
            Iterator it = openingHoursI.g().iterator();
            while (it.hasNext()) {
                Preconditions.e(!TextUtils.isEmpty((String) it.next()), "WeekdayText must not contain null or empty values.");
            }
            c(ImmutableList.t(openingHoursI.e()));
            e(ImmutableList.t(openingHoursI.g()));
            d(ImmutableList.t(openingHoursI.f()));
            return i();
        }

        public abstract Builder b(HoursType hoursType);

        public abstract Builder c(List list);

        public abstract Builder d(List list);

        public abstract Builder e(List list);

        public abstract Builder f(Boolean bool);

        public abstract Builder g(Instant instant);

        public abstract Builder h(Instant instant);

        abstract OpeningHours i();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum HoursType implements Parcelable {
        ACCESS,
        BREAKFAST,
        f74953c,
        DELIVERY,
        DINNER,
        DRIVE_THROUGH,
        HAPPY_HOUR,
        KITCHEN,
        LUNCH,
        ONLINE_SERVICE_HOURS,
        PICKUP,
        SENIOR_HOURS,
        TAKEOUT;

        public static final Parcelable.Creator<HoursType> CREATOR = new zzfy();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    public static Builder c() {
        zzau zzauVar = new zzau();
        zzauVar.c(new ArrayList());
        zzauVar.d(new ArrayList());
        zzauVar.e(new ArrayList());
        return zzauVar;
    }

    public abstract HoursType d();

    public abstract List e();

    public abstract List f();

    public abstract List g();

    public abstract Boolean h();

    public abstract Instant i();

    public abstract Instant j();
}

package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import com.facebook.ads.AdError;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() { // from class: com.google.android.material.datepicker.CalendarConstraints.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i3) {
            return new CalendarConstraints[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Month f80740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Month f80741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DateValidator f80742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Month f80743d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f80744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f80745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f80746h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f80747f = UtcDates.a(Month.c(1900, 0).f80870g);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final long f80748g = UtcDates.a(Month.c(AdError.BROKEN_MEDIA_ERROR_CODE, 11).f80870g);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f80749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f80750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f80751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f80752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private DateValidator f80753e;

        Builder(CalendarConstraints calendarConstraints) {
            this.f80749a = f80747f;
            this.f80750b = f80748g;
            this.f80753e = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f80749a = calendarConstraints.f80740a.f80870g;
            this.f80750b = calendarConstraints.f80741b.f80870g;
            this.f80751c = Long.valueOf(calendarConstraints.f80743d.f80870g);
            this.f80752d = calendarConstraints.f80744f;
            this.f80753e = calendarConstraints.f80742c;
        }

        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f80753e);
            Month monthD = Month.d(this.f80749a);
            Month monthD2 = Month.d(this.f80750b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.f80751c;
            return new CalendarConstraints(monthD, monthD2, dateValidator, l3 == null ? null : Month.d(l3.longValue()), this.f80752d);
        }

        public Builder b(long j3) {
            this.f80751c = Long.valueOf(j3);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DateValidator extends Parcelable {
        boolean O0(long j3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f80740a.equals(calendarConstraints.f80740a) && this.f80741b.equals(calendarConstraints.f80741b) && ObjectsCompat.a(this.f80743d, calendarConstraints.f80743d) && this.f80744f == calendarConstraints.f80744f && this.f80742c.equals(calendarConstraints.f80742c);
    }

    Month g(Month month) {
        return month.compareTo(this.f80740a) < 0 ? this.f80740a : month.compareTo(this.f80741b) > 0 ? this.f80741b : month;
    }

    public DateValidator h() {
        return this.f80742c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f80740a, this.f80741b, this.f80743d, Integer.valueOf(this.f80744f), this.f80742c});
    }

    Month i() {
        return this.f80741b;
    }

    int j() {
        return this.f80744f;
    }

    int k() {
        return this.f80746h;
    }

    Month l() {
        return this.f80743d;
    }

    Month m() {
        return this.f80740a;
    }

    int n() {
        return this.f80745g;
    }

    boolean o(long j3) {
        if (this.f80740a.g(1) > j3) {
            return false;
        }
        Month month = this.f80741b;
        return j3 <= month.g(month.f80869f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f80740a, 0);
        parcel.writeParcelable(this.f80741b, 0);
        parcel.writeParcelable(this.f80743d, 0);
        parcel.writeParcelable(this.f80742c, 0);
        parcel.writeInt(this.f80744f);
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i3) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f80740a = month;
        this.f80741b = month2;
        this.f80743d = month3;
        this.f80744f = i3;
        this.f80742c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i3 < 0 || i3 > UtcDates.m().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f80746h = month.l(month2) + 1;
        this.f80745g = (month2.f80867c - month.f80867c) + 1;
    }
}

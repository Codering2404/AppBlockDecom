package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i3) {
            return new Month[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f80865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f80866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f80867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f80868d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f80869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f80870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f80871h;

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarE = UtcDates.e(calendar);
        this.f80865a = calendarE;
        this.f80866b = calendarE.get(2);
        this.f80867c = calendarE.get(1);
        this.f80868d = calendarE.getMaximum(7);
        this.f80869f = calendarE.getActualMaximum(5);
        this.f80870g = calendarE.getTimeInMillis();
    }

    static Month c(int i3, int i4) {
        Calendar calendarM = UtcDates.m();
        calendarM.set(1, i3);
        calendarM.set(2, i4);
        return new Month(calendarM);
    }

    static Month d(long j3) {
        Calendar calendarM = UtcDates.m();
        calendarM.setTimeInMillis(j3);
        return new Month(calendarM);
    }

    static Month e() {
        return new Month(UtcDates.k());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.f80865a.compareTo(month.f80865a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f80866b == month.f80866b && this.f80867c == month.f80867c;
    }

    int f(int i3) {
        int i4 = this.f80865a.get(7);
        if (i3 <= 0) {
            i3 = this.f80865a.getFirstDayOfWeek();
        }
        int i5 = i4 - i3;
        return i5 < 0 ? i5 + this.f80868d : i5;
    }

    long g(int i3) {
        Calendar calendarE = UtcDates.e(this.f80865a);
        calendarE.set(5, i3);
        return calendarE.getTimeInMillis();
    }

    int h(long j3) {
        Calendar calendarE = UtcDates.e(this.f80865a);
        calendarE.setTimeInMillis(j3);
        return calendarE.get(5);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f80866b), Integer.valueOf(this.f80867c)});
    }

    String i() {
        if (this.f80871h == null) {
            this.f80871h = DateStrings.l(this.f80865a.getTimeInMillis());
        }
        return this.f80871h;
    }

    long j() {
        return this.f80865a.getTimeInMillis();
    }

    Month k(int i3) {
        Calendar calendarE = UtcDates.e(this.f80865a);
        calendarE.add(2, i3);
        return new Month(calendarE);
    }

    int l(Month month) {
        if (this.f80865a instanceof GregorianCalendar) {
            return ((month.f80867c - this.f80867c) * 12) + (month.f80866b - this.f80866b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f80867c);
        parcel.writeInt(this.f80866b);
    }
}

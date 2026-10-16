package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.R;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() { // from class: com.google.android.material.timepicker.TimeModel.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i3) {
            return new TimeModel[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxInputValidator f82480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxInputValidator f82481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f82482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f82483d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f82484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f82485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f82486h;

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return c(resources, charSequence, "%02d");
    }

    public static String c(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int h(int i3) {
        return i3 >= 12 ? 1 : 0;
    }

    public int d() {
        return this.f82482c == 1 ? R.string.f79711j : R.string.f79713l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        if (this.f82482c == 1) {
            return this.f82483d % 24;
        }
        int i3 = this.f82483d;
        if (i3 % 12 == 0) {
            return 12;
        }
        return this.f82486h == 1 ? i3 - 12 : i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f82483d == timeModel.f82483d && this.f82484f == timeModel.f82484f && this.f82482c == timeModel.f82482c && this.f82485g == timeModel.f82485g;
    }

    public MaxInputValidator f() {
        return this.f82481b;
    }

    public MaxInputValidator g() {
        return this.f82480a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f82482c), Integer.valueOf(this.f82483d), Integer.valueOf(this.f82484f), Integer.valueOf(this.f82485g)});
    }

    public void i(int i3) {
        if (this.f82482c == 1) {
            this.f82483d = i3;
        } else {
            this.f82483d = (i3 % 12) + (this.f82486h != 1 ? 0 : 12);
        }
    }

    public void j(int i3) {
        this.f82484f = i3 % 60;
    }

    public void k(int i3) {
        if (i3 != this.f82486h) {
            this.f82486h = i3;
            int i4 = this.f82483d;
            if (i4 < 12 && i3 == 1) {
                this.f82483d = i4 + 12;
            } else {
                if (i4 < 12 || i3 != 0) {
                    return;
                }
                this.f82483d = i4 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f82483d);
        parcel.writeInt(this.f82484f);
        parcel.writeInt(this.f82485g);
        parcel.writeInt(this.f82482c);
    }

    public TimeModel(int i3) {
        this(0, 0, 10, i3);
    }

    public TimeModel(int i3, int i4, int i5, int i6) {
        this.f82483d = i3;
        this.f82484f = i4;
        this.f82485g = i5;
        this.f82482c = i6;
        this.f82486h = h(i3);
        this.f82480a = new MaxInputValidator(59);
        this.f82481b = new MaxInputValidator(i6 == 1 ? 23 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}

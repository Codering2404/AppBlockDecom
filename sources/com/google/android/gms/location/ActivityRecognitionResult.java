package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List f72855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f72856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f72857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f72858d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Bundle f72859f;

    public ActivityRecognitionResult(List list, long j3, long j4, int i3, Bundle bundle) {
        Preconditions.b((list == null || list.isEmpty()) ? false : true, "Must have at least 1 detected activity");
        Preconditions.b(j3 > 0 && j4 > 0, "Must set times");
        this.f72855a = list;
        this.f72856b = j3;
        this.f72857c = j4;
        this.f72858d = i3;
        this.f72859f = bundle;
    }

    private static boolean M(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!M(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else {
                if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        for (int i3 = 0; i3 < length; i3++) {
                            if (Objects.b(Array.get(obj, i3), Array.get(obj2, i3))) {
                            }
                        }
                    }
                    return false;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f72856b == activityRecognitionResult.f72856b && this.f72857c == activityRecognitionResult.f72857c && this.f72858d == activityRecognitionResult.f72858d && Objects.b(this.f72855a, activityRecognitionResult.f72855a) && M(this.f72859f, activityRecognitionResult.f72859f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(Long.valueOf(this.f72856b), Long.valueOf(this.f72857c), Integer.valueOf(this.f72858d), this.f72855a, this.f72859f);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f72855a);
        long j3 = this.f72856b;
        long j4 = this.f72857c;
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 59 + String.valueOf(j3).length() + 24 + String.valueOf(j4).length() + 1);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(strValueOf);
        sb.append(", timeMillis=");
        sb.append(j3);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j4);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, this.f72855a, false);
        SafeParcelWriter.z(parcel, 2, this.f72856b);
        SafeParcelWriter.z(parcel, 3, this.f72857c);
        SafeParcelWriter.u(parcel, 4, this.f72858d);
        SafeParcelWriter.j(parcel, 5, this.f72859f, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

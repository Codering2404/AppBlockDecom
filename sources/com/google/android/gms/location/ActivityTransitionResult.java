package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new zzi();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f72871b;

    public ActivityTransitionResult(List list) {
        this.f72871b = null;
        Preconditions.n(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i3 = 1; i3 < list.size(); i3++) {
                int i4 = i3 - 1;
                Preconditions.c(((ActivityTransitionEvent) list.get(i3)).N() >= ((ActivityTransitionEvent) list.get(i4)).N(), "Transition out of order: ts1=%d, ts2=%d", Long.valueOf(((ActivityTransitionEvent) list.get(i3)).N()), Long.valueOf(((ActivityTransitionEvent) list.get(i4)).N()));
            }
        }
        this.f72870a = Collections.unmodifiableList(list);
    }

    public List M() {
        return this.f72870a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f72870a.equals(((ActivityTransitionResult) obj).f72870a);
    }

    public int hashCode() {
        return this.f72870a.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, M(), false);
        SafeParcelWriter.j(parcel, 2, this.f72871b, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public ActivityTransitionResult(List list, Bundle bundle) {
        this(list);
        this.f72871b = bundle;
    }
}

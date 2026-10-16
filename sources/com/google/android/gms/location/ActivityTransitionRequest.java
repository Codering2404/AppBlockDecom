package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzh();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Comparator f72865f = new zzg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f72868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f72869d;

    public ActivityTransitionRequest(List list, String str, List list2, String str2) {
        Preconditions.n(list, "transitions can't be null");
        Preconditions.b(!list.isEmpty(), "transitions can't be empty.");
        Preconditions.m(list);
        TreeSet treeSet = new TreeSet(f72865f);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            Preconditions.b(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
        this.f72866a = Collections.unmodifiableList(list);
        this.f72867b = str;
        this.f72868c = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f72869d = str2;
    }

    public final ActivityTransitionRequest M(String str) {
        this.f72869d = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (Objects.b(this.f72866a, activityTransitionRequest.f72866a) && Objects.b(this.f72867b, activityTransitionRequest.f72867b) && Objects.b(this.f72869d, activityTransitionRequest.f72869d) && Objects.b(this.f72868c, activityTransitionRequest.f72868c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f72866a.hashCode() * 31;
        String str = this.f72867b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f72868c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f72869d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        List list = this.f72868c;
        String strValueOf = String.valueOf(this.f72866a);
        String strValueOf2 = String.valueOf(list);
        String str = this.f72869d;
        int length = strValueOf.length();
        String str2 = this.f72867b;
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + strValueOf2.length() + 18 + String.valueOf(str).length() + 1);
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(strValueOf);
        sb.append(", mTag='");
        sb.append(str2);
        sb.append("', mClients=");
        sb.append(strValueOf2);
        sb.append(", mAttributionTag=");
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        List list = this.f72866a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, list, false);
        SafeParcelWriter.G(parcel, 2, this.f72867b, false);
        SafeParcelWriter.K(parcel, 3, this.f72868c, false);
        SafeParcelWriter.G(parcel, 4, this.f72869d, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

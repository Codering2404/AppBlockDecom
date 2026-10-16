package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VersionInfoParcel> CREATOR = new zzy();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f70149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f70152d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f70153f;

    public VersionInfoParcel(int i3, int i4, boolean z2) {
        this(i3, i4, z2, false, false);
    }

    public static VersionInfoParcel M() {
        return new VersionInfoParcel(12451000, 12451000, true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, this.f70149a, false);
        SafeParcelWriter.u(parcel, 3, this.f70150b);
        SafeParcelWriter.u(parcel, 4, this.f70151c);
        SafeParcelWriter.g(parcel, 5, this.f70152d);
        SafeParcelWriter.g(parcel, 6, this.f70153f);
        SafeParcelWriter.b(parcel, iA);
    }

    public VersionInfoParcel(int i3, int i4, boolean z2, boolean z3) {
        this(i3, i4, z2, false, z3);
    }

    public VersionInfoParcel(int i3, int i4, boolean z2, boolean z3, boolean z4) {
        String str;
        if (z2) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = z3 ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 13 + String.valueOf(i4).length() + 2);
        sb.append("afma-sdk-a-v");
        sb.append(i3);
        sb.append(".");
        sb.append(i4);
        sb.append(".");
        sb.append(str);
        this(sb.toString(), i3, i4, z2, z4);
    }

    VersionInfoParcel(String str, int i3, int i4, boolean z2, boolean z3) {
        this.f70149a = str;
        this.f70150b = i3;
        this.f70151c = i4;
        this.f70152d = z2;
        this.f70153f = z3;
    }
}

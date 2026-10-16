package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f70937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f70938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f70939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f70940d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f70941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f70942g;

    AccountChangeEvent(int i3, long j3, String str, int i4, int i5, String str2) {
        this.f70937a = i3;
        this.f70938b = j3;
        this.f70939c = (String) Preconditions.m(str);
        this.f70940d = i4;
        this.f70941f = i5;
        this.f70942g = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f70937a == accountChangeEvent.f70937a && this.f70938b == accountChangeEvent.f70938b && Objects.b(this.f70939c, accountChangeEvent.f70939c) && this.f70940d == accountChangeEvent.f70940d && this.f70941f == accountChangeEvent.f70941f && Objects.b(this.f70942g, accountChangeEvent.f70942g);
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f70937a), Long.valueOf(this.f70938b), this.f70939c, Integer.valueOf(this.f70940d), Integer.valueOf(this.f70941f), this.f70942g);
    }

    public String toString() {
        int i3 = this.f70940d;
        String str = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        return "AccountChangeEvent {accountName = " + this.f70939c + ", changeType = " + str + ", changeData = " + this.f70942g + ", eventIndex = " + this.f70941f + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f70937a);
        SafeParcelWriter.z(parcel, 2, this.f70938b);
        SafeParcelWriter.G(parcel, 3, this.f70939c, false);
        SafeParcelWriter.u(parcel, 4, this.f70940d);
        SafeParcelWriter.u(parcel, 5, this.f70941f);
        SafeParcelWriter.G(parcel, 6, this.f70942g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

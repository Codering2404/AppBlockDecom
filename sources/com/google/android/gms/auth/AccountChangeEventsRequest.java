package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f70943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f70944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f70945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Account f70946d;

    AccountChangeEventsRequest(int i3, int i4, String str, Account account) {
        this.f70943a = i3;
        this.f70944b = i4;
        this.f70945c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f70946d = account;
        } else {
            this.f70946d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f70943a);
        SafeParcelWriter.u(parcel, 2, this.f70944b);
        SafeParcelWriter.G(parcel, 3, this.f70945c, false);
        SafeParcelWriter.E(parcel, 4, this.f70946d, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

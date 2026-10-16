package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzau();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f87811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f87812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f87813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f87814d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f87815f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    UserProfileChangeRequest(String str, String str2, boolean z2, boolean z3) {
        this.f87811a = str;
        this.f87812b = str2;
        this.f87813c = z2;
        this.f87814d = z3;
        this.f87815f = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String M() {
        return this.f87811a;
    }

    public Uri N() {
        return this.f87815f;
    }

    public final boolean O() {
        return this.f87813c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.G(parcel, 3, this.f87812b, false);
        SafeParcelWriter.g(parcel, 4, this.f87813c);
        SafeParcelWriter.g(parcel, 5, this.f87814d);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String zza() {
        return this.f87812b;
    }

    public final boolean zzc() {
        return this.f87814d;
    }
}

package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f70949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f70951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f70952d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f70953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f70954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f70955h;

    TokenData(int i3, String str, Long l3, boolean z2, boolean z3, List list, String str2) {
        this.f70949a = i3;
        this.f70950b = Preconditions.g(str);
        this.f70951c = l3;
        this.f70952d = z2;
        this.f70953f = z3;
        this.f70954g = list;
        this.f70955h = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f70950b, tokenData.f70950b) && Objects.b(this.f70951c, tokenData.f70951c) && this.f70952d == tokenData.f70952d && this.f70953f == tokenData.f70953f && Objects.b(this.f70954g, tokenData.f70954g) && Objects.b(this.f70955h, tokenData.f70955h);
    }

    public final int hashCode() {
        return Objects.c(this.f70950b, this.f70951c, Boolean.valueOf(this.f70952d), Boolean.valueOf(this.f70953f), this.f70954g, this.f70955h);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f70949a);
        SafeParcelWriter.G(parcel, 2, this.f70950b, false);
        SafeParcelWriter.B(parcel, 3, this.f70951c, false);
        SafeParcelWriter.g(parcel, 4, this.f70952d);
        SafeParcelWriter.g(parcel, 5, this.f70953f);
        SafeParcelWriter.I(parcel, 6, this.f70954g, false);
        SafeParcelWriter.G(parcel, 7, this.f70955h, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

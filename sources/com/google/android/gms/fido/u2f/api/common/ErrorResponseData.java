package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ErrorResponseData extends ResponseData {
    public static final Parcelable.Creator<ErrorResponseData> CREATOR = new zzd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ErrorCode f72726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72727b;

    ErrorResponseData(int i3, String str) {
        this.f72726a = ErrorCode.d(i3);
        this.f72727b = str;
    }

    public int M() {
        return this.f72726a.c();
    }

    public String N() {
        return this.f72727b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ErrorResponseData)) {
            return false;
        }
        ErrorResponseData errorResponseData = (ErrorResponseData) obj;
        return Objects.b(this.f72726a, errorResponseData.f72726a) && Objects.b(this.f72727b, errorResponseData.f72727b);
    }

    public int hashCode() {
        return Objects.c(this.f72726a, this.f72727b);
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzbiVarZza.zza("errorCode", this.f72726a.c());
        String str = this.f72727b;
        if (str != null) {
            zzbiVarZza.zzb("errorMessage", str);
        }
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, M());
        SafeParcelWriter.G(parcel, 3, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}

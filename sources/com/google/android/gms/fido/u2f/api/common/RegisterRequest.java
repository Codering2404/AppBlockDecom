package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class RegisterRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new zzg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProtocolVersion f72738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f72739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f72740d;

    RegisterRequest(int i3, String str, byte[] bArr, String str2) {
        this.f72737a = i3;
        try {
            this.f72738b = ProtocolVersion.a(str);
            this.f72739c = bArr;
            this.f72740d = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public String M() {
        return this.f72740d;
    }

    public byte[] N() {
        return this.f72739c;
    }

    public int O() {
        return this.f72737a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.f72739c, registerRequest.f72739c) || this.f72738b != registerRequest.f72738b) {
            return false;
        }
        String str = this.f72740d;
        if (str == null) {
            if (registerRequest.f72740d != null) {
                return false;
            }
        } else if (!str.equals(registerRequest.f72740d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f72739c) + 31) * 31) + this.f72738b.hashCode();
        String str = this.f72740d;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, O());
        SafeParcelWriter.G(parcel, 2, this.f72738b.toString(), false);
        SafeParcelWriter.l(parcel, 3, N(), false);
        SafeParcelWriter.G(parcel, 4, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}

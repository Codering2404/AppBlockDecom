package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class RegisterResponseData extends ResponseData {
    public static final Parcelable.Creator<RegisterResponseData> CREATOR = new zzi();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f72749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProtocolVersion f72750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72751c;

    RegisterResponseData(byte[] bArr, String str, String str2) {
        this.f72749a = bArr;
        try {
            this.f72750b = ProtocolVersion.a(str);
            this.f72751c = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public String M() {
        return this.f72751c;
    }

    public byte[] N() {
        return this.f72749a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RegisterResponseData)) {
            return false;
        }
        RegisterResponseData registerResponseData = (RegisterResponseData) obj;
        return Objects.b(this.f72750b, registerResponseData.f72750b) && Arrays.equals(this.f72749a, registerResponseData.f72749a) && Objects.b(this.f72751c, registerResponseData.f72751c);
    }

    public int hashCode() {
        return Objects.c(this.f72750b, Integer.valueOf(Arrays.hashCode(this.f72749a)), this.f72751c);
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzbiVarZza.zzb("protocolVersion", this.f72750b);
        zzgf zzgfVarZzf = zzgf.zzf();
        byte[] bArr = this.f72749a;
        zzbiVarZza.zzb("registerData", zzgfVarZzf.zzg(bArr, 0, bArr.length));
        String str = this.f72751c;
        if (str != null) {
            zzbiVarZza.zzb("clientDataString", str);
        }
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, N(), false);
        SafeParcelWriter.G(parcel, 3, this.f72750b.toString(), false);
        SafeParcelWriter.G(parcel, 4, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}

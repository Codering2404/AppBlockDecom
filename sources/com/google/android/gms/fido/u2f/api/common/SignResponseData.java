package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SignResponseData extends ResponseData {
    public static final Parcelable.Creator<SignResponseData> CREATOR = new zzl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f72763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f72765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f72766d;

    public SignResponseData(byte[] bArr, String str, byte[] bArr2, byte[] bArr3) {
        this.f72763a = (byte[]) Preconditions.m(bArr);
        this.f72764b = (String) Preconditions.m(str);
        this.f72765c = (byte[]) Preconditions.m(bArr2);
        this.f72766d = (byte[]) Preconditions.m(bArr3);
    }

    public String M() {
        return this.f72764b;
    }

    public byte[] N() {
        return this.f72763a;
    }

    public byte[] O() {
        return this.f72765c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignResponseData)) {
            return false;
        }
        SignResponseData signResponseData = (SignResponseData) obj;
        return Arrays.equals(this.f72763a, signResponseData.f72763a) && Objects.b(this.f72764b, signResponseData.f72764b) && Arrays.equals(this.f72765c, signResponseData.f72765c) && Arrays.equals(this.f72766d, signResponseData.f72766d);
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(Arrays.hashCode(this.f72763a)), this.f72764b, Integer.valueOf(Arrays.hashCode(this.f72765c)), Integer.valueOf(Arrays.hashCode(this.f72766d)));
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzgf zzgfVarZzf = zzgf.zzf();
        byte[] bArr = this.f72763a;
        zzbiVarZza.zzb("keyHandle", zzgfVarZzf.zzg(bArr, 0, bArr.length));
        zzbiVarZza.zzb("clientDataString", this.f72764b);
        zzgf zzgfVarZzf2 = zzgf.zzf();
        byte[] bArr2 = this.f72765c;
        zzbiVarZza.zzb("signatureData", zzgfVarZzf2.zzg(bArr2, 0, bArr2.length));
        zzgf zzgfVarZzf3 = zzgf.zzf();
        byte[] bArr3 = this.f72766d;
        zzbiVarZza.zzb("application", zzgfVarZzf3.zzg(bArr3, 0, bArr3.length));
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, N(), false);
        SafeParcelWriter.G(parcel, 3, M(), false);
        SafeParcelWriter.l(parcel, 4, O(), false);
        SafeParcelWriter.l(parcel, 5, this.f72766d, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

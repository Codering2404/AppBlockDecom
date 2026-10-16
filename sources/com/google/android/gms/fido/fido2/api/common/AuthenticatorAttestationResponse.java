package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgx;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgx f72481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgx f72483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f72484d;

    AuthenticatorAttestationResponse(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        byte[] bArr4 = (byte[]) Preconditions.m(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) Preconditions.m(bArr2);
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) Preconditions.m(bArr3);
        zzgx zzgxVarZzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.f72481a = (zzgx) Preconditions.m(zzgxVarZzl);
        this.f72482b = (zzgx) Preconditions.m(zzgxVarZzl2);
        this.f72483c = (zzgx) Preconditions.m(zzgxVarZzl3);
        this.f72484d = (String[]) Preconditions.m(strArr);
    }

    public byte[] M() {
        return this.f72483c.zzm();
    }

    public byte[] N() {
        return this.f72482b.zzm();
    }

    public byte[] O() {
        return this.f72481a.zzm();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        return Objects.b(this.f72481a, authenticatorAttestationResponse.f72481a) && Objects.b(this.f72482b, authenticatorAttestationResponse.f72482b) && Objects.b(this.f72483c, authenticatorAttestationResponse.f72483c);
    }

    public String[] g0() {
        return this.f72484d;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(Objects.c(this.f72481a)), Integer.valueOf(Objects.c(this.f72482b)), Integer.valueOf(Objects.c(this.f72483c)));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0125 A[Catch: JSONException -> 0x0019, zzho -> 0x018e, TRY_LEAVE, TryCatch #1 {zzho -> 0x018e, blocks: (B:33:0x00f4, B:39:0x0113, B:41:0x0125, B:46:0x0139, B:49:0x015b, B:51:0x0171, B:53:0x0177, B:56:0x0191, B:57:0x0196, B:58:0x0197, B:59:0x019c, B:64:0x01a7, B:66:0x01b7, B:68:0x01c5, B:69:0x01d8, B:70:0x01dd, B:71:0x01de, B:72:0x01e3, B:77:0x0202, B:78:0x0207), top: B:108:0x00f4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0202 A[Catch: JSONException -> 0x0019, zzho -> 0x018e, TRY_ENTER, TryCatch #1 {zzho -> 0x018e, blocks: (B:33:0x00f4, B:39:0x0113, B:41:0x0125, B:46:0x0139, B:49:0x015b, B:51:0x0171, B:53:0x0177, B:56:0x0191, B:57:0x0196, B:58:0x0197, B:59:0x019c, B:64:0x01a7, B:66:0x01b7, B:68:0x01c5, B:69:0x01d8, B:70:0x01dd, B:71:0x01de, B:72:0x01e3, B:77:0x0202, B:78:0x0207), top: B:108:0x00f4, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject j0() {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse.j0():org.json.JSONObject");
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzgf zzgfVarZzf = zzgf.zzf();
        byte[] bArrO = O();
        zzbiVarZza.zzb("keyHandle", zzgfVarZzf.zzg(bArrO, 0, bArrO.length));
        zzgf zzgfVarZzf2 = zzgf.zzf();
        byte[] bArrN = N();
        zzbiVarZza.zzb("clientDataJSON", zzgfVarZzf2.zzg(bArrN, 0, bArrN.length));
        zzgf zzgfVarZzf3 = zzgf.zzf();
        byte[] bArrM = M();
        zzbiVarZza.zzb("attestationObject", zzgfVarZzf3.zzg(bArrM, 0, bArrM.length));
        zzbiVarZza.zzb("transports", Arrays.toString(this.f72484d));
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, O(), false);
        SafeParcelWriter.l(parcel, 3, N(), false);
        SafeParcelWriter.l(parcel, 4, M(), false);
        SafeParcelWriter.H(parcel, 5, g0(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}

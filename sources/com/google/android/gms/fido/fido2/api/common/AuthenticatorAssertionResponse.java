package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AuthenticationToken;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticatorAssertionResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorAssertionResponse> CREATOR = new zzj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgx f72476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgx f72478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzgx f72479d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzgx f72480f;

    AuthenticatorAssertionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = (byte[]) Preconditions.m(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl = zzgx.zzl(bArr6, 0, bArr6.length);
        byte[] bArr7 = (byte[]) Preconditions.m(bArr2);
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr7, 0, bArr7.length);
        byte[] bArr8 = (byte[]) Preconditions.m(bArr3);
        zzgx zzgxVarZzl3 = zzgx.zzl(bArr8, 0, bArr8.length);
        byte[] bArr9 = (byte[]) Preconditions.m(bArr4);
        zzgx zzgxVarZzl4 = zzgx.zzl(bArr9, 0, bArr9.length);
        zzgx zzgxVarZzl5 = bArr5 == null ? null : zzgx.zzl(bArr5, 0, bArr5.length);
        this.f72476a = (zzgx) Preconditions.m(zzgxVarZzl);
        this.f72477b = (zzgx) Preconditions.m(zzgxVarZzl2);
        this.f72478c = (zzgx) Preconditions.m(zzgxVarZzl3);
        this.f72479d = (zzgx) Preconditions.m(zzgxVarZzl4);
        this.f72480f = zzgxVarZzl5;
    }

    public byte[] M() {
        return this.f72478c.zzm();
    }

    public byte[] N() {
        return this.f72477b.zzm();
    }

    public byte[] O() {
        return this.f72476a.zzm();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAssertionResponse)) {
            return false;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) obj;
        return Objects.b(this.f72476a, authenticatorAssertionResponse.f72476a) && Objects.b(this.f72477b, authenticatorAssertionResponse.f72477b) && Objects.b(this.f72478c, authenticatorAssertionResponse.f72478c) && Objects.b(this.f72479d, authenticatorAssertionResponse.f72479d) && Objects.b(this.f72480f, authenticatorAssertionResponse.f72480f);
    }

    public byte[] g0() {
        return this.f72479d.zzm();
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(Objects.c(this.f72476a)), Integer.valueOf(Objects.c(this.f72477b)), Integer.valueOf(Objects.c(this.f72478c)), Integer.valueOf(Objects.c(this.f72479d)), Integer.valueOf(Objects.c(this.f72480f)));
    }

    public byte[] j0() {
        zzgx zzgxVar = this.f72480f;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
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
        zzbiVarZza.zzb("authenticatorData", zzgfVarZzf3.zzg(bArrM, 0, bArrM.length));
        zzgf zzgfVarZzf4 = zzgf.zzf();
        byte[] bArrG0 = g0();
        zzbiVarZza.zzb(AuthenticationToken.SIGNATURE_KEY, zzgfVarZzf4.zzg(bArrG0, 0, bArrG0.length));
        byte[] bArrJ0 = j0();
        if (bArrJ0 != null) {
            zzbiVarZza.zzb("userHandle", zzgf.zzf().zzg(bArrJ0, 0, bArrJ0.length));
        }
        return zzbiVarZza.toString();
    }

    public final JSONObject w0() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientDataJSON", Base64Utils.e(N()));
            jSONObject.put("authenticatorData", Base64Utils.e(M()));
            jSONObject.put(AuthenticationToken.SIGNATURE_KEY, Base64Utils.e(g0()));
            if (this.f72480f == null) {
                return jSONObject;
            }
            jSONObject.put("userHandle", Base64Utils.e(j0()));
            return jSONObject;
        } catch (JSONException e3) {
            throw new RuntimeException("Error encoding AuthenticatorAssertionResponse to JSON object", e3);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, O(), false);
        SafeParcelWriter.l(parcel, 3, N(), false);
        SafeParcelWriter.l(parcel, 4, M(), false);
        SafeParcelWriter.l(parcel, 5, g0(), false);
        SafeParcelWriter.l(parcel, 6, j0(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}

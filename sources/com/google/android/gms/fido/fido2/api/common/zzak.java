package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzfv;
import com.google.android.gms.internal.fido.zzfx;
import com.google.android.gms.internal.fido.zzgj;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f72650b = "WebAuthn PRF\u0000".getBytes(StandardCharsets.UTF_8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f72651a;

    public zzak(byte[][] bArr) {
        Preconditions.a(bArr != null);
        Preconditions.a(1 == ((bArr.length & 1) ^ 1));
        int i3 = 0;
        while (i3 < bArr.length) {
            Preconditions.a(i3 == 0 || bArr[i3] != null);
            int i4 = i3 + 1;
            Preconditions.a(bArr[i4] != null);
            int length = bArr[i4].length;
            Preconditions.a(length == 32 || length == 64);
            i3 += 2;
        }
        this.f72651a = bArr;
    }

    public static zzak M(JSONObject jSONObject, boolean z2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject.has("eval")) {
                arrayList.add(null);
                if (z2) {
                    arrayList.add(g0(jSONObject.getJSONObject("eval")));
                } else {
                    arrayList.add(j0(jSONObject.getJSONObject("eval")));
                }
            }
            if (jSONObject.has("evalByCredential")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("evalByCredential");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    arrayList.add(Base64Utils.b(next));
                    if (z2) {
                        arrayList.add(g0(jSONObject2.getJSONObject(next)));
                    } else {
                        arrayList.add(j0(jSONObject2.getJSONObject(next)));
                    }
                }
            }
            return new zzak((byte[][]) arrayList.toArray(new byte[0][]));
        } catch (IllegalArgumentException unused) {
            throw new JSONException("invalid base64url value");
        }
    }

    private static JSONObject N(byte[] bArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bArr.length == 32) {
            jSONObject.put("first", Base64Utils.e(bArr));
            return jSONObject;
        }
        jSONObject.put("first", Base64.encodeToString(bArr, 0, 32, 11));
        jSONObject.put("second", Base64.encodeToString(bArr, 32, 32, 11));
        return jSONObject;
    }

    private static byte[] O(byte[] bArr) {
        zzfv zzfvVarZza = zzfx.zza().zza();
        zzfvVarZza.zza(f72650b);
        zzfvVarZza.zza(bArr);
        return zzfvVarZza.zzc().zzd();
    }

    private static byte[] g0(JSONObject jSONObject) throws JSONException {
        byte[] bArrB = Base64Utils.b(jSONObject.getString("first"));
        if (bArrB.length != 32) {
            throw new JSONException("hashed PRF value with wrong length");
        }
        if (!jSONObject.has("second")) {
            return bArrB;
        }
        byte[] bArrB2 = Base64Utils.b(jSONObject.getString("second"));
        if (bArrB2.length == 32) {
            return zzgj.zza(bArrB, bArrB2);
        }
        throw new JSONException("hashed PRF value with wrong length");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzak) {
            return Arrays.deepEquals(this.f72651a, ((zzak) obj).f72651a);
        }
        return false;
    }

    public final int hashCode() {
        int iC = 0;
        for (byte[] bArr : this.f72651a) {
            if (bArr != null) {
                iC ^= Objects.c(bArr);
            }
        }
        return iC;
    }

    public final String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i3 = 0;
            JSONObject jSONObject2 = null;
            while (true) {
                byte[][] bArr = this.f72651a;
                if (i3 >= bArr.length) {
                    return "PrfExtension{" + jSONObject.toString() + "}";
                }
                if (bArr[i3] == null) {
                    jSONObject.put("eval", N(bArr[i3 + 1]));
                } else {
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                        jSONObject.put("evalByCredential", jSONObject2);
                    }
                    jSONObject2.put(Base64Utils.e(this.f72651a[i3]), N(this.f72651a[i3 + 1]));
                }
                i3 += 2;
            }
        } catch (JSONException e3) {
            return "PrfExtension{Exception:" + e3.getMessage() + "}";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        byte[][] bArr = this.f72651a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.m(parcel, 1, bArr, false);
        SafeParcelWriter.b(parcel, iA);
    }

    private static byte[] j0(JSONObject jSONObject) {
        byte[] bArrO = O(Base64Utils.b(jSONObject.getString("first")));
        String str = KqqtdetwHMIO.xsPeenHakAE;
        return !jSONObject.has(str) ? bArrO : zzgj.zza(bArrO, O(Base64Utils.b(jSONObject.getString(str))));
    }
}

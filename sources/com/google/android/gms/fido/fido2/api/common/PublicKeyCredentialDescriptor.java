package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import com.google.android.gms.internal.fido.zzcf;
import com.google.android.gms.internal.fido.zzgx;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyCredentialDescriptor extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PublicKeyCredentialType f72570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f72572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzcf f72569d = zzcf.zzm(com.google.android.gms.internal.fido.zzh.zza, com.google.android.gms.internal.fido.zzh.zzb);
    public static final Parcelable.Creator<PublicKeyCredentialDescriptor> CREATOR = new zzap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedPubKeyCredDescriptorException extends Exception {
    }

    public PublicKeyCredentialDescriptor(String str, zzgx zzgxVar, List list) {
        Preconditions.m(str);
        try {
            this.f72570a = PublicKeyCredentialType.a(str);
            this.f72571b = (zzgx) Preconditions.m(zzgxVar);
            this.f72572c = list;
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static PublicKeyCredentialDescriptor g0(JSONObject jSONObject) {
        return new PublicKeyCredentialDescriptor(jSONObject.getString("type"), Base64.decode(jSONObject.getString("id"), 11), jSONObject.has("transports") ? Transport.c(jSONObject.getJSONArray("transports")) : null);
    }

    public byte[] M() {
        return this.f72571b.zzm();
    }

    public List N() {
        return this.f72572c;
    }

    public String O() {
        return this.f72570a.toString();
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        if (!this.f72570a.equals(publicKeyCredentialDescriptor.f72570a) || !Objects.b(this.f72571b, publicKeyCredentialDescriptor.f72571b)) {
            return false;
        }
        List list2 = this.f72572c;
        if (list2 == null && publicKeyCredentialDescriptor.f72572c == null) {
            return true;
        }
        return list2 != null && (list = publicKeyCredentialDescriptor.f72572c) != null && list2.containsAll(list) && publicKeyCredentialDescriptor.f72572c.containsAll(this.f72572c);
    }

    public int hashCode() {
        return Objects.c(this.f72570a, this.f72571b, this.f72572c);
    }

    public final String toString() {
        return "PublicKeyCredentialDescriptor{\n type=" + String.valueOf(this.f72570a) + ", \n id=" + Base64Utils.e(M()) + ", \n transports=" + String.valueOf(this.f72572c) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, O(), false);
        SafeParcelWriter.l(parcel, 3, M(), false);
        SafeParcelWriter.K(parcel, 4, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublicKeyCredentialDescriptor(String str, byte[] bArr, List list) {
        this(str, zzgx.zzl(bArr, 0, bArr.length), list);
        zzgx zzgxVar = zzgx.zzb;
    }
}

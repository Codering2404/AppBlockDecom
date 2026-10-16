package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzhp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final zzhp f72642f = zzhp.zzg(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final zzhp f72643g = zzhp.zzg(2);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final zzhp f72644h = zzhp.zzg(3);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final zzhp f72645i = zzhp.zzg(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgx f72646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgx f72648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72649d;

    zzai(zzgx zzgxVar, zzgx zzgxVar2, zzgx zzgxVar3, int i3) {
        this.f72646a = zzgxVar;
        this.f72647b = zzgxVar2;
        this.f72648c = zzgxVar3;
        this.f72649d = i3;
    }

    public final byte[] M() {
        zzgx zzgxVar = this.f72646a;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final byte[] N() {
        zzgx zzgxVar = this.f72648c;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final byte[] O() {
        zzgx zzgxVar = this.f72647b;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzaiVar = (zzai) obj;
        return Objects.b(this.f72646a, zzaiVar.f72646a) && Objects.b(this.f72647b, zzaiVar.f72647b) && Objects.b(this.f72648c, zzaiVar.f72648c) && this.f72649d == zzaiVar.f72649d;
    }

    public final int hashCode() {
        return Objects.c(this.f72646a, this.f72647b, this.f72648c, Integer.valueOf(this.f72649d));
    }

    public final String toString() {
        return "HmacSecretExtension{coseKeyAgreement=" + Base64Utils.e(M()) + ", saltEnc=" + Base64Utils.e(O()) + ", saltAuth=" + Base64Utils.e(N()) + ", getPinUvAuthProtocol=" + this.f72649d + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, M(), false);
        SafeParcelWriter.l(parcel, 2, O(), false);
        SafeParcelWriter.l(parcel, 3, N(), false);
        SafeParcelWriter.u(parcel, 4, this.f72649d);
        SafeParcelWriter.b(parcel, iA);
    }
}

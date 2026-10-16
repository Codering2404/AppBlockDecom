package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzgx f72653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72654b;

    public zzf(zzgx zzgxVar, zzgx zzgxVar2) {
        this.f72653a = zzgxVar;
        this.f72654b = zzgxVar2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzfVar = (zzf) obj;
        return Objects.b(this.f72653a, zzfVar.f72653a) && Objects.b(this.f72654b, zzfVar.f72654b);
    }

    public final int hashCode() {
        return Objects.c(this.f72653a, this.f72654b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        zzgx zzgxVar = this.f72653a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, zzgxVar == null ? null : zzgxVar.zzm(), false);
        zzgx zzgxVar2 = this.f72654b;
        SafeParcelWriter.l(parcel, 2, zzgxVar2 != null ? zzgxVar2.zzm() : null, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

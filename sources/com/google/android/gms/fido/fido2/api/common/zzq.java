package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f72657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzgx f72658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgx f72659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzgx f72660d;

    zzq(long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = (byte[]) Preconditions.m(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzgxVarZzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) Preconditions.m(bArr2);
        zzgx zzgxVarZzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) Preconditions.m(bArr3);
        zzgx zzgxVarZzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.f72657a = j3;
        this.f72658b = (zzgx) Preconditions.m(zzgxVarZzl);
        this.f72659c = (zzgx) Preconditions.m(zzgxVarZzl2);
        this.f72660d = (zzgx) Preconditions.m(zzgxVarZzl3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        return this.f72657a == zzqVar.f72657a && Objects.b(this.f72658b, zzqVar.f72658b) && Objects.b(this.f72659c, zzqVar.f72659c) && Objects.b(this.f72660d, zzqVar.f72660d);
    }

    public final int hashCode() {
        return Objects.c(Long.valueOf(this.f72657a), this.f72658b, this.f72659c, this.f72660d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        long j3 = this.f72657a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, j3);
        SafeParcelWriter.l(parcel, 2, this.f72658b.zzm(), false);
        SafeParcelWriter.l(parcel, 3, this.f72659c.zzm(), false);
        SafeParcelWriter.l(parcel, 4, this.f72660d.zzm(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}

package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72661a;

    public zzs(List list) {
        this.f72661a = (List) Preconditions.m(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        return this.f72661a.containsAll(zzsVar.f72661a) && zzsVar.f72661a.containsAll(this.f72661a);
    }

    public final int hashCode() {
        return Objects.c(new HashSet(this.f72661a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.f72661a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, list, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

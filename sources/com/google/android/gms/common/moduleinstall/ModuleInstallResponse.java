package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new zad();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72142b;

    public ModuleInstallResponse(int i3, boolean z2) {
        this.f72141a = i3;
        this.f72142b = z2;
    }

    public int M() {
        return this.f72141a;
    }

    public final boolean N() {
        return this.f72142b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, M());
        SafeParcelWriter.g(parcel, 2, this.f72142b);
        SafeParcelWriter.b(parcel, iA);
    }
}

package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new zaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72139b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.CLASS)
    public @interface AvailabilityStatus {
    }

    public ModuleAvailabilityResponse(boolean z2, int i3) {
        this.f72138a = z2;
        this.f72139b = i3;
    }

    public boolean M() {
        return this.f72138a;
    }

    public int N() {
        return this.f72139b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, M());
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.b(parcel, iA);
    }
}

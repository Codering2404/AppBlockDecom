package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new zae();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f72145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f72146d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f72147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ProgressInfo f72148g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ProgressInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f72149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f72150b;

        ProgressInfo(long j3, long j4) {
            Preconditions.p(j4);
            this.f72149a = j3;
            this.f72150b = j4;
        }
    }

    public ModuleInstallStatusUpdate(int i3, int i4, Long l3, Long l4, int i5) {
        this.f72143a = i3;
        this.f72144b = i4;
        this.f72145c = l3;
        this.f72146d = l4;
        this.f72147f = i5;
        this.f72148g = (l3 == null || l4 == null || l4.longValue() == 0) ? null : new ProgressInfo(l3.longValue(), l4.longValue());
    }

    public int M() {
        return this.f72147f;
    }

    public int N() {
        return this.f72144b;
    }

    public int O() {
        return this.f72143a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, O());
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.B(parcel, 3, this.f72145c, false);
        SafeParcelWriter.B(parcel, 4, this.f72146d, false);
        SafeParcelWriter.u(parcel, 5, M());
        SafeParcelWriter.b(parcel, iA);
    }
}

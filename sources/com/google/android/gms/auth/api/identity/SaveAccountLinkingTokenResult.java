package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SaveAccountLinkingTokenResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenResult> CREATOR = new zbr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingIntent f71135a;

    public SaveAccountLinkingTokenResult(PendingIntent pendingIntent) {
        this.f71135a = pendingIntent;
    }

    public PendingIntent M() {
        return this.f71135a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SaveAccountLinkingTokenResult) {
            return Objects.b(this.f71135a, ((SaveAccountLinkingTokenResult) obj).f71135a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(this.f71135a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, M(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}

package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zad extends com.google.android.gms.internal.base.zab implements zae {
    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            Status status = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleAvailabilityResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            N3(status, moduleAvailabilityResponse);
        } else if (i3 == 2) {
            Status status2 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            I3(status2, moduleInstallResponse);
        } else if (i3 == 3) {
            Status status3 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleInstallIntentResponse moduleInstallIntentResponse = (ModuleInstallIntentResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallIntentResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            s0(status3, moduleInstallIntentResponse);
        } else {
            if (i3 != 4) {
                return false;
            }
            Status status4 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            F4(status4);
        }
        return true;
    }
}

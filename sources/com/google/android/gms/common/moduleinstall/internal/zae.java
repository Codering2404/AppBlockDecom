package com.google.android.gms.common.moduleinstall.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface zae extends IInterface {
    void F4(Status status);

    void I3(Status status, ModuleInstallResponse moduleInstallResponse);

    void N3(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse);

    void s0(Status status, ModuleInstallIntentResponse moduleInstallIntentResponse);
}

package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzg extends zzb implements zzh {
    public zzg() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.appupdate.internal.zzb
    protected final boolean x3(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 2) {
            Bundle bundle = (Bundle) zzc.a(parcel, Bundle.CREATOR);
            zzc.b(parcel);
            K3(bundle);
            return true;
        }
        if (i3 != 3) {
            return false;
        }
        Bundle bundle2 = (Bundle) zzc.a(parcel, Bundle.CREATOR);
        zzc.b(parcel);
        zzb(bundle2);
        return true;
    }
}

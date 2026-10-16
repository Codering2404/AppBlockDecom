package com.google.android.libraries.places.internal;

import com.facebook.internal.Utility;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcby implements zzcan {
    zzcby() {
    }

    @Override // com.google.android.libraries.places.internal.zzcan
    public final zzcam zza(int i3) {
        return new zzcbx(new zzcff(), Math.min(1048576, ((i3 + 8191) / Utility.DEFAULT_STREAM_BUFFER_SIZE) * Utility.DEFAULT_STREAM_BUFFER_SIZE));
    }
}

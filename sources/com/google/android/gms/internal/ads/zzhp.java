package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzhp extends zzj {
    long zzb(zzht zzhtVar) throws IOException;

    Uri zzc();

    void zzd() throws IOException;

    void zze(zzin zzinVar);

    default Map zzj() {
        return Collections.EMPTY_MAP;
    }
}

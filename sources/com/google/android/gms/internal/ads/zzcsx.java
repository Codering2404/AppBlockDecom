package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcsx implements zzcrt {
    private final zzecr zza;

    zzcsx(zzecr zzecrVar) {
        this.zza = zzecrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrt
    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zza.zzc(str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }
}

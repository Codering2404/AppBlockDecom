package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.Container;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzu implements zzap {
    final /* synthetic */ Container zza;

    @Override // com.google.android.gms.tagmanager.zzap
    public final Object zza(String str, Map map) {
        Container.FunctionCallMacroCallback functionCallMacroCallbackZza = this.zza.zza(str);
        if (functionCallMacroCallbackZza == null) {
            return null;
        }
        return functionCallMacroCallbackZza.getValue(str, map);
    }
}

package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzg implements DynamiteModule.VersionPolicy {
    zzg() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int iA = iVersions.a(context, str, true);
        selectionResult.f72415b = iA;
        if (iA != 0) {
            selectionResult.f72416c = 1;
            return selectionResult;
        }
        int iB = iVersions.b(context, str);
        selectionResult.f72414a = iB;
        if (iB != 0) {
            selectionResult.f72416c = -1;
        }
        return selectionResult;
    }
}

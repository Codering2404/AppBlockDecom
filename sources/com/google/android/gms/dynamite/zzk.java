package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzk implements DynamiteModule.VersionPolicy {
    zzk() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        int iA;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int iB = iVersions.b(context, str);
        selectionResult.f72414a = iB;
        int i3 = 1;
        int i4 = 0;
        if (iB != 0) {
            iA = iVersions.a(context, str, false);
            selectionResult.f72415b = iA;
        } else {
            iA = iVersions.a(context, str, true);
            selectionResult.f72415b = iA;
        }
        int i5 = selectionResult.f72414a;
        if (i5 == 0) {
            if (iA == 0) {
                i3 = 0;
            }
            selectionResult.f72416c = i3;
            return selectionResult;
        }
        i4 = i5;
        if (i4 >= iA) {
            i3 = -1;
        }
        selectionResult.f72416c = i3;
        return selectionResult;
    }
}

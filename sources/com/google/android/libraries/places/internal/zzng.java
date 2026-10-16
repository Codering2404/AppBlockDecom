package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzng {
    public static zzaoc a(zzmz zzmzVar, zzmy zzmyVar) {
        return b(zzmzVar, zzmyVar == zzmy.AUTOCOMPLETE_WIDGET ? 2 : 3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
    }

    public static zzaoc b(zzmz zzmzVar, int i3, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        int i4;
        zzmy zzmyVar2 = zzmy.PROGRAMMATIC_KOTLIN_API;
        int iOrdinal = zzmzVar.c().ordinal();
        if (iOrdinal != 0) {
            i4 = 4;
            if (iOrdinal != 1) {
                i4 = iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? 1 : 8 : 7 : 5;
            }
        } else {
            i4 = 2;
        }
        int i5 = zzmyVar == zzmyVar2 ? 2 : 3;
        zzaoc zzaocVarG = zzaoj.G();
        zzxv zzxvVarG = zzya.G();
        zzxvVarG.y(zzmzVar.a());
        zzxvVarG.z(zzmzVar.b());
        zzaocVarG.y((zzya) zzxvVarG.zzG());
        zzaocVarG.F(i3 == 2);
        zzaocVarG.Q(i3);
        zzaocVarG.P(i4);
        zzaocVarG.R(i5);
        zzaocVarG.H("5.1.1");
        zzaocVarG.L(zzbVar.a());
        String strC = zzbVar.c();
        if (strC != null) {
            zzaku zzakuVarG = zzakv.G();
            zzakuVarG.y(strC);
            zzaocVarG.K(zzakuVarG);
        }
        return zzaocVarG;
    }
}

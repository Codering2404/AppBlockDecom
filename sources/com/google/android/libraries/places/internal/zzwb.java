package com.google.android.libraries.places.internal;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzwb extends zzvq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Level f78722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f78723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzva f78724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f78725f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzwb(String str, String str2, boolean z2, int i3, boolean z3, boolean z4) {
        super(str2);
        Level level = Level.ALL;
        int i4 = zzwc.f78729j;
        this.f78721b = "";
        this.f78725f = 2;
        this.f78722c = level;
        this.f78723d = zzwc.f78726g;
        this.f78724e = zzwc.f78727h;
    }

    @Override // com.google.android.libraries.places.internal.zzup
    public final boolean a(Level level) {
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzup
    public final void b(zzun zzunVar) {
        String strA = (String) zzunVar.zzl().d(zzug.f78625a);
        if (strA == null) {
            strA = c();
        }
        if (strA == null) {
            strA = zzunVar.zzg().a();
            int iIndexOf = strA.indexOf(36, strA.lastIndexOf(46));
            if (iIndexOf >= 0) {
                strA = strA.substring(0, iIndexOf);
            }
        }
        String str = this.f78721b;
        zzwc.h(zzunVar, zzvv.a(str, strA, true), 2, this.f78722c, this.f78723d, this.f78724e);
    }
}

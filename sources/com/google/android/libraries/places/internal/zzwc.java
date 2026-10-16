package com.google.android.libraries.places.internal;

import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwc extends zzvq {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set f78726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzva f78727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzwa f78728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f78729j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Level f78731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f78732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzva f78733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f78734f;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzth.f78577a, zzug.f78625a, zzuh.f78626a)));
        f78726g = setUnmodifiableSet;
        f78727h = zzvd.a(setUnmodifiableSet).c();
        f78728i = new zzwa(null);
    }

    /* synthetic */ zzwc(String str, String str2, boolean z2, int i3, Level level, Set set, zzva zzvaVar, byte[] bArr) {
        super(str2);
        this.f78730b = zzvv.a("", str2, true);
        this.f78734f = 2;
        this.f78731c = level;
        this.f78732d = set;
        this.f78733e = zzvaVar;
    }

    public static zzwa d() {
        return f78728i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(com.google.android.libraries.places.internal.zzun r3, java.lang.String r4, int r5, java.util.logging.Level r6, java.util.Set r7, com.google.android.libraries.places.internal.zzva r8) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzwc.h(com.google.android.libraries.places.internal.zzun, java.lang.String, int, java.util.logging.Level, java.util.Set, com.google.android.libraries.places.internal.zzva):void");
    }

    @Override // com.google.android.libraries.places.internal.zzup
    public final boolean a(Level level) {
        String str = this.f78730b;
        int iB = zzvv.b(level);
        return Log.isLoggable(str, iB) || Log.isLoggable("all", iB);
    }

    @Override // com.google.android.libraries.places.internal.zzup
    public final void b(zzun zzunVar) {
        h(zzunVar, this.f78730b, 2, this.f78731c, this.f78732d, this.f78733e);
    }
}

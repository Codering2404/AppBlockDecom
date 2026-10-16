package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpc extends zzbiv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbpd f76585a;

    zzbpc(zzbpd zzbpdVar, zzcag zzcagVar) {
        this.f76585a = (zzbpd) Preconditions.u(zzbpdVar, "tracer");
    }

    static void c(zzbku zzbkuVar, int i3, String str) {
        Level levelF = f(i3);
        if (zzbpd.f76586c.isLoggable(levelF)) {
            zzbpd.c(zzbkuVar, levelF, str);
        }
    }

    static void d(zzbku zzbkuVar, int i3, String str, Object... objArr) {
        Level levelF = f(2);
        if (zzbpd.f76586c.isLoggable(levelF)) {
            zzbpd.c(zzbkuVar, levelF, MessageFormat.format(str, objArr));
        }
    }

    private final boolean e(int i3) {
        if (i3 == 1) {
            return false;
        }
        this.f76585a.b();
        return false;
    }

    private static Level f(int i3) {
        int i4 = i3 - 1;
        return i4 != 1 ? (i4 == 2 || i4 == 3) ? Level.FINE : Level.FINEST : Level.FINER;
    }

    @Override // com.google.android.libraries.places.internal.zzbiv
    public final void a(int i3, String str) {
        c(this.f76585a.d(), i3, str);
        e(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbiv
    public final void b(int i3, String str, Object... objArr) {
        Level levelF = f(i3);
        e(i3);
        a(i3, zzbpd.f76586c.isLoggable(levelF) ? MessageFormat.format(str, objArr) : null);
    }
}

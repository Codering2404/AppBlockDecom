package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzps extends IOException {
    zzps() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzps(long j3, long j4, int i3, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3))), th);
    }

    zzps(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}

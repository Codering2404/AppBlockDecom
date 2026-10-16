package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Logger f76586c = Logger.getLogger(zzbiv.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f76587a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbku f76588b;

    zzbpd(zzbku zzbkuVar, int i3, long j3, String str) {
        Preconditions.u(str, "description");
        this.f76588b = (zzbku) Preconditions.u(zzbkuVar, "logId");
        zzbkj zzbkjVar = new zzbkj();
        zzbkjVar.a(str.concat(" created"));
        zzbkjVar.c(zzbkk.CT_INFO);
        zzbkjVar.b(j3);
        a(zzbkjVar.e());
    }

    static void c(zzbku zzbkuVar, Level level, String str) {
        Logger logger = f76586c;
        if (logger.isLoggable(level)) {
            String strValueOf = String.valueOf(zzbkuVar);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 3 + String.valueOf(str).length());
            sb.append("[");
            sb.append(strValueOf);
            sb.append("] ");
            sb.append(str);
            LogRecord logRecord = new LogRecord(level, sb.toString());
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    final void a(zzbkl zzbklVar) {
        int iOrdinal = zzbklVar.f76338b.ordinal();
        Level level = iOrdinal != 2 ? iOrdinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.f76587a) {
        }
        c(this.f76588b, level, zzbklVar.f76337a);
    }

    final boolean b() {
        synchronized (this.f76587a) {
        }
        return false;
    }

    final zzbku d() {
        return this.f76588b;
    }
}

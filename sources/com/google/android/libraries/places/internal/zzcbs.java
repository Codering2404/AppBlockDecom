package com.google.android.libraries.places.internal;

import com.applovin.sdk.AppLovinEventTypes;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Logger f77454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Level f77455b;

    zzcbs(Level level, Class cls) {
        Logger logger = Logger.getLogger(cls.getName());
        this.f77455b = (Level) Preconditions.u(level, AppLovinEventTypes.USER_COMPLETED_LEVEL);
        this.f77454a = (Logger) Preconditions.u(logger, "logger");
    }

    private static String k(zzcff zzcffVar) {
        return zzcffVar.zzb() <= 64 ? zzcffVar.k().g() : String.valueOf(zzcffVar.m((int) Math.min(zzcffVar.zzb(), 64L)).g()).concat("...");
    }

    private final boolean l() {
        return this.f77454a.isLoggable(this.f77455b);
    }

    final void a(int i3, int i4, zzcff zzcffVar, int i5, boolean z2) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strA = zzcbq.a(i3);
            String strK = k(zzcffVar);
            String strValueOf = String.valueOf(i4);
            StringBuilder sb = new StringBuilder(strA.length() + 16 + strValueOf.length() + 11 + String.valueOf(z2).length() + 8 + String.valueOf(i5).length() + 7 + String.valueOf(strK).length());
            sb.append(strA);
            sb.append(" DATA: streamId=");
            sb.append(i4);
            sb.append(" endStream=");
            sb.append(z2);
            sb.append(" length=");
            sb.append(i5);
            sb.append(" bytes=");
            sb.append(strK);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logData", sb.toString());
        }
    }

    final void b(int i3, int i4, List list, boolean z2) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String string = list.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 35 + string.length() + 11 + String.valueOf(z2).length());
            sb.append("INBOUND HEADERS: streamId=");
            sb.append(i4);
            sb.append(" headers=");
            sb.append(string);
            sb.append(" endStream=");
            sb.append(z2);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logHeaders", sb.toString());
        }
    }

    final void c(int i3, int i4, zzccv zzccvVar) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strA = zzcbq.a(i3);
            String strValueOf = String.valueOf(zzccvVar);
            StringBuilder sb = new StringBuilder(strA.length() + 22 + String.valueOf(i4).length() + 11 + strValueOf.length());
            sb.append(strA);
            sb.append(" RST_STREAM: streamId=");
            sb.append(i4);
            sb.append(" errorCode=");
            sb.append(strValueOf);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logRstStream", sb.toString());
        }
    }

    final void d(int i3) {
        if (l()) {
            this.f77454a.logp(this.f77455b, "io.grpc.okhttp.OkHttpFrameLogger", "logSettingsAck", zzcbq.a(2).concat(" SETTINGS: ack=true"));
        }
    }

    final void e(int i3, zzcdk zzcdkVar) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strA = zzcbq.a(i3);
            EnumMap enumMap = new EnumMap(zzcbr.class);
            for (zzcbr zzcbrVar : zzcbr.values()) {
                if (zzcdkVar.b(zzcbrVar.zza())) {
                    enumMap.put(zzcbrVar, Integer.valueOf(zzcdkVar.c(zzcbrVar.zza())));
                }
            }
            String string = enumMap.toString();
            StringBuilder sb = new StringBuilder(strA.length() + 30 + String.valueOf(string).length());
            sb.append(strA);
            sb.append(" SETTINGS: ack=false settings=");
            sb.append(string);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logSettings", sb.toString());
        }
    }

    final void f(int i3, long j3) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strA = zzcbq.a(i3);
            StringBuilder sb = new StringBuilder(strA.length() + 23 + String.valueOf(j3).length());
            sb.append(strA);
            sb.append(" PING: ack=false bytes=");
            sb.append(j3);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logPing", sb.toString());
        }
    }

    final void g(int i3, long j3) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strValueOf = String.valueOf(j3);
            String strA = zzcbq.a(2);
            StringBuilder sb = new StringBuilder(strA.length() + 22 + strValueOf.length());
            sb.append(strA);
            sb.append(" PING: ack=true bytes=");
            sb.append(j3);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logPingAck", sb.toString());
        }
    }

    final void h(int i3, int i4, int i5, List list) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String string = list.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 49 + String.valueOf(i5).length() + 9 + string.length());
            sb.append("INBOUND PUSH_PROMISE: streamId=");
            sb.append(i4);
            sb.append(" promisedStreamId=");
            sb.append(i5);
            sb.append(" headers=");
            sb.append(string);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logPushPromise", sb.toString());
        }
    }

    final void i(int i3, int i4, zzccv zzccvVar, zzcfj zzcfjVar) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strA = zzcbq.a(i3);
            String strValueOf = String.valueOf(zzccvVar);
            int iJ = zzcfjVar.j();
            zzcff zzcffVar = new zzcff();
            zzcffVar.M(zzcfjVar);
            String strK = k(zzcffVar);
            StringBuilder sb = new StringBuilder(strA.length() + 23 + String.valueOf(i4).length() + 11 + strValueOf.length() + 8 + String.valueOf(iJ).length() + 7 + String.valueOf(strK).length());
            sb.append(strA);
            sb.append(" GO_AWAY: lastStreamId=");
            sb.append(i4);
            sb.append(" errorCode=");
            sb.append(strValueOf);
            sb.append(" length=");
            sb.append(iJ);
            sb.append(" bytes=");
            sb.append(strK);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logGoAway", sb.toString());
        }
    }

    final void j(int i3, int i4, long j3) {
        if (l()) {
            Logger logger = this.f77454a;
            Level level = this.f77455b;
            String strA = zzcbq.a(i3);
            String strValueOf = String.valueOf(i4);
            StringBuilder sb = new StringBuilder(strA.length() + 25 + strValueOf.length() + 21 + String.valueOf(j3).length());
            sb.append(strA);
            sb.append(" WINDOW_UPDATE: streamId=");
            sb.append(i4);
            sb.append(" windowSizeIncrement=");
            sb.append(j3);
            logger.logp(level, "io.grpc.okhttp.OkHttpFrameLogger", "logWindowsUpdate", sb.toString());
        }
    }
}

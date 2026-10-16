package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdf implements zzccx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcfh f77655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcdd f77656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final zzcda f77657c;

    zzcdf(zzcfh zzcfhVar, int i3, boolean z2) {
        this.f77655a = zzcfhVar;
        zzcdd zzcddVar = new zzcdd(zzcfhVar);
        this.f77656b = zzcddVar;
        this.f77657c = new zzcda(4096, 4096, zzcddVar);
    }

    private final List a(int i3, short s2, byte b3, int i4) throws IOException {
        zzcdd zzcddVar = this.f77656b;
        zzcddVar.f77650f = i3;
        zzcddVar.f77647b = i3;
        zzcddVar.f77651g = s2;
        zzcddVar.f77648c = b3;
        zzcddVar.f77649d = i4;
        zzcda zzcdaVar = this.f77657c;
        zzcdaVar.b();
        return zzcdaVar.c();
    }

    private final void b(zzccw zzccwVar, int i3) {
        zzcfh zzcfhVar = this.f77655a;
        zzcfhVar.zzm();
        zzcfhVar.zzj();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.places.internal.zzccx
    public final boolean a0(zzccw zzccwVar) throws IOException {
        try {
            this.f77655a.zzg(9L);
            zzcfh zzcfhVar = this.f77655a;
            int iF = zzcdh.f(zzcfhVar);
            if (iF > 16384) {
                throw zzcdh.i("FRAME_SIZE_ERROR: %s", Integer.valueOf(iF));
            }
            byte bZzj = (byte) (zzcfhVar.zzj() & 255);
            byte bZzj2 = (byte) (zzcfhVar.zzj() & 255);
            int iZzm = zzcfhVar.zzm() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            Logger logger = zzcdh.f77663a;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                zzcdh.f77663a.logp(level, "io.grpc.okhttp.internal.framed.Http2$Reader", "nextFrame", zzcde.a(true, iZzm, iF, bZzj, bZzj2));
            }
            switch (bZzj) {
                case 0:
                    boolean z2 = bZzj2 & 1;
                    if ((bZzj2 & 32) != 0) {
                        throw zzcdh.i("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                    }
                    int iZzj = (bZzj2 & 8) != 0 ? zzcfhVar.zzj() & 255 : 0;
                    zzccwVar.H(1 == z2, iZzm, zzcfhVar, zzcdh.e(iF, bZzj2, (short) iZzj), iF);
                    zzcfhVar.x0(iZzj);
                    return true;
                case 1:
                    if (iZzm == 0) {
                        throw zzcdh.i("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                    }
                    boolean z3 = bZzj2 & 32;
                    boolean z4 = bZzj2 & 1;
                    int iZzj2 = (bZzj2 & 8) != 0 ? zzcfhVar.zzj() & 255 : 0;
                    if (z3 != 0) {
                        b(zzccwVar, iZzm);
                        iF -= 5;
                    }
                    short s2 = (short) iZzj2;
                    zzccwVar.I(false, 1 == z4, iZzm, -1, a(zzcdh.e(iF, bZzj2, s2), s2, bZzj2, iZzm), 4);
                    return true;
                case 2:
                    if (iF != 5) {
                        throw zzcdh.i("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iF));
                    }
                    if (iZzm == 0) {
                        throw zzcdh.i("TYPE_PRIORITY streamId == 0", new Object[0]);
                    }
                    b(zzccwVar, iZzm);
                    return true;
                case 3:
                    if (iF != 4) {
                        throw zzcdh.i("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iF));
                    }
                    if (iZzm == 0) {
                        throw zzcdh.i("TYPE_RST_STREAM streamId == 0", new Object[0]);
                    }
                    int iZzm2 = zzcfhVar.zzm();
                    zzccv zzccvVarA = zzccv.a(iZzm2);
                    if (zzccvVarA == null) {
                        throw zzcdh.i("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iZzm2));
                    }
                    zzccwVar.G(iZzm, zzccvVarA);
                    return true;
                case 4:
                    if (iZzm != 0) {
                        throw zzcdh.i("TYPE_SETTINGS streamId != 0", new Object[0]);
                    }
                    if ((bZzj2 & 1) == 0) {
                        if (iF % 6 != 0) {
                            throw zzcdh.i("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(iF));
                        }
                        zzcdk zzcdkVar = new zzcdk();
                        for (int i3 = 0; i3 < iF; i3 += 6) {
                            short sZzl = zzcfhVar.zzl();
                            int iZzm3 = zzcfhVar.zzm();
                            switch (sZzl) {
                                case 1:
                                case 6:
                                    zzcdkVar.a(sZzl, 0, iZzm3);
                                    break;
                                case 2:
                                    if (iZzm3 != 0 && iZzm3 != 1) {
                                        throw zzcdh.i("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    }
                                    zzcdkVar.a(sZzl, 0, iZzm3);
                                    break;
                                case 3:
                                    sZzl = 4;
                                    zzcdkVar.a(sZzl, 0, iZzm3);
                                    break;
                                case 4:
                                    if (iZzm3 < 0) {
                                        throw zzcdh.i("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    }
                                    sZzl = 7;
                                    zzcdkVar.a(sZzl, 0, iZzm3);
                                    break;
                                    break;
                                case 5:
                                    if (iZzm3 < 16384 || iZzm3 > 16777215) {
                                        throw zzcdh.i("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iZzm3));
                                    }
                                    zzcdkVar.a(sZzl, 0, iZzm3);
                                    break;
                                default:
                                    break;
                            }
                        }
                        zzccwVar.M(false, zzcdkVar);
                        if (zzcdkVar.e() >= 0) {
                            this.f77657c.a(zzcdkVar.e());
                        }
                    } else if (iF != 0) {
                        throw zzcdh.i("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    }
                    return true;
                case 5:
                    if (iZzm == 0) {
                        throw zzcdh.i("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                    }
                    short sZzj = (short) ((bZzj2 & 8) != 0 ? zzcfhVar.zzj() & 255 : 0);
                    zzccwVar.N(iZzm, zzcfhVar.zzm() & Api.BaseClientBuilder.API_PRIORITY_OTHER, a(zzcdh.e(iF - 4, bZzj2, sZzj), sZzj, bZzj2, iZzm));
                    return true;
                case 6:
                    if (iF != 8) {
                        throw zzcdh.i("TYPE_PING length != 8: %s", Integer.valueOf(iF));
                    }
                    if (iZzm != 0) {
                        throw zzcdh.i("TYPE_PING streamId != 0", new Object[0]);
                    }
                    zzccwVar.J(1 == (bZzj2 & 1), zzcfhVar.zzm(), zzcfhVar.zzm());
                    return true;
                case 7:
                    if (iF < 8) {
                        throw zzcdh.i("TYPE_GOAWAY length < 8: %s", Integer.valueOf(iF));
                    }
                    if (iZzm != 0) {
                        throw zzcdh.i("TYPE_GOAWAY streamId != 0", new Object[0]);
                    }
                    int i4 = iF - 8;
                    int iZzm4 = zzcfhVar.zzm();
                    int iZzm5 = zzcfhVar.zzm();
                    zzccv zzccvVarA2 = zzccv.a(iZzm5);
                    if (zzccvVarA2 == null) {
                        throw zzcdh.i("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iZzm5));
                    }
                    zzcfj zzcfjVarZ1 = zzcfj.f77742d;
                    if (i4 > 0) {
                        zzcfjVarZ1 = zzcfhVar.z1(i4);
                    }
                    zzccwVar.L(iZzm4, zzccvVarA2, zzcfjVarZ1);
                    return true;
                case 8:
                    if (iF != 4) {
                        throw zzcdh.i("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iF));
                    }
                    long jZzm = ((long) zzcfhVar.zzm()) & 2147483647L;
                    if (jZzm == 0) {
                        throw zzcdh.i("windowSizeIncrement was 0", new Object[0]);
                    }
                    zzccwVar.K(iZzm, jZzm);
                    return true;
                default:
                    zzcfhVar.x0(iF);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f77655a.close();
    }
}

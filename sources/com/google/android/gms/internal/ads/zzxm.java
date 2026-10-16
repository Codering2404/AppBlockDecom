package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzxm {
    void zzD(zzxi zzxiVar);

    zzxi zzG(zzxk zzxkVar, zzabl zzablVar, long j3);

    default zzbf zzH() {
        return null;
    }

    default boolean zzI() {
        return true;
    }

    zzak zzJ();

    void zzl(Handler handler, zzxv zzxvVar);

    void zzm(zzxv zzxvVar);

    void zzn(Handler handler, zzuj zzujVar);

    void zzo(zzuj zzujVar);

    void zzp(zzxl zzxlVar, zzin zzinVar, zzqf zzqfVar);

    void zzq(zzxl zzxlVar);

    void zzr(zzxl zzxlVar);

    void zzs(zzxl zzxlVar);

    void zzt() throws IOException;

    default void zzA(zzak zzakVar) {
    }
}

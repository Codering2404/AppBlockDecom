package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Process;
import com.google.android.gms.internal.common.zzi;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzx;
import com.google.android.gms.internal.common.zzy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProcessUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f72283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f72284b;

    public static String a() {
        if (f72283a == null) {
            f72283a = Application.getProcessName();
        }
        return f72283a;
    }

    public static boolean b() {
        Boolean boolValueOf = f72284b;
        if (boolValueOf == null) {
            if (PlatformVersion.f()) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objZza = zzj.zza(Process.class, "isIsolated", new zzi[0]);
                    Object[] objArr = new Object[0];
                    if (objZza == null) {
                        throw new zzy(zzx.zza("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objZza;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            f72284b = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}

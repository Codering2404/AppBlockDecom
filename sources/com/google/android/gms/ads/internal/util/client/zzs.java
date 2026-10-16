package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs {
    public static Object a(Context context, String str, zzq zzqVar) throws zzr {
        try {
            return zzqVar.zza(c(context).d(str));
        } catch (Exception e3) {
            throw new zzr(e3);
        }
    }

    public static Context b(Context context) {
        return c(context).b();
    }

    private static DynamiteModule c(Context context) throws zzr {
        try {
            return DynamiteModule.e(context, DynamiteModule.f72395b, ModuleDescriptor.MODULE_ID);
        } catch (Exception e3) {
            throw new zzr(e3);
        }
    }
}

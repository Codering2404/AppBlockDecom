package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzaex {
    private zzaex() {
    }

    public static Object zza(String str, Type type) throws zzacn {
        if (type == String.class) {
            try {
                zzagt zzagtVar = (zzagt) new zzagt().zza(str);
                if (zzagtVar.zzb()) {
                    return zzagtVar.zza();
                }
                throw new zzacn("No error message: " + str);
            } catch (Exception e3) {
                throw new zzacn("Json conversion failed! " + e3.getMessage(), e3);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            try {
                return ((zzaez) ((Class) type).getConstructor(null).newInstance(null)).zza(str);
            } catch (Exception e4) {
                throw new zzacn("Json conversion failed! " + e4.getMessage(), e4);
            }
        } catch (Exception e5) {
            throw new zzacn("Instantiation of JsonResponse failed! " + String.valueOf(type), e5);
        }
    }
}

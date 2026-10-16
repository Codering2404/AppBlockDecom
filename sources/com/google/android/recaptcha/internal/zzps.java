package com.google.android.recaptcha.internal;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzps {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzpr zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzps.<clinit>():void");
    }

    private zzps() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i3 = zzks.zza;
        Field fieldZzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (fieldZzC != null) {
            return fieldZzC;
        }
        Field fieldZzC2 = zzC(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (fieldZzC2 == null || fieldZzC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j3, byte b3) {
        zzpr zzprVar = zzf;
        long j4 = (-4) & j3;
        int i3 = zzprVar.zza.getInt(obj, j4);
        int i4 = ((~((int) j3)) & 3) << 3;
        zzprVar.zza.putInt(obj, j4, ((255 & b3) << i4) | (i3 & (~(255 << i4))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j3, byte b3) {
        zzpr zzprVar = zzf;
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        zzprVar.zza.putInt(obj, j4, ((255 & b3) << i3) | (zzprVar.zza.getInt(obj, j4) & (~(255 << i3))));
    }

    static double zza(Object obj, long j3) {
        return zzf.zza(obj, j3);
    }

    static float zzb(Object obj, long j3) {
        return zzf.zzb(obj, j3);
    }

    static int zzc(Object obj, long j3) {
        return zzf.zza.getInt(obj, j3);
    }

    static long zzd(Object obj, long j3) {
        return zzf.zza.getLong(obj, j3);
    }

    static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    static Object zzf(Object obj, long j3) {
        return zzf.zza.getObject(obj, j3);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzpo());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzps.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    static void zzm(Object obj, long j3, boolean z2) {
        zzf.zzc(obj, j3, z2);
    }

    static void zzn(byte[] bArr, long j3, byte b3) {
        zzf.zzd(bArr, zza + j3, b3);
    }

    static void zzo(Object obj, long j3, double d3) {
        zzf.zze(obj, j3, d3);
    }

    static void zzp(Object obj, long j3, float f3) {
        zzf.zzf(obj, j3, f3);
    }

    static void zzq(Object obj, long j3, int i3) {
        zzf.zza.putInt(obj, j3, i3);
    }

    static void zzr(Object obj, long j3, long j4) {
        zzf.zza.putLong(obj, j3, j4);
    }

    static void zzs(Object obj, long j3, Object obj2) {
        zzf.zza.putObject(obj, j3, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j3) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j3) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255)) != 0;
    }

    static boolean zzv(Class cls) {
        int i3 = zzks.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j3) {
        return zzf.zzg(obj, j3);
    }

    static boolean zzx() {
        return zzh;
    }

    static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}

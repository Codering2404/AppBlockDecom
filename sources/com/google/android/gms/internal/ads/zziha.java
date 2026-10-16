package com.google.android.gms.internal.ads;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziha {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzigz zzf;
    private static final boolean zzg;
    private static final long zzh;

    static {
        boolean z2;
        zzigz zzigzVar;
        Unsafe unsafeZzr = zzr();
        zzc = unsafeZzr;
        int i3 = zzicn.zza;
        zzd = Memory.class;
        Class cls = Long.TYPE;
        boolean zZzs = zzs(cls);
        zze = zZzs;
        Class cls2 = Integer.TYPE;
        boolean zZzs2 = zzs(cls2);
        zzigz zzigxVar = null;
        if (unsafeZzr != null) {
            if (zZzs) {
                zzigxVar = new zzigy(unsafeZzr);
            } else if (zZzs2) {
                zzigxVar = new zzigx(unsafeZzr);
            }
        }
        zzf = zzigxVar;
        if (zzigxVar != null) {
            try {
                Class<?> cls3 = zzigxVar.zza.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                zzC();
            } catch (Throwable th) {
                zzz(th);
            }
        }
        zzigz zzigzVar2 = zzf;
        if (zzigzVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls4 = zzigzVar2.zza.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                zzz(th2);
                z2 = false;
            }
        }
        zzg = z2;
        zza = zzA(byte[].class);
        zzA(boolean[].class);
        zzB(boolean[].class);
        zzA(int[].class);
        zzB(int[].class);
        zzA(long[].class);
        zzB(long[].class);
        zzA(float[].class);
        zzB(float[].class);
        zzA(double[].class);
        zzB(double[].class);
        zzA(Object[].class);
        zzB(Object[].class);
        Field fieldZzC = zzC();
        long jObjectFieldOffset = -1;
        if (fieldZzC != null && (zzigzVar = zzf) != null) {
            jObjectFieldOffset = zzigzVar.zza.objectFieldOffset(fieldZzC);
        }
        zzh = jObjectFieldOffset;
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zziha() {
    }

    private static int zzA(Class cls) {
        if (zzg) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzB(Class cls) {
        if (zzg) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzC() {
        int i3 = zzicn.zza;
        Field fieldZzD = zzD(Buffer.class, "effectiveDirectAddress");
        if (fieldZzD != null) {
            return fieldZzD;
        }
        Field fieldZzD2 = zzD(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (fieldZzD2 == null || fieldZzD2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzD2;
    }

    private static Field zzD(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j3, byte b3) {
        Unsafe unsafe = zzf.zza;
        long j4 = (-4) & j3;
        int i3 = unsafe.getInt(obj, j4);
        int i4 = ((~((int) j3)) & 3) << 3;
        unsafe.putInt(obj, j4, ((255 & b3) << i4) | (i3 & (~(255 << i4))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzF(Object obj, long j3, byte b3) {
        Unsafe unsafe = zzf.zza;
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        unsafe.putInt(obj, j4, ((255 & b3) << i3) | (unsafe.getInt(obj, j4) & (~(255 << i3))));
    }

    static boolean zza() {
        return zzg;
    }

    static Object zzb(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    static int zzc(Object obj, long j3) {
        return zzf.zza.getInt(obj, j3);
    }

    static void zzd(Object obj, long j3, int i3) {
        zzf.zza.putInt(obj, j3, i3);
    }

    static long zze(Object obj, long j3) {
        return zzf.zza.getLong(obj, j3);
    }

    static void zzf(Object obj, long j3, long j4) {
        zzf.zza.putLong(obj, j3, j4);
    }

    static boolean zzg(Object obj, long j3) {
        return zzf.zzb(obj, j3);
    }

    static void zzh(Object obj, long j3, boolean z2) {
        zzf.zzc(obj, j3, z2);
    }

    static float zzi(Object obj, long j3) {
        return zzf.zzd(obj, j3);
    }

    static void zzj(Object obj, long j3, float f3) {
        zzf.zze(obj, j3, f3);
    }

    static double zzk(Object obj, long j3) {
        return zzf.zzf(obj, j3);
    }

    static void zzl(Object obj, long j3, double d3) {
        zzf.zzg(obj, j3, d3);
    }

    static Object zzm(Object obj, long j3) {
        return zzf.zza.getObject(obj, j3);
    }

    static void zzn(Object obj, long j3, Object obj2) {
        zzf.zza.putObject(obj, j3, obj2);
    }

    static void zzo(byte[] bArr, long j3, byte b3) {
        zzf.zza(bArr, zza + j3, b3);
    }

    static byte zzp(long j3) {
        return zzf.zzh(j3);
    }

    static long zzq(ByteBuffer byteBuffer) {
        zzigz zzigzVar = zzf;
        return zzigzVar.zza.getLong(byteBuffer, zzh);
    }

    static Unsafe zzr() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzigw());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(zziha.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "getUnsafe", "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    static boolean zzs(Class cls) {
        int i3 = zzicn.zza;
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

    static /* synthetic */ boolean zzv(Object obj, long j3) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzw(Object obj, long j3) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ void zzz(Throwable th) {
        Logger.getLogger(zziha.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }
}

package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DynamiteModule {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Boolean f72401h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f72402i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f72403j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f72404k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Boolean f72405l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static zzp f72411r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static zzq f72412s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f72413a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ThreadLocal f72406m = new ThreadLocal();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ThreadLocal f72407n = new zze();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final VersionPolicy.IVersions f72408o = new zzf();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VersionPolicy f72395b = new zzg();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final VersionPolicy f72396c = new zzh();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final VersionPolicy f72397d = new zzi();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final VersionPolicy f72398e = new zzj();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final VersionPolicy f72399f = new zzk();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final VersionPolicy f72400g = new zzl();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final VersionPolicy f72409p = new zzm();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final VersionPolicy f72410q = new zzc();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, Throwable th, byte[] bArr) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, byte[] bArr) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface VersionPolicy {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface IVersions {
            int a(Context context, String str, boolean z2);

            int b(Context context, String str);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class SelectionResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f72414a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f72415b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f72416c = 0;
        }

        SelectionResult a(Context context, String str, IVersions iVersions);
    }

    private DynamiteModule(Context context) {
        Preconditions.m(context);
        this.f72413a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.b(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 50 + String.valueOf(str).length() + 1);
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e3) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e3.getMessage())));
            return 0;
        }
    }

    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02dd A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #1 {all -> 0x00c3, blocks: (B:5:0x0045, B:9:0x00bc, B:16:0x00c8, B:19:0x00ce, B:32:0x00ec, B:109:0x027d, B:110:0x0288, B:118:0x0298, B:120:0x02c0, B:122:0x02cf, B:132:0x02ef, B:133:0x02f7, B:113:0x028b, B:114:0x028c, B:115:0x0294, B:134:0x02f8, B:135:0x0319, B:136:0x031a, B:137:0x036c), top: B:150:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.google.android.gms.dynamite.DynamiteModule$VersionPolicy] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.dynamite.DynamiteModule e(android.content.Context r30, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r31, java.lang.String r32) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            Method dump skipped, instruction units count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x018d A[Catch: all -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00f2, blocks: (B:4:0x0006, B:65:0x00e7, B:67:0x00ed, B:75:0x011b, B:103:0x017f, B:107:0x018d, B:125:0x01ea, B:126:0x01ed, B:120:0x01e1, B:73:0x00f8, B:128:0x01ef, B:5:0x0007, B:8:0x000d, B:9:0x0029, B:63:0x00e4, B:22:0x004d, B:46:0x00a3, B:49:0x00a6, B:56:0x00be, B:64:0x00e6, B:62:0x00c4), top: B:141:0x0006, inners: #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2 A[Catch: all -> 0x003a, TryCatch #11 {, blocks: (B:10:0x002a, B:12:0x0036, B:53:0x00bb, B:17:0x003f, B:19:0x0046, B:21:0x004c, B:26:0x0053, B:28:0x0057, B:32:0x0061, B:34:0x0069, B:37:0x0070, B:44:0x009a, B:45:0x00a2, B:40:0x0077, B:42:0x007d, B:43:0x008c, B:48:0x00a5, B:51:0x00a8, B:52:0x00b2, B:18:0x0042), top: B:142:0x002a, inners: #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(android.content.Context r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f72405l)) {
            return true;
        }
        boolean z2 = false;
        if (f72405l == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != PlatformVersion.g() ? 0 : 268435456);
            if (GoogleApiAvailabilityLight.h().j(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z2 = true;
            }
            f72405l = Boolean.valueOf(z2);
            if (z2 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f72403j = true;
            }
        }
        if (!z2) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0147: MOVE (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:328), block:B:92:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int h(android.content.Context r14, java.lang.String r15, boolean r16, boolean r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.h(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static boolean i(Cursor cursor) {
        zzn zznVar = (zzn) f72406m.get();
        if (zznVar == null || zznVar.f72419a != null) {
            return false;
        }
        zznVar.f72419a = cursor;
        return true;
    }

    private static DynamiteModule j(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void k(ClassLoader classLoader) throws LoadingException {
        zzq zzqVar;
        byte[] bArr = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                zzqVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
            }
            f72412s = zzqVar;
        } catch (ClassNotFoundException e3) {
            e = e3;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (InstantiationException e5) {
            e = e5;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (InvocationTargetException e7) {
            e = e7;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        }
    }

    private static zzp l(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = f72411r;
            if (zzpVar2 != null) {
                return zzpVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzpVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzpVar = iInterfaceQueryLocalInterface instanceof zzp ? (zzp) iInterfaceQueryLocalInterface : new zzp(iBinder);
                }
                if (zzpVar != null) {
                    f72411r = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e3) {
                String message = e3.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    public Context b() {
        return this.f72413a;
    }

    public IBinder d(String str) throws LoadingException {
        try {
            return (IBinder) this.f72413a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e3) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e3, null);
        }
    }
}

package com.google.android.libraries.places.internal;

import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfa<T> implements zzbfl<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f76124m = new int[0];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Unsafe f76125n = zzbgf.v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f76126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f76127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f76128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f76129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbex f76130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f76131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f76132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f76133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f76134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f76135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbfy f76136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzbdc f76137l;

    private zzbfa(int[] iArr, Object[] objArr, int i3, int i4, zzbex zzbexVar, boolean z2, int[] iArr2, int i5, int i6, zzbfd zzbfdVar, zzbek zzbekVar, zzbfy zzbfyVar, zzbdc zzbdcVar, zzbes zzbesVar) {
        this.f76126a = iArr;
        this.f76127b = objArr;
        this.f76128c = i3;
        this.f76129d = i4;
        this.f76132g = zzbexVar instanceof zzbdq;
        boolean z3 = false;
        if (zzbdcVar != null && (zzbexVar instanceof zzbdn)) {
            z3 = true;
        }
        this.f76131f = z3;
        this.f76133h = iArr2;
        this.f76134i = i5;
        this.f76135j = i6;
        this.f76136k = zzbfyVar;
        this.f76137l = zzbdcVar;
        this.f76130e = zzbexVar;
    }

    private final Object A(Object obj, int i3, int i4) {
        zzbfl zzbflVarV = v(i4);
        if (!o(obj, i3, i4)) {
            return zzbflVarV.zza();
        }
        Object object = f76125n.getObject(obj, F(i4) & 1048575);
        if (d(object)) {
            return object;
        }
        Object objZza = zzbflVarV.zza();
        if (object != null) {
            zzbflVarV.zzd(objZza, object);
        }
        return objZza;
    }

    private final void B(Object obj, int i3, int i4, Object obj2) {
        f76125n.putObject(obj, F(i4) & 1048575, obj2);
        p(obj, i3, i4);
    }

    private final Object C(Object obj, int i3, Object obj2, zzbfy zzbfyVar, Object obj3) {
        int i4 = this.f76126a[i3];
        Object objS = zzbgf.s(obj, F(i3) & 1048575);
        if (objS == null || x(i3) == null) {
            return obj2;
        }
        throw null;
    }

    private static boolean D(Object obj, int i3, zzbfl zzbflVar) {
        return zzbflVar.zzi(zzbgf.s(obj, i3 & 1048575));
    }

    private final void E(Object obj, int i3, zzbfk zzbfkVar) {
        long j3 = i3 & 1048575;
        if (c(i3)) {
            zzbgf.t(obj, j3, zzbfkVar.zzn());
        } else if (this.f76132g) {
            zzbgf.t(obj, j3, zzbfkVar.zzm());
        } else {
            zzbgf.t(obj, j3, zzbfkVar.zzs());
        }
    }

    private final int F(int i3) {
        return this.f76126a[i3 + 1];
    }

    private final int G(int i3) {
        return this.f76126a[i3 + 2];
    }

    private static int H(int i3) {
        return (i3 >>> 20) & 255;
    }

    private static boolean c(int i3) {
        return (i3 & 536870912) != 0;
    }

    private static boolean d(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzbdq) {
            return ((zzbdq) obj).v();
        }
        return true;
    }

    private static void e(Object obj) {
        if (!d(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private static double f(Object obj, long j3) {
        return ((Double) zzbgf.s(obj, j3)).doubleValue();
    }

    private static float g(Object obj, long j3) {
        return ((Float) zzbgf.s(obj, j3)).floatValue();
    }

    private static int h(Object obj, long j3) {
        return ((Integer) zzbgf.s(obj, j3)).intValue();
    }

    private static long i(Object obj, long j3) {
        return ((Long) zzbgf.s(obj, j3)).longValue();
    }

    private static boolean j(Object obj, long j3) {
        return ((Boolean) zzbgf.s(obj, j3)).booleanValue();
    }

    private final boolean k(Object obj, Object obj2, int i3) {
        return m(obj, i3) == m(obj2, i3);
    }

    private final boolean l(Object obj, int i3, int i4, int i5, int i6) {
        return i4 == 1048575 ? m(obj, i3) : (i5 & i6) != 0;
    }

    private final boolean m(Object obj, int i3) {
        int iG = G(i3);
        long j3 = iG & 1048575;
        if (j3 != 1048575) {
            return (zzbgf.i(obj, j3) & (1 << (iG >>> 20))) != 0;
        }
        int iF = F(i3);
        long j4 = iF & 1048575;
        switch (H(iF)) {
            case 0:
                return Double.doubleToRawLongBits(zzbgf.q(obj, j4)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzbgf.o(obj, j4)) != 0;
            case 2:
                return zzbgf.k(obj, j4) != 0;
            case 3:
                return zzbgf.k(obj, j4) != 0;
            case 4:
                return zzbgf.i(obj, j4) != 0;
            case 5:
                return zzbgf.k(obj, j4) != 0;
            case 6:
                return zzbgf.i(obj, j4) != 0;
            case 7:
                return zzbgf.m(obj, j4);
            case 8:
                Object objS = zzbgf.s(obj, j4);
                if (objS instanceof String) {
                    return !((String) objS).isEmpty();
                }
                if (objS instanceof zzbcl) {
                    return !zzbcl.f75997b.equals(objS);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzbgf.s(obj, j4) != null;
            case 10:
                return !zzbcl.f75997b.equals(zzbgf.s(obj, j4));
            case 11:
                return zzbgf.i(obj, j4) != 0;
            case 12:
                return zzbgf.i(obj, j4) != 0;
            case 13:
                return zzbgf.i(obj, j4) != 0;
            case 14:
                return zzbgf.k(obj, j4) != 0;
            case 15:
                return zzbgf.i(obj, j4) != 0;
            case 16:
                return zzbgf.k(obj, j4) != 0;
            case 17:
                return zzbgf.s(obj, j4) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void n(Object obj, int i3) {
        int iG = G(i3);
        long j3 = 1048575 & iG;
        if (j3 == 1048575) {
            return;
        }
        zzbgf.j(obj, j3, (1 << (iG >>> 20)) | zzbgf.i(obj, j3));
    }

    private final boolean o(Object obj, int i3, int i4) {
        return zzbgf.i(obj, (long) (G(i4) & 1048575)) == i3;
    }

    private final void p(Object obj, int i3, int i4) {
        zzbgf.j(obj, G(i4) & 1048575, i3);
    }

    private static final void q(int i3, Object obj, zzbgl zzbglVar) {
        if (obj instanceof String) {
            zzbglVar.zzm(i3, (String) obj);
        } else {
            zzbglVar.a(i3, (zzbcl) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.libraries.places.internal.zzbfa r(java.lang.Class r32, com.google.android.libraries.places.internal.zzbeu r33, com.google.android.libraries.places.internal.zzbfd r34, com.google.android.libraries.places.internal.zzbek r35, com.google.android.libraries.places.internal.zzbfy r36, com.google.android.libraries.places.internal.zzbdc r37, com.google.android.libraries.places.internal.zzbes r38) {
        /*
            Method dump skipped, instruction units count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfa.r(java.lang.Class, com.google.android.libraries.places.internal.zzbeu, com.google.android.libraries.places.internal.zzbfd, com.google.android.libraries.places.internal.zzbek, com.google.android.libraries.places.internal.zzbfy, com.google.android.libraries.places.internal.zzbdc, com.google.android.libraries.places.internal.zzbes):com.google.android.libraries.places.internal.zzbfa");
    }

    private static Field s(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e3) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + name.length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    private final void t(Object obj, Object obj2, int i3) {
        if (m(obj2, i3)) {
            int iF = F(i3) & 1048575;
            Unsafe unsafe = f76125n;
            long j3 = iF;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                int i4 = this.f76126a[i3];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i4);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzbfl zzbflVarV = v(i3);
            if (!m(obj, i3)) {
                if (d(object)) {
                    Object objZza = zzbflVarV.zza();
                    zzbflVarV.zzd(objZza, object);
                    unsafe.putObject(obj, j3, objZza);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                n(obj, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!d(object2)) {
                Object objZza2 = zzbflVarV.zza();
                zzbflVarV.zzd(objZza2, object2);
                unsafe.putObject(obj, j3, objZza2);
                object2 = objZza2;
            }
            zzbflVarV.zzd(object2, object);
        }
    }

    private final void u(Object obj, Object obj2, int i3) {
        int[] iArr = this.f76126a;
        int i4 = iArr[i3];
        if (o(obj2, i4, i3)) {
            int iF = F(i3) & 1048575;
            Unsafe unsafe = f76125n;
            long j3 = iF;
            Object object = unsafe.getObject(obj2, j3);
            if (object == null) {
                int i5 = iArr[i3];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i5);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzbfl zzbflVarV = v(i3);
            if (!o(obj, i4, i3)) {
                if (d(object)) {
                    Object objZza = zzbflVarV.zza();
                    zzbflVarV.zzd(objZza, object);
                    unsafe.putObject(obj, j3, objZza);
                } else {
                    unsafe.putObject(obj, j3, object);
                }
                p(obj, i4, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j3);
            if (!d(object2)) {
                Object objZza2 = zzbflVarV.zza();
                zzbflVarV.zzd(objZza2, object2);
                unsafe.putObject(obj, j3, objZza2);
                object2 = objZza2;
            }
            zzbflVarV.zzd(object2, object);
        }
    }

    private final zzbfl v(int i3) {
        Object[] objArr = this.f76127b;
        int i4 = i3 / 3;
        int i5 = i4 + i4;
        zzbfl zzbflVar = (zzbfl) objArr[i5];
        if (zzbflVar != null) {
            return zzbflVar;
        }
        zzbfl zzbflVarB = zzbfh.a().b((Class) objArr[i5 + 1]);
        objArr[i5] = zzbflVarB;
        return zzbflVarB;
    }

    private final Object w(int i3) {
        int i4 = i3 / 3;
        return this.f76127b[i4 + i4];
    }

    private final zzbdw x(int i3) {
        int i4 = i3 / 3;
        return (zzbdw) this.f76127b[i4 + i4 + 1];
    }

    private final Object y(Object obj, int i3) {
        zzbfl zzbflVarV = v(i3);
        int iF = F(i3) & 1048575;
        if (!m(obj, i3)) {
            return zzbflVarV.zza();
        }
        Object object = f76125n.getObject(obj, iF);
        if (d(object)) {
            return object;
        }
        Object objZza = zzbflVarV.zza();
        if (object != null) {
            zzbflVarV.zzd(objZza, object);
        }
        return objZza;
    }

    private final void z(Object obj, int i3, Object obj2) {
        f76125n.putObject(obj, F(i3) & 1048575, obj2);
        n(obj, i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.libraries.places.internal.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r21, com.google.android.libraries.places.internal.zzbgl r22) {
        /*
            Method dump skipped, instruction units count: 1454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfa.a(java.lang.Object, com.google.android.libraries.places.internal.zzbgl):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:260:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x08af A[LOOP:4: B:264:0x08ab->B:266:0x08af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x08c0  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0881 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x020c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x088e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:317:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ac A[Catch: all -> 0x0089, TryCatch #8 {all -> 0x0089, blocks: (B:35:0x0083, B:39:0x0090, B:41:0x0098, B:42:0x009c, B:75:0x019f, B:83:0x01c4, B:80:0x01ac, B:82:0x01b2, B:44:0x00a2, B:45:0x00ac, B:46:0x00b6, B:47:0x00c0, B:48:0x00ca, B:49:0x00d1, B:50:0x00d2, B:51:0x00dc, B:52:0x00e2, B:54:0x00ea, B:56:0x00ff, B:57:0x010a, B:58:0x010f, B:59:0x011b, B:61:0x0123, B:63:0x0138, B:64:0x0143, B:65:0x0148, B:66:0x0153, B:67:0x0158, B:68:0x0161, B:69:0x016a, B:70:0x0173, B:71:0x017c, B:72:0x0185, B:73:0x018e, B:74:0x0197, B:86:0x01cb, B:87:0x01ce, B:89:0x01d1), top: B:281:0x0083 }] */
    @Override // com.google.android.libraries.places.internal.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.Object r19, com.google.android.libraries.places.internal.zzbfk r20, com.google.android.libraries.places.internal.zzbdb r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfa.b(java.lang.Object, com.google.android.libraries.places.internal.zzbfk, com.google.android.libraries.places.internal.zzbdb):void");
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final Object zza() {
        return ((zzbdq) this.f76130e).x();
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final boolean zzb(Object obj, Object obj2) {
        boolean zC;
        for (int i3 = 0; i3 < this.f76126a.length; i3 += 3) {
            int iF = F(i3);
            long j3 = iF & 1048575;
            switch (H(iF)) {
                case 0:
                    if (!k(obj, obj2, i3) || Double.doubleToLongBits(zzbgf.q(obj, j3)) != Double.doubleToLongBits(zzbgf.q(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!k(obj, obj2, i3) || Float.floatToIntBits(zzbgf.o(obj, j3)) != Float.floatToIntBits(zzbgf.o(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!k(obj, obj2, i3) || zzbgf.k(obj, j3) != zzbgf.k(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!k(obj, obj2, i3) || zzbgf.k(obj, j3) != zzbgf.k(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!k(obj, obj2, i3) || zzbgf.i(obj, j3) != zzbgf.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!k(obj, obj2, i3) || zzbgf.k(obj, j3) != zzbgf.k(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!k(obj, obj2, i3) || zzbgf.i(obj, j3) != zzbgf.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!k(obj, obj2, i3) || zzbgf.m(obj, j3) != zzbgf.m(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!k(obj, obj2, i3) || !zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!k(obj, obj2, i3) || !zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!k(obj, obj2, i3) || !zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!k(obj, obj2, i3) || zzbgf.i(obj, j3) != zzbgf.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!k(obj, obj2, i3) || zzbgf.i(obj, j3) != zzbgf.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!k(obj, obj2, i3) || zzbgf.i(obj, j3) != zzbgf.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!k(obj, obj2, i3) || zzbgf.k(obj, j3) != zzbgf.k(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!k(obj, obj2, i3) || zzbgf.i(obj, j3) != zzbgf.i(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!k(obj, obj2, i3) || zzbgf.k(obj, j3) != zzbgf.k(obj2, j3)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!k(obj, obj2, i3) || !zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zC = zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3));
                    break;
                case 50:
                    zC = zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jG = G(i3) & 1048575;
                    if (zzbgf.i(obj, jG) != zzbgf.i(obj2, jG) || !zzbfn.c(zzbgf.s(obj, j3), zzbgf.s(obj2, j3))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zC) {
                return false;
            }
        }
        if (!((zzbdq) obj).zzc.equals(((zzbdq) obj2).zzc)) {
            return false;
        }
        if (this.f76131f) {
            return ((zzbdn) obj).zzb.equals(((zzbdn) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final int zzc(Object obj) {
        int i3;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f76126a;
            if (i5 >= iArr.length) {
                int iHashCode = (i6 * 53) + ((zzbdq) obj).zzc.hashCode();
                return this.f76131f ? (iHashCode * 53) + ((zzbdn) obj).zzb.f76045a.hashCode() : iHashCode;
            }
            int iF = F(i5);
            int i7 = 1048575 & iF;
            int iH = H(iF);
            int i8 = iArr[i5];
            long j3 = i7;
            int iHashCode2 = 37;
            switch (iH) {
                case 0:
                    i3 = i6 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzbgf.q(obj, j3));
                    byte[] bArr = zzbeb.f76092b;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 1:
                    i3 = i6 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzbgf.o(obj, j3));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 2:
                    i3 = i6 * 53;
                    jDoubleToLongBits = zzbgf.k(obj, j3);
                    byte[] bArr2 = zzbeb.f76092b;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 3:
                    i3 = i6 * 53;
                    jDoubleToLongBits = zzbgf.k(obj, j3);
                    byte[] bArr3 = zzbeb.f76092b;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 4:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.i(obj, j3);
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 5:
                    i3 = i6 * 53;
                    jDoubleToLongBits = zzbgf.k(obj, j3);
                    byte[] bArr4 = zzbeb.f76092b;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 6:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.i(obj, j3);
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 7:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbeb.a(zzbgf.m(obj, j3));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 8:
                    i3 = i6 * 53;
                    iFloatToIntBits = ((String) zzbgf.s(obj, j3)).hashCode();
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 9:
                    i4 = i6 * 53;
                    Object objS = zzbgf.s(obj, j3);
                    if (objS != null) {
                        iHashCode2 = objS.hashCode();
                    }
                    i6 = i4 + iHashCode2;
                    break;
                case 10:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.s(obj, j3).hashCode();
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 11:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.i(obj, j3);
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 12:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.i(obj, j3);
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 13:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.i(obj, j3);
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 14:
                    i3 = i6 * 53;
                    jDoubleToLongBits = zzbgf.k(obj, j3);
                    byte[] bArr5 = zzbeb.f76092b;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 15:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.i(obj, j3);
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 16:
                    i3 = i6 * 53;
                    jDoubleToLongBits = zzbgf.k(obj, j3);
                    byte[] bArr6 = zzbeb.f76092b;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 17:
                    i4 = i6 * 53;
                    Object objS2 = zzbgf.s(obj, j3);
                    if (objS2 != null) {
                        iHashCode2 = objS2.hashCode();
                    }
                    i6 = i4 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.s(obj, j3).hashCode();
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 50:
                    i3 = i6 * 53;
                    iFloatToIntBits = zzbgf.s(obj, j3).hashCode();
                    i6 = i3 + iFloatToIntBits;
                    break;
                case 51:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(f(obj, j3));
                        byte[] bArr7 = zzbeb.f76092b;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = Float.floatToIntBits(g(obj, j3));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = i(obj, j3);
                        byte[] bArr8 = zzbeb.f76092b;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = i(obj, j3);
                        byte[] bArr9 = zzbeb.f76092b;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = h(obj, j3);
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = i(obj, j3);
                        byte[] bArr10 = zzbeb.f76092b;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = h(obj, j3);
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = zzbeb.a(j(obj, j3));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = ((String) zzbgf.s(obj, j3)).hashCode();
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = zzbgf.s(obj, j3).hashCode();
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = zzbgf.s(obj, j3).hashCode();
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = h(obj, j3);
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = h(obj, j3);
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = h(obj, j3);
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = i(obj, j3);
                        byte[] bArr11 = zzbeb.f76092b;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = h(obj, j3);
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        jDoubleToLongBits = i(obj, j3);
                        byte[] bArr12 = zzbeb.f76092b;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (o(obj, i8, i5)) {
                        i3 = i6 * 53;
                        iFloatToIntBits = zzbgf.s(obj, j3).hashCode();
                        i6 = i3 + iFloatToIntBits;
                    }
                    break;
            }
            i5 += 3;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbfl
    public final void zzd(Object obj, Object obj2) {
        e(obj);
        obj2.getClass();
        int i3 = 0;
        while (true) {
            int[] iArr = this.f76126a;
            if (i3 >= iArr.length) {
                zzbfn.e(this.f76136k, obj, obj2);
                if (this.f76131f) {
                    zzbfn.d(this.f76137l, obj, obj2);
                    return;
                }
                return;
            }
            int iF = F(i3);
            int i4 = 1048575 & iF;
            int iH = H(iF);
            int i5 = iArr[i3];
            long j3 = i4;
            switch (iH) {
                case 0:
                    if (m(obj2, i3)) {
                        zzbgf.r(obj, j3, zzbgf.q(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 1:
                    if (m(obj2, i3)) {
                        zzbgf.p(obj, j3, zzbgf.o(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 2:
                    if (m(obj2, i3)) {
                        zzbgf.l(obj, j3, zzbgf.k(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 3:
                    if (m(obj2, i3)) {
                        zzbgf.l(obj, j3, zzbgf.k(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 4:
                    if (m(obj2, i3)) {
                        zzbgf.j(obj, j3, zzbgf.i(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 5:
                    if (m(obj2, i3)) {
                        zzbgf.l(obj, j3, zzbgf.k(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 6:
                    if (m(obj2, i3)) {
                        zzbgf.j(obj, j3, zzbgf.i(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 7:
                    if (m(obj2, i3)) {
                        zzbgf.n(obj, j3, zzbgf.m(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 8:
                    if (m(obj2, i3)) {
                        zzbgf.t(obj, j3, zzbgf.s(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 9:
                    t(obj, obj2, i3);
                    break;
                case 10:
                    if (m(obj2, i3)) {
                        zzbgf.t(obj, j3, zzbgf.s(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 11:
                    if (m(obj2, i3)) {
                        zzbgf.j(obj, j3, zzbgf.i(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 12:
                    if (m(obj2, i3)) {
                        zzbgf.j(obj, j3, zzbgf.i(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 13:
                    if (m(obj2, i3)) {
                        zzbgf.j(obj, j3, zzbgf.i(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 14:
                    if (m(obj2, i3)) {
                        zzbgf.l(obj, j3, zzbgf.k(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 15:
                    if (m(obj2, i3)) {
                        zzbgf.j(obj, j3, zzbgf.i(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 16:
                    if (m(obj2, i3)) {
                        zzbgf.l(obj, j3, zzbgf.k(obj2, j3));
                        n(obj, i3);
                    }
                    break;
                case 17:
                    t(obj, obj2, i3);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzbea zzbeaVarZzg = (zzbea) zzbgf.s(obj, j3);
                    zzbea zzbeaVar = (zzbea) zzbgf.s(obj2, j3);
                    int size = zzbeaVarZzg.size();
                    int size2 = zzbeaVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzbeaVarZzg.zza()) {
                            zzbeaVarZzg = zzbeaVarZzg.zzg(size2 + size);
                        }
                        zzbeaVarZzg.addAll(zzbeaVar);
                    }
                    if (size > 0) {
                        zzbeaVar = zzbeaVarZzg;
                    }
                    zzbgf.t(obj, j3, zzbeaVar);
                    break;
                case 50:
                    int i6 = zzbfn.f76155b;
                    zzbgf.t(obj, j3, zzbes.a(zzbgf.s(obj, j3), zzbgf.s(obj2, j3)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (o(obj2, i5, i3)) {
                        zzbgf.t(obj, j3, zzbgf.s(obj2, j3));
                        p(obj, i5, i3);
                    }
                    break;
                case 60:
                    u(obj, obj2, i3);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (o(obj2, i5, i3)) {
                        zzbgf.t(obj, j3, zzbgf.s(obj2, j3));
                        p(obj, i5, i3);
                    }
                    break;
                case 68:
                    u(obj, obj2, i3);
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x047e  */
    @Override // com.google.android.libraries.places.internal.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 2026
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfa.zze(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.libraries.places.internal.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfa.zzh(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Override // com.google.android.libraries.places.internal.zzbfl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzi(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbfa.zzi(java.lang.Object):boolean");
    }
}

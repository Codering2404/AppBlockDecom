package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbdg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzbdg f76044d = new zzbdg(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbfs f76045a = new zzbfo();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f76046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f76047c;

    private zzbdg() {
    }

    public static zzbdg a() {
        return f76044d;
    }

    public static int j(zzbdf zzbdfVar, Object obj) {
        int iD;
        int iB;
        zzbgj zzbgjVarZzb = zzbdfVar.zzb();
        zzbdfVar.zza();
        zzbdfVar.zzd();
        int iB2 = zzbcu.B(-94933856);
        if (zzbgjVarZzb == zzbgj.f76195l) {
            iB2 += iB2;
        }
        zzbgk zzbgkVar = zzbgk.INT;
        int iC = 4;
        switch (zzbgjVarZzb.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                iC = 8;
                return iB2 + iC;
            case 1:
                ((Float) obj).getClass();
                return iB2 + iC;
            case 2:
                iC = zzbcu.C(((Long) obj).longValue());
                return iB2 + iC;
            case 3:
                iC = zzbcu.C(((Long) obj).longValue());
                return iB2 + iC;
            case 4:
                iC = zzbcu.C(((Integer) obj).intValue());
                return iB2 + iC;
            case 5:
                ((Long) obj).getClass();
                iC = 8;
                return iB2 + iC;
            case 6:
                ((Integer) obj).getClass();
                return iB2 + iC;
            case 7:
                ((Boolean) obj).getClass();
                iC = 1;
                return iB2 + iC;
            case 8:
                if (!(obj instanceof zzbcl)) {
                    iC = zzbcu.c((String) obj);
                    return iB2 + iC;
                }
                iD = ((zzbcl) obj).d();
                iB = zzbcu.B(iD);
                iC = iB + iD;
                return iB2 + iC;
            case 9:
                iC = ((zzbex) obj).j();
                return iB2 + iC;
            case 10:
                if (!(obj instanceof zzbeh)) {
                    iC = zzbcu.d((zzbex) obj);
                    return iB2 + iC;
                }
                iD = ((zzbeh) obj).b();
                iB = zzbcu.B(iD);
                iC = iB + iD;
                return iB2 + iC;
            case 11:
                if (obj instanceof zzbcl) {
                    iD = ((zzbcl) obj).d();
                    iB = zzbcu.B(iD);
                } else {
                    iD = ((byte[]) obj).length;
                    iB = zzbcu.B(iD);
                }
                iC = iB + iD;
                return iB2 + iC;
            case 12:
                iC = zzbcu.B(((Integer) obj).intValue());
                return iB2 + iC;
            case 13:
                iC = obj instanceof zzbdu ? zzbcu.C(((zzbdu) obj).zza()) : zzbcu.C(((Integer) obj).intValue());
                return iB2 + iC;
            case 14:
                ((Integer) obj).getClass();
                return iB2 + iC;
            case 15:
                ((Long) obj).getClass();
                iC = 8;
                return iB2 + iC;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iC = zzbcu.B((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iB2 + iC;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iC = zzbcu.C((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iB2 + iC;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean k(Map.Entry entry) {
        zzbdf zzbdfVar = (zzbdf) entry.getKey();
        if (zzbdfVar.zzc() != zzbgk.MESSAGE) {
            return true;
        }
        zzbdfVar.zzd();
        Object value = entry.getValue();
        if (value instanceof zzbey) {
            return ((zzbey) value).c();
        }
        if (value instanceof zzbeh) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static Object l(Object obj) {
        if (obj instanceof zzbfc) {
            return ((zzbfc) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void m(Map.Entry entry) {
        zzbdf zzbdfVar = (zzbdf) entry.getKey();
        Object value = entry.getValue();
        boolean z2 = value instanceof zzbeh;
        zzbdfVar.zzd();
        if (zzbdfVar.zzc() != zzbgk.MESSAGE) {
            if (z2) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.f76045a.put(zzbdfVar, l(value));
            return;
        }
        Object objE = e(zzbdfVar);
        if (objE == null) {
            this.f76045a.put(zzbdfVar, l(value));
            if (z2) {
                this.f76047c = true;
                return;
            }
            return;
        }
        if (z2) {
            throw null;
        }
        if (!zzbdfVar.zzf(objE)) {
            zzbdfVar.zzg(objE, value);
            return;
        }
        zzbew zzbewVarH = ((zzbex) objE).h();
        zzbdfVar.zzg(zzbewVarH, value);
        this.f76045a.put(zzbdfVar, zzbewVarH.zzG());
    }

    private static final int n(Map.Entry entry) {
        int i3;
        int iB;
        int iB2;
        zzbdf zzbdfVar = (zzbdf) entry.getKey();
        Object value = entry.getValue();
        if (zzbdfVar.zzc() != zzbgk.MESSAGE) {
            return j(zzbdfVar, value);
        }
        zzbdfVar.zzd();
        zzbdfVar.zze();
        if (value instanceof zzbeh) {
            ((zzbdf) entry.getKey()).zza();
            int iB3 = zzbcu.B(8);
            i3 = iB3 + iB3;
            iB = zzbcu.B(16) + zzbcu.B(525004180);
            int iB4 = zzbcu.B(24);
            int iB5 = ((zzbeh) value).b();
            iB2 = iB4 + zzbcu.B(iB5) + iB5;
        } else {
            ((zzbdf) entry.getKey()).zza();
            int iB6 = zzbcu.B(8);
            i3 = iB6 + iB6;
            iB = zzbcu.B(16) + zzbcu.B(525004180);
            iB2 = zzbcu.B(24) + zzbcu.d((zzbex) value);
        }
        return i3 + iB + iB2;
    }

    public final void b() {
        if (this.f76046b) {
            return;
        }
        zzbfs zzbfsVar = this.f76045a;
        int iC = zzbfsVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            Object value = zzbfsVar.d(i3).getValue();
            if (value instanceof zzbdq) {
                ((zzbdq) value).z();
            }
        }
        Iterator it = zzbfsVar.e().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzbdq) {
                ((zzbdq) value2).z();
            }
        }
        zzbfsVar.a();
        this.f76046b = true;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final zzbdg clone() {
        zzbdg zzbdgVar = new zzbdg();
        zzbfs zzbfsVar = this.f76045a;
        int iC = zzbfsVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            Map.Entry entryD = zzbfsVar.d(i3);
            zzbdgVar.f((zzbdf) ((zzbfp) entryD).a(), entryD.getValue());
        }
        for (Map.Entry entry : zzbfsVar.e()) {
            zzbdgVar.f((zzbdf) entry.getKey(), entry.getValue());
        }
        zzbdgVar.f76047c = this.f76047c;
        return zzbdgVar;
    }

    public final Iterator d() {
        zzbfs zzbfsVar = this.f76045a;
        return zzbfsVar.isEmpty() ? Collections.emptyIterator() : this.f76047c ? new zzbeg(zzbfsVar.entrySet().iterator()) : zzbfsVar.entrySet().iterator();
    }

    public final Object e(zzbdf zzbdfVar) {
        Object obj = this.f76045a.get(zzbdfVar);
        if (obj instanceof zzbeh) {
            throw null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbdg) {
            return this.f76045a.equals(((zzbdg) obj).f76045a);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.libraries.places.internal.zzbdu) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.libraries.places.internal.zzbeh) == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(com.google.android.libraries.places.internal.zzbdf r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3.zzd()
            com.google.android.libraries.places.internal.zzbgj r0 = r3.zzb()
            byte[] r1 = com.google.android.libraries.places.internal.zzbeb.f76092b
            r4.getClass()
            com.google.android.libraries.places.internal.zzbgj r1 = com.google.android.libraries.places.internal.zzbgj.f76186b
            com.google.android.libraries.places.internal.zzbgk r1 = com.google.android.libraries.places.internal.zzbgk.INT
            com.google.android.libraries.places.internal.zzbgk r0 = r0.a()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L46;
                case 1: goto L43;
                case 2: goto L40;
                case 3: goto L3d;
                case 4: goto L3a;
                case 5: goto L37;
                case 6: goto L2e;
                case 7: goto L25;
                case 8: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L57
        L1c:
            boolean r0 = r4 instanceof com.google.android.libraries.places.internal.zzbex
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof com.google.android.libraries.places.internal.zzbeh
            if (r0 == 0) goto L57
            goto L4a
        L25:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof com.google.android.libraries.places.internal.zzbdu
            if (r0 == 0) goto L57
            goto L4a
        L2e:
            boolean r0 = r4 instanceof com.google.android.libraries.places.internal.zzbcl
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4a
        L37:
            boolean r0 = r4 instanceof java.lang.String
            goto L48
        L3a:
            boolean r0 = r4 instanceof java.lang.Boolean
            goto L48
        L3d:
            boolean r0 = r4 instanceof java.lang.Double
            goto L48
        L40:
            boolean r0 = r4 instanceof java.lang.Float
            goto L48
        L43:
            boolean r0 = r4 instanceof java.lang.Long
            goto L48
        L46:
            boolean r0 = r4 instanceof java.lang.Integer
        L48:
            if (r0 == 0) goto L57
        L4a:
            boolean r0 = r4 instanceof com.google.android.libraries.places.internal.zzbeh
            if (r0 == 0) goto L51
            r0 = 1
            r2.f76047c = r0
        L51:
            com.google.android.libraries.places.internal.zzbfs r0 = r2.f76045a
            r0.put(r3, r4)
            return
        L57:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3.zza()
            r1 = 525004180(0x1f4aed94, float:4.2971684E-20)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.libraries.places.internal.zzbgj r3 = r3.zzb()
            com.google.android.libraries.places.internal.zzbgk r3 = r3.a()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbdg.f(com.google.android.libraries.places.internal.zzbdf, java.lang.Object):void");
    }

    public final boolean g() {
        zzbfs zzbfsVar = this.f76045a;
        int iC = zzbfsVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            if (!k(zzbfsVar.d(i3))) {
                return false;
            }
        }
        Iterator it = zzbfsVar.e().iterator();
        while (it.hasNext()) {
            if (!k((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void h(zzbdg zzbdgVar) {
        zzbfs zzbfsVar = zzbdgVar.f76045a;
        int iC = zzbfsVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            m(zzbfsVar.d(i3));
        }
        Iterator it = zzbfsVar.e().iterator();
        while (it.hasNext()) {
            m((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.f76045a.hashCode();
    }

    public final int i() {
        zzbfs zzbfsVar = this.f76045a;
        int iC = zzbfsVar.c();
        int iN = 0;
        for (int i3 = 0; i3 < iC; i3++) {
            iN += n(zzbfsVar.d(i3));
        }
        Iterator it = zzbfsVar.e().iterator();
        while (it.hasNext()) {
            iN += n((Map.Entry) it.next());
        }
        return iN;
    }

    private zzbdg(boolean z2) {
        b();
        b();
    }
}

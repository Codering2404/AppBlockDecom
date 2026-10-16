package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcp implements zzbfk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbco f76019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f76020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f76022d = 0;

    private zzbcp(zzbco zzbcoVar) {
        byte[] bArr = zzbeb.f76092b;
        this.f76019a = zzbcoVar;
        zzbcoVar.f76018e = this;
    }

    private final void j(int i3) throws zzbec {
        if ((this.f76020b & 7) != i3) {
            throw new zzbec("Protocol message tag had invalid wire type.");
        }
    }

    private final void k(Object obj, zzbfl zzbflVar, zzbdb zzbdbVar) throws zzbed {
        zzbco zzbcoVar = this.f76019a;
        int iA = zzbcoVar.A();
        zzbcoVar.g();
        int iG = zzbcoVar.G(iA);
        zzbcoVar.f76014a++;
        zzbflVar.b(obj, this, zzbdbVar);
        zzbcoVar.n(0);
        zzbcoVar.f76014a--;
        zzbcoVar.a(iG);
    }

    private final Object l(zzbfl zzbflVar, zzbdb zzbdbVar) throws zzbed {
        Object objZza = zzbflVar.zza();
        k(objZza, zzbflVar, zzbdbVar);
        zzbflVar.zzh(objZza);
        return objZza;
    }

    private final void m(Object obj, zzbfl zzbflVar, zzbdb zzbdbVar) {
        int i3 = this.f76021c;
        this.f76021c = ((this.f76020b >>> 3) << 3) | 4;
        try {
            zzbflVar.b(obj, this, zzbdbVar);
            if (this.f76020b == this.f76021c) {
            } else {
                throw new zzbed("Failed to parse the message.");
            }
        } finally {
            this.f76021c = i3;
        }
    }

    private final Object n(zzbfl zzbflVar, zzbdb zzbdbVar) {
        Object objZza = zzbflVar.zza();
        m(objZza, zzbflVar, zzbdbVar);
        zzbflVar.zzh(objZza);
        return objZza;
    }

    private final void o(int i3) throws zzbed {
        if (this.f76019a.c() != i3) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void p(int i3) throws zzbed {
        if ((i3 & 3) != 0) {
            throw new zzbed("Failed to parse the message.");
        }
    }

    private static final void q(int i3) throws zzbed {
        if ((i3 & 7) != 0) {
            throw new zzbed("Failed to parse the message.");
        }
    }

    public static zzbcp r(zzbco zzbcoVar) {
        Object obj = zzbcoVar.f76018e;
        return obj != null ? (zzbcp) obj : new zzbcp(zzbcoVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final Object a(Class cls, zzbdb zzbdbVar) throws zzbec {
        j(2);
        return l(zzbfh.a().b(cls), zzbdbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void b(Object obj, zzbfl zzbflVar, zzbdb zzbdbVar) throws zzbec {
        j(3);
        m(obj, zzbflVar, zzbdbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final Object c(Class cls, zzbdb zzbdbVar) throws zzbec {
        j(3);
        return n(zzbfh.a().b(cls), zzbdbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void d(Object obj, zzbfl zzbflVar, zzbdb zzbdbVar) throws zzbed {
        j(2);
        k(obj, zzbflVar, zzbdbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void e(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbemVar.e(zzbcoVar.F());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbemVar.e(zzbcoVar2.F());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Long.valueOf(zzbcoVar3.F()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Long.valueOf(zzbcoVar4.F()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void f(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdr) {
            zzbdr zzbdrVar = (zzbdr) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbdrVar.zzh(zzbcoVar.E());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdrVar.zzh(zzbcoVar2.E());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Integer.valueOf(zzbcoVar3.E()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Integer.valueOf(zzbcoVar4.E()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void g(List list, zzbfl zzbflVar, zzbdb zzbdbVar) throws zzbec {
        int iM;
        int i3 = this.f76020b;
        if ((i3 & 7) != 3) {
            throw new zzbec("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(n(zzbflVar, zzbdbVar));
            zzbco zzbcoVar = this.f76019a;
            if (zzbcoVar.b() || this.f76022d != 0) {
                return;
            } else {
                iM = zzbcoVar.m();
            }
        } while (iM == i3);
        this.f76022d = iM;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void h(List list, zzbfl zzbflVar, zzbdb zzbdbVar) throws zzbec {
        int iM;
        int i3 = this.f76020b;
        if ((i3 & 7) != 2) {
            throw new zzbec("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(l(zzbflVar, zzbdbVar));
            zzbco zzbcoVar = this.f76019a;
            if (zzbcoVar.b() || this.f76022d != 0) {
                return;
            } else {
                iM = zzbcoVar.m();
            }
        } while (iM == i3);
        this.f76022d = iM;
    }

    public final void i(List list, boolean z2) throws zzbec {
        int iM;
        int iM2;
        if ((this.f76020b & 7) != 2) {
            throw new zzbec("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzbej) && !z2) {
            zzbej zzbejVar = (zzbej) list;
            do {
                zzs();
                zzbejVar.zzb();
                zzbco zzbcoVar = this.f76019a;
                if (zzbcoVar.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            do {
                list.add(z2 ? zzn() : zzm());
                zzbco zzbcoVar2 = this.f76019a;
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM = zzbcoVar2.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzA(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdi) {
            zzbdi zzbdiVar = (zzbdi) list;
            int i3 = this.f76020b & 7;
            if (i3 == 2) {
                zzbco zzbcoVar = this.f76019a;
                int iA = zzbcoVar.A();
                p(iA);
                int iC = zzbcoVar.c() + iA;
                do {
                    zzbdiVar.d(zzbcoVar.q());
                } while (zzbcoVar.c() < iC);
                return;
            }
            if (i3 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdiVar.d(zzbcoVar2.q());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 == 2) {
                zzbco zzbcoVar3 = this.f76019a;
                int iA2 = zzbcoVar3.A();
                p(iA2);
                int iC2 = zzbcoVar3.c() + iA2;
                do {
                    list.add(Float.valueOf(zzbcoVar3.q()));
                } while (zzbcoVar3.c() < iC2);
                return;
            }
            if (i4 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Float.valueOf(zzbcoVar4.q()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzB(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbemVar.e(zzbcoVar.r());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbemVar.e(zzbcoVar2.r());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Long.valueOf(zzbcoVar3.r()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Long.valueOf(zzbcoVar4.r()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzC(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbemVar.e(zzbcoVar.s());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbemVar.e(zzbcoVar2.s());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Long.valueOf(zzbcoVar3.s()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Long.valueOf(zzbcoVar4.s()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzD(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdr) {
            zzbdr zzbdrVar = (zzbdr) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbdrVar.zzh(zzbcoVar.t());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdrVar.zzh(zzbcoVar2.t());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Integer.valueOf(zzbcoVar3.t()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Integer.valueOf(zzbcoVar4.t()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzE(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i3 = this.f76020b & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iA = zzbcoVar.A();
                q(iA);
                int iC = zzbcoVar.c() + iA;
                do {
                    zzbemVar.e(zzbcoVar.u());
                } while (zzbcoVar.c() < iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbemVar.e(zzbcoVar2.u());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iA2 = zzbcoVar3.A();
                q(iA2);
                int iC2 = zzbcoVar3.c() + iA2;
                do {
                    list.add(Long.valueOf(zzbcoVar3.u()));
                } while (zzbcoVar3.c() < iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Long.valueOf(zzbcoVar4.u()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzF(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdr) {
            zzbdr zzbdrVar = (zzbdr) list;
            int i3 = this.f76020b & 7;
            if (i3 == 2) {
                zzbco zzbcoVar = this.f76019a;
                int iA = zzbcoVar.A();
                p(iA);
                int iC = zzbcoVar.c() + iA;
                do {
                    zzbdrVar.zzh(zzbcoVar.v());
                } while (zzbcoVar.c() < iC);
                return;
            }
            if (i3 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdrVar.zzh(zzbcoVar2.v());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 == 2) {
                zzbco zzbcoVar3 = this.f76019a;
                int iA2 = zzbcoVar3.A();
                p(iA2);
                int iC2 = zzbcoVar3.c() + iA2;
                do {
                    list.add(Integer.valueOf(zzbcoVar3.v()));
                } while (zzbcoVar3.c() < iC2);
                return;
            }
            if (i4 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Integer.valueOf(zzbcoVar4.v()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzG(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbcd) {
            zzbcd zzbcdVar = (zzbcd) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbcdVar.d(zzbcoVar.w());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbcdVar.d(zzbcoVar2.w());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Boolean.valueOf(zzbcoVar3.w()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Boolean.valueOf(zzbcoVar4.w()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzK(List list) throws zzbec {
        int iM;
        if ((this.f76020b & 7) != 2) {
            throw new zzbec("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzs());
            zzbco zzbcoVar = this.f76019a;
            if (zzbcoVar.b()) {
                return;
            } else {
                iM = zzbcoVar.m();
            }
        } while (iM == this.f76020b);
        this.f76022d = iM;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzL(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdr) {
            zzbdr zzbdrVar = (zzbdr) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbdrVar.zzh(zzbcoVar.A());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdrVar.zzh(zzbcoVar2.A());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Integer.valueOf(zzbcoVar3.A()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Integer.valueOf(zzbcoVar4.A()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzM(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdr) {
            zzbdr zzbdrVar = (zzbdr) list;
            int i3 = this.f76020b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iC = zzbcoVar.c() + zzbcoVar.A();
                do {
                    zzbdrVar.zzh(zzbcoVar.B());
                } while (zzbcoVar.c() < iC);
                o(iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdrVar.zzh(zzbcoVar2.B());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 0) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iC2 = zzbcoVar3.c() + zzbcoVar3.A();
                do {
                    list.add(Integer.valueOf(zzbcoVar3.B()));
                } while (zzbcoVar3.c() < iC2);
                o(iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Integer.valueOf(zzbcoVar4.B()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzN(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbdr) {
            zzbdr zzbdrVar = (zzbdr) list;
            int i3 = this.f76020b & 7;
            if (i3 == 2) {
                zzbco zzbcoVar = this.f76019a;
                int iA = zzbcoVar.A();
                p(iA);
                int iC = zzbcoVar.c() + iA;
                do {
                    zzbdrVar.zzh(zzbcoVar.C());
                } while (zzbcoVar.c() < iC);
                return;
            }
            if (i3 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbdrVar.zzh(zzbcoVar2.C());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 == 2) {
                zzbco zzbcoVar3 = this.f76019a;
                int iA2 = zzbcoVar3.A();
                p(iA2);
                int iC2 = zzbcoVar3.c() + iA2;
                do {
                    list.add(Integer.valueOf(zzbcoVar3.C()));
                } while (zzbcoVar3.c() < iC2);
                return;
            }
            if (i4 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Integer.valueOf(zzbcoVar4.C()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzO(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i3 = this.f76020b & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iA = zzbcoVar.A();
                q(iA);
                int iC = zzbcoVar.c() + iA;
                do {
                    zzbemVar.e(zzbcoVar.D());
                } while (zzbcoVar.c() < iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbemVar.e(zzbcoVar2.D());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iA2 = zzbcoVar3.A();
                q(iA2);
                int iC2 = zzbcoVar3.c() + iA2;
                do {
                    list.add(Long.valueOf(zzbcoVar3.D()));
                } while (zzbcoVar3.c() < iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Long.valueOf(zzbcoVar4.D()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzb() {
        int iM = this.f76022d;
        if (iM != 0) {
            this.f76020b = iM;
            this.f76022d = 0;
        } else {
            iM = this.f76019a.m();
            this.f76020b = iM;
        }
        return (iM == 0 || iM == this.f76021c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iM >>> 3;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzc() {
        return this.f76020b;
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final boolean zzd() {
        int i3;
        zzbco zzbcoVar = this.f76019a;
        if (zzbcoVar.b() || (i3 = this.f76020b) == this.f76021c) {
            return false;
        }
        return zzbcoVar.o(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final double zze() throws zzbec {
        j(1);
        return this.f76019a.p();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final float zzf() throws zzbec {
        j(5);
        return this.f76019a.q();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final long zzg() throws zzbec {
        j(0);
        return this.f76019a.r();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final long zzh() throws zzbec {
        j(0);
        return this.f76019a.s();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzi() throws zzbec {
        j(0);
        return this.f76019a.t();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final long zzj() throws zzbec {
        j(1);
        return this.f76019a.u();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzk() throws zzbec {
        j(5);
        return this.f76019a.v();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final boolean zzl() throws zzbec {
        j(0);
        return this.f76019a.w();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final String zzm() throws zzbec {
        j(2);
        return this.f76019a.x();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final String zzn() throws zzbec {
        j(2);
        return this.f76019a.y();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final zzbcl zzs() throws zzbec {
        j(2);
        return this.f76019a.z();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzt() throws zzbec {
        j(0);
        return this.f76019a.A();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzu() throws zzbec {
        j(0);
        return this.f76019a.B();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzv() throws zzbec {
        j(5);
        return this.f76019a.C();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final long zzw() throws zzbec {
        j(1);
        return this.f76019a.D();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final int zzx() throws zzbec {
        j(0);
        return this.f76019a.E();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final long zzy() throws zzbec {
        j(0);
        return this.f76019a.F();
    }

    @Override // com.google.android.libraries.places.internal.zzbfk
    public final void zzz(List list) throws zzbed {
        int iM;
        int iM2;
        if (list instanceof zzbcw) {
            zzbcw zzbcwVar = (zzbcw) list;
            int i3 = this.f76020b & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar = this.f76019a;
                int iA = zzbcoVar.A();
                q(iA);
                int iC = zzbcoVar.c() + iA;
                do {
                    zzbcwVar.d(zzbcoVar.p());
                } while (zzbcoVar.c() < iC);
                return;
            }
            do {
                zzbco zzbcoVar2 = this.f76019a;
                zzbcwVar.d(zzbcoVar2.p());
                if (zzbcoVar2.b()) {
                    return;
                } else {
                    iM2 = zzbcoVar2.m();
                }
            } while (iM2 == this.f76020b);
        } else {
            int i4 = this.f76020b & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new zzbec("Protocol message tag had invalid wire type.");
                }
                zzbco zzbcoVar3 = this.f76019a;
                int iA2 = zzbcoVar3.A();
                q(iA2);
                int iC2 = zzbcoVar3.c() + iA2;
                do {
                    list.add(Double.valueOf(zzbcoVar3.p()));
                } while (zzbcoVar3.c() < iC2);
                return;
            }
            do {
                zzbco zzbcoVar4 = this.f76019a;
                list.add(Double.valueOf(zzbcoVar4.p()));
                if (zzbcoVar4.b()) {
                    return;
                } else {
                    iM = zzbcoVar4.m();
                }
            } while (iM == this.f76020b);
            iM2 = iM;
        }
        this.f76022d = iM2;
    }
}

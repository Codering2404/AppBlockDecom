package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbvw extends zzbly {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Logger f77016p = Logger.getLogger(zzbvw.class.getName());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final long f77017q = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final long f77018r = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final zzbwo f77019s = zzbzz.a(zzbsz.f76835p);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final zzbjy f77020t = zzbjy.a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final zzbjk f77021u = zzbjk.a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final Pattern f77022v = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Method f77023w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbwo f77024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbwo f77025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f77026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final zzbnc f77027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List f77028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f77029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f77030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final String f77031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final zzbjy f77032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final zzbjk f77033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final long f77034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final zzbkn f77035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final List f77036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzbvt f77037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final zzbvs f77038o;

    static {
        Method declaredMethod = null;
        try {
            int i3 = zzbob.f76524a;
            Class cls = Boolean.TYPE;
            declaredMethod = zzbob.class.getDeclaredMethod("getClientInterceptor", cls, cls, cls, cls);
        } catch (ClassNotFoundException e3) {
            f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e3);
        } catch (NoSuchMethodException e4) {
            f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "<clinit>", "Unable to apply census stats", (Throwable) e4);
        }
        f77023w = declaredMethod;
    }

    public zzbvw(String str, zzbiu zzbiuVar, zzbip zzbipVar, zzbvt zzbvtVar, zzbvs zzbvsVar) {
        zzbwo zzbwoVar = f77019s;
        this.f77024a = zzbwoVar;
        this.f77025b = zzbwoVar;
        this.f77026c = new ArrayList();
        this.f77027d = zzbnc.c();
        this.f77028e = new ArrayList();
        this.f77031h = "pick_first";
        this.f77032i = f77020t;
        this.f77033j = f77021u;
        this.f77034k = f77017q;
        this.f77035l = zzbkn.a();
        this.f77036m = new ArrayList();
        this.f77029f = (String) Preconditions.u(str, "target");
        this.f77037n = (zzbvt) Preconditions.u(zzbvtVar, "clientTransportFactoryBuilder");
        this.f77038o = zzbvsVar;
        zzbkr.a(this);
    }

    static zzbvv e(String str, zzbnc zzbncVar, Collection collection) {
        URI uri;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e3) {
            sb.append(e3.getMessage());
            uri = null;
        }
        zzbmz zzbmzVarB = uri != null ? zzbncVar.b(uri.getScheme()) : null;
        String string = "";
        if (zzbmzVarB == null && !f77022v.matcher(str).matches()) {
            try {
                String strA = zzbncVar.a();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1);
                sb2.append("/");
                sb2.append(str);
                uri = new URI(strA, "", sb2.toString(), null);
                zzbmzVarB = zzbncVar.b(uri.getScheme());
            } catch (URISyntaxException e4) {
                throw new IllegalArgumentException(e4);
            }
        }
        if (zzbmzVarB != null) {
            if (collection == null || collection.containsAll(zzbmzVarB.e())) {
                return new zzbvv(uri, zzbmzVarB);
            }
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        if (sb.length() > 0) {
            String string2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(string2.length() + 3);
            sb3.append(" (");
            sb3.append(string2);
            sb3.append(")");
            string = sb3.toString();
        }
        throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, string));
    }

    @Override // com.google.android.libraries.places.internal.zzbly
    public final zzblw a() {
        zzbiy zzbiyVar;
        zzbpq zzbpqVarZza = this.f77037n.zza();
        zzcch zzcchVar = zzcbd.f77383i;
        zzbvv zzbvvVarE = e(this.f77029f, this.f77027d, Collections.singleton(InetSocketAddress.class));
        URI uri = zzbvvVarE.f77014a;
        zzbmz zzbmzVar = zzbvvVarE.f77015b;
        zzbsg zzbsgVar = new zzbsg();
        zzbzz zzbzzVarA = zzbzz.a(zzbsz.f76835p);
        Supplier supplier = zzbsz.f76837r;
        uri.toString();
        List list = this.f77026c;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (true) {
            zzbiy zzbiyVar2 = null;
            if (!it.hasNext()) {
                zzbkr.b();
                Method method = f77023w;
                if (method != null) {
                    try {
                        Boolean bool = Boolean.TRUE;
                        zzbiyVar = (zzbiy) method.invoke(null, bool, bool, Boolean.FALSE, bool);
                    } catch (IllegalAccessException e3) {
                        f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e3);
                        zzbiyVar = null;
                    } catch (InvocationTargetException e4) {
                        f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e4);
                        zzbiyVar = null;
                    }
                } else {
                    zzbiyVar = null;
                }
                if (zzbiyVar != null) {
                    arrayList.add(0, zzbiyVar);
                }
                try {
                    zzbiyVar2 = (zzbiy) zzboc.class.getDeclaredMethod("getClientInterceptor", null).invoke(null, null);
                } catch (ClassNotFoundException e5) {
                    f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e5);
                } catch (IllegalAccessException e6) {
                    f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e6);
                } catch (NoSuchMethodException e7) {
                    f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e7);
                } catch (InvocationTargetException e8) {
                    f77016p.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e8);
                }
                if (zzbiyVar2 != null) {
                    arrayList.add(0, zzbiyVar2);
                }
                return new zzbvy(new zzbvr(this, zzbpqVarZza, uri, zzbmzVar, zzbsgVar, zzbzzVarA, supplier, arrayList, zzcag.f77331a));
            }
            zzbiy zzbiyVar3 = (zzbiy) it.next();
            if (zzbiyVar3 instanceof zzbvu) {
                throw null;
            }
            arrayList.add(zzbiyVar3);
        }
    }

    public final zzbvw b(List list) {
        this.f77026c.addAll(list);
        return this;
    }

    public final zzbvw c(String str) {
        this.f77030g = str;
        return this;
    }

    final int d() {
        this.f77038o.zza();
        return 443;
    }
}

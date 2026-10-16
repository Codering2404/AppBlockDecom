package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbtc extends zzbof {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final zzbkv f76841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final zzbmc f76842w;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private zzbnp f76843r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private zzbmg f76844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Charset f76845t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f76846u;

    static {
        zzbtb zzbtbVar = new zzbtb();
        f76841v = zzbtbVar;
        f76842w = zzbkw.a(":status", zzbtbVar);
    }

    protected zzbtc(int i3, zzcaa zzcaaVar, zzcal zzcalVar, zzbis zzbisVar) {
        super(i3, zzcaaVar, zzcalVar, zzbisVar);
        this.f76845t = StandardCharsets.UTF_8;
    }

    private static Charset F(zzbmg zzbmgVar) {
        String str = (String) zzbmgVar.b(zzbsz.f76828i);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return StandardCharsets.UTF_8;
    }

    private static void G(zzbmg zzbmgVar) {
        zzbmgVar.d(f76842w);
        zzbmgVar.d(zzbky.f76359b);
        zzbmgVar.d(zzbky.f76358a);
    }

    private static final zzbnp H(zzbmg zzbmgVar) {
        char cCharAt;
        Integer num = (Integer) zzbmgVar.b(f76842w);
        if (num == null) {
            return zzbnp.f76495l.e("Missing HTTP status code");
        }
        String str = (String) zzbmgVar.b(zzbsz.f76828i);
        if (str != null && str.length() >= 16) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.startsWith("application/grpc") && (lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';')) {
                return null;
            }
        }
        return zzbsz.a(num.intValue()).f("invalid content-type: ".concat(String.valueOf(str)));
    }

    protected final void C(zzbmg zzbmgVar) {
        Preconditions.u(zzbmgVar, "headers");
        zzbnp zzbnpVar = this.f76843r;
        if (zzbnpVar != null) {
            this.f76843r = zzbnpVar.f("headers: ".concat(zzbmgVar.toString()));
            return;
        }
        try {
            if (this.f76846u) {
                this.f76843r = zzbnp.f76495l.e("Received headers twice");
            } else {
                Integer num = (Integer) zzbmgVar.b(f76842w);
                if (num == null || num.intValue() < 100 || num.intValue() >= 200) {
                    this.f76846u = true;
                    zzbnp zzbnpVarH = H(zzbmgVar);
                    this.f76843r = zzbnpVarH;
                    if (zzbnpVarH != null) {
                        this.f76843r = zzbnpVarH.f("headers: ".concat(zzbmgVar.toString()));
                        this.f76844s = zzbmgVar;
                        this.f76845t = F(zzbmgVar);
                        return;
                    }
                    G(zzbmgVar);
                    u(zzbmgVar);
                }
            }
            zzbnp zzbnpVar2 = this.f76843r;
            if (zzbnpVar2 != null) {
                this.f76843r = zzbnpVar2.f("headers: ".concat(zzbmgVar.toString()));
                this.f76844s = zzbmgVar;
                this.f76845t = F(zzbmgVar);
            }
        } catch (Throwable th) {
            zzbnp zzbnpVar3 = this.f76843r;
            if (zzbnpVar3 != null) {
                this.f76843r = zzbnpVar3.f("headers: ".concat(zzbmgVar.toString()));
                this.f76844s = zzbmgVar;
                this.f76845t = F(zzbmgVar);
            }
            throw th;
        }
    }

    protected final void D(zzbxo zzbxoVar, boolean z2) {
        zzbnp zzbnpVar = this.f76843r;
        if (zzbnpVar != null) {
            Charset charset = this.f76845t;
            int i3 = zzbxr.f77169b;
            Preconditions.u(charset, "charset");
            Preconditions.u(zzbxoVar, "buffer");
            int iZzf = zzbxoVar.zzf();
            byte[] bArr = new byte[iZzf];
            zzbxoVar.zzi(bArr, 0, iZzf);
            this.f76843r = zzbnpVar.f("DATA-----------------------------\n".concat(new String(bArr, charset)));
            zzbxoVar.close();
            if (this.f76843r.h().length() > 1000 || z2) {
                I(this.f76843r, false, this.f76844s);
                return;
            }
            return;
        }
        if (!this.f76846u) {
            zzbxoVar.close();
            I(zzbnp.f76495l.e("headers not received before payload"), false, new zzbmg());
            return;
        }
        int iZzf2 = zzbxoVar.zzf();
        v(zzbxoVar);
        if (z2) {
            if (iZzf2 > 0) {
                this.f76843r = zzbnp.f76495l.e("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.f76843r = zzbnp.f76495l.e("Received unexpected EOS on empty DATA frame from server");
            }
            zzbmg zzbmgVar = new zzbmg();
            this.f76844s = zzbmgVar;
            x(this.f76843r, zzbpm.PROCESSED, false, zzbmgVar);
        }
    }

    protected final void E(zzbmg zzbmgVar) {
        zzbnp zzbnpVarF;
        Preconditions.u(zzbmgVar, "trailers");
        zzbnp zzbnpVarH = this.f76843r;
        if (zzbnpVarH == null && !this.f76846u) {
            zzbnpVarH = H(zzbmgVar);
            this.f76843r = zzbnpVarH;
            if (zzbnpVarH != null) {
                this.f76844s = zzbmgVar;
            }
        }
        if (zzbnpVarH != null) {
            zzbnp zzbnpVarF2 = zzbnpVarH.f("trailers: ".concat(zzbmgVar.toString()));
            this.f76843r = zzbnpVarF2;
            I(zzbnpVarF2, false, this.f76844s);
            return;
        }
        zzbnp zzbnpVar = (zzbnp) zzbmgVar.b(zzbky.f76359b);
        if (zzbnpVar != null) {
            zzbnpVarF = zzbnpVar.e((String) zzbmgVar.b(zzbky.f76358a));
        } else if (this.f76846u) {
            zzbnpVarF = zzbnp.f76490g.e("missing GRPC status in response");
        } else {
            Integer num = (Integer) zzbmgVar.b(f76842w);
            zzbnpVarF = (num != null ? zzbsz.a(num.intValue()) : zzbnp.f76495l.e("missing HTTP status code")).f("missing GRPC status, inferred error from HTTP status code");
        }
        G(zzbmgVar);
        w(zzbmgVar, zzbnpVarF);
    }

    protected abstract void I(zzbnp zzbnpVar, boolean z2, zzbmg zzbmgVar);
}

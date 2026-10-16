package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzff {
    private final Lazy zza;
    private final Lazy zzb;
    private final Lazy zzc;

    public zzff() {
        int i3 = zzav.zza;
        this.zza = LazyKt.b(zzfc.zza);
        this.zzb = LazyKt.b(zzfd.zza);
        this.zzc = LazyKt.b(zzfe.zza);
    }

    public static final /* synthetic */ zzfk zzb(zzff zzffVar) {
        return (zzfk) zzffVar.zza.getValue();
    }

    static /* synthetic */ Object zze(zzff zzffVar, zzsc zzscVar, zzek zzekVar, Continuation continuation) throws Exception {
        String strZza;
        try {
            String strZzl = zzscVar.zzl();
            String strZzM = zzscVar.zzM();
            zzaq zzaqVarZzf = zzffVar.zzf();
            String str = null;
            if (zzaqVarZzf != null && zzaqVarZzf.zzd(strZzM)) {
                zzen zzenVarZzf = zzekVar.zzf(25);
                try {
                    strZza = zzffVar.zzf().zza(strZzM);
                } catch (Exception e3) {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzR, e3.getMessage()));
                }
                if (strZza != null) {
                    zzenVarZzf.zza();
                    str = strZza;
                } else {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzS, null));
                }
            }
            if (str == null) {
                zzaq zzaqVarZzf2 = zzffVar.zzf();
                if (zzaqVarZzf2 != null) {
                    zzaqVarZzf2.zzb();
                }
                zzen zzenVarZzf2 = zzekVar.zzf(23);
                try {
                    String strZzb = zzffVar.zzg().zzb(strZzl);
                    zzenVarZzf2.zza();
                    zzen zzenVarZzf3 = zzekVar.zzf(24);
                    try {
                        zzaq zzaqVarZzf3 = zzffVar.zzf();
                        if (zzaqVarZzf3 != null) {
                            zzaqVarZzf3.zzc(strZzM, strZzb);
                        }
                        zzenVarZzf3.zza();
                    } catch (Exception e4) {
                        zzenVarZzf3.zzb(new zzbd(zzbb.zzk, zzba.zzT, e4.getMessage()));
                    }
                    str = strZzb;
                } catch (zzbd e5) {
                    zzenVarZzf2.zzb(e5);
                    throw e5;
                }
            }
            return StringsKt.O(zzscVar.zzk(), "JAVASCRIPT_TAG", str, false, 4, null);
        } catch (Exception e6) {
            if (e6 instanceof zzbd) {
                throw e6;
            }
            throw new zzbd(zzbb.zzb, zzba.zzL, e6.getMessage());
        }
    }

    private final zzaq zzf() {
        return (zzaq) this.zzb.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzey zzg() {
        return (zzey) this.zzc.getValue();
    }

    public final Object zzc(String str, zzto zztoVar, Continuation continuation) throws RecaptchaException {
        return CoroutineScopeKt.f(new zzfb(this, str, zztoVar, null), continuation);
    }

    public final Object zzd(zzsc zzscVar, zzek zzekVar, Continuation continuation) throws zzbd {
        return zze(this, zzscVar, zzekVar, continuation);
    }
}

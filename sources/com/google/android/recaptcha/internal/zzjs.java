package com.google.android.recaptcha.internal;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzjs implements zzjw {
    zzjs() {
    }

    @Override // com.google.android.recaptcha.internal.zzjw
    public final zzjv zza(CharSequence charSequence, Charset charset) {
        zzjx zzjxVarZzb = zzb();
        byte[] bytes = charSequence.toString().getBytes(charset);
        bytes.getClass();
        ((zzjr) zzjxVarZzb).zza(bytes, 0, bytes.length);
        return zzjxVarZzb.zzb();
    }
}

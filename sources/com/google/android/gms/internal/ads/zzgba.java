package com.google.android.gms.internal.ads;

import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgba implements Serializer {
    public static final zzgba zza = new zzgba();
    private static final zzgax zzb;

    static {
        zzgax zzgaxVarZzd = zzgax.zzd();
        Intrinsics.checkNotNullExpressionValue(zzgaxVarZzd, "getDefaultInstance(...)");
        zzb = zzgaxVarZzd;
    }

    private zzgba() {
    }

    @Override // androidx.datastore.core.Serializer
    public final /* synthetic */ Object getDefaultValue() {
        return zzb;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, Continuation continuation) {
        try {
            zzgax zzgaxVarZzc = zzgax.zzc(inputStream);
            Intrinsics.checkNotNull(zzgaxVarZzc);
            return zzgaxVarZzc;
        } catch (Exception unused) {
            return zzb;
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final /* synthetic */ Object writeTo(Object obj, OutputStream outputStream, Continuation continuation) throws IOException {
        ((zzgax) obj).zzaO(outputStream);
        return Unit.f139807a;
    }
}

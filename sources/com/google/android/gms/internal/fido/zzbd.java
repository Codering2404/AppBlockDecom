package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbd {
    private final String zza = ",\n  ";

    private zzbd(String str) {
    }

    public static zzbd zza(String str) {
        return new zzbd(",\n  ");
    }

    static final CharSequence zzd(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder zzc(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                sb.append(zzd(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.zza);
                    sb.append(zzd(it.next()));
                }
            }
            return sb;
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}

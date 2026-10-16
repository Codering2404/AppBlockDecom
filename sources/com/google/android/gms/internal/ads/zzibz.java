package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzibz extends Writer {
    private final Appendable zza;
    private final zziby zzb = new zziby(null);

    zzibz(Appendable appendable) {
        this.zza = appendable;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) throws IOException {
        this.zza.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i3) throws IOException {
        this.zza.append((char) i3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i3, int i4) throws IOException {
        Objects.requireNonNull(str);
        this.zza.append(str, i3, i4 + i3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i3, int i4) throws IOException {
        this.zza.append(charSequence, i3, i4);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i3, int i4) throws IOException {
        append(charSequence, i3, i4);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i3, int i4) throws IOException {
        zziby zzibyVar = this.zzb;
        zzibyVar.zza(cArr);
        this.zza.append(zzibyVar, i3, i4 + i3);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() throws IOException {
    }
}

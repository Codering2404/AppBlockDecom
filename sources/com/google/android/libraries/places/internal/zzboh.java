package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzboh implements zzbxo {
    protected final void a(int i3) {
        if (zzf() < i3) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public boolean zza() {
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public void zzc() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzbxo, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public void zzb() {
    }
}

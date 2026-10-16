package com.google.android.libraries.places.internal;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwi extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f77086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzcam f77087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbwl f77088c;

    /* synthetic */ zzbwi(zzbwl zzbwlVar, byte[] bArr) {
        Objects.requireNonNull(zzbwlVar);
        this.f77088c = zzbwlVar;
        this.f77086a = new ArrayList();
    }

    final /* synthetic */ int a() {
        Iterator it = this.f77086a.iterator();
        int iZzd = 0;
        while (it.hasNext()) {
            iZzd += ((zzcam) it.next()).zzd();
        }
        return iZzd;
    }

    final /* synthetic */ List b() {
        return this.f77086a;
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        zzcam zzcamVar = this.f77087b;
        byte b3 = (byte) i3;
        if (zzcamVar == null || zzcamVar.zzc() <= 0) {
            write(new byte[]{b3}, 0, 1);
        } else {
            zzcamVar.a(b3);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i4) {
        if (this.f77087b == null) {
            zzbwl zzbwlVar = this.f77088c;
            zzcam zzcamVarZza = zzbwlVar.d().zza(Math.max(4096, i4));
            this.f77087b = zzcamVarZza;
            this.f77086a.add(zzcamVarZza);
        }
        while (i4 > 0) {
            int iMin = Math.min(i4, this.f77087b.zzc());
            if (iMin == 0) {
                int iZzd = this.f77087b.zzd();
                zzcam zzcamVarZza2 = this.f77088c.d().zza(Math.max(i4, iZzd + iZzd));
                this.f77087b = zzcamVarZza2;
                this.f77086a.add(zzcamVarZza2);
            } else {
                this.f77087b.zza(bArr, i3, iMin);
                i3 += iMin;
                i4 -= iMin;
            }
        }
    }
}

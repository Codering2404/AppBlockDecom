package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbwl implements zzbsq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbwk f77090a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcam f77092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f77093d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzcan f77097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcaa f77098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f77099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f77100k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f77102m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f77091b = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbjj f77094e = zzbjh.f76278a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbwj f77095f = new zzbwj(this, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ByteBuffer f77096g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f77101l = -1;

    public zzbwl(zzbwk zzbwkVar, zzcan zzcanVar, zzcaa zzcaaVar) {
        this.f77090a = (zzbwk) Preconditions.u(zzbwkVar, "sink");
        this.f77097h = (zzcan) Preconditions.u(zzcanVar, "bufferAllocator");
        this.f77098i = (zzcaa) Preconditions.u(zzcaaVar, "statsTraceCtx");
    }

    private final void e(zzbwi zzbwiVar, boolean z2) {
        int iA = zzbwiVar.a();
        int i3 = this.f77091b;
        if (i3 >= 0 && iA > i3) {
            throw new zzbns(zzbnp.f76493j.e(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iA), Integer.valueOf(this.f77091b))), null);
        }
        ByteBuffer byteBuffer = this.f77096g;
        byteBuffer.clear();
        byteBuffer.put(z2 ? (byte) 1 : (byte) 0).putInt(iA);
        zzcam zzcamVarZza = this.f77097h.zza(5);
        zzcamVarZza.zza(byteBuffer.array(), 0, byteBuffer.position());
        if (iA == 0) {
            this.f77092c = zzcamVarZza;
            return;
        }
        zzbwk zzbwkVar = this.f77090a;
        zzbwkVar.d(zzcamVarZza, false, false, this.f77100k - 1);
        this.f77100k = 1;
        List listB = zzbwiVar.b();
        for (int i4 = 0; i4 < listB.size() - 1; i4++) {
            zzbwkVar.d((zzcam) listB.get(i4), false, false, 0);
        }
        this.f77092c = (zzcam) listB.get(listB.size() - 1);
        this.f77102m = iA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int f(InputStream inputStream, OutputStream outputStream) {
        return ((zzbjz) inputStream).a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void c(byte[] bArr, int i3, int i4) {
        while (i4 > 0) {
            zzcam zzcamVar = this.f77092c;
            if (zzcamVar != null && zzcamVar.zzc() == 0) {
                h(false, false);
            }
            if (this.f77092c == null) {
                Preconditions.A(this.f77093d > 0, "knownLengthPendingAllocation reached 0");
                zzcam zzcamVarZza = this.f77097h.zza(this.f77093d);
                this.f77092c = zzcamVarZza;
                int i5 = this.f77093d;
                this.f77093d = i5 - Math.min(i5, zzcamVarZza.zzc());
            }
            int iMin = Math.min(i4, this.f77092c.zzc());
            this.f77092c.zza(bArr, i3, iMin);
            i3 += iMin;
            i4 -= iMin;
        }
    }

    private final void h(boolean z2, boolean z3) {
        zzcam zzcamVar = this.f77092c;
        this.f77092c = null;
        this.f77090a.d(zzcamVar, z2, z3, this.f77100k);
        this.f77100k = 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbsq
    public final /* bridge */ /* synthetic */ zzbsq a(zzbjj zzbjjVar) {
        this.f77094e = (zzbjj) Preconditions.u(zzbjjVar, "Can't pass an empty compressor");
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbsq
    public final void b(InputStream inputStream) {
        int iF;
        if (this.f77099j) {
            throw new IllegalStateException("Framer already closed");
        }
        this.f77100k++;
        int i3 = this.f77101l + 1;
        this.f77101l = i3;
        this.f77102m = 0L;
        this.f77098i.f(i3);
        zzbjj zzbjjVar = this.f77094e;
        zzbji zzbjiVar = zzbjh.f76278a;
        try {
            int iAvailable = inputStream.available();
            if (iAvailable != 0 && zzbjjVar != zzbjiVar) {
                zzbwi zzbwiVar = new zzbwi(this, null);
                OutputStream outputStreamA = this.f77094e.a(zzbwiVar);
                try {
                    iF = f(inputStream, outputStreamA);
                    outputStreamA.close();
                    int i4 = this.f77091b;
                    if (i4 >= 0 && iF > i4) {
                        throw new zzbns(zzbnp.f76493j.e(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iF), Integer.valueOf(this.f77091b))), null);
                    }
                    e(zzbwiVar, true);
                } catch (Throwable th) {
                    outputStreamA.close();
                    throw th;
                }
            } else if (iAvailable != -1) {
                this.f77102m = iAvailable;
                int i5 = this.f77091b;
                if (i5 >= 0 && iAvailable > i5) {
                    throw new zzbns(zzbnp.f76493j.e(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iAvailable), Integer.valueOf(this.f77091b))), null);
                }
                ByteBuffer byteBuffer = this.f77096g;
                byteBuffer.clear();
                byteBuffer.put((byte) 0).putInt(iAvailable);
                this.f77093d = iAvailable + 5;
                c(byteBuffer.array(), 0, byteBuffer.position());
                iF = f(inputStream, this.f77095f);
            } else {
                zzbwi zzbwiVar2 = new zzbwi(this, null);
                iF = f(inputStream, zzbwiVar2);
                e(zzbwiVar2, false);
            }
            if (iAvailable != -1 && iF != iAvailable) {
                throw new zzbns(zzbnp.f76495l.e(String.format("Message length inaccurate %s != %s", Integer.valueOf(iF), Integer.valueOf(iAvailable))), null);
            }
            zzcaa zzcaaVar = this.f77098i;
            long j3 = iF;
            zzcaaVar.j(j3);
            zzcaaVar.k(this.f77102m);
            zzcaaVar.h(this.f77101l, this.f77102m, j3);
        } catch (zzbns e3) {
            throw e3;
        } catch (IOException e4) {
            throw new zzbns(zzbnp.f76495l.e("Failed to frame message").d(e4), null);
        } catch (RuntimeException e5) {
            throw new zzbns(zzbnp.f76495l.e("Failed to frame message").d(e5), null);
        }
    }

    final /* synthetic */ zzcan d() {
        return this.f77097h;
    }

    @Override // com.google.android.libraries.places.internal.zzbsq
    public final void zzb() {
        zzcam zzcamVar = this.f77092c;
        if (zzcamVar == null || zzcamVar.zzd() <= 0) {
            return;
        }
        h(false, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbsq
    public final boolean zzc() {
        return this.f77099j;
    }

    @Override // com.google.android.libraries.places.internal.zzbsq
    public final void zzd() {
        if (this.f77099j) {
            return;
        }
        this.f77099j = true;
        zzcam zzcamVar = this.f77092c;
        if (zzcamVar != null && zzcamVar.zzd() == 0) {
            this.f77092c = null;
        }
        h(true, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbsq
    public final void zzf(int i3) {
        Preconditions.A(this.f77091b == -1, "max size already set");
        this.f77091b = i3;
    }
}

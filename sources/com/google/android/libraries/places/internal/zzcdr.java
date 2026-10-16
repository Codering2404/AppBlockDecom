package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdr implements zzbmk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal f77687c = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbff f77688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbex f77689b;

    zzcdr(zzbex zzbexVar, int i3) {
        this.f77689b = (zzbex) Preconditions.u(zzbexVar, "defaultInstance cannot be null");
        this.f77688a = zzbexVar.zzbr();
    }

    @Override // com.google.android.libraries.places.internal.zzbmi
    public final /* bridge */ /* synthetic */ InputStream zza(Object obj) {
        return new zzcdq((zzbex) obj, this.f77688a);
    }

    @Override // com.google.android.libraries.places.internal.zzbmi
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        zzbco zzbcoVarD;
        byte[] bArr;
        if (inputStream instanceof zzcdq) {
            zzcdq zzcdqVar = (zzcdq) inputStream;
            if (zzcdqVar.c() == this.f77688a) {
                try {
                    return zzcdqVar.b();
                } catch (IllegalStateException unused) {
                }
            }
        }
        try {
            if (inputStream instanceof zzbla) {
                int iAvailable = inputStream.available();
                if (iAvailable <= 0 || iAvailable > 4194304) {
                    if (iAvailable == 0) {
                        return this.f77689b;
                    }
                    zzbcoVarD = null;
                } else {
                    ThreadLocal threadLocal = f77687c;
                    Reference reference = (Reference) threadLocal.get();
                    if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                        bArr = new byte[iAvailable];
                        threadLocal.set(new WeakReference(bArr));
                    }
                    int i3 = iAvailable;
                    while (i3 > 0) {
                        int i4 = inputStream.read(bArr, iAvailable - i3, i3);
                        if (i4 == -1) {
                            break;
                        }
                        i3 -= i4;
                    }
                    if (i3 != 0) {
                        int i5 = iAvailable - i3;
                        StringBuilder sb = new StringBuilder(String.valueOf(iAvailable).length() + 21 + String.valueOf(i5).length());
                        sb.append("size inaccurate: ");
                        sb.append(iAvailable);
                        sb.append(" != ");
                        sb.append(i5);
                        throw new RuntimeException(sb.toString());
                    }
                    zzbcoVarD = zzbco.e(bArr, 0, iAvailable);
                }
            } else {
                zzbcoVarD = null;
            }
            if (zzbcoVarD == null) {
                zzbcoVarD = zzbco.d(inputStream, 4096);
            }
            zzbcoVarD.j(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            try {
                zzbex zzbexVar = (zzbex) this.f77688a.b(zzbcoVarD, zzcds.f77690a);
                try {
                    zzbcoVarD.n(0);
                    return zzbexVar;
                } catch (zzbed e3) {
                    throw e3;
                }
            } catch (zzbed e4) {
                throw new zzbns(zzbnp.f76495l.e("Invalid protobuf byte sequence").d(e4), null);
            }
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmk
    public final Class zzc() {
        return this.f77689b.getClass();
    }
}

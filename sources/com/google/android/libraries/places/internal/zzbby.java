package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzbbx;
import com.google.android.libraries.places.internal.zzbby;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbby<MessageType extends zzbby<MessageType, BuilderType>, BuilderType extends zzbbx<MessageType, BuilderType>> implements zzbex {
    protected transient int zza = 0;

    protected static void f(Iterable iterable, List list) {
        zzbbx.q(iterable, list);
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final zzbcl a() {
        try {
            int iJ = j();
            zzbcl zzbclVar = zzbcl.f75997b;
            byte[] bArr = new byte[iJ];
            int i3 = zzbcu.f76033d;
            zzbcr zzbcrVar = new zzbcr(bArr, 0, iJ);
            k(zzbcrVar);
            zzbcrVar.e();
            return new zzbck(bArr);
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final byte[] b() {
        try {
            int iJ = j();
            byte[] bArr = new byte[iJ];
            int i3 = zzbcu.f76033d;
            zzbcr zzbcrVar = new zzbcr(bArr, 0, iJ);
            k(zzbcrVar);
            zzbcrVar.e();
            return bArr;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    int d(zzbfl zzbflVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final void i(OutputStream outputStream) {
        int iJ = j();
        int i3 = zzbcu.f76033d;
        if (iJ > 4096) {
            iJ = 4096;
        }
        zzbct zzbctVar = new zzbct(outputStream, iJ);
        k(zzbctVar);
        zzbctVar.z();
    }
}

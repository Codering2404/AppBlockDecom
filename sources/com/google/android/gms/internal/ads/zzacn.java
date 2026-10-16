package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacn {
    private final ByteBuffer zza = ByteBuffer.allocateDirect(500);
    private zzgt zzb;

    private final void zzd(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (((zzgs) list.get(i3)).zza == 1) {
                this.zzb = zzgt.zza((zzgs) list.get(i3));
            }
        }
    }

    private final void zze() {
        ByteBuffer byteBuffer = this.zza;
        byteBuffer.position(byteBuffer.limit());
    }

    public final int zza(ByteBuffer byteBuffer, boolean z2) {
        zzgt zzgtVar;
        zzgq zzgqVarZzb;
        ByteBuffer byteBuffer2 = this.zza;
        if (byteBuffer2.hasRemaining()) {
            zzd(zzgu.zza(byteBuffer2));
            zze();
        }
        List listZza = zzgu.zza(byteBuffer);
        zzd(listZza);
        int size = listZza.size() - 1;
        int i3 = 0;
        while (size >= 0) {
            zzgs zzgsVar = (zzgs) listZza.get(size);
            int i4 = zzgsVar.zza;
            if (i4 != 2 && i4 != 15) {
                if (i4 == 3) {
                    if (!z2) {
                        break;
                    }
                    i4 = 3;
                }
                if ((i4 != 6 && i4 != 3) || (zzgtVar = this.zzb) == null || (zzgqVarZzb = zzgq.zzb(zzgtVar, zzgsVar)) == null || zzgqVarZzb.zza()) {
                    break;
                }
            }
            if (((zzgs) listZza.get(size)).zza == 6 || ((zzgs) listZza.get(size)).zza == 3) {
                i3++;
            }
            size--;
        }
        return (i3 > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((zzgs) listZza.get(size)).zzb.limit() : byteBuffer.position();
    }

    public final void zzb(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, iPosition + 500));
        ByteBuffer byteBuffer2 = this.zza;
        byteBuffer2.clear();
        byteBuffer2.put(byteBuffer);
        byteBuffer2.flip();
        byteBuffer.position(iPosition);
        byteBuffer.limit(iLimit);
    }

    public final void zzc() {
        this.zzb = null;
        zze();
    }
}

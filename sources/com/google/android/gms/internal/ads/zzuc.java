package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzuc extends zzcp {
    private static void zzq(int i3, ByteBuffer byteBuffer) {
        float f3 = (float) (((double) i3) * 4.656612875245797E-10d);
        byteBuffer.putInt(Float.isNaN(f3) ? 0 : Float.floatToIntBits(f3));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzd(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferZzk;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        int i4 = this.zzb.zzd;
        if (i4 == 2) {
            byteBufferZzk = zzk(i3 + i3);
            while (iPosition < iLimit) {
                zzq(byteBuffer.getShort(iPosition) << 16, byteBufferZzk);
                iPosition += 2;
            }
        } else if (i4 == 3) {
            byteBufferZzk = zzk(i3 * 4);
            while (iPosition < iLimit) {
                zzq(((byteBuffer.get(iPosition) & 255) - 128) << 24, byteBufferZzk);
                iPosition++;
            }
        } else if (i4 == 21) {
            byteBufferZzk = zzk((i3 / 3) * 4);
            while (iPosition < iLimit) {
                zzq(zzhah.zze(byteBuffer.get(iPosition + 2), byteBuffer.get(iPosition + 1), byteBuffer.get(iPosition), (byte) 0), byteBufferZzk);
                iPosition += 3;
            }
        } else if (i4 == 22) {
            byteBufferZzk = zzk(i3);
            while (iPosition < iLimit) {
                zzq(byteBuffer.getInt(iPosition), byteBufferZzk);
                iPosition += 4;
            }
        } else if (i4 == 268435456) {
            byteBufferZzk = zzk(i3 + i3);
            while (iPosition < iLimit) {
                zzq(Short.reverseBytes(byteBuffer.getShort(iPosition)) << 16, byteBufferZzk);
                iPosition += 2;
            }
        } else if (i4 == 1342177280) {
            byteBufferZzk = zzk((i3 / 3) * 4);
            while (iPosition < iLimit) {
                zzq(zzhah.zze(byteBuffer.get(iPosition), byteBuffer.get(iPosition + 1), byteBuffer.get(iPosition + 2), (byte) 0), byteBufferZzk);
                iPosition += 3;
            }
        } else if (i4 == 1610612736) {
            byteBufferZzk = zzk(i3);
            while (iPosition < iLimit) {
                zzq(Integer.reverseBytes(byteBuffer.getInt(iPosition)), byteBufferZzk);
                iPosition += 4;
            }
        } else {
            if (i4 != 1879048192) {
                throw new IllegalStateException();
            }
            byteBufferZzk = zzk(i3 / 2);
            while (iPosition < iLimit) {
                byteBufferZzk.putFloat((float) byteBuffer.getDouble(iPosition));
                iPosition += 8;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzk.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl zzm(zzcl zzclVar) throws zzcn {
        int i3 = zzclVar.zzd;
        if (zzfl.zzD(i3)) {
            return i3 != 4 ? new zzcl(zzclVar.zzb, zzclVar.zzc, 4) : zzcl.zza;
        }
        throw new zzcn("Unhandled input format:", zzclVar);
    }
}

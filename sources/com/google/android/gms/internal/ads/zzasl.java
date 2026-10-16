package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasl {
    static Pair zza(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair pairZze = zze(randomAccessFile, 0);
        return pairZze != null ? pairZze : zze(randomAccessFile, 65535);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzf(byteBuffer);
        return zzg(byteBuffer, byteBuffer.position() + 16);
    }

    public static void zzc(ByteBuffer byteBuffer, long j3) {
        zzf(byteBuffer);
        int iPosition = byteBuffer.position() + 16;
        if (j3 >= 0 && j3 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + iPosition, (int) j3);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 27);
        sb.append("uint32 value of out range: ");
        sb.append(j3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static long zzd(ByteBuffer byteBuffer) {
        zzf(byteBuffer);
        return zzg(byteBuffer, byteBuffer.position() + 12);
    }

    private static Pair zze(RandomAccessFile randomAccessFile, int i3) throws IOException {
        int i4;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i3, (-22) + length)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        zzf(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity < 22) {
            i4 = -1;
        } else {
            int i5 = iCapacity - 22;
            int iMin = Math.min(i5, 65535);
            for (int i6 = 0; i6 < iMin; i6++) {
                i4 = i5 - i6;
                if (byteBufferAllocate.getInt(i4) == 101010256 && ((char) byteBufferAllocate.getShort(i4 + 20)) == i6) {
                    break;
                }
            }
            i4 = -1;
        }
        if (i4 == -1) {
            return null;
        }
        byteBufferAllocate.position(i4);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i4)));
    }

    private static void zzf(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static long zzg(ByteBuffer byteBuffer, int i3) {
        return ((long) byteBuffer.getInt(i3)) & 4294967295L;
    }
}

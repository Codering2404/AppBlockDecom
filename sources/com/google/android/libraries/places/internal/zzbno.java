package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbno implements zzbmf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f76486a = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    private zzbno() {
        throw null;
    }

    private static boolean a(byte b3) {
        return b3 < 32 || b3 >= 126 || b3 == 37;
    }

    @Override // com.google.android.libraries.places.internal.zzbmf
    public final /* bridge */ /* synthetic */ byte[] zza(Object obj) {
        byte[] bytes = ((String) obj).getBytes(StandardCharsets.UTF_8);
        int i3 = 0;
        while (true) {
            int length = bytes.length;
            if (i3 >= length) {
                return bytes;
            }
            if (a(bytes[i3])) {
                byte[] bArr = new byte[((length - i3) * 3) + i3];
                if (i3 != 0) {
                    System.arraycopy(bytes, 0, bArr, 0, i3);
                }
                int i4 = i3;
                while (i3 < bytes.length) {
                    int i5 = i4 + 1;
                    byte b3 = bytes[i3];
                    if (a(b3)) {
                        bArr[i4] = 37;
                        byte[] bArr2 = f76486a;
                        bArr[i5] = bArr2[(b3 >> 4) & 15];
                        bArr[i4 + 2] = bArr2[b3 & Ascii.SI];
                        i4 += 3;
                    } else {
                        bArr[i4] = b3;
                        i4 = i5;
                    }
                    i3++;
                }
                return Arrays.copyOf(bArr, i4);
            }
            i3++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmf
    public final /* bridge */ /* synthetic */ Object zzb(byte[] bArr) {
        int length;
        int i3 = 0;
        while (true) {
            length = bArr.length;
            if (i3 >= length) {
                return new String(bArr, 0);
            }
            byte b3 = bArr[i3];
            if (b3 < 32 || b3 >= 126 || (b3 == 37 && i3 + 2 < length)) {
                break;
            }
            i3++;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        int i4 = 0;
        while (true) {
            int length2 = bArr.length;
            if (i4 >= length2) {
                return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), StandardCharsets.UTF_8);
            }
            int i5 = i4 + 1;
            if (bArr[i4] == 37 && i4 + 2 < length2) {
                try {
                    byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i5, 2, StandardCharsets.US_ASCII), 16));
                    i4 += 3;
                } catch (NumberFormatException unused) {
                    byteBufferAllocate.put(bArr[i4]);
                    i4 = i5;
                }
            }
            byteBufferAllocate.put(bArr[i4]);
            i4 = i5;
        }
    }

    /* synthetic */ zzbno(byte[] bArr) {
    }
}

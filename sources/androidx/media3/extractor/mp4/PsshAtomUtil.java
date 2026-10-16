package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PsshAtomUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PsshAtom {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f46806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f46808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UUID[] f46809d;

        PsshAtom(UUID uuid, int i3, byte[] bArr, UUID[] uuidArr) {
            this.f46806a = uuid;
            this.f46807b = i3;
            this.f46808c = bArr;
            this.f46809d = uuidArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            byteBufferAllocate.putInt(0);
        } else {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    public static PsshAtom d(byte[] bArr) {
        UUID[] uuidArr;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.g() < 32) {
            return null;
        }
        parsableByteArray.W(0);
        int iA = parsableByteArray.a();
        int iQ = parsableByteArray.q();
        if (iQ != iA) {
            Log.i("PsshAtomUtil", "Advertised atom size (" + iQ + ") does not match buffer size: " + iA);
            return null;
        }
        int iQ2 = parsableByteArray.q();
        if (iQ2 != 1886614376) {
            Log.i("PsshAtomUtil", "Atom type is not pssh: " + iQ2);
            return null;
        }
        int iP = BoxParser.p(parsableByteArray.q());
        if (iP > 1) {
            Log.i("PsshAtomUtil", "Unsupported pssh version: " + iP);
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.A(), parsableByteArray.A());
        if (iP == 1) {
            int iL = parsableByteArray.L();
            uuidArr = new UUID[iL];
            for (int i3 = 0; i3 < iL; i3++) {
                uuidArr[i3] = new UUID(parsableByteArray.A(), parsableByteArray.A());
            }
        } else {
            uuidArr = null;
        }
        int iL2 = parsableByteArray.L();
        int iA2 = parsableByteArray.a();
        if (iL2 == iA2) {
            byte[] bArr2 = new byte[iL2];
            parsableByteArray.l(bArr2, 0, iL2);
            return new PsshAtom(uuid, iP, bArr2, uuidArr);
        }
        Log.i("PsshAtomUtil", "Atom data size (" + iL2 + ") does not match the bytes left: " + iA2);
        return null;
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        PsshAtom psshAtomD = d(bArr);
        if (psshAtomD == null) {
            return null;
        }
        if (uuid.equals(psshAtomD.f46806a)) {
            return psshAtomD.f46808c;
        }
        Log.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + psshAtomD.f46806a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        PsshAtom psshAtomD = d(bArr);
        if (psshAtomD == null) {
            return null;
        }
        return psshAtomD.f46806a;
    }

    public static int g(byte[] bArr) {
        PsshAtom psshAtomD = d(bArr);
        if (psshAtomD == null) {
            return -1;
        }
        return psshAtomD.f46807b;
    }
}

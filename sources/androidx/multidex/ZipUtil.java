package androidx.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ZipUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CentralDirectory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f48741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f48742b;

        CentralDirectory() {
        }
    }

    static long a(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j3 = centralDirectory.f48742b;
        randomAccessFile.seek(centralDirectory.f48741a);
        byte[] bArr = new byte[16384];
        int i3 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j3));
        while (i3 != -1) {
            crc32.update(bArr, 0, i3);
            j3 -= (long) i3;
            if (j3 == 0) {
                break;
            }
            i3 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j3));
        }
        return crc32.getValue();
    }

    static CentralDirectory b(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        long j3 = length - 22;
        if (j3 < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j4 = length - 65558;
        long j5 = j4 >= 0 ? j4 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(j3);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.f48742b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                centralDirectory.f48741a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return centralDirectory;
            }
            j3--;
        } while (j3 >= j5);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}

package androidx.media3.extractor.avi;

import androidx.media3.common.Format;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class StreamFormatChunk implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Format f46330a;

    public StreamFormatChunk(Format format) {
        this.f46330a = format;
    }

    private static String a(int i3) {
        switch (i3) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    private static String b(int i3) {
        if (i3 == 1) {
            return "audio/raw";
        }
        if (i3 == 85) {
            return "audio/mpeg";
        }
        if (i3 == 255) {
            return "audio/mp4a-latm";
        }
        if (i3 == 8192) {
            return "audio/ac3";
        }
        if (i3 != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    private static AviChunk c(ParsableByteArray parsableByteArray) {
        parsableByteArray.X(4);
        int iU = parsableByteArray.u();
        int iU2 = parsableByteArray.u();
        parsableByteArray.X(4);
        int iU3 = parsableByteArray.u();
        String strA = a(iU3);
        if (strA != null) {
            Format.Builder builder = new Format.Builder();
            builder.B0(iU).d0(iU2).u0(strA);
            return new StreamFormatChunk(builder.N());
        }
        Log.i("StreamFormatChunk", "Ignoring track with unsupported compression " + iU3);
        return null;
    }

    public static AviChunk d(int i3, ParsableByteArray parsableByteArray) {
        if (i3 == 2) {
            return c(parsableByteArray);
        }
        if (i3 == 1) {
            return e(parsableByteArray);
        }
        Log.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + Util.s0(i3));
        return null;
    }

    private static AviChunk e(ParsableByteArray parsableByteArray) {
        int iZ = parsableByteArray.z();
        String strB = b(iZ);
        if (strB == null) {
            Log.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + iZ);
            return null;
        }
        int iZ2 = parsableByteArray.z();
        int iU = parsableByteArray.u();
        parsableByteArray.X(6);
        int iH0 = Util.h0(parsableByteArray.z());
        int iZ3 = parsableByteArray.a() > 0 ? parsableByteArray.z() : 0;
        Format.Builder builder = new Format.Builder();
        builder.u0(strB).R(iZ2).v0(iU);
        if (strB.equals("audio/raw") && iH0 != 0) {
            builder.o0(iH0);
        }
        if (strB.equals("audio/mp4a-latm") && iZ3 > 0) {
            byte[] bArr = new byte[iZ3];
            parsableByteArray.l(bArr, 0, iZ3);
            builder.g0(ImmutableList.z(bArr));
        }
        return new StreamFormatChunk(builder.N());
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public int getType() {
        return 1718776947;
    }
}

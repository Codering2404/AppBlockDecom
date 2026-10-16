package androidx.media3.extractor.flv;

import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.flv.TagPayloadReader;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioTagPayloadReader extends TagPayloadReader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f46354e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f46355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f46356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46357d;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f46355b) {
            parsableByteArray.X(1);
        } else {
            int iH = parsableByteArray.H();
            int i3 = (iH >> 4) & 15;
            this.f46357d = i3;
            if (i3 == 2) {
                this.f46378a.c(new Format.Builder().U("video/x-flv").u0("audio/mpeg").R(1).v0(f46354e[(iH >> 2) & 3]).N());
                this.f46356c = true;
            } else if (i3 == 7 || i3 == 8) {
                this.f46378a.c(new Format.Builder().U("video/x-flv").u0(i3 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").R(1).v0(8000).N());
                this.f46356c = true;
            } else if (i3 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f46357d);
            }
            this.f46355b = true;
        }
        return true;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean c(ParsableByteArray parsableByteArray, long j3) {
        if (this.f46357d == 2) {
            int iA = parsableByteArray.a();
            this.f46378a.b(parsableByteArray, iA);
            this.f46378a.g(j3, 1, iA, 0, null);
            return true;
        }
        int iH = parsableByteArray.H();
        if (iH != 0 || this.f46356c) {
            if (this.f46357d == 10 && iH != 1) {
                return false;
            }
            int iA2 = parsableByteArray.a();
            this.f46378a.b(parsableByteArray, iA2);
            this.f46378a.g(j3, 1, iA2, 0, null);
            return true;
        }
        int iA3 = parsableByteArray.a();
        byte[] bArr = new byte[iA3];
        parsableByteArray.l(bArr, 0, iA3);
        AacUtil.Config configE = AacUtil.e(bArr);
        this.f46378a.c(new Format.Builder().U("video/x-flv").u0("audio/mp4a-latm").S(configE.f46026c).R(configE.f46025b).v0(configE.f46024a).g0(Collections.singletonList(bArr)).N());
        this.f46356c = true;
        return false;
    }
}

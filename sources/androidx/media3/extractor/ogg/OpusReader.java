package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class OpusReader extends StreamReader {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f46905o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f46906p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f46907n;

    OpusReader() {
    }

    private static boolean n(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.a() < bArr.length) {
            return false;
        }
        int iF = parsableByteArray.f();
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.l(bArr2, 0, bArr.length);
        parsableByteArray.W(iF);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(ParsableByteArray parsableByteArray) {
        return n(parsableByteArray, f46905o);
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected long f(ParsableByteArray parsableByteArray) {
        return c(OpusUtil.e(parsableByteArray.e()));
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected boolean h(ParsableByteArray parsableByteArray, long j3, StreamReader.SetupData setupData) {
        if (n(parsableByteArray, f46905o)) {
            byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g());
            int iC = OpusUtil.c(bArrCopyOf);
            List listA = OpusUtil.a(bArrCopyOf);
            if (setupData.f46921a != null) {
                return true;
            }
            setupData.f46921a = new Format.Builder().U("audio/ogg").u0("audio/opus").R(iC).v0(48000).g0(listA).N();
            return true;
        }
        byte[] bArr = f46906p;
        if (!n(parsableByteArray, bArr)) {
            Assertions.i(setupData.f46921a);
            return false;
        }
        Assertions.i(setupData.f46921a);
        if (this.f46907n) {
            return true;
        }
        this.f46907n = true;
        parsableByteArray.X(bArr.length);
        Metadata metadataD = VorbisUtil.d(ImmutableList.v(VorbisUtil.k(parsableByteArray, false, false).f46243b));
        if (metadataD == null) {
            return true;
        }
        setupData.f46921a = setupData.f46921a.b().n0(metadataD.b(setupData.f46921a.f40629l)).N();
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f46907n = false;
        }
    }
}

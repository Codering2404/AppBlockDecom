package androidx.media3.decoder;

import android.media.MediaCodec;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CryptoInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f42125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f42127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f42128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f42129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f42130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f42131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f42132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PatternHolderV24 f42133j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PatternHolderV24 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f42134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f42135b;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i3, int i4) {
            this.f42135b.set(i3, i4);
            this.f42134a.setPattern(this.f42135b);
        }

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.f42134a = cryptoInfo;
            this.f42135b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f42132i = cryptoInfo;
        this.f42133j = Util.f41609a >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f42132i;
    }

    public void b(int i3) {
        if (i3 == 0) {
            return;
        }
        if (this.f42127d == null) {
            int[] iArr = new int[1];
            this.f42127d = iArr;
            this.f42132i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f42127d;
        iArr2[0] = iArr2[0] + i3;
    }

    public void c(int i3, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i4, int i5, int i6) {
        this.f42129f = i3;
        this.f42127d = iArr;
        this.f42128e = iArr2;
        this.f42125b = bArr;
        this.f42124a = bArr2;
        this.f42126c = i4;
        this.f42130g = i5;
        this.f42131h = i6;
        MediaCodec.CryptoInfo cryptoInfo = this.f42132i;
        cryptoInfo.numSubSamples = i3;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i4;
        if (Util.f41609a >= 24) {
            ((PatternHolderV24) Assertions.e(this.f42133j)).b(i5, i6);
        }
    }
}

package androidx.media3.extractor.metadata.flac;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PictureFrame implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f46430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f46431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f46432h;

    public PictureFrame(int i3, String str, String str2, int i4, int i5, int i6, int i7, byte[] bArr) {
        this.f46425a = i3;
        this.f46426b = str;
        this.f46427c = str2;
        this.f46428d = i4;
        this.f46429e = i5;
        this.f46430f = i6;
        this.f46431g = i7;
        this.f46432h = bArr;
    }

    public static PictureFrame d(ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        String strR = MimeTypes.r(parsableByteArray.F(parsableByteArray.q(), StandardCharsets.US_ASCII));
        String strE = parsableByteArray.E(parsableByteArray.q());
        int iQ2 = parsableByteArray.q();
        int iQ3 = parsableByteArray.q();
        int iQ4 = parsableByteArray.q();
        int iQ5 = parsableByteArray.q();
        int iQ6 = parsableByteArray.q();
        byte[] bArr = new byte[iQ6];
        parsableByteArray.l(bArr, 0, iQ6);
        return new PictureFrame(iQ, strR, strE, iQ2, iQ3, iQ4, iQ5, bArr);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void b(MediaMetadata.Builder builder) {
        builder.K(this.f46432h, this.f46425a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PictureFrame.class == obj.getClass()) {
            PictureFrame pictureFrame = (PictureFrame) obj;
            if (this.f46425a == pictureFrame.f46425a && this.f46426b.equals(pictureFrame.f46426b) && this.f46427c.equals(pictureFrame.f46427c) && this.f46428d == pictureFrame.f46428d && this.f46429e == pictureFrame.f46429e && this.f46430f == pictureFrame.f46430f && this.f46431g == pictureFrame.f46431g && Arrays.equals(this.f46432h, pictureFrame.f46432h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f46425a) * 31) + this.f46426b.hashCode()) * 31) + this.f46427c.hashCode()) * 31) + this.f46428d) * 31) + this.f46429e) * 31) + this.f46430f) * 31) + this.f46431g) * 31) + Arrays.hashCode(this.f46432h);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f46426b + ", description=" + this.f46427c;
    }
}

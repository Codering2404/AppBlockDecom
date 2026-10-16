package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardGifDecoder implements GifDecoder {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f66199u = "StandardGifDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f66200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f66201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GifDecoder.BitmapProvider f66202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f66203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f66204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[] f66205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f66206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f66207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f66208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f66209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f66210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private GifHeader f66211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f66212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f66213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f66214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f66215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f66216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f66217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Boolean f66218s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Bitmap.Config f66219t;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i3) {
        this(bitmapProvider);
        q(gifHeader, byteBuffer, i3);
    }

    private int i(int i3, int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = i3; i11 < this.f66215p + i3; i11++) {
            byte[] bArr = this.f66208i;
            if (i11 >= bArr.length || i11 >= i4) {
                break;
            }
            int i12 = this.f66200a[bArr[i11] & 255];
            if (i12 != 0) {
                i6 += (i12 >> 24) & 255;
                i7 += (i12 >> 16) & 255;
                i8 += (i12 >> 8) & 255;
                i9 += i12 & 255;
                i10++;
            }
        }
        int i13 = i3 + i5;
        for (int i14 = i13; i14 < this.f66215p + i13; i14++) {
            byte[] bArr2 = this.f66208i;
            if (i14 >= bArr2.length || i14 >= i4) {
                break;
            }
            int i15 = this.f66200a[bArr2[i14] & 255];
            if (i15 != 0) {
                i6 += (i15 >> 24) & 255;
                i7 += (i15 >> 16) & 255;
                i8 += (i15 >> 8) & 255;
                i9 += i15 & 255;
                i10++;
            }
        }
        if (i10 == 0) {
            return 0;
        }
        return ((i6 / i10) << 24) | ((i7 / i10) << 16) | ((i8 / i10) << 8) | (i9 / i10);
    }

    private void j(GifFrame gifFrame) {
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.f66209j;
        int i7 = gifFrame.f66174d;
        int i8 = this.f66215p;
        int i9 = i7 / i8;
        int i10 = gifFrame.f66172b / i8;
        int i11 = gifFrame.f66173c / i8;
        int i12 = gifFrame.f66171a / i8;
        boolean z2 = this.f66210k == 0;
        int i13 = this.f66217r;
        int i14 = this.f66216q;
        byte[] bArr = this.f66208i;
        int[] iArr2 = this.f66200a;
        Boolean bool = this.f66218s;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i17 < i9) {
            int[] iArr3 = iArr;
            if (gifFrame.f66175e) {
                if (i16 >= i9) {
                    int i19 = i18 + 1;
                    i3 = i9;
                    if (i19 == 2) {
                        i18 = i19;
                        i16 = 4;
                    } else if (i19 == 3) {
                        i18 = i19;
                        i15 = 4;
                        i16 = 2;
                    } else if (i19 != 4) {
                        i18 = i19;
                    } else {
                        i18 = i19;
                        i16 = 1;
                        i15 = 2;
                    }
                } else {
                    i3 = i9;
                }
                i4 = i16 + i15;
            } else {
                i3 = i9;
                i4 = i16;
                i16 = i17;
            }
            int i20 = i16 + i10;
            boolean z3 = i8 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i5 = i4;
                int i25 = i17 * i8 * gifFrame.f66173c;
                if (z3) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i26;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr3[i27] = i28;
                        } else if (z2 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26 = i27 + 1;
                    }
                } else {
                    int i29 = ((i23 - i22) * i8) + i25;
                    i6 = i8;
                    int i30 = i22;
                    while (i30 < i23) {
                        int i31 = i23;
                        int i32 = i(i25, i29, gifFrame.f66173c);
                        if (i32 != 0) {
                            iArr3[i30] = i32;
                        } else if (z2 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i25 += i6;
                        i30++;
                        i23 = i31;
                    }
                    i17++;
                    i8 = i6;
                    iArr = iArr3;
                    i9 = i3;
                    i16 = i5;
                }
            } else {
                i5 = i4;
            }
            i6 = i8;
            i17++;
            i8 = i6;
            iArr = iArr3;
            i9 = i3;
            i16 = i5;
        }
        if (this.f66218s == null) {
            this.f66218s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void k(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.f66209j;
        int i3 = gifFrame2.f66174d;
        int i4 = gifFrame2.f66172b;
        int i5 = gifFrame2.f66173c;
        int i6 = gifFrame2.f66171a;
        boolean z2 = this.f66210k == 0;
        int i7 = this.f66217r;
        byte[] bArr = this.f66208i;
        int[] iArr2 = this.f66200a;
        int i8 = 0;
        byte b3 = -1;
        while (i8 < i3) {
            int i9 = (i8 + i4) * i7;
            int i10 = i9 + i6;
            int i11 = i10 + i5;
            int i12 = i9 + i7;
            if (i12 < i11) {
                i11 = i12;
            }
            int i13 = gifFrame2.f66173c * i8;
            int i14 = i10;
            while (i14 < i11) {
                byte b4 = bArr[i13];
                int[] iArr3 = iArr;
                int i15 = b4 & 255;
                if (i15 != b3) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr3[i14] = i16;
                    } else {
                        b3 = b4;
                    }
                }
                i13++;
                i14++;
                iArr = iArr3;
            }
            i8++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.f66218s;
        this.f66218s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f66218s == null && z2 && b3 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void l(GifFrame gifFrame) {
        int i3;
        int i4;
        byte[] bArr;
        short s2;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.f66203d.position(gifFrame.f66180j);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.f66211l;
            i3 = gifHeader.f66187f;
            i4 = gifHeader.f66188g;
        } else {
            i3 = gifFrame.f66173c;
            i4 = gifFrame.f66174d;
        }
        int i5 = i3 * i4;
        byte[] bArr2 = standardGifDecoder.f66208i;
        if (bArr2 == null || bArr2.length < i5) {
            standardGifDecoder.f66208i = standardGifDecoder.f66202c.b(i5);
        }
        byte[] bArr3 = standardGifDecoder.f66208i;
        if (standardGifDecoder.f66205f == null) {
            standardGifDecoder.f66205f = new short[4096];
        }
        short[] sArr = standardGifDecoder.f66205f;
        if (standardGifDecoder.f66206g == null) {
            standardGifDecoder.f66206g = new byte[4096];
        }
        byte[] bArr4 = standardGifDecoder.f66206g;
        if (standardGifDecoder.f66207h == null) {
            standardGifDecoder.f66207h = new byte[4097];
        }
        byte[] bArr5 = standardGifDecoder.f66207h;
        int iP = standardGifDecoder.p();
        int i6 = 1 << iP;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = iP + 1;
        int i10 = (1 << i9) - 1;
        byte b3 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            sArr[i11] = 0;
            bArr4[i11] = (byte) i11;
        }
        byte[] bArr6 = standardGifDecoder.f66204e;
        int i12 = i9;
        int i13 = i8;
        int i14 = i10;
        int i15 = 0;
        int iO = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (true) {
            if (i15 >= i5) {
                break;
            }
            if (iO == 0) {
                iO = standardGifDecoder.o();
                if (iO <= 0) {
                    standardGifDecoder.f66214o = 3;
                    break;
                }
                i16 = b3;
            }
            i18 += (bArr6[i16] & 255) << i17;
            i16++;
            iO--;
            int i23 = i17 + 8;
            int i24 = i13;
            int i25 = i12;
            int i26 = i22;
            short[] sArr2 = sArr;
            int i27 = i20;
            while (true) {
                bArr = bArr4;
                if (i23 < i25) {
                    i13 = i24;
                    i20 = i27;
                    break;
                }
                int i28 = i18 & i14;
                i18 >>= i25;
                i23 -= i25;
                if (i28 == i6) {
                    i25 = i9;
                    i24 = i8;
                    i14 = i10;
                    bArr4 = bArr;
                    i26 = -1;
                } else {
                    if (i28 == i7) {
                        i20 = i27;
                        i13 = i24;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i26 == -1) {
                        bArr3[i19] = bArr[i28];
                        i19++;
                        i15++;
                        i26 = i28;
                        i27 = i26;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i28 >= i24) {
                            bArr7[i21] = (byte) i27;
                            i21++;
                            s2 = i26;
                        } else {
                            s2 = i28;
                        }
                        while (s2 >= i6) {
                            bArr7[i21] = bArr[s2];
                            i21++;
                            s2 = sArr2[s2];
                        }
                        int i29 = bArr[s2] & 255;
                        byte b4 = (byte) i29;
                        bArr3[i19] = b4;
                        while (true) {
                            i19++;
                            i15++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr3[i19] = bArr7[i21];
                        }
                        if (i24 < 4096) {
                            sArr2[i24] = (short) i26;
                            bArr[i24] = b4;
                            i24++;
                            if ((i24 & i14) == 0 && i24 < 4096) {
                                i25++;
                                i14 += i24;
                            }
                        }
                        i26 = i28;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i27 = i29;
                    }
                }
            }
            i17 = i23;
            sArr = sArr2;
            bArr4 = bArr;
            b3 = 0;
            i22 = i26;
            i12 = i25;
            standardGifDecoder = this;
        }
        Arrays.fill(bArr3, i19, i5, b3);
    }

    private Bitmap n() {
        Boolean bool = this.f66218s;
        Bitmap bitmapC = this.f66202c.c(this.f66217r, this.f66216q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f66219t);
        bitmapC.setHasAlpha(true);
        return bitmapC;
    }

    private int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.f66203d;
        byteBuffer.get(this.f66204e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    private int p() {
        return this.f66203d.get() & 255;
    }

    private Bitmap r(GifFrame gifFrame, GifFrame gifFrame2) {
        int i3;
        int i4;
        Bitmap bitmap;
        int[] iArr = this.f66209j;
        int i5 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.f66212m;
            if (bitmap2 != null) {
                this.f66202c.a(bitmap2);
            }
            this.f66212m = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f66177g == 3 && this.f66212m == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i4 = gifFrame2.f66177g) > 0) {
            if (i4 == 2) {
                if (!gifFrame.f66176f) {
                    GifHeader gifHeader = this.f66211l;
                    int i6 = gifHeader.f66193l;
                    if (gifFrame.f66181k == null || gifHeader.f66191j != gifFrame.f66178h) {
                        i5 = i6;
                    }
                }
                int i7 = gifFrame2.f66174d;
                int i8 = this.f66215p;
                int i9 = i7 / i8;
                int i10 = gifFrame2.f66172b / i8;
                int i11 = gifFrame2.f66173c / i8;
                int i12 = gifFrame2.f66171a / i8;
                int i13 = this.f66217r;
                int i14 = (i10 * i13) + i12;
                int i15 = (i9 * i13) + i14;
                while (i14 < i15) {
                    int i16 = i14 + i11;
                    for (int i17 = i14; i17 < i16; i17++) {
                        iArr[i17] = i5;
                    }
                    i14 += this.f66217r;
                }
            } else if (i4 == 3 && (bitmap = this.f66212m) != null) {
                int i18 = this.f66217r;
                bitmap.getPixels(iArr, 0, i18, 0, 0, i18, this.f66216q);
            }
        }
        l(gifFrame);
        if (gifFrame.f66175e || this.f66215p != 1) {
            j(gifFrame);
        } else {
            k(gifFrame);
        }
        if (this.f66213n && ((i3 = gifFrame.f66177g) == 0 || i3 == 1)) {
            if (this.f66212m == null) {
                this.f66212m = n();
            }
            Bitmap bitmap3 = this.f66212m;
            int i19 = this.f66217r;
            bitmap3.setPixels(iArr, 0, i19, 0, 0, i19, this.f66216q);
        }
        Bitmap bitmapN = n();
        int i20 = this.f66217r;
        bitmapN.setPixels(iArr, 0, i20, 0, 0, i20, this.f66216q);
        return bitmapN;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized Bitmap a() {
        try {
            if (this.f66211l.f66184c <= 0 || this.f66210k < 0) {
                String str = f66199u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.f66211l.f66184c + ", framePointer=" + this.f66210k);
                }
                this.f66214o = 1;
            }
            int i3 = this.f66214o;
            if (i3 != 1 && i3 != 2) {
                this.f66214o = 0;
                if (this.f66204e == null) {
                    this.f66204e = this.f66202c.b(255);
                }
                GifFrame gifFrame = (GifFrame) this.f66211l.f66186e.get(this.f66210k);
                int i4 = this.f66210k - 1;
                GifFrame gifFrame2 = i4 >= 0 ? (GifFrame) this.f66211l.f66186e.get(i4) : null;
                int[] iArr = gifFrame.f66181k;
                if (iArr == null) {
                    iArr = this.f66211l.f66182a;
                }
                this.f66200a = iArr;
                if (iArr == null) {
                    String str2 = f66199u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.f66210k);
                    }
                    this.f66214o = 1;
                    return null;
                }
                if (gifFrame.f66176f) {
                    System.arraycopy(iArr, 0, this.f66201b, 0, iArr.length);
                    int[] iArr2 = this.f66201b;
                    this.f66200a = iArr2;
                    iArr2[gifFrame.f66178h] = 0;
                    if (gifFrame.f66177g == 2 && this.f66210k == 0) {
                        this.f66218s = Boolean.TRUE;
                    }
                }
                return r(gifFrame, gifFrame2);
            }
            String str3 = f66199u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.f66214o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void b() {
        this.f66210k = (this.f66210k + 1) % this.f66211l.f66184c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int c() {
        return this.f66211l.f66184c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f66211l = null;
        byte[] bArr = this.f66208i;
        if (bArr != null) {
            this.f66202c.e(bArr);
        }
        int[] iArr = this.f66209j;
        if (iArr != null) {
            this.f66202c.f(iArr);
        }
        Bitmap bitmap = this.f66212m;
        if (bitmap != null) {
            this.f66202c.a(bitmap);
        }
        this.f66212m = null;
        this.f66203d = null;
        this.f66218s = null;
        byte[] bArr2 = this.f66204e;
        if (bArr2 != null) {
            this.f66202c.e(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void d(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f66219t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int e() {
        int i3;
        if (this.f66211l.f66184c <= 0 || (i3 = this.f66210k) < 0) {
            return 0;
        }
        return m(i3);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void f() {
        this.f66210k = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int g() {
        return this.f66210k;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.f66203d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int h() {
        return this.f66203d.limit() + this.f66208i.length + (this.f66209j.length * 4);
    }

    public int m(int i3) {
        if (i3 < 0) {
            return -1;
        }
        GifHeader gifHeader = this.f66211l;
        if (i3 < gifHeader.f66184c) {
            return ((GifFrame) gifHeader.f66186e.get(i3)).f66179i;
        }
        return -1;
    }

    public synchronized void q(GifHeader gifHeader, ByteBuffer byteBuffer, int i3) {
        try {
            if (i3 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i3);
            }
            int iHighestOneBit = Integer.highestOneBit(i3);
            this.f66214o = 0;
            this.f66211l = gifHeader;
            this.f66210k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f66203d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.f66203d.order(ByteOrder.LITTLE_ENDIAN);
            this.f66213n = false;
            Iterator it = gifHeader.f66186e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((GifFrame) it.next()).f66177g == 3) {
                    this.f66213n = true;
                    break;
                }
            }
            this.f66215p = iHighestOneBit;
            int i4 = gifHeader.f66187f;
            this.f66217r = i4 / iHighestOneBit;
            int i5 = gifHeader.f66188g;
            this.f66216q = i5 / iHighestOneBit;
            this.f66208i = this.f66202c.b(i4 * i5);
            this.f66209j = this.f66202c.d(this.f66217r * this.f66216q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider) {
        this.f66201b = new int[Function.MAX_NARGS];
        this.f66219t = Bitmap.Config.ARGB_8888;
        this.f66202c = bitmapProvider;
        this.f66211l = new GifHeader();
    }
}

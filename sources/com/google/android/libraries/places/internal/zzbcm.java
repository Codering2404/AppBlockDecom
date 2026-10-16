package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcm extends zzbco {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f75999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f76000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f76001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f76002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f76003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f76004l;

    /* synthetic */ zzbcm(byte[] bArr, int i3, int i4, boolean z2, byte[] bArr2) {
        super(null);
        this.f76004l = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f75999g = bArr;
        this.f76000h = i4;
        this.f76002j = 0;
    }

    private final void J() {
        int i3 = this.f76000h + this.f76001i;
        this.f76000h = i3;
        int i4 = this.f76004l;
        if (i3 <= i4) {
            this.f76001i = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f76001i = i5;
        this.f76000h = i3 - i5;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int A() {
        return K();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int B() {
        return K();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int C() {
        return N();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long D() {
        return O();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int E() {
        return zzbco.k(K());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long F() {
        return zzbco.l(L());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int G(int i3) {
        if (i3 < 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i4 = i3 + this.f76002j;
        if (i4 < 0) {
            throw new zzbed("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.f76004l;
        if (i4 > i5) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f76004l = i4;
        J();
        return i5;
    }

    public final byte H() throws zzbed {
        int i3 = this.f76002j;
        if (i3 == this.f76000h) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.f75999g;
        this.f76002j = i3 + 1;
        return bArr[i3];
    }

    public final void I(int i3) throws zzbed {
        if (i3 >= 0) {
            int i4 = this.f76000h;
            int i5 = this.f76002j;
            if (i3 <= i4 - i5) {
                this.f76002j = i5 + i3;
                return;
            }
        }
        if (i3 >= 0) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int K() {
        int i3;
        int i4 = this.f76002j;
        int i5 = this.f76000h;
        if (i5 != i4) {
            byte[] bArr = this.f75999g;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.f76002j = i6;
                return b3;
            }
            if (i5 - i6 >= 9) {
                int i7 = i4 + 2;
                int i8 = (bArr[i6] << 7) ^ b3;
                if (i8 < 0) {
                    i3 = i8 ^ (-128);
                } else {
                    int i9 = i4 + 3;
                    int i10 = (bArr[i7] << Ascii.SO) ^ i8;
                    if (i10 >= 0) {
                        i3 = i10 ^ 16256;
                    } else {
                        int i11 = i4 + 4;
                        int i12 = i10 ^ (bArr[i9] << Ascii.NAK);
                        if (i12 < 0) {
                            i3 = (-2080896) ^ i12;
                        } else {
                            i9 = i4 + 5;
                            byte b4 = bArr[i11];
                            int i13 = (i12 ^ (b4 << Ascii.FS)) ^ 266354560;
                            if (b4 < 0) {
                                i11 = i4 + 6;
                                if (bArr[i9] < 0) {
                                    i9 = i4 + 7;
                                    if (bArr[i11] < 0) {
                                        i11 = i4 + 8;
                                        if (bArr[i9] < 0) {
                                            i9 = i4 + 9;
                                            if (bArr[i11] < 0) {
                                                int i14 = i4 + 10;
                                                if (bArr[i9] >= 0) {
                                                    i7 = i14;
                                                    i3 = i13;
                                                }
                                            }
                                        }
                                    }
                                }
                                i3 = i13;
                            }
                            i3 = i13;
                        }
                        i7 = i11;
                    }
                    i7 = i9;
                }
                this.f76002j = i7;
                return i3;
            }
        }
        return (int) M();
    }

    public final long L() {
        long j3;
        long j4;
        long j5;
        int i3 = this.f76002j;
        int i4 = this.f76000h;
        if (i4 != i3) {
            byte[] bArr = this.f75999g;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.f76002j = i5;
                return b3;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b3;
                if (i7 < 0) {
                    j3 = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << Ascii.SO) ^ i7;
                    if (i9 >= 0) {
                        j3 = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                        if (i11 < 0) {
                            long j6 = (-2080896) ^ i11;
                            i6 = i10;
                            j3 = j6;
                        } else {
                            i8 = i3 + 5;
                            long j7 = (((long) bArr[i10]) << 28) ^ ((long) i11);
                            if (j7 >= 0) {
                                j3 = j7 ^ 266354560;
                            } else {
                                i6 = i3 + 6;
                                long j8 = (((long) bArr[i8]) << 35) ^ j7;
                                if (j8 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    int i12 = i3 + 7;
                                    long j9 = j8 ^ (((long) bArr[i6]) << 42);
                                    if (j9 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i3 + 8;
                                        j8 = j9 ^ (((long) bArr[i12]) << 49);
                                        if (j8 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i12 = i3 + 9;
                                            j9 = j8 ^ (((long) bArr[i6]) << 56);
                                            if (j9 >= 0) {
                                                j4 = 71499008037633920L;
                                            } else {
                                                i6 = i3 + 10;
                                                long j10 = j9 ^ (((long) bArr[i12]) << 63);
                                                if (j10 >= 0) {
                                                    j3 = j10 ^ (-9151873028817141888L);
                                                }
                                            }
                                        }
                                    }
                                    j3 = j9 ^ j4;
                                    i6 = i12;
                                }
                                j3 = j8 ^ j5;
                            }
                        }
                    }
                    i6 = i8;
                }
                this.f76002j = i6;
                return j3;
            }
        }
        return M();
    }

    final long M() throws zzbed {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            byte bH = H();
            j3 |= ((long) (bH & Ascii.DEL)) << i3;
            if ((bH & 128) == 0) {
                return j3;
            }
        }
        throw new zzbed("CodedInputStream encountered a malformed varint.");
    }

    public final int N() throws zzbed {
        int i3 = this.f76002j;
        if (this.f76000h - i3 < 4) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.f75999g;
        this.f76002j = i3 + 4;
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    public final long O() throws zzbed {
        int i3 = this.f76002j;
        if (this.f76000h - i3 < 8) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.f75999g;
        this.f76002j = i3 + 8;
        long j3 = bArr[i3];
        long j4 = (((long) bArr[i3 + 1]) & 255) << 8;
        long j5 = bArr[i3 + 2];
        long j6 = bArr[i3 + 3];
        return ((((long) bArr[i3 + 6]) & 255) << 48) | (j3 & 255) | j4 | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final void a(int i3) {
        this.f76004l = i3;
        J();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final boolean b() {
        return this.f76002j == this.f76000h;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int c() {
        return this.f76002j;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int m() throws zzbed {
        if (b()) {
            this.f76003k = 0;
            return 0;
        }
        int iK = K();
        this.f76003k = iK;
        if ((iK >>> 3) != 0) {
            return iK;
        }
        throw new zzbed("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final void n(int i3) throws zzbed {
        if (this.f76003k != i3) {
            throw new zzbed("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final boolean o(int i3) throws zzbed {
        int i4 = i3 & 7;
        int i5 = 0;
        if (i4 == 0) {
            if (this.f76000h - this.f76002j < 10) {
                while (i5 < 10) {
                    if (H() < 0) {
                        i5++;
                    }
                }
                throw new zzbed("CodedInputStream encountered a malformed varint.");
            }
            while (i5 < 10) {
                byte[] bArr = this.f75999g;
                int i6 = this.f76002j;
                this.f76002j = i6 + 1;
                if (bArr[i6] < 0) {
                    i5++;
                }
            }
            throw new zzbed("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i4 == 1) {
            I(8);
            return true;
        }
        if (i4 == 2) {
            I(K());
            return true;
        }
        if (i4 == 3) {
            i();
            n(((i3 >>> 3) << 3) | 4);
            return true;
        }
        if (i4 == 4) {
            h();
            return false;
        }
        if (i4 != 5) {
            throw new zzbec("Protocol message tag had invalid wire type.");
        }
        I(4);
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final double p() {
        return Double.longBitsToDouble(O());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final float q() {
        return Float.intBitsToFloat(N());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long r() {
        return L();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long s() {
        return L();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int t() {
        return K();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long u() {
        return O();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int v() {
        return N();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final boolean w() {
        return L() != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final String x() throws zzbed {
        int iK = K();
        if (iK > 0) {
            int i3 = this.f76000h;
            int i4 = this.f76002j;
            if (iK <= i3 - i4) {
                String str = new String(this.f75999g, i4, iK, zzbeb.f76091a);
                this.f76002j += iK;
                return str;
            }
        }
        if (iK == 0) {
            return "";
        }
        if (iK < 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final String y() throws zzbed {
        int iK = K();
        if (iK > 0) {
            int i3 = this.f76000h;
            int i4 = this.f76002j;
            if (iK <= i3 - i4) {
                String strC = zzbgi.c(this.f75999g, i4, iK);
                this.f76002j += iK;
                return strC;
            }
        }
        if (iK == 0) {
            return "";
        }
        if (iK <= 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final zzbcl z() throws zzbed {
        int iK = K();
        if (iK > 0) {
            int i3 = this.f76000h;
            int i4 = this.f76002j;
            if (iK <= i3 - i4) {
                zzbcl zzbclVarN = zzbcl.n(this.f75999g, i4, iK, false);
                this.f76002j += iK;
                return zzbclVarN;
            }
        }
        if (iK == 0) {
            return zzbcl.f75997b;
        }
        if (iK > 0) {
            int i5 = this.f76000h;
            int i6 = this.f76002j;
            if (iK <= i5 - i6) {
                int i7 = iK + i6;
                this.f76002j = i7;
                byte[] bArrCopyOfRange = Arrays.copyOfRange(this.f75999g, i6, i7);
                zzbcl zzbclVar = zzbcl.f75997b;
                return new zzbck(bArrCopyOfRange);
            }
        }
        if (iK <= 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}

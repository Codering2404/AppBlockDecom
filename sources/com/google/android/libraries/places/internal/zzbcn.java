package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcn extends zzbco {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final InputStream f76005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f76006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f76007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f76008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f76009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f76010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f76011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f76012n;

    /* synthetic */ zzbcn(InputStream inputStream, int i3, byte[] bArr) {
        super(null);
        this.f76012n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        byte[] bArr2 = zzbeb.f76092b;
        this.f76005g = inputStream;
        this.f76006h = new byte[4096];
        this.f76007i = 0;
        this.f76009k = 0;
        this.f76011m = 0;
    }

    private final void J() {
        int i3 = this.f76007i + this.f76008j;
        this.f76007i = i3;
        int i4 = this.f76011m + i3;
        int i5 = this.f76012n;
        if (i4 <= i5) {
            this.f76008j = 0;
            return;
        }
        int i6 = i4 - i5;
        this.f76008j = i6;
        this.f76007i = i3 - i6;
    }

    private final void K(int i3) throws zzbed {
        if (L(i3)) {
            return;
        }
        if (i3 <= (this.f76017d - this.f76011m) - this.f76009k) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzbed("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean L(int i3) throws IOException {
        int i4 = this.f76009k;
        int i5 = i4 + i3;
        int i6 = this.f76007i;
        if (i5 <= i6) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 66);
            sb.append("refillBuffer() called when ");
            sb.append(i3);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        int i7 = this.f76017d;
        int i8 = this.f76011m;
        if (i3 > (i7 - i8) - i4 || i8 + i4 + i3 > this.f76012n) {
            return false;
        }
        if (i4 > 0) {
            if (i6 > i4) {
                byte[] bArr = this.f76006h;
                System.arraycopy(bArr, i4, bArr, 0, i6 - i4);
            }
            i8 = this.f76011m + i4;
            this.f76011m = i8;
            i6 = this.f76007i - i4;
            this.f76007i = i6;
            this.f76009k = 0;
        }
        try {
            int i9 = this.f76005g.read(this.f76006h, i6, Math.min(4096 - i6, (this.f76017d - i8) - i6));
            if (i9 != 0 && i9 >= -1 && i9 <= 4096) {
                if (i9 <= 0) {
                    return false;
                }
                this.f76007i += i9;
                J();
                return this.f76007i >= i3 || L(i3);
            }
            String strValueOf = String.valueOf(this.f76005g.getClass());
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 39 + String.valueOf(i9).length() + 41);
            sb2.append(strValueOf);
            sb2.append("#read(byte[]) returned invalid result: ");
            sb2.append(i9);
            sb2.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(sb2.toString());
        } catch (zzbed e3) {
            e3.a();
            throw e3;
        }
    }

    private final byte[] M(int i3, boolean z2) throws IOException {
        byte[] bArrN = N(i3);
        if (bArrN != null) {
            return bArrN;
        }
        int i4 = this.f76009k;
        int i5 = this.f76007i;
        int i6 = i5 - i4;
        this.f76011m += i5;
        this.f76009k = 0;
        this.f76007i = 0;
        List<byte[]> listO = O(i3 - i6);
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f76006h, i4, bArr, 0, i6);
        for (byte[] bArr2 : listO) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i6, length);
            i6 += length;
        }
        return bArr;
    }

    private final byte[] N(int i3) throws IOException {
        if (i3 == 0) {
            return zzbeb.f76092b;
        }
        int i4 = this.f76011m;
        int i5 = this.f76009k;
        int i6 = i4 + i5 + i3;
        if (i6 - this.f76017d > 0) {
            throw new zzbed("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i7 = this.f76012n;
        if (i6 > i7) {
            I((i7 - i4) - i5);
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i8 = this.f76007i - i5;
        int i9 = i3 - i8;
        if (i9 >= 4096) {
            try {
                if (i9 > this.f76005g.available()) {
                    return null;
                }
            } catch (zzbed e3) {
                e3.a();
                throw e3;
            }
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f76006h, this.f76009k, bArr, 0, i8);
        this.f76011m += this.f76007i;
        this.f76009k = 0;
        this.f76007i = 0;
        while (i8 < i3) {
            try {
                int i10 = this.f76005g.read(bArr, i8, i3 - i8);
                if (i10 == -1) {
                    throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.f76011m += i10;
                i8 += i10;
            } catch (zzbed e4) {
                e4.a();
                throw e4;
            }
        }
        return bArr;
    }

    private final List O(int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i3 > 0) {
            int iMin = Math.min(i3, 4096);
            byte[] bArr = new byte[iMin];
            int i4 = 0;
            while (i4 < iMin) {
                int i5 = this.f76005g.read(bArr, i4, iMin - i4);
                if (i5 == -1) {
                    throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.f76011m += i5;
                i4 += i5;
            }
            i3 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int A() {
        return P();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int B() {
        return P();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int C() {
        return S();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long D() {
        return T();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int E() {
        return zzbco.k(P());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long F() {
        return zzbco.l(Q());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int G(int i3) throws zzbed {
        if (i3 < 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i4 = i3 + this.f76011m + this.f76009k;
        if (i4 < 0) {
            throw new zzbed("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.f76012n;
        if (i4 > i5) {
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f76012n = i4;
        J();
        return i5;
    }

    public final byte H() throws zzbed {
        if (this.f76009k == this.f76007i) {
            K(1);
        }
        byte[] bArr = this.f76006h;
        int i3 = this.f76009k;
        this.f76009k = i3 + 1;
        return bArr[i3];
    }

    public final void I(int i3) throws zzbed {
        int i4 = this.f76007i;
        int i5 = this.f76009k;
        int i6 = i4 - i5;
        if (i3 <= i6 && i3 >= 0) {
            this.f76009k = i5 + i3;
            return;
        }
        if (i3 < 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i7 = this.f76011m;
        int i8 = i7 + i5;
        int i9 = this.f76012n;
        if (i8 + i3 > i9) {
            I((i9 - i7) - i5);
            throw new zzbed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f76011m = i8;
        this.f76007i = 0;
        this.f76009k = 0;
        while (i6 < i3) {
            try {
                long j3 = i3 - i6;
                try {
                    long jSkip = this.f76005g.skip(j3);
                    if (jSkip < 0 || jSkip > j3) {
                        String strValueOf = String.valueOf(this.f76005g.getClass());
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(jSkip).length() + 41);
                        sb.append(strValueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(jSkip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i6 += (int) jSkip;
                    }
                } catch (zzbed e3) {
                    e3.a();
                    throw e3;
                }
            } catch (Throwable th) {
                this.f76011m += i6;
                J();
                throw th;
            }
        }
        this.f76011m += i6;
        J();
        if (i6 >= i3) {
            return;
        }
        int i10 = this.f76007i;
        int i11 = i10 - this.f76009k;
        this.f76009k = i10;
        K(1);
        while (true) {
            int i12 = i3 - i11;
            int i13 = this.f76007i;
            if (i12 <= i13) {
                this.f76009k = i12;
                return;
            } else {
                i11 += i13;
                this.f76009k = i13;
                K(1);
            }
        }
    }

    public final int P() {
        int i3;
        int i4 = this.f76009k;
        int i5 = this.f76007i;
        if (i5 != i4) {
            byte[] bArr = this.f76006h;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.f76009k = i6;
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
                this.f76009k = i7;
                return i3;
            }
        }
        return (int) R();
    }

    public final long Q() {
        long j3;
        long j4;
        long j5;
        int i3 = this.f76009k;
        int i4 = this.f76007i;
        if (i4 != i3) {
            byte[] bArr = this.f76006h;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.f76009k = i5;
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
                this.f76009k = i6;
                return j3;
            }
        }
        return R();
    }

    final long R() throws zzbed {
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

    public final int S() throws zzbed {
        int i3 = this.f76009k;
        if (this.f76007i - i3 < 4) {
            K(4);
            i3 = this.f76009k;
        }
        byte[] bArr = this.f76006h;
        this.f76009k = i3 + 4;
        int i4 = bArr[i3] & 255;
        int i5 = bArr[i3 + 1] & 255;
        int i6 = bArr[i3 + 2] & 255;
        return ((bArr[i3 + 3] & 255) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    public final long T() throws zzbed {
        int i3 = this.f76009k;
        if (this.f76007i - i3 < 8) {
            K(8);
            i3 = this.f76009k;
        }
        byte[] bArr = this.f76006h;
        this.f76009k = i3 + 8;
        long j3 = bArr[i3];
        long j4 = (((long) bArr[i3 + 1]) & 255) << 8;
        long j5 = bArr[i3 + 2];
        long j6 = bArr[i3 + 3];
        return ((((long) bArr[i3 + 6]) & 255) << 48) | (j3 & 255) | j4 | ((j5 & 255) << 16) | ((j6 & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((((long) bArr[i3 + 7]) & 255) << 56);
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final void a(int i3) {
        this.f76012n = i3;
        J();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final boolean b() {
        return this.f76009k == this.f76007i && !L(1);
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int c() {
        return this.f76011m + this.f76009k;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int m() throws zzbed {
        if (b()) {
            this.f76010l = 0;
            return 0;
        }
        int iP = P();
        this.f76010l = iP;
        if ((iP >>> 3) != 0) {
            return iP;
        }
        throw new zzbed("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final void n(int i3) throws zzbed {
        if (this.f76010l != i3) {
            throw new zzbed("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final boolean o(int i3) throws zzbed {
        int i4 = i3 & 7;
        int i5 = 0;
        if (i4 == 0) {
            if (this.f76007i - this.f76009k < 10) {
                while (i5 < 10) {
                    if (H() < 0) {
                        i5++;
                    }
                }
                throw new zzbed("CodedInputStream encountered a malformed varint.");
            }
            while (i5 < 10) {
                byte[] bArr = this.f76006h;
                int i6 = this.f76009k;
                this.f76009k = i6 + 1;
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
            I(P());
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
        return Double.longBitsToDouble(T());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final float q() {
        return Float.intBitsToFloat(S());
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long r() {
        return Q();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long s() {
        return Q();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int t() {
        return P();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final long u() {
        return T();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final int v() {
        return S();
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final boolean w() {
        return Q() != 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final String x() throws zzbed {
        int iP = P();
        if (iP > 0) {
            int i3 = this.f76007i;
            int i4 = this.f76009k;
            if (iP <= i3 - i4) {
                String str = new String(this.f76006h, i4, iP, zzbeb.f76091a);
                this.f76009k += iP;
                return str;
            }
        }
        if (iP == 0) {
            return "";
        }
        if (iP < 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iP > this.f76007i) {
            return new String(M(iP, false), zzbeb.f76091a);
        }
        K(iP);
        String str2 = new String(this.f76006h, this.f76009k, iP, zzbeb.f76091a);
        this.f76009k += iP;
        return str2;
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final zzbcl z() throws IOException {
        int iP = P();
        int i3 = this.f76007i;
        int i4 = this.f76009k;
        if (iP <= i3 - i4 && iP > 0) {
            zzbcl zzbclVarN = zzbcl.n(this.f76006h, i4, iP, false);
            this.f76009k += iP;
            return zzbclVarN;
        }
        if (iP == 0) {
            return zzbcl.f75997b;
        }
        if (iP < 0) {
            throw new zzbed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrN = N(iP);
        if (bArrN != null) {
            return zzbcl.n(bArrN, 0, bArrN.length, false);
        }
        int i5 = this.f76009k;
        int i6 = this.f76007i;
        int i7 = i6 - i5;
        this.f76011m += i6;
        this.f76009k = 0;
        this.f76007i = 0;
        List<byte[]> listO = O(iP - i7);
        byte[] bArr = new byte[iP];
        System.arraycopy(this.f76006h, i5, bArr, 0, i7);
        for (byte[] bArr2 : listO) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i7, length);
            i7 += length;
        }
        zzbcl zzbclVar = zzbcl.f75997b;
        try {
            return new zzbck(bArr);
        } catch (zzbed e3) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbco
    public final String y() throws IOException {
        byte[] bArrM;
        int iP = P();
        int i3 = this.f76009k;
        int i4 = this.f76007i;
        if (iP <= i4 - i3 && iP > 0) {
            bArrM = this.f76006h;
            this.f76009k = i3 + iP;
        } else {
            if (iP == 0) {
                return "";
            }
            if (iP >= 0) {
                i3 = 0;
                if (iP <= i4) {
                    K(iP);
                    bArrM = this.f76006h;
                    this.f76009k = iP;
                } else {
                    bArrM = M(iP, false);
                }
            } else {
                throw new zzbed(MrGIhy.hTjHyWurWFPYNpq);
            }
        }
        return zzbgi.c(bArrM, i3, iP);
    }
}

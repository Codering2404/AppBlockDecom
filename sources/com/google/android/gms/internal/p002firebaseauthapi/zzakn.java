package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzakn extends zzajw {
    private static final Logger zzb = Logger.getLogger(zzakn.class.getName());
    private static final boolean zzc = zzanz.zzc();
    zzakp zza;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class zza extends zzakn {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        zza(byte[] bArr, int i3, int i4) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i4) | i4) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i4)));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i4;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final int zza() {
            return this.zzc - this.zzd;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i3, boolean z2) throws IOException {
            zzj(i3, 0);
            zza(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc() {
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzd(int i3, zzajv zzajvVar) throws IOException {
            zzj(1, 3);
            zzk(2, i3);
            zzc(3, zzajvVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(int i3, long j3) throws IOException {
            zzj(i3, 1);
            zzf(j3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzg(int i3, int i4) throws IOException {
            zzj(i3, 5);
            zzj(i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i3, int i4) throws IOException {
            zzj(i3, 0);
            zzk(i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i3) throws IOException {
            int i4 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i4] = (byte) i3;
                bArr[i4 + 1] = (byte) (i3 >> 8);
                bArr[i4 + 2] = (byte) (i3 >> 16);
                bArr[i4 + 3] = i3 >> Ascii.CAN;
                this.zzd = i4 + 4;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzd(i4, this.zzc, 4, (Throwable) e3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i3) throws IOException {
            if (i3 >= 0) {
                zzm(i3);
            } else {
                zzh(i3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzm(int i3) throws IOException {
            int i4;
            int i5 = this.zzd;
            while ((i3 & (-128)) != 0) {
                try {
                    i4 = i5 + 1;
                    try {
                        this.zzb[i5] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        i3 >>>= 7;
                        i5 = i4;
                    } catch (IndexOutOfBoundsException e3) {
                        e = e3;
                        i5 = i4;
                        throw new zzd(i5, this.zzc, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e4) {
                    e = e4;
                    throw new zzd(i5, this.zzc, 1, (Throwable) e);
                }
            }
            i4 = i5 + 1;
            this.zzb[i5] = (byte) i3;
            this.zzd = i4;
        }

        private final void zzc(byte[] bArr, int i3, int i4) throws IOException {
            try {
                System.arraycopy(bArr, i3, this.zzb, this.zzd, i4);
                this.zzd += i4;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzd(this.zzd, this.zzc, i4, (Throwable) e3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zza(byte b3) throws IOException {
            int i3 = this.zzd;
            try {
                int i4 = i3 + 1;
                try {
                    this.zzb[i3] = b3;
                    this.zzd = i4;
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i3 = i4;
                    throw new zzd(i3, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e4) {
                e = e4;
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(byte[] bArr, int i3, int i4) throws IOException {
            zzm(i4);
            zzc(bArr, 0, i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(long j3) throws IOException {
            int i3 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i3] = (byte) j3;
                bArr[i3 + 1] = (byte) (j3 >> 8);
                bArr[i3 + 2] = (byte) (j3 >> 16);
                bArr[i3 + 3] = (byte) (j3 >> 24);
                bArr[i3 + 4] = (byte) (j3 >> 32);
                bArr[i3 + 5] = (byte) (j3 >> 40);
                bArr[i3 + 6] = (byte) (j3 >> 48);
                bArr[i3 + 7] = (byte) (j3 >> 56);
                this.zzd = i3 + 8;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzd(i3, this.zzc, 8, (Throwable) e3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i3, long j3) throws IOException {
            zzj(i3, 0);
            zzh(j3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i3, int i4) throws IOException {
            zzj(i3, 0);
            zzm(i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzajv zzajvVar) throws IOException {
            zzm(zzajvVar.zzb());
            zzajvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc(int i3, zzajv zzajvVar) throws IOException {
            zzj(i3, 2);
            zzb(zzajvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(long j3) throws IOException {
            int i3;
            int i4;
            int i5 = this.zzd;
            if (zzakn.zzc && zza() >= 10) {
                while ((j3 & (-128)) != 0) {
                    zzanz.zza(this.zzb, i5, (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                    i5++;
                }
                i3 = i5 + 1;
                zzanz.zza(this.zzb, i5, (byte) j3);
            } else {
                while ((j3 & (-128)) != 0) {
                    try {
                        i4 = i5 + 1;
                    } catch (IndexOutOfBoundsException e3) {
                        e = e3;
                    }
                    try {
                        this.zzb[i5] = (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        j3 >>>= 7;
                        i5 = i4;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                        i5 = i4;
                        throw new zzd(i5, this.zzc, 1, (Throwable) e);
                    }
                }
                i3 = i5 + 1;
                try {
                    this.zzb[i5] = (byte) j3;
                } catch (IndexOutOfBoundsException e5) {
                    e = e5;
                    i5 = i3;
                    throw new zzd(i5, this.zzc, 1, (Throwable) e);
                }
            }
            this.zzd = i3;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
        public final void zza(byte[] bArr, int i3, int i4) throws IOException {
            zzc(bArr, i3, i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzamm zzammVar) throws IOException {
            zzm(zzammVar.zzl());
            zzammVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i3, int i4) throws IOException {
            zzm((i3 << 3) | i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i3, zzamm zzammVar) throws IOException {
            zzj(1, 3);
            zzk(2, i3);
            zzj(3, 2);
            zzb(zzammVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i3, String str) throws IOException {
            zzj(i3, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(String str) throws IOException {
            int i3 = this.zzd;
            try {
                int iZzi = zzakn.zzi(str.length() * 3);
                int iZzi2 = zzakn.zzi(str.length());
                if (iZzi2 == iZzi) {
                    int i4 = i3 + iZzi2;
                    this.zzd = i4;
                    int iZza = zzaoa.zza(str, this.zzb, i4, zza());
                    this.zzd = i3;
                    zzm((iZza - i3) - iZzi2);
                    this.zzd = iZza;
                    return;
                }
                zzm(zzaoa.zza(str));
                this.zzd = zzaoa.zza(str, this.zzb, this.zzd, zza());
            } catch (zzaod e3) {
                this.zzd = i3;
                zza(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzd(e4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class zzb extends zzakn {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        zzb(int i3) {
            super();
            if (i3 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i3, 20)];
            this.zzb = bArr;
            this.zzc = bArr.length;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void zzb(byte b3) {
            int i3 = this.zzd;
            this.zzb[i3] = b3;
            this.zzd = i3 + 1;
            this.zze++;
        }

        final void zzi(long j3) {
            int i3 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i3] = (byte) j3;
            bArr[i3 + 1] = (byte) (j3 >> 8);
            bArr[i3 + 2] = (byte) (j3 >> 16);
            bArr[i3 + 3] = (byte) (j3 >> 24);
            bArr[i3 + 4] = (byte) (j3 >> 32);
            bArr[i3 + 5] = (byte) (j3 >> 40);
            bArr[i3 + 6] = (byte) (j3 >> 48);
            bArr[i3 + 7] = (byte) (j3 >> 56);
            this.zzd = i3 + 8;
            this.zze += 8;
        }

        final void zzj(long j3) {
            if (!zzakn.zzc) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i3 = this.zzd;
                    this.zzd = i3 + 1;
                    bArr[i3] = (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.zze++;
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr2[i4] = (byte) j3;
                this.zze++;
                return;
            }
            long j4 = this.zzd;
            while ((j3 & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                zzanz.zza(bArr3, i5, (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i6 = this.zzd;
            this.zzd = i6 + 1;
            zzanz.zza(bArr4, i6, (byte) j3);
            this.zze += (int) (((long) this.zzd) - j4);
        }

        final void zzl(int i3, int i4) {
            zzo((i3 << 3) | i4);
        }

        final void zzn(int i3) {
            int i4 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i4] = (byte) i3;
            bArr[i4 + 1] = (byte) (i3 >> 8);
            bArr[i4 + 2] = (byte) (i3 >> 16);
            bArr[i4 + 3] = i3 >> Ascii.CAN;
            this.zzd = i4 + 4;
            this.zze += 4;
        }

        final void zzo(int i3) {
            if (!zzakn.zzc) {
                while ((i3 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i4 = this.zzd;
                    this.zzd = i4 + 1;
                    bArr[i4] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.zze++;
                    i3 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                bArr2[i5] = (byte) i3;
                this.zze++;
                return;
            }
            long j3 = this.zzd;
            while ((i3 & (-128)) != 0) {
                byte[] bArr3 = this.zzb;
                int i6 = this.zzd;
                this.zzd = i6 + 1;
                zzanz.zza(bArr3, i6, (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                i3 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i7 = this.zzd;
            this.zzd = i7 + 1;
            zzanz.zza(bArr4, i7, (byte) i3);
            this.zze += (int) (((long) this.zzd) - j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        zzd(int i3, int i4, int i5, Throwable th) {
            this(i3, i4, i5, th);
        }

        private zzd(long j3, long j4, int i3, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3)), th);
        }
    }

    public static int zza(double d3) {
        return 8;
    }

    public static int zzb(int i3) {
        return 4;
    }

    public static int zzc(long j3) {
        return 8;
    }

    static int zze(int i3) {
        if (i3 > 4096) {
            return 4096;
        }
        return i3;
    }

    public static int zzf(int i3) {
        return 4;
    }

    public static int zzg(int i3) {
        return zzi(zzn(i3));
    }

    public static int zzh(int i3) {
        return zzi(i3 << 3);
    }

    private static long zzi(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    private static int zzn(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b3) throws IOException;

    public abstract void zzb(int i3, zzamm zzammVar) throws IOException;

    public abstract void zzb(int i3, String str) throws IOException;

    public abstract void zzb(int i3, boolean z2) throws IOException;

    public abstract void zzb(zzajv zzajvVar) throws IOException;

    public abstract void zzb(zzamm zzammVar) throws IOException;

    public abstract void zzb(String str) throws IOException;

    abstract void zzb(byte[] bArr, int i3, int i4) throws IOException;

    public abstract void zzc() throws IOException;

    public abstract void zzc(int i3, zzajv zzajvVar) throws IOException;

    public abstract void zzd(int i3, zzajv zzajvVar) throws IOException;

    public abstract void zzf(int i3, long j3) throws IOException;

    public abstract void zzf(long j3) throws IOException;

    public abstract void zzg(int i3, int i4) throws IOException;

    public abstract void zzh(int i3, int i4) throws IOException;

    public abstract void zzh(int i3, long j3) throws IOException;

    public abstract void zzh(long j3) throws IOException;

    public abstract void zzj(int i3) throws IOException;

    public abstract void zzj(int i3, int i4) throws IOException;

    public abstract void zzk(int i3) throws IOException;

    public abstract void zzk(int i3, int i4) throws IOException;

    public final void zzl(int i3) throws IOException {
        zzm(zzn(i3));
    }

    public abstract void zzm(int i3) throws IOException;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class zzc extends zzb {
        private final OutputStream zzf;

        zzc(OutputStream outputStream, int i3) {
            super(i3);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.zzf = outputStream;
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        private final void zzp(int i3) throws IOException {
            if (this.zzc - this.zzd < i3) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zza(byte b3) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i3, boolean z2) throws IOException {
            zzp(11);
            zzl(i3, 0);
            zzb(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzd(int i3, zzajv zzajvVar) throws IOException {
            zzj(1, 3);
            zzk(2, i3);
            zzc(3, zzajvVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(int i3, long j3) throws IOException {
            zzp(18);
            zzl(i3, 1);
            zzi(j3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzg(int i3, int i4) throws IOException {
            zzp(14);
            zzl(i3, 5);
            zzn(i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i3, int i4) throws IOException {
            zzp(20);
            zzl(i3, 0);
            if (i4 >= 0) {
                zzo(i4);
            } else {
                zzj(i4);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i3) throws IOException {
            zzp(4);
            zzn(i3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i3) throws IOException {
            if (i3 >= 0) {
                zzm(i3);
            } else {
                zzh(i3);
            }
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzm(int i3) throws IOException {
            zzp(5);
            zzo(i3);
        }

        private final void zzc(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = this.zzc;
            int i6 = this.zzd;
            if (i5 - i6 >= i4) {
                System.arraycopy(bArr, i3, this.zzb, i6, i4);
                this.zzd += i4;
            } else {
                int i7 = i5 - i6;
                System.arraycopy(bArr, i3, this.zzb, i6, i7);
                int i8 = i3 + i7;
                i4 -= i7;
                this.zzd = this.zzc;
                this.zze += i7;
                zze();
                if (i4 <= this.zzc) {
                    System.arraycopy(bArr, i8, this.zzb, 0, i4);
                    this.zzd = i4;
                } else {
                    this.zzf.write(bArr, i8, i4);
                }
            }
            this.zze += i4;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzj(int i3, int i4) throws IOException {
            zzm((i3 << 3) | i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzk(int i3, int i4) throws IOException {
            zzp(20);
            zzl(i3, 0);
            zzo(i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajw
        public final void zza(byte[] bArr, int i3, int i4) throws IOException {
            zzc(bArr, i3, i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(byte[] bArr, int i3, int i4) throws IOException {
            zzm(i4);
            zzc(bArr, 0, i4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzf(long j3) throws IOException {
            zzp(8);
            zzi(j3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(int i3, long j3) throws IOException {
            zzp(20);
            zzl(i3, 0);
            zzj(j3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzajv zzajvVar) throws IOException {
            zzm(zzajvVar.zzb());
            zzajvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(zzamm zzammVar) throws IOException {
            zzm(zzammVar.zzl());
            zzammVar.zza(this);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzh(long j3) throws IOException {
            zzp(10);
            zzj(j3);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i3, zzamm zzammVar) throws IOException {
            zzj(1, 3);
            zzk(2, i3);
            zzj(3, 2);
            zzb(zzammVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(int i3, String str) throws IOException {
            zzj(i3, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzc(int i3, zzajv zzajvVar) throws IOException {
            zzj(i3, 2);
            zzb(zzajvVar);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakn
        public final void zzb(String str) throws IOException {
            int iZza;
            try {
                int length = str.length() * 3;
                int iZzi = zzakn.zzi(length);
                int i3 = iZzi + length;
                int i4 = this.zzc;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int iZza2 = zzaoa.zza(str, bArr, 0, length);
                    zzm(iZza2);
                    zza(bArr, 0, iZza2);
                    return;
                }
                if (i3 > i4 - this.zzd) {
                    zze();
                }
                int iZzi2 = zzakn.zzi(str.length());
                int i5 = this.zzd;
                try {
                    if (iZzi2 == iZzi) {
                        int i6 = i5 + iZzi2;
                        this.zzd = i6;
                        int iZza3 = zzaoa.zza(str, this.zzb, i6, this.zzc - i6);
                        this.zzd = i5;
                        iZza = (iZza3 - i5) - iZzi2;
                        zzo(iZza);
                        this.zzd = iZza3;
                    } else {
                        iZza = zzaoa.zza(str);
                        zzo(iZza);
                        this.zzd = zzaoa.zza(str, this.zzb, this.zzd, iZza);
                    }
                    this.zze += iZza;
                } catch (zzaod e3) {
                    this.zze -= this.zzd - i5;
                    this.zzd = i5;
                    throw e3;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new zzd(e4);
                }
            } catch (zzaod e5) {
                zza(str, e5);
            }
        }
    }

    private zzakn() {
    }

    public static int zza(float f3) {
        return 4;
    }

    public static int zzb(int i3, int i4) {
        return zzi(i3 << 3) + 4;
    }

    public static int zzc(int i3, int i4) {
        return zzi(i3 << 3) + zze(i4);
    }

    static int zzd(int i3) {
        return zzi(i3) + i3;
    }

    public static int zze(int i3, int i4) {
        return zzi(i3 << 3) + zzi(zzn(i4));
    }

    public static int zzf(int i3, int i4) {
        return zzi(i3 << 3) + zzi(i4);
    }

    public static int zzi(int i3) {
        return (352 - (Integer.numberOfLeadingZeros(i3) * 9)) >>> 6;
    }

    public final void zzg(int i3, long j3) throws IOException {
        zzh(i3, zzi(j3));
    }

    public static int zza(long j3) {
        return 8;
    }

    public static int zzb(int i3, long j3) {
        return zzi(i3 << 3) + zze(j3);
    }

    public static int zzd(int i3, int i4) {
        return zzi(i3 << 3) + 4;
    }

    public final void zzg(long j3) throws IOException {
        zzh(zzi(j3));
    }

    public final void zzi(int i3, int i4) throws IOException {
        zzk(i3, zzn(i4));
    }

    public static int zza(boolean z2) {
        return 1;
    }

    public static int zzc(int i3) {
        return zze(i3);
    }

    public static int zzd(int i3, long j3) {
        return zzi(i3 << 3) + zze(zzi(j3));
    }

    public static int zze(int i3, long j3) {
        return zzi(i3 << 3) + zze(j3);
    }

    public static int zza(int i3, boolean z2) {
        return zzi(i3 << 3) + 1;
    }

    public static int zzb(long j3) {
        return zze(j3);
    }

    public static int zzc(int i3, long j3) {
        return zzi(i3 << 3) + 8;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzi(length) + length;
    }

    public static int zzb(int i3, zzalu zzaluVar) {
        int iZzi = zzi(i3 << 3);
        int iZza = zzaluVar.zza();
        return iZzi + zzi(iZza) + iZza;
    }

    public static int zzd(long j3) {
        return zze(zzi(j3));
    }

    public static int zze(long j3) {
        return (640 - (Long.numberOfLeadingZeros(j3) * 9)) >>> 6;
    }

    public static int zza(int i3, zzajv zzajvVar) {
        int iZzi = zzi(i3 << 3);
        int iZzb = zzajvVar.zzb();
        return iZzi + zzi(iZzb) + iZzb;
    }

    public static int zzb(int i3, zzajv zzajvVar) {
        return (zzi(8) << 1) + zzf(2, i3) + zza(3, zzajvVar);
    }

    public static int zza(zzajv zzajvVar) {
        int iZzb = zzajvVar.zzb();
        return zzi(iZzb) + iZzb;
    }

    public static zzakn zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zza(int i3, double d3) {
        return zzi(i3 << 3) + 8;
    }

    public static int zza(int i3, int i4) {
        return zzi(i3 << 3) + zze(i4);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int zza(int i3) {
        return zze(i3);
    }

    public final void zzb(boolean z2) throws IOException {
        zza(z2 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i3, long j3) {
        return zzi(i3 << 3) + 8;
    }

    public final void zzb(int i3, double d3) throws IOException {
        zzf(i3, Double.doubleToRawLongBits(d3));
    }

    public static int zza(int i3, float f3) {
        return zzi(i3 << 3) + 4;
    }

    public final void zzb(double d3) throws IOException {
        zzf(Double.doubleToRawLongBits(d3));
    }

    public static int zza(int i3, zzalu zzaluVar) {
        return (zzi(8) << 1) + zzf(2, i3) + zzb(3, zzaluVar);
    }

    public final void zzb(int i3, float f3) throws IOException {
        zzg(i3, Float.floatToRawIntBits(f3));
    }

    public final void zzb(float f3) throws IOException {
        zzj(Float.floatToRawIntBits(f3));
    }

    public static int zza(zzalu zzaluVar) {
        int iZza = zzaluVar.zza();
        return zzi(iZza) + iZza;
    }

    public static int zza(int i3, zzamm zzammVar) {
        return (zzi(8) << 1) + zzf(2, i3) + zzi(24) + zza(zzammVar);
    }

    public static int zza(zzamm zzammVar) {
        int iZzl = zzammVar.zzl();
        return zzi(iZzl) + iZzl;
    }

    public static int zza(int i3, String str) {
        return zzi(i3 << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzaoa.zza(str);
        } catch (zzaod unused) {
            length = str.getBytes(zzalh.zza).length;
        }
        return zzi(length) + length;
    }

    public static zzakn zza(OutputStream outputStream, int i3) {
        return new zzc(outputStream, i3);
    }

    final void zza(String str, zzaod zzaodVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaodVar);
        byte[] bytes = str.getBytes(zzalh.zza);
        try {
            zzm(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzd(e3);
        }
    }
}

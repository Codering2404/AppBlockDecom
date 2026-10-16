package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztz extends zzcp {
    private int zzd;
    private boolean zze;
    private int zzf;
    private long zzg;
    private byte[] zzi;
    private byte[] zzl;
    private int zzh = 0;
    private int zzj = 0;
    private int zzk = 0;

    public zztz() {
        byte[] bArr = zzfl.zzb;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    private final void zzs(boolean z2) {
        int i3;
        int length;
        int i4 = this.zzk;
        int length2 = this.zzi.length;
        if (i4 != length2) {
            if (!z2) {
                return;
            } else {
                z2 = true;
            }
        }
        if (this.zzh == 0) {
            if (z2) {
                zzu(i4, 3);
                length = i4;
            } else {
                zzgtj.zzi(i4 >= (length2 >> 1));
                length = this.zzi.length >> 1;
                zzu(length, 0);
            }
            i3 = length;
        } else {
            int i5 = length2 >> 1;
            int i6 = i4 - i5;
            if (z2) {
                int iZzt = zzt(i6) + (this.zzi.length >> 1);
                zzu(iZzt, 2);
                int i7 = i5 + i6;
                i3 = iZzt;
                length = i7;
            } else {
                int iZzt2 = zzt(i6);
                zzu(iZzt2, 1);
                i3 = iZzt2;
                length = i6;
            }
        }
        if (length % this.zzd != 0) {
            throw new IllegalStateException(zzgua.zzd("bytesConsumed is not aligned to frame size: %s", Integer.valueOf(length)));
        }
        zzgtj.zzi(i4 >= i3);
        this.zzk -= length;
        int i8 = this.zzj + length;
        this.zzj = i8;
        this.zzj = i8 % this.zzi.length;
        int i9 = this.zzh;
        int i10 = this.zzd;
        this.zzh = i9 + (i3 / i10);
        this.zzg += (long) ((length - i3) / i10);
    }

    private final int zzt(int i3) {
        int iZzw = ((zzw(2000000L) - this.zzh) * this.zzd) - (this.zzi.length >> 1);
        zzgtj.zzi(iZzw >= 0);
        int iMin = (int) Math.min((i3 * 0.2f) + 0.5f, iZzw);
        int i4 = this.zzd;
        return (iMin / i4) * i4;
    }

    private final void zzu(int i3, int i4) {
        int i5;
        if (i3 == 0) {
            return;
        }
        zzgtj.zza(this.zzk >= i3);
        if (i4 == 2) {
            int i6 = this.zzj;
            int i7 = this.zzk;
            int i8 = i6 + i7;
            byte[] bArr = this.zzi;
            int length = bArr.length;
            if (i8 <= length) {
                System.arraycopy(bArr, i8 - i3, this.zzl, 0, i3);
            } else {
                int i9 = i7 - (length - i6);
                if (i9 >= i3) {
                    System.arraycopy(bArr, i9 - i3, this.zzl, 0, i3);
                } else {
                    int i10 = i3 - i9;
                    System.arraycopy(bArr, length - i10, this.zzl, 0, i10);
                    System.arraycopy(this.zzi, 0, this.zzl, i10, i9);
                }
            }
        } else {
            int i11 = this.zzj;
            int i12 = i11 + i3;
            byte[] bArr2 = this.zzi;
            int length2 = bArr2.length;
            if (i12 <= length2) {
                System.arraycopy(bArr2, i11, this.zzl, 0, i3);
            } else {
                int i13 = length2 - i11;
                System.arraycopy(bArr2, i11, this.zzl, 0, i13);
                System.arraycopy(this.zzi, 0, this.zzl, i13, i3 - i13);
            }
        }
        zzgtj.zzd(i3 % this.zzd == 0, "sizeToOutput is not aligned to frame size: %s", i3);
        zzgtj.zzi(this.zzj < this.zzi.length);
        byte[] bArr3 = this.zzl;
        zzgtj.zzd(i3 % this.zzd == 0, "byteOutput size is not aligned to frame size %s", i3);
        if (i4 != 3) {
            for (int i14 = 0; i14 < i3; i14 += 2) {
                int i15 = i14 + 1;
                int iZzv = zzv(bArr3[i15], bArr3[i14]);
                if (i4 == 0) {
                    i5 = ((((i14 * 1000) / (i3 - 1)) * (-90)) / 1000) + 100;
                } else {
                    i5 = 10;
                    if (i4 == 2) {
                        i5 = 10 + (((90000 * i14) / (i3 - 1)) / 1000);
                    }
                }
                int i16 = (iZzv * i5) / 100;
                if (i16 >= 32767) {
                    bArr3[i14] = -1;
                    bArr3[i15] = Ascii.DEL;
                } else if (i16 <= -32768) {
                    bArr3[i14] = 0;
                    bArr3[i15] = -128;
                } else {
                    bArr3[i14] = (byte) (i16 & 255);
                    bArr3[i15] = (byte) (i16 >> 8);
                }
            }
        }
        zzk(i3).put(bArr3, 0, i3).flip();
    }

    private static int zzv(byte b3, byte b4) {
        return (b3 << 8) | (b4 & 255);
    }

    private final int zzw(long j3) {
        return (int) ((j3 * ((long) this.zzb.zzb)) / 1000000);
    }

    private static final boolean zzx(byte b3, byte b4) {
        return Math.abs(zzv(b3, b4)) > 1024;
    }

    @Override // com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzco
    public final boolean zzc() {
        return super.zzc() && this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzd(ByteBuffer byteBuffer) {
        int iLimit;
        int i3;
        int iPosition;
        while (byteBuffer.hasRemaining() && !zzl()) {
            if (this.zzf != 0) {
                zzgtj.zzi(this.zzj < this.zzi.length);
                int iLimit2 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    } else {
                        if (zzx(byteBuffer.get(iPosition2), byteBuffer.get(iPosition2 - 1))) {
                            int i4 = this.zzd;
                            iLimit = i4 * (iPosition2 / i4);
                            break;
                        }
                        iPosition2 += 2;
                    }
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int i5 = this.zzj;
                int i6 = this.zzk;
                int i7 = i5 + i6;
                int length = this.zzi.length;
                if (i7 < length) {
                    i3 = length - i7;
                } else {
                    i7 = i6 - (length - i5);
                    i3 = i5 - i7;
                }
                int iMin = Math.min(iPosition3, i3);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.zzi, i7, iMin);
                int i8 = this.zzk + iMin;
                this.zzk = i8;
                zzgtj.zzi(i8 <= this.zzi.length);
                boolean z2 = iLimit < iLimit2 && iPosition3 < i3;
                zzs(z2);
                if (z2) {
                    this.zzf = 0;
                    this.zzh = 0;
                }
                byteBuffer.limit(iLimit2);
            } else {
                int iLimit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit3, byteBuffer.position() + this.zzi.length));
                int iLimit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit4 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else {
                        if (zzx(byteBuffer.get(iLimit4), byteBuffer.get(iLimit4 - 1))) {
                            int i9 = this.zzd;
                            iPosition = ((iLimit4 / i9) * i9) + i9;
                            break;
                        }
                        iLimit4 -= 2;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.zzf = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    zzk(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final zzcl zzm(zzcl zzclVar) throws zzcn {
        if (zzclVar.zzd == 2) {
            return zzclVar.zzb == -1 ? zzcl.zza : zzclVar;
        }
        throw new zzcn("Unhandled input format:", zzclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzn() {
        if (this.zzk > 0) {
            zzs(true);
            this.zzh = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzo(zzcm zzcmVar) {
        if (zzc()) {
            int i3 = this.zzb.zzc;
            this.zzd = i3 + i3;
            int iZzw = zzw(100000L) / 2;
            int i4 = this.zzd;
            int i5 = (iZzw / i4) * i4;
            int i6 = i5 + i5;
            if (this.zzi.length != i6) {
                this.zzi = new byte[i6];
                this.zzl = new byte[i6];
            }
        }
        this.zzf = 0;
        this.zzg = 0L;
        this.zzh = 0;
        this.zzj = 0;
        this.zzk = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzp() {
        this.zze = false;
        byte[] bArr = zzfl.zzb;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    public final void zzq(boolean z2) {
        this.zze = z2;
    }

    public final long zzr() {
        return this.zzg;
    }
}

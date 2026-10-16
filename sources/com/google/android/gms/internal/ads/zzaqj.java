package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqj {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(com.google.android.gms.internal.ads.zzes r18, com.google.android.gms.internal.ads.zzaqh r19) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqj.zza(com.google.android.gms.internal.ads.zzes, com.google.android.gms.internal.ads.zzaqh):boolean");
    }

    public static zzaqi zzb(zzes zzesVar) throws zzat {
        int iZzj;
        int i3;
        char c3;
        int i4;
        int i5;
        int iZzj2;
        char c4;
        int iZzj3 = zzesVar.zzj(8);
        int i6 = 5;
        int iZzj4 = zzesVar.zzj(5);
        if (iZzj4 != 31) {
            switch (iZzj4) {
                case 0:
                    iZzj = 96000;
                    break;
                case 1:
                    iZzj = 88200;
                    break;
                case 2:
                    iZzj = 64000;
                    break;
                case 3:
                    iZzj = 48000;
                    break;
                case 4:
                    iZzj = 44100;
                    break;
                case 5:
                    iZzj = 32000;
                    break;
                case 6:
                    iZzj = 24000;
                    break;
                case 7:
                    iZzj = 22050;
                    break;
                case 8:
                    iZzj = 16000;
                    break;
                case 9:
                    iZzj = 12000;
                    break;
                case 10:
                    iZzj = 11025;
                    break;
                case 11:
                    iZzj = 8000;
                    break;
                case 12:
                    iZzj = 7350;
                    break;
                case 13:
                case 14:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 32);
                    sb.append("Unsupported sampling rate index ");
                    sb.append(iZzj4);
                    throw zzat.zzc(sb.toString());
                case 15:
                    iZzj = 57600;
                    break;
                case 16:
                    iZzj = 51200;
                    break;
                case 17:
                    iZzj = 40000;
                    break;
                case 18:
                    iZzj = 38400;
                    break;
                case 19:
                    iZzj = 34150;
                    break;
                case 20:
                    iZzj = 28800;
                    break;
                case 21:
                    iZzj = 25600;
                    break;
                case 22:
                    iZzj = 20000;
                    break;
                case 23:
                    iZzj = 19200;
                    break;
                case 24:
                    iZzj = 17075;
                    break;
                case 25:
                    iZzj = 14400;
                    break;
                case 26:
                    iZzj = 12800;
                    break;
                case 27:
                    iZzj = 9600;
                    break;
            }
        } else {
            iZzj = zzesVar.zzj(24);
        }
        int iZzj5 = zzesVar.zzj(3);
        int i7 = 1;
        if (iZzj5 == 0) {
            i3 = 768;
        } else if (iZzj5 == 1) {
            i3 = 1024;
        } else if (iZzj5 == 2 || iZzj5 == 3) {
            i3 = 2048;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj5).length() + 36);
                sb2.append("Unsupported coreSbrFrameLengthIndex ");
                sb2.append(iZzj5);
                throw zzat.zzc(sb2.toString());
            }
            i3 = 4096;
        }
        if (iZzj5 == 0 || iZzj5 == 1) {
            c3 = 0;
        } else if (iZzj5 == 2) {
            c3 = 2;
        } else if (iZzj5 == 3) {
            c3 = 3;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(iZzj5).length() + 36);
                sb3.append("Unsupported coreSbrFrameLengthIndex ");
                sb3.append(iZzj5);
                throw zzat.zzc(sb3.toString());
            }
            c3 = 1;
        }
        zzesVar.zzh(2);
        zzc(zzesVar);
        int iZzj6 = zzesVar.zzj(5);
        int i8 = 0;
        int iZzf = 0;
        while (true) {
            int i9 = 16;
            if (i8 < iZzj6 + 1) {
                int iZzj7 = zzesVar.zzj(3);
                iZzf += zzf(zzesVar, 5, 8, 16) + 1;
                if ((iZzj7 == 0 || iZzj7 == 2) && zzesVar.zzi()) {
                    zzc(zzesVar);
                }
                i8++;
            } else {
                int iZzf2 = zzf(zzesVar, 4, 8, 16) + 1;
                zzesVar.zzg();
                int i10 = 0;
                while (true) {
                    double d3 = 2.0d;
                    if (i10 >= iZzf2) {
                        int i11 = iZzj3;
                        byte[] bArr = null;
                        if (zzesVar.zzi()) {
                            int iZzf3 = zzf(zzesVar, 2, 4, 8) + 1;
                            for (int i12 = 0; i12 < iZzf3; i12++) {
                                int iZzf4 = zzf(zzesVar, 4, 8, 16);
                                int iZzf5 = zzf(zzesVar, 4, 8, 16);
                                if (iZzf4 == 7) {
                                    int iZzj8 = zzesVar.zzj(4) + 1;
                                    zzesVar.zzh(4);
                                    byte[] bArr2 = new byte[iZzj8];
                                    for (int i13 = 0; i13 < iZzj8; i13++) {
                                        bArr2[i13] = (byte) zzesVar.zzj(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzesVar.zzh(iZzf5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (iZzj) {
                            case 14700:
                            case 16000:
                                d3 = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d3 = 1.5d;
                                break;
                            case 44100:
                            case 48000:
                            case 88200:
                            case 96000:
                                d3 = 1.0d;
                                break;
                            default:
                                StringBuilder sb4 = new StringBuilder(String.valueOf(iZzj).length() + 26);
                                sb4.append("Unsupported sampling rate ");
                                sb4.append(iZzj);
                                throw zzat.zzc(sb4.toString());
                        }
                        return new zzaqi(i11, (int) (((double) iZzj) * d3), (int) (((double) i3) * d3), bArr3, null);
                    }
                    int iZzj9 = zzesVar.zzj(2);
                    if (iZzj9 == 0) {
                        i4 = iZzj3;
                        i5 = i7;
                        zzd(zzesVar);
                        if (c3 > 0) {
                            zze(zzesVar);
                        }
                    } else if (iZzj9 == i7) {
                        i5 = i7;
                        if (zzd(zzesVar)) {
                            zzesVar.zzg();
                        }
                        if (c3 > 0) {
                            zze(zzesVar);
                            iZzj2 = zzesVar.zzj(2);
                            c4 = c3;
                        } else {
                            iZzj2 = 0;
                            c4 = 0;
                        }
                        if (iZzj2 > 0) {
                            zzesVar.zzh(6);
                            int iZzj10 = zzesVar.zzj(2);
                            zzesVar.zzh(4);
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(i6);
                            }
                            if (iZzj2 == 2 || iZzj2 == 3) {
                                zzesVar.zzh(6);
                            }
                            if (iZzj10 == 2) {
                                zzesVar.zzg();
                            }
                        }
                        i4 = iZzj3;
                        int iFloor = ((int) Math.floor(Math.log(iZzf - 1) / Math.log(2.0d))) + 1;
                        int iZzj11 = zzesVar.zzj(2);
                        if (iZzj11 > 0 && zzesVar.zzi()) {
                            zzesVar.zzh(iFloor);
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(iFloor);
                        }
                        if (c4 == 0 && iZzj11 == 0) {
                            zzesVar.zzg();
                        }
                    } else if (iZzj9 != 3) {
                        i4 = iZzj3;
                        i5 = i7;
                    } else {
                        zzf(zzesVar, 4, 8, i9);
                        int iZzf6 = zzf(zzesVar, 4, 8, i9);
                        i5 = i7;
                        if (zzesVar.zzi()) {
                            zzf(zzesVar, 8, i9, 0);
                        }
                        zzesVar.zzg();
                        if (iZzf6 > 0) {
                            zzesVar.zzh(iZzf6 * 8);
                        }
                        i4 = iZzj3;
                    }
                    i10++;
                    iZzj3 = i4;
                    i7 = i5;
                    i6 = 5;
                    i9 = 16;
                }
            }
        }
    }

    private static void zzc(zzes zzesVar) {
        int iZzj;
        int iZzj2 = zzesVar.zzj(2);
        if (iZzj2 == 0) {
            zzesVar.zzh(6);
            return;
        }
        int iZzf = zzf(zzesVar, 5, 8, 16) + 1;
        if (iZzj2 == 1) {
            zzesVar.zzh(iZzf * 7);
            return;
        }
        if (iZzj2 == 2) {
            boolean zZzi = zzesVar.zzi();
            int i3 = true != zZzi ? 5 : 1;
            int i4 = true == zZzi ? 7 : 5;
            int i5 = true == zZzi ? 8 : 6;
            int i6 = 0;
            while (i6 < iZzf) {
                if (zzesVar.zzi()) {
                    zzesVar.zzh(7);
                    iZzj = 0;
                } else {
                    if (zzesVar.zzj(2) == 3 && zzesVar.zzj(i4) * i3 != 0) {
                        zzesVar.zzg();
                    }
                    iZzj = zzesVar.zzj(i5) * i3;
                    if (iZzj != 0 && iZzj != 180) {
                        zzesVar.zzg();
                    }
                    zzesVar.zzg();
                }
                if (iZzj != 0 && iZzj != 180 && zzesVar.zzi()) {
                    i6++;
                }
                i6++;
            }
        }
    }

    private static boolean zzd(zzes zzesVar) {
        zzesVar.zzh(3);
        boolean zZzi = zzesVar.zzi();
        if (zZzi) {
            zzesVar.zzh(13);
        }
        return zZzi;
    }

    private static void zze(zzes zzesVar) {
        zzesVar.zzh(3);
        zzesVar.zzh(8);
        boolean zZzi = zzesVar.zzi();
        boolean zZzi2 = zzesVar.zzi();
        if (zZzi) {
            zzesVar.zzh(5);
        }
        if (zZzi2) {
            zzesVar.zzh(6);
        }
    }

    private static int zzf(zzes zzesVar, int i3, int i4, int i5) {
        zzgtj.zza(Math.max(Math.max(i3, i4), i5) <= 31);
        int i6 = (1 << i3) - 1;
        int i7 = (1 << i4) - 1;
        Math.addExact(Math.addExact(i6, i7), 1 << i5);
        if (zzesVar.zzc() < i3) {
            return -1;
        }
        int iZzj = zzesVar.zzj(i3);
        if (iZzj != i6) {
            return iZzj;
        }
        if (zzesVar.zzc() < i4) {
            return -1;
        }
        int iZzj2 = zzesVar.zzj(i4);
        int i8 = iZzj + iZzj2;
        if (iZzj2 != i7) {
            return i8;
        }
        if (zzesVar.zzc() < i5) {
            return -1;
        }
        return i8 + zzesVar.zzj(i5);
    }
}

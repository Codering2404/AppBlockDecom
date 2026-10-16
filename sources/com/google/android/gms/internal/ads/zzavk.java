package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzavk implements zzawe {
    public static final /* synthetic */ zzavk zza;
    public static final /* synthetic */ zzavk zzb;
    public static final /* synthetic */ zzavk zzc;
    public static final /* synthetic */ zzavk zzd;
    public static final /* synthetic */ zzavk zze;
    public static final /* synthetic */ zzavk zzf;
    public static final /* synthetic */ zzavk zzg;
    public static final /* synthetic */ zzavk zzh;
    public static final /* synthetic */ zzavk zzi;
    public static final /* synthetic */ zzavk zzj;
    public static final /* synthetic */ zzavk zzk;
    public static final /* synthetic */ zzavk zzl;
    public static final /* synthetic */ zzavk zzm;
    public static final /* synthetic */ zzavk zzn;
    public static final /* synthetic */ zzavk zzo;
    public static final /* synthetic */ zzavk zzp;
    public static final /* synthetic */ zzavk zzq;
    public static final /* synthetic */ zzavk zzr;
    public static final /* synthetic */ zzavk zzs;
    public static final /* synthetic */ zzavk zzt;
    public static final /* synthetic */ zzavk zzu;
    private final /* synthetic */ int zzv;

    static {
        int i3 = (((((~574682290) & 203332142) | 828655825) + ((574682290 & 488280686) | 1367367889)) - 2039730118) ^ (1891066487 % 382926234);
        int i4 = (((((~138700754) & 1311190796) | 1098494210) + ((138700754 & 235277837) | 2126145)) - 1303500118) ^ (631340353 % 54449299);
        int i5 = (((((~429857344) & 761470753) | 244716435) + ((429857344 & 862030880) | 1585885407)) - (-1912977126)) ^ (1209597698 % 1200977805);
        int i6 = (((((~353056618) & 587352576) | 1209239528) + ((353056618 & 1728108930) | 1420269559)) - (-1847305937)) ^ (1896236448 % 1127167744);
        int i7 = (((((~899633766) & 123837830) | 368257288) + ((899633766 & 167810182) | 1023429240)) - 1335244442) ^ (2104001379 % 2013966848);
        int i8 = (((((~1451163042) & 1144033732) | 979119168) + ((1451163042 & 1142985108) | 17523737)) - 1635219142) ^ (1178835412 % 674426555);
        int i9 = (((((~2129768394) & 1627076842) | 1930240353) + ((2129768394 & 384997514) | 369722160)) - (-1995771891)) ^ (1450967523 % 42186306);
        zzu = new zzavk((((((~880944650) & 1717883648) | 10231720) + ((880944650 & 1718140932) | 277359766)) - 1470954277) ^ (2122533302 % 1588279465));
        zzt = new zzavk((((((~2105342203) & 63587109) | 1700430907) + ((2105342203 & 42025732) | 358031402)) - 2053339984) ^ (1059789835 % 1012707329));
        zzs = new zzavk((((((~217704412) & 144255288) | 1174857666) + ((217704412 & 1788447288) | 1667270208)) - (-1441824169)) ^ (1234644696 % 220282619));
        zzr = new zzavk(i9);
        zzq = new zzavk(i6);
        zzp = new zzavk(i7);
        zzavk zzavkVar = new zzavk(i8);
        int i10 = (((((~363159161) & 562794784) | 672605403) + ((363159161 & 25727904) | 2081572569)) - (-1616076716)) ^ (912078408 % 135177290);
        int i11 = (((((~1362243428) & 18451060) | 1179867339) + ((1362243428 & 558662325) | 550966467)) - 1623872455) ^ (1106211926 % 327305250);
        int i12 = (((((~1725362297) & 1360741300) | 1109702041) + ((1725362297 & 354116135) | 1147188355)) - (-1834394863)) ^ (1760481135 % 279527351);
        int i13 = (((((~167368542) & 67146177) | 1656237739) + ((167368542 & 1145098568) | 1113671327)) - (-1733089599)) ^ (1999038585 % 574620392);
        int i14 = (((((~1855103807) & 659964675) | 1290440236) + ((1855103807 & 588562691) | 482511980)) - 1987315200) ^ (988506952 % 614340012);
        int i15 = (((((~309667127) & 3230344) | 101519449) + ((309667127 & 607439488) | 793023522)) - 846909944) ^ (1953534826 % 1902736997);
        int i16 = (((((~682736626) & 1985796848) | 208315317) + ((682736626 & 1922324801) | 8464129)) - 2089727599) ^ (649022765 % 608034986);
        int i17 = (((((~2068224547) & 575179716) | 1587938398) + ((2068224547 & 1013484418) | 1605526586)) - (-1152499266)) ^ (1603386966 % 1010764797);
        int i18 = (((((~1281944976) & 1463473736) | 847256033) + ((1281944976 & 1698424328) | 948255187)) - (-1974214194)) ^ (1727952741 % 1091714937);
        zzo = zzavkVar;
        zzn = new zzavk(i5);
        zzm = new zzavk(i10);
        zzl = new zzavk(i11);
        zzk = new zzavk(i12);
        zzj = new zzavk(i4);
        zzi = new zzavk(i13);
        zzh = new zzavk(i14);
        zzg = new zzavk(i15);
        zzf = new zzavk(i3);
        zze = new zzavk(i16);
        zzd = new zzavk(i17);
        zzc = new zzavk(i18);
        zzb = new zzavk(1);
        zza = new zzavk(0);
    }

    private /* synthetic */ zzavk(int i3) {
        this.zzv = i3;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzauw zzauwVar;
        long j3 = 1;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        switch (this.zzv) {
                                            case 0:
                                                zzawh zzawhVar = (zzawh) obj;
                                                zzawd zzawdVar = zzawhVar.zzb;
                                                long jZzm = zzawdVar.zzc().zzm();
                                                if (zzawdVar.zzc().zzm() != 0) {
                                                    zzawhVar.zzd.zza(jZzm);
                                                }
                                                return Optional.empty();
                                            case 1:
                                                try {
                                                    zzawd zzawdVar2 = ((zzawh) obj).zzb;
                                                    long jZzm2 = zzawdVar2.zzc().zzm();
                                                    zzawm zzawmVarZzc = zzawdVar2.zzc();
                                                    zzawm zzawmVarZzc2 = zzawdVar2.zzc();
                                                    List listZzo = zzawmVarZzc2.zzo();
                                                    if (jZzm2 < 0) {
                                                        jZzm2 += (long) (listZzo.size() + 1);
                                                    }
                                                    if (jZzm2 < 0 || jZzm2 >= listZzo.size() + 1) {
                                                        throw new zzawk();
                                                    }
                                                    listZzo.add((int) jZzm2, zzawmVarZzc);
                                                    zzawdVar2.zzb(zzawmVarZzc2);
                                                    return Optional.empty();
                                                } catch (zzawk unused) {
                                                    zzauwVar = zzauw.zzI;
                                                }
                                                break;
                                            case 2:
                                                zzawh zzawhVar2 = (zzawh) obj;
                                                zzawd zzawdVar3 = zzawhVar2.zzb;
                                                long jZzm3 = zzawdVar3.zzc().zzm();
                                                if (zzawdVar3.zzc().zzm() == 0) {
                                                    zzawhVar2.zzd.zza(jZzm3);
                                                }
                                                return Optional.empty();
                                            case 3:
                                                ((zzawh) obj).zzb.zzb(zzawm.zzb(r0.zzc().zzo().size()));
                                                return Optional.empty();
                                            case 4:
                                                ((zzawh) obj).zzb.zzb(zzawm.zzb(r0.zzc().zzn().zza.length));
                                                return Optional.empty();
                                            case 5:
                                                zzawd zzawdVar4 = ((zzawh) obj).zzb;
                                                zzawdVar4.zzb(zzawm.zzc(Math.log(zzawdVar4.zzc().zzq())));
                                                return Optional.empty();
                                            case 6:
                                                zzawd zzawdVar5 = ((zzawh) obj).zzb;
                                                long jZzm4 = zzawdVar5.zzc().zzm();
                                                long jZzm5 = zzawdVar5.zzc().zzm();
                                                if (jZzm4 == 0 || jZzm5 == 0) {
                                                    j3 = 0;
                                                }
                                                zzawdVar5.zzb(zzawm.zzb(j3));
                                                return Optional.empty();
                                            case 7:
                                                zzawd zzawdVar6 = ((zzawh) obj).zzb;
                                                if (zzawdVar6.zzc().zzm() != 0) {
                                                    j3 = 0;
                                                }
                                                zzawdVar6.zzb(zzawm.zzb(j3));
                                                return Optional.empty();
                                            case 8:
                                                zzawd zzawdVar7 = ((zzawh) obj).zzb;
                                                long jZzm6 = zzawdVar7.zzc().zzm();
                                                long jZzm7 = zzawdVar7.zzc().zzm();
                                                if (jZzm6 == 0 && jZzm7 == 0) {
                                                    j3 = 0;
                                                }
                                                zzawdVar7.zzb(zzawm.zzb(j3));
                                                return Optional.empty();
                                            case 9:
                                                zzawh zzawhVar3 = (zzawh) obj;
                                                zzawd zzawdVar8 = zzawhVar3.zzb;
                                                try {
                                                    int iCompare = new zzawi(false).compare(zzawdVar8.zzc(), zzawdVar8.zzc());
                                                    zzawd zzawdVar9 = zzawhVar3.zzb;
                                                    if (iCompare >= 0) {
                                                        j3 = 0;
                                                    }
                                                    zzawdVar9.zzb(zzawm.zzb(j3));
                                                    return Optional.empty();
                                                } catch (IllegalArgumentException unused2) {
                                                    return Optional.of(zzauw.zzd);
                                                }
                                            case 10:
                                                int[] iArr = {1944216249, 348137722, 926438168, 13122018, 1882968836, -1273372307, 246144337, 1723705710, 1677157265};
                                                int i3 = iArr[0];
                                                int i4 = iArr[1];
                                                int i5 = iArr[2];
                                                int i6 = iArr[3];
                                                int i7 = iArr[4];
                                                int i8 = iArr[5];
                                                int i9 = iArr[6];
                                                int i10 = iArr[7];
                                                int i11 = i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8);
                                                int i12 = i10 % 1677157265;
                                                zzawh zzawhVar4 = (zzawh) obj;
                                                try {
                                                    zzawd zzawdVar10 = zzawhVar4.zzb;
                                                    long jZzm8 = zzawdVar10.zzc().zzm();
                                                    zzavc zzavcVar = zzawhVar4.zza;
                                                    zzawd zzawdVar11 = new zzawd(i12 ^ i11);
                                                    for (int i13 = 0; i13 < zzawdVar10.zzb; i13++) {
                                                        try {
                                                            zzawdVar11.zzb(zzawm.zzj((zzawm) zzawdVar10.zza.get(i13)));
                                                        } catch (zzawc e3) {
                                                            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e3);
                                                        }
                                                        break;
                                                    }
                                                    zzavv zzavvVar = zzawhVar4.zzd;
                                                    new zzawh(zzavcVar, zzawdVar11, new zzavv(zzavvVar.zzb, zzavvVar.zza, zzavvVar.zzc.zzc(), zzavvVar.zzd)).zzd.zza(jZzm8);
                                                    zzawdVar10.zzb(zzawm.zza(new zzavm()));
                                                    return Optional.empty();
                                                } catch (zzavt | zzavu unused3) {
                                                    zzauwVar = zzauw.zzt;
                                                }
                                                break;
                                            case 11:
                                                try {
                                                    zzawd zzawdVar12 = ((zzawh) obj).zzb;
                                                    zzawdVar12.zzb(zzawm.zza(zzawdVar12.zzc().zzi((Class) zzawdVar12.zzc().zzl())));
                                                    return Optional.empty();
                                                } catch (zzawj unused4) {
                                                    zzauwVar = zzauw.zzp;
                                                }
                                                break;
                                            case 12:
                                                zzawd zzawdVar13 = ((zzawh) obj).zzb;
                                                long jZzm9 = zzawdVar13.zzc().zzm();
                                                long jZzm10 = zzawdVar13.zzc().zzm();
                                                if (jZzm9 == 0) {
                                                    return Optional.of(zzauw.zzF);
                                                }
                                                zzawdVar13.zzb(zzawm.zzb(jZzm10 % jZzm9));
                                                return Optional.empty();
                                            case 13:
                                                zzawd zzawdVar14 = ((zzawh) obj).zzb;
                                                zzawdVar14.zzb(zzawm.zzc(zzawdVar14.zzc().zzq() * zzawdVar14.zzc().zzq()));
                                                return Optional.empty();
                                            case 14:
                                                zzawd zzawdVar15 = ((zzawh) obj).zzb;
                                                zzawdVar15.zzb(zzawm.zzb(zzawdVar15.zzc().zzm() * zzawdVar15.zzc().zzm()));
                                                return Optional.empty();
                                            case 15:
                                                zzawd zzawdVar16 = ((zzawh) obj).zzb;
                                                long jZzm11 = zzawdVar16.zzc().zzm();
                                                ArrayList arrayList = new ArrayList();
                                                for (long j4 = 0; j4 < jZzm11; j4++) {
                                                    arrayList.add(zzawdVar16.zzc());
                                                }
                                                Collections.reverse(arrayList);
                                                zzawdVar16.zzb(zzawm.zze(arrayList));
                                                return Optional.empty();
                                            case 16:
                                                zzawd zzawdVar17 = ((zzawh) obj).zzb;
                                                zzawdVar17.zzb(zzawm.zzc(Math.pow(zzawdVar17.zzc().zzq(), zzawdVar17.zzc().zzq())));
                                                return Optional.empty();
                                            case 17:
                                                ((zzawh) obj).zzb.zzb(zzawm.zza(null));
                                                return Optional.empty();
                                            case 18:
                                                zzawh zzawhVar5 = (zzawh) obj;
                                                ByteBuffer byteBufferWrap = ByteBuffer.wrap(zzawhVar5.zzd.zzf((((((~1201162069L) & 403189074) | 1043752718) + ((1201162069 & 95979632) | 900760100)) - 1766798336) ^ (507611410 % 329370448)).zza());
                                                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                                                zzawhVar5.zzb.zzb(zzawm.zzc(Double.longBitsToDouble(byteBufferWrap.getLong())));
                                                return Optional.empty();
                                            case 19:
                                                zzawh zzawhVar6 = (zzawh) obj;
                                                zzawhVar6.zzb.zzb(zzawm.zzb(zzawhVar6.zzd.zze()));
                                                return Optional.empty();
                                            default:
                                                long j5 = ((((~346030096L) & 203234088) | 575197286) + ((346030096 & 2352425736L) | 2745332883L)) - 1505840317;
                                                long j6 = 1246101662 % 372004513;
                                                long j7 = ((((~1810821955L) & 1747262537) | 563863662) + ((1810821955 & 1295301633) | 94020008)) - 1690999106;
                                                long j8 = 1675644664 % 749217043;
                                                zzawh zzawhVar7 = (zzawh) obj;
                                                zzavv zzavvVar2 = zzawhVar7.zzd;
                                                long jZze = zzavvVar2.zze();
                                                if (jZze >= 0 && jZze <= (j5 ^ j6)) {
                                                    if (((j7 ^ j8) & jZze) != 0) {
                                                        return Optional.of(zzauw.zze);
                                                    }
                                                    zzawhVar7.zzb.zzb(zzawm.zzd(zzavvVar2.zzf(jZze)));
                                                    return Optional.empty();
                                                }
                                                return Optional.of(zzauw.zzz);
                                        }
                                    } catch (zzawc unused5) {
                                        zzauwVar = zzauw.zza;
                                    }
                                } catch (zzavu unused6) {
                                    zzauwVar = zzauw.zzz;
                                }
                            } catch (zzawj unused7) {
                                zzauwVar = zzauw.zzy;
                            }
                        } catch (zzawc e4) {
                            e = e4;
                            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
                        }
                    } catch (zzavt e5) {
                        e = e5;
                        throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
                    }
                } catch (zzawb unused8) {
                    zzauwVar = zzauw.zzx;
                }
            } catch (zzavs unused9) {
                zzauwVar = zzauw.zzD;
            }
        } catch (zzavt | zzavu unused10) {
            zzauwVar = zzauw.zzi;
        }
        return Optional.of(zzauwVar);
    }
}

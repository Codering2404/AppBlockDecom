package com.google.android.gms.internal.gtm;

import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zza' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxl {
    public static final zzxl zzA;
    public static final zzxl zzB;
    public static final zzxl zzC;
    public static final zzxl zzD;
    public static final zzxl zzE;
    public static final zzxl zzF;
    public static final zzxl zzG;
    public static final zzxl zzH;
    public static final zzxl zzI;
    public static final zzxl zzJ;
    public static final zzxl zzK;
    public static final zzxl zzL;
    public static final zzxl zzM;
    public static final zzxl zzN;
    public static final zzxl zzO;
    public static final zzxl zzP;
    public static final zzxl zzQ;
    public static final zzxl zzR;
    public static final zzxl zzS;
    public static final zzxl zzT;
    public static final zzxl zzU;
    public static final zzxl zzV;
    public static final zzxl zzW;
    public static final zzxl zzX;
    public static final zzxl zzY;
    private static final zzxl[] zzZ;
    public static final zzxl zza;
    private static final /* synthetic */ zzxl[] zzaa;
    public static final zzxl zzb;
    public static final zzxl zzc;
    public static final zzxl zzd;
    public static final zzxl zze;
    public static final zzxl zzf;
    public static final zzxl zzg;
    public static final zzxl zzh;
    public static final zzxl zzi;
    public static final zzxl zzj;
    public static final zzxl zzk;
    public static final zzxl zzl;
    public static final zzxl zzm;
    public static final zzxl zzn;
    public static final zzxl zzo;
    public static final zzxl zzp;
    public static final zzxl zzq;
    public static final zzxl zzr;
    public static final zzxl zzs;
    public static final zzxl zzt;
    public static final zzxl zzu;
    public static final zzxl zzv;
    public static final zzxl zzw;
    public static final zzxl zzx;
    public static final zzxl zzy;
    public static final zzxl zzz;
    private final zzyh zzab;
    private final int zzac;
    private final Class zzad;

    private zzxl(String str, int i3, int i4, int i5, zzyh zzyhVar) {
        this.zzac = i4;
        this.zzab = zzyhVar;
        int i6 = i5 - 1;
        if (i6 == 1 || i6 == 3) {
            this.zzad = zzyhVar.zza();
        } else {
            this.zzad = null;
        }
        if (i5 == 1) {
            zzyh zzyhVar2 = zzyh.zza;
            zzyhVar.ordinal();
        }
    }

    public static zzxl[] values() {
        return (zzxl[]) zzaa.clone();
    }

    public final int zza() {
        return this.zzac;
    }

    static {
        zzyh zzyhVar = zzyh.zze;
        zzxl zzxlVar = new zzxl("DOUBLE", 0, 0, 1, zzyhVar);
        zza = zzxlVar;
        zzyh zzyhVar2 = zzyh.zzd;
        zzxl zzxlVar2 = new zzxl("FLOAT", 1, 1, 1, zzyhVar2);
        zzb = zzxlVar2;
        zzyh zzyhVar3 = zzyh.zzc;
        zzxl zzxlVar3 = new zzxl("INT64", 2, 2, 1, zzyhVar3);
        zzc = zzxlVar3;
        zzxl zzxlVar4 = new zzxl("UINT64", 3, 3, 1, zzyhVar3);
        zzd = zzxlVar4;
        zzyh zzyhVar4 = zzyh.zzb;
        zzxl zzxlVar5 = new zzxl("INT32", 4, 4, 1, zzyhVar4);
        zze = zzxlVar5;
        zzxl zzxlVar6 = new zzxl("FIXED64", 5, 5, 1, zzyhVar3);
        zzf = zzxlVar6;
        zzxl zzxlVar7 = new zzxl("FIXED32", 6, 6, 1, zzyhVar4);
        zzg = zzxlVar7;
        zzyh zzyhVar5 = zzyh.zzf;
        zzxl zzxlVar8 = new zzxl("BOOL", 7, 7, 1, zzyhVar5);
        zzh = zzxlVar8;
        zzyh zzyhVar6 = zzyh.zzg;
        zzxl zzxlVar9 = new zzxl("STRING", 8, 8, 1, zzyhVar6);
        zzi = zzxlVar9;
        zzyh zzyhVar7 = zzyh.zzj;
        zzxl zzxlVar10 = new zzxl("MESSAGE", 9, 9, 1, zzyhVar7);
        zzj = zzxlVar10;
        zzyh zzyhVar8 = zzyh.zzh;
        zzxl zzxlVar11 = new zzxl("BYTES", 10, 10, 1, zzyhVar8);
        zzk = zzxlVar11;
        zzxl zzxlVar12 = new zzxl("UINT32", 11, 11, 1, zzyhVar4);
        zzl = zzxlVar12;
        zzyh zzyhVar9 = zzyh.zzi;
        zzxl zzxlVar13 = new zzxl("ENUM", 12, 12, 1, zzyhVar9);
        zzm = zzxlVar13;
        zzxl zzxlVar14 = new zzxl("SFIXED32", 13, 13, 1, zzyhVar4);
        zzn = zzxlVar14;
        zzxl zzxlVar15 = new zzxl("SFIXED64", 14, 14, 1, zzyhVar3);
        zzo = zzxlVar15;
        zzxl zzxlVar16 = new zzxl("SINT32", 15, 15, 1, zzyhVar4);
        zzp = zzxlVar16;
        zzxl zzxlVar17 = new zzxl("SINT64", 16, 16, 1, zzyhVar3);
        zzq = zzxlVar17;
        zzxl zzxlVar18 = new zzxl("GROUP", 17, 17, 1, zzyhVar7);
        zzr = zzxlVar18;
        zzxl zzxlVar19 = new zzxl("DOUBLE_LIST", 18, 18, 2, zzyhVar);
        zzs = zzxlVar19;
        zzxl zzxlVar20 = new zzxl("FLOAT_LIST", 19, 19, 2, zzyhVar2);
        zzt = zzxlVar20;
        zzxl zzxlVar21 = new zzxl("INT64_LIST", 20, 20, 2, zzyhVar3);
        zzu = zzxlVar21;
        zzxl zzxlVar22 = new zzxl("UINT64_LIST", 21, 21, 2, zzyhVar3);
        zzv = zzxlVar22;
        zzxl zzxlVar23 = new zzxl("INT32_LIST", 22, 22, 2, zzyhVar4);
        zzw = zzxlVar23;
        zzxl zzxlVar24 = new zzxl("FIXED64_LIST", 23, 23, 2, zzyhVar3);
        zzx = zzxlVar24;
        zzxl zzxlVar25 = new zzxl("FIXED32_LIST", 24, 24, 2, zzyhVar4);
        zzy = zzxlVar25;
        zzxl zzxlVar26 = new zzxl("BOOL_LIST", 25, 25, 2, zzyhVar5);
        zzz = zzxlVar26;
        zzxl zzxlVar27 = new zzxl("STRING_LIST", 26, 26, 2, zzyhVar6);
        zzA = zzxlVar27;
        zzxl zzxlVar28 = new zzxl("MESSAGE_LIST", 27, 27, 2, zzyhVar7);
        zzB = zzxlVar28;
        zzxl zzxlVar29 = new zzxl("BYTES_LIST", 28, 28, 2, zzyhVar8);
        zzC = zzxlVar29;
        zzxl zzxlVar30 = new zzxl("UINT32_LIST", 29, 29, 2, zzyhVar4);
        zzD = zzxlVar30;
        zzxl zzxlVar31 = new zzxl(cJfnYMIyomoWf.aCzKF, 30, 30, 2, zzyhVar9);
        zzE = zzxlVar31;
        zzxl zzxlVar32 = new zzxl("SFIXED32_LIST", 31, 31, 2, zzyhVar4);
        zzF = zzxlVar32;
        zzxl zzxlVar33 = new zzxl("SFIXED64_LIST", 32, 32, 2, zzyhVar3);
        zzG = zzxlVar33;
        zzxl zzxlVar34 = new zzxl("SINT32_LIST", 33, 33, 2, zzyhVar4);
        zzH = zzxlVar34;
        zzxl zzxlVar35 = new zzxl("SINT64_LIST", 34, 34, 2, zzyhVar3);
        zzI = zzxlVar35;
        zzxl zzxlVar36 = new zzxl("DOUBLE_LIST_PACKED", 35, 35, 3, zzyhVar);
        zzJ = zzxlVar36;
        zzxl zzxlVar37 = new zzxl("FLOAT_LIST_PACKED", 36, 36, 3, zzyhVar2);
        zzK = zzxlVar37;
        zzxl zzxlVar38 = new zzxl("INT64_LIST_PACKED", 37, 37, 3, zzyhVar3);
        zzL = zzxlVar38;
        zzxl zzxlVar39 = new zzxl("UINT64_LIST_PACKED", 38, 38, 3, zzyhVar3);
        zzM = zzxlVar39;
        zzxl zzxlVar40 = new zzxl("INT32_LIST_PACKED", 39, 39, 3, zzyhVar4);
        zzN = zzxlVar40;
        zzxl zzxlVar41 = new zzxl("FIXED64_LIST_PACKED", 40, 40, 3, zzyhVar3);
        zzO = zzxlVar41;
        zzxl zzxlVar42 = new zzxl("FIXED32_LIST_PACKED", 41, 41, 3, zzyhVar4);
        zzP = zzxlVar42;
        zzxl zzxlVar43 = new zzxl("BOOL_LIST_PACKED", 42, 42, 3, zzyhVar5);
        zzQ = zzxlVar43;
        zzxl zzxlVar44 = new zzxl("UINT32_LIST_PACKED", 43, 43, 3, zzyhVar4);
        zzR = zzxlVar44;
        zzxl zzxlVar45 = new zzxl("ENUM_LIST_PACKED", 44, 44, 3, zzyhVar9);
        zzS = zzxlVar45;
        zzxl zzxlVar46 = new zzxl("SFIXED32_LIST_PACKED", 45, 45, 3, zzyhVar4);
        zzT = zzxlVar46;
        zzxl zzxlVar47 = new zzxl("SFIXED64_LIST_PACKED", 46, 46, 3, zzyhVar3);
        zzU = zzxlVar47;
        zzxl zzxlVar48 = new zzxl(HcgZcEUYo.cLIAtTfcUxsfP, 47, 47, 3, zzyhVar4);
        zzV = zzxlVar48;
        zzxl zzxlVar49 = new zzxl("SINT64_LIST_PACKED", 48, 48, 3, zzyhVar3);
        zzW = zzxlVar49;
        zzxl zzxlVar50 = new zzxl("GROUP_LIST", 49, 49, 2, zzyhVar7);
        zzX = zzxlVar50;
        zzxl zzxlVar51 = new zzxl("MAP", 50, 50, 4, zzyh.zza);
        zzY = zzxlVar51;
        zzaa = new zzxl[]{zzxlVar, zzxlVar2, zzxlVar3, zzxlVar4, zzxlVar5, zzxlVar6, zzxlVar7, zzxlVar8, zzxlVar9, zzxlVar10, zzxlVar11, zzxlVar12, zzxlVar13, zzxlVar14, zzxlVar15, zzxlVar16, zzxlVar17, zzxlVar18, zzxlVar19, zzxlVar20, zzxlVar21, zzxlVar22, zzxlVar23, zzxlVar24, zzxlVar25, zzxlVar26, zzxlVar27, zzxlVar28, zzxlVar29, zzxlVar30, zzxlVar31, zzxlVar32, zzxlVar33, zzxlVar34, zzxlVar35, zzxlVar36, zzxlVar37, zzxlVar38, zzxlVar39, zzxlVar40, zzxlVar41, zzxlVar42, zzxlVar43, zzxlVar44, zzxlVar45, zzxlVar46, zzxlVar47, zzxlVar48, zzxlVar49, zzxlVar50, zzxlVar51};
        zzxl[] zzxlVarArrValues = values();
        zzZ = new zzxl[zzxlVarArrValues.length];
        for (zzxl zzxlVar52 : zzxlVarArrValues) {
            zzZ[zzxlVar52.zzac] = zzxlVar52;
        }
    }
}

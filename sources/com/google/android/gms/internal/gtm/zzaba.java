package com.google.android.gms.internal.gtm;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
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
public final class zzaba {
    public static final zzaba zza;
    public static final zzaba zzb;
    public static final zzaba zzc;
    public static final zzaba zzd;
    public static final zzaba zze;
    public static final zzaba zzf;
    public static final zzaba zzg;
    public static final zzaba zzh;
    public static final zzaba zzi;
    public static final zzaba zzj;
    public static final zzaba zzk;
    public static final zzaba zzl;
    public static final zzaba zzm;
    public static final zzaba zzn;
    public static final zzaba zzo;
    public static final zzaba zzp;
    public static final zzaba zzq;
    public static final zzaba zzr;
    private static final /* synthetic */ zzaba[] zzs;
    private final zzabb zzt;

    static {
        zzaba zzabaVar = new zzaba("DOUBLE", 0, zzabb.DOUBLE, 1);
        zza = zzabaVar;
        zzaba zzabaVar2 = new zzaba("FLOAT", 1, zzabb.FLOAT, 5);
        zzb = zzabaVar2;
        zzabb zzabbVar = zzabb.LONG;
        zzaba zzabaVar3 = new zzaba("INT64", 2, zzabbVar, 0);
        zzc = zzabaVar3;
        zzaba zzabaVar4 = new zzaba("UINT64", 3, zzabbVar, 0);
        zzd = zzabaVar4;
        zzabb zzabbVar2 = zzabb.INT;
        zzaba zzabaVar5 = new zzaba("INT32", 4, zzabbVar2, 0);
        zze = zzabaVar5;
        zzaba zzabaVar6 = new zzaba("FIXED64", 5, zzabbVar, 1);
        zzf = zzabaVar6;
        zzaba zzabaVar7 = new zzaba("FIXED32", 6, zzabbVar2, 5);
        zzg = zzabaVar7;
        zzaba zzabaVar8 = new zzaba("BOOL", 7, zzabb.BOOLEAN, 0);
        zzh = zzabaVar8;
        zzaba zzabaVar9 = new zzaba("STRING", 8, zzabb.STRING, 2);
        zzi = zzabaVar9;
        zzabb zzabbVar3 = zzabb.MESSAGE;
        zzaba zzabaVar10 = new zzaba("GROUP", 9, zzabbVar3, 3);
        zzj = zzabaVar10;
        zzaba zzabaVar11 = new zzaba("MESSAGE", 10, zzabbVar3, 2);
        zzk = zzabaVar11;
        zzaba zzabaVar12 = new zzaba("BYTES", 11, zzabb.BYTE_STRING, 2);
        zzl = zzabaVar12;
        zzaba zzabaVar13 = new zzaba("UINT32", 12, zzabbVar2, 0);
        zzm = zzabaVar13;
        zzaba zzabaVar14 = new zzaba("ENUM", 13, zzabb.ENUM, 0);
        zzn = zzabaVar14;
        zzaba zzabaVar15 = new zzaba("SFIXED32", 14, zzabbVar2, 5);
        zzo = zzabaVar15;
        zzaba zzabaVar16 = new zzaba("SFIXED64", 15, zzabbVar, 1);
        zzp = zzabaVar16;
        zzaba zzabaVar17 = new zzaba("SINT32", 16, zzabbVar2, 0);
        zzq = zzabaVar17;
        zzaba zzabaVar18 = new zzaba("SINT64", 17, zzabbVar, 0);
        zzr = zzabaVar18;
        zzs = new zzaba[]{zzabaVar, zzabaVar2, zzabaVar3, zzabaVar4, zzabaVar5, zzabaVar6, zzabaVar7, zzabaVar8, zzabaVar9, zzabaVar10, zzabaVar11, zzabaVar12, zzabaVar13, zzabaVar14, zzabaVar15, zzabaVar16, zzabaVar17, zzabaVar18};
    }

    private zzaba(String str, int i3, zzabb zzabbVar, int i4) {
        this.zzt = zzabbVar;
    }

    public static zzaba[] values() {
        return (zzaba[]) zzs.clone();
    }

    public final zzabb zza() {
        return this.zzt;
    }
}

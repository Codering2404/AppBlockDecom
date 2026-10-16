package com.google.android.gms.internal.gtm;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
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
public final class zzyh {
    public static final zzyh zza;
    public static final zzyh zzb;
    public static final zzyh zzc;
    public static final zzyh zzd;
    public static final zzyh zze;
    public static final zzyh zzf;
    public static final zzyh zzg;
    public static final zzyh zzh;
    public static final zzyh zzi;
    public static final zzyh zzj;
    private static final /* synthetic */ zzyh[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzyh zzyhVar = new zzyh("VOID", 0, Void.class, Void.class, null);
        zza = zzyhVar;
        Class cls = Integer.TYPE;
        zzyh zzyhVar2 = new zzyh("INT", 1, cls, Integer.class, 0);
        zzb = zzyhVar2;
        zzyh zzyhVar3 = new zzyh("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzyhVar3;
        zzyh zzyhVar4 = new zzyh("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzyhVar4;
        zzyh zzyhVar5 = new zzyh("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzyhVar5;
        zzyh zzyhVar6 = new zzyh("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzyhVar6;
        zzyh zzyhVar7 = new zzyh("STRING", 6, String.class, String.class, "");
        zzg = zzyhVar7;
        zzyh zzyhVar8 = new zzyh("BYTE_STRING", 7, zzud.class, zzud.class, zzud.zzb);
        zzh = zzyhVar8;
        zzyh zzyhVar9 = new zzyh("ENUM", 8, cls, Integer.class, null);
        zzi = zzyhVar9;
        zzyh zzyhVar10 = new zzyh("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzyhVar10;
        zzk = new zzyh[]{zzyhVar, zzyhVar2, zzyhVar3, zzyhVar4, zzyhVar5, zzyhVar6, zzyhVar7, zzyhVar8, zzyhVar9, zzyhVar10};
    }

    private zzyh(String str, int i3, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzyh[] values() {
        return (zzyh[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}

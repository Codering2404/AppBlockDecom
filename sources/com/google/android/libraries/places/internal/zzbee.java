package com.google.android.libraries.places.internal;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbee {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzbee f76094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzbee f76095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbee f76096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzbee f76097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzbee f76098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzbee f76099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzbee f76100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzbee f76101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzbee f76102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final zzbee f76103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ zzbee[] f76104m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f76105a;

    static {
        zzbee zzbeeVar = new zzbee("VOID", 0, Void.class, Void.class, null);
        f76094b = zzbeeVar;
        Class cls = Integer.TYPE;
        zzbee zzbeeVar2 = new zzbee("INT", 1, cls, Integer.class, 0);
        f76095c = zzbeeVar2;
        zzbee zzbeeVar3 = new zzbee("LONG", 2, Long.TYPE, Long.class, 0L);
        f76096d = zzbeeVar3;
        zzbee zzbeeVar4 = new zzbee("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f76097f = zzbeeVar4;
        zzbee zzbeeVar5 = new zzbee("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f76098g = zzbeeVar5;
        zzbee zzbeeVar6 = new zzbee("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f76099h = zzbeeVar6;
        zzbee zzbeeVar7 = new zzbee("STRING", 6, String.class, String.class, "");
        f76100i = zzbeeVar7;
        zzbee zzbeeVar8 = new zzbee("BYTE_STRING", 7, zzbcl.class, zzbcl.class, zzbcl.f75997b);
        f76101j = zzbeeVar8;
        zzbee zzbeeVar9 = new zzbee("ENUM", 8, cls, Integer.class, null);
        f76102k = zzbeeVar9;
        zzbee zzbeeVar10 = new zzbee("MESSAGE", 9, Object.class, Object.class, null);
        f76103l = zzbeeVar10;
        f76104m = new zzbee[]{zzbeeVar, zzbeeVar2, zzbeeVar3, zzbeeVar4, zzbeeVar5, zzbeeVar6, zzbeeVar7, zzbeeVar8, zzbeeVar9, zzbeeVar10};
    }

    private zzbee(String str, int i3, Class cls, Class cls2, Object obj) {
        this.f76105a = cls2;
    }

    public static zzbee[] values() {
        return (zzbee[]) f76104m.clone();
    }

    public final Class a() {
        return this.f76105a;
    }
}

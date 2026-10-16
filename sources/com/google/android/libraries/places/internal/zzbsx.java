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
public final class zzbsx {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzbsx f76802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbsx f76803d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzbsx f76804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzbsx f76805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzbsx f76806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzbsx f76807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzbsx f76808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzbsx f76809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final zzbsx f76810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final zzbsx f76811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final zzbsx f76812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final zzbsx f76813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final zzbsx f76814p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final zzbsx f76815q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final zzbsx[] f76816r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final /* synthetic */ zzbsx[] f76817s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f76818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbnp f76819b;

    private zzbsx(String str, int i3, int i4, zzbnp zzbnpVar) {
        this.f76818a = i4;
        String strConcat = "HTTP/2 error code: ".concat(String.valueOf(name()));
        if (zzbnpVar.h() != null) {
            String strH = zzbnpVar.h();
            StringBuilder sb = new StringBuilder(strConcat.length() + 2 + String.valueOf(strH).length() + 1);
            sb.append(strConcat);
            sb.append(" (");
            sb.append(strH);
            sb.append(")");
            strConcat = sb.toString();
        }
        this.f76819b = zzbnpVar.e(strConcat);
    }

    public static zzbnp a(long j3) {
        zzbsx[] zzbsxVarArr = f76816r;
        zzbsx zzbsxVar = null;
        if (j3 < zzbsxVarArr.length && j3 >= 0) {
            zzbsxVar = zzbsxVarArr[(int) j3];
        }
        if (zzbsxVar != null) {
            return zzbsxVar.f76819b;
        }
        zzbnp zzbnpVarA = zzbnp.a(f76804f.f76819b.g().zza());
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 32);
        sb.append("Unrecognized HTTP/2 error code: ");
        sb.append(j3);
        return zzbnpVarA.e(sb.toString());
    }

    public static zzbsx[] values() {
        return (zzbsx[]) f76817s.clone();
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        */
    static {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbsx.<clinit>():void");
    }
}

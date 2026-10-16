package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 org.checkerframework.checker.formatter.qual.ConversionCategory, still in use, count: 1, list:
  (r0v0 org.checkerframework.checker.formatter.qual.ConversionCategory) from 0x009f: FILLED_NEW_ARRAY 
  (r0v0 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r5v0 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r9v1 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r10v2 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r11v3 org.checkerframework.checker.formatter.qual.ConversionCategory)
 A[WRAPPED] (LINE:160) elemType: org.checkerframework.checker.formatter.qual.ConversionCategory
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ConversionCategory {
    GENERAL("bBhHsS", null),
    CHAR("cC", Character.class, Byte.class, Short.class, Integer.class),
    INT("doxX", Byte.class, Short.class, Integer.class, Long.class, BigInteger.class),
    FLOAT("eEfgGaA", Float.class, Double.class, BigDecimal.class),
    TIME("tT", Long.class, Calendar.class, Date.class),
    CHAR_AND_INT(null, Byte.class, Short.class, Integer.class),
    INT_AND_TIME(null, Long.class),
    NULL(null, new Class[0]),
    UNUSED(null, null);


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ConversionCategory[] f145265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ConversionCategory[] f145266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ConversionCategory[] f145267o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class[] f145269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f145270b;

    static {
        ConversionCategory conversionCategory = CHAR;
        ConversionCategory conversionCategory2 = INT;
        ConversionCategory conversionCategory3 = FLOAT;
        ConversionCategory conversionCategory4 = TIME;
        ConversionCategory conversionCategory5 = CHAR_AND_INT;
        ConversionCategory conversionCategory6 = INT_AND_TIME;
        ConversionCategory conversionCategory7 = NULL;
        f145265m = new ConversionCategory[]{conversionCategory, conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4};
        f145266n = new ConversionCategory[]{conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5, conversionCategory6, conversionCategory7};
        f145267o = new ConversionCategory[]{conversionCategory7, conversionCategory5, conversionCategory6, conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4};
    }

    private ConversionCategory(String str, Class... clsArr) {
        this.f145270b = str;
        if (clsArr == null) {
            this.f145269a = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class cls : clsArr) {
            arrayList.add(cls);
            Class clsB = b(cls);
            if (clsB != null) {
                arrayList.add(clsB);
            }
        }
        this.f145269a = (Class[]) arrayList.toArray(new Class[0]);
    }

    private static Class b(Class cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return null;
    }

    public static ConversionCategory valueOf(String str) {
        return (ConversionCategory) Enum.valueOf(ConversionCategory.class, str);
    }

    public static ConversionCategory[] values() {
        return (ConversionCategory[]) f145268p.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" conversion category");
        Class[] clsArr = this.f145269a;
        if (clsArr == null || clsArr.length == 0) {
            return sb.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "(one of: ", ")");
        for (Class cls : this.f145269a) {
            stringJoiner.add(cls.getSimpleName());
        }
        sb.append(" ");
        sb.append(stringJoiner);
        return sb.toString();
    }
}

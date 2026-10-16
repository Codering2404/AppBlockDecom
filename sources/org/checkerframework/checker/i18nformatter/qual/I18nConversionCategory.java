package org.checkerframework.checker.i18nformatter.qual;

import java.util.Date;
import java.util.StringJoiner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum I18nConversionCategory {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final I18nConversionCategory[] f145275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final I18nConversionCategory[] f145276i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class[] f145278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f145279b;

    static {
        I18nConversionCategory i18nConversionCategory = DATE;
        I18nConversionCategory i18nConversionCategory2 = NUMBER;
        f145275h = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
        f145276i = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
    }

    I18nConversionCategory(Class[] clsArr, String[] strArr) {
        this.f145278a = clsArr;
        this.f145279b = strArr;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.f145278a == null) {
            sb.append(" conversion category (all types)");
        } else {
            StringJoiner stringJoiner = new StringJoiner(", ", " conversion category (one of: ", ")");
            for (Class cls : this.f145278a) {
                stringJoiner.add(cls.getCanonicalName());
            }
            sb.append(stringJoiner);
        }
        return sb.toString();
    }
}

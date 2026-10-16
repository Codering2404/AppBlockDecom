package org.threeten.bp.format;

import org.threeten.bp.DateTimeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f146439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146440b;

    public DateTimeParseException(String str, CharSequence charSequence, int i3) {
        super(str);
        this.f146439a = charSequence.toString();
        this.f146440b = i3;
    }

    public int a() {
        return this.f146440b;
    }

    public DateTimeParseException(String str, CharSequence charSequence, int i3, Throwable th) {
        super(str, th);
        this.f146439a = charSequence.toString();
        this.f146440b = i3;
    }
}

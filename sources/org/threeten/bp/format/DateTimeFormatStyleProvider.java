package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.chrono.Chronology;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class DateTimeFormatStyleProvider {
    DateTimeFormatStyleProvider() {
    }

    static DateTimeFormatStyleProvider b() {
        return new SimpleDateTimeFormatStyleProvider();
    }

    public abstract DateTimeFormatter a(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale);
}

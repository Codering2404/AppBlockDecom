package org.threeten.bp.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.chrono.Chronology;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class SimpleDateTimeFormatStyleProvider extends DateTimeFormatStyleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap f146472a = new ConcurrentHashMap(16, 0.75f, 2);

    SimpleDateTimeFormatStyleProvider() {
    }

    private int c(FormatStyle formatStyle) {
        return formatStyle.ordinal();
    }

    @Override // org.threeten.bp.format.DateTimeFormatStyleProvider
    public DateTimeFormatter a(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Date and Time style must not both be null");
        }
        String str = chronology.getId() + '|' + locale.toString() + '|' + formatStyle + formatStyle2;
        ConcurrentMap concurrentMap = f146472a;
        Object obj = concurrentMap.get(str);
        if (obj != null) {
            if (obj.equals("")) {
                throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
            }
            return (DateTimeFormatter) obj;
        }
        DateFormat dateTimeInstance = formatStyle != null ? formatStyle2 != null ? DateFormat.getDateTimeInstance(c(formatStyle), c(formatStyle2), locale) : DateFormat.getDateInstance(c(formatStyle), locale) : DateFormat.getTimeInstance(c(formatStyle2), locale);
        if (!(dateTimeInstance instanceof SimpleDateFormat)) {
            concurrentMap.putIfAbsent(str, "");
            throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
        }
        DateTimeFormatter dateTimeFormatterF = new DateTimeFormatterBuilder().k(((SimpleDateFormat) dateTimeInstance).toPattern()).F(locale);
        concurrentMap.putIfAbsent(str, dateTimeFormatterF);
        return dateTimeFormatterF;
    }
}

package org.threeten.bp.format;

import androidx.compose.animation.core.h;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DateTimeTextProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference f146449a = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ProviderSingleton {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final DateTimeTextProvider f146450a = a();

        static DateTimeTextProvider a() {
            h.a(DateTimeTextProvider.f146449a, null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) DateTimeTextProvider.f146449a.get();
        }
    }

    static DateTimeTextProvider b() {
        return ProviderSingleton.f146450a;
    }

    public abstract String c(TemporalField temporalField, long j3, TextStyle textStyle, Locale locale);

    public abstract Iterator d(TemporalField temporalField, TextStyle textStyle, Locale locale);
}

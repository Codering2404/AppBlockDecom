package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CacheBuilderSpec {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Splitter f83467o = Splitter.f(',').n();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Splitter f83468p = Splitter.f('=').n();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ImmutableMap f83469q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Integer f83470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Long f83471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Long f83472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Integer f83473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    LocalCache.Strength f83474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    LocalCache.Strength f83475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Boolean f83476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f83477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    TimeUnit f83478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f83479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TimeUnit f83480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f83481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    TimeUnit f83482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f83483n;

    /* JADX INFO: renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f83484a;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            f83484a = iArr;
            try {
                iArr[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f83484a[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class DurationParser implements ValueParser {
        DurationParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class IntegerParser implements ValueParser {
        IntegerParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class KeyStrengthParser implements ValueParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocalCache.Strength f83485a;

        public KeyStrengthParser(LocalCache.Strength strength) {
            this.f83485a = strength;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class LongParser implements ValueParser {
        LongParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ValueParser {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ValueStrengthParser implements ValueParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocalCache.Strength f83486a;

        public ValueStrengthParser(LocalCache.Strength strength) {
            this.f83486a = strength;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }
    }

    static {
        ImmutableMap.Builder builderG = ImmutableMap.a().g("initialCapacity", new InitialCapacityParser()).g("maximumSize", new MaximumSizeParser()).g("maximumWeight", new MaximumWeightParser()).g("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        f83469q = builderG.g("weakKeys", new KeyStrengthParser(strength)).g("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).g("weakValues", new ValueStrengthParser(strength)).g("recordStats", new RecordStatsParser()).g("expireAfterAccess", new AccessDurationParser()).g("expireAfterWrite", new WriteDurationParser()).g("refreshAfterWrite", new RefreshDurationParser()).g("refreshInterval", new RefreshDurationParser()).d();
    }

    private static Long a(long j3, TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j3));
    }

    public String b() {
        return this.f83483n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return Objects.a(this.f83470a, cacheBuilderSpec.f83470a) && Objects.a(this.f83471b, cacheBuilderSpec.f83471b) && Objects.a(this.f83472c, cacheBuilderSpec.f83472c) && Objects.a(this.f83473d, cacheBuilderSpec.f83473d) && Objects.a(this.f83474e, cacheBuilderSpec.f83474e) && Objects.a(this.f83475f, cacheBuilderSpec.f83475f) && Objects.a(this.f83476g, cacheBuilderSpec.f83476g) && Objects.a(a(this.f83477h, this.f83478i), a(cacheBuilderSpec.f83477h, cacheBuilderSpec.f83478i)) && Objects.a(a(this.f83479j, this.f83480k), a(cacheBuilderSpec.f83479j, cacheBuilderSpec.f83480k)) && Objects.a(a(this.f83481l, this.f83482m), a(cacheBuilderSpec.f83481l, cacheBuilderSpec.f83482m));
    }

    public int hashCode() {
        return Objects.b(this.f83470a, this.f83471b, this.f83472c, this.f83473d, this.f83474e, this.f83475f, this.f83476g, a(this.f83477h, this.f83478i), a(this.f83479j, this.f83480k), a(this.f83481l, this.f83482m));
    }

    public String toString() {
        return MoreObjects.c(this).k(b()).toString();
    }
}

package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.R;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Limit {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Limit[] $VALUES;
    public static final Limit ADD_NEW_APPS;
    public static final Companion Companion;
    public static final Limit STATISTICS_LIMIT;
    private static final Lazy<Map<Integer, Limit>> valuesById$delegate;
    private final int errorDescriptionResId;
    private final int id;
    private final int titleResId;
    private final int value;
    public static final Limit PROFILE_LIMIT = new Limit("PROFILE_LIMIT", 0, 0, 3, 0, R.string.lu, 4, null);
    public static final Limit APP_LIMIT = new Limit("APP_LIMIT", 1, 1, 5, R.string.G1, R.string.Sb);
    public static final Limit WEBSITE_LIMIT = new Limit("WEBSITE_LIMIT", 2, 2, 5, R.string.hG, R.string.gc);
    public static final Limit APP_WEB_LIMIT_QUICK_BLOCK = new Limit("APP_WEB_LIMIT_QUICK_BLOCK", 3, 3, 3, 0, R.string.mr, 4, null);
    public static final Limit TIMES_LIMIT = new Limit("TIMES_LIMIT", 4, 4, 2, R.string.tD, R.string.dc);
    public static final Limit NOTIFICATION_LIMIT = new Limit("NOTIFICATION_LIMIT", 5, 5, 15, 0, 0, 12, null);
    public static final Limit USAGE_LIMIT = new Limit("USAGE_LIMIT", 6, 6, 30, R.string.JF, R.string.fc);
    public static final Limit LAUNCH_COUNT = new Limit("LAUNCH_COUNT", 7, 7, 15, R.string.Bi, R.string.Vb);
    public static final Limit LOCK_TIME_LIMIT = new Limit("LOCK_TIME_LIMIT", 8, 8, 4, 0, R.string.Wb, 4, null);
    public static final Limit STRICT_MODE_LIMIT = new Limit("STRICT_MODE_LIMIT", 9, 9, 24, 0, 0, 12, null);
    public static final Limit ALLOWLIST = new Limit("ALLOWLIST", 12, 12, 0, R.string.A0, 0, 8, null);
    public static final Limit BLOCK_UNSUPPORTED_BROWSERS = new Limit("BLOCK_UNSUPPORTED_BROWSERS", 13, 13, 0, R.string.U3, 0, 8, null);
    public static final Limit ADULT_CONTENT_BLOCKING = new Limit("ADULT_CONTENT_BLOCKING", 14, 14, 0, R.string.W, 0, 8, null);
    public static final Limit IN_APP_PURCHASES_BLOCKING = new Limit("IN_APP_PURCHASES_BLOCKING", 15, 18, 0, R.string.Rq, 0, 8, null);
    public static final Limit DUPLICATE_SCHEDULES = new Limit("DUPLICATE_SCHEDULES", 16, 15, 0, R.string.Fc, 0, 8, null);
    public static final Limit TIME_SCHEDULE_DAY_LIMIT = new Limit("TIME_SCHEDULE_DAY_LIMIT", 17, 16, Api.BaseClientBuilder.API_PRIORITY_OTHER, R.string.tk, 0, 8, null);
    public static final Limit SUB_APPS_LIMIT = new Limit("SUB_APPS_LIMIT", 18, 17, 0, R.string.aC, 0, 8, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b() {
            return (Map) Limit.valuesById$delegate.getValue();
        }

        public final Limit a(int i3) {
            return (Limit) b().get(Integer.valueOf(i3));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f96989a;

        static {
            int[] iArr = new int[Limit.values().length];
            try {
                iArr[Limit.PROFILE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Limit.APP_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Limit.WEBSITE_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Limit.TIME_SCHEDULE_DAY_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Limit.USAGE_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Limit.LAUNCH_COUNT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Limit.LOCK_TIME_LIMIT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Limit.STRICT_MODE_LIMIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Limit.ADD_NEW_APPS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Limit.ALLOWLIST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Limit.BLOCK_UNSUPPORTED_BROWSERS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Limit.ADULT_CONTENT_BLOCKING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[Limit.IN_APP_PURCHASES_BLOCKING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[Limit.SUB_APPS_LIMIT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            f96989a = iArr;
        }
    }

    private static final /* synthetic */ Limit[] $values() {
        return new Limit[]{PROFILE_LIMIT, APP_LIMIT, WEBSITE_LIMIT, APP_WEB_LIMIT_QUICK_BLOCK, TIMES_LIMIT, NOTIFICATION_LIMIT, USAGE_LIMIT, LAUNCH_COUNT, LOCK_TIME_LIMIT, STRICT_MODE_LIMIT, STATISTICS_LIMIT, ADD_NEW_APPS, ALLOWLIST, BLOCK_UNSUPPORTED_BROWSERS, ADULT_CONTENT_BLOCKING, IN_APP_PURCHASES_BLOCKING, DUPLICATE_SCHEDULES, TIME_SCHEDULE_DAY_LIMIT, SUB_APPS_LIMIT};
    }

    static {
        int i3 = 0;
        STATISTICS_LIMIT = new Limit("STATISTICS_LIMIT", 10, 10, 3, i3, 0, 12, null);
        ADD_NEW_APPS = new Limit("ADD_NEW_APPS", 11, 11, i3, R.string.Q, 0, 8, null);
        Limit[] limitArr$values = $values();
        $VALUES = limitArr$values;
        $ENTRIES = EnumEntriesKt.a(limitArr$values);
        Companion = new Companion(null);
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Limit.valuesById_delegate$lambda$0();
            }
        });
    }

    private Limit(String str, int i3, int i4, int i5, int i6, int i7) {
        this.id = i4;
        this.value = i5;
        this.titleResId = i6;
        this.errorDescriptionResId = i7;
    }

    @JvmStatic
    public static final Limit getById(int i3) {
        return Companion.a(i3);
    }

    public static EnumEntries<Limit> getEntries() {
        return $ENTRIES;
    }

    public static Limit valueOf(String str) {
        return (Limit) Enum.valueOf(Limit.class, str);
    }

    public static Limit[] values() {
        return (Limit[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        EnumEntries<Limit> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (Limit limit : entries) {
            linkedHashMap.put(Integer.valueOf(limit.id), limit);
        }
        return linkedHashMap;
    }

    public final int getErrorDescriptionResId() {
        return this.errorDescriptionResId;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLimitValue() {
        int i3 = WhenMappings.f96989a[ordinal()];
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2 || i3 == 3) {
            return 5;
        }
        return i3 != 4 ? this.value : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final String getReadableLimit(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (WhenMappings.f96989a[ordinal()]) {
            case 5:
                return context.getString(R.string.yk, Integer.valueOf(getLimitValue()));
            case 6:
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format(Locale.getDefault(), "%d×", Arrays.copyOf(new Object[]{Integer.valueOf(getLimitValue())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            case 7:
            case 8:
                return context.getString(R.string.wk, Integer.valueOf(getLimitValue()));
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return null;
            default:
                return String.valueOf(getLimitValue());
        }
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    /* synthetic */ Limit(String str, int i3, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i8 & 1) != 0 ? -1 : i4, (i8 & 2) != 0 ? -1 : i5, (i8 & 4) != 0 ? -1 : i6, (i8 & 8) != 0 ? -1 : i7);
    }
}

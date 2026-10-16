package cz.mobilesoft.coreblock.scene.insights.usecase;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.text.format.DateFormat;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.UseCase;
import cz.mobilesoft.coreblock.util.helperextension.CalendarExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class CreateIntervalsUseCase extends UseCase<Param, List<? extends InsightsViewState.InsightsInterval>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f103666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f103667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Calendar f103668c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Param implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InsightsViewState.InsightsPeriodType f103669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InsightsViewModel.InsightTypeConfig f103670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f103671c;

        public Param(InsightsViewState.InsightsPeriodType insightsPeriodType, InsightsViewModel.InsightTypeConfig intervalConfig, long j3) {
            Intrinsics.checkNotNullParameter(insightsPeriodType, "insightsPeriodType");
            Intrinsics.checkNotNullParameter(intervalConfig, "intervalConfig");
            this.f103669a = insightsPeriodType;
            this.f103670b = intervalConfig;
            this.f103671c = j3;
        }

        public final InsightsViewState.InsightsPeriodType a() {
            return this.f103669a;
        }

        public final InsightsViewModel.InsightTypeConfig b() {
            return this.f103670b;
        }

        public final long c() {
            return this.f103671c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Param)) {
                return false;
            }
            Param param = (Param) obj;
            return this.f103669a == param.f103669a && Intrinsics.areEqual(this.f103670b, param.f103670b) && this.f103671c == param.f103671c;
        }

        public int hashCode() {
            return (((this.f103669a.hashCode() * 31) + this.f103670b.hashCode()) * 31) + Long.hashCode(this.f103671c);
        }

        public String toString() {
            return "Param(insightsPeriodType=" + this.f103669a + ", intervalConfig=" + this.f103670b + ", initialTimestamp=" + this.f103671c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f103672a;

        static {
            int[] iArr = new int[InsightsViewState.InsightsPeriodType.values().length];
            try {
                iArr[InsightsViewState.InsightsPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f103672a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreateIntervalsUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f103666a = context;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f103667b = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.usecase.CreateIntervalsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        this.f103668c = Calendar.getInstance();
    }

    private final List d(final InsightsViewModel.InsightTypeConfig insightTypeConfig) {
        ArrayList arrayList = new ArrayList();
        int iC = insightTypeConfig.c();
        for (final int i3 = 0; i3 < iC; i3++) {
            arrayList.add(f(insightTypeConfig.a(), 6, i3, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.usecase.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateIntervalsUseCase.e(i3, insightTypeConfig, this, ((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(int i3, InsightsViewModel.InsightTypeConfig insightTypeConfig, CreateIntervalsUseCase createIntervalsUseCase, long j3, long j4) {
        if (i3 != insightTypeConfig.c() - 1) {
            return i3 == insightTypeConfig.c() + (-2) ? createIntervalsUseCase.j(j3) : createIntervalsUseCase.j(j3);
        }
        String string = createIntervalsUseCase.f103666a.getString(R.string.SD);
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final InsightsViewState.InsightsInterval f(long j3, int i3, int i4, Function2 function2) {
        this.f103668c.setTimeInMillis(j3);
        this.f103668c.add(i3, i4);
        long timeInMillis = this.f103668c.getTimeInMillis();
        this.f103668c.add(i3, 1);
        long timeInMillis2 = this.f103668c.getTimeInMillis();
        return new InsightsViewState.InsightsInterval(timeInMillis, timeInMillis2, (String) function2.invoke(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis2)));
    }

    private final List g(InsightsViewModel.InsightTypeConfig insightTypeConfig, long j3) {
        ArrayList arrayList;
        Object obj;
        ArrayList arrayList2;
        Object obj2 = null;
        boolean zBooleanValue = BuildConfig.f95357b.booleanValue() ? ((Boolean) BuildersKt__BuildersKt.b(null, new CreateIntervalsUseCase$createTrendIntervals$devShowAllTrendIntervals$1(this, null), 1, null)).booleanValue() : false;
        ArrayList arrayList3 = new ArrayList();
        this.f103668c.setTimeInMillis(insightTypeConfig.a());
        String str = new SimpleDateFormat("MMMM", Locale.getDefault()).format(this.f103668c.getTime());
        int i3 = this.f103668c.get(1);
        long days = TimeUnit.MILLISECONDS.toDays(j3 - insightTypeConfig.a());
        for (InsightsViewState.TrendInterval trendInterval : InsightsViewState.TrendInterval.getEntries()) {
            if (trendInterval.getDays() == null || days > trendInterval.getDays().intValue() || zBooleanValue) {
                this.f103668c.setTimeInMillis(j3);
                Calendar calendar = this.f103668c;
                Intrinsics.checkNotNullExpressionValue(calendar, "calendar");
                CalendarExtKt.a(calendar);
                long timeInMillis = this.f103668c.getTimeInMillis();
                if (trendInterval.getDays() != null) {
                    this.f103668c.add(6, -trendInterval.getDays().intValue());
                    arrayList = arrayList3;
                } else {
                    arrayList = arrayList3;
                    this.f103668c.setTimeInMillis(insightTypeConfig.a());
                    Calendar calendar2 = this.f103668c;
                    Intrinsics.checkNotNullExpressionValue(calendar2, "calendar");
                    CalendarExtKt.a(calendar2);
                    this.f103668c.add(6, 1);
                }
                long timeInMillis2 = this.f103668c.getTimeInMillis();
                String title = trendInterval.getTitle();
                if (title == null) {
                    Context context = this.f103666a;
                    int i4 = R.string.yh;
                    Intrinsics.checkNotNull(str);
                    obj = null;
                    title = context.getString(i4, StringHelperExtKt.q(str, String.valueOf(i3), null, 2, null));
                    Intrinsics.checkNotNullExpressionValue(title, "getString(...)");
                } else {
                    obj = null;
                }
                arrayList2 = arrayList;
                arrayList2.add(new InsightsViewState.InsightsInterval(timeInMillis2, timeInMillis, title));
            } else {
                obj = obj2;
                arrayList2 = arrayList3;
            }
            arrayList3 = arrayList2;
            obj2 = obj;
        }
        return arrayList3;
    }

    private final List h(final InsightsViewModel.InsightTypeConfig insightTypeConfig) {
        ArrayList arrayList = new ArrayList();
        int iD = insightTypeConfig.d();
        for (final int i3 = 0; i3 < iD; i3++) {
            arrayList.add(f(insightTypeConfig.b(), 3, i3, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.usecase.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateIntervalsUseCase.i(i3, insightTypeConfig, this, ((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(int i3, InsightsViewModel.InsightTypeConfig insightTypeConfig, CreateIntervalsUseCase createIntervalsUseCase, long j3, long j4) {
        if (i3 != insightTypeConfig.d() - 1) {
            return createIntervalsUseCase.l(j3, j4);
        }
        String string = createIntervalsUseCase.f103666a.getString(R.string.PC);
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final String j(long j3) {
        this.f103668c.setTimeInMillis(j3);
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "EEEE, dMMMM")).format(this.f103668c.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore k() {
        return (DevDataStore) this.f103667b.getValue();
    }

    private final String l(long j3, long j4) {
        this.f103668c.setTimeInMillis(j3);
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dM")).format(this.f103668c.getTime());
        this.f103668c.setTimeInMillis(j4);
        this.f103668c.add(6, -1);
        return str + " - " + new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dMyyyy")).format(this.f103668c.getTime());
    }

    public List m(Param params) {
        Intrinsics.checkNotNullParameter(params, "params");
        InsightsViewState.InsightsPeriodType insightsPeriodTypeA = params.a();
        InsightsViewModel.InsightTypeConfig insightTypeConfigB = params.b();
        long jC = params.c();
        int i3 = WhenMappings.f103672a[insightsPeriodTypeA.ordinal()];
        if (i3 == 1) {
            return d(insightTypeConfigB);
        }
        if (i3 == 2) {
            return h(insightTypeConfigB);
        }
        if (i3 == 3) {
            return g(insightTypeConfigB, jC);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}

package cz.mobilesoft.coreblock.util.profile;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.Condition;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.LongRange;
import kotlin.sequences.SequencesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProfileHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProfileHelper f129250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f129251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f129252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f129253d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f129254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f129255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f129256h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f129257a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.COMBINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f129257a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final ProfileHelper profileHelper = new ProfileHelper();
        f129250a = profileHelper;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129251b = LazyKt.a(lazyThreadSafetyModeB, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.util.profile.ProfileHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = profileHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f129252c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.util.profile.ProfileHelper$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = profileHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f129253d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<IntervalDao>() { // from class: cz.mobilesoft.coreblock.util.profile.ProfileHelper$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = profileHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IntervalDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f129254f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.util.profile.ProfileHelper$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = profileHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr6, objArr7);
            }
        });
        f129255g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.profile.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileHelper.H();
            }
        });
        f129256h = 8;
    }

    private ProfileHelper() {
    }

    public static /* synthetic */ boolean C(ProfileHelper profileHelper, Profile profile, List list, Interval interval, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            interval = null;
        }
        return profileHelper.B(profile, list, interval);
    }

    private final DayFlags D(Set set, final DayOfWeek dayOfWeek) {
        Object next;
        DayFlags dayFlags = null;
        if (set.isEmpty()) {
            return null;
        }
        Iterator it = SequencesKt.M(CollectionsKt.asSequence(new LongRange(1L, 7L)), new Function1() { // from class: cz.mobilesoft.coreblock.util.profile.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileHelper.F(dayOfWeek, ((Long) obj).longValue());
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (set.contains((DayOfWeek) next)) {
                break;
            }
        }
        DayOfWeek dayOfWeek2 = (DayOfWeek) next;
        if (dayOfWeek2 == null) {
            return null;
        }
        Iterator<DayFlags> it2 = DayFlags.getEntries().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            DayFlags next2 = it2.next();
            if (next2.getDayOfWeek() == dayOfWeek2) {
                dayFlags = next2;
                break;
            }
        }
        return dayFlags;
    }

    static /* synthetic */ DayFlags E(ProfileHelper profileHelper, Set set, DayOfWeek dayOfWeek, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dayOfWeek = LocalDate.d0().S();
            Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        }
        return profileHelper.D(set, dayOfWeek);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DayOfWeek F(DayOfWeek dayOfWeek, long j3) {
        return dayOfWeek.n(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H() {
        return CollectionsKt.listOf((Object[]) new ProfileType[]{ProfileType.TIME, ProfileType.USAGE_LIMIT, ProfileType.LAUNCH_COUNT, ProfileType.LOCATION, ProfileType.WIFI});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K(String str, WebsiteDTO websiteDTO, WebsiteProfileRelation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.c(), str) && it.e() == websiteDTO.d();
    }

    private final ImmutableList i(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Condition condition = (Condition) it.next();
            Integer titleResId = condition.b().getTitleResId();
            if (titleResId != null) {
                String string = context.getString(titleResId.intValue());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                int i3 = WhenMappings.f129257a[condition.b().ordinal()];
                if (i3 == 2) {
                    arrayList.add(string + ": " + condition.c() + ", " + condition.a());
                } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                    arrayList.add(string + ": " + condition.a());
                } else if (i3 == 6) {
                    arrayList.add(string + ": " + condition.a() + ", " + condition.c());
                }
            }
        }
        return ExtensionsKt.h(arrayList);
    }

    private final Triple j(ProfileWithConfiguration profileWithConfiguration, Context context, UsageLimit.LimitType limitType) {
        UsageLimit.PeriodType periodTypeK;
        List listR = profileWithConfiguration.r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((UsageLimit) obj).i() == limitType) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        long jF = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            jF += ((UsageLimit) obj2).f();
        }
        UsageLimit usageLimit = (UsageLimit) CollectionsKt.firstOrNull((List) arrayList);
        if (usageLimit == null || (periodTypeK = usageLimit.k()) == null) {
            periodTypeK = UsageLimit.PeriodType.DAILY;
        }
        String string = context.getString(periodTypeK.getDescriptionResId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strE = StringHelperExtKt.e(string);
        if (limitType == UsageLimit.LimitType.TIME) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(jF);
            return new Triple(DateHelperExtKt.f(seconds, true, true, false, 8, null), CollectionsKt.listOf((Object[]) new String[]{DateHelperExtKt.f(0L, false, false, false, 14, null), DateHelperExtKt.f(seconds, false, false, false, 14, null)}), strE);
        }
        int i4 = (int) jF;
        return new Triple(context.getResources().getQuantityString(R.plurals.f95752m, i4, Integer.valueOf(i4)), CollectionsKt.listOf((Object[]) new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(jF)}), strE);
    }

    public static /* synthetic */ ScheduleViewState.MainCardSummaryData l(ProfileHelper profileHelper, ProfileWithConfiguration profileWithConfiguration, ProfileType profileType, List list, boolean z2, boolean z3, Context context, boolean z4, int i3, Object obj) {
        boolean z5;
        ProfileHelper profileHelper2;
        ProfileWithConfiguration profileWithConfiguration2;
        ProfileType profileType2;
        Context context2;
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List list2 = list;
        boolean z6 = (i3 & 8) != 0 ? false : z2;
        boolean zC = (i3 & 16) != 0 ? C(profileHelper, profileWithConfiguration.p(), profileWithConfiguration.l(), null, 2, null) : z3;
        if ((i3 & 64) != 0) {
            z5 = false;
            profileWithConfiguration2 = profileWithConfiguration;
            profileType2 = profileType;
            context2 = context;
            profileHelper2 = profileHelper;
        } else {
            z5 = z4;
            profileHelper2 = profileHelper;
            profileWithConfiguration2 = profileWithConfiguration;
            profileType2 = profileType;
            context2 = context;
        }
        return profileHelper2.k(profileWithConfiguration2, profileType2, list2, z6, zC, context2, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence m(Context context, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        return IntervalsHelper.f129240a.b(context, interval.b(), interval.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence n(Context context, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        return IntervalsHelper.f129240a.b(context, interval.b(), interval.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence o(Context context, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        return IntervalsHelper.f129240a.b(context, interval.b(), interval.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence p(WifiNetwork it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.c();
    }

    private final String s(ProfileWithConfiguration profileWithConfiguration, List list, Context context) {
        Iterator it = list.iterator();
        int i3 = 0;
        int iC = 0;
        while (it.hasNext()) {
            iC += ((AggregatedItemRecord) it.next()).c();
        }
        double d3 = 7;
        double minutes = (TimeUnit.SECONDS.toMinutes(iC) / d3) * d3;
        List listR = profileWithConfiguration.r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((UsageLimit) obj).i() == UsageLimit.LimitType.TIME) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        long minutes2 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            minutes2 += TimeUnit.MILLISECONDS.toMinutes(((UsageLimit) obj2).f());
        }
        long jMax = (long) Math.max(minutes - (minutes2 * ((double) DayFlags.Companion.j(profileWithConfiguration.p().p()).size())), 30.0d);
        long j3 = (((long) 30) + jMax) / ((long) 60);
        if (jMax > 30) {
            String string = context.getString(R.string.zu, String.valueOf(j3));
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.Cu);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntervalDao t() {
        return (IntervalDao) f129253d.getValue();
    }

    private final JobHelperKtx u() {
        return (JobHelperKtx) f129251b.getValue();
    }

    private final ProfileDao x() {
        return (ProfileDao) f129254f.getValue();
    }

    private final WebsiteProfileRelationDao z() {
        return (WebsiteProfileRelationDao) f129252c.getValue();
    }

    public final boolean A(Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "<this>");
        return ((Boolean) BuildersKt__BuildersKt.b(null, new ProfileHelper$isCurrentlyActive$1(profile, null), 1, null)).booleanValue();
    }

    public final boolean B(Profile profile, List intervals, Interval interval) {
        Intrinsics.checkNotNullParameter(profile, "<this>");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        if (profile.H()) {
            return false;
        }
        if (interval == null) {
            interval = r(profile, intervals);
        }
        ProfileType profileType = ProfileType.TIME;
        boolean zU = profile.U(profileType);
        int iE = profile.E();
        ProfileType profileType2 = ProfileType.STRICT_MODE;
        boolean z2 = (iE & (~profileType2.mask())) != profileType.mask();
        int iE2 = (~profileType.mask()) & profile.E() & (~profileType2.mask());
        return (zU && z2 && profile.x() == 0) ? (interval != null && (profile.v() & iE2) == iE2) || profile.Q() : interval != null || profile.P() || profile.Q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        if (r11.f(r9, r6) == r0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r9, android.content.Context r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$1 r0 = (cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$1) r0
            int r1 = r0.f129266f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f129266f = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$1 r0 = new cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.f129264c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f129266f
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L4b
            if (r1 == r2) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r9 = r6.f129263b
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r9 = r6.f129262a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r9
            kotlin.ResultKt.b(r11)
            goto L85
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            java.lang.Object r9 = r6.f129263b
            r10 = r9
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r9 = r6.f129262a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r9
            kotlin.ResultKt.b(r11)
            goto L6c
        L4b:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.util.location.GeofenceHelper r1 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.f128735a
            long r3 = r9.r()
            cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$2 r5 = new cz.mobilesoft.coreblock.util.profile.ProfileHelper$prepareProfileForDeletion$2
            r5.<init>()
            r6.f129262a = r9
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r6.f129263b = r11
            r6.f129266f = r2
            r2 = r10
            java.lang.Object r10 = r1.z(r2, r3, r5, r6)
            if (r10 != r0) goto L6b
            goto L84
        L6b:
            r10 = r2
        L6c:
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r11 = r8.u()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r6.f129262a = r1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r6.f129263b = r10
            r6.f129266f = r7
            java.lang.Object r9 = r11.f(r9, r6)
            if (r9 != r0) goto L85
        L84:
            return r0
        L85:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileHelper.G(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b3, code lost:
    
        if (r2.p(r12, r0) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I(long r10, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.util.profile.ProfileHelper$updateProfileLastTimeStartByIntervalId$1
            if (r0 == 0) goto L13
            r0 = r12
            cz.mobilesoft.coreblock.util.profile.ProfileHelper$updateProfileLastTimeStartByIntervalId$1 r0 = (cz.mobilesoft.coreblock.util.profile.ProfileHelper$updateProfileLastTimeStartByIntervalId$1) r0
            int r1 = r0.f129286i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129286i = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.profile.ProfileHelper$updateProfileLastTimeStartByIntervalId$1 r0 = new cz.mobilesoft.coreblock.util.profile.ProfileHelper$updateProfileLastTimeStartByIntervalId$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f129284g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129286i
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L53
            if (r2 == r6) goto L4d
            if (r2 == r5) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r10 = r0.f129281c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r10 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r10
            java.lang.Object r10 = r0.f129280b
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r10 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r10
            kotlin.ResultKt.b(r12)
            goto Lb6
        L39:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L41:
            int r10 = r0.f129282d
            long r5 = r0.f129279a
            java.lang.Object r11 = r0.f129280b
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r11 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r11
            kotlin.ResultKt.b(r12)
            goto L8a
        L4d:
            long r10 = r0.f129279a
            kotlin.ResultKt.b(r12)
            goto L65
        L53:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r12 = r9.t()
            r0.f129279a = r10
            r0.f129286i = r6
            java.lang.Object r12 = r12.e(r10, r0)
            if (r12 != r1) goto L65
            goto Lb5
        L65:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r12 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r12
            if (r12 == 0) goto Lb6
            cz.mobilesoft.coreblock.util.profile.ProfileHelper r2 = cz.mobilesoft.coreblock.util.profile.ProfileHelper.f129250a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r2 = r2.x()
            long r6 = r12.g()
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r0.f129280b = r8
            r0.f129279a = r10
            r0.f129282d = r3
            r0.f129286i = r5
            java.lang.Object r2 = r2.e(r6, r0)
            if (r2 != r1) goto L86
            goto Lb5
        L86:
            r5 = r10
            r11 = r12
            r12 = r2
            r10 = r3
        L8a:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r12 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r12
            if (r12 == 0) goto Lb6
            long r7 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.c()
            r12.h0(r7)
            cz.mobilesoft.coreblock.util.profile.ProfileHelper r2 = cz.mobilesoft.coreblock.util.profile.ProfileHelper.f129250a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r2 = r2.x()
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r0.f129280b = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r0.f129281c = r11
            r0.f129279a = r5
            r0.f129282d = r10
            r0.f129283f = r3
            r0.f129286i = r4
            java.lang.Object r10 = r2.p(r12, r0)
            if (r10 != r1) goto Lb6
        Lb5:
            return r1
        Lb6:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileHelper.I(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0286, code lost:
    
        if (r3.h(r1, r2) == r4) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r31, java.util.List r32, java.util.List r33, kotlin.coroutines.Continuation r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileHelper.J(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState.MainCardSummaryData k(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r29, cz.mobilesoft.coreblock.enums.ProfileType r30, java.util.List r31, boolean r32, boolean r33, final android.content.Context r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileHelper.k(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, cz.mobilesoft.coreblock.enums.ProfileType, java.util.List, boolean, boolean, android.content.Context, boolean):cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$MainCardSummaryData");
    }

    public final ScheduleViewState.DetailViewState.ConditionCardContent q(ImmutableList immutableList, Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(immutableList, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        for (Object obj : immutableList) {
            if (((Condition) obj).b() != ProfileType.TIME) {
                arrayList.add(obj);
            }
        }
        Iterator<E> it = immutableList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Condition) next).b() == ProfileType.TIME) {
                break;
            }
        }
        Condition condition = (Condition) next;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableList, 10));
        Iterator<E> it2 = immutableList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Condition) it2.next()).b());
        }
        ProfileType profileTypeV = v(arrayList2);
        int i3 = profileTypeV == null ? -1 : WhenMappings.f129257a[profileTypeV.ordinal()];
        if (i3 == -1) {
            return null;
        }
        if (i3 == 1) {
            ProfileType profileType = ProfileType.COMBINED;
            String string = context.getString(R.string.Q8);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return new ScheduleViewState.DetailViewState.ConditionCardContent(profileType, string, null, "", R.drawable.N4, R.drawable.O4, true, i(context, immutableList));
        }
        if (i3 == 2) {
            if (condition != null) {
                return new ScheduleViewState.DetailViewState.ConditionCardContent(condition.b(), condition.a(), null, condition.c(), condition.b().getActiveScheduleIconResId(), condition.b().getDisabledScheduleIconResId(), false, null, 192, null);
            }
            return null;
        }
        Condition condition2 = (Condition) CollectionsKt.firstOrNull((List) arrayList);
        if (condition2 == null || condition == null) {
            return null;
        }
        return new ScheduleViewState.DetailViewState.ConditionCardContent(condition2.b(), condition2.a(), condition.a(), condition.c(), condition2.b().getActiveScheduleIconResId(), condition2.b().getDisabledScheduleIconResId(), false, null, 192, null);
    }

    public final Interval r(Profile profile, List intervals) {
        Intrinsics.checkNotNullParameter(profile, "<this>");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        if (!profile.U(ProfileType.TIME)) {
            return null;
        }
        Calendar calendarA = TimeHelperExt.A();
        DayFlags dayFlagsD = DayFlags.Companion.d();
        long j3 = ((long) calendarA.get(12)) + (((long) calendarA.get(11)) * 60);
        if (profile.I(dayFlagsD)) {
            return IntervalsHelperKt.b(intervals, j3, profile.I(dayFlagsD.addDays(1)));
        }
        return null;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final ProfileType v(List list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((ProfileType) obj) != ProfileType.TIME) {
                arrayList.add(obj);
            }
        }
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProfileType) next) == ProfileType.TIME) {
                break;
            }
        }
        ProfileType profileType = (ProfileType) next;
        if (list.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            return ProfileType.COMBINED;
        }
        if (arrayList.isEmpty() && profileType != null) {
            return profileType;
        }
        if (arrayList.size() != 1 || profileType == null) {
            return null;
        }
        return (ProfileType) CollectionsKt.firstOrNull((List) arrayList);
    }

    public final List w(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(ProfileType.TIME);
        }
        if (z3) {
            arrayList.add(ProfileType.LOCATION);
        }
        if (z4) {
            arrayList.add(ProfileType.WIFI);
        }
        if (z5) {
            arrayList.add(ProfileType.USAGE_LIMIT);
        }
        if (z6) {
            arrayList.add(ProfileType.LAUNCH_COUNT);
        }
        return arrayList;
    }

    public final List y() {
        return (List) f129255g.getValue();
    }
}

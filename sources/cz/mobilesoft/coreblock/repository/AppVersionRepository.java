package cz.mobilesoft.coreblock.repository;

import android.content.res.Resources;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.AppVersionNameDTO;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogClickAction;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFeature;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogLabel;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogVersionItem;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppVersionRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppVersionRepository f97355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f97356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f97357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f97358d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f97359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f97360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f97361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AppVersionNameDTO f97362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AppVersionNameDTO f97363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AppVersionNameDTO f97364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AppVersionNameDTO f97365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AppVersionNameDTO f97366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AppVersionNameDTO f97367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final AppVersionNameDTO f97368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final AppVersionNameDTO f97369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final AppVersionNameDTO f97370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final AppVersionNameDTO f97371r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final AppVersionNameDTO f97372s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Lazy f97373t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Lazy f97374u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Lazy f97375v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Lazy f97376w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f97377x;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final AppVersionRepository appVersionRepository = new AppVersionRepository();
        f97355a = appVersionRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f97356b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f97357c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f97358d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f97359f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(NotificationDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        f97360g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr8, objArr9);
            }
        });
        f97361h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.repository.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppVersionRepository.k();
            }
        });
        f97362i = new AppVersionNameDTO(5, 22);
        f97363j = new AppVersionNameDTO(6, 0);
        f97364k = new AppVersionNameDTO(6, 1);
        f97365l = new AppVersionNameDTO(6, 3);
        f97366m = new AppVersionNameDTO(6, 4);
        f97367n = new AppVersionNameDTO(6, 6, 6);
        f97368o = new AppVersionNameDTO(6, 7);
        f97369p = new AppVersionNameDTO(6, 8, 0);
        f97370q = new AppVersionNameDTO(6, 8, 2);
        f97371r = new AppVersionNameDTO(7, 18, 1);
        f97372s = new AppVersionNameDTO(7, 21, 1);
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        f97373t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<AppVersionDao>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppVersionDao.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        f97374u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.repository.AppVersionRepository$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = appVersionRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr12, objArr13);
            }
        });
        f97375v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.repository.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppVersionRepository.C();
            }
        });
        f97376w = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.repository.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppVersionRepository.E();
            }
        });
        f97377x = 8;
    }

    private AppVersionRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A(ChangelogVersionItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow C() {
        return f97355a.n().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow E() {
        return f97355a.n().D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(java.lang.String r8, kotlin.jvm.functions.Function1 r9, kotlin.jvm.functions.Function1 r10, kotlin.jvm.functions.Function1 r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AppVersionRepository.F(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Date I(String str) {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List k() {
        Resources resources = LockieApplication.g().getResources();
        int i3 = R.string.o6;
        ChangelogLabel changelogLabel = ChangelogLabel.FIXED;
        ChangelogLabel changelogLabel2 = ChangelogLabel.IMPROVED;
        ChangelogFeature changelogFeature = new ChangelogFeature(i3, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel, changelogLabel2}), null, R.string.D5, null, null, null, null, null, null, 1012, null);
        List listListOf = CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel2, changelogLabel});
        int i4 = R.string.n6;
        int i5 = R.string.f95781d1;
        int i6 = R.string.f95790f1;
        ChangelogFeature changelogFeature2 = new ChangelogFeature(i3, listListOf, null, i4, CollectionsKt.listOf(resources.getString(i5, resources.getString(i6))), null, null, null, null, null, 996, null);
        ChangelogFeature changelogFeature3 = new ChangelogFeature(i3, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel2, changelogLabel}), null, R.string.C5, CollectionsKt.listOf(resources.getString(i5, resources.getString(i6))), null, null, null, null, null, 996, null);
        int i7 = R.string.d6;
        ChangelogLabel changelogLabel3 = ChangelogLabel.NEW;
        List listListOf2 = CollectionsKt.listOf(changelogLabel3);
        int i8 = R.string.qi;
        int i9 = R.string.Ci;
        Integer numValueOf = Integer.valueOf(i9);
        ChangelogClickAction.OpenKeywordsBottomSheet openKeywordsBottomSheet = ChangelogClickAction.OpenKeywordsBottomSheet.f106921a;
        ChangelogFeature changelogFeature4 = new ChangelogFeature(i7, listListOf2, null, i8, null, numValueOf, openKeywordsBottomSheet, Integer.valueOf(i9), openKeywordsBottomSheet, null, 532, null);
        ChangelogFeature changelogFeature5 = new ChangelogFeature(R.string.H5, CollectionsKt.listOf(changelogLabel3), null, R.string.G5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature6 = new ChangelogFeature(R.string.m5, CollectionsKt.listOf(changelogLabel2), null, R.string.l5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature7 = new ChangelogFeature(R.string.B5, CollectionsKt.listOf(changelogLabel), null, R.string.A5, null, null, null, null, null, null, 1012, null);
        int i10 = R.string.v5;
        ChangelogLabel changelogLabel4 = ChangelogLabel.SUBS_ONLY;
        List listListOf3 = CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4});
        Integer numValueOf2 = Integer.valueOf(R.drawable.m7);
        int i11 = R.string.R2;
        List listListOf4 = CollectionsKt.listOf("");
        int i12 = R.string.Le;
        Integer numValueOf3 = Integer.valueOf(i12);
        PremiumFeature premiumFeature = PremiumFeature.BACKUP;
        ChangelogFeature changelogFeature8 = new ChangelogFeature(i10, listListOf3, numValueOf2, i11, listListOf4, numValueOf3, new ChangelogClickAction.OpenLimitScreen(premiumFeature), Integer.valueOf(R.string.fe), ChangelogClickAction.OpenBackups.f106920a, new ChangelogClickAction.OpenOldPremiumToSubscriptionScreen(premiumFeature));
        ChangelogFeature changelogFeature9 = new ChangelogFeature(R.string.r6, CollectionsKt.listOf(changelogLabel2), Integer.valueOf(R.drawable.F7), R.string.T6, null, null, null, null, null, null, 1008, null);
        ChangelogFeature changelogFeature10 = new ChangelogFeature(R.string.a6, CollectionsKt.listOf(changelogLabel2), null, R.string.Z5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature11 = new ChangelogFeature(R.string.q6, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.p6, null, Integer.valueOf(i12), new ChangelogClickAction.OpenLimitScreen(PremiumFeature.QUICK_BLOCK_TIMER), null, null, null, 916, null);
        ChangelogFeature changelogFeature12 = new ChangelogFeature(R.string.o5, CollectionsKt.listOf(changelogLabel2), null, R.string.n5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature13 = new ChangelogFeature(R.string.W5, CollectionsKt.listOf(changelogLabel2), null, R.string.Y6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature14 = new ChangelogFeature(R.string.j4, CollectionsKt.listOf(changelogLabel2), null, R.string.Lh, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature15 = new ChangelogFeature(R.string.w6, CollectionsKt.listOf(changelogLabel2), null, R.string.v6, null, null, null, null, null, null, 1012, null);
        new ChangelogFeature(R.string.is, CollectionsKt.listOf(changelogLabel3), Integer.valueOf(R.drawable.L7), R.string.s6, null, null, null, null, null, null, 1008, null);
        ChangelogFeature changelogFeature16 = new ChangelogFeature(R.string.i6, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel2}), null, R.string.j6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature17 = new ChangelogFeature(R.string.p5, CollectionsKt.listOf(changelogLabel3), null, R.string.q5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature18 = new ChangelogFeature(R.string.CD, CollectionsKt.listOf(changelogLabel2), null, R.string.R5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature19 = new ChangelogFeature(R.string.b6, CollectionsKt.listOf(changelogLabel3), null, R.string.c6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature20 = new ChangelogFeature(R.string.h6, CollectionsKt.listOf(changelogLabel3), null, R.string.g6, CollectionsKt.listOf(resources.getString(R.string.H6)), null, null, null, null, null, 996, null);
        ChangelogFeature changelogFeature21 = new ChangelogFeature(R.string.bj, CollectionsKt.listOf(changelogLabel3), null, R.string.m6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature22 = new ChangelogFeature(R.string.Y5, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel2}), null, R.string.X5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature23 = new ChangelogFeature(R.string.t5, CollectionsKt.listOf(changelogLabel3), null, R.string.s5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature24 = new ChangelogFeature(R.string.u6, CollectionsKt.listOf(changelogLabel2), null, R.string.t6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature25 = new ChangelogFeature(R.string.Q5, CollectionsKt.listOf(changelogLabel3), null, R.string.P5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature26 = new ChangelogFeature(R.string.U3, CollectionsKt.listOf(changelogLabel3), null, R.string.I6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature27 = new ChangelogFeature(R.string.G6, CollectionsKt.listOf(changelogLabel2), null, R.string.F6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature28 = new ChangelogFeature(R.string.V5, CollectionsKt.listOf(changelogLabel2), null, R.string.U5, null, null, null, null, null, null, 1012, null);
        int i13 = R.string.D6;
        ChangelogFeature changelogFeature29 = new ChangelogFeature(i13, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel2}), null, R.string.E6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature30 = new ChangelogFeature(R.string.y6, CollectionsKt.listOf(changelogLabel3), null, R.string.x6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature31 = new ChangelogFeature(R.string.M5, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel2}), null, R.string.L5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature32 = new ChangelogFeature(R.string.J5, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel2}), null, R.string.I5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature33 = new ChangelogFeature(R.string.f6, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel2}), null, R.string.e6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature34 = new ChangelogFeature(R.string.N6, CollectionsKt.listOf(changelogLabel3), null, R.string.M6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature35 = new ChangelogFeature(R.string.W, CollectionsKt.listOf(changelogLabel3), null, R.string.r5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature36 = new ChangelogFeature(R.string.O5, CollectionsKt.listOf(changelogLabel2), null, R.string.N5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature37 = new ChangelogFeature(R.string.z5, CollectionsKt.listOf(changelogLabel3), null, R.string.y5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature38 = new ChangelogFeature(R.string.x5, CollectionsKt.listOf(changelogLabel3), null, R.string.w5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature39 = new ChangelogFeature(R.string.A6, CollectionsKt.listOf(changelogLabel2), null, R.string.z6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature40 = new ChangelogFeature(R.string.l6, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel2, changelogLabel4}), null, R.string.k6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature41 = new ChangelogFeature(R.string.C6, CollectionsKt.listOf(changelogLabel3), null, R.string.K5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature42 = new ChangelogFeature(R.string.B6, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.u5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature43 = new ChangelogFeature(R.string.K6, CollectionsKt.listOf(changelogLabel2), null, R.string.J6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature44 = new ChangelogFeature(R.string.jo, CollectionsKt.listOf(changelogLabel3), null, R.string.j7, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature45 = new ChangelogFeature(R.string.i7, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.h7, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature46 = new ChangelogFeature(R.string.f5, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.e5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature47 = new ChangelogFeature(R.string.d5, CollectionsKt.listOf(changelogLabel2), null, R.string.c5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature48 = new ChangelogFeature(R.string.F5, CollectionsKt.listOf(changelogLabel3), null, R.string.E5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature49 = new ChangelogFeature(R.string.T5, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.S5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature50 = new ChangelogFeature(R.string.I3, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.i5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature51 = new ChangelogFeature(R.string.qc, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel3, changelogLabel4}), null, R.string.b5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature52 = new ChangelogFeature(R.string.S6, CollectionsKt.listOf(changelogLabel2), null, R.string.R6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature53 = new ChangelogFeature(i13, CollectionsKt.listOf(changelogLabel2), null, R.string.o7, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature54 = new ChangelogFeature(R.string.MG, CollectionsKt.listOf(changelogLabel2), null, R.string.L6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature55 = new ChangelogFeature(R.string.k5, CollectionsKt.listOf(changelogLabel3), null, R.string.j5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature56 = new ChangelogFeature(R.string.Sz, CollectionsKt.listOf((Object[]) new ChangelogLabel[]{changelogLabel2, changelogLabel4}), null, R.string.Rz, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature57 = new ChangelogFeature(R.string.P6, CollectionsKt.listOf(changelogLabel2), null, R.string.O6, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature58 = new ChangelogFeature(R.string.f95772b1, CollectionsKt.listOf(changelogLabel3), null, R.string.R0, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature59 = new ChangelogFeature(R.string.h5, CollectionsKt.listOf(changelogLabel3), null, R.string.g5, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature60 = new ChangelogFeature(R.string.l7, CollectionsKt.listOf(changelogLabel3), null, R.string.k7, null, null, null, null, null, null, 1012, null);
        ChangelogFeature changelogFeature61 = new ChangelogFeature(R.string.n7, CollectionsKt.listOf(changelogLabel2), null, R.string.m7, null, null, null, null, null, null, 1012, null);
        int i14 = R.drawable.rb;
        ChangelogFeature changelogFeature62 = new ChangelogFeature(R.string.e7, CollectionsKt.listOf(changelogLabel3), Integer.valueOf(i14), R.string.d7, null, null, null, null, null, null, 1008, null);
        int i15 = R.drawable.vb;
        ChangelogFeature changelogFeature63 = new ChangelogFeature(R.string.WB, CollectionsKt.listOf(changelogLabel2), Integer.valueOf(i15), R.string.p7, null, null, null, null, null, null, 1008, null);
        int i16 = R.drawable.ub;
        ChangelogFeature changelogFeature64 = new ChangelogFeature(R.string.ly, CollectionsKt.listOf(changelogLabel2), Integer.valueOf(i16), R.string.Q6, null, null, null, null, null, null, 1008, null);
        int i17 = R.drawable.wb;
        ChangelogFeature changelogFeature65 = new ChangelogFeature(R.string.t3, CollectionsKt.listOf(changelogLabel3), Integer.valueOf(i17), R.string.u3, null, null, null, null, null, null, 1008, null);
        int i18 = R.drawable.qb;
        ChangelogFeature changelogFeature66 = new ChangelogFeature(R.string.g7, CollectionsKt.listOf(changelogLabel2), Integer.valueOf(i18), R.string.f7, null, null, null, null, null, null, 1008, null);
        int i19 = R.drawable.tb;
        ChangelogFeature changelogFeature67 = new ChangelogFeature(R.string.fH, CollectionsKt.listOf(changelogLabel3), Integer.valueOf(i19), R.string.eH, null, null, null, null, null, null, 1008, null);
        int i20 = R.drawable.pb;
        ChangelogFeature changelogFeature68 = new ChangelogFeature(R.string.TG, CollectionsKt.listOf(changelogLabel3), Integer.valueOf(i20), R.string.SG, null, null, null, null, null, null, 1008, null);
        int i21 = R.drawable.sb;
        ChangelogFeature changelogFeature69 = new ChangelogFeature(R.string.VG, CollectionsKt.listOf(changelogLabel4), Integer.valueOf(i21), R.string.UG, null, null, null, null, null, null, 1008, null);
        int i22 = R.drawable.yb;
        ChangelogFeature changelogFeature70 = new ChangelogFeature(R.string.hH, CollectionsKt.listOf(changelogLabel4), Integer.valueOf(i22), R.string.iH, null, null, null, null, null, null, 1008, null);
        int i23 = R.drawable.xb;
        ChangelogFeature changelogFeature71 = new ChangelogFeature(R.string.pD, CollectionsKt.listOf(changelogLabel3), Integer.valueOf(i23), R.string.q7, null, null, null, null, null, null, 1008, null);
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        AppVersionNameDTO appVersionNameDTO = new AppVersionNameDTO(7, 20);
        AppVersionRepository appVersionRepository = f97355a;
        listCreateListBuilder.add(new ChangelogVersionItem(appVersionNameDTO, appVersionRepository.I("31-08-2026"), CollectionsKt.listOf(changelogFeature71), false, true, 8, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 19), appVersionRepository.I("29-06-2026"), CollectionsKt.listOf(changelogFeature70), false, true, 8, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 18), appVersionRepository.I("18-05-2026"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature68, changelogFeature67, changelogFeature69}), false, true, 8, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 17), appVersionRepository.I("10-04-2026"), CollectionsKt.listOf(changelogFeature66), false, true, 8, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 16), appVersionRepository.I("03-03-2026"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature63, changelogFeature64, changelogFeature65}), false, true, 8, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 15), appVersionRepository.I("16-01-2026"), CollectionsKt.listOf(changelogFeature62), false, true, 8, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 14), appVersionRepository.I("05-12-2025"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature60, changelogFeature61}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 13), appVersionRepository.I("08-12-2025"), CollectionsKt.listOf(changelogFeature59), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 12), appVersionRepository.I("14-11-2025"), CollectionsKt.listOf(changelogFeature58), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 11, 1), appVersionRepository.I("20-10-2025"), CollectionsKt.listOf(changelogFeature57), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 11), appVersionRepository.I("13-10-2025"), CollectionsKt.listOf(changelogFeature56), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 10), appVersionRepository.I("16-9-2025"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature54, changelogFeature55}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 9), appVersionRepository.I("25-7-2025"), CollectionsKt.listOf(changelogFeature53), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 8), appVersionRepository.I("13-7-2025"), CollectionsKt.listOf(changelogFeature52), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 7), appVersionRepository.I("13-6-2025"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature50, changelogFeature51}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 6), appVersionRepository.I("21-5-2025"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature48, changelogFeature49}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 5), appVersionRepository.I("18-3-2025"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature46, changelogFeature47}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 3), appVersionRepository.I("10-2-2025"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature44, changelogFeature45}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 2), appVersionRepository.I("1-11-2024"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature41, changelogFeature42, changelogFeature43}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 1), appVersionRepository.I("28-06-2024"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature36, changelogFeature37, changelogFeature38, changelogFeature39, changelogFeature40}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(7, 0), appVersionRepository.I("14-03-2024"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature34, changelogFeature35}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 10), appVersionRepository.I("15-02-2024"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature30, changelogFeature31, changelogFeature32, changelogFeature33}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 9), appVersionRepository.I("15-01-2024"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature28, changelogFeature29}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 8), appVersionRepository.I("15-12-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature27, changelogFeature3}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 7), appVersionRepository.I("15-11-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature26, changelogFeature24, changelogFeature25}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 6), appVersionRepository.I("15-10-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature23, changelogFeature}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 5), appVersionRepository.I("15-09-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature21, changelogFeature22}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 4), appVersionRepository.I("15-07-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature20, changelogFeature3}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 3), appVersionRepository.I("15-05-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature16, changelogFeature17, changelogFeature18, changelogFeature19}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 2), appVersionRepository.I("15-03-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature14, changelogFeature15}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 1), appVersionRepository.I("15-01-2023"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature12, changelogFeature13, changelogFeature3}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(6, 0), appVersionRepository.I("15-11-2022"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature9, changelogFeature10, changelogFeature11}), false, false, 16, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(5, 22), appVersionRepository.I("15-09-2022"), CollectionsKt.listOf(changelogFeature2), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(5, 21), appVersionRepository.I("15-08-2022"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature4, changelogFeature5}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(5, 20), appVersionRepository.I("15-07-2022"), CollectionsKt.listOf((Object[]) new ChangelogFeature[]{changelogFeature6, changelogFeature7}), false, false, 24, null));
        listCreateListBuilder.add(new ChangelogVersionItem(new AppVersionNameDTO(5, 19), appVersionRepository.I("15-06-2022"), CollectionsKt.listOf(changelogFeature8), false, false, 24, null));
        return CollectionsKt.build(listCreateListBuilder);
    }

    private final boolean l(List list, AppVersionNameDTO appVersionNameDTO, AppVersionNameDTO appVersionNameDTO2) {
        Object next;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AppVersionNameDTO appVersionNameDTOE = ((ChangelogVersionItem) next).e();
            if (appVersionNameDTOE.f(appVersionNameDTO) > 0 && appVersionNameDTO2.f(appVersionNameDTOE) >= 0) {
                break;
            }
        }
        return next != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppVersionDao n() {
        return (AppVersionDao) f97373t.getValue();
    }

    private final PremiumRepositoryV2 s() {
        return (PremiumRepositoryV2) f97360g.getValue();
    }

    private final ProfileDao t() {
        return (ProfileDao) f97374u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(java.lang.String r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AppVersionRepository.u(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(ChangelogVersionItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(ChangelogVersionItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d4, code lost:
    
        if (r9.l0(true, r0) == r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01cd, code lost:
    
        if (r4.T0(r3, r0) == r1) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0148 A[PHI: r7 r8
      0x0148: PHI (r7v19 cz.mobilesoft.coreblock.dto.AppVersionNameDTO) = 
      (r7v13 cz.mobilesoft.coreblock.dto.AppVersionNameDTO)
      (r7v16 cz.mobilesoft.coreblock.dto.AppVersionNameDTO)
      (r7v21 cz.mobilesoft.coreblock.dto.AppVersionNameDTO)
     binds: [B:46:0x011b, B:51:0x0144, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0148: PHI (r8v17 android.content.Context) = (r8v11 android.content.Context), (r8v14 android.content.Context), (r8v19 android.content.Context) binds: [B:46:0x011b, B:51:0x0144, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(android.content.Context r7, cz.mobilesoft.coreblock.dto.AppVersionNameDTO r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AppVersionRepository.y(android.content.Context, cz.mobilesoft.coreblock.dto.AppVersionNameDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object z(String str, Continuation continuation) {
        return F(str, new AppVersionRepository$handleWhatsNewOnAppUpdated$2(null), new AppVersionRepository$handleWhatsNewOnAppUpdated$3(null), new Function1() { // from class: cz.mobilesoft.coreblock.repository.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AppVersionRepository.A((ChangelogVersionItem) obj));
            }
        }, continuation);
    }

    public final Flow B() {
        return (Flow) f97375v.getValue();
    }

    public final Flow D() {
        return (Flow) f97376w.getValue();
    }

    public final void G() {
        CoroutinesHelperExtKt.d(new AppVersionRepository$setChangelogNotShowing$1(null));
    }

    public final void H() {
        CoroutinesHelperExtKt.d(new AppVersionRepository$setWhatsNewNotShowing$1(null));
    }

    public final List m() {
        return (List) f97361h.getValue();
    }

    public final List o() {
        AppVersionNameDTO appVersionNameDTOA = AppVersionNameDTO.f96890d.a();
        if (appVersionNameDTOA == null) {
            return m();
        }
        List listM = m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((ChangelogVersionItem) obj).e().compareTo(appVersionNameDTOA) <= 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final CoreDataStore p() {
        return (CoreDataStore) f97356b.getValue();
    }

    public final CoreMultiProcessDataStore q() {
        return (CoreMultiProcessDataStore) f97357c.getValue();
    }

    public final NotificationDataStore r() {
        return (NotificationDataStore) f97359f.getValue();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b1 A[PHI: r1 r4 r5 r7 r8 r9 r10 r11 r12 r13 r15
      0x01b1: PHI (r1v9 int) = (r1v7 int), (r1v11 int) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r4v8 int) = (r4v6 int), (r4v9 int) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r5v8 java.lang.String) = (r5v5 java.lang.String), (r5v11 java.lang.String) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r7v8 android.content.Context) = (r7v5 android.content.Context), (r7v10 android.content.Context) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r8v9 int) = (r8v6 int), (r8v10 int) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r9v9 int) = (r9v6 int), (r9v11 int) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r10v17 int) = (r10v14 int), (r10v19 int) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r11v5 cz.mobilesoft.coreblock.dto.AppVersionNameDTO) = (r11v2 cz.mobilesoft.coreblock.dto.AppVersionNameDTO), (r11v7 cz.mobilesoft.coreblock.dto.AppVersionNameDTO) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r12v6 java.lang.String) = (r12v3 java.lang.String), (r12v9 java.lang.String) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r13v5 boolean) = (r13v1 boolean), (r13v8 boolean) binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r15v5 cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity) = 
      (r15v1 cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity)
      (r15v8 cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity)
     binds: [B:41:0x01ad, B:15:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x024a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r27v0, types: [cz.mobilesoft.coreblock.repository.AppVersionRepository] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(android.content.Context r28, boolean r29, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.AppVersionRepository.x(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

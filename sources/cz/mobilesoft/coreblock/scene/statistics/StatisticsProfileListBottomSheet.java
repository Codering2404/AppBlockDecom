package cz.mobilesoft.coreblock.scene.statistics;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.WebsiteDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.profile.ProfileItemType;
import cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Dispatchers;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsProfileListBottomSheet extends ProfileListBottomSheet implements KoinComponent {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f119691u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f119692v = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f119693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f119694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f119695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f119696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f119697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Collection f119698t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatisticsProfileListBottomSheet a(String str, Collection collection, Fragment targetFragment) {
            Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
            StatisticsProfileListBottomSheet statisticsProfileListBottomSheet = new StatisticsProfileListBottomSheet();
            Bundle bundleB = BundleKt.b(TuplesKt.a("PACKAGE_NAME", str), TuplesKt.a("URL", collection));
            statisticsProfileListBottomSheet.setTargetFragment(targetFragment, 936);
            statisticsProfileListBottomSheet.setArguments(bundleB);
            return statisticsProfileListBottomSheet;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StatisticsProfileListBottomSheet() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119693o = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f119694p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f119695q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f119696r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr6, objArr7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao S0() {
        return (ApplicationDao) this.f119693o.getValue();
    }

    private final QuickBlockRepository T0() {
        return (QuickBlockRepository) this.f119695q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WebsiteProfileRelationDao U0() {
        return (WebsiteProfileRelationDao) this.f119694p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, DialogInterface dialogInterface, int i3) {
        statisticsProfileListBottomSheet.a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, DialogInterface dialogInterface, int i3) {
        statisticsProfileListBottomSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, DialogInterface dialogInterface, int i3) {
        ArrayList arrayList;
        ApplicationDTO applicationDTO;
        Collection collection = statisticsProfileListBottomSheet.f119698t;
        List listListOf = null;
        if (collection != null) {
            Collection collection2 = collection;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                arrayList2.add(new WebsiteDTO(false, (String) it.next(), 1, null));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        String str = statisticsProfileListBottomSheet.f119697s;
        if (str != null && (applicationDTO = (ApplicationDTO) BuildersKt__BuildersKt.b(null, new StatisticsProfileListBottomSheet$onSecondaryButtonClick$onCreateProfileConfirmed$1$applicationList$1$1(statisticsProfileListBottomSheet, str, null), 1, null)) != null) {
            listListOf = CollectionsKt.listOf(applicationDTO);
        }
        List list = listListOf;
        ActivityResultLauncher activityResultLauncherZ = statisticsProfileListBottomSheet.Z();
        ScheduleActivity.Companion companion = ScheduleActivity.f114377m;
        FragmentActivity fragmentActivityRequireActivity = statisticsProfileListBottomSheet.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        activityResultLauncherZ.b(ScheduleActivity.Companion.b(companion, fragmentActivityRequireActivity, new ScheduleDescriptor.NewSchedule(list, arrayList, false, false, null, null, 60, null), false, false, 12, null));
        AnswersHelper.f128199a.M6(statisticsProfileListBottomSheet.i0());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(Function2 function2, DialogInterface dialogInterface, int i3) {
        function2.invoke(dialogInterface, Integer.valueOf(i3));
    }

    private final void a1() {
        List list = (List) d0().getValue();
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            z0();
        } else {
            CoroutinesHelperExtKt.d(new StatisticsProfileListBottomSheet$saveAndDismiss$1(this, list, null));
        }
    }

    private final StrictModeRepository j0() {
        return (StrictModeRepository) this.f119696r.getValue();
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public boolean W(ProfileViewDTO profileViewDTO) {
        Object next;
        Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
        if (profileViewDTO.h() == Profile.BlockingMode.Allowlist && j0().n()) {
            Toast.makeText(requireContext(), StrictModeTitleAlternatives.Companion.a(), 0).show();
            return false;
        }
        if (this.f119697s != null) {
            PremiumFeature premiumFeature = profileViewDTO.N() ? PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED : PremiumFeature.PROFILES_APPS_UNLIMITED;
            List list = (List) BuildersKt__BuildersKt.b(null, new StatisticsProfileListBottomSheet$canItemBeSelected$1$existingAppRelations$1(this, profileViewDTO, null), 1, null);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((Application) next).d(), this.f119697s)) {
                    break;
                }
            }
            if (next == null) {
                Limit limit = premiumFeature.getLimit();
                ComparableExtKt.e(limit != null ? Integer.valueOf(limit.getLimitValue()) : null, Integer.valueOf(list.size() + 1));
            }
        }
        Collection collection = this.f119698t;
        if (collection != null) {
            PremiumFeature premiumFeature2 = profileViewDTO.N() ? PremiumFeature.QUICK_BLOCK_WEBS_UNLIMITED : PremiumFeature.PROFILES_WEBS_UNLIMITED;
            List list2 = (List) BuildersKt__BuildersKt.b(null, new StatisticsProfileListBottomSheet$canItemBeSelected$2$existingWebRelations$1(this, profileViewDTO, null), 1, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : collection) {
                if (!list2.contains((String) obj)) {
                    arrayList.add(obj);
                }
            }
            Limit limit2 = premiumFeature2.getLimit();
            ComparableExtKt.e(limit2 != null ? Integer.valueOf(limit2.getLimitValue()) : null, Integer.valueOf(list2.size() + arrayList.size()));
        }
        return true;
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public ProfileItemType c0() {
        return ProfileItemType.SelectBottomSheet.Statistics.f129304a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e0(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$getProfiles$1
            if (r0 == 0) goto L14
            r0 = r8
            cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$getProfiles$1 r0 = (cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$getProfiles$1) r0
            int r1 = r0.f119707c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f119707c = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$getProfiles$1 r0 = new cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$getProfiles$1
            r0.<init>(r7, r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.f119705a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f119707c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.b(r8)
            goto L47
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r1 = r7.b0()
            r4.f119707c = r2
            r2 = 0
            r3 = 0
            r5 = 2
            r6 = 0
            java.lang.Object r8 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.v0(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L47
            return r0
        L47:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L52:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L69
            java.lang.Object r1 = r8.next()
            r2 = r1
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r2 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r2
            boolean r2 = r2.H()
            if (r2 != 0) goto L52
            r0.add(r1)
            goto L52
        L69:
            cz.mobilesoft.coreblock.repository.QuickBlockRepository r8 = r7.T0()
            cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO r8 = r8.q()
            if (r8 == 0) goto L7d
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r8 = r8.h()
            if (r8 == 0) goto L7d
            r1 = 0
            r0.add(r1, r8)
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet.e0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public int k0() {
        return R.string.S;
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public boolean o0() {
        return false;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.setupDialog(dialog, i3);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f119697s = arguments.getString("PACKAGE_NAME");
            Serializable serializable = arguments.getSerializable("URL");
            this.f119698t = serializable instanceof Collection ? (Collection) serializable : null;
        }
        String str = this.f119697s;
        if (str != null) {
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            CoroutinesHelperExtKt.c(lifecycle, Dispatchers.b(), new StatisticsProfileListBottomSheet$setupDialog$2$1(this, str, null));
        }
        Collection collection = this.f119698t;
        if (collection != null) {
            Lifecycle lifecycle2 = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle2, "<get-lifecycle>(...)");
            CoroutinesHelperExtKt.c(lifecycle2, Dispatchers.b(), new StatisticsProfileListBottomSheet$setupDialog$3$1(this, collection, null));
        }
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public void w0() {
        if (((Collection) h0().getValue()).isEmpty() || !Intrinsics.areEqual(this.f119697s, LockieApplication.f95360f)) {
            a1();
        } else {
            DialogHelper.i(requireActivity(), new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    StatisticsProfileListBottomSheet.V0(this.f120095a, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    StatisticsProfileListBottomSheet.W0(this.f120096a, dialogInterface, i3);
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public void x0(long j3) {
        ProfileListBottomSheet.B0(this, null, 1, null);
        Set mutableSet = CollectionsKt.toMutableSet((Iterable) h0().getValue());
        mutableSet.add(Long.valueOf(j3));
        h0().setValue(mutableSet);
    }

    @Override // cz.mobilesoft.coreblock.view.bottomsheet.ProfileListBottomSheet
    public void z0() {
        if (DialogHelper.n(getActivity(), (int) ((Number) BuildersKt__BuildersKt.b(null, new StatisticsProfileListBottomSheet$onSecondaryButtonClick$profilesSize$1(this, null), 1, null)).longValue(), Product.PROFILE, PremiumFeature.PROFILES_UNLIMITED)) {
            final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.statistics.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatisticsProfileListBottomSheet.X0(this.f120022a, (DialogInterface) obj, ((Integer) obj2).intValue());
                }
            };
            if (Intrinsics.areEqual(this.f119697s, LockieApplication.f95360f)) {
                DialogHelper.i(requireActivity(), new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        StatisticsProfileListBottomSheet.Y0(function2, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.p
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        StatisticsProfileListBottomSheet.Z0(dialogInterface, i3);
                    }
                });
            } else {
                function2.invoke(null, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(DialogInterface dialogInterface, int i3) {
    }
}

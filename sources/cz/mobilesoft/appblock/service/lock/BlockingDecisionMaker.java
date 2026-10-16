package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.appblock.service.lock.BlockingDecision;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.util.constants.Constants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class BlockingDecisionMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f94767a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f94768a;

        static {
            int[] iArr = new int[UsageLimit.LimitType.values().length];
            try {
                iArr[UsageLimit.LimitType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UsageLimit.LimitType.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f94768a = iArr;
        }
    }

    public final Pair a(List limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        UsageLimit usageLimit = null;
        UsageLimit usageLimit2 = null;
        for (UsageLimit usageLimit3 : CollectionsKt.sortedWith(limits, new Comparator() { // from class: cz.mobilesoft.appblock.service.lock.BlockingDecisionMaker$classifyLimits$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                UsageLimit usageLimit4 = (UsageLimit) obj;
                UsageLimit usageLimit5 = (UsageLimit) obj2;
                return ComparisonsKt.d(Long.valueOf(usageLimit4.f() - usageLimit4.m()), Long.valueOf(usageLimit5.f() - usageLimit5.m()));
            }
        })) {
            if (usageLimit != null && usageLimit2 != null) {
                break;
            }
            int i3 = WhenMappings.f94768a[usageLimit3.i().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (usageLimit2 == null) {
                    usageLimit2 = usageLimit3;
                }
            } else if (usageLimit == null) {
                usageLimit = usageLimit3;
            }
        }
        return TuplesKt.a(usageLimit, usageLimit2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List b(java.util.List r12, cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase.AppsDTO r13, cz.mobilesoft.coreblock.dto.UrlDto r14, java.util.Set r15) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.BlockingDecisionMaker.b(java.util.List, cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO, cz.mobilesoft.coreblock.dto.UrlDto, java.util.Set):java.util.List");
    }

    public final boolean c(UsageLimit usageLimit, UsageLimit usageLimit2, boolean z2) {
        if (usageLimit == null || usageLimit.m() < usageLimit.f()) {
            return z2 && usageLimit2 != null && usageLimit2.m() >= usageLimit2.f();
        }
        return true;
    }

    public final String d(List list, GetForegroundAppsUseCase.AppsDTO foregroundApps) {
        Intrinsics.checkNotNullParameter(foregroundApps, "foregroundApps");
        List list2 = list;
        return (list2 == null || list2.isEmpty()) ? foregroundApps.i() : ((ApplicationProfileRelation) list.get(0)).d();
    }

    public final BlockingDecision e(List profiles, List usageLimits) {
        Object next;
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        Intrinsics.checkNotNullParameter(usageLimits, "usageLimits");
        if (usageLimits.isEmpty()) {
            return new BlockingDecision.Blocked(profiles, null);
        }
        List list = usageLimits;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            UsageLimit usageLimit = (UsageLimit) next;
            if (usageLimit.m() >= usageLimit.f()) {
                break;
            }
        }
        UsageLimit usageLimit2 = (UsageLimit) next;
        if (usageLimit2 != null) {
            UsageLimit.PeriodType periodTypeK = (usageLimit2.i() == UsageLimit.LimitType.TIME || usageLimit2.i() == UsageLimit.LimitType.LAUNCH_COUNT) ? usageLimit2.k() : null;
            ArrayList arrayList = new ArrayList();
            for (Object obj : profiles) {
                if (((ProfileWithConfiguration) obj).p().r() == usageLimit2.l()) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                profiles = arrayList;
            }
            return new BlockingDecision.Blocked(profiles, periodTypeK);
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            hashSet.add(Long.valueOf(((UsageLimit) it2.next()).l()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : profiles) {
            if (!hashSet.contains(Long.valueOf(((ProfileWithConfiguration) obj2).p().r()))) {
                arrayList2.add(obj2);
            }
        }
        return !arrayList2.isEmpty() ? new BlockingDecision.Blocked(arrayList2, null) : BlockingDecision.NotBlocked.f94766a;
    }

    public final boolean f(GetForegroundAppsUseCase.AppsDTO appsDTO) {
        boolean z2 = false;
        if (appsDTO != null && appsDTO.m()) {
            z2 = true;
        }
        return !z2;
    }

    public final boolean g(GetForegroundAppsUseCase.AppsDTO foregroundApps, GetForegroundAppsUseCase.AppsDTO appsDTO, boolean z2, boolean z3, long j3) {
        Intrinsics.checkNotNullParameter(foregroundApps, "foregroundApps");
        if (Intrinsics.areEqual(foregroundApps, appsDTO) && !z3) {
            if (j3 <= 5000) {
                return false;
            }
            if (foregroundApps.m() && z2) {
                return false;
            }
        }
        return true;
    }

    public final boolean h(GetForegroundAppsUseCase.AppsDTO foregroundApps) {
        Intrinsics.checkNotNullParameter(foregroundApps, "foregroundApps");
        if (Intrinsics.areEqual(foregroundApps.i(), "com.android.vending") && Intrinsics.areEqual(foregroundApps.k(), "cz.mobilesoft.appblock")) {
            return true;
        }
        return (Intrinsics.areEqual(foregroundApps.i(), "com.android.vending") && Constants.f128448f.contains(foregroundApps.h())) || Intrinsics.areEqual(foregroundApps.h(), "com.android.settings.password.ConfirmDeviceCredentialActivity") || Intrinsics.areEqual(foregroundApps.h(), "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity");
    }
}

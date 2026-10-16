package cz.mobilesoft.coreblock.storage.room.dto.blocking;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.repository.SubAppsCatalog;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.util.profile.WebsiteHelperKt;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import org.threeten.bp.DayOfWeek;

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
public final class ProfileWithConfiguration implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Profile f126367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f126368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f126369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f126370d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f126371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f126372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f126373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f126374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f126375j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f126376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f126377b;

        static {
            int[] iArr = new int[Profile.BlockingMode.values().length];
            try {
                iArr[Profile.BlockingMode.Blocklist.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Profile.BlockingMode.Allowlist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f126376a = iArr;
            int[] iArr2 = new int[Profile.AllowlistWebBrowsingMode.values().length];
            try {
                iArr2[Profile.AllowlistWebBrowsingMode.Allowed.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Profile.AllowlistWebBrowsingMode.NotAllowed.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Profile.AllowlistWebBrowsingMode.SelectedSites.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f126377b = iArr2;
        }
    }

    public ProfileWithConfiguration(Profile profile, List applications, List websites, List intervals, List geoAddresses, List wifis, List usageLimits, List pomodoroSessions, List subApps) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(geoAddresses, "geoAddresses");
        Intrinsics.checkNotNullParameter(wifis, "wifis");
        Intrinsics.checkNotNullParameter(usageLimits, "usageLimits");
        Intrinsics.checkNotNullParameter(pomodoroSessions, "pomodoroSessions");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        this.f126367a = profile;
        this.f126368b = applications;
        this.f126369c = websites;
        this.f126370d = intervals;
        this.f126371f = geoAddresses;
        this.f126372g = wifis;
        this.f126373h = usageLimits;
        this.f126374i = pomodoroSessions;
        this.f126375j = subApps;
    }

    private final boolean G(UrlDto urlDto) {
        if (!urlDto.isDomainReliable()) {
            return false;
        }
        int i3 = WhenMappings.f126377b[this.f126367a.F().ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            List list = this.f126369c;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (WebsiteHelperKt.a((WebsiteProfileRelation) it.next(), urlDto)) {
                    return false;
                }
            }
            return true;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!this.f126369c.isEmpty()) {
            List list2 = this.f126369c;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (WebsiteHelperKt.a((WebsiteProfileRelation) it2.next(), urlDto)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static /* synthetic */ ProfileWithConfiguration d(ProfileWithConfiguration profileWithConfiguration, Profile profile, List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            profile = profileWithConfiguration.f126367a;
        }
        if ((i3 & 2) != 0) {
            list = profileWithConfiguration.f126368b;
        }
        if ((i3 & 4) != 0) {
            list2 = profileWithConfiguration.f126369c;
        }
        if ((i3 & 8) != 0) {
            list3 = profileWithConfiguration.f126370d;
        }
        if ((i3 & 16) != 0) {
            list4 = profileWithConfiguration.f126371f;
        }
        if ((i3 & 32) != 0) {
            list5 = profileWithConfiguration.f126372g;
        }
        if ((i3 & 64) != 0) {
            list6 = profileWithConfiguration.f126373h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            list7 = profileWithConfiguration.f126374i;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            list8 = profileWithConfiguration.f126375j;
        }
        List list9 = list7;
        List list10 = list8;
        List list11 = list5;
        List list12 = list6;
        List list13 = list4;
        List list14 = list2;
        return profileWithConfiguration.c(profile, list, list14, list3, list13, list11, list12, list9, list10);
    }

    public static /* synthetic */ IntervalDTO n(ProfileWithConfiguration profileWithConfiguration, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return profileWithConfiguration.m(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(int i3, IntervalDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.b() > ((long) i3);
    }

    private final boolean u(Collection collection) {
        if (this.f126367a.o() == Profile.BlockingMode.Allowlist) {
            List list = this.f126368b;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (collection.contains(((ApplicationProfileRelation) it.next()).d())) {
                        return false;
                    }
                }
            }
            return true;
        }
        List list2 = this.f126368b;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            if (collection.contains(((ApplicationProfileRelation) it2.next()).d())) {
                return true;
            }
        }
        return false;
    }

    private final boolean v(SubApp subApp) {
        List list = this.f126375j;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((SubAppRelation) it.next()).c(), subApp.getId())) {
                return true;
            }
        }
        return false;
    }

    public final boolean A(Collection packages) {
        Intrinsics.checkNotNullParameter(packages, "packages");
        return y() && u(packages);
    }

    public final boolean B(SubApp subApp) {
        Intrinsics.checkNotNullParameter(subApp, "subApp");
        return y() && v(subApp);
    }

    public final boolean C(UrlDto url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return y() && w(url);
    }

    public final boolean D() {
        Object next;
        Iterator it = this.f126373h.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((UsageLimit) next).i() == UsageLimit.LimitType.LAUNCH_COUNT) {
                break;
            }
        }
        UsageLimit usageLimit = (UsageLimit) next;
        return usageLimit != null && usageLimit.f() - usageLimit.m() <= 0;
    }

    public final boolean E() {
        Object next;
        Iterator it = this.f126373h.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((UsageLimit) next).i() == UsageLimit.LimitType.TIME) {
                break;
            }
        }
        UsageLimit usageLimit = (UsageLimit) next;
        return usageLimit != null && usageLimit.f() - usageLimit.m() <= 0;
    }

    public final boolean F() {
        if (this.f126367a.j() || this.f126367a.k() || this.f126367a.i() || this.f126367a.n() || !this.f126375j.isEmpty() || this.f126367a.o() == Profile.BlockingMode.Allowlist || this.f126368b.size() > Limit.APP_LIMIT.getLimitValue() || this.f126369c.size() > Limit.WEBSITE_LIMIT.getLimitValue()) {
            return false;
        }
        List list = this.f126373h;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((UsageLimit) it.next()).n()) {
                    return false;
                }
            }
        }
        if (this.f126370d.size() > Limit.TIME_SCHEDULE_DAY_LIMIT.getLimitValue() || j() != null) {
            return false;
        }
        if (this.f126367a.R() && this.f126367a.w() > 0) {
            return false;
        }
        if (!this.f126367a.R() || this.f126368b.size() <= Limit.APP_WEB_LIMIT_QUICK_BLOCK.getLimitValue()) {
            return !this.f126367a.R() || this.f126369c.size() <= Limit.APP_WEB_LIMIT_QUICK_BLOCK.getLimitValue();
        }
        return false;
    }

    public final boolean b() {
        if (Intrinsics.areEqual(this.f126367a.A(), "STRICT_MODE_TAG_V2")) {
            return false;
        }
        List list = this.f126368b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((ApplicationProfileRelation) it.next()).g(2)) {
                    return true;
                }
            }
        }
        return (this.f126369c.isEmpty() && Category.Companion.c(this.f126367a.z()).isEmpty()) ? false : true;
    }

    public final ProfileWithConfiguration c(Profile profile, List applications, List websites, List intervals, List geoAddresses, List wifis, List usageLimits, List pomodoroSessions, List subApps) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(geoAddresses, "geoAddresses");
        Intrinsics.checkNotNullParameter(wifis, "wifis");
        Intrinsics.checkNotNullParameter(usageLimits, "usageLimits");
        Intrinsics.checkNotNullParameter(pomodoroSessions, "pomodoroSessions");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        return new ProfileWithConfiguration(profile, applications, websites, intervals, geoAddresses, wifis, usageLimits, pomodoroSessions, subApps);
    }

    public final List e(String primaryPackage, String str) {
        Intrinsics.checkNotNullParameter(primaryPackage, "primaryPackage");
        List<ApplicationProfileRelation> list = this.f126368b;
        ArrayList arrayList = new ArrayList();
        for (ApplicationProfileRelation applicationProfileRelation : list) {
            if ((applicationProfileRelation.b() != 0 && !applicationProfileRelation.h() && !Constants.f128453k.contains(applicationProfileRelation.d())) || (!Intrinsics.areEqual(primaryPackage, applicationProfileRelation.d()) && !Intrinsics.areEqual(str, applicationProfileRelation.d()))) {
                applicationProfileRelation = null;
            }
            if (applicationProfileRelation != null) {
                arrayList.add(applicationProfileRelation);
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileWithConfiguration)) {
            return false;
        }
        ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
        return Intrinsics.areEqual(this.f126367a, profileWithConfiguration.f126367a) && Intrinsics.areEqual(this.f126368b, profileWithConfiguration.f126368b) && Intrinsics.areEqual(this.f126369c, profileWithConfiguration.f126369c) && Intrinsics.areEqual(this.f126370d, profileWithConfiguration.f126370d) && Intrinsics.areEqual(this.f126371f, profileWithConfiguration.f126371f) && Intrinsics.areEqual(this.f126372g, profileWithConfiguration.f126372g) && Intrinsics.areEqual(this.f126373h, profileWithConfiguration.f126373h) && Intrinsics.areEqual(this.f126374i, profileWithConfiguration.f126374i) && Intrinsics.areEqual(this.f126375j, profileWithConfiguration.f126375j);
    }

    public final List f(String primaryPackage, String str) {
        String strC;
        Intrinsics.checkNotNullParameter(primaryPackage, "primaryPackage");
        List<SubAppRelation> list = this.f126375j;
        ArrayList arrayList = new ArrayList();
        for (SubAppRelation subAppRelation : list) {
            List<SubApp> listA = SubAppsCatalog.f98385a.a();
            if ((listA instanceof Collection) && listA.isEmpty()) {
                strC = null;
            } else {
                for (SubApp subApp : listA) {
                    if (Intrinsics.areEqual(subApp.getId(), subAppRelation.c()) && (Intrinsics.areEqual(subApp.getParentApp(), primaryPackage) || Intrinsics.areEqual(subApp.getParentApp(), str))) {
                        strC = subAppRelation.c();
                        break;
                    }
                }
                strC = null;
            }
            if (strC != null) {
                arrayList.add(strC);
            }
        }
        return arrayList;
    }

    public final List g() {
        return this.f126368b;
    }

    public final List h() {
        Object next;
        List<SubAppRelation> list = this.f126375j;
        ArrayList arrayList = new ArrayList();
        for (SubAppRelation subAppRelation : list) {
            Iterator it = SubAppsCatalog.f98385a.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((SubApp) next).getId(), subAppRelation.c())) {
                    break;
                }
            }
            SubApp subApp = (SubApp) next;
            if (subApp != null) {
                arrayList.add(subApp);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            SubApp subApp2 = (SubApp) obj;
            List list2 = this.f126368b;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((ApplicationProfileRelation) it2.next()).d(), subApp2.getParentApp())) {
                        break;
                    }
                }
            }
            arrayList2.add(obj);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            arrayList3.add(((SubApp) obj2).getId());
        }
        return arrayList3;
    }

    public int hashCode() {
        return (((((((((((((((this.f126367a.hashCode() * 31) + this.f126368b.hashCode()) * 31) + this.f126369c.hashCode()) * 31) + this.f126370d.hashCode()) * 31) + this.f126371f.hashCode()) * 31) + this.f126372g.hashCode()) * 31) + this.f126373h.hashCode()) * 31) + this.f126374i.hashCode()) * 31) + this.f126375j.hashCode();
    }

    public final int i() {
        List list = this.f126368b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((ApplicationProfileRelation) obj).g(2)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() + this.f126369c.size() + (this.f126367a.i() ? 1 : 0) + (this.f126367a.n() ? 1 : 0) + (this.f126367a.j() ? 1 : 0) + (this.f126367a.k() ? 1 : 0);
    }

    public final PomodoroSession j() {
        Object next;
        Iterator it = this.f126374i.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PomodoroSession) next).t()) {
                break;
            }
        }
        return (PomodoroSession) next;
    }

    public final List k() {
        return this.f126371f;
    }

    public final List l() {
        return this.f126370d;
    }

    public final IntervalDTO m(long j3) {
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j3), ZoneId.systemDefault());
        DayFlags.Companion companion = DayFlags.Companion;
        DayOfWeek dayOfWeekL = DayOfWeek.l(localDateTimeOfInstant.getDayOfWeek().getValue());
        Intrinsics.checkNotNullExpressionValue(dayOfWeekL, "of(...)");
        DayFlags dayFlagsB = companion.b(dayOfWeekL);
        Object next = null;
        if (!this.f126367a.I(dayFlagsB)) {
            return null;
        }
        final int hour = (localDateTimeOfInstant.getHour() * 60) + localDateTimeOfInstant.getMinute();
        List<Interval> listN = IntervalsHelperKt.n(this.f126370d);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listN, 10));
        for (Interval interval : listN) {
            arrayList.add(new IntervalDTO(interval.b(), interval.a(), null, null, 12, null));
        }
        Iterator it = SequencesKt.A(CollectionsKt.asSequence(ExtensionsKt.h(arrayList)), new Function1() { // from class: e2.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ProfileWithConfiguration.o(hour, (IntervalDTO) obj));
            }
        }).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jB = ((IntervalDTO) next).b();
                do {
                    Object next2 = it.next();
                    long jB2 = ((IntervalDTO) next2).b();
                    if (jB > jB2) {
                        next = next2;
                        jB = jB2;
                    }
                } while (it.hasNext());
            }
        }
        return (IntervalDTO) next;
    }

    public final Profile p() {
        return this.f126367a;
    }

    public final List q() {
        return this.f126375j;
    }

    public final List r() {
        return this.f126373h;
    }

    public final List s() {
        return this.f126369c;
    }

    public final List t() {
        return this.f126372g;
    }

    public String toString() {
        return "ProfileWithConfiguration(profile=" + this.f126367a + ", applications=" + this.f126368b + ", websites=" + this.f126369c + ", intervals=" + this.f126370d + ", geoAddresses=" + this.f126371f + ", wifis=" + this.f126372g + ", usageLimits=" + this.f126373h + ", pomodoroSessions=" + this.f126374i + ", subApps=" + this.f126375j + ")";
    }

    public final boolean w(UrlDto url) {
        Intrinsics.checkNotNullParameter(url, "url");
        int i3 = WhenMappings.f126376a[this.f126367a.o().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return G(url);
            }
            throw new NoWhenBranchMatchedException();
        }
        List list = this.f126369c;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (WebsiteHelperKt.a((WebsiteProfileRelation) it.next(), url)) {
                return true;
            }
        }
        return false;
    }

    public final boolean x(UrlDto urlDto, SubApp subApp) {
        if (this.f126367a.l()) {
            return true;
        }
        if (urlDto == null || !w(urlDto)) {
            return subApp != null && v(subApp);
        }
        return true;
    }

    public final boolean y() {
        return j() != null || ProfileHelper.C(ProfileHelper.f129250a, this.f126367a, this.f126370d, null, 2, null);
    }

    public final boolean z() {
        PomodoroSession pomodoroSessionJ = j();
        return pomodoroSessionJ != null ? pomodoroSessionJ.u() : ProfileHelper.C(ProfileHelper.f129250a, this.f126367a, this.f126370d, null, 2, null);
    }
}

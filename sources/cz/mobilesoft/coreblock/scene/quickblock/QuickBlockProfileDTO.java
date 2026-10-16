package cz.mobilesoft.coreblock.scene.quickblock;

import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class QuickBlockProfileDTO {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f114030q = new Companion(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f114031r = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f114032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Profile.BlockingMode f114033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f114034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f114035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f114036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f114037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f114038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f114039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f114040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f114041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f114042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f114043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f114044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f114045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Profile f114046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final PomodoroSession f114047p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuickBlockProfileDTO a(ProfileWithBlockedItems profileWithBlockedItems) {
            if (profileWithBlockedItems == null) {
                return null;
            }
            return new QuickBlockProfileDTO(profileWithBlockedItems.c().r(), profileWithBlockedItems.c().o(), profileWithBlockedItems.c().i(), profileWithBlockedItems.c().n(), profileWithBlockedItems.c().j(), profileWithBlockedItems.c().k(), profileWithBlockedItems.c().l(), profileWithBlockedItems.c().m(), profileWithBlockedItems.c().P(), profileWithBlockedItems.c().w(), profileWithBlockedItems.a(), profileWithBlockedItems.e(), Category.Companion.c(profileWithBlockedItems.c().z()), profileWithBlockedItems.d(), profileWithBlockedItems.c(), profileWithBlockedItems.b());
        }

        private Companion() {
        }
    }

    public QuickBlockProfileDTO(long j3, Profile.BlockingMode blockingMode, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, long j4, List applications, List websites, List selectedCategories, List subApps, Profile quickBlockProfile, PomodoroSession pomodoroSession) {
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(selectedCategories, "selectedCategories");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        Intrinsics.checkNotNullParameter(quickBlockProfile, "quickBlockProfile");
        this.f114032a = j3;
        this.f114033b = blockingMode;
        this.f114034c = z2;
        this.f114035d = z3;
        this.f114036e = z4;
        this.f114037f = z5;
        this.f114038g = z6;
        this.f114039h = z7;
        this.f114040i = z8;
        this.f114041j = j4;
        this.f114042k = applications;
        this.f114043l = websites;
        this.f114044m = selectedCategories;
        this.f114045n = subApps;
        this.f114046o = quickBlockProfile;
        this.f114047p = pomodoroSession;
    }

    public final List a() {
        return this.f114042k;
    }

    public final boolean b() {
        return this.f114036e;
    }

    public final boolean c() {
        return this.f114037f;
    }

    public final boolean d() {
        return this.f114035d;
    }

    public final Profile.BlockingMode e() {
        return this.f114033b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockProfileDTO)) {
            return false;
        }
        QuickBlockProfileDTO quickBlockProfileDTO = (QuickBlockProfileDTO) obj;
        return this.f114032a == quickBlockProfileDTO.f114032a && this.f114033b == quickBlockProfileDTO.f114033b && this.f114034c == quickBlockProfileDTO.f114034c && this.f114035d == quickBlockProfileDTO.f114035d && this.f114036e == quickBlockProfileDTO.f114036e && this.f114037f == quickBlockProfileDTO.f114037f && this.f114038g == quickBlockProfileDTO.f114038g && this.f114039h == quickBlockProfileDTO.f114039h && this.f114040i == quickBlockProfileDTO.f114040i && this.f114041j == quickBlockProfileDTO.f114041j && Intrinsics.areEqual(this.f114042k, quickBlockProfileDTO.f114042k) && Intrinsics.areEqual(this.f114043l, quickBlockProfileDTO.f114043l) && Intrinsics.areEqual(this.f114044m, quickBlockProfileDTO.f114044m) && Intrinsics.areEqual(this.f114045n, quickBlockProfileDTO.f114045n) && Intrinsics.areEqual(this.f114046o, quickBlockProfileDTO.f114046o) && Intrinsics.areEqual(this.f114047p, quickBlockProfileDTO.f114047p);
    }

    public final long f() {
        return this.f114032a;
    }

    public final PomodoroSession g() {
        return this.f114047p;
    }

    public final Profile h() {
        return this.f114046o;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((Long.hashCode(this.f114032a) * 31) + this.f114033b.hashCode()) * 31) + Boolean.hashCode(this.f114034c)) * 31) + Boolean.hashCode(this.f114035d)) * 31) + Boolean.hashCode(this.f114036e)) * 31) + Boolean.hashCode(this.f114037f)) * 31) + Boolean.hashCode(this.f114038g)) * 31) + Boolean.hashCode(this.f114039h)) * 31) + Boolean.hashCode(this.f114040i)) * 31) + Long.hashCode(this.f114041j)) * 31) + this.f114042k.hashCode()) * 31) + this.f114043l.hashCode()) * 31) + this.f114044m.hashCode()) * 31) + this.f114045n.hashCode()) * 31) + this.f114046o.hashCode()) * 31;
        PomodoroSession pomodoroSession = this.f114047p;
        return iHashCode + (pomodoroSession == null ? 0 : pomodoroSession.hashCode());
    }

    public final QuickBlockRepository.QuickBlockState i() {
        PomodoroSession pomodoroSession = this.f114047p;
        return (pomodoroSession == null || !pomodoroSession.t()) ? q() ? new QuickBlockRepository.QuickBlockState.Running(Long.valueOf(this.f114041j)) : this.f114040i ? new QuickBlockRepository.QuickBlockState.Running(null) : QuickBlockRepository.QuickBlockState.Stopped.f97890b : new QuickBlockRepository.QuickBlockState.Pomodoro(this.f114047p, false, 2, null);
    }

    public final List j() {
        return this.f114044m;
    }

    public final boolean k() {
        return this.f114034c;
    }

    public final List l() {
        return this.f114045n;
    }

    public final List m() {
        return this.f114043l;
    }

    public final boolean n() {
        return this.f114038g;
    }

    public final boolean o() {
        return this.f114039h;
    }

    public final boolean p() {
        return this.f114040i || q();
    }

    public final boolean q() {
        return this.f114041j > TimeHelperExt.c();
    }

    public String toString() {
        return "QuickBlockProfileDTO(id=" + this.f114032a + ", blockingMode=" + this.f114033b + ", shouldAddNewApplications=" + this.f114034c + ", blockUnsupportedBrowsers=" + this.f114035d + ", blockAdultContent=" + this.f114036e + ", blockInAppPurchases=" + this.f114037f + ", isBlockingLaunch=" + this.f114038g + ", isBlockingNotifications=" + this.f114039h + ", isOnIndefinitely=" + this.f114040i + ", onUntil=" + this.f114041j + ", applications=" + this.f114042k + ", websites=" + this.f114043l + ", selectedCategories=" + this.f114044m + ", subApps=" + this.f114045n + ", quickBlockProfile=" + this.f114046o + ", pomodoroSession=" + this.f114047p + ")";
    }
}

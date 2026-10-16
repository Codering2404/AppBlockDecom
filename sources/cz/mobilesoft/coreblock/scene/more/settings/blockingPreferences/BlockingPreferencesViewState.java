package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import android.content.Context;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivationTime;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BlockingPreferencesViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f108183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f108184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f108185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f108186d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f108187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f108188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f108189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set f108190i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f108191j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f108192k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f108193l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final StrictModeDeactivationTime f108194m;

    public BlockingPreferencesViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Set excludedBrowsers, Set selectedAvailableSettings, boolean z8, boolean z9, List availableSettingsItems, StrictModeDeactivationTime strictModeDeactivationTime) {
        Intrinsics.checkNotNullParameter(excludedBrowsers, "excludedBrowsers");
        Intrinsics.checkNotNullParameter(selectedAvailableSettings, "selectedAvailableSettings");
        Intrinsics.checkNotNullParameter(availableSettingsItems, "availableSettingsItems");
        Intrinsics.checkNotNullParameter(strictModeDeactivationTime, "strictModeDeactivationTime");
        this.f108183a = z2;
        this.f108184b = z3;
        this.f108185c = z4;
        this.f108186d = z5;
        this.f108187f = z6;
        this.f108188g = z7;
        this.f108189h = excludedBrowsers;
        this.f108190i = selectedAvailableSettings;
        this.f108191j = z8;
        this.f108192k = z9;
        this.f108193l = availableSettingsItems;
        this.f108194m = strictModeDeactivationTime;
    }

    public static /* synthetic */ BlockingPreferencesViewState b(BlockingPreferencesViewState blockingPreferencesViewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Set set, Set set2, boolean z8, boolean z9, List list, StrictModeDeactivationTime strictModeDeactivationTime, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = blockingPreferencesViewState.f108183a;
        }
        if ((i3 & 2) != 0) {
            z3 = blockingPreferencesViewState.f108184b;
        }
        if ((i3 & 4) != 0) {
            z4 = blockingPreferencesViewState.f108185c;
        }
        if ((i3 & 8) != 0) {
            z5 = blockingPreferencesViewState.f108186d;
        }
        if ((i3 & 16) != 0) {
            z6 = blockingPreferencesViewState.f108187f;
        }
        if ((i3 & 32) != 0) {
            z7 = blockingPreferencesViewState.f108188g;
        }
        if ((i3 & 64) != 0) {
            set = blockingPreferencesViewState.f108189h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            set2 = blockingPreferencesViewState.f108190i;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z8 = blockingPreferencesViewState.f108191j;
        }
        if ((i3 & 512) != 0) {
            z9 = blockingPreferencesViewState.f108192k;
        }
        if ((i3 & 1024) != 0) {
            list = blockingPreferencesViewState.f108193l;
        }
        if ((i3 & 2048) != 0) {
            strictModeDeactivationTime = blockingPreferencesViewState.f108194m;
        }
        List list2 = list;
        StrictModeDeactivationTime strictModeDeactivationTime2 = strictModeDeactivationTime;
        boolean z10 = z8;
        boolean z11 = z9;
        Set set3 = set;
        Set set4 = set2;
        boolean z12 = z6;
        boolean z13 = z7;
        return blockingPreferencesViewState.a(z2, z3, z4, z5, z12, z13, set3, set4, z10, z11, list2, strictModeDeactivationTime2);
    }

    public final BlockingPreferencesViewState a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Set excludedBrowsers, Set selectedAvailableSettings, boolean z8, boolean z9, List availableSettingsItems, StrictModeDeactivationTime strictModeDeactivationTime) {
        Intrinsics.checkNotNullParameter(excludedBrowsers, "excludedBrowsers");
        Intrinsics.checkNotNullParameter(selectedAvailableSettings, "selectedAvailableSettings");
        Intrinsics.checkNotNullParameter(availableSettingsItems, "availableSettingsItems");
        Intrinsics.checkNotNullParameter(strictModeDeactivationTime, "strictModeDeactivationTime");
        return new BlockingPreferencesViewState(z2, z3, z4, z5, z6, z7, excludedBrowsers, selectedAvailableSettings, z8, z9, availableSettingsItems, strictModeDeactivationTime);
    }

    public final boolean c() {
        return this.f108187f;
    }

    public final List d() {
        return this.f108193l;
    }

    public final boolean e() {
        return this.f108188g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockingPreferencesViewState)) {
            return false;
        }
        BlockingPreferencesViewState blockingPreferencesViewState = (BlockingPreferencesViewState) obj;
        return this.f108183a == blockingPreferencesViewState.f108183a && this.f108184b == blockingPreferencesViewState.f108184b && this.f108185c == blockingPreferencesViewState.f108185c && this.f108186d == blockingPreferencesViewState.f108186d && this.f108187f == blockingPreferencesViewState.f108187f && this.f108188g == blockingPreferencesViewState.f108188g && Intrinsics.areEqual(this.f108189h, blockingPreferencesViewState.f108189h) && Intrinsics.areEqual(this.f108190i, blockingPreferencesViewState.f108190i) && this.f108191j == blockingPreferencesViewState.f108191j && this.f108192k == blockingPreferencesViewState.f108192k && Intrinsics.areEqual(this.f108193l, blockingPreferencesViewState.f108193l) && this.f108194m == blockingPreferencesViewState.f108194m;
    }

    public final boolean f() {
        return this.f108192k;
    }

    public final Set g() {
        return this.f108189h;
    }

    public final boolean h() {
        return this.f108186d;
    }

    public int hashCode() {
        return (((((((((((((((((((((Boolean.hashCode(this.f108183a) * 31) + Boolean.hashCode(this.f108184b)) * 31) + Boolean.hashCode(this.f108185c)) * 31) + Boolean.hashCode(this.f108186d)) * 31) + Boolean.hashCode(this.f108187f)) * 31) + Boolean.hashCode(this.f108188g)) * 31) + this.f108189h.hashCode()) * 31) + this.f108190i.hashCode()) * 31) + Boolean.hashCode(this.f108191j)) * 31) + Boolean.hashCode(this.f108192k)) * 31) + this.f108193l.hashCode()) * 31) + this.f108194m.hashCode();
    }

    public final boolean i() {
        return this.f108191j;
    }

    public final boolean j() {
        return this.f108185c;
    }

    public final boolean k() {
        return this.f108184b;
    }

    public final Set l() {
        return this.f108190i;
    }

    public final StrictModeDeactivationTime m() {
        return this.f108194m;
    }

    public final boolean n() {
        return this.f108183a;
    }

    public String toString() {
        return "BlockingPreferencesViewState(isStrictModeOn=" + this.f108183a + ", schedulePausedEnabled=" + this.f108184b + ", popupBlockingEnabled=" + this.f108185c + ", locationSwitchEnabled=" + this.f108186d + ", availableSettingsEnabled=" + this.f108187f + ", blockAppBlockUninstallEnabled=" + this.f108188g + ", excludedBrowsers=" + this.f108189h + ", selectedAvailableSettings=" + this.f108190i + ", mindfulEditEnabled=" + this.f108191j + ", blockPhoneStartupEnabled=" + this.f108192k + ", availableSettingsItems=" + this.f108193l + ", strictModeDeactivationTime=" + this.f108194m + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ BlockingPreferencesViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Set set, Set set2, boolean z8, boolean z9, List list, StrictModeDeactivationTime strictModeDeactivationTime, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        z2 = (i3 & 1) != 0 ? false : z2;
        z3 = (i3 & 2) != 0 ? false : z3;
        z4 = (i3 & 4) != 0 ? false : z4;
        z5 = (i3 & 8) != 0 ? false : z5;
        z6 = (i3 & 16) != 0 ? false : z6;
        z7 = (i3 & 32) != 0 ? false : z7;
        set = (i3 & 64) != 0 ? SetsKt.emptySet() : set;
        set2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? SetsKt.emptySet() : set2;
        z8 = (i3 & Function.MAX_NARGS) != 0 ? false : z8;
        z9 = (i3 & 512) != 0 ? false : z9;
        if ((i3 & 1024) != 0) {
            SystemSettingsType.Companion companion = SystemSettingsType.Companion;
            Context contextG = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
            list = companion.a(contextG);
        }
        this(z2, z3, z4, z5, z6, z7, set, set2, z8, z9, list, (i3 & 2048) != 0 ? StrictModeDeactivationTime.Companion.b() : strictModeDeactivationTime);
    }
}

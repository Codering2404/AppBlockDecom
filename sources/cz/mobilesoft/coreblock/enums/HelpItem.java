package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import android.content.Intent;
import com.facebook.ads.AdError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PermissionAccessibilityReason;
import cz.mobilesoft.coreblock.scene.more.help.DokiActivity;
import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class HelpItem {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HelpItem[] $VALUES;
    public static final HelpItem ACCESSIBILITY_SPLIT_SCREEN_BLOCKING;
    public static final HelpItem AUTOSTART;
    public static final HelpItem BATTERY_OPTIMIZATION;
    public static final HelpItem CONTACT_SUPPORT;
    public static final HelpItem DOKI;
    public static final HelpItem RESTORE_PURCHASES = new HelpItem("RESTORE_PURCHASES", 0, R.drawable.M4, R.string.Uo, R.string.To, null, new Function1() { // from class: cz.mobilesoft.coreblock.enums.g
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(HelpItem._init_$lambda$0((HelpItemResultLauncher) obj));
        }
    }, false, PaywallLegacyComponentInteraction.Value.RESTORE_PURCHASES, 8, null);
    public static final HelpItem XIAOMI_LOCK_APPS;
    private final Function1<HelpItemResultLauncher, Boolean> action;
    private final String analyticsId;
    private final List<Integer> descriptionPlaceholdersResIds;
    private final int descriptionResId;
    private final int iconResId;
    private final boolean isBlockedByStrictMode;
    private final int titleResId;

    private static final /* synthetic */ HelpItem[] $values() {
        return new HelpItem[]{RESTORE_PURCHASES, AUTOSTART, BATTERY_OPTIMIZATION, XIAOMI_LOCK_APPS, ACCESSIBILITY_SPLIT_SCREEN_BLOCKING, DOKI, CONTACT_SUPPORT};
    }

    static {
        int i3 = R.drawable.f95523i1;
        int i4 = R.string.Io;
        int i5 = R.string.Ho;
        int i6 = R.string.f95790f1;
        int i7 = 32;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z2 = false;
        AUTOSTART = new HelpItem("AUTOSTART", 1, i3, i4, i5, CollectionsKt.listOf(Integer.valueOf(i6)), new Function1() { // from class: cz.mobilesoft.coreblock.enums.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HelpItem._init_$lambda$1((HelpItemResultLauncher) obj));
            }
        }, z2, "autostart", i7, defaultConstructorMarker);
        BATTERY_OPTIMIZATION = new HelpItem("BATTERY_OPTIMIZATION", 2, i3, R.string.So, R.string.Ro, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(i6), Integer.valueOf(i6)}), new Function1() { // from class: cz.mobilesoft.coreblock.enums.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HelpItem._init_$lambda$2((HelpItemResultLauncher) obj));
            }
        }, z2, "battery", i7, defaultConstructorMarker);
        XIAOMI_LOCK_APPS = new HelpItem("XIAOMI_LOCK_APPS", 3, i3, R.string.Lo, R.string.Ko, CollectionsKt.listOf(Integer.valueOf(i6)), new Function1() { // from class: cz.mobilesoft.coreblock.enums.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HelpItem._init_$lambda$3((HelpItemResultLauncher) obj));
            }
        }, z2, "xiaomi_lock", i7, defaultConstructorMarker);
        ACCESSIBILITY_SPLIT_SCREEN_BLOCKING = new HelpItem("ACCESSIBILITY_SPLIT_SCREEN_BLOCKING", 4, i3, R.string.Cf, R.string.Bf, CollectionsKt.listOf(Integer.valueOf(i6)), new Function1() { // from class: cz.mobilesoft.coreblock.enums.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HelpItem._init_$lambda$4((HelpItemResultLauncher) obj));
            }
        }, z2, "accessibility_split", i7, defaultConstructorMarker);
        DOKI = new HelpItem("DOKI", 5, R.drawable.j4, R.string.Qo, R.string.Po, CollectionsKt.listOf(Integer.valueOf(i6)), new Function1() { // from class: cz.mobilesoft.coreblock.enums.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HelpItem._init_$lambda$5((HelpItemResultLauncher) obj));
            }
        }, false, "doki");
        CONTACT_SUPPORT = new HelpItem("CONTACT_SUPPORT", 6, R.drawable.G3, R.string.i8, R.string.j8, null, new Function1() { // from class: cz.mobilesoft.coreblock.enums.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HelpItem._init_$lambda$6((HelpItemResultLauncher) obj));
            }
        }, false, "contact_support", 8, null);
        HelpItem[] helpItemArr$values = $values();
        $VALUES = helpItemArr$values;
        $ENTRIES = EnumEntriesKt.a(helpItemArr$values);
    }

    private HelpItem(String str, int i3, int i4, int i5, int i6, List list, Function1 function1, boolean z2, String str2) {
        this.iconResId = i4;
        this.titleResId = i5;
        this.descriptionResId = i6;
        this.descriptionPlaceholdersResIds = list;
        this.action = function1;
        this.isBlockedByStrictMode = z2;
        this.analyticsId = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(HelpItemResultLauncher launcher) {
        Intent intentA;
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        HelpItem helpItem = RESTORE_PURCHASES;
        if (SessionManager.f127910a.r()) {
            intentA = RestorePurchaseActivity.f107825f.a(launcher.b());
        } else {
            intentA = SignInActivity.f110366h.a(launcher.b(), new SignInConfig(SignInEntryPoint.RESTORE, null, false, true, false, true, false, false, false, false, null, AdError.INTERNAL_ERROR_2006, null));
        }
        launcher.d(helpItem, intentA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(HelpItemResultLauncher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        return RunnabilityHelper.Q(launcher.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(HelpItemResultLauncher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        RunnabilityHelper.T(launcher.b());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$3(HelpItemResultLauncher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        RunnabilityHelper.S(launcher.b());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$4(HelpItemResultLauncher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        boolean z2 = false;
        boolean z3 = false;
        launcher.d(ACCESSIBILITY_SPLIT_SCREEN_BLOCKING, PermissionActivity.Companion.b(PermissionActivity.f111772j, launcher.b(), CollectionsKt.listOf(new PermissionDTO(new Permission.ACCESSIBILITY(PermissionAccessibilityReason.SplitScreen.f97008a, false, 2, null), z2, z3, 6, null)), false, false, false, null, null, 116, null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$5(HelpItemResultLauncher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        launcher.d(DOKI, new Intent(launcher.b(), (Class<?>) DokiActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$6(HelpItemResultLauncher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        RunnabilityHelper.V(launcher.b(), 0, null, false, null, false, "troubleshooting_screen", 62, null);
        return true;
    }

    public static EnumEntries<HelpItem> getEntries() {
        return $ENTRIES;
    }

    public static HelpItem valueOf(String str) {
        return (HelpItem) Enum.valueOf(HelpItem.class, str);
    }

    public static HelpItem[] values() {
        return (HelpItem[]) $VALUES.clone();
    }

    public final Function1<HelpItemResultLauncher, Boolean> getAction() {
        return this.action;
    }

    public final String getAnalyticsId() {
        return this.analyticsId;
    }

    public final String getDescription(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<Integer> list = this.descriptionPlaceholdersResIds;
        if (list != null) {
            int i3 = this.descriptionResId;
            List<Integer> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(context.getString(((Number) it.next()).intValue()));
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            String string = context.getString(i3, Arrays.copyOf(strArr, strArr.length));
            if (string != null) {
                return string;
            }
        }
        String string2 = context.getString(this.descriptionResId);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    public final List<Integer> getDescriptionPlaceholdersResIds() {
        return this.descriptionPlaceholdersResIds;
    }

    public final int getDescriptionResId() {
        return this.descriptionResId;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final boolean isBlockedByStrictMode() {
        return this.isBlockedByStrictMode;
    }

    /* synthetic */ HelpItem(String str, int i3, int i4, int i5, int i6, List list, Function1 function1, boolean z2, String str2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, i6, (i7 & 8) != 0 ? null : list, function1, (i7 & 32) != 0 ? true : z2, str2);
    }
}

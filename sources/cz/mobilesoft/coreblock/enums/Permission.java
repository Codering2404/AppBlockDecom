package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PermissionAccessibilityReason;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.viewholder.StepDTO;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public abstract class Permission implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f96992b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f96993c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Permission.c();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f96994a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ALARM_EXACT extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ALARM_EXACT f96997d = new ALARM_EXACT();

        private ALARM_EXACT() {
            super(9, null);
        }

        private final Object readResolve() {
            return f96997d;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ALARM_EXACT);
        }

        public int hashCode() {
            return -1224129543;
        }

        public String toString() {
            return "ALARM_EXACT";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return (List) Permission.f96993c.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DEVICE_ADMIN extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final DEVICE_ADMIN f96998d = new DEVICE_ADMIN();

        private DEVICE_ADMIN() {
            super(6, null);
        }

        private final Object readResolve() {
            return f96998d;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof DEVICE_ADMIN);
        }

        public int hashCode() {
            return -1082177442;
        }

        public String toString() {
            return "DEVICE_ADMIN";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LOCATION extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final LOCATION f96999d = new LOCATION();

        private LOCATION() {
            super(5, null);
        }

        private final Object readResolve() {
            return f96999d;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LOCATION);
        }

        public int hashCode() {
            return 1557257229;
        }

        public String toString() {
            return "LOCATION";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MIUI_11_POP_UP extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final MIUI_11_POP_UP f97000d = new MIUI_11_POP_UP();

        private MIUI_11_POP_UP() {
            super(4, null);
        }

        private final Object readResolve() {
            return f97000d;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof MIUI_11_POP_UP);
        }

        public int hashCode() {
            return 1069783153;
        }

        public String toString() {
            return "MIUI_11_POP_UP";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NOTIFICATION_ACCESS extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final NOTIFICATION_ACCESS f97001d = new NOTIFICATION_ACCESS();

        private NOTIFICATION_ACCESS() {
            super(2, null);
        }

        private final Object readResolve() {
            return f97001d;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NOTIFICATION_ACCESS);
        }

        public int hashCode() {
            return -1147898912;
        }

        public String toString() {
            return "NOTIFICATION_ACCESS";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class POST_NOTIFICATIONS extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f97002d;

        public POST_NOTIFICATIONS() {
            this(false, 1, null);
        }

        public boolean equals(Object obj) {
            return obj != null && POST_NOTIFICATIONS.class == obj.getClass();
        }

        public int hashCode() {
            return POST_NOTIFICATIONS.class.hashCode();
        }

        public final boolean k() {
            return this.f97002d;
        }

        public String toString() {
            return "POST_NOTIFICATIONS(alwaysRequired=" + this.f97002d + ")";
        }

        public POST_NOTIFICATIONS(boolean z2) {
            super(8, null);
            this.f97002d = z2;
        }

        public /* synthetic */ POST_NOTIFICATIONS(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SYSTEM_OVERLAY extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final SYSTEM_OVERLAY f97003d = new SYSTEM_OVERLAY();

        private SYSTEM_OVERLAY() {
            super(3, null);
        }

        private final Object readResolve() {
            return f97003d;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SYSTEM_OVERLAY);
        }

        public int hashCode() {
            return -1755256712;
        }

        public String toString() {
            return "SYSTEM_OVERLAY";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class USAGE_ACCESS extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PermissionUsageAccessReason f97004d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public USAGE_ACCESS(PermissionUsageAccessReason reason) {
            super(0, null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.f97004d = reason;
        }

        public boolean equals(Object obj) {
            return obj != null && USAGE_ACCESS.class == obj.getClass();
        }

        public int hashCode() {
            return USAGE_ACCESS.class.hashCode();
        }

        public final PermissionUsageAccessReason k() {
            return this.f97004d;
        }

        public String toString() {
            return "USAGE_ACCESS(reason=" + this.f97004d + ")";
        }

        public /* synthetic */ USAGE_ACCESS(PermissionUsageAccessReason permissionUsageAccessReason, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? PermissionUsageAccessReason.AppBlocking : permissionUsageAccessReason);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97005a;

        static {
            int[] iArr = new int[PermissionUsageAccessReason.values().length];
            try {
                iArr[PermissionUsageAccessReason.Statistics.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f97005a = iArr;
        }
    }

    public /* synthetic */ Permission(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final List c() {
        int i3 = 1;
        boolean z2 = false;
        return CollectionsKt.listOf((Object[]) new Permission[]{new USAGE_ACCESS(null, i3, 0 == true ? 1 : 0), NOTIFICATION_ACCESS.f97001d, SYSTEM_OVERLAY.f97003d, new ACCESSIBILITY(0 == true ? 1 : 0, z2, 3, 0 == true ? 1 : 0), MIUI_11_POP_UP.f97000d, LOCATION.f96999d, DEVICE_ADMIN.f96998d, ALARM_EXACT.f96997d, new POST_NOTIFICATIONS(z2, i3, 0 == true ? 1 : 0)});
    }

    public static /* synthetic */ String e(Permission permission, Context context, boolean z2, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDescription");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return permission.d(context, z2, z3);
    }

    public static /* synthetic */ int j(Permission permission, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTitleRes");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return permission.i(z2);
    }

    public final String d(Context context, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this, LOCATION.f96999d)) {
            String string = context.getString(R.string.Tn);
            Intrinsics.checkNotNull(string);
            return string;
        }
        if (this instanceof USAGE_ACCESS) {
            if (WhenMappings.f97005a[((USAGE_ACCESS) this).k().ordinal()] == 1) {
                String string2 = context.getString(R.string.mA);
                Intrinsics.checkNotNull(string2);
                return string2;
            }
            String string3 = context.getString(R.string.Un);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
        if (Intrinsics.areEqual(this, NOTIFICATION_ACCESS.f97001d)) {
            String string4 = context.getString(R.string.pl);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        if (Intrinsics.areEqual(this, SYSTEM_OVERLAY.f97003d)) {
            Object second = PermissionHelper.c().f96934b;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            String string5 = context.getString(((Number) second).intValue());
            Intrinsics.checkNotNull(string5);
            return string5;
        }
        if (!(this instanceof ACCESSIBILITY)) {
            if (Intrinsics.areEqual(this, MIUI_11_POP_UP.f97000d)) {
                String string6 = context.getString(R.string.ww, context.getString(R.string.f95790f1));
                Intrinsics.checkNotNull(string6);
                return string6;
            }
            if (Intrinsics.areEqual(this, DEVICE_ADMIN.f96998d)) {
                String string7 = context.getString(R.string.Mb);
                Intrinsics.checkNotNull(string7);
                return string7;
            }
            if (Intrinsics.areEqual(this, ALARM_EXACT.f96997d)) {
                String string8 = context.getString(R.string.f95810k0);
                Intrinsics.checkNotNull(string8);
                return string8;
            }
            if (!(this instanceof POST_NOTIFICATIONS)) {
                throw new NoWhenBranchMatchedException();
            }
            String string9 = context.getString(R.string.xo);
            Intrinsics.checkNotNull(string9);
            return string9;
        }
        if (z3) {
            String string10 = context.getString(R.string.Z);
            Intrinsics.checkNotNull(string10);
            return string10;
        }
        if (z2) {
            String string11 = context.getString(R.string.f95796h);
            Intrinsics.checkNotNull(string11);
            return string11;
        }
        ACCESSIBILITY accessibility = (ACCESSIBILITY) this;
        PermissionAccessibilityReason permissionAccessibilityReasonK = accessibility.k();
        if (Intrinsics.areEqual(permissionAccessibilityReasonK, PermissionAccessibilityReason.WebBlocking.f97017a)) {
            String string12 = context.getString(R.string.Sn, context.getString(R.string.f95813l));
            Intrinsics.checkNotNull(string12);
            return string12;
        }
        if (Intrinsics.areEqual(permissionAccessibilityReasonK, PermissionAccessibilityReason.Statistics.f97009a)) {
            String string13 = context.getString(R.string.zg);
            Intrinsics.checkNotNull(string13);
            return string13;
        }
        if (Intrinsics.areEqual(permissionAccessibilityReasonK, PermissionAccessibilityReason.FloatingWindows.f97006a)) {
            String string14 = context.getString(R.string.Sn, context.getString(R.string.f95792g));
            Intrinsics.checkNotNull(string14);
            return string14;
        }
        if (Intrinsics.areEqual(permissionAccessibilityReasonK, PermissionAccessibilityReason.InAppPurchases.f97007a)) {
            String string15 = context.getString(R.string.Sn, context.getString(R.string.Rq));
            Intrinsics.checkNotNull(string15);
            return string15;
        }
        if (Intrinsics.areEqual(permissionAccessibilityReasonK, PermissionAccessibilityReason.UsageLimits.f97016a)) {
            String string16 = context.getString(R.string.AF);
            Intrinsics.checkNotNull(string16);
            return string16;
        }
        if (permissionAccessibilityReasonK instanceof PermissionAccessibilityReason.StrictMode) {
            String string17 = context.getString(R.string.Sn, context.getString((((PermissionAccessibilityReason.StrictMode) accessibility.k()).a() && ((PermissionAccessibilityReason.StrictMode) accessibility.k()).f()) ? R.string.f95830p : ((PermissionAccessibilityReason.StrictMode) accessibility.k()).f() ? R.string.f95826o : ((PermissionAccessibilityReason.StrictMode) accessibility.k()).d() ? R.string.Q3 : ((PermissionAccessibilityReason.StrictMode) accessibility.k()).e() ? R.string.ic : ((PermissionAccessibilityReason.StrictMode) accessibility.k()).b() ? R.string.v3 : ((PermissionAccessibilityReason.StrictMode) accessibility.k()).c() ? R.string.o3 : R.string.f95821n));
            Intrinsics.checkNotNull(string17);
            return string17;
        }
        if (!Intrinsics.areEqual(permissionAccessibilityReasonK, PermissionAccessibilityReason.SplitScreen.f97008a)) {
            throw new NoWhenBranchMatchedException();
        }
        String string18 = context.getString(R.string.Bf, context.getString(R.string.f95790f1));
        Intrinsics.checkNotNull(string18);
        return string18;
    }

    public final int f() {
        return this.f96994a;
    }

    public final String g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this instanceof USAGE_ACCESS) {
            return context.getString(R.string.F1);
        }
        if (Intrinsics.areEqual(this, NOTIFICATION_ACCESS.f97001d)) {
            return context.getString(R.string.vl);
        }
        if (Intrinsics.areEqual(this, SYSTEM_OVERLAY.f97003d)) {
            Object first = PermissionHelper.c().f96933a;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            return context.getString(((Number) first).intValue());
        }
        if (this instanceof ACCESSIBILITY) {
            return context.getString(R.string.fw);
        }
        if (Intrinsics.areEqual(this, MIUI_11_POP_UP.f97000d)) {
            return context.getString(R.string.xw);
        }
        if (Intrinsics.areEqual(this, ALARM_EXACT.f96997d)) {
            return context.getString(R.string.f95814l0);
        }
        if (this instanceof POST_NOTIFICATIONS) {
            return context.getString(R.string.yo);
        }
        return null;
    }

    public final List h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(this instanceof ACCESSIBILITY)) {
            return null;
        }
        String string = context.getString(R.string.f95790f1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
        String string2 = context.getString((runnabilityHelper.K() && runnabilityHelper.r()) ? R.string.hw : runnabilityHelper.N() ? R.string.iw : R.string.gw, string);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = runnabilityHelper.N() ? context.getString(R.string.kw, string) : context.getString(R.string.jw);
        Intrinsics.checkNotNull(string3);
        String string4 = context.getString(R.string.lw, context.getString(runnabilityHelper.N() ? R.string.ew : R.string.dw));
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return CollectionsKt.listOf((Object[]) new StepDTO[]{new StepDTO(1, StringHelper.h(string2)), new StepDTO(2, StringHelper.h(string3)), new StepDTO(3, StringHelper.h(string4))});
    }

    public final int i(boolean z2) {
        if (this instanceof USAGE_ACCESS) {
            return R.string.zF;
        }
        if (Intrinsics.areEqual(this, NOTIFICATION_ACCESS.f97001d)) {
            return R.string.ql;
        }
        if (Intrinsics.areEqual(this, SYSTEM_OVERLAY.f97003d)) {
            Object obj = PermissionHelper.c().f96933a;
            Intrinsics.checkNotNull(obj);
            return ((Number) obj).intValue();
        }
        if (this instanceof ACCESSIBILITY) {
            return z2 ? R.string.f95767a0 : R.string.f95809k;
        }
        if (Intrinsics.areEqual(this, MIUI_11_POP_UP.f97000d)) {
            return R.string.xw;
        }
        if (Intrinsics.areEqual(this, LOCATION.f96999d)) {
            return R.string.Q2;
        }
        if (Intrinsics.areEqual(this, DEVICE_ADMIN.f96998d)) {
            return R.string.Qb;
        }
        if (Intrinsics.areEqual(this, ALARM_EXACT.f96997d)) {
            return R.string.f95818m0;
        }
        if (this instanceof POST_NOTIFICATIONS) {
            return R.string.zo;
        }
        throw new NoWhenBranchMatchedException();
    }

    private Permission(int i3) {
        this.f96994a = i3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ACCESSIBILITY extends Permission {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PermissionAccessibilityReason f96995d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f96996f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ACCESSIBILITY(PermissionAccessibilityReason reason, boolean z2) {
            super(1, null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.f96995d = reason;
            this.f96996f = z2;
        }

        public boolean equals(Object obj) {
            return obj != null && ACCESSIBILITY.class == obj.getClass();
        }

        public int hashCode() {
            return ACCESSIBILITY.class.hashCode();
        }

        public final PermissionAccessibilityReason k() {
            return this.f96995d;
        }

        public final boolean l() {
            return this.f96996f;
        }

        public String toString() {
            return "ACCESSIBILITY(reason=" + this.f96995d + ", waitForAdvancedProtectionOff=" + this.f96996f + ")";
        }

        public /* synthetic */ ACCESSIBILITY(PermissionAccessibilityReason permissionAccessibilityReason, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? PermissionAccessibilityReason.WebBlocking.f97017a : permissionAccessibilityReason, (i3 & 2) != 0 ? false : z2);
        }
    }
}

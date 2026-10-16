package cz.mobilesoft.coreblock.scene.strictmode3;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeButtonState;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class StrictMode3ViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActiveState f121455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f121456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f121457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f121458d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f121459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StrictModeAccessMethod f121460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImmutableList f121461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AccessMethodConfiguration f121462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImmutableList f121463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PremiumState f121464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MissingPermissions f121465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f121466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f121467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f121468o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f121469p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f121470q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f121471r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ViewModelState f121472s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f121473t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f121474u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f121475v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121483a;

        static {
            int[] iArr = new int[StrictModeButtonState.values().length];
            try {
                iArr[StrictModeButtonState.Activate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeButtonState.Deactivate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeButtonState.Resume.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StrictModeButtonState.ExtendTimer.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StrictModeButtonState.ConnectCharger.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StrictModeButtonState.ApprovalRequest.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[StrictModeButtonState.ApprovalRequestSent.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f121483a = iArr;
        }
    }

    public StrictMode3ViewState(ActiveState activeState, String title, String str, String str2, String subtitle, StrictModeAccessMethod strictModeAccessMethod, ImmutableList accessMethodsSplit, AccessMethodConfiguration accessMethodConfiguration, ImmutableList options, PremiumState premiumState, MissingPermissions missingPermissions, String str3, long j3, boolean z2, boolean z3, boolean z4, String cooldownFormattedTime, ViewModelState viewModelState, String approvalPresetEmail, String approvalLastSendEmailRequestDateTime, long j4) {
        Intrinsics.checkNotNullParameter(activeState, "activeState");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
        Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(cooldownFormattedTime, "cooldownFormattedTime");
        Intrinsics.checkNotNullParameter(approvalPresetEmail, "approvalPresetEmail");
        Intrinsics.checkNotNullParameter(approvalLastSendEmailRequestDateTime, "approvalLastSendEmailRequestDateTime");
        this.f121455a = activeState;
        this.f121456b = title;
        this.f121457c = str;
        this.f121458d = str2;
        this.f121459f = subtitle;
        this.f121460g = strictModeAccessMethod;
        this.f121461h = accessMethodsSplit;
        this.f121462i = accessMethodConfiguration;
        this.f121463j = options;
        this.f121464k = premiumState;
        this.f121465l = missingPermissions;
        this.f121466m = str3;
        this.f121467n = j3;
        this.f121468o = z2;
        this.f121469p = z3;
        this.f121470q = z4;
        this.f121471r = cooldownFormattedTime;
        this.f121472s = viewModelState;
        this.f121473t = approvalPresetEmail;
        this.f121474u = approvalLastSendEmailRequestDateTime;
        this.f121475v = j4;
    }

    public static /* synthetic */ StrictMode3ViewState b(StrictMode3ViewState strictMode3ViewState, ActiveState activeState, String str, String str2, String str3, String str4, StrictModeAccessMethod strictModeAccessMethod, ImmutableList immutableList, AccessMethodConfiguration accessMethodConfiguration, ImmutableList immutableList2, PremiumState premiumState, MissingPermissions missingPermissions, String str5, long j3, boolean z2, boolean z3, boolean z4, String str6, ViewModelState viewModelState, String str7, String str8, long j4, int i3, Object obj) {
        long j5;
        String str9;
        boolean z5;
        ActiveState activeState2 = (i3 & 1) != 0 ? strictMode3ViewState.f121455a : activeState;
        String str10 = (i3 & 2) != 0 ? strictMode3ViewState.f121456b : str;
        String str11 = (i3 & 4) != 0 ? strictMode3ViewState.f121457c : str2;
        String str12 = (i3 & 8) != 0 ? strictMode3ViewState.f121458d : str3;
        String str13 = (i3 & 16) != 0 ? strictMode3ViewState.f121459f : str4;
        StrictModeAccessMethod strictModeAccessMethod2 = (i3 & 32) != 0 ? strictMode3ViewState.f121460g : strictModeAccessMethod;
        ImmutableList immutableList3 = (i3 & 64) != 0 ? strictMode3ViewState.f121461h : immutableList;
        AccessMethodConfiguration accessMethodConfiguration2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? strictMode3ViewState.f121462i : accessMethodConfiguration;
        ImmutableList immutableList4 = (i3 & Function.MAX_NARGS) != 0 ? strictMode3ViewState.f121463j : immutableList2;
        PremiumState premiumState2 = (i3 & 512) != 0 ? strictMode3ViewState.f121464k : premiumState;
        MissingPermissions missingPermissions2 = (i3 & 1024) != 0 ? strictMode3ViewState.f121465l : missingPermissions;
        String str14 = (i3 & 2048) != 0 ? strictMode3ViewState.f121466m : str5;
        long j6 = (i3 & 4096) != 0 ? strictMode3ViewState.f121467n : j3;
        ActiveState activeState3 = activeState2;
        boolean z6 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? strictMode3ViewState.f121468o : z2;
        boolean z7 = (i3 & 16384) != 0 ? strictMode3ViewState.f121469p : z3;
        boolean z8 = (i3 & 32768) != 0 ? strictMode3ViewState.f121470q : z4;
        String str15 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? strictMode3ViewState.f121471r : str6;
        ViewModelState viewModelState2 = (i3 & 131072) != 0 ? strictMode3ViewState.f121472s : viewModelState;
        String str16 = (i3 & 262144) != 0 ? strictMode3ViewState.f121473t : str7;
        String str17 = (i3 & 524288) != 0 ? strictMode3ViewState.f121474u : str8;
        if ((i3 & 1048576) != 0) {
            z5 = z7;
            str9 = str17;
            j5 = strictMode3ViewState.f121475v;
        } else {
            j5 = j4;
            str9 = str17;
            z5 = z7;
        }
        return strictMode3ViewState.a(activeState3, str10, str11, str12, str13, strictModeAccessMethod2, immutableList3, accessMethodConfiguration2, immutableList4, premiumState2, missingPermissions2, str14, j6, z6, z5, z8, str15, viewModelState2, str16, str9, j5);
    }

    public final StrictMode3ViewState a(ActiveState activeState, String title, String str, String str2, String subtitle, StrictModeAccessMethod strictModeAccessMethod, ImmutableList accessMethodsSplit, AccessMethodConfiguration accessMethodConfiguration, ImmutableList options, PremiumState premiumState, MissingPermissions missingPermissions, String str3, long j3, boolean z2, boolean z3, boolean z4, String cooldownFormattedTime, ViewModelState viewModelState, String approvalPresetEmail, String approvalLastSendEmailRequestDateTime, long j4) {
        Intrinsics.checkNotNullParameter(activeState, "activeState");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
        Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(cooldownFormattedTime, "cooldownFormattedTime");
        Intrinsics.checkNotNullParameter(approvalPresetEmail, "approvalPresetEmail");
        Intrinsics.checkNotNullParameter(approvalLastSendEmailRequestDateTime, "approvalLastSendEmailRequestDateTime");
        return new StrictMode3ViewState(activeState, title, str, str2, subtitle, strictModeAccessMethod, accessMethodsSplit, accessMethodConfiguration, options, premiumState, missingPermissions, str3, j3, z2, z3, z4, cooldownFormattedTime, viewModelState, approvalPresetEmail, approvalLastSendEmailRequestDateTime, j4);
    }

    public final StrictModeAccessMethod c() {
        return this.f121460g;
    }

    public final AccessMethodConfiguration d() {
        return this.f121462i;
    }

    public final ImmutableList e() {
        return this.f121461h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictMode3ViewState)) {
            return false;
        }
        StrictMode3ViewState strictMode3ViewState = (StrictMode3ViewState) obj;
        return Intrinsics.areEqual(this.f121455a, strictMode3ViewState.f121455a) && Intrinsics.areEqual(this.f121456b, strictMode3ViewState.f121456b) && Intrinsics.areEqual(this.f121457c, strictMode3ViewState.f121457c) && Intrinsics.areEqual(this.f121458d, strictMode3ViewState.f121458d) && Intrinsics.areEqual(this.f121459f, strictMode3ViewState.f121459f) && this.f121460g == strictMode3ViewState.f121460g && Intrinsics.areEqual(this.f121461h, strictMode3ViewState.f121461h) && Intrinsics.areEqual(this.f121462i, strictMode3ViewState.f121462i) && Intrinsics.areEqual(this.f121463j, strictMode3ViewState.f121463j) && Intrinsics.areEqual(this.f121464k, strictMode3ViewState.f121464k) && Intrinsics.areEqual(this.f121465l, strictMode3ViewState.f121465l) && Intrinsics.areEqual(this.f121466m, strictMode3ViewState.f121466m) && this.f121467n == strictMode3ViewState.f121467n && this.f121468o == strictMode3ViewState.f121468o && this.f121469p == strictMode3ViewState.f121469p && this.f121470q == strictMode3ViewState.f121470q && Intrinsics.areEqual(this.f121471r, strictMode3ViewState.f121471r) && Intrinsics.areEqual(this.f121472s, strictMode3ViewState.f121472s) && Intrinsics.areEqual(this.f121473t, strictMode3ViewState.f121473t) && Intrinsics.areEqual(this.f121474u, strictMode3ViewState.f121474u) && this.f121475v == strictMode3ViewState.f121475v;
    }

    public final boolean f() {
        return this.f121470q;
    }

    public final ActiveState g() {
        return this.f121455a;
    }

    public final List h() {
        ImmutableList immutableList = this.f121463j;
        ArrayList arrayList = new ArrayList();
        for (Object obj : immutableList) {
            if (((StrictModeOption) obj).getMask() != 1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(Integer.valueOf(((StrictModeOption) obj2).getTitle()));
        }
        return CollectionsKt.toList(arrayList2);
    }

    public int hashCode() {
        int iHashCode = ((this.f121455a.hashCode() * 31) + this.f121456b.hashCode()) * 31;
        String str = this.f121457c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f121458d;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f121459f.hashCode()) * 31;
        StrictModeAccessMethod strictModeAccessMethod = this.f121460g;
        int iHashCode4 = (((((((((((iHashCode3 + (strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode())) * 31) + this.f121461h.hashCode()) * 31) + this.f121462i.hashCode()) * 31) + this.f121463j.hashCode()) * 31) + this.f121464k.hashCode()) * 31) + this.f121465l.hashCode()) * 31;
        String str3 = this.f121466m;
        int iHashCode5 = (((((((((((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + Long.hashCode(this.f121467n)) * 31) + Boolean.hashCode(this.f121468o)) * 31) + Boolean.hashCode(this.f121469p)) * 31) + Boolean.hashCode(this.f121470q)) * 31) + this.f121471r.hashCode()) * 31;
        ViewModelState viewModelState = this.f121472s;
        return ((((((iHashCode5 + (viewModelState != null ? viewModelState.hashCode() : 0)) * 31) + this.f121473t.hashCode()) * 31) + this.f121474u.hashCode()) * 31) + Long.hashCode(this.f121475v);
    }

    public final String i() {
        return this.f121474u;
    }

    public final String j() {
        return this.f121473t;
    }

    public final boolean k() {
        return this.f121468o;
    }

    public final String l(Context context, StrictModeButtonState buttonState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buttonState, "buttonState");
        switch (WhenMappings.f121483a[buttonState.ordinal()]) {
            case 1:
                String string = context.getString(R.string.yx);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = context.getString(R.string.h9);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                int i3 = R.string.Cy;
                String str = this.f121458d;
                if (str == null) {
                    str = "";
                }
                String string3 = context.getString(i3, str);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = context.getString(R.string.KB);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = context.getString(R.string.f8);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = context.getString(R.string.J1);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = context.getString(R.string.I1);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final List m() {
        return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.By), Integer.valueOf(R.string.yy), Integer.valueOf(R.string.zy), Integer.valueOf(R.string.Ay), Integer.valueOf(R.string.AA)});
    }

    public final String n() {
        return this.f121471r;
    }

    public final String o() {
        return this.f121457c;
    }

    public final String p() {
        return this.f121466m;
    }

    public final MissingPermissions q() {
        return this.f121465l;
    }

    public final ImmutableList r() {
        return this.f121463j;
    }

    public final PremiumState s() {
        return this.f121464k;
    }

    public final boolean t() {
        return this.f121469p;
    }

    public String toString() {
        return "StrictMode3ViewState(activeState=" + this.f121455a + ", title=" + this.f121456b + ", endsAtTime=" + this.f121457c + ", pauseRemaining=" + this.f121458d + ", subtitle=" + this.f121459f + ", accessMethod=" + this.f121460g + ", accessMethodsSplit=" + this.f121461h + ", accessMethodConfiguration=" + this.f121462i + ", options=" + this.f121463j + ", premiumState=" + this.f121464k + ", missingPermissions=" + this.f121465l + ", limitedTimeString=" + this.f121466m + ", lastPinUpdate=" + this.f121467n + ", bottomSheetVisible=" + this.f121468o + ", resumeSheetVisible=" + this.f121469p + ", activationConfirmationSheetVisible=" + this.f121470q + ", cooldownFormattedTime=" + this.f121471r + ", viewState=" + this.f121472s + ", approvalPresetEmail=" + this.f121473t + ", approvalLastSendEmailRequestDateTime=" + this.f121474u + ", deactivationTimeMinutes=" + this.f121475v + ")";
    }

    public final String u() {
        return this.f121459f;
    }

    public final String v() {
        return this.f121456b;
    }

    public final ViewModelState w() {
        return this.f121472s;
    }

    public final boolean x() {
        return StrictModeRepository.f98230m.a(this.f121461h, this.f121464k.f(Product.STRICT_MODE));
    }

    public final boolean y() {
        return this.f121461h.contains(StrictModeAccessMethod.Approval) && !SessionManager.f127910a.r();
    }

    public final boolean z() {
        return TimeHelperExt.c() - this.f121467n < 300000;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MissingPermissions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f121481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f121482b;

        public MissingPermissions(ImmutableList permissions, boolean z2) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            this.f121481a = permissions;
            this.f121482b = z2;
        }

        public static /* synthetic */ MissingPermissions b(MissingPermissions missingPermissions, ImmutableList immutableList, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                immutableList = missingPermissions.f121481a;
            }
            if ((i3 & 2) != 0) {
                z2 = missingPermissions.f121482b;
            }
            return missingPermissions.a(immutableList, z2);
        }

        public final MissingPermissions a(ImmutableList permissions, boolean z2) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            return new MissingPermissions(permissions, z2);
        }

        public final boolean c() {
            return this.f121482b;
        }

        public final ImmutableList d() {
            return this.f121481a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MissingPermissions)) {
                return false;
            }
            MissingPermissions missingPermissions = (MissingPermissions) obj;
            return Intrinsics.areEqual(this.f121481a, missingPermissions.f121481a) && this.f121482b == missingPermissions.f121482b;
        }

        public int hashCode() {
            return (this.f121481a.hashCode() * 31) + Boolean.hashCode(this.f121482b);
        }

        public String toString() {
            return "MissingPermissions(permissions=" + this.f121481a + ", animateCheckMark=" + this.f121482b + ")";
        }

        public /* synthetic */ MissingPermissions(ImmutableList immutableList, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ActiveState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeState f121476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f121477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f121478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f121479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final StrictModeButtonState f121480e;

        public ActiveState(StrictModeState state, boolean z2, boolean z3, boolean z4, StrictModeButtonState buttonState) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(buttonState, "buttonState");
            this.f121476a = state;
            this.f121477b = z2;
            this.f121478c = z3;
            this.f121479d = z4;
            this.f121480e = buttonState;
        }

        public static /* synthetic */ ActiveState b(ActiveState activeState, StrictModeState strictModeState, boolean z2, boolean z3, boolean z4, StrictModeButtonState strictModeButtonState, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                strictModeState = activeState.f121476a;
            }
            if ((i3 & 2) != 0) {
                z2 = activeState.f121477b;
            }
            if ((i3 & 4) != 0) {
                z3 = activeState.f121478c;
            }
            if ((i3 & 8) != 0) {
                z4 = activeState.f121479d;
            }
            if ((i3 & 16) != 0) {
                strictModeButtonState = activeState.f121480e;
            }
            StrictModeButtonState strictModeButtonState2 = strictModeButtonState;
            boolean z5 = z3;
            return activeState.a(strictModeState, z2, z5, z4, strictModeButtonState2);
        }

        public final ActiveState a(StrictModeState state, boolean z2, boolean z3, boolean z4, StrictModeButtonState buttonState) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(buttonState, "buttonState");
            return new ActiveState(state, z2, z3, z4, buttonState);
        }

        public final StrictModeButtonState c() {
            return this.f121480e;
        }

        public final boolean d() {
            return this.f121479d;
        }

        public final StrictModeState e() {
            return this.f121476a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActiveState)) {
                return false;
            }
            ActiveState activeState = (ActiveState) obj;
            return this.f121476a == activeState.f121476a && this.f121477b == activeState.f121477b && this.f121478c == activeState.f121478c && this.f121479d == activeState.f121479d && this.f121480e == activeState.f121480e;
        }

        public final boolean f() {
            return this.f121477b;
        }

        public final boolean g() {
            return this.f121478c;
        }

        public int hashCode() {
            return (((((((this.f121476a.hashCode() * 31) + Boolean.hashCode(this.f121477b)) * 31) + Boolean.hashCode(this.f121478c)) * 31) + Boolean.hashCode(this.f121479d)) * 31) + this.f121480e.hashCode();
        }

        public String toString() {
            return "ActiveState(state=" + this.f121476a + ", isButtonEnabled=" + this.f121477b + ", isButtonVisible=" + this.f121478c + ", showExtendTimerButton=" + this.f121479d + ", buttonState=" + this.f121480e + ")";
        }

        public /* synthetic */ ActiveState(StrictModeState strictModeState, boolean z2, boolean z3, boolean z4, StrictModeButtonState strictModeButtonState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? StrictModeState.Inactive : strictModeState, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? false : z4, (i3 & 16) != 0 ? StrictModeButtonState.Activate : strictModeButtonState);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ StrictMode3ViewState(ActiveState activeState, String str, String str2, String str3, String str4, StrictModeAccessMethod strictModeAccessMethod, ImmutableList immutableList, AccessMethodConfiguration accessMethodConfiguration, ImmutableList immutableList2, PremiumState premiumState, MissingPermissions missingPermissions, String str5, long j3, boolean z2, boolean z3, boolean z4, String str6, ViewModelState viewModelState, String str7, String str8, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        MissingPermissions missingPermissions2;
        ActiveState activeState2 = (i3 & 1) != 0 ? new ActiveState(null, false, false, false, null, 31, null) : activeState;
        String str9 = (i3 & 2) != 0 ? "" : str;
        String str10 = (i3 & 4) != 0 ? "" : str2;
        String str11 = (i3 & 8) != 0 ? "" : str3;
        String str12 = (i3 & 16) != 0 ? "" : str4;
        ImmutableList immutableList3 = null;
        Object[] objArr = 0;
        StrictModeAccessMethod strictModeAccessMethod2 = (i3 & 32) != 0 ? null : strictModeAccessMethod;
        ImmutableList immutableListA = (i3 & 64) != 0 ? ExtensionsKt.a() : immutableList;
        AccessMethodConfiguration accessMethodConfiguration2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? AccessMethodConfiguration.None.f121084c : accessMethodConfiguration;
        ImmutableList immutableListB = (i3 & Function.MAX_NARGS) != 0 ? ExtensionsKt.b(StrictModeOption.BlockEditing) : immutableList2;
        PremiumState premiumState2 = (i3 & 512) != 0 ? PremiumState.None.INSTANCE : premiumState;
        boolean z5 = false;
        if ((i3 & 1024) != 0) {
            missingPermissions2 = new MissingPermissions(immutableList3, z5, 3, objArr == true ? 1 : 0);
        } else {
            missingPermissions2 = missingPermissions;
        }
        this(activeState2, str9, str10, str11, str12, strictModeAccessMethod2, immutableListA, accessMethodConfiguration2, immutableListB, premiumState2, missingPermissions2, (i3 & 2048) != 0 ? "" : str5, (i3 & 4096) != 0 ? 0L : j3, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z2, (i3 & 16384) != 0 ? false : z3, (i3 & 32768) != 0 ? false : z4, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? "" : str6, (i3 & 131072) != 0 ? null : viewModelState, (i3 & 262144) != 0 ? "" : str7, (i3 & 524288) == 0 ? str8 : "", (i3 & 1048576) != 0 ? 0L : j4);
    }
}

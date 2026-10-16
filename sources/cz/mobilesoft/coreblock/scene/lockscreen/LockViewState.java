package cz.mobilesoft.coreblock.scene.lockscreen;

import android.graphics.drawable.Drawable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.ads.AdView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import java.util.Set;
import kotlin.Metadata;
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
public final class LockViewState implements ViewState {
    private final boolean A;
    private final String B;
    private final float C;
    private final boolean D;
    private final boolean E;
    private final boolean F;
    private final CustomBlockingScreenConfigEntity G;
    private final Set H;
    private final UsageLimit.PeriodType I;
    private final boolean J;
    private final PremiumState K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f105536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f105537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f105538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f105539d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f105540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f105541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f105542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f105543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f105544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f105545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f105546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f105547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f105548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f105549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f105550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f105551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f105552r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f105553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f105554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f105555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f105556v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f105557w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final boolean f105558x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AdView f105559y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Drawable f105560z;

    public LockViewState(String appPackageName, String appBlockedTitle, int i3, int i4, boolean z2, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String currentCampaignCardText, boolean z10, String textBlockProfileTitle, String textBlockUntil, String textExplanation, String textBackToAppButton, String textFitify, String textVosHealth, String str, boolean z11, AdView adView, Drawable drawable, boolean z12, String str2, float f3, boolean z13, boolean z14, boolean z15, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Set selectedAvailableSettings, UsageLimit.PeriodType periodType, boolean z16, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appBlockedTitle, "appBlockedTitle");
        Intrinsics.checkNotNullParameter(currentCampaignCardText, "currentCampaignCardText");
        Intrinsics.checkNotNullParameter(textBlockProfileTitle, "textBlockProfileTitle");
        Intrinsics.checkNotNullParameter(textBlockUntil, "textBlockUntil");
        Intrinsics.checkNotNullParameter(textExplanation, "textExplanation");
        Intrinsics.checkNotNullParameter(textBackToAppButton, "textBackToAppButton");
        Intrinsics.checkNotNullParameter(textFitify, "textFitify");
        Intrinsics.checkNotNullParameter(textVosHealth, "textVosHealth");
        Intrinsics.checkNotNullParameter(selectedAvailableSettings, "selectedAvailableSettings");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f105536a = appPackageName;
        this.f105537b = appBlockedTitle;
        this.f105538c = i3;
        this.f105539d = i4;
        this.f105540f = z2;
        this.f105541g = i5;
        this.f105542h = z3;
        this.f105543i = z4;
        this.f105544j = z5;
        this.f105545k = z6;
        this.f105546l = z7;
        this.f105547m = z8;
        this.f105548n = z9;
        this.f105549o = currentCampaignCardText;
        this.f105550p = z10;
        this.f105551q = textBlockProfileTitle;
        this.f105552r = textBlockUntil;
        this.f105553s = textExplanation;
        this.f105554t = textBackToAppButton;
        this.f105555u = textFitify;
        this.f105556v = textVosHealth;
        this.f105557w = str;
        this.f105558x = z11;
        this.f105559y = adView;
        this.f105560z = drawable;
        this.A = z12;
        this.B = str2;
        this.C = f3;
        this.D = z13;
        this.E = z14;
        this.F = z15;
        this.G = customBlockingScreenConfigEntity;
        this.H = selectedAvailableSettings;
        this.I = periodType;
        this.J = z16;
        this.K = premiumState;
    }

    public static /* synthetic */ LockViewState b(LockViewState lockViewState, String str, String str2, int i3, int i4, boolean z2, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str3, boolean z10, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z11, AdView adView, Drawable drawable, boolean z12, String str11, float f3, boolean z13, boolean z14, boolean z15, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Set set, UsageLimit.PeriodType periodType, boolean z16, PremiumState premiumState, int i6, int i7, Object obj) {
        PremiumState premiumState2;
        boolean z17;
        String str12;
        String str13;
        String str14;
        boolean z18;
        AdView adView2;
        Drawable drawable2;
        boolean z19;
        String str15;
        float f4;
        boolean z20;
        boolean z21;
        boolean z22;
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity2;
        Set set2;
        UsageLimit.PeriodType periodType2;
        boolean z23;
        boolean z24;
        int i8;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        int i9;
        int i10;
        String str22 = (i6 & 1) != 0 ? lockViewState.f105536a : str;
        String str23 = (i6 & 2) != 0 ? lockViewState.f105537b : str2;
        int i11 = (i6 & 4) != 0 ? lockViewState.f105538c : i3;
        int i12 = (i6 & 8) != 0 ? lockViewState.f105539d : i4;
        boolean z32 = (i6 & 16) != 0 ? lockViewState.f105540f : z2;
        int i13 = (i6 & 32) != 0 ? lockViewState.f105541g : i5;
        boolean z33 = (i6 & 64) != 0 ? lockViewState.f105542h : z3;
        boolean z34 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? lockViewState.f105543i : z4;
        boolean z35 = (i6 & Function.MAX_NARGS) != 0 ? lockViewState.f105544j : z5;
        boolean z36 = (i6 & 512) != 0 ? lockViewState.f105545k : z6;
        boolean z37 = (i6 & 1024) != 0 ? lockViewState.f105546l : z7;
        boolean z38 = (i6 & 2048) != 0 ? lockViewState.f105547m : z8;
        boolean z39 = (i6 & 4096) != 0 ? lockViewState.f105548n : z9;
        String str24 = (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? lockViewState.f105549o : str3;
        String str25 = str22;
        boolean z40 = (i6 & 16384) != 0 ? lockViewState.f105550p : z10;
        String str26 = (i6 & 32768) != 0 ? lockViewState.f105551q : str4;
        String str27 = (i6 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? lockViewState.f105552r : str5;
        String str28 = (i6 & 131072) != 0 ? lockViewState.f105553s : str6;
        String str29 = (i6 & 262144) != 0 ? lockViewState.f105554t : str7;
        String str30 = (i6 & 524288) != 0 ? lockViewState.f105555u : str8;
        String str31 = (i6 & 1048576) != 0 ? lockViewState.f105556v : str9;
        String str32 = (i6 & 2097152) != 0 ? lockViewState.f105557w : str10;
        boolean z41 = (i6 & 4194304) != 0 ? lockViewState.f105558x : z11;
        AdView adView3 = (i6 & 8388608) != 0 ? lockViewState.f105559y : adView;
        Drawable drawable3 = (i6 & 16777216) != 0 ? lockViewState.f105560z : drawable;
        boolean z42 = (i6 & 33554432) != 0 ? lockViewState.A : z12;
        String str33 = (i6 & 67108864) != 0 ? lockViewState.B : str11;
        float f5 = (i6 & 134217728) != 0 ? lockViewState.C : f3;
        boolean z43 = (i6 & 268435456) != 0 ? lockViewState.D : z13;
        boolean z44 = (i6 & 536870912) != 0 ? lockViewState.E : z14;
        boolean z45 = (i6 & 1073741824) != 0 ? lockViewState.F : z15;
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity3 = (i6 & Integer.MIN_VALUE) != 0 ? lockViewState.G : customBlockingScreenConfigEntity;
        Set set3 = (i7 & 1) != 0 ? lockViewState.H : set;
        UsageLimit.PeriodType periodType3 = (i7 & 2) != 0 ? lockViewState.I : periodType;
        boolean z46 = (i7 & 4) != 0 ? lockViewState.J : z16;
        if ((i7 & 8) != 0) {
            z17 = z46;
            premiumState2 = lockViewState.K;
            str13 = str31;
            str14 = str32;
            z18 = z41;
            adView2 = adView3;
            drawable2 = drawable3;
            z19 = z42;
            str15 = str33;
            f4 = f5;
            z20 = z43;
            z21 = z44;
            z22 = z45;
            customBlockingScreenConfigEntity2 = customBlockingScreenConfigEntity3;
            set2 = set3;
            periodType2 = periodType3;
            z23 = z40;
            i8 = i13;
            z25 = z33;
            z26 = z34;
            z27 = z35;
            z28 = z36;
            z29 = z37;
            z30 = z38;
            z31 = z39;
            str16 = str24;
            str17 = str26;
            str18 = str27;
            str19 = str28;
            str20 = str29;
            str12 = str30;
            str21 = str23;
            i9 = i11;
            i10 = i12;
            z24 = z32;
        } else {
            premiumState2 = premiumState;
            z17 = z46;
            str12 = str30;
            str13 = str31;
            str14 = str32;
            z18 = z41;
            adView2 = adView3;
            drawable2 = drawable3;
            z19 = z42;
            str15 = str33;
            f4 = f5;
            z20 = z43;
            z21 = z44;
            z22 = z45;
            customBlockingScreenConfigEntity2 = customBlockingScreenConfigEntity3;
            set2 = set3;
            periodType2 = periodType3;
            z23 = z40;
            z24 = z32;
            i8 = i13;
            z25 = z33;
            z26 = z34;
            z27 = z35;
            z28 = z36;
            z29 = z37;
            z30 = z38;
            z31 = z39;
            str16 = str24;
            str17 = str26;
            str18 = str27;
            str19 = str28;
            str20 = str29;
            str21 = str23;
            i9 = i11;
            i10 = i12;
        }
        return lockViewState.a(str25, str21, i9, i10, z24, i8, z25, z26, z27, z28, z29, z30, z31, str16, z23, str17, str18, str19, str20, str12, str13, str14, z18, adView2, drawable2, z19, str15, f4, z20, z21, z22, customBlockingScreenConfigEntity2, set2, periodType2, z17, premiumState2);
    }

    public final boolean A() {
        return this.f105547m;
    }

    public final boolean B() {
        return this.F;
    }

    public final boolean C() {
        return this.f105546l;
    }

    public final boolean D() {
        return this.f105545k;
    }

    public final boolean E() {
        return this.f105540f;
    }

    public final boolean F() {
        return this.J;
    }

    public final String G() {
        return this.f105554t;
    }

    public final String H() {
        return this.f105551q;
    }

    public final String I() {
        return this.f105552r;
    }

    public final String J() {
        return this.f105553s;
    }

    public final String K() {
        return this.f105555u;
    }

    public final String L() {
        return this.f105556v;
    }

    public final boolean M() {
        return this.E;
    }

    public final LockViewState a(String appPackageName, String appBlockedTitle, int i3, int i4, boolean z2, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String currentCampaignCardText, boolean z10, String textBlockProfileTitle, String textBlockUntil, String textExplanation, String textBackToAppButton, String textFitify, String textVosHealth, String str, boolean z11, AdView adView, Drawable drawable, boolean z12, String str2, float f3, boolean z13, boolean z14, boolean z15, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Set selectedAvailableSettings, UsageLimit.PeriodType periodType, boolean z16, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appBlockedTitle, "appBlockedTitle");
        Intrinsics.checkNotNullParameter(currentCampaignCardText, "currentCampaignCardText");
        Intrinsics.checkNotNullParameter(textBlockProfileTitle, "textBlockProfileTitle");
        Intrinsics.checkNotNullParameter(textBlockUntil, "textBlockUntil");
        Intrinsics.checkNotNullParameter(textExplanation, "textExplanation");
        Intrinsics.checkNotNullParameter(textBackToAppButton, "textBackToAppButton");
        Intrinsics.checkNotNullParameter(textFitify, "textFitify");
        Intrinsics.checkNotNullParameter(textVosHealth, "textVosHealth");
        Intrinsics.checkNotNullParameter(selectedAvailableSettings, "selectedAvailableSettings");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        return new LockViewState(appPackageName, appBlockedTitle, i3, i4, z2, i5, z3, z4, z5, z6, z7, z8, z9, currentCampaignCardText, z10, textBlockProfileTitle, textBlockUntil, textExplanation, textBackToAppButton, textFitify, textVosHealth, str, z11, adView, drawable, z12, str2, f3, z13, z14, z15, customBlockingScreenConfigEntity, selectedAvailableSettings, periodType, z16, premiumState);
    }

    public final AdView c() {
        return this.f105559y;
    }

    public final String d() {
        return this.f105537b;
    }

    public final int e() {
        return this.f105541g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LockViewState)) {
            return false;
        }
        LockViewState lockViewState = (LockViewState) obj;
        return Intrinsics.areEqual(this.f105536a, lockViewState.f105536a) && Intrinsics.areEqual(this.f105537b, lockViewState.f105537b) && this.f105538c == lockViewState.f105538c && this.f105539d == lockViewState.f105539d && this.f105540f == lockViewState.f105540f && this.f105541g == lockViewState.f105541g && this.f105542h == lockViewState.f105542h && this.f105543i == lockViewState.f105543i && this.f105544j == lockViewState.f105544j && this.f105545k == lockViewState.f105545k && this.f105546l == lockViewState.f105546l && this.f105547m == lockViewState.f105547m && this.f105548n == lockViewState.f105548n && Intrinsics.areEqual(this.f105549o, lockViewState.f105549o) && this.f105550p == lockViewState.f105550p && Intrinsics.areEqual(this.f105551q, lockViewState.f105551q) && Intrinsics.areEqual(this.f105552r, lockViewState.f105552r) && Intrinsics.areEqual(this.f105553s, lockViewState.f105553s) && Intrinsics.areEqual(this.f105554t, lockViewState.f105554t) && Intrinsics.areEqual(this.f105555u, lockViewState.f105555u) && Intrinsics.areEqual(this.f105556v, lockViewState.f105556v) && Intrinsics.areEqual(this.f105557w, lockViewState.f105557w) && this.f105558x == lockViewState.f105558x && Intrinsics.areEqual(this.f105559y, lockViewState.f105559y) && Intrinsics.areEqual(this.f105560z, lockViewState.f105560z) && this.A == lockViewState.A && Intrinsics.areEqual(this.B, lockViewState.B) && Float.compare(this.C, lockViewState.C) == 0 && this.D == lockViewState.D && this.E == lockViewState.E && this.F == lockViewState.F && Intrinsics.areEqual(this.G, lockViewState.G) && Intrinsics.areEqual(this.H, lockViewState.H) && this.I == lockViewState.I && this.J == lockViewState.J && Intrinsics.areEqual(this.K, lockViewState.K);
    }

    public final int f() {
        return this.f105539d;
    }

    public final int g() {
        return this.f105538c;
    }

    public final String h() {
        return this.f105536a;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((this.f105536a.hashCode() * 31) + this.f105537b.hashCode()) * 31) + Integer.hashCode(this.f105538c)) * 31) + Integer.hashCode(this.f105539d)) * 31) + Boolean.hashCode(this.f105540f)) * 31) + Integer.hashCode(this.f105541g)) * 31) + Boolean.hashCode(this.f105542h)) * 31) + Boolean.hashCode(this.f105543i)) * 31) + Boolean.hashCode(this.f105544j)) * 31) + Boolean.hashCode(this.f105545k)) * 31) + Boolean.hashCode(this.f105546l)) * 31) + Boolean.hashCode(this.f105547m)) * 31) + Boolean.hashCode(this.f105548n)) * 31) + this.f105549o.hashCode()) * 31) + Boolean.hashCode(this.f105550p)) * 31) + this.f105551q.hashCode()) * 31) + this.f105552r.hashCode()) * 31) + this.f105553s.hashCode()) * 31) + this.f105554t.hashCode()) * 31) + this.f105555u.hashCode()) * 31) + this.f105556v.hashCode()) * 31;
        String str = this.f105557w;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f105558x)) * 31;
        AdView adView = this.f105559y;
        int iHashCode3 = (iHashCode2 + (adView == null ? 0 : adView.hashCode())) * 31;
        Drawable drawable = this.f105560z;
        int iHashCode4 = (((iHashCode3 + (drawable == null ? 0 : drawable.hashCode())) * 31) + Boolean.hashCode(this.A)) * 31;
        String str2 = this.B;
        int iHashCode5 = (((((((((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + Float.hashCode(this.C)) * 31) + Boolean.hashCode(this.D)) * 31) + Boolean.hashCode(this.E)) * 31) + Boolean.hashCode(this.F)) * 31;
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity = this.G;
        int iHashCode6 = (((iHashCode5 + (customBlockingScreenConfigEntity == null ? 0 : customBlockingScreenConfigEntity.hashCode())) * 31) + this.H.hashCode()) * 31;
        UsageLimit.PeriodType periodType = this.I;
        return ((((iHashCode6 + (periodType != null ? periodType.hashCode() : 0)) * 31) + Boolean.hashCode(this.J)) * 31) + this.K.hashCode();
    }

    public final UsageLimit.PeriodType i() {
        return this.I;
    }

    public final Drawable j() {
        return this.f105560z;
    }

    public final String k() {
        return this.f105557w;
    }

    public final boolean l() {
        return (!this.E || this.K.f(Product.ADS)) ? !this.A : !this.A && this.f105558x;
    }

    public final boolean m() {
        return this.D;
    }

    public final float n() {
        return this.C;
    }

    public final String o() {
        return this.B;
    }

    public final String p() {
        return this.f105549o;
    }

    public final CustomBlockingScreenConfigEntity q() {
        return this.G;
    }

    public final boolean r() {
        return this.f105550p;
    }

    public final Set s() {
        return this.H;
    }

    public final boolean t() {
        return this.f105542h;
    }

    public String toString() {
        return "LockViewState(appPackageName=" + this.f105536a + ", appBlockedTitle=" + this.f105537b + ", appNameHighlightStartPosition=" + this.f105538c + ", appNameHighlightEndPosition=" + this.f105539d + ", showSmallAppName=" + this.f105540f + ", appNameHighlightColorResId=" + this.f105541g + ", shouldShowCustomScreenPopup=" + this.f105542h + ", showCloseButton=" + this.f105543i + ", showBackToAppButton=" + this.f105544j + ", showSettingsButton=" + this.f105545k + ", showMotivationalText=" + this.f105546l + ", showInAppUpdateCard=" + this.f105547m + ", showCampaignCard=" + this.f105548n + ", currentCampaignCardText=" + this.f105549o + ", runCampaignCountdown=" + this.f105550p + ", textBlockProfileTitle=" + this.f105551q + ", textBlockUntil=" + this.f105552r + ", textExplanation=" + this.f105553s + ", textBackToAppButton=" + this.f105554t + ", textFitify=" + this.f105555u + ", textVosHealth=" + this.f105556v + ", blockingReasonText=" + this.f105557w + ", showAdBanner=" + this.f105558x + ", adView=" + this.f105559y + ", blockedAppIcon=" + this.f105560z + ", showCountDown=" + this.A + ", countDownText=" + this.B + ", countDownProgress=" + this.C + ", closeOnResume=" + this.D + ", waitForBannerLoad=" + this.E + ", showContactSupportMenu=" + this.F + ", customBlockingScreenConfig=" + this.G + ", selectedAvailableSettings=" + this.H + ", appUsageLimitType=" + this.I + ", showUsageLimitRanOut=" + this.J + ", premiumState=" + this.K + ")";
    }

    public final boolean u() {
        return this.f105558x;
    }

    public final boolean v() {
        return this.f105544j;
    }

    public final boolean w() {
        return this.f105548n;
    }

    public final boolean x() {
        return this.f105543i;
    }

    public final boolean y() {
        return this.F;
    }

    public final boolean z() {
        return this.A;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ LockViewState(java.lang.String r41, java.lang.String r42, int r43, int r44, boolean r45, int r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, boolean r53, java.lang.String r54, boolean r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, boolean r63, com.google.android.gms.ads.AdView r64, android.graphics.drawable.Drawable r65, boolean r66, java.lang.String r67, float r68, boolean r69, boolean r70, boolean r71, cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r72, java.util.Set r73, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType r74, boolean r75, cz.mobilesoft.coreblock.enums.PremiumState r76, int r77, int r78, kotlin.jvm.internal.DefaultConstructorMarker r79) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.LockViewState.<init>(java.lang.String, java.lang.String, int, int, boolean, int, boolean, boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, com.google.android.gms.ads.AdView, android.graphics.drawable.Drawable, boolean, java.lang.String, float, boolean, boolean, boolean, cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity, java.util.Set, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType, boolean, cz.mobilesoft.coreblock.enums.PremiumState, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

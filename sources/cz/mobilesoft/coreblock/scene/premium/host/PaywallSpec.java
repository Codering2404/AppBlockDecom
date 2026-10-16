package cz.mobilesoft.coreblock.scene.premium.host;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RevenueCatPlacement f113331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PaywallLayout f113332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PaywallCopy f113333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CloseBehaviour f113334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PaywallAnalytics f113335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PaywallChrome f113336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PaywallViewModelKind f113337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final PaywallOnOpen f113338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OfferUsedMarker f113339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OtherOptionsSheet f113340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f113341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f113342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f113343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f113344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f113345o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f113346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f113347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f113348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f113349s;

    public PaywallSpec(RevenueCatPlacement placement, PaywallLayout layout, PaywallCopy copy, CloseBehaviour close, PaywallAnalytics analytics, PaywallChrome chrome, PaywallViewModelKind viewModel, PaywallOnOpen onOpen, OfferUsedMarker marksOfferUsed, OtherOptionsSheet otherOptionsSheet, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(copy, "copy");
        Intrinsics.checkNotNullParameter(close, "close");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(chrome, "chrome");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onOpen, "onOpen");
        Intrinsics.checkNotNullParameter(marksOfferUsed, "marksOfferUsed");
        Intrinsics.checkNotNullParameter(otherOptionsSheet, "otherOptionsSheet");
        this.f113331a = placement;
        this.f113332b = layout;
        this.f113333c = copy;
        this.f113334d = close;
        this.f113335e = analytics;
        this.f113336f = chrome;
        this.f113337g = viewModel;
        this.f113338h = onOpen;
        this.f113339i = marksOfferUsed;
        this.f113340j = otherOptionsSheet;
        this.f113341k = z2;
        this.f113342l = z3;
        this.f113343m = z4;
        this.f113344n = z5;
        this.f113345o = z6;
        this.f113346p = z7;
        this.f113347q = z8;
        this.f113348r = z9;
        this.f113349s = z10;
    }

    public final PaywallAnalytics a() {
        return this.f113335e;
    }

    public final boolean b() {
        return this.f113346p;
    }

    public final PaywallChrome c() {
        return this.f113336f;
    }

    public final CloseBehaviour d() {
        return this.f113334d;
    }

    public final PaywallCopy e() {
        return this.f113333c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallSpec)) {
            return false;
        }
        PaywallSpec paywallSpec = (PaywallSpec) obj;
        return this.f113331a == paywallSpec.f113331a && Intrinsics.areEqual(this.f113332b, paywallSpec.f113332b) && Intrinsics.areEqual(this.f113333c, paywallSpec.f113333c) && this.f113334d == paywallSpec.f113334d && Intrinsics.areEqual(this.f113335e, paywallSpec.f113335e) && Intrinsics.areEqual(this.f113336f, paywallSpec.f113336f) && this.f113337g == paywallSpec.f113337g && this.f113338h == paywallSpec.f113338h && this.f113339i == paywallSpec.f113339i && this.f113340j == paywallSpec.f113340j && this.f113341k == paywallSpec.f113341k && this.f113342l == paywallSpec.f113342l && this.f113343m == paywallSpec.f113343m && this.f113344n == paywallSpec.f113344n && this.f113345o == paywallSpec.f113345o && this.f113346p == paywallSpec.f113346p && this.f113347q == paywallSpec.f113347q && this.f113348r == paywallSpec.f113348r && this.f113349s == paywallSpec.f113349s;
    }

    public final boolean f() {
        return this.f113345o;
    }

    public final boolean g() {
        return this.f113342l;
    }

    public final boolean h() {
        return this.f113343m;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.f113331a.hashCode() * 31) + this.f113332b.hashCode()) * 31) + this.f113333c.hashCode()) * 31) + this.f113334d.hashCode()) * 31) + this.f113335e.hashCode()) * 31) + this.f113336f.hashCode()) * 31) + this.f113337g.hashCode()) * 31) + this.f113338h.hashCode()) * 31) + this.f113339i.hashCode()) * 31) + this.f113340j.hashCode()) * 31) + Boolean.hashCode(this.f113341k)) * 31) + Boolean.hashCode(this.f113342l)) * 31) + Boolean.hashCode(this.f113343m)) * 31) + Boolean.hashCode(this.f113344n)) * 31) + Boolean.hashCode(this.f113345o)) * 31) + Boolean.hashCode(this.f113346p)) * 31) + Boolean.hashCode(this.f113347q)) * 31) + Boolean.hashCode(this.f113348r)) * 31) + Boolean.hashCode(this.f113349s);
    }

    public final PaywallLayout i() {
        return this.f113332b;
    }

    public final OfferUsedMarker j() {
        return this.f113339i;
    }

    public final PaywallOnOpen k() {
        return this.f113338h;
    }

    public final boolean l() {
        return this.f113344n;
    }

    public final OtherOptionsSheet m() {
        return this.f113340j;
    }

    public final RevenueCatPlacement n() {
        return this.f113331a;
    }

    public final boolean o() {
        return this.f113348r;
    }

    public final boolean p() {
        return this.f113347q;
    }

    public final boolean q() {
        return this.f113341k;
    }

    public final boolean r() {
        return this.f113349s;
    }

    public final PaywallViewModelKind s() {
        return this.f113337g;
    }

    public String toString() {
        return "PaywallSpec(placement=" + this.f113331a + ", layout=" + this.f113332b + ", copy=" + this.f113333c + ", close=" + this.f113334d + ", analytics=" + this.f113335e + ", chrome=" + this.f113336f + ", viewModel=" + this.f113337g + ", onOpen=" + this.f113338h + ", marksOfferUsed=" + this.f113339i + ", otherOptionsSheet=" + this.f113340j + ", showsAllOptionsInSheet=" + this.f113341k + ", ignoresPassLock=" + this.f113342l + ", launchesInOwnTask=" + this.f113343m + ", opensDashboardAfterPurchase=" + this.f113344n + ", honoursOnboardingVariant=" + this.f113345o + ", canUseSuperwall=" + this.f113346p + ", removesTask=" + this.f113347q + ", preselectActiveOption=" + this.f113348r + ", useIntroTrialToggleVariants=" + this.f113349s + ")";
    }

    public /* synthetic */ PaywallSpec(RevenueCatPlacement revenueCatPlacement, PaywallLayout paywallLayout, PaywallCopy paywallCopy, CloseBehaviour closeBehaviour, PaywallAnalytics paywallAnalytics, PaywallChrome paywallChrome, PaywallViewModelKind paywallViewModelKind, PaywallOnOpen paywallOnOpen, OfferUsedMarker offerUsedMarker, OtherOptionsSheet otherOptionsSheet, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(revenueCatPlacement, paywallLayout, paywallCopy, closeBehaviour, paywallAnalytics, (i3 & 32) != 0 ? new PaywallChrome(null, null, null, false, false, 31, null) : paywallChrome, (i3 & 64) != 0 ? PaywallViewModelKind.Plain : paywallViewModelKind, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaywallOnOpen.Nothing : paywallOnOpen, (i3 & Function.MAX_NARGS) != 0 ? OfferUsedMarker.Nothing : offerUsedMarker, (i3 & 512) != 0 ? OtherOptionsSheet.Standard : otherOptionsSheet, (i3 & 1024) != 0 ? false : z2, (i3 & 2048) != 0 ? false : z3, (i3 & 4096) != 0 ? false : z4, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z5, (i3 & 16384) != 0 ? false : z6, (32768 & i3) != 0 ? true : z7, (65536 & i3) != 0 ? false : z8, (131072 & i3) != 0 ? false : z9, (i3 & 262144) != 0 ? false : z10);
    }
}

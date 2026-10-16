package cz.mobilesoft.coreblock.scene.premium;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.LoginAfterPurchase;
import cz.mobilesoft.coreblock.enums.Review;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOfferSelectionType;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.storage.datastore.entity.IntroTrialToggleScreenType;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
public final class PremiumScreenViewState implements ViewState {
    private final IntroTrialToggleScreenType A;
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final boolean F;
    private final boolean G;
    private final boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PremiumScreenTypeViewState f112492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewModelState f112493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewModelState f112494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f112495d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewModelState f112496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PremiumOfferSelectionType f112497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Offering f112498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImmutableList f112499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Long f112500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f112501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f112502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PurchaseSuccessDTO f112503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f112504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f112505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f112506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f112507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f112508r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f112509s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final PremiumOptionDTO f112510t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final PremiumOptionDTO f112511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final PremiumOptionDTO f112512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final LoginAfterPurchase f112513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final boolean f112514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final boolean f112515y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f112516z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PremiumScreenTypeViewState {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f112517i = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f112518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f112519b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f112521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Integer f112522e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f112524g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f112525h;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f112520c = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f112523f = Review.Companion.d();

        public Integer a() {
            return this.f112522e;
        }

        public Integer b() {
            return this.f112518a;
        }

        public boolean c() {
            return this.f112520c;
        }

        public String d(boolean z2) {
            return null;
        }

        public List e() {
            return this.f112523f;
        }

        public boolean f() {
            return this.f112525h;
        }

        public boolean g() {
            return this.f112519b;
        }

        public boolean h() {
            return this.f112524g;
        }

        public boolean i() {
            return this.f112521d;
        }
    }

    public PremiumScreenViewState(PremiumScreenTypeViewState premiumScreenTypeViewState, ViewModelState billingState, ViewModelState optionsState, String str, ViewModelState viewModelState, PremiumOfferSelectionType optionSelectionType, Offering offering, ImmutableList options, Long l3, boolean z2, boolean z3, PurchaseSuccessDTO purchaseSuccessDTO, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, PremiumOptionDTO premiumOptionDTO3, LoginAfterPurchase loginAfterPurchase, boolean z10, boolean z11, boolean z12, IntroTrialToggleScreenType introTrialToggleScreenType, String str2, String str3, String str4, String str5, boolean z13, boolean z14, boolean z15) {
        Intrinsics.checkNotNullParameter(premiumScreenTypeViewState, "premiumScreenTypeViewState");
        Intrinsics.checkNotNullParameter(billingState, "billingState");
        Intrinsics.checkNotNullParameter(optionsState, "optionsState");
        Intrinsics.checkNotNullParameter(optionSelectionType, "optionSelectionType");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(loginAfterPurchase, "loginAfterPurchase");
        Intrinsics.checkNotNullParameter(introTrialToggleScreenType, "introTrialToggleScreenType");
        this.f112492a = premiumScreenTypeViewState;
        this.f112493b = billingState;
        this.f112494c = optionsState;
        this.f112495d = str;
        this.f112496f = viewModelState;
        this.f112497g = optionSelectionType;
        this.f112498h = offering;
        this.f112499i = options;
        this.f112500j = l3;
        this.f112501k = z2;
        this.f112502l = z3;
        this.f112503m = purchaseSuccessDTO;
        this.f112504n = z4;
        this.f112505o = z5;
        this.f112506p = z6;
        this.f112507q = z7;
        this.f112508r = z8;
        this.f112509s = z9;
        this.f112510t = premiumOptionDTO;
        this.f112511u = premiumOptionDTO2;
        this.f112512v = premiumOptionDTO3;
        this.f112513w = loginAfterPurchase;
        this.f112514x = z10;
        this.f112515y = z11;
        this.f112516z = z12;
        this.A = introTrialToggleScreenType;
        this.B = str2;
        this.C = str3;
        this.D = str4;
        this.E = str5;
        this.F = z13;
        this.G = z14;
        this.H = z15;
    }

    private final boolean L() {
        return this.f112492a.i();
    }

    private final boolean T(Context context) {
        if (E()) {
            return !NetworkHelperKt.b(context) || o();
        }
        return false;
    }

    public static /* synthetic */ PremiumScreenViewState b(PremiumScreenViewState premiumScreenViewState, PremiumScreenTypeViewState premiumScreenTypeViewState, ViewModelState viewModelState, ViewModelState viewModelState2, String str, ViewModelState viewModelState3, PremiumOfferSelectionType premiumOfferSelectionType, Offering offering, ImmutableList immutableList, Long l3, boolean z2, boolean z3, PurchaseSuccessDTO purchaseSuccessDTO, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, PremiumOptionDTO premiumOptionDTO3, LoginAfterPurchase loginAfterPurchase, boolean z10, boolean z11, boolean z12, IntroTrialToggleScreenType introTrialToggleScreenType, String str2, String str3, String str4, String str5, boolean z13, boolean z14, boolean z15, int i3, int i4, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        PremiumOptionDTO premiumOptionDTO4;
        PremiumOptionDTO premiumOptionDTO5;
        PremiumOptionDTO premiumOptionDTO6;
        LoginAfterPurchase loginAfterPurchase2;
        boolean z20;
        boolean z21;
        boolean z22;
        IntroTrialToggleScreenType introTrialToggleScreenType2;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z23;
        boolean z24;
        ViewModelState viewModelState4;
        ViewModelState viewModelState5;
        String str10;
        ViewModelState viewModelState6;
        PremiumOfferSelectionType premiumOfferSelectionType2;
        Offering offering2;
        ImmutableList immutableList2;
        Long l4;
        boolean z25;
        boolean z26;
        PurchaseSuccessDTO purchaseSuccessDTO2;
        boolean z27;
        boolean z28;
        boolean z29;
        PremiumScreenTypeViewState premiumScreenTypeViewState2 = (i3 & 1) != 0 ? premiumScreenViewState.f112492a : premiumScreenTypeViewState;
        ViewModelState viewModelState7 = (i3 & 2) != 0 ? premiumScreenViewState.f112493b : viewModelState;
        ViewModelState viewModelState8 = (i3 & 4) != 0 ? premiumScreenViewState.f112494c : viewModelState2;
        String str11 = (i3 & 8) != 0 ? premiumScreenViewState.f112495d : str;
        ViewModelState viewModelState9 = (i3 & 16) != 0 ? premiumScreenViewState.f112496f : viewModelState3;
        PremiumOfferSelectionType premiumOfferSelectionType3 = (i3 & 32) != 0 ? premiumScreenViewState.f112497g : premiumOfferSelectionType;
        Offering offering3 = (i3 & 64) != 0 ? premiumScreenViewState.f112498h : offering;
        ImmutableList immutableList3 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? premiumScreenViewState.f112499i : immutableList;
        Long l5 = (i3 & Function.MAX_NARGS) != 0 ? premiumScreenViewState.f112500j : l3;
        boolean z30 = (i3 & 512) != 0 ? premiumScreenViewState.f112501k : z2;
        boolean z31 = (i3 & 1024) != 0 ? premiumScreenViewState.f112502l : z3;
        PurchaseSuccessDTO purchaseSuccessDTO3 = (i3 & 2048) != 0 ? premiumScreenViewState.f112503m : purchaseSuccessDTO;
        boolean z32 = (i3 & 4096) != 0 ? premiumScreenViewState.f112504n : z4;
        boolean z33 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? premiumScreenViewState.f112505o : z5;
        PremiumScreenTypeViewState premiumScreenTypeViewState3 = premiumScreenTypeViewState2;
        boolean z34 = (i3 & 16384) != 0 ? premiumScreenViewState.f112506p : z6;
        boolean z35 = (i3 & 32768) != 0 ? premiumScreenViewState.f112507q : z7;
        boolean z36 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? premiumScreenViewState.f112508r : z8;
        boolean z37 = (i3 & 131072) != 0 ? premiumScreenViewState.f112509s : z9;
        PremiumOptionDTO premiumOptionDTO7 = (i3 & 262144) != 0 ? premiumScreenViewState.f112510t : premiumOptionDTO;
        PremiumOptionDTO premiumOptionDTO8 = (i3 & 524288) != 0 ? premiumScreenViewState.f112511u : premiumOptionDTO2;
        PremiumOptionDTO premiumOptionDTO9 = (i3 & 1048576) != 0 ? premiumScreenViewState.f112512v : premiumOptionDTO3;
        LoginAfterPurchase loginAfterPurchase3 = (i3 & 2097152) != 0 ? premiumScreenViewState.f112513w : loginAfterPurchase;
        boolean z38 = (i3 & 4194304) != 0 ? premiumScreenViewState.f112514x : z10;
        boolean z39 = (i3 & 8388608) != 0 ? premiumScreenViewState.f112515y : z11;
        boolean z40 = (i3 & 16777216) != 0 ? premiumScreenViewState.f112516z : z12;
        IntroTrialToggleScreenType introTrialToggleScreenType3 = (i3 & 33554432) != 0 ? premiumScreenViewState.A : introTrialToggleScreenType;
        String str12 = (i3 & 67108864) != 0 ? premiumScreenViewState.B : str2;
        String str13 = (i3 & 134217728) != 0 ? premiumScreenViewState.C : str3;
        String str14 = (i3 & 268435456) != 0 ? premiumScreenViewState.D : str4;
        String str15 = (i3 & 536870912) != 0 ? premiumScreenViewState.E : str5;
        boolean z41 = (i3 & 1073741824) != 0 ? premiumScreenViewState.F : z13;
        boolean z42 = (i3 & Integer.MIN_VALUE) != 0 ? premiumScreenViewState.G : z14;
        if ((i4 & 1) != 0) {
            z17 = z42;
            z16 = premiumScreenViewState.H;
            z19 = z37;
            premiumOptionDTO4 = premiumOptionDTO7;
            premiumOptionDTO5 = premiumOptionDTO8;
            premiumOptionDTO6 = premiumOptionDTO9;
            loginAfterPurchase2 = loginAfterPurchase3;
            z20 = z38;
            z21 = z39;
            z22 = z40;
            introTrialToggleScreenType2 = introTrialToggleScreenType3;
            str6 = str12;
            str7 = str13;
            str8 = str14;
            str9 = str15;
            z23 = z41;
            z24 = z34;
            viewModelState5 = viewModelState8;
            str10 = str11;
            viewModelState6 = viewModelState9;
            premiumOfferSelectionType2 = premiumOfferSelectionType3;
            offering2 = offering3;
            immutableList2 = immutableList3;
            l4 = l5;
            z25 = z30;
            z26 = z31;
            purchaseSuccessDTO2 = purchaseSuccessDTO3;
            z27 = z32;
            z28 = z33;
            z29 = z35;
            z18 = z36;
            viewModelState4 = viewModelState7;
        } else {
            z16 = z15;
            z17 = z42;
            z18 = z36;
            z19 = z37;
            premiumOptionDTO4 = premiumOptionDTO7;
            premiumOptionDTO5 = premiumOptionDTO8;
            premiumOptionDTO6 = premiumOptionDTO9;
            loginAfterPurchase2 = loginAfterPurchase3;
            z20 = z38;
            z21 = z39;
            z22 = z40;
            introTrialToggleScreenType2 = introTrialToggleScreenType3;
            str6 = str12;
            str7 = str13;
            str8 = str14;
            str9 = str15;
            z23 = z41;
            z24 = z34;
            viewModelState4 = viewModelState7;
            viewModelState5 = viewModelState8;
            str10 = str11;
            viewModelState6 = viewModelState9;
            premiumOfferSelectionType2 = premiumOfferSelectionType3;
            offering2 = offering3;
            immutableList2 = immutableList3;
            l4 = l5;
            z25 = z30;
            z26 = z31;
            purchaseSuccessDTO2 = purchaseSuccessDTO3;
            z27 = z32;
            z28 = z33;
            z29 = z35;
        }
        return premiumScreenViewState.a(premiumScreenTypeViewState3, viewModelState4, viewModelState5, str10, viewModelState6, premiumOfferSelectionType2, offering2, immutableList2, l4, z25, z26, purchaseSuccessDTO2, z27, z28, z24, z29, z18, z19, premiumOptionDTO4, premiumOptionDTO5, premiumOptionDTO6, loginAfterPurchase2, z20, z21, z22, introTrialToggleScreenType2, str6, str7, str8, str9, z23, z17, z16);
    }

    private final List j() {
        List listListOf = CollectionsKt.listOf((Object[]) new ViewModelState[]{this.f112494c, this.f112493b});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (obj instanceof FailedWithError) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean o() {
        List listJ = j();
        if ((listJ instanceof Collection) && listJ.isEmpty()) {
            return false;
        }
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            Throwable thA = ((FailedWithError) it.next()).a();
            PurchasesException purchasesException = thA instanceof PurchasesException ? (PurchasesException) thA : null;
            if ((purchasesException != null ? purchasesException.getCode() : null) == PurchasesErrorCode.NetworkError) {
                return true;
            }
        }
        return false;
    }

    public final String A() {
        return this.D;
    }

    public final Long B() {
        return this.f112500j;
    }

    public final List C() {
        return this.f112492a.e();
    }

    public final PremiumOptionDTO D() {
        return this.f112510t;
    }

    public final boolean E() {
        return (this.f112494c instanceof FailedWithError) || (this.f112493b instanceof FailedWithError);
    }

    public final boolean F() {
        return this.f112504n;
    }

    public final boolean G() {
        return (E() || H()) ? false : true;
    }

    public final boolean H() {
        boolean zG = this.f112492a.g();
        if ((this.f112494c instanceof Loading) || (this.f112493b instanceof Loading)) {
            return zG || this.f112502l;
        }
        return false;
    }

    public final boolean I() {
        return this.f112515y;
    }

    public final boolean J() {
        return this.f112506p;
    }

    public final boolean K() {
        return this.f112505o;
    }

    public final boolean M() {
        return Y() && this.f112492a.h();
    }

    public final boolean N() {
        return this.f112507q;
    }

    public final String O() {
        return this.C;
    }

    public final String P() {
        return this.B;
    }

    public final int Q() {
        PremiumOptionDTO premiumOptionDTO = this.f112510t;
        if (premiumOptionDTO != null) {
            return premiumOptionDTO.m();
        }
        return 7;
    }

    public final boolean R() {
        return this.f112514x;
    }

    public final boolean S() {
        return this.f112509s;
    }

    public final boolean U() {
        return m() || L();
    }

    public final boolean V() {
        return this.H;
    }

    public final boolean W() {
        return this.f112516z;
    }

    public final boolean X() {
        return this.f112501k;
    }

    public final boolean Y() {
        ImmutableList immutableList = this.f112499i;
        if (immutableList == null || !immutableList.isEmpty()) {
            Iterator<E> it = immutableList.iterator();
            while (it.hasNext()) {
                if (((PremiumOptionDTO) it.next()).n() != null) {
                    return true;
                }
            }
        }
        return this.G;
    }

    public final boolean Z() {
        PremiumOptionDTO premiumOptionDTO = this.f112510t;
        return (premiumOptionDTO != null ? premiumOptionDTO.n() : null) != null;
    }

    public final PremiumScreenViewState a(PremiumScreenTypeViewState premiumScreenTypeViewState, ViewModelState billingState, ViewModelState optionsState, String str, ViewModelState viewModelState, PremiumOfferSelectionType optionSelectionType, Offering offering, ImmutableList options, Long l3, boolean z2, boolean z3, PurchaseSuccessDTO purchaseSuccessDTO, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, PremiumOptionDTO premiumOptionDTO3, LoginAfterPurchase loginAfterPurchase, boolean z10, boolean z11, boolean z12, IntroTrialToggleScreenType introTrialToggleScreenType, String str2, String str3, String str4, String str5, boolean z13, boolean z14, boolean z15) {
        Intrinsics.checkNotNullParameter(premiumScreenTypeViewState, "premiumScreenTypeViewState");
        Intrinsics.checkNotNullParameter(billingState, "billingState");
        Intrinsics.checkNotNullParameter(optionsState, "optionsState");
        Intrinsics.checkNotNullParameter(optionSelectionType, "optionSelectionType");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(loginAfterPurchase, "loginAfterPurchase");
        Intrinsics.checkNotNullParameter(introTrialToggleScreenType, "introTrialToggleScreenType");
        return new PremiumScreenViewState(premiumScreenTypeViewState, billingState, optionsState, str, viewModelState, optionSelectionType, offering, options, l3, z2, z3, purchaseSuccessDTO, z4, z5, z6, z7, z8, z9, premiumOptionDTO, premiumOptionDTO2, premiumOptionDTO3, loginAfterPurchase, z10, z11, z12, introTrialToggleScreenType, str2, str3, str4, str5, z13, z14, z15);
    }

    public final ViewModelState c() {
        return this.f112493b;
    }

    public final String d(Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Integer numB = this.f112492a.b();
        if (Z()) {
            string = context.getString(R.string.cA, Integer.valueOf(Q()));
        } else if (numB != null) {
            string = context.getString(numB.intValue());
        } else {
            PremiumOptionDTO premiumOptionDTO = this.f112510t;
            string = (premiumOptionDTO != null ? premiumOptionDTO.j() : null) == PremiumOptionPeriod.Lifetime ? context.getString(R.string.Pq) : context.getString(R.string.cC);
        }
        Intrinsics.checkNotNull(string);
        return StringHelperExtKt.t(context, this.f112492a.d(Z()), string);
    }

    public final ViewModelState e() {
        return this.f112496f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PremiumScreenViewState)) {
            return false;
        }
        PremiumScreenViewState premiumScreenViewState = (PremiumScreenViewState) obj;
        return Intrinsics.areEqual(this.f112492a, premiumScreenViewState.f112492a) && Intrinsics.areEqual(this.f112493b, premiumScreenViewState.f112493b) && Intrinsics.areEqual(this.f112494c, premiumScreenViewState.f112494c) && Intrinsics.areEqual(this.f112495d, premiumScreenViewState.f112495d) && Intrinsics.areEqual(this.f112496f, premiumScreenViewState.f112496f) && this.f112497g == premiumScreenViewState.f112497g && Intrinsics.areEqual(this.f112498h, premiumScreenViewState.f112498h) && Intrinsics.areEqual(this.f112499i, premiumScreenViewState.f112499i) && Intrinsics.areEqual(this.f112500j, premiumScreenViewState.f112500j) && this.f112501k == premiumScreenViewState.f112501k && this.f112502l == premiumScreenViewState.f112502l && Intrinsics.areEqual(this.f112503m, premiumScreenViewState.f112503m) && this.f112504n == premiumScreenViewState.f112504n && this.f112505o == premiumScreenViewState.f112505o && this.f112506p == premiumScreenViewState.f112506p && this.f112507q == premiumScreenViewState.f112507q && this.f112508r == premiumScreenViewState.f112508r && this.f112509s == premiumScreenViewState.f112509s && Intrinsics.areEqual(this.f112510t, premiumScreenViewState.f112510t) && Intrinsics.areEqual(this.f112511u, premiumScreenViewState.f112511u) && Intrinsics.areEqual(this.f112512v, premiumScreenViewState.f112512v) && this.f112513w == premiumScreenViewState.f112513w && this.f112514x == premiumScreenViewState.f112514x && this.f112515y == premiumScreenViewState.f112515y && this.f112516z == premiumScreenViewState.f112516z && this.A == premiumScreenViewState.A && Intrinsics.areEqual(this.B, premiumScreenViewState.B) && Intrinsics.areEqual(this.C, premiumScreenViewState.C) && Intrinsics.areEqual(this.D, premiumScreenViewState.D) && Intrinsics.areEqual(this.E, premiumScreenViewState.E) && this.F == premiumScreenViewState.F && this.G == premiumScreenViewState.G && this.H == premiumScreenViewState.H;
    }

    public final boolean f() {
        PremiumOptionDTO premiumOptionDTO = this.f112512v;
        if ((premiumOptionDTO != null ? premiumOptionDTO.j() : null) == PremiumOptionPeriod.Yearly) {
            return true;
        }
        PremiumOptionDTO premiumOptionDTO2 = this.f112512v;
        return (premiumOptionDTO2 != null ? premiumOptionDTO2.j() : null) == PremiumOptionPeriod.Monthly;
    }

    public final Integer g() {
        return this.f112492a.a();
    }

    public final PremiumOptionDTO h() {
        return this.f112511u;
    }

    public int hashCode() {
        int iHashCode = ((((this.f112492a.hashCode() * 31) + this.f112493b.hashCode()) * 31) + this.f112494c.hashCode()) * 31;
        String str = this.f112495d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ViewModelState viewModelState = this.f112496f;
        int iHashCode3 = (((iHashCode2 + (viewModelState == null ? 0 : viewModelState.hashCode())) * 31) + this.f112497g.hashCode()) * 31;
        Offering offering = this.f112498h;
        int iHashCode4 = (((iHashCode3 + (offering == null ? 0 : offering.hashCode())) * 31) + this.f112499i.hashCode()) * 31;
        Long l3 = this.f112500j;
        int iHashCode5 = (((((iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f112501k)) * 31) + Boolean.hashCode(this.f112502l)) * 31;
        PurchaseSuccessDTO purchaseSuccessDTO = this.f112503m;
        int iHashCode6 = (((((((((((((iHashCode5 + (purchaseSuccessDTO == null ? 0 : purchaseSuccessDTO.hashCode())) * 31) + Boolean.hashCode(this.f112504n)) * 31) + Boolean.hashCode(this.f112505o)) * 31) + Boolean.hashCode(this.f112506p)) * 31) + Boolean.hashCode(this.f112507q)) * 31) + Boolean.hashCode(this.f112508r)) * 31) + Boolean.hashCode(this.f112509s)) * 31;
        PremiumOptionDTO premiumOptionDTO = this.f112510t;
        int iHashCode7 = (iHashCode6 + (premiumOptionDTO == null ? 0 : premiumOptionDTO.hashCode())) * 31;
        PremiumOptionDTO premiumOptionDTO2 = this.f112511u;
        int iHashCode8 = (iHashCode7 + (premiumOptionDTO2 == null ? 0 : premiumOptionDTO2.hashCode())) * 31;
        PremiumOptionDTO premiumOptionDTO3 = this.f112512v;
        int iHashCode9 = (((((((((((iHashCode8 + (premiumOptionDTO3 == null ? 0 : premiumOptionDTO3.hashCode())) * 31) + this.f112513w.hashCode()) * 31) + Boolean.hashCode(this.f112514x)) * 31) + Boolean.hashCode(this.f112515y)) * 31) + Boolean.hashCode(this.f112516z)) * 31) + this.A.hashCode()) * 31;
        String str2 = this.B;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.C;
        int iHashCode11 = (iHashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.D;
        int iHashCode12 = (iHashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.E;
        return ((((((iHashCode12 + (str5 != null ? str5.hashCode() : 0)) * 31) + Boolean.hashCode(this.F)) * 31) + Boolean.hashCode(this.G)) * 31) + Boolean.hashCode(this.H);
    }

    public final String i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.f112495d;
        if (str != null) {
            return str;
        }
        if (T(context)) {
            return context.getString(R.string.Wk);
        }
        return null;
    }

    public final String k(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (T(context)) {
            return context.getString(R.string.Vk);
        }
        return null;
    }

    public final List l() {
        PremiumOptionDTO premiumOptionDTO = this.f112512v;
        if (premiumOptionDTO == null) {
            return this.f112499i;
        }
        if (premiumOptionDTO.j() != PremiumOptionPeriod.Monthly) {
            return CollectionsKt.listOf(this.f112512v);
        }
        ImmutableList immutableList = this.f112499i;
        ArrayList arrayList = new ArrayList();
        for (Object obj : immutableList) {
            if (((PremiumOptionDTO) obj).j() != PremiumOptionPeriod.Lifetime) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean m() {
        if (!this.f112492a.i() && E() && this.f112502l) {
            return true;
        }
        return this.f112492a.c();
    }

    public final boolean n() {
        return this.F;
    }

    public final boolean p() {
        return this.f112508r;
    }

    public final IntroTrialToggleScreenType q() {
        return this.A;
    }

    public final LoginAfterPurchase r() {
        return this.f112513w;
    }

    public final Offering s() {
        return this.f112498h;
    }

    public final PremiumOfferSelectionType t() {
        return this.f112497g;
    }

    public String toString() {
        return "PremiumScreenViewState(premiumScreenTypeViewState=" + this.f112492a + ", billingState=" + this.f112493b + ", optionsState=" + this.f112494c + ", purchasesState=" + this.f112495d + ", campaignState=" + this.f112496f + ", optionSelectionType=" + this.f112497g + ", offering=" + this.f112498h + ", options=" + this.f112499i + ", remainingDiscountCountdownMillis=" + this.f112500j + ", isPurchasePending=" + this.f112501k + ", wasRetryClicked=" + this.f112502l + ", purchaseSuccessDTO=" + this.f112503m + ", showForFirstYearText=" + this.f112504n + ", showRatingAfterTrialStarted=" + this.f112505o + ", showRatingAfterPurchase=" + this.f112506p + ", showYearlyPaymentMonthly=" + this.f112507q + ", hidePurchaseDisclaimer=" + this.f112508r + ", withPaywall=" + this.f112509s + ", selectedOption=" + this.f112510t + ", defaultOption=" + this.f112511u + ", activeOption=" + this.f112512v + ", loginAfterPurchase=" + this.f112513w + ", useSubscriptionOnboarding=" + this.f112514x + ", showOnboardingGuestPassShare=" + this.f112515y + ", isOfferTrialEndCalendarShown=" + this.f112516z + ", introTrialToggleScreenType=" + this.A + ", title=" + this.B + ", subtitle=" + this.C + ", rcPaywallTitle=" + this.D + ", rcPaywallSubtitle=" + this.E + ", hasNonTrialPremium=" + this.F + ", fromDevMenu=" + this.G + ", isHardPaywall=" + this.H + ")";
    }

    public final ImmutableList u() {
        return this.f112499i;
    }

    public final ViewModelState v() {
        return this.f112494c;
    }

    public final ImmutableList w() {
        if (this.f112492a.f()) {
            return this.f112499i;
        }
        PremiumOptionDTO premiumOptionDTO = this.f112512v;
        if (premiumOptionDTO == null) {
            ImmutableList immutableList = this.f112499i;
            ArrayList arrayList = new ArrayList();
            for (Object obj : immutableList) {
                if (!Intrinsics.areEqual((PremiumOptionDTO) obj, this.f112511u)) {
                    arrayList.add(obj);
                }
            }
            return ExtensionsKt.h(arrayList);
        }
        if (premiumOptionDTO.j() != PremiumOptionPeriod.Monthly) {
            return ExtensionsKt.a();
        }
        ImmutableList immutableList2 = this.f112499i;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : immutableList2) {
            if (((PremiumOptionDTO) obj2).j() == PremiumOptionPeriod.Yearly) {
                arrayList2.add(obj2);
            }
        }
        return ExtensionsKt.h(arrayList2);
    }

    public final PremiumScreenTypeViewState x() {
        return this.f112492a;
    }

    public final PurchaseSuccessDTO y() {
        return this.f112503m;
    }

    public final String z() {
        return this.E;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PremiumScreenViewState(PremiumScreenTypeViewState premiumScreenTypeViewState, ViewModelState viewModelState, ViewModelState viewModelState2, String str, ViewModelState viewModelState3, PremiumOfferSelectionType premiumOfferSelectionType, Offering offering, ImmutableList immutableList, Long l3, boolean z2, boolean z3, PurchaseSuccessDTO purchaseSuccessDTO, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, PremiumOptionDTO premiumOptionDTO3, LoginAfterPurchase loginAfterPurchase, boolean z10, boolean z11, boolean z12, IntroTrialToggleScreenType introTrialToggleScreenType, String str2, String str3, String str4, String str5, boolean z13, boolean z14, boolean z15, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        ViewModelState viewModelState4 = (i3 & 2) != 0 ? Loading.f127895a : viewModelState;
        ViewModelState viewModelState5 = (i3 & 4) != 0 ? Loading.f127895a : viewModelState2;
        String str6 = (i3 & 8) != 0 ? null : str;
        ViewModelState viewModelState6 = (i3 & 16) != 0 ? null : viewModelState3;
        PremiumOfferSelectionType premiumOfferSelectionType2 = (i3 & 32) != 0 ? PremiumOfferSelectionType.Selection : premiumOfferSelectionType;
        Offering offering2 = (i3 & 64) != 0 ? null : offering;
        ImmutableList immutableListA = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ExtensionsKt.a() : immutableList;
        this(premiumScreenTypeViewState, viewModelState4, viewModelState5, str6, viewModelState6, premiumOfferSelectionType2, offering2, immutableListA, (i3 & Function.MAX_NARGS) != 0 ? null : l3, (i3 & 512) != 0 ? true : z2, (i3 & 1024) != 0 ? false : z3, (i3 & 2048) != 0 ? null : purchaseSuccessDTO, (i3 & 4096) != 0 ? false : z4, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z5, (i3 & 16384) != 0 ? false : z6, (i3 & 32768) != 0 ? false : z7, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? false : z8, (i3 & 131072) != 0 ? false : z9, (i3 & 262144) != 0 ? (PremiumOptionDTO) CollectionsKt.firstOrNull((List) immutableListA) : premiumOptionDTO, (i3 & 524288) != 0 ? null : premiumOptionDTO2, (i3 & 1048576) != 0 ? null : premiumOptionDTO3, (i3 & 2097152) != 0 ? LoginAfterPurchase.None : loginAfterPurchase, (i3 & 4194304) != 0 ? false : z10, (i3 & 8388608) != 0 ? false : z11, (i3 & 16777216) != 0 ? false : z12, (i3 & 33554432) != 0 ? IntroTrialToggleScreenType.TrialNoToggle : introTrialToggleScreenType, (i3 & 67108864) != 0 ? null : str2, (i3 & 134217728) != 0 ? null : str3, (i3 & 268435456) != 0 ? null : str4, (i3 & 536870912) != 0 ? null : str5, (i3 & 1073741824) != 0 ? false : z13, (i3 & Integer.MIN_VALUE) != 0 ? false : z14, (i4 & 1) != 0 ? false : z15);
    }
}

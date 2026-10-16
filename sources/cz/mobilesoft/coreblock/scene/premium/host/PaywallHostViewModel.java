package cz.mobilesoft.coreblock.scene.premium.host;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
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
public abstract class PaywallHostViewModel extends PremiumScreenViewModel {
    public static final Companion X = new Companion(null);
    public static final int Y = 8;
    private final PaywallTarget Q;
    private final PaywallSpec R;
    private final Launch S;
    private final boolean T;
    private final boolean U;
    private final boolean V;
    private final Long W;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v0, types: [cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$Companion$screenTypeViewState$1] */
        public final PaywallHostViewModel$Companion$screenTypeViewState$1 b(final PaywallTarget paywallTarget, final PaywallSpec paywallSpec, final Launch launch) {
            return new PremiumScreenViewState.PremiumScreenTypeViewState(paywallTarget, launch) { // from class: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$Companion$screenTypeViewState$1

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final Integer f113296j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                private final Integer f113297k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                private final List f113298l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                private boolean f113299m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                private final boolean f113300n;

                /* JADX INFO: renamed from: o, reason: collision with root package name */
                private final boolean f113301o;

                /* JADX INFO: renamed from: p, reason: collision with root package name */
                private final boolean f113302p;

                /* JADX INFO: renamed from: q, reason: collision with root package name */
                private final boolean f113303q;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final /* synthetic */ class WhenMappings {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f113305a;

                    static {
                        int[] iArr = new int[RemoteButtonText.values().length];
                        try {
                            iArr[RemoteButtonText.None.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[RemoteButtonText.Discount.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[RemoteButtonText.PremiumScreen.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f113305a = iArr;
                    }
                }

                {
                    this.f113296j = this.f113304r.c().b();
                    this.f113297k = this.f113304r.c().a();
                    this.f113298l = PaywallSpecTableKt.X(paywallTarget);
                    this.f113299m = this.f113304r.q();
                    this.f113300n = this.f113304r.c().e();
                    this.f113301o = this.f113304r.c().d();
                    this.f113302p = launch.c();
                    this.f113303q = launch.d();
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public Integer a() {
                    return this.f113297k;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public Integer b() {
                    return this.f113296j;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public boolean c() {
                    return this.f113302p;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public String d(boolean z2) {
                    int i3 = WhenMappings.f113305a[this.f113304r.c().c().ordinal()];
                    if (i3 == 1) {
                        return null;
                    }
                    if (i3 == 2) {
                        return PrefManager.f126839a.M0();
                    }
                    if (i3 == 3) {
                        return z2 ? PrefManager.f126839a.P0() : PrefManager.f126839a.O0();
                    }
                    throw new NoWhenBranchMatchedException();
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public List e() {
                    return this.f113298l;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public boolean f() {
                    return this.f113299m;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public boolean g() {
                    return this.f113301o;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public boolean h() {
                    return this.f113300n;
                }

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public boolean i() {
                    return this.f113303q;
                }
            };
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Launch {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f113306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f113307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f113308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f113309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f113310e;

        public Launch(String entrances, String str, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(entrances, "entrances");
            this.f113306a = entrances;
            this.f113307b = str;
            this.f113308c = z2;
            this.f113309d = z3;
            this.f113310e = z4;
        }

        public final String a() {
            return this.f113306a;
        }

        public final String b() {
            return this.f113307b;
        }

        public final boolean c() {
            return this.f113308c;
        }

        public final boolean d() {
            return this.f113309d;
        }

        public final boolean e() {
            return this.f113310e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Launch)) {
                return false;
            }
            Launch launch = (Launch) obj;
            return Intrinsics.areEqual(this.f113306a, launch.f113306a) && Intrinsics.areEqual(this.f113307b, launch.f113307b) && this.f113308c == launch.f113308c && this.f113309d == launch.f113309d && this.f113310e == launch.f113310e;
        }

        public int hashCode() {
            int iHashCode = this.f113306a.hashCode() * 31;
            String str = this.f113307b;
            return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f113308c)) * 31) + Boolean.hashCode(this.f113309d)) * 31) + Boolean.hashCode(this.f113310e);
        }

        public String toString() {
            return "Launch(entrances=" + this.f113306a + ", entrancesDetail=" + this.f113307b + ", withCloseButton=" + this.f113308c + ", withSkipText=" + this.f113309d + ", isFirstStart=" + this.f113310e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113311a;

        static {
            int[] iArr = new int[PremiumOptionPeriod.values().length];
            try {
                iArr[PremiumOptionPeriod.Monthly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumOptionPeriod.Yearly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f113311a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallHostViewModel(Application application, PaywallTarget target, PaywallSpec spec, Launch launch) {
        super(application, X.b(target, spec, launch));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(launch, "launch");
        this.Q = target;
        this.R = spec;
        this.S = launch;
        this.T = spec.o();
        this.U = spec.r();
        boolean z2 = false;
        if (!(target instanceof PaywallTarget.Discount) ? !(target instanceof PaywallTarget.PromoCode) : !((PaywallTarget.Discount) target).isFromDeeplink()) {
            z2 = true;
        }
        this.V = z2;
        this.W = spec.a().b();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object D2(cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$experimentEngine$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$experimentEngine$1 r0 = (cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$experimentEngine$1) r0
            int r1 = r0.f113315d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f113315d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$experimentEngine$1 r0 = new cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$experimentEngine$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f113313b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f113315d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f113312a
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel r4 = (cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel) r4
            kotlin.ResultKt.b(r5)
            goto L5f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec r5 = r4.R
            boolean r5 = r5.f()
            if (r5 == 0) goto L66
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel$Launch r5 = r4.S
            boolean r5 = r5.e()
            if (r5 == 0) goto L66
            cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore r5 = r4.V1()
            kotlinx.coroutines.flow.Flow r5 = r5.y()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f113312a = r4
            r0.f113315d = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            cz.mobilesoft.coreblock.storage.datastore.entity.OnboardingPaywallVariant r5 = (cz.mobilesoft.coreblock.storage.datastore.entity.OnboardingPaywallVariant) r5
            cz.mobilesoft.coreblock.util.monetization.PaywallEngine r4 = cz.mobilesoft.coreblock.scene.premium.host.PaywallSpecKt.a(r5)
            return r4
        L66:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel.D2(cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence E2(PremiumOptionDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.f();
    }

    static /* synthetic */ Object I2(PaywallHostViewModel paywallHostViewModel, Continuation continuation) {
        return paywallHostViewModel.R.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState J2(PaywallTarget.IntroTrial introTrial, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, introTrial.getFromDevMenu(), false, Api.BaseClientBuilder.API_PRIORITY_OTHER, 1, null);
    }

    protected final Launch F2() {
        return this.S;
    }

    protected final PaywallSpec G2() {
        return this.R;
    }

    protected final PaywallTarget H2() {
        return this.Q;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected Object O1(Continuation continuation) {
        return D2(this, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.AnalyticsData Q1() {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel.Q1():cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$AnalyticsData");
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Long U1() {
        return this.W;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected boolean W1() {
        return this.T;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String Y1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.R.e().j().a(context, (PremiumScreenViewState) I0());
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String Z1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.R.e().k().a(context, (PremiumScreenViewState) I0());
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String a2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.R.e().l().a(context, (PremiumScreenViewState) I0());
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public boolean b2() {
        return this.V;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String c2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.R.e().m().a(context, (PremiumScreenViewState) I0());
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected boolean d2() {
        return this.U;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object h2(Continuation continuation) {
        return I2(this, continuation);
    }

    protected final void start() {
        f2();
        PaywallTarget paywallTarget = this.Q;
        final PaywallTarget.IntroTrial introTrial = paywallTarget instanceof PaywallTarget.IntroTrial ? (PaywallTarget.IntroTrial) paywallTarget : null;
        if (introTrial != null) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.host.t0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PaywallHostViewModel.J2(introTrial, (PremiumScreenViewState) obj);
                }
            });
        }
    }
}

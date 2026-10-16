package cz.mobilesoft.coreblock.scene.premium.superwall;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.LoginAfterPurchase;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class SuperwallPlacementViewState implements ViewState, Parcelable {
    public static final Parcelable.Creator<SuperwallPlacementViewState> CREATOR = new Creator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Step f113850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f113851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f113852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f113853d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f113854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f113855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f113856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f113857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f113858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LoginAfterPurchase f113859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f113860l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<SuperwallPlacementViewState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SuperwallPlacementViewState createFromParcel(Parcel parcel) {
            boolean z2;
            boolean z3;
            boolean z4;
            int i3;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            LoginAfterPurchase loginAfterPurchase;
            boolean z10;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Step stepValueOf = Step.valueOf(parcel.readString());
            boolean z11 = false;
            boolean z12 = true;
            if (parcel.readInt() != 0) {
                z2 = false;
                z11 = true;
            } else {
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z3 = true;
            } else {
                z3 = true;
                z12 = z2;
            }
            int i4 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z4 = z3;
                i3 = i4;
                z5 = z4;
            } else {
                z4 = z3;
                i3 = i4;
                z5 = z2;
            }
            if (parcel.readInt() != 0) {
                z6 = z4;
            } else {
                z6 = z4;
                z4 = z2;
            }
            if (parcel.readInt() != 0) {
                z7 = z6;
            } else {
                z7 = z6;
                z6 = z2;
            }
            if (parcel.readInt() != 0) {
                z8 = z7;
            } else {
                z8 = z7;
                z7 = z2;
            }
            if (parcel.readInt() != 0) {
                z9 = z8;
            } else {
                z9 = z8;
                z8 = z2;
            }
            LoginAfterPurchase loginAfterPurchaseValueOf = LoginAfterPurchase.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z10 = z9;
                loginAfterPurchase = loginAfterPurchaseValueOf;
            } else {
                loginAfterPurchase = loginAfterPurchaseValueOf;
                z10 = z2;
            }
            return new SuperwallPlacementViewState(stepValueOf, z11, z12, i3, z5, z4, z6, z7, z8, loginAfterPurchase, z10);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SuperwallPlacementViewState[] newArray(int i3) {
            return new SuperwallPlacementViewState[i3];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Step {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Step[] $VALUES;
        public static final Step Paywall = new Step("Paywall", 0);
        public static final Step SignIn = new Step("SignIn", 1);
        public static final Step TrialReminders = new Step("TrialReminders", 2);
        public static final Step SubscriptionOnboarding = new Step("SubscriptionOnboarding", 3);
        public static final Step GuestPassShare = new Step("GuestPassShare", 4);
        public static final Step Fallback = new Step("Fallback", 5);
        public static final Step FinishSuccess = new Step("FinishSuccess", 6);
        public static final Step FinishCanceled = new Step("FinishCanceled", 7);

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{Paywall, SignIn, TrialReminders, SubscriptionOnboarding, GuestPassShare, Fallback, FinishSuccess, FinishCanceled};
        }

        static {
            Step[] stepArr$values = $values();
            $VALUES = stepArr$values;
            $ENTRIES = EnumEntriesKt.a(stepArr$values);
        }

        private Step(String str, int i3) {
        }

        public static EnumEntries<Step> getEntries() {
            return $ENTRIES;
        }

        public static Step valueOf(String str) {
            return (Step) Enum.valueOf(Step.class, str);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    public SuperwallPlacementViewState(Step step, boolean z2, boolean z3, int i3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, LoginAfterPurchase loginAfterPurchase, boolean z9) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(loginAfterPurchase, "loginAfterPurchase");
        this.f113850a = step;
        this.f113851b = z2;
        this.f113852c = z3;
        this.f113853d = i3;
        this.f113854f = z4;
        this.f113855g = z5;
        this.f113856h = z6;
        this.f113857i = z7;
        this.f113858j = z8;
        this.f113859k = loginAfterPurchase;
        this.f113860l = z9;
    }

    public static /* synthetic */ SuperwallPlacementViewState c(SuperwallPlacementViewState superwallPlacementViewState, Step step, boolean z2, boolean z3, int i3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, LoginAfterPurchase loginAfterPurchase, boolean z9, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            step = superwallPlacementViewState.f113850a;
        }
        if ((i4 & 2) != 0) {
            z2 = superwallPlacementViewState.f113851b;
        }
        if ((i4 & 4) != 0) {
            z3 = superwallPlacementViewState.f113852c;
        }
        if ((i4 & 8) != 0) {
            i3 = superwallPlacementViewState.f113853d;
        }
        if ((i4 & 16) != 0) {
            z4 = superwallPlacementViewState.f113854f;
        }
        if ((i4 & 32) != 0) {
            z5 = superwallPlacementViewState.f113855g;
        }
        if ((i4 & 64) != 0) {
            z6 = superwallPlacementViewState.f113856h;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z7 = superwallPlacementViewState.f113857i;
        }
        if ((i4 & Function.MAX_NARGS) != 0) {
            z8 = superwallPlacementViewState.f113858j;
        }
        if ((i4 & 512) != 0) {
            loginAfterPurchase = superwallPlacementViewState.f113859k;
        }
        if ((i4 & 1024) != 0) {
            z9 = superwallPlacementViewState.f113860l;
        }
        LoginAfterPurchase loginAfterPurchase2 = loginAfterPurchase;
        boolean z10 = z9;
        boolean z11 = z7;
        boolean z12 = z8;
        boolean z13 = z5;
        boolean z14 = z6;
        boolean z15 = z4;
        boolean z16 = z3;
        return superwallPlacementViewState.a(step, z2, z16, i3, z15, z13, z14, z11, z12, loginAfterPurchase2, z10);
    }

    public final SuperwallPlacementViewState a(Step step, boolean z2, boolean z3, int i3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, LoginAfterPurchase loginAfterPurchase, boolean z9) {
        Intrinsics.checkNotNullParameter(step, "step");
        Intrinsics.checkNotNullParameter(loginAfterPurchase, "loginAfterPurchase");
        return new SuperwallPlacementViewState(step, z2, z3, i3, z4, z5, z6, z7, z8, loginAfterPurchase, z9);
    }

    public final boolean d() {
        return this.f113854f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final LoginAfterPurchase e() {
        return this.f113859k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperwallPlacementViewState)) {
            return false;
        }
        SuperwallPlacementViewState superwallPlacementViewState = (SuperwallPlacementViewState) obj;
        return this.f113850a == superwallPlacementViewState.f113850a && this.f113851b == superwallPlacementViewState.f113851b && this.f113852c == superwallPlacementViewState.f113852c && this.f113853d == superwallPlacementViewState.f113853d && this.f113854f == superwallPlacementViewState.f113854f && this.f113855g == superwallPlacementViewState.f113855g && this.f113856h == superwallPlacementViewState.f113856h && this.f113857i == superwallPlacementViewState.f113857i && this.f113858j == superwallPlacementViewState.f113858j && this.f113859k == superwallPlacementViewState.f113859k && this.f113860l == superwallPlacementViewState.f113860l;
    }

    public final boolean f() {
        return this.f113857i;
    }

    public final boolean g() {
        return this.f113855g;
    }

    public final boolean h() {
        return this.f113860l;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f113850a.hashCode() * 31) + Boolean.hashCode(this.f113851b)) * 31) + Boolean.hashCode(this.f113852c)) * 31) + Integer.hashCode(this.f113853d)) * 31) + Boolean.hashCode(this.f113854f)) * 31) + Boolean.hashCode(this.f113855g)) * 31) + Boolean.hashCode(this.f113856h)) * 31) + Boolean.hashCode(this.f113857i)) * 31) + Boolean.hashCode(this.f113858j)) * 31) + this.f113859k.hashCode()) * 31) + Boolean.hashCode(this.f113860l);
    }

    public final boolean i() {
        return this.f113858j;
    }

    public final Step j() {
        return this.f113850a;
    }

    public final boolean k() {
        return this.f113851b;
    }

    public final int l() {
        return this.f113853d;
    }

    public final boolean m() {
        return this.f113856h;
    }

    public final boolean n() {
        return this.f113852c;
    }

    public String toString() {
        return "SuperwallPlacementViewState(step=" + this.f113850a + ", stepLaunched=" + this.f113851b + ", wasTrialPurchased=" + this.f113852c + ", trialDays=" + this.f113853d + ", alreadyOwned=" + this.f113854f + ", showRatingAfterPurchase=" + this.f113855g + ", useSubscriptionOnboarding=" + this.f113856h + ", showOnboardingGuestPassShare=" + this.f113857i + ", signInContinueWithoutAccount=" + this.f113858j + ", loginAfterPurchase=" + this.f113859k + ", showRatingPending=" + this.f113860l + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f113850a.name());
        dest.writeInt(this.f113851b ? 1 : 0);
        dest.writeInt(this.f113852c ? 1 : 0);
        dest.writeInt(this.f113853d);
        dest.writeInt(this.f113854f ? 1 : 0);
        dest.writeInt(this.f113855g ? 1 : 0);
        dest.writeInt(this.f113856h ? 1 : 0);
        dest.writeInt(this.f113857i ? 1 : 0);
        dest.writeInt(this.f113858j ? 1 : 0);
        dest.writeString(this.f113859k.name());
        dest.writeInt(this.f113860l ? 1 : 0);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SuperwallPlacementViewState(cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState.Step r2, boolean r3, boolean r4, int r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, cz.mobilesoft.coreblock.enums.LoginAfterPurchase r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r1 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L6
            cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState$Step r2 = cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState.Step.Paywall
        L6:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto Lc
            r3 = r0
        Lc:
            r14 = r13 & 4
            if (r14 == 0) goto L11
            r4 = r0
        L11:
            r14 = r13 & 8
            if (r14 == 0) goto L16
            r5 = 7
        L16:
            r14 = r13 & 16
            if (r14 == 0) goto L1b
            r6 = r0
        L1b:
            r14 = r13 & 32
            if (r14 == 0) goto L20
            r7 = r0
        L20:
            r14 = r13 & 64
            if (r14 == 0) goto L25
            r8 = r0
        L25:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L2a
            r9 = r0
        L2a:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L2f
            r10 = r0
        L2f:
            r14 = r13 & 512(0x200, float:7.17E-43)
            if (r14 == 0) goto L35
            cz.mobilesoft.coreblock.enums.LoginAfterPurchase r11 = cz.mobilesoft.coreblock.enums.LoginAfterPurchase.None
        L35:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L46
            r14 = r0
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L52
        L46:
            r14 = r12
            r13 = r11
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L52:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState.<init>(cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState$Step, boolean, boolean, int, boolean, boolean, boolean, boolean, boolean, cz.mobilesoft.coreblock.enums.LoginAfterPurchase, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

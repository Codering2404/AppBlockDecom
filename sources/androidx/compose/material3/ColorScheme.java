package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ColorScheme {
    private final long A;
    private final long B;
    private final long C;
    private final long D;
    private final long E;
    private final long F;
    private final long G;
    private final long H;
    private final long I;
    private final long J;
    private ButtonColors K;
    private ButtonColors L;
    private ButtonColors M;
    private ButtonColors N;
    private ButtonColors O;
    private CardColors P;
    private CardColors Q;
    private CardColors R;
    private ChipColors S;
    private ChipColors T;
    private ChipColors U;
    private ChipColors V;
    private SelectableChipColors W;
    private SelectableChipColors X;
    private SelectableChipColors Y;
    private TopAppBarColors Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16616a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private TopAppBarColors f16617a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16618b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private TopAppBarColors f16619b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16620c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private TopAppBarColors f16621c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16622d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private CheckboxColors f16623d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f16624e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private DatePickerColors f16625e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16626f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private IconButtonColors f16627f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f16628g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private IconToggleButtonColors f16629g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f16630h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private IconButtonColors f16631h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f16632i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private IconToggleButtonColors f16633i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f16634j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private IconButtonColors f16635j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f16636k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private IconToggleButtonColors f16637k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f16638l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private IconButtonColors f16639l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f16640m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private IconToggleButtonColors f16641m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f16642n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private MenuItemColors f16643n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f16644o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private NavigationBarItemColors f16645o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f16646p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private NavigationRailItemColors f16647p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f16648q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private NavigationItemColors f16649q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f16650r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private RadioButtonColors f16651r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f16652s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private SegmentedButtonColors f16653s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f16654t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private SliderColors f16655t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f16656u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private SwitchColors f16657u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f16658v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private TextFieldColors f16659v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f16660w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private TextFieldColors f16661w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long f16662x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private TimePickerColors f16663x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final long f16664y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private RichTooltipColors f16665y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final long f16666z;

    public /* synthetic */ ColorScheme(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38);
    }

    public static /* synthetic */ ColorScheme b(ColorScheme colorScheme, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, int i3, int i4, Object obj) {
        long j39;
        long j40;
        long j41;
        long j42;
        long j43;
        long j44;
        long j45;
        long j46;
        long j47;
        long j48;
        long j49;
        long j50;
        long j51;
        long j52;
        long j53;
        long j54;
        long j55;
        long j56;
        long j57;
        long j58;
        long j59;
        long j60;
        long j61;
        long j62;
        long j63;
        long j64;
        long j65;
        long j66;
        long j67;
        long j68;
        ColorScheme colorScheme2;
        long j69;
        long j70;
        long j71;
        long j72;
        long j73;
        long j74 = (i3 & 1) != 0 ? colorScheme.f16616a : j3;
        long j75 = (i3 & 2) != 0 ? colorScheme.f16618b : j4;
        long j76 = (i3 & 4) != 0 ? colorScheme.f16620c : j5;
        long j77 = (i3 & 8) != 0 ? colorScheme.f16622d : j6;
        long j78 = (i3 & 16) != 0 ? colorScheme.f16624e : j7;
        long j79 = (i3 & 32) != 0 ? colorScheme.f16626f : j8;
        long j80 = (i3 & 64) != 0 ? colorScheme.f16628g : j9;
        long j81 = j74;
        long j82 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? colorScheme.f16630h : j10;
        long j83 = (i3 & Function.MAX_NARGS) != 0 ? colorScheme.f16632i : j11;
        long j84 = (i3 & 512) != 0 ? colorScheme.f16634j : j12;
        long j85 = (i3 & 1024) != 0 ? colorScheme.f16636k : j13;
        long j86 = (i3 & 2048) != 0 ? colorScheme.f16638l : j14;
        long j87 = (i3 & 4096) != 0 ? colorScheme.f16640m : j15;
        long j88 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? colorScheme.f16642n : j16;
        long j89 = (i3 & 16384) != 0 ? colorScheme.f16644o : j17;
        long j90 = (i3 & 32768) != 0 ? colorScheme.f16646p : j18;
        long j91 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? colorScheme.f16648q : j19;
        long j92 = (i3 & 131072) != 0 ? colorScheme.f16650r : j20;
        long j93 = (i3 & 262144) != 0 ? colorScheme.f16652s : j21;
        long j94 = (i3 & 524288) != 0 ? colorScheme.f16654t : j22;
        long j95 = (i3 & 1048576) != 0 ? colorScheme.f16656u : j23;
        long j96 = (i3 & 2097152) != 0 ? colorScheme.f16658v : j24;
        long j97 = (i3 & 4194304) != 0 ? colorScheme.f16660w : j25;
        long j98 = (i3 & 8388608) != 0 ? colorScheme.f16662x : j26;
        long j99 = (i3 & 16777216) != 0 ? colorScheme.f16664y : j27;
        long j100 = (i3 & 33554432) != 0 ? colorScheme.f16666z : j28;
        long j101 = (i3 & 67108864) != 0 ? colorScheme.A : j29;
        long j102 = (i3 & 134217728) != 0 ? colorScheme.B : j30;
        long j103 = (i3 & 268435456) != 0 ? colorScheme.C : j31;
        long j104 = (i3 & 536870912) != 0 ? colorScheme.D : j32;
        long j105 = (i3 & 1073741824) != 0 ? colorScheme.E : j33;
        long j106 = (i3 & Integer.MIN_VALUE) != 0 ? colorScheme.F : j34;
        long j107 = (i4 & 1) != 0 ? colorScheme.G : j35;
        long j108 = (i4 & 2) != 0 ? colorScheme.H : j36;
        long j109 = (i4 & 4) != 0 ? colorScheme.I : j37;
        if ((i4 & 8) != 0) {
            j40 = j109;
            j39 = colorScheme.J;
            j42 = j103;
            j43 = j104;
            j44 = j105;
            j45 = j106;
            j46 = j107;
            j47 = j108;
            j49 = j96;
            j50 = j97;
            j51 = j98;
            j52 = j99;
            j53 = j100;
            j54 = j101;
            j41 = j102;
            j56 = j89;
            j57 = j90;
            j58 = j91;
            j59 = j92;
            j60 = j93;
            j61 = j94;
            j48 = j95;
            j63 = j82;
            j64 = j83;
            j65 = j84;
            j66 = j85;
            j67 = j86;
            j68 = j87;
            j55 = j88;
            colorScheme2 = colorScheme;
            j69 = j75;
            j70 = j76;
            j71 = j77;
            j72 = j78;
            j73 = j79;
            j62 = j80;
        } else {
            j39 = j38;
            j40 = j109;
            j41 = j102;
            j42 = j103;
            j43 = j104;
            j44 = j105;
            j45 = j106;
            j46 = j107;
            j47 = j108;
            j48 = j95;
            j49 = j96;
            j50 = j97;
            j51 = j98;
            j52 = j99;
            j53 = j100;
            j54 = j101;
            j55 = j88;
            j56 = j89;
            j57 = j90;
            j58 = j91;
            j59 = j92;
            j60 = j93;
            j61 = j94;
            j62 = j80;
            j63 = j82;
            j64 = j83;
            j65 = j84;
            j66 = j85;
            j67 = j86;
            j68 = j87;
            colorScheme2 = colorScheme;
            j69 = j75;
            j70 = j76;
            j71 = j77;
            j72 = j78;
            j73 = j79;
        }
        return colorScheme2.a(j81, j69, j70, j71, j72, j73, j62, j63, j64, j65, j66, j67, j68, j55, j56, j57, j58, j59, j60, j61, j48, j49, j50, j51, j52, j53, j54, j41, j42, j43, j44, j45, j46, j47, j40, j39);
    }

    public final MenuItemColors A() {
        return this.f16643n0;
    }

    public final void A0(ChipColors chipColors) {
        this.S = chipColors;
    }

    public final NavigationBarItemColors B() {
        return this.f16645o0;
    }

    public final void B0(ButtonColors buttonColors) {
        this.K = buttonColors;
    }

    public final NavigationRailItemColors C() {
        return this.f16647p0;
    }

    public final void C0(CardColors cardColors) {
        this.P = cardColors;
    }

    public final ButtonColors D() {
        return this.N;
    }

    public final void D0(TopAppBarColors topAppBarColors) {
        this.f16617a0 = topAppBarColors;
    }

    public final CardColors E() {
        return this.R;
    }

    public final void E0(CheckboxColors checkboxColors) {
        this.f16623d0 = checkboxColors;
    }

    public final IconButtonColors F() {
        return this.f16639l0;
    }

    public final void F0(DatePickerColors datePickerColors) {
        this.f16625e0 = datePickerColors;
    }

    public final TextFieldColors G() {
        return this.f16659v0;
    }

    public final void G0(ChipColors chipColors) {
        this.T = chipColors;
    }

    public final RadioButtonColors H() {
        return this.f16651r0;
    }

    public final void H0(ButtonColors buttonColors) {
        this.L = buttonColors;
    }

    public final RichTooltipColors I() {
        return this.f16665y0;
    }

    public final void I0(CardColors cardColors) {
        this.Q = cardColors;
    }

    public final SegmentedButtonColors J() {
        return this.f16653s0;
    }

    public final void J0(SelectableChipColors selectableChipColors) {
        this.X = selectableChipColors;
    }

    public final SliderColors K() {
        return this.f16655t0;
    }

    public final void K0(ChipColors chipColors) {
        this.V = chipColors;
    }

    public final ChipColors L() {
        return this.U;
    }

    public final void L0(NavigationItemColors navigationItemColors) {
        this.f16649q0 = navigationItemColors;
    }

    public final SwitchColors M() {
        return this.f16657u0;
    }

    public final void M0(IconButtonColors iconButtonColors) {
        this.f16631h0 = iconButtonColors;
    }

    public final ButtonColors N() {
        return this.O;
    }

    public final void N0(IconToggleButtonColors iconToggleButtonColors) {
        this.f16633i0 = iconToggleButtonColors;
    }

    public final TextFieldColors O() {
        return this.f16661w0;
    }

    public final void O0(ButtonColors buttonColors) {
        this.M = buttonColors;
    }

    public final TimePickerColors P() {
        return this.f16663x0;
    }

    public final void P0(IconButtonColors iconButtonColors) {
        this.f16635j0 = iconButtonColors;
    }

    public final TopAppBarColors Q() {
        return this.Z;
    }

    public final void Q0(IconToggleButtonColors iconToggleButtonColors) {
        this.f16637k0 = iconToggleButtonColors;
    }

    public final long R() {
        return this.f16660w;
    }

    public final void R0(SelectableChipColors selectableChipColors) {
        this.W = selectableChipColors;
    }

    public final long S() {
        return this.f16664y;
    }

    public final void S0(IconButtonColors iconButtonColors) {
        this.f16627f0 = iconButtonColors;
    }

    public final long T() {
        return this.f16658v;
    }

    public final void T0(IconToggleButtonColors iconToggleButtonColors) {
        this.f16629g0 = iconToggleButtonColors;
    }

    public final long U() {
        return this.f16624e;
    }

    public final void U0(SelectableChipColors selectableChipColors) {
        this.Y = selectableChipColors;
    }

    public final long V() {
        return this.f16656u;
    }

    public final void V0(TopAppBarColors topAppBarColors) {
        this.f16621c0 = topAppBarColors;
    }

    public final long W() {
        return this.f16644o;
    }

    public final void W0(TopAppBarColors topAppBarColors) {
        this.f16619b0 = topAppBarColors;
    }

    public final long X() {
        return this.f16662x;
    }

    public final void X0(MenuItemColors menuItemColors) {
        this.f16643n0 = menuItemColors;
    }

    public final long Y() {
        return this.f16666z;
    }

    public final void Y0(NavigationBarItemColors navigationBarItemColors) {
        this.f16645o0 = navigationBarItemColors;
    }

    public final long Z() {
        return this.f16618b;
    }

    public final void Z0(NavigationRailItemColors navigationRailItemColors) {
        this.f16647p0 = navigationRailItemColors;
    }

    public final ColorScheme a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38) {
        return new ColorScheme(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, null);
    }

    public final long a0() {
        return this.f16622d;
    }

    public final void a1(ButtonColors buttonColors) {
        this.N = buttonColors;
    }

    public final long b0() {
        return this.f16628g;
    }

    public final void b1(CardColors cardColors) {
        this.R = cardColors;
    }

    public final long c() {
        return this.f16642n;
    }

    public final long c0() {
        return this.f16632i;
    }

    public final void c1(IconButtonColors iconButtonColors) {
        this.f16639l0 = iconButtonColors;
    }

    public final ChipColors d() {
        return this.S;
    }

    public final long d0() {
        return this.f16648q;
    }

    public final void d1(IconToggleButtonColors iconToggleButtonColors) {
        this.f16641m0 = iconToggleButtonColors;
    }

    public final ButtonColors e() {
        return this.K;
    }

    public final long e0() {
        return this.f16652s;
    }

    public final void e1(TextFieldColors textFieldColors) {
        this.f16659v0 = textFieldColors;
    }

    public final CardColors f() {
        return this.P;
    }

    public final long f0() {
        return this.f16636k;
    }

    public final void f1(RadioButtonColors radioButtonColors) {
        this.f16651r0 = radioButtonColors;
    }

    public final TopAppBarColors g() {
        return this.f16617a0;
    }

    public final long g0() {
        return this.f16640m;
    }

    public final void g1(RichTooltipColors richTooltipColors) {
        this.f16665y0 = richTooltipColors;
    }

    public final CheckboxColors h() {
        return this.f16623d0;
    }

    public final long h0() {
        return this.A;
    }

    public final void h1(SegmentedButtonColors segmentedButtonColors) {
        this.f16653s0 = segmentedButtonColors;
    }

    public final DatePickerColors i() {
        return this.f16625e0;
    }

    public final long i0() {
        return this.B;
    }

    public final void i1(SliderColors sliderColors) {
        this.f16655t0 = sliderColors;
    }

    public final ChipColors j() {
        return this.T;
    }

    public final long j0() {
        return this.f16616a;
    }

    public final void j1(ChipColors chipColors) {
        this.U = chipColors;
    }

    public final ButtonColors k() {
        return this.L;
    }

    public final long k0() {
        return this.f16620c;
    }

    public final void k1(SwitchColors switchColors) {
        this.f16657u0 = switchColors;
    }

    public final CardColors l() {
        return this.Q;
    }

    public final long l0() {
        return this.C;
    }

    public final void l1(ButtonColors buttonColors) {
        this.O = buttonColors;
    }

    public final SelectableChipColors m() {
        return this.X;
    }

    public final long m0() {
        return this.f16626f;
    }

    public final void m1(TextFieldColors textFieldColors) {
        this.f16661w0 = textFieldColors;
    }

    public final ChipColors n() {
        return this.V;
    }

    public final long n0() {
        return this.f16630h;
    }

    public final void n1(TimePickerColors timePickerColors) {
        this.f16663x0 = timePickerColors;
    }

    public final NavigationItemColors o() {
        return this.f16649q0;
    }

    public final long o0() {
        return this.f16646p;
    }

    public final void o1(TopAppBarColors topAppBarColors) {
        this.Z = topAppBarColors;
    }

    public final IconButtonColors p() {
        return this.f16631h0;
    }

    public final long p0() {
        return this.D;
    }

    public final IconToggleButtonColors q() {
        return this.f16633i0;
    }

    public final long q0() {
        return this.F;
    }

    public final ButtonColors r() {
        return this.M;
    }

    public final long r0() {
        return this.G;
    }

    public final IconButtonColors s() {
        return this.f16635j0;
    }

    public final long s0() {
        return this.H;
    }

    public final IconToggleButtonColors t() {
        return this.f16637k0;
    }

    public final long t0() {
        return this.I;
    }

    public String toString() {
        return "ColorScheme(primary=" + ((Object) Color.A(this.f16616a)) + "onPrimary=" + ((Object) Color.A(this.f16618b)) + "primaryContainer=" + ((Object) Color.A(this.f16620c)) + "onPrimaryContainer=" + ((Object) Color.A(this.f16622d)) + "inversePrimary=" + ((Object) Color.A(this.f16624e)) + "secondary=" + ((Object) Color.A(this.f16626f)) + "onSecondary=" + ((Object) Color.A(this.f16628g)) + "secondaryContainer=" + ((Object) Color.A(this.f16630h)) + "onSecondaryContainer=" + ((Object) Color.A(this.f16632i)) + "tertiary=" + ((Object) Color.A(this.f16634j)) + "onTertiary=" + ((Object) Color.A(this.f16636k)) + "tertiaryContainer=" + ((Object) Color.A(this.f16638l)) + "onTertiaryContainer=" + ((Object) Color.A(this.f16640m)) + "background=" + ((Object) Color.A(this.f16642n)) + "onBackground=" + ((Object) Color.A(this.f16644o)) + "surface=" + ((Object) Color.A(this.f16646p)) + "onSurface=" + ((Object) Color.A(this.f16648q)) + "surfaceVariant=" + ((Object) Color.A(this.f16650r)) + "onSurfaceVariant=" + ((Object) Color.A(this.f16652s)) + "surfaceTint=" + ((Object) Color.A(this.f16654t)) + "inverseSurface=" + ((Object) Color.A(this.f16656u)) + "inverseOnSurface=" + ((Object) Color.A(this.f16658v)) + "error=" + ((Object) Color.A(this.f16660w)) + "onError=" + ((Object) Color.A(this.f16662x)) + "errorContainer=" + ((Object) Color.A(this.f16664y)) + "onErrorContainer=" + ((Object) Color.A(this.f16666z)) + "outline=" + ((Object) Color.A(this.A)) + "outlineVariant=" + ((Object) Color.A(this.B)) + "scrim=" + ((Object) Color.A(this.C)) + "surfaceBright=" + ((Object) Color.A(this.D)) + "surfaceDim=" + ((Object) Color.A(this.E)) + "surfaceContainer=" + ((Object) Color.A(this.F)) + "surfaceContainerHigh=" + ((Object) Color.A(this.G)) + "surfaceContainerHighest=" + ((Object) Color.A(this.H)) + "surfaceContainerLow=" + ((Object) Color.A(this.I)) + "surfaceContainerLowest=" + ((Object) Color.A(this.J)) + ')';
    }

    public final SelectableChipColors u() {
        return this.W;
    }

    public final long u0() {
        return this.J;
    }

    public final IconButtonColors v() {
        return this.f16627f0;
    }

    public final long v0() {
        return this.E;
    }

    public final IconToggleButtonColors w() {
        return this.f16629g0;
    }

    public final long w0() {
        return this.f16654t;
    }

    public final SelectableChipColors x() {
        return this.Y;
    }

    public final long x0() {
        return this.f16650r;
    }

    public final TopAppBarColors y() {
        return this.f16621c0;
    }

    public final long y0() {
        return this.f16634j;
    }

    public final TopAppBarColors z() {
        return this.f16619b0;
    }

    public final long z0() {
        return this.f16638l;
    }

    public /* synthetic */ ColorScheme(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31);
    }

    private ColorScheme(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38) {
        this.f16616a = j3;
        this.f16618b = j4;
        this.f16620c = j5;
        this.f16622d = j6;
        this.f16624e = j7;
        this.f16626f = j8;
        this.f16628g = j9;
        this.f16630h = j10;
        this.f16632i = j11;
        this.f16634j = j12;
        this.f16636k = j13;
        this.f16638l = j14;
        this.f16640m = j15;
        this.f16642n = j16;
        this.f16644o = j17;
        this.f16646p = j18;
        this.f16648q = j19;
        this.f16650r = j20;
        this.f16652s = j21;
        this.f16654t = j22;
        this.f16656u = j23;
        this.f16658v = j24;
        this.f16660w = j25;
        this.f16662x = j26;
        this.f16664y = j27;
        this.f16666z = j28;
        this.A = j29;
        this.B = j30;
        this.C = j31;
        this.D = j32;
        this.E = j33;
        this.F = j34;
        this.G = j35;
        this.H = j36;
        this.I = j37;
        this.J = j38;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ColorScheme(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31) {
        Color.Companion companion = Color.f25715b;
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), null);
    }
}

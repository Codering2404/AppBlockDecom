package androidx.compose.ui.input.key;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f26638b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f26642c = Key_androidKt.a(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f26646d = Key_androidKt.a(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f26650e = Key_androidKt.a(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f26654f = Key_androidKt.a(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f26658g = Key_androidKt.a(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f26662h = Key_androidKt.a(259);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f26666i = Key_androidKt.a(260);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f26670j = Key_androidKt.a(261);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f26674k = Key_androidKt.a(262);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f26678l = Key_androidKt.a(263);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f26682m = Key_androidKt.a(280);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f26686n = Key_androidKt.a(281);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f26690o = Key_androidKt.a(282);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final long f26694p = Key_androidKt.a(283);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f26698q = Key_androidKt.a(5);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final long f26702r = Key_androidKt.a(6);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final long f26705s = Key_androidKt.a(19);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f26708t = Key_androidKt.a(20);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final long f26711u = Key_androidKt.a(21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final long f26714v = Key_androidKt.a(22);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final long f26717w = Key_androidKt.a(23);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final long f26720x = Key_androidKt.a(268);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final long f26723y = Key_androidKt.a(269);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final long f26726z = Key_androidKt.a(270);
    private static final long A = Key_androidKt.a(271);
    private static final long B = Key_androidKt.a(24);
    private static final long C = Key_androidKt.a(25);
    private static final long D = Key_androidKt.a(26);
    private static final long E = Key_androidKt.a(27);
    private static final long F = Key_androidKt.a(28);
    private static final long G = Key_androidKt.a(7);
    private static final long H = Key_androidKt.a(8);
    private static final long I = Key_androidKt.a(9);
    private static final long J = Key_androidKt.a(10);
    private static final long K = Key_androidKt.a(11);
    private static final long L = Key_androidKt.a(12);
    private static final long M = Key_androidKt.a(13);
    private static final long N = Key_androidKt.a(14);
    private static final long O = Key_androidKt.a(15);
    private static final long P = Key_androidKt.a(16);
    private static final long Q = Key_androidKt.a(81);
    private static final long R = Key_androidKt.a(69);
    private static final long S = Key_androidKt.a(17);
    private static final long T = Key_androidKt.a(70);
    private static final long U = Key_androidKt.a(18);
    private static final long V = Key_androidKt.a(29);
    private static final long W = Key_androidKt.a(30);
    private static final long X = Key_androidKt.a(31);
    private static final long Y = Key_androidKt.a(32);
    private static final long Z = Key_androidKt.a(33);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final long f26635a0 = Key_androidKt.a(34);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final long f26639b0 = Key_androidKt.a(35);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final long f26643c0 = Key_androidKt.a(36);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final long f26647d0 = Key_androidKt.a(37);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final long f26651e0 = Key_androidKt.a(38);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final long f26655f0 = Key_androidKt.a(39);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final long f26659g0 = Key_androidKt.a(40);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final long f26663h0 = Key_androidKt.a(41);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final long f26667i0 = Key_androidKt.a(42);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final long f26671j0 = Key_androidKt.a(43);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final long f26675k0 = Key_androidKt.a(44);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final long f26679l0 = Key_androidKt.a(45);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final long f26683m0 = Key_androidKt.a(46);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final long f26687n0 = Key_androidKt.a(47);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final long f26691o0 = Key_androidKt.a(48);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final long f26695p0 = Key_androidKt.a(49);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final long f26699q0 = Key_androidKt.a(50);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final long f26703r0 = Key_androidKt.a(51);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final long f26706s0 = Key_androidKt.a(52);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final long f26709t0 = Key_androidKt.a(53);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final long f26712u0 = Key_androidKt.a(54);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static final long f26715v0 = Key_androidKt.a(55);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static final long f26718w0 = Key_androidKt.a(56);

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final long f26721x0 = Key_androidKt.a(57);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final long f26724y0 = Key_androidKt.a(58);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final long f26727z0 = Key_androidKt.a(59);
    private static final long A0 = Key_androidKt.a(60);
    private static final long B0 = Key_androidKt.a(61);
    private static final long C0 = Key_androidKt.a(62);
    private static final long D0 = Key_androidKt.a(63);
    private static final long E0 = Key_androidKt.a(64);
    private static final long F0 = Key_androidKt.a(65);
    private static final long G0 = Key_androidKt.a(66);
    private static final long H0 = Key_androidKt.a(67);
    private static final long I0 = Key_androidKt.a(112);
    private static final long J0 = Key_androidKt.a(111);
    private static final long K0 = Key_androidKt.a(113);
    private static final long L0 = Key_androidKt.a(114);
    private static final long M0 = Key_androidKt.a(115);
    private static final long N0 = Key_androidKt.a(116);
    private static final long O0 = Key_androidKt.a(117);
    private static final long P0 = Key_androidKt.a(118);
    private static final long Q0 = Key_androidKt.a(119);
    private static final long R0 = Key_androidKt.a(120);
    private static final long S0 = Key_androidKt.a(121);
    private static final long T0 = Key_androidKt.a(122);
    private static final long U0 = Key_androidKt.a(123);
    private static final long V0 = Key_androidKt.a(124);
    private static final long W0 = Key_androidKt.a(277);
    private static final long X0 = Key_androidKt.a(278);
    private static final long Y0 = Key_androidKt.a(279);
    private static final long Z0 = Key_androidKt.a(68);

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private static final long f26636a1 = Key_androidKt.a(71);

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private static final long f26640b1 = Key_androidKt.a(72);

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private static final long f26644c1 = Key_androidKt.a(76);

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private static final long f26648d1 = Key_androidKt.a(73);

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private static final long f26652e1 = Key_androidKt.a(74);

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private static final long f26656f1 = Key_androidKt.a(75);

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private static final long f26660g1 = Key_androidKt.a(77);

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private static final long f26664h1 = Key_androidKt.a(78);

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private static final long f26668i1 = Key_androidKt.a(79);

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private static final long f26672j1 = Key_androidKt.a(80);

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private static final long f26676k1 = Key_androidKt.a(82);

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private static final long f26680l1 = Key_androidKt.a(83);

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private static final long f26684m1 = Key_androidKt.a(84);

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private static final long f26688n1 = Key_androidKt.a(92);

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private static final long f26692o1 = Key_androidKt.a(93);

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final long f26696p1 = Key_androidKt.a(94);

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private static final long f26700q1 = Key_androidKt.a(95);

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private static final long f26704r1 = Key_androidKt.a(96);

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private static final long f26707s1 = Key_androidKt.a(97);

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private static final long f26710t1 = Key_androidKt.a(98);

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private static final long f26713u1 = Key_androidKt.a(99);

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private static final long f26716v1 = Key_androidKt.a(100);

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private static final long f26719w1 = Key_androidKt.a(101);

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private static final long f26722x1 = Key_androidKt.a(102);

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private static final long f26725y1 = Key_androidKt.a(103);

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    private static final long f26728z1 = Key_androidKt.a(104);
    private static final long A1 = Key_androidKt.a(105);
    private static final long B1 = Key_androidKt.a(106);
    private static final long C1 = Key_androidKt.a(107);
    private static final long D1 = Key_androidKt.a(108);
    private static final long E1 = Key_androidKt.a(109);
    private static final long F1 = Key_androidKt.a(110);
    private static final long G1 = Key_androidKt.a(188);
    private static final long H1 = Key_androidKt.a(189);
    private static final long I1 = Key_androidKt.a(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
    private static final long J1 = Key_androidKt.a(191);
    private static final long K1 = Key_androidKt.a(192);
    private static final long L1 = Key_androidKt.a(193);
    private static final long M1 = Key_androidKt.a(194);
    private static final long N1 = Key_androidKt.a(195);
    private static final long O1 = Key_androidKt.a(196);
    private static final long P1 = Key_androidKt.a(197);
    private static final long Q1 = Key_androidKt.a(198);
    private static final long R1 = Key_androidKt.a(199);
    private static final long S1 = Key_androidKt.a(200);
    private static final long T1 = Key_androidKt.a(RCHTTPStatusCodes.CREATED);
    private static final long U1 = Key_androidKt.a(202);
    private static final long V1 = Key_androidKt.a(203);
    private static final long W1 = Key_androidKt.a(125);
    private static final long X1 = Key_androidKt.a(131);
    private static final long Y1 = Key_androidKt.a(132);
    private static final long Z1 = Key_androidKt.a(133);

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    private static final long f26637a2 = Key_androidKt.a(134);

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private static final long f26641b2 = Key_androidKt.a(135);

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    private static final long f26645c2 = Key_androidKt.a(136);

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    private static final long f26649d2 = Key_androidKt.a(137);

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    private static final long f26653e2 = Key_androidKt.a(138);

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    private static final long f26657f2 = Key_androidKt.a(139);

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    private static final long f26661g2 = Key_androidKt.a(140);

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    private static final long f26665h2 = Key_androidKt.a(141);

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    private static final long f26669i2 = Key_androidKt.a(142);

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    private static final long f26673j2 = Key_androidKt.a(143);

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    private static final long f26677k2 = Key_androidKt.a(144);

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    private static final long f26681l2 = Key_androidKt.a(145);

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    private static final long f26685m2 = Key_androidKt.a(146);

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    private static final long f26689n2 = Key_androidKt.a(147);

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    private static final long f26693o2 = Key_androidKt.a(148);

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    private static final long f26697p2 = Key_androidKt.a(149);

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    private static final long f26701q2 = Key_androidKt.a(150);
    private static final long r2 = Key_androidKt.a(151);
    private static final long s2 = Key_androidKt.a(152);
    private static final long t2 = Key_androidKt.a(153);
    private static final long u2 = Key_androidKt.a(154);
    private static final long v2 = Key_androidKt.a(ModuleDescriptor.MODULE_VERSION);
    private static final long w2 = Key_androidKt.a(156);
    private static final long x2 = Key_androidKt.a(157);
    private static final long y2 = Key_androidKt.a(158);
    private static final long z2 = Key_androidKt.a(159);
    private static final long A2 = Key_androidKt.a(160);
    private static final long B2 = Key_androidKt.a(161);
    private static final long C2 = Key_androidKt.a(162);
    private static final long D2 = Key_androidKt.a(163);
    private static final long E2 = Key_androidKt.a(126);
    private static final long F2 = Key_androidKt.a(127);
    private static final long G2 = Key_androidKt.a(85);
    private static final long H2 = Key_androidKt.a(86);
    private static final long I2 = Key_androidKt.a(130);
    private static final long J2 = Key_androidKt.a(87);
    private static final long K2 = Key_androidKt.a(88);
    private static final long L2 = Key_androidKt.a(89);
    private static final long M2 = Key_androidKt.a(90);
    private static final long N2 = Key_androidKt.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    private static final long O2 = Key_androidKt.a(222);
    private static final long P2 = Key_androidKt.a(129);
    private static final long Q2 = Key_androidKt.a(226);
    private static final long R2 = Key_androidKt.a(272);
    private static final long S2 = Key_androidKt.a(273);
    private static final long T2 = Key_androidKt.a(274);
    private static final long U2 = Key_androidKt.a(275);
    private static final long V2 = Key_androidKt.a(91);
    private static final long W2 = Key_androidKt.a(164);
    private static final long X2 = Key_androidKt.a(165);
    private static final long Y2 = Key_androidKt.a(166);
    private static final long Z2 = Key_androidKt.a(167);
    private static final long a3 = Key_androidKt.a(168);
    private static final long b3 = Key_androidKt.a(169);
    private static final long c3 = Key_androidKt.a(170);
    private static final long d3 = Key_androidKt.a(171);
    private static final long e3 = Key_androidKt.a(172);
    private static final long f3 = Key_androidKt.a(173);
    private static final long g3 = Key_androidKt.a(174);
    private static final long h3 = Key_androidKt.a(175);
    private static final long i3 = Key_androidKt.a(176);
    private static final long j3 = Key_androidKt.a(177);
    private static final long k3 = Key_androidKt.a(178);
    private static final long l3 = Key_androidKt.a(179);
    private static final long m3 = Key_androidKt.a(SensibleDefaults.X_OFFSET);
    private static final long n3 = Key_androidKt.a(181);
    private static final long o3 = Key_androidKt.a(182);
    private static final long p3 = Key_androidKt.a(183);
    private static final long q3 = Key_androidKt.a(184);
    private static final long r3 = Key_androidKt.a(185);
    private static final long s3 = Key_androidKt.a(186);
    private static final long t3 = Key_androidKt.a(187);
    private static final long u3 = Key_androidKt.a(204);
    private static final long v3 = Key_androidKt.a(205);
    private static final long w3 = Key_androidKt.a(206);
    private static final long x3 = Key_androidKt.a(207);
    private static final long y3 = Key_androidKt.a(208);
    private static final long z3 = Key_androidKt.a(209);
    private static final long A3 = Key_androidKt.a(210);
    private static final long B3 = Key_androidKt.a(211);
    private static final long C3 = Key_androidKt.a(212);
    private static final long D3 = Key_androidKt.a(213);
    private static final long E3 = Key_androidKt.a(214);
    private static final long F3 = Key_androidKt.a(215);
    private static final long G3 = Key_androidKt.a(216);
    private static final long H3 = Key_androidKt.a(217);
    private static final long I3 = Key_androidKt.a(218);
    private static final long J3 = Key_androidKt.a(219);
    private static final long K3 = Key_androidKt.a(220);
    private static final long L3 = Key_androidKt.a(221);
    private static final long M3 = Key_androidKt.a(223);
    private static final long N3 = Key_androidKt.a(224);
    private static final long O3 = Key_androidKt.a(276);
    private static final long P3 = Key_androidKt.a(225);
    private static final long Q3 = Key_androidKt.a(229);
    private static final long R3 = Key_androidKt.a(230);
    private static final long S3 = Key_androidKt.a(231);
    private static final long T3 = Key_androidKt.a(232);
    private static final long U3 = Key_androidKt.a(233);
    private static final long V3 = Key_androidKt.a(234);
    private static final long W3 = Key_androidKt.a(235);
    private static final long X3 = Key_androidKt.a(236);
    private static final long Y3 = Key_androidKt.a(237);
    private static final long Z3 = Key_androidKt.a(238);
    private static final long a4 = Key_androidKt.a(239);
    private static final long b4 = Key_androidKt.a(240);
    private static final long c4 = Key_androidKt.a(241);
    private static final long d4 = Key_androidKt.a(242);
    private static final long e4 = Key_androidKt.a(243);
    private static final long f4 = Key_androidKt.a(244);
    private static final long g4 = Key_androidKt.a(245);
    private static final long h4 = Key_androidKt.a(246);
    private static final long i4 = Key_androidKt.a(247);
    private static final long j4 = Key_androidKt.a(248);
    private static final long k4 = Key_androidKt.a(249);
    private static final long l4 = Key_androidKt.a(250);
    private static final long m4 = Key_androidKt.a(251);
    private static final long n4 = Key_androidKt.a(252);
    private static final long o4 = Key_androidKt.a(253);
    private static final long p4 = Key_androidKt.a(254);
    private static final long q4 = Key_androidKt.a(255);
    private static final long r4 = Key_androidKt.a(Function.MAX_NARGS);
    private static final long s4 = Key_androidKt.a(257);
    private static final long t4 = Key_androidKt.a(258);
    private static final long u4 = Key_androidKt.a(264);
    private static final long v4 = Key_androidKt.a(265);
    private static final long w4 = Key_androidKt.a(266);
    private static final long x4 = Key_androidKt.a(267);
    private static final long y4 = Key_androidKt.a(284);
    private static final long z4 = Key_androidKt.a(285);
    private static final long A4 = Key_androidKt.a(286);
    private static final long B4 = Key_androidKt.a(287);
    private static final long C4 = Key_androidKt.a(288);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Key.f26658g;
        }

        public final long b() {
            return Key.f26717w;
        }

        public final long c() {
            return Key.f26708t;
        }

        public final long d() {
            return Key.f26711u;
        }

        public final long e() {
            return Key.f26714v;
        }

        public final long f() {
            return Key.f26705s;
        }

        public final long g() {
            return Key.G0;
        }

        public final long h() {
            return Key.J0;
        }

        public final long i() {
            return Key.A2;
        }

        public final long j() {
            return Key.f26692o1;
        }

        public final long k() {
            return Key.f26688n1;
        }

        public final long l() {
            return Key.C0;
        }

        public final long m() {
            return Key.B0;
        }

        private Companion() {
        }
    }

    public static boolean o(long j5, Object obj) {
        return (obj instanceof Key) && j5 == ((Key) obj).s();
    }

    public static final boolean p(long j5, long j6) {
        return j5 == j6;
    }

    public static int q(long j5) {
        return Long.hashCode(j5);
    }

    public static String r(long j5) {
        return "Key code: " + j5;
    }

    public boolean equals(Object obj) {
        return o(this.f26729a, obj);
    }

    public int hashCode() {
        return q(this.f26729a);
    }

    public final /* synthetic */ long s() {
        return this.f26729a;
    }

    public String toString() {
        return r(this.f26729a);
    }

    public static long n(long j5) {
        return j5;
    }
}

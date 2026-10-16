package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialDynamicColors {
    static double A1(Hct hct, DynamicScheme dynamicScheme) {
        Hct hctF = hct.f(V1(dynamicScheme));
        return (!DynamicColor.h(hct.e()) || DynamicColor.g(hctF.e())) ? DynamicColor.a(hctF.e()) : DynamicColor.a(hct.e());
    }

    public static /* synthetic */ Double D(DynamicScheme dynamicScheme) {
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 10.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 20.0d : 100.0d);
    }

    public static /* synthetic */ ToneDeltaPair E0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.P1(), materialDynamicColors.O1(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double H0(DynamicScheme dynamicScheme) {
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 90.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 80.0d : 40.0d);
    }

    public static /* synthetic */ ToneDeltaPair U(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.f1(), materialDynamicColors.e1(), 15.0d, TonePolarity.NEARER, false);
    }

    private static ViewingConditions V1(DynamicScheme dynamicScheme) {
        return ViewingConditions.a(dynamicScheme.f80622d ? 30.0d : 80.0d);
    }

    public static /* synthetic */ ToneDeltaPair Z(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.P1(), materialDynamicColors.O1(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double b0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        materialDynamicColors.getClass();
        if (l1(dynamicScheme)) {
            return Double.valueOf(DynamicColor.b(((Double) materialDynamicColors.C1().f80611c.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 0.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 90.0d : 10.0d);
    }

    public static /* synthetic */ Double e0(DynamicScheme dynamicScheme) {
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 100.0d : 0.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 80.0d : 40.0d);
    }

    public static /* synthetic */ Double f(DynamicScheme dynamicScheme) {
        double d3 = dynamicScheme.f80622d ? 30.0d : 90.0d;
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 30.0d : 85.0d);
        }
        if (l1(dynamicScheme)) {
            return Double.valueOf(A1(dynamicScheme.f80625g.e(g1(dynamicScheme.f80625g.f(), dynamicScheme.f80625g.d(), d3, !dynamicScheme.f80622d)), dynamicScheme));
        }
        return Double.valueOf(d3);
    }

    public static /* synthetic */ Double f0(DynamicScheme dynamicScheme) {
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 20.0d : 100.0d);
    }

    static double g1(double d3, double d4, double d5, boolean z2) {
        Hct hctA = Hct.a(d3, d4, d5);
        if (hctA.c() < d4) {
            double dC = hctA.c();
            while (hctA.c() < d4) {
                d5 += z2 ? -1.0d : 1.0d;
                Hct hctA2 = Hct.a(d3, d4, d5);
                if (dC > hctA2.c() || Math.abs(hctA2.c() - d4) < 0.4d) {
                    return d5;
                }
                if (Math.abs(hctA2.c() - d4) < Math.abs(hctA.c() - d4)) {
                    hctA = hctA2;
                }
                dC = Math.max(dC, hctA2.c());
            }
        }
        return d5;
    }

    public static /* synthetic */ Double h(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        materialDynamicColors.getClass();
        if (l1(dynamicScheme)) {
            return Double.valueOf(DynamicColor.b(((Double) materialDynamicColors.E1().f80611c.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.f80622d ? 90.0d : 10.0d);
    }

    public static /* synthetic */ Double i0(DynamicScheme dynamicScheme) {
        if (l1(dynamicScheme)) {
            return Double.valueOf(A1(dynamicScheme.f80620b, dynamicScheme));
        }
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 85.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 30.0d : 90.0d);
    }

    private static boolean l1(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.f80621c;
        return variant == Variant.FIDELITY || variant == Variant.CONTENT;
    }

    private static boolean m1(DynamicScheme dynamicScheme) {
        return dynamicScheme.f80621c == Variant.MONOCHROME;
    }

    public static /* synthetic */ ToneDeltaPair n(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.C1(), materialDynamicColors.B1(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair n0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.E1(), materialDynamicColors.D1(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double o0(DynamicScheme dynamicScheme) {
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.f80622d ? 20.0d : 100.0d);
    }

    public static /* synthetic */ Double s0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        materialDynamicColors.getClass();
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 0.0d : 100.0d);
        }
        if (l1(dynamicScheme)) {
            return Double.valueOf(DynamicColor.b(((Double) materialDynamicColors.P1().f80611c.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.f80622d ? 90.0d : 10.0d);
    }

    public static /* synthetic */ Double t0(DynamicScheme dynamicScheme) {
        if (m1(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f80622d ? 60.0d : 49.0d);
        }
        if (l1(dynamicScheme)) {
            return Double.valueOf(DislikeAnalyzer.a(dynamicScheme.f80626h.e(A1(dynamicScheme.f80626h.e(dynamicScheme.f80620b.e()), dynamicScheme))).e());
        }
        return Double.valueOf(dynamicScheme.f80622d ? 30.0d : 90.0d);
    }

    public static /* synthetic */ ToneDeltaPair u(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.E1(), materialDynamicColors.D1(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair v(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.f1(), materialDynamicColors.e1(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair x0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.C1(), materialDynamicColors.B1(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor B1() {
        return new DynamicColor("primary", new Function() { // from class: com.google.android.material.color.utilities.z2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80624f;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.e0((DynamicScheme) obj);
            }
        }, true, new a3(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.x0(this.f80719a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor C1() {
        return new DynamicColor("primary_container", new Function() { // from class: com.google.android.material.color.utilities.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80624f;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.i0((DynamicScheme) obj);
            }
        }, true, new a3(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.n(this.f80734a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor D1() {
        return new DynamicColor("secondary", new Function() { // from class: com.google.android.material.color.utilities.n1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80625g;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 80.0d : 40.0d);
            }
        }, true, new a3(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.p1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.u(this.f80728a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor E1() {
        return new DynamicColor("secondary_container", new Function() { // from class: com.google.android.material.color.utilities.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80625g;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.f((DynamicScheme) obj);
            }
        }, true, new a3(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.n0(this.f80730a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor F1() {
        return new DynamicColor("surface", new Function() { // from class: com.google.android.material.color.utilities.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.q
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 6.0d : 98.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor G1() {
        return new DynamicColor("surface_bright", new Function() { // from class: com.google.android.material.color.utilities.i0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 24.0d : 98.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor H1() {
        return new DynamicColor("surface_container", new Function() { // from class: com.google.android.material.color.utilities.k2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 12.0d : 94.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor I1() {
        return new DynamicColor("surface_container_high", new Function() { // from class: com.google.android.material.color.utilities.a0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 17.0d : 92.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor J1() {
        return new DynamicColor("surface_container_highest", new Function() { // from class: com.google.android.material.color.utilities.e1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.f1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 22.0d : 90.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor K1() {
        return new DynamicColor("surface_container_low", new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 10.0d : 96.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor L1() {
        return new DynamicColor("surface_container_lowest", new Function() { // from class: com.google.android.material.color.utilities.q1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.r1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 4.0d : 100.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor M1() {
        return new DynamicColor("surface_dim", new Function() { // from class: com.google.android.material.color.utilities.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 6.0d : 87.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor N1() {
        return new DynamicColor("surface_variant", new Function() { // from class: com.google.android.material.color.utilities.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80628j;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.b1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 30.0d : 90.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor O1() {
        return new DynamicColor("tertiary", new Function() { // from class: com.google.android.material.color.utilities.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80626h;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.H0((DynamicScheme) obj);
            }
        }, true, new a3(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.E0(this.f80722a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor P1() {
        return new DynamicColor("tertiary_container", new Function() { // from class: com.google.android.material.color.utilities.g1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80626h;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.t0((DynamicScheme) obj);
            }
        }, true, new a3(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.j1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.Z(this.f80725a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor Q1() {
        return DynamicColor.c("text_hint_inverse", new Function() { // from class: com.google.android.material.color.utilities.c1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.d1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 10.0d : 90.0d);
            }
        });
    }

    public DynamicColor R1() {
        return DynamicColor.c("text_primary_inverse", new Function() { // from class: com.google.android.material.color.utilities.i2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 10.0d : 90.0d);
            }
        });
    }

    public DynamicColor S1() {
        return DynamicColor.c("text_primary_inverse_disable_only", new Function() { // from class: com.google.android.material.color.utilities.u0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.v0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 10.0d : 90.0d);
            }
        });
    }

    public DynamicColor T1() {
        return DynamicColor.c("text_secondary_and_tertiary_inverse", new Function() { // from class: com.google.android.material.color.utilities.u2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80628j;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.v2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 30.0d : 80.0d);
            }
        });
    }

    public DynamicColor U1() {
        return DynamicColor.c("text_secondary_and_tertiary_inverse_disabled", new Function() { // from class: com.google.android.material.color.utilities.b0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 10.0d : 90.0d);
            }
        });
    }

    public DynamicColor a1() {
        return new DynamicColor("background", new Function() { // from class: com.google.android.material.color.utilities.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 6.0d : 98.0d);
            }
        }, true, null, null, null, null);
    }

    public DynamicColor b1() {
        return DynamicColor.c("control_activated", new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80624f;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 30.0d : 90.0d);
            }
        });
    }

    public DynamicColor c1() {
        return new DynamicColor("control_highlight", new Function() { // from class: com.google.android.material.color.utilities.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 100.0d : 0.0d);
            }
        }, false, null, null, null, null, new Function() { // from class: com.google.android.material.color.utilities.u
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 0.2d : 0.12d);
            }
        });
    }

    public DynamicColor d1() {
        return DynamicColor.c("control_normal", new Function() { // from class: com.google.android.material.color.utilities.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80628j;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.j
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 80.0d : 30.0d);
            }
        });
    }

    public DynamicColor e1() {
        return new DynamicColor("error", new Function() { // from class: com.google.android.material.color.utilities.f2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80629k;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.g2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 80.0d : 40.0d);
            }
        }, true, new a3(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new Function() { // from class: com.google.android.material.color.utilities.h2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.v(this.f80724a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor f1() {
        return new DynamicColor("error_container", new Function() { // from class: com.google.android.material.color.utilities.w2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80629k;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.x2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 30.0d : 90.0d);
            }
        }, true, new a3(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Function() { // from class: com.google.android.material.color.utilities.y2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.U(this.f80737a, (DynamicScheme) obj);
            }
        });
    }

    public DynamicColor h1(DynamicScheme dynamicScheme) {
        return dynamicScheme.f80622d ? G1() : M1();
    }

    public DynamicColor i1() {
        return new DynamicColor("inverse_on_surface", new Function() { // from class: com.google.android.material.color.utilities.v1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.w1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 20.0d : 95.0d);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.x1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80735a.k1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor j1() {
        return new DynamicColor("inverse_primary", new Function() { // from class: com.google.android.material.color.utilities.o0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80624f;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 40.0d : 80.0d);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.q0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80729a.k1();
            }
        }, null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor k1() {
        return new DynamicColor("inverse_surface", new Function() { // from class: com.google.android.material.color.utilities.o2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.q2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 90.0d : 20.0d);
            }
        }, false, null, null, null, null);
    }

    public DynamicColor n1() {
        return new DynamicColor("on_background", new Function() { // from class: com.google.android.material.color.utilities.d0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.e0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 90.0d : 10.0d);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.f0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80723a.a1();
            }
        }, null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), null);
    }

    public DynamicColor o1() {
        return new DynamicColor("on_error", new Function() { // from class: com.google.android.material.color.utilities.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80629k;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.s0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 20.0d : 100.0d);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.t0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80731a.e1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor p1() {
        return new DynamicColor("on_error_container", new Function() { // from class: com.google.android.material.color.utilities.r2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80629k;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.s2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 90.0d : 10.0d);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.t2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80733a.f1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor q1() {
        return new DynamicColor("on_primary", new Function() { // from class: com.google.android.material.color.utilities.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80624f;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.f0((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.n0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80727a.B1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor r1() {
        return new DynamicColor("on_primary_container", new Function() { // from class: com.google.android.material.color.utilities.w0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80624f;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.y0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.b0(this.f80736a, (DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.z0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80738a.C1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor s1() {
        return new DynamicColor("on_secondary", new Function() { // from class: com.google.android.material.color.utilities.k1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80625g;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.D((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.m1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80726a.D1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor t1() {
        return new DynamicColor("on_secondary_container", new Function() { // from class: com.google.android.material.color.utilities.b2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80625g;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.h(this.f80720a, (DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.d2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80721a.E1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor u1() {
        return new DynamicColor("on_surface", new Function() { // from class: com.google.android.material.color.utilities.e2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80627i;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.p2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 90.0d : 10.0d);
            }
        }, false, new a3(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor v1() {
        return new DynamicColor("on_surface_variant", new Function() { // from class: com.google.android.material.color.utilities.m2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80628j;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 80.0d : 30.0d);
            }
        }, false, new a3(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor w1() {
        return new DynamicColor("on_tertiary", new Function() { // from class: com.google.android.material.color.utilities.x0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80626h;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.i1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.o0((DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.t1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80732a.O1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor x1() {
        return new DynamicColor("on_tertiary_container", new Function() { // from class: com.google.android.material.color.utilities.y1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80626h;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.z1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MaterialDynamicColors.s0(this.f80739a, (DynamicScheme) obj);
            }
        }, false, new Function() { // from class: com.google.android.material.color.utilities.a2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f80716a.P1();
            }
        }, null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor y1() {
        return new DynamicColor("outline", new Function() { // from class: com.google.android.material.color.utilities.s1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80628j;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.u1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 60.0d : 50.0d);
            }
        }, false, new a3(this), null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), null);
    }

    public DynamicColor z1() {
        return new DynamicColor("outline_variant", new Function() { // from class: com.google.android.material.color.utilities.g0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DynamicScheme) obj).f80628j;
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.h0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(((DynamicScheme) obj).f80622d ? 30.0d : 80.0d);
            }
        }, false, new a3(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), null);
    }
}

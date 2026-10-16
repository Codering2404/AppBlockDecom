package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ArcCurveFit extends CurveFit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f31719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Arc[] f31720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31721c = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Arc {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static double[] f31722s = new double[91];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double[] f31723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f31724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f31725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f31726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f31727e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        double f31728f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double f31729g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        double f31730h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        double f31731i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        double f31732j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        double f31733k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        double f31734l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        double f31735m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        double f31736n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        double f31737o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        double f31738p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f31739q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f31740r;

        Arc(int i3, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.f31740r = false;
            double d9 = d7 - d5;
            double d10 = d8 - d6;
            if (i3 == 1) {
                this.f31739q = true;
            } else if (i3 == 4) {
                this.f31739q = d10 > 0.0d;
            } else if (i3 != 5) {
                this.f31739q = false;
            } else {
                this.f31739q = d10 < 0.0d;
            }
            this.f31725c = d3;
            this.f31726d = d4;
            this.f31731i = 1.0d / (d4 - d3);
            if (3 == i3) {
                this.f31740r = true;
            }
            if (!this.f31740r && Math.abs(d9) >= 0.001d && Math.abs(d10) >= 0.001d) {
                this.f31723a = new double[101];
                boolean z2 = this.f31739q;
                this.f31732j = d9 * ((double) (z2 ? -1 : 1));
                this.f31733k = d10 * ((double) (z2 ? 1 : -1));
                this.f31734l = z2 ? d7 : d5;
                this.f31735m = z2 ? d6 : d8;
                a(d5, d6, d7, d8);
                this.f31736n = this.f31724b * this.f31731i;
                return;
            }
            this.f31740r = true;
            this.f31727e = d5;
            this.f31728f = d7;
            this.f31729g = d6;
            this.f31730h = d8;
            double dHypot = Math.hypot(d10, d9);
            this.f31724b = dHypot;
            this.f31736n = dHypot * this.f31731i;
            double d11 = this.f31726d;
            double d12 = this.f31725c;
            this.f31734l = d9 / (d11 - d12);
            this.f31735m = d10 / (d11 - d12);
        }

        private void a(double d3, double d4, double d5, double d6) {
            double d7 = d5 - d3;
            double d8 = d4 - d6;
            int i3 = 0;
            double dHypot = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            while (true) {
                if (i3 >= f31722s.length) {
                    break;
                }
                int i4 = i3;
                double radians = Math.toRadians((((double) i3) * 90.0d) / ((double) (r15.length - 1)));
                double dSin = Math.sin(radians) * d7;
                double dCos = Math.cos(radians) * d8;
                if (i4 > 0) {
                    dHypot += Math.hypot(dSin - d9, dCos - d10);
                    f31722s[i4] = dHypot;
                }
                i3 = i4 + 1;
                d9 = dSin;
                d10 = dCos;
            }
            this.f31724b = dHypot;
            int i5 = 0;
            while (true) {
                double[] dArr = f31722s;
                if (i5 >= dArr.length) {
                    break;
                }
                dArr[i5] = dArr[i5] / dHypot;
                i5++;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= this.f31723a.length) {
                    return;
                }
                double length = ((double) i6) / ((double) (r1.length - 1));
                int iBinarySearch = Arrays.binarySearch(f31722s, length);
                if (iBinarySearch >= 0) {
                    this.f31723a[i6] = ((double) iBinarySearch) / ((double) (f31722s.length - 1));
                } else if (iBinarySearch == -1) {
                    this.f31723a[i6] = 0.0d;
                } else {
                    int i7 = -iBinarySearch;
                    int i8 = i7 - 2;
                    double[] dArr2 = f31722s;
                    double d11 = dArr2[i8];
                    this.f31723a[i6] = (((double) i8) + ((length - d11) / (dArr2[i7 - 1] - d11))) / ((double) (dArr2.length - 1));
                }
                i6++;
            }
        }

        double b() {
            double d3 = this.f31732j * this.f31738p;
            double dHypot = this.f31736n / Math.hypot(d3, (-this.f31733k) * this.f31737o);
            return this.f31739q ? (-d3) * dHypot : d3 * dHypot;
        }

        double c() {
            double d3 = this.f31732j * this.f31738p;
            double d4 = (-this.f31733k) * this.f31737o;
            double dHypot = this.f31736n / Math.hypot(d3, d4);
            return this.f31739q ? (-d4) * dHypot : d4 * dHypot;
        }

        public double d(double d3) {
            return this.f31734l;
        }

        public double e(double d3) {
            return this.f31735m;
        }

        public double f(double d3) {
            double d4 = (d3 - this.f31725c) * this.f31731i;
            double d5 = this.f31727e;
            return d5 + (d4 * (this.f31728f - d5));
        }

        public double g(double d3) {
            double d4 = (d3 - this.f31725c) * this.f31731i;
            double d5 = this.f31729g;
            return d5 + (d4 * (this.f31730h - d5));
        }

        double h() {
            return this.f31734l + (this.f31732j * this.f31737o);
        }

        double i() {
            return this.f31735m + (this.f31733k * this.f31738p);
        }

        double j(double d3) {
            if (d3 <= 0.0d) {
                return 0.0d;
            }
            if (d3 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f31723a;
            double length = d3 * ((double) (dArr.length - 1));
            int i3 = (int) length;
            double d4 = length - ((double) i3);
            double d5 = dArr[i3];
            return d5 + (d4 * (dArr[i3 + 1] - d5));
        }

        void k(double d3) {
            double dJ = j((this.f31739q ? this.f31726d - d3 : d3 - this.f31725c) * this.f31731i) * 1.5707963267948966d;
            this.f31737o = Math.sin(dJ);
            this.f31738p = Math.cos(dJ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ArcCurveFit(int[] r23, double[] r24, double[][] r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r0.<init>()
            r2 = 1
            r0.f31721c = r2
            r0.f31719a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.f31720b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.f31720b
            int r8 = r7.length
            if (r4 >= r8) goto L58
            r8 = r23[r4]
            r9 = 3
            if (r8 == 0) goto L38
            if (r8 == r2) goto L36
            r10 = 2
            if (r8 == r10) goto L34
            if (r8 == r9) goto L2f
            r9 = 4
            if (r8 == r9) goto L38
            r9 = 5
            if (r8 == r9) goto L38
            r9 = r6
            goto L38
        L2f:
            if (r5 != r2) goto L36
            goto L34
        L32:
            r9 = r5
            goto L38
        L34:
            r5 = r10
            goto L32
        L36:
            r5 = r2
            goto L32
        L38:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r25[r4]
            r16 = r14
            r14 = r16[r3]
            r16 = r16[r2]
            r18 = r25[r6]
            r20 = r18
            r18 = r20[r3]
            r20 = r20[r2]
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L16
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double c(double d3, int i3) {
        double dG;
        double dE;
        double dI;
        double dC;
        double dG2;
        double dE2;
        int i4 = 0;
        if (this.f31721c) {
            Arc[] arcArr = this.f31720b;
            Arc arc = arcArr[0];
            double d4 = arc.f31725c;
            if (d3 < d4) {
                double d5 = d3 - d4;
                if (arc.f31740r) {
                    if (i3 == 0) {
                        dG2 = arc.f(d4);
                        dE2 = this.f31720b[0].d(d4);
                    } else {
                        dG2 = arc.g(d4);
                        dE2 = this.f31720b[0].e(d4);
                    }
                    return dG2 + (d5 * dE2);
                }
                arc.k(d4);
                if (i3 == 0) {
                    dI = this.f31720b[0].h();
                    dC = this.f31720b[0].b();
                } else {
                    dI = this.f31720b[0].i();
                    dC = this.f31720b[0].c();
                }
                return dI + (d5 * dC);
            }
            if (d3 > arcArr[arcArr.length - 1].f31726d) {
                double d6 = arcArr[arcArr.length - 1].f31726d;
                double d7 = d3 - d6;
                int length = arcArr.length - 1;
                if (i3 == 0) {
                    dG = arcArr[length].f(d6);
                    dE = this.f31720b[length].d(d6);
                } else {
                    dG = arcArr[length].g(d6);
                    dE = this.f31720b[length].e(d6);
                }
                return dG + (d7 * dE);
            }
        } else {
            Arc[] arcArr2 = this.f31720b;
            double d8 = arcArr2[0].f31725c;
            if (d3 < d8) {
                d3 = d8;
            } else if (d3 > arcArr2[arcArr2.length - 1].f31726d) {
                d3 = arcArr2[arcArr2.length - 1].f31726d;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.f31720b;
            if (i4 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i4];
            if (d3 <= arc2.f31726d) {
                if (arc2.f31740r) {
                    return i3 == 0 ? arc2.f(d3) : arc2.g(d3);
                }
                arc2.k(d3);
                return i3 == 0 ? this.f31720b[i4].h() : this.f31720b[i4].i();
            }
            i4++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void d(double d3, double[] dArr) {
        if (this.f31721c) {
            Arc[] arcArr = this.f31720b;
            Arc arc = arcArr[0];
            double d4 = arc.f31725c;
            if (d3 < d4) {
                double d5 = d3 - d4;
                if (arc.f31740r) {
                    dArr[0] = arc.f(d4) + (this.f31720b[0].d(d4) * d5);
                    dArr[1] = this.f31720b[0].g(d4) + (d5 * this.f31720b[0].e(d4));
                    return;
                } else {
                    arc.k(d4);
                    dArr[0] = this.f31720b[0].h() + (this.f31720b[0].b() * d5);
                    dArr[1] = this.f31720b[0].i() + (d5 * this.f31720b[0].c());
                    return;
                }
            }
            if (d3 > arcArr[arcArr.length - 1].f31726d) {
                double d6 = arcArr[arcArr.length - 1].f31726d;
                double d7 = d3 - d6;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.f31740r) {
                    dArr[0] = arc2.f(d6) + (this.f31720b[length].d(d6) * d7);
                    dArr[1] = this.f31720b[length].g(d6) + (d7 * this.f31720b[length].e(d6));
                    return;
                } else {
                    arc2.k(d3);
                    dArr[0] = this.f31720b[length].h() + (this.f31720b[length].b() * d7);
                    dArr[1] = this.f31720b[length].i() + (d7 * this.f31720b[length].c());
                    return;
                }
            }
        } else {
            Arc[] arcArr2 = this.f31720b;
            double d8 = arcArr2[0].f31725c;
            if (d3 < d8) {
                d3 = d8;
            }
            if (d3 > arcArr2[arcArr2.length - 1].f31726d) {
                d3 = arcArr2[arcArr2.length - 1].f31726d;
            }
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr3 = this.f31720b;
            if (i3 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i3];
            if (d3 <= arc3.f31726d) {
                if (arc3.f31740r) {
                    dArr[0] = arc3.f(d3);
                    dArr[1] = this.f31720b[i3].g(d3);
                    return;
                } else {
                    arc3.k(d3);
                    dArr[0] = this.f31720b[i3].h();
                    dArr[1] = this.f31720b[i3].i();
                    return;
                }
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void e(double d3, float[] fArr) {
        if (this.f31721c) {
            Arc[] arcArr = this.f31720b;
            Arc arc = arcArr[0];
            double d4 = arc.f31725c;
            if (d3 < d4) {
                double d5 = d3 - d4;
                if (arc.f31740r) {
                    fArr[0] = (float) (arc.f(d4) + (this.f31720b[0].d(d4) * d5));
                    fArr[1] = (float) (this.f31720b[0].g(d4) + (d5 * this.f31720b[0].e(d4)));
                    return;
                } else {
                    arc.k(d4);
                    fArr[0] = (float) (this.f31720b[0].h() + (this.f31720b[0].b() * d5));
                    fArr[1] = (float) (this.f31720b[0].i() + (d5 * this.f31720b[0].c()));
                    return;
                }
            }
            if (d3 > arcArr[arcArr.length - 1].f31726d) {
                double d6 = arcArr[arcArr.length - 1].f31726d;
                double d7 = d3 - d6;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.f31740r) {
                    fArr[0] = (float) (arc2.f(d6) + (this.f31720b[length].d(d6) * d7));
                    fArr[1] = (float) (this.f31720b[length].g(d6) + (d7 * this.f31720b[length].e(d6)));
                    return;
                } else {
                    arc2.k(d3);
                    fArr[0] = (float) this.f31720b[length].h();
                    fArr[1] = (float) this.f31720b[length].i();
                    return;
                }
            }
        } else {
            Arc[] arcArr2 = this.f31720b;
            double d8 = arcArr2[0].f31725c;
            if (d3 < d8) {
                d3 = d8;
            } else if (d3 > arcArr2[arcArr2.length - 1].f31726d) {
                d3 = arcArr2[arcArr2.length - 1].f31726d;
            }
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr3 = this.f31720b;
            if (i3 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i3];
            if (d3 <= arc3.f31726d) {
                if (arc3.f31740r) {
                    fArr[0] = (float) arc3.f(d3);
                    fArr[1] = (float) this.f31720b[i3].g(d3);
                    return;
                } else {
                    arc3.k(d3);
                    fArr[0] = (float) this.f31720b[i3].h();
                    fArr[1] = (float) this.f31720b[i3].i();
                    return;
                }
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double f(double d3, int i3) {
        Arc[] arcArr = this.f31720b;
        int i4 = 0;
        double d4 = arcArr[0].f31725c;
        if (d3 < d4) {
            d3 = d4;
        }
        if (d3 > arcArr[arcArr.length - 1].f31726d) {
            d3 = arcArr[arcArr.length - 1].f31726d;
        }
        while (true) {
            Arc[] arcArr2 = this.f31720b;
            if (i4 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i4];
            if (d3 <= arc.f31726d) {
                if (arc.f31740r) {
                    return i3 == 0 ? arc.d(d3) : arc.e(d3);
                }
                arc.k(d3);
                return i3 == 0 ? this.f31720b[i4].b() : this.f31720b[i4].c();
            }
            i4++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void g(double d3, double[] dArr) {
        Arc[] arcArr = this.f31720b;
        double d4 = arcArr[0].f31725c;
        if (d3 < d4) {
            d3 = d4;
        } else if (d3 > arcArr[arcArr.length - 1].f31726d) {
            d3 = arcArr[arcArr.length - 1].f31726d;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.f31720b;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d3 <= arc.f31726d) {
                if (arc.f31740r) {
                    dArr[0] = arc.d(d3);
                    dArr[1] = this.f31720b[i3].e(d3);
                    return;
                } else {
                    arc.k(d3);
                    dArr[0] = this.f31720b[i3].b();
                    dArr[1] = this.f31720b[i3].c();
                    return;
                }
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] h() {
        return this.f31719a;
    }
}

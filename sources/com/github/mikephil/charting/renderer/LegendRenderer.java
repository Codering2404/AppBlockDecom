package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LegendRenderer extends Renderer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f68701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f68702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Legend f68703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List f68704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Paint.FontMetrics f68705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f68706g;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f68708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f68709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f68710d;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            f68710d = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68710d[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68710d[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68710d[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68710d[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68710d[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            f68709c = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f68709c[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f68708b = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f68708b[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f68708b[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            f68707a = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f68707a[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f68707a[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.f68704e = new ArrayList(16);
        this.f68705f = new Paint.FontMetrics();
        this.f68706g = new Path();
        this.f68703d = legend;
        Paint paint = new Paint(1);
        this.f68701b = paint;
        paint.setTextSize(Utils.e(9.0f));
        this.f68701b.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f68702c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.github.mikephil.charting.data.ChartData r18) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.a(com.github.mikephil.charting.data.ChartData):void");
    }

    protected void b(Canvas canvas, float f3, float f4, LegendEntry legendEntry, Legend legend) {
        Canvas canvas2;
        int i3 = legendEntry.f68451f;
        if (i3 == 1122868 || i3 == 1122867 || i3 == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm legendFormS = legendEntry.f68447b;
        if (legendFormS == Legend.LegendForm.DEFAULT) {
            legendFormS = legend.s();
        }
        this.f68702c.setColor(legendEntry.f68451f);
        float fE = Utils.e(Float.isNaN(legendEntry.f68448c) ? legend.v() : legendEntry.f68448c);
        float f5 = fE / 2.0f;
        int i4 = AnonymousClass1.f68710d[legendFormS.ordinal()];
        if (i4 == 3 || i4 == 4) {
            canvas2 = canvas;
            this.f68702c.setStyle(Paint.Style.FILL);
            canvas2.drawCircle(f3 + f5, f4, f5, this.f68702c);
        } else if (i4 != 5) {
            if (i4 == 6) {
                float fE2 = Utils.e(Float.isNaN(legendEntry.f68449d) ? legend.u() : legendEntry.f68449d);
                DashPathEffect dashPathEffectT = legendEntry.f68450e;
                if (dashPathEffectT == null) {
                    dashPathEffectT = legend.t();
                }
                this.f68702c.setStyle(Paint.Style.STROKE);
                this.f68702c.setStrokeWidth(fE2);
                this.f68702c.setPathEffect(dashPathEffectT);
                this.f68706g.reset();
                this.f68706g.moveTo(f3, f4);
                this.f68706g.lineTo(f3 + fE, f4);
                canvas.drawPath(this.f68706g, this.f68702c);
            }
            canvas2 = canvas;
        } else {
            this.f68702c.setStyle(Paint.Style.FILL);
            canvas2 = canvas;
            canvas2.drawRect(f3, f4 - f5, f3 + fE, f4 + f5, this.f68702c);
        }
        canvas2.restoreToCount(iSave);
    }

    protected void c(Canvas canvas, float f3, float f4, String str) {
        canvas.drawText(str, f3, f4, this.f68701b);
    }

    public Paint d() {
        return this.f68701b;
    }

    public void e(Canvas canvas) {
        float f3;
        float fM;
        List list;
        boolean z2;
        List list2;
        List list3;
        int i3;
        Canvas canvas2;
        float f4;
        float fJ;
        int i4;
        float f5;
        Canvas canvas3;
        float f6;
        float fD;
        double d3;
        double d4;
        if (this.f68703d.f()) {
            Typeface typefaceC = this.f68703d.c();
            if (typefaceC != null) {
                this.f68701b.setTypeface(typefaceC);
            }
            this.f68701b.setTextSize(this.f68703d.b());
            this.f68701b.setColor(this.f68703d.a());
            float fL = Utils.l(this.f68701b, this.f68705f);
            float fN = Utils.n(this.f68701b, this.f68705f) + Utils.e(this.f68703d.F());
            float fA = fL - (Utils.a(this.f68701b, "ABC") / 2.0f);
            LegendEntry[] legendEntryArrQ = this.f68703d.q();
            float fE = Utils.e(this.f68703d.w());
            float fE2 = Utils.e(this.f68703d.E());
            Legend.LegendOrientation legendOrientationB = this.f68703d.B();
            Legend.LegendHorizontalAlignment legendHorizontalAlignmentX = this.f68703d.x();
            Legend.LegendVerticalAlignment legendVerticalAlignmentD = this.f68703d.D();
            Legend.LegendDirection legendDirectionP = this.f68703d.p();
            float fE3 = Utils.e(this.f68703d.v());
            float fE4 = Utils.e(this.f68703d.C());
            float fE5 = this.f68703d.e();
            float fD2 = this.f68703d.d();
            int i5 = AnonymousClass1.f68707a[legendHorizontalAlignmentX.ordinal()];
            if (i5 == 1) {
                f3 = fE4;
                if (legendOrientationB != Legend.LegendOrientation.VERTICAL) {
                    fD2 += this.f68749a.h();
                }
                fM = legendDirectionP == Legend.LegendDirection.RIGHT_TO_LEFT ? fD2 + this.f68703d.f68421x : fD2;
            } else if (i5 == 2) {
                f3 = fE4;
                fM = (legendOrientationB == Legend.LegendOrientation.VERTICAL ? this.f68749a.m() : this.f68749a.i()) - fD2;
                if (legendDirectionP == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    fM -= this.f68703d.f68421x;
                }
            } else if (i5 != 3) {
                f3 = fE4;
                fM = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                float fM2 = legendOrientationB == legendOrientation ? this.f68749a.m() / 2.0f : this.f68749a.h() + (this.f68749a.k() / 2.0f);
                Legend.LegendDirection legendDirection = Legend.LegendDirection.LEFT_TO_RIGHT;
                f3 = fE4;
                fM = fM2 + (legendDirectionP == legendDirection ? fD2 : -fD2);
                if (legendOrientationB == legendOrientation) {
                    double d5 = fM;
                    if (legendDirectionP == legendDirection) {
                        d3 = d5;
                        d4 = (((double) (-this.f68703d.f68421x)) / 2.0d) + ((double) fD2);
                    } else {
                        d3 = d5;
                        d4 = (((double) this.f68703d.f68421x) / 2.0d) - ((double) fD2);
                    }
                    fM = (float) (d3 + d4);
                }
            }
            int i6 = AnonymousClass1.f68709c[legendOrientationB.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    return;
                }
                int i7 = AnonymousClass1.f68708b[legendVerticalAlignmentD.ordinal()];
                if (i7 == 1) {
                    fJ = (legendHorizontalAlignmentX == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.f68749a.j()) + fE5;
                } else if (i7 == 2) {
                    fJ = (legendHorizontalAlignmentX == Legend.LegendHorizontalAlignment.CENTER ? this.f68749a.l() : this.f68749a.f()) - (this.f68703d.f68422y + fE5);
                } else if (i7 != 3) {
                    fJ = 0.0f;
                } else {
                    float fL2 = this.f68749a.l() / 2.0f;
                    Legend legend = this.f68703d;
                    fJ = (fL2 - (legend.f68422y / 2.0f)) + legend.e();
                }
                float f7 = fJ;
                float f8 = 0.0f;
                int i8 = 0;
                boolean z3 = false;
                while (i8 < legendEntryArrQ.length) {
                    LegendEntry legendEntry = legendEntryArrQ[i8];
                    boolean z4 = legendEntry.f68447b != Legend.LegendForm.NONE;
                    float fE6 = Float.isNaN(legendEntry.f68448c) ? fE3 : Utils.e(legendEntry.f68448c);
                    if (z4) {
                        Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        float f9 = legendDirectionP == legendDirection2 ? fM + f8 : fM - (fE6 - f8);
                        f5 = f3;
                        f6 = fN;
                        i4 = i8;
                        canvas3 = canvas;
                        b(canvas3, f9, f7 + fA, legendEntry, this.f68703d);
                        fD = legendDirectionP == legendDirection2 ? f9 + fE6 : f9;
                    } else {
                        i4 = i8;
                        f5 = f3;
                        canvas3 = canvas;
                        f6 = fN;
                        fD = fM;
                    }
                    if (legendEntry.f68446a != null) {
                        if (z4 && !z3) {
                            fD += legendDirectionP == Legend.LegendDirection.LEFT_TO_RIGHT ? fE : -fE;
                        } else if (z3) {
                            fD = fM;
                        }
                        if (legendDirectionP == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fD -= Utils.d(this.f68701b, r2);
                        }
                        if (z3) {
                            f7 += fL + f6;
                            c(canvas3, fD, f7 + fL, legendEntry.f68446a);
                        } else {
                            c(canvas3, fD, f7 + fL, legendEntry.f68446a);
                        }
                        f7 += fL + f6;
                        f8 = 0.0f;
                    } else {
                        f8 += fE6 + f5;
                        z3 = true;
                    }
                    i8 = i4 + 1;
                    fN = f6;
                    f3 = f5;
                }
                return;
            }
            float f10 = f3;
            List listO = this.f68703d.o();
            List listN = this.f68703d.n();
            List listM = this.f68703d.m();
            int i9 = AnonymousClass1.f68708b[legendVerticalAlignmentD.ordinal()];
            float f11 = fM;
            if (i9 != 1) {
                fE5 = i9 != 2 ? i9 != 3 ? 0.0f : fE5 + ((this.f68749a.l() - this.f68703d.f68422y) / 2.0f) : (this.f68749a.l() - fE5) - this.f68703d.f68422y;
            }
            int length = legendEntryArrQ.length;
            float f12 = f11;
            int i10 = 0;
            int i11 = 0;
            while (i11 < length) {
                float f13 = fE5;
                LegendEntry legendEntry2 = legendEntryArrQ[i11];
                List list4 = listN;
                int i12 = length;
                boolean z5 = legendEntry2.f68447b != Legend.LegendForm.NONE;
                float fE7 = Float.isNaN(legendEntry2.f68448c) ? fE3 : Utils.e(legendEntry2.f68448c);
                if (i11 < listM.size() && ((Boolean) listM.get(i11)).booleanValue()) {
                    f13 += fL + fN;
                    f12 = f11;
                }
                if (f12 == f11 && legendHorizontalAlignmentX == Legend.LegendHorizontalAlignment.CENTER && i10 < listO.size()) {
                    f12 += (legendDirectionP == Legend.LegendDirection.RIGHT_TO_LEFT ? ((FSize) listO.get(i10)).f68786c : -((FSize) listO.get(i10)).f68786c) / 2.0f;
                    i10++;
                }
                float f14 = f12;
                int i13 = i10;
                float f15 = f14;
                boolean z6 = legendEntry2.f68446a == null;
                if (z5) {
                    if (legendDirectionP == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f15 -= fE7;
                    }
                    float f16 = f15;
                    z2 = z5;
                    i3 = i11;
                    list = listO;
                    list2 = list4;
                    list3 = listM;
                    b(canvas, f16, f13 + fA, legendEntry2, this.f68703d);
                    canvas2 = canvas;
                    f15 = legendDirectionP == Legend.LegendDirection.LEFT_TO_RIGHT ? f16 + fE7 : f16;
                } else {
                    list = listO;
                    z2 = z5;
                    list2 = list4;
                    list3 = listM;
                    i3 = i11;
                    canvas2 = canvas;
                }
                if (z6) {
                    f4 = legendDirectionP == Legend.LegendDirection.RIGHT_TO_LEFT ? -f10 : f10;
                } else {
                    if (z2) {
                        f15 += legendDirectionP == Legend.LegendDirection.RIGHT_TO_LEFT ? -fE : fE;
                    }
                    Legend.LegendDirection legendDirection3 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (legendDirectionP == legendDirection3) {
                        f15 -= ((FSize) list2.get(i3)).f68786c;
                    }
                    c(canvas2, f15, f13 + fL, legendEntry2.f68446a);
                    if (legendDirectionP == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f15 += ((FSize) list2.get(i3)).f68786c;
                    }
                    f4 = legendDirectionP == legendDirection3 ? -fE2 : fE2;
                }
                i11 = i3 + 1;
                f12 = f15 + f4;
                i10 = i13;
                listN = list2;
                fE5 = f13;
                listM = list3;
                length = i12;
                listO = list;
            }
        }
    }
}

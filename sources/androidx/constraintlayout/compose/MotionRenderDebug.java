package androidx.constraintlayout.compose;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.Motion;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionRenderDebug {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f30900u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f30901v = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f30902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f30903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f30904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Path f30905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f30906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f30907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f30908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f30909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f30910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f30911j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private DashPathEffect f30917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f30918q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f30920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f30921t;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f30912k = -21965;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f30913l = -2067046;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f30914m = -13391360;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f30915n = 1996488704;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f30916o = 10;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Rect f30919r = new Rect();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MotionRenderDebug(float f3) {
        this.f30921t = 1;
        Paint paint = new Paint();
        this.f30906e = paint;
        paint.setAntiAlias(true);
        this.f30906e.setColor(-21965);
        this.f30906e.setStrokeWidth(2.0f);
        Paint paint2 = this.f30906e;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f30907f = paint3;
        paint3.setAntiAlias(true);
        this.f30907f.setColor(-2067046);
        this.f30907f.setStrokeWidth(2.0f);
        this.f30907f.setStyle(style);
        Paint paint4 = new Paint();
        this.f30908g = paint4;
        paint4.setAntiAlias(true);
        this.f30908g.setColor(-13391360);
        this.f30908g.setStrokeWidth(2.0f);
        this.f30908g.setStyle(style);
        Paint paint5 = new Paint();
        this.f30909h = paint5;
        paint5.setAntiAlias(true);
        this.f30909h.setColor(-13391360);
        this.f30909h.setTextSize(f3);
        this.f30911j = new float[8];
        Paint paint6 = new Paint();
        this.f30910i = paint6;
        paint6.setAntiAlias(true);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f30917p = dashPathEffect;
        this.f30908g.setPathEffect(dashPathEffect);
        this.f30904c = new float[100];
        this.f30903b = new int[50];
        if (this.f30920s) {
            this.f30906e.setStrokeWidth(8.0f);
            this.f30910i.setStrokeWidth(8.0f);
            this.f30907f.setStrokeWidth(8.0f);
            this.f30921t = 4;
        }
    }

    private final void b(Canvas canvas) {
        float[] fArr = this.f30902a;
        Intrinsics.checkNotNull(fArr);
        canvas.drawLines(fArr, this.f30906e);
    }

    private final void c(Canvas canvas, float f3, float f4) {
        float[] fArr = this.f30902a;
        Intrinsics.checkNotNull(fArr);
        float f5 = fArr[0];
        float[] fArr2 = this.f30902a;
        Intrinsics.checkNotNull(fArr2);
        float f6 = fArr2[1];
        float[] fArr3 = this.f30902a;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.f30902a;
        Intrinsics.checkNotNull(fArr4);
        float f7 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.f30902a;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.f30902a;
        Intrinsics.checkNotNull(fArr6);
        float f8 = fArr5[fArr6.length - 1];
        float fMin = Math.min(f5, f7);
        float fMax = Math.max(f6, f8);
        float fMin2 = f3 - Math.min(f5, f7);
        float fMax2 = Math.max(f6, f8) - f4;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        float f9 = 100;
        sb.append(((int) (((double) ((f9 * fMin2) / Math.abs(f7 - f5))) + 0.5d)) / 100.0f);
        String string = sb.toString();
        g(string, this.f30909h);
        float f10 = 2;
        canvas.drawText(string, ((fMin2 / f10) - (this.f30919r.width() / 2)) + fMin, f4 - 20, this.f30909h);
        canvas.drawLine(f3, f4, Math.min(f5, f7), f4, this.f30908g);
        String str = "" + (((int) (((double) ((f9 * fMax2) / Math.abs(f8 - f6))) + 0.5d)) / 100.0f);
        g(str, this.f30909h);
        canvas.drawText(str, f3 + 5, fMax - ((fMax2 / f10) - (this.f30919r.height() / 2)), this.f30909h);
        canvas.drawLine(f3, f4, f3, Math.max(f6, f8), this.f30908g);
    }

    private final void d(Canvas canvas, float f3, float f4) {
        float[] fArr = this.f30902a;
        Intrinsics.checkNotNull(fArr);
        float f5 = fArr[0];
        float[] fArr2 = this.f30902a;
        Intrinsics.checkNotNull(fArr2);
        float f6 = fArr2[1];
        float[] fArr3 = this.f30902a;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.f30902a;
        Intrinsics.checkNotNull(fArr4);
        float f7 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.f30902a;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.f30902a;
        Intrinsics.checkNotNull(fArr6);
        float f8 = fArr5[fArr6.length - 1];
        float fHypot = (float) Math.hypot(f5 - f7, f6 - f8);
        float f9 = f7 - f5;
        float f10 = f8 - f6;
        float f11 = (((f3 - f5) * f9) + ((f4 - f6) * f10)) / (fHypot * fHypot);
        float f12 = f5 + (f9 * f11);
        float f13 = f6 + (f11 * f10);
        Path path = new Path();
        path.moveTo(f3, f4);
        path.lineTo(f12, f13);
        float fHypot2 = (float) Math.hypot(f12 - f3, f13 - f4);
        String str = "" + (((int) ((100 * fHypot2) / fHypot)) / 100.0f);
        g(str, this.f30909h);
        canvas.drawTextOnPath(str, path, (fHypot2 / 2) - (this.f30919r.width() / 2), -20.0f, this.f30909h);
        canvas.drawLine(f3, f4, f12, f13, this.f30908g);
    }

    private final void e(Canvas canvas, float f3, float f4, int i3, int i4, int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        float f5 = 100;
        sb.append(((int) (((double) (((f3 - (i3 / 2)) * f5) / (i5 - i3))) + 0.5d)) / 100.0f);
        String string = sb.toString();
        g(string, this.f30909h);
        float f6 = 2;
        canvas.drawText(string, ((f3 / f6) - (this.f30919r.width() / 2)) + 0.0f, f4 - 20, this.f30909h);
        canvas.drawLine(f3, f4, Math.min(0.0f, 1.0f), f4, this.f30908g);
        String str = "" + (((int) (((double) ((f5 * (f4 - (i4 / 2))) / (i6 - i4))) + 0.5d)) / 100.0f);
        g(str, this.f30909h);
        canvas.drawText(str, f3 + 5, 0.0f - ((f4 / f6) - (this.f30919r.height() / 2)), this.f30909h);
        canvas.drawLine(f3, f4, f3, Math.max(0.0f, 1.0f), this.f30908g);
    }

    private final void f(Canvas canvas, int i3, int i4, Motion motion, int i5, int i6) {
        int iB;
        int iK;
        if (motion.r() != null) {
            iB = motion.r().B();
            iK = motion.r().k();
        } else {
            iB = 0;
            iK = 0;
        }
        int i7 = i4 - 1;
        for (int i8 = 1; i8 < i7; i8++) {
            if (i3 != 4 || this.f30903b[i8 - 1] != 0) {
                float[] fArr = this.f30904c;
                int i9 = i8 * 2;
                float f3 = fArr[i9];
                float f4 = fArr[i9 + 1];
                Path path = this.f30905d;
                Intrinsics.checkNotNull(path);
                path.reset();
                Path path2 = this.f30905d;
                Intrinsics.checkNotNull(path2);
                path2.moveTo(f3, this.f30916o + f4);
                Path path3 = this.f30905d;
                Intrinsics.checkNotNull(path3);
                path3.lineTo(this.f30916o + f3, f4);
                Path path4 = this.f30905d;
                Intrinsics.checkNotNull(path4);
                path4.lineTo(f3, f4 - this.f30916o);
                Path path5 = this.f30905d;
                Intrinsics.checkNotNull(path5);
                path5.lineTo(f3 - this.f30916o, f4);
                Path path6 = this.f30905d;
                Intrinsics.checkNotNull(path6);
                path6.close();
                if (i3 == 4) {
                    int i10 = this.f30903b[i8 - 1];
                    if (i10 == 1) {
                        d(canvas, f3 - 0.0f, f4 - 0.0f);
                    } else if (i10 == 0) {
                        c(canvas, f3 - 0.0f, f4 - 0.0f);
                    } else if (i10 == 2) {
                        e(canvas, f3 - 0.0f, f4 - 0.0f, iB, iK, i5, i6);
                    }
                    Path path7 = this.f30905d;
                    Intrinsics.checkNotNull(path7);
                    canvas.drawPath(path7, this.f30910i);
                }
                if (i3 == 2) {
                    d(canvas, f3 - 0.0f, f4 - 0.0f);
                }
                if (i3 == 3) {
                    c(canvas, f3 - 0.0f, f4 - 0.0f);
                }
                if (i3 == 6) {
                    e(canvas, f3 - 0.0f, f4 - 0.0f, iB, iK, i5, i6);
                }
                Path path8 = this.f30905d;
                Intrinsics.checkNotNull(path8);
                canvas.drawPath(path8, this.f30910i);
            }
        }
        float[] fArr2 = this.f30902a;
        Intrinsics.checkNotNull(fArr2);
        if (fArr2.length > 1) {
            float[] fArr3 = this.f30902a;
            Intrinsics.checkNotNull(fArr3);
            float f5 = fArr3[0];
            float[] fArr4 = this.f30902a;
            Intrinsics.checkNotNull(fArr4);
            canvas.drawCircle(f5, fArr4[1], 8.0f, this.f30907f);
            float[] fArr5 = this.f30902a;
            Intrinsics.checkNotNull(fArr5);
            float[] fArr6 = this.f30902a;
            Intrinsics.checkNotNull(fArr6);
            float f6 = fArr5[fArr6.length - 2];
            float[] fArr7 = this.f30902a;
            Intrinsics.checkNotNull(fArr7);
            float[] fArr8 = this.f30902a;
            Intrinsics.checkNotNull(fArr8);
            canvas.drawCircle(f6, fArr7[fArr8.length - 1], 8.0f, this.f30907f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.graphics.Canvas r9, androidx.constraintlayout.core.motion.Motion r10, int r11, int r12, int r13, boolean r14, boolean r15) {
        /*
            r8 = this;
            float[] r0 = r8.f30904c
            int[] r1 = r8.f30903b
            r2 = 0
            int r0 = r10.g(r0, r1, r2)
            r8.f30918q = r0
            int r11 = r11 / 16
            float[] r0 = r8.f30902a
            if (r0 == 0) goto L19
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length
            int r1 = r11 * 2
            if (r0 == r1) goto L26
        L19:
            int r0 = r11 * 2
            float[] r0 = new float[r0]
            r8.f30902a = r0
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            r8.f30905d = r0
        L26:
            int r0 = r8.f30921t
            float r1 = (float) r0
            float r0 = (float) r0
            r9.translate(r1, r0)
            android.graphics.Paint r0 = r8.f30906e
            int r1 = r8.f30915n
            r0.setColor(r1)
            android.graphics.Paint r0 = r8.f30910i
            int r1 = r8.f30915n
            r0.setColor(r1)
            android.graphics.Paint r0 = r8.f30907f
            int r1 = r8.f30915n
            r0.setColor(r1)
            android.graphics.Paint r0 = r8.f30908g
            int r1 = r8.f30915n
            r0.setColor(r1)
            float[] r0 = r8.f30902a
            r10.h(r0, r11)
            if (r14 == 0) goto L53
            r8.b(r9)
        L53:
            r3 = 1
            if (r15 == 0) goto L61
            int r4 = r8.f30918q
            r1 = r8
            r2 = r9
            r5 = r10
            r6 = r12
            r7 = r13
            r1.f(r2, r3, r4, r5, r6, r7)
            goto L66
        L61:
            r1 = r8
            r2 = r9
            r5 = r10
            r6 = r12
            r7 = r13
        L66:
            android.graphics.Paint r9 = r1.f30906e
            int r10 = r1.f30912k
            r9.setColor(r10)
            android.graphics.Paint r9 = r1.f30907f
            int r10 = r1.f30913l
            r9.setColor(r10)
            android.graphics.Paint r9 = r1.f30910i
            int r10 = r1.f30913l
            r9.setColor(r10)
            android.graphics.Paint r9 = r1.f30908g
            int r10 = r1.f30914m
            r9.setColor(r10)
            int r9 = r1.f30921t
            float r10 = (float) r9
            float r10 = -r10
            float r9 = (float) r9
            float r9 = -r9
            r2.translate(r10, r9)
            if (r14 == 0) goto L90
            r8.b(r2)
        L90:
            if (r15 == 0) goto L97
            int r4 = r1.f30918q
            r1.f(r2, r3, r4, r5, r6, r7)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionRenderDebug.a(android.graphics.Canvas, androidx.constraintlayout.core.motion.Motion, int, int, int, boolean, boolean):void");
    }

    public final void g(String str, Paint paint) {
        paint.getTextBounds(str, 0, str.length(), this.f30919r);
    }
}

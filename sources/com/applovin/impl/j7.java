package com.applovin.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.a5;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class j7 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f60622h = {0, 7, 8, Ascii.SI};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f60623i = {0, 119, -120, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f60624j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f60625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f60626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Canvas f60627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f60628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f60629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f60630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f60631g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f60633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f60634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f60635d;

        public a(int i3, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f60632a = i3;
            this.f60633b = iArr;
            this.f60634c = iArr2;
            this.f60635d = iArr3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f60638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f60639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f60640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f60641f;

        public b(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f60636a = i3;
            this.f60637b = i4;
            this.f60638c = i5;
            this.f60639d = i6;
            this.f60640e = i7;
            this.f60641f = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f60643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f60644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f60645d;

        public c(int i3, boolean z2, byte[] bArr, byte[] bArr2) {
            this.f60642a = i3;
            this.f60643b = z2;
            this.f60644c = bArr;
            this.f60645d = bArr2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f60648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray f60649d;

        public d(int i3, int i4, int i5, SparseArray sparseArray) {
            this.f60646a = i3;
            this.f60647b = i4;
            this.f60648c = i5;
            this.f60649d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60651b;

        public e(int i3, int i4) {
            this.f60650a = i3;
            this.f60651b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f60653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f60654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f60655d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f60656e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f60657f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f60658g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f60659h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f60660i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f60661j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray f60662k;

        public f(int i3, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, SparseArray sparseArray) {
            this.f60652a = i3;
            this.f60653b = z2;
            this.f60654c = i4;
            this.f60655d = i5;
            this.f60656e = i6;
            this.f60657f = i7;
            this.f60658g = i8;
            this.f60659h = i9;
            this.f60660i = i10;
            this.f60661j = i11;
            this.f60662k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray sparseArray = fVar.f60662k;
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                this.f60662k.put(sparseArray.keyAt(i3), (g) sparseArray.valueAt(i3));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f60665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f60666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f60667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f60668f;

        public g(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f60663a = i3;
            this.f60664b = i4;
            this.f60665c = i5;
            this.f60666d = i6;
            this.f60667e = i7;
            this.f60668f = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray f60671c = new SparseArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray f60672d = new SparseArray();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray f60673e = new SparseArray();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray f60674f = new SparseArray();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray f60675g = new SparseArray();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b f60676h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d f60677i;

        public h(int i3, int i4) {
            this.f60669a = i3;
            this.f60670b = i4;
        }

        public void a() {
            this.f60671c.clear();
            this.f60672d.clear();
            this.f60673e.clear();
            this.f60674f.clear();
            this.f60675g.clear();
            this.f60676h = null;
            this.f60677i = null;
        }
    }

    public j7(int i3, int i4) {
        Paint paint = new Paint();
        this.f60625a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f60626b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f60627c = new Canvas();
        this.f60628d = new b(719, 575, 0, 719, 0, 575);
        this.f60629e = new a(0, a(), b(), c());
        this.f60630f = new h(i3, i4);
    }

    private static int a(int i3, int i4, int i5, int i6) {
        return (i3 << 24) | (i4 << 16) | (i5 << 8) | i6;
    }

    private static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i3 = 1; i3 < 16; i3++) {
            if (i3 < 8) {
                iArr[i3] = a(255, (i3 & 1) != 0 ? 255 : 0, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i3] = a(255, (i3 & 1) != 0 ? 127 : 0, (i3 & 2) != 0 ? 127 : 0, (i3 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] c() {
        int[] iArr = new int[Function.MAX_NARGS];
        iArr[0] = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (i3 < 8) {
                iArr[i3] = a(63, (i3 & 1) != 0 ? 255 : 0, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) == 0 ? 0 : 255);
            } else {
                int i4 = i3 & 136;
                if (i4 == 0) {
                    iArr[i3] = a(255, ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? 170 : 0), ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0), ((i3 & 4) == 0 ? 0 : 85) + ((i3 & 64) == 0 ? 0 : 170));
                } else if (i4 == 8) {
                    iArr[i3] = a(127, ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? 170 : 0), ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0), ((i3 & 4) == 0 ? 0 : 85) + ((i3 & 64) == 0 ? 0 : 170));
                } else if (i4 == 128) {
                    iArr[i3] = a(255, ((i3 & 1) != 0 ? 43 : 0) + 127 + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + 127 + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + 127 + ((i3 & 64) == 0 ? 0 : 85));
                } else if (i4 == 136) {
                    iArr[i3] = a(255, ((i3 & 1) != 0 ? 43 : 0) + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + ((i3 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public void d() {
        this.f60630f.a();
    }

    private static byte[] a(int i3, int i4, zg zgVar) {
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) zgVar.a(i4);
        }
        return bArr;
    }

    private static int[] a() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int a(zg zgVar, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2;
        int i5;
        int iA;
        int iA2;
        boolean z3 = false;
        while (true) {
            int iA3 = zgVar.a(2);
            if (iA3 != 0) {
                z2 = z3;
                i5 = 1;
            } else {
                if (zgVar.f()) {
                    iA = zgVar.a(3) + 3;
                    iA2 = zgVar.a(2);
                } else {
                    if (zgVar.f()) {
                        z2 = z3;
                        i5 = 1;
                    } else {
                        int iA4 = zgVar.a(2);
                        if (iA4 == 0) {
                            z2 = true;
                        } else if (iA4 == 1) {
                            z2 = z3;
                            i5 = 2;
                        } else if (iA4 == 2) {
                            iA = zgVar.a(4) + 12;
                            iA2 = zgVar.a(2);
                        } else if (iA4 != 3) {
                            z2 = z3;
                        } else {
                            iA = zgVar.a(8) + 29;
                            iA2 = zgVar.a(2);
                        }
                        iA3 = 0;
                        i5 = 0;
                    }
                    iA3 = 0;
                }
                z2 = z3;
                i5 = iA;
                iA3 = iA2;
            }
            if (i5 != 0 && paint != null) {
                if (bArr != null) {
                    iA3 = bArr[iA3];
                }
                paint.setColor(iArr[iA3]);
                canvas.drawRect(i3, i4, i3 + i5, 1 + i4, paint);
            }
            i3 += i5;
            if (z2) {
                return i3;
            }
            z3 = z2;
        }
    }

    private static int b(zg zgVar, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2;
        int i5;
        int iA;
        int iA2;
        boolean z3 = false;
        while (true) {
            int iA3 = zgVar.a(4);
            if (iA3 != 0) {
                z2 = z3;
                i5 = 1;
            } else if (!zgVar.f()) {
                int iA4 = zgVar.a(3);
                if (iA4 != 0) {
                    z2 = z3;
                    i5 = iA4 + 2;
                    iA3 = 0;
                } else {
                    z2 = true;
                    iA3 = 0;
                    i5 = 0;
                }
            } else {
                if (!zgVar.f()) {
                    iA = zgVar.a(2) + 4;
                    iA2 = zgVar.a(4);
                } else {
                    int iA5 = zgVar.a(2);
                    if (iA5 == 0) {
                        z2 = z3;
                        i5 = 1;
                        iA3 = 0;
                    } else if (iA5 == 1) {
                        iA3 = 0;
                        i5 = 2;
                        z2 = z3;
                    } else if (iA5 == 2) {
                        iA = zgVar.a(4) + 9;
                        iA2 = zgVar.a(4);
                    } else if (iA5 != 3) {
                        z2 = z3;
                        iA3 = 0;
                        i5 = 0;
                    } else {
                        iA = zgVar.a(8) + 25;
                        iA2 = zgVar.a(4);
                    }
                }
                z2 = z3;
                i5 = iA;
                iA3 = iA2;
            }
            if (i5 != 0 && paint != null) {
                if (bArr != null) {
                    iA3 = bArr[iA3];
                }
                paint.setColor(iArr[iA3]);
                canvas.drawRect(i3, i4, i3 + i5, 1 + i4, paint);
            }
            i3 += i5;
            if (z2) {
                return i3;
            }
            z3 = z2;
        }
    }

    private static int c(zg zgVar, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2;
        int iA;
        boolean z3 = false;
        while (true) {
            int iA2 = zgVar.a(8);
            if (iA2 != 0) {
                z2 = z3;
                iA = 1;
            } else if (!zgVar.f()) {
                int iA3 = zgVar.a(7);
                if (iA3 != 0) {
                    z2 = z3;
                    iA = iA3;
                    iA2 = 0;
                } else {
                    z2 = true;
                    iA2 = 0;
                    iA = 0;
                }
            } else {
                z2 = z3;
                iA = zgVar.a(7);
                iA2 = zgVar.a(8);
            }
            if (iA != 0 && paint != null) {
                if (bArr != null) {
                    iA2 = bArr[iA2];
                }
                paint.setColor(iArr[iA2]);
                canvas.drawRect(i3, i4, i3 + iA, 1 + i4, paint);
            }
            i3 += iA;
            if (z2) {
                return i3;
            }
            z3 = z2;
        }
    }

    private static f c(zg zgVar, int i3) {
        int i4;
        int iA;
        int iA2;
        char c3;
        int iA3 = zgVar.a(8);
        int i5 = 4;
        zgVar.d(4);
        boolean zF = zgVar.f();
        zgVar.d(3);
        int i6 = 16;
        int iA4 = zgVar.a(16);
        int iA5 = zgVar.a(16);
        int iA6 = zgVar.a(3);
        int iA7 = zgVar.a(3);
        int i7 = 2;
        zgVar.d(2);
        int iA8 = zgVar.a(8);
        int iA9 = zgVar.a(8);
        int iA10 = zgVar.a(4);
        int iA11 = zgVar.a(2);
        zgVar.d(2);
        int i8 = i3 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i8 > 0) {
            int iA12 = zgVar.a(i6);
            int iA13 = zgVar.a(i7);
            int iA14 = zgVar.a(i7);
            int iA15 = zgVar.a(12);
            zgVar.d(i5);
            int iA16 = zgVar.a(12);
            int i9 = i8 - 6;
            if (iA13 != 1) {
                i4 = 2;
                if (iA13 != 2) {
                    iA2 = 0;
                    iA = 0;
                    i8 = i9;
                    c3 = '\b';
                }
                sparseArray.put(iA12, new g(iA13, iA14, iA15, iA16, iA2, iA));
                i6 = 16;
                i7 = i4;
                i5 = 4;
            } else {
                i4 = 2;
            }
            c3 = '\b';
            i8 -= 8;
            iA2 = zgVar.a(8);
            iA = zgVar.a(8);
            sparseArray.put(iA12, new g(iA13, iA14, iA15, iA16, iA2, iA));
            i6 = 16;
            i7 = i4;
            i5 = 4;
        }
        return new f(iA3, zF, iA4, iA5, iA6, iA7, iA8, iA9, iA10, iA11, sparseArray);
    }

    private static void a(c cVar, a aVar, int i3, int i4, int i5, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i3 == 3) {
            iArr = aVar.f60635d;
        } else if (i3 == 2) {
            iArr = aVar.f60634c;
        } else {
            iArr = aVar.f60633b;
        }
        int[] iArr2 = iArr;
        a(cVar.f60644c, iArr2, i3, i4, i5, paint, canvas);
        a(cVar.f60645d, iArr2, i3, i4, i5 + 1, paint, canvas);
    }

    private static c b(zg zgVar) {
        byte[] bArr;
        int iA = zgVar.a(16);
        zgVar.d(4);
        int iA2 = zgVar.a(2);
        boolean zF = zgVar.f();
        zgVar.d(1);
        byte[] bArr2 = xp.f65032f;
        if (iA2 == 1) {
            zgVar.d(zgVar.a(8) * 16);
        } else {
            if (iA2 == 0) {
                int iA3 = zgVar.a(16);
                int iA4 = zgVar.a(16);
                if (iA3 > 0) {
                    bArr2 = new byte[iA3];
                    zgVar.b(bArr2, 0, iA3);
                }
                if (iA4 > 0) {
                    bArr = new byte[iA4];
                    zgVar.b(bArr, 0, iA4);
                }
            }
            return new c(iA, zF, bArr2, bArr);
        }
        bArr = bArr2;
        return new c(iA, zF, bArr2, bArr);
    }

    private static a a(zg zgVar, int i3) {
        int iA;
        int i4;
        int iA2;
        int iA3;
        int iA4;
        int i5 = 8;
        int iA5 = zgVar.a(8);
        zgVar.d(8);
        int i6 = 2;
        int i7 = i3 - 2;
        int[] iArrA = a();
        int[] iArrB = b();
        int[] iArrC = c();
        while (i7 > 0) {
            int iA6 = zgVar.a(i5);
            int iA7 = zgVar.a(i5);
            int[] iArr = (iA7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? iArrA : (iA7 & 64) != 0 ? iArrB : iArrC;
            if ((iA7 & 1) != 0) {
                iA3 = zgVar.a(i5);
                iA4 = zgVar.a(i5);
                iA = zgVar.a(i5);
                iA2 = zgVar.a(i5);
                i4 = i7 - 6;
            } else {
                int iA8 = zgVar.a(6) << i6;
                int iA9 = zgVar.a(4) << 4;
                iA = zgVar.a(4) << 4;
                i4 = i7 - 4;
                iA2 = zgVar.a(i6) << 6;
                iA3 = iA8;
                iA4 = iA9;
            }
            if (iA3 == 0) {
                iA2 = 255;
                iA4 = 0;
                iA = 0;
            }
            double d3 = iA3;
            double d4 = iA4 - 128;
            double d5 = iA - 128;
            iArr[iA6] = a((byte) (255 - (iA2 & 255)), xp.a((int) (d3 + (1.402d * d4)), 0, 255), xp.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), xp.a((int) (d3 + (d5 * 1.772d)), 0, 255));
            i7 = i4;
            iA5 = iA5;
            i5 = 8;
            i6 = 2;
        }
        return new a(iA5, iArrA, iArrB, iArrC);
    }

    private static d b(zg zgVar, int i3) {
        int iA = zgVar.a(8);
        int iA2 = zgVar.a(4);
        int iA3 = zgVar.a(2);
        zgVar.d(2);
        int i4 = i3 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int iA4 = zgVar.a(8);
            zgVar.d(8);
            i4 -= 6;
            sparseArray.put(iA4, new e(zgVar.a(16), zgVar.a(16)));
        }
        return new d(iA, iA2, iA3, sparseArray);
    }

    private static b a(zg zgVar) {
        int i3;
        int i4;
        int i5;
        int iA;
        zgVar.d(4);
        boolean zF = zgVar.f();
        zgVar.d(3);
        int iA2 = zgVar.a(16);
        int iA3 = zgVar.a(16);
        if (zF) {
            int iA4 = zgVar.a(16);
            int iA5 = zgVar.a(16);
            int iA6 = zgVar.a(16);
            iA = zgVar.a(16);
            i5 = iA5;
            i4 = iA6;
            i3 = iA4;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = iA2;
            iA = iA3;
        }
        return new b(iA2, iA3, i3, i5, i4, iA);
    }

    private static void a(zg zgVar, h hVar) {
        f fVar;
        int iA = zgVar.a(8);
        int iA2 = zgVar.a(16);
        int iA3 = zgVar.a(16);
        int iD = zgVar.d() + iA3;
        if (iA3 * 8 > zgVar.b()) {
            oc.d("DvbParser", "Data field length exceeds limit");
            zgVar.d(zgVar.b());
            return;
        }
        switch (iA) {
            case 16:
                if (iA2 == hVar.f60669a) {
                    d dVar = hVar.f60677i;
                    d dVarB = b(zgVar, iA3);
                    if (dVarB.f60648c != 0) {
                        hVar.f60677i = dVarB;
                        hVar.f60671c.clear();
                        hVar.f60672d.clear();
                        hVar.f60673e.clear();
                    } else if (dVar != null && dVar.f60647b != dVarB.f60647b) {
                        hVar.f60677i = dVarB;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f60677i;
                if (iA2 == hVar.f60669a && dVar2 != null) {
                    f fVarC = c(zgVar, iA3);
                    if (dVar2.f60648c == 0 && (fVar = (f) hVar.f60671c.get(fVarC.f60652a)) != null) {
                        fVarC.a(fVar);
                    }
                    hVar.f60671c.put(fVarC.f60652a, fVarC);
                }
                break;
            case 18:
                if (iA2 == hVar.f60669a) {
                    a aVarA = a(zgVar, iA3);
                    hVar.f60672d.put(aVarA.f60632a, aVarA);
                } else if (iA2 == hVar.f60670b) {
                    a aVarA2 = a(zgVar, iA3);
                    hVar.f60674f.put(aVarA2.f60632a, aVarA2);
                }
                break;
            case 19:
                if (iA2 == hVar.f60669a) {
                    c cVarB = b(zgVar);
                    hVar.f60673e.put(cVarB.f60642a, cVarB);
                } else if (iA2 == hVar.f60670b) {
                    c cVarB2 = b(zgVar);
                    hVar.f60675g.put(cVarB2.f60642a, cVarB2);
                }
                break;
            case 20:
                if (iA2 == hVar.f60669a) {
                    hVar.f60676h = a(zgVar);
                }
                break;
        }
        zgVar.e(iD - zgVar.d());
    }

    public List a(byte[] bArr, int i3) {
        int i4;
        SparseArray sparseArray;
        int i5;
        zg zgVar = new zg(bArr, i3);
        while (zgVar.b() >= 48 && zgVar.a(8) == 15) {
            a(zgVar, this.f60630f);
        }
        h hVar = this.f60630f;
        d dVar = hVar.f60677i;
        if (dVar == null) {
            return Collections.EMPTY_LIST;
        }
        b bVar = hVar.f60676h;
        if (bVar == null) {
            bVar = this.f60628d;
        }
        Bitmap bitmap = this.f60631g;
        if (bitmap == null || bVar.f60636a + 1 != bitmap.getWidth() || bVar.f60637b + 1 != this.f60631g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar.f60636a + 1, bVar.f60637b + 1, Bitmap.Config.ARGB_8888);
            this.f60631g = bitmapCreateBitmap;
            this.f60627c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = dVar.f60649d;
        int i6 = 0;
        while (i6 < sparseArray2.size()) {
            this.f60627c.save();
            e eVar = (e) sparseArray2.valueAt(i6);
            f fVar = (f) this.f60630f.f60671c.get(sparseArray2.keyAt(i6));
            int i7 = eVar.f60650a + bVar.f60638c;
            int i8 = eVar.f60651b + bVar.f60640e;
            this.f60627c.clipRect(i7, i8, Math.min(fVar.f60654c + i7, bVar.f60639d), Math.min(fVar.f60655d + i8, bVar.f60641f));
            a aVar = (a) this.f60630f.f60672d.get(fVar.f60658g);
            if (aVar == null && (aVar = (a) this.f60630f.f60674f.get(fVar.f60658g)) == null) {
                aVar = this.f60629e;
            }
            a aVar2 = aVar;
            SparseArray sparseArray3 = fVar.f60662k;
            int i9 = 0;
            while (i9 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i9);
                g gVar = (g) sparseArray3.valueAt(i9);
                c cVar = (c) this.f60630f.f60673e.get(iKeyAt);
                if (cVar == null) {
                    cVar = (c) this.f60630f.f60675g.get(iKeyAt);
                }
                if (cVar != null) {
                    sparseArray = sparseArray2;
                    i5 = i9;
                    a(cVar, aVar2, fVar.f60657f, gVar.f60665c + i7, gVar.f60666d + i8, cVar.f60643b ? null : this.f60625a, this.f60627c);
                } else {
                    sparseArray = sparseArray2;
                    i5 = i9;
                }
                i9 = i5 + 1;
                sparseArray2 = sparseArray;
            }
            SparseArray sparseArray4 = sparseArray2;
            if (fVar.f60653b) {
                int i10 = fVar.f60657f;
                if (i10 == 3) {
                    i4 = aVar2.f60635d[fVar.f60659h];
                } else if (i10 == 2) {
                    i4 = aVar2.f60634c[fVar.f60660i];
                } else {
                    i4 = aVar2.f60633b[fVar.f60661j];
                }
                this.f60626b.setColor(i4);
                this.f60627c.drawRect(i7, i8, fVar.f60654c + i7, fVar.f60655d + i8, this.f60626b);
            }
            arrayList.add(new a5.b().a(Bitmap.createBitmap(this.f60631g, i7, i8, fVar.f60654c, fVar.f60655d)).b(i7 / bVar.f60636a).b(0).a(i8 / bVar.f60637b, 0).a(0).d(fVar.f60654c / bVar.f60636a).a(fVar.f60655d / bVar.f60637b).a());
            this.f60627c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f60627c.restore();
            i6++;
            sparseArray2 = sparseArray4;
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(byte[] bArr, int[] iArr, int i3, int i4, int i5, Paint paint, Canvas canvas) {
        Canvas canvas2;
        byte[] bArr2;
        Paint paint2;
        byte[] bArr3;
        byte[] bArr4;
        Paint paint3;
        zg zgVar = new zg(bArr);
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        int iA = i4;
        int i6 = i5;
        byte[] bArrA3 = null;
        while (zgVar.b() != 0) {
            int iA2 = zgVar.a(8);
            if (iA2 != 240) {
                switch (iA2) {
                    case 16:
                        int[] iArr2 = iArr;
                        Paint paint4 = paint;
                        canvas2 = canvas;
                        if (i3 != 3) {
                            if (i3 != 2) {
                                bArr2 = null;
                                paint2 = paint4;
                            } else if (bArrA2 == null) {
                                bArr3 = f60622h;
                                paint2 = paint4;
                                bArr2 = bArr3;
                            } else {
                                paint2 = paint4;
                                bArr2 = bArrA2;
                            }
                            iA = a(zgVar, iArr2, bArr2, iA, i6, paint2, canvas2);
                            zgVar.c();
                            iArr = iArr2;
                            paint = paint2;
                        } else if (bArrA3 == null) {
                            bArr3 = f60623i;
                            paint2 = paint4;
                            bArr2 = bArr3;
                            iA = a(zgVar, iArr2, bArr2, iA, i6, paint2, canvas2);
                            zgVar.c();
                            iArr = iArr2;
                            paint = paint2;
                        } else {
                            paint2 = paint4;
                            bArr2 = bArrA3;
                            iA = a(zgVar, iArr2, bArr2, iA, i6, paint2, canvas2);
                            zgVar.c();
                            iArr = iArr2;
                            paint = paint2;
                        }
                        break;
                    case 17:
                        int[] iArr3 = iArr;
                        Paint paint5 = paint;
                        canvas2 = canvas;
                        if (i3 != 3) {
                            bArr4 = null;
                            paint3 = paint5;
                        } else if (bArrA == null) {
                            paint3 = paint5;
                            bArr4 = f60624j;
                        } else {
                            paint3 = paint5;
                            bArr4 = bArrA;
                        }
                        iA = b(zgVar, iArr3, bArr4, iA, i6, paint3, canvas2);
                        zgVar.c();
                        paint = paint3;
                        iArr = iArr3;
                        break;
                    case 18:
                        iA = c(zgVar, iArr, null, iA, i6, paint, canvas);
                        continue;
                    default:
                        switch (iA2) {
                            case 32:
                                bArrA2 = a(4, 4, zgVar);
                                break;
                            case 33:
                                bArrA3 = a(4, 8, zgVar);
                                break;
                            case 34:
                                bArrA = a(16, 8, zgVar);
                                break;
                            default:
                                continue;
                        }
                        break;
                }
                canvas = canvas2;
            } else {
                i6 += 2;
                iA = i4;
            }
        }
    }
}

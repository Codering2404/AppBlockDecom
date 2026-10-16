package androidx.media3.extractor.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbParser implements SubtitleParser {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f47066h = {0, 7, 8, Ascii.SI};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f47067i = {0, 119, -120, -1};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f47068j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f47069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f47070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Canvas f47071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DisplayDefinition f47072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ClutDefinition f47073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SubtitleService f47074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f47075g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ClutDefinition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f47077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f47078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f47079d;

        public ClutDefinition(int i3, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f47076a = i3;
            this.f47077b = iArr;
            this.f47078c = iArr2;
            this.f47079d = iArr3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DisplayDefinition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f47083d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f47084e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f47085f;

        public DisplayDefinition(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f47080a = i3;
            this.f47081b = i4;
            this.f47082c = i5;
            this.f47083d = i6;
            this.f47084e = i7;
            this.f47085f = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ObjectData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f47087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f47088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f47089d;

        public ObjectData(int i3, boolean z2, byte[] bArr, byte[] bArr2) {
            this.f47086a = i3;
            this.f47087b = z2;
            this.f47088c = bArr;
            this.f47089d = bArr2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PageComposition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray f47093d;

        public PageComposition(int i3, int i4, int i5, SparseArray sparseArray) {
            this.f47090a = i3;
            this.f47091b = i4;
            this.f47092c = i5;
            this.f47093d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PageRegion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47095b;

        public PageRegion(int i3, int i4) {
            this.f47094a = i3;
            this.f47095b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RegionComposition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f47097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f47099d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f47100e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f47101f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f47102g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f47103h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f47104i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f47105j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray f47106k;

        public RegionComposition(int i3, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, SparseArray sparseArray) {
            this.f47096a = i3;
            this.f47097b = z2;
            this.f47098c = i4;
            this.f47099d = i5;
            this.f47100e = i6;
            this.f47101f = i7;
            this.f47102g = i8;
            this.f47103h = i9;
            this.f47104i = i10;
            this.f47105j = i11;
            this.f47106k = sparseArray;
        }

        public void a(RegionComposition regionComposition) {
            SparseArray sparseArray = regionComposition.f47106k;
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                this.f47106k.put(sparseArray.keyAt(i3), (RegionObject) sparseArray.valueAt(i3));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RegionObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f47110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f47111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f47112f;

        public RegionObject(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f47107a = i3;
            this.f47108b = i4;
            this.f47109c = i5;
            this.f47110d = i6;
            this.f47111e = i7;
            this.f47112f = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SubtitleService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray f47115c = new SparseArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray f47116d = new SparseArray();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray f47117e = new SparseArray();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray f47118f = new SparseArray();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray f47119g = new SparseArray();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DisplayDefinition f47120h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PageComposition f47121i;

        public SubtitleService(int i3, int i4) {
            this.f47113a = i3;
            this.f47114b = i4;
        }

        public void a() {
            this.f47115c.clear();
            this.f47116d.clear();
            this.f47117e.clear();
            this.f47118f.clear();
            this.f47119g.clear();
            this.f47120h = null;
            this.f47121i = null;
        }
    }

    public DvbParser(List list) {
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[]) list.get(0));
        int iP = parsableByteArray.P();
        int iP2 = parsableByteArray.P();
        Paint paint = new Paint();
        this.f47069a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f47070b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f47071c = new Canvas();
        this.f47072d = new DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.f47073e = new ClutDefinition(0, e(), f(), g());
        this.f47074f = new SubtitleService(iP, iP2);
    }

    private static byte[] d(int i3, int i4, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) parsableBitArray.h(i4);
        }
        return bArr;
    }

    private static int[] e() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] f() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i3 = 1; i3 < 16; i3++) {
            if (i3 < 8) {
                iArr[i3] = h(255, (i3 & 1) != 0 ? 255 : 0, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i3] = h(255, (i3 & 1) != 0 ? 127 : 0, (i3 & 2) != 0 ? 127 : 0, (i3 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] g() {
        int[] iArr = new int[Function.MAX_NARGS];
        iArr[0] = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (i3 < 8) {
                iArr[i3] = h(63, (i3 & 1) != 0 ? 255 : 0, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) == 0 ? 0 : 255);
            } else {
                int i4 = i3 & 136;
                if (i4 == 0) {
                    iArr[i3] = h(255, ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? 170 : 0), ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0), ((i3 & 4) == 0 ? 0 : 85) + ((i3 & 64) == 0 ? 0 : 170));
                } else if (i4 == 8) {
                    iArr[i3] = h(127, ((i3 & 1) != 0 ? 85 : 0) + ((i3 & 16) != 0 ? 170 : 0), ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0), ((i3 & 4) == 0 ? 0 : 85) + ((i3 & 64) == 0 ? 0 : 170));
                } else if (i4 == 128) {
                    iArr[i3] = h(255, ((i3 & 1) != 0 ? 43 : 0) + 127 + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + 127 + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + 127 + ((i3 & 64) == 0 ? 0 : 85));
                } else if (i4 == 136) {
                    iArr[i3] = h(255, ((i3 & 1) != 0 ? 43 : 0) + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + ((i3 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int h(int i3, int i4, int i5, int i6) {
        return (i3 << 24) | (i4 << 16) | (i5 << 8) | i6;
    }

    private static int i(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2;
        int i5;
        int iH;
        int iH2;
        boolean z3 = false;
        while (true) {
            int iH3 = parsableBitArray.h(2);
            if (iH3 != 0) {
                z2 = z3;
                i5 = 1;
            } else {
                if (parsableBitArray.g()) {
                    iH = parsableBitArray.h(3) + 3;
                    iH2 = parsableBitArray.h(2);
                } else {
                    if (parsableBitArray.g()) {
                        z2 = z3;
                        i5 = 1;
                    } else {
                        int iH4 = parsableBitArray.h(2);
                        if (iH4 == 0) {
                            z2 = true;
                        } else if (iH4 == 1) {
                            z2 = z3;
                            i5 = 2;
                        } else if (iH4 == 2) {
                            iH = parsableBitArray.h(4) + 12;
                            iH2 = parsableBitArray.h(2);
                        } else if (iH4 != 3) {
                            z2 = z3;
                        } else {
                            iH = parsableBitArray.h(8) + 29;
                            iH2 = parsableBitArray.h(2);
                        }
                        iH3 = 0;
                        i5 = 0;
                    }
                    iH3 = 0;
                }
                z2 = z3;
                i5 = iH;
                iH3 = iH2;
            }
            if (i5 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i3, i4, i3 + i5, 1 + i4, paint);
            }
            i3 += i5;
            if (z2) {
                return i3;
            }
            z3 = z2;
        }
    }

    private static int j(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2;
        int i5;
        int iH;
        int iH2;
        boolean z3 = false;
        while (true) {
            int iH3 = parsableBitArray.h(4);
            if (iH3 != 0) {
                z2 = z3;
                i5 = 1;
            } else if (parsableBitArray.g()) {
                if (parsableBitArray.g()) {
                    int iH4 = parsableBitArray.h(2);
                    if (iH4 == 0) {
                        z2 = z3;
                        i5 = 1;
                        iH3 = 0;
                    } else if (iH4 == 1) {
                        iH3 = 0;
                        i5 = 2;
                        z2 = z3;
                    } else if (iH4 == 2) {
                        iH = parsableBitArray.h(4) + 9;
                        iH2 = parsableBitArray.h(4);
                    } else if (iH4 != 3) {
                        z2 = z3;
                        iH3 = 0;
                        i5 = 0;
                    } else {
                        iH = parsableBitArray.h(8) + 25;
                        iH2 = parsableBitArray.h(4);
                    }
                } else {
                    iH = parsableBitArray.h(2) + 4;
                    iH2 = parsableBitArray.h(4);
                }
                z2 = z3;
                i5 = iH;
                iH3 = iH2;
            } else {
                int iH5 = parsableBitArray.h(3);
                if (iH5 != 0) {
                    z2 = z3;
                    i5 = iH5 + 2;
                    iH3 = 0;
                } else {
                    z2 = true;
                    iH3 = 0;
                    i5 = 0;
                }
            }
            if (i5 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i3, i4, i3 + i5, 1 + i4, paint);
            }
            i3 += i5;
            if (z2) {
                return i3;
            }
            z3 = z2;
        }
    }

    private static int k(ParsableBitArray parsableBitArray, int[] iArr, byte[] bArr, int i3, int i4, Paint paint, Canvas canvas) {
        boolean z2;
        int iH;
        boolean z3 = false;
        while (true) {
            int iH2 = parsableBitArray.h(8);
            if (iH2 != 0) {
                z2 = z3;
                iH = 1;
            } else if (parsableBitArray.g()) {
                z2 = z3;
                iH = parsableBitArray.h(7);
                iH2 = parsableBitArray.h(8);
            } else {
                int iH3 = parsableBitArray.h(7);
                if (iH3 != 0) {
                    z2 = z3;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    z2 = true;
                    iH2 = 0;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i3, i4, i3 + iH, 1 + i4, paint);
            }
            i3 += iH;
            if (z2) {
                return i3;
            }
            z3 = z2;
        }
    }

    private static void l(byte[] bArr, int[] iArr, int i3, int i4, int i5, Paint paint, Canvas canvas) {
        int[] iArr2;
        Paint paint2;
        Canvas canvas2;
        byte[] bArr2;
        byte[] bArr3;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        byte[] bArrD = null;
        byte[] bArrD2 = null;
        int i6 = i4;
        int i7 = i5;
        byte[] bArrD3 = null;
        while (parsableBitArray.b() != 0) {
            int iH = parsableBitArray.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        iArr2 = iArr;
                        Paint paint3 = paint;
                        canvas2 = canvas;
                        if (i3 == 3) {
                            bArr3 = bArrD3 == null ? f47067i : bArrD3;
                        } else if (i3 != 2) {
                            bArr2 = null;
                            paint2 = paint3;
                            i6 = i(parsableBitArray, iArr2, bArr2, i6, i7, paint2, canvas2);
                            parsableBitArray.c();
                        } else {
                            bArr3 = bArrD2 == null ? f47066h : bArrD2;
                        }
                        paint2 = paint3;
                        bArr2 = bArr3;
                        i6 = i(parsableBitArray, iArr2, bArr2, i6, i7, paint2, canvas2);
                        parsableBitArray.c();
                        break;
                    case 17:
                        iArr2 = iArr;
                        Paint paint4 = paint;
                        canvas2 = canvas;
                        paint2 = paint4;
                        i6 = j(parsableBitArray, iArr2, i3 == 3 ? bArrD == null ? f47068j : bArrD : null, i6, i7, paint2, canvas2);
                        parsableBitArray.c();
                        break;
                    case 18:
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas2 = canvas;
                        i6 = k(parsableBitArray, iArr2, null, i6, i7, paint2, canvas2);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrD2 = d(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArrD3 = d(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArrD = d(16, 8, parsableBitArray);
                                break;
                        }
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas2 = canvas;
                        break;
                }
            } else {
                iArr2 = iArr;
                paint2 = paint;
                canvas2 = canvas;
                i7 += 2;
                i6 = i4;
            }
            iArr = iArr2;
            paint = paint2;
            canvas = canvas2;
        }
    }

    private static void m(ObjectData objectData, ClutDefinition clutDefinition, int i3, int i4, int i5, Paint paint, Canvas canvas) {
        int[] iArr = i3 == 3 ? clutDefinition.f47079d : i3 == 2 ? clutDefinition.f47078c : clutDefinition.f47077b;
        l(objectData.f47088c, iArr, i3, i4, i5, paint, canvas);
        l(objectData.f47089d, iArr, i3, i4, i5 + 1, paint, canvas);
    }

    private CuesWithTiming n(ParsableBitArray parsableBitArray) {
        SparseArray sparseArray;
        int i3;
        while (parsableBitArray.b() >= 48 && parsableBitArray.h(8) == 15) {
            t(parsableBitArray, this.f47074f);
        }
        SubtitleService subtitleService = this.f47074f;
        PageComposition pageComposition = subtitleService.f47121i;
        if (pageComposition == null) {
            return new CuesWithTiming(ImmutableList.y(), -9223372036854775807L, -9223372036854775807L);
        }
        DisplayDefinition displayDefinition = subtitleService.f47120h;
        if (displayDefinition == null) {
            displayDefinition = this.f47072d;
        }
        Bitmap bitmap = this.f47075g;
        if (bitmap == null || displayDefinition.f47080a + 1 != bitmap.getWidth() || displayDefinition.f47081b + 1 != this.f47075g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(displayDefinition.f47080a + 1, displayDefinition.f47081b + 1, Bitmap.Config.ARGB_8888);
            this.f47075g = bitmapCreateBitmap;
            this.f47071c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = pageComposition.f47093d;
        int i4 = 0;
        while (i4 < sparseArray2.size()) {
            this.f47071c.save();
            PageRegion pageRegion = (PageRegion) sparseArray2.valueAt(i4);
            RegionComposition regionComposition = (RegionComposition) this.f47074f.f47115c.get(sparseArray2.keyAt(i4));
            int i5 = pageRegion.f47094a + displayDefinition.f47082c;
            int i6 = pageRegion.f47095b + displayDefinition.f47084e;
            this.f47071c.clipRect(i5, i6, Math.min(regionComposition.f47098c + i5, displayDefinition.f47083d), Math.min(regionComposition.f47099d + i6, displayDefinition.f47085f));
            ClutDefinition clutDefinition = (ClutDefinition) this.f47074f.f47116d.get(regionComposition.f47102g);
            if (clutDefinition == null && (clutDefinition = (ClutDefinition) this.f47074f.f47118f.get(regionComposition.f47102g)) == null) {
                clutDefinition = this.f47073e;
            }
            ClutDefinition clutDefinition2 = clutDefinition;
            SparseArray sparseArray3 = regionComposition.f47106k;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i7);
                RegionObject regionObject = (RegionObject) sparseArray3.valueAt(i7);
                ObjectData objectData = (ObjectData) this.f47074f.f47117e.get(iKeyAt);
                if (objectData == null) {
                    objectData = (ObjectData) this.f47074f.f47119g.get(iKeyAt);
                }
                if (objectData != null) {
                    sparseArray = sparseArray2;
                    i3 = i7;
                    m(objectData, clutDefinition2, regionComposition.f47101f, regionObject.f47109c + i5, regionObject.f47110d + i6, objectData.f47087b ? null : this.f47069a, this.f47071c);
                } else {
                    sparseArray = sparseArray2;
                    i3 = i7;
                }
                i7 = i3 + 1;
                sparseArray2 = sparseArray;
            }
            SparseArray sparseArray4 = sparseArray2;
            if (regionComposition.f47097b) {
                int i8 = regionComposition.f47101f;
                this.f47070b.setColor(i8 == 3 ? clutDefinition2.f47079d[regionComposition.f47103h] : i8 == 2 ? clutDefinition2.f47078c[regionComposition.f47104i] : clutDefinition2.f47077b[regionComposition.f47105j]);
                this.f47071c.drawRect(i5, i6, regionComposition.f47098c + i5, regionComposition.f47099d + i6, this.f47070b);
            }
            arrayList.add(new Cue.Builder().f(Bitmap.createBitmap(this.f47075g, i5, i6, regionComposition.f47098c, regionComposition.f47099d)).k(i5 / displayDefinition.f47080a).l(0).h(i6 / displayDefinition.f47081b, 0).i(0).n(regionComposition.f47098c / displayDefinition.f47080a).g(regionComposition.f47099d / displayDefinition.f47081b).a());
            this.f47071c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f47071c.restore();
            i4++;
            sparseArray2 = sparseArray4;
        }
        return new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L);
    }

    private static ClutDefinition o(ParsableBitArray parsableBitArray, int i3) {
        int iH;
        int i4;
        int iH2;
        int iH3;
        int iH4;
        int i5 = 8;
        int iH5 = parsableBitArray.h(8);
        parsableBitArray.r(8);
        int i6 = 2;
        int i7 = i3 - 2;
        int[] iArrE = e();
        int[] iArrF = f();
        int[] iArrG = g();
        while (i7 > 0) {
            int iH6 = parsableBitArray.h(i5);
            int iH7 = parsableBitArray.h(i5);
            int[] iArr = (iH7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? iArrE : (iH7 & 64) != 0 ? iArrF : iArrG;
            if ((iH7 & 1) != 0) {
                iH3 = parsableBitArray.h(i5);
                iH4 = parsableBitArray.h(i5);
                iH = parsableBitArray.h(i5);
                iH2 = parsableBitArray.h(i5);
                i4 = i7 - 6;
            } else {
                int iH8 = parsableBitArray.h(6) << i6;
                int iH9 = parsableBitArray.h(4) << 4;
                iH = parsableBitArray.h(4) << 4;
                i4 = i7 - 4;
                iH2 = parsableBitArray.h(i6) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH2 = 255;
                iH4 = 0;
                iH = 0;
            }
            double d3 = iH3;
            double d4 = iH4 - 128;
            double d5 = iH - 128;
            iArr[iH6] = h((byte) (255 - (iH2 & 255)), Util.r((int) (d3 + (1.402d * d4)), 0, 255), Util.r((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), Util.r((int) (d3 + (d5 * 1.772d)), 0, 255));
            i7 = i4;
            iH5 = iH5;
            i5 = 8;
            i6 = 2;
        }
        return new ClutDefinition(iH5, iArrE, iArrF, iArrG);
    }

    private static DisplayDefinition p(ParsableBitArray parsableBitArray) {
        int i3;
        int i4;
        int i5;
        int iH;
        parsableBitArray.r(4);
        boolean zG = parsableBitArray.g();
        parsableBitArray.r(3);
        int iH2 = parsableBitArray.h(16);
        int iH3 = parsableBitArray.h(16);
        if (zG) {
            int iH4 = parsableBitArray.h(16);
            int iH5 = parsableBitArray.h(16);
            int iH6 = parsableBitArray.h(16);
            iH = parsableBitArray.h(16);
            i5 = iH5;
            i4 = iH6;
            i3 = iH4;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = iH2;
            iH = iH3;
        }
        return new DisplayDefinition(iH2, iH3, i3, i5, i4, iH);
    }

    private static ObjectData q(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int iH = parsableBitArray.h(16);
        parsableBitArray.r(4);
        int iH2 = parsableBitArray.h(2);
        boolean zG = parsableBitArray.g();
        parsableBitArray.r(1);
        byte[] bArr2 = Util.f41614f;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = parsableBitArray.h(16);
                int iH4 = parsableBitArray.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    parsableBitArray.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    parsableBitArray.k(bArr, 0, iH4);
                }
            }
            return new ObjectData(iH, zG, bArr2, bArr);
        }
        parsableBitArray.r(parsableBitArray.h(8) * 16);
        bArr = bArr2;
        return new ObjectData(iH, zG, bArr2, bArr);
    }

    private static PageComposition r(ParsableBitArray parsableBitArray, int i3) {
        int iH = parsableBitArray.h(8);
        int iH2 = parsableBitArray.h(4);
        int iH3 = parsableBitArray.h(2);
        parsableBitArray.r(2);
        int i4 = i3 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int iH4 = parsableBitArray.h(8);
            parsableBitArray.r(8);
            i4 -= 6;
            sparseArray.put(iH4, new PageRegion(parsableBitArray.h(16), parsableBitArray.h(16)));
        }
        return new PageComposition(iH, iH2, iH3, sparseArray);
    }

    private static RegionComposition s(ParsableBitArray parsableBitArray, int i3) {
        int i4;
        int iH;
        int iH2;
        char c3;
        int iH3 = parsableBitArray.h(8);
        int i5 = 4;
        parsableBitArray.r(4);
        boolean zG = parsableBitArray.g();
        parsableBitArray.r(3);
        int i6 = 16;
        int iH4 = parsableBitArray.h(16);
        int iH5 = parsableBitArray.h(16);
        int iH6 = parsableBitArray.h(3);
        int iH7 = parsableBitArray.h(3);
        int i7 = 2;
        parsableBitArray.r(2);
        int iH8 = parsableBitArray.h(8);
        int iH9 = parsableBitArray.h(8);
        int iH10 = parsableBitArray.h(4);
        int iH11 = parsableBitArray.h(2);
        parsableBitArray.r(2);
        int i8 = i3 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i8 > 0) {
            int iH12 = parsableBitArray.h(i6);
            int iH13 = parsableBitArray.h(i7);
            int iH14 = parsableBitArray.h(i7);
            int iH15 = parsableBitArray.h(12);
            parsableBitArray.r(i5);
            int iH16 = parsableBitArray.h(12);
            int i9 = i8 - 6;
            if (iH13 != 1) {
                i4 = 2;
                if (iH13 != 2) {
                    iH2 = 0;
                    iH = 0;
                    i8 = i9;
                    c3 = '\b';
                }
                sparseArray.put(iH12, new RegionObject(iH13, iH14, iH15, iH16, iH2, iH));
                i6 = 16;
                i7 = i4;
                i5 = 4;
            } else {
                i4 = 2;
            }
            c3 = '\b';
            i8 -= 8;
            iH2 = parsableBitArray.h(8);
            iH = parsableBitArray.h(8);
            sparseArray.put(iH12, new RegionObject(iH13, iH14, iH15, iH16, iH2, iH));
            i6 = 16;
            i7 = i4;
            i5 = 4;
        }
        return new RegionComposition(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    private static void t(ParsableBitArray parsableBitArray, SubtitleService subtitleService) {
        RegionComposition regionComposition;
        int iH = parsableBitArray.h(8);
        int iH2 = parsableBitArray.h(16);
        int iH3 = parsableBitArray.h(16);
        int iD = parsableBitArray.d() + iH3;
        if (iH3 * 8 > parsableBitArray.b()) {
            Log.i("DvbParser", "Data field length exceeds limit");
            parsableBitArray.r(parsableBitArray.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == subtitleService.f47113a) {
                    PageComposition pageComposition = subtitleService.f47121i;
                    PageComposition pageCompositionR = r(parsableBitArray, iH3);
                    if (pageCompositionR.f47092c != 0) {
                        subtitleService.f47121i = pageCompositionR;
                        subtitleService.f47115c.clear();
                        subtitleService.f47116d.clear();
                        subtitleService.f47117e.clear();
                    } else if (pageComposition != null && pageComposition.f47091b != pageCompositionR.f47091b) {
                        subtitleService.f47121i = pageCompositionR;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService.f47121i;
                if (iH2 == subtitleService.f47113a && pageComposition2 != null) {
                    RegionComposition regionCompositionS = s(parsableBitArray, iH3);
                    if (pageComposition2.f47092c == 0 && (regionComposition = (RegionComposition) subtitleService.f47115c.get(regionCompositionS.f47096a)) != null) {
                        regionCompositionS.a(regionComposition);
                    }
                    subtitleService.f47115c.put(regionCompositionS.f47096a, regionCompositionS);
                }
                break;
            case 18:
                if (iH2 == subtitleService.f47113a) {
                    ClutDefinition clutDefinitionO = o(parsableBitArray, iH3);
                    subtitleService.f47116d.put(clutDefinitionO.f47076a, clutDefinitionO);
                } else if (iH2 == subtitleService.f47114b) {
                    ClutDefinition clutDefinitionO2 = o(parsableBitArray, iH3);
                    subtitleService.f47118f.put(clutDefinitionO2.f47076a, clutDefinitionO2);
                }
                break;
            case 19:
                if (iH2 == subtitleService.f47113a) {
                    ObjectData objectDataQ = q(parsableBitArray);
                    subtitleService.f47117e.put(objectDataQ.f47086a, objectDataQ);
                } else if (iH2 == subtitleService.f47114b) {
                    ObjectData objectDataQ2 = q(parsableBitArray);
                    subtitleService.f47119g.put(objectDataQ2.f47086a, objectDataQ2);
                }
                break;
            case 20:
                if (iH2 == subtitleService.f47113a) {
                    subtitleService.f47120h = p(parsableBitArray);
                }
                break;
        }
        parsableBitArray.s(iD - parsableBitArray.d());
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i4 + i3);
        parsableBitArray.p(i3);
        consumer.accept(n(parsableBitArray));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 2;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void reset() {
        this.f47074f.a();
    }
}

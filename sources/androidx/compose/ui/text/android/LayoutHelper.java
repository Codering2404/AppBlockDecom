package androidx.compose.ui.text.android;

import android.text.Layout;
import com.facebook.internal.Utility;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
public final class LayoutHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Layout f28952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f28953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f28954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean[] f28955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private char[] f28956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28957f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BidiRun {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f28959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f28960c;

        public BidiRun(int i3, int i4, boolean z2) {
            this.f28958a = i3;
            this.f28959b = i4;
            this.f28960c = z2;
        }

        public final int a() {
            return this.f28959b;
        }

        public final int b() {
            return this.f28958a;
        }

        public final boolean c() {
            return this.f28960c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) obj;
            return this.f28958a == bidiRun.f28958a && this.f28959b == bidiRun.f28959b && this.f28960c == bidiRun.f28960c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f28958a) * 31) + Integer.hashCode(this.f28959b)) * 31) + Boolean.hashCode(this.f28960c);
        }

        public String toString() {
            return "BidiRun(start=" + this.f28958a + ", end=" + this.f28959b + ", isRtl=" + this.f28960c + ')';
        }
    }

    public LayoutHelper(Layout layout) {
        this.f28952a = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iM0 = StringsKt.m0(this.f28952a.getText(), '\n', length, false, 4, null);
            length = iM0 < 0 ? this.f28952a.getText().length() : iM0 + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < this.f28952a.getText().length());
        this.f28953b = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList2.add(null);
        }
        this.f28954c = arrayList2;
        this.f28955d = new boolean[this.f28953b.size()];
        this.f28957f = this.f28953b.size();
    }

    private final float b(int i3, boolean z2) {
        int iK = RangesKt.k(i3, this.f28952a.getLineEnd(this.f28952a.getLineForOffset(i3)));
        return z2 ? this.f28952a.getPrimaryHorizontal(iK) : this.f28952a.getSecondaryHorizontal(iK);
    }

    public static /* synthetic */ int g(LayoutHelper layoutHelper, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        return layoutHelper.f(i3, z2);
    }

    private final int k(int i3, int i4) {
        while (i3 > i4 && i(this.f28952a.getText().charAt(i3 - 1))) {
            i3--;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.text.Bidi a(int r11) {
        /*
            r10 = this;
            boolean[] r0 = r10.f28955d
            boolean r0 = r0[r11]
            if (r0 == 0) goto Lf
            java.util.List r0 = r10.f28954c
            java.lang.Object r11 = r0.get(r11)
            java.text.Bidi r11 = (java.text.Bidi) r11
            return r11
        Lf:
            r0 = 0
            if (r11 != 0) goto L14
            r1 = r0
            goto L22
        L14:
            java.util.List r1 = r10.f28953b
            int r2 = r11 + (-1)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L22:
            java.util.List r2 = r10.f28953b
            java.lang.Object r2 = r2.get(r11)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r10.f28956e
            if (r3 == 0) goto L3a
            int r4 = r3.length
            if (r4 >= r8) goto L38
            goto L3a
        L38:
            r4 = r3
            goto L3d
        L3a:
            char[] r3 = new char[r8]
            goto L38
        L3d:
            android.text.Layout r3 = r10.f28952a
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r4, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r4, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L60
            boolean r9 = r10.j(r11)
            java.text.Bidi r3 = new java.text.Bidi
            r6 = 0
            r7 = 0
            r5 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r0 = r3.getRunCount()
            if (r0 != r2) goto L61
        L60:
            r3 = r1
        L61:
            java.util.List r0 = r10.f28954c
            r0.set(r11, r3)
            boolean[] r0 = r10.f28955d
            r0[r11] = r2
            if (r3 == 0) goto L73
            char[] r11 = r10.f28956e
            if (r4 != r11) goto L72
            r4 = r1
            goto L73
        L72:
            r4 = r11
        L73:
            r10.f28956e = r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutHelper.a(int):java.text.Bidi");
    }

    public final float c(int i3, boolean z2, boolean z3) {
        int iK = i3;
        if (!z3) {
            return b(i3, z2);
        }
        int iA = LayoutCompat_androidKt.a(this.f28952a, iK, z3);
        int lineStart = this.f28952a.getLineStart(iA);
        int lineEnd = this.f28952a.getLineEnd(iA);
        if (iK != lineStart && iK != lineEnd) {
            return b(i3, z2);
        }
        if (iK == 0 || iK == this.f28952a.getText().length()) {
            return b(i3, z2);
        }
        int iF = f(iK, z3);
        boolean zJ = j(iF);
        int iK2 = k(lineEnd, lineStart);
        int iH = h(iF);
        int i4 = lineStart - iH;
        int i5 = iK2 - iH;
        Bidi bidiA = a(iF);
        Bidi bidiCreateLineBidi = bidiA != null ? bidiA.createLineBidi(i4, i5) : null;
        boolean z4 = false;
        if (bidiCreateLineBidi == null || bidiCreateLineBidi.getRunCount() == 1) {
            boolean zIsRtlCharAt = this.f28952a.isRtlCharAt(lineStart);
            if (z2 || zJ == zIsRtlCharAt) {
                zJ = !zJ;
            }
            if (iK == lineStart) {
                z4 = zJ;
            } else if (!zJ) {
                z4 = true;
            }
            Layout layout = this.f28952a;
            return z4 ? layout.getLineLeft(iA) : layout.getLineRight(iA);
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i6 = 0; i6 < runCount; i6++) {
            bidiRunArr[i6] = new BidiRun(bidiCreateLineBidi.getRunStart(i6) + lineStart, bidiCreateLineBidi.getRunLimit(i6) + lineStart, bidiCreateLineBidi.getRunLevel(i6) % 2 == 1);
        }
        int runCount2 = bidiCreateLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i7 = 0; i7 < runCount2; i7++) {
            bArr[i7] = (byte) bidiCreateLineBidi.getRunLevel(i7);
        }
        Bidi.reorderVisually(bArr, 0, bidiRunArr, 0, runCount);
        int i8 = -1;
        if (iK == lineStart) {
            int i9 = 0;
            while (true) {
                if (i9 >= runCount) {
                    break;
                }
                if (bidiRunArr[i9].b() == iK) {
                    i8 = i9;
                    break;
                }
                i9++;
            }
            BidiRun bidiRun = bidiRunArr[i8];
            if (z2 || zJ == bidiRun.c()) {
                zJ = !zJ;
            }
            return (i8 == 0 && zJ) ? this.f28952a.getLineLeft(iA) : (i8 != ArraysKt.getLastIndex(bidiRunArr) || zJ) ? zJ ? this.f28952a.getPrimaryHorizontal(bidiRunArr[i8 - 1].b()) : this.f28952a.getPrimaryHorizontal(bidiRunArr[i8 + 1].b()) : this.f28952a.getLineRight(iA);
        }
        if (iK > iK2) {
            iK = k(iK, lineStart);
        }
        int i10 = 0;
        while (true) {
            if (i10 >= runCount) {
                break;
            }
            if (bidiRunArr[i10].a() == iK) {
                i8 = i10;
                break;
            }
            i10++;
        }
        BidiRun bidiRun2 = bidiRunArr[i8];
        if (!z2 && zJ != bidiRun2.c()) {
            zJ = !zJ;
        }
        return (i8 == 0 && zJ) ? this.f28952a.getLineLeft(iA) : (i8 != ArraysKt.getLastIndex(bidiRunArr) || zJ) ? zJ ? this.f28952a.getPrimaryHorizontal(bidiRunArr[i8 - 1].a()) : this.f28952a.getPrimaryHorizontal(bidiRunArr[i8 + 1].a()) : this.f28952a.getLineRight(iA);
    }

    public final BidiRun[] d(int i3) {
        Bidi bidiCreateLineBidi;
        int lineStart = this.f28952a.getLineStart(i3);
        int lineEnd = this.f28952a.getLineEnd(i3);
        int iG = g(this, lineStart, false, 2, null);
        int iH = h(iG);
        int i4 = lineStart - iH;
        int i5 = lineEnd - iH;
        Bidi bidiA = a(iG);
        if (bidiA == null || (bidiCreateLineBidi = bidiA.createLineBidi(i4, i5)) == null) {
            return new BidiRun[]{new BidiRun(lineStart, lineEnd, this.f28952a.isRtlCharAt(lineStart))};
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i6 = 0; i6 < runCount; i6++) {
            int runStart = bidiCreateLineBidi.getRunStart(i6) + lineStart;
            int runLimit = bidiCreateLineBidi.getRunLimit(i6) + lineStart;
            boolean z2 = true;
            if (bidiCreateLineBidi.getRunLevel(i6) % 2 != 1) {
                z2 = false;
            }
            bidiRunArr[i6] = new BidiRun(runStart, runLimit, z2);
        }
        return bidiRunArr;
    }

    public final int e(int i3) {
        return k(this.f28952a.getLineEnd(i3), this.f28952a.getLineStart(i3));
    }

    public final int f(int i3, boolean z2) {
        int iBinarySearch$default = CollectionsKt.binarySearch$default(this.f28953b, Integer.valueOf(i3), 0, 0, 6, (Object) null);
        int i4 = iBinarySearch$default < 0 ? -(iBinarySearch$default + 1) : iBinarySearch$default + 1;
        if (z2 && i4 > 0) {
            int i5 = i4 - 1;
            if (i3 == ((Number) this.f28953b.get(i5)).intValue()) {
                return i5;
            }
        }
        return i4;
    }

    public final int h(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return ((Number) this.f28953b.get(i3 - 1)).intValue();
    }

    public final boolean i(char c3) {
        if (c3 == ' ' || c3 == '\n' || c3 == 5760) {
            return true;
        }
        return (Intrinsics.compare((int) c3, Utility.DEFAULT_STREAM_BUFFER_SIZE) >= 0 && Intrinsics.compare((int) c3, 8202) <= 0 && c3 != 8199) || c3 == 8287 || c3 == 12288;
    }

    public final boolean j(int i3) {
        return this.f28952a.getParagraphDirection(this.f28952a.getLineForOffset(h(i3))) == -1;
    }
}

package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SlotWriter {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Companion f24197y = new Companion(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f24198z = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f24199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f24200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f24201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f24202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap f24203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutableIntObjectMap f24204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f24210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f24211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f24213o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MutableIntObjectMap f24217s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f24218t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f24219u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f24221w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MutableIntList f24222x;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final IntStack f24214p = new IntStack();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final IntStack f24215q = new IntStack();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final IntStack f24216r = new IntStack();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f24220v = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List b(SlotWriter slotWriter, int i3, SlotWriter slotWriter2, boolean z2, boolean z3, boolean z4) {
            boolean zQ0;
            List listEmptyList;
            int iM0 = slotWriter.m0(i3);
            int i4 = i3 + iM0;
            int iP = slotWriter.P(i3);
            int iP2 = slotWriter.P(i4);
            int i5 = iP2 - iP;
            boolean zM = slotWriter.M(i3);
            slotWriter2.q0(iM0);
            slotWriter2.r0(i5, slotWriter2.c0());
            if (slotWriter.f24205g < i4) {
                slotWriter.A0(i4);
            }
            if (slotWriter.f24209k < iP2) {
                slotWriter.C0(iP2, i4);
            }
            int[] iArr = slotWriter2.f24200b;
            int iC0 = slotWriter2.c0();
            int i6 = iC0 * 5;
            ArraysKt.copyInto(slotWriter.f24200b, iArr, i6, i3 * 5, i4 * 5);
            Object[] objArr = slotWriter2.f24201c;
            int i7 = slotWriter2.f24207i;
            System.arraycopy(slotWriter.f24201c, iP, objArr, i7, i5);
            int iE0 = slotWriter2.e0();
            iArr[i6 + 2] = iE0;
            int i8 = iC0 - i3;
            int i9 = iC0 + iM0;
            int iQ = i7 - slotWriter2.Q(iArr, iC0);
            int i10 = slotWriter2.f24211m;
            int i11 = slotWriter2.f24210l;
            int length = objArr.length;
            int i12 = i10;
            int i13 = iC0;
            while (true) {
                zQ0 = false;
                if (i13 >= i9) {
                    break;
                }
                if (i13 != iC0) {
                    int i14 = (i13 * 5) + 2;
                    iArr[i14] = iArr[i14] + i8;
                }
                int[] iArr2 = iArr;
                int i15 = iC0;
                iArr2[(i13 * 5) + 4] = slotWriter2.S(slotWriter2.Q(iArr, i13) + iQ, i12 >= i13 ? slotWriter2.f24209k : 0, i11, length);
                if (i13 == i12) {
                    i12++;
                }
                i13++;
                iC0 = i15;
                iArr = iArr2;
            }
            int[] iArr3 = iArr;
            slotWriter2.f24211m = i12;
            int iR = SlotTableKt.r(slotWriter.f24202d, i3, slotWriter.f0());
            int iR2 = SlotTableKt.r(slotWriter.f24202d, i4, slotWriter.f0());
            if (iR < iR2) {
                ArrayList arrayList = slotWriter.f24202d;
                ArrayList arrayList2 = new ArrayList(iR2 - iR);
                for (int i16 = iR; i16 < iR2; i16++) {
                    Anchor anchor = (Anchor) arrayList.get(i16);
                    anchor.c(anchor.a() + i8);
                    arrayList2.add(anchor);
                }
                slotWriter2.f24202d.addAll(SlotTableKt.r(slotWriter2.f24202d, slotWriter2.c0(), slotWriter2.f0()), arrayList2);
                arrayList.subList(iR, iR2).clear();
                listEmptyList = arrayList2;
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            if (!list.isEmpty()) {
                HashMap map = slotWriter.f24203e;
                HashMap map2 = slotWriter2.f24203e;
                if (map != null && map2 != null) {
                    int size = list.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        Anchor anchor2 = (Anchor) listEmptyList.get(i17);
                        GroupSourceInformation groupSourceInformation = (GroupSourceInformation) map.get(anchor2);
                        if (groupSourceInformation != null) {
                            map.remove(anchor2);
                            map2.put(anchor2, groupSourceInformation);
                        }
                    }
                }
            }
            int iE02 = slotWriter2.e0();
            GroupSourceInformation groupSourceInformationH1 = slotWriter2.h1(iE0);
            if (groupSourceInformationH1 != null) {
                int iP3 = iE02 + 1;
                int iC02 = slotWriter2.c0();
                int i18 = -1;
                while (iP3 < iC02) {
                    i18 = iP3;
                    iP3 = SlotTableKt.p(slotWriter2.f24200b, iP3) + iP3;
                }
                groupSourceInformationH1.b(slotWriter2, i18, iC02);
            }
            int iI0 = slotWriter.I0(i3);
            if (z4) {
                if (z2) {
                    boolean z5 = iI0 >= 0;
                    if (z5) {
                        slotWriter.j1();
                        slotWriter.C(iI0 - slotWriter.c0());
                        slotWriter.j1();
                    }
                    slotWriter.C(i3 - slotWriter.c0());
                    boolean zP0 = slotWriter.P0();
                    if (z5) {
                        slotWriter.Z0();
                        slotWriter.T();
                        slotWriter.Z0();
                        slotWriter.T();
                    }
                    zQ0 = zP0;
                } else {
                    zQ0 = slotWriter.Q0(i3, iM0);
                    slotWriter.R0(iP, i5, i3 - 1);
                }
            }
            if (zQ0) {
                ComposerKt.t("Unexpectedly removed anchors");
            }
            int i19 = slotWriter2.f24213o;
            int i20 = iArr3[i6 + 1];
            slotWriter2.f24213o = i19 + ((1073741824 & i20) == 0 ? i20 & 67108863 : 1);
            if (z3) {
                slotWriter2.f24218t = i9;
                slotWriter2.f24207i = i7 + i5;
            }
            if (zM) {
                slotWriter2.s1(iE0);
            }
            return listEmptyList;
        }

        static /* synthetic */ List c(Companion companion, SlotWriter slotWriter, int i3, SlotWriter slotWriter2, boolean z2, boolean z3, boolean z4, int i4, Object obj) {
            if ((i4 & 32) != 0) {
                z4 = true;
            }
            return companion.b(slotWriter, i3, slotWriter2, z2, z3, z4);
        }

        private Companion() {
        }
    }

    public SlotWriter(SlotTable slotTable) {
        this.f24199a = slotTable;
        this.f24200b = slotTable.s();
        this.f24201c = slotTable.u();
        this.f24202d = slotTable.p();
        this.f24203e = slotTable.w();
        this.f24204f = slotTable.q();
        this.f24205g = slotTable.t();
        this.f24206h = (this.f24200b.length / 5) - slotTable.t();
        this.f24209k = slotTable.v();
        this.f24210l = this.f24201c.length - slotTable.v();
        this.f24211m = slotTable.t();
        this.f24219u = slotTable.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(int i3) {
        int i4 = this.f24206h;
        int i5 = this.f24205g;
        if (i5 != i3) {
            if (!this.f24202d.isEmpty()) {
                q1(i5, i3);
            }
            if (i4 > 0) {
                int[] iArr = this.f24200b;
                int i6 = i3 * 5;
                int i7 = i4 * 5;
                int i8 = i5 * 5;
                if (i3 < i5) {
                    ArraysKt.copyInto(iArr, iArr, i7 + i6, i6, i8);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i8, i8 + i7, i6 + i7);
                }
            }
            if (i3 < i5) {
                i5 = i3 + i4;
            }
            int iY = Y();
            if (!(i5 < iY)) {
                ComposerKt.t("Check failed");
            }
            while (i5 < iY) {
                int i9 = (i5 * 5) + 2;
                int i10 = this.f24200b[i9];
                int iL0 = L0(K0(i10), i3);
                if (iL0 != i10) {
                    this.f24200b[i9] = iL0;
                }
                i5++;
                if (i5 == i3) {
                    i5 += i4;
                }
            }
        }
        this.f24205g = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(int i3, int i4) {
        int i5 = this.f24210l;
        int i6 = this.f24209k;
        int i7 = this.f24211m;
        if (i6 != i3) {
            Object[] objArr = this.f24201c;
            if (i3 < i6) {
                System.arraycopy(objArr, i3, objArr, i3 + i5, i6 - i3);
            } else {
                int i8 = i6 + i5;
                System.arraycopy(objArr, i8, objArr, i6, (i3 + i5) - i8);
            }
        }
        int iMin = Math.min(i4 + 1, f0());
        if (i7 != iMin) {
            int length = this.f24201c.length - i5;
            if (iMin < i7) {
                int iJ0 = j0(iMin);
                int iJ02 = j0(i7);
                int i9 = this.f24205g;
                while (iJ0 < iJ02) {
                    int i10 = (iJ0 * 5) + 4;
                    int i11 = this.f24200b[i10];
                    if (!(i11 >= 0)) {
                        ComposerKt.t("Unexpected anchor value, expected a positive anchor");
                    }
                    this.f24200b[i10] = -((length - i11) + 1);
                    iJ0++;
                    if (iJ0 == i9) {
                        iJ0 += this.f24206h;
                    }
                }
            } else {
                int iJ03 = j0(i7);
                int iJ04 = j0(iMin);
                while (iJ03 < iJ04) {
                    int i12 = (iJ03 * 5) + 4;
                    int i13 = this.f24200b[i12];
                    if (!(i13 < 0)) {
                        ComposerKt.t("Unexpected anchor value, expected a negative anchor");
                    }
                    this.f24200b[i12] = i13 + length + 1;
                    iJ03++;
                    if (iJ03 == this.f24205g) {
                        iJ03 += this.f24206h;
                    }
                }
            }
            this.f24211m = iMin;
        }
        this.f24209k = i3;
    }

    private final int G(int[] iArr, int i3) {
        return Q(iArr, i3) + Integer.bitCount(iArr[(i3 * 5) + 1] >> 29);
    }

    private final int H0(int[] iArr, int i3) {
        return Q(iArr, i3);
    }

    private final boolean I(int i3) {
        int iM0 = i3 + 1;
        int iM02 = i3 + m0(i3);
        while (iM0 < iM02) {
            if ((this.f24200b[(j0(iM0) * 5) + 1] & 201326592) != 0) {
                return true;
            }
            iM0 += m0(iM0);
        }
        return false;
    }

    private final int J0(int[] iArr, int i3) {
        return K0(iArr[(j0(i3) * 5) + 2]);
    }

    private final void K() {
        int i3 = this.f24209k;
        ArraysKt.fill(this.f24201c, (Object) null, i3, this.f24210l + i3);
    }

    private final int K0(int i3) {
        return i3 > -2 ? i3 : (f0() + i3) - (-2);
    }

    private final int L0(int i3, int i4) {
        return i3 < i4 ? i3 : -((f0() - i3) + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(int i3) {
        return i3 >= 0 && (this.f24200b[(j0(i3) * 5) + 1] & 201326592) != 0;
    }

    private final Object M0(Object obj) {
        Object objX0 = X0();
        W0(obj);
        return objX0;
    }

    private final boolean N(int i3) {
        return i3 >= 0 && (this.f24200b[(j0(i3) * 5) + 1] & 67108864) != 0;
    }

    private final void N0() {
        MutableIntList mutableIntList = this.f24222x;
        if (mutableIntList != null) {
            while (PrioritySet.f(mutableIntList)) {
                t1(PrioritySet.h(mutableIntList), mutableIntList);
            }
        }
    }

    private final int O(int i3, int i4, int i5) {
        return i3 < 0 ? (i5 - i4) + i3 + 1 : i3;
    }

    private final boolean O0(int i3, int i4, HashMap map) {
        int i5 = i4 + i3;
        int iR = SlotTableKt.r(this.f24202d, i5, Y() - this.f24206h);
        if (iR >= this.f24202d.size()) {
            iR--;
        }
        int i6 = iR + 1;
        int i7 = 0;
        while (iR >= 0) {
            Anchor anchor = (Anchor) this.f24202d.get(iR);
            int iE = E(anchor);
            if (iE < i3) {
                break;
            }
            if (iE < i5) {
                anchor.c(Integer.MIN_VALUE);
                if (map != null) {
                }
                if (i7 == 0) {
                    i7 = iR + 1;
                }
                i6 = iR;
            }
            iR--;
        }
        boolean z2 = i6 < i7;
        if (z2) {
            this.f24202d.subList(i6, i7).clear();
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P(int i3) {
        return Q(this.f24200b, j0(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Q(int[] iArr, int i3) {
        return i3 >= Y() ? this.f24201c.length - this.f24210l : O(iArr[(i3 * 5) + 4], this.f24210l, this.f24201c.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q0(int i3, int i4) {
        if (i4 > 0) {
            ArrayList arrayList = this.f24202d;
            A0(i3);
            zO0 = arrayList.isEmpty() ? false : O0(i3, i4, this.f24203e);
            this.f24205g = i3;
            this.f24206h += i4;
            int i5 = this.f24211m;
            if (i5 > i3) {
                this.f24211m = Math.max(i3, i5 - i4);
            }
            int i6 = this.f24219u;
            if (i6 >= this.f24205g) {
                this.f24219u = i6 - i4;
            }
            int i7 = this.f24220v;
            if (N(i7)) {
                s1(i7);
            }
        }
        return zO0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R(int i3) {
        return i3 + (this.f24210l * (i3 < this.f24209k ? 0 : 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(int i3, int i4, int i5) {
        if (i4 > 0) {
            int i6 = this.f24210l;
            int i7 = i3 + i4;
            C0(i7, i5);
            this.f24209k = i3;
            this.f24210l = i6 + i4;
            ArraysKt.fill(this.f24201c, (Object) null, i3, i7);
            int i8 = this.f24208j;
            if (i8 >= i3) {
                this.f24208j = i8 - i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S(int i3, int i4, int i5, int i6) {
        return i3 > i4 ? -(((i6 - i5) - i3) + 1) : i3;
    }

    private final int T0() {
        int iY = (Y() - this.f24206h) - this.f24215q.g();
        this.f24219u = iY;
        return iY;
    }

    private final void U0() {
        this.f24215q.h((Y() - this.f24206h) - this.f24219u);
    }

    private final void X(int i3, int i4, int i5) {
        int iL0 = L0(i3, this.f24205g);
        while (i5 < i4) {
            this.f24200b[(j0(i5) * 5) + 2] = iL0;
            int iP = SlotTableKt.p(this.f24200b, j0(i5)) + i5;
            X(i5, iP, i5 + 1);
            i5 = iP;
        }
    }

    private final int Y() {
        return this.f24200b.length / 5;
    }

    private final int c1(int[] iArr, int i3) {
        return i3 >= Y() ? this.f24201c.length - this.f24210l : O(SlotTableKt.u(iArr, i3), this.f24210l, this.f24201c.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupSourceInformation h1(int i3) {
        Anchor anchorO1;
        HashMap map = this.f24203e;
        if (map == null || (anchorO1 = o1(i3)) == null) {
            return null;
        }
        return (GroupSourceInformation) map.get(anchorO1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j0(int i3) {
        return i3 + (this.f24206h * (i3 < this.f24205g ? 0 : 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    private final void l1(int i3, Object obj, boolean z2, Object obj2) {
        int iP;
        GroupSourceInformation groupSourceInformationH1;
        int i4 = this.f24220v;
        Object[] objArr = this.f24212n > 0;
        this.f24216r.h(this.f24213o);
        if (objArr == true) {
            int i5 = this.f24218t;
            int iQ = Q(this.f24200b, j0(i5));
            q0(1);
            this.f24207i = iQ;
            this.f24208j = iQ;
            int iJ0 = j0(i5);
            Composer.Companion companion = Composer.f23746a;
            ?? r12 = obj != companion.a() ? 1 : 0;
            ?? r13 = (z2 || obj2 == companion.a()) ? 0 : 1;
            int iS = S(iQ, this.f24209k, this.f24210l, this.f24201c.length);
            if (iS >= 0 && this.f24211m < i5) {
                iS = -(((this.f24201c.length - this.f24210l) - iS) + 1);
            }
            SlotTableKt.q(this.f24200b, iJ0, i3, z2, r12, r13, this.f24220v, iS);
            int i6 = (z2 ? 1 : 0) + r12 + r13;
            if (i6 > 0) {
                r0(i6, i5);
                Object[] objArr2 = this.f24201c;
                int i7 = this.f24207i;
                if (z2) {
                    objArr2[i7] = obj2;
                    i7++;
                }
                if (r12 != 0) {
                    objArr2[i7] = obj;
                    i7++;
                }
                if (r13 != 0) {
                    objArr2[i7] = obj2;
                    i7++;
                }
                this.f24207i = i7;
            }
            this.f24213o = 0;
            iP = i5 + 1;
            this.f24220v = i5;
            this.f24218t = iP;
            if (i4 >= 0 && (groupSourceInformationH1 = h1(i4)) != null) {
                groupSourceInformationH1.l(this, i5);
            }
        } else {
            this.f24214p.h(i4);
            U0();
            int i8 = this.f24218t;
            int iJ02 = j0(i8);
            if (!Intrinsics.areEqual(obj2, Composer.f23746a.a())) {
                if (z2) {
                    w1(obj2);
                } else {
                    r1(obj2);
                }
            }
            this.f24207i = c1(this.f24200b, iJ02);
            this.f24208j = Q(this.f24200b, j0(this.f24218t + 1));
            int[] iArr = this.f24200b;
            this.f24213o = iArr[(iJ02 * 5) + 1] & 67108863;
            this.f24220v = i8;
            this.f24218t = i8 + 1;
            iP = i8 + SlotTableKt.p(iArr, iJ02);
        }
        this.f24219u = iP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(int i3) {
        if (i3 > 0) {
            int i4 = this.f24218t;
            A0(i4);
            int i5 = this.f24205g;
            int i6 = this.f24206h;
            int[] iArr = this.f24200b;
            int length = iArr.length / 5;
            int i7 = length - i6;
            if (i6 < i3) {
                int iMax = Math.max(Math.max(length * 2, i7 + i3), 32);
                int[] iArr2 = new int[iMax * 5];
                int i8 = iMax - i7;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i5 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i5 + i8) * 5, (i6 + i5) * 5, length * 5);
                this.f24200b = iArr2;
                i6 = i8;
            }
            int i9 = this.f24219u;
            if (i9 >= i5) {
                this.f24219u = i9 + i3;
            }
            int i10 = i5 + i3;
            this.f24205g = i10;
            this.f24206h = i6 - i3;
            int iS = S(i7 > 0 ? P(i4 + i3) : 0, this.f24211m >= i5 ? this.f24209k : 0, this.f24210l, this.f24201c.length);
            for (int i11 = i5; i11 < i10; i11++) {
                this.f24200b[(i11 * 5) + 4] = iS;
            }
            int i12 = this.f24211m;
            if (i12 >= i5) {
                this.f24211m = i12 + i3;
            }
        }
    }

    private final void q1(int i3, int i4) {
        Anchor anchor;
        int iA;
        Anchor anchor2;
        int iA2;
        int i5;
        int iY = Y() - this.f24206h;
        if (i3 >= i4) {
            for (int iR = SlotTableKt.r(this.f24202d, i4, iY); iR < this.f24202d.size() && (iA = (anchor = (Anchor) this.f24202d.get(iR)).a()) >= 0; iR++) {
                anchor.c(-(iY - iA));
            }
            return;
        }
        for (int iR2 = SlotTableKt.r(this.f24202d, i3, iY); iR2 < this.f24202d.size() && (iA2 = (anchor2 = (Anchor) this.f24202d.get(iR2)).a()) < 0 && (i5 = iA2 + iY) < i4; iR2++) {
            anchor2.c(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(int i3, int i4) {
        if (i3 > 0) {
            C0(this.f24207i, i4);
            int i5 = this.f24209k;
            int i6 = this.f24210l;
            if (i6 < i3) {
                Object[] objArr = this.f24201c;
                int length = objArr.length;
                int i7 = length - i6;
                int iMax = Math.max(Math.max(length * 2, i7 + i3), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i8 = 0; i8 < iMax; i8++) {
                    objArr2[i8] = null;
                }
                int i9 = iMax - i7;
                int i10 = i6 + i5;
                System.arraycopy(objArr, 0, objArr2, 0, i5);
                System.arraycopy(objArr, i10, objArr2, i5 + i9, length - i10);
                this.f24201c = objArr2;
                i6 = i9;
            }
            int i11 = this.f24208j;
            if (i11 >= i5) {
                this.f24208j = i11 + i3;
            }
            this.f24209k = i5 + i3;
            this.f24210l = i6 - i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(int i3) {
        if (i3 >= 0) {
            MutableIntList mutableIntListC = this.f24222x;
            if (mutableIntListC == null) {
                mutableIntListC = PrioritySet.c(null, 1, null);
                this.f24222x = mutableIntListC;
            }
            PrioritySet.a(mutableIntListC, i3);
        }
    }

    private final void t1(int i3, MutableIntList mutableIntList) {
        int iJ0 = j0(i3);
        boolean zI = I(i3);
        int[] iArr = this.f24200b;
        if (((iArr[(iJ0 * 5) + 1] & 67108864) != 0) != zI) {
            SlotTableKt.w(iArr, iJ0, zI);
            int iI0 = I0(i3);
            if (iI0 >= 0) {
                PrioritySet.a(mutableIntList, iI0);
            }
        }
    }

    private final void u1(int[] iArr, int i3, int i4) {
        iArr[(i3 * 5) + 4] = S(i4, this.f24209k, this.f24210l, this.f24201c.length);
    }

    public static /* synthetic */ void w0(SlotWriter slotWriter, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = slotWriter.f24220v;
        }
        slotWriter.v0(i3);
    }

    private final void x0(int i3, int i4, int i5) {
        Anchor anchor;
        int iE;
        int i6 = i5 + i3;
        int iF0 = f0();
        int iR = SlotTableKt.r(this.f24202d, i3, iF0);
        ArrayList arrayList = new ArrayList();
        if (iR >= 0) {
            while (iR < this.f24202d.size() && (iE = E((anchor = (Anchor) this.f24202d.get(iR)))) >= i3 && iE < i6) {
                arrayList.add(anchor);
                this.f24202d.remove(iR);
            }
        }
        int i7 = i4 - i3;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            Anchor anchor2 = (Anchor) arrayList.get(i8);
            int iE2 = E(anchor2) + i7;
            if (iE2 >= this.f24205g) {
                anchor2.c(-(iF0 - iE2));
            } else {
                anchor2.c(iE2);
            }
            this.f24202d.add(SlotTableKt.r(this.f24202d, iE2, iF0), anchor2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void x1(int r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.j0(r5)
            int[] r1 = r4.f24200b
            int r2 = r1.length
            if (r0 >= r2) goto L15
            int r2 = r0 * 5
            r3 = 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r2 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r2
            if (r1 == 0) goto L15
            goto L16
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Updating the node of a group at "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " that was not created with as a node group"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            androidx.compose.runtime.ComposerKt.t(r5)
        L31:
            java.lang.Object[] r5 = r4.f24201c
            int[] r1 = r4.f24200b
            int r0 = r4.H0(r1, r0)
            int r0 = r4.R(r0)
            r5[r0] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.x1(int, java.lang.Object):void");
    }

    public final List B0(int i3, SlotTable slotTable, int i4) {
        if (!(this.f24212n <= 0 && m0(this.f24218t + i3) == 1)) {
            ComposerKt.t("Check failed");
        }
        int i5 = this.f24218t;
        int i6 = this.f24207i;
        int i7 = this.f24208j;
        C(i3);
        j1();
        H();
        SlotWriter slotWriterC = slotTable.C();
        try {
            List listC = Companion.c(f24197y, slotWriterC, i4, this, false, true, false, 32, null);
            slotWriterC.L(true);
            U();
            T();
            this.f24218t = i5;
            this.f24207i = i6;
            this.f24208j = i7;
            return listC;
        } catch (Throwable th) {
            slotWriterC.L(false);
            throw th;
        }
    }

    public final void C(int i3) {
        boolean z2 = false;
        if (!(i3 >= 0)) {
            ComposerKt.t("Cannot seek backwards");
        }
        if (!(this.f24212n <= 0)) {
            PreconditionsKt.b("Cannot call seek() while inserting");
        }
        if (i3 == 0) {
            return;
        }
        int i4 = this.f24218t + i3;
        if (i4 >= this.f24220v && i4 <= this.f24219u) {
            z2 = true;
        }
        if (!z2) {
            ComposerKt.t("Cannot seek outside the current group (" + this.f24220v + '-' + this.f24219u + ')');
        }
        this.f24218t = i4;
        int iQ = Q(this.f24200b, j0(i4));
        this.f24207i = iQ;
        this.f24208j = iQ;
    }

    public final Anchor D(int i3) {
        ArrayList arrayList = this.f24202d;
        int iT = SlotTableKt.t(arrayList, i3, f0());
        if (iT >= 0) {
            return (Anchor) arrayList.get(iT);
        }
        if (i3 > this.f24205g) {
            i3 = -(f0() - i3);
        }
        Anchor anchor = new Anchor(i3);
        arrayList.add(-(iT + 1), anchor);
        return anchor;
    }

    public final List D0(Anchor anchor, int i3, SlotWriter slotWriter) {
        if (!(slotWriter.f24212n > 0)) {
            ComposerKt.t("Check failed");
        }
        if (!(this.f24212n == 0)) {
            ComposerKt.t("Check failed");
        }
        if (!anchor.b()) {
            ComposerKt.t("Check failed");
        }
        int iE = E(anchor) + i3;
        int i4 = this.f24218t;
        if (!(i4 <= iE && iE < this.f24219u)) {
            ComposerKt.t("Check failed");
        }
        int iI0 = I0(iE);
        int iM0 = m0(iE);
        int iG0 = u0(iE) ? 1 : G0(iE);
        List listC = Companion.c(f24197y, this, iE, slotWriter, false, false, false, 32, null);
        s1(iI0);
        boolean z2 = iG0 > 0;
        while (iI0 >= i4) {
            int iJ0 = j0(iI0);
            int[] iArr = this.f24200b;
            SlotTableKt.x(iArr, iJ0, SlotTableKt.p(iArr, iJ0) - iM0);
            if (z2) {
                int[] iArr2 = this.f24200b;
                int i5 = iArr2[(iJ0 * 5) + 1];
                if ((1073741824 & i5) != 0) {
                    z2 = false;
                } else {
                    SlotTableKt.z(iArr2, iJ0, (i5 & 67108863) - iG0);
                }
            }
            iI0 = I0(iI0);
        }
        if (z2) {
            if (!(this.f24213o >= iG0)) {
                ComposerKt.t("Check failed");
            }
            this.f24213o -= iG0;
        }
        return listC;
    }

    public final int E(Anchor anchor) {
        int iA = anchor.a();
        return iA < 0 ? f0() + iA : iA;
    }

    public final Object E0(int i3) {
        int iJ0 = j0(i3);
        int[] iArr = this.f24200b;
        if ((iArr[(iJ0 * 5) + 1] & 1073741824) != 0) {
            return this.f24201c[R(H0(iArr, iJ0))];
        }
        return null;
    }

    public final void F(Anchor anchor, Object obj) {
        if (!(this.f24212n == 0)) {
            ComposerKt.t("Can only append a slot if not current inserting");
        }
        int i3 = this.f24207i;
        int i4 = this.f24208j;
        int iE = E(anchor);
        int iQ = Q(this.f24200b, j0(iE + 1));
        this.f24207i = iQ;
        this.f24208j = iQ;
        r0(1, iE);
        if (i3 >= iQ) {
            i3++;
            i4++;
        }
        this.f24201c[iQ] = obj;
        this.f24207i = i3;
        this.f24208j = i4;
    }

    public final Object F0(Anchor anchor) {
        return E0(anchor.e(this));
    }

    public final int G0(int i3) {
        return this.f24200b[(j0(i3) * 5) + 1] & 67108863;
    }

    public final void H() {
        int i3 = this.f24212n;
        this.f24212n = i3 + 1;
        if (i3 == 0) {
            U0();
        }
    }

    public final int I0(int i3) {
        return J0(this.f24200b, i3);
    }

    public final Object J(int i3) {
        int iR = R(i3);
        Object[] objArr = this.f24201c;
        Object obj = objArr[iR];
        objArr[iR] = Composer.f23746a.a();
        return obj;
    }

    public final void L(boolean z2) {
        this.f24221w = true;
        if (z2 && this.f24214p.f23907b == 0) {
            A0(f0());
            C0(this.f24201c.length - this.f24210l, this.f24205g);
            K();
            N0();
        }
        this.f24199a.h(this, this.f24200b, this.f24205g, this.f24201c, this.f24209k, this.f24202d, this.f24203e, this.f24204f);
    }

    public final boolean P0() {
        Anchor anchorO1;
        if (!(this.f24212n == 0)) {
            ComposerKt.t("Cannot remove group while inserting");
        }
        int i3 = this.f24218t;
        int i4 = this.f24207i;
        int iQ = Q(this.f24200b, j0(i3));
        int iY0 = Y0();
        GroupSourceInformation groupSourceInformationH1 = h1(this.f24220v);
        if (groupSourceInformationH1 != null && (anchorO1 = o1(i3)) != null) {
            groupSourceInformationH1.j(anchorO1);
        }
        MutableIntList mutableIntList = this.f24222x;
        if (mutableIntList != null) {
            while (PrioritySet.f(mutableIntList) && PrioritySet.g(mutableIntList) >= i3) {
                PrioritySet.h(mutableIntList);
            }
        }
        boolean zQ0 = Q0(i3, this.f24218t - i3);
        R0(iQ, this.f24207i - iQ, i3 - 1);
        this.f24218t = i3;
        this.f24207i = i4;
        this.f24213o -= iY0;
        return zQ0;
    }

    public final void S0() {
        if (!(this.f24212n == 0)) {
            ComposerKt.t("Cannot reset when inserting");
        }
        N0();
        this.f24218t = 0;
        this.f24219u = Y() - this.f24206h;
        this.f24207i = 0;
        this.f24208j = 0;
        this.f24213o = 0;
    }

    public final int T() {
        MutableObjectList mutableObjectList;
        boolean z2 = this.f24212n > 0;
        int i3 = this.f24218t;
        int i4 = this.f24219u;
        int i5 = this.f24220v;
        int iJ0 = j0(i5);
        int i6 = this.f24213o;
        int i7 = i3 - i5;
        int i8 = (iJ0 * 5) + 1;
        boolean z3 = (this.f24200b[i8] & 1073741824) != 0;
        if (z2) {
            MutableIntObjectMap mutableIntObjectMap = this.f24217s;
            if (mutableIntObjectMap != null && (mutableObjectList = (MutableObjectList) mutableIntObjectMap.b(i5)) != null) {
                Object[] objArr = mutableObjectList.f3081a;
                int i9 = mutableObjectList.f3082b;
                for (int i10 = 0; i10 < i9; i10++) {
                    M0(objArr[i10]);
                }
            }
            SlotTableKt.x(this.f24200b, iJ0, i7);
            SlotTableKt.z(this.f24200b, iJ0, i6);
            this.f24213o = this.f24216r.g() + (z3 ? 1 : i6);
            int iJ02 = J0(this.f24200b, i5);
            this.f24220v = iJ02;
            int iF0 = iJ02 < 0 ? f0() : j0(iJ02 + 1);
            int iQ = iF0 >= 0 ? Q(this.f24200b, iF0) : 0;
            this.f24207i = iQ;
            this.f24208j = iQ;
            return i6;
        }
        if (!(i3 == i4)) {
            ComposerKt.t("Expected to be at the end of a group");
        }
        int iP = SlotTableKt.p(this.f24200b, iJ0);
        int[] iArr = this.f24200b;
        int i11 = iArr[i8] & 67108863;
        SlotTableKt.x(iArr, iJ0, i7);
        SlotTableKt.z(this.f24200b, iJ0, i6);
        int iG = this.f24214p.g();
        T0();
        this.f24220v = iG;
        int iJ03 = J0(this.f24200b, i5);
        int iG2 = this.f24216r.g();
        this.f24213o = iG2;
        if (iJ03 == iG) {
            this.f24213o = iG2 + (z3 ? 0 : i6 - i11);
            return i6;
        }
        int i12 = i7 - iP;
        int i13 = z3 ? 0 : i6 - i11;
        if (i12 != 0 || i13 != 0) {
            while (iJ03 != 0 && iJ03 != iG && (i13 != 0 || i12 != 0)) {
                int iJ04 = j0(iJ03);
                if (i12 != 0) {
                    SlotTableKt.x(this.f24200b, iJ04, SlotTableKt.p(this.f24200b, iJ04) + i12);
                }
                if (i13 != 0) {
                    int[] iArr2 = this.f24200b;
                    SlotTableKt.z(iArr2, iJ04, (iArr2[(iJ04 * 5) + 1] & 67108863) + i13);
                }
                int[] iArr3 = this.f24200b;
                if ((iArr3[(iJ04 * 5) + 1] & 1073741824) != 0) {
                    i13 = 0;
                }
                iJ03 = J0(iArr3, iJ03);
            }
        }
        this.f24213o += i13;
        return i6;
    }

    public final void U() {
        if (!(this.f24212n > 0)) {
            PreconditionsKt.b("Unbalanced begin/end insert");
        }
        int i3 = this.f24212n - 1;
        this.f24212n = i3;
        if (i3 == 0) {
            if (!(this.f24216r.f23907b == this.f24214p.f23907b)) {
                ComposerKt.t("startGroup/endGroup mismatch while inserting");
            }
            T0();
        }
    }

    public final void V(int i3) {
        boolean z2 = false;
        if (!(this.f24212n <= 0)) {
            ComposerKt.t("Cannot call ensureStarted() while inserting");
        }
        int i4 = this.f24220v;
        if (i4 != i3) {
            if (i3 >= i4 && i3 < this.f24219u) {
                z2 = true;
            }
            if (!z2) {
                ComposerKt.t("Started group at " + i3 + " must be a subgroup of the group at " + i4);
            }
            int i5 = this.f24218t;
            int i6 = this.f24207i;
            int i7 = this.f24208j;
            this.f24218t = i3;
            j1();
            this.f24218t = i5;
            this.f24207i = i6;
            this.f24208j = i7;
        }
    }

    public final Object V0(int i3, int i4, Object obj) {
        int iR = R(d1(i3, i4));
        Object[] objArr = this.f24201c;
        Object obj2 = objArr[iR];
        objArr[iR] = obj;
        return obj2;
    }

    public final void W(Anchor anchor) {
        V(anchor.e(this));
    }

    public final void W0(Object obj) {
        if (!(this.f24207i <= this.f24208j)) {
            ComposerKt.t("Writing to an invalid slot");
        }
        this.f24201c[R(this.f24207i - 1)] = obj;
    }

    public final Object X0() {
        if (this.f24212n > 0) {
            r0(1, this.f24220v);
        }
        Object[] objArr = this.f24201c;
        int i3 = this.f24207i;
        this.f24207i = i3 + 1;
        return objArr[R(i3)];
    }

    public final int Y0() {
        int iJ0 = j0(this.f24218t);
        int iP = this.f24218t + SlotTableKt.p(this.f24200b, iJ0);
        this.f24218t = iP;
        this.f24207i = Q(this.f24200b, j0(iP));
        int i3 = this.f24200b[(iJ0 * 5) + 1];
        if ((1073741824 & i3) != 0) {
            return 1;
        }
        return i3 & 67108863;
    }

    public final boolean Z() {
        return this.f24221w;
    }

    public final void Z0() {
        int i3 = this.f24219u;
        this.f24218t = i3;
        this.f24207i = Q(this.f24200b, j0(i3));
    }

    public final boolean a0() {
        return this.f24204f != null;
    }

    public final Object a1(int i3, int i4) {
        int iC1 = c1(this.f24200b, j0(i3));
        int iQ = Q(this.f24200b, j0(i3 + 1));
        int i5 = i4 + iC1;
        if (iC1 > i5 || i5 >= iQ) {
            return Composer.f23746a.a();
        }
        return this.f24201c[R(i5)];
    }

    public final boolean b0() {
        return this.f24203e != null;
    }

    public final Object b1(Anchor anchor, int i3) {
        return a1(E(anchor), i3);
    }

    public final int c0() {
        return this.f24218t;
    }

    public final int d0() {
        return this.f24219u;
    }

    public final int d1(int i3, int i4) {
        int iC1 = c1(this.f24200b, j0(i3));
        int i5 = iC1 + i4;
        if (!(i5 >= iC1 && i5 < Q(this.f24200b, j0(i3 + 1)))) {
            ComposerKt.t("Write to an invalid slot index " + i4 + " for group " + i3);
        }
        return i5;
    }

    public final int e0() {
        return this.f24220v;
    }

    public final int e1(int i3) {
        return Q(this.f24200b, j0(i3 + m0(i3)));
    }

    public final int f0() {
        return Y() - this.f24206h;
    }

    public final int f1(int i3) {
        return Q(this.f24200b, j0(i3 + 1));
    }

    public final int g0() {
        return this.f24201c.length - this.f24210l;
    }

    public final int g1(int i3) {
        return c1(this.f24200b, j0(i3));
    }

    public final SlotTable h0() {
        return this.f24199a;
    }

    public final Object i0(int i3) {
        int iJ0 = j0(i3);
        int[] iArr = this.f24200b;
        return (iArr[(iJ0 * 5) + 1] & 268435456) != 0 ? this.f24201c[G(iArr, iJ0)] : Composer.f23746a.a();
    }

    public final void i1(int i3, Object obj, Object obj2) {
        l1(i3, obj, false, obj2);
    }

    public final void j1() {
        if (!(this.f24212n == 0)) {
            ComposerKt.t("Key must be supplied when inserting");
        }
        Composer.Companion companion = Composer.f23746a;
        l1(0, companion.a(), false, companion.a());
    }

    public final int k0(int i3) {
        return this.f24200b[j0(i3) * 5];
    }

    public final void k1(int i3, Object obj) {
        l1(i3, obj, false, Composer.f23746a.a());
    }

    public final Object l0(int i3) {
        int iJ0 = j0(i3);
        int[] iArr = this.f24200b;
        if ((iArr[(iJ0 * 5) + 1] & 536870912) != 0) {
            return this.f24201c[SlotTableKt.s(iArr, iJ0)];
        }
        return null;
    }

    public final int m0(int i3) {
        return SlotTableKt.p(this.f24200b, j0(i3));
    }

    public final void m1(int i3, Object obj) {
        l1(i3, obj, true, Composer.f23746a.a());
    }

    public final boolean n0(int i3) {
        return o0(i3, this.f24218t);
    }

    public final void n1(int i3) {
        if (!(i3 > 0)) {
            ComposerKt.t("Check failed");
        }
        int i4 = this.f24220v;
        int iC1 = c1(this.f24200b, j0(i4));
        int iQ = Q(this.f24200b, j0(i4 + 1)) - i3;
        if (!(iQ >= iC1)) {
            ComposerKt.t("Check failed");
        }
        R0(iQ, i3, i4);
        int i5 = this.f24207i;
        if (i5 >= iC1) {
            this.f24207i = i5 - i3;
        }
    }

    public final boolean o0(int i3, int i4) {
        int iB;
        int iY;
        if (i4 == this.f24220v) {
            iY = this.f24219u;
        } else if (i4 <= this.f24214p.f(0) && (iB = this.f24214p.b(i4)) >= 0) {
            iY = (Y() - this.f24206h) - this.f24215q.d(iB);
        } else {
            int iM0 = m0(i4);
            iY = iM0 + i4;
        }
        return i3 > i4 && i3 < iY;
    }

    public final Anchor o1(int i3) {
        if (i3 < 0 || i3 >= f0()) {
            return null;
        }
        return SlotTableKt.o(this.f24202d, i3, f0());
    }

    public final boolean p0(int i3) {
        int i4 = this.f24220v;
        if (i3 <= i4 || i3 >= this.f24219u) {
            return i4 == 0 && i3 == 0;
        }
        return true;
    }

    public final Object p1(Object obj) {
        if (this.f24212n <= 0 || this.f24207i == this.f24209k) {
            return M0(obj);
        }
        MutableIntObjectMap mutableIntObjectMap = this.f24217s;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 1;
        int i4 = 0;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap(i4, i3, defaultConstructorMarker);
        }
        this.f24217s = mutableIntObjectMap;
        int i5 = this.f24220v;
        Object objB = mutableIntObjectMap.b(i5);
        if (objB == null) {
            objB = new MutableObjectList(i4, i3, defaultConstructorMarker);
            mutableIntObjectMap.r(i5, objB);
        }
        ((MutableObjectList) objB).n(obj);
        return Composer.f23746a.a();
    }

    public final void r1(Object obj) {
        int iJ0 = j0(this.f24218t);
        if (!((this.f24200b[(iJ0 * 5) + 1] & 268435456) != 0)) {
            ComposerKt.t("Updating the data of a group that was not created with a data slot");
        }
        this.f24201c[R(G(this.f24200b, iJ0))] = obj;
    }

    public final boolean s0() {
        return this.f24218t == this.f24219u;
    }

    public final boolean t0() {
        int i3 = this.f24218t;
        return i3 < this.f24219u && (this.f24200b[(j0(i3) * 5) + 1] & 1073741824) != 0;
    }

    public String toString() {
        return "SlotWriter(current = " + this.f24218t + " end=" + this.f24219u + " size = " + f0() + " gap=" + this.f24205g + '-' + (this.f24205g + this.f24206h) + ')';
    }

    public final boolean u0(int i3) {
        return (this.f24200b[(j0(i3) * 5) + 1] & 1073741824) != 0;
    }

    public final void v0(int i3) {
        int iJ0 = j0(i3);
        int[] iArr = this.f24200b;
        int i4 = (iJ0 * 5) + 1;
        if ((iArr[i4] & 134217728) != 0) {
            return;
        }
        SlotTableKt.y(iArr, iJ0, true);
        if ((this.f24200b[i4] & 67108864) != 0) {
            return;
        }
        s1(I0(i3));
    }

    public final void v1(Anchor anchor, Object obj) {
        x1(anchor.e(this), obj);
    }

    public final void w1(Object obj) {
        x1(this.f24218t, obj);
    }

    public final List y0(SlotTable slotTable, int i3, boolean z2) {
        if (!(this.f24212n > 0)) {
            ComposerKt.t("Check failed");
        }
        if (i3 != 0 || this.f24218t != 0 || this.f24199a.t() != 0 || SlotTableKt.p(slotTable.s(), i3) != slotTable.t()) {
            SlotWriter slotWriterC = slotTable.C();
            try {
                List listB = f24197y.b(slotWriterC, i3, this, true, true, z2);
                slotWriterC.L(true);
                return listB;
            } catch (Throwable th) {
                slotWriterC.L(false);
                throw th;
            }
        }
        int[] iArr = this.f24200b;
        Object[] objArr = this.f24201c;
        ArrayList arrayList = this.f24202d;
        HashMap map = this.f24203e;
        MutableIntObjectMap mutableIntObjectMap = this.f24204f;
        int[] iArrS = slotTable.s();
        int iT = slotTable.t();
        Object[] objArrU = slotTable.u();
        int iV = slotTable.v();
        HashMap mapW = slotTable.w();
        MutableIntObjectMap mutableIntObjectMapQ = slotTable.q();
        this.f24200b = iArrS;
        this.f24201c = objArrU;
        this.f24202d = slotTable.p();
        this.f24205g = iT;
        this.f24206h = (iArrS.length / 5) - iT;
        this.f24209k = iV;
        this.f24210l = objArrU.length - iV;
        this.f24211m = iT;
        this.f24203e = mapW;
        this.f24204f = mutableIntObjectMapQ;
        slotTable.E(iArr, 0, objArr, 0, arrayList, map, mutableIntObjectMap);
        return this.f24202d;
    }

    public final void y1() {
        this.f24203e = this.f24199a.w();
        this.f24204f = this.f24199a.q();
    }

    public final void z0(int i3) {
        boolean z2 = true;
        if (!(this.f24212n == 0)) {
            ComposerKt.t("Cannot move a group while inserting");
        }
        if (!(i3 >= 0)) {
            ComposerKt.t("Parameter offset is out of bounds");
        }
        if (i3 == 0) {
            return;
        }
        int i4 = this.f24218t;
        int i5 = this.f24220v;
        int i6 = this.f24219u;
        int iP = i4;
        for (int i7 = i3; i7 > 0; i7--) {
            iP += SlotTableKt.p(this.f24200b, j0(iP));
            if (!(iP <= i6)) {
                ComposerKt.t("Parameter offset is out of bounds");
            }
        }
        int iP2 = SlotTableKt.p(this.f24200b, j0(iP));
        int iQ = Q(this.f24200b, j0(this.f24218t));
        int iQ2 = Q(this.f24200b, j0(iP));
        int i8 = iP + iP2;
        int iQ3 = Q(this.f24200b, j0(i8));
        int i9 = iQ3 - iQ2;
        r0(i9, Math.max(this.f24218t - 1, 0));
        q0(iP2);
        int[] iArr = this.f24200b;
        int iJ0 = j0(i8) * 5;
        ArraysKt.copyInto(iArr, iArr, j0(i4) * 5, iJ0, (iP2 * 5) + iJ0);
        if (i9 > 0) {
            Object[] objArr = this.f24201c;
            int iR = R(iQ2 + i9);
            System.arraycopy(objArr, iR, objArr, iQ, R(iQ3 + i9) - iR);
        }
        int i10 = iQ2 + i9;
        int i11 = i10 - iQ;
        int i12 = this.f24209k;
        int i13 = this.f24210l;
        int length = this.f24201c.length;
        int i14 = this.f24211m;
        int i15 = i4 + iP2;
        int i16 = i4;
        while (i16 < i15) {
            boolean z3 = z2;
            int iJ02 = j0(i16);
            int i17 = i16;
            int i18 = i11;
            u1(iArr, iJ02, S(Q(iArr, iJ02) - i11, i14 < iJ02 ? 0 : i12, i13, length));
            i16 = i17 + 1;
            z2 = z3;
            i11 = i18;
        }
        x0(i8, i4, iP2);
        if (Q0(i8, iP2)) {
            ComposerKt.t("Unexpectedly removed anchors");
        }
        X(i5, this.f24219u, i4);
        if (i9 > 0) {
            R0(i10, i9, i8 - 1);
        }
    }
}

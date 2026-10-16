package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24183b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24185d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24186f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24189i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private HashMap f24191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MutableIntObjectMap f24192l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f24182a = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f24184c = new Object[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f24187g = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f24190j = new ArrayList();

    private final Anchor I(int i3) {
        int i4;
        if (this.f24188h) {
            ComposerKt.t("use active SlotWriter to crate an anchor for location instead");
        }
        if (i3 < 0 || i3 >= (i4 = this.f24183b)) {
            return null;
        }
        return SlotTableKt.o(this.f24190j, i3, i4);
    }

    public final boolean A(int i3, Anchor anchor) {
        if (this.f24188h) {
            ComposerKt.t("Writer is active");
        }
        if (!(i3 >= 0 && i3 < this.f24183b)) {
            ComposerKt.t("Invalid group index");
        }
        if (D(anchor)) {
            int iP = SlotTableKt.p(this.f24182a, i3) + i3;
            int iA = anchor.a();
            if (i3 <= iA && iA < iP) {
                return true;
            }
        }
        return false;
    }

    public final SlotReader B() {
        if (this.f24188h) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.f24186f++;
        return new SlotReader(this);
    }

    public final SlotWriter C() {
        if (this.f24188h) {
            ComposerKt.t("Cannot start a writer when another writer is pending");
        }
        if (!(this.f24186f <= 0)) {
            ComposerKt.t("Cannot start a writer when a reader is pending");
        }
        this.f24188h = true;
        this.f24189i++;
        return new SlotWriter(this);
    }

    public final boolean D(Anchor anchor) {
        int iT;
        return anchor.b() && (iT = SlotTableKt.t(this.f24190j, anchor.a(), this.f24183b)) >= 0 && Intrinsics.areEqual(this.f24190j.get(iT), anchor);
    }

    public final void E(int[] iArr, int i3, Object[] objArr, int i4, ArrayList arrayList, HashMap map, MutableIntObjectMap mutableIntObjectMap) {
        this.f24182a = iArr;
        this.f24183b = i3;
        this.f24184c = objArr;
        this.f24185d = i4;
        this.f24190j = arrayList;
        this.f24191k = map;
        this.f24192l = mutableIntObjectMap;
    }

    public final Object G(int i3, int i4) {
        int iU = SlotTableKt.u(this.f24182a, i3);
        int i5 = i3 + 1;
        return (i4 < 0 || i4 >= (i5 < this.f24183b ? this.f24182a[(i5 * 5) + 4] : this.f24184c.length) - iU) ? Composer.f23746a.a() : this.f24184c[iU + i4];
    }

    public final GroupSourceInformation H(int i3) {
        Anchor anchorI;
        HashMap map = this.f24191k;
        if (map == null || (anchorI = I(i3)) == null) {
            return null;
        }
        return (GroupSourceInformation) map.get(anchorI);
    }

    public final Anchor e(int i3) {
        if (this.f24188h) {
            ComposerKt.t("use active SlotWriter to create an anchor location instead");
        }
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f24183b) {
            z2 = true;
        }
        if (!z2) {
            PreconditionsKt.a("Parameter index is out of range");
        }
        ArrayList arrayList = this.f24190j;
        int iT = SlotTableKt.t(arrayList, i3, this.f24183b);
        if (iT >= 0) {
            return (Anchor) arrayList.get(iT);
        }
        Anchor anchor = new Anchor(i3);
        arrayList.add(-(iT + 1), anchor);
        return anchor;
    }

    public final int f(Anchor anchor) {
        if (this.f24188h) {
            ComposerKt.t("Use active SlotWriter to determine anchor location instead");
        }
        if (!anchor.b()) {
            PreconditionsKt.a("Anchor refers to a group that was removed");
        }
        return anchor.a();
    }

    public final void g(SlotReader slotReader, HashMap map) {
        if (!(slotReader.y() == this && this.f24186f > 0)) {
            ComposerKt.t("Unexpected reader close()");
        }
        this.f24186f--;
        if (map != null) {
            synchronized (this.f24187g) {
                try {
                    HashMap map2 = this.f24191k;
                    if (map2 != null) {
                        map2.putAll(map);
                    } else {
                        this.f24191k = map;
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void h(SlotWriter slotWriter, int[] iArr, int i3, Object[] objArr, int i4, ArrayList arrayList, HashMap map, MutableIntObjectMap mutableIntObjectMap) {
        if (!(slotWriter.h0() == this && this.f24188h)) {
            PreconditionsKt.a("Unexpected writer close()");
        }
        this.f24188h = false;
        E(iArr, i3, objArr, i4, arrayList, map, mutableIntObjectMap);
    }

    public boolean isEmpty() {
        return this.f24183b == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.f24183b);
    }

    public final void l() {
        this.f24192l = new MutableIntObjectMap(0, 1, null);
    }

    public final void n() {
        this.f24191k = new HashMap();
    }

    public final boolean o() {
        return this.f24183b > 0 && (this.f24182a[1] & 67108864) != 0;
    }

    public final ArrayList p() {
        return this.f24190j;
    }

    public final MutableIntObjectMap q() {
        return this.f24192l;
    }

    public final int[] s() {
        return this.f24182a;
    }

    public final int t() {
        return this.f24183b;
    }

    public final Object[] u() {
        return this.f24184c;
    }

    public final int v() {
        return this.f24185d;
    }

    public final HashMap w() {
        return this.f24191k;
    }

    public final int x() {
        return this.f24189i;
    }

    public final boolean y() {
        return this.f24188h;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable b() {
        return this;
    }
}

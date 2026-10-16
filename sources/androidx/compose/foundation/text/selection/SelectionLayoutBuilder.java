package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
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
public final class SelectionLayoutBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayoutCoordinates f11389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Selection f11391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Comparator f11392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableLongIntMap f11393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f11394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11397k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11398a;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.f11217a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.f11218b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.f11219c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11398a = iArr;
        }
    }

    public /* synthetic */ SelectionLayoutBuilder(long j3, long j4, LayoutCoordinates layoutCoordinates, boolean z2, Selection selection, Comparator comparator, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, layoutCoordinates, z2, selection, comparator);
    }

    private final int i(int i3, Direction direction, Direction direction2) {
        if (i3 == -1) {
            int i4 = WhenMappings.f11398a[SelectionLayoutKt.f(direction, direction2).ordinal()];
            if (i4 == 1) {
                return this.f11397k - 1;
            }
            if (i4 == 2) {
                return this.f11397k;
            }
            if (i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i3;
    }

    public final SelectableInfo a(long j3, int i3, Direction direction, Direction direction2, int i4, Direction direction3, Direction direction4, int i5, TextLayoutResult textLayoutResult) {
        this.f11397k += 2;
        SelectableInfo selectableInfo = new SelectableInfo(j3, this.f11397k, i3, i4, i5, textLayoutResult);
        this.f11395i = i(this.f11395i, direction, direction2);
        this.f11396j = i(this.f11396j, direction3, direction4);
        this.f11393g.n(j3, this.f11394h.size());
        this.f11394h.add(selectableInfo);
        return selectableInfo;
    }

    public final SelectionLayout b() {
        int i3 = this.f11397k + 1;
        int size = this.f11394h.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            SelectableInfo selectableInfo = (SelectableInfo) CollectionsKt.single(this.f11394h);
            int i4 = this.f11395i;
            int i5 = i4 == -1 ? i3 : i4;
            int i6 = this.f11396j;
            return new SingleSelectionLayout(this.f11390d, i5, i6 == -1 ? i3 : i6, this.f11391e, selectableInfo);
        }
        MutableLongIntMap mutableLongIntMap = this.f11393g;
        List list = this.f11394h;
        int i7 = this.f11395i;
        int i8 = i7 == -1 ? i3 : i7;
        int i9 = this.f11396j;
        return new MultiSelectionLayout(mutableLongIntMap, list, i8, i9 == -1 ? i3 : i9, this.f11390d, this.f11391e);
    }

    public final LayoutCoordinates c() {
        return this.f11389c;
    }

    public final long d() {
        return this.f11387a;
    }

    public final long e() {
        return this.f11388b;
    }

    public final Selection f() {
        return this.f11391e;
    }

    public final Comparator g() {
        return this.f11392f;
    }

    public final boolean h() {
        return this.f11390d;
    }

    private SelectionLayoutBuilder(long j3, long j4, LayoutCoordinates layoutCoordinates, boolean z2, Selection selection, Comparator comparator) {
        this.f11387a = j3;
        this.f11388b = j4;
        this.f11389c = layoutCoordinates;
        this.f11390d = z2;
        this.f11391e = selection;
        this.f11392f = comparator;
        this.f11393g = LongIntMapKt.a();
        this.f11394h = new ArrayList();
        this.f11395i = -1;
        this.f11396j = -1;
        this.f11397k = -1;
    }
}

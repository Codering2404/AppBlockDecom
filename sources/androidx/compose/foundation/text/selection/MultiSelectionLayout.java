package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
final class MultiSelectionLayout implements SelectionLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LongIntMap f11235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f11236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Selection f11240f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11241a;

        static {
            int[] iArr = new int[CrossStatus.values().length];
            try {
                iArr[CrossStatus.f11214c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CrossStatus.f11213b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CrossStatus.f11212a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11241a = iArr;
        }
    }

    public MultiSelectionLayout(LongIntMap longIntMap, List list, int i3, int i4, boolean z2, Selection selection) {
        this.f11235a = longIntMap;
        this.f11236b = list;
        this.f11237c = i3;
        this.f11238d = i4;
        this.f11239e = z2;
        this.f11240f = selection;
        if (list.size() > 1) {
            return;
        }
        InlineClassHelperKt.c("MultiSelectionLayout requires an infoList size greater than 1, was " + list.size() + '.');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MutableLongObjectMap mutableLongObjectMap, Selection selection, SelectableInfo selectableInfo, int i3, int i4) {
        Selection selectionM = selection.d() ? selectableInfo.m(i4, i3) : selectableInfo.m(i3, i4);
        if (!(i3 <= i4)) {
            InlineClassHelperKt.c("minOffset should be less than or equal to maxOffset: " + selectionM);
        }
        mutableLongObjectMap.n(selectableInfo.h(), selectionM);
    }

    private final int o(long j3) {
        try {
            return this.f11235a.b(j3);
        } catch (NoSuchElementException e3) {
            throw new IllegalStateException("Invalid selectableId: " + j3, e3);
        }
    }

    private final boolean q(MultiSelectionLayout multiSelectionLayout) {
        if (getSize() != multiSelectionLayout.getSize()) {
            return true;
        }
        int size = this.f11236b.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((SelectableInfo) this.f11236b.get(i3)).n((SelectableInfo) multiSelectionLayout.f11236b.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private final int r(int i3, boolean z2) {
        return (i3 - (!z2 ? 1 : 0)) / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int s(int r4, boolean r5) {
        /*
            r3 = this;
            androidx.compose.foundation.text.selection.CrossStatus r0 = r3.e()
            int[] r1 = androidx.compose.foundation.text.selection.MultiSelectionLayout.WhenMappings.f11241a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L17
            r2 = 2
            if (r0 == r2) goto L21
            r2 = 3
            if (r0 != r2) goto L1b
            if (r5 != 0) goto L19
        L17:
            r5 = r1
            goto L21
        L19:
            r5 = 0
            goto L21
        L1b:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L21:
            int r4 = r3.r(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiSelectionLayout.s(int, boolean):int");
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean a() {
        return this.f11239e;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo b() {
        return a() ? k() : j();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo c() {
        return e() == CrossStatus.f11212a ? j() : k();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int d() {
        return this.f11238d;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public CrossStatus e() {
        return l() < d() ? CrossStatus.f11213b : l() > d() ? CrossStatus.f11212a : ((SelectableInfo) this.f11236b.get(l() / 2)).d();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void f(Function1 function1) {
        int iO = o(c().h());
        int iO2 = o(p().h());
        int i3 = iO + 1;
        if (i3 >= iO2) {
            return;
        }
        while (i3 < iO2) {
            function1.invoke(this.f11236b.get(i3));
            i3++;
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public Selection g() {
        return this.f11240f;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return this.f11236b.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public LongObjectMap h(final Selection selection) {
        if (selection.e().e() != selection.c().e()) {
            final MutableLongObjectMap mutableLongObjectMapC = LongObjectMapKt.c();
            n(mutableLongObjectMapC, selection, c(), (selection.d() ? selection.c() : selection.e()).d(), c().l());
            f(new Function1<SelectableInfo, Unit>() { // from class: androidx.compose.foundation.text.selection.MultiSelectionLayout$createSubSelections$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(SelectableInfo selectableInfo) {
                    this.f11242a.n(mutableLongObjectMapC, selection, selectableInfo, 0, selectableInfo.l());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((SelectableInfo) obj);
                    return Unit.f139807a;
                }
            });
            n(mutableLongObjectMapC, selection, p(), 0, (selection.d() ? selection.e() : selection.c()).d());
            return mutableLongObjectMapC;
        }
        if (!((selection.d() && selection.e().d() >= selection.c().d()) || (!selection.d() && selection.e().d() <= selection.c().d()))) {
            InlineClassHelperKt.c("unexpectedly miss-crossed selection: " + selection);
        }
        return LongObjectMapKt.b(selection.e().e(), selection);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean i(SelectionLayout selectionLayout) {
        return (g() != null && selectionLayout != null && (selectionLayout instanceof MultiSelectionLayout) && a() == selectionLayout.a() && l() == selectionLayout.l() && d() == selectionLayout.d() && !q((MultiSelectionLayout) selectionLayout)) ? false : true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo j() {
        return (SelectableInfo) this.f11236b.get(s(d(), false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo k() {
        return (SelectableInfo) this.f11236b.get(s(l(), true));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int l() {
        return this.f11237c;
    }

    public SelectableInfo p() {
        return e() == CrossStatus.f11212a ? k() : j();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiSelectionLayout(isStartHandle=");
        sb.append(a());
        sb.append(", startPosition=");
        boolean z2 = true;
        float f3 = 2;
        sb.append((l() + 1) / f3);
        sb.append(", endPosition=");
        sb.append((d() + 1) / f3);
        sb.append(", crossed=");
        sb.append(e());
        sb.append(", infos=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n\t");
        List list = this.f11236b;
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            SelectableInfo selectableInfo = (SelectableInfo) list.get(i3);
            if (z2) {
                z2 = false;
            } else {
                sb2.append(",\n\t");
            }
            StringBuilder sb3 = new StringBuilder();
            i3++;
            sb3.append(i3);
            sb3.append(" -> ");
            sb3.append(selectableInfo);
            sb2.append(sb3.toString());
        }
        sb2.append("\n]");
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append(')');
        return sb.toString();
    }
}

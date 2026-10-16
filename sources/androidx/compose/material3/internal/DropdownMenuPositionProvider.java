package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
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
public final class DropdownMenuPositionProvider implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f22026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Density f22027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f22029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MenuPosition.Horizontal f22030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MenuPosition.Horizontal f22031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MenuPosition.Horizontal f22032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MenuPosition.Horizontal f22033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MenuPosition.Vertical f22034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MenuPosition.Vertical f22035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MenuPosition.Vertical f22036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MenuPosition.Vertical f22037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MenuPosition.Vertical f22038m;

    public /* synthetic */ DropdownMenuPositionProvider(long j3, Density density, int i3, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, density, i3, function2);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
        int iA;
        int i3 = 0;
        List listListOf = CollectionsKt.listOf((Object[]) new MenuPosition.Horizontal[]{this.f22030e, this.f22031f, IntOffset.k(intRect.e()) < IntSize.g(j3) / 2 ? this.f22032g : this.f22033h});
        int size = listListOf.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                iA = 0;
                break;
            }
            iA = ((MenuPosition.Horizontal) listListOf.get(i4)).a(intRect, j3, IntSize.g(j4), layoutDirection);
            if (i4 == CollectionsKt.getLastIndex(listListOf) || (iA >= 0 && IntSize.g(j4) + iA <= IntSize.g(j3))) {
                break;
            }
            i4++;
        }
        List listListOf2 = CollectionsKt.listOf((Object[]) new MenuPosition.Vertical[]{this.f22034i, this.f22035j, this.f22036k, IntOffset.l(intRect.e()) < IntSize.f(j3) / 2 ? this.f22037l : this.f22038m});
        int size2 = listListOf2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            int iA2 = ((MenuPosition.Vertical) listListOf2.get(i5)).a(intRect, j3, IntSize.f(j4));
            if (i5 == CollectionsKt.getLastIndex(listListOf2) || (iA2 >= this.f22028c && IntSize.f(j4) + iA2 <= IntSize.f(j3) - this.f22028c)) {
                i3 = iA2;
                break;
            }
        }
        long jA = IntOffsetKt.a(iA, i3);
        this.f22029d.invoke(intRect, IntRectKt.a(jA, j4));
        return jA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.e(this.f22026a, dropdownMenuPositionProvider.f22026a) && Intrinsics.areEqual(this.f22027b, dropdownMenuPositionProvider.f22027b) && this.f22028c == dropdownMenuPositionProvider.f22028c && Intrinsics.areEqual(this.f22029d, dropdownMenuPositionProvider.f22029d);
    }

    public int hashCode() {
        return (((((DpOffset.h(this.f22026a) * 31) + this.f22027b.hashCode()) * 31) + Integer.hashCode(this.f22028c)) * 31) + this.f22029d.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.i(this.f22026a)) + ", density=" + this.f22027b + ", verticalMargin=" + this.f22028c + ", onPositionCalculated=" + this.f22029d + ')';
    }

    private DropdownMenuPositionProvider(long j3, Density density, int i3, Function2 function2) {
        this.f22026a = j3;
        this.f22027b = density;
        this.f22028c = i3;
        this.f22029d = function2;
        int iZ0 = density.z0(DpOffset.f(j3));
        MenuPosition menuPosition = MenuPosition.f22094a;
        this.f22030e = menuPosition.k(iZ0);
        this.f22031f = menuPosition.e(iZ0);
        this.f22032g = menuPosition.g(0);
        this.f22033h = menuPosition.i(0);
        int iZ02 = density.z0(DpOffset.g(j3));
        this.f22034i = menuPosition.m(iZ02);
        this.f22035j = menuPosition.a(iZ02);
        this.f22036k = menuPosition.d(iZ02);
        this.f22037l = menuPosition.o(i3);
        this.f22038m = menuPosition.c(i3);
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j3, Density density, int i3, Function2 function2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, density, (i4 & 4) != 0 ? density.z0(MenuKt.j()) : i3, (i4 & 8) != 0 ? new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.internal.DropdownMenuPositionProvider.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((IntRect) obj, (IntRect) obj2);
                return Unit.f139807a;
            }

            public final void c(IntRect intRect, IntRect intRect2) {
            }
        } : function2, null);
    }
}

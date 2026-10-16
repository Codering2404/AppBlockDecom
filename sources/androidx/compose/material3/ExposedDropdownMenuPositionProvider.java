package androidx.compose.material3;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
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
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Density f17618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final State f17620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function2 f17622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MenuPosition.Horizontal f17623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MenuPosition.Horizontal f17624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MenuPosition.Horizontal f17625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MenuPosition.Horizontal f17626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MenuPosition.Vertical f17627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MenuPosition.Vertical f17628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MenuPosition.Vertical f17629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MenuPosition.Vertical f17630m;

    public ExposedDropdownMenuPositionProvider(Density density, int i3, State state, int i4, Function2 function2) {
        this.f17618a = density;
        this.f17619b = i3;
        this.f17620c = state;
        this.f17621d = i4;
        this.f17622e = function2;
        MenuPosition menuPosition = MenuPosition.f22094a;
        this.f17623f = MenuPosition.l(menuPosition, 0, 1, null);
        this.f17624g = MenuPosition.f(menuPosition, 0, 1, null);
        this.f17625h = MenuPosition.h(menuPosition, 0, 1, null);
        this.f17626i = MenuPosition.j(menuPosition, 0, 1, null);
        this.f17627j = MenuPosition.n(menuPosition, 0, 1, null);
        this.f17628k = MenuPosition.b(menuPosition, 0, 1, null);
        this.f17629l = menuPosition.o(i4);
        this.f17630m = menuPosition.c(i4);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
        int iA;
        State state = this.f17620c;
        if (state != null) {
            state.getValue();
        }
        long jA = IntSizeKt.a(IntSize.g(j3), IntSize.f(j3) + this.f17619b);
        int i3 = 0;
        List listListOf = CollectionsKt.listOf((Object[]) new MenuPosition.Horizontal[]{this.f17623f, this.f17624g, IntOffset.k(intRect.e()) < IntSize.g(jA) / 2 ? this.f17625h : this.f17626i});
        int size = listListOf.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                iA = 0;
                break;
            }
            iA = ((MenuPosition.Horizontal) listListOf.get(i4)).a(intRect, jA, IntSize.g(j4), layoutDirection);
            if (i4 == CollectionsKt.getLastIndex(listListOf) || (iA >= 0 && IntSize.g(j4) + iA <= IntSize.g(jA))) {
                break;
            }
            i4++;
        }
        List listListOf2 = CollectionsKt.listOf((Object[]) new MenuPosition.Vertical[]{this.f17627j, this.f17628k, IntOffset.l(intRect.e()) < IntSize.f(jA) / 2 ? this.f17629l : this.f17630m});
        int size2 = listListOf2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            int iA2 = ((MenuPosition.Vertical) listListOf2.get(i5)).a(intRect, jA, IntSize.f(j4));
            if (i5 == CollectionsKt.getLastIndex(listListOf2) || (iA2 >= 0 && IntSize.f(j4) + iA2 <= IntSize.f(jA))) {
                i3 = iA2;
                break;
            }
        }
        long jA2 = IntOffsetKt.a(iA, i3);
        this.f17622e.invoke(intRect, IntRectKt.a(jA2, j4));
        return jA2;
    }

    public /* synthetic */ ExposedDropdownMenuPositionProvider(Density density, int i3, State state, int i4, Function2 function2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, i3, (i5 & 4) != 0 ? null : state, (i5 & 8) != 0 ? density.z0(MenuKt.j()) : i4, (i5 & 16) != 0 ? new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuPositionProvider.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((IntRect) obj, (IntRect) obj2);
                return Unit.f139807a;
            }

            public final void c(IntRect intRect, IntRect intRect2) {
            }
        } : function2);
    }
}

package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
    private final long f12862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Density f12863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f12864c;

    public /* synthetic */ DropdownMenuPositionProvider(long j3, Density density, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, density, function2);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
        Sequence sequenceM;
        Object obj;
        Object next;
        int iZ0 = this.f12863b.z0(MenuKt.j());
        int iZ02 = this.f12863b.z0(DpOffset.f(this.f12862a));
        LayoutDirection layoutDirection2 = LayoutDirection.f30001a;
        int i3 = iZ02 * (layoutDirection == layoutDirection2 ? 1 : -1);
        int iZ03 = this.f12863b.z0(DpOffset.g(this.f12862a));
        int iG = intRect.g() + i3;
        int iH = (intRect.h() - IntSize.g(j4)) + i3;
        int iG2 = IntSize.g(j3) - IntSize.g(j4);
        if (layoutDirection == layoutDirection2) {
            Integer numValueOf = Integer.valueOf(iG);
            Integer numValueOf2 = Integer.valueOf(iH);
            if (intRect.g() < 0) {
                iG2 = 0;
            }
            sequenceM = SequencesKt.m(numValueOf, numValueOf2, Integer.valueOf(iG2));
        } else {
            Integer numValueOf3 = Integer.valueOf(iH);
            Integer numValueOf4 = Integer.valueOf(iG);
            if (intRect.h() <= IntSize.g(j3)) {
                iG2 = 0;
            }
            sequenceM = SequencesKt.m(numValueOf3, numValueOf4, Integer.valueOf(iG2));
        }
        Iterator it = sequenceM.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int iIntValue = ((Number) next).intValue();
            if (iIntValue >= 0 && iIntValue + IntSize.g(j4) <= IntSize.g(j3)) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num != null) {
            iH = num.intValue();
        }
        int iMax = Math.max(intRect.d() + iZ03, iZ0);
        int iJ = (intRect.j() - IntSize.f(j4)) + iZ03;
        Iterator it2 = SequencesKt.m(Integer.valueOf(iMax), Integer.valueOf(iJ), Integer.valueOf((intRect.j() - (IntSize.f(j4) / 2)) + iZ03), Integer.valueOf((IntSize.f(j3) - IntSize.f(j4)) - iZ0)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            int iIntValue2 = ((Number) next2).intValue();
            if (iIntValue2 >= iZ0 && iIntValue2 + IntSize.f(j4) <= IntSize.f(j3) - iZ0) {
                obj = next2;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            iJ = num2.intValue();
        }
        this.f12864c.invoke(intRect, new IntRect(iH, iJ, IntSize.g(j4) + iH, IntSize.f(j4) + iJ));
        return IntOffsetKt.a(iH, iJ);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.e(this.f12862a, dropdownMenuPositionProvider.f12862a) && Intrinsics.areEqual(this.f12863b, dropdownMenuPositionProvider.f12863b) && Intrinsics.areEqual(this.f12864c, dropdownMenuPositionProvider.f12864c);
    }

    public int hashCode() {
        return (((DpOffset.h(this.f12862a) * 31) + this.f12863b.hashCode()) * 31) + this.f12864c.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.i(this.f12862a)) + ", density=" + this.f12863b + ", onPositionCalculated=" + this.f12864c + ')';
    }

    private DropdownMenuPositionProvider(long j3, Density density, Function2 function2) {
        this.f12862a = j3;
        this.f12863b = density;
        this.f12864c = function2;
    }

    /* JADX INFO: renamed from: androidx.compose.material.DropdownMenuPositionProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function2<IntRect, IntRect, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f12865a = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((IntRect) obj, (IntRect) obj2);
            return Unit.f139807a;
        }

        public final void c(IntRect intRect, IntRect intRect2) {
        }
    }
}

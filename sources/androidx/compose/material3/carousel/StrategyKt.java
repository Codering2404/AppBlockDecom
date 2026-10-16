package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
public final class StrategyKt {
    private static final KeylineList i(final KeylineList keylineList, float f3, float f4, float f5, Keyline keyline, int i3) {
        ArrayList arrayList = new ArrayList(keylineList.size());
        int size = keylineList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Keyline keyline2 = keylineList.get(i4);
            if (!keyline2.g()) {
                arrayList.add(keyline2);
            }
        }
        final float size2 = f5 / arrayList.size();
        KeylineList keylineListB = KeylineListKt.b(f3, f4, i3, (keyline.d() - (size2 / 2.0f)) + f5, new Function1<KeylineListScope, Unit>() { // from class: androidx.compose.material3.carousel.StrategyKt$createShiftedKeylineListForContentPadding$newKeylines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(KeylineListScope keylineListScope) {
                KeylineList keylineList2 = keylineList;
                float f6 = size2;
                int size3 = keylineList2.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    Keyline keyline3 = keylineList2.get(i5);
                    keylineListScope.b(keyline3.e() - Math.abs(f6), keyline3.g());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((KeylineListScope) obj);
                return Unit.f139807a;
            }
        });
        ArrayList arrayList2 = new ArrayList(keylineListB.size());
        int size3 = keylineListB.size();
        for (int i5 = 0; i5 < size3; i5++) {
            arrayList2.add(Keyline.b(keylineListB.get(i5), 0.0f, 0.0f, keylineList.get(i5).f(), false, false, false, 0.0f, 123, null));
        }
        return new KeylineList(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(KeylineList keylineList, float f3, float f4, float f5) {
        if (keylineList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineList);
        if (keylineList.A(f3)) {
            if (f5 == 0.0f) {
                return arrayList;
            }
            arrayList.add(i(keylineList, f3, f4, -f5, keylineList.p(), keylineList.q()));
            return arrayList;
        }
        int iQ = keylineList.q();
        int iT = keylineList.t();
        int i3 = iT - iQ;
        if (i3 <= 0 && keylineList.p().c() > 0.0f) {
            arrayList.add(r(keylineList, 0, 0, f3, f4));
            return arrayList;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            KeylineList keylineList2 = (KeylineList) CollectionsKt.last((List) arrayList);
            int i5 = iT - i4;
            arrayList.add(r(keylineList2, keylineList.t(), i5 < CollectionsKt.getLastIndex(keylineList) ? keylineList2.B(keylineList.get(i5 + 1).e()) + 1 : 0, f3, f4));
        }
        if (f5 == 0.0f) {
            return arrayList;
        }
        arrayList.set(CollectionsKt.getLastIndex(arrayList), i((KeylineList) CollectionsKt.last((List) arrayList), f3, f4, -f5, ((KeylineList) CollectionsKt.last((List) arrayList)).p(), ((KeylineList) CollectionsKt.last((List) arrayList)).q()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(List list, float f3) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) CollectionsKt.last((List) CollectionsKt.first(list))).f() - ((Keyline) CollectionsKt.last((List) CollectionsKt.last(list))).f(), f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShiftPointRange l(int i3, FloatList floatList, float f3) {
        float fA = floatList.a(0);
        Iterator<Integer> it = RangesKt.B(1, i3).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            float fA2 = floatList.a(iNextInt);
            if (f3 <= fA2) {
                return new ShiftPointRange(iNextInt - 1, iNextInt, p(0.0f, 1.0f, fA, fA2, f3));
            }
            fA = fA2;
        }
        return new ShiftPointRange(0, 0, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(KeylineList keylineList, float f3, float f4, float f5) {
        if (keylineList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineList);
        if (keylineList.y()) {
            if (f5 == 0.0f) {
                return arrayList;
            }
            arrayList.add(i(keylineList, f3, f4, f5, keylineList.f(), keylineList.g()));
            return arrayList;
        }
        int iL = keylineList.l();
        int iG = keylineList.g() - iL;
        if (iG <= 0 && keylineList.f().c() > 0.0f) {
            arrayList.add(r(keylineList, 0, 0, f3, f4));
            return arrayList;
        }
        for (int i3 = 0; i3 < iG; i3++) {
            KeylineList keylineList2 = (KeylineList) CollectionsKt.last((List) arrayList);
            int i4 = iL + i3;
            int lastIndex = CollectionsKt.getLastIndex(keylineList);
            if (i4 > 0) {
                lastIndex = keylineList2.d(keylineList.get(i4 - 1).e()) - 1;
            }
            arrayList.add(r(keylineList2, keylineList.l(), lastIndex, f3, f4));
        }
        if (f5 == 0.0f) {
            return arrayList;
        }
        arrayList.set(CollectionsKt.getLastIndex(arrayList), i((KeylineList) CollectionsKt.last((List) arrayList), f3, f4, f5, ((KeylineList) CollectionsKt.last((List) arrayList)).f(), ((KeylineList) CollectionsKt.last((List) arrayList)).g()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float n(List list, float f3) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) CollectionsKt.first((List) CollectionsKt.last(list))).f() - ((Keyline) CollectionsKt.first((List) CollectionsKt.first(list))).f(), f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FloatList o(float f3, List list, boolean z2) {
        MutableFloatList mutableFloatListA = FloatListKt.a(0.0f);
        if (f3 != 0.0f && !list.isEmpty()) {
            IntRange intRangeB = RangesKt.B(1, list.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
            Iterator<Integer> it = intRangeB.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                int i3 = iNextInt - 1;
                KeylineList keylineList = (KeylineList) list.get(i3);
                KeylineList keylineList2 = (KeylineList) list.get(iNextInt);
                arrayList.add(Boolean.valueOf(mutableFloatListA.d(iNextInt == CollectionsKt.getLastIndex(list) ? 1.0f : mutableFloatListA.a(i3) + ((z2 ? ((Keyline) CollectionsKt.first((List) keylineList2)).f() - ((Keyline) CollectionsKt.first((List) keylineList)).f() : ((Keyline) CollectionsKt.last((List) keylineList)).f() - ((Keyline) CollectionsKt.last((List) keylineList2)).f()) / f3))));
            }
        }
        return mutableFloatListA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(float f3, float f4, float f5, float f6, float f7) {
        return f7 <= f5 ? f3 : f7 >= f6 ? f4 : MathHelpersKt.b(f3, f4, (f7 - f5) / (f6 - f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q(List list, int i3, int i4) {
        Keyline keyline = (Keyline) list.get(i3);
        list.remove(i3);
        list.add(i4, keyline);
        return list;
    }

    private static final KeylineList r(final KeylineList keylineList, final int i3, final int i4, float f3, float f4) {
        int i5 = i3 > i4 ? 1 : -1;
        return KeylineListKt.b(f3, f4, keylineList.v() + i5, keylineList.u().d() + (((keylineList.get(i3).e() - keylineList.get(i3).c()) + f4) * i5), new Function1<KeylineListScope, Unit>() { // from class: androidx.compose.material3.carousel.StrategyKt$moveKeylineAndCreateShiftedKeylineList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(KeylineListScope keylineListScope) {
                List listQ = StrategyKt.q(CollectionsKt.toMutableList((Collection) keylineList), i3, i4);
                int size = listQ.size();
                for (int i6 = 0; i6 < size; i6++) {
                    Keyline keyline = (Keyline) listQ.get(i6);
                    keylineListScope.b(keyline.e(), keyline.g());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((KeylineListScope) obj);
                return Unit.f139807a;
            }
        });
    }
}

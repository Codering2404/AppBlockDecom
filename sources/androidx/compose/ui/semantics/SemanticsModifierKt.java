package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SemanticsModifierKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f28502a = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(InspectorInfo inspectorInfo, SemanticsConfiguration semanticsConfiguration) {
        ValueElementSequence valueElementSequenceB = inspectorInfo.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(semanticsConfiguration, 10)), 16));
        for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry : semanticsConfiguration) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Pair pairA = TuplesKt.a(key.a(), entry.getValue());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        valueElementSequenceB.c(DiagnosticsEntry.PROPERTIES_KEY, linkedHashMap);
    }

    public static final Modifier c(Modifier modifier, Function1 function1) {
        return modifier.then(new ClearAndSetSemanticsElement(function1));
    }

    public static final int d() {
        return f28502a.addAndGet(1);
    }

    public static final Modifier e(Modifier modifier, boolean z2, Function1 function1) {
        return modifier.then(new AppendedSemanticsElement(z2, function1));
    }

    public static /* synthetic */ Modifier f(Modifier modifier, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return e(modifier, z2, function1);
    }
}

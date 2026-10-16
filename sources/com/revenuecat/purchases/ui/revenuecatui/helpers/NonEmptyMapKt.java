package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class NonEmptyMapKt {
    public static final /* synthetic */ NonEmptyMap nonEmptyMapOf(Pair entry, Pair... t2) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(t2, "t");
        return new NonEmptyMap(entry, MapsKt.toMap(t2));
    }

    public static final /* synthetic */ NonEmptyMap toNonEmptyMapOrNull(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        final LinkedHashMap linkedHashMap = new LinkedHashMap(map.size() - 1);
        final Function1 function1 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt.toNonEmptyMapOrNull.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map.Entry) obj);
                return Unit.f139807a;
            }

            public final void invoke(Map.Entry entry2) {
                Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
                linkedHashMap.put(entry2.getKey(), entry2.getValue());
            }
        };
        it.forEachRemaining(new Consumer() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                function1.invoke(obj);
            }
        });
        return new NonEmptyMap(new Pair(entry.getKey(), entry.getValue()), linkedHashMap);
    }

    public static final /* synthetic */ NonEmptyMap nonEmptyMapOf(Pair entry, Map map) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(map, "map");
        return new NonEmptyMap(entry, map);
    }
}

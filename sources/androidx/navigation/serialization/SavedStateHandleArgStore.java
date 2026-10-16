package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

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
final class SavedStateHandleArgStore extends ArgStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateHandle f49476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f49477b;

    @Override // androidx.navigation.serialization.ArgStore
    public boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f49476a.b(key);
    }

    @Override // androidx.navigation.serialization.ArgStore
    public Object b(String key) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(key, "key");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.a(key, this.f49476a.c(key)));
        if (mapMapOf.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapMapOf.size());
            for (Map.Entry entry : mapMapOf.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        Object obj = this.f49477b.get(key);
        if (obj != null) {
            return ((NavType) obj).a(bundleB, key);
        }
        throw new IllegalStateException(("Failed to find type for " + key + " when decoding " + this.f49476a).toString());
    }
}

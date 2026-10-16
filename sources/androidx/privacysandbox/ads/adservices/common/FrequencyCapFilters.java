package androidx.privacysandbox.ads.adservices.common;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@ExperimentalFeatures.Ext8OptIn
public final class FrequencyCapFilters {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f51200e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f51201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f51202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f51203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f51204d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface AdEventType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((KeyedFrequencyCap) it.next()).a());
        }
        return arrayList;
    }

    public final android.adservices.common.FrequencyCapFilters b() {
        android.adservices.common.FrequencyCapFilters frequencyCapFiltersBuild = m.a().setKeyedFrequencyCapsForWinEvents(a(this.f51201a)).setKeyedFrequencyCapsForImpressionEvents(a(this.f51202b)).setKeyedFrequencyCapsForViewEvents(a(this.f51203c)).setKeyedFrequencyCapsForClickEvents(a(this.f51204d)).build();
        Intrinsics.checkNotNullExpressionValue(frequencyCapFiltersBuild, "Builder()\n            .s…   )\n            .build()");
        return frequencyCapFiltersBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrequencyCapFilters)) {
            return false;
        }
        FrequencyCapFilters frequencyCapFilters = (FrequencyCapFilters) obj;
        return Intrinsics.areEqual(this.f51201a, frequencyCapFilters.f51201a) && Intrinsics.areEqual(this.f51202b, frequencyCapFilters.f51202b) && Intrinsics.areEqual(this.f51203c, frequencyCapFilters.f51203c) && Intrinsics.areEqual(this.f51204d, frequencyCapFilters.f51204d);
    }

    public int hashCode() {
        return (((((this.f51201a.hashCode() * 31) + this.f51202b.hashCode()) * 31) + this.f51203c.hashCode()) * 31) + this.f51204d.hashCode();
    }

    public String toString() {
        return "FrequencyCapFilters: keyedFrequencyCapsForWinEvents=" + this.f51201a + ", keyedFrequencyCapsForImpressionEvents=" + this.f51202b + ", keyedFrequencyCapsForViewEvents=" + this.f51203c + ", keyedFrequencyCapsForClickEvents=" + this.f51204d;
    }
}

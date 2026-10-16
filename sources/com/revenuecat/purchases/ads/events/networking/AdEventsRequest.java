package com.revenuecat.purchases.ads.events.networking;

import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendEvent$Ad$$serializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@Serializable
public final class AdEventsRequest {
    private final List<BackendEvent.Ad> events;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(BackendEvent$Ad$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AdEventsRequest> serializer() {
            return AdEventsRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ AdEventsRequest(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, AdEventsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.events = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdEventsRequest copy$default(AdEventsRequest adEventsRequest, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = adEventsRequest.events;
        }
        return adEventsRequest.copy(list);
    }

    public final List<BackendEvent.Ad> component1() {
        return this.events;
    }

    public final AdEventsRequest copy(List<BackendEvent.Ad> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        return new AdEventsRequest(events);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdEventsRequest) && Intrinsics.areEqual(this.events, ((AdEventsRequest) obj).events);
    }

    public final List<String> getCacheKey() {
        List<BackendEvent.Ad> list = this.events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((BackendEvent.Ad) it.next()).hashCode()));
        }
        return arrayList;
    }

    public final List<BackendEvent.Ad> getEvents() {
        return this.events;
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public String toString() {
        return "AdEventsRequest(events=" + this.events + ')';
    }

    public AdEventsRequest(List<BackendEvent.Ad> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.events = events;
    }
}

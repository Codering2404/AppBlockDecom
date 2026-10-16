package com.superwall.sdk.analytics.internal.trackable;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class UserInitiatedEvent implements TrackableUserInitiatedEvent {
    private Map<String, ? extends Object> audienceFilterParams;
    private final boolean canImplicitlyTriggerPaywall;
    private final boolean isFeatureGatable;
    private final String rawName;

    public /* synthetic */ UserInitiatedEvent(String str, boolean z2, Map map, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, map, z3);
    }

    @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
    public Map<String, Object> getAudienceFilterParams() {
        return this.audienceFilterParams;
    }

    @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
    public boolean getCanImplicitlyTriggerPaywall() {
        return this.canImplicitlyTriggerPaywall;
    }

    @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
    public String getRawName() {
        return this.rawName;
    }

    public final boolean isFeatureGatable() {
        return this.isFeatureGatable;
    }

    public void setAudienceFilterParams(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.audienceFilterParams = map;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Track extends UserInitiatedEvent {
        public /* synthetic */ Track(String str, boolean z2, boolean z3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z2, z3, (i3 & 8) != 0 ? MapsKt.emptyMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return MapsKt.hashMapOf(TuplesKt.a("is_feature_gatable", Boxing.a(isFeatureGatable())));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Track(String rawName, boolean z2, boolean z3, Map<String, ? extends Object> customParameters) {
            super(rawName, z2, customParameters, z3, null);
            Intrinsics.checkNotNullParameter(rawName, "rawName");
            Intrinsics.checkNotNullParameter(customParameters, "customParameters");
        }
    }

    private UserInitiatedEvent(String str, boolean z2, Map<String, ? extends Object> map, boolean z3) {
        this.rawName = str;
        this.canImplicitlyTriggerPaywall = z2;
        this.audienceFilterParams = map;
        this.isFeatureGatable = z3;
    }

    public /* synthetic */ UserInitiatedEvent(String str, boolean z2, Map map, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, (i3 & 4) != 0 ? MapsKt.emptyMap() : map, z3, null);
    }
}

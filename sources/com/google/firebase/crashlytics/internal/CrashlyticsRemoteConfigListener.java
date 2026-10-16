package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class CrashlyticsRemoteConfigListener implements RolloutsStateSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UserMetadata f88274a;

    public CrashlyticsRemoteConfigListener(UserMetadata userMetadata) {
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        this.f88274a = userMetadata;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber
    public void a(RolloutsState rolloutsState) {
        Intrinsics.checkNotNullParameter(rolloutsState, "rolloutsState");
        UserMetadata userMetadata = this.f88274a;
        Set setB = rolloutsState.b();
        Intrinsics.checkNotNullExpressionValue(setB, "getRolloutAssignments(...)");
        Set<RolloutAssignment> set = setB;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (RolloutAssignment rolloutAssignment : set) {
            arrayList.add(com.google.firebase.crashlytics.internal.metadata.RolloutAssignment.b(rolloutAssignment.d(), rolloutAssignment.b(), rolloutAssignment.c(), rolloutAssignment.f(), rolloutAssignment.e()));
        }
        userMetadata.r(arrayList);
        Logger.f().b("Updated Crashlytics Rollout State");
    }
}

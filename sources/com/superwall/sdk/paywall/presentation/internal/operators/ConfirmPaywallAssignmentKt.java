package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.config.Assignments;
import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConfirmPaywallAssignmentKt {
    public static final void confirmPaywallAssignment(Superwall superwall, ConfirmableAssignment confirmableAssignment, PresentationRequest request, boolean z2, DependencyContainer dependencyContainer) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        if (dependencyContainer == null) {
            dependencyContainer = superwall.getDependencyContainer$superwall_release();
        }
        confirmPaywallAssignment(confirmableAssignment, request, z2, dependencyContainer.getAssignments$superwall_release());
    }

    public static /* synthetic */ void confirmPaywallAssignment$default(Superwall superwall, ConfirmableAssignment confirmableAssignment, PresentationRequest presentationRequest, boolean z2, DependencyContainer dependencyContainer, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            dependencyContainer = null;
        }
        confirmPaywallAssignment(superwall, confirmableAssignment, presentationRequest, z2, dependencyContainer);
    }

    public static final void confirmPaywallAssignment(ConfirmableAssignment confirmableAssignment, PresentationRequest request, boolean z2, Assignments assignments) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        if (Intrinsics.areEqual(request.getFlags().getType(), PresentationRequestType.GetImplicitPresentationResult.INSTANCE) || z2 || confirmableAssignment == null) {
            return;
        }
        assignments.confirmAssignment(confirmableAssignment);
    }
}

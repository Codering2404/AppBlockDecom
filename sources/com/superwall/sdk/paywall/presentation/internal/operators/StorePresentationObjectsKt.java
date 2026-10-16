package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.LastPresentationItems;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class StorePresentationObjectsKt {
    public static final Object storePresentationObjects(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation) {
        if (presentationRequest == null) {
            return Unit.f139807a;
        }
        superwall.getPresentationItems$superwall_release().setLast(new LastPresentationItems(presentationRequest, mutableSharedFlow));
        return Unit.f139807a;
    }
}

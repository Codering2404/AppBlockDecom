package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.analytics.internal.TrackingResult;
import com.superwall.sdk.analytics.internal.trackable.UserInitiatedEvent;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
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
public final class TrackAndPresentContext {
    private final Function0<Boolean> isPaywallPresented;
    private final Function4<PresentationInfo, PaywallOverrides, Boolean, PresentationRequestType, PresentationRequest> makePresentationRequest;
    private final Function3<PresentationRequest, MutableSharedFlow<PaywallState>, Continuation<? super Unit>, Object> present;
    private final Function2<UserInitiatedEvent.Track, Continuation<? super Result<TrackingResult>>, Object> track;

    /* JADX WARN: Multi-variable type inference failed */
    public TrackAndPresentContext(Function2<? super UserInitiatedEvent.Track, ? super Continuation<? super Result<TrackingResult>>, ? extends Object> track, Function4<? super PresentationInfo, ? super PaywallOverrides, ? super Boolean, ? super PresentationRequestType, PresentationRequest> makePresentationRequest, Function0<Boolean> isPaywallPresented, Function3<? super PresentationRequest, ? super MutableSharedFlow<PaywallState>, ? super Continuation<? super Unit>, ? extends Object> present) {
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(makePresentationRequest, "makePresentationRequest");
        Intrinsics.checkNotNullParameter(isPaywallPresented, "isPaywallPresented");
        Intrinsics.checkNotNullParameter(present, "present");
        this.track = track;
        this.makePresentationRequest = makePresentationRequest;
        this.isPaywallPresented = isPaywallPresented;
        this.present = present;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrackAndPresentContext copy$default(TrackAndPresentContext trackAndPresentContext, Function2 function2, Function4 function4, Function0 function0, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function2 = trackAndPresentContext.track;
        }
        if ((i3 & 2) != 0) {
            function4 = trackAndPresentContext.makePresentationRequest;
        }
        if ((i3 & 4) != 0) {
            function0 = trackAndPresentContext.isPaywallPresented;
        }
        if ((i3 & 8) != 0) {
            function3 = trackAndPresentContext.present;
        }
        return trackAndPresentContext.copy(function2, function4, function0, function3);
    }

    public final Function2<UserInitiatedEvent.Track, Continuation<? super Result<TrackingResult>>, Object> component1() {
        return this.track;
    }

    public final Function4<PresentationInfo, PaywallOverrides, Boolean, PresentationRequestType, PresentationRequest> component2() {
        return this.makePresentationRequest;
    }

    public final Function0<Boolean> component3() {
        return this.isPaywallPresented;
    }

    public final Function3<PresentationRequest, MutableSharedFlow<PaywallState>, Continuation<? super Unit>, Object> component4() {
        return this.present;
    }

    public final TrackAndPresentContext copy(Function2<? super UserInitiatedEvent.Track, ? super Continuation<? super Result<TrackingResult>>, ? extends Object> track, Function4<? super PresentationInfo, ? super PaywallOverrides, ? super Boolean, ? super PresentationRequestType, PresentationRequest> makePresentationRequest, Function0<Boolean> isPaywallPresented, Function3<? super PresentationRequest, ? super MutableSharedFlow<PaywallState>, ? super Continuation<? super Unit>, ? extends Object> present) {
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(makePresentationRequest, "makePresentationRequest");
        Intrinsics.checkNotNullParameter(isPaywallPresented, "isPaywallPresented");
        Intrinsics.checkNotNullParameter(present, "present");
        return new TrackAndPresentContext(track, makePresentationRequest, isPaywallPresented, present);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackAndPresentContext)) {
            return false;
        }
        TrackAndPresentContext trackAndPresentContext = (TrackAndPresentContext) obj;
        return Intrinsics.areEqual(this.track, trackAndPresentContext.track) && Intrinsics.areEqual(this.makePresentationRequest, trackAndPresentContext.makePresentationRequest) && Intrinsics.areEqual(this.isPaywallPresented, trackAndPresentContext.isPaywallPresented) && Intrinsics.areEqual(this.present, trackAndPresentContext.present);
    }

    public final Function4<PresentationInfo, PaywallOverrides, Boolean, PresentationRequestType, PresentationRequest> getMakePresentationRequest() {
        return this.makePresentationRequest;
    }

    public final Function3<PresentationRequest, MutableSharedFlow<PaywallState>, Continuation<? super Unit>, Object> getPresent() {
        return this.present;
    }

    public final Function2<UserInitiatedEvent.Track, Continuation<? super Result<TrackingResult>>, Object> getTrack() {
        return this.track;
    }

    public int hashCode() {
        return (((((this.track.hashCode() * 31) + this.makePresentationRequest.hashCode()) * 31) + this.isPaywallPresented.hashCode()) * 31) + this.present.hashCode();
    }

    public final Function0<Boolean> isPaywallPresented() {
        return this.isPaywallPresented;
    }

    public String toString() {
        return "TrackAndPresentContext(track=" + this.track + ", makePresentationRequest=" + this.makePresentationRequest + ", isPaywallPresented=" + this.isPaywallPresented + ", present=" + this.present + ")";
    }
}

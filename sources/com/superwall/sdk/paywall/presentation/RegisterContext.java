package com.superwall.sdk.paywall.presentation;

import coil.target.Yb.oUcQRqOVfOC;
import com.superwall.sdk.misc.SerialTaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

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
public final class RegisterContext {
    private final CoroutineScope collectionScope;
    private final CoroutineDispatcher dispatcher;
    private final Function2<String, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> registerCustomCallback;
    private final SerialTaskManager serialTaskManager;
    private final TrackAndPresentContext trackAndPresentContext;
    private final Function1<String, Unit> unregisterCustomCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public RegisterContext(CoroutineDispatcher coroutineDispatcher, CoroutineScope collectionScope, SerialTaskManager serialTaskManager, TrackAndPresentContext trackAndPresentContext, Function2<? super String, ? super Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> function2, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, oUcQRqOVfOC.RuRCysEPaDnLF);
        Intrinsics.checkNotNullParameter(collectionScope, "collectionScope");
        Intrinsics.checkNotNullParameter(serialTaskManager, "serialTaskManager");
        Intrinsics.checkNotNullParameter(trackAndPresentContext, "trackAndPresentContext");
        this.dispatcher = coroutineDispatcher;
        this.collectionScope = collectionScope;
        this.serialTaskManager = serialTaskManager;
        this.trackAndPresentContext = trackAndPresentContext;
        this.registerCustomCallback = function2;
        this.unregisterCustomCallback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisterContext copy$default(RegisterContext registerContext, CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope, SerialTaskManager serialTaskManager, TrackAndPresentContext trackAndPresentContext, Function2 function2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineDispatcher = registerContext.dispatcher;
        }
        if ((i3 & 2) != 0) {
            coroutineScope = registerContext.collectionScope;
        }
        if ((i3 & 4) != 0) {
            serialTaskManager = registerContext.serialTaskManager;
        }
        if ((i3 & 8) != 0) {
            trackAndPresentContext = registerContext.trackAndPresentContext;
        }
        if ((i3 & 16) != 0) {
            function2 = registerContext.registerCustomCallback;
        }
        if ((i3 & 32) != 0) {
            function1 = registerContext.unregisterCustomCallback;
        }
        Function2 function22 = function2;
        Function1 function12 = function1;
        return registerContext.copy(coroutineDispatcher, coroutineScope, serialTaskManager, trackAndPresentContext, function22, function12);
    }

    public final CoroutineDispatcher component1() {
        return this.dispatcher;
    }

    public final CoroutineScope component2() {
        return this.collectionScope;
    }

    public final SerialTaskManager component3() {
        return this.serialTaskManager;
    }

    public final TrackAndPresentContext component4() {
        return this.trackAndPresentContext;
    }

    public final Function2<String, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> component5() {
        return this.registerCustomCallback;
    }

    public final Function1<String, Unit> component6() {
        return this.unregisterCustomCallback;
    }

    public final RegisterContext copy(CoroutineDispatcher dispatcher, CoroutineScope collectionScope, SerialTaskManager serialTaskManager, TrackAndPresentContext trackAndPresentContext, Function2<? super String, ? super Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> function2, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(collectionScope, "collectionScope");
        Intrinsics.checkNotNullParameter(serialTaskManager, "serialTaskManager");
        Intrinsics.checkNotNullParameter(trackAndPresentContext, "trackAndPresentContext");
        return new RegisterContext(dispatcher, collectionScope, serialTaskManager, trackAndPresentContext, function2, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterContext)) {
            return false;
        }
        RegisterContext registerContext = (RegisterContext) obj;
        return Intrinsics.areEqual(this.dispatcher, registerContext.dispatcher) && Intrinsics.areEqual(this.collectionScope, registerContext.collectionScope) && Intrinsics.areEqual(this.serialTaskManager, registerContext.serialTaskManager) && Intrinsics.areEqual(this.trackAndPresentContext, registerContext.trackAndPresentContext) && Intrinsics.areEqual(this.registerCustomCallback, registerContext.registerCustomCallback) && Intrinsics.areEqual(this.unregisterCustomCallback, registerContext.unregisterCustomCallback);
    }

    public final CoroutineScope getCollectionScope() {
        return this.collectionScope;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Function2<String, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> getRegisterCustomCallback() {
        return this.registerCustomCallback;
    }

    public final SerialTaskManager getSerialTaskManager() {
        return this.serialTaskManager;
    }

    public final TrackAndPresentContext getTrackAndPresentContext() {
        return this.trackAndPresentContext;
    }

    public final Function1<String, Unit> getUnregisterCustomCallback() {
        return this.unregisterCustomCallback;
    }

    public int hashCode() {
        int iHashCode = ((((((this.dispatcher.hashCode() * 31) + this.collectionScope.hashCode()) * 31) + this.serialTaskManager.hashCode()) * 31) + this.trackAndPresentContext.hashCode()) * 31;
        Function2<String, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object>, Unit> function2 = this.registerCustomCallback;
        int iHashCode2 = (iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31;
        Function1<String, Unit> function1 = this.unregisterCustomCallback;
        return iHashCode2 + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return "RegisterContext(dispatcher=" + this.dispatcher + ", collectionScope=" + this.collectionScope + ", serialTaskManager=" + this.serialTaskManager + ", trackAndPresentContext=" + this.trackAndPresentContext + ", registerCustomCallback=" + this.registerCustomCallback + ", unregisterCustomCallback=" + this.unregisterCustomCallback + ")";
    }

    public /* synthetic */ RegisterContext(CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope, SerialTaskManager serialTaskManager, TrackAndPresentContext trackAndPresentContext, Function2 function2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineDispatcher, coroutineScope, serialTaskManager, trackAndPresentContext, (i3 & 16) != 0 ? null : function2, (i3 & 32) != 0 ? null : function1);
    }
}

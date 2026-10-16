package com.google.android.libraries.places.widget.kotlin;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

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
/* JADX INFO: loaded from: classes6.dex */
final class AutocompleteSupportFragmentKt$placeSelectionEvents$1 extends SuspendLambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f79371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f79372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AutocompleteSupportFragment f79373c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutocompleteSupportFragmentKt$placeSelectionEvents$1(AutocompleteSupportFragment autocompleteSupportFragment, Continuation continuation) {
        super(2, continuation);
        this.f79373c = autocompleteSupportFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AutocompleteSupportFragmentKt$placeSelectionEvents$1 autocompleteSupportFragmentKt$placeSelectionEvents$1 = new AutocompleteSupportFragmentKt$placeSelectionEvents$1(this.f79373c, continuation);
        autocompleteSupportFragmentKt$placeSelectionEvents$1.f79372b = obj;
        return autocompleteSupportFragmentKt$placeSelectionEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((AutocompleteSupportFragmentKt$placeSelectionEvents$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f79371a;
        ResultKt.b(obj);
        if (i3 == 0) {
            final ProducerScope producerScope = (ProducerScope) this.f79372b;
            final AutocompleteSupportFragment autocompleteSupportFragment = this.f79373c;
            autocompleteSupportFragment.w(new PlaceSelectionListener() { // from class: com.google.android.libraries.places.widget.kotlin.AutocompleteSupportFragmentKt$placeSelectionEvents$1.1
                @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
                public void a(Status status) {
                    Intrinsics.checkNotNullParameter(status, "status");
                    producerScope.h(new PlaceSelectionError(status));
                }

                @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
                public void c(Place place) {
                    Intrinsics.checkNotNullParameter(place, "place");
                    producerScope.h(new PlaceSelectionSuccess(place));
                }
            });
            Function0 function0 = new Function0() { // from class: com.google.android.libraries.places.widget.kotlin.zza
                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Object invoke() {
                    autocompleteSupportFragment.w(null);
                    return Unit.f139807a;
                }
            };
            this.f79371a = 1;
            if (ProduceKt.a(producerScope, function0, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}

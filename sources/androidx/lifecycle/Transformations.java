package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class Transformations {
    public static final LiveData d(LiveData liveData, final Function1 transform) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final MediatorLiveData mediatorLiveData = liveData.i() ? new MediatorLiveData(transform.invoke(liveData.f())) : new MediatorLiveData();
        mediatorLiveData.q(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: androidx.lifecycle.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Transformations.e(mediatorLiveData, transform, obj);
            }
        }));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(MediatorLiveData mediatorLiveData, Function1 function1, Object obj) {
        mediatorLiveData.p(function1.invoke(obj));
        return Unit.f139807a;
    }

    public static final LiveData f(LiveData liveData, final Function1 transform) {
        LiveData liveData2;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final MediatorLiveData mediatorLiveData = (liveData.i() && (liveData2 = (LiveData) transform.invoke(liveData.f())) != null && liveData2.i()) ? new MediatorLiveData(liveData2.f()) : new MediatorLiveData();
        mediatorLiveData.q(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: androidx.lifecycle.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Transformations.g(transform, objectRef, mediatorLiveData, obj);
            }
        }));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1, Ref.ObjectRef objectRef, final MediatorLiveData mediatorLiveData, Object obj) {
        LiveData liveData = (LiveData) function1.invoke(obj);
        Object obj2 = objectRef.f140144a;
        if (obj2 != liveData) {
            if (obj2 != null) {
                Intrinsics.checkNotNull(obj2);
                mediatorLiveData.r((LiveData) obj2);
            }
            objectRef.f140144a = liveData;
            if (liveData != null) {
                Intrinsics.checkNotNull(liveData);
                mediatorLiveData.q(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: androidx.lifecycle.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return Transformations.h(mediatorLiveData, obj3);
                    }
                }));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.p(obj);
        return Unit.f139807a;
    }
}

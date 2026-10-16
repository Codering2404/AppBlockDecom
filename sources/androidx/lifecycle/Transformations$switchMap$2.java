package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Transformations$switchMap$2 implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LiveData f40115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function f40116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediatorLiveData f40117c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.p(obj);
        return Unit.f139807a;
    }

    @Override // androidx.lifecycle.Observer
    public void a(Object obj) {
        LiveData liveData = (LiveData) this.f40116b.apply(obj);
        LiveData liveData2 = this.f40115a;
        if (liveData2 == liveData) {
            return;
        }
        if (liveData2 != null) {
            MediatorLiveData mediatorLiveData = this.f40117c;
            Intrinsics.checkNotNull(liveData2);
            mediatorLiveData.r(liveData2);
        }
        this.f40115a = liveData;
        if (liveData != null) {
            MediatorLiveData mediatorLiveData2 = this.f40117c;
            Intrinsics.checkNotNull(liveData);
            final MediatorLiveData mediatorLiveData3 = this.f40117c;
            mediatorLiveData2.q(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: androidx.lifecycle.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Transformations$switchMap$2.c(mediatorLiveData3, obj2);
                }
            }));
        }
    }
}

package cz.mobilesoft.coreblock.storage.datastore;

import androidx.datastore.preferences.core.MutablePreferences;
import com.google.gson.Gson;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.CoreDataStore$addApiErrorLogs$2", f = "CoreDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class CoreDataStore$addApiErrorLogs$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoreDataStore f124133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f124134d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreDataStore$addApiErrorLogs$2(CoreDataStore coreDataStore, List list, Continuation continuation) {
        super(2, continuation);
        this.f124133c = coreDataStore;
        this.f124134d = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CoreDataStore$addApiErrorLogs$2 coreDataStore$addApiErrorLogs$2 = new CoreDataStore$addApiErrorLogs$2(this.f124133c, this.f124134d, continuation);
        coreDataStore$addApiErrorLogs$2.f124132b = obj;
        return coreDataStore$addApiErrorLogs$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
        return ((CoreDataStore$addApiErrorLogs$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutablePreferences mutablePreferences = (MutablePreferences) this.f124132b;
        IntrinsicsKt.f();
        if (this.f124131a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoreDataStore coreDataStore = this.f124133c;
        String str = (String) mutablePreferences.c(DataStoreKeysKt.k());
        if (str == null) {
            str = "";
        }
        List mutableList = CollectionsKt.toMutableList((Collection) coreDataStore.K6(str));
        mutableList.addAll(this.f124134d);
        while (mutableList.size() > 10) {
            mutableList.remove(0);
        }
        mutablePreferences.k(DataStoreKeysKt.k(), new Gson().s(mutableList));
        return Unit.f139807a;
    }
}

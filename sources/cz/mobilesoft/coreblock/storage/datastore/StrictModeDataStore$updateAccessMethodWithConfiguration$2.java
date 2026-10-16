package cz.mobilesoft.coreblock.storage.datastore;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore$updateAccessMethodWithConfiguration$2", f = "StrictModeDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeDataStore$updateAccessMethodWithConfiguration$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictModeAccessMethod f124661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Long f124662d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f124663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Set f124664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Long f124665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f124666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ AccessMethodConfiguration.Schedules.SchedulesBlockingMode f124667j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeDataStore$updateAccessMethodWithConfiguration$2(StrictModeAccessMethod strictModeAccessMethod, Long l3, String str, Set set, Long l4, String str2, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode, Continuation continuation) {
        super(2, continuation);
        this.f124661c = strictModeAccessMethod;
        this.f124662d = l3;
        this.f124663f = str;
        this.f124664g = set;
        this.f124665h = l4;
        this.f124666i = str2;
        this.f124667j = schedulesBlockingMode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeDataStore$updateAccessMethodWithConfiguration$2 strictModeDataStore$updateAccessMethodWithConfiguration$2 = new StrictModeDataStore$updateAccessMethodWithConfiguration$2(this.f124661c, this.f124662d, this.f124663f, this.f124664g, this.f124665h, this.f124666i, this.f124667j, continuation);
        strictModeDataStore$updateAccessMethodWithConfiguration$2.f124660b = obj;
        return strictModeDataStore$updateAccessMethodWithConfiguration$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
        return ((StrictModeDataStore$updateAccessMethodWithConfiguration$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutablePreferences mutablePreferences = (MutablePreferences) this.f124660b;
        IntrinsicsKt.f();
        if (this.f124659a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        mutablePreferences.k(DataStoreKeysKt.l4(), Boxing.d(this.f124661c.getMask()));
        if (this.f124662d != null) {
            mutablePreferences.k(DataStoreKeysKt.D4(), this.f124662d);
        }
        if (this.f124663f != null) {
            mutablePreferences.k(DataStoreKeysKt.z4(), this.f124663f);
        }
        if (this.f124664g != null) {
            Preferences.Key keyA4 = DataStoreKeysKt.A4();
            Set set = this.f124664g;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(String.valueOf(((Number) it.next()).longValue()));
            }
            mutablePreferences.k(keyA4, linkedHashSet);
        }
        if (this.f124665h != null) {
            mutablePreferences.k(DataStoreKeysKt.q4(), this.f124665h);
        }
        if (this.f124666i != null) {
            mutablePreferences.k(DataStoreKeysKt.o4(), this.f124666i);
        }
        if (this.f124667j != null) {
            mutablePreferences.k(DataStoreKeysKt.B4(), Boxing.e(this.f124667j.getId()));
        }
        return Unit.f139807a;
    }
}

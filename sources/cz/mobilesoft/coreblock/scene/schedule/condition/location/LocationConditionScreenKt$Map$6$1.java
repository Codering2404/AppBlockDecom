package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import androidx.compose.runtime.MutableState;
import com.google.maps.android.compose.CameraPositionState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$Map$6$1", f = "LocationConditionScreen.kt", l = {682, 694, 708}, m = "invokeSuspend", v = 1)
final class LocationConditionScreenKt$Map$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f115378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f115379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f115380d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f115381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f115382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f115383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f115384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f115385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f115386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f115387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ LocationConfigurationViewState f115388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ MutableState f115389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ CameraPositionState f115390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ boolean f115391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ boolean f115392q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionScreenKt$Map$6$1(LocationConfigurationViewState locationConfigurationViewState, MutableState mutableState, CameraPositionState cameraPositionState, boolean z2, boolean z3, Continuation continuation) {
        super(2, continuation);
        this.f115388m = locationConfigurationViewState;
        this.f115389n = mutableState;
        this.f115390o = cameraPositionState;
        this.f115391p = z2;
        this.f115392q = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationConditionScreenKt$Map$6$1(this.f115388m, this.f115389n, this.f115390o, this.f115391p, this.f115392q, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0179, code lost:
    
        if (r9.i(r3, 1000, r26) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$Map$6$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationConditionScreenKt$Map$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}

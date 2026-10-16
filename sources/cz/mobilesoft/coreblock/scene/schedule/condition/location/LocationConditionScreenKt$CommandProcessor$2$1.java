package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$CommandProcessor$2$1", f = "LocationConditionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class LocationConditionScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<LocationConditionScreenViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f115363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f115364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f115365d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f115366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f115367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f115368h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$CommandProcessor$2$1$1", f = "LocationConditionScreen.kt", l = {RCHTTPStatusCodes.NOT_MODIFIED}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f115370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LocationConditionScreenViewCommand f115371c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, LocationConditionScreenViewCommand locationConditionScreenViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f115370b = scaffoldState;
            this.f115371c = locationConditionScreenViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115370b, this.f115371c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f115369a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f115370b.b();
                String strA = ((LocationConditionScreenViewCommand.ShowSnackbar) this.f115371c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f115369a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionScreenKt$CommandProcessor$2$1(Function1 function1, Function0 function0, MutableState mutableState, ScaffoldState scaffoldState, CoroutineScope coroutineScope, Continuation continuation) {
        super(2, continuation);
        this.f115364c = function1;
        this.f115365d = function0;
        this.f115366f = mutableState;
        this.f115367g = scaffoldState;
        this.f115368h = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LocationConditionScreenKt$CommandProcessor$2$1 locationConditionScreenKt$CommandProcessor$2$1 = new LocationConditionScreenKt$CommandProcessor$2$1(this.f115364c, this.f115365d, this.f115366f, this.f115367g, this.f115368h, continuation);
        locationConditionScreenKt$CommandProcessor$2$1.f115363b = obj;
        return locationConditionScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LocationConditionScreenViewCommand locationConditionScreenViewCommand, Continuation continuation) {
        return ((LocationConditionScreenKt$CommandProcessor$2$1) create(locationConditionScreenViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LocationConditionScreenViewCommand locationConditionScreenViewCommand = (LocationConditionScreenViewCommand) this.f115363b;
        IntrinsicsKt.f();
        if (this.f115362a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (locationConditionScreenViewCommand instanceof LocationConditionScreenViewCommand.SaveChanges) {
            this.f115364c.invoke(((LocationConditionScreenViewCommand.SaveChanges) locationConditionScreenViewCommand).a());
        } else if (Intrinsics.areEqual(locationConditionScreenViewCommand, LocationConditionScreenViewCommand.CloseScreen.f115417a)) {
            this.f115365d.invoke();
        } else if (Intrinsics.areEqual(locationConditionScreenViewCommand, LocationConditionScreenViewCommand.ShowUnsavedChangesDialog.f115420a)) {
            this.f115366f.setValue(Boxing.a(true));
        } else {
            if (!(locationConditionScreenViewCommand instanceof LocationConditionScreenViewCommand.ShowSnackbar)) {
                throw new NoWhenBranchMatchedException();
            }
            SnackbarData snackbarDataB = this.f115367g.b().b();
            if (snackbarDataB != null) {
                snackbarDataB.dismiss();
            }
            BuildersKt__Builders_commonKt.d(this.f115368h, null, null, new AnonymousClass1(this.f115367g, locationConditionScreenViewCommand, null), 3, null);
        }
        return Unit.f139807a;
    }
}

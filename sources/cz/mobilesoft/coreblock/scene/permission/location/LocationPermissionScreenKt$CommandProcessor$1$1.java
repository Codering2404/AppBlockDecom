package cz.mobilesoft.coreblock.scene.permission.location;

import android.app.Activity;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreenKt$CommandProcessor$1$1", f = "LocationPermissionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class LocationPermissionScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<LocationPermissionCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f111850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f111851c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationPermissionScreenKt$CommandProcessor$1$1(Activity activity, Continuation continuation) {
        super(2, continuation);
        this.f111851c = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LocationPermissionScreenKt$CommandProcessor$1$1 locationPermissionScreenKt$CommandProcessor$1$1 = new LocationPermissionScreenKt$CommandProcessor$1$1(this.f111851c, continuation);
        locationPermissionScreenKt$CommandProcessor$1$1.f111850b = obj;
        return locationPermissionScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LocationPermissionCommand locationPermissionCommand, Continuation continuation) {
        return ((LocationPermissionScreenKt$CommandProcessor$1$1) create(locationPermissionCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LocationPermissionCommand locationPermissionCommand = (LocationPermissionCommand) this.f111850b;
        IntrinsicsKt.f();
        if (this.f111849a != 0) {
            throw new IllegalStateException(KLAQHFCRAUejH.KYBtKCQmvIocWe);
        }
        ResultKt.b(obj);
        if (!(locationPermissionCommand instanceof LocationPermissionCommand.Finish)) {
            throw new NoWhenBranchMatchedException();
        }
        this.f111851c.setResult(-1);
        this.f111851c.finish();
        return Unit.f139807a;
    }
}
